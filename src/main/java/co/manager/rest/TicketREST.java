package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.dto.TicketDTO;
import co.manager.dto.TicketNotesDTO;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.entity.TicketTINotes;
import co.manager.persistence.facade.TicketTIFacade;
import co.manager.persistence.facade.TicketTINotesFacade;
import co.manager.util.IGBUtils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("ticket")
public class TicketREST {
    private static final Logger CONSOLE = Logger.getLogger(TicketREST.class.getSimpleName());

    @EJB
    private TicketTIFacade ticketTIFacade;
    @EJB
    private TicketTINotesFacade ticketTINotesFacade;
    @Inject
    private ManagerApplicationBean managerAppBean;

    @GET
    @Path("list/{empId}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTickets(@PathParam("empId") String empId) {
        CONSOLE.log(Level.INFO, "Listando tickets TI actuales");

        boolean admUser = false;
        //TODO: validar si el usuario es administrador de tickets.
        if (Boolean.parseBoolean(getPropertyValue("adm.user.ticket", empId))) {
            admUser = true;
        }

        List<Object[]> objects = ticketTIFacade.listTickets(empId, admUser);
        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los tickets TI actuales");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando los tickets TI actuales.")).build();
        }

        List<TicketDTO> ticketTI = new ArrayList<>();
        for (Object[] obj : objects) {
            TicketDTO dto = new TicketDTO();
            //TODO: Encabezado del TicketDTO.
            dto.setIdTicket((Integer) obj[0]);
            dto.setTypeTicket((String) obj[1]);
            dto.setDateTicket((Date) obj[2]);
            dto.setDepartment((String) obj[3]);
            dto.setEmpAdd((String) obj[4]);
            dto.setEmpSet((String) obj[5]);
            dto.setUrlAttached((String) obj[6]);
            dto.setPriority((String) obj[7]);
            dto.setCompany((String) (obj[8] == "VARROC" ? "MOTOZONE" : "IGB"));
            dto.setAsunt((String) obj[9]);
            ticketTI.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando tickets TI actuales");
        return Response.ok(ticketTI).build();
    }


    @GET
    @Path("notes/{idTicket}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTicketNotes(@PathParam("idTicket") Integer idTicket) {
        CONSOLE.log(Level.INFO, "Listando notas del ticket TI #", idTicket.toString());
        List<Object[]> objects = ticketTINotesFacade.listNotesTicket(idTicket);

        List<TicketNotesDTO> ticketNotes = new ArrayList<>();
        for (Object[] obj : objects) {
            TicketNotesDTO dto = new TicketNotesDTO();
            dto.setIdTicket((Integer) obj[1]);
            dto.setDateNote((Date) obj[2]);
            dto.setEmpNote((String) obj[3]);
            dto.setNote((String) obj[4]);
            ticketNotes.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando notas del ticket TI #", idTicket.toString());
        return Response.ok(ticketNotes).build();
    }

    @POST
    @Path("add-note")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addTicketNote(TicketNotesDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creación de nota para el ticket TI #", dto.idTicket.toString());
        if (dto.getIdTicket() == null || dto.getIdTicket() <= 0) {
            CONSOLE.log(Level.SEVERE, "Campo idTicket es obligatorio para crear la nota");
            return Response.ok(new ResponseDTO(-1, "Campo idTicket es obligatorio para crear la nota.")).build();
        }
        if (dto.getEmpNote() == null || dto.getEmpNote().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Campo empleado es obligatorio para crear la nota");
            return Response.ok(new ResponseDTO(-1, "Campo empleado es obligatorio para crear la nota.")).build();
        }
        if (dto.getNote() == null || dto.getNote().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Campo nota es obligatorio para crear la nota");
            return Response.ok(new ResponseDTO(-1, "Campo nota es obligatorio para crear la nota.")).build();
        }

        TicketTINotes entity = new TicketTINotes();
        entity.setIdTicket(dto.idTicket.longValue());
        entity.setDate(new Date());
        entity.setEmpId(dto.empNote);
        entity.setNote(dto.note);

        try {
            ticketTINotesFacade.create(entity, "", false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la nota para el ticket TI #" + dto.idTicket.toString(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la nota para el ticket TI #" + dto.idTicket.toString())).build();
        }

        CONSOLE.log(Level.INFO, "Creacion de nota exitosa para el ticket TI #", dto.idTicket.toString());
        return Response.ok(new ResponseDTO(0, "Creacion de nota exitosa.")).build();
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(managerAppBean.obtenerValorPropiedad(propertyName), companyName);
    }
}
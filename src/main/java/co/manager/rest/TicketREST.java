package co.manager.rest;

import co.manager.dto.MailMessageDTO;
import co.manager.dto.ResponseDTO;
import co.manager.dto.TicketDTO;
import co.manager.dto.TicketNotesDTO;
import co.manager.ejb.EmailManager;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.entity.TicketTI;
import co.manager.persistence.entity.TicketTINotes;
import co.manager.persistence.facade.TicketTIFacade;
import co.manager.persistence.facade.TicketTINotesFacade;
import co.manager.persistence.facade.TicketTITypeFacade;
import co.manager.persistence.facade.UsersFacade;
import co.manager.util.IGBUtils;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.*;
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
    @EJB
    private TicketTITypeFacade ticketTITypeFacade;
    @EJB
    private UsersFacade usersFacade;
    @Inject
    private ManagerApplicationBean managerAppBean;
    @Inject
    private EmailManager emailManager;

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
            dto.setStatus((String) obj[10]);
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
        CONSOLE.log(Level.INFO, "Listando notas del ticket TI #{0}", idTicket.toString());
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
        CONSOLE.log(Level.INFO, "Retornando notas del ticket TI #{0}", idTicket.toString());
        return Response.ok(ticketNotes).build();
    }

    @GET
    @Path("type-tickets")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTypeTickets() {
        return Response.ok(ticketTITypeFacade.listTypeTickets()).build();
    }

    @POST
    @Path("assign-ticket")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response assignTicket(TicketDTO dto) {
        return Response.ok(ticketTIFacade.assignTicket(dto.idTicket, dto.empSet, dto.priority, dto.status)).build();
    }

    @POST
    @Path("add-note")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addTicketNote(TicketNotesDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creación de nota para el ticket TI #{0}", dto.idTicket.toString());
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
            CONSOLE.log(Level.INFO, "Creacion de nota exitosa para el ticket TI #{0}", dto.idTicket.toString());
            return Response.ok(new ResponseDTO(0, "Creacion de nota exitosa.")).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la nota para el ticket TI #" + dto.idTicket.toString(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la nota para el ticket TI #{0}" + dto.idTicket.toString())).build();
        }
    }

    @POST
    @Path("add-new-ticket")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addNewTicket(TicketDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creacion de un nuevo ticket {0}", dto.toString());

        TicketTI entity = new TicketTI();
        entity.setIdTicketType(dto.idTypeTicket);
        entity.setDate(new Date());
        entity.setDepartmentName(dto.department);
        entity.setEmpIdAdd(dto.empAdd);
        entity.setEmpIdSet(null);
        entity.setUrlAttached(dto.urlAttached);
        entity.setPriority(dto.priority);
        entity.setCompanyName(dto.company);
        entity.setAsunt(dto.asunt);
        entity.setStatus("ABIERTO");

        try {
            ticketTIFacade.create(entity, dto.company, false);

            //TODO: Notificar vía mail la creación del ticket
            Map<String, String> params = new HashMap<>();
            params.put("idTicket", entity.getId().toString());
            params.put("status", entity.getStatus());
            params.put("empIdAdd", entity.getEmpIdAdd());
            params.put("companyName", entity.getCompanyName());
            params.put("department", entity.getDepartmentName());
            params.put("priority", entity.getPriority());
            params.put("empIdSet", entity.getEmpIdSet());
            params.put("asunt", entity.getAsunt());
            params.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(entity.getDate()));

            Object[] user = usersFacade.getAttributeUser(dto.empAdd);
            if (user != null) {
                params.put("empName", (String) user[0] + " " + user[1]);
            }

            sendEmail("TicketNotification", "Ticket <ticketIgb@igbcolombia.com>", "Nuevo ticket", (String) user[2],
                    "soporte@igbcolombia.com", "", null, params);
            return Response.ok(new ResponseDTO(0, entity.getId())).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el ticket", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el ticket.")).build();
        }
    }

    private void sendEmail(String template, String from, String subject, String toAddress, String ccAddress, String bccAddress, List<String[]> adjuntos, Map<String, String> params) {
        MailMessageDTO dtoMail = new MailMessageDTO();
        dtoMail.setTemplateName(template);
        dtoMail.setParams(params);
        dtoMail.setAttachments(adjuntos);
        dtoMail.setFrom(from);
        dtoMail.setSubject(subject);
        dtoMail.addToAddress(toAddress);
        dtoMail.addBccAddress(bccAddress);
        dtoMail.addBccAddress(ccAddress);
        try {
            emailManager.sendMailClientCapture(dtoMail);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al enviar la notificacion", e);
        }
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(managerAppBean.obtenerValorPropiedad(propertyName), companyName);
    }
}
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
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
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTickets(@PathParam("empId") String empId) {
        CONSOLE.log(Level.INFO, "Listando tickets TI actuales");

        boolean admUser = false;
        //TODO: validar si el usuario es administrador de tickets.
        if (Boolean.parseBoolean(getPropertyValue("adm.user.ticket", empId))) {
            admUser = true;
        }

        List<Object[]> objects = ticketTIFacade.listTickets(empId, admUser);
        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los tickets TI actuales");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando los tickets TI actuales.")).build();
        } else if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No existe ningun ticket asociado al usuario {0}", empId);
            return Response.ok(new ResponseDTO(-1, "No existe ningun ticket asociado al usuario " + empId)).build();
        }

        List<TicketDTO> ticketTI = new ArrayList<>();
        for (Object[] obj : objects) {
            TicketDTO dto = new TicketDTO();
            //Encabezado del TicketDTO.
            dto.setIdTicket((Integer) obj[0]);
            dto.setTypeTicket((String) obj[1]);
            dto.setDateTicket((String) obj[2]);
            dto.setDepartment((String) obj[3]);
            dto.setEmpAdd((String) obj[4]);
            dto.setEmpSet((String) obj[5]);
            dto.setUrlAttached((String) obj[6]);
            dto.setPriority((String) obj[7]);
            dto.setCompany((String) (obj[8] == "VARROC" ? "MOTOZONE" : "IGB"));
            dto.setAsunt((String) obj[9]);
            dto.setStatus((String) obj[10]);
            dto.setType((String) obj[11]);
            dto.setDateEnd((String) obj[12]);
            ticketTI.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando tickets TI actuales");
        return Response.ok(ticketTI).build();
    }

    @GET
    @Path("notes/{idTicket}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTicketNotes(@PathParam("idTicket") Integer idTicket) {
        CONSOLE.log(Level.INFO, "Listando notas del ticket TI #{0}", idTicket.toString());
        List<Object[]> objects = ticketTINotesFacade.listNotesTicket(idTicket);

        List<TicketNotesDTO> ticketNotes = new ArrayList<>();
        for (Object[] obj : objects) {
            TicketNotesDTO dto = new TicketNotesDTO();
            dto.setIdTicket((Integer) obj[1]);
            dto.setDateNote((String) obj[2]);
            dto.setEmpNote((String) obj[3]);
            dto.setNote((String) obj[4]);
            ticketNotes.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando notas del ticket TI #{0}", idTicket.toString());
        return Response.ok(ticketNotes).build();
    }

    @GET
    @Path("type-tickets")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTypeTickets() {
        return Response.ok(ticketTITypeFacade.listTypeTickets()).build();
    }

    @POST
    @Path("assign-ticket")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response assignTicket(@QueryParam("username") String username, TicketDTO dto) {
        boolean resp = ticketTIFacade.assignTicket(dto.getIdTicket(), dto.getEmpSet().toLowerCase(), dto.getPriority(), "ASIGNADO");

        if (!resp) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error asigando el ticket #{0}", dto.getIdTicket());
            return Response.ok(resp).build();
        }

        //Agregar nota al ticket, de que fue asignado
        TicketTINotes entity = new TicketTINotes();
        entity.setIdTicket(dto.idTicket.longValue());
        entity.setEmpId(username);
        entity.setNote("Ticket asignado al empleado " + dto.getEmpSet().toLowerCase() + " con prioridad " + dto.getPriority());
        entity.setDate(new Date());

        try {
            ticketTINotesFacade.create(entity, "", false);
        } catch (Exception e) {
            CONSOLE.log(Level.WARNING, "No se agrego la nota al ticket #" + dto.getIdTicket(), e);
        }

        try {
            //TODO: Notificar vía mail la asignacion del ticket
            Map<String, String> params = new HashMap<>();
            params.put("idTicket", dto.getIdTicket().toString());
            params.put("status", "ASIGNADO");
            params.put("empIdAdd", dto.getEmpAdd().toLowerCase());
            params.put("companyName", dto.getCompany());
            params.put("department", dto.getDepartment());
            params.put("priority", dto.getPriority());
            params.put("empIdSet", dto.getEmpSet().toLowerCase());
            params.put("asunt", dto.getAsunt());
            params.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            params.put("note", "Ticket asignado al empleado " + dto.getEmpSet().toLowerCase() + " con prioridad " + dto.getPriority());

            Object[] user = usersFacade.getAttributeUser(dto.getEmpAdd().toLowerCase());
            if (user != null) {
                params.put("empName", (String) user[0] + " " + user[1]);
            }

            sendEmail("TicketNotification", "soporte@igbcolombia.com", "Asignado ticket", (String) user[2],
                    "soporte@igbcolombia.com", null, null, params);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando la notificacion de la asignacion del ticket #" + dto.getIdTicket(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de la asignacion del ticket " + dto.getIdTicket())).build();
        }
        return Response.ok(resp).build();
    }

    @POST
    @Path("add-note")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addTicketNote(TicketNotesDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creación de nota para el ticket TI #{0}", dto.getIdTicket().toString());
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
        entity.setIdTicket(dto.getIdTicket().longValue());
        entity.setEmpId(dto.getEmpNote().toLowerCase());
        entity.setNote(dto.getNote());
        entity.setDate(new Date());

        TicketDTO ticketDTO = ticketTIFacade.getTicket(dto.getIdTicket(), "", false);

        try {
            ticketTINotesFacade.create(entity, "", false);
            CONSOLE.log(Level.INFO, "Creacion de nota exitosa para el ticket TI #{0}", dto.getIdTicket().toString());
            try {
                //Notificar vía mail la nota del ticket
                Map<String, String> params = new HashMap<>();
                params.put("idTicket", entity.getIdTicket().toString());
                params.put("status", ticketDTO.getStatus());
                params.put("empIdAdd", ticketDTO.getEmpAdd());
                params.put("companyName", ticketDTO.getCompany());
                params.put("department", ticketDTO.getDepartment());
                params.put("priority", ticketDTO.getPriority());
                params.put("empIdSet", ticketDTO.getEmpSet());
                params.put("asunt", ticketDTO.getAsunt());
                params.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                params.put("note", entity.getNote());

                Object[] user = usersFacade.getAttributeUser(ticketDTO.getEmpAdd());
                if (user != null) {
                    params.put("empName", (String) user[0] + " " + user[1]);
                }

                sendEmail("TicketNotification", "soporte@igbcolombia.com", "Nuevo ticket", (String) user[2],
                        "soporte@igbcolombia.com", null, null, params);
                return Response.ok(new ResponseDTO(0, "Creacion de nota exitosa.")).build();
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando la notificacion de la creacion de la nota al ticket", e);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de la creacion de la nota al ticket.")).build();
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la nota para el ticket TI #" + dto.getIdTicket().toString(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la nota para el ticket TI #{0}" + dto.getIdTicket().toString())).build();
        }
    }

    @POST
    @Path("add-file-ticket")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addFile(File fichero,
                            @QueryParam("size") Integer size,
                            @QueryParam("name") String name,
                            @QueryParam("idTicket") Integer idTicket) {
        return Response.ok(uploadAttachment(idTicket, name, size, fichero)).build();
    }

    @POST
    @Path("add-new-ticket")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addNewTicket(TicketDTO dto,
                                 @QueryParam("newNote") String newNote) throws ParseException {
        CONSOLE.log(Level.INFO, "Iniciando creacion de un nuevo ticket {0}", dto.toString());

        TicketTI entity = new TicketTI();
        entity.setIdTicketType(dto.getIdTypeTicket());
        entity.setDate(new Date());
        entity.setDepartmentName(dto.getDepartment());
        entity.setEmpIdAdd(dto.getEmpAdd().toLowerCase());
        entity.setEmpIdSet(null);
        entity.setUrlAttached(dto.getUrlAttached());
        entity.setPriority(dto.getPriority());
        entity.setCompanyName(dto.getCompany());
        entity.setAsunt(dto.getAsunt());
        entity.setStatus("ABIERTO");
        entity.setType(dto.getType());
        entity.setDateEnd(dto.getType().equals("PROYECTO") ? new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDateEnd()) : null);

        try {
            ticketTIFacade.create(entity, dto.getCompany(), false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el ticket", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el ticket.")).build();
        }

        try {
            //Notificar vía mail la creación del ticket
            Map<String, String> params = new HashMap<>();
            params.put("idTicket", entity.getId().toString());
            params.put("status", entity.getStatus());
            params.put("empIdAdd", entity.getEmpIdAdd().toLowerCase());
            params.put("companyName", entity.getCompanyName());
            params.put("department", entity.getDepartmentName());
            params.put("priority", entity.getPriority());
            params.put("empIdSet", entity.getEmpIdSet() == null ? "SIN ASIGNAR" : entity.getEmpIdSet());
            params.put("asunt", entity.getAsunt());
            params.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(entity.getDate()));
            params.put("note", newNote == null ? "SIN NOTA" : newNote);

            Object[] user = usersFacade.getAttributeUser(dto.getEmpAdd().toLowerCase());
            if (user != null) {
                params.put("empName", (String) user[0] + " " + user[1]);
            }

            sendEmail("TicketNotification", "soporte@igbcolombia.com", "Nuevo ticket", (String) user[2],
                    "soporte@igbcolombia.com", null, null, params);
            return Response.ok(new ResponseDTO(0, entity.getId())).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando la notificacion de la creacion del ticket", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de la creacion del ticket.")).build();
        }
    }

    @POST
    @Path("update-status-ticket")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response updateStatusTicket(TicketDTO dto,
                                       @QueryParam("note") String note) {
        if (!ticketTIFacade.changeStatusTicket(dto.getIdTicket(), dto.getStatus())) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el estado a {0} al ticket #{1}", new Object[]{dto.getStatus(), dto.getIdTicket()});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error actualizando el estado a " + dto.getStatus() + " al ticket #" + dto.getIdTicket())).build();
        }

        try {
            TicketTINotes entity = new TicketTINotes();
            entity.setIdTicket(dto.idTicket.longValue());
            entity.setEmpId(dto.getEmpSet().toLowerCase());
            entity.setNote(note);
            entity.setDate(new Date());
            ticketTINotesFacade.create(entity, "", false);
        } catch (Exception e) {
            CONSOLE.log(Level.WARNING, "Ocurrio un novedad agregando la nota al ticket #{0}", dto.getIdTicket());
        }

        try {
            //Notificar vía mail la modificación de estado del ticket
            Map<String, String> params = new HashMap<>();
            params.put("idTicket", dto.getIdTicket().toString());
            params.put("status", dto.getStatus());
            params.put("empIdAdd", dto.getEmpAdd().toLowerCase());
            params.put("companyName", dto.getCompany());
            params.put("department", dto.getDepartment());
            params.put("priority", dto.getPriority());
            params.put("empIdSet", dto.getEmpSet().toLowerCase() == null ? "SIN ASIGNAR" : dto.getEmpSet().toLowerCase());
            params.put("asunt", dto.getAsunt());
            params.put("createDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            params.put("note", note);

            Object[] user = usersFacade.getAttributeUser(dto.getEmpAdd().toLowerCase());
            if (user != null) {
                params.put("empName", (String) user[0] + " " + user[1]);
            }

            sendEmail("TicketNotification", "soporte@igbcolombia.com", dto.getAsunt() + " ticket", (String) user[2],
                    "soporte@igbcolombia.com", null, null, params);
            return Response.ok(new ResponseDTO(0, dto.getIdTicket())).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando la notificacion de la actualizacion del ticket", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de la actualizacion del ticket.")).build();
        }
    }

    private void sendEmail(String template, String from, String subject, String toAddress, String ccAddress, String bccAddress, List<String[]> adjuntos, Map<String, String> params) {
        MailMessageDTO dtoMail = new MailMessageDTO();
        dtoMail.setTemplateName(template);
        dtoMail.setParams(params);
        dtoMail.setAttachments(adjuntos);
        dtoMail.setFrom(from);
        dtoMail.setSubject(subject);
        dtoMail.addToAddress(toAddress + ',' + ccAddress);
        dtoMail.addBccAddress(bccAddress);
        dtoMail.addBccAddress(ccAddress);
        try {
            emailManager.sendEmail(dtoMail);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al enviar la notificacion. ", e);
        }
    }

    private boolean uploadAttachment(Integer idTicket, String name, int size, File attached) {
        byte[] byt = new byte[size];
        try {
            FileInputStream fileInput = new FileInputStream(attached);
            fileInput.read(byt);
            FileOutputStream fileOut = new FileOutputStream(new File(managerAppBean.obtenerValorPropiedad("url.archivo") + File.separator + "uploads" + File.separator + "[" + idTicket.toString() + "]" + name));
            fileOut.write(byt);
            fileInput.close();
            fileOut.close();
            CONSOLE.log(Level.INFO, "Se guardo el adjunto para el ticket {0} correctamente.", idTicket.toString());
            return true;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error guardando el adjunto para el ticket " + idTicket.toString(), e.getMessage());
            return false;
        }
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(managerAppBean.obtenerValorPropiedad(propertyName), companyName);
    }
}
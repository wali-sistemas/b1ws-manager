package co.manager.rest;

import co.manager.dto.ClientFeriaDTO;
import co.manager.dto.MailMessageDTO;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.EmailManager;
import co.manager.persistence.facade.ClientFeriaSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("feria")
public class EventREST implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(EventREST.class.getSimpleName());
    private String emailTelemercader;

    @EJB
    private ClientFeriaSAPFacade clientFeriaSAPFacade;
    @Inject
    private EmailManager emailManager;

    public EventREST() {
    }

    @POST
    @Path("add-client")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addClienteFeria(ClientFeriaDTO dto) {
        CONSOLE.log(Level.INFO, "Captura de datos para cliente feria [" + dto.getCompanyName() + "]");
        //Validar si el documento se encuentra ya registrado.
        if ((clientFeriaSAPFacade.getClienteFeria(dto.getDocumento(), dto.getCompanyName(), false)) != null) {
            return Response.ok(new ResponseDTO(-1, "Documento ya registrado.")).build();
        }

        boolean res = clientFeriaSAPFacade.addClienteFeria(dto, false);
        if (res) {
            Map<String, String> params = new HashMap<>();
            params.put("cliente", dto.getNombreCompleto());
            params.put("documento", dto.getDocumento());
            params.put("telefono", dto.getTelefono());
            params.put("correo", (dto.getCorreo() == null || dto.getCorreo().isEmpty()) ? "Ninguno" : dto.getCorreo());
            params.put("mensaje", dto.getInteres());

            switch (dto.getCompanyName()) {
                case "VARROC":
                    if (dto.getRegional().equals("PAISAS") || dto.getRegional().equals("CACHACOS")) {
                        emailTelemercader = "telemercadeo@motozonecolombia.com";
                    } else {
                        emailTelemercader = "telemercadeo1@motozonecolombia.com";
                    }
                    break;
                case "IGB":
                    emailTelemercader = clientFeriaSAPFacade.getMailRegional(dto.getRegional().trim(), dto.getCompanyName(), false);
                    break;
                default:
                    emailTelemercader = null;
            }

            sendEmail(dto.getCompanyName().equals("IGB") ? "IgbContactoEvento" : "MtzContactoEvento", "Feria <f2r@feria2ruedas.com>", "Datos de cliente feria2ruedas", dto.getCorreo(),
                    emailTelemercader, "sistemas2@igbcolombia.com", null, params);
        }
        return Response.ok(new ResponseDTO(res ? 0 : -1, res ? "Datos capturados exitosamente." : "Ocurrio un error capturando los datos.")).build();
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
            emailManager.sendEmail(dtoMail);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al enviar la notificacion", e);
        }
    }
}
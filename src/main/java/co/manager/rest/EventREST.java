package co.manager.rest;

import co.manager.dto.ClientFeriaDTO;
import co.manager.dto.ResponseDTO;
import co.manager.persistence.facade.ClientFeriaSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("feria")
public class EventREST implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(EventREST.class.getSimpleName());

    @EJB
    private ClientFeriaSAPFacade clientFeriaSAPFacade;

    public EventREST() {
    }

    @POST
    @Path("add-client")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addClienteFeria(ClientFeriaDTO dto) {
        CONSOLE.log(Level.INFO, "Captura de datos de cliente feria");
        //Validar si el documento se encuentra ya registrado.
        if ((clientFeriaSAPFacade.getClienteFeria(dto.getDocumento())) != null) {
            return Response.ok(new ResponseDTO(-1, "Documento ya registrado.")).build();
        }

        boolean res = clientFeriaSAPFacade.addClienteFeria(dto);
        return Response.ok(new ResponseDTO(res ? 0 : -1, res ? "Datos capturados exitosamente." : "Ocurrio un error capturando los datos.")).build();
    }
}
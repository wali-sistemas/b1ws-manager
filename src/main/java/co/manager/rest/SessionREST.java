package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.ejb.SessionManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("session")
public class SessionREST {
    private static final Logger CONSOLE = Logger.getLogger(SessionREST.class.getSimpleName());
    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @GET
    @Path("open/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response openSession(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando sesion de DI Server para la compañia [" + companyName + "]");
        String response = sessionManager.login(companyName);//login(companyName);
        return Response.ok(new ResponseDTO(response == null ? -1 : 0, response)).build();
    }

    @PUT
    @Path("closed/{sessionid}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response closeSession(@PathParam("sessionid") String sessionId) {
        CONSOLE.log(Level.INFO, "Cerrando sesion [{0}] de DI Server", sessionId);
        String response = sessionManager.logout(sessionId);
        return Response.ok(new ResponseDTO(response == null ? -1 : 0, response)).build();
    }
}
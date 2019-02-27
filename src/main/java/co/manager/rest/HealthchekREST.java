package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.SessionPoolManager;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * @author dbotero
 */
@Path("health")
public class HealthchekREST {
    private static final Logger CONSOLE = Logger.getLogger(HealthchekREST.class.getSimpleName());

    @Inject
    private SessionPoolManager sessionPoolManager;

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response openSession() {
        return Response.ok(new ResponseDTO(0, sessionPoolManager.reportStatus())).build();
    }

    @GET
    @Path("reset")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response resetSession() {
        sessionPoolManager.resetSesion();
        return Response.ok(new ResponseDTO(0, sessionPoolManager.reportStatus())).build();
    }
}
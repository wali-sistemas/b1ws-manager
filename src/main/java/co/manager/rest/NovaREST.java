package co.manager.rest;

import co.manager.novaws.dto.ItemRestDTO;
import co.manager.novaws.ejb.NovaEJB;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("nova")
public class NovaREST {
    private static final Logger CONSOLE = Logger.getLogger(NovaREST.class.getSimpleName());
    @EJB
    private NovaEJB novaEJB;

    @GET
    @Path("items")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getItems() {
        ItemRestDTO res = novaEJB.getItems();

        return Response.ok(res).build();
    }
}

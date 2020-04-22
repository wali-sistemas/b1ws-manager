package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.persistence.facade.TicketTIFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListTickets() {
        return Response.ok(ticketTIFacade.getListTickets()).build();
    }
}
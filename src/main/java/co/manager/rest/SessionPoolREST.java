package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.SessionPoolManager;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dbotero

 * Esta clase maneja una lista de sesiones de B1WS que se renuevan automaticamente cuando se cumple un tiempo
 * predeterminado. La clase tiene ademas un numero máximo de sesiones, las cuales abre a medida que sea necesario
 * y cierra cuando se vencen o no se han usado en un periodo de tiempo predeterminado
 */
@Path("pool")
public class SessionPoolREST {
    private static final Logger CONSOLE = Logger.getLogger(SessionPoolREST.class.getSimpleName());
    @Inject
    private SessionPoolManager sessionPoolManager;

    @GET
    @Path("session/{companyName}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSession(@PathParam("companyName") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando sesion de DI Server para la compañia [" + companyName + "]");
        String sessionId = sessionPoolManager.getSession(companyName);
        if (sessionId != null) {
            return Response.ok(new ResponseDTO(0, sessionId)).build();
        }
        return Response.status(429).entity(new ResponseDTO(1, "No hay sesiones disponibles para asignar. Intente de nuevo en unos segundos")).build();
    }

    @PUT
    @Path("return/{sessionId}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response returnSession(@PathParam("sessionId") String sessionId) {
        CONSOLE.log(Level.INFO, "Devolviendo sesion [{0}] al pool", sessionId);
        sessionPoolManager.returnSession(sessionId);
        return Response.ok(new ResponseDTO(0, "La sesión fue devuelta con éxito")).build();
    }
}
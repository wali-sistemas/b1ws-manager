package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.ItemEJB;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.persistence.facade.PickingRecordFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
@Path("sonda")
public class SondaREST {
    private static final Logger CONSOLE = Logger.getLogger(SondaREST.class.getSimpleName());
    @EJB
    PickingRecordFacade pickingRecordFacade;
    @EJB
    ItemSAPFacade itemSAPFacade;
    @EJB
    ItemEJB itemEJB;

    @GET
    @Path("picking-delete-temporary/{companyname}/{warehousecode}/{testing}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response deleteTemporaryRecords(@PathParam("companyname") String companyName,
                                           @PathParam("warehousecode") String warehouseCode,
                                           @PathParam("testing") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Ejecutando proceso para eliminar registros de picking temporales. Empresa: {0}, Bodega: {1}",
                new Object[]{companyName, warehouseCode});
        List<Object[]> records = pickingRecordFacade.findTemporaryRecords(companyName, pruebas);
        CONSOLE.log(Level.INFO, "Se encontraron {0} registros temporales para {1}-{2}",
                new Object[]{records.size(), companyName, warehouseCode});
        Date now = new Date();
        List<Integer> expiredRecords = new ArrayList<>();
        for (Object[] row : records) {
            Integer recordId = (Integer) row[0];
            Date expires = (Date) row[1];
            if (hasExpired(expires, now)) {
                expiredRecords.add(recordId);
            }
        }
        if (!expiredRecords.isEmpty()) {
            CONSOLE.log(Level.INFO, "Eliminando {0} registros vencidos", expiredRecords);
            pickingRecordFacade.deleteExpiredRecords(expiredRecords, companyName, pruebas);
        }
        return Response.ok(new ResponseDTO(0, expiredRecords)).build();
    }

    @GET
    @Path("sync-picture/{companyname}/{testing}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response syncItem(@PathParam("companyname") String companyname,
                             @PathParam("testing") boolean testing) {
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion de campo picturName para [" + companyname + "]");
        List<String> items = itemSAPFacade.getListItemByPicture(companyname, testing);
        if (items == null || items.size() <= 0) {
            CONSOLE.log(Level.INFO, "No se encontraron datos para sincronizar en [" + companyname + "]");
            return Response.ok(new ResponseDTO(-1, "No se encontraron datos para sincronizar.")).build();
        }

        for (int i = 0; i < items.size(); i++) {
            String picturName = items.get(i) + ".jpg";
            try {
                itemSAPFacade.updateFieldPicture(items.get(i), picturName, companyname, testing);
                picturName = "";
            } catch (Exception e) {
            }
        }
        CONSOLE.log(Level.INFO, "Finalizando sincronizacion de campo picturName para [" + companyname + "]");
        return Response.ok(new ResponseDTO(0, "Finalizando sincronizacion para [" + companyname + "]")).build();
    }

    @GET
    @Path("sync-item-mrco/{companyname}/{testing}")
    @Produces({MediaType.APPLICATION_JSON})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response syncItemMotorepuesto(@PathParam("companyname") String companyname,
                                         @PathParam("testing") boolean testing) {
        List<Object[]> items = itemSAPFacade.listItemsPendingSyncMrco(companyname, testing);

        //Item Entity = itemEJB.findItem((String) items[0],);

        return Response.ok().build();
    }

    private boolean hasExpired(Date expires, Date now) {
        return now.getTime() > expires.getTime();
    }
}
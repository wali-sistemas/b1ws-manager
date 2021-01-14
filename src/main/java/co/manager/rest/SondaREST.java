package co.manager.rest;

import co.manager.b1ws.item.Item;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.ItemEJB;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.persistence.facade.PickingRecordFacade;
import co.manager.persistence.facade.SalesOrderSAPFacade;

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
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
    ItemEJB itemEJB;
    @EJB
    PickingRecordFacade pickingRecordFacade;
    @EJB
    ItemSAPFacade itemSAPFacade;
    @EJB
    SalesOrderSAPFacade salesOrderSAPFacade;

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
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion de items a motorepuesto.");
        List<String> items = itemSAPFacade.listItemsPendingSyncMrco(companyname, testing);

        if (items.equals(null)) {
            CONSOLE.log(Level.WARNING, "Ocurrio un error consultando los items.");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error consultando los items.")).build();
        }
        if (items.size() <= 0) {
            CONSOLE.log(Level.WARNING, "Sin datos para sincronizar en motorepuesto.");
            return Response.ok(new ResponseDTO(-1, "Sin datos para sincronizar en motorepuesto.")).build();
        }

        for (int i = 0; i < items.size(); i++) {
            Item entity = itemEJB.getMasterItem(companyname, items.get(i));
            if (!entity.getItemCode().equals(null)) {
                entity.setSeries(48l);
                entity.setApTaxCode("IVAD01");
                entity.setArTaxCode("IVAV01");
                entity.setValid("N");
                entity.setFrozen("Y");
                entity.setManufacturer(1l);
                entity.setProperties2("N");
                entity.setAtcEntry(null);

                if (companyname.equals("IGB")) {
                    entity.setItemsGroupCode(100l);
                    entity.setMainsupplier("P811011909");
                } else {
                    entity.setItemsGroupCode(102l);
                    entity.setMainsupplier("P900255414");
                }

                try {
                    GregorianCalendar date = new GregorianCalendar();
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
                    entity.setCreateDate(date2);
                    entity.setUpdateDate(date2);
                } catch (Exception e) {
                }

                String itemMotorepuesto = itemEJB.addItem(entity, "VELEZ");
                if (itemMotorepuesto != null) {
                    CONSOLE.log(Level.INFO, "Sincronización del item {0} en motorepuesto exitosa.", entity.getItemCode());
                } else {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error sincronizando el item " + entity.getItemCode() + " en motorepuesto.");
                }
            }
        }

        return Response.ok(new ResponseDTO(0, "Finalizando sincronizacion de items a motorepuesto.")).build();
    }

    @GET
    @Path("sync-tranport-order/{companyname}/{testing}")
    @Produces({MediaType.APPLICATION_JSON})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response syncTranspotOrder(@PathParam("companyname") String companyname,
                                      @PathParam("testing") boolean testing) {
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion de transportadora en las ordenes de {0}", companyname);
        List<Object[]> orders = salesOrderSAPFacade.listOrdersForValidateTransport(companyname, testing);

        if (orders.size() <= 0) {
            CONSOLE.log(Level.WARNING, "Sin datos para sincronizar transporte.");
            return Response.ok(new ResponseDTO(-1, "Sin datos para sincronizar transporte.")).build();
        }

        for (Object[] obj : orders) {
            salesOrderSAPFacade.updateTransport((Integer) obj[0], (String) obj[1], companyname, false);
        }
        return Response.ok(new ResponseDTO(0, "Finalizando sincronizacion de transportadora en las ordenes de " + companyname)).build();
    }

    private boolean hasExpired(Date expires, Date now) {
        return now.getTime() > expires.getTime();
    }
}
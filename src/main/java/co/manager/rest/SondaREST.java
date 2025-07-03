package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.BusinessPartnerEJB;
import co.manager.ejb.EmailManager;
import co.manager.ejb.ItemEJB;
import co.manager.ejb.PurchaseInvoicesEJB;
import co.manager.hanaws.dto.item.ItemsDTO;
import co.manager.hanaws.dto.item.ItemsRestDTO;
import co.manager.modulaws.dto.item.ItemModulaDTO;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.ItemModulaEJB;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.persistence.entity.ItemModula;
import co.manager.persistence.facade.*;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
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
    private ItemEJB itemEJB;
    @EJB
    private PickingRecordFacade pickingRecordFacade;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private ItemModulaEJB itemModulaEJB;
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;
    @EJB
    private ItemModulaFacade itemModulaFacade;
    @EJB
    private SalesQuotationSAPFacade salesQuotationSAPFacade;
    @EJB
    private PedBoxREST pedBoxREST;
    @EJB
    private OrderModulaEJB orderModulaEJB;
    @EJB
    private PurchaseOrderFacade purchaseOrderFacade;
    @EJB
    private InvoiceSAPFacade invoiceSAPFacade;
    @EJB
    private PurchaseInvoicesEJB purchaseInvoicesEJB;
    @Inject
    private EmailManager emailManager;

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
            ItemsRestDTO res = itemEJB.getMasterItem(companyname, items.get(i));
            ItemsDTO itemDTO = new ItemsDTO();
            if (!res.getItemCode().equals(null)) {
                itemDTO.setItemCode(res.getItemCode());
                itemDTO.setItemName(res.getItemName());
                itemDTO.setItemType("itItems");
                itemDTO.setForeignName(res.getForeignName());
                itemDTO.setuSubgrupo(res.getuSubgrupo());
                itemDTO.setuMarca(res.getuMarca());
                itemDTO.setuCategoria(res.getuCategoria());
                itemDTO.setuAplicacion(res.getuAplicacion());
                itemDTO.setuArticulo(res.getuArticulo());
                itemDTO.setuProcedencia(res.getuProcedencia());
                itemDTO.setuModelo(res.getuModelo());
                itemDTO.setuTalla(res.getuTalla());
                itemDTO.setuTipo(res.getuTipo());
                itemDTO.setuViscosidad(res.getuViscosidad());

                if (companyname.equals("IGB")) {
                    itemDTO.setItemsGroupCode(100l);
                    itemDTO.setMainsupplier("P811011909");
                } else {
                    itemDTO.setItemsGroupCode(102l);
                    itemDTO.setMainsupplier("P900255414");
                }

                itemDTO.setPicture(res.getPicture());
                itemDTO.setuTipo(res.getuTipo());
                itemDTO.setIndirectTax("tYES");
                itemDTO.setTaxCodeAP("IVAD01");
                itemDTO.setTaxCodeAR("IVAV01");
                itemDTO.setManufacturer(1l);
                itemDTO.setValidFor("tNO");
                itemDTO.setFrozenFor("tYES");
                itemDTO.setQryGroup2("tNO");

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    itemDTO.setCreateDate(date2);
                    itemDTO.setUpdateDate(date2);
                    itemDTO.setUfeccrea(date2);

                } catch (Exception e) {
                }

                String itemMotorepuesto = itemEJB.addItem(itemDTO, "VELEZ");
                if (itemMotorepuesto != null) {
                    CONSOLE.log(Level.INFO, "Sincronización del item {0} en motorepuesto exitosa.", res.getItemCode());
                } else {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error sincronizando el item " + res.getItemCode() + " en motorepuesto.");
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

    @GET
    @Path("sync-item-modula/{companyname}/{testing}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response syncItemsModula(@PathParam("companyname") String companyName,
                                    @PathParam("testing") boolean testing) {
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion automatica de creacion de articulos en wms-modula");
        ItemModulaDTO itemModulaDTO = new ItemModulaDTO();
        List<ItemModulaDTO.item> items = new ArrayList<>();

        List<Object[]> objects = itemSAPFacade.listItemsToSyncModula(companyName, testing);
        if (objects == null || objects.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron items para sincronizar en modula para ", companyName);
            return Response.ok(new ResponseDTO(-1, "No se encontraron items para sincronizar en modula para " + companyName)).build();
        }

        for (Object[] obj : objects) {
            ItemModulaDTO.item dto = new ItemModulaDTO.item();
            dto.setArtOperacione("I");//Operacion
            dto.setArtArticolo((String) obj[0]);//item
            dto.setArtDes((String) obj[1]);//Descrip
            dto.setArtStockMin((Integer) obj[2]);//StockMin
            dto.setArtStockMax((Integer) obj[3]);//StocMax
            dto.setArtActive((String) obj[4]);//Activo
            dto.setArtDIMX((Integer) obj[5]);//Ancho
            dto.setArtDIMY((Integer) obj[6]);//Largo
            dto.setArtDIMZ((Integer) obj[7]);//Alto
            dto.setArtPMU((Integer) obj[8]);//Peso
            dto.setArtAREEABI((Integer) obj[9]);//Area
            items.add(dto);
        }
        itemModulaDTO.setImpArticuli(items);

        Gson gson = new Gson();
        String json = gson.toJson(itemModulaDTO);
        CONSOLE.log(Level.INFO, json);

        String res = itemModulaEJB.addItem(itemModulaDTO);
        if (res != null) {
            for (ItemModulaDTO.item item : itemModulaDTO.getImpArticuli()) {
                try {
                    ItemModula entity = new ItemModula();
                    entity.setItemCode(item.getArtArticolo());
                    entity.setItemName(item.getArtDes());
                    entity.setStockMin(item.getArtStockMin());
                    entity.setStockMax(item.getArtStockMax());
                    entity.setActive(item.getArtActive());
                    entity.setAncho(item.getArtDIMX());
                    entity.setLargo(item.getArtDIMY());
                    entity.setAlto(item.getArtDIMZ());
                    entity.setPeso(item.getArtPMU());
                    entity.setArea(item.getArtAREEABI());
                    //TODO: crear registro local de creacion de items
                    itemModulaFacade.create(entity, companyName, testing);
                    //TODO: Actualizando el UDF sync-modula a estado="N"
                    itemSAPFacade.updateFieldSyncModula(entity.getItemCode(), "N", companyName, false);
                } catch (Exception e) {
                }
            }
        } else {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando los articulos en wms-modula");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando los articulos en wms-modula.")).build();
        }
        CONSOLE.log(Level.INFO, "Finalizando sincronizacion automatica de articulos creados en wms-modula");
        return Response.ok(res).build();
    }

    @GET
    @Path("sync-respFiscal/{companyname}")
    @Produces({MediaType.APPLICATION_JSON})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addRespoFisCustomer(@PathParam("companyname") String companyName) {
        List<Object[]> list = businessPartnerSAPFacade.listClientsWithOutResFis(companyName, false);
        if (list.size() == 0) {
            CONSOLE.log(Level.SEVERE, "Sin Datos Para sincronizar");
            return Response.ok(new ResponseDTO(-1, "Sin Datos Para sincronizar")).build();
        }

        return Response.ok(businessPartnerEJB.addRespFisMassiveSN(companyName, list)).build();
    }

    @GET
    @Path("sync-sales-quotation/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createSalesOrder(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando creacion automatica de pedido con base de una oferta de venta");
        List<Object[]> quotations = salesQuotationSAPFacade.listSalesQuotations(companyName, false);

        if (quotations.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron ofertas de venta completadas");
            return Response.ok(new ResponseDTO(-2, "No se encontraron ofertas de venta completadas.")).build();
        }

        List<String> orders = new ArrayList<>();
        for (Object[] obj : quotations) {
            Integer slpCode = (Integer) obj[5];
            BigDecimal discPrcnt = (BigDecimal) obj[6];
            Integer docEntry = (Integer) obj[7];
            BigDecimal docTotal = (BigDecimal) obj[9];

            SalesOrderDTO dto = new SalesOrderDTO();
            dto.setCardCode((String) obj[0]);
            dto.setComments((String) obj[1]);
            dto.setCompanyName(companyName);
            dto.setNumAtCard((new SimpleDateFormat("yyyyMMdd").format(new Date())) + dto.getCardCode() + new SimpleDateFormat("hmmss").format(new Date()));
            dto.setIdTransport((String) obj[2]);
            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
            dto.setShipToCode((String) obj[3]);
            dto.setPayToCode((String) obj[4]);
            dto.setSlpCode(slpCode.longValue());
            dto.setDiscountPercent(discPrcnt.doubleValue());
            dto.setDocTotal(docTotal.doubleValue());

            List<Object[]> details = salesQuotationSAPFacade.listDetailSalesQuotations(docEntry, companyName, false);
            if (details.isEmpty()) {
                CONSOLE.log(Level.SEVERE, "No se encontro items en la oferta de venta {0}", docEntry);
                return Response.ok(new ResponseDTO(-2, "No se encontro items en la oferta de venta " + docEntry)).build();
            }

            List<DetailSalesOrderDTO> items = new ArrayList<>();
            for (Object[] objDtll : details) {
                Integer lineNum = (Integer) objDtll[3];

                DetailSalesOrderDTO detail = new DetailSalesOrderDTO();
                detail.setItemCode((String) objDtll[0]);
                detail.setQuantity((Integer) objDtll[1]);
                detail.setWhsCode((String) objDtll[2]);
                detail.setBaseLine((long) lineNum);
                detail.setBaseEntry(docEntry.longValue());
                detail.setBaseType(23l);
                items.add(detail);
            }
            dto.setDetailSalesOrder(items);

            //Invocando el servicio de creacion de orden de venta.
            ResponseExtranetDTO res = (ResponseExtranetDTO) pedBoxREST.createOrderSale(dto).getEntity();
            if (res.getCode() == 0) {
                orders.add(res.getContent().toString());
                try {
                    salesQuotationSAPFacade.updateStatus(docEntry.longValue(), 'F', companyName, false);
                } catch (Exception e) {
                }
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el pedido");
                try {
                    salesQuotationSAPFacade.updateStatus(docEntry.longValue(), 'E', companyName, false);
                } catch (Exception e) {
                }
            }
        }
        CONSOLE.log(Level.INFO, "Finalizando creacion automatica de pedido con base de una oferta de venta");
        return Response.ok(orders).build();
    }

    @GET
    @Path("sync-order-modula/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createSalesOrderModula(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando sinc-automatica de orden de venta autorizada para separar en wms-modula.");

        List<Object[]> orders = salesOrderSAPFacade.listOrdersApprovedForModula(companyName, false);
        if (orders.isEmpty() || orders == null) {
            CONSOLE.log(Level.WARNING, "No se encontraron ordenes para sincronizar en wms-modula");
            return Response.ok(new ResponseDTO(-2, "No se encontraron ordenes para sincronizar en wms-modula.")).build();
        }

        HashMap<String, String> order = new HashMap<>();
        for (Object[] obj : orders) {
            order.put((String) obj[0], "id");
        }

        OrderModulaDTO orderModulaDTO = new OrderModulaDTO();
        for (String docNum : order.keySet()) {
            orderModulaDTO.setDocNum(docNum);
            orderModulaDTO.setType("P");//TODO: Se envia solicitud a wms modula de tipo depostivo estado=P

            List<OrderModulaDTO.DetailModulaDTO> items = new ArrayList<>();
            for (Object[] obj : orders) {
                if (orderModulaDTO.getDocNum().equals(obj[0])) {
                    //Encabezado
                    orderModulaDTO.setDocNum((String) obj[0]);
                    //Detalle
                    OrderModulaDTO.DetailModulaDTO detailModulaDTO = new OrderModulaDTO.DetailModulaDTO();
                    detailModulaDTO.setItemCode((String) obj[1]);
                    detailModulaDTO.setQuantity((Integer) obj[2]);
                    items.add(detailModulaDTO);
                }
            }
            orderModulaDTO.setDetail(items);

            Gson gson = new Gson();
            String json = gson.toJson(orderModulaDTO);
            CONSOLE.log(Level.INFO, json);

            String resMDL = orderModulaEJB.addOrdine(orderModulaDTO, "Orden de Venta");
            if (resMDL == null || resMDL.isEmpty()) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error depositando orden de venta en modula docNum [{0}]", docNum);
                try {
                    //actualizar estado de la orden=Error
                    salesOrderSAPFacade.updateStatus(docNum, 'E', companyName, false);
                } catch (Exception e) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el estado[E] de la orden de venta docNum [" + docNum + "]", e);
                }
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error depositando orden de venta " + docNum + " en modula.")).build();
            } else {
                try {
                    //actualizar estado de la orden=Modula
                    salesOrderSAPFacade.updateStatus(docNum, 'M', companyName, false);
                } catch (Exception e) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el estado[M] de la orden de venta docNum [" + docNum + "]", e);
                }
            }
        }
        return Response.ok(order).build();
    }

    @GET
    @Path("comex/send-document-bl/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response sendDocumentBL(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando notificacion automatica de documento BL para comex");

        List<Object[]> orders = purchaseOrderFacade.listOrdersWithDocumentBL(companyName, false);
        if (orders.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron ordenes de compra con documento BL");
            return Response.ok(new ResponseDTO(-2, "No se encontraron ordenes de compra con documento BL.")).build();
        }

        for (Object[] obj : orders) {
            try {
                //TODO: Notificar vía mail el documento BL
                Map<String, String> params = new HashMap<>();
                params.put("docNum", (String) obj[0]);
                params.put("docDate", new SimpleDateFormat("yyyy-MM-dd").format(obj[1]));
                params.put("docBL", (String) obj[2]);
                params.put("slpName", (String) obj[3]);
                params.put("comment", (String) obj[4]);
                params.put("line", (String) obj[5]);
                if (companyName.contains("VARROC")) {
                    params.put("footer", "email-mtz.png");
                    params.put("companyName", "MOTOZONE S.A.S");
                } else {
                    params.put("footer", "email-igb.png");
                    params.put("companyName", "IGB S.A.S");
                }

                sendEmail("NotificationDocumentBL", "soporte@igbcolombia.com", "Orden con Documento BL", (String) obj[6],
                        "grupocomex@igbcolombia.com", "", null, params);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando la notificacion de documento BL para la orden de compra #" + obj[0], e);
                purchaseOrderFacade.updateFieldDocumentBL((String) obj[0], 'E', companyName, false);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de documento BL para la orden de compra # " + obj[0])).build();
            }
            purchaseOrderFacade.updateFieldDocumentBL((String) obj[0], 'C', companyName, false);
        }
        return Response.ok(new ResponseDTO(0, "Notificacion documento BL envida con exito.")).build();
    }

    @GET
    @Path("comex/send-data-driver/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response sendDataDriver(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando notificacion automatica de datos del conductor");

        List<Object[]> data = purchaseOrderFacade.listOrderWithDataDriver(companyName, false);
        if (data.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos del conductor para notificacion automatica");
            return Response.ok(new ResponseDTO(-2, "No se encontraron datos del conductor para notificacion automatica.")).build();
        }

        for (Object[] obj : data) {
            try {
                //TODO: Notificar vía mail los datos del conductor
                Map<String, String> params = new HashMap<>();
                params.put("docNum", (String) obj[0]);
                params.put("docDate", new SimpleDateFormat("yyyy-MM-dd").format(obj[1]));
                params.put("driver", (String) obj[2]);
                params.put("idDriver", (String) obj[3]);
                params.put("placa", (String) obj[4]);
                params.put("container", (String) obj[5]);
                params.put("sealSecurity", (String) obj[6]);
                params.put("arriboCedi", new SimpleDateFormat("yyyy-MM-dd").format(obj[7]));
                params.put("slpName", (String) obj[8]);
                params.put("typeEmp", (String) obj[9]);
                params.put("photo", obj[8] + ".jpg");
                params.put("brands", (String) obj[11]);
                params.put("cardCode", (String) obj[12]);
                params.put("cardName", (String) obj[13]);
                if (companyName.contains("VARROC")) {
                    params.put("footer", "email-mtz.png");
                    params.put("companyName", "MOTOZONE S.A.S");
                } else {
                    params.put("footer", "email-igb.png");
                    params.put("companyName", "IGB S.A.S");
                }

                sendEmail("NotificationDataDriver", "soporte@igbcolombia.com", "Datos conductor Orden " + obj[0], (String) obj[10],
                        "conductores@igbcolombia.com", "", null, params);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando los datos automaticos del conductor para la orden de compra #" + obj[0], e);
                purchaseOrderFacade.updateFieldDataDriver((String) obj[0], 'E', companyName, false);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error enviando la notificacion de documento BL para la orden de compra # " + obj[0])).build();
            }
            purchaseOrderFacade.updateFieldDataDriver((String) obj[0], 'C', companyName, false);
        }
        return Response.ok(new ResponseDTO(0, "Notificacion datos de conductor envido con exito.")).build();
    }

    @GET
    @Path("sync-purchase-invoice/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response syncPurchaseInvoice(@PathParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion automatica de facturas de compras pendientes por crear en {0}", companyName);

        List<String> invoices = invoiceSAPFacade.listInvoicePurchase(companyName, false);
        for (String invoice : invoices) {
            CONSOLE.log(Level.INFO, "Iniciando creacion de factura de compra para la venta # {0} realizada en [{1}]", new Object[]{invoice, companyName});

            //TODO: validar que la factura de compra no exista en motorepuestos.com para no generar duplicidad
            if (invoiceSAPFacade.validateExistInvoicePurchaseInMRTO(invoice, "VELEZ", false) > 0) {
                CONSOLE.log(Level.WARNING, "No se puede crear la factura de compra porque ya existe en SAP");
                return Response.ok(new ResponseDTO(-2, "No se puede crear la factura de compra porque ya existe en SAP.")).build();
            }

            List<Object[]> details = invoiceSAPFacade.listDetailInvoice(invoice, companyName, false);
            if (details.isEmpty()) {
                CONSOLE.log(Level.WARNING, "No se encontraron datos de la FV# {0} para crear la factura de compra", invoice);
                return Response.ok(new ResponseDTO(-2, "No se encontraron datos de la FV [" + invoice + "] para crear la factura de compra.")).build();
            }

            ResponseDTO res = purchaseInvoicesEJB.createPurchaseInvoice(details, invoice, companyName);
            CONSOLE.log(Level.WARNING, "Factura de provedor #{0} creada con exito", res.getContent());
        }

        CONSOLE.log(Level.INFO, "Finalizando sincronizacion automatica de facturas de compras.");
        return Response.ok(new ResponseDTO(-1, "Finalizando sincronizacion automatica de facturas de compras.")).build();
    }

    private void sendEmail(String template, String from, String subject, String toAddress, String ccAddress, String bccAddress, String adjunto, Map<String, String> params) {
        MailMessageDTO dtoMail = new MailMessageDTO();
        dtoMail.setTemplateName(template);
        dtoMail.setParams(params);
        dtoMail.setUrlAttachment(adjunto);
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

    private boolean hasExpired(Date expires, Date now) {
        return now.getTime() > expires.getTime();
    }
}
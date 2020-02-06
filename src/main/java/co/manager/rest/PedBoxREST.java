package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.SalesOrderEJB;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.persistence.facade.SalesOrderSAPFacade;
import co.manager.persistence.facade.WarehouseSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("pedbox")
public class PedBoxREST {
    private static final Logger CONSOLE = Logger.getLogger(PedBoxREST.class.getSimpleName());

    @EJB
    private WarehouseSAPFacade warehouseSAPFacade;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;
    @EJB
    private SalesOrderEJB salesOrderEJB;

    @GET
    @Path("warehouses/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListWarehouses(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Listando bodegas para la empresa [{0}]", companyname);
        List<Object[]> objects = warehouseSAPFacade.getListWarehouse(companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las bodegas para la empresa [{0}]", companyname);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando las bodegas.")).build();
        }

        List<WarehouseDTO> warehouses = new ArrayList<>();

        for (Object[] obj : objects) {
            WarehouseDTO dto = new WarehouseDTO();
            dto.setWhsCode((String) obj[0]);
            dto.setWhsName((String) obj[1]);
            warehouses.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de bodegas para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, warehouses)).build();
    }

    @GET
    @Path("items/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListItems(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Listando items actual para la empresa [{0}]", companyname);
        List<Object[]> objects = itemSAPFacade.getListItems(companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando items actual para {0}", companyname);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando items actual para " + companyname)).build();
        }

        List<ItemDTO> stock = new ArrayList<>();
        for (Object[] obj : objects) {
            ItemDTO dto = new ItemDTO();
            dto.setItemCode((String) obj[0]);
            dto.setItemName((String) obj[1]);
            dto.setUnit(null);
            dto.setPresentation((String) obj[2]);
            dto.setPrice((BigDecimal) obj[3]);
            dto.setIva((Integer) obj[4]);
            dto.setDiscount(0);
            dto.setWhsCode((String) obj[5]);
            dto.setQuantity(null);
            stock.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando items actual para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, stock)).build();
    }

    @GET
    @Path("price-list/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getPriceList(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Iniciando retorno de lista de precios para {0}", companyname);
        List<Object[]> objects = itemSAPFacade.getPriceList(companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la lista de precios para {0}", companyname);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error retornando la lista de precios para " + companyname)).build();
        }

        List<PriceListDTO> priceList = new ArrayList<>();
        for (Object[] obj : objects) {
            PriceListDTO dto = new PriceListDTO();
            dto.setItemCode((String) obj[0]);
            dto.setCodPriceList((Integer) obj[1]);
            dto.setPrice((BigDecimal) obj[2]);
            priceList.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando lista de precio para {0}", companyname);
        return Response.ok(new ResponseDTO(0, priceList)).build();
    }

    @GET
    @Path("customers/{slpcode}/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustomers(@PathParam("slpcode") String slpCode,
                                 @PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Iniciando retorno de clientes para el asesor [{0}] de la compania {1}", new Object[]{slpCode, companyname});
        List<CustomerDTO> customerDTO = new ArrayList<>();
        List<Object[]> objects = businessPartnerSAPFacade.getListCustomersBySeller(slpCode, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando el listado de clientes para el vendedor [{0}] para {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error retornando el listado de clientes para el vendedor [" + slpCode + "] para " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "El vendedor [{0}] para {1} no tiene clientes asignados", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "El vendedor [" + slpCode + "] para " + companyname + " no tiene clientes asignados.")).build();
        }

        HashMap<String, String> customers = new HashMap<>();
        for (Object[] obj : objects) {
            customers.put((String) obj[0], "id");
        }

        for (String client : customers.keySet()) {
            List<CustomerDTO.CustomerAddressesDTO> customerAddresses = new ArrayList<>();
            CustomerDTO dto = new CustomerDTO();
            dto.setCardCode(client);

            for (Object[] obj : objects) {
                if (dto.getCardCode().equals(obj[0])) {
                    //TODO: Encabezado del CustomerDTO.
                    dto.setNit((String) obj[1]);
                    dto.setCardName((String) obj[2]);
                    dto.setAddressToDef((String) obj[3]);
                    dto.setLocation((String) obj[4]);
                    dto.setPhone((String) obj[5]);
                    dto.setCellular((String) obj[6]);
                    dto.setEmail((String) obj[7]);
                    dto.setWayToPay((String) obj[8]);
                    dto.setPlazo((Integer) obj[9]);
                    dto.setContact((String) obj[10]);
                    dto.setSeller((String) obj[11]);
                    dto.setLength((Integer) obj[12]);
                    dto.setLatitude((Integer) obj[13]);
                    dto.setPriceList((Integer) obj[14]);
                    dto.setNotes((String) obj[15]);
                    dto.setDiscountCommercial((BigDecimal) obj[16]);
                    dto.setCondition((String) obj[17]);
                    dto.setExcent((String) obj[18]);
                    dto.setCupo((BigDecimal) obj[19]);
                    //TODO: Detalle de direcciones al CustomerDTO
                    CustomerDTO.CustomerAddressesDTO dto2 = new CustomerDTO.CustomerAddressesDTO();
                    dto2.setLineNum((Integer) obj[20]);
                    dto2.setAddress((String) obj[21]);
                    dto2.setCity((String) obj[22]);
                    dto2.setCountry((String) obj[23]);
                    customerAddresses.add(dto2);
                }
            }
            dto.setAddresses(customerAddresses);
            customerDTO.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de clientes del vendedor [{0}] para {1}", new Object[]{slpCode, companyname});
        return Response.ok(new ResponseDTO(0, customerDTO)).build();
    }

    @GET
    @Path("stock-current/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockCurrent(@PathParam("companyname") String companyname,
                                    @QueryParam("itemcode") String itemCode,
                                    @QueryParam("whscode") String whsCode) {
        CONSOLE.log(Level.INFO, "Listando stock actual para la empresa [{0}]", companyname);
        List<StockCurrentDTO> stockCurrentDTO = new ArrayList<>();
        List<Object[]> objects = itemSAPFacade.getStockWarehouseCurrent(itemCode.trim(), whsCode.trim(), companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para {0}", companyname);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el stock actual para " + companyname)).build();
        }

        HashMap<String, String> items = new HashMap<>();
        for (Object[] obj : objects) {
            items.put((String) obj[0], "id");
        }

        for (String item : items.keySet()) {
            List<StockCurrentDTO.StockCurrentWarehouseDTO> stockCurrentWarehouse = new ArrayList<>();
            StockCurrentDTO dto1 = new StockCurrentDTO();
            dto1.setItemCode(item);

            for (Object[] obj : objects) {
                if (dto1.getItemCode().equals(obj[0])) {
                    StockCurrentDTO.StockCurrentWarehouseDTO dto2 = new StockCurrentDTO.StockCurrentWarehouseDTO();
                    dto2.setWhsCode((String) obj[1]);
                    dto2.setQuantity((Integer) obj[2]);
                    stockCurrentWarehouse.add(dto2);
                }
            }
            dto1.setStockWarehouses(stockCurrentWarehouse);
            stockCurrentDTO.add(dto1);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de stock actual para [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, stockCurrentDTO)).build();
    }

    @GET
    @Path("status-order/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStatusOrder(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Listando estados disponibles para las ordenes de la empresa [{0}]", companyname);
        List<String> status = salesOrderSAPFacade.getStatusOrder(companyname, false);
        return Response.ok(new ResponseDTO(status == null ? -1 : 0, status)).build();
    }

    @GET
    @Path("orders-stopped/{companyname}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrdersStopped(@PathParam("companyname") String companyname,
                                      @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Listando ordenes detenidas al vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        List<Object[]> objects = salesOrderSAPFacade.findOrdersStopped(slpCode, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar las ordenes detenidas al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar las ordenes detenidas al vendedor " + slpCode + " en " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontraron ordenes detenidas para el vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "No se encontraron ordenes detenidas paar el vendedor " + slpCode + " en " + companyname)).build();
        }

        List<SalesOrderStoppedDTO> ordersStopped = new ArrayList<>();
        for (Object[] obj : objects) {
            SalesOrderStoppedDTO dto = new SalesOrderStoppedDTO();
            dto.setDocNum((Integer) obj[0]);
            dto.setDocDate((Date) obj[1]);
            dto.setCardCode((String) obj[2]);
            dto.setCardName((String) obj[3]);
            dto.setStatus((String) obj[4]);
            dto.setDocTotal((BigDecimal) obj[5]);
            dto.setAuthorization('N');
            ordersStopped.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de ordenes detenidas al vendedor {0} en la empresa {1}", new Object[]{slpCode, companyname});
        return Response.ok(new ResponseDTO(0, ordersStopped)).build();
    }

    @POST
    @Path("create-order")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesOrderDTO dto) {
        if (dto.getCompanyName().equals(null) || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
        }
        if (dto.getCardCode().equals(null) || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo cardCode es obligatorio.")).build();
        }
        if (dto.getDetailSalesOrder().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo detailSalesOrder es obligatorio.")).build();
        }
        if (dto.getSlpCode().equals(null) || dto.getSlpCode() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo slpCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo slpCode es obligatorio.")).build();
        }
        if (dto.getNumAtCard().equals(null) || dto.getNumAtCard().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo numAtCard es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo numAtCard es obligatorio.")).build();
        }
        //Consultando id de la transportadora asignada al cliente
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));

        return Response.ok(salesOrderEJB.createSalesOrder(dto)).build();
    }
}
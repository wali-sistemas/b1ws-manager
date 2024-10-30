package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.*;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.persistence.entity.DetallePagoPasarelaSAP;
import co.manager.persistence.entity.OrderDetailPedbox;
import co.manager.persistence.entity.OrderPedbox;
import co.manager.persistence.entity.PagoPasarelaSAP;
import co.manager.persistence.facade.*;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
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
@Path("pedbox")
public class PedBoxREST {
    private static final Logger CONSOLE = Logger.getLogger(PedBoxREST.class.getSimpleName());
    private boolean orderCompleted = true;

    @Inject
    private ManagerApplicationBean managerApplicationBean;
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
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;
    @EJB
    private QuotationsEJB quotationsEJB;
    @EJB
    private IncomingPaymentEJB incomingPaymentEJB;
    @EJB
    private SalesPersonSAPFacade salesPersonSAPFacade;
    @EJB
    private InvoiceSAPFacade invoiceSAPFacade;
    @EJB
    private IncomingPaymentsSAPFacade incomingPaymentsSAPFacade;
    @EJB
    private CreditNotesSAPFacade creditNotesSAPFacade;
    @EJB
    private PagoPasarelaSAPFacade pagoPasarelaSAPFacade;
    @EJB
    private DetallePagoPasarelaSAPFacade detPagoPasarelaSAPFacade;
    @EJB
    private CitySAPFacade citySAPFacade;
    @EJB
    private OrderModulaEJB orderModulaEJB;
    @EJB
    private OrderPedboxFacade orderPedboxFacade;
    @EJB
    private OrderDetailPedboxFacade orderDetailPedboxFacade;
    @EJB
    private BasicFunctions basicFunctions;
    @EJB
    private OrderAPPFacade orderAPPFacade;

    @GET
    @Path("list-municipios/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getMunicipios(@PathParam("companyname") String companyname) {
        List<Object[]> objects = citySAPFacade.listMunicipios(companyname, false);
        List<CityDTO> municipios = new ArrayList<>();

        for (Object[] obj : objects) {
            CityDTO dto = new CityDTO();
            dto.setCode((String) obj[0]);
            dto.setName((String) obj[1]);
            municipios.add(dto);
        }
        return Response.ok(municipios).build();
    }

    @GET
    @Path("list-departamentos/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getDepartamentos(@PathParam("companyname") String companyname) {
        List<Object[]> objects = citySAPFacade.listDepartamentos(companyname, false);
        List<CityDTO> departamentos = new ArrayList<>();

        for (Object[] obj : objects) {
            CityDTO dto = new CityDTO();
            dto.setCode((String) obj[0]);
            dto.setName((String) obj[1]);
            departamentos.add(dto);
        }
        return Response.ok(departamentos).build();
    }

    @GET
    @Path("list-type-document/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getTypeDocument(@PathParam("companyname") String companyname) {
        List<Object[]> objects = businessPartnerSAPFacade.listTypeDocument(companyname, false);
        List<TypeDocDTO> typeDocDTO = new ArrayList<>();

        for (Object[] obj : objects) {
            TypeDocDTO dto = new TypeDocDTO();
            dto.setCode((String) obj[0]);
            dto.setDocument((String) obj[1]);
            dto.setType((String) obj[2]);
            typeDocDTO.add(dto);
        }
        return Response.ok(typeDocDTO).build();
    }

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
            dto.setType((Integer) obj[2]);
            warehouses.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de bodegas para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, warehouses)).build();
    }

    @GET
    @Path("items/extranet/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListItemsByFiltres(@PathParam("companyname") String companyname,
                                          @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Listando items actual para la empresa [{0}]", companyname);
        List<Object[]> objects = new ArrayList<>();

        if (slpCode == null) {
            objects = itemSAPFacade.getListItemsExtranet(companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
        } else if (slpCode.equals("0") || companyname.equals("VARROC")) {
            objects = itemSAPFacade.getListItemsExtranet(companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
        } else {
            objects = itemSAPFacade.getListItemsExtranetBySeller(slpCode, companyname, false);
        }

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando items actual para {0}", companyname);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando items actual para " + companyname)).build();
        }

        List<ItemExtranetDTO> stock = new ArrayList<>();
        for (Object[] obj : objects) {
            ItemExtranetDTO dto = new ItemExtranetDTO();
            dto.setItemCode((String) obj[0]);
            dto.setItemName((String) obj[1]);
            //Modificar hasta que compras termine el proyecto de unidad de empaque.
            dto.setPresentation((String) obj[2]);
            dto.setPrice((BigDecimal) obj[3]);
            dto.setIva((Integer) obj[4]);
            dto.setWhsCode((String) obj[5]);
            dto.setStock((Integer) obj[6]);
            dto.setDiscountItem(0);
            dto.setDiscountPorc(0);
            dto.setPictureUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/mtz/" + obj[7]);
            //filtros para extranet
            dto.setModeloMoto((String) obj[8]);
            dto.setTipoLlanta((String) obj[9]);
            dto.setAnchoLlanta((String) obj[10]);
            dto.setPerfilLlanta((String) obj[11]);
            dto.setRinLlanta((String) obj[12]);
            dto.setTalla((String) obj[13]);
            dto.setCategoria((String) obj[14]);
            dto.setGrupo((String) obj[15]);
            dto.setSubgrupo((String) obj[16]);
            dto.setMarca((String) obj[17]);
            dto.setViscosidad((String) obj[18]);
            dto.setBase((String) obj[19]);

            if (companyname.equals("VARROC")) {
                dto.setUrlFichaTecnica(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + companyname + "/fileItem/" + obj[0] + ".pdf");
            }
            stock.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando items actual para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, stock)).build();
    }

    @GET
    @Path("customers-portfolio/extranet/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getAllCustomersPortfolioByCustomer(@PathParam("companyname") String companyname,
                                                       @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Iniciando servicio para obtener la cartera de cliente {0} en la empresa [{1}]", new Object[]{cardCode, companyname});
        List<PortfolioCustomerDTO> customerPortfolio = new ArrayList<>();
        List<Object[]> objects = businessPartnerSAPFacade.listCustomerPortfolioByCustomer(cardCode, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la cartera del cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar la cartera del cliente " + cardCode + " en " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos asociados al cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "No se encontraron datos asociados al cliente " + cardCode + " en " + companyname)).build();
        }

        HashMap<String, String> customers = new HashMap<>();
        for (Object[] obj : objects) {
            customers.put((String) obj[0], "id");
        }

        for (String client : customers.keySet()) {
            List<PortfolioCustomerDTO.DetailPortfolioCustomerDTO> customerDetailPortfolio = new ArrayList<>();
            PortfolioCustomerDTO dto = new PortfolioCustomerDTO();
            dto.setCardCode(client);

            for (Object[] obj : objects) {
                if (dto.getCardCode().equals(obj[0])) {
                    //Encabezado del CustomerDTO.
                    dto.setCardName((String) obj[1]);
                    dto.setLicTradNum((String) obj[2]);
                    dto.setSlpName((String) obj[10]);
                    dto.setPayCondition((String) obj[11]);
                    dto.setCupo((BigDecimal) obj[12]);
                    dto.setPayDayAvg((Integer) obj[13]);
                    dto.setLastSaleDay((Date) obj[14]);
                    //Detalle de direcciones al CustomerDTO
                    PortfolioCustomerDTO.DetailPortfolioCustomerDTO dto2 = new PortfolioCustomerDTO.DetailPortfolioCustomerDTO();
                    dto2.setDocType((String) obj[3]);
                    dto2.setDocNum((Integer) obj[4]);
                    dto2.setDocDate((Date) obj[5]);
                    dto2.setDocDueDate((Date) obj[6]);
                    dto2.setBalance((BigDecimal) obj[7]);
                    dto2.setDocTotal((BigDecimal) obj[8]);
                    dto2.setDocDateCutoff(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    dto2.setExpiredDays((Integer) obj[9]);
                    dto2.setUrlFE((String) obj[15]);
                    dto2.setIva((BigDecimal) obj[16]);
                    dto2.setSubtotal((BigDecimal) obj[17]);
                    dto2.setDiscount((BigDecimal) obj[18]);
                    customerDetailPortfolio.add(dto2);
                }
            }
            dto.setDetailPortfolio(customerDetailPortfolio);
            customerPortfolio.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el listado de la cartera del cliente {0} en la empresa [{1}]", new Object[]{cardCode, companyname});
        return Response.ok(new ResponseDTO(0, customerPortfolio)).build();
    }

    @GET
    @Path("price-list/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
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
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustomers(@PathParam("slpcode") String slpCode,
                                 @PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Iniciando retorno de clientes para el asesor [{0}] de la compania {1}", new Object[]{slpCode, companyname});
        List<CustomerDTO> customerDTO = new ArrayList<>();
        List<Object[]> objects = businessPartnerSAPFacade.listCustomersBySalesPerson(slpCode, companyname, false);

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
                    //Encabezado del CustomerDTO.
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
                    dto.setLength((String) obj[12]);
                    dto.setLatitude((String) obj[13]);
                    dto.setPriceList((Integer) obj[14]);
                    dto.setNotes((String) obj[15]);
                    dto.setDiscountCommercial((BigDecimal) obj[16]);
                    dto.setCondition((String) obj[17]);
                    dto.setExcent((String) obj[18]);
                    dto.setCupo((BigDecimal) obj[19]);
                    //Detalle de direcciones al CustomerDTO
                    CustomerDTO.CustomerAddressesDTO dto2 = new CustomerDTO.CustomerAddressesDTO();
                    dto2.setLineNum((String) obj[20]);
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
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockCurrent(@PathParam("companyname") String companyname,
                                    @QueryParam("itemcode") String itemCode,
                                    @QueryParam("whscode") String whsCode) {
        CONSOLE.log(Level.INFO, "Listando stock actual para el item [{0}] en la empresa [{1}]", new Object[]{itemCode, companyname});
        List<StockCurrentDTO> stockCurrentDTO = new ArrayList<>();
        //seteando sucursal pedBox lo maneja como integer.
        String sucursal = whsCode.trim().length() <= 1 && !whsCode.equals("0") ? "0" + whsCode.trim() : whsCode.trim();

        List<Object[]> objects = itemSAPFacade.getStockWarehouseCurrent(itemCode.trim(), sucursal, companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para el item [{0}] en [{1}]", new Object[]{itemCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el stock actual para el item [" + itemCode + "] en " + companyname)).build();
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
        CONSOLE.log(Level.INFO, "Retornando listado de stock actual para el item [{0}] en [{1}]", new Object[]{itemCode, companyname});
        return Response.ok(new ResponseDTO(0, stockCurrentDTO)).build();
    }

    @GET
    @Path("status-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStatusOrder(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Listando estados disponibles para las ordenes de la empresa [{0}]", companyname);
        List<String> status = salesOrderSAPFacade.getStatusOrder(companyname, false);
        return Response.ok(new ResponseDTO(status == null ? -1 : 0, status)).build();
    }

    @GET
    @Path("orders-stopped/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
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
            return Response.ok(new ResponseDTO(-1, "No se encontraron ordenes detenidas para el vendedor " + slpCode + " en " + companyname)).build();
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
            dto.setWhsCode((String) obj[6]);
            dto.setComments((String) obj[7]);
            ordersStopped.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de ordenes detenidas al vendedor {0} en la empresa {1}", new Object[]{slpCode, companyname});
        return Response.ok(new ResponseDTO(0, ordersStopped)).build();
    }

    @GET
    @Path("detail-orders-stopped/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listDetailOrdersStopped(@PathParam("companyname") String companyname,
                                            @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Listando detalle de las ordenes detenidas al vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        List<DetailSalesOrderStoppedDTO> detailordersStopped = new ArrayList<>();
        List<Object[]> objects = salesOrderSAPFacade.findDetailOrdersStopped(slpCode, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el detalle de las ordenes detenidas al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el detalle de las ordenes detenidas al vendedor " + slpCode + " en " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontro el detalle de las ordenes detenidas para el vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "No se encontro el detalle de las ordenes detenidas para el vendedor " + slpCode + " en " + companyname)).build();
        }

        HashMap<Integer, String> ordersStopped = new HashMap<>();
        for (Object[] obj : objects) {
            ordersStopped.put((Integer) obj[0], "id");
        }

        for (Integer client : ordersStopped.keySet()) {
            List<DetailSalesOrderStoppedDTO.DetailItemDTO> detailItemDTO = new ArrayList<>();
            DetailSalesOrderStoppedDTO dto = new DetailSalesOrderStoppedDTO();
            dto.setDocNum(client);

            for (Object[] obj : objects) {
                if (dto.getDocNum().equals(obj[0])) {
                    //Encabezado del DetailSalesOrderStoppedDTO.
                    dto.setCardCode((String) obj[1]);
                    dto.setNit((String) obj[2]);
                    dto.setCardName((String) obj[3]);
                    dto.setDocDueDate((Date) obj[4]);
                    dto.setDocDate((Date) obj[5]);
                    dto.setDocTotal((BigDecimal) obj[6]);
                    dto.setSlpCode((String) obj[7]);
                    dto.setSlpName((String) obj[8]);
                    dto.setStatus((String) obj[9]);
                    dto.setMonth((String) obj[10]);
                    //Detalle de direcciones al DetailItemDTO
                    DetailSalesOrderStoppedDTO.DetailItemDTO dto2 = new DetailSalesOrderStoppedDTO.DetailItemDTO();
                    dto2.setItemCode((String) obj[11]);
                    dto2.setDscription((String) obj[12]);
                    dto2.setOrderQty((Integer) obj[13]);
                    dto2.setDelivrdQty((Integer) obj[14]);
                    dto2.setPrice((BigDecimal) obj[15]);
                    detailItemDTO.add(dto2);
                }
            }
            dto.setDetailItem(detailItemDTO);
            detailordersStopped.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el detalle de las ordenes detenidas al vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        return Response.ok(new ResponseDTO(0, detailordersStopped)).build();
    }

    @GET
    @Path("customer-portfolio/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getOnlyCustomerPortfolioBySalesPerson(@PathParam("companyname") String companyname,
                                                          @QueryParam("slpcode") String slpCode,
                                                          @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Iniciando servicio para obtener la cartera del cliente {0} asignado al vendedor {1} en [{2}]", new Object[]{cardCode, slpCode, companyname});
        CupoDTO dto = businessPartnerSAPFacade.getCustomerPortfolio(cardCode, slpCode, companyname, false);

        if (dto == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la cartera del cliente {0} asignado al vendedor {1} en {2}", new Object[]{cardCode, slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar la cartera del cliente " + cardCode + " asignado al vendedor " + slpCode + " en " + companyname)).build();
        }
        return Response.ok(new ResponseDTO(0, dto)).build();
    }

    @GET
    @Path("customers-portfolio/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getAllCustomersPortfolioBySalesPerson(@PathParam("companyname") String companyname,
                                                          @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Iniciando servicio para obtener la cartera de clientes para el vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        List<PortfolioCustomerDTO> customerPortfolio = new ArrayList<>();
        List<Object[]> objects = businessPartnerSAPFacade.listCustomerPortfolioBySalesPerson(slpCode, null, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la cartera de los clientes asignados al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar la cartera de los clientes asignados al vendedor " + slpCode + " en " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos asociados al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "No se encontraron datos asociados al vendedor " + slpCode + " en " + companyname)).build();
        }

        HashMap<String, String> customers = new HashMap<>();
        for (Object[] obj : objects) {
            customers.put((String) obj[0], "id");
        }

        for (String client : customers.keySet()) {
            List<PortfolioCustomerDTO.DetailPortfolioCustomerDTO> customerDetailPortfolio = new ArrayList<>();
            PortfolioCustomerDTO dto = new PortfolioCustomerDTO();
            dto.setCardCode(client);

            for (Object[] obj : objects) {
                if (dto.getCardCode().equals(obj[0])) {
                    //Encabezado del CustomerDTO.
                    dto.setCardName((String) obj[1]);
                    dto.setLicTradNum((String) obj[2]);
                    dto.setSlpName((String) obj[10]);
                    dto.setPayCondition((String) obj[11]);
                    dto.setCupo((BigDecimal) obj[12]);
                    dto.setPayDayAvg((Integer) obj[13]);
                    dto.setLastSaleDay((Date) obj[14]);
                    //Detalle de direcciones al CustomerDTO
                    PortfolioCustomerDTO.DetailPortfolioCustomerDTO dto2 = new PortfolioCustomerDTO.DetailPortfolioCustomerDTO();
                    dto2.setDocType((String) obj[3]);
                    dto2.setDocNum((Integer) obj[4]);
                    dto2.setDocDate((Date) obj[5]);
                    dto2.setDocDueDate((Date) obj[6]);
                    dto2.setBalance((BigDecimal) obj[7]);
                    dto2.setDocTotal((BigDecimal) obj[8]);
                    dto2.setDocDateCutoff(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
                    dto2.setExpiredDays((Integer) obj[9]);
                    dto2.setUrlFE((String) obj[15]);
                    customerDetailPortfolio.add(dto2);
                }
            }
            dto.setDetailPortfolio(customerDetailPortfolio);
            customerPortfolio.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el listado de la cartera de clientes asignados al vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        return Response.ok(new ResponseDTO(0, customerPortfolio)).build();
    }

    @GET
    @Path("invoices-history/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listPaymentHitoryByCustomer(@PathParam("companyname") String companyname,
                                                @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Listando historial de facturas para el cliente [{0}] de la empresa [{1}]", new Object[]{cardCode, companyname});
        //historial de facturas de los últimos 6 meses.
        List<Object[]> objects = invoiceSAPFacade.listInvoicesHistoryByCustomer(cardCode, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historial de facturas para el cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el historial de facturas para el cliente " + cardCode + " en " + companyname)).build();
        }

        List<InvoicesHistoryDTO> invoicesHistory = new ArrayList<>();
        for (Object[] obj : objects) {
            InvoicesHistoryDTO dto = new InvoicesHistoryDTO();
            dto.setDocType("Factura Venta");
            dto.setDocNum((Integer) obj[0]);
            dto.setDocDate((Date) obj[1]);
            dto.setSubTotal((BigDecimal) obj[2]);
            dto.setPorcDesc((Integer) obj[3]);
            dto.setDiscount((BigDecimal) obj[4]);
            dto.setIva((BigDecimal) obj[5]);
            dto.setDocTotal((BigDecimal) obj[6]);
            dto.setUrlFacture((String) obj[7]);

            invoicesHistory.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando historial de facturas para el cliente {0} en {1}", new Object[]{cardCode, companyname});
        return Response.ok(new ResponseDTO(0, invoicesHistory)).build();
    }

    @GET
    @Path("payments-history/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listInvoicesHitoryByCustomer(@PathParam("companyname") String companyname,
                                                 @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Listando historial de pagos para el cliente [{0}] de la empresa [{1}]", new Object[]{cardCode, companyname});
        //historial de pagos de los últimos 3 meses.
        List<Object[]> objects = incomingPaymentsSAPFacade.listPaymentsHistoryByCustomer(cardCode, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historial de pagos para el cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el historial de pagos para el cliente " + cardCode + " en " + companyname)).build();
        }

        List<PaymentsHistoryDTO> paymentsHistory = new ArrayList<>();
        for (Object[] obj : objects) {
            PaymentsHistoryDTO dto = new PaymentsHistoryDTO();
            dto.setDocType("Recibos Pago");
            dto.setDocNum((Integer) obj[0]);
            dto.setDocDate((Date) obj[1]);
            dto.setDocTotal((BigDecimal) obj[2]);

            paymentsHistory.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando historial de pagos para el cliente {0} en {1}", new Object[]{cardCode, companyname});
        return Response.ok(new ResponseDTO(0, paymentsHistory)).build();
    }

    @GET
    @Path("credit-notes-history/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listCreditNotesHitoryByCustomer(@PathParam("companyname") String companyname,
                                                    @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Listando historial de notas credito para el cliente [{0}] de la empresa [{1}]", new Object[]{cardCode, companyname});
        //historial de notas crédito de los últimos 3 meses.
        List<Object[]> objects = creditNotesSAPFacade.listCreditNotesHistoryByCustomer(cardCode, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historial de notas credito para el cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el historial de notas credito para el cliente " + cardCode + " en " + companyname)).build();
        }

        List<CreditNotesHistoryDTO> creditNotesHistory = new ArrayList<>();
        for (Object[] obj : objects) {
            CreditNotesHistoryDTO dto = new CreditNotesHistoryDTO();
            dto.setDocType("Notas Crédito");
            dto.setDocNum((Integer) obj[0]);
            dto.setDocDate((Date) obj[1]);
            dto.setDocTotal((BigDecimal) obj[2]);
            dto.setDescription((String) obj[3]);
            dto.setUrlFacture((String) obj[4]);

            creditNotesHistory.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando historial de notas credito para el cliente {0} en {1}", new Object[]{cardCode, companyname});
        return Response.ok(new ResponseDTO(0, creditNotesHistory)).build();
    }

    @GET
    @Path("orders-history/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrdersHistoryByCustomer(@PathParam("companyname") String companyname,
                                                @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Listando historial de ordenes para el cliente [{0}] de la empresa [{1}]", new Object[]{cardCode, companyname});
        //historial de ordenes de los últimos 3 meses.
        List<Object[]> objects = salesOrderSAPFacade.listOrdersHistoryByCustomer(cardCode, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historial de ordenes para el cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el historial de ordenes para el cliente " + cardCode + " en " + companyname)).build();
        }

        List<OrdersHistoryDTO> ordersHistory = new ArrayList<>();
        for (Object[] obj : objects) {
            OrdersHistoryDTO dto = new OrdersHistoryDTO();
            dto.setDocNum((Integer) obj[0]);
            dto.setDocDate((Date) obj[1]);
            dto.setDocTotal((BigDecimal) obj[2]);

            ordersHistory.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando historial de ordenes para el cliente {0} en {1}", new Object[]{cardCode, companyname});
        return Response.ok(new ResponseDTO(0, ordersHistory)).build();
    }

    @GET
    @Path("orders-detail-history/{companyname}")
    @Produces({MediaType.APPLICATION_JSON})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getHistoryByCustomer(@PathParam("companyname") String companyname,
                                         @QueryParam("cardcode") String cardCode) {
        List<OrdersPedboxHistoryDTO> ordersPedboxHistory = new ArrayList<>();

        List<Object[]> objects = salesOrderSAPFacade.listOrdersHistoryWithDetailByCustomer(cardCode, companyname, false);
        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historial de ordenes para el cliente {0} en {1}", new Object[]{cardCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el historial de ordenes para el cliente " + cardCode + " en " + companyname)).build();
        }

        HashMap<String, String> orders = new HashMap<>();
        for (Object[] obj : objects) {
            orders.put((String) obj[1], "id");
        }

        for (String client : orders.keySet()) {
            List<OrdersPedboxHistoryDTO.OrdersDetailsPedboxHistoryDTO> orderDetailHistory = new ArrayList<>();
            OrdersPedboxHistoryDTO dto = new OrdersPedboxHistoryDTO();
            dto.setDocNum(client);
            for (Object[] obj : objects) {
                if (dto.getDocNum().equals(obj[1])) {
                    //Encabezado
                    dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format(obj[0]));
                    dto.setDocNum((String) obj[1]);
                    dto.setDesc1((Integer) obj[4]);
                    dto.setTotal((BigDecimal) obj[12]);
                    //Detalle
                    OrdersPedboxHistoryDTO.OrdersDetailsPedboxHistoryDTO dto2 = new OrdersPedboxHistoryDTO.OrdersDetailsPedboxHistoryDTO();
                    dto2.setWhsCode((String) obj[2]);
                    dto2.setQty((Integer) obj[3]);
                    dto2.setDesc2((Integer) obj[5]);
                    dto2.setItemName((String) obj[6]);
                    dto2.setPrice((BigDecimal) obj[8]);
                    dto2.setItemCode((String) obj[9]);
                    dto2.setSeq((Integer) obj[10]);
                    dto2.setIva((Integer) obj[7]);
                    dto2.setSubTotal((BigDecimal) obj[11]);
                    orderDetailHistory.add(dto2);
                }
            }
            dto.setDetailHistory(orderDetailHistory);
            ordersPedboxHistory.add(dto);
        }
        return Response.ok(new ResponseDTO(0, ordersPedboxHistory)).build();
    }

    @GET
    @Path("orders-detail/extranet/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrderDetail(@PathParam("companyname") String companyname,
                                    @QueryParam("docNum") Integer docNum) {
        CONSOLE.log(Level.INFO, "Listando detalle de la orden [{0}] de la empresa [{1}]", new Object[]{docNum.toString(), companyname});
        List<Object[]> objects = salesOrderSAPFacade.listDetailOrder(docNum, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle de la orden {0} en {1}", new Object[]{docNum.toString(), companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el detalle de la orden " + docNum.toString() + " en " + companyname)).build();
        }

        List<DetailSalesOrderExtranetDTO> detailOrder = new ArrayList<>();
        for (Object[] obj : objects) {
            DetailSalesOrderExtranetDTO dto = new DetailSalesOrderExtranetDTO();
            dto.setLineNum((Integer) obj[0]);
            dto.setItemCode((String) obj[1]);
            dto.setItemName((String) obj[2]);
            dto.setQty((Integer) obj[3]);
            dto.setQtyPack((Integer) obj[4]);
            dto.setPriceUnit((BigDecimal) obj[5]);
            dto.setIva((Integer) obj[6]);
            dto.setDiscPrcnt((BigDecimal) obj[7]);

            detailOrder.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el detalle de la orden {0} en {1}", new Object[]{docNum.toString(), companyname});
        return Response.ok(new ResponseDTO(0, detailOrder)).build();
    }

    @GET
    @Path("budget-sales/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSalesBudgetBySeller(@PathParam("companyname") String companyname,
                                           @QueryParam("slpcode") String slpCode,
                                           @QueryParam("year") Integer year,
                                           @QueryParam("month") String month) {
        CONSOLE.log(Level.INFO, "Iniciando consulta de presupuesto de ventas para la empresa {0}. ano[{1}]-mes[{2}]-asesor[{3}]", new Object[]{companyname, year, month, slpCode});
        List<Object[]> objects = salesPersonSAPFacade.getSaleBudgetBySeller(slpCode, year, month.length() == 1 ? '0' + month : month, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los presupuestos para la empresa {0}. ano[{1}]-mes[{2}]-asesor[{3}]", new Object[]{companyname, year, month, slpCode});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando los presupuestos para " + companyname)).build();
        }

        List<SalesBudgetDTO> presupuestos = new ArrayList<>();
        for (Object[] obj : objects) {
            SalesBudgetDTO dto = new SalesBudgetDTO();
            dto.setCompanyName(companyname);
            dto.setSlpCode((String) obj[0]);
            dto.setYear((Integer) obj[1]);
            dto.setMonth((String) obj[2]);
            dto.setVentas((BigDecimal) obj[3]);
            dto.setPresupuesto((BigDecimal) obj[4]);
            dto.setPendiente((BigDecimal) obj[5]);

            presupuestos.add(dto);
        }
        return Response.ok(new ResponseDTO(0, presupuestos)).build();
    }

    @GET
    @Path("find-seller/{companyname}/{cardcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSellerByCustomer(@PathParam("companyname") String companyName,
                                        @PathParam("cardcode") String cardCode) {
        return Response.ok(businessPartnerSAPFacade.getSellerByCustomer(cardCode, companyName, false)).build();
    }

    @GET
    @Path("customer-certificate/purchase/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustomerPurchaseCertificate(@PathParam("companyname") String companyName,
                                                   @QueryParam("cardcode") String cardCode,
                                                   @QueryParam("year") String year,
                                                   @QueryParam("type") Integer typeCert) {
        CONSOLE.log(Level.INFO, "Iniciando servicio para generar certificado de compras para el cliente [{0}] del ano [{1}]", new Object[]{cardCode, year});

        Object[] obj = invoiceSAPFacade.getSumOfInvoicesByCustomer(cardCode, companyName, false);
        if (obj == null) {
            CONSOLE.log(Level.WARNING, "No se encontraron compras relacionadas para mostrarle al cliente {0}", cardCode);
            return Response.ok(new ResponseDTO(-2, "No se encontraron compras relacionadas para mostrarle al cliente " + cardCode)).build();
        }

        CertifSumInvoicesDTO dto = new CertifSumInvoicesDTO();
        dto.setYear(year);
        dto.setNit((String) obj[0]);
        dto.setCardName((String) obj[1]);
        dto.setSumComp((BigDecimal) obj[2]);
        dto.setSumIvaComp((BigDecimal) obj[3]);
        dto.setSumDiscount((BigDecimal) obj[4]);
        dto.setSumDev((BigDecimal) obj[5]);
        dto.setSumIvaDev((BigDecimal) obj[6]);
        dto.setSumTransp((BigDecimal) obj[7]);

        return Response.ok(dto).build();
    }

    @GET
    @Path("customer-data/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustomerData(@PathParam("companyname") String companyName,
                                    @QueryParam("cardcode") String cardCode) {
        Object[] obj = businessPartnerSAPFacade.getCustomerData(cardCode, companyName, false);
        if (obj == null) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos del cliente [{0}] en {1}", new Object[]{cardCode, companyName});
            return Response.ok(new ResponseDTO(-2, "No se encontraron datos del cliente " + cardCode + " en " + companyName)).build();
        }

        CustomerDataDTO dto = new CustomerDataDTO();
        dto.setCardCode((String) obj[0]);
        dto.setCardType((String) obj[1]);
        dto.setCardName((String) obj[2]);
        dto.setLicTradNum((String) obj[3]);
        dto.setGroupCode((Integer) obj[4]);
        dto.setPhone1((String) obj[5]);
        dto.setPhone2((String) obj[6]);
        dto.setEmail((String) obj[7]);
        dto.setUcodeResFis((String) obj[8]);
        dto.setTerritory((Integer) obj[9]);
        dto.setSlpCode((String) obj[10]);
        dto.setFreeText((String) obj[11]);
        dto.setIdContact((String) obj[12]);
        dto.setFirstNameContact((String) obj[13]);
        dto.setMiddleNameContact((String) obj[14]);
        dto.setLastNameContact((String) obj[15]);
        dto.setPositionContact((String) obj[16]);
        dto.setTel1Contact((String) obj[17]);
        dto.setBirthDateContact((Date) obj[18]);
        dto.setBillToDef((String) obj[19]);
        dto.setAddress((String) obj[20]);
        dto.setState1((String) obj[21]);
        dto.setBlock((String) obj[22]);
        dto.setUlatitud((String) obj[23]);
        dto.setUlongitud((String) obj[24]);
        dto.setUbpcoNombre((String) obj[25]);
        dto.setUbpco1Apellido((String) obj[26]);
        dto.setUbpco2Apellido((String) obj[27]);
        dto.setUbpcoTDC((Integer) obj[28]);
        dto.setUbpcoTP((String) obj[29]);
        dto.setUbpcoRTC((String) obj[30]);
        dto.setUbpcoCity((String) obj[31]);
        dto.setUbpcoAddress((String) obj[32]);
        dto.setUemailFE((String) obj[33]);
        dto.setUregional((String) obj[34]);
        dto.setGroupNum((Integer) obj[35]);
        dto.setDiscount((Integer) obj[36]);
        dto.setVatStatus((String) obj[37]);
        dto.setCreditLine((BigDecimal) obj[38]);
        dto.setCreateDate((Date) obj[39]);
        dto.setUtrasp((String) obj[40]);
        dto.setQryGroup4((String) obj[41]);
        dto.setQryGroup15((String) obj[42]);
        dto.setWtliable((String) obj[43]);
        dto.setRetAUT3((String) obj[44]);
        dto.setRetAUT4((String) obj[45]);
        dto.setUproFid((String) obj[46]);
        dto.setListNum((Integer) obj[47]);

        return Response.ok(new ResponseDTO(0, dto)).build();
    }

    @GET
    @Path("detail-tracking/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getDetailTrackingByInvoice(@PathParam("companyname") String companyName,
                                               @QueryParam("docnum") String docNum) {
        Object[] obj = salesOrderSAPFacade.getDetailTrackingByOrder(docNum, companyName, false);

        DetailTrackingInvoiceDTO dto = new DetailTrackingInvoiceDTO();
        dto.setOrder((String) obj[0]);
        dto.setDocDateOrder(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[1]));
        dto.setStatusOrder((String) obj[2]);
        dto.setDocDueDateOrder(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[3]));
        dto.setInvoice((String) obj[4]);
        dto.setDocDateInvoice(obj[5] != null ? new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[5]) : null);
        dto.setTransport((String) obj[6]);
        dto.setGuia((String) obj[7]);
        dto.setStatusInvoice((String) obj[8]);
        dto.setUrlTracking((String) obj[9]);

        return Response.ok(dto).build();
    }

    @POST
    @Path("create-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesOrderDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creacion de orden de venta para " + dto.getCompanyName());
        ResponseExtranetDTO res = new ResponseExtranetDTO();

        /**** 1.Validar si ya existe la orden en SAP por idPedBox campo NumAtCard****/
        if (dto.getNumAtCard() == null || dto.getNumAtCard().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo numAtCard es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo numAtCard es obligatorio.")).build();
        } else {
            Integer docNum = salesOrderSAPFacade.getDocNumOrderByNumAtCard(dto.getNumAtCard(), dto.getCompanyName(), false);
            if (docNum != 0) {
                CONSOLE.log(Level.INFO, "La orden ya existe en SAP con el id {0}", docNum);
                return Response.ok(new ResponseExtranetDTO(0, docNum, 0, "La orden ya existe en SAP", null)).build();
            }
        }
        //TODO: Campo DocTotal para la creación de pedidos de motorepuestos.com no lo estan llenando falta en la integración con el AWS
        if (dto.getCardCode().equals("C900998242") || dto.getCompanyName().contains("VELEZ")) {
            dto.setDocTotal(1.0);
        }
        /**** 2.Validar campos obligatorios para creación de orden de venta****/
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo cardCode es obligatorio.")).build();
        } else if (dto.getDetailSalesOrder().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo detailSalesOrder es obligatorio.")).build();
        } else if (dto.getSlpCode() == null || dto.getSlpCode() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo slpCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo slpCode es obligatorio.")).build();
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo status es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo status es obligatorio.")).build();
        } else if (dto.getConfirmed() == null || dto.getConfirmed().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo confirmed es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo confirmed es obligatorio.")).build();
        } else if (dto.getDocTotal() == null || dto.getDocTotal() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo docTotal es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseExtranetDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo docTotal es obligatorio.")).build();
        }
        /**** 3.Validar descuento comercial. Marcar con estado REVISAR y no Autorizar despacho****/
        if ((dto.getCompanyName().contains("VARROC") || dto.getCompanyName().contains("IGB")) && dto.getCardCode().equals("C900998242")) {
            dto.setStatus("APROBADO");
            dto.setConfirmed("Y");
        } else if (dto.getCompanyName().contains("VELEZ")) {
            dto.setStatus("APROBADO");
            dto.setConfirmed("Y");
        } else {
            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
        }
        /*if (dto.getCompanyName().contains("IGB") && dto.getStatus().equals("APROBADO")) {
            if (businessPartnerSAPFacade.checkFieldDiscountCommercial(dto.getCardCode(), dto.getCompanyName(), false)) {
                dto.setStatus("REVISAR");
                dto.setConfirmed("N");
            }
        } else if (dto.getCompanyName().contains("VARROC")) {
            //TODO: Por instrucción del area de operaciones de MTZ, todos las ordenes ingresan con estado REVISAR
            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
        }
        //TODO: Solo para motorepuestos.co y editores las ordenes pasan aprobadas
        if (dto.getCardCode().equals("C900998242")) {
            dto.setStatus("APROBADO");
            dto.setConfirmed("Y");
        }
        //TODO: Pedidos de extranet deben entrar con status=REVISAR
        if (dto.getNumAtCard().substring(0, 1).equals("E")) {
            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
        }*/
        /**** 4.Consultando el centro de costo por asesor de venta****/
        String ocrCode = salesPersonSAPFacade.getCentroCosto(dto.getSlpCode(), dto.getCompanyName(), false);
        dto.getDetailSalesOrder().get(0).setOcrCode(ocrCode);
        /**** 5.Consultando código de transportadora asignada al cliente****/
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
        /**** 6.Consultando por cliente el id de la dirección de factura****/
        String shipToCodeDefault = null;
        List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
        if (idAddress.size() > 0) {
            for (Object[] obj : idAddress) {
                shipToCodeDefault = (String) obj[0];
                dto.setPayToCode((String) obj[1]);
            }
        }

        if (dto.getShipToCode().equals("0")) {
            dto.setShipToCode(shipToCodeDefault);
        }

        /*** 7.Consultar de los items la descripción y el grupo***/
        for (DetailSalesOrderDTO detail : dto.getDetailSalesOrder()) {
            Object[] obj = itemSAPFacade.getItemNameAndGrup(detail.getItemCode(), dto.getCompanyName(), false);
            detail.setItemName((String) obj[0]);
            detail.setGroup((String) obj[1]);
        }

        Object[] whsCodeDefaultTire;
        //TODO: si la orden es de Extranet, consultar bodega por default que tiene asigando el asesor para las llantas
        if (dto.getNumAtCard().substring(0, 1).equals("E")) {
            whsCodeDefaultTire = salesPersonSAPFacade.getWhsCodeDefaultBySeller(dto.getSlpCode().toString(), dto.getCompanyName(), false);
        } else {
            whsCodeDefaultTire = new Object[]{dto.getDetailSalesOrder().get(0).getWhsCode()};
        }

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        /**** 8.Separación de items para crear ordenes independientes - Llantas - (**) - Repuestos - Lubricantes****/
        List<DetailSalesOrderDTO> detailSalesOrderWS = dto.getDetailSalesOrder();
        List<DetailSalesOrderDTO> detailSalesOrder_REP = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_REP_desc = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU_desc = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_desc = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_desc = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link_desc = new ArrayList<>();

        String numAtCard = dto.getNumAtCard();
        res = new ResponseExtranetDTO();
        orderCompleted = true;

        /**** 9.Crear orden directamente en cedi solo para: motorepuestos.co - REDPLAS ****/
        if (dto.getCompanyName().contains("VELEZ") || dto.getCardCode().equals("C900998242") || dto.getCompanyName().contains("REDPLAS")) {
            res = salesOrderEJB.createSalesOrderByExtranet(dto);
            if (res.getCode() == 0) {
                return Response.ok(res).build();
            } else {
                /**** 9.1.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a la app ****/
                return Response.ok(createOrderTemporary(dto, res.getOrderTemp(), res.getMessage())).build();
            }
        } else {
            for (DetailSalesOrderDTO detail : detailSalesOrderWS) {
                if (dto.getCompanyName().contains("IGB")) {
                    if (detail.getGroup().equals("LLANTAS")) {
                        if (detail.getItemCode().substring(0, 1).equals("U")) {
                            detail.setWhsCode("05");
                            if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cart_desc.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cart.add(setDetailOrder(detail, ocrCode));
                            }
                        } else {
                            //TODO: setear bodega de llantas por default
                            detail.setWhsCode((String) whsCodeDefaultTire[0]);
                            if (detail.getWhsCode().equals("05")) {
                                if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                                    detailSalesOrder_LL_cart_desc.add(setDetailOrder(detail, ocrCode));
                                } else {
                                    detailSalesOrder_LL_cart.add(setDetailOrder(detail, ocrCode));
                                }
                            } else if (detail.getWhsCode().equals("26")) {
                                if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                                    detailSalesOrder_LL_cali_desc.add(setDetailOrder(detail, ocrCode));
                                } else {
                                    detailSalesOrder_LL_cali.add(setDetailOrder(detail, ocrCode));
                                }
                            }
                        }
                    } else {
                        if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_REP_desc.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_REP.add(setDetailOrder(detail, ocrCode));
                        }
                    }
                } else {
                    if (detail.getGroup().equals("LLANTAS")) {
                        if (detail.getWhsCode().equals("13")) {
                            if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_link_desc.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_link.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("26")) {
                            if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cali_desc.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cali.add(setDetailOrder(detail, ocrCode));
                            }
                        }
                    } else if (detail.getGroup().equals("LUBRICANTES")) {
                        if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_LU_desc.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_LU.add(setDetailOrder(detail, ocrCode));
                        }
                    } else {
                        detail.setWhsCode("32");
                        if (detail.getItemName().substring(0, 4).equals("(**)") || detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_REP_desc.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_REP.add(setDetailOrder(detail, ocrCode));
                        }
                    }
                }
            }
        }
        /**** 10.5.Solo repuestos con (**) ****/
        if (detailSalesOrder_REP_desc.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP_desc);
                dto.setNumAtCard(numAtCard + "RD");
                /**** 10.5.1.Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByExtranet(dto);
                    if (res.getCode() < 0) {
                        dto.setDetailSalesOrder(new ArrayList<>());
                        dto.setDetailSalesOrder(detailSalesOrderWS);
                        dto.setNumAtCard(numAtCard);
                        ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items REPUESTOS sin (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;

                        return Response.ok(res).build();
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.6.Solo repuestos ****/
        if (detailSalesOrder_REP.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP);
                dto.setNumAtCard(numAtCard + "R");
                /**** 10.6.1.Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByExtranet(dto);
                    if (res.getCode() < 0) {
                        dto.setDetailSalesOrder(new ArrayList<>());
                        dto.setDetailSalesOrder(detailSalesOrderWS);
                        dto.setNumAtCard(numAtCard);
                        ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items REPUESTOS sin (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;

                        return Response.ok(res).build();
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.7.Solo lubricantes con (**) ****/
        if (detailSalesOrder_LU_desc.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU_desc);
                dto.setNumAtCard(numAtCard + "LUD");
                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo lubricantes con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.9.Solo llantas sin (**) ****/
        if (detailSalesOrder_LL_link.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link);
                dto.setNumAtCard(numAtCard + "LLK");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas sin (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.10.Solo llantas con (**) ****/
        if (detailSalesOrder_LL_link_desc.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link_desc);
                dto.setNumAtCard(numAtCard + "LLKD");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.2.Solo llantas de cali con (**) ****/
        if (detailSalesOrder_LL_cali_desc.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali_desc);
                dto.setNumAtCard(numAtCard + "LL26D");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas de cali con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.4.Solo llantas de cartagena con (**) ****/
        if (detailSalesOrder_LL_cart_desc.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart_desc);
                dto.setNumAtCard(numAtCard + "LL05D");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas de cartagena con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.Crear ordenes separadas por regla de negocio ****/
        /**** 10.1.Solo llantas de cali ****/
        if (detailSalesOrder_LL_cali.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali);
                dto.setNumAtCard(numAtCard + "LL26");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas de cali sin (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.3.Solo llantas de cartagena ****/
        if (detailSalesOrder_LL_cart.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart);
                dto.setNumAtCard(numAtCard + "LL05");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo llantas de cartagena sin (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.8.Solo lubricantes ****/
        if (detailSalesOrder_LU.size() > 0) {
            if (orderCompleted) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU);
                dto.setNumAtCard(numAtCard + "LU");

                res = salesOrderEJB.createSalesOrderByExtranet(dto);
                if (res.getCode() < 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrderWS);
                    dto.setNumAtCard(numAtCard);
                    ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo lubricantes sin (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;

                    return Response.ok(res).build();
                } else {
                    orderCompleted = true;
                }
            } else {
                return Response.ok(res).build();
            }
        }
        /**** 10.9.Crear orden temporal, si no clasifico bien los articulos ****/
        if (res.getContent() == null) {
            ResponseExtranetDTO response = createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items. Orden Temp={0}", response.getContent());
            res = response;
            orderCompleted = false;
        }
        CONSOLE.log(Level.INFO, "Retornando ordenes creadas para la empresa [{0}]", dto.getCompanyName());
        return Response.ok(res).build();
    }

    @POST
    @Path("update-geolocation-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response updateGeolocationCustomer(GeolocationDTO dto) {
        if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la geolocalizacion. Campo cardcode es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al actualizar la geolocalizacion. Campo cardcode es obligatorio.")).build();
        } else if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la geolocalizacion. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al actualizar la geolocalizacion. Campo companyName es obligatorio.")).build();
        } else if (dto.getLatitud() == null || dto.getLatitud().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la geolocalizacion. Campo latitud es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al actualizar la geolocalizacion. Campo latitud es obligatorio.")).build();
        } else if (dto.getLongitud() == null || dto.getLongitud().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la geolocalizacion. Campo longitud es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al actualizar la geolocalizacion. Campo longitud es obligatorio.")).build();
        }
        return Response.ok(businessPartnerSAPFacade.updateGeolocation(dto, false)).build();
    }

    @POST
    @Path("create-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(BusinessPartnerDTO dto) {
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio.")).build();
        } else if (dto.getDocument() == null || dto.getDocument().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo document es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo document es obligatorio.")).build();
        } else if (dto.getTypeDoc() == null || dto.getTypeDoc().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo typeDoc es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo typeDoc es obligatorio.")).build();
        } else if (dto.getFirstname() == null || dto.getFirstname().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo firstname es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo firstname es obligatorio.")).build();
        } else if (dto.getLastname1() == null || dto.getLastname1().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo lastname1 es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo lastname1 es obligatorio.")).build();
        } else if (dto.getPhone() == null || dto.getPhone().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo phone es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo phone es obligatorio.")).build();
        } else if (dto.getCellular() == null || dto.getCellular().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cellular es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo cellular es obligatorio.")).build();
        } else if (dto.getMail() == null || dto.getMail().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo mail es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo mail es obligatorio.")).build();
        } else if (dto.getCodDepartamento() == null || dto.getCodDepartamento().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo codDepartamento es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo codDepartamento es obligatorio.")).build();
        } else if (dto.getCodMunicipio() == null || dto.getCodMunicipio().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo codMunicipio es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo codMunicipio es obligatorio.")).build();
        } else if (dto.getAddress() == null || dto.getAddress().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo address es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo address es obligatorio.")).build();
        } else if (dto.getAcceptHabeasData() == null || dto.getAcceptHabeasData().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo acceptHabeasData es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo acceptHabeasData es obligatorio.")).build();
        } else if (dto.getTransp() == null || dto.getTransp().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo transportadora es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo transportadora es obligatorio.")).build();
        }

        int digito = basicFunctions.getDigitoDian(dto.getDocument());

        dto.setLicTradNum(dto.getDocument() + "-" + digito);
        dto.setCardCode("C" + dto.getDocument());

        if (dto.getTypeTransaction().equals("add")) {
            //Validar si ya existe el cliente en SAP.
            if (businessPartnerSAPFacade.findCustomer("C" + dto.getDocument(), dto.getCompanyName(), false)) {
                CONSOLE.log(Level.INFO, "El cliente ya existe en SAP con el id {0}", "C" + dto.getDocument());
                return Response.ok(new ResponseDTO(0, "C" + dto.getDocument())).build();
            }

            CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en {0}", dto.getCompanyName());
            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);
            return Response.ok(businessPartnerEJB.createBusinessPartnerFromWali(dto)).build();
        } else {
            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);
            return Response.ok(businessPartnerEJB.updateBusinessPartnerFromWali(dto)).build();
        }
    }

    @POST
    @Path("create-quotation")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createQuotation(QuotationDTO dto) {
        return Response.ok(quotationsEJB.createSalesOrder(dto)).build();
    }

    @POST
    @Path("create-payment")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createIncomingPayments(IncomingPaymentDTO dto) {
        CONSOLE.log(Level.INFO, "Validando campos obligatorios para la creacion de pago recibido por placeToPay");
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo companyName es obligatorio.")).build();
        } else if (dto.getIdPayment() == null || dto.getIdPayment() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago para {0}. Campo IdPayment es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo IdPayment es obligatorio.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo cardCode es obligatorio.")).build();
        } else if (dto.getTransferReference() == null || dto.getTransferReference().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago para {0}. Campo companyName es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo transferReference es obligatorio.")).build();
        } else if (dto.getCashSum() == null || dto.getCashSum().equals(BigDecimal.ZERO)) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago para {0}. Campo cashSum es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo cashSum es obligatorio.")).build();
        } else if (dto.getIncomingPaymentInvoices().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago para {0}. Campo incomingPaymentInvoices es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el pago. Campo detailSalesOrder es obligatorio.")).build();
        }
        CONSOLE.log(Level.INFO, "Iniciando creacion de pago recibido para la empresa {0}", dto.getCompanyName());
        CONSOLE.log(Level.INFO, dto.toString());

        if (pagoPasarelaSAPFacade.comfirmPayment(dto.getIdPayment(), dto.getCompanyName(), false)) {
            CONSOLE.log(Level.WARNING, "Lo sentimos. Ya existe un registro con ese id de pago en {0}", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-2, "Lo sentimos. Ya existe un registro con ese id de pago en " + dto.getCompanyName())).build();
        }
        //registrar en tabla temporal el pago recibido por placeToPayF
        String idPago = (new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getCardCode();

        PagoPasarelaSAP entityEnc = new PagoPasarelaSAP();
        entityEnc.setCode(idPago);
        entityEnc.setName(idPago);
        entityEnc.setuIdPago(dto.getIdPayment());
        entityEnc.setuCardCode(dto.getCardCode());
        entityEnc.setuTransferReference(dto.getTransferReference());
        entityEnc.setuCashSum(dto.getCashSum());
        entityEnc.setuStatus(dto.getStatus());
        entityEnc.setuPasarela("PlaceToPay");
        entityEnc.setuCreateDate(new Date());
        entityEnc.setuDocNum("0");

        try {
            pagoPasarelaSAPFacade.addPago(entityEnc, dto.getCompanyName(), false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del pago recibido para + " + dto.getCompanyName(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el registro del pago recibido para " + dto.getCompanyName())).build();
        }

        for (IncomingPaymentInvoiceDTO detPago : dto.getIncomingPaymentInvoices()) {
            String idDetPago = (new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getCardCode();
            DetallePagoPasarelaSAP entityDet = new DetallePagoPasarelaSAP();
            entityDet.setCode(idDetPago);
            entityDet.setName(idDetPago);
            entityDet.setuIdDetalle(entityEnc.getuIdPago());
            entityDet.setuIdPago(entityEnc.getuIdPago());
            entityDet.setuDocEntryFv(invoiceSAPFacade.getDocEntry(detPago.getDocEntry(), dto.getCompanyName(), false));
            detPago.setDocEntry(Long.parseLong(entityDet.getuDocEntryFv()));
            entityDet.setuLineNumFv(detPago.getLineNum());
            entityDet.setuSumAppliedFv(detPago.getSumApplied());

            try {
                detPagoPasarelaSAPFacade.addDetailPago(entityDet, dto.getCompanyName(), false);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del detalle de pago recibido para " + dto.getCompanyName(), e);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el registro del detalle de pago recibido para " + dto.getCompanyName())).build();
            }
        }

        /*if (dto.getFranchise().contains("PSE")) {

        }*/

        if (dto.getCompanyName().contains("VARROC")) {
            return Response.ok(incomingPaymentEJB.createIncomingPaymentsService(dto)).build();
        } else {
            CONSOLE.log(Level.INFO, "Finalizando creacion de pago recibido #{0} para la empresa {1}", new Object[]{entityEnc.getuIdPago(), dto.getCompanyName()});
            return Response.ok(new ResponseDTO(0, entityEnc.getuIdPago())).build();
        }
    }

    @POST
    @Path("extranet/shopping-cart")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response validateStockShoppingCart(StockShoppingCartDTO dto) {
        CONSOLE.log(Level.INFO, "Validando carrito de compras del cliente ", dto.getCardCode());
        //consultar el asesor asignado
        String slpCode = businessPartnerSAPFacade.getSellerByCustomer(dto.getCardCode(), dto.getCompanyName().equals("VELEZ") ? "IGB" : dto.getCompanyName(), false);

        List<StockShoppingCartRestDTO> list = new ArrayList<>();
        if (slpCode != null) {
            for (String item : dto.getItems()) {
                StockShoppingCartRestDTO stockShoppingCartRestDTO = new StockShoppingCartRestDTO();
                Object[] obj = itemSAPFacade.listItemsShoppingCart(slpCode, item, dto.getCompanyName(), false);

                if (obj != null) {
                    stockShoppingCartRestDTO.setItemCode((String) obj[0]);
                    stockShoppingCartRestDTO.setStock((Integer) obj[1]);
                    stockShoppingCartRestDTO.setPrice((BigDecimal) obj[2]);
                    list.add(stockShoppingCartRestDTO);
                }
            }
        }
        return Response.ok(list).build();
    }

    private ResponseExtranetDTO createOrderTemporary(SalesOrderDTO dto, Long docNum, String message) {
        /**** 7.3. Registrar pedido en tablas temporales****/
        OrderPedbox order = new OrderPedbox();
        OrderDetailPedbox detail = new OrderDetailPedbox();

        order.setDocNum(docNum.intValue());
        order.setDocDate(new Date());
        order.setCardCode(dto.getCardCode());
        order.setNumAtCard(dto.getNumAtCard());
        order.setComments(dto.getComments());
        order.setSlpCode(dto.getSlpCode().toString());
        order.setStatus("F");
        order.setCompanyName(dto.getCompanyName());
        order.setDocTotal(dto.getDocTotal());
        try {
            orderPedboxFacade.create(order, dto.getCompanyName(), false);
        } catch (Exception ex) {
        }

        for (DetailSalesOrderDTO dt : dto.getDetailSalesOrder()) {
            /**** 7.4. Consultado stock actual en SAP para MODULA y CEDI****/
            Object[] stockCurrent = itemSAPFacade.getStockItemMDLvsSAPvsSBT(dt.getItemCode(), dt.getWhsCode(), dto.getCompanyName(), false);

            detail.setIdOrder(order);
            detail.setIdOrderDetail(0);
            detail.setItemCode(dt.getItemCode());
            detail.setWhsCode(dt.getWhsCode());
            detail.setQtyAPP(dt.getQuantity());
            detail.setQtyMDL((Integer) stockCurrent[0]);
            detail.setQtySAP((Integer) stockCurrent[1]);
            detail.setQtySBT((Integer) stockCurrent[2]);
            try {
                orderDetailPedboxFacade.create(detail, dto.getCompanyName(), false);
            } catch (Exception ex) {
            }
        }
        /**** 7.5. Consultar items agotados para mostrarlos****/
        List<Object[]> objects = orderAPPFacade.listOutStockItems(order.getIdOrder(), dto.getCompanyName(), dto.getNumAtCard(), false);

        List<ResponseExtranetDTO.OutStockItems> outStockItems = new ArrayList<>();
        for (Object[] obj : objects) {
            ResponseExtranetDTO.OutStockItems outStockItem = new ResponseExtranetDTO.OutStockItems();
            outStockItem.setItemCode((String) obj[0]);
            outStockItem.setQtyOrder((Integer) obj[1]);
            outStockItem.setQtyCurrent((Integer) obj[2]);
            outStockItems.add(outStockItem);
        }
        return new ResponseExtranetDTO(0, order.getIdOrder(), 0, message, outStockItems);
    }

    private DetailSalesOrderDTO setDetailOrder(DetailSalesOrderDTO detail, String ocrCode) {
        DetailSalesOrderDTO detailDTO = new DetailSalesOrderDTO();
        detailDTO.setItemCode(detail.getItemCode());
        detailDTO.setQuantity(detail.getQuantity());
        detailDTO.setWhsCode(detail.getWhsCode());
        detailDTO.setOcrCode(ocrCode);
        detailDTO.setBaseLine(detail.getBaseLine());
        detailDTO.setBaseEntry(detail.getBaseEntry());
        detailDTO.setBaseType(detail.getBaseType());
        return detail;
    }

    private ResponseExtranetDTO sortOutItemsOnlyParts(SalesOrderDTO dto, String ocrCode) {
        ResponseExtranetDTO res = new ResponseExtranetDTO();
        String serial = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        List<DetailSalesOrderDTO> itemsMDL = new ArrayList<>();
        List<DetailSalesOrderDTO> itemsSAP = new ArrayList<>();

        /**** 9.1.1.Separar pedido 30Modula - 01CEDI ****/
        for (DetailSalesOrderDTO detailSalesOrderDTO : dto.getDetailSalesOrder()) {
            /**** 9.1.2.Consultando stock actual por item en CEDI y MODULA****/
            Object[] stockCurrent = itemSAPFacade.getStockItemMDLvsSAPvsSBT(detailSalesOrderDTO.getItemCode(), detailSalesOrderDTO.getWhsCode(), dto.getCompanyName(), false);
            /**** 9.1.3.Validar si la cantidad solicitada es mayor al porcentaje de consumo asignado en modula para decidir a donde se enviara la orden****/
            if (((Integer) stockCurrent[0] - detailSalesOrderDTO.getQuantity()) > (((Integer) stockCurrent[0] * warehouseSAPFacade.getConsumePorcModula(dto.getCompanyName(), false)) / 100)) {
                if ((Integer) stockCurrent[0] >= detailSalesOrderDTO.getQuantity()) {
                    // Llenamos detalle para enviar a modula
                    DetailSalesOrderDTO detailDTO = new DetailSalesOrderDTO();
                    detailDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                    detailDTO.setQuantity(detailSalesOrderDTO.getQuantity());
                    detailDTO.setWhsCode("30");
                    detailDTO.setOcrCode(ocrCode);
                    detailDTO.setBaseLine(detailSalesOrderDTO.getBaseLine());
                    detailDTO.setBaseEntry(detailSalesOrderDTO.getBaseEntry());
                    detailDTO.setBaseType(detailSalesOrderDTO.getBaseType());
                    itemsMDL.add(detailDTO);
                } else {
                    // Llenamos detalle para enviar a modula
                    DetailSalesOrderDTO detailDTO = new DetailSalesOrderDTO();
                    detailDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                    detailDTO.setQuantity((Integer) stockCurrent[0]);
                    detailDTO.setWhsCode("30");
                    detailDTO.setOcrCode(ocrCode);
                    detailDTO.setBaseLine(detailSalesOrderDTO.getBaseLine());
                    detailDTO.setBaseEntry(detailSalesOrderDTO.getBaseEntry());
                    detailDTO.setBaseType(detailSalesOrderDTO.getBaseType());
                    itemsMDL.add(detailDTO);
                }
            } else {
                DetailSalesOrderDTO detailDTO = new DetailSalesOrderDTO();
                if ((detailSalesOrderDTO.getQuantity() - (Integer) stockCurrent[1]) > 0) {
                    // Llenamos detalle para enviar a modula
                    detailDTO = new DetailSalesOrderDTO();
                    detailDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                    detailDTO.setQuantity((detailSalesOrderDTO.getQuantity() - (Integer) stockCurrent[1]));
                    detailDTO.setWhsCode("30");
                    detailDTO.setOcrCode(ocrCode);
                    detailDTO.setBaseLine(detailSalesOrderDTO.getBaseLine());
                    detailDTO.setBaseEntry(detailSalesOrderDTO.getBaseEntry());
                    detailDTO.setBaseType(detailSalesOrderDTO.getBaseType());
                    itemsMDL.add(detailDTO);
                    if (detailDTO.getQuantity() < detailSalesOrderDTO.getQuantity() && (Integer) stockCurrent[1] <= detailSalesOrderDTO.getQuantity()) {
                        // llenamos detalle para enviar a cedi
                        detailDTO = new DetailSalesOrderDTO();
                        detailDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                        detailDTO.setQuantity((Integer) stockCurrent[1]);
                        detailDTO.setWhsCode("01");
                        detailDTO.setOcrCode(ocrCode);
                        detailDTO.setBaseLine(detailSalesOrderDTO.getBaseLine());
                        detailDTO.setBaseEntry(detailSalesOrderDTO.getBaseEntry());
                        detailDTO.setBaseType(detailSalesOrderDTO.getBaseType());
                        itemsSAP.add(detailDTO);
                    }
                } else {
                    // llenamos detalle para enviar a cedi
                    detailDTO = new DetailSalesOrderDTO();
                    detailDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                    detailDTO.setQuantity(detailSalesOrderDTO.getQuantity());
                    detailDTO.setWhsCode("01");
                    detailDTO.setOcrCode(ocrCode);
                    detailDTO.setBaseLine(detailSalesOrderDTO.getBaseLine());
                    detailDTO.setBaseEntry(detailSalesOrderDTO.getBaseEntry());
                    detailDTO.setBaseType(detailSalesOrderDTO.getBaseType());
                    itemsSAP.add(detailDTO);
                }
            }
        }
        /**** 10.Iniciar creación de pedido 30Modula****/
        if (orderCompleted) {
            /**** 11.Iniciar creación de pedido 30Modula ****/
            if (itemsMDL.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(itemsMDL);
                dto.setNumAtCard(dto.getNumAtCard() + "M");
                dto.setSerialMDL(serial);
                /**** 10.1.Crear orden para el almacén 30-MODULA****/
                res = salesOrderEJB.createSalesOrderByExtranet(dto);

                if (res.getCode() == 0) {
                    if (dto.getStatus().equals("APROBADO") && dto.getConfirmed().equals("Y")) {
                        /**** 10.1..1.Se construye DTO para envia solicitud a wms-modula de tipo deposito estado=P****/
                        OrderModulaDTO orderModulaDTO = new OrderModulaDTO();
                        orderModulaDTO.setDocNum(res.getContent().toString());
                        orderModulaDTO.setType("P");

                        List<OrderModulaDTO.DetailModulaDTO> details = new ArrayList<>();
                        for (DetailSalesOrderDTO detailSalesOrderDTO : itemsMDL) {
                            OrderModulaDTO.DetailModulaDTO detailModulaDTO = new OrderModulaDTO.DetailModulaDTO();
                            detailModulaDTO.setItemCode(detailSalesOrderDTO.getItemCode());
                            detailModulaDTO.setQuantity(detailSalesOrderDTO.getQuantity());
                            details.add(detailModulaDTO);
                        }
                        orderModulaDTO.setDetail(details);

                        String resMDL = orderModulaEJB.addOrdine(orderModulaDTO, "Orden de Venta");
                        if (resMDL == null || resMDL.isEmpty()) {
                            CONSOLE.log(Level.SEVERE, "Ocurrio un error depositando orden de venta en modula");
                            return new ResponseExtranetDTO(-1, "Ocurrio un error depositando orden de venta en modula.");
                        }
                    }
                    orderCompleted = true;
                } else {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error creando la orden de venta en SAP de la bodega 30 Modula");
                    /**** 10.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                    orderCompleted = false;
                    return createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());
                }
            }
        } else {
            return res;
        }
        if (orderCompleted) {
            /**** 11.Iniciar creación de pedido 01CEDI ****/
            if (itemsSAP.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(itemsSAP);
                dto.setNumAtCard(dto.getNumAtCard() + "S");
                dto.setSerialMDL(serial);
                /**** 11.1.Crear orden para el almacén 01-CEDI****/
                res = salesOrderEJB.createSalesOrderByExtranet(dto);

                if (res.getCode() == 0) {
                    /**** 11.1.1.Retornando el nro de documento creado****/
                    orderCompleted = true;
                    return res;
                } else {
                    /**** 11.1.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                    orderCompleted = false;
                    return createOrderTemporary(dto, res.getOrderTemp(), res.getMessage());
                }
            } else {
                /**** 11.2.Retornando el nro de documento creado****/
                return res;
            }
        } else {
            return res;
        }
    }
}
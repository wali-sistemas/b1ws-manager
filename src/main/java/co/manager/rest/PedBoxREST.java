package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.*;
import co.manager.persistence.entity.DetallePagoPasarelaSAP;
import co.manager.persistence.entity.PagoPasarelaSAP;
import co.manager.persistence.facade.*;
import co.manager.util.Constants;

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
            warehouses.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de bodegas para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, warehouses)).build();
    }

    @GET
    @Path("items/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
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
            dto.setUnit("UND");//Modificar hasta que compras termine el proyecto de unidad de empaque.
            dto.setPresentation((Integer) obj[2]);
            dto.setPrice((BigDecimal) obj[3]);
            dto.setIva((Integer) obj[4]);
            dto.setDiscount(0);
            dto.setWhsCode((String) obj[5]);
            dto.setPictureUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/mtz/" + obj[7]);
            stock.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando items actual para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, stock)).build();
    }

    @GET
    @Path("items/extranet/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListItemsByFiltres(@PathParam("companyname") String companyname) {
        CONSOLE.log(Level.INFO, "Listando items actual para la empresa [{0}]", companyname);
        List<Object[]> objects = itemSAPFacade.getListItemsExtranet(companyname, false);

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

        List<Object[]> objects = itemSAPFacade.getStockWarehouseCurrent(itemCode.trim(), sucursal, companyname, false);

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
        List<Object[]> objects = businessPartnerSAPFacade.listCustomerPortfolioBySalesPerson(slpCode, companyname, false);

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
        //historial de facturas de los últimos 3 meses.
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
    public Response listOrdersHitoryByCustomer(@PathParam("companyname") String companyname,
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
        CONSOLE.log(Level.INFO, "Iniciando consulta de presupuesto de ventas para la empresa {0}. ano[{1}]-mes[{2}]", new Object[]{companyname, year, month});
        List<Object[]> objects = salesPersonSAPFacade.getSaleBudgetBySeller(slpCode, year, month.length() == 1 ? '0' + month : month, companyname, false);

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los presupuestos para ", companyname);
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

    @POST
    @Path("create-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesOrderDTO dto) {
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo cardCode es obligatorio.")).build();
        } else if (dto.getDetailSalesOrder().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo detailSalesOrder es obligatorio.")).build();
        } else if (dto.getSlpCode() == null || dto.getSlpCode() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo slpCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo slpCode es obligatorio.")).build();
        } else if (dto.getNumAtCard() == null || dto.getNumAtCard().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo numAtCard es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo numAtCard es obligatorio.")).build();
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo status es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo status es obligatorio.")).build();
        } else if (dto.getConfirmed() == null || dto.getConfirmed().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo confirmed es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + " .Campo confirmed es obligatorio.")).build();
        }
        //Validar si ya existe la orden en SAP por idPedBox.
        Integer docNum = salesOrderSAPFacade.getDocNumOrderByNumAtCard(dto.getNumAtCard(), dto.getCompanyName(), false);
        if (docNum != 0) {
            CONSOLE.log(Level.INFO, "La orden ya existe en SAP con el id {0}", docNum);
            return Response.ok(new ResponseDTO(0, docNum)).build();
        }
        //validar PayToCode= id direccion de factura
        List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
        if (idAddress.size() > 0) {
            for (Object[] obj : idAddress) {
                dto.setPayToCode((String) obj[1]);
            }
        }
        //Validar descuento comercial.Marcar con estado revisar y no autorizar sepearcion.
        if (dto.getCompanyName().contains("IGB") && dto.getStatus().equals("APROBADO")) {
            if (businessPartnerSAPFacade.checkFieldDiscountCommercial(dto.getCardCode(), dto.getCompanyName(), false)) {
                dto.setStatus("REVISAR");
                dto.setConfirmed("N");
            }
        }
        //Consultando id de la transportadora asignada al cliente
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
        //Consultando el centro de costo
        dto.getDetailSalesOrder().get(0).setOcrCode(salesPersonSAPFacade.getCentroCosto(dto.getSlpCode(), dto.getCompanyName(), false));
        CONSOLE.log(Level.INFO, dto.toString());

        return Response.ok(salesOrderEJB.createSalesOrder(dto)).build();
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
        CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en {0}", dto.getCompanyName());
        if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo cardCode es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo cardCode es obligatorio.")).build();
        } else if (dto.getCardName() == null || dto.getCardName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo cardName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo cardName es obligatorio.")).build();
        }

        dto.setLicTradNum(dto.getCardCode().replace("C", ""));
        return Response.ok(businessPartnerEJB.createBusinessPartner(dto)).build();
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

        if (pagoPasarelaSAPFacade.comfirmPayment(dto.getIdPayment(), dto.getCompanyName(), true)) {
            CONSOLE.log(Level.WARNING, "Lo sentimos. Ya existe un registro con ese id de pago en {0}", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Lo sentimos. Ya existe un registro con ese id de pago en " + dto.getCompanyName())).build();
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

        try {
            pagoPasarelaSAPFacade.create(entityEnc, dto.getCompanyName(), false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del pago recibido para + " + dto.getCompanyName(), e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el registro del pago recibido para " + dto.getCompanyName())).build();
        }

        for (IncomingPaymentInvoiceDTO detPago : dto.getIncomingPaymentInvoices()) {
            String idDetPago = (new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getCardCode();
            DetallePagoPasarelaSAP entityDet = new DetallePagoPasarelaSAP();
            entityDet.setCode(idDetPago);
            entityDet.setName(idDetPago);
            entityDet.setuIdPago(entityEnc.getuIdPago());
            entityDet.setuDocEntryFv(String.valueOf(invoiceSAPFacade.getDocEntry(detPago.getDocEntry(), dto.getCompanyName(), false)));
            detPago.setDocEntry(Long.parseLong(entityDet.getuDocEntryFv()));
            entityDet.setuLineNumFv(detPago.getLineNum());
            entityDet.setuSumAppliedFv(detPago.getSumApplied());

            try {
                detPagoPasarelaSAPFacade.create(entityDet, dto.getCompanyName(), false);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del detalle de pago recibido para " + dto.getCompanyName(), e);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando el registro del detalle de pago recibido para " + dto.getCompanyName())).build();
            }
        }

        CONSOLE.log(Level.INFO, dto.toString());

        if (dto.getCompanyName().contains("VARROC")) {
            return Response.ok(incomingPaymentEJB.createIncomingPaymentsService(dto)).build();
        } else {
            CONSOLE.log(Level.INFO, "Finalizando creacion de pago recibido #{0} para la empresa {1}", new Object[]{entityEnc.getuIdPago(), dto.getCompanyName()});
            return Response.ok(new ResponseDTO(0, entityEnc.getuIdPago())).build();
        }
    }
}
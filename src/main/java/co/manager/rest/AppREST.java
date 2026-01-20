package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.ejb.SalesOrderEJB;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.persistence.entity.*;
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
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("app")
public class AppREST {
    private static final Logger CONSOLE = Logger.getLogger(AppREST.class.getSimpleName());
    private boolean orderCompleted = true;

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private SalesPersonSAPFacade salesPersonSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private WarehouseSAPFacade warehouseSAPFacade;
    @EJB
    private OrderPedboxFacade orderPedboxFacade;
    @EJB
    private OrderDetailPedboxFacade orderDetailPedboxFacade;
    @EJB
    private SalesOrderEJB salesOrderEJB;
    @EJB
    private OrderModulaEJB orderModulaEJB;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;
    @EJB
    private OrderAPPFacade orderAPPFacade;
    @EJB
    private OrderDetailAPPFacade orderDetailAPPFacade;
    @EJB
    private HistoryGeoLocationSAPFacade historyGeoLocationSAPFacade;
    @EJB
    private ItemSoldOutAPPFacade itemSoldOutAPPFacade;

    @GET
    @Path("active-companies")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListActiveCompanies() {
        CONSOLE.log(Level.INFO, "Listando companias activas para la app");

        List<CompanyDTO> companies = new ArrayList<>();
        CompanyDTO dto = new CompanyDTO();
        dto.setCompanyName("IGB");
        dto.setDataBase("IGB");
        companies.add(dto);
        dto = new CompanyDTO();
        dto.setCompanyName("MOTOZONE");
        dto.setDataBase("VARROC");
        companies.add(dto);

        return Response.ok(companies).build();
    }

    @GET
    @Path("login/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getDataLogin(@PathParam("companyname") String companyName,
                                 @QueryParam("user") String user,
                                 @QueryParam("pass") String pass) {
        CONSOLE.log(Level.INFO, "Validando login para la app [" + companyName + "] del user[" + user + "]-pass[" + pass + "]");

        List<Object[]> objs = salesPersonSAPFacade.validateLoginApp(user, pass, companyName, false);
        if (objs.size() == 0) {
            CONSOLE.log(Level.WARNING, "Datos errados para iniciar sesion. User[{0}] Pass[{1}] Company[{3}]", new Object[]{user, pass, companyName});
            return Response.ok(new ResponseDTO(-1, "Datos errados para iniciar sesión")).build();
        }

        if (objs == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando datos para iniciar sesion. User[{0}] Pass[{1}] Company[{3}]", new Object[]{user, pass, companyName});
            return Response.ok(new ResponseDTO(-2, "Ocurrio un error validando datos para iniciar sesión.")).build();
        }

        List<LoginAppDTO> data = new ArrayList<>();
        for (Object[] obj : objs) {
            LoginAppDTO dto = new LoginAppDTO();
            dto.setSlpCode((String) obj[0]);
            dto.setSlpName((String) obj[1]);
            dto.setPassWord((String) obj[2]);
            dto.setAppVersion("12.4");
            dto.setCompanyName(companyName);

            data.add(dto);
        }
        return Response.ok(data).build();
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
                    dto.setBalance((BigDecimal) obj[25]);
                    dto.setCupo((BigDecimal) obj[26]);
                    dto.setPoints((BigDecimal) obj[27]);
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
    @Path("items/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getListItemsByFiltres(@PathParam("companyname") String companyname,
                                          @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Listando items actual para la empresa [{0}]", companyname);

        List<Object[]> objects = new ArrayList<>();
        if (slpCode == null) {
            objects = itemSAPFacade.getListItemsExtranet("0", companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
        } else if (slpCode.equals("0") || companyname.equals("VARROC")) {
            objects = itemSAPFacade.getListItemsExtranet("0", companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
        } else if (companyname.equals("REDPLAS")) {
            objects = itemSAPFacade.getListItemsBySellerRedPlas(slpCode, companyname, false);
        } else {
            objects = itemSAPFacade.getListItemsExtranet(slpCode, companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
            //TODO: Se usaba cuando definimos bodegas de llantas por default
            //objects = itemSAPFacade.getListItemsExtranetBySeller(slpCode, companyname, false);
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
            //TODO: Modificar hasta que compras termine el proyecto de unidad de empaque.
            dto.setPresentation((String) obj[2]);
            dto.setPrice((BigDecimal) obj[3]);
            dto.setIva((Integer) obj[4]);
            dto.setWhsCode((String) obj[5]);
            dto.setStock((Integer) obj[6] < 0 ? 0 : (Integer) obj[6]);
            dto.setDiscountItem(0);
            dto.setDiscountPorc(0);
            dto.setPictureUrl("http://wali.igbcolombia.com:8080/shared/images/mtz/" + obj[7]);
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
                dto.setUrlFichaTecnica("http://wali.igbcolombia.com:8080/shared/images/mtz/" + companyname + "/fileItem/" + obj[0] + ".pdf");
            }
            stock.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando items actual para la empresa [{0}]", companyname);
        return Response.ok(new ResponseDTO(0, stock)).build();
    }

    @GET
    @Path("stock-current/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockCurrent(@PathParam("companyname") String companyname,
                                    @QueryParam("itemcode") String itemCode,
                                    @QueryParam("whscode") String whsCode,
                                    @QueryParam("slpcode") String slpCode) {
        CONSOLE.log(Level.INFO, "Listando stock actual para el item [{0}] en la empresa [{1}]", new Object[]{itemCode, companyname});
        List<StockCurrentDTO> stockCurrentDTO = new ArrayList<>();
        List<Object[]> objects;

        String sucursal = "";
        if (!itemCode.equals("0") || !itemCode.isEmpty()) {
            if (whsCode.equals("0") || whsCode.isEmpty()) {
                //seteando sucursal se maneja como integer.
                sucursal = whsCode.trim().length() <= 1 && !whsCode.equals("0") ? "0" + whsCode.trim() : whsCode.trim();
            } else {
                if (itemCode.substring(0, 2).equals("LR") && whsCode.equals("45")) {
                    sucursal = "01";
                } else {
                    sucursal = whsCode.trim().length() <= 1 && !whsCode.equals("0") ? "0" + whsCode.trim() : whsCode.trim();
                }
            }
        }

        objects = itemSAPFacade.getStockWarehouseCurrent(itemCode.trim(), sucursal, companyname, managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA), false);
        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para el item [{0}] en [{1}]", new Object[]{itemCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el stock actual para el item [" + itemCode + "] en " + companyname)).build();
        }

        HashMap<String, String> items = new HashMap<>();
        for (Object[] obj : objects) {
            items.put((String) obj[0], "id");
        }

        for (String item : items.keySet()) {
            Integer stockFull = 0;
            List<StockCurrentDTO.StockCurrentWarehouseDTO> stockCurrentWarehouse = new ArrayList<>();
            StockCurrentDTO dto1 = new StockCurrentDTO();
            dto1.setItemCode(item);

            for (Object[] obj : objects) {
                if (dto1.getItemCode().equals(obj[0])) {
                    StockCurrentDTO.StockCurrentWarehouseDTO dto2 = new StockCurrentDTO.StockCurrentWarehouseDTO();
                    dto2.setWhsCode((String) obj[1]);
                    dto2.setQuantity((Integer) obj[2]);
                    stockFull += dto2.getQuantity();
                    stockCurrentWarehouse.add(dto2);
                }
            }
            dto1.setStockWarehouses(stockCurrentWarehouse);
            dto1.setStockFull(stockFull);
            stockCurrentDTO.add(dto1);
        }
        CONSOLE.log(Level.INFO, "Retornando listado de stock actual para el item [{0}] en [{1}]", new Object[]{itemCode, companyname});
        return Response.ok(new ResponseDTO(0, stockCurrentDTO)).build();
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
            dto.setSlpName((String) obj[6]);
            dto.setMail((String) obj[7]);
            dto.setUrlSlpPicture("http://wali.igbcolombia.com:8080/shared/images/users/seller/" + obj[8] + ".jpg");
            dto.setWhsDefTire((String) obj[9]);

            presupuestos.add(dto);
        }
        return Response.ok(new ResponseDTO(0, presupuestos)).build();
    }

    @GET
    @Path("effectiveness-sales/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSalesEffectivenessBySeller(@PathParam("companyname") String companyname,
                                                  @QueryParam("slpcode") String slpCode,
                                                  @QueryParam("year") Integer year,
                                                  @QueryParam("month") Integer month) {
        CONSOLE.log(Level.INFO, "Iniciando consulta de efectividad de ventas para el asesor [{3}] en [{0}]. ano[{1}]-mes[{2}]", new Object[]{companyname, year, month, slpCode});
        Object[] obj = salesPersonSAPFacade.getSalesEffectivenessBySeller(slpCode, year, month, companyname, false);

        if (obj == null) {
            CONSOLE.log(Level.SEVERE, "No se encontraron datos para graficar la efectividad");
            return Response.ok(new ResponseDTO(-1, "No se encontraron datos para graficar la efectividad.")).build();
        }

        SalesEffectivenessDTO dto = new SalesEffectivenessDTO();
        dto.setSlpCode((String) obj[0]);
        dto.setSlpName((String) obj[1]);
        dto.setBase((Integer) obj[2]);
        dto.setImpact((Integer) obj[3]);
        dto.setEffectiveness((BigDecimal) obj[4]);
        dto.setYear(year);
        dto.setMonth(month);

        return Response.ok(new ResponseDTO(0, dto)).build();
    }

    @GET
    @Path("list-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrder(@PathParam("companyname") String companyname,
                              @QueryParam("slpcode") long slpCode,
                              @QueryParam("year") long year,
                              @QueryParam("month") long month,
                              @QueryParam("day") long day) {
        CONSOLE.log(Level.INFO, "Listando pedidos para la empresa {0}. ano[{1}]-mes[{2}]-dia[{3}]-asesor[{4}]", new Object[]{companyname, year, month, day, slpCode});

        List<OrdersAppDTO> ordersAppDTO = new ArrayList<>();
        List<Object[]> objsSAP = salesOrderSAPFacade.listOrdersByDateAndSale(slpCode, year, month, day, companyname, false);
        if (!objsSAP.isEmpty()) {
            for (Object[] obj : objsSAP) {
                OrdersAppDTO dto = new OrdersAppDTO();
                dto.setCardCode((String) obj[0]);
                dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[1]));
                dto.setDocTotal((BigDecimal) obj[2]);
                dto.setComments((String) obj[3]);
                dto.setDocEntry((Integer) obj[4]);
                dto.setDocNum((Integer) obj[5]);
                dto.setCardName((String) obj[6]);
                dto.setStatus((String) obj[7]);

                ordersAppDTO.add(dto);
            }
        }

        List<Object[]> objsTEM = orderPedboxFacade.listOrderPendingBySales(slpCode, year, month, day, companyname, false);
        if (!objsTEM.isEmpty()) {
            for (Object[] obj : objsTEM) {
                OrdersAppDTO dto = new OrdersAppDTO();
                dto.setDocEntry((Integer) obj[0]);
                dto.setDocNum((Integer) obj[1] == 0 ? dto.getDocEntry() : (Integer) obj[1]);
                dto.setCardCode((String) obj[2]);
                dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[3]));
                dto.setDocTotal(new BigDecimal((Double) obj[4]));
                dto.setComments((String) obj[5]);
                dto.setStatus("CONTROL SISTEMAS");
                dto.setCardName(businessPartnerSAPFacade.getCustomerName(dto.getCardCode(), companyname, false));

                ordersAppDTO.add(dto);
            }
        }
        return Response.ok(new ResponseDTO(0, ordersAppDTO)).build();
    }

    @GET
    @Path("list-order-saves/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrderSaves(@PathParam("companyname") String companyname,
                                   @QueryParam("slpcode") long slpCode,
                                   @QueryParam("year") long year,
                                   @QueryParam("month") long month,
                                   @QueryParam("day") long day) {
        CONSOLE.log(Level.INFO, "Listando pedidos guardados para la empresa {0}. ano[{1}]-mes[{2}]-dia[{3}]-asesor[{4}]", new Object[]{companyname, year, month, day, slpCode});
        List<SalesOrderSaveDTO> salesOrderSaveDTO = new ArrayList<>();

        List<Object[]> objects = orderAPPFacade.listOrderSaves(slpCode, year, month, day, companyname, false);
        if (objects.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "No se encontraron ordenes guardadas para mostrar");
            List<ResponseDTO> response = new ArrayList<>();
            response.add(new ResponseDTO(-1, "No se encontraron ordenes guardadas para mostrar."));
            return Response.ok(response).build();
        }

        HashMap<Integer, String> orderSaves = new HashMap<>();
        for (Object[] obj : objects) {
            orderSaves.put((Integer) obj[0], "id");
        }

        for (Integer order : orderSaves.keySet()) {
            List<DetailSalesOrderSaveDTO> detail = new ArrayList<>();
            SalesOrderSaveDTO dto = new SalesOrderSaveDTO();
            dto.setId(order);

            for (Object[] obj : objects) {
                if (dto.getId().equals(obj[0])) {
                    //Encabezado del order guardada
                    dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[2]));
                    dto.setCardCode((String) obj[3]);
                    dto.setCardName((String) obj[4]);
                    dto.setNumAtCard((String) obj[5]);
                    dto.setShipToCode((String) obj[6]);
                    dto.setPayToCode((String) obj[7]);
                    dto.setComments((String) obj[8]);
                    dto.setSlpCode((String) obj[9]);
                    dto.setStatus((String) obj[10]);
                    dto.setCompanyName((String) obj[11]);
                    dto.setDiscountPercent((BigDecimal) obj[12]);
                    dto.setDocTotal((BigDecimal) obj[13]);
                    dto.setLineNum((String) obj[14]);
                    //Detalle de orden guardada
                    DetailSalesOrderSaveDTO dto2 = new DetailSalesOrderSaveDTO();
                    dto2.setItemCode((String) obj[17]);
                    dto2.setItemName((String) obj[18]);
                    dto2.setGroup((String) obj[19]);
                    dto2.setPresentation((String) obj[20]);
                    dto2.setWhsCode((String) obj[21]);
                    dto2.setPrice((BigDecimal) obj[22]);
                    dto2.setDiscountItem((BigDecimal) obj[23]);
                    dto2.setDiscountPorc((BigDecimal) obj[24]);
                    dto2.setIva((BigDecimal) obj[25]);
                    dto2.setQuantity((Integer) obj[26]);

                    detail.add(dto2);
                }
            }
            dto.setDetailSalesOrderSave(detail);
            salesOrderSaveDTO.add(dto);
        }
        return Response.ok(salesOrderSaveDTO).build();
    }

    @GET
    @Path("process-saved-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response processSavedOrder(@QueryParam("id") long idOrder,
                                      @QueryParam("docNum") Integer docNum,
                                      @QueryParam("status") String status,
                                      @PathParam("companyname") String companyname) {
        return Response.ok(orderAPPFacade.updateStatusOrderSaves(idOrder, status, docNum, companyname, false)).build();
    }

    @GET
    @Path("marked-days-saved-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSavedOrderByMarkedDays(@PathParam("companyname") String companyname,
                                              @QueryParam("slpcode") String slpCode) {
        List<Object> objects = orderAPPFacade.listSavedOrderByMarkedDays(slpCode, companyname, false);

        List<String> results = new ArrayList<>();
        for (Object obj : objects) {
            results.add(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj));
        }
        return Response.ok(results).build();
    }

    @GET
    @Path("report-saved-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getSavedOrdersReport(@PathParam("companyname") String companyName,
                                         @QueryParam("slpcode") String slpCode) {
        Object obj = orderAPPFacade.getSavedOrdersReportBySeller(slpCode, companyName, false);
        if (obj != null) {
            return Response.ok(new ResponseDTO(0, obj)).build();
        } else {
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error obteniendo el reporte de ordenes guardadas para el asesor " + slpCode)).build();
        }
    }

    @GET
    @Path("detail-age-customer-portfolio/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getDetailAgeCustomerPortfolio(@PathParam("companyname") String companyname,
                                                  @QueryParam("slpcode") String slpCode,
                                                  @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Iniciando consulta de edad de cartera de clientes para el asesor {0} en la empresa {1}", new Object[]{slpCode, companyname});
        List<Object[]> objects = businessPartnerSAPFacade.listDetailAgeCustomerPortfolioBySalesPerson(slpCode, cardCode, companyname, false);
        if (objects.isEmpty() || objects == null) {
            CONSOLE.log(Level.SEVERE, "No se encontraron documentos para mostrar");
            List<ResponseDTO> response = new ArrayList<>();
            response.add(new ResponseDTO(-1, "No se encontraron documentos para mostrar."));
            return Response.ok(response).build();
        }

        List<DetailAgeCustomerPortfolioDTO> details = new ArrayList<>();
        for (Object[] obj : objects) {
            DetailAgeCustomerPortfolioDTO dto = new DetailAgeCustomerPortfolioDTO();
            dto.setSlpCode((String) obj[0]);
            dto.setCardCode((String) obj[1]);
            dto.setAgeSinVencer((BigDecimal) obj[2]);
            dto.setAge0a30((BigDecimal) obj[3]);
            dto.setAge30a60((BigDecimal) obj[4]);
            dto.setAge61a90((BigDecimal) obj[5]);
            dto.setAge91a120((BigDecimal) obj[6]);
            dto.setAgeMas120((BigDecimal) obj[7]);
            dto.setSubTotal((BigDecimal) obj[8]);
            dto.setTotal((BigDecimal) obj[9]);
            dto.setEmail((String) obj[10]);
            dto.setPhone((String) obj[11]);

            details.add(dto);
        }
        return Response.ok(new ResponseDTO(0, details)).build();
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
                                                          @QueryParam("slpcode") String slpCode,
                                                          @QueryParam("cardcode") String cardCode) {
        CONSOLE.log(Level.INFO, "Iniciando servicio para obtener la cartera de clientes para el vendedor {0} en la empresa [{1}]", new Object[]{slpCode, companyname});
        List<PortfolioCustomerDTO> customerPortfolio = new ArrayList<>();
        List<Object[]> objects = businessPartnerSAPFacade.listCustomerPortfolioBySalesPerson(slpCode, cardCode, companyname, false);

        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la cartera de los clientes asignados al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar la cartera de los clientes asignados al vendedor " + slpCode + " en " + companyname)).build();
        }
        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos asociados al vendedor {0} en {1}", new Object[]{slpCode, companyname});
            return Response.ok(new ResponseDTO(-1, "No se encontraron datos asociados al vendedor " + slpCode + " en " + companyname)).build();
        }

        TreeMap<String, String> customers = new TreeMap<>();
        for (Object[] obj : objects) {
            customers.put((String) obj[1], "id");
        }

        for (Map.Entry<String, String> client : customers.entrySet()) {
            List<PortfolioCustomerDTO.DetailPortfolioCustomerDTO> customerDetailPortfolio = new ArrayList<>();
            PortfolioCustomerDTO dto = new PortfolioCustomerDTO();
            dto.setCardName(client.getKey());

            for (Object[] obj : objects) {
                if (dto.getCardName().equals(obj[1])) {
                    //Encabezado del CustomerDTO.
                    dto.setCardCode((String) obj[0]);
                    dto.setLicTradNum((String) obj[2]);
                    dto.setSlpName((String) obj[10]);
                    dto.setPayCondition((String) obj[11]);
                    dto.setCupo((BigDecimal) obj[12]);
                    dto.setPayDayAvg((Integer) obj[13]);
                    dto.setLastSaleDay((Date) obj[14]);
                    dto.setTotalDoc((Integer) obj[16]);
                    dto.setEmailFE((String) obj[17]);
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
                    dto2.setTotalBruto((BigDecimal) obj[18]);
                    dto2.setActiveCalc((String) obj[19]);
                    dto2.setComment((String) obj[20]);
                    dto2.setDiscApplied(0);
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
    @Path("get-geo-location/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getGeoLoactionBySeller(@PathParam("companyname") String companyname,
                                           @QueryParam("slpcode") String slpCode,
                                           @QueryParam("year") String year,
                                           @QueryParam("month") String month,
                                           @QueryParam("day") String day) {
        List<Object[]> objs = historyGeoLocationSAPFacade.listGeoLocationBySeller(slpCode, year, month, day, companyname, false);
        List<HistoryGeoLocationDTO> recordGeoLocations = new ArrayList<>();
        for (Object[] obj : objs) {
            HistoryGeoLocationDTO dto = new HistoryGeoLocationDTO();
            dto.setSlpCode((String) obj[0]);
            dto.setSlpName((String) obj[1]);
            dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format(obj[2]));
            dto.setDocTime((String) obj[3]);
            dto.setLatitude((String) obj[4]);
            dto.setLongitude((String) obj[5]);
            dto.setDocType((String) obj[6]);
            dto.setRegional((String) obj[7]);
            dto.setIdCard((String) obj[8]);
            recordGeoLocations.add(dto);
        }
        return Response.ok(new ResponseDTO(0, recordGeoLocations)).build();
    }

    @GET
    @Path("list-activity-report/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listActivityReportBySellers(@PathParam("companyname") String companyName) {
        return Response.ok(historyGeoLocationSAPFacade.listActivityReportBySeller(companyName, false)).build();
    }

    @GET
    @Path("create-record-login/{companyname}/{slpcode}/{version}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createRecordLogin(@PathParam("companyname") String companyName,
                                      @PathParam("slpcode") String slpCode,
                                      @PathParam("version") String version) {
        return Response.ok(new ResponseDTO(0, salesPersonSAPFacade.addLoginVersionApp(slpCode, version, companyName, false))).build();
    }

    @GET
    @Path("find-order-extranet-inprogress/{companyname}/{slpcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response findOrderExtranetInProgressBySeller(@PathParam("companyname") String companyName,
                                                        @PathParam("slpcode") String slpCode) {
        Object[] obj = salesOrderSAPFacade.getOrderExtranetInProgressBySeller(slpCode, companyName, false);
        if (obj == null) {
            return Response.ok(new ResponseDTO(-1, "No se encontraron ordenes de extranet en progreso para el asesor " + slpCode + " en la empresa " + companyName)).build();
        }

        NotificationOrderExtranetDTO dto = new NotificationOrderExtranetDTO();
        dto.setDocNum((String) obj[0]);
        dto.setDocDate(new SimpleDateFormat("yyyy-MM-dd").format(obj[1]));
        dto.setDocTotal((BigDecimal) obj[2]);
        dto.setCardCode((String) obj[3]);
        dto.setCardName((String) obj[4]);

        return Response.ok(new ResponseDTO(0, dto)).build();
    }

    @GET
    @Path("list-budget-brand/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response findSalesBudgetByBrandAndSeller(@PathParam("companyname") String companyName,
                                                    @QueryParam("slpcode") String slpCode) {
        List<Object[]> objs = salesPersonSAPFacade.getSalesBudgetByBrandAndSeller(slpCode, companyName, false);
        if (objs.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "No se encontro presupuesto de marcas para mostrar del asesor " + slpCode + " en " + companyName);
            return Response.ok(new ResponseDTO(-1, "No se encontro presupuesto de marcas para mostrar del asesor.")).build();
        }

        List<SalesBudgetBrandDTO> list = new ArrayList<>();
        for (Object[] obj : objs) {
            SalesBudgetBrandDTO dto = new SalesBudgetBrandDTO();
            dto.setBrand((String) obj[0]);
            dto.setBudget((BigDecimal) obj[1]);
            dto.setSale((BigDecimal) obj[2]);
            dto.setResult((String) obj[3]);

            if (dto.getBudget().compareTo(BigDecimal.ZERO) > 0) {
                dto.setPercent(Math.max(dto.getSale().multiply(new BigDecimal("100")).divide(dto.getBudget(), 0, RoundingMode.HALF_UP).intValue(), 0));
            } else {
                dto.setPercent(0);
            }

            list.add(dto);
        }
        return Response.ok(new ResponseDTO(0, list)).build();
    }

    @PUT
    @Path("update-status-order-extranet/{companyname}/{docnum}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response updateStatusNotificationOrderExtranet(@PathParam("companyname") String companyName,
                                                          @PathParam("docnum") String docNum) {
        try {
            return Response.ok(new ResponseDTO(0, salesOrderSAPFacade.updateStatusOrderExtranetInprogress(docNum, "NOTIFICADO APP", companyName, false))).build();
        } catch (Exception e) {
            return Response.ok(new ResponseDTO(-1, false)).build();
        }
    }

    @POST
    @Path("add-item-sold-out")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addItemSoldOut(ItemSoldOutAppDTO dto) {
        ItemSoldOutAPP entity = new ItemSoldOutAPP();

        entity.setItemCode(dto.getItemCode());
        entity.setItemName(dto.getItemName());
        entity.setQtySoldOut(dto.getQuantity());
        entity.setDocDate(new Date());
        entity.setSlpCode(dto.getSlpCode());
        entity.setCompanyName(dto.getCompanyName());
        entity.setOrigen(dto.getOrigen());
        entity.setWhsName(dto.getWhsName());

        try {
            itemSoldOutAPPFacade.create(entity, entity.getCompanyName(), false);
        } catch (Exception e) {
            return Response.ok(false).build();
        }
        return Response.ok(true).build();
    }

    @POST
    @Path("create-record-geo-location")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createRecordGeoLocation(HistoryGeoLocationDTO dto) {
        if (dto.getSlpCode() == null || dto.getSlpCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de geo-localizacion. Campo slpCode es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el registro de geo-localizacion. Campo slpCode es obligatorio.")).build();
        } else if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de geo-localizacion. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el registro de geo-localizacion. Campo companyName es obligatorio.")).build();
        } else if (dto.getLatitude() == null || dto.getLatitude().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de geo-localizacion. Campo latitude es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el registro de geo-localizacion. Campo latitude es obligatorio.")).build();
        } else if (dto.getLongitude() == null || dto.getLongitude().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de geo-localizacion. Campo longitude es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el registro de geo-localizacion. Campo longitude es obligatorio.")).build();
        } else if (dto.getDocType() == null || dto.getDocType().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de geo-localizacion. Campo docType es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el registro de geo-localizacion. Campo docType es obligatorio.")).build();
        }
        CONSOLE.log(Level.INFO, "Iniciando servicio para crear registro de geo-localizacion para el asesor {0} en {1}", new Object[]{dto.getSlpCode(), dto.getCompanyName()});

        HistoryGeoLocationSAP entity = new HistoryGeoLocationSAP();
        entity.setCode(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + dto.getSlpCode());
        entity.setName(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + dto.getSlpCode());
        entity.setUslpCode(dto.getSlpCode());
        entity.setUdocDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        entity.setUdocTime(new SimpleDateFormat("HHmm").format(new Date()));
        entity.setUlatitud(dto.getLatitude());
        entity.setUlongitud(dto.getLongitude());
        entity.setUdocType(dto.getDocType());
        try {
            historyGeoLocationSAPFacade.addHistoryGeoLocation(entity, dto.getCompanyName(), false);
            CONSOLE.log(Level.INFO, "Asesor [" + dto.getSlpCode() + "]-" + dto.getCompanyName() + " geo-localizado con exito");
            return Response.ok(new ResponseDTO(0, "Asesor [" + dto.getSlpCode() + "]-" + dto.getCompanyName() + " geo-localizado con exito")).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error geo-localizando el asesor " + dto.getSlpCode() + " en " + dto.getCompanyName());
            return Response.ok(-1, "Ocurrio un error geo-localizando el asesor " + dto.getSlpCode() + " en " + dto.getCompanyName()).build();
        }
    }

    @POST
    @Path("create-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesOrderDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creacion de orden de venta para " + dto.getCompanyName());

        /*if (!dto.getCardCode().equals("C900998242")) {
            //TODO: restablecer numAtCard
            dto.setNumAtCard(dto.getNumAtCard().substring(0, dto.getNumAtCard().length()-1));
        }*/

        ResponseDTO res = new ResponseDTO();
        /**** 1. Validar si ya existe la orden en SAP por idPedBox campo NumAtCard****/
        if (dto.getNumAtCard() == null || dto.getNumAtCard().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo numAtCard es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo numAtCard es obligatorio.")).build();
        } else {
            Integer docNum = salesOrderSAPFacade.getDocNumOrderByNumAtCard(dto.getNumAtCard(), dto.getCompanyName(), false);
            if (docNum != 0) {
                CONSOLE.log(Level.INFO, "La orden ya existe en SAP con el id {0}", docNum);
                return Response.ok(new ResponseDTO(0, docNum)).build();
            }
        }
        /**** 2. Validar campos obligatorios para creación de orden de venta****/
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo cardCode es obligatorio.")).build();
        } else if (dto.getDetailSalesOrder().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo detailSalesOrder es obligatorio.")).build();
        } else if (dto.getSlpCode() == null || dto.getSlpCode() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo slpCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo slpCode es obligatorio.")).build();
        } else if (dto.getDocTotal() == null || dto.getDocTotal() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo docTotal es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo docTotal es obligatorio.")).build();
        }

        /**** 3. Validar descuento comercial. Marcar con estado REVISAR y no Autorizar despacho****/
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
        /*if (dto.getCompanyName().contains("IGB")) {
            if (businessPartnerSAPFacade.checkFieldDiscountCommercial(dto.getCardCode(), dto.getCompanyName(), false)) {
                dto.setStatus("REVISAR");
                dto.setConfirmed("N");
            } else if (dto.getDocTotal() <= businessPartnerSAPFacade.getAvailableCreditByCustomer(dto.getCardCode(), dto.getCompanyName(), false).doubleValue()) {
                dto.setStatus("APROBADO");
                dto.setConfirmed("Y");
            } else {
                dto.setStatus("REVISAR");
                dto.setConfirmed("N");
            }
        } else if (dto.getCompanyName().contains("VARROC")) {
            //TODO: Por instrucción del area de operaciones de MTZ, todos las ordenes ingresan con estado REVISAR
            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
        }
        //TODO: Solo para motorepuestos.co las ordenes pasan aprobadas en IGB
        if (dto.getCardCode().equals("C900998242")) {
            dto.setStatus("APROBADO");
            dto.setConfirmed("Y");
        }*/
        /**** 4. Consultando el centro de costo por asesor de venta****/
        String ocrCode = salesPersonSAPFacade.getCentroCosto(dto.getSlpCode(), dto.getCompanyName(), false);
        dto.getDetailSalesOrder().get(0).setOcrCode(ocrCode);
        /**** 5. Consultando código de transportadora asignada al cliente****/
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
        /**** 6. Consultando por cliente el id de la dirección de factura****/
        String shipToCodeDefault = null;
        List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
        if (idAddress.size() > 0) {
            for (Object[] obj : idAddress) {
                shipToCodeDefault = (String) obj[0];
                dto.setPayToCode((String) obj[1]);
            }
        }

        if (dto.getShipToCode().equals("Elija un destino")) {
            dto.setShipToCode(shipToCodeDefault);
        }

        //TODO: asignar bodega 01 a la 45 cuando sea solo lubricante
        for (DetailSalesOrderDTO detail : dto.getDetailSalesOrder()) {
            if (detail.getItemCode().substring(0, 2).equals("LR") && detail.getWhsCode().equals("45")) {
                detail.setWhsCode("01");
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        /**** 7. Separación de items para crear ordenes independientes - Llantas - (*) - (**) - Repuestos - combos ****/
        List<DetailSalesOrderDTO> detailSalesOrderWS = dto.getDetailSalesOrder();
        List<DetailSalesOrderDTO> detailSalesOrder_REP = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_REP_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_REP_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_REP_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LU_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_link_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_med = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_med_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_med_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_med_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_bog = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_bog_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_bog_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LR_bog_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_bog = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_combo = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_med = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_med_one_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_med_two_asterisk = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_LL_med_combo = new ArrayList<>();

        String numAtCard = dto.getNumAtCard();
        res = new ResponseDTO();
        orderCompleted = true;

        /**** 8. Crear orden directamente en cedi solo para: motorepuestos.co - REDPLAS ****/
        if (dto.getCompanyName().contains("VELEZ") || dto.getCardCode().equals("C900998242") || dto.getCompanyName().contains("REDPLAS")) {
            res = salesOrderEJB.createSalesOrderByApp(dto);
            if (res.getCode() == 0) {
                return Response.ok(res).build();
            } else {
                /**** 8.1. Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a la app ****/
                return Response.ok(createOrderTemporary(dto, 0)).build();
            }
        } else {
            for (DetailSalesOrderDTO detail : detailSalesOrderWS) {
                if (dto.getCompanyName().contains("IGB")) {
                    if (detail.getGroup().equals("LLANTAS")) {
                        if (detail.getWhsCode().equals("05")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cart_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_cart_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_cart_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cart.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("26")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cali_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_cali_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_cali_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cali.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("35")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_bog_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_bog_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_bog_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_bog.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("45")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_med_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_med_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_med_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_med.add(setDetailOrder(detail, ocrCode));
                            }
                        }
                    } else if (detail.getGroup().equals("LUBRICANTES") && detail.getItemCode().substring(0, 2).equals("LR")) {
                        if (detail.getWhsCode().equals("35")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LR_bog_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LR_bog_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LR_bog_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LR_bog.add(setDetailOrder(detail, ocrCode));
                            }
                        } else {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LR_med_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LR_med_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LR_med_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LR_med.add(setDetailOrder(detail, ocrCode));
                            }
                        }
                    } else {
                        if (detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_REP_one_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                            detailSalesOrder_REP_two_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                            detailSalesOrder_REP_combo.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_REP.add(setDetailOrder(detail, ocrCode));
                        }
                    }
                } else {
                    if (detail.getGroup().equals("LLANTAS")) {
                        if (detail.getWhsCode().equals("13")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_link_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_link_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_link_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_link.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("26")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cali_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_cali_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_cali_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cali.add(setDetailOrder(detail, ocrCode));
                            }
                        }
                    } else if (detail.getGroup().equals("LUBRICANTES")) {
                        if (detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_LU_one_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                            detailSalesOrder_LU_two_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                            detailSalesOrder_LU_combo.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_LU.add(setDetailOrder(detail, ocrCode));
                        }
                    } else {
                        detail.setWhsCode("32");
                        if (detail.getItemName().substring(0, 3).equals("(*)")) {
                            detailSalesOrder_REP_one_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                            detailSalesOrder_REP_two_asterisk.add(setDetailOrder(detail, ocrCode));
                        } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                            detailSalesOrder_REP_combo.add(setDetailOrder(detail, ocrCode));
                        } else {
                            detailSalesOrder_REP.add(setDetailOrder(detail, ocrCode));
                        }
                    }
                }
            }
        }
        /**** 9.Crear ordenes separadas por regla de negocio ****/
        /**** 9.1. Solo repuestos con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_REP_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP_one_asterisk);
                dto.setNumAtCard(numAtCard + "RD1");
                /**** 9.1.1. Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items Repuestos con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.2. Solo repuestos con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_REP_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP_two_asterisk);
                dto.setNumAtCard(numAtCard + "RD2");
                /**** 9.2.1. Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items Repuestos con (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.3. Solo repuestos con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_REP_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP_combo);
                dto.setNumAtCard(numAtCard + "RDC");
                /**** 9.3.1. Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items Repuestos con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.4. Solo repuestos ****/
        if (orderCompleted) {
            if (detailSalesOrder_REP.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP);
                dto.setNumAtCard(numAtCard + "R");
                /**** 9.4.1. Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
                if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("true")) {
                    res = sortOutItemsOnlyParts(dto, ocrCode);
                } else {
                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items Repuestos. Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.5. Solo lubricantes con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LU_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU_one_asterisk);
                dto.setNumAtCard(numAtCard + "LU13D1");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.6. Solo lubricantes con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LU_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU_two_asterisk);
                dto.setNumAtCard(numAtCard + "LU13D2");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.7. Solo lubricantes con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LU_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU_combo);
                dto.setNumAtCard(numAtCard + "LU13DC");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.8. Solo lubricantes REVO Medellín con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_med_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_med_one_asterisk);
                dto.setNumAtCard(numAtCard + "LR01D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Medellin con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.9. Solo lubricantes REVO Medellín con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_med_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_med_two_asterisk);
                dto.setNumAtCard(numAtCard + "LR01D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Medellin con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.10. Solo lubricantes REVO Medellín con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_med_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_med_combo);
                dto.setNumAtCard(numAtCard + "LR01DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Medellin con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.11. Solo lubricantes REVO Bogotá con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_bog_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_bog_one_asterisk);
                dto.setNumAtCard(numAtCard + "LR35D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Bogota con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.12. Solo lubricantes REVO Bogotá con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_bog_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_bog_two_asterisk);
                dto.setNumAtCard(numAtCard + "LR35D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Bogota con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.13. Solo lubricantes REVO Bogotá con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_bog_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_bog_combo);
                dto.setNumAtCard(numAtCard + "LR35DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Bogota con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.14. Solo llantas link con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_link_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link_one_asterisk);
                dto.setNumAtCard(numAtCard + "LL13D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (*). Orden Temp={0}", response.getContent());
                    res = response;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.15. Solo llantas link con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_link_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link_two_asterisk);
                dto.setNumAtCard(numAtCard + "LL13D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (**). Orden Temp={0}", response.getContent());
                    res = response;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.16. Solo llantas link con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_link_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link_combo);
                dto.setNumAtCard(numAtCard + "LL13DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.17. Solo llantas link ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_link.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_link);
                dto.setNumAtCard(numAtCard + "LL13");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link. Orden Temp={0}", response.getContent());
                    res = response;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.18. Solo llantas de cali con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cali_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali_one_asterisk);
                dto.setNumAtCard(numAtCard + "LL26D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.19. Solo llantas de cali con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cali_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali_two_asterisk);
                dto.setNumAtCard(numAtCard + "LL26D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.20. Solo llantas de cali con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cali_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali_combo);
                dto.setNumAtCard(numAtCard + "LL26DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.21. Solo llantas de cartagena con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cart_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart_one_asterisk);
                dto.setNumAtCard(numAtCard + "LL05D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.22. Solo llantas de cartagena con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cart_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart_two_asterisk);
                dto.setNumAtCard(numAtCard + "LL05D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.23. Solo llantas de cartagena con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cart_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart_combo);
                dto.setNumAtCard(numAtCard + "LL05DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.24. Solo llantas de bogotá con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_bog_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_bog_one_asterisk);
                dto.setNumAtCard(numAtCard + "LL35D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.25. Solo llantas de bogotá con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_bog_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_bog_two_asterisk);
                dto.setNumAtCard(numAtCard + "LL35D2");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (**). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.26. Solo llantas de bogotá con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_bog_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_bog_combo);
                dto.setNumAtCard(numAtCard + "LL35DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.27. Solo llantas de medellín con (*) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_med_one_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_med_one_asterisk);
                dto.setNumAtCard(numAtCard + "LL45D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.28. Solo llantas de medellín con (**) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_med_two_asterisk.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_med_two_asterisk);
                dto.setNumAtCard(numAtCard + "LL45D1");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (*). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.29. Solo llantas de medellín con (combo) ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_med_combo.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_med_combo);
                dto.setNumAtCard(numAtCard + "LL45DC");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (combo). Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.30. Solo lubricantes ****/
        if (orderCompleted) {
            if (detailSalesOrder_LU.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LU);
                dto.setNumAtCard(numAtCard + "LU");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.31. Solo lubricantes REVO Medellín****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_med.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_med);
                dto.setNumAtCard(numAtCard + "LR01");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Medellin. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.32. Solo lubricantes REVO Bogotá****/
        if (orderCompleted) {
            if (detailSalesOrder_LR_bog.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LR_bog);
                dto.setNumAtCard(numAtCard + "LR35");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo Lubricantes Revo Bogota. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.33. Solo llantas de cali ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cali.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cali);
                dto.setNumAtCard(numAtCard + "LL26");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.34. Solo llantas de cartagena ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_cart.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_cart);
                dto.setNumAtCard(numAtCard + "LL05");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.35. Solo llantas de bogotá ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_bog.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_bog);
                dto.setNumAtCard(numAtCard + "LL35");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        /**** 9.36. Solo llantas de medellín ****/
        if (orderCompleted) {
            if (detailSalesOrder_LL_med.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_LL_med);
                dto.setNumAtCard(numAtCard + "LL45");
                dto.setSerialMDL("");

                res = salesOrderEJB.createSalesOrderByApp(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín. Orden Temp={0}", response.getContent());
                    res = response;
                    orderCompleted = false;
                } else {
                    orderCompleted = true;
                }
            }
        } else {
            return Response.ok(res).build();
        }
        //TODO: crear orden temporal, si no clasifico bien los articulos
        if (res.getContent() == null) {
            ResponseDTO response = createOrderTemporary(dto, 0);
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items. Orden Temp={0}", response.getContent());
            res = response;
            orderCompleted = false;
        }
        CONSOLE.log(Level.INFO, "Retornando ordenes creadas para la empresa [{0}]", dto.getCompanyName());
        return Response.ok(res).build();
    }

    @POST
    @Path("save-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response saveOrderSale(SalesOrderSaveDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando guardado de orden de venta para " + dto.getCompanyName());

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        /****Registrar pedido en tablas temporales****/
        OrderAPP order = new OrderAPP();
        OrderDetailAPP detail = new OrderDetailAPP();

        order.setDocNum(null);
        order.setDocDate(new Date());
        order.setCardCode(dto.getCardCode());
        order.setCardName(dto.getCardName());
        order.setNumAtCard(dto.getNumAtCard());
        order.setComments(dto.getComments());
        order.setSlpCode(dto.getSlpCode());
        order.setStatus("G");
        order.setCompanyName(dto.getCompanyName());
        order.setDocTotal(dto.getDocTotal().doubleValue());
        order.setShipToCode(dto.getShipToCode());
        order.setPayToCode(dto.getPayToCode());
        order.setDiscountPercent(dto.getDiscountPercent().doubleValue());
        order.setLineNum(dto.getLineNum());
        try {
            orderAPPFacade.create(order, dto.getCompanyName(), false);
        } catch (Exception ex) {
        }

        for (DetailSalesOrderSaveDTO dt : dto.getDetailSalesOrderSave()) {
            /****Consultado stock actual en SAP - MODULA - SBT y CEDI****/
            Object[] stockCurrent = itemSAPFacade.getStockItemMDLvsSAPvsSBT(dt.getItemCode(), dt.getWhsCode(), dto.getCompanyName(), false);

            detail.setIdOrder(order);
            detail.setIdOrderDetail(0);
            detail.setItemCode(dt.getItemCode());
            detail.setItemName(dt.getItemName());
            detail.setGroup(dt.getGroup());
            detail.setPresentation(dt.getPresentation());
            detail.setWhsCode(dt.getWhsCode());
            detail.setPrice(dt.getPrice().doubleValue());
            detail.setDiscountItem(dt.getDiscountItem().doubleValue());
            detail.setDiscountPorc(dt.getDiscountPorc().doubleValue());
            detail.setIva(dt.getIva().doubleValue());
            detail.setQtyAPP(dt.getQuantity());
            detail.setQtyMDL((Integer) stockCurrent[0]);
            detail.setQtySAP((Integer) stockCurrent[1]);
            detail.setQtySBT((Integer) stockCurrent[2]);
            try {
                orderDetailAPPFacade.create(detail, dto.getCompanyName(), false);
            } catch (Exception ex) {
            }
        }
        return Response.ok(new ResponseDTO(0, order.getIdOrder())).build();
    }

    private ResponseDTO sortOutItemsOnlyParts(SalesOrderDTO dto, String ocrCode) {
        ResponseDTO res = new ResponseDTO();
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
            if (itemsMDL.size() > 0) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(itemsMDL);
                dto.setNumAtCard(dto.getNumAtCard() + "M");
                dto.setSerialMDL(serial);
                /**** 10.1.Crear orden para el almacén 30-MODULA****/
                res = salesOrderEJB.createSalesOrderByApp(dto);

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
                            return new ResponseDTO(-1, "Ocurrio un error depositando orden de venta en modula.");
                        }
                    }
                    orderCompleted = true;
                } else {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error creando la orden de venta en SAP de la bodega 30 Modula");
                    /**** 10.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                    orderCompleted = false;
                    return createOrderTemporary(dto, 0);
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
                res = salesOrderEJB.createSalesOrderByApp(dto);

                if (res.getCode() == 0) {
                    /**** 11.1.1.Retornando el nro de documento creado****/
                    orderCompleted = true;
                    return res;
                } else {
                    /**** 11.1.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                    orderCompleted = false;
                    return createOrderTemporary(dto, 0);
                }
            } else {
                /**** 11.2.Retornando el nro de documento creado****/
                return res;
            }
        } else {
            return res;
        }
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

    private ResponseDTO createOrderTemporary(SalesOrderDTO dto, Integer docNum/*, String msjError*/) {
        /****Registrar pedido en tablas temporales****/
        OrderPedbox order = new OrderPedbox();
        OrderDetailPedbox detail = new OrderDetailPedbox();

        order.setDocNum(docNum);
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
            /****Consultado stock actual en SAP - MODULA - SBT y CEDI****/
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
        CONSOLE.log(Level.INFO, "Se creo la orden temporal satisfactoriamente. idOrden={0} en la empresa {1}", new Object[]{order.getIdOrder(), dto.getCompanyName()});
        return new ResponseDTO(0, order.getIdOrder());
    }
}
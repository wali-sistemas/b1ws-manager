package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.ejb.SalesOrderEJB;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.persistence.entity.OrderDetailPedbox;
import co.manager.persistence.entity.OrderPedbox;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("app")
public class AppREST {
    private static final Logger CONSOLE = Logger.getLogger(AppREST.class.getSimpleName());

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
            CONSOLE.log(Level.WARNING, "Datos errados para iniciar sesion. User[0] Pass[1] Company[3]", new Object[]{user, pass, companyName});
            return Response.ok(new ResponseDTO(-1, "Datos errados para iniciar sesión")).build();
        }

        if (objs == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando datos para iniciar sesion. User[0] Pass[1] Company[3]", new Object[]{user, pass, companyName});
            return Response.ok(new ResponseDTO(-2, "Ocurrio un error validando datos para iniciar sesión.")).build();
        }

        List<LoginAppDTO> data = new ArrayList<>();
        for (Object[] obj : objs) {
            LoginAppDTO dto = new LoginAppDTO();
            dto.setSlpCode((String) obj[0]);
            dto.setSlpName((String) obj[1]);
            dto.setPassWord((String) obj[2]);
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
    @Path("items/{companyname}")
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
                                    @QueryParam("whscode") String whsCode) {
        CONSOLE.log(Level.INFO, "Listando stock actual para el item [{0}] en la empresa [{1}]", new Object[]{itemCode, companyname});
        List<StockCurrentDTO> stockCurrentDTO = new ArrayList<>();
        //seteando sucursal se maneja como integer.
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
        CONSOLE.log(Level.INFO, "Iniciando creacion de orden de venta para " + dto.getCompanyName());

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
        if (dto.getCompanyName().contains("IGB")) {
            if (businessPartnerSAPFacade.checkFieldDiscountCommercial(dto.getCardCode(), dto.getCompanyName(), false)) {
                dto.setStatus("REVISAR");
                dto.setConfirmed("N");
            } else if (dto.getDocTotal() <= businessPartnerSAPFacade.getAvailableCreditByCustomer(dto.getCardCode(), dto.getCompanyName(), false)) {
                dto.setStatus("TEST-APROBADO");
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
        //TODO: Solo para motorepuestos.co y editores las ordenes pasan aprobadas
        if (dto.getCardCode().equals("C900998242") || dto.getCardCode().equals("C900640419")) {
            dto.setStatus("APROBADO");
            dto.setConfirmed("Y");
        }
        /**** 4. Consultando el centro de costo por asesor de venta****/
        String ocrCode = salesPersonSAPFacade.getCentroCosto(dto.getSlpCode(), dto.getCompanyName(), false);
        dto.getDetailSalesOrder().get(0).setOcrCode(ocrCode);
        /**** 5. Consultando código de transportadora asignada al cliente****/
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
        /**** 6. Consultando por cliente el id de la dirección de factura****/
        List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
        if (idAddress.size() > 0) {
            for (Object[] obj : idAddress) {
                dto.setPayToCode((String) obj[1]);
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        /**** 7. Separación de items para crear ordenes independientes - Llantas - (**) - Repuestos****/
        List<DetailSalesOrderDTO> detailSalesOrderWS = dto.getDetailSalesOrder();
        List<DetailSalesOrderDTO> detailSalesOrder_TY = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_PW = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_U = new ArrayList<>();
        List<DetailSalesOrderDTO> detailSalesOrder_REP = new ArrayList<>();

        List<DetailSalesOrderDTO> detailSalesOrder_TY_desc = new ArrayList<>();

        List<DetailSalesOrderDTO> detailSalesOrder_PW_desc = new ArrayList<>();

        List<DetailSalesOrderDTO> detailSalesOrder_U_desc = new ArrayList<>();

        List<DetailSalesOrderDTO> detailSalesOrder_REP_desc = new ArrayList<>();

        String numAtCard = dto.getNumAtCard();
        res = new ResponseDTO();

        /**** 8. Crear orden directamente en cedi solo para MOTOREPUESTOS - IGB(cliente C900998242)****/
        if (dto.getCompanyName().contains("VELEZ") || dto.getCardCode().equals("C900998242")) {
            res = salesOrderEJB.createSalesOrder(dto);
            if (res.getCode() == 0) {
                return Response.ok(res).build();
            } else {
                /**** 8.1. Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a la app****/
                return Response.ok(createOrderTemporary(dto, 0)).build();
            }
        } else if (dto.getCompanyName().contains("VARROC")) {
            //TODO: Pendiente por separar las llantas y repuestos de MTZ
        } else {
            for (DetailSalesOrderDTO detail : detailSalesOrderWS) {
                /**** 8.2. Registrar ventas perdidas, recorrer lista para identificar items reportados****/
                if (detail.getWhsCode().equals("00")) {
                    return Response.ok(createOrderTemporary(dto, 0)).build();
                } else if (detail.getItemCode().substring(0, 2).equals("TY")) {
                    /**** 8.3. Separar con ítems solo Llantas TY (Timsun) con (**) ****/
                    if (detail.getItemName().substring(0, 4).equals("(**)")) {
                        detailSalesOrder_TY_desc.add(setDetailOrder(detail, ocrCode));
                    } else {
                        /**** 8.3.1. Separar con ítems solo Llantas TY (Timsun) sin (**) ****/
                        detailSalesOrder_TY.add(setDetailOrder(detail, ocrCode));
                    }
                } else if (detail.getItemCode().substring(0, 2).equals("PW")) {
                    /**** 8.4. Separar con ítems solo Llantas PW (PowerMax) con (**) ****/
                    if (detail.getItemName().substring(0, 4).equals("(**)")) {
                        detailSalesOrder_PW_desc.add(setDetailOrder(detail, ocrCode));
                    } else {
                        /**** 8.4.1. Separar con ítems solo Llantas PW (PowerMax) sin (**) ****/
                        detailSalesOrder_PW.add(setDetailOrder(detail, ocrCode));
                    }
                } else if (detail.getItemCode().substring(0, 1).equals("U")) {
                    /**** 8.5. Separar con ítems solo Llantas U (Donin) con (**) ****/
                    if (detail.getItemName().substring(0, 4).equals("(**)")) {
                        detailSalesOrder_U_desc.add(setDetailOrder(detail, ocrCode));
                    } else {
                        /**** 8.5.1. Separar con ítems solo Llantas U (Donin) sin (**) ****/
                        detailSalesOrder_U.add(setDetailOrder(detail, ocrCode));
                    }
                } else {
                    /**** 8.6. Separar con ítems solo Repuestos con (**) ****/
                    if (detail.getItemName().substring(0, 4).equals("(**)")) {
                        detailSalesOrder_REP_desc.add(setDetailOrder(detail, ocrCode));
                    } else {
                        /**** 8.6. Separar con ítems solo Repuestos sin (**) ****/
                        detailSalesOrder_REP.add(setDetailOrder(detail, ocrCode));
                    }
                }
            }
        }

        /**** 9.Crear ordenes sepradas por regla de negocio ****/
        if (detailSalesOrder_TY.size() > 0) {
            dto.setDetailSalesOrder(new ArrayList<>());
            dto.setDetailSalesOrder(detailSalesOrder_TY);
            dto.setNumAtCard(numAtCard + "TY");

            res = salesOrderEJB.createSalesOrder(dto);
            if (res.getCode() < 0) {
                ResponseDTO response = createOrderTemporary(dto, 0);

                gson = new Gson();
                json = gson.toJson(dto);
                CONSOLE.log(Level.INFO, json);
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items TY sin (**). Orden Temp={0}", response.getContent());
                res = response;
            }
        }
        if (detailSalesOrder_PW.size() > 0) {
            dto.setDetailSalesOrder(new ArrayList<>());
            dto.setDetailSalesOrder(detailSalesOrder_PW);
            dto.setNumAtCard(numAtCard + "PW");

            res = salesOrderEJB.createSalesOrder(dto);
            if (res.getCode() < 0) {
                ResponseDTO response = createOrderTemporary(dto, 0);

                gson = new Gson();
                json = gson.toJson(dto);
                CONSOLE.log(Level.INFO, json);
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items PW sin (**). Orden Temp={0}", response.getContent());
                res = response;
            }
        }
        if (detailSalesOrder_U.size() > 0) {
            dto.setDetailSalesOrder(new ArrayList<>());
            dto.setDetailSalesOrder(detailSalesOrder_U);
            dto.setNumAtCard(numAtCard + "U");

            res = salesOrderEJB.createSalesOrder(dto);
            if (res.getCode() < 0) {
                ResponseDTO response = createOrderTemporary(dto, 0);

                gson = new Gson();
                json = gson.toJson(dto);
                CONSOLE.log(Level.INFO, json);
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items PW sin (**). Orden Temp={0}", response.getContent());
                res = response;
            }
        }
        if (detailSalesOrder_REP.size() > 0) {
            /**** 9.1.Validar si los repuestos son de IGB y separar que es para modula y cedi ****/
            if (dto.getCompanyName().equals("IGB") && managerApplicationBean.obtenerValorPropiedad(Constants.BREAKER_MODULA).equals("false")) {
                dto.setDetailSalesOrder(new ArrayList<>());
                dto.setDetailSalesOrder(detailSalesOrder_REP);
                dto.setNumAtCard(numAtCard + "R");

                res = salesOrderEJB.createSalesOrder(dto);
                if (res.getCode() < 0) {
                    ResponseDTO response = createOrderTemporary(dto, 0);

                    gson = new Gson();
                    json = gson.toJson(dto);
                    CONSOLE.log(Level.INFO, json);
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items REPUESTOS sin (**). Orden Temp={0}", response.getContent());
                    res = response;
                }
            } else {
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
                        } else {
                            // llenamos detalle para enviar a cedi
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
                if (itemsMDL.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(itemsMDL);
                    dto.setNumAtCard(numAtCard + "M");
                    dto.setSerialMDL(serial);
                    /**** 10.1.Crear orden para el almacén 30-MODULA****/
                    res = salesOrderEJB.createSalesOrder(dto);

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
                                return Response.ok(new ResponseDTO(-1, "Ocurrio un error depositando orden de venta en modula.")).build();
                            }
                        }
                    } else {
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error creando la orden de venta en SAP de la bodega 30 Modula");
                        /**** 10.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                        return Response.ok(createOrderTemporary(dto, 0)).build();
                    }
                }

                /**** 11.Iniciar creación de pedido 01CEDI ****/
                if (itemsSAP.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(itemsSAP);
                    dto.setNumAtCard(numAtCard + "S");
                    dto.setSerialMDL(serial);
                    /**** 11.1.Crear orden para el almacén 01-CEDI****/
                    res = salesOrderEJB.createSalesOrder(dto);

                    if (res.getCode() == 0) {
                        /**** 11.1.1.Retornando el nro de documento creado****/
                        return Response.ok(res).build();
                    } else {
                        /**** 11.1.2.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
                        return Response.ok(createOrderTemporary(dto, 0)).build();
                    }
                } else {
                    /**** 11.2.Retornando el nro de documento creado****/
                    return Response.ok(res).build();
                }
            }
        }
        CONSOLE.log(Level.INFO, "Retornando ordenes creadas para la empresa [{0}]", dto.getCompanyName());
        return Response.ok(res).build();
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


    private ResponseDTO createOrderTemporary(SalesOrderDTO dto, long docNum) {
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

        return new ResponseDTO(0, order.getIdOrder());
    }
}
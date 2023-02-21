package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.persistence.facade.SalesPersonSAPFacade;
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
import java.util.ArrayList;
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
}
package co.manager.rest;

import co.manager.dto.CompanyDTO;
import co.manager.dto.CustomerDTO;
import co.manager.dto.LoginAppDTO;
import co.manager.dto.ResponseDTO;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.SalesPersonSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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

    @EJB
    private SalesPersonSAPFacade salesPersonSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;

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
}
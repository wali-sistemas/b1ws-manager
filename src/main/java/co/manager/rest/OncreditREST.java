package co.manager.rest;

import co.manager.dto.CustomerOncreditDTO;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.BasicFunctions;
import co.manager.ejb.BusinessPartnerEJB;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("oncredit")
public class OncreditREST {
    private static final Logger CONSOLE = Logger.getLogger(OncreditREST.class.getSimpleName());

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private BasicFunctions basicFunctions;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;

    @GET
    @Path("fetch-customer/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response fetchCustomer(@PathParam("companyname") String companyName,
                                  @QueryParam("cardcode") String cardCode,
                                  @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            CONSOLE.log(Level.INFO, "Iniciando busquedad de datos del cliente {0} para la compania {1}", new Object[]{cardCode, companyName});
            //Validar si ya existe el cliente y su estado en SAP.
            Object[] res = businessPartnerSAPFacade.findCustomer("C" + cardCode, companyName, false);
            if ((Boolean) res[0] && res[1].equals("Y")) {
                Object[] obj = businessPartnerSAPFacade.getCustomerDataOncredit("C" + cardCode, companyName, false);
                if (obj == null) {
                    CONSOLE.log(Level.WARNING, "No se encontraron datos para mostrar del cliente [C" + cardCode + "] en " + companyName + ".");
                    return Response.ok(new ResponseDTO(-1, "No se encontraron datos para mostrar.")).build();
                }
                CustomerOncreditDTO dtoCL = new CustomerOncreditDTO();
                dtoCL.setCompanyName(companyName);
                dtoCL.setIdTypeDoc((String) obj[0]);
                dtoCL.setTypeDoc((String) obj[1]);
                dtoCL.setDocIdent((String) obj[2]);
                dtoCL.setClAntg((String) obj[3]);
                dtoCL.setCardName((String) obj[4]);
                dtoCL.setCardCode(dtoCL.getDocIdent().substring(0, dtoCL.getDocIdent().length() - 2));
                dtoCL.setFirstName((String) obj[5]);
                dtoCL.setLastName1((String) obj[6]);
                dtoCL.setLastName2((String) obj[7]);
                dtoCL.setCellular((String) obj[8]);
                dtoCL.setEmail((String) obj[9]);
                dtoCL.setCodCity((String) obj[10]);
                dtoCL.setAddress((String) obj[11]);
                dtoCL.setCity((String) obj[12]);
                dtoCL.setDepart((String) obj[13]);
                dtoCL.setMunic((String) obj[14]);

                CustomerOncreditDTO.CustomerContactPersons dtoCD = new CustomerOncreditDTO.CustomerContactPersons();
                dtoCD.setIdTypeDoc((String) obj[15]);
                dtoCD.setDocIdent((String) obj[16]);
                dtoCD.setFirstName((String) obj[17]);
                dtoCD.setMiddleName((String) obj[18]);
                dtoCD.setLastName((String) obj[19]);
                dtoCD.setAddress((String) obj[20]);
                dtoCD.setCellular((String) obj[21]);
                dtoCD.setEmail((String) obj[22]);

                dtoCL.setCustomerContactPersons(dtoCD);

                CONSOLE.log(Level.INFO, "Retornando datos para cargar en el preformulario de oncredit del cliente {0} para la empresa {1}", new Object[]{cardCode, companyName});
                return Response.ok(new ResponseDTO(0, dtoCL)).build();
            } else if ((Boolean) res[0] && res[1].equals("N")) {
                CONSOLE.log(Level.WARNING, "Cliente inactivo [C" + cardCode + "] en " + companyName + ". Comunicate con el área de cartera.");
                return Response.ok(new ResponseDTO(-2, "Cliente inactivo. Comunícate con el área de cartera.")).build();
            } else {
                //cliente no existe.
                CONSOLE.log(Level.WARNING, "Nuevo cliente [C" + cardCode + "] en " + companyName + ".");
                return Response.ok(new ResponseDTO(-3, "Nuevo cliente. Completar los datos.")).build();
            }
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-4, "Token invalido para consumir servicio.")).build();
        }
    }

    @POST
    @Path("create-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(CustomerOncreditDTO dto,
                                   @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo cardCode es obligatorio.")).build();
            } else if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio");
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo empresa es obligatorio.")).build();
            }
            //Validar si ya existe el cliente y su estado en SAP.
            Object[] res = businessPartnerSAPFacade.findCustomer("C" + dto.getCardCode(), dto.getCompanyName(), false);
            if ((Boolean) res[0] && res[1].equals("Y")) {
                //Cliente activo y existente
                CONSOLE.log(Level.INFO, "El cliente ya está registrado en SAP con el id {0} C", dto.getCardCode());
                return Response.ok(new ResponseDTO(0, "El cliente ya está registrado en SAP con el id " + dto.getCardCode())).build();
            } else if ((Boolean) res[0] && res[1].equals("N")) {
                CONSOLE.log(Level.WARNING, "Cliente inactivo [C" + dto.getCardCode() + "] en " + dto.getCompanyName() + ". Contactar al área de cartera.");
                return Response.ok(new ResponseDTO(-2, "Cliente inactivo. Contactar al área de cartera.")).build();
            } else {
                //Verificar los datos obligatorios para registrar un nuevo cliente.
                if (dto.getTypeDoc() == null || dto.getTypeDoc().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo typeDoc es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo tipo de documento es obligatorio.")).build();
                } else if (dto.getFirstName() == null || dto.getFirstName().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo firstName es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo nombre es obligatorio.")).build();
                } else if (dto.getLastName1() == null || dto.getLastName1().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo lastName1 es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo primer apellido es obligatorio.")).build();
                } else if (dto.getLastName2() == null || dto.getLastName2().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo lastName2 es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo segundo apellido es obligatorio.")).build();
                } else if (dto.getCellular() == null || dto.getCellular().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cellular es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo número de celular es obligatorio.")).build();
                } else if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo email es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo correo electrónico es obligatorio.")).build();
                } else if (dto.getCodCity() == null || dto.getCodCity().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo codCity es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo código DANE ciudad es obligatorio.")).build();
                } else if (dto.getAddress() == null || dto.getAddress().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo address es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo dirección es obligatorio.")).build();
                } else if (dto.getCity() == null || dto.getCity().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo city es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo nombre de ciudad es obligatorio.")).build();
                } else if (dto.getDepart() == null || dto.getDepart().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo depart es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo nombre de departamento es obligatorio.")).build();
                } else if (dto.getMunic() == null || dto.getMunic().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo munic es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + ". Campo nombre de municipio es obligatorio.")).build();
                }
                CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en " + dto.getCompanyName(), dto.toString());

                Gson gson = new Gson();
                String json = gson.toJson(dto);
                CONSOLE.log(Level.INFO, json);

                return Response.ok(businessPartnerEJB.createBusinessPartnerFromOncredit(dto, basicFunctions.getDigitoDian(dto.getDocIdent()))).build();
            }
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-4, "Token invalido para consumir servicio.")).build();
        }
    }
}
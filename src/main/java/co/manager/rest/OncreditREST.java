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

    @POST
    @Path("create-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(CustomerOncreditDTO dto,
                                   @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            //Validar si ya existe el cliente y su estado en SAP.
            Object[] res = businessPartnerSAPFacade.findCustomer("C" + dto.getDocId(), dto.getCompanyName(), false);
            if ((Boolean) res[0] && res[1].equals("Y")) {
                //Cliente existente y activo. Retornar data.
                CONSOLE.log(Level.INFO, "El cliente ya existe en SAP con el id {0} C", dto.getDocId() + ". Retornando datos ya existente.");

                Object[] customer = businessPartnerSAPFacade.getCustomerDataOncretid('C' + dto.getDocId(), dto.companyName, false);
                CustomerOncreditDTO customerDTO = new CustomerOncreditDTO();
                customerDTO.setDocId((String) customer[0]);
                customerDTO.setTypeDoc((String) customer[2]);
                customerDTO.setFirstName((String) customer[3]);
                customerDTO.setMiddleName("");
                customerDTO.setFirstlastName((String) customer[4]);
                customerDTO.setMiddlelastName((String) customer[5]);
                customerDTO.setCellular((String) customer[6]);
                customerDTO.setEmail((String) customer[7]);
                customerDTO.setBirthDate((String) customer[8]);
                customerDTO.setGender("");
                customerDTO.setExpDocDate("");
                customerDTO.setPlaceExp("");
                customerDTO.setCompanyName(dto.companyName);
                customerDTO.setAge(0);

                return Response.ok(new ResponseDTO(0, customerDTO)).build();
            } else if ((Boolean) res[0] && res[1].equals("N")) {
                CONSOLE.log(Level.WARNING, "Cliente inactivo [C" + dto.getDocId() + "] en " + dto.getCompanyName() + ". Contactar al área de cartera.");
                return Response.ok(new ResponseDTO(-2, "Cliente inactivo. Contactar al área de cartera.")).build();
            } else {
                //Validar datos obligatorios para crear cliente no existente
                if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio");
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio.")).build();
                } else if (dto.getDocId() == null || dto.getDocId().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo docId es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo docId es obligatorio.")).build();
                } else if (dto.getTypeDoc() == null || dto.getTypeDoc().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo typeDoc es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo typeDoc es obligatorio.")).build();
                } else if (dto.getFirstName() == null || dto.getFirstName().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo firstName es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo firstName es obligatorio.")).build();
                } else if (dto.getFirstlastName() == null || dto.getFirstlastName().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo firstlastName es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo firstlastName es obligatorio.")).build();
                } else if (dto.getCellular() == null || dto.getCellular().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cellular es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo cellular es obligatorio.")).build();
                } else if (dto.getEmail() == null || dto.getEmail().isEmpty()) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo email es obligatorio", dto.getCompanyName());
                    return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo email es obligatorio.")).build();
                }
                CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en " + dto.getCompanyName(), dto.toString());

                Gson gson = new Gson();
                String json = gson.toJson(dto);
                CONSOLE.log(Level.INFO, json);

                return Response.ok(businessPartnerEJB.createBusinessPartnerFromOncredit(dto, basicFunctions.getDigitoDian(dto.getDocId()))).build();
            }
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }
}
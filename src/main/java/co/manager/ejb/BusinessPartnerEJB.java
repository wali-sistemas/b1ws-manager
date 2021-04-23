package co.manager.ejb;

import co.manager.dto.BusinessPartnerDTO;
import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.businessPartners.BusinessPartnersClient;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersRestDTO;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BusinessPartnerEJB {
    private static final Logger CONSOLE = Logger.getLogger(BusinessPartnerEJB.class.getSimpleName());
    private static final String taxCodeMotorepuesto = "IVAV01";
    private BusinessPartnersClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new BusinessPartnersClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de BusinessPartnersServiceLayer. ", e);
        }
    }

    public ResponseDTO createBusinessPartner(BusinessPartnerDTO dto) {
        String cardCode = "";
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                BusinessPartnersDTO businessPartner = new BusinessPartnersDTO();
                businessPartner.setCardCode(dto.getCardCode());
                businessPartner.setCardName(dto.getCardName().toUpperCase());
                businessPartner.setCardType("C");
                businessPartner.setFederalTaxID(dto.getLicTradNum());
                businessPartner.setProperties13(dto.getAcceptHabeasData());
                businessPartner.setGroupCode(114l);
                businessPartner.setPhone1(dto.getPhone());
                businessPartner.setCellular(dto.getCellular());
                businessPartner.setEmailAddress(dto.getMail().toUpperCase());
                businessPartner.setuManejo("DIA");
                businessPartner.setuDocFormEntFE(1l);
                businessPartner.setuAddInFaElectronicaEmailContactoFE(dto.getMail().toUpperCase());
                businessPartner.setuCelularFE(dto.getCellular());
                businessPartner.setUbpcortc("RS");
                businessPartner.setUbpcotdc("13");
                businessPartner.setUbpcotp("01");
                businessPartner.setUbpcocs(dto.getCodMunicipio());
                businessPartner.setUbpcoCity(dto.getCodMunicipio());
                businessPartner.setUbpcoNombre(dto.getFirstname().toUpperCase());
                businessPartner.setUbpco1Apellido(dto.getLastname1().toUpperCase());
                businessPartner.setUbpco2Apellido(dto.getLastname2().toUpperCase());
                businessPartner.setUbpcoAddress(dto.getAddress().toUpperCase());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    businessPartner.setUfeccrea(date2);
                } catch (Exception e) {
                }

                List<BusinessPartnersDTO.BPAddresses.BPAddress> addresses = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    BusinessPartnersDTO.BPAddresses.BPAddress address = new BusinessPartnersDTO.BPAddresses.BPAddress();
                    address.setAddressName("DIR WEB");
                    address.setStreet(dto.getAddress().toUpperCase());
                    address.setBlock("SABANETA");
                    address.setState(dto.getCodDepartamento());
                    address.setCountry("CO");

                    if (i == 0) {
                        address.setAddressType("bo_BillTo");
                    } else {
                        address.setAddressType("bo_ShipTo");
                        address.setTaxCode(taxCodeMotorepuesto);
                    }

                    address.setBpCode(dto.getCardCode());
                    address.setRowNum(0l);
                    address.setuMunicipio(dto.getCodMunicipio());
                    addresses.add(address);
                }
                businessPartner.setBpAddresses(addresses);

                CONSOLE.log(Level.INFO, "Iniciando creacion de socio de negocio para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(businessPartner);
                CONSOLE.log(Level.INFO, json);
                BusinessPartnersRestDTO res = service.addBusinessPartner(businessPartner, sessionId);
                cardCode = res.getCardCode();

                if (cardCode.isEmpty()) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el socio de negocios satisfactoriamente");
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el socio de negocio ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, cardCode);
    }
}
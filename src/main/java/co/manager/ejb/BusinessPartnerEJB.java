package co.manager.ejb;

import co.manager.b1ws.businessPartners.*;
import co.manager.dto.BusinessPartnerDTO;
import co.manager.dto.ResponseDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BusinessPartnerEJB {
    private static final Logger CONSOLE = Logger.getLogger(BusinessPartnerEJB.class.getSimpleName());
    private BusinessPartnersService service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new BusinessPartnersService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_BUSINESS_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de BusinessPartnersService. ", e);
        }
    }

    private String createBusinessPartnerDocument(BusinessPartner document, String sessionId) throws MalformedURLException {
        BusinessPartnersService service = new BusinessPartnersService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_BUSINESS_SERVICE)));
        Add add = new Add();
        add.setBusinessPartner(document);

        MsgHeader header = new MsgHeader();
        header.setServiceName("BusinessPartnersService");
        header.setSessionID(sessionId);

        CONSOLE.log(Level.INFO, "Creando socio de negocio en SAP con sessionId [{0}]", sessionId);

        AddResponse response = service.getBusinessPartnersServiceSoap12().add(add, header);
        String cardCode = response.getBusinessPartnerParams().getCardCode();
        CONSOLE.log(Level.INFO, "Socio de negocio creado con cardCode {0}", cardCode);
        return cardCode;
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
                BusinessPartner businessPartner = new BusinessPartner();

                businessPartner.setCardCode(dto.getCardCode());
                businessPartner.setCardName(dto.getCardName());
                businessPartner.setCardType("L");
                businessPartner.setFederalTaxID(dto.getLicTradNum());

                //campos de medios magneticos
                businessPartner.setUBPCORTC("RC");
                businessPartner.setUBPCOTDC("13");
                businessPartner.setUBPCOCS("05001");

                CONSOLE.log(Level.INFO, "Iniciando creacion de socio de negocio para {0}", dto.getCompanyName());
                cardCode = createBusinessPartnerDocument(businessPartner, sessionId);
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
package co.manager.ejb;

import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.purchaseInvoices.PurchaseInvoicesClient;
import co.manager.hanaws.dto.purchaseInvoice.PurchaseInvoicesDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class PurchaseInvoicesEJB {
    private static final Logger CONSOLE = Logger.getLogger(PurchaseInvoicesEJB.class.getSimpleName());
    private PurchaseInvoicesClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new PurchaseInvoicesClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de PurchaseInvoicesServiceLayer. ", e);
        }
    }

    public ResponseDTO createPurchaseInvoice(PurchaseInvoicesDTO dto, String companyName) {
        Long docEntry = 0l;
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(companyName);
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento


        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, docEntry);
    }
}
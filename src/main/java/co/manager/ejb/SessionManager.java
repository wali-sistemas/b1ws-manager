package co.manager.ejb;

import co.manager.hanaws.client.login.LoginClient;
import co.manager.hanaws.dto.login.LoginDTO;
import co.manager.hanaws.dto.login.LoginRestDTO;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author dbotero
 */
@Stateless
public class SessionManager implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(SessionManager.class.getSimpleName());
    private LoginClient service;

    @Inject
    private ManagerApplicationBean appBean;

    @PostConstruct
    private void initialize() {
        try {
            service = new LoginClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de LoginServiceLayer. ", e);
        }
    }

    public String login(String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando peticion se sessionId para {0}", companyName);
        try {
            LoginDTO dto = new LoginDTO(IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_COMPANY_DATABASE), companyName),
                    IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_COMPANY_PASSWORD), companyName),
                    IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(Constants.B1WS_COMPANY_USERNAME), companyName));

            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);

            LoginRestDTO res = service.getSessionId(dto);
            return res.getSessionId();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server. ", e);
            return null;
        }
    }

    public String logout(String sessionId) {
        CONSOLE.log(Level.INFO, "Iniciando cierre de sessionID ", sessionId);
        try {
            //pendiente duda para cerrar sessionId
            //service.closeSessionId(sessionId);
            CONSOLE.log(Level.INFO, "Sesion [{0}] DI Server finalizada con exito", sessionId);
            return "success";
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al finalizar la sesion en el DI Server " + sessionId, e);
            return "error";
        }
    }
}
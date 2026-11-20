package co.manager.novaws.ejb;

import co.manager.ejb.ManagerApplicationBean;
import co.manager.novaws.client.NovaClient;
import co.manager.novaws.dto.ItemRestDTO;
import co.manager.novaws.dto.LoginDTO;
import co.manager.novaws.dto.LoginRestDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class NovaEJB {
    private static final Logger CONSOLE = Logger.getLogger(NovaEJB.class.getSimpleName());
    private NovaClient service;

    @Inject
    private ManagerApplicationBean appBean;

    @PostConstruct
    private void initialize() {
        try {
            service = new NovaClient(appBean.obtenerValorPropiedad(Constants.SIIGO_URL));
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de Login en Siigo. ", e);
        }
    }

    public String createToken() {
        try {
            LoginDTO dto = new LoginDTO();
            dto.setUsername(appBean.obtenerValorPropiedad(Constants.SIIGO_USER_NAME));
            dto.setAccessKey(appBean.obtenerValorPropiedad(Constants.SIIGO_ACCESS_KEY));

            LoginRestDTO res = service.getSessionId(dto);
            return res.getAccessToken();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de Login [Siigo]. ", e);
        }
        return "";
    }

    public ItemRestDTO getItems() {
        String token = createToken();

        if (!token.isEmpty()) {
            try {
                return service.getItems(token, "wms");
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error creando la guia de transporte[Rapido-ochoa]", e);
            }
        }
        return null;
    }
}

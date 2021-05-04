package co.manager.ejb;

import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.item.ItemsClient;
import co.manager.hanaws.dto.item.ItemsDTO;
import co.manager.hanaws.dto.item.ItemsRestDTO;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemEJB {
    private static final Logger CONSOLE = Logger.getLogger(ItemEJB.class.getSimpleName());
    private ItemsClient service;
    @Inject
    private ManagerApplicationBean appBean;
    @Inject
    private SessionPoolManager sessionPoolManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new ItemsClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de ItemsServiceLayer. ", e);
        }
    }

    public ItemsRestDTO getMasterItem(String companyName, String item) {
        ResponseDTO res = null;
        ItemsRestDTO documento = new ItemsRestDTO();
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionPoolManager.getSession(companyName);
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return null;
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                documento = service.getItem(item, sessionId);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el item master. ", e);
            }
        }
        //3. Logout
        if (sessionId != null) {
            try {
                sessionPoolManager.returnSession(sessionId);
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            }
        }
        return documento;
    }

    public String addItem(ItemsDTO item, String companyName) {
        String itemCode = null;
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionPoolManager.getSession(companyName);
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return null;
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                Gson gson = new Gson();
                String json = gson.toJson(item);
                CONSOLE.log(Level.INFO, json);
                ItemsRestDTO res = service.addItem(item, sessionId);
                itemCode = res.getItemCode();
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el item master. ", e);
            }
        }
        //3. Logout
        if (sessionId != null) {
            try {
                sessionPoolManager.returnSession(sessionId);
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            }
        }
        return itemCode;
    }
}
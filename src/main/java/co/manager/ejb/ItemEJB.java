package co.manager.ejb;

import co.manager.b1ws.item.*;
import co.manager.dto.ResponseDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;

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
public class ItemEJB {
    private static final Logger CONSOLE = Logger.getLogger(ItemEJB.class.getSimpleName());
    private ItemsService service;

    @Inject
    private ManagerApplicationBean appBean;
    @Inject
    private SessionPoolManager sessionPoolManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new ItemsService(
                    new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ITEM_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de ItemsService. ", e);
        }
    }

    private String createItem(Item document, String sessionId) throws MalformedURLException {
        ItemsService service = new ItemsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ITEM_SERVICE)));
        Add add = new Add();
        add.setItem(document);

        MsgHeader header = new MsgHeader();
        header.setServiceName(Constants.B1WS_ITEM_SERVICE);
        header.setSessionID(sessionId);

        CONSOLE.log(Level.INFO, "Creando items en SAP con sessionId [{0}]", sessionId);

        AddResponse response = service.getItemsServiceSoap12().add(add, header);
        return response.getItemParams().getItemCode();
    }

    private Item findItem(String itemCode, String sessionId) throws MalformedURLException {
        ItemsService service = new ItemsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ITEM_SERVICE)));

        MsgHeader header = new MsgHeader();
        header.setServiceName(Constants.B1WS_ITEM_SERVICE);
        header.setSessionID(sessionId);

        ItemParams docParams = new ItemParams();
        docParams.setItemCode(itemCode);

        GetByParams params = new GetByParams();
        params.setItemParams(docParams);

        GetByParamsResponse response = service.getItemsServiceSoap12().getByParams(params, header);
        return response.getItem();
    }

    public Item getMasterItem(String companyName, String item) {
        ResponseDTO res = null;
        Item documento = new Item();
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionPoolManager.getSession(companyName);
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new Item();
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                documento = findItem(item, sessionId);
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

    public String addItem(Item item, String companyName) {
        ResponseDTO res = null;
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
                itemCode = createItem(item, sessionId);
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
package co.manager.ejb;

import co.manager.b1ws.item.*;
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

    @PostConstruct
    private void initialize() {
        try {
            service = new ItemsService(
                    new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ITEM_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de ItemsService. ", e);
        }
    }

    public Item findItem(String itemCode, String sessionId) throws MalformedURLException {
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
}
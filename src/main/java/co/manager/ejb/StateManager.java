package co.manager.ejb;

import co.manager.b1ws.state.*;
import co.manager.dto.ResponseDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class StateManager {
    private static final Logger CONSOLE = Logger.getLogger(StateManager.class.getSimpleName());
    private StatesService service;

    @Inject
    private ManagerApplicationBean appBean;

    @PostConstruct
    private void initialize() {
        try {
            service = new StatesService(
                    new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_STATE_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de StateService. ", e);
        }
    }

    public Response getState(String sessionId) {
        MsgHeader header = new MsgHeader();
        header.setSessionID(sessionId);
        header.setServiceName(Constants.B1WS_STATE_SERVICE);

        StateParams docParams = new StateParams();
        docParams.setCode("100");
        docParams.setCountry("BR");
        docParams.setName("EXTERIOR");

        GetState params = new GetState();
        params.setStateParams(docParams);

        try {
            GetStateResponse response = service.getStatesServiceSoap12().getState(params, header);
            return Response.ok(new ResponseDTO(response != null ? 0 : -1, response != null ? "OK" : "No se encontraron datos")).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el servicio state del B1WS. " + e);
            return null;
        }
    }
}
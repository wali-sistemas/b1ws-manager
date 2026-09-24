package co.manager.ejb;

import co.manager.dto.InventoryItemGenExitsDTO;
import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.InventoryGenExits.InventoryGenExitsClient;
import co.manager.hanaws.dto.InventoryGenExits.InventoryGenExitsDTO;
import co.manager.hanaws.dto.InventoryGenExits.InventoryGenExitsRestDTO;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;
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
public class InventoryGenExitsEJB {
    private static final Logger CONSOLE = Logger.getLogger(InventoryGenExitsEJB.class.getSimpleName());
    private InventoryGenExitsClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new InventoryGenExitsClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de InventoryGenExitsServiceLayer. ", e);
        }
    }

    public ResponseDTO createInventoryGenExitsService(InventoryItemGenExitsDTO dto) {
        long docNum = 0l;
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
                InventoryGenExitsDTO inventoryGenExits = new InventoryGenExitsDTO();
                inventoryGenExits.setSeries(Integer.parseInt(getPropertyValue("manager.inventoryGenExits.series", dto.getCompanyName())));
                inventoryGenExits.setReference2(dto.getCardCode());
                inventoryGenExits.setComments(dto.getComment());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    inventoryGenExits.setDocDate(date2);
                    inventoryGenExits.setDocDueDate(date2);
                } catch (Exception exception) {
                }

                List<InventoryGenExitsDTO.DocumentLine> lines = new ArrayList<>();
                for (InventoryItemGenExitsDTO.DocumentLines line : dto.getDocumentLines()) {
                    InventoryGenExitsDTO.DocumentLine inventoryGenExitsLine = new InventoryGenExitsDTO.DocumentLine();
                    inventoryGenExitsLine.setItemCode(line.getItemCode());
                    inventoryGenExitsLine.setQuantity(line.getQuantity());
                    inventoryGenExitsLine.setWarehouseCode(line.getWhsCode());
                    lines.add(inventoryGenExitsLine);
                }
                inventoryGenExits.setDocumentLines(lines);

                CONSOLE.log(Level.INFO, "Iniciando creacion de salida de mercancia para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(inventoryGenExits);
                CONSOLE.log(Level.INFO, json);

                InventoryGenExitsRestDTO res = service.addInventoryGenExits(inventoryGenExits, sessionId);
                docNum = res.getDocNum();

                if (docNum <= 0L) {
                    CONSOLE.log(Level.WARNING, "Ocurrio un problema al crear la salida de mercancia");
                    return new ResponseDTO(-1, "Ocurrio un problema al crear la salida de mercancia.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo la salida de mercancia #{0} satisfactoriamente", res.getDocNum());
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la salida de mercancia. ", e);
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
        return new ResponseDTO(0, docNum);
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(propertyName), companyName);
    }
}

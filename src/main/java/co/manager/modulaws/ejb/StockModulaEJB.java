package co.manager.modulaws.ejb;

import co.manager.modulaws.client.StockClient;
import co.manager.modulaws.dto.item.StockRestDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class StockModulaEJB {
    private static final Logger CONSOLE = Logger.getLogger(StockModulaEJB.class.getSimpleName());
    private StockClient service;

    @PostConstruct
    private void initialize() {
        try {
            service = new StockClient(Constants.MODULAWS_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de modula [CFG-EXP-GIACENZE]. ", e);
        }
    }

    public StockRestDTO getStock() {
        StockRestDTO documento = new StockRestDTO();
        try {
            documento = service.getStock();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la respuesta de la instancia [CFG-EXP-GIACENZE]", e);
            return null;
        }
        return documento;
    }
}
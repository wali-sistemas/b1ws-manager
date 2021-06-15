package co.manager.modulaws.ejb;

import co.manager.modulaws.client.ItemClient;
import co.manager.modulaws.dto.item.ItemModulaDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemModulaEJB {
    private static final Logger CONSOLE = Logger.getLogger(ItemModulaEJB.class.getSimpleName());
    private ItemClient service;

    @PostConstruct
    private void initialize() {
        try {
            service = new ItemClient(Constants.MODULAWS_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de modula [CFG-IMP-ARTICOLI]. ", e);
        }
    }

    public String addItem(ItemModulaDTO dto) {
        try {
            return service.addItem(dto);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la respuesta de la instancia [CFG-IMP-ARTICOLI].");
            return null;
        }
    }
}
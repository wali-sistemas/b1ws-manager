package co.manager.modulaws.ejb;

import co.manager.modulaws.client.OrderClient;
import co.manager.modulaws.dto.order.OrderModulaRestDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OrderModulaEJB {
    private static final Logger CONSOLE = Logger.getLogger(OrderModulaEJB.class.getSimpleName());
    private OrderClient service;

    @PostConstruct
    private void initialize() {
        try {
            service = new OrderClient(Constants.MODULAWS_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de modula [CFG-IMP-ORDINI]. ", e);
        }
    }

    public String addOrdine(OrderModulaRestDTO.Header dto) {
        try {
            return service.addOrdine(dto);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la respuesta de la instancia [CFG-IMP-ORDINI]" , e);
            return null;
        }
    }
}
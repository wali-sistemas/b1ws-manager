package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderPedbox;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OrderPedboxFacade {
    private static final Logger CONSOLE = Logger.getLogger(OrderPedbox.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(OrderPedbox orderPedbox, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(orderPedbox);
    }

    public OrderPedbox find(long idOrder, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(OrderPedbox.class, idOrder);
    }
}
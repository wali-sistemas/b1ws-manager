package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderDetailAPP;
import co.manager.persistence.entity.OrderDetailPedbox;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OrderDetailAPPFacade {
    private static final Logger CONSOLE = Logger.getLogger(OrderDetailAPP.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(OrderDetailAPP OrderDetailAPP, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(OrderDetailAPP);
    }

    public OrderDetailAPP find(String itemCode, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(OrderDetailAPP.class, itemCode);
    }
}
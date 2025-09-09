package co.manager.persistence.facade;

import co.manager.persistence.entity.ItemSoldOutAPP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemSoldOutAPPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSoldOutAPPFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public ItemSoldOutAPPFacade() {
    }

    public void create(ItemSoldOutAPP itemSoldOutAPP, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(itemSoldOutAPP);
    }
}
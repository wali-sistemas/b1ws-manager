package co.manager.persistence.facade;

import co.manager.persistence.entity.ItemModula;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemModulaFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemModula.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(ItemModula itemModula, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(itemModula);
    }

    public ItemModula find(String itemCode, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(ItemModula.class, itemCode);
    }

    public void remove(String itemModula, String companyName, boolean testing) {
        ItemModula entity = find(itemModula, companyName, testing);
        if (entity != null) {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).remove(entity);
        }
    }
}
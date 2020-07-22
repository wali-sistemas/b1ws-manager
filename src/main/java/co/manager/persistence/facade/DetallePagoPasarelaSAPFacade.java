package co.manager.persistence.facade;

import co.manager.persistence.entity.DetallePagoPasarelaSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class DetallePagoPasarelaSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(DetallePagoPasarelaSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(DetallePagoPasarelaSAP detallePagoPasarelaSAP, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE).persist(detallePagoPasarelaSAP);
    }
}
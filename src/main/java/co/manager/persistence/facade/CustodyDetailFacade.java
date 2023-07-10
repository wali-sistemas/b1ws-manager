package co.manager.persistence.facade;

import co.manager.persistence.entity.CustodyDetail;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class CustodyDetailFacade {
    private static final Logger CONSOLE = Logger.getLogger(CustodyDetailFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(CustodyDetail custodyDetail, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(custodyDetail);
    }

    public void remove(CustodyDetail custodyDetail, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).remove(custodyDetail);
    }

    public void find(String idCustody, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(CustodyDetail.class, idCustody);
    }
}
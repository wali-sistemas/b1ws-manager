package co.manager.persistence.facade;

import co.manager.persistence.entity.AssetMasterData;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class AssetMasterDataFacade {
    private static final Logger CONSOLE = Logger.getLogger(AssetMasterData.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(AssetMasterData assetMasterData, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(assetMasterData);
    }

    public void find(String idAsset, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(AssetMasterData.class, idAsset);
    }
}

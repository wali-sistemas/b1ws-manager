package co.manager.persistence.facade;

import co.manager.persistence.entity.AssetMasterData;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.logging.Level;
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

    public Object[] findAsset(String idAsset, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.idAsset as varchar(50))as idAsset,cast(a.type as varchar(max))as type,cast(a.brand as varchar(max))as brand, ");
        sb.append(" cast(a.reference as varchar(max))as reference,cast(a.serial as varchar(max))as serial,cast(a.company as varchar(20))as company, ");
        sb.append(" cast(a.datePurchase as date)as datePurchase,cast(a.ccosto as int)as ccosto,cast(a.status as varchar(1))as status,cast(a.comment as text)as comment, ");
        sb.append(" cast(a.pictureAssetUrl as varchar(max))as pictureAssetUrl,cast(e.cardCode as varchar(20))as cardCode,cast(e.cardName as varchar(100))as cardName ");
        sb.append("from asset_master_data a ");
        sb.append("left join custody_detail c on c.idAsset=a.idAsset ");
        sb.append("left join employee e on e.cardCode=c.cardCode ");
        sb.append("where a.idAsset='");
        sb.append(idAsset);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los datos del activo fijo - " + idAsset, e);
        }
        return new Object[]{};
    }
}
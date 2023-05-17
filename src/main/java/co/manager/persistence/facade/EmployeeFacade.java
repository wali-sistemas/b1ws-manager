package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class EmployeeFacade {
    private static final Logger CONSOLE = Logger.getLogger(EmployeeFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listCustodyByEmplee(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.cardCode as varchar)as cardCode,cast(e.cardName as varchar)as cardName,cast(e.department as varchar)as depart, ");
        sb.append(" cast(e.company as varchar)as company,cast(e.ccosto as int)as ccEmpl, cast(e.status as varchar)as statusEmp,cast(c.idAsset as varchar)as id, ");
        sb.append(" cast(c.dateAssign as date)as dateAssign,cast(c.dateFinish as date)as dateFinish,cast(c.status as varchar)as statusDet, ");
        sb.append(" cast(c.userAssign as varchar)as userAssign,cast(c.userFinish as varchar)as userFinish,cast(a.type as varchar)as type, ");
        sb.append(" cast(a.brand as varchar)as brand,cast(a.reference as varchar)as referencia,cast(a.serial as varchar)as serial, ");
        sb.append(" cast(a.company as varchar)as companyPurchase,cast(a.datePurchase as date)as datePurchase,cast(a.ccosto as int)as ccAsset, ");
        sb.append(" cast(a.status as varchar)as statusAsset,cast(a.comment as varchar)as comment,cast(a.pictureAssetUrl as varchar(max))as pictAsset ");
        sb.append("from employee e ");
        sb.append("inner join custody_detail c on c.cardCode=e.cardCode ");
        sb.append("inner join asset_master_data a on a.idAsset=c.idAsset ");
        sb.append("where e.cardCode='");
        sb.append(cardCode);
        sb.append("' and e.status='Y'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las custodias asignadas el empleado " + cardCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
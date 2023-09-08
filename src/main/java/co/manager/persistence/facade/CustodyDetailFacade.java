package co.manager.persistence.facade;

import co.manager.persistence.entity.CustodyDetail;
import co.manager.persistence.entity.CustodyDetail_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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

    public List<String> listCustodyDetailByAsset(String idAsset, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(idCustody as varchar)as id ");
        sb.append("from custody_detail ");
        sb.append("where status='Y' and idAsset='");
        sb.append(idAsset);
        sb.append("'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle de las custodias del activo " + idAsset, e);
        }
        return new ArrayList<>();
    }

    public boolean updateCustodyDetailByAsset(String idCustody, String status, String employee, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<CustodyDetail> cu = cb.createCriteriaUpdate(CustodyDetail.class);
        Root<CustodyDetail> root = cu.from(CustodyDetail.class);
        cu.set(root.get(CustodyDetail_.status), status);
        cu.set(root.get(CustodyDetail_.dateFinish), new Date());
        cu.set(root.get(CustodyDetail_.userFinish), employee);
        cu.where(cb.equal(root.get(CustodyDetail_.idCustody), idCustody));
        try {
            int rows = em.createQuery(cu).executeUpdate();
            if (rows == 1) {
                return true;
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar los datos del detalle de las custodias ", e);
        }
        return false;
    }
}
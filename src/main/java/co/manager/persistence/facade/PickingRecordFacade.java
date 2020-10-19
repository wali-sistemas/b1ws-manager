package co.manager.persistence.facade;

import co.manager.persistence.entity.PickingRecord;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class PickingRecordFacade {

    private static final Logger CONSOLE = Logger.getLogger(PickingRecordFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public PickingRecordFacade() {
    }

    public List<Object[]> findTemporaryRecords(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select idpicking_record, expires from picking_record where company_name = '");
        sb.append(companyName);
        sb.append("' and expires is not null");
        try {
            return (List<Object[]>) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los registros de picking temporales. ", e);
        }
        return new ArrayList<>();
    }

    public void deleteExpiredRecords(List<Integer> recordIds, String companyName, boolean testing) {
        CriteriaBuilder cb = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).getCriteriaBuilder();
        CriteriaDelete<PickingRecord> cd = cb.createCriteriaDelete(PickingRecord.class);
        Root<PickingRecord> root = cd.from(PickingRecord.class);
        cd.where(root.get("id").in(recordIds));
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createQuery(cd).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al eliminar los picking records vencidos. ", e);
        }
    }
}
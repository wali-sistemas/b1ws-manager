package co.manager.persistence.facade;

import co.manager.persistence.entity.SalesPersonSAP;
import co.manager.persistence.entity.SalesPersonSAP_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class SalesPersonSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(SalesPersonSAP.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public SalesPersonSAPFacade() {
    }

    public String getCentroCosto(Long slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<String> cq = cb.createQuery(String.class);
        Root<SalesPersonSAP> sales = cq.from(SalesPersonSAP.class);
        cq.select(sales.get(SalesPersonSAP_.uCentroCosto));
        cq.where(cb.equal(sales.get(SalesPersonSAP_.slpCode), slpCode));

        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el centro de costo para el vendedor " + slpCode.toString(), e.getMessage());
        }
        return "";
    }
}
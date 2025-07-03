package co.manager.persistence.facade;

import co.manager.persistence.entity.AssociatedFEMPRO;
import co.manager.persistence.entity.AssociatedFEMPRO_;
import co.manager.persistence.entity.TicketTI;
import co.manager.persistence.entity.TicketTI_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class AssociatedFEMPROFacade {
    private static final Logger CONSOLE = Logger.getLogger(AssociatedFEMPROFacade.class.getSimpleName());
    private static final String DB_TYPE_NOVAWEB = Constants.DATABASE_TYPE_NOVAWEB;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(AssociatedFEMPRO entity, String companyName, boolean testing) {
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).persist(entity);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el asociado: " + entity, e);
            throw e;
        }
    }

    public AssociatedFEMPRO find(Integer idAssociate, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).find(AssociatedFEMPRO.class, idAssociate);
    }

    public List<AssociatedFEMPRO> listAssociatedRequestsByStatus(String status, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AssociatedFEMPRO> cq = cb.createQuery(AssociatedFEMPRO.class);
        Root<AssociatedFEMPRO> root = cq.from(AssociatedFEMPRO.class);
        cq.where(cb.equal(root.get(AssociatedFEMPRO_.estAso), status));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las solicitudes de los asociados en estado [" + status + "]", e);
        }
        return new ArrayList<>();
    }
}
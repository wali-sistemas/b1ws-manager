package co.manager.persistence.facade;

import co.manager.persistence.entity.AssociatedFEMPRO;
import co.manager.persistence.entity.AssociatedFEMPRO_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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

    public AssociatedFEMPRO find(Integer idAssociated, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).find(AssociatedFEMPRO.class, idAssociated);
    }

    public AssociatedFEMPRO getAssociatedByCode(String codeAssociated, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AssociatedFEMPRO> cq = cb.createQuery(AssociatedFEMPRO.class);
        Root<AssociatedFEMPRO> root = cq.from(AssociatedFEMPRO.class);
        cq.where(cb.equal(root.get(AssociatedFEMPRO_.codAso), codeAssociated));
        try {
            return em.createQuery(cq).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los datos del asociado [" + codeAssociated + "]", e);
        }
        return new AssociatedFEMPRO();
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

    public void updateStatusRequestsByAssociated(String codAssociated, String status, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<AssociatedFEMPRO> cu = cb.createCriteriaUpdate(AssociatedFEMPRO.class);
        Root<AssociatedFEMPRO> root = cu.from(AssociatedFEMPRO.class);
        cu.set(root.get(AssociatedFEMPRO_.estAso), status);
        cu.where(cb.equal(root.get(AssociatedFEMPRO_.codAso), codAssociated));
        try {
            em.createQuery(cu).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el estado de la solicitud para el asociado " + codAssociated, e);
        }
    }
}
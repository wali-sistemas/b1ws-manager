package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderPedbox;
import co.manager.persistence.entity.OrderPedbox_;
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
public class OrderPedboxFacade {
    private static final Logger CONSOLE = Logger.getLogger(OrderPedbox.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(OrderPedbox orderPedbox, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(orderPedbox);
    }

    public OrderPedbox find(long idOrder, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(OrderPedbox.class, idOrder);
    }

    public List<Object[]> listOrderPendingBySales(long slpCode, long year, long month, long day, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<OrderPedbox> root = cq.from(OrderPedbox.class);
        Selection<Object[]> selection = cb.array(root.get(OrderPedbox_.idOrder), root.get(OrderPedbox_.docNum), root.get(OrderPedbox_.cardCode),
                root.get(OrderPedbox_.docDate), root.get(OrderPedbox_.docTotal), root.get(OrderPedbox_.comments));
        cq.select(selection);
        Predicate predSlpCode = cb.equal(root.get(OrderPedbox_.slpCode), slpCode);
        Predicate predStatus = cb.equal(root.get(OrderPedbox_.status), "F");
        Predicate predYear = cb.equal(cb.function("YEAR", Integer.class, root.get(OrderPedbox_.docDate)), year);
        Predicate predMonth = cb.equal(cb.function("MONTH", Integer.class, root.get(OrderPedbox_.docDate)), month);
        Predicate predDay = cb.equal(cb.function("DAY", Integer.class, root.get(OrderPedbox_.docDate)), day);
        Predicate predCompanyName = cb.equal(root.get(OrderPedbox_.companyName), companyName);
        cq.where(cb.and(predSlpCode, predStatus, predYear, predMonth, predDay, predCompanyName));
        try {
            return em.createQuery(cq).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes de venta para el asesor [" + slpCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
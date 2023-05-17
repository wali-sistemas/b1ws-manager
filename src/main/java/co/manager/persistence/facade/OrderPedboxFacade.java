package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderPedbox;
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
        StringBuilder sb = new StringBuilder();
        sb.append("select cast (cardCode as varchar (20))as cardCode,cast(docDate as date) as docDate,cast(docTotal as numeric(18, 2)) as docTotal, ");
        sb.append(" cast(comments as varchar(500)) as comments,cast(idOrder as int)as docEntry, cast(docNum as int)as docNum ");
        sb.append("from order_pedbox ");
        sb.append("where slpCode=");
        sb.append(slpCode);
        sb.append(" and year(docDate)=");
        sb.append(year);
        sb.append(" and month(docDate)=");
        sb.append(month);
        sb.append(" and day(docDate)=");
        sb.append(day);
        sb.append(" and status='F' order by docDate asc,docNum desc");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes de venta para el asesor [" + slpCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
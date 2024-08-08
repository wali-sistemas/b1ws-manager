package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderAPP;
import co.manager.persistence.entity.OrderAPP_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OrderAPPFacade {
    private static final Logger CONSOLE = Logger.getLogger(OrderAPP.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(OrderAPP orderAPP, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(orderAPP);
    }

    public OrderAPP find(long idOrder, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(OrderAPP.class, idOrder);
    }

    public List<Object[]> listOrderSaves(long slpCode, long year, long month, long day, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.idOrder as int)as id,cast(e.docNum as int)as docNum,cast(e.docDate as datetime)as docDate,cast(e.cardCode as varchar(50))as cardCode, ");
        sb.append(" cast(e.cardName as varchar(100))as cardName,cast(e.numAtCard as varchar(50))as numAtCard,cast(e.shipToCode as varchar(100))as shipToCode, ");
        sb.append(" cast(e.payToCode as varchar(100))as payToCode,cast(e.comments as varchar(250))as comments,cast(e.slpCode as varchar(4))as slpCode,cast(e.status as varchar(2))as status, ");
        sb.append(" cast(e.companyName as varchar(50))as companyName,cast(e.discountPercent as numeric(18,0))as discountPercent,cast(e.docTotal as numeric(18,0))as docTotal, ");
        sb.append(" cast(e.lineNum as varchar(100))as lineNum,cast(d.idOrder as int)as idDet,cast(d.idOrderDetail as int)as idDetail,cast(d.itemCode as varchar(20))as itemCode, ");
        sb.append(" cast(d.itemName as varchar(100))as itemName,cast(d.[group] as varchar(100))as groupItem,cast(d.presentation as varchar(100))as presentation,cast(d.whsCode as varchar(10))as whsCode, ");
        sb.append(" cast(d.price as numeric(18,0))as price,cast(d.discountItem as numeric(18,0))as discountItem,cast(d.discountPorc as numeric(18,0))as discountPorc, ");
        sb.append(" cast(d.iva as numeric(18,0))as iva,cast(d.qtyAPP as int)as qtyAPP,cast(d.qtyMDL as int)as qtyMDL,cast(d.qtySAP as int)as qtySAP,cast(d.qtySBT as int)as qtySBT ");
        sb.append("from order_app e ");
        sb.append("inner join order_detail_app d on e.idOrder=d.idOrder ");
        sb.append("where e.status='G' and year(e.docDate)=");
        sb.append(year);
        sb.append(" and month(e.docDate)=");
        sb.append(month);
        sb.append(" and day(e.docDate)=");
        sb.append(day);
        sb.append(" and e.slpCode=");
        sb.append(slpCode);
        sb.append(" and companyName='");
        sb.append(companyName);
        sb.append("'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes guardadas para el asesor [" + slpCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public boolean updateStatusOrderSaves(long idOrder, String status, Integer docNum, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema("", testing, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<OrderAPP> cu = cb.createCriteriaUpdate(OrderAPP.class);
        Root<OrderAPP> root = cu.from(OrderAPP.class);
        cu.set(root.get(OrderAPP_.status), status);
        cu.set(root.get(OrderAPP_.docNum), docNum);
        cu.where(cb.and(cb.equal(root.get(OrderAPP_.idOrder), idOrder), cb.equal(root.get(OrderAPP_.companyName), companyName)));
        try {
            int row = em.createQuery(cu).executeUpdate();
            if (row == 1) {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando la orden guardada. ", e);
        }
        return false;
    }

    public List<Object[]> listOutStockItems(Long idOrden, String numAtCard, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(d.itemCode as varchar(20))as itemCode,cast(d.qtyAPP as int)as qtyOrder, ");
        if (numAtCard.charAt(numAtCard.length() - 1) == 'M') {
            sb.append(" case when d.qtyMDL<0 then 0 else cast(d.qtyMDL as int) end as qtyMDL ");
        } else {
            sb.append(" case when d.qtySAP<0 then 0 else cast(d.qtySAP as int) end as qtySAP ");
        }
        sb.append("from order_pedbox e ");
        sb.append("inner join order_detail_pedbox d on e.idOrder=d.idOrder ");
        sb.append("where e.companyName='IGB' and e.idOrder=");
        sb.append(idOrden);
        if (numAtCard.charAt(numAtCard.length() - 1) == 'M') {
            sb.append(" and d.qtyAPP>d.qtyMDL ");
        } else {
            sb.append(" and d.qtyAPP>d.qtySAP ");
        }
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los items agotados para el idOrder=" + idOrden + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object> listSavedOrderByMarkedDays(String slpCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(docDate as datetime)as docDate ");
        sb.append("from order_app ");
        sb.append("where status='G' and companyName='");
        sb.append(companyName);
        sb.append("' and slpCode=");
        sb.append(slpCode);
        sb.append("order by docDate asc");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes guardadas marcadas por dias del asesor " + slpCode, e);
        }
        return new ArrayList<>();
    }

    public Object[] getSavedOrdersReportBySeller(String slpCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(count(idOrder)as int)as nroPedG,cast(sum(docTotal)as numeric(18,2))as totalPedG ");
        sb.append("from order_app ");
        sb.append("where companyName='");
        sb.append(companyName);
        sb.append("' and status='G' and year(docDate)=year(GETDATE()) and slpCode=");
        sb.append(slpCode);
        sb.append(" group by slpCode ");
        sb.append("order by sum(docTotal) desc ");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo el reporte de ordenes guardadas para el asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }
}
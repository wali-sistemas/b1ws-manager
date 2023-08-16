package co.manager.persistence.facade;

import co.manager.persistence.entity.OrderAPP;
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
        sb.append("select cast(e.idOrder as int)as id,cast(e.docNum as int)as docNum,cast(e.docDate as date)as docDate,cast(e.cardCode as varchar(50))as cardCode, ");
        sb.append(" cast(e.cardName as varchar(100))as cardName,cast(e.numAtCard as varchar(50))as numAtCard,cast(e.shipToCode as varchar(100))as shipToCode, ");
        sb.append(" cast(e.payToCode as varchar(100))as payToCode,cast(e.comments as varchar(250))as comments,cast(e.slpCode as varchar(4))as slpCode,cast(e.status as varchar(2))as status, ");
        sb.append(" cast(e.companyName as varchar(50))as companyName,cast(e.discountPercent as numeric(18,0))as discountPercent,cast(e.docTotal as numeric(18,0))as docTotal, ");
        sb.append(" cast(e.lineNum as varchar(100))as lineNum,cast(d.idOrder as int)as idDet,cast(d.idOrderDetail as int)as idDetail,cast(d.itemCode as varchar(20))as itemCode, ");
        sb.append(" cast(d.itemName as varchar(20))as itemName,cast(d.[group] as varchar(100))as groupItem,cast(d.presentation as varchar(100))as presentation,cast(d.whsCode as varchar(10))as whsCode, ");
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
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes guardadas para el asesor [" + slpCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
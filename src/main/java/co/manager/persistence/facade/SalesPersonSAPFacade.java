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
import java.util.List;
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

    public List<Object[]> getSaleBudgetBySeller(String slpCode, Integer year, String month, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.SlpCode as varchar(10))as Asesor,cast(year(p.U_ANO_PRES)as int)as Ano,cast(p.U_MES_PRES as varchar(2))as Mes, ");
        sb.append(" isnull(sum(t.Ventas)-sum(t.Devoluciones),0)as VentasNetas,cast(p.U_VALOR_PRES as numeric(18,2))as Presupuesto, ");
        sb.append(" isnull((select sum(cast(DocTotal-VatSum-TotalExpns+WTSum as numeric(18,2)))as Pendiente from ORDR where DocStatus='O' and year(DocDate)=p.U_ANO_PRES and SlpCode=t.Asesor and month(DocDate)=p.U_MES_PRES),0)as Pendiente ");
        sb.append("from  [@PRES_ZONA_VEND] p ");
        sb.append("inner join OSLP a on p.U_VEND_PRES=a.SlpName ");
        sb.append("left  join (select cast(f.SlpCode as varchar(10))as Asesor,cast(sum(f.DocTotal-f.VatSum-f.TotalExpns+f.WTSum)as numeric(18,2))as Ventas,0 as Devoluciones ");
        sb.append("  from  OINV f ");
        sb.append("  where f.DocType='I' and year(f.DocDate)='");
        sb.append(year);
        sb.append("' and month(f.DocDate)='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and f.SlpCode='");
            sb.append(slpCode);
        }

        sb.append("' group by year(f.DocDate),month(f.DocDate),f.SlpCode ");
        sb.append("union all ");
        sb.append("  select cast(n.SlpCode as varchar(10))as Asesor,0 as Ventas,cast(sum(n.DocTotal-n.VatSum-n.TotalExpns+n.WTSum)as numeric(18,2))as Devoluciones ");
        sb.append("  from  ORIN n ");
        sb.append("  where n.DocType='I' and year(n.DocDate)='");
        sb.append(year);
        sb.append("' and month(n.DocDate)='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and n.SlpCode='");
            sb.append(slpCode);
        }

        sb.append("' group by year(n.DocDate),month(n.DocDate),n.SlpCode)as t on a.SlpCode=t.Asesor ");
        sb.append("where p.U_ANO_PRES='");
        sb.append(year);
        sb.append("' and p.U_MES_PRES='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and a.SlpCode='");
            sb.append(slpCode);
        }

        sb.append("' group by p.U_VALOR_PRES,a.SlpCode,t.Asesor,p.U_ANO_PRES,p.U_MES_PRES ");
        sb.append("order by a.SlpCode");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el presupuesto para el asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }
}
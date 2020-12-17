package co.manager.persistence.facade;

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
public class InvoiceSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(InvoiceSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listInvoicesHistoryByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(f.DocNum as int)as DocNum, cast(f.DocDate as date)as DocDate, ");
        sb.append("      cast((select sum(d.LineTotal) from INV1 d where d.DocEntry = f.DocEntry) as numeric(18,2))as SubTotal, ");
        sb.append("      cast(f.DiscPrcnt as int)as PorcDesc, cast(f.DiscSum as numeric(18,2))as Descuento, ");
        sb.append("      cast(f.VatSum as numeric(18,2))as Iva, cast(f.DocTotal as numeric(18,2))as DocTotal, ");
        sb.append("      cast(f.U_addInFE_LinkFE as varchar(max))as UrlFacture ");
        sb.append("from  OINV f ");
        sb.append("where cast(f.DocDate as date) between cast(DATEADD(MM,-3,GETDATE())as date) and cast(GETDATE() as date) and f.DocType = 'I' and f.CardCode = '");
        sb.append(cardCode);
        sb.append("' order by f.DocDate DESC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las facturas historicas para el cliente [" + cardCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> getSaleBudgetBySeller(String slpCode, Integer year, String month, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Ano,t.Mes,sum(t.Ventas)-sum(t.Devoluciones)as VentasNetas,cast(p.U_VALOR_PRES as numeric(18,2))as Presupuesto ");
        sb.append("from ( ");
        sb.append(" select cast(year(f.DocDate)as int)as Ano,cast(month(f.DocDate)as varchar(2))as Mes,cast(f.SlpCode as varchar(10))as Asesor,");
        sb.append("  cast(sum(f.DocTotal-f.VatSum-f.TotalExpns+f.WTSum)as numeric(18,2))as Ventas,0 as Devoluciones ");
        sb.append(" from  OINV f ");
        sb.append(" where f.DocType='I' and year(f.DocDate)='");
        sb.append(year);
        sb.append("' and month(f.DocDate)='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and f.SlpCode='");
            sb.append(slpCode);
        }

        sb.append("' group by year(f.DocDate),month(f.DocDate),f.SlpCode ");
        sb.append("union all ");
        sb.append(" select cast(year(n.DocDate)as int)as Ano,cast(month(n.DocDate)as varchar(2))as Mes,cast(n.SlpCode as varchar(10))as Asesor, ");
        sb.append("  0 as Ventas,cast(sum(n.DocTotal-n.VatSum-n.TotalExpns+n.WTSum)as numeric(18,2))as Devoluciones ");
        sb.append(" from  ORIN n ");
        sb.append(" where n.DocType='I' and year(n.DocDate)='");
        sb.append(year);
        sb.append("' and month(n.DocDate)='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and n.SlpCode='");
            sb.append(slpCode);
        }

        sb.append("' group by year(n.DocDate),month(n.DocDate),n.SlpCode ");
        sb.append(")as t ");
        sb.append("inner join OSLP a on a.SlpCode=t.Asesor ");
        sb.append("left  join [@PRES_ZONA_VEND] p on p.U_VEND_PRES=a.SlpName ");
        sb.append("where p.U_MES_PRES='");
        sb.append(month);
        sb.append("' group by t.Ano,t.Mes,p.U_VALOR_PRES,t.Asesor");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el presupuesto para el asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }
}
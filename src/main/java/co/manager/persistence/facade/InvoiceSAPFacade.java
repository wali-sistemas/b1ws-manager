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
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listInvoicesHistoryByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(f.\"DocNum\" as int)as DocNum, cast(f.\"DocDate\" as date)as DocDate, ");
        sb.append("      cast((select sum(d.\"LineTotal\") from INV1 d where d.\"DocEntry\" = f.\"DocEntry\") as numeric(18,2))as SubTotal, ");
        sb.append("      cast(f.\"DiscPrcnt\" as int)as PorcDesc, cast(f.\"DiscSum\" as numeric(18,2))as Descuento, ");
        sb.append("      cast(f.\"VatSum\" as numeric(18,2))as Iva, cast(f.\"DocTotal\" as numeric(18,2))as DocTotal, ");
        sb.append("      cast(f.\"U_addInFE_LinkFE\" as varchar(1000))as UrlFacturem ");
        sb.append("from  OINV f ");
        sb.append("where f.\"DocDate\" between ADD_MONTHS(TO_DATE(current_date,'YYYY-MM-DD'),-6) and current_date and f.\"DocType\"='I' and f.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("' order by f.\"DocDate\" DESC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las facturas historicas para el cliente [" + cardCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public String getDocEntry(Long docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"DocEntry\" as varchar)as DocEntry from OINV where \"DocNum\"=");
        sb.append(docNum);
        try {
            return (String) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el docEntry de la factura de venta " + docNum, e);
        }
        return null;
    }

    public List<Object[]> listDetailInvoice(String docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(f.\"Comments\" as varchar(1000))as Comments,cast(d.\"ItemCode\" as varchar(20))as ItemCode, ");
        sb.append(" cast(d.\"Quantity\" as int)as Qty,cast(d.\"Price\" as numeric(18,2))as Price,cast(d.\"LineNum\" as int)as lineNum, ");
        sb.append(" cast(f.\"DiscPrcnt\" as numeric(18,2))as DiscPrcnt,cast(f.\"DocDueDate\" as date)as DocDueDate,cast(o.\"U_Marca\" as varchar)as marca ");
        sb.append("from OINV f ");
        sb.append("inner join INV1 d on d.\"DocEntry\"=f.\"DocEntry\" ");
        sb.append("inner join OITM o on o.\"ItemCode\"=d.\"ItemCode\"  ");
        sb.append("where f.\"DocNum\"=");
        sb.append(docNum);
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle para la factura de venta #" + docNum, e);
        }
        return new ArrayList<>();
    }

    public Object[] getSumOfInvoicesByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(c.\"LicTradNum\" as varchar(20))as nit,cast(f.\"CardName\" as varchar(100))as cliente, ");
        sb.append(" cast(sum(f.\"DocTotal\")as numeric(18,2))as comp,cast(sum(f.\"VatSum\")as numeric(18,2))as ivaCom, ");
        sb.append(" cast(sum(f.\"DiscSum\")as numeric(18,2))as descto, ");
        sb.append(" (select cast(sum(n.\"DocTotal\")as numeric(18,2)) from ORIN n where n.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("')as dev,(select cast(sum(n.\"VatSum\")as numeric(18, 2)) from ORIN n where n.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("')as ivaDev,cast(ifnull(sum(g.\"LineTotal\"),0)as numeric(18, 2))as flete ");
        sb.append("from OINV f ");
        sb.append("inner join OCRD c on c.\"CardCode\"=f.\"CardCode\" ");
        sb.append("left join INV3 g on g.\"DocEntry\"=f.\"DocEntry\" and g.\"ExpnsCode\"=1 ");
        sb.append("where year (f.\"DocDate\")=year(current_date) and f.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("' group by year(f.\"DocDate\"),f.\"CardName\",c.\"LicTradNum\"");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las compras del cliente " + cardCode + " realizadas en " + companyName);
        }
        return null;
    }

    public List<String> listInvoicePurchase(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"DocNum\" as varchar(100))as fv ");
        sb.append("from OINV ");
        sb.append("where \"DocType\"<>'S' and \"DocNum\" not in(1442,221,238,308,362,387) and \"DocStatus\"='O' and year(\"DocDate\")=year(current_date) and \"CardCode\"='C900998242' and cast(\"DocNum\" as varchar(100)) not in(");
        sb.append(" select cast(\"NumAtCard\" as varchar(100))as fv ");
        sb.append(" from \"VELEZ\".OPCH ");
        sb.append(" where year(\"DocDate\")=year(current_date) and \"CardCode\"=");
        if (companyName.contains("IGB")) {
            sb.append("'P811011909'");
        } else {
            sb.append("'P900255414'");
        }
        sb.append(" and \"NumAtCard\" is not null)");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las facturas de compra pendientes por crear en motorepuestos.com", e);
        }
        return new ArrayList<>();
    }

    public Integer validateExistInvoicePurchaseInMRTO(String docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(count(\"DocNum\") as int)as c ");
        sb.append("from \"VELEZ\".OPCH ");
        sb.append("where \"NumAtCard\"='");
        sb.append(docNum);
        sb.append("'");
        try {
            return (Integer) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando la existencia de la factura de compra en " + companyName, e);
        }
        return null;
    }
}
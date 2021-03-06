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
        sb.append("where f.\"DocDate\" between ADD_MONTHS(TO_DATE(current_date,'YYYY-MM-DD'),-3) and current_date and f.\"DocType\"='I' and f.\"CardCode\"='");
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
}
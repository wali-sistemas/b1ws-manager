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

    public Integer getDocEntry(Long docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(DocEntry as int)as DocEntry from OINV where DocNum=");
        sb.append(docNum);
        try {
            return (Integer) persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el docEntry de la factura de venta " + docNum, e);
        }
        return null;
    }
}
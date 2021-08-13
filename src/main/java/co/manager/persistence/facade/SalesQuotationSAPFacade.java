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
public class SalesQuotationSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(SalesQuotationSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;
    @EJB
    private PersistenceConf persistenceConf;

    public SalesQuotationSAPFacade() {
    }

    public List<Object[]> listSalesQuotations(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"CardCode\" as varchar(20))as CardCode, ");
        sb.append(" cast(\"Comments\" as varchar(1000))as Comments,cast(\"U_TRANSP\" as varchar(5))as Transp, ");
        sb.append(" cast(\"ShipToCode\" as varchar(100))as ShipToCode,cast(\"PayToCode\" as varchar(100))as PayToCode, ");
        sb.append(" cast(\"SlpCode\" as int)as SlpCode,cast(\"DiscPrcnt\" as numeric(18,0))as DiscPrcnt, ");
        sb.append(" cast(\"DocEntry\" as int)as DocEntry,cast(\"DocNum\" as int)as DocNum ");
        sb.append("from OQUT ");
        sb.append("where year(\"DocDate\")=year(current_date) and MONTH(\"DocDate\") between MONTH(current_date)-1 and MONTH(current_date) and \"DocStatus\"='O' and \"U_ESTADO_WMS\"='C'");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ofertas de ventas completadas para crear ordenes.", e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listDetailSalesQuotations(long docEntry, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"ItemCode\" as varchar(20))as ItemCode,cast(\"Quantity\" as int)as Qty,cast(\"WhsCode\" as varchar(5))as WhsCode ");
        sb.append("from QUT1 ");
        sb.append("where \"DocEntry\"=");
        sb.append(docEntry);
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle de la oferta de venta docEntry[" + docEntry + "]", e);
        }
        return new ArrayList<>();
    }

    public void updateStatus(long docEntry, Character status, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OQUT set \"U_ESTADO_WMS\"='");
        sb.append(status);
        sb.append("' where \"DocEntry\"=");
        sb.append(docEntry);
        try {
            persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualiando el estado de la oferta de venta docEntry=[" + docEntry + "]", e);
        }
    }
}
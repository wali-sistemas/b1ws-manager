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
public class PurchaseOrderFacade {
    private static final Logger CONSOLE = Logger.getLogger(PurchaseOrderFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public PurchaseOrderFacade() {
    }

    public List<Object[]> listOrdersWithDocumentBL(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as varchar(20))as DocNum,cast(o.\"DocDate\" as date)as DocDate, ");
        sb.append(" cast(o.\"U_DOC_TRANSP\" as varchar(50))as BL,cast(s.\"SlpName\" as varchar(100))as SlpName, ");
        sb.append(" cast(o.\"Comments\" as varchar(100))as Coment,'REPUESTOS' as Linea, ");
        sb.append(" cast(s.\"Email\" as varchar(100))as mail ");
        sb.append("from OPOR o ");
        sb.append("inner join OSLP s ON s.\"SlpCode\" = o.\"SlpCode\" ");
        sb.append("where o.\"Series\"='48' and o.\"DocStatus\"='O' and o.\"U_DOC_TRANSP\" is not null and o.\"U_NotificationBL\"='Y' ");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes de compra con documento BL. ", e);
        }
        return new ArrayList<>();
    }

    public void updateFieldDocumentBL(String docNum, char status, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OPOR set \"U_NotificationBL\"='");
        sb.append(status);
        sb.append("' where \"DocNum\"=");
        sb.append(docNum);
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el campo de usuario en la factura de compra. Estado=[" + status + "]");
        }
    }
}
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
public class CreditNotesSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(CreditNotesSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listCreditNotesHistoryByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(n.\"DocNum\" as int)as DocNum, cast(n.\"DocDate\" as date)as DocDate, cast(n.\"DocTotal\" as numeric(18,2))as DocTotal, ");
        sb.append("      cast(n.\"Comments\" as varchar(1000))as Descripcion, cast(n.\"U_addInFE_LinkFE\" as varchar(1000))as UrlFacture ");
        sb.append("from  ORIN n ");
        sb.append("where n.\"DocDate\" between ADD_MONTHS(TO_DATE(current_date,'YYYY-MM-DD'),-3) and current_date and n.\"DocType\" = 'I' and n.\"CardCode\" ='");
        sb.append(cardCode);
        sb.append("' order by n.\"DocDate\" DESC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las notas credito historicas para el cliente [" + cardCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
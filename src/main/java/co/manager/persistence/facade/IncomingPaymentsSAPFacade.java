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
public class IncomingPaymentsSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(IncomingPaymentsSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listPaymentsHistoryByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(r.DocNum as int)as DocNum, cast(r.DocDate as date)as DocDate, cast(r.DocTotal as numeric(18,2))as DocTotal ");
        sb.append("from  ORCT r ");
        sb.append("where cast(r.DocDate as date) between cast(DATEADD(MM,-3,GETDATE())as date) and cast(GETDATE() as date) and cast(GETDATE() as date) and r.CardCode = '");
        sb.append(cardCode);
        sb.append("' order by r.DocDate DESC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los pagos para el cliente " + cardCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
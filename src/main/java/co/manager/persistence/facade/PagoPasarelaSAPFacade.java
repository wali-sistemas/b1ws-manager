package co.manager.persistence.facade;

import co.manager.persistence.entity.PagoPasarelaSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class PagoPasarelaSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(PagoPasarelaSAP.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(PagoPasarelaSAP pagoPasarelaSAP, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE).persist(pagoPasarelaSAP);
    }

    public boolean comfirmPayment(Integer idPago, String companyNane, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(COUNT(U_idPago) as int)as idPago from [@PAGO_PASARELA_ENC] where U_idPago =");
        sb.append(idPago);
        try {
            Integer res = (Integer) persistenceConf.chooseSchema(companyNane, pruebas, DB_TYPE).createNativeQuery(sb.toString()).getSingleResult();
            if (res > 0) {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el siguiente id de pago para " + companyNane, e);
        }
        return false;
    }
}
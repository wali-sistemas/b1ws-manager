package co.manager.persistence.facade;

import co.manager.persistence.entity.DetallePagoPasarelaSAP;
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
public class DetallePagoPasarelaSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(DetallePagoPasarelaSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addDetailPago(DetallePagoPasarelaSAP detallePagoPasarelaSAP, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@PAGO_PASARELA_DET\" values ('");
        sb.append(detallePagoPasarelaSAP.getCode());
        sb.append("','");
        sb.append(detallePagoPasarelaSAP.getName());
        sb.append("',");
        sb.append(detallePagoPasarelaSAP.getuIdDetalle());
        sb.append(",");
        sb.append(detallePagoPasarelaSAP.getuIdPago());
        sb.append(",");
        sb.append(detallePagoPasarelaSAP.getuDocEntryFv());
        sb.append(",");
        sb.append(detallePagoPasarelaSAP.getuLineNumFv());
        sb.append(",");
        sb.append(detallePagoPasarelaSAP.getuSumAppliedFv());
        sb.append(");");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el detalle del pago para " + companyName, e);
        }
    }
}
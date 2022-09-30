package co.manager.persistence.facade;

import co.manager.persistence.entity.PagoPasarelaSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class PagoPasarelaSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(PagoPasarelaSAP.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public boolean comfirmPayment(Integer idPago, String companyNane, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(count(\"U_idPago\") as int)as idPago from \"@PAGO_PASARELA_ENC\" where \"U_idPago\" =");
        sb.append(idPago);
        try {
            Integer res = (Integer) persistenceConf.chooseSchema(companyNane, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
            if (res > 0) {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el siguiente id de pago para " + companyNane, e);
        }
        return false;
    }

    public void addPago(PagoPasarelaSAP pagoPasarelaSAP, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@PAGO_PASARELA_ENC\" values ('");
        sb.append(pagoPasarelaSAP.getCode());
        sb.append("','");
        sb.append(pagoPasarelaSAP.getName());
        sb.append("',");
        sb.append(pagoPasarelaSAP.getuIdPago());
        sb.append(",'");
        sb.append(pagoPasarelaSAP.getuCardCode());
        sb.append("','");
        sb.append(pagoPasarelaSAP.getuTransferReference());
        sb.append("',");
        sb.append(pagoPasarelaSAP.getuCashSum());
        sb.append(",'");
        sb.append(pagoPasarelaSAP.getuStatus());
        sb.append("','");
        sb.append(pagoPasarelaSAP.getuPasarela());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(pagoPasarelaSAP.getuCreateDate()));
        sb.append("','");
        sb.append(pagoPasarelaSAP.getuDocNum());
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el pago para " + companyName, e);
        }
    }

    public void updateNroPago(Integer idPago, Long docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("update \"@PAGO_PASARELA_ENC\" ");
        sb.append("set \"U_docNum\"='");
        sb.append(docNum);
        sb.append("' where \"U_idPago\"=");
        sb.append(idPago);
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar el nro de pago para " + companyName, e);
        }
    }
}
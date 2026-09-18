package co.manager.persistence.facade;

import co.manager.dto.DespachoExhibidoreDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class DespachoExhibidoreSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(DespachoExhibidoreSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public boolean addDespachoExhibidore(DespachoExhibidoreDTO dto, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@DESPACHO_EXHIBIDORE\" values ('");
        sb.append(dto.getCode());
        sb.append("','");
        sb.append(dto.getName());
        sb.append("','");
        sb.append(dto.getCardCode());
        sb.append("',");
        sb.append(dto.getQty());
        sb.append(",'");
        sb.append(dto.getMarca());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        sb.append("','");
        sb.append(dto.getBaseRef());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        sb.append("','");
        sb.append(dto.getItemCode());
        sb.append("');");
        try {
            int res = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
            if (res == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el registro de despacho del exhibidor para el cliente " + dto.getCardCode() + " en " + companyName, e);
            return false;
        }
    }

    public boolean existsExhibitorDispatchRecordByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(count(\"U_CardCode\")as int)as reg ");
        sb.append("from \"@DESPACHO_EXHIBIDORE\" ");
        sb.append("where \"U_CardCode\"='");
        sb.append(cardCode);
        sb.append("' and current_date<ADD_YEARS(cast(\"U_DocShipping\" as date),1)");
        try {
            int res = (int) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
            if (res == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando la existencia del cliente " + cardCode + " en despacho exhibidor para " + companyName);
            return false;
        }
    }
}
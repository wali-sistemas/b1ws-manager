package co.manager.persistence.facade;

import co.manager.dto.PointHistoryCalidosoDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class RedimeHistorialPuntosSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(RedimeHistorialPuntosSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addRedeemHistoryPoints(PointHistoryCalidosoDTO dto, String companyName, boolean testing) {
        String id = (new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getCardCode();
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@REDENCION_HISTPUNTO\" values ('");
        sb.append(id);
        sb.append("','");
        sb.append(id);
        sb.append("','");
        sb.append(dto.getCardCode());
        sb.append("','");
        sb.append(dto.getConcept());
        sb.append("',");
        sb.append(dto.getDocNum());
        sb.append(",'");
        sb.append(dto.getDocType());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(dto.getDocDate()));
        sb.append("',");
        sb.append(dto.getPoint());
        sb.append(",null,null,'");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(dto.getTransferDate()));
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error registrando el historico de puntos para el participante [" + dto.getCardCode() + "]" + " en " + companyName);
        }
    }
}
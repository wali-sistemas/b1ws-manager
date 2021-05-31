package co.manager.persistence.facade;

import co.manager.dto.VendedorMostradorDTO;
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
public class VendedorMostradorSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(VendedorMostradorSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addVendedorMostrador(VendedorMostradorDTO dto, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@REDENCION_VENDMOSTR\" values ('");
        sb.append((new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getDocumento());
        sb.append("','");
        sb.append((new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getDocumento());
        sb.append("','");
        sb.append(dto.getDocumento());
        sb.append("','");
        sb.append(dto.getNombres().toUpperCase());
        sb.append("','");
        sb.append(dto.getApellidos().toUpperCase());
        sb.append("','");
        sb.append(dto.getCorreo().toUpperCase());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyyMMdd").format(dto.getFechaNacimiento()));
        sb.append("','");
        sb.append(dto.getCardCode());
        sb.append("','");
        sb.append(dto.getAceptoTratamientoDatos());
        sb.append("','");
        sb.append(dto.getAceptoTermino());
        sb.append("','");
        sb.append(dto.getCelular());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        sb.append("','");
        sb.append(dto.getDepartamento().toUpperCase());
        sb.append("','");
        sb.append(dto.getCiudad().toUpperCase());
        sb.append("','");
        sb.append("S");
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del vendedor mostrador id=" + dto.getDocumento(), e);
        }
    }
}

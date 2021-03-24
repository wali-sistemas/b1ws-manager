package co.manager.persistence.facade;

import co.manager.dto.ClientFeriaDTO;
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
public class ClientFeriaSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ClientFeriaSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;
    @EJB
    private PersistenceConf persistenceConf;

    public ClientFeriaSAPFacade() {
    }

    public String getClienteFeria(String documento, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_documento\" AS varchar(20)) from \"@CLIENTES_FERIA\" where \"U_documento\" = '");
        sb.append(documento);
        sb.append("'");
        try {
            return (String) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los datos capturados del cliente feria. ", e);
            return null;
        }
    }

    public boolean addClienteFeria(ClientFeriaDTO dto, boolean testing) {
        String id = String.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO \"@CLIENTES_FERIA\" VALUES ('");
        sb.append(id);//code
        sb.append("','");
        sb.append(id);//name
        sb.append("','");
        sb.append(dto.getDocumento().trim());
        sb.append("','");
        sb.append(dto.getNombreCompleto().trim());
        sb.append("','");
        sb.append(dto.getTelefono().trim());
        sb.append("','");
        sb.append(dto.getCorreo() == null ? "" : dto.getCorreo().trim());
        sb.append("','");
        sb.append(dto.getAlmacen() == null ? "" : dto.getAlmacen().trim());
        sb.append("','");
        sb.append(dto.getInteres().trim());
        sb.append("','");
        sb.append(dto.getRegional().trim());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-dd-MM HH:mm:ss").format(new Date()));
        sb.append("','");
        sb.append(dto.getCiudad());
        sb.append("');");
        try {
            persistenceConf.chooseSchema(dto.getCompanyName(), testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al insertar los datos capturados al cliente feria. ", e);
            return false;
        }
        return true;
    }
}
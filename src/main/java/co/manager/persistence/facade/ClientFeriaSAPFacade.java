package co.manager.persistence.facade;

import co.manager.dto.ClientFeriaDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ClientFeriaSAPFacade {
    @PersistenceContext(unitName = "IGBPU")
    private EntityManager em;
    private static final Logger CONSOLE = Logger.getLogger(ClientFeriaSAPFacade.class.getSimpleName());

    public String getClienteFeria(String documento) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT CAST(U_documento AS varchar(20)) FROM [@CLIENTES_FERIA] WHERE U_documento = '");
        sb.append(documento);
        sb.append("'");

        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los datos capturados del cliente feria", e);
            return null;
        }
    }

    public boolean addClienteFeria(ClientFeriaDTO dto) {
        String id = String.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO [@CLIENTES_FERIA] VALUES ('");
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
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        sb.append("');");

        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al insertar los datos capturados al cliente feria", e);
            return false;
        }
        return true;
    }
}
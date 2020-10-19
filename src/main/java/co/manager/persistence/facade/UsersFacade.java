package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class UsersFacade {
    private static final Logger CONSOLE = Logger.getLogger(UsersFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public UsersFacade() {
    }

    public Object[] getAttributeUser(String username) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(name as varchar(45))as name,cast(surname as varchar(45))as surname,cast(email as varchar(80))as email ");
        sb.append("from users where username = '");
        sb.append(username);
        sb.append("'");
        try {
            return (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo los datos del usuario del wms.", e);
        }
        return null;
    }
}
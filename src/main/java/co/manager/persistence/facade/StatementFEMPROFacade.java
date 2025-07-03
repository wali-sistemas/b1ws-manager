package co.manager.persistence.facade;

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
public class StatementFEMPROFacade {
    private static final Logger CONSOLE = Logger.getLogger(StatementFEMPROFacade.class.getSimpleName());
    private static final String DB_TYPE_NOVAWEB = Constants.DATABASE_TYPE_NOVAWEB;

    @EJB
    private PersistenceConf persistenceConf;

    public Object[] findDataEmployee(String empId, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(documento as varchar(20))as doc,cast(nombre as varchar(100))as nom,cast(correo as varchar(50))as email ");
        sb.append("from estado_cuenta ");
        sb.append("where documento='");
        sb.append(empId);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los datos del empleado [" + empId + "] en el fondo. ", e);
        }
        return null;
    }
}
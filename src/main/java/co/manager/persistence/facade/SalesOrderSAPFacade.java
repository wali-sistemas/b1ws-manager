package co.manager.persistence.facade;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class SalesOrderSAPFacade {

    private static final Logger CONSOLE = Logger.getLogger(SalesOrderSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = "mssql";

    @EJB
    private PersistenceConf persistenceConf;

    public SalesOrderSAPFacade() {
    }

    public List<String> getStatusOrder(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.Name as varchar(50)) as Estados ");
        sb.append("from   [@DESPACHADORES] e ");
        sb.append("where  RTRIM(LTRIM(e.Name)) NOT IN ('.',',') and RTRIM(LTRIM(e.Code)) like '%[a-zA-Z]%' ");
        sb.append("order  by Estados asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los estado disponibles para " + companyName, e);
        }
        return null;
    }
}
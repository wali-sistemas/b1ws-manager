package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class RedimeProductoSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(RedimeProductoSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listActiveProducts(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_ItemCode\" as varchar(20))as ItemCode, ");
        sb.append(" cast(\"U_ItemName\" as varchar(100))as ItemName, ");
        sb.append(" cast(\"U_Description\" as varchar(4000))as Description, ");
        sb.append(" cast(\"U_Price\" as numeric(18,0))as Price, ");
        sb.append(" cast(\"U_PictureName\" as varchar(30))as PictureName, ");
        sb.append(" cast(\"U_Condition\" as varchar(4000))as Condiction, ");
        sb.append(" cast(\"U_Supplier\" as varchar(50))as Aliados ");
        sb.append("from \"@REDENCION_PRODUCTOS\" ");
        sb.append("where \"U_Active\"='Y'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los productos activos para redimir en el programa de fidelización. ", e);
        }
        return new ArrayList<>();
    }
}
package co.manager.persistence.facade;

import co.manager.persistence.entity.ItemSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public ItemSAPFacade() {
    }

    public List<String> getListItemByPicture(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select Distinct cast(ItemCode as varchar(10)) as item from OITM ");
        sb.append("where PicturName is null and validFor = 'Y' and InvntItem = 'Y'");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los items sin foto en SAP.", e);
        }
        return null;
    }

    public void updateFieldPicture(String itemCode, String picturName, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<ItemSAP> cu = cb.createCriteriaUpdate(ItemSAP.class);
        Root<ItemSAP> root = cu.from(ItemSAP.class);

        cu.set(root.get("picturName"), picturName);
        cu.where(cb.equal(root.get("itemCode"), itemCode));
        try {
            em.createQuery(cu).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar el picturName para el item #[" + itemCode + "] de la empresa [" + companyName +"]");
        }
    }
}
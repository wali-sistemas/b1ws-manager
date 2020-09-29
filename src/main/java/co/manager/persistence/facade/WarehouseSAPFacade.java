package co.manager.persistence.facade;

import co.manager.persistence.entity.WarehouseSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class WarehouseSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(WarehouseSAP.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public WarehouseSAPFacade() {
    }

    public List<Object[]> getListWarehouse(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.WhsCode as varchar(20)) as Bodega, cast(o.WhsName as varchar(50)) as Descripcion ");
        sb.append("from OWHS o ");
        sb.append("where o.WhsCode IN (");

        if (companyName.equals("IGB")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01', '05', '26'");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'01', '08', '26', '44'");
        }
        sb.append(") order by o.WhsCode ASC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listado las bodegas de ventas para mostrar en pedBox para " + companyName, e);
        }
        return null;
    }
}
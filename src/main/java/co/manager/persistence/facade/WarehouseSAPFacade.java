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
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public WarehouseSAPFacade() {
    }

    public List<Object[]> getListWarehouse(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"WhsCode\" as varchar(20)) as Bodega, cast(o.\"WhsName\" as varchar(50)) as Descripcion, ");
        sb.append(" case when o.\"WhsCode\"='32' then 1 else 0 end as type ");
        sb.append("from OWHS o ");
        sb.append("where o.\"WhsCode\" IN (");

        if (companyName.equals("IGB")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01','05','26','32','35','45','55') ");
            sb.append("union all ");
            sb.append("select '00' as Bodega,'VENTAS PERDIDAS' as Descripcion,2 as type ");
            sb.append("from dummy ");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'13','26','32','35') ");
        }
        sb.append("order by type asc");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listado las bodegas de ventas para mostrar en pedBox para " + companyName, e);
        }
        return null;
    }

    public Integer getConsumePorcModula(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_PORCENTAJE\" as int)as porc ");
        sb.append("from OWHS ");
        sb.append("where \"WhsCode\"='30' ");
        try {
            return (Integer) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el porcentaje a consumir de wms-modula");
        }
        return 0;
    }
}
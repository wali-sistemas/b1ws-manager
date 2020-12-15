package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author jguisao
 */
@Stateless
public class PersistenceConf {

    @PersistenceContext(unitName = "IGBPU")
    private EntityManager emIGB;
    @PersistenceContext(unitName = "IGBPruebasPU")
    private EntityManager emIGBPruebas;
    @PersistenceContext(unitName = "VARROCPU")
    private EntityManager emVARROC;
    @PersistenceContext(unitName = "VARROCPruebasPU")
    private EntityManager emVARROCPruebas;
    @PersistenceContext(unitName = "VELEZPU")
    private EntityManager emVELEZ;
    @PersistenceContext(unitName = "VELEZPruebasPU")
    private EntityManager emVELEZPruebas;
    @PersistenceContext(unitName = "WMSPU")
    private EntityManager emWMS;

    public EntityManager chooseSchema(String companyName, boolean testing, String dbType) {

        if (dbType.equalsIgnoreCase(Constants.DATABASE_TYPE_WALI)) {
            return emWMS;
        } else {
            switch (companyName) {
                case "IGB":
                    return emIGB;
                case "VARROC":
                    return emVARROC;
                case "IGBPruebas":
                    return emIGBPruebas;
                case "VARROCPruebas":
                    return emVARROCPruebas;
                case "VELEZ":
                    return emVELEZ;
                case "VELEZPruebas":
                    return emVELEZPruebas;
                default:
                    return null;
            }
        }
    }
}
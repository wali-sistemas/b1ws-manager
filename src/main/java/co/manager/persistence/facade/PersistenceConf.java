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
    @PersistenceContext(unitName = "WMSPU")
    private EntityManager emWMS;
    @PersistenceContext(unitName = "HANAIGBPU")
    private EntityManager emHANAIGB;
    @PersistenceContext(unitName = "HANAVARROCPU")
    private EntityManager emHANAVARROC;
    @PersistenceContext(unitName = "HANAVELEZPU")
    private EntityManager emHANAVELEZ;

    public EntityManager chooseSchema(String companyName, boolean testing, String dbType) {
        if (dbType.equalsIgnoreCase(Constants.DATABASE_TYPE_WALI)) {
            return emWMS;
        } else {
            switch (companyName) {
                case "IGB":
                    return emHANAIGB;
                case "VARROC":
                    return emHANAVARROC;
                case "VELEZ":
                    return emHANAVELEZ;
                default:
                    return null;
            }
        }
    }
}
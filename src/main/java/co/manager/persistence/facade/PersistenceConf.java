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
    @PersistenceContext(unitName = "HANAIGBTESTPU")
    private EntityManager emHANAIGBTEST;
    @PersistenceContext(unitName = "HANAVARROCTESTPU")
    private EntityManager emHANAVARROCTEST;
    @PersistenceContext(unitName = "HANAREDPLASPU")
    private EntityManager emHANAREDPLAS;
    @PersistenceContext(unitName = "IGBNOVAWEBPU")
    private EntityManager emIGBNOVAWEBPU;
    @PersistenceContext(unitName = "MTZNOVAWEBPU")
    private EntityManager emMTZNOVAWEBPU;
    @PersistenceContext(unitName = "IGBNOVAWEBNUBEPU")
    private EntityManager emIGBNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "MTZNOVAWEBNUBEPU")
    private EntityManager emMTZNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "DIGNOVAWEBNUBEPU")
    private EntityManager emDIGNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "INVNOVAWEBNUBEPU")
    private EntityManager emINVNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "MOTNOVAWEBNUBEPU")
    private EntityManager emMOTNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "VILNOVAWEBNUBEPU")
    private EntityManager emVILNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "WALNOVAWEBNUBEPU")
    private EntityManager emWALNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "FPBNOVAWEBNUBEPU")
    private EntityManager emFPBNOVAWEBNUBEPU;
    @PersistenceContext(unitName = "MODULANOVAWEBNUBEPU")
    private EntityManager emMODULANOVAWEBNUBEPU;

    public EntityManager chooseSchema(String companyName, boolean testing, String dbType) {
        if (dbType.equalsIgnoreCase(Constants.DATABASE_TYPE_WALI)) {
            return emWMS;
        } else if (dbType.equalsIgnoreCase(Constants.DATABASE_TYPE_NOVAWEB)) {
            switch (companyName) {
                case "DSM_NOVAWEB":
                    return emDIGNOVAWEBNUBEPU;
                case "INVERSUR_NOVAWEB":
                    return emINVNOVAWEBNUBEPU;
                case "MOTOREPUESTOS_NOVAWEB":
                    return emMOTNOVAWEBNUBEPU;
                case "VILNA_NOVAWEB":
                    return emVILNOVAWEBNUBEPU;
                case "WALI_NOVAWEB":
                    return emWALNOVAWEBNUBEPU;
                case "FEMPROBN_NOVAWEB":
                    return emFPBNOVAWEBNUBEPU;
                case "MODULA_NOVAWEB":
                    return emMODULANOVAWEBNUBEPU;
                default:
                    return null;
            }
        } else {
            switch (companyName) {
                case "IGB":
                    if (!testing) {
                        return emHANAIGB;
                    } else {
                        return emHANAIGBTEST;
                    }
                case "VARROC":
                    return emHANAVARROC;
                case "VARROCPruebas":
                    return emHANAVARROCTEST;
                case "VELEZ":
                    return emHANAVELEZ;
                case "IGBPruebas":
                    return emHANAIGBTEST;
                case "REDPLAS":
                    return emHANAREDPLAS;
                default:
                    return null;
            }
        }
    }
}
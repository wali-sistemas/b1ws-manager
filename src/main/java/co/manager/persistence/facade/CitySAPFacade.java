package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class CitySAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(CitySAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;
    @EJB
    private PersistenceConf persistenceConf;

    public List<Object[]> listMunicipios(String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Code\" as varchar(20))as Code,cast(\"Name\" as varchar(100))as Municipio from \"@BPCO_MU\"");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los municipios en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listDepartamentos(String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Code\" as varchar(20))as Code, cast(\"Name\" as varchar(100))as Departamento from OCST where \"Country\" = 'CO'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los departementos en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public String getNameMunicipio(String code, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Name\" as varchar(100))as Municipio from \"@BPCO_MU\" where \"Code\"='");
        sb.append(code);
        sb.append("'");
        try {
            return (String) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el municipio de codigo " + code, e);
        }
        return "";
    }
}
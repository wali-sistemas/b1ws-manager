package co.manager.persistence.facade;

import co.manager.dto.ConceptCalidosoDTO;
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
public class ConceptoSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ConceptoSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public List<ConceptCalidosoDTO> listActivePrograms(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Code\" as varchar(3))as code,cast(\"Name\" as varchar(100))as concepto ");
        sb.append("from \"@REDENCION_CONCEPTOS\" ");
        sb.append("where \"U_Activo\"='Y'");
        try {
            List<ConceptCalidosoDTO> listConcepts = new ArrayList<>();
            for (Object[] obj : (List<Object[]>) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList()) {
                ConceptCalidosoDTO dto = new ConceptCalidosoDTO();
                dto.setCode((String) obj[0]);
                dto.setConcepto((String) obj[1]);
                listConcepts.add(dto);
            }
            return listConcepts;
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar los programas activos en los calidosos. ", e);
        }
        return null;
    }
}
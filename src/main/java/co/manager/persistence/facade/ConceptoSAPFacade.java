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

    public List<Object[]> countNumberRegister(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(t.\"Name\" as varchar(100))as Programa,cast(count(t.\"doc\")as int)as Nro ");
        sb.append("from ( ");
        sb.append(" select R.\"Name\",c.\"CardCode\" as \"doc\" ");
        sb.append(" from OCRD c ");
        sb.append(" inner join \"@REDENCION_CONCEPTOS\" r on c.\"U_PRO_FIDELIZACION\"=r.\"Code\" ");
        sb.append(" where c.\"QryGroup15\"='Y' and c.\"validFor\"='Y' ");
        sb.append(" union all ");
        sb.append(" select 'Vendedor de Mostrador' as \"Name\",v.\"U_Documento\" as \"doc\" ");
        sb.append(" from \"@REDENCION_VENDMOSTR\" v ");
        sb.append(" where v.\"U_Activo\"='S' ");
        sb.append(")as t ");
        sb.append("group by t.\"Name\"");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener los numeros de regitros en los calidosos. ", e);
        }
        return new ArrayList<>();
    }
}
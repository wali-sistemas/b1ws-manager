package co.manager.persistence.facade;

import co.manager.dto.VendedorMostradorDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class VendedorMostradorSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(VendedorMostradorSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addVendedorMostrador(VendedorMostradorDTO dto, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@REDENCION_VENDMOSTR\" values ('");
        sb.append((new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getDocumento());
        sb.append("','");
        sb.append((new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getDocumento());
        sb.append("','C");
        sb.append(dto.getDocumento());
        sb.append("','");
        sb.append(dto.getNombres().toUpperCase());
        sb.append("','");
        sb.append(dto.getApellidos().toUpperCase());
        sb.append("','");
        sb.append(dto.getCorreo().toUpperCase());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyyMMdd").format(dto.getFechaNacimiento()));
        sb.append("','");
        sb.append(dto.getCardCode());
        sb.append("','");
        sb.append(dto.getAceptoTratamientoDatos());
        sb.append("','");
        sb.append(dto.getAceptoTermino());
        sb.append("','");
        sb.append(dto.getCelular());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        sb.append("','");
        sb.append(dto.getDepartamento().toUpperCase());
        sb.append("','");
        sb.append(dto.getCiudad().toUpperCase());
        sb.append("','");
        sb.append("S");
        sb.append("','");
        sb.append(dto.getDireccion().toUpperCase());
        sb.append("','");
        sb.append(dto.getCodConcepto());
        sb.append("','");
        sb.append("N");
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro del vendedor mostrador id=" + dto.getDocumento(), e);
        }
    }

    public List<Object[]> listDataLoginCalidoso(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(v.\"U_Documento\" as varchar(20))as id,case when v.\"U_Concepto\"='01' then 'Vendedor de Mostrador' else 'Mecánico' end as Programa,cast(v.\"U_Correo\" as varchar(100))as mail, ");
        sb.append(" cast(v.\"U_Celular\" as varchar(50))as celular,cast(v.\"U_Nombres\" ||' '|| v.\"U_Apellidos\" as varchar(100))as Nombres ");
        sb.append("from \"@REDENCION_VENDMOSTR\" v ");
        sb.append("where \"U_Activo\"='S' ");
        sb.append("union all ");
        sb.append("select cast(c.\"CardCode\" as varchar(20))as id,cast(r.\"Name\" as varchar(100))as Programa, ");
        sb.append(" cast(c.\"E_Mail\" as varchar(100))as mail,substring(cast(c.\"Phone2\" as varchar(10)),0,10)as celular,cast(c.\"CardName\" as varchar(100))as Nombres ");
        sb.append("from OCRD c ");
        sb.append("inner join \"@REDENCION_CONCEPTOS\" r on c.\"U_PRO_FIDELIZACION\"=r.\"Code\" ");
        sb.append("where c.\"QryGroup15\"='Y' and c.\"validFor\"='Y'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los datos para login en los calidosos. ", e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listVendMostradorByClient(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(v.\"U_CardCode\" as varchar(20))as cliente, ");
        sb.append(" cast(row_number() over(partition by v.\"U_CardCode\" order by v.\"U_Documento\")as int)as row, ");
        sb.append(" cast(v.\"U_Documento\" as varchar(20))as VendMostrador, ");
        sb.append(" cast(v.\"U_Nombres\" as varchar(100))as Nombres,cast(v.\"U_Apellidos\" as varchar(100))as Apellidos, ");
        sb.append(" cast(v.\"U_Correo\" as varchar(100))as Correo,cast(v.\"U_Celular\" as varchar(50))as Celular, ");
        sb.append(" cast(v.\"U_Ciudad\" as varchar(100))as Ciudad,cast(v.\"U_Departamento\" as varchar(100))as Departamento ");
        sb.append("from \"@REDENCION_VENDMOSTR\" v ");
        sb.append("inner join OCRD c on v.\"U_CardCode\"=c.\"CardCode\" ");
        sb.append("where v.\"U_Activo\"='S' and c.\"validFor\"='Y' and c.\"QryGroup15\"='Y' and v.\"U_Concepto\"='01' ");
        if (!cardCode.equals("0")) {
            sb.append("and v.\"U_CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }
        sb.append("order by 1,3");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los vendedores mosrador par ael cliente " + cardCode, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listMechanicsByClient(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(v.\"U_CardCode\" as varchar(20))as cliente, ");
        sb.append(" cast(row_number() over(partition by v.\"U_CardCode\" order by v.\"U_Documento\")as int)as row, ");
        sb.append(" cast(v.\"U_Documento\" as varchar(20))as Mecanico, ");
        sb.append(" cast(v.\"U_Nombres\" as varchar(100))as Nombres,cast(v.\"U_Apellidos\" as varchar(100))as Apellidos, ");
        sb.append(" cast(v.\"U_Correo\" as varchar(100))as Correo,cast(v.\"U_Celular\" as varchar(50))as Celular, ");
        sb.append(" cast(v.\"U_Ciudad\" as varchar(100))as Ciudad,cast(v.\"U_Departamento\" as varchar(100))as Departamento ");
        sb.append("from \"@REDENCION_VENDMOSTR\" v ");
        sb.append("inner join OCRD c on v.\"U_CardCode\"=c.\"CardCode\" ");
        sb.append("where v.\"U_Activo\"='S' and c.\"validFor\"='Y' and c.\"QryGroup15\"='Y' and v.\"U_Concepto\"='05' ");
        if (!cardCode.equals("0")) {
            sb.append("and v.\"U_CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }
        sb.append("order by 1,3");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los vendedores mosrador par ael cliente " + cardCode, e);
        }
        return new ArrayList<>();
    }

    public boolean validateVendMostrador(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_Documento\" as varchar(20))as Code from \"@REDENCION_VENDMOSTR\" where \"U_Documento\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            int res = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult().hashCode();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NoResultException ex) {
            return false;
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando si existe el vendedor mostrador [" + cardCode + "]");
        }
        return false;
    }
}
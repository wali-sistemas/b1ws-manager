package co.manager.persistence.facade;

import co.manager.dto.PointRedeemCalidosoDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class RedimePuntosSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(RedimePuntosSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addRedeemPoints(PointRedeemCalidosoDTO dto, String companyName, boolean testing) {
        String id = (new SimpleDateFormat("yyyyMMdd-HHmmssSSS-").format(new Date())) + dto.getDocumento();
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@REDENCION_PUNTOS\" values ('");
        sb.append(id);
        sb.append("','");
        sb.append(id);
        sb.append("','");
        sb.append(dto.getDocumento());
        sb.append("','");
        sb.append(new SimpleDateFormat("yyyy-MM-dd").format(dto.getFecha()));
        sb.append("',");
        sb.append(dto.getPuntos());
        sb.append(",'");
        sb.append(dto.getConcepto());
        sb.append("','");
        sb.append(dto.getComprobante());
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error registrando la redencion de puntos para el participante [" + dto.getDocumento() + "]");
        }
    }

    public List<Object[]> listAvailablePoints(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(t.\"CardCode\" as varchar(20))as CardCode,cast(t.\"Programa\" as varchar(50))as Programa,cast(sum(t.\"PtsDisp\")as int)as PtsDisp ");
        sb.append("from (");
        sb.append(" select e.\"CardCode\",case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0)) ");
        sb.append("  else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))end \"PtsDisp\",c.\"Name\" as \"Programa\" ");
        sb.append(" from OINV e ");
        sb.append(" inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append(" inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append(" inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append(" inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append(" inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" ");
        sb.append(" where year(e.\"DocDate\")=year(current_date) and s.\"QryGroup15\"='Y' and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");
        sb.append(" group by m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",c.\"Name\" ");
        sb.append("union all ");
        sb.append(" select e.\"CardCode\",case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0))*-1 ");
        sb.append("  else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))*-1 end \"PtsDisp\",c.\"Name\" as \"Programa\" ");
        sb.append(" from ORIN e ");
        sb.append(" inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append(" inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append(" inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append(" inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append(" inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" ");
        sb.append(" where year(e.\"DocDate\")=year(current_date) and s.\"QryGroup15\"='Y' and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");
        sb.append(" group by m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",c.\"Name\" ");
        sb.append("union all ");
        sb.append(" select distinct v.\"U_Documento\" as \"CardCode\",case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("  else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100)) ");
        sb.append("        *(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0)) ");
        sb.append("        /(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")) ");
        sb.append("  else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0)) ");
        sb.append("        /(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))end end as \"PtsDisp\",c.\"Name\" as \"Programa\" ");
        sb.append(" from OINV e ");
        sb.append(" inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append(" inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append(" inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append(" inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" ");
        sb.append(" inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"='01' ");
        sb.append(" where year(e.\"DocDate\")=year(current_date) and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");
        sb.append(" group by m.\"U_Puntos\",c.\"U_PorcPuntos\",v.\"U_Documento\",c.\"Name\",e.\"CardCode\" ");
        sb.append("union all ");
        sb.append(" select distinct v.\"U_Documento\" as \"CardCode\",case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("  else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100)) ");
        sb.append("   *(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0)) ");
        sb.append("   /(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 ");
        sb.append("  else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100)) ");
        sb.append("   *(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0)) ");
        sb.append("   /(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 end end as \"PtsDisp\",c.\"Name\" as \"Programa\" ");
        sb.append(" from ORIN e ");
        sb.append(" inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append(" inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append(" inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append(" inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" ");
        sb.append(" inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"='01' ");
        sb.append(" where year(e.\"DocDate\")=year(current_date) and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");
        sb.append(" group by m.\"U_Puntos\",c.\"U_PorcPuntos\",v.\"U_Documento\",c.\"Name\", e.\"CardCode\" ");
        sb.append("union all ");
        sb.append(" select distinct cast(p.\"U_CardCode\" as varchar(50)) as \"CardCode\",cast(sum(p.\"U_Point\")as numeric(18,0))*-1 as \"PtsDisp\", ");
        sb.append("  case when p.\"U_CardCode\"=c.\"CardCode\" then (select cast(\"Name\" as varchar(50)) from \"@REDENCION_CONCEPTOS\" where \"Code\"=c.\"U_PRO_FIDELIZACION\") ");
        sb.append("  else (select cast(\"Name\" as varchar(50)) from \"@REDENCION_CONCEPTOS\" where \"Code\"='01')end \"Programa\" ");
        sb.append(" from \"@REDENCION_PUNTOS\" p ");
        sb.append(" left join OCRD c on p.\"U_CardCode\"=c.\"CardCode\" ");
        sb.append(" left join \"@REDENCION_VENDMOSTR\" v ON p.\"U_CardCode\"=v.\"U_Documento\" ");
        sb.append(" where year(p.\"U_DocDate\")=year(current_date) ");
        sb.append(" group by p.\"U_CardCode\",c.\"CardCode\",c.\"U_PRO_FIDELIZACION\" ");
        sb.append(")as t ");

        if (!cardCode.equals("0")) {
            sb.append("where t.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("group by t.\"CardCode\",t.\"Programa\" ");
        sb.append("order by t.\"CardCode\",t.\"Programa\" ASC ");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los puntos disponibles para " + cardCode, e);
        }
        return null;
    }
}
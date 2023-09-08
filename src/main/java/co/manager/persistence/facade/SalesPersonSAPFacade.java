package co.manager.persistence.facade;

import co.manager.persistence.entity.SalesPersonSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class SalesPersonSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(SalesPersonSAP.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public SalesPersonSAPFacade() {
    }

    public String getCentroCosto(Long slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_CentroCosto\" as varchar(20))as CentroCosto from OSLP where \"SlpCode\"=");
        sb.append(slpCode);
        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el centro de costo para el vendedor " + slpCode.toString(), e.getMessage());
        }
        return "";
    }

    public String getMailRegional(String regional, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Email\" as varchar(50)) as Email ");
        sb.append("from OSLP s ");
        sb.append("where  \"Email\" is not null and \"Memo\" = '");
        sb.append(regional);
        sb.append("'");
        try {
            return (String) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el mail del regional. ", e);
            return "";
        }
    }

    public List<Object[]> getSaleBudgetBySellerAndLitros(String slpCode, Integer year, String month, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.\"SlpCode\" as varchar(10))as Asesor,cast(year(p.\"U_ANO_PRES\")as int)as Ano,cast(p.\"U_MES_PRES\" as varchar(2))as Mes, ");
        //TODO: Solo motozone se mide por litros
        if (companyName.contains("VARROC")) {
            sb.append(" ifnull(sum(t.\"LitrosFv\"-t.\"LitrosNc\"),0)as VentasNetas, ");
        } else {
            sb.append(" ifnull(sum(t.Ventas)-sum(t.Devoluciones),0)as VentasNetas, ");
        }

        sb.append("cast(p.\"U_VALOR_PRES\" as numeric(18,0))as Presupuesto, ");

        if (companyName.contains("VARROC")) {
            sb.append(" ifnull((select sum((d.\"Quantity\"*a.\"SVolume\"))as Pendiente from ORDR o inner join RDR1 d ON o.\"DocEntry\"=d.\"DocEntry\" inner join OITM a on a.\"ItemCode\"=d.\"ItemCode\" where o.\"DocStatus\"='O' and year(o.\"DocDate\")=p.\"U_ANO_PRES\" and o.\"SlpCode\"=t.Asesor and month(o.\"DocDate\")=p.\"U_MES_PRES\" and d.\"TaxOnly\"='N'),0)as Pendiente ");
        } else {
            sb.append(" ifnull((select sum(cast(\"DocTotal\"-\"VatSum\"-\"TotalExpns\"+\"WTSum\" as numeric(18,2)))as Pendiente from ORDR where \"DocStatus\"='O' and year(\"DocDate\")=p.\"U_ANO_PRES\" and \"SlpCode\"=t.Asesor and month(\"DocDate\")=p.\"U_MES_PRES\"),0)as Pendiente ");
        }

        sb.append("from  \"@PRES_ZONA_VEND\" p ");
        sb.append("inner join OSLP a on p.\"U_VEND_PRES\"=a.\"SlpName\" ");
        sb.append("left  join (select cast(f.\"SlpCode\" as varchar(10))as Asesor,cast(sum(f.\"DocTotal\"-f.\"VatSum\"-f.\"TotalExpns\"+f.\"WTSum\")as numeric(18,2))as Ventas,0 as Devoluciones ");

        if (companyName.contains("VARROC")) {
            sb.append(",sum((d.\"Quantity\"*a.\"SVolume\"))as \"LitrosFv\",0 as \"LitrosNc\" ");
        }

        sb.append("  from  OINV f ");

        if (companyName.contains("VARROC")) {
            sb.append("inner join INV1 d on d.\"DocEntry\"=f.\"DocEntry\" ");
            sb.append("inner join OITM a on a.\"ItemCode\"=d.\"ItemCode\" ");
        }

        sb.append("  where f.\"DocType\"='I' and year(f.\"DocDate\")='");
        sb.append(year);
        sb.append("' and month(f.\"DocDate\")='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and f.\"SlpCode\"='");
            sb.append(slpCode);
        }
        //Se discrimina en motozone ventas de productos solo impuesto
        if (companyName.contains("VARROC")) {
            sb.append("' and d.\"TaxOnly\"='N");
        }

        sb.append("' group by year(f.\"DocDate\"),month(f.\"DocDate\"),f.\"SlpCode\" ");
        sb.append("union all ");
        sb.append("  select cast(n.\"SlpCode\" as varchar(10))as Asesor,0 as Ventas,cast(sum(n.\"DocTotal\"-n.\"VatSum\"-n.\"TotalExpns\"+n.\"WTSum\")as numeric(18,2))as Devoluciones ");

        if (companyName.contains("VARROC")) {
            sb.append(",0 as \"LitrosFv\",sum((d.\"Quantity\"*a.\"SVolume\"))as \"LitrosNc\" ");
        }

        sb.append("  from  ORIN n ");

        if (companyName.contains("VARROC")) {
            sb.append("inner join RIN1 d on d.\"DocEntry\"=n.\"DocEntry\" ");
            sb.append("inner join OITM a on a.\"ItemCode\"=d.\"ItemCode\" ");
        }

        sb.append("  where n.\"DocType\"='I' and year(n.\"DocDate\")='");
        sb.append(year);
        sb.append("' and month(n.\"DocDate\")='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and n.\"SlpCode\"='");
            sb.append(slpCode);
        }
        //Se discrimina en motozone notas de productos solo impuesto
        if (companyName.contains("VARROC")) {
            sb.append("' and d.\"TaxOnly\"='N");
        }

        sb.append("' group by year(n.\"DocDate\"),month(n.\"DocDate\"),n.\"SlpCode\")as t on a.\"SlpCode\"=t.Asesor ");
        sb.append("where p.\"U_ANO_PRES\"='");
        sb.append(year);
        sb.append("' and p.\"U_MES_PRES\"='");
        sb.append(month);

        if (!slpCode.equals("0")) {
            sb.append("' and a.\"SlpCode\"='");
            sb.append(slpCode);
        }

        sb.append("' group by p.\"U_VALOR_PRES\",a.\"SlpCode\",t.Asesor,p.\"U_ANO_PRES\",p.\"U_MES_PRES\" ");
        sb.append("order by a.\"SlpCode\"");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el presupuesto para el asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }

    public List<Object[]> getSaleBudgetBySeller(String slpCode, Integer year, String month, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.\"SlpCode\" as varchar(10))as Asesor,cast(year(p.\"U_ANO_PRES\")as int)as Ano,cast(p.\"U_MES_PRES\" as varchar(2))as Mes, ");
        sb.append(" ifnull(sum(t.Ventas)-sum(t.Devoluciones)-sum(t.asientos),0)as VentasNetas, ");
        sb.append("cast(p.\"U_VALOR_PRES\" as numeric(18,0))as Presupuesto, ");
        sb.append(" ifnull((select sum(cast(\"DocTotal\"-\"VatSum\"-\"TotalExpns\"+\"WTSum\" as numeric(18,2)))as Pendiente from ORDR where \"DocStatus\"='O' and year(\"DocDate\")='");
        sb.append(year);
        sb.append("' and month(\"DocDate\")='");
        sb.append(month);
        if (!slpCode.equals("0")) {
            sb.append("' and \"SlpCode\"='");
            sb.append(slpCode);
        }
        sb.append("'),0)as Pendiente,");
        sb.append(" cast(a.\"SlpName\" as varchar(50))as NomAsesor,cast(a.\"Email\" as varchar(50))as correo,cast(a.\"U_CEDULA\" as varchar(20))as cedula,cast(a.\"Telephone\" as varchar(3))as whsDefTire ");
        sb.append("from  \"@PRES_ZONA_VEND\" p ");
        sb.append("inner join OSLP a on p.\"U_VEND_PRES\"=a.\"SlpName\" ");
        sb.append("left  join (select cast(f.\"SlpCode\" as varchar(10))as Asesor,cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(f.\"DiscPrcnt\")/100))as numeric(18,2))as Ventas,0 as Devoluciones,0 as Asientos ");
        sb.append("from  OINV f ");
        sb.append("inner join INV1 d on d.\"DocEntry\"=f.\"DocEntry\" ");
        sb.append("where d.\"TaxOnly\"='N' and f.\"DocNum\" not in(select \"Code\" from \"@DOC_EXCLU\" where \"U_TIPO\"='FV') and year(f.\"DocDate\")='");
        sb.append(year);
        sb.append("' and month(f.\"DocDate\")='");
        sb.append(month);
        if (!slpCode.equals("0")) {
            sb.append("' and f.\"SlpCode\"='");
            sb.append(slpCode);
        }
        sb.append("' group by year(f.\"DocDate\"),month(f.\"DocDate\"),f.\"SlpCode\" ");
        sb.append("union all ");
        sb.append("  select cast(n.\"SlpCode\" as varchar(10))as Asesor,0 as Ventas,cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(n.\"DiscPrcnt\")/100)) as numeric(18,2))as Devoluciones,0 as Asientos ");
        sb.append("  from  ORIN n ");
        sb.append("  inner join RIN1 d on d.\"DocEntry\" = n.\"DocEntry\" ");
        sb.append("  where d.\"TaxOnly\"='N' and n.\"DocNum\" not in(select \"Code\" from \"@DOC_EXCLU\" where \"U_TIPO\"='NC') and year(n.\"DocDate\")='");
        sb.append(year);
        sb.append("' and month(n.\"DocDate\")='");
        sb.append(month);
        if (!slpCode.equals("0")) {
            sb.append("' and n.\"SlpCode\"='");
            sb.append(slpCode);
        }
        sb.append("' group by year(n.\"DocDate\"),month(n.\"DocDate\"),n.\"SlpCode\" ");
        sb.append("union all ");
        sb.append(" select cast(f.\"SlpCode\" as varchar(10))as Asesor,0 as Ventas,0 as Devoluciones,cast(sum(f.\"DocTotal\") as numeric(18,0))as Asientos ");
        sb.append(" from( ");
        sb.append("  select distinct e.\"TransId\", ");
        sb.append("   (select max(v.\"SlpCode\") ");
        sb.append("    from JDT1 a ");
        sb.append("    inner join OCRD c on a.\"U_InfoCo01\"=c.\"CardCode\" ");
        sb.append("    inner join OSLP v on c.\"SlpCode\"=v.\"SlpCode\" ");
        sb.append("    where a.\"TransId\"=e.\"TransId\" and a.\"Account\"<>'13050510' ");
        sb.append("   )as \"SlpCode\",(d.\"Debit\"-d.\"Credit\") as \"DocTotal\",e.\"BaseRef\",e.\"TaxDate\" ");
        sb.append("  from OJDT e ");
        sb.append("  inner join JDT1 d on e.\"TransId\"=d.\"TransId\" ");
        sb.append("  where e.\"Memo\"<>'P.133 períodos de cierre' and d.\"Account\" in ('41350520','41750540','41750525','41750530') and e.\"TransId\" not in (select \"Code\" from \"@DOC_EXCLU\" where \"U_TIPO\"='AS') ");
        sb.append(" )as f ");
        sb.append(" where year(f.\"TaxDate\")='");
        sb.append(year);
        sb.append("' and month(f.\"TaxDate\")='");
        sb.append(month);
        if (!slpCode.equals("0")) {
            sb.append("' and f.\"SlpCode\"='");
            sb.append(slpCode);
        }
        sb.append("' group by year(f.\"TaxDate\"),month(f.\"TaxDate\"),f.\"SlpCode\" ");
        sb.append(")as t on a.\"SlpCode\"=t.Asesor ");
        sb.append("where p.\"U_ANO_PRES\"='");
        sb.append(year);
        sb.append("' and p.\"U_MES_PRES\"='");
        sb.append(month);
        if (!slpCode.equals("0")) {
            sb.append("' and a.\"SlpCode\"='");
            sb.append(slpCode);
        }
        sb.append("' group by p.\"U_VALOR_PRES\",a.\"SlpCode\",t.Asesor,p.\"U_ANO_PRES\",p.\"U_MES_PRES\",a.\"SlpName\",a.\"Email\",a.\"U_CEDULA\",a.\"Telephone\" ");
        sb.append("order by a.\"SlpCode\"");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el presupuesto para el asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }

    public Object[] getSalesEffectivenessBySeller(String slpCode, Integer year, Integer month, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(t.\"SlpCode\" as varchar(2))as slpCode,cast(t.\"SlpName\" as varchar(100))as slpName, ");
        sb.append(" cast(t.\"U_COBERTURA\" as int)as clBase,cast(t.\"clImpac\" as int)as clImpac,cast(((t.\"clImpac\"/t.\"U_COBERTURA\")*100)as numeric(18,2))as cobertura ");
        sb.append("from ");
        sb.append(" (select a.\"SlpName\", a.\"SlpCode\",p.\"U_COBERTURA\", ");
        sb.append("   (select count(a.\"CardCode\") ");
        sb.append("    from ");
        sb.append("     (select distinct f.\"CardCode\" ");
        sb.append("      from OINV f ");
        sb.append("      inner join OCRD c on f.\"CardCode\"=c.\"CardCode\" ");
        sb.append("      inner join OSLP v on f.\"SlpCode\"=v.\"SlpCode\" ");
        sb.append("      where month(f.\"DocDate\")=");
        sb.append(month);
        sb.append("       and year(f.\"DocDate\")=");
        sb.append(year);
        sb.append("       and v.\"SlpName\"=p.\"U_VENDEDOR\" and (");
        sb.append("      select sum(o.\"DocTotal\"-o.\"VatSum\"-o.\"TotalExpns\"+o.\"WTSum\")as \"Total\"");
        sb.append("      from OINV o ");
        sb.append("      where month(o.\"DocDate\")=");
        sb.append(month);
        sb.append("       and year(o.\"DocDate\")=");
        sb.append(year);
        sb.append("       and f.\"CardCode\"=o.\"CardCode\"");
        sb.append(" union all ");
        sb.append("      select sum(n.\"DocTotal\"-n.\"VatSum\"-n.\"TotalExpns\"+n.\"WTSum\")*-1 as \"Total\" ");
        sb.append("      from ORIN n ");
        sb.append("      where month(n.\"DocDate\")=");
        sb.append(month);
        sb.append("       and year(n.\"DocDate\")=");
        sb.append(year);
        sb.append("       and f.\"CardCode\"=o.\"CardCode\"");
        sb.append("    )>499999 ");
        sb.append("   )as a ");
        sb.append("  )as \"clImpac\" ");
        sb.append(" from \"@PRES_COBERTURA\" p ");
        sb.append(" inner join OSLP a on p.\"U_VENDEDOR\"=a.\"SlpName\" ");
        sb.append(" where a.\"Fax\"='Y' and p.\"U_YEAR\"=");
        sb.append(year);
        sb.append("  and p.\"U_MONTH\"=");
        sb.append(month);
        sb.append("  and a.\"SlpCode\"=");
        sb.append(slpCode);
        sb.append(" group by a.\"SlpName\",p.\"U_VENDEDOR\",p.\"U_COBERTURA\",a.\"SlpCode\" ");
        sb.append(" order by 1,2 ");
        sb.append(")as t");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la efectividad de ventas para el asesor " + slpCode + " en " + companyName);
        }
        return null;
    }

    public List<Object[]> validateLoginApp(String user, String pass, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"SlpCode\" as varchar(3))as slpCode,cast(\"SlpName\" as varchar(100))as slpName,cast(\"U_CEDULA\" as varchar(100))as passWord ");
        sb.append("from OSLP ");
        sb.append("where \"Locked\"='N' and \"Fax\"='Y' and \"SlpCode\"='");
        sb.append(user);
        sb.append("' and \"U_CEDULA\"='");
        sb.append(pass);
        sb.append("'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los logins para " + companyName);
        }
        return null;
    }

    public Object[] getWhsCodeDefaultBySeller(String slpCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(ifnull(\"Telephone\",'01') as varchar(3))as whsCodeDefTire,'01' as WhsCodeDefLub,'32' as WhsCodeDefPart ");
        sb.append("from OSLP ");
        sb.append("where \"SlpCode\"='");
        sb.append(slpCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las bodegas por defecto asignadas al asesor " + slpCode + " en " + companyName);
        }
        return null;
    }
}
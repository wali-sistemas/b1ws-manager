package co.manager.persistence.facade;

import co.manager.dto.ClientCalidosoDTO;
import co.manager.dto.CupoDTO;
import co.manager.dto.GeolocationDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BusinessPartnerSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public BusinessPartnerSAPFacade() {
    }

    public List<Object[]> listCustomersBySalesPerson(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(sn.\"CardCode\" as varchar(20)) as CardCode, cast(sn.\"LicTradNum\" as varchar(20)) as Nit, ");
        sb.append(" cast(sn.\"CardName\" as varchar(100)) as Nombre, cast(sn.\"Address\" as varchar(100)) as AddressToDef, ");
        sb.append(" cast(sn.\"City\" as varchar(50)) as Localidad, cast(substring(sn.\"Phone1\",1,10) as varchar(10)) as Telefono, ");
        sb.append(" cast(substring(ifnull(sn.\"Cellular\",''),1,10) as varchar(10)) as Celular, cast(upper(sn.\"E_Mail\") as varchar(50)) as Email, ");
        sb.append(" cast(oc.\"PymntGroup\" as varchar(20)) as FormaPago, cast(((oc.\"ExtraMonth\" * 30) + oc.\"ExtraDays\") as int) as Plazo, ");
        sb.append(" cast(sn.\"CntctPrsn\" as varchar(100)) as Contacto, cast(sn.\"SlpCode\" as varchar(15)) as Vendedor, ");
        sb.append(" cast(sn.\"U_LONGITUD\" as varchar(20)) as Longitud, cast(sn.\"U_LATITUD\" as varchar(20)) as Latitud, ");
        sb.append(" cast(sn.\"ListNum\" as int) as listaPrecio, '' as Notas, ");
        sb.append(" cast(ifnull(sn.\"Discount\",0) as numeric(18,2)) as DescuentComercial, ");
        sb.append(" 'N' as Condicion, case when cr.\"TaxCode\" = 'IVAG19' then 'N' else 'S' end as Excento, ");
        sb.append(" cast(((sn.\"CreditLine\") - sn.\"Balance\" - sn.\"OrdersBal\") as numeric(18,0)) as SaldoCurrent, ");
        sb.append(" cast(cr.\"Address\" as varchar(50)) as IdAddress, ");
        sb.append(" cast(ifnull(upper(cr.\"Street\"),'') as varchar(100)) as Address, cast(ifnull(upper(cr.\"City\"),'') as varchar(50)) as City, ");
        sb.append(" cast(ifnull(upper(cs.\"Name\"),'') as varchar(50)) as County,case when sn.\"ShipToDef\" = cr.\"Address\" then 1 else 2 end ShipDef, ");
        sb.append(" cast(sn.\"Balance\" as numeric(18,2))as saldo,cast(sn.\"CreditLine\" as numeric(18,2))as cupo ");
        sb.append("from   OCRD sn ");
        sb.append("inner  join CRD1 cr on cr.\"CardCode\" = sn.\"CardCode\" ");
        sb.append("inner  join OCTG oc on sn.\"GroupNum\" = oc.\"GroupNum\" ");
        sb.append("inner  join OCST cs on cs.\"Code\" = cr.\"State\" ");
        sb.append("where  sn.\"CardType\" = 'C' and sn.\"frozenFor\" = 'N' and cs.\"Country\" = 'CO' and sn.\"SlpCode\" <> -1 ");
        sb.append("       and cr.\"AdresType\" = 'S' and sn.\"SlpCode\" =");
        sb.append(slpCode);
        sb.append(" order by ShipDef");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes del vendedor. ", e);
        }
        return null;
    }

    public String getTransportCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"U_TRASP\" as varchar(11)) as transport from OCRD where \"CardCode\" = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la transportadora del cliente. ", e);
        }
        return null;
    }

    public CupoDTO getCustomerPortfolio(String cardCode, String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(((s.\"CreditLine\")-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo, ");
        sb.append("       cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago, ");
        sb.append("      (select max(cast(v.\"DocDate\" as date)) from OINV v where v.\"CardCode\" = s.\"CardCode\")as fechaUltComp ");
        sb.append("from  OCRD s ");
        sb.append("where s.\"SlpCode\" =");
        sb.append(slpCode);
        sb.append(" and s.\"CardCode\" = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            Object[] obj = (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
            CupoDTO dto = new CupoDTO((BigDecimal) obj[0], (Integer) obj[1], (Date) obj[2]);
            return dto;
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la cartera del cliente. ", e);
        }
        return null;
    }

    public List<Object[]> listCustomerPortfolioBySalesPerson(String slpCode, String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.cardCode,t.cardName,t.nit,t.tipoDoc,t.docNum,t.fechaEmision,t.fechaVencimiento,t.valorSaldo,t.valorDocumento,t.diasVencidos*-1 as diasVenc, ");
        sb.append(" cast(a.\"SlpName\" as varchar(50))as vendedor,cast(c.\"PymntGroup\" as varchar(20))as condicionPago,case when t.cupo < 0 then 0 else t.cupo end as cupo,t.uPromDiasPago, ");
        sb.append(" t.fechaUltComp,t.urlFacture,cast(count(t.docNum) OVER(partition by t.cardCode)as int)as totalDoc,cast(t.emailFE as varchar(254))as emailFE ");
        sb.append("from (select cast(f.\"CardCode\" as varchar(20))as cardCode, cast(f.\"CardName\" as varchar(100))as cardName,cast(s.\"LicTradNum\" as varchar(20))as nit, ");
        sb.append("       'Factura'as tipoDoc,cast(f.\"DocNum\" as int)as docNum,cast(f.\"DocDate\" as date)as fechaEmision,cast(f.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("       cast((f.\"DocTotal\"-f.\"PaidToDate\")as numeric(18,0))as valorSaldo,cast(f.\"DocTotal\" as numeric(18,0))as valorDocumento,DAYS_BETWEEN(current_date,f.\"DocDueDate\")as diasVencidos, ");
        sb.append("       cast(((s.\"CreditLine\")-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo,cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago, ");
        sb.append("       (select max(cast(v.\"DocDate\" as date)) from OINV v where v.\"CardCode\" = f.\"CardCode\")as fechaUltComp,cast(f.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,f.\"SlpCode\",s.\"GroupNum\", ");
        sb.append("       s.\"U_addInFaElectronica_email_contacto_FE\" as emailFE ");
        sb.append("      from  OINV f ");
        sb.append("      inner join OCRD s ON f.\"CardCode\" = s.\"CardCode\" ");
        sb.append("      where f.\"DocStatus\" = 'O' union all ");
        sb.append("      select cast(n.\"CardCode\" as varchar(20))as cardCode,cast(n.\"CardName\" as varchar(100))as cardName,cast(s.\"LicTradNum\" as varchar(20))as nit, ");
        sb.append("       'Nota Crédito'as tipoDoc,cast(n.\"DocNum\" as int)as docNum,cast(n.\"DocDate\" as date)as fechaEmision,cast(n.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("       cast((n.\"DocTotal\"-n.\"PaidToDate\")*-1 as numeric(18,0))as valorSaldo,cast(n.\"DocTotal\"*-1 as numeric(18,0))as valorDocumento,DAYS_BETWEEN(current_date,n.\"DocDueDate\")as diasVencidos, ");
        sb.append("       cast(((s.\"CreditLine\")-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo,cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago, ");
        sb.append("       null as fechaUltComp,cast(n.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,n.\"SlpCode\",s.\"GroupNum\",s.\"U_addInFaElectronica_email_contacto_FE\" as emailFE ");
        sb.append("      from  ORIN n ");
        sb.append("      inner join OCRD s ON n.\"CardCode\" = s.\"CardCode\" ");
        sb.append("      where n.\"DocStatus\" = 'O' ");
        sb.append(")as t ");
        sb.append("inner join OSLP a ON a.\"SlpCode\" = t.\"SlpCode\" ");
        sb.append("inner join OCTG c ON c.\"GroupNum\" = t.\"GroupNum\" ");
        sb.append("where t.\"SlpCode\"=");
        sb.append(slpCode);
        if (cardCode != null) {
            sb.append(" and t.cardCode='");
            sb.append(cardCode);
            sb.append("' ");
        }
        sb.append(" group by t.cardCode,t.cardName,t.nit,t.tipoDoc,t.docNum,t.fechaEmision,t.fechaVencimiento,t.valorSaldo,t.valorDocumento,t.diasVencidos,a.\"SlpName\",c.\"PymntGroup\",t.cupo,t.uPromDiasPago,t.fechaUltComp,t.urlFacture,t.emailFE ");
        sb.append("order by 2 asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la cartera de los clientes. ", e);
        }
        return null;
    }

    public List<Object[]> listCustomerPortfolioByCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.cardCode,t.cardName,cast(s.\"LicTradNum\" as varchar(20))as nit,t.tipoDoc,t.docNum,t.fechaEmision,t.fechaVencimiento,t.valorSaldo,t.valorDocumento,t.diasVencidos, ");
        sb.append("       cast(a.\"SlpName\" as varchar(50))as vendedor,cast(c.\"PymntGroup\" as varchar(20))as condicionPago,cast(((s.\"CreditLine\")-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo, ");
        sb.append("       cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago,t.fechaUltComp,t.urlFacture, t.Iva, t.Subtotal, t.Descuento ");
        sb.append("from (select cast(f.\"CardCode\" as varchar(20))as cardCode, cast(f.\"CardName\" as varchar(100))as cardName, 'Factura'as tipoDoc, ");
        sb.append("             cast(f.\"DocNum\" as int)as docNum,cast(f.\"DocDate\" as date)as fechaEmision,cast(f.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("             cast((f.\"DocTotal\"-f.\"PaidToDate\")as numeric(18,0))as valorSaldo,cast(f.\"DocTotal\" as numeric(18,0))as valorDocumento, ");
        sb.append("             DAYS_BETWEEN(f.\"DocDueDate\",current_date)as diasVencidos, (select max(cast(\"DocDate\" as date)) from OINV v where v.\"CardCode\" = f.\"CardCode\")as fechaUltComp, ");
        sb.append("             cast(f.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,f.\"SlpCode\", cast(f.\"VatSum\" as numeric(18,2))as iva, ");
        sb.append("             cast((((((f.\"DocTotal\"+f.\"DiscSum\")-f.\"VatSum\")-f.\"TotalExpns\")+f.\"WTSum\")-f.\"RoundDif\")as numeric(18,2))as subtotal, cast(f.\"DiscSum\" as numeric(18,2))as descuento ");
        sb.append("      from   OINV f ");
        sb.append("      where (f.\"DocTotal\"-f.\"PaidToDate\") > 1999 and f.\"DocStatus\" = 'O' union all ");
        sb.append("      select cast(n.\"CardCode\" as varchar(20))as cardCode,cast(n.\"CardName\" as varchar(100))as cardName, 'Nota Crédito'as tipoDoc, ");
        sb.append("             cast(n.\"DocNum\" as int)as docNum,cast(n.\"DocDate\" as date)as fechaEmision,cast(n.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("             cast((n.\"DocTotal\"-n.\"PaidToDate\")*-1 as numeric(18,0))as valorSaldo,cast(n.\"DocTotal\"*-1 as numeric(18,0))as valorDocumento, ");
        sb.append("             DAYS_BETWEEN(n.\"DocDueDate\",current_date)as diasVencidos, null as fechaUltComp, ");
        sb.append("             cast(n.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,n.\"SlpCode\", cast(n.\"VatSum\" as numeric(18,2))as iva, ");
        sb.append("             cast((((((n.\"DocTotal\"+n.\"DiscSum\")-n.\"VatSum\")-n.\"TotalExpns\")+n.\"WTSum\")-n.\"RoundDif\")as numeric(18,2))as subtotal, cast(n.\"DiscSum\" as numeric(18,2))as descuento ");
        sb.append("      from   ORIN n ");
        sb.append("      where (n.\"DocTotal\"-n.\"PaidToDate\")>1999 and n.\"DocStatus\" = 'O' ");
        sb.append(")as t ");
        sb.append("inner join OCRD s ON s.\"CardCode\" = t.cardCode ");
        sb.append("inner join OSLP a ON a.\"SlpCode\" = t.\"SlpCode\" ");
        sb.append("inner join OCTG c ON c.\"GroupNum\" = s.\"GroupNum\" ");
        sb.append("where t.cardCode = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la cartera de los clientes. ", e);
        }
        return null;
    }

    public List<Object[]> listDetailAgeCustomerPortfolioBySalesPerson(String slpCode, String cardCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select r.SlpCode,r.CardCode,r.\"Sin vencer\",r.\"0 a 30\",r.\"30 a 60\",r.\"61 a 90\",r.\"91 a 120\",r.\"+ 120\",r.\"SubTotal\",cast(sum(r.\"SubTotal\")OVER(PARTITION BY r.SlpCode)as numeric(18,0))as \"Total\",r.\"E_Mail\",substring(r.\"Phone2\",0,10)as \"Phone2\" ");
        sb.append("from ( ");
        sb.append(" select cast(z.\"SlpCode\" as varchar)as SlpCode,cast(z.\"CardCode\"as varchar)as CardCode, ");
        sb.append("  cast(sum(z.\"Sin vencer\")as numeric(18,0))as \"Sin vencer\",cast(sum(z.\"0 a 30\")as numeric(18,0))as \"0 a 30\",cast(sum(z.\"30 a 60\")as numeric(18,0))as \"30 a 60\",cast(sum(z.\"61 a 90\")as numeric(18,0))as \"61 a 90\",cast(sum(z.\"91 a 120\")as numeric(18,0))as \"91 a 120\",cast(sum(z.\"+ 120\")as numeric(18,0))as \"+ 120\", ");
        sb.append("  cast(sum(z.\"Sin vencer\")+sum(z.\"0 a 30\")+sum(z.\"30 a 60\")+sum(z.\"61 a 90\")+sum(z.\"91 a 120\")+sum(z.\"+ 120\")as numeric(18,0))as \"SubTotal\",cast(z.\"E_Mail\" as varchar(100))as \"E_Mail\",cast(z.\"Phone2\" as varchar(20))as \"Phone2\" ");
        sb.append(" from ( ");
        sb.append("  select y.\"SlpCode\",y.\"CardCode\", ");
        sb.append("   case when y.\"DiasAtraso\" < 0 then sum(y.\"Saldo\") else 0 end as \"Sin vencer\", ");
        sb.append("   case when (y.\"DiasAtraso\" >= 0 and y.\"DiasAtraso\" <= 30) then sum(y.\"Saldo\") else 0 end as \"0 a 30\", ");
        sb.append("   case when (y.\"DiasAtraso\" >= 30 and y.\"DiasAtraso\" <= 60) then sum(y.\"Saldo\") else 0 end as \"30 a 60\", ");
        sb.append("   case when (y.\"DiasAtraso\" >= 61 and y.\"DiasAtraso\" <= 90) then sum(y.\"Saldo\") else 0 end as \"61 a 90\", ");
        sb.append("   case when (y.\"DiasAtraso\" >= 91 and y.\"DiasAtraso\" <= 120) then sum(y.\"Saldo\") else 0 end as \"91 a 120\", ");
        sb.append("   case when (y.\"DiasAtraso\" > 120) then sum(y.\"Saldo\") else 0 end as \"+ 120\",y.\"E_Mail\",y.\"Phone2\" ");
        sb.append("  from ( ");
        sb.append("   select t.\"SlpCode\",t.\"CardCode\",cast(t.\"DiasAtraso\" as varchar(1000))as \"DiasAtraso\",sum(cast(t.\"Saldo\" as numeric(18,0)))as \"Saldo\",t.\"E_Mail\",t.\"Phone2\" ");
        sb.append("   from ( ");
        sb.append("    select f.\"SlpCode\",f.\"CardCode\",cast((f.\"DocTotal\"-f.\"PaidToDate\")as numeric(18,0))as \"Saldo\",days_between(current_date,f.\"DocDueDate\")*-1 as \"DiasAtraso\",s.\"E_Mail\",s.\"Phone2\" ");
        sb.append("    from OINV f ");
        sb.append("    inner join OCRD s ON f.\"CardCode\"=s.\"CardCode\" ");
        sb.append("    where (f.\"DocTotal\"-f.\"PaidToDate\")>1999 and f.\"DocStatus\"='O' ");
        sb.append("   union all ");
        sb.append("    select n.\"SlpCode\",n.\"CardCode\",cast((n.\"DocTotal\"-n.\"PaidToDate\")as numeric(18,0))*-1 as \"Saldo\",days_between(current_date,n.\"DocDueDate\")*-1 as \"DiasAtraso\",s.\"E_Mail\",s.\"Phone2\" ");
        sb.append("    from ORIN n ");
        sb.append("    inner join OCRD s ON n.\"CardCode\"=s.\"CardCode\" ");
        sb.append("    where (n.\"DocTotal\"-n.\"PaidToDate\")>1999 and n.\"DocStatus\"='O' ");
        sb.append("   )as t ");
        sb.append("   group by t.\"DiasAtraso\",t.\"CardCode\",t.\"SlpCode\",t.\"E_Mail\",t.\"Phone2\" ");
        sb.append("  )as y ");
        sb.append("  group by y.\"DiasAtraso\",y.\"CardCode\",y.\"SlpCode\",y.\"E_Mail\",y.\"Phone2\" ");
        sb.append(" )as z ");
        sb.append(" where z.\"SlpCode\"=");
        sb.append(slpCode);
        if (cardCode != null) {
            sb.append(" and z.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }
        sb.append(" group by z.\"CardCode\",z.\"SlpCode\",z.\"E_Mail\",z.\"Phone2\" ");
        sb.append(" order by z.\"CardCode\" asc ");
        sb.append(")as r");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando la edad de la cartera del asesor " + slpCode + " en " + companyName, e);
        }
        return null;
    }

    public boolean updateGeolocation(GeolocationDTO dto, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(dto.getCompanyName(), pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("update OCRD set \"U_LATITUD\" = '");
        sb.append(dto.getLatitud());
        sb.append("', \"U_LONGITUD\" = '");
        sb.append(dto.getLongitud());
        sb.append("' where \"CardCode\" = '");
        sb.append(dto.getCardCode());
        sb.append("'");
        try {
            if (em.createNativeQuery(sb.toString()).executeUpdate() <= 0) {
                return false;
            } else {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar la geolocalizacion del cliente [" + dto.getCardCode() + "] en [" + dto.getCompanyName() + "]", e);
        }
        return false;
    }

    public List<Object[]> findIdAddress(String cardCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(s.\"ShipToDef\" as varchar(100))as ShipToDef, cast(s.\"BillToDef\" as varchar(100))as BillToDef ");
        sb.append("from OCRD s where s.\"CardCode\" ='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el id de direcciones para el cliente " + cardCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public boolean checkFieldDiscountCommercial(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"QryGroup12\" as varchar(1))as QryGroup12 from OCRD where \"CardCode\" = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            if (em.createNativeQuery(sb.toString()).getSingleResult().equals("Y")) {
                return true;
            } else {
                return false;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar la propiedad del SN " + cardCode, e);
        }
        return false;
    }

    public List<Object[]> listTypeDocument(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"Code\" as varchar(20))as Code,cast(\"Name\" as varchar(100))as Doc,cast(\"U_TicpoDocICA\" as varchar(5))as Tipo ");
        sb.append("from \"@BPCO_TD\" where \"Code\" not in(11,12,21,42,43)");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los tipos de documentos en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public boolean findCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"CardCode\" as varchar(20))as CardCode from OCRD where \"CardCode\" = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            if (em.createNativeQuery(sb.toString()).getSingleResult().equals(cardCode)) {
                return true;
            } else {
                return false;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando el cliente [" + cardCode + "] en [" + companyName + ']', e);
        }
        return false;
    }

    public List<ClientCalidosoDTO> listClientCalidosos(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"CardCode\" as varchar(20))as CardCode,cast(\"CardName\" as varchar(100))as CardName,cast(\"LicTradNum\" as varchar(20))as LicTradNum ");
        sb.append("from OCRD ");
        sb.append("where \"CardType\"='C' and \"validFor\"='Y' and \"QryGroup15\"='Y' and \"SlpCode\" not in ('22','81','15','19') ");
        sb.append("order by \"CardName\" asc");
        try {
            List<ClientCalidosoDTO> listConcepts = new ArrayList<>();
            for (Object[] obj : (List<Object[]>) persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList()) {
                ClientCalidosoDTO dto = new ClientCalidosoDTO();
                dto.setCardCode((String) obj[0]);
                dto.setCardName((String) obj[1]);
                dto.setLicTradNum((String) obj[2]);
                listConcepts.add(dto);
            }
            return listConcepts;


        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes activos en los calidosos. ", e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listHistoryPointsCalidosos(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from (");
        sb.append("select cast(t.\"CardCode\" as varchar(20))as \"CardCode\",cast(t.\"Programa\" as varchar(50))as \"Programa\",cast(t.\"DocNum\" as int)as \"DocNum\",cast(t.\"TypeDoc\" as varchar(2))as \"TypeDoc\",cast(TO_VARCHAR(t.\"DocDate\",'YYYY-MM-DD')as varchar(20))as \"DocDate\", ");
        sb.append(" case when t.\"Programa\"<>'Vendedor de Mostrador' then cast(sum(\"PuntosCL\")as int) else cast(sum(\"PuntosVM\")as int)end as \"Puntos\" ");
        sb.append("from (");
        sb.append("  select e.\"CardCode\",e.\"DocNum\",'FV' as \"TypeDoc\",e.\"DocDate\", ");
        sb.append("   case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0)) ");
        sb.append("    else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))end \"PuntosCL\", ");
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S') ");
        sb.append("          else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from OINV e ");
        sb.append("  inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" and c.\"U_Activo\"='Y' ");
        sb.append("  where year(e.\"DocDate\")=year(current_date) and month(e.\"DocDate\")=month(current_date) and s.\"QryGroup15\"='Y' and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");

        if (!cardCode.equals("0")) {
            sb.append(" and e.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("  group by e.\"DocNum\",m.\"Name\",m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",e.\"DocDate\",c.\"Name\" ");
        sb.append(" union all ");
        sb.append("  select e.\"CardCode\",e.\"DocNum\",'NC' as \"TypeDoc\",e.\"DocDate\", ");
        sb.append("   case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0))*-1 ");
        sb.append("    else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))*-1 end \"PuntosCL\", ");
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S'))*-1 ");
        sb.append("          else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S'))*-1 end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from ORIN e ");
        sb.append("  inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" and c.\"U_Activo\"='Y' ");
        sb.append("  where year(e.\"DocDate\")=year(current_date) and month(e.\"DocDate\")=month(current_date) and s.\"QryGroup15\"='Y' and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");

        if (!cardCode.equals("0")) {
            sb.append(" and e.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("  group by e.\"DocNum\",m.\"Name\",m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",e.\"DocDate\",c.\"Name\" ");
        sb.append(" union all ");
        sb.append("  select v.\"U_Documento\" as \"CardCode\",e.\"DocNum\",'FV' as \"TypeDoc\",e.\"DocDate\", ");
        sb.append("   case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0)) ");
        sb.append("    else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))end \"PuntosCL\", ");
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')) ");
        sb.append("          else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S'))end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from OINV e ");
        sb.append("  inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S' ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=v.\"U_Concepto\" and c.\"U_Activo\"='Y' ");
        sb.append("  where year(e.\"DocDate\")=year(current_date) and month(e.\"DocDate\")=month(current_date) and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");

        if (!cardCode.equals("0")) {
            sb.append(" and e.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("  group by e.\"DocNum\",m.\"Name\",m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",e.\"DocDate\",v.\"U_Documento\",c.\"Name\" ");
        sb.append(" union all ");
        sb.append("  select v.\"U_Documento\" as \"CardCode\",e.\"DocNum\",'NC' as \"TypeDoc\",e.\"DocDate\", ");
        sb.append("   case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\")*m.\"U_Puntos\" as numeric(18,0))*-1 ");
        sb.append("    else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*c.\"U_PorcPuntos\" as numeric(18,0))*-1 end \"PuntosCL\", ");
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S')<=0 then 0 ");
        sb.append("    else ");
        sb.append("   case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S'))*-1 ");
        sb.append("    else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S'))*-1 end");
        sb.append("   end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from ORIN e ");
        sb.append("  inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" and v.\"U_Activo\"='S' ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=v.\"U_Concepto\" and c.\"U_Activo\"='Y' ");
        sb.append("  where year(e.\"DocDate\")=year(current_date) and month(e.\"DocDate\")=month(current_date) and e.\"DiscPrcnt\"<100 and d.\"TaxOnly\"='N' ");

        if (!cardCode.equals("0")) {
            sb.append(" and e.\"CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("  group by e.\"DocNum\",m.\"Name\",m.\"U_Puntos\",c.\"U_PorcPuntos\",e.\"CardCode\",e.\"DocDate\",v.\"U_Documento\",c.\"Name\" ");
        sb.append(") as t ");
        sb.append("group by t.\"DocNum\",t.\"CardCode\",t.\"TypeDoc\",t.\"DocDate\",t.\"Programa\" ");
        sb.append(") as y ");
        sb.append("union all ");
        sb.append("select cast(\"U_CardCode\" as varchar(20))as \"CardCode\",cast(\"U_Programa\" as varchar(50))as \"Programa\",cast(\"U_DocNum\" as int)as \"DocNum\", ");
        sb.append(" cast(\"U_TypeDoc\" as varchar(2))as \"TypeDoc\",cast(TO_VARCHAR(\"U_DocDate\",'YYYY-MM-DD')as varchar(20))as \"DocDate\",cast(\"U_Puntos\" as int)as \"Puntos\" ");
        sb.append("from \"@REDENCION_HISTPUNTO\" ");

        if (!cardCode.equals("0")) {
            sb.append("where \"U_CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append(" union all ");
        sb.append("select cast(p.\"U_CardCode\" as varchar(20))as \"CardCode\",cast('REDENCIÓN' as varchar(50))as \"Programa\",cast(0 as int)as \"DocNum\", ");
        sb.append(" cast('RM' as varchar(2))as \"TypeDoc\",cast(TO_VARCHAR(p.\"U_DocDate\",'YYYY-MM-DD')as varchar(20))as \"DocDate\",cast(p.\"U_Point\" as int)*-1 as \"Puntos\" ");
        sb.append("from \"@REDENCION_PUNTOS\" p ");

        if (!cardCode.equals("0")) {
            sb.append("where p.\"U_CardCode\"='");
            sb.append(cardCode);
            sb.append("' ");
        }

        sb.append("order by y.\"TypeDoc\",y.\"DocNum\",y.\"Programa\" ASC");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los puntos para el participante " + cardCode, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listClientsWithOutResFis(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(s.\"CardCode\" as varchar(20)),cast(s.\"CardName\" as varchar(100)) ");
        sb.append("from OCRD s ");
        sb.append("left join \"@OK1_FE_RES_FIS_SN\" e on e.\"U_CardCode\" = s.\"CardCode\" ");
        sb.append("left join \"@OK1_FE_RES_FIS_SN_L\" d on d.\"DocEntry\" = e.\"DocEntry\" ");
        sb.append("where s.\"validFor\"='Y' and e.\"U_CardCode\" is null and \"CardType\"='C' and s.\"U_BPCO_TP\" = '01'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes sin responsabilidad fiscal de " + companyName);
        }
        return new ArrayList<>();
    }

    public String getSellerByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"SlpCode\" as varchar(5))as slpCode ");
        sb.append("from OCRD ");
        sb.append("where \"CardCode\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (String) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el asesor asociado al cliente " + cardCode, e);
        }
        return null;
    }

    public Object[] getIncomeAccountByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(d.\"TaxCode\" as varchar(20))as taxCode, ");
        sb.append(" case when d.\"TaxCode\"='IVAEXCLU' then '41350507' ");
        sb.append("  when d.\"TaxCode\" IN ('IVAG19','IVAV01') then '41350505' ");
        sb.append("  when d.\"TaxCode\"='IVAVEXE' then '41350510' ");
        sb.append(" else '' end as AcctCode ");
        sb.append("from OCRD s ");
        sb.append("inner join CRD1 d on s.\"CardCode\"=d.\"CardCode\" and s.\"ShipToDef\"=d.\"Address\" ");
        sb.append("where \"AdresType\"='S' and s.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo la cuenta de ingreso en ventas para el cliente " + cardCode, e);
        }
        return new Object[]{};
    }

    public BigDecimal getAvailableCreditByCustomer(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select t.\"Disponible\" ");
        sb.append("from ( ");
        sb.append(" select distinct c.\"CardCode\",c.\"CreditLine\"-c.\"Balance\"-ifnull((select sum(\"DocTotal\") from ORDR where \"DocStatus\"='O' and \"CardCode\"=c.\"CardCode\"),0)+ifnull((select sum(\"DocTotal\") from ODLN where \"DocStatus\"='O' and \"CardCode\"=c.\"CardCode\"),0)as \"Disponible\",cast( ");
        sb.append(" (select sum(rc2.\"Vlrec\"*DAYS_BETWEEN(rc2.\"Fecha_FA\",rc2.\"Fecha_RC\"))/sum(rc2.\"Vlrec\") ");
        sb.append("  from ( ");
        sb.append("   select rc1.\"Fecha_RC\" as \"Fecha_RC\",rc1.\"Vlrec\" as \"Vlrec\",rc1.\"Fecha_FA\" as \"Fecha_FA\" ");
        sb.append("   from ( ");
        sb.append("    select dc3.\"CardCode\" as \"CardCode\",dc3.\"Tipo_Doc\" as \"Tipo_Doc\",dc3.\"NroDoc\" as \"NroDoc\",dc3.\"Fecha_RC\" as \"Fecha_RC\",dc3.\"NroRec\" as \"NroRec\",dc3.\"Vlrec\" as \"Vlrec\",f.\"DocDate\" as \"Fecha_FA\" ");
        sb.append("    from ( ");
        sb.append("     select dc1.\"CardCode\" as \"CardCode\",dc1.\"Tipo_Doc\" as \"Tipo_Doc\",dc1.\"NroDoc\" as \"NroDoc\",dc1.\"Fecha_RC\" as \"Fecha_RC\",dc2.\"NroRec\" as \"NroRec\",dc2.\"Vlrec\" as \"Vlrec\" ");
        sb.append("     from ( ");
        sb.append("      select o.\"CardCode\" as \"CardCode\",o.\"ObjType\" as \"Tipo_Doc\",o.\"DocNum\" as \"NroDoc\",o.\"TaxDate\" as \"Fecha_RC\" ");
        sb.append("      from ORCT o ");
        sb.append("      inner join OCRD c on c.\"CardCode\"=o.\"CardCode\" ");
        sb.append("      inner join \"@PARAMETROS\" p on p.\"Code\"='02' ");
        sb.append("      where o.\"CardCode\"=c.\"CardCode\" and o.\"DocDate\">=ADD_MONTHS(current_date,-10) and o.\"DocDate\"<=current_date and o.\"Canceled\"='N' ");
        sb.append("     )as dc1 ");
        sb.append("    inner join (");
        sb.append("     select dc1.\"Tipo_Doc\" as \"Tipo_Doc\",dc1.\"NroDoc\" as \"NroDoc\",dc1.\"Fecha_RC\" as \"Fecha_RC\",o.\"ReconNum\" as \"NroRec\",i.\"ReconSum\" as \"Vlrec\",dc1.\"CardCode\" ");
        sb.append("     from ( ");
        sb.append("      select o.\"CardCode\" as \"CardCode\",o.\"ObjType\" as \"Tipo_Doc\",o.\"DocEntry\" as \"DocEntry_Doc\",o.\"DocNum\" as \"NroDoc\",o.\"TaxDate\" as \"Fecha_RC\",0 as \"NroRec\", 0 as \"Vlrec\" ");
        sb.append("      from ORCT o");
        sb.append("      inner join OCRD c on c.\"CardCode\"=o.\"CardCode\" ");
        sb.append("      inner join \"@PARAMETROS\" p on p.\"Code\"='02' ");
        sb.append("      where o.\"CardCode\"=c.\"CardCode\" and o.\"DocDate\">=ADD_MONTHS(current_date,-10) and o.\"DocDate\"<=current_date and o.\"Canceled\"='N' ");
        sb.append("     )as dc1 ");
        sb.append("     left join ITR1 i on i.\"SrcObjTyp\"=dc1.\"Tipo_Doc\" and i.\"SrcObjAbs\"=dc1.\"DocEntry_Doc\" ");
        sb.append("     left join OITR o on o.\"ReconNum\"=i.\"ReconNum\" ");
        sb.append("     where o.\"Canceled\"='N' and o.\"ReconType\"<>7 and o.\"ReconType\"<>5 ");
        sb.append("    )as dc2 on (dc1.\"CardCode\"=dc2.\"CardCode\" and dc1.\"Tipo_Doc\"=dc2.\"Tipo_Doc\" and dc1.\"NroDoc\"=dc2.\"NroDoc\") ");
        sb.append("   )as dc3 ");
        sb.append("   inner join OITR o on o.\"ReconNum\"=dc3.\"NroRec\" ");
        sb.append("   inner join ITR1 i on i.\"ReconNum\"=o.\"ReconNum\" and i.\"SrcObjTyp\"='13' ");
        sb.append("   inner join OINV f on f.\"DocEntry\"=i.\"SrcObjAbs\" ");
        sb.append("   where dc3.\"Tipo_Doc\"='24' and f.\"DocSubType\"<>'DN' ");
        sb.append("  )as rc1 ");
        sb.append("  group by rc1.\"CardCode\",rc1.\"Tipo_Doc\",rc1.\"NroDoc\",rc1.\"Fecha_RC\",rc1.\"NroRec\",rc1.\"Vlrec\",rc1.\"Fecha_FA\" ");
        sb.append(" )as rc2)as int)as \"PromDay\", ");
        sb.append(" (select max(days_between(\"DocDueDate\",current_date)) from OINV where \"DocStatus\"='O' and days_between(\"DocDueDate\",current_date)>10 and \"CardCode\"=c.\"CardCode\")as \"SinFacVenc\", ");
        sb.append(" ifnull((select distinct 'SI' from OINV where MONTHS_between(\"DocDate\",ADD_MONTHS(ADD_DAYS(ADD_MONTHS(ADD_DAYS(CURRENT_DATE,-EXTRACT(DAY FROM CURRENT_DATE)+1),1),-1),-1))<10 and \"CardCode\"=c.\"CardCode\"),'NO')as \"CompReciente\" ");
        sb.append(" from OCRD c ");
        sb.append(" where c.\"validFor\"='Y' and c.\"CardType\"='C' and c.\"GroupNum\"<>'-1' and c.\"Discount\"='0' ");
        sb.append(")as t ");
        sb.append("where t.\"PromDay\"<55 and t.\"CompReciente\"='SI' and \"SinFacVenc\" is null and \"Disponible\">0 and t.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (BigDecimal) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al obtener el credito disponible para el cliente " + cardCode, e);
        }
        return new BigDecimal(0);
    }

    public String getCustomerName(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"CardName\" as varchar(100))as cardName ");
        sb.append("from OCRD ");
        sb.append("where \"CardCode\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult().toString();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo el nombre del cliente para el cardCode=" + cardCode + " en " + companyName, e);
        }
        return "";
    }

    public Object[] getCustomerData(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(s.\"CardCode\" as varchar(20))as cardCode,cast(s.\"CardType\" as varchar(1))as cardType,cast(s.\"CardName\" as varchar(100))as cardName,cast(s.\"LicTradNum\" as varchar(15))as licTradNum, ");
        sb.append(" cast(s.\"GroupCode\" as int)as groupCode,cast(s.\"Phone1\" as varchar(20))as phone1,cast(s.\"Phone2\" as varchar(20))as phone2,cast(s.\"E_Mail\" as varchar(100))as eMail,cast(d.\"U_codeResFis\" as varchar(20))as uCodeResFis, ");
        sb.append(" cast(s.\"Territory\" as int)as territory,cast(s.\"SlpCode\" as varchar(5))as slpCode,cast(s.\"Free_Text\" as varchar(250))as freeText,cast(p.\"Name\" as varchar(20))as idContact,cast(p.\"FirstName\" as varchar(50))as firstName, ");
        sb.append(" cast(p.\"MiddleName\" as varchar(50))as middleName,cast(p.\"LastName\" as varchar(50))as lastName,cast(p.\"Position\" as varchar(50))as position,cast(p.\"Tel1\" as varchar(20))as tel1,cast(p.\"BirthDate\" as date)as birthDate, ");
        sb.append(" cast(s.\"BillToDef\" as varchar(100))as billToDef,cast(s.\"Address\" as varchar(100))as address,cast(s.\"State1\" as varchar(2))as state1,cast(s.\"Block\" as varchar(10))as block,cast( a.\"U_LATITUD\" as varchar(100))as uLatitud, ");
        sb.append(" cast(a.\"U_LONGITUD\" as varchar(100))as uLongitud,cast(s.\"U_BPCO_Nombre\" as varchar(50))as uBPCONombre,cast(s.\"U_BPCO_1Apellido\" as varchar(50))as uBPCO1Apellido,cast(s.\"U_BPCO_2Apellido\" as varchar(50))as uBPCO2Apellido, ");
        sb.append(" cast(s.\"U_BPCO_TDC\" as int)as uBPCOTDC,cast(s.\"U_BPCO_TP\" as varchar(5))as uBPCOTP,cast(s.\"U_BPCO_RTC\" as varchar(2))as uBPCORTC,cast(s.\"U_BPCO_City\" as varchar(10))as uBPCOCity, ");
        sb.append(" cast(s.\"U_BPCO_Address\" as varchar(100))as uBPCOAddress,cast(s.\"U_addInFaElectronica_email_contacto_FE\" as varchar(100))as uEmailFE,cast(s.\"U_REGIONAL\" as varchar(50))as uRegional,cast(s.\"GroupNum\" as int)as groupNum, ");
        sb.append(" cast(s.\"Discount\" as int)as discount,cast(s.\"VatStatus\" as varchar(1))as vatStatus,cast(s.\"CreditLine\" as numeric(18,2))as creditLine,cast(s.\"CreateDate\" as date)as createDate,cast(s.\"U_TRASP\" as varchar(2))as uTrasp, ");
        sb.append(" cast(s.\"QryGroup4\" as varchar(1))as qryGroup4,cast(s.\"QryGroup15\" as varchar(1))as qryGroup15,cast(s.\"WTLiable\" as varchar(1))as wTLiable, ");
        sb.append(" (select cast(a.\"WTCode\" as varchar(10)) from CRD4 a where a.\"WTCode\" like '%AUT3%' and a.\"CardCode\"= s.\"CardCode\")as AUT3, ");
        sb.append(" (select cast(a.\"WTCode\" as varchar(10)) from CRD4 a where a.\"WTCode\" like '%AUT4%' and a.\"CardCode\"=s.\"CardCode\")as AUT4,cast(s.\"U_PRO_FIDELIZACION\" as varchar(2))as uProFid,cast(s.\"ListNum\" as int)as listNum ");
        sb.append("from OCRD s ");
        sb.append("inner join \"CRD1\" a on a.\"CardCode\"=s.\"CardCode\" and a.\"Address\"=s.\"BillToDef\" and a.\"AdresType\"='B' ");
        sb.append("left join \"@OK1_FE_RES_FIS_SN\" e on e.\"U_CardCode\"=s.\"CardCode\" ");
        sb.append("left join \"@OK1_FE_RES_FIS_SN_L\" d on d.\"DocEntry\"=e.\"DocEntry\" ");
        sb.append("left join \"OCPR\" p on p.\"CardCode\"=s.\"CardCode\" ");
        sb.append("where s.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo los datos del cliente " + cardCode + " en " + companyName, e);
        }
        return null;
    }
}
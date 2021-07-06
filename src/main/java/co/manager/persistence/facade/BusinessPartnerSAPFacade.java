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
        sb.append("       cast(sn.\"CardName\" as varchar(50)) as Nombre, cast(sn.\"Address\" as varchar(100)) as AddressToDef, ");
        sb.append("       cast(sn.\"City\" as varchar(50)) as Localidad, cast(substring(sn.\"Phone1\",1,10) as varchar(10)) as Telefono, ");
        sb.append("       cast(substring(ifnull(sn.\"Cellular\",''),1,10) as varchar(10)) as Celular, cast(upper(sn.\"E_Mail\") as varchar(50)) as Email, ");
        sb.append("       cast(oc.\"PymntGroup\" as varchar(20)) as FormaPago, cast(((oc.\"ExtraMonth\" * 30) + oc.\"ExtraDays\") as int) as Plazo, ");
        sb.append("       cast(sn.\"CntctPrsn\" as varchar(100)) as Contacto, cast(sn.\"SlpCode\" as varchar(15)) as Vendedor, ");
        sb.append("       cast(sn.\"U_LONGITUD\" as varchar(20)) as Longitud, cast(sn.\"U_LATITUD\" as varchar(20)) as Latitud, ");
        sb.append("       cast(sn.\"ListNum\" as int) as listaPrecio, '' as Notas, ");

        if (companyName.contains("IGB")) {
            sb.append("cast(ifnull(sn.\"Discount\",0) as numeric(18,2)) as DescuentComercial, ");
        } else {
            //se envia 0 para motozone, hasta que se definan los descuentos logisticos.
            sb.append("cast(0 as numeric(18,2)) as DescuentComercial, ");
        }

        sb.append("       'N' as Condicion, case when cr.\"TaxCode\" = 'IVAG19' then 'N' else 'S' end as Excento, ");
        sb.append("       cast(((sn.\"CreditLine\" * 1.2) - sn.\"Balance\" - sn.\"OrdersBal\") as numeric(18,0)) as Cupo, ");
        sb.append("       cast(cr.\"Address\" as varchar(50)) as IdAddress, ");
        sb.append("       cast(ifnull(upper(cr.\"Street\"),'') as varchar(100)) as Address, cast(ifnull(upper(cr.\"City\"),'') as varchar(50)) as City, ");
        sb.append("       cast(ifnull(upper(cs.\"Name\"),'') as varchar(50)) as County ");
        sb.append("from   OCRD sn ");
        sb.append("inner  join CRD1 cr on cr.\"CardCode\" = sn.\"CardCode\" ");
        sb.append("inner  join OCTG oc on sn.\"GroupNum\" = oc.\"GroupNum\" ");
        sb.append("inner  join OCST cs on cs.\"Code\" = cr.\"State\" ");
        sb.append("where  sn.\"CardType\" = 'C' and sn.\"frozenFor\" = 'N' and cs.\"Country\" = 'CO' and sn.\"SlpCode\" <> -1 ");
        sb.append("       and cr.\"AdresType\" = 'S' and sn.\"SlpCode\" =");
        sb.append(slpCode);
        sb.append(" order by sn.\"CardCode\" asc, cr.\"LineNum\" DESC");
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
        sb.append("select cast(((s.\"CreditLine\"*1.2)-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo, ");
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

    public List<Object[]> listCustomerPortfolioBySalesPerson(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.cardCode,t.cardName,t.nit,t.tipoDoc,t.docNum,t.fechaEmision,t.fechaVencimiento,t.valorSaldo,t.valorDocumento,t.diasVencidos, ");
        sb.append("     cast(a.\"SlpName\" as varchar(50))as vendedor,cast(c.\"PymntGroup\" as varchar(20))as condicionPago,t.cupo,t.uPromDiasPago,t.fechaUltComp,t.urlFacture ");
        sb.append("from (select cast(f.\"CardCode\" as varchar(20))as cardCode, cast(f.\"CardName\" as varchar(20))as cardName,cast(s.\"LicTradNum\" as varchar(20))as nit, ");
        sb.append("            'Factura'as tipoDoc,cast(f.\"DocNum\" as int)as docNum,cast(f.\"DocDate\" as date)as fechaEmision,cast(f.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("            cast((f.\"DocTotal\"-f.\"PaidToDate\")as numeric(18,0))as valorSaldo,cast(f.\"DocTotal\" as numeric(18,0))as valorDocumento,DAYS_BETWEEN(current_date,f.\"DocDueDate\")as diasVencidos, ");
        sb.append("            cast(((s.\"CreditLine\"*1.2)-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo,cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago, ");
        sb.append("            (select max(cast(v.\"DocDate\" as date)) from OINV v where v.\"CardCode\" = f.\"CardCode\")as fechaUltComp,cast(f.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,f.\"SlpCode\",s.\"GroupNum\" ");
        sb.append("      from  OINV f ");
        sb.append("      inner join OCRD s ON f.\"CardCode\" = s.\"CardCode\" ");
        sb.append("      where (f.\"DocTotal\"-f.\"PaidToDate\") > 1999 and f.\"DocStatus\" = 'O' union all ");
        sb.append("      select cast(n.\"CardCode\" as varchar(20))as cardCode,cast(n.\"CardName\" as varchar(20))as cardName,cast(s.\"LicTradNum\" as varchar(20))as nit, ");
        sb.append("            'Nota Crédito'as tipoDoc,cast(n.\"DocNum\" as int)as docNum,cast(n.\"DocDate\" as date)as fechaEmision,cast(n.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("            cast((n.\"DocTotal\"-n.\"PaidToDate\")*-1 as numeric(18,0))as valorSaldo,cast(n.\"DocTotal\"*-1 as numeric(18,0))as valorDocumento,DAYS_BETWEEN(current_date,n.\"DocDueDate\")as diasVencidos, ");
        sb.append("            cast(((s.\"CreditLine\"*1.2)-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo,cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago, ");
        sb.append("            null as fechaUltComp,cast(n.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,n.\"SlpCode\",s.\"GroupNum\" ");
        sb.append("      from  ORIN n ");
        sb.append("      inner join OCRD s ON n.\"CardCode\" = s.\"CardCode\" ");
        sb.append("      where (n.\"DocTotal\"-n.\"PaidToDate\")>1999 and n.\"DocStatus\" = 'O' ");
        sb.append(")as t ");
        sb.append("inner join OSLP a ON a.\"SlpCode\" = t.\"SlpCode\" ");
        sb.append("inner join OCTG c ON c.\"GroupNum\" = t.\"GroupNum\" ");
        sb.append("where t.\"SlpCode\" IN (");
        sb.append(slpCode);
        sb.append(")");
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
        sb.append("       cast(a.\"SlpName\" as varchar(50))as vendedor,cast(c.\"PymntGroup\" as varchar(20))as condicionPago,cast(((s.\"CreditLine\"*1.2)-s.\"Balance\"-s.\"OrdersBal\")as numeric(18,0))as cupo, ");
        sb.append("       cast(s.\"U_PROM_DIAS_PAGO\" as int)as uPromDiasPago,t.fechaUltComp,t.urlFacture, t.Iva, t.Subtotal, t.Descuento ");
        sb.append("from (select cast(f.\"CardCode\" as varchar(20))as cardCode, cast(f.\"CardName\" as varchar(20))as cardName, 'Factura'as tipoDoc, ");
        sb.append("             cast(f.\"DocNum\" as int)as docNum,cast(f.\"DocDate\" as date)as fechaEmision,cast(f.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("             cast((f.\"DocTotal\"-f.\"PaidToDate\")as numeric(18,0))as valorSaldo,cast(f.\"DocTotal\" as numeric(18,0))as valorDocumento, ");
        sb.append("             DAYS_BETWEEN(current_date,f.\"DocDueDate\")as diasVencidos, (select max(cast(\"DocDate\" as date)) from OINV v where v.\"CardCode\" = f.\"CardCode\")as fechaUltComp, ");
        sb.append("             cast(f.\"U_addInFE_LinkFE\" as varchar(1000))as urlFacture,f.\"SlpCode\", cast(f.\"VatSum\" as numeric(18,2))as iva, ");
        sb.append("             cast((((((f.\"DocTotal\"+f.\"DiscSum\")-f.\"VatSum\")-f.\"TotalExpns\")+f.\"WTSum\")-f.\"RoundDif\")as numeric(18,2))as subtotal, cast(f.\"DiscSum\" as numeric(18,2))as descuento ");
        sb.append("      from   OINV f ");
        sb.append("      where (f.\"DocTotal\"-f.\"PaidToDate\") > 1999 and f.\"DocStatus\" = 'O' union all ");
        sb.append("      select cast(n.\"CardCode\" as varchar(20))as cardCode,cast(n.\"CardName\" as varchar(20))as cardName, 'Nota Crédito'as tipoDoc, ");
        sb.append("             cast(n.\"DocNum\" as int)as docNum,cast(n.\"DocDate\" as date)as fechaEmision,cast(n.\"DocDueDate\" as date)as fechaVencimiento, ");
        sb.append("             cast((n.\"DocTotal\"-n.\"PaidToDate\")*-1 as numeric(18,0))as valorSaldo,cast(n.\"DocTotal\"*-1 as numeric(18,0))as valorDocumento, ");
        sb.append("             DAYS_BETWEEN(current_date,n.\"DocDueDate\")as diasVencidos, null as fechaUltComp, ");
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
        sb.append("select cast(\"CardCode\" as varchar(20))as CardCode,cast(\"CardName\" as varchar(20))as CardName,cast(\"LicTradNum\" as varchar(20))as LicTradNum ");
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
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\") ");
        sb.append("          else cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from OINV e ");
        sb.append("  inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" ");
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
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 ");
        sb.append("          else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from ORIN e ");
        sb.append("  inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join OCRD s ON s.\"CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"=s.\"U_PRO_FIDELIZACION\" ");
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
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("    else case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")) ");
        sb.append("          else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))end ");
        sb.append("         end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from OINV e ");
        sb.append("  inner join INV1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"='01' ");
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
        sb.append("   case when (select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\")<=0 then 0 ");
        sb.append("    else ");
        sb.append("   case when m.\"U_Puntos\">0 then (cast((sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01'))*m.\"U_Puntos\" as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 ");
        sb.append("    else (cast(sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))*(select \"U_PorcPuntos\" from \"@REDENCION_CONCEPTOS\" where \"U_Activo\"='Y' and \"Code\"='01') as numeric(18,0))/(select count(v.\"U_CardCode\") from \"@REDENCION_VENDMOSTR\" v where v.\"U_CardCode\"=e.\"CardCode\"))*-1 end");
        sb.append("   end as \"PuntosVM\",c.\"Name\" as \"Programa\" ");
        sb.append("  from ORIN e ");
        sb.append("  inner join RIN1 d ON e.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("  inner join OITM a ON a.\"ItemCode\"=d.\"ItemCode\" ");
        sb.append("  inner join \"@MARCAS\" m ON m.\"Code\"=a.\"U_Marca\" ");
        sb.append("  inner join \"@REDENCION_VENDMOSTR\" v ON v.\"U_CardCode\"=e.\"CardCode\" ");
        sb.append("  inner join \"@REDENCION_CONCEPTOS\" c ON c.\"Code\"='01' ");
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
}
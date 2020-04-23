package co.manager.persistence.facade;

import co.manager.dto.CupoDTO;
import co.manager.dto.GeolocationDTO;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BusinessPartnerSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public BusinessPartnerSAPFacade() {
    }

    public List<Object[]> listCustomersBySalesPerson(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(sn.CardCode as varchar(20)) as CardCode, cast(sn.LicTradNum as varchar(20)) as Nit, ");
        sb.append("       cast(sn.CardName as varchar(50)) as Nombre, cast(sn.Address as varchar(100)) as AddressToDef, ");
        sb.append("       cast(sn.City as varchar(50)) as Localidad, cast(substring(sn.Phone1,1,10) as varchar(10)) as Telefono, ");
        sb.append("       cast(substring(isnull(sn.Cellular,''),1,10) as varchar(10)) as Celular, cast(upper(sn.E_Mail) as varchar(50)) as Email, ");
        sb.append("       cast(oc.PymntGroup as varchar(20)) as FormaPago, cast(((oc.ExtraMonth * 30) + ExtraDays) as int) as Plazo, ");
        sb.append("       cast(sn.CntctPrsn as varchar(100)) as Contacto, cast(sn.SlpCode as varchar(15)) as Vendedor, ");
        sb.append("       cast(isnull(sn.U_LONGITUD, 0) as varchar(20)) as Longitud, cast(isnull(sn.U_LATITUD, 0) as varchar(20)) as Latitud, ");
        sb.append("       cast(sn.ListNum as int) as listaPrecio, '' as Notas, cast(isnull(sn.Discount,0) as numeric(18,2)) as DescuentComercial, ");
        sb.append("       'N' as Condicion, case when cr.TaxCode = 'IVAG19' then 'N' else 'S' end as Excento, ");
        sb.append("       cast(((sn.CreditLine * 1.2) - sn.Balance - sn.OrdersBal) as numeric(18,0)) as Cupo, ");
        sb.append("       cast(cr.Address as varchar(50)) as IdAddress, ");
        sb.append("       cast(isnull(upper(cr.Street),'') as varchar(100)) as Address, cast(isnull(upper(cr.City),'') as varchar(50)) as City, ");
        sb.append("       cast(isnull(upper(cs.Name),'') as varchar(50)) as County ");
        sb.append("from   OCRD sn ");
        sb.append("inner  join CRD1 cr on cr.CardCode = sn.CardCode ");
        sb.append("inner  join OCTG oc on sn.GroupNum = oc.GroupNum ");
        sb.append("inner  join OCST cs on cs.Code = cr.State ");
        sb.append("where  sn.CardType = 'C' and sn.frozenFor = 'N' and cs.Country = 'CO' and sn.SlpCode <> -1 ");
        sb.append("       and cr.AdresType = 'S' and sn.SlpCode =");
        sb.append(slpCode);
        sb.append(" order by sn.CardCode, LineNum asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes del vendedor", e);
        }
        return null;
    }

    public String getTransportCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(U_TRASP as varchar(11)) as transport from OCRD where CardCode = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (String) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la transportadora del cliente.", e);
        }
        return null;
    }

    public CupoDTO getCustomerPortfolio(String cardCode, String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(((cast(s.CreditLine as int)*1.2)-s.Balance-s.OrdersBal)as numeric(18,0))as cupo, ");
        sb.append("       cast(s.U_PROM_DIAS_PAGO as int)as uPromDiasPago, ");
        sb.append("      (select max(cast(DocDate as date)) from OINV v where v.CardCode = s.CardCode)as fechaUltComp ");
        sb.append("from  OCRD s ");
        sb.append("where s.SlpCode =");
        sb.append(slpCode);
        sb.append(" and s.CardCode = '");
        sb.append(cardCode);
        sb.append("'");
        try {
            Object[] obj = (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
            CupoDTO dto = new CupoDTO((BigDecimal) obj[0], (Integer) obj[1], (Date) obj[2]);
            return dto;
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la cartera del cliente.", e);
        }
        return null;
    }

    public List<Object[]> listCustomerPortfolioBySalesPerson(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(f.CardCode as varchar(20))as cardCode, cast(f.CardName as varchar(20))as cardName, cast(s.LicTradNum as varchar(20))as nit, 'Factura'as tipoDoc, cast(f.DocNum as int)as docNum, ");
        sb.append("      cast(f.DocDate as date)as fechaEmision, cast(f.DocDueDate as date)as fechaVencimiento, cast((f.DocTotal-f.PaidToDate)as numeric(18,0))as valorSaldo, ");
        sb.append("      cast(f.DocTotal as numeric(18,0))as valorDocumento, cast(getdate() as int)-cast(f.DocDueDate as int)as diasVencidos, ");
        sb.append("      cast(a.SlpName as varchar(50))as vendedor, cast(c.PymntGroup as varchar(20))as condicionPago, cast(((cast(s.CreditLine as int)*1.2)-s.Balance-s.OrdersBal)as numeric(18,0))as cupo, ");
        sb.append("      cast(s.U_PROM_DIAS_PAGO as int)as uPromDiasPago, (select max(cast(DocDate as date)) from OINV v where v.CardCode = f.CardCode)as fechaUltComp, cast(f.U_addInFE_LinkFE as varchar(max))as urlFacture ");
        sb.append("from  OINV f ");
        sb.append("inner join OCRD s ON f.CardCode = s.CardCode ");
        sb.append("inner join OSLP a ON a.SlpCode = f.SlpCode ");
        sb.append("inner join OCTG c ON c.GroupNum = s.GroupNum ");
        sb.append("where (f.DocTotal-f.PaidToDate) > 1999 and f.DocStatus = 'O' and f.SlpCode =");
        sb.append(slpCode);
        sb.append(" union all ");
        sb.append("select cast(n.CardCode as varchar(20))as cardCode, cast(n.CardName as varchar(20))as cardName, cast(s.LicTradNum as varchar(20))as nit, 'Nota Crédito'as tipoDoc, cast(n.DocNum as int)as docNum, ");
        sb.append("      cast(n.DocDate as date)as fechaEmision, cast(n.DocDueDate as date)as fechaVencimiento, cast((n.DocTotal-n.PaidToDate)*-1 as numeric(18,0))as valorSaldo, ");
        sb.append("      cast(n.DocTotal*-1 as numeric(18,0))as valorDocumento, cast(getdate() as int)-cast(n.DocDueDate as int)as diasVencidos, ");
        sb.append("      cast(a.SlpName as varchar(50))as vendedor, cast(c.PymntGroup as varchar(20))as condicionPago, cast(((cast(s.CreditLine as int)*1.2)-s.Balance-s.OrdersBal)as numeric(18,0))as cupo, ");
        sb.append("      cast(s.U_PROM_DIAS_PAGO as int)as uPromDiasPago, null as fechaUltComp, cast(n.U_addInFE_LinkFE as varchar(max))as urlFacture ");
        sb.append("from  ORIN n ");
        sb.append("inner join OCRD s ON n.CardCode = s.CardCode ");
        sb.append("inner join OSLP a ON a.SlpCode = n.SlpCode ");
        sb.append("inner join OCTG c ON c.GroupNum = s.GroupNum ");
        sb.append("where (n.DocTotal-n.PaidToDate) > 1999 and n.DocStatus = 'O' and n.SlpCode =");
        sb.append(slpCode);
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la cartera de los clientes.", e);
        }
        return null;
    }

    public boolean updateGeolocation(GeolocationDTO dto, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(dto.getCompanyName(), pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("update OCRD set U_LATITUD = '");
        sb.append(dto.getLatitud());
        sb.append("', U_LONGITUD = '");
        sb.append(dto.getLongitud());
        sb.append("' where CardCode = '");
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
}
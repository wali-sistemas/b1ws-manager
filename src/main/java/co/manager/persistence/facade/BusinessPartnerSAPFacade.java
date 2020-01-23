package co.manager.persistence.facade;

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
public class BusinessPartnerSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public BusinessPartnerSAPFacade() {
    }

    public List<Object[]> getListCustomersBySeller(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(sn.CardCode as varchar(20)) as CardCode, cast(sn.LicTradNum as varchar(20)) as Nit, ");
        sb.append("       cast(sn.CardName as varchar(50)) as Nombre, cast(sn.Address as varchar(100)) as AddressToDef, ");
        sb.append("       cast(sn.City as varchar(50)) as Localidad, cast(substring(sn.Phone1,1,10) as varchar(10)) as Telefono, ");
        sb.append("       cast(substring(isnull(sn.Cellular,''),1,10) as varchar(10)) as Celular, cast(upper(sn.E_Mail) as varchar(50)) as Email, ");
        sb.append("       cast(oc.PymntGroup as varchar(20)) as FormaPago, cast(((oc.ExtraMonth * 30) + ExtraDays) as int) as Plazo, ");
        sb.append("       cast(sn.CntctPrsn as varchar(100)) as Contacto, cast(sl.U_CEDULA as varchar(15)) as Vendedor, 0 as Longitud, 0 as Latitud, ");
        sb.append("       cast(sn.ListNum as int) as listaPrecio, '' as Notas, cast(isnull(sn.Discount,0) as numeric(18,2)) as DescuentComercial, ");
        sb.append("       'N' as Condicion, case when cr.TaxCode = 'IVAG19' then 'N' else 'S' end as Excento, ");
        sb.append("       cast(((cast(sn.CreditLine as int) * 1.2) - sn.Balance - sn.OrdersBal) as numeric(18,0)) as Cupo, ");
        sb.append("       cast(row_number() over (partition by sn.CardCode order by sn.CardCode) as int) as LineNum, ");
        sb.append("       cast(isnull(upper(cr.Street),'') as varchar(100)) as Address, cast(isnull(upper(cr.City),'') as varchar(50)) as City, ");
        sb.append("       cast(isnull(upper(cs.Name),'') as varchar(50)) as County ");
        sb.append("from   OCRD sn ");
        sb.append("inner  join CRD1 cr on cr.CardCode = sn.CardCode ");
        sb.append("inner  join OCTG oc on sn.GroupNum = oc.GroupNum ");
        sb.append("inner  join OSLP sl ON sn.SlpCode = sl.SlpCode ");
        sb.append("inner  join OCST cs on cs.Code = cr.State ");
        sb.append("where  sn.CardType = 'C' and sn.frozenFor = 'N' and cs.Country = 'CO' and sn.SlpCode <> -1 ");
        sb.append("       and cr.AdresType = 'S' and sn.SlpCode =");
        sb.append(slpCode);
        sb.append(" order by sn.CardCode, LineNum asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes del vendedor [{0}] para {1}", new Object[]{slpCode, companyName});
        }
        return null;
    }

    public List<Object[]> getListCustomerAddresses(String slpCode, String companyname, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyname, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(Upper(sn.CardCode) as varchar (20)) as CardCode, cast(sn.LicTradNum as varchar(20)) as Nit, ");
        sb.append("       cast(row_number()over(partition by sn.CardCode order by sn.CardCode) as int) as CodAddress, ");
        sb.append("       cast(isnull(Upper(dr.Street),'') as varchar(100)) as Address, ");
        sb.append("       cast(isnull(Upper(dr.City),'') as varchar(50)) as City, ");
        sb.append("       cast(isnull(Upper(dp.Name),'') as varchar(50)) as County ");
        sb.append("from  OCRD sn ");
        sb.append("inner join CRD1 dr ON dr.CardCode = sn.CardCode ");
        sb.append("inner join OCTG T2 ON sn.GroupNum = T2.GroupNum ");
        sb.append("inner join OSLP ve ON sn.SlpCode = ve.SlpCode ");
        sb.append("inner join OCST dp ON dp.Code = dr.State ");
        sb.append("where sn.CardType = 'C' and sn.frozenFor = 'N' and dp.Country = 'CO' and sn.SlpCode<> -1 and dr.AdresType = 'B' and sn.CardCode = 'C10004671'");
        sb.append("order by sn.CardCode, CodAddress");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las direcciones de los clientes asignados al vendedor [{0}] para la empresa {1}", new Object[]{slpCode, companyname});
        }
        return null;
    }
}
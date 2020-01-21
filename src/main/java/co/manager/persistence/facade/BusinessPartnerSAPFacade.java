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
        sb.append("       cast(sn.CardName as varchar(50)) as Nombre, cast(sn.Address as varchar(100)) as Direccion, ");
        sb.append("       cast(sn.City as varchar(50)) as Localidad, cast(substring(sn.Phone1,1,10) as varchar(10)) as Telefono, ");
        sb.append("       cast(substring(ISNULL(sn.Cellular,''),1,10) as varchar(10)) as Celular, cast(LOWER(sn.E_Mail) as varchar(50)) as Email, ");
        sb.append("       cast(oc.PymntGroup as varchar(20)) as FormaPago, cast(((oc.ExtraMonth * 30) + ExtraDays) as int) as Plazo, ");
        sb.append("       cast(sn.CntctPrsn as varchar(100)) as Contacto, cast(sl.U_CEDULA as varchar(15)) as Vendedor, 0 as Longitud, 0 as Latitud, ");
        sb.append("       cast(sn.ListNum as int) as listaPrecio, '' as Notas, cast(isnull(sn.Discount,0) as numeric(18,2)) as DescuentComercial, ");
        sb.append("       'N' as Condicion, case when cr.TaxCode = 'IVAG19' THEN 'N' ELSE 'S' END AS Excento, ");
        sb.append("       cast(((cast(sn.CreditLine as int) * 1.2) - sn.Balance - sn.OrdersBal) as numeric(18,0)) as Cupo ");
        sb.append("from OCRD sn ");
        sb.append("inner join CRD1 cr on cr.CardCode = sn.CardCode and sn.BillToDef = cr.Address ");
        sb.append("inner join OCTG oc on sn.GroupNum = oc.GroupNum ");
        sb.append("inner join OCST cs on sn.State1 = cs.Code ");
        sb.append("inner join OSLP sl ON sn.SlpCode = sl.SlpCode ");
        sb.append("where sn.CardType = 'C' and sn.frozenFor = 'N' and cs.Country = 'CO' and sn.SlpCode <> -1 ");
        sb.append("      and cr.AdresType = 'S' and sn.SlpCode =");
        sb.append(slpCode);
        sb.append(" order by sn.CardCode asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los clientes del vendedor [{0}] para {1}", new Object[]{slpCode, companyName});
        }
        return null;
    }
}
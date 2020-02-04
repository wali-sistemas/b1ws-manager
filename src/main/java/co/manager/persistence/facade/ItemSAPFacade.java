package co.manager.persistence.facade;

import co.manager.persistence.entity.ItemSAP;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class ItemSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(ItemSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MSSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public ItemSAPFacade() {
    }

    public List<String> getListItemByPicture(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select Distinct cast(ItemCode as varchar(10)) as item from OITM ");
        sb.append("where (PicturName is null or ItemCode <> replace(PicturName, '.jpg', '')) ");
        sb.append("and validFor = 'Y' and InvntItem = 'Y'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los items sin foto en SAP.", e);
        }
        return null;
    }

    public void updateFieldPicture(String itemCode, String picturName, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<ItemSAP> cu = cb.createCriteriaUpdate(ItemSAP.class);
        Root<ItemSAP> root = cu.from(ItemSAP.class);

        cu.set(root.get("picturName"), picturName);
        cu.where(cb.equal(root.get("itemCode"), itemCode));
        try {
            em.createQuery(cu).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar el picturName para el item #[" + itemCode + "] de la empresa [" + companyName + "]");
        }
    }

    public List<Object[]> getListItems(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select distinct cast(it.ItemCode as varchar(20)) as Producto, ");
        sb.append("       cast(it.ItemName as varchar(50)) as Descripcion, ");
        sb.append("       cast(it.InvntryUom as varchar(10)) as Presentacion, cast(pre.Price as decimal(18,0)) as Precio, ");
        sb.append("       cast(imp.Rate as int) as PorcentajeIva, cast(it.DfltWH as varchar(20)) as Bodega ");
        sb.append("from  OITM it ");
        sb.append("inner join ITM1 pre on it.ItemCode = pre.itemcode ");
        sb.append("inner join OSTC imp on imp.Code = it.TaxCodeAR ");
        sb.append("inner join OITW inv on inv.ItemCode = it.ItemCode ");
        sb.append("where it.validFor = 'Y' and it.ItemType = 'I' and it.U_Marca <> '' and inv.OnHand > 0 and inv.WhsCode in ('01','05','26') and pre.PriceList =");
        if (companyName.equals("IGB")) {
            sb.append(4);
        } else {
            sb.append(1);
        }
        sb.append("order by Producto ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para [{0}]", companyName);
        }
        return null;
    }

    public List<Object[]> getPriceList(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(pr.itemcode as varchar(20)) as ItemCode, cast(pr.PriceList as int) as PriceList, cast(pr.Price as numeric(18,0)) as Price ");
        sb.append("from ITM1 pr ");
        sb.append("inner join OITM it on it.ItemCode = pr.itemcode ");
        sb.append("where it.validFor = 'Y' and it.ItemType = 'I' and it.U_Marca <> '' and PriceList =");
        if (companyName.equals("IGB")) {
            sb.append("4");
        } else {
            sb.append("1");
        }
        sb.append(" order by pr.ItemCode asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la lista de precios para {0}", companyName);
        }
        return null;
    }

    public List<Object[]> getStockWarehouseCurrent(String itemCode, String whsCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select cast(oi.ItemCode as varchar(20)) as Producto, ");
        sb.append("       cast(it.WhsCode as varchar(20)) as Bodega, ");
        sb.append("       cast(case when (select sum(de.onHandQty) ");
        sb.append("                        from OBIN ub ");
        sb.append("                        inner join oibq de on ub.AbsEntry = de.BinAbs ");
        sb.append("                        where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = oi.ItemCode) > 0 ");
        sb.append("       then (it.onHAND - it.iscommited - (select sum(de.onHandQty) ");
        sb.append("                                           from OBIN ub ");
        sb.append("                                           inner join oibq de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = oi.ItemCode)) ");
        sb.append("       else (it.onHAND - it.iscommited) end as int) as Stock ");
        sb.append("from OITM oi ");
        sb.append("inner join OITW it on it.ItemCode = oi.ItemCode ");
        sb.append("where it.WhsCode in ('01','26','28') and oi.frozenFor = 'N' and oi.SellItem = 'Y' and oi.InvntItem = 'Y' and (it.onHand - it.IsCommited) > 0 ");

        if (!itemCode.equals("0")) {
            sb.append(" and oi.ItemCode = '");
            sb.append(itemCode);
            sb.append("'");
        }

        if (!whsCode.equals("0")) {
            sb.append(" and it.WhsCode = '");
            sb.append(whsCode);
            sb.append("'");
        }

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para {0}", companyName);
        }
        return null;
    }
}
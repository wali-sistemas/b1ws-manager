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
import java.util.ArrayList;
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
        sb.append("select Distinct cast(ItemCode as varchar(20)) as item from OITM ");
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
        sb.append("select * from ( ");
        sb.append("select distinct cast(it.ItemCode as varchar(20)) as Producto, ");
        sb.append("      cast(it.ItemName as varchar(100)) as Descripcion, ");
        sb.append("      cast(it.PurPackUn as int) as Presentacion, cast(pre.Price as decimal(18,0)) as Precio, ");
        sb.append("      cast(imp.Rate as int) as PorcentajeIva, cast(it.DfltWH as varchar(20)) as Bodega, ");
        sb.append("      cast(case when (select sum(de.onHandQty) from OBIN ub inner join oibq de on ub.AbsEntry = de.BinAbs ");
        sb.append("      where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode) > 0 ");
        sb.append("      then (it.onHAND - it.iscommited - (select sum(de.onHandQty) ");
        sb.append("      from OBIN ub ");
        sb.append("      inner join oibq de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode)) ");
        sb.append("      else (it.onHAND - it.iscommited) end as int) as Stock, cast(it.PicturName as varchar(50)) as PicturName ");
        sb.append("from  OITM it ");
        sb.append("inner join ITM1 pre on it.ItemCode = pre.itemcode ");
        sb.append("inner join OSTC imp on imp.Code = it.TaxCodeAR ");
        sb.append("inner join OITW inv on inv.ItemCode = it.ItemCode ");
        sb.append("where inv.OnHand > 0 and it.validFor = 'Y' and it.ItemType = 'I' and it.U_Marca <> '' and inv.WhsCode in (");
        if (companyName.equals("IGB")) {
            //TODO: Filtro bodegas de solo ventas para IGB
            sb.append("'01', '05', '26'");
        } else {
            //TODO: Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'01', '09', '26', '44'");
        }
        sb.append(") and pre.PriceList =");
        if (companyName.equals("IGB")) {
            sb.append(4);
        } else {
            sb.append(1);
        }
        sb.append(") as t where t.Stock > 0 ");
        sb.append("order by Producto ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para [{0}]", companyName);
        }
        return null;
    }

    public List<Object[]> getListItemsExtranet(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select * from ( ");
        sb.append("select distinct cast(it.ItemCode as varchar(20))as Producto, ");
        sb.append("      cast(it.ItemName as varchar(100))as Descripcion, ");
        sb.append("      cast(it.PurPackUn as int)as Presentacion, cast(pre.Price as decimal(18,0))as Precio, ");
        sb.append("      cast(imp.Rate as int)as PorcentajeIva, cast(it.DfltWH as varchar(20))as Bodega, ");
        sb.append("      cast(case when (select sum(de.onHandQty) from OBIN ub inner join oibq de on ub.AbsEntry = de.BinAbs ");
        sb.append("      where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode) > 0 ");
        sb.append("      then (it.onHAND - it.iscommited - (select sum(de.onHandQty) ");
        sb.append("      from OBIN ub ");
        sb.append("      inner join oibq de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode)) ");
        sb.append("      else (it.onHAND - it.iscommited) end as int) as Stock, cast(it.PicturName as varchar)as PicturName, ");
        sb.append("      cast(mar.Name as varchar(20))as Marca, cast(gru.Name as varchar(20))as Grupo, cast(sub.Name as varchar(20))as Subgrupo, ");
        sb.append("      cast(it.U_Aplicacion as varchar(MAX))as ModeloMoto, cast(tll.Name as varchar(20))as TipoLlanta, cast(anc.Name as varchar(20))as AnchoLlanta, ");
        sb.append("      cast(pe.Name as varchar(20))as PerfilLlanta, cast(rin.Name as varchar(20))as RinLlanta, cast(ta.Name as varchar(20))as Talla ");
        if (companyName.equals("VARROC")) {
            //sb.append(" ,cast(l.Name as varchar(20))as Sublinea ");
            sb.append(" ,cast(null as varchar(20))as Sublinea ");
        }
        sb.append("from  OITM it ");
        sb.append("inner join ITM1 pre on it.ItemCode = pre.itemcode and pre.PriceList=");
        if (companyName.equals("IGB")) {
            sb.append(4);
        } else {
            sb.append(1);
        }
        sb.append(" inner join OSTC imp on imp.Code = it.TaxCodeAR ");
        sb.append(" inner join OITW inv on inv.ItemCode = it.ItemCode and inv.OnHand > 0 and inv.WhsCode in (");
        if (companyName.equals("IGB")) {
            //TODO: Filtro bodegas de solo ventas para IGB
            sb.append("'01', '05', '26') ");
        } else {
            //TODO: Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'01', '09', '26', '44') ");
        }
        sb.append("left  join [@MARCAS] mar on mar.Code = it.U_Marca and it.U_Marca<>'' ");
        sb.append("left  join [@GRUPOS] gru on gru.Code = it.U_Grupo ");
        sb.append("left  join [@SUBGRUPOS] sub on sub.Code = it.U_Subgrupo ");
        sb.append("left  join [@TIPO_LLANTA] tll on tll.code = it.u_tipo_llanta ");
        sb.append("left  join [@ANCHO_LLANTA] anc on anc.Code = it.U_ANCHO_LLANTA ");
        sb.append("left  join [@PERFIL_LLANTA] pe on pe.Code = it.U_PERFIL_LLANTA ");
        sb.append("left  join [@RIN_LLANTA] rin on rin.Code = it.U_RIN_LLANTA ");
        sb.append("left  join [@TALLA] ta on ta.Code = it.U_TALLA ");
        /*if (companyName.equals("VARROC")) {
            sb.append("left join [@LINEA] l on l.code = it.u_linea ");
        }*/
        sb.append("where it.validFor = 'Y' and it.ItemType = 'I' ");
        sb.append(") as t where t.Stock > 0 ");
        sb.append("order by Producto ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para [{0}]", companyName);
        }
        return new ArrayList<>();
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
        sb.append("where it.WhsCode in (");
        if (companyName.equals("IGB")) {
            //TODO: Filtro bodegas de solo ventas para IGB
            sb.append("'01', '05', '26'");
        } else {
            //TODO: Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'01', '09', '26', '44'");
        }
        sb.append(") and oi.frozenFor = 'N' and oi.SellItem = 'Y' and oi.InvntItem = 'Y' and (it.onHand - it.IsCommited) > 0 ");
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

    public List<Object[]> listItemMasterMotorepuesto() {
        EntityManager em = persistenceConf.chooseSchema("IGB", false, DB_TYPE);

        StringBuilder sb = new StringBuilder();
        sb.append("select t.*, cast(itMrto.ItemName as varchar(100))as NombreWeb, cast(prMrto.Price as numeric(18,2))as PrecioInicial, cast(0 as numeric(18,2))as PrecioOferta from ( ");
        sb.append(" select distinct cast(it.ItemCode as varchar(50))as Producto,cast(it.PurPackUn as int)as Presentacion, ");
        sb.append(" cast(19/*imp.Rate*/ as int)as PorcentajeIva, cast(it.DfltWH as varchar(50))as Bodega, ");
        sb.append(" cast(case when (select isnull(sum(de.onHandQty),0) from OBIN ub inner join oibq de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode) > 0 ");
        sb.append(" then ((select SUM(s.OnHand) from OITW s where s.WhsCode in ('01', '05', '26') and s.ItemCode = it.ItemCode)-it.iscommited-(select ");
        sb.append(" sum(de.onHandQty) from OBIN ub inner join oibq de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode)) ");
        sb.append(" else ((select SUM(s.OnHand) from OITW s where s.WhsCode in ('01', '05', '26') and s.ItemCode = it.ItemCode) - it.iscommited) end as int) as Stock, ");
        sb.append(" cast(it.PicturName as varchar)as PicturName, cast(c.Name as varchar(100))as Categoria, cast(mar.Name as varchar(50))as Marca, cast(it.U_SUBMARCA as varchar(50))as SubMarca, ");
        sb.append(" cast(gru.Name as varchar(50))as Grupo, cast(sub.Name as varchar(50))as SubGrupo, ");
        sb.append(" cast(it.U_Aplicacion as varchar(MAX))as ModeloMoto, cast(tll.Name as varchar(50))as TipoLlanta, cast(anc.Name as varchar(50))as AnchoLlanta, ");
        sb.append(" cast(pe.Name as varchar(50))as PerfilLlanta, cast(rin.Name as varchar(50))as RinLlanta, cast(ta.Name as varchar(50))as Talla, ");
        sb.append(" cast(it.U_COLOR_CADENA as varchar(50))as ColorCadena, cast(it.U_PASO_CADENA as varchar(50))as PasoCadena, null as Viscosidad, null as Base, ");
        sb.append(" cast(it.ItemCode as varchar(20))as ArticuloPadre, cast(it.U_TIPO as varchar(15))as TipoArticulo, cast(it.U_KEYWORDS as varchar(max))as Keywords ");
        sb.append(" from  OITM it ");
        //sb.append(" inner join OSTC imp on imp.Code = it.TaxCodeAR ");
        sb.append(" left  join [@MARCAS] mar on mar.Code = it.U_Marca and it.U_Marca<>'' ");
        sb.append(" left  join [@GRUPOS] gru on gru.Code = it.U_Grupo ");
        sb.append(" left  join [@SUBGRUPOS] sub on sub.Code = it.U_Subgrupo ");
        sb.append(" left  join [@TIPO_LLANTA] tll on tll.code = it.u_tipo_llanta ");
        sb.append(" left  join [@ANCHO_LLANTA] anc on anc.Code = it.U_ANCHO_LLANTA ");
        sb.append(" left  join [@PERFIL_LLANTA] pe on pe.Code = it.U_PERFIL_LLANTA ");
        sb.append(" left  join [@RIN_LLANTA] rin on rin.Code = it.U_RIN_LLANTA ");
        sb.append(" left  join [@TALLA] ta on ta.Code = it.U_TALLA ");
        sb.append(" left  join [@CATEGORIA] c on c.Code = it.U_CATEGORIA ");
        sb.append(" where it.validFor = 'Y' and it.ItemType = 'I' and it.QryGroup2 = 'Y' ");
        sb.append("UNION ALL ");
        //TODO: macth con Motozone
        sb.append(" select distinct cast(it.ItemCode as varchar(50))as Producto,cast(it.PurPackUn as int)as Presentacion, ");
        sb.append(" cast(19/*imp.Rate*/ as int)as PorcentajeIva, cast(it.DfltWH as varchar(50))as Bodega, ");
        sb.append(" cast(case when (select isnull(sum(de.onHandQty),0) from [SBOMOTOREPUESTO].[VARROC].[DBO].OBIN ub inner join [SBOMOTOREPUESTO].[VARROC].[DBO].OIBQ de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode) > 0 ");
        sb.append(" then ((select SUM(s.OnHand) from [SBOMOTOREPUESTO].[VARROC].[DBO].OITW s where s.WhsCode in ('01', '09', '26', '44') and s.ItemCode = it.ItemCode) - it.iscommited - (select ");
        sb.append(" sum(de.onHandQty) from [SBOMOTOREPUESTO].[VARROC].[DBO].OBIN ub inner join [SBOMOTOREPUESTO].[VARROC].[DBO].OIBQ de on ub.AbsEntry = de.BinAbs where ub.Attr4Val = 'N' and de.onHandQty > 0 and de.ItemCode = it.ItemCode)) ");
        sb.append(" else ((select SUM(s.OnHand) from [SBOMOTOREPUESTO].[VARROC].[DBO].OITW s where s.WhsCode in ('01', '09', '26', '44') and s.ItemCode = it.ItemCode) - it.iscommited) end as int) as Stock, ");
        sb.append(" cast(it.PicturName as varchar)as PicturName, cast(c.Name as varchar(100)) as Categoria, cast(mar.Name as varchar(50))as Marca, '' as SubMarca, ");
        sb.append(" cast(gru.Name as varchar(50))as Grupo, cast(sub.Name as varchar(50))as SubGrupo, ");
        sb.append(" cast(it.U_Aplicacion as varchar(MAX))as ModeloMoto, cast(tll.Name as varchar(50))as TipoLlanta, cast(anc.Name as varchar(50))as AnchoLlanta, ");
        sb.append(" cast(pe.Name as varchar(50))as PerfilLlanta, cast(rin.Name as varchar(50))as RinLlanta, cast(ta.Name as varchar(50))as Talla, ");
        sb.append(" null as ColorCadena, null as PasoCadena, cast(vis.Name as varchar(50))as Viscosidad, cast(bs.Name as varchar(50))as Base, ");
        sb.append(" cast(it.ItemCode as varchar(20))as ArticuloPadre, cast(it.U_TIPO as varchar(15))as TipoArticulo, cast(it.U_KEYWORDS as varchar(max))as Keywords ");
        sb.append(" from  [SBOMOTOREPUESTO].[VARROC].[DBO].OITM it ");
        //sb.append(" inner join [SBOMOTOREPUESTO].[VARROC].[DBO].OSTC imp on imp.Code = it.TaxCodeAR ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@MARCAS] mar on mar.Code = it.U_Marca and it.U_Marca<>'' ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@GRUPOS] gru on gru.Code = it.U_Grupo ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@SUBGRUPOS] sub on sub.Code = it.U_Subgrupo ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@TIPO_LLANTA] tll on tll.code = it.u_tipo_llanta ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@ANCHO_LLANTA] anc on anc.Code = it.U_ANCHO_LLANTA ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@PERFIL_LLANTA] pe on pe.Code = it.U_PERFIL_LLANTA ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@RIN_LLANTA] rin on rin.Code = it.U_RIN_LLANTA ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@TALLA] ta on ta.Code = it.U_TALLA ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@CATEGORIA] c on c.Code = it.U_CATEGORIA ");
        //sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@LINEA] lin on lin.Code = it.U_Linea ");
        //sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@SUBLINEA] subLin on subLin.Code = it.U_SUBLINEA ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@VISCOSIDAD] vis on vis.Code = it.U_VISCOSIDAD ");
        sb.append(" left  join [SBOMOTOREPUESTO].[VARROC].[DBO].[@BASE] bs on bs.Code = it.U_BASE ");
        sb.append(" where it.validFor = 'Y' and it.ItemType = 'I' and it.QryGroup2 = 'Y' ");
        sb.append(") as t ");
        sb.append("left  join [SBOMOTOREPUESTO].[VELEZ].[DBO].OITM itMrto on itMrto.ItemCode = t.Producto ");
        sb.append("left  join [SBOMOTOREPUESTO].[VELEZ].[DBO].ITM1 prMrto on prMrto.ItemCode = itMrto.ItemCode and prMrto.PriceList=1 ");
        sb.append("where t.Stock > 0 order by Producto ASC");

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar los items para motorepuesto. ", e);
        }
        return null;
    }
}
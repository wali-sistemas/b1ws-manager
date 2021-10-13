package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public ItemSAPFacade() {
    }

    public List<String> getListItemByPicture(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select Distinct cast(\"ItemCode\" as varchar(20)) as item from " + "OITM ");
        sb.append("where (\"PicturName\" is null or \"ItemCode\" <> replace(\"PicturName\", '.jpg', '')) ");
        sb.append("and \"validFor\" = 'Y' and \"InvntItem\" = 'Y'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los items sin foto en SAP. ", e);
        }
        return null;
    }

    public void updateFieldPicture(String itemCode, String picturName, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("update OITM set \"PicturName\"='");
        sb.append(picturName);
        sb.append("' where \"ItemCode\"='");
        sb.append(itemCode);
        sb.append("'");
        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar el picturName para el item #[" + itemCode + "] de la empresa [" + companyName + "]", e);
        }
    }

    public List<Object[]> getListItems(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ( ");
        sb.append("select distinct cast(it.\"ItemCode\" as varchar(20)) as Producto, ");
        sb.append("      cast(it.\"ItemName\" as varchar(100)) as Descripcion, ");
        sb.append("      cast(it.\"PurPackUn\" as int) as Presentacion, cast(pre.\"Price\" as decimal(18,0)) as Precio, ");
        sb.append("      cast(imp.\"Rate\" as int) as PorcentajeIva, cast(it.\"DfltWH\" as varchar(20)) as Bodega, ");
        sb.append("      cast(case when (select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\" = de.\"BinAbs\" ");
        sb.append("      where ub.\"Attr4Val\" = 'N' and de.\"OnHandQty\" > 0 and de.\"ItemCode\" = it. \"ItemCode\") >0 ");
        sb.append("      then(inv.\"OnHand\" - inv.\"IsCommited\" - (select sum(de.\"OnHandQty\") ");
        sb.append("      from OBIN ub ");
        sb.append("      inner join OIBQ de on ub.\"AbsEntry\" = de.\"BinAbs\" where ub.\"Attr4Val\" = 'N' and de.\"OnHandQty\" > 0 and de.\"ItemCode\" = it.\"ItemCode\")) ");
        sb.append("      else(inv. \"OnHand\" - inv. \"IsCommited\")end as int)as Stock, cast (it. \"PicturName\" as varchar (50))as PicturName ");
        sb.append("from  OITM it ");
        sb.append("inner join ITM1 pre on it.\"ItemCode\" = pre. \"ItemCode\" ");
        sb.append("inner join OSTC imp on imp.\"Code\" = it. \"TaxCodeAR\" ");
        sb.append("inner join OITW inv on inv.\"ItemCode\" = it. \"ItemCode\" ");
        sb.append("where inv.\"OnHand\" > 0 and it.\"validFor\" = 'Y' and it.\"ItemType\" = 'I' and it.\"U_Marca\" <>'' and inv.\"WhsCode\" in (");
        if (companyName.contains("IGB")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01', '30', '05', '26'");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'13', '26'");
        }
        sb.append(")and pre.\"PriceList\" =");
        if (companyName.contains("IGB")) {
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
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para " + companyName, e);
        }
        return null;
    }

    public List<Object[]> getListItemsExtranet(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,SUM(t.Stock)as Stock,t.PicturName,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("from ( ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("  cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio,cast(19 as int)as PorcentajeIva,cast(it.\"DfltWH\" as varchar(20))as Bodega, ");
        sb.append("  cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock,cast(it.\"PicturName\" as varchar)as PicturName, ");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto,cast(tll.\"Name\" as varchar(20))as TipoLlanta,cast(anc.\"Name\" as varchar(20))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(20))as PerfilLlanta,cast(rin.\"Name\" as varchar(20))as RinLlanta,cast(ta.\"Name\" as varchar(20))as Talla, ");
        sb.append("  cast(c.\"Name\" as varchar(100))as Categoria,cast(gru.\"Name\" as varchar(20))as Grupo,cast(sub.\"Name\" as varchar(20))as Subgrupo,cast(mar.\"Name\" as varchar(20))as Marca, ");
        sb.append("  cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base ");
        sb.append(" from OITM it ");
        sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=");

        if (companyName.contains("IGB")) {
            sb.append(4);
        } else {
            sb.append(1);
        }

        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in(");

        if (companyName.contains("IGB")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01','30','05','26')");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'13','26')");
        }

        sb.append(" left join \"@MARCAS\" mar on mar.\"Code\" = it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
        sb.append(" left join \"@GRUPOS\" gru on gru.\"Code\" = it.\"U_Grupo\" ");
        sb.append(" left join \"@SUBGRUPOS\" sub on sub.\"Code\" = it.\"U_Subgrupo\" ");
        sb.append(" left join \"@TIPO_LLANTA\" tll on tll.\"Code\" = it.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"@ANCHO_LLANTA\" anc on anc.\"Code\" = it.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"@PERFIL_LLANTA\" pe on pe.\"Code\" = it.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"@RIN_LLANTA\" rin on rin.\"Code\" = it.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"@TALLA\" ta on ta.\"Code\" = it.\"U_TALLA\" ");
        sb.append(" left join \"@CATEGORIA\" c on c.\"Code\" = it.\"U_CATEGORIA\" ");
        sb.append(" left join \"@VISCOSIDAD\" vis on vis.\"Code\" = it.\"U_VISCOSIDAD\" ");
        sb.append(" left join \"@BASE\" bs on bs.\"Code\" = it.\"U_BASE\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y'");
        sb.append(")as t where t.Stock>0 ");
        sb.append("group by t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,t.PicturName,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("order by Producto ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para " + companyName, e);
        }
        return new ArrayList<>();
    }

    //TODO: solo aplica para IGB y MOTOREPUESTO
    public Object[] listItemsShoppingCart(String slpCode, String itemCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select r.* ");

        if (companyName.equals("VELEZ")) {
            sb.append(",cast(prMrto.\"Price\" as decimal(18,0))as Precio ");
        }
        sb.append("from (");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");

        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in('01','30') ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");

        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='05' ");
        sb.append(" inner join OSLP ase on inv.\"WhsCode\" = ase.\"Telephone\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' and it.\"U_Marca\"<>'96' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");

        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in('05','26') ");
        sb.append(" inner join OSLP ase on inv.\"WhsCode\" = ase.\"Telephone\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' and it.\"U_Marca\"='96' and ase.\"SlpCode\"=");
        sb.append(slpCode);
        sb.append(")as r ");

        if (companyName.equals("VELEZ")) {
            sb.append("inner join \"VELEZ\".OITM itMrto on itMrto.\"ItemCode\"=r.Producto and itMrto.\"validFor\"='Y' ");
            sb.append("inner join \"VELEZ\".ITM1 prMrto on prMrto.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto.\"PriceList\"=1 ");
        }
        sb.append("where r.Stock>0 and r.Producto='");
        sb.append(itemCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema("IGB", pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando el stock de los items agregados en el carrito de compras de la extranet. ", e);
        }
        return null;
    }

    //TODO: solo aplica para IGB
    public List<Object[]> getListItemsExtranetBySeller(String slpCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,SUM(t.Stock)as Stock,t.PicturName,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("from (");
        sb.append(" select r.*,cast(19 as int)as PorcentajeIva,cast(tll.\"Name\" as varchar(20))as TipoLlanta,cast(anc.\"Name\" as varchar(20))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(20))as PerfilLlanta,cast(rin.\"Name\" as varchar(20))as RinLlanta,cast(ta.\"Name\" as varchar(20))as Talla, ");
        sb.append("  cast(c.\"Name\" as varchar(100))as Categoria,cast(gru.\"Name\" as varchar(20))as Grupo,cast(sub.\"Name\" as varchar(20))as Subgrupo, ");
        sb.append("  cast(mar.\"Name\" as varchar(20))as Marca,cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base");
        sb.append(" from ( ");
        sb.append("  select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("   cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio,cast(it.\"DfltWH\" as varchar(20))as Bodega, ");
        sb.append("   cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("   then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("   else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock, cast(it.\"PicturName\" as varchar)as PicturName,cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto ");
        sb.append("  from OITM it ");
        sb.append("  inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        sb.append("  inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in('01','30') ");
        sb.append("  where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append(" union all ");
        sb.append("  select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("   cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio,cast(it.\"DfltWH\" as varchar(20))as Bodega, ");
        sb.append("   cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("   then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("   else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock,cast(it.\"PicturName\" as varchar)as PicturName,cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto ");
        sb.append("  from OITM it ");
        sb.append("  inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        sb.append("  inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='05' ");
        sb.append("  inner join OSLP ase on inv.\"WhsCode\" = ase.\"Telephone\" ");
        sb.append("  where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' and it.\"U_Marca\"<>'96' ");
        sb.append(" union all ");
        sb.append("  select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("   cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio,cast(inv.\"WhsCode\" as varchar(20))as Bodega, ");
        sb.append("   cast(case when(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("   then (inv.\"OnHand\"-inv.\"IsCommited\"-(select sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("   else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock,cast(it.\"PicturName\" as varchar)as PicturName,cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto ");
        sb.append("  from OITM it ");
        sb.append("  inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        sb.append("  inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in('05','26') ");
        sb.append("  inner join OSLP ase on inv.\"WhsCode\" = ase.\"Telephone\" ");
        sb.append("  where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' and it.\"U_Marca\"='96' and ase.\"SlpCode\"=");
        sb.append(slpCode);
        sb.append("  )as r ");
        sb.append(" inner join OITM it on it.\"ItemCode\" = r.Producto ");
        sb.append(" left  join \"@MARCAS\" mar on mar.\"Code\" = it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
        sb.append(" left  join \"@GRUPOS\" gru on gru.\"Code\" = it.\"U_Grupo\" ");
        sb.append(" left  join \"@SUBGRUPOS\" sub on sub.\"Code\" = it.\"U_Subgrupo\" ");
        sb.append(" left  join \"@TIPO_LLANTA\" tll on tll.\"Code\" = it.\"U_TIPO_LLANTA\" ");
        sb.append(" left  join \"@ANCHO_LLANTA\" anc on anc.\"Code\" = it.\"U_ANCHO_LLANTA\" ");
        sb.append(" left  join \"@PERFIL_LLANTA\" pe on pe.\"Code\" = it.\"U_PERFIL_LLANTA\" ");
        sb.append(" left  join \"@RIN_LLANTA\" rin on rin.\"Code\" = it.\"U_RIN_LLANTA\" ");
        sb.append(" left  join \"@TALLA\" ta on ta.\"Code\" = it.\"U_TALLA\" ");
        sb.append(" left  join \"@CATEGORIA\" c on c.\"Code\" = it.\"U_CATEGORIA\" ");
        sb.append(" left  join \"@VISCOSIDAD\" vis on vis.\"Code\" = it.\"U_VISCOSIDAD\" ");
        sb.append(" left  join \"@BASE\" bs on bs.\"Code\" = it.\"U_BASE\" ");
        sb.append(" where r.Stock>0");
        sb.append(")as t ");
        sb.append("where t.Stock>0 ");
        sb.append("group by t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,t.PicturName,t.ModeloMoto,t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("order by Producto ASC");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual para " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> getPriceList(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(pr.\"ItemCode\" as varchar(20)) as ItemCode, cast(pr.\"PriceList\" as int) as PriceList, cast(pr.\"Price\" as numeric(18,0)) as Price ");
        sb.append("from ITM1 pr ");
        sb.append("inner join OITM it on it.\"ItemCode\" = pr.\"ItemCode\" ");
        sb.append("where it.\"validFor\" = 'Y' and it.\"ItemType\" = 'I' and it.\"U_Marca\" <> '' and \"PriceList\" =");
        if (companyName.contains("IGB")) {
            sb.append("4");
        } else {
            sb.append("1");
        }
        sb.append(" order by pr.\"ItemCode\" asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando la lista de precios para " + companyName, e);
        }
        return null;
    }

    public List<Object[]> getStockWarehouseCurrent(String itemCode, String whsCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ( ");
        sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (select sum(de.\"OnHandQty\") ");
        sb.append(" from OBIN ub ");
        sb.append(" inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append(" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-(select sum(de.\"OnHandQty\") ");
        sb.append("  from OBIN ub ");
        sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) ");
        sb.append(" else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
        sb.append(" from OITM oi ");
        sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
        sb.append(" where it.\"WhsCode\" in (");
        if (companyName.contains("IGB")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01','30','05','26'");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'13','26'");
        }
        sb.append(") and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
        if (!itemCode.equals("0")) {
            sb.append(" and oi.\"ItemCode\"='");
            sb.append(itemCode);
            sb.append("'");
        }
        if (!whsCode.equals("0")) {
            sb.append(" and it.\"WhsCode\"='");
            sb.append(whsCode);
            sb.append("'");
        }
        sb.append(")as t where t.Stock>=0");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para " + companyName, e);
        }
        return null;
    }

    public List<Object[]> listItemMasterMotorepuesto() {
        EntityManager em = persistenceConf.chooseSchema("IGB", false, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.*,cast(itMrto.\"ItemName\" as varchar(100))as NombreWeb,cast(prMrto.\"Price\" as numeric(18,2))as PrecioInicial,cast(prMrto2.\"Price\" as numeric(18,2))as PrecioOferta, ");
        sb.append(" cast(itMrto.\"U_DESCRIPCION_LARGA\" as varchar(1000))as DescripcionLarga,cast(itMrto.\"QryGroup2\" as varchar(100))as UltimasOfertas from(");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(50))as Producto,cast(it.\"InvntryUom\" as varchar(15))as Presentacion, ");
        sb.append(" cast(19 as int)as PorcentajeIva,cast(it.\"DfltWH\" as varchar(50))as Bodega, ");
        sb.append(" cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append(" then((select SUM(s.\"OnHand\") from OITW s where s.\"WhsCode\" in('01','30','05','26') and s.\"ItemCode\"=it.\"ItemCode\")-it.\"IsCommited\"-(select ");
        sb.append(" sum(de.\"OnHandQty\") from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append(" else((select SUM(s.\"OnHand\") from OITW s where s.\"WhsCode\" in('01','30','05','26') and s.\"ItemCode\"=it.\"ItemCode\")-it.\"IsCommited\") end as int)as Stock, ");
        sb.append(" cast(it.\"PicturName\" as varchar)as PicturName,cast(c.\"Name\" as varchar(100))as Categoria,cast(mar.\"Name\" as varchar(50))as Marca,cast(it.\"U_SUBMARCA\" as varchar(50))as SubMarca, ");
        sb.append(" cast(gru.\"Name\" as varchar(50))as Grupo,cast(sub.\"Name\" as varchar(50))as SubGrupo, ");
        sb.append(" cast(it.\"U_Aplicacion\" as varchar(1000))as ModeloMoto,cast(tll.\"Name\" as varchar(50))as TipoLlanta,cast(anc.\"Name\" as varchar(50))as AnchoLlanta, ");
        sb.append(" cast(pe.\"Name\" as varchar(50))as PerfilLlanta,cast(rin.\"Name\" as varchar(50))as RinLlanta,cast(ta.\"Name\" as varchar(50))as Talla, ");
        sb.append(" cast(it.\"U_COLOR_CADENA\" as varchar(50))as ColorCadena,cast(it.\"U_PASO_CADENA\" as varchar(50))as PasoCadena,null as Viscosidad,null as Base, ");
        sb.append(" cast(it.\"U_TIPO\" as varchar(15))as TipoArticulo,cast(it.\"U_KEYWORDS\" as varchar(1000))as Keywords, ");
        sb.append(" cast(it.\"U_ARTICULO\" as varchar(20))as ArticuloPadre,cast(pp.\"Name\" as varchar(100))as DescripPadre ");
        sb.append(" from OITM it ");
        sb.append(" left join \"@MARCAS\" mar on mar.\"Code\"=it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
        sb.append(" left join \"@GRUPOS\" gru on gru.\"Code\"=it.\"U_Grupo\" ");
        sb.append(" left join \"@SUBGRUPOS\" sub on sub.\"Code\"=it.\"U_Subgrupo\" ");
        sb.append(" left join \"@TIPO_LLANTA\" tll on tll.\"Code\"=it.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"@ANCHO_LLANTA\" anc on anc.\"Code\"=it.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"@PERFIL_LLANTA\" pe on pe.\"Code\"=it.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"@RIN_LLANTA\" rin on rin.\"Code\"=it.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"@TALLA\" ta on ta.\"Code\"=it.\"U_TALLA\" ");
        sb.append(" left join \"@CATEGORIA\" c on c.\"Code\"=it.\"U_CATEGORIA\" ");
        sb.append(" left join \"@PRODUCTO_PADRE\" pp on pp.\"Code\"=it.\"U_ARTICULO\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"QryGroup2\"='Y' ");
        sb.append("UNION ALL ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(50))as Producto,cast(it.\"PurPackMsr\" as varchar(15))as Presentacion, ");
        sb.append(" cast(19 as int)as PorcentajeIva,cast(it.\"DfltWH\" as varchar(50))as Bodega, ");
        sb.append(" cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from \"VARROC\".OBIN ub inner join \"VARROC\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append(" then((select SUM(s.\"OnHand\") from \"VARROC\".OITW s where s.\"WhsCode\" in('13','26','PUBLICID','80','81','48') and s.\"ItemCode\"=it.\"ItemCode\")-it.\"IsCommited\"-(select ");
        sb.append(" sum(de.\"OnHandQty\") from \"VARROC\".OBIN ub inner join \"VARROC\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append(" else((select SUM(s.\"OnHand\") from \"VARROC\".OITW s where s.\"WhsCode\" in('13','26','PUBLICID','80','81','48') and s.\"ItemCode\"=it.\"ItemCode\")-it.\"IsCommited\") end as int)as Stock, ");
        sb.append(" cast(it.\"PicturName\" as varchar)as PicturName,cast(c.\"Name\" as varchar(100))as Categoria,cast(mar.\"Name\" as varchar(50))as Marca,'' as SubMarca, ");
        sb.append(" cast(gru.\"Name\" as varchar(50))as Grupo,cast(sub.\"Name\" as varchar(50))as SubGrupo, ");
        sb.append(" cast(it.\"U_Aplicacion\" as varchar(1000))as ModeloMoto,cast(tll.\"Name\" as varchar(50))as TipoLlanta,cast(anc.\"Name\" as varchar(50))as AnchoLlanta, ");
        sb.append(" cast(pe.\"Name\" as varchar(50))as PerfilLlanta,cast(rin.\"Name\" as varchar(50))as RinLlanta,cast(ta.\"Name\" as varchar(50))as Talla, ");
        sb.append(" null as ColorCadena,null as PasoCadena,cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base, ");
        sb.append(" cast(it.\"U_TIPO\" as varchar(15))as TipoArticulo,cast(it.\"U_KEYWORDS\" as varchar(1000))as Keywords, ");
        sb.append(" cast(it.\"U_ARTICULO\" as varchar(20))as ArticuloPadre,cast(pp.\"Name\" as varchar(100))as DescripPadre ");
        sb.append(" from \"VARROC\".OITM it ");
        sb.append(" left join \"VARROC\".\"@MARCAS\" mar on mar.\"Code\"=it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
        sb.append(" left join \"VARROC\".\"@GRUPOS\" gru on gru.\"Code\"=it.\"U_Grupo\" ");
        sb.append(" left join \"VARROC\".\"@SUBGRUPOS\" sub on sub.\"Code\"=it.\"U_Subgrupo\" ");
        sb.append(" left join \"VARROC\".\"@TIPO_LLANTA\" tll on tll.\"Code\"=it.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@ANCHO_LLANTA\" anc on anc.\"Code\"=it.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@PERFIL_LLANTA\" pe on pe.\"Code\"=it.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@RIN_LLANTA\" rin on rin.\"Code\"=it.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@TALLA\" ta on ta.\"Code\"=it.\"U_TALLA\" ");
        sb.append(" left join \"VARROC\".\"@CATEGORIA\" c on c.\"Code\"=it.\"U_CATEGORIA\" ");
        sb.append(" left join \"VARROC\".\"@VISCOSIDAD\" vis on vis.\"Code\"=it.\"U_VISCOSIDAD\" ");
        sb.append(" left join \"VARROC\".\"@BASE\" bs on bs.\"Code\"=it.\"U_BASE\" ");
        sb.append(" left join \"VARROC\".\"@PRODUCTO_PADRE\" pp on pp.\"Code\"=it.\"U_ARTICULO\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"QryGroup2\"='Y' ");
        sb.append(")as t ");
        sb.append("inner join \"VELEZ\".OITM itMrto on itMrto.\"ItemCode\"=t.Producto and itMrto.\"validFor\"='Y' ");
        sb.append("inner join \"VELEZ\".ITM1 prMrto on prMrto.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto.\"PriceList\"=1 ");
        sb.append("inner join \"VELEZ\".ITM1 prMrto2 on prMrto2.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto2.\"PriceList\"=2 ");
        sb.append("order by Producto ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar los items para motorepuesto. ", e);
        }
        return null;
    }

    public List<String> listItemsPendingSyncMrco(String companyName, boolean pruebas) {
        //listar items pendientes por crear en bd motorepuestos.
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct cast(it.\"ItemCode\" as varchar(20))as item ");
        sb.append("from OITM it ");
        sb.append("left join \"VELEZ\".OITM itMrto on itMrto.\"ItemCode\"=it.\"ItemCode\" ");
        sb.append("where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"QryGroup2\"='Y' and itMrto.\"ItemName\" is null ");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar los items pendientes por crear en motorepuesto. ", e);
        }
        return null;
    }

    public List<Object[]> listStockSAPModula(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(art.\"ItemCode\" as varchar(20))as itemCode, ");
        sb.append(" cast(art.\"ItemName\" as varchar(200))as itemName, ");
        sb.append(" cast(sal.\"OnHand\"-sal.\"IsCommited\" as int)as qty, ");
        sb.append(" cast(sal.\"WhsCode\" as varchar(10))as whsCode, ");
        sb.append(" 'SAP' as binCode, ");
        sb.append(" cast(alm.\"WhsName\" as varchar(30))as whsName ");
        sb.append("from OITM art ");
        sb.append("inner join OITW sal on sal.\"ItemCode\"=art.\"ItemCode\" ");
        sb.append("inner join OWHS alm on alm.\"WhsCode\"=sal.\"WhsCode\" ");
        sb.append("where sal.\"OnHand\">0 and sal.\"WhsCode\"='30' and art.\"validFor\"='Y' and art.\"ItemType\"='I' and art.\"SellItem\"='Y'");
        sb.append("order by art.\"ItemCode\"");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual de modula en SAP. ", e);
            return null;
        }
        return new ArrayList<>();
    }

    public Integer listStockSAPModulaByItem(String itemCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(sal.\"OnHand\" as int)as qty ");
        sb.append("from OITM art ");
        sb.append("inner join OITW sal on sal.\"ItemCode\"=art.\"ItemCode\" ");
        sb.append("inner join OWHS alm on alm.\"WhsCode\"=sal.\"WhsCode\" ");
        sb.append("where sal.\"OnHand\">0 and sal.\"WhsCode\"='30' and art.\"validFor\"='Y' and art.\"ItemType\"='I' and art.\"SellItem\"='Y' and art.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("' order by art.\"ItemCode\"");
        try {
            return (Integer) persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el stock actual de modula en SAP. ", e);
            return null;
        }
        return 0;
    }

    public List<Object[]> listItemsToSyncModula(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct cast(a.\"ItemCode\" as varchar(20))as itemCode,cast(a.\"ItemName\" as varchar(200))as itemName, ");
        sb.append(" cast(s.\"MinStock\" as int)as StockMin,cast(s.\"MaxStock\" as int)as StockMax, ");
        sb.append(" cast(a.\"validFor\" as varchar(1))as Active,cast(a.\"SWidth1\" as int)as Ancho, ");
        sb.append(" cast(a.\"SLength1\" as int)as Largo,cast(a.\"SHeight1\" as int)as Alto,cast(a.\"SWeight1\" as int)as Peso ");
        sb.append("from OITM a ");
        sb.append("inner join OITW s on s.\"ItemCode\"=a.\"ItemCode\" ");
        sb.append("where s.\"WhsCode\"='30' and a.\"QryGroup3\"='Y' order by 1");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los items habilitados para modula.", e);
        }
        return null;
    }

    public Object[] getStockItemMDLvsSAP(String itemCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select sum(\"StockMDL\")as StockMDL,sum(\"StockCDI\")as StockCDI from (");
        sb.append(" select cast(sum(s.\"OnHand\"-s.\"IsCommited\") as int)as \"StockMDL\",0 as \"StockCDI\" ");
        sb.append(" from \"OITW\" s ");
        sb.append(" where s.\"OnHand\">0 and s.\"WhsCode\"='30' and s.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("' union all ");
        sb.append(" select 0 as \"StockMDL\",cast(case when");
        sb.append("  (select sum(de.\"OnHandQty\") ");
        sb.append("   from OBIN ub ");
        sb.append("   inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("   where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"WhsCode\"='01' and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-");
        sb.append("   (select sum(de.\"OnHandQty\") ");
        sb.append("    from OBIN ub ");
        sb.append("    inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("    where ub.\"Attr4Val\"='N' and de.\"OnHandQty\">0 and de.\"WhsCode\"='01' and de.\"ItemCode\"=it.\"ItemCode\") ");
        sb.append("  )else (inv.\"OnHand\"-inv.\"IsCommited\")end as int)as \"StockCDI\" ");
        sb.append(" from OITM it");
        sb.append(" inner join OITW inv on inv.\"ItemCode\"=it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='01' ");
        sb.append(" where it.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("')as t");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando en SAP el stock actual del item [" + itemCode + "] en modula.", e);
        }
        return null;
    }

    public void updateFieldSyncModula(String itemCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OITM set \"QryGroup3\"='N' where \"ItemCode\"='");
        sb.append(itemCode);
        sb.append("'");
        try {
            persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el UDF sync-modula para el item[" + itemCode + "]", e);
        }
    }
}
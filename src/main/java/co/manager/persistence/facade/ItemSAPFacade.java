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

    public List<Object[]> getListItemsExtranet(String slpCode, String companyName, String statusModula, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,SUM(t.Stock)as Stock,t.PicturName,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("from ( ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("  cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio, ");
        sb.append("  case when it.\"TaxCodeAR\" in ('IVAVEXE','IVAEXCLU') then 0 else 19 end as PorcentajeIva,cast(it.\"DfltWH\" as varchar(20))as Bodega, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in(");
        if (companyName.contains("IGB") && statusModula.equals("true")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01','30','05','26','32','35','60','55'");
        } else if (companyName.contains("IGB") && statusModula.equals("false")) {
            //Filtro bodegas de solo ventas para IGB
            sb.append("'01','05','26','32','35','60','55'");
        } else if (companyName.contains("REDPLAS")) {
            sb.append("01");
        } else {
            //Filtro bodegas de solo ventas para MOTOZONE
            sb.append("'13','26','32','35'");
        }
        sb.append(") and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then ((select ifnull(sum(\"OnHand\"),0) from OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in(");
        if (companyName.contains("IGB") && statusModula.equals("true")) {
            sb.append("'01','30','05','26','32','35','60','55'");
        } else if (companyName.contains("IGB") && statusModula.equals("false")) {
            sb.append("'01','05','26','32','35','60','55'");
        } else if (companyName.contains("REDPLAS")) {
            sb.append("01");
        } else {
            sb.append("'13','26','32','35'");
        }
        sb.append("))-it.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in(");
        if (companyName.contains("IGB") && statusModula.equals("true")) {
            sb.append("'01','30','05','26','32','35','60','55'");
        } else if (companyName.contains("IGB") && statusModula.equals("false")) {
            sb.append("'01','05','26','32','35','60','55'");
        } else if (companyName.contains("REDPLAS")) {
            sb.append("01");
        } else {
            sb.append("'13','26','32','35'");
        }
        sb.append(") and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else ((select ifnull(sum(\"OnHand\"),0) from OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in(");
        if (companyName.contains("IGB") && statusModula.equals("true")) {
            sb.append("'01','30','05','26','32','35','60','55'");
        } else if (companyName.contains("IGB") && statusModula.equals("false")) {
            sb.append("'01','05','26','32','35','60','55'");
        } else if (companyName.contains("REDPLAS")) {
            sb.append("01");
        } else {
            sb.append("'13','26','32','35'");
        }
        sb.append("))-it.\"IsCommited\") end as int)as Stock,cast(it.\"PicturName\" as varchar)as PicturName,");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto,cast(tll.\"Name\" as varchar(20))as TipoLlanta,cast(anc.\"Name\" as varchar(20))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(20))as PerfilLlanta,cast(rin.\"Name\" as varchar(20))as RinLlanta,cast(ta.\"Name\" as varchar(20))as Talla, ");
        sb.append("  cast(c.\"Name\" as varchar(100))as Categoria,cast(gru.\"Name\" as varchar(20))as Grupo,cast(sub.\"Name\" as varchar(20))as Subgrupo,cast(mar.\"Name\" as varchar(20))as Marca, ");
        sb.append("  cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base ");
        sb.append(" from OITM it ");
        sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=");
        if (companyName.contains("IGB") && !slpCode.equals("267")) {
            sb.append(4);
        } else if (slpCode.equals("267")) {
            sb.append(8);
        } else {
            sb.append(1);
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\" in(");
        if (companyName.contains("IGB") && statusModula.equals("true")) {
            sb.append("'01','30','05','26','32','35','60','55'");
        } else if (companyName.contains("IGB") && statusModula.equals("false")) {
            sb.append("'01','05','26','32','35','60','55'");
        } else if (companyName.contains("REDPLAS")) {
            sb.append("01");
        } else {
            sb.append("'13','26','32','35'");
        }
        sb.append(") left join \"@MARCAS\" mar on mar.\"Code\" = it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
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
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append(")as t where t.Stock>0 ");
        if (slpCode.equals("267")) {
            sb.append(" and t.Precio>0 ");
        }
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
    public Object[] listItemsShoppingCart(String itemCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select r.Producto,sum(r.Stock)as Stock ");
        if (companyName.equals("VELEZ")) {
            sb.append(",cast(prMrto.\"Price\" as decimal(18,0))as Precio ");
        } else {
            sb.append(",r.Precio ");
        }
        sb.append("from (");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('01','30') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('01','30') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
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
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='05' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='05' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='05' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='26' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='26' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='26' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='35' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='35' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='35' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='60' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='60' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='60' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='55' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='55' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='55' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='13' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='13' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='13' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append("union all ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='32' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='32' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else (inv.\"OnHand\"-inv.\"IsCommited\") end as int)as Stock ");
        if (companyName.equals("IGB")) {
            sb.append(",cast(pre.\"Price\" as decimal(18,0))as Precio ");
            sb.append(" from OITM it ");
            sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=4 ");
        } else {
            sb.append(" from OITM it ");
        }
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='32' ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"InvntItem\"='Y' and it.\"SellItem\"='Y' ");
        sb.append(")as r ");
        if (companyName.equals("VELEZ")) {
            sb.append("inner join \"VELEZ\".OITM itMrto on itMrto.\"ItemCode\"=r.Producto and itMrto.\"validFor\"='Y' ");
            sb.append("inner join \"VELEZ\".ITM1 prMrto on prMrto.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto.\"PriceList\"=1 ");
        }
        sb.append("where /*r.Stock>0 and*/ r.Producto='");
        sb.append(itemCode);
        sb.append("' group by r.Producto ");
        if (companyName.equals("VELEZ")) {
            sb.append(",prMrto.\"Price\"");
        } else {
            sb.append(",r.Precio");
        }
        try {
            return (Object[]) persistenceConf.chooseSchema("IGB", pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException e) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando el stock del item [" + itemCode + "] agregado en el carrito de compras para " + companyName, e);
        }
        return null;
    }

    //TODO: solo aplica para REDPLAS
    public List<Object[]> getListItemsBySellerRedPlas(String slpCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Descripcion,t.Presentacion,t.Precio,t.PorcentajeIva,t.Bodega,t.Stock,t.PicturName,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.Categoria,t.Grupo,t.Subgrupo,Marca,t.Viscosidad,t.Base ");
        sb.append("from ( ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(20))as Producto,cast(it.\"ItemName\" as varchar(100))as Descripcion, ");
        sb.append("  cast(it.\"InvntryUom\" as varchar(15))as Presentacion,cast(pre.\"Price\" as decimal(18,0))as Precio, ");
        sb.append("  case when it.\"TaxCodeAR\" in ('IVAVEXE','IVAEXCLU') then 0 else 19 end as PorcentajeIva, ");
        sb.append("  cast(it.\"DfltWH\" as varchar(20))as Bodega,0 as Stock,cast(it.\"PicturName\" as varchar)as PicturName, ");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(100))as ModeloMoto,cast(tll.\"Name\" as varchar(20))as TipoLlanta, ");
        sb.append("  cast(anc.\"Name\" as varchar(20))as AnchoLlanta, cast(pe.\"Name\" as varchar(20))as PerfilLlanta,cast(rin.\"Name\" as varchar(20))as RinLlanta, ");
        sb.append("  cast(ta.\"Name\" as varchar(20))as Talla, cast(c.\"Name\" as varchar(100))as Categoria,cast(gru.\"Name\" as varchar(20))as Grupo, ");
        sb.append("  cast(sub.\"Name\" as varchar(20))as Subgrupo,cast(mar.\"Name\" as varchar(20))as Marca,cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base ");
        sb.append(" from OITM it ");
        sb.append(" inner join ITM1 pre on it.\"ItemCode\" = pre.\"ItemCode\" and pre.\"PriceList\"=1 ");
        sb.append(" inner join OITW inv on inv.\"ItemCode\" = it.\"ItemCode\" ");
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
        sb.append(" where it.\"validFor\"='Y' and it.\"SellItem\"='Y' and it.\"QryGroup10\"='Y'");
        sb.append(" order by 1 ");
        sb.append(")as t ");
        sb.append("order by Producto ASC ");
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

    public List<Object[]> getStockWarehouseCurrent(String itemCode, String whsCode, String companyName, String statusModula, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Bodega,sum(t.Stock)as Stock from ( ");
        if (companyName.contains("VARROC")) {
            //LINK MTZ - SOLO LUBRICANTES Y LLANTAS
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
            sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
            sb.append("  from OBIN ub ");
            sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
            sb.append("  where de.\"WhsCode\"='13' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
            sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='13' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
            sb.append(" from OITM oi ");
            sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
            sb.append(" where it.\"WhsCode\"='13' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
            if (!itemCode.equals("0")) {
                sb.append("and oi.\"ItemCode\"='");
                sb.append(itemCode);
                sb.append("'");
            }
            sb.append(" union all ");
        } else {
            if (statusModula.equals("true")) {
                //MDL IGB
                //TODO: se fija bodega 01 para modula, debido a que unificamos la bodega 30 en la 01
                sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast('01' as varchar(20))as Bodega,cast(case when (");
                sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
                sb.append("  from OBIN ub ");
                sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
                sb.append("  where de.\"WhsCode\"='30' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
                sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='30' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
                sb.append(" from OITM oi ");
                sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
                sb.append(" where it.\"WhsCode\"='30' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
                if (!itemCode.equals("0")) {
                    sb.append("and oi.\"ItemCode\"='");
                    sb.append(itemCode);
                    sb.append("'");
                }
                sb.append(" union all ");
            }
            //CARTAGENA IGB
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
            sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
            sb.append("  from OBIN ub ");
            sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
            sb.append("  where de.\"WhsCode\"='05' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
            sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='05' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
            sb.append(" from OITM oi ");
            sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
            sb.append(" where it.\"WhsCode\"='05' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
            if (!itemCode.equals("0")) {
                sb.append("and oi.\"ItemCode\"='");
                sb.append(itemCode);
                sb.append("'");
            }
            sb.append(" union all ");
            //BOGOTÁ LUBRICANTE REVO IGB
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
            sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
            sb.append("  from OBIN ub ");
            sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
            sb.append("  where de.\"WhsCode\"='35' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
            sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='35' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
            sb.append(" from OITM oi ");
            sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
            sb.append(" where it.\"WhsCode\"='35' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
            if (!itemCode.equals("0")) {
                sb.append("and oi.\"ItemCode\"='");
                sb.append(itemCode);
                sb.append("'");
            }
            sb.append(" union all ");
            //COTA LUBRICANTE REVO IGB
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
            sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
            sb.append("  from OBIN ub ");
            sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
            sb.append("  where de.\"WhsCode\"='55' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
            sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='55' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
            sb.append(" from OITM oi ");
            sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
            sb.append(" where it.\"WhsCode\"='55' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
            if (!itemCode.equals("0")) {
                sb.append("and oi.\"ItemCode\"='");
                sb.append(itemCode);
                sb.append("'");
            }
            sb.append(" union all ");
            //ALMAVIVA IGB - SOLO LLANTAS
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
            sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
            sb.append("  from OBIN ub ");
            sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
            sb.append("  where de.\"WhsCode\"='60' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
            sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='60' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
            sb.append(" from OITM oi ");
            sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
            sb.append(" where it.\"WhsCode\"='60' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
            if (!itemCode.equals("0")) {
                sb.append("and oi.\"ItemCode\"='");
                sb.append(itemCode);
                sb.append("'");
            }
            sb.append(" union all ");
        }
        //CALI IGB - MTZ
        sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
        sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
        sb.append("  from OBIN ub ");
        sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("  where de.\"WhsCode\"='26' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
        sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='26' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
        sb.append(" from OITM oi ");
        sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
        sb.append(" where it.\"WhsCode\"='26' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
        if (!itemCode.equals("0")) {
            sb.append("and oi.\"ItemCode\"='");
            sb.append(itemCode);
            sb.append("'");
        }
        sb.append(" union all ");
        //SANBARTOLOME IGB - MTZ
        if (companyName.contains("IGB")) {
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast('01' as varchar(20))as Bodega,cast(case when (");
        } else {
            sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
        }
        sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
        sb.append("  from OBIN ub ");
        sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("  where de.\"WhsCode\"='32' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
        sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='32' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
        sb.append(" from OITM oi ");
        sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
        sb.append(" where it.\"WhsCode\"='32' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
        if (!itemCode.equals("0")) {
            sb.append("and oi.\"ItemCode\"='");
            sb.append(itemCode);
            sb.append("'");
        }
        sb.append(" union all ");
        //CEDI IGB - MTZ
        sb.append(" select cast(oi.\"ItemCode\" as varchar(20))as Producto,cast(it.\"WhsCode\" as varchar(20))as Bodega,cast(case when (");
        sb.append("  select ifnull(sum(de.\"OnHandQty\"),0) ");
        sb.append("  from OBIN ub ");
        sb.append("  inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("  where de.\"WhsCode\"='01' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")>0 then (it.\"OnHand\"-it.\"IsCommited\"-");
        sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) from OBIN ub inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='01' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=oi.\"ItemCode\")) else (it.\"OnHand\"-it.\"IsCommited\") end as int)as Stock ");
        sb.append(" from OITM oi ");
        sb.append(" inner join OITW it on it.\"ItemCode\"=oi.\"ItemCode\" ");
        sb.append(" where it.\"WhsCode\"='01' and oi.\"frozenFor\"='N' and oi.\"SellItem\"='Y' and oi.\"InvntItem\"='Y' ");
        if (!itemCode.equals("0")) {
            sb.append("and oi.\"ItemCode\"='");
            sb.append(itemCode);
            sb.append("'");
        }
        sb.append(")as t where t.Stock>=0 ");
        if (!whsCode.equals("0")) {
            sb.append("and t.Bodega='");
            sb.append(whsCode);
            sb.append("'");
        }
        sb.append(" group by t.Producto,t.Bodega");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el stock actual para " + companyName, e);
        }
        return null;
    }

    public List<Object[]> listItemMasterMotorepuesto(String updateDate, String active) {
        EntityManager em = persistenceConf.chooseSchema("IGB", false, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.Producto,t.Presentacion,t.PorcentajeIva,t.Bodega,case when t.Stock < 0 then 0 else t.Stock end as Stock,t.PicturName,t.Categoria,t.Marca,t.SubMarca,t.Grupo,t.SubGrupo,t.ModeloMoto, ");
        sb.append(" t.TipoLlanta,t.AnchoLlanta,t.PerfilLlanta,t.RinLlanta,t.Talla,t.ColorCadena,t.PasoCadena,t.Viscosidad,t.Base,t.TipoArticulo,t.Keywords,t.ArticuloPadre,t.DescripPadre,t.fechaModificacion, ");
        sb.append(" t.horaModificacion,t.marcaMoto,t.motoAplica, ");
        sb.append(" cast(itMrto.\"ItemName\" as varchar(10000))as NombreWeb, cast((prMrto.\"Price\"*(t.PorcentajeIva/100))+prMrto.\"Price\" as numeric(18,2))as PrecioInicial,cast((prMrto2.\"Price\"*(t.PorcentajeIva/100))+prMrto2.\"Price\" as numeric(18,2))as PrecioOferta, ");
        sb.append(" cast(itMrto.\"U_DESCRIPCION_LARGA_W\" as varchar(1000000))as DescripcionLarga,cast(itMrto.\"U_DESCRIPCION_CORTA_W\" as varchar(1000000))as DescripcionCorta,cast(itMrto.\"QryGroup2\" as varchar(100))as UltimasOfertas, ");
        sb.append(" cast(\"QryGroup3\" as varchar(1))as hotSale,cast(\"SLength1\" as double)as longitud,cast(\"SWidth1\" as double)as ancho,cast(\"SHeight1\" as double)as altura,cast(\"SVolume\" as double)as volumen,round(cast(\"SWeight1\" as double),2)as peso ");
        sb.append("from( ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(50))as Producto,cast(ifnull(it.\"InvntryUom\",'NULL')as varchar(15))as Presentacion, ");
        sb.append("  cast(19 as int)as PorcentajeIva,cast(it.\"DfltWH\" as varchar(50))as Bodega, ");
        sb.append(" cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from \"IGB\".OBIN ub inner join \"IGB\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('01','05','26','32','35','60','55') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then ((select ifnull(sum(\"OnHand\"),0) from \"IGB\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in('01','05','26','32','35','60','55'))-it.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from \"IGB\".OBIN ub inner join \"IGB\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('01','05','26','32','35','60','55') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("  else ((select ifnull(sum(\"OnHand\"),0) from \"IGB\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in('01','05','26','32','35','60','55'))-it.\"IsCommited\") ");
        sb.append(" end as int)as Stock, ");
        sb.append("  cast(it.\"PicturName\" as varchar)as PicturName,cast(c.\"Name\" as varchar(100))as Categoria,cast(mar.\"Name\" as varchar(50))as Marca,cast(it.\"U_SUBMARCA\" as varchar(50))as SubMarca, ");
        sb.append("  cast(gru.\"Name\" as varchar(50))as Grupo,cast(sub.\"Name\" as varchar(50))as SubGrupo, ");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(1000))as ModeloMoto,cast(tll.\"Name\" as varchar(50))as TipoLlanta,cast(anc.\"Name\" as varchar(50))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(50))as PerfilLlanta,cast(rin.\"Name\" as varchar(50))as RinLlanta,cast(ta.\"Name\" as varchar(50))as Talla, ");
        sb.append("  cast(it.\"U_COLOR_CADENA\" as varchar(50))as ColorCadena,cast(it.\"U_PASO_CADENA\" as varchar(50))as PasoCadena,null as Viscosidad,null as Base, ");
        sb.append("  cast(it.\"U_TIPO\" as varchar(15))as TipoArticulo,cast(it.\"U_KEYWORDS\" as varchar(1000))as Keywords, ");
        sb.append("  cast(it.\"U_ARTICULO\" as varchar(20))as ArticuloPadre,'' as DescripPadre, ");
        sb.append("  cast(TO_NVARCHAR(it.\"UpdateDate\", 'YYYY-MM-DD')as varchar(15))as fechaModificacion,cast(SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),1,2) || ':' || SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),3,2)as varchar(6))as horaModificacion, ");
        sb.append("  cast(mm.\"Name\" as varchar(20))as marcaMoto,cast(it2.\"U_MOTO\" as varchar(1000))as motoAplica ");
        sb.append(" from \"IGB\".OITM it ");
        sb.append(" left join \"VELEZ\".\"OITM\" it2 on it2.\"ItemCode\"=it.\"ItemCode\" ");
        sb.append(" left join \"VELEZ\".\"@MARCAS\" mar on mar.\"Code\"=it2.\"U_Marca\" and it2.\"U_Marca\"<>'' ");
        sb.append(" left join \"VELEZ\".\"@GRUPOS\" gru on gru.\"Code\"=it2.\"U_Grupo\" ");
        sb.append(" left join \"VELEZ\".\"@SUBGRUPOS\" sub on sub.\"Code\"=it2.\"U_Subgrupo\" ");
        sb.append(" left join \"IGB\".\"@TIPO_LLANTA\" tll on tll.\"Code\"=it2.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"IGB\".\"@ANCHO_LLANTA\" anc on anc.\"Code\"=it2.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"IGB\".\"@PERFIL_LLANTA\" pe on pe.\"Code\"=it2.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"IGB\".\"@RIN_LLANTA\" rin on rin.\"Code\"=it2.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"IGB\".\"@TALLA\" ta on ta.\"Code\"=it2.\"U_TALLA\" ");
        sb.append(" left join \"VELEZ\".\"@CATEGORIA\" c on c.\"Code\"=it2.\"U_CATEGORIA\" ");
        sb.append(" left join \"IGB\".\"@VISCOSIDAD\" vis on vis.\"Code\"=it2.\"U_VISCOSIDAD\" ");
        sb.append(" left join \"IGB\".\"@BASE\" bs on bs.\"Code\"=it2.\"U_BASE\" ");
        sb.append(" left join \"VELEZ\".\"@MARCA_MOTO\" mm on mm.\"Name\"=it2.\"U_MARCA_MOTO\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"QryGroup2\"='Y' ");
        sb.append("UNION ALL ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(50))as Producto,cast(ifnull(it.\"InvntryUom\",'NULL')as varchar(15))as Presentacion, ");
        sb.append("  cast(19 as int)as PorcentajeIva,cast(it.\"DfltWH\" as varchar(50))as Bodega, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from \"VARROC\".OBIN ub inner join \"VARROC\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('13','26','32','35') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("   then ((select ifnull(sum(\"OnHand\"),0) from \"VARROC\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in('13','26','32','35'))-it.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from \"VARROC\".OBIN ub inner join \"VARROC\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\" in('13','26','32','35') and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("   else ((select ifnull(sum(\"OnHand\"),0) from \"VARROC\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\" in('13','26','32','35'))-it.\"IsCommited\") ");
        sb.append("  end as int)as Stock, ");
        sb.append("  cast(it.\"PicturName\" as varchar)as PicturName,cast(c.\"Name\" as varchar(100))as Categoria,cast(mar.\"Name\" as varchar(50))as Marca,cast(mar.\"Name\" as varchar(50))as SubMarca, ");
        sb.append("  cast(gru.\"Name\" as varchar(50))as Grupo,cast(sub.\"Name\" as varchar(50))as SubGrupo, ");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(1000))as ModeloMoto,cast(tll.\"Name\" as varchar(50))as TipoLlanta,cast(anc.\"Name\" as varchar(50))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(50))as PerfilLlanta,cast(rin.\"Name\" as varchar(50))as RinLlanta,cast(ta.\"Name\" as varchar(50))as Talla, ");
        sb.append("  null as ColorCadena,null as PasoCadena,cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base, ");
        sb.append("  cast(it.\"U_TIPO\" as varchar(15))as TipoArticulo,cast(it.\"U_KEYWORDS\" as varchar(1000))as Keywords, ");
        sb.append("  cast(it.\"U_ARTICULO\" as varchar(20))as ArticuloPadre,'' as DescripPadre, ");
        sb.append("  cast(TO_NVARCHAR(it.\"UpdateDate\", 'YYYY-MM-DD')as varchar(15))as fechaModificacion,cast(SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),1,2) || ':' || SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),3,2)as varchar(6))as horaModificacion, ");
        sb.append("  cast(mm.\"Name\" as varchar(20))as marcaMoto,cast(it2.\"U_MOTO\" as varchar(1000))as motoAplica ");
        sb.append(" from \"VARROC\".OITM it ");
        sb.append(" left join \"VELEZ\".\"OITM\" it2 on it2.\"ItemCode\"=it.\"ItemCode\" ");
        sb.append(" left join \"VELEZ\".\"@MARCAS\" mar on mar.\"Code\"=it2.\"U_Marca\" and it2.\"U_Marca\"<>'' ");
        sb.append(" left join \"VELEZ\".\"@GRUPOS\" gru on gru.\"Code\"=it2.\"U_Grupo\" ");
        sb.append(" left join \"VELEZ\".\"@SUBGRUPOS\" sub on sub.\"Code\"=it2.\"U_Subgrupo\" ");
        sb.append(" left join \"VARROC\".\"@TIPO_LLANTA\" tll on tll.\"Code\"=it2.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@ANCHO_LLANTA\" anc on anc.\"Code\"=it2.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@PERFIL_LLANTA\" pe on pe.\"Code\"=it2.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@RIN_LLANTA\" rin on rin.\"Code\"=it2.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"VARROC\".\"@TALLA\" ta on ta.\"Code\"=it2.\"U_TALLA\" ");
        sb.append(" left join \"VELEZ\".\"@CATEGORIA\" c on c.\"Code\"=it2.\"U_CATEGORIA\" ");
        sb.append(" left join \"VARROC\".\"@VISCOSIDAD\" vis on vis.\"Code\"=it2.\"U_VISCOSIDAD\" ");
        sb.append(" left join \"VARROC\".\"@BASE\" bs on bs.\"Code\"=it2.\"U_BASE\" ");
        sb.append(" left join \"VELEZ\".\"@MARCA_MOTO\" mm on mm.\"Name\"=it2.\"U_MARCA_MOTO\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"QryGroup2\"='Y' ");
        sb.append("UNION ALL ");
        sb.append(" select distinct cast(it.\"ItemCode\" as varchar(50))as Producto,cast(ifnull(it.\"InvntryUom\",'NULL')as varchar(15))as Presentacion, ");
        sb.append("  cast(19 as int)as PorcentajeIva,cast(ifnull(it.\"DfltWH\",'01')as varchar(50))as Bodega, ");
        sb.append("  cast(case when(select ifnull(sum(de.\"OnHandQty\"),0) from \"VELEZ\".OBIN ub inner join \"VELEZ\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='01' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("   then ((select ifnull(sum(\"OnHand\"),0) from \"VELEZ\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\"='01')-it.\"IsCommited\"-(select ifnull(sum(de.\"OnHandQty\"),0) from \"VELEZ\".OBIN ub inner join \"VELEZ\".OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" where de.\"WhsCode\"='01' and (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"ItemCode\"=it.\"ItemCode\")) ");
        sb.append("   else ((select ifnull(sum(\"OnHand\"),0) from \"VELEZ\".OITW where \"ItemCode\"=it.\"ItemCode\" and \"WhsCode\"='01')-it.\"IsCommited\") ");
        sb.append("  end as int)as Stock, ");
        sb.append("  cast(it.\"PicturName\" as varchar)as PicturName,cast(c.\"Name\" as varchar(100))as Categoria,cast(mar.\"Name\" as varchar(50))as Marca,cast(it.\"U_SUBMARCA\" as varchar(50))as SubMarca, ");
        sb.append("  cast(gru.\"Name\" as varchar(50))as Grupo,cast(sub.\"Name\" as varchar(50))as SubGrupo, ");
        sb.append("  cast(it.\"U_Aplicacion\" as varchar(1000))as ModeloMoto,cast(tll.\"Name\" as varchar(50))as TipoLlanta,cast(anc.\"Name\" as varchar(50))as AnchoLlanta, ");
        sb.append("  cast(pe.\"Name\" as varchar(50))as PerfilLlanta,cast(rin.\"Name\" as varchar(50))as RinLlanta,cast(ta.\"Name\" as varchar(50))as Talla, ");
        sb.append("  null as ColorCadena,null as PasoCadena,cast(vis.\"Name\" as varchar(50))as Viscosidad,cast(bs.\"Name\" as varchar(50))as Base, ");
        sb.append("  cast(it.\"U_TIPO\" as varchar(15))as TipoArticulo,cast(it.\"U_KEYWORDS\" as varchar(1000))as Keywords, ");
        sb.append("  cast(it.\"U_ARTICULO\" as varchar(20))as ArticuloPadre,'' as DescripPadre, ");
        sb.append("  cast(TO_NVARCHAR(it.\"UpdateDate\", 'YYYY-MM-DD')as varchar(15))as fechaModificacion,cast(SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),1,2) || ':' || SUBSTR(LPAD(it.\"UpdateTS\",6,'0'),3,2)as varchar(6))as horaModificacion, ");
        sb.append("  cast(mm.\"Name\" as varchar(20))as marcaMoto,cast(it.\"U_MOTO\" as varchar(1000))as motoAplica ");
        sb.append(" from \"VELEZ\".OITM it ");
        sb.append(" left join \"VELEZ\".\"@MARCAS\" mar on mar.\"Code\"=it.\"U_Marca\" and it.\"U_Marca\"<>'' ");
        sb.append(" left join \"VELEZ\".\"@GRUPOS\" gru on gru.\"Code\"=it.\"U_Grupo\" ");
        sb.append(" left join \"VELEZ\".\"@SUBGRUPOS\" sub on sub.\"Code\"=it.\"U_Subgrupo\" ");
        sb.append(" left join \"VELEZ\".\"@TIPO_LLANTA\" tll on tll.\"Code\"=it.\"U_TIPO_LLANTA\" ");
        sb.append(" left join \"VELEZ\".\"@ANCHO_LLANTA\" anc on anc.\"Code\"=it.\"U_ANCHO_LLANTA\" ");
        sb.append(" left join \"VELEZ\".\"@PERFIL_LLANTA\" pe on pe.\"Code\"=it.\"U_PERFIL_LLANTA\" ");
        sb.append(" left join \"VELEZ\".\"@RIN_LLANTA\" rin on rin.\"Code\"=it.\"U_RIN_LLANTA\" ");
        sb.append(" left join \"VELEZ\".\"@TALLA\" ta on ta.\"Code\"=it.\"U_TALLA\" ");
        sb.append(" left join \"VELEZ\".\"@CATEGORIA\" c on c.\"Code\"=it.\"U_CATEGORIA\" ");
        sb.append(" left join \"VELEZ\".\"@VISCOSIDAD\" vis on vis.\"Code\"=it.\"U_VISCOSIDAD\" ");
        sb.append(" left join \"VELEZ\".\"@BASE\" bs on bs.\"Code\"=it.\"U_BASE\" ");
        sb.append(" left join \"VELEZ\".\"@MARCA_MOTO\" mm on mm.\"Name\"=it.\"U_MARCA_MOTO\" ");
        sb.append(" where it.\"validFor\"='Y' and it.\"ItemType\"='I' and it.\"CardCode\" not in ('P900255414', 'P811011909') ");
        sb.append(")as t ");
        sb.append("inner join \"VELEZ\".OITM itMrto on itMrto.\"ItemCode\"=t.Producto ");
        sb.append("inner join \"VELEZ\".ITM1 prMrto on prMrto.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto.\"PriceList\"=1 ");
        sb.append("inner join \"VELEZ\".ITM1 prMrto2 on prMrto2.\"ItemCode\"=itMrto.\"ItemCode\" and prMrto2.\"PriceList\"=2 ");
        if (active != null) {
            sb.append("where itMrto.\"validFor\"='N' ");
        } else {
            sb.append("where itMrto.\"validFor\"='Y' ");
        }
        if (updateDate != null) {
            sb.append(" and TO_NVARCHAR(itMrto.\"UpdateDate\", 'YYYY-MM-DD')='");
            sb.append(updateDate);
            sb.append("' or TO_NVARCHAR(t.FECHAMODIFICACION, 'YYYY-MM-DD')='");
            sb.append(updateDate);
            sb.append("'");
        }
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
        sb.append(" cast(sal.\"OnHand\" as int)as qty, ");
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

    public List<Object[]> listItemsToSyncModula(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct cast(a.\"ItemCode\" as varchar(20))as itemCode,cast(a.\"ItemName\" as varchar(200))as itemName, ");
        sb.append(" cast(s.\"MinStock\" as int)as StockMin,cast(s.\"MaxStock\" as int)as StockMax, ");
        sb.append(" cast(a.\"validFor\" as varchar(1))as Active,cast(ifnull(a.\"SWidth1\",0) as int)as Ancho, ");
        sb.append(" cast(ifnull(a.\"SLength1\",0) as int)as Largo,cast(ifnull(a.\"SHeight1\",0) as int)as Alto,cast(ifnull(a.\"SWeight1\",0) as int)as Peso, ");
        sb.append(" case when a.\"QryGroup6\"='Y' then 1 when a.\"QryGroup7\"='Y' then 2 else 0 end Area ");
        sb.append("from OITM a ");
        sb.append("inner join OITW s on s.\"ItemCode\"=a.\"ItemCode\" ");
        sb.append("where s.\"WhsCode\"='30' and (a.\"QryGroup3\"='Y' or a.\"QryGroup5\"='Y') order by 1");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los items habilitados para modula.", e);
        }
        return null;
    }

    public Object[] getStockItemMDLvsSAPvsSBT(String itemCode, String wshCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select sum(\"StockMDL\")as StockMDL,sum(\"StockCDI\")as StockCDI,sum(\"StockSBT\")as StockSBT from (");
        sb.append(" select 0 as \"StockMDL\",0 as \"StockCDI\",ifnull(cast(sum(s.\"OnHand\") as int),0) as \"StockSBT\" ");
        sb.append(" from \"OITW\" s ");
        sb.append(" where s.\"OnHand\">0 and s.\"WhsCode\"='32' and s.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("' union all ");
        sb.append(" select ifnull(cast(sum(s.\"OnHand\"-s.\"IsCommited\") as int),0)as \"StockMDL\",0 as \"StockCDI\",0 as \"StockSBT\" ");
        sb.append(" from \"OITW\" s ");
        sb.append(" where s.\"OnHand\">0 and s.\"WhsCode\"='30' and s.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("' union all ");
        sb.append(" select 0 as \"StockMDL\",ifnull(cast(case when");
        sb.append("  (select ifnull(sum(de.\"OnHandQty\"),0) ");
        sb.append("   from OBIN ub ");
        sb.append("   inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("   where (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"WhsCode\"='");
        sb.append(wshCode.equals("30") ? "01" : wshCode);
        sb.append("' and de.\"ItemCode\"=it.\"ItemCode\")>0 ");
        sb.append("  then (inv.\"OnHand\"-inv.\"IsCommited\"-");
        sb.append("   (select ifnull(sum(de.\"OnHandQty\"),0) ");
        sb.append("    from OBIN ub ");
        sb.append("    inner join OIBQ de on ub.\"AbsEntry\"=de.\"BinAbs\" ");
        sb.append("    where (ub.\"Attr4Val\"='' or ub.\"Attr4Val\" is null) and de.\"OnHandQty\">0 and de.\"WhsCode\"='");
        sb.append(wshCode.equals("30") ? "01" : wshCode);
        sb.append("' and de.\"ItemCode\"=it.\"ItemCode\") ");
        sb.append("  )else (inv.\"OnHand\"-inv.\"IsCommited\")end as int),0)as \"StockCDI\",0 as \"StockSBT\" ");
        sb.append(" from OITM it");
        sb.append(" inner join OITW inv on inv.\"ItemCode\"=it.\"ItemCode\" and inv.\"OnHand\">0 and inv.\"WhsCode\"='");
        sb.append(wshCode.equals("30") ? "01" : wshCode);
        sb.append("' where it.\"ItemCode\"='");
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

    public void updateFieldSyncModula(String itemCode, String status, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OITM set \"QryGroup3\"='");
        sb.append(status);
        sb.append("',\"QryGroup5\"='");
        sb.append(status);
        sb.append("' where \"ItemCode\"='");
        sb.append(itemCode);
        sb.append("'");
        try {
            persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el UDF sync-modula para el item[" + itemCode + "]", e);
        }
    }

    public Object[] getIncomeAccountByItem(String itemCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"TaxCodeAR\" as varchar(20))as taxCode, ");
        sb.append(" case when o.\"TaxCodeAR\"='IVAEXCLU' then '41350507' ");
        sb.append("      when o.\"TaxCodeAR\" IN ('IVAG19','IVAV01') then '41350505' ");
        sb.append("      when o.\"TaxCodeAR\"='IVAVEXE' then '41350510' ");
        sb.append("      when o.\"TaxCodeAR\"='IVAG01' then '41200501' ");
        sb.append(" else '' end as AcctCode,cast(o.\"U_Marca\" as varchar(20))as marca ");
        sb.append("from OITM o ");
        sb.append("where o.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo la cuenta de ingreso en ventas para el item " + itemCode, e);
        }
        return new Object[]{};
    }

    public void updateStocksItemByWarehouse(String itemCode, Integer minStock, Integer maxStock, String whsCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OITW set \"MinStock\"=");
        sb.append(minStock);
        sb.append(",\"MaxStock\"=");
        sb.append(maxStock);
        sb.append(" where \"ItemCode\"='");
        sb.append(itemCode);
        sb.append("' and \"WhsCode\"='");
        sb.append(whsCode);
        sb.append("'");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando los stock min-max para el item {0} en la bodega {1}", new Object[]{itemCode, whsCode});
        }
    }

    public Object[] getItemNameAndGrup(String itemCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.\"ItemName\" as varchar)as itemName,cast(g.\"Name\" as varchar)as grupo ");
        sb.append("from OITM a ");
        sb.append("inner join \"@GRUPOS\" g on a.\"U_Grupo\"=g.\"Code\" ");
        sb.append("where a.\"ItemCode\"='");
        sb.append(itemCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el nombre y el grupo del item " + itemCode + " en " + companyName, e);
        }
        return null;
    }

    public List<Object[]> getResultOfItemChatBotIA(StringBuilder queryIA, String slpCode, String companyName, boolean testing) {
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(queryIA.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los datos del query generado por OpenAI para el asesor " + slpCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }
}
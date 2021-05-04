package co.manager.hanaws.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsDTO implements Serializable {
    @JsonProperty("ItemCode")
    protected String itemCode;
    @JsonProperty("ItemName")
    protected String itemName;
    @JsonProperty("ItemType")
    protected String itemType;
    @JsonProperty("ForeignName")
    protected String foreignName;
    @JsonProperty("ItemsGroupCode")
    protected Long itemsGroupCode;
    @JsonProperty("Mainsupplier")
    protected String mainsupplier;
    @JsonProperty("Picture")
    protected String picture;
    @JsonProperty("Manufacturer")
    protected Long manufacturer;
    @JsonProperty("IndirectTax")
    protected String indirectTax;
    @JsonProperty("ArTaxCode")
    protected String taxCodeAR;
    @JsonProperty("ApTaxCode")
    protected String taxCodeAP;
    @JsonProperty("U_TIPO")
    protected String uTipo;
    @JsonProperty("U_Subgrupo")
    protected String uSubgrupo;
    @JsonProperty("U_Marca")
    protected String uMarca;
    @JsonProperty("U_Procedencia")
    protected String uProcedencia;
    @JsonProperty("U_Modelo")
    protected String uModelo;
    @JsonProperty("U_Cod_Anterior")
    protected String uCodAnterior;
    @JsonProperty("U_COSTOIMP")
    protected String ucostoimp;
    @JsonProperty("U_Aplicacion")
    protected String uAplicacion;
    @JsonProperty("U_Type")
    protected String uType;
    @JsonProperty("U_CATEGORIA")
    protected String uCategoria;
    @JsonProperty("U_CATALOGO")
    protected String uCatalogo;
    @JsonProperty("U_TIPO_LLANTA")
    protected String uTipoLlanta;
    @JsonProperty("U_ANCHO_LLANTA")
    protected String uAnchoLlanta;
    @JsonProperty("U_RIN_LLANTA")
    protected String uRinLlanta;
    @JsonProperty("U_PERFIL_LLANTA")
    protected String uPerfilLlanta;
    @JsonProperty("U_TALLA")
    protected String uTalla;
    @JsonProperty("U_COLOR_CADENA")
    protected String uColorCadena;
    @JsonProperty("U_VISCOSIDAD")
    protected String uViscosidad;
    @JsonProperty("U_BASE")
    protected String uBase;
    @JsonProperty("U_ARTICULO")
    protected String uArticulo;
    @JsonProperty("U_KEYWORDS")
    protected String uKeywords;
    @JsonProperty("U_PASO_CADENA")
    protected String uPasoCadena;
    @JsonProperty("U_EsAIU")
    protected String uEsAIU;
    @JsonProperty("U_PorcAIU")
    protected String uPorcAIU;
    @JsonProperty("U_CalcAIU")
    protected String uCalcAIU;
    @JsonProperty("U_LARGO_CADENA")
    protected String uLargoCadena;
    @JsonProperty("UpdateDate")
    protected String updateDate;
    @JsonProperty("CreateDate")
    protected String createDate;
    @JsonProperty("U_FEC_CREA")
    protected String ufeccrea;
    @JsonProperty("Valid")
    protected String validFor;
    @JsonProperty("Frozen")
    protected String frozenFor;
    @JsonProperty("Properties2")
    protected String qryGroup2;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public Long getItemsGroupCode() {
        return itemsGroupCode;
    }

    public void setItemsGroupCode(Long itemsGroupCode) {
        this.itemsGroupCode = itemsGroupCode;
    }

    public String getMainsupplier() {
        return mainsupplier;
    }

    public void setMainsupplier(String mainsupplier) {
        this.mainsupplier = mainsupplier;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Long getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getIndirectTax() {
        return indirectTax;
    }

    public void setIndirectTax(String indirectTax) {
        this.indirectTax = indirectTax;
    }

    public String getTaxCodeAR() {
        return taxCodeAR;
    }

    public void setTaxCodeAR(String taxCodeAR) {
        this.taxCodeAR = taxCodeAR;
    }

    public String getTaxCodeAP() {
        return taxCodeAP;
    }

    public void setTaxCodeAP(String taxCodeAP) {
        this.taxCodeAP = taxCodeAP;
    }

    public String getuTipo() {
        return uTipo;
    }

    public void setuTipo(String uTipo) {
        this.uTipo = uTipo;
    }

    public String getuSubgrupo() {
        return uSubgrupo;
    }

    public void setuSubgrupo(String uSubgrupo) {
        this.uSubgrupo = uSubgrupo;
    }

    public String getuMarca() {
        return uMarca;
    }

    public void setuMarca(String uMarca) {
        this.uMarca = uMarca;
    }

    public String getuProcedencia() {
        return uProcedencia;
    }

    public void setuProcedencia(String uProcedencia) {
        this.uProcedencia = uProcedencia;
    }

    public String getuModelo() {
        return uModelo;
    }

    public void setuModelo(String uModelo) {
        this.uModelo = uModelo;
    }

    public String getuCodAnterior() {
        return uCodAnterior;
    }

    public void setuCodAnterior(String uCodAnterior) {
        this.uCodAnterior = uCodAnterior;
    }

    public String getUcostoimp() {
        return ucostoimp;
    }

    public void setUcostoimp(String ucostoimp) {
        this.ucostoimp = ucostoimp;
    }

    public String getuAplicacion() {
        return uAplicacion;
    }

    public void setuAplicacion(String uAplicacion) {
        this.uAplicacion = uAplicacion;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public String getuCategoria() {
        return uCategoria;
    }

    public void setuCategoria(String uCategoria) {
        this.uCategoria = uCategoria;
    }

    public String getuCatalogo() {
        return uCatalogo;
    }

    public void setuCatalogo(String uCatalogo) {
        this.uCatalogo = uCatalogo;
    }

    public String getuTipoLlanta() {
        return uTipoLlanta;
    }

    public void setuTipoLlanta(String uTipoLlanta) {
        this.uTipoLlanta = uTipoLlanta;
    }

    public String getuAnchoLlanta() {
        return uAnchoLlanta;
    }

    public void setuAnchoLlanta(String uAnchoLlanta) {
        this.uAnchoLlanta = uAnchoLlanta;
    }

    public String getuRinLlanta() {
        return uRinLlanta;
    }

    public void setuRinLlanta(String uRinLlanta) {
        this.uRinLlanta = uRinLlanta;
    }

    public String getuPerfilLlanta() {
        return uPerfilLlanta;
    }

    public void setuPerfilLlanta(String uPerfilLlanta) {
        this.uPerfilLlanta = uPerfilLlanta;
    }

    public String getuTalla() {
        return uTalla;
    }

    public void setuTalla(String uTalla) {
        this.uTalla = uTalla;
    }

    public String getuColorCadena() {
        return uColorCadena;
    }

    public void setuColorCadena(String uColorCadena) {
        this.uColorCadena = uColorCadena;
    }

    public String getuViscosidad() {
        return uViscosidad;
    }

    public void setuViscosidad(String uViscosidad) {
        this.uViscosidad = uViscosidad;
    }

    public String getuBase() {
        return uBase;
    }

    public void setuBase(String uBase) {
        this.uBase = uBase;
    }

    public String getuArticulo() {
        return uArticulo;
    }

    public void setuArticulo(String uArticulo) {
        this.uArticulo = uArticulo;
    }

    public String getuKeywords() {
        return uKeywords;
    }

    public void setuKeywords(String uKeywords) {
        this.uKeywords = uKeywords;
    }

    public String getuPasoCadena() {
        return uPasoCadena;
    }

    public void setuPasoCadena(String uPasoCadena) {
        this.uPasoCadena = uPasoCadena;
    }

    public String getuEsAIU() {
        return uEsAIU;
    }

    public void setuEsAIU(String uEsAIU) {
        this.uEsAIU = uEsAIU;
    }

    public String getuPorcAIU() {
        return uPorcAIU;
    }

    public void setuPorcAIU(String uPorcAIU) {
        this.uPorcAIU = uPorcAIU;
    }

    public String getuCalcAIU() {
        return uCalcAIU;
    }

    public void setuCalcAIU(String uCalcAIU) {
        this.uCalcAIU = uCalcAIU;
    }

    public String getuLargoCadena() {
        return uLargoCadena;
    }

    public void setuLargoCadena(String uLargoCadena) {
        this.uLargoCadena = uLargoCadena;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUfeccrea() {
        return ufeccrea;
    }

    public void setUfeccrea(String ufeccrea) {
        this.ufeccrea = ufeccrea;
    }

    public String getValidFor() {
        return validFor;
    }

    public void setValidFor(String validFor) {
        this.validFor = validFor;
    }

    public String getFrozenFor() {
        return frozenFor;
    }

    public void setFrozenFor(String frozenFor) {
        this.frozenFor = frozenFor;
    }

    public String getQryGroup2() {
        return qryGroup2;
    }

    public void setQryGroup2(String qryGroup2) {
        this.qryGroup2 = qryGroup2;
    }

    @Override
    public String toString() {
        return "ItemsDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemType='" + itemType + '\'' +
                ", foreignName='" + foreignName + '\'' +
                ", itemsGroupCode=" + itemsGroupCode +
                ", mainsupplier='" + mainsupplier + '\'' +
                ", picture='" + picture + '\'' +
                ", manufacturer=" + manufacturer +
                ", indirectTax='" + indirectTax + '\'' +
                ", taxCodeAR='" + taxCodeAR + '\'' +
                ", taxCodeAP='" + taxCodeAP + '\'' +
                ", uTipo='" + uTipo + '\'' +
                ", uSubgrupo='" + uSubgrupo + '\'' +
                ", uMarca='" + uMarca + '\'' +
                ", uProcedencia='" + uProcedencia + '\'' +
                ", uModelo='" + uModelo + '\'' +
                ", uCodAnterior='" + uCodAnterior + '\'' +
                ", ucostoimp='" + ucostoimp + '\'' +
                ", uAplicacion='" + uAplicacion + '\'' +
                ", uType='" + uType + '\'' +
                ", uCategoria='" + uCategoria + '\'' +
                ", uCatalogo='" + uCatalogo + '\'' +
                ", uTipoLlanta='" + uTipoLlanta + '\'' +
                ", uAnchoLlanta='" + uAnchoLlanta + '\'' +
                ", uRinLlanta='" + uRinLlanta + '\'' +
                ", uPerfilLlanta='" + uPerfilLlanta + '\'' +
                ", uTalla='" + uTalla + '\'' +
                ", uColorCadena='" + uColorCadena + '\'' +
                ", uViscosidad='" + uViscosidad + '\'' +
                ", uBase='" + uBase + '\'' +
                ", uArticulo='" + uArticulo + '\'' +
                ", uKeywords='" + uKeywords + '\'' +
                ", uPasoCadena='" + uPasoCadena + '\'' +
                ", uEsAIU='" + uEsAIU + '\'' +
                ", uPorcAIU='" + uPorcAIU + '\'' +
                ", uCalcAIU='" + uCalcAIU + '\'' +
                ", uLargoCadena='" + uLargoCadena + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", createDate='" + createDate + '\'' +
                ", ufeccrea='" + ufeccrea + '\'' +
                ", validFor='" + validFor + '\'' +
                ", frozenFor='" + frozenFor + '\'' +
                ", qryGroup2='" + qryGroup2 + '\'' +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemMotorepuestoDTO {

    private String itemCode;
    private String nomWeb;
    private String presentation;
    private Integer iva;
    private String whsCode;
    private Integer stock;
    private String pictureUrl;
    private String category;
    private String marca;
    private String pictureMarcaUrl;
    private String subMarca;
    private String grupo;
    private String subgrupo;
    private String modeloMoto;
    private String tipoLlanta;
    private String anchoLlanta;
    private String perfilLlanta;
    private String rinLlanta;
    private String talla;
    private String colorCadena;
    private String pasoCadena;
    private String viscosidad;
    private String base;
    private boolean parent;
    private String itemParent;
    private String itemNameParent;
    private String itemType;
    private String keyword;
    private BigDecimal priceVenta;
    private BigDecimal pricePromo;
    private String descripcionLarga;
    private String ultimasOfertas;

    public ItemMotorepuestoDTO() {
    }

    public ItemMotorepuestoDTO(String itemCode, String nomWeb, String presentation, Integer iva, String whsCode, Integer stock, String pictureUrl, String category, String marca, String pictureMarcaUrl, String subMarca, String grupo, String subgrupo, String modeloMoto, String tipoLlanta, String anchoLlanta, String perfilLlanta, String rinLlanta, String talla, String colorCadena, String pasoCadena, String viscosidad, String base, boolean parent, String itemParent, String itemNameParent, String itemType, String keyword, BigDecimal priceVenta, BigDecimal pricePromo, String descripcionLarga, String ultimasOfertas) {
        this.itemCode = itemCode;
        this.nomWeb = nomWeb;
        this.presentation = presentation;
        this.iva = iva;
        this.whsCode = whsCode;
        this.stock = stock;
        this.pictureUrl = pictureUrl;
        this.category = category;
        this.marca = marca;
        this.pictureMarcaUrl = pictureMarcaUrl;
        this.subMarca = subMarca;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.modeloMoto = modeloMoto;
        this.tipoLlanta = tipoLlanta;
        this.anchoLlanta = anchoLlanta;
        this.perfilLlanta = perfilLlanta;
        this.rinLlanta = rinLlanta;
        this.talla = talla;
        this.colorCadena = colorCadena;
        this.pasoCadena = pasoCadena;
        this.viscosidad = viscosidad;
        this.base = base;
        this.parent = parent;
        this.itemParent = itemParent;
        this.itemNameParent = itemNameParent;
        this.itemType = itemType;
        this.keyword = keyword;
        this.priceVenta = priceVenta;
        this.pricePromo = pricePromo;
        this.descripcionLarga = descripcionLarga;
        this.ultimasOfertas = ultimasOfertas;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getNomWeb() {
        return nomWeb;
    }

    public void setNomWeb(String nomWeb) {
        this.nomWeb = nomWeb;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPictureMarcaUrl() {
        return pictureMarcaUrl;
    }

    public void setPictureMarcaUrl(String pictureMarcaUrl) {
        this.pictureMarcaUrl = pictureMarcaUrl;
    }

    public String getSubMarca() {
        return subMarca;
    }

    public void setSubMarca(String subMarca) {
        this.subMarca = subMarca;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    public String getModeloMoto() {
        return modeloMoto;
    }

    public void setModeloMoto(String modeloMoto) {
        this.modeloMoto = modeloMoto;
    }

    public String getTipoLlanta() {
        return tipoLlanta;
    }

    public void setTipoLlanta(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }

    public String getAnchoLlanta() {
        return anchoLlanta;
    }

    public void setAnchoLlanta(String anchoLlanta) {
        this.anchoLlanta = anchoLlanta;
    }

    public String getPerfilLlanta() {
        return perfilLlanta;
    }

    public void setPerfilLlanta(String perfilLlanta) {
        this.perfilLlanta = perfilLlanta;
    }

    public String getRinLlanta() {
        return rinLlanta;
    }

    public void setRinLlanta(String rinLlanta) {
        this.rinLlanta = rinLlanta;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColorCadena() {
        return colorCadena;
    }

    public void setColorCadena(String colorCadena) {
        this.colorCadena = colorCadena;
    }

    public String getPasoCadena() {
        return pasoCadena;
    }

    public void setPasoCadena(String pasoCadena) {
        this.pasoCadena = pasoCadena;
    }

    public String getViscosidad() {
        return viscosidad;
    }

    public void setViscosidad(String viscosidad) {
        this.viscosidad = viscosidad;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public String getItemParent() {
        return itemParent;
    }

    public void setItemParent(String itemParent) {
        this.itemParent = itemParent;
    }

    public String getItemNameParent() {
        return itemNameParent;
    }

    public void setItemNameParent(String itemNameParent) {
        this.itemNameParent = itemNameParent;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BigDecimal getPriceVenta() {
        return priceVenta;
    }

    public void setPriceVenta(BigDecimal priceVenta) {
        this.priceVenta = priceVenta;
    }

    public BigDecimal getPricePromo() {
        return pricePromo;
    }

    public void setPricePromo(BigDecimal pricePromo) {
        this.pricePromo = pricePromo;
    }

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public String getUltimasOfertas() {
        return ultimasOfertas;
    }

    public void setUltimasOfertas(String ultimasOfertas) {
        this.ultimasOfertas = ultimasOfertas;
    }

    @Override
    public String toString() {
        return "ItemMotorepuestoDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", nomWeb='" + nomWeb + '\'' +
                ", presentation='" + presentation + '\'' +
                ", iva=" + iva +
                ", whsCode='" + whsCode + '\'' +
                ", stock=" + stock +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", category='" + category + '\'' +
                ", marca='" + marca + '\'' +
                ", pictureMarcaUrl='" + pictureMarcaUrl + '\'' +
                ", subMarca='" + subMarca + '\'' +
                ", grupo='" + grupo + '\'' +
                ", subgrupo='" + subgrupo + '\'' +
                ", modeloMoto='" + modeloMoto + '\'' +
                ", tipoLlanta='" + tipoLlanta + '\'' +
                ", anchoLlanta='" + anchoLlanta + '\'' +
                ", perfilLlanta='" + perfilLlanta + '\'' +
                ", rinLlanta='" + rinLlanta + '\'' +
                ", talla='" + talla + '\'' +
                ", colorCadena='" + colorCadena + '\'' +
                ", pasoCadena='" + pasoCadena + '\'' +
                ", viscosidad='" + viscosidad + '\'' +
                ", base='" + base + '\'' +
                ", parent=" + parent +
                ", itemParent='" + itemParent + '\'' +
                ", itemNameParent='" + itemNameParent + '\'' +
                ", itemType='" + itemType + '\'' +
                ", keyword='" + keyword + '\'' +
                ", priceVenta=" + priceVenta +
                ", pricePromo=" + pricePromo +
                ", descripcionLarga='" + descripcionLarga + '\'' +
                ", ultimasOfertas='" + ultimasOfertas + '\'' +
                '}';
    }
}
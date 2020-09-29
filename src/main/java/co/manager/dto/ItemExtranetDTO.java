package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemExtranetDTO {
    private String itemCode;
    private String itemName;
    private String whsCode;
    private String pictureUrl;
    private String presentation;
    private Integer iva;
    private Integer discountItem;
    private Integer discountPorc;
    private BigDecimal price;
    private Integer stock;
    private String categoria;
    private String grupo;
    private String subgrupo;
    private String marca;
    private String modeloMoto;
    private String tipoLlanta;
    private String anchoLlanta;
    private String perfilLlanta;
    private String rinLlanta;
    private String talla;
    private String viscosidad;
    private String base;
    private String urlFichaTecnica;

    public ItemExtranetDTO() {
    }

    public ItemExtranetDTO(String itemCode, String itemName, String whsCode, String pictureUrl, String presentation, Integer iva, Integer discountItem, Integer discountPorc, BigDecimal price, Integer stock, String categoria, String grupo, String subgrupo, String marca, String modeloMoto, String tipoLlanta, String anchoLlanta, String perfilLlanta, String rinLlanta, String talla, String viscosidad, String base, String urlFichaTecnica) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.whsCode = whsCode;
        this.pictureUrl = pictureUrl;
        this.presentation = presentation;
        this.iva = iva;
        this.discountItem = discountItem;
        this.discountPorc = discountPorc;
        this.price = price;
        this.stock = stock;
        this.categoria = categoria;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.marca = marca;
        this.modeloMoto = modeloMoto;
        this.tipoLlanta = tipoLlanta;
        this.anchoLlanta = anchoLlanta;
        this.perfilLlanta = perfilLlanta;
        this.rinLlanta = rinLlanta;
        this.talla = talla;
        this.viscosidad = viscosidad;
        this.base = base;
        this.urlFichaTecnica = urlFichaTecnica;
    }

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

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
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

    public Integer getDiscountItem() {
        return discountItem;
    }

    public void setDiscountItem(Integer discountItem) {
        this.discountItem = discountItem;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getDiscountPorc() {
        return discountPorc;
    }

    public void setDiscountPorc(Integer discountPorc) {
        this.discountPorc = discountPorc;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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

    public String getUrlFichaTecnica() {
        return urlFichaTecnica;
    }

    public void setUrlFichaTecnica(String urlFichaTecnica) {
        this.urlFichaTecnica = urlFichaTecnica;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "ItemExtranetDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", presentation='" + presentation + '\'' +
                ", iva=" + iva +
                ", discountItem=" + discountItem +
                ", discountPorc=" + discountPorc +
                ", price=" + price +
                ", stock=" + stock +
                ", categoria='" + categoria + '\'' +
                ", grupo='" + grupo + '\'' +
                ", subgrupo='" + subgrupo + '\'' +
                ", marca='" + marca + '\'' +
                ", modeloMoto='" + modeloMoto + '\'' +
                ", tipoLlanta='" + tipoLlanta + '\'' +
                ", anchoLlanta='" + anchoLlanta + '\'' +
                ", perfilLlanta='" + perfilLlanta + '\'' +
                ", rinLlanta='" + rinLlanta + '\'' +
                ", talla='" + talla + '\'' +
                ", viscosidad='" + viscosidad + '\'' +
                ", base='" + base + '\'' +
                ", urlFichaTecnica='" + urlFichaTecnica + '\'' +
                '}';
    }
}
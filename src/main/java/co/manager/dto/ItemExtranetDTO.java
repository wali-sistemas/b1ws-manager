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
    private String unit;
    private String whsCode;
    private String pictureUrl;
    private Integer presentation;
    private Integer iva;
    private Integer discount;
    private BigDecimal price;
    //TODO: campos para filtros en extranet
    private String marca;
    private String grupo;
    private String subgrupo;
    private String subLinea;
    private String modeloMoto;
    private String tipoLlanta;
    private String anchoLlanta;
    private String perfilLlanta;
    private String rinLlanta;
    private String talla;
    private String urlFichaTecnica;

    public ItemExtranetDTO() {
    }

    public ItemExtranetDTO(String itemCode, String itemName, String unit, String whsCode, String pictureUrl, Integer presentation, Integer iva, Integer discount, BigDecimal price, String marca, String grupo, String subgrupo, String subLinea, String modeloMoto, String tipoLlanta, String anchoLlanta, String perfilLlanta, String rinLlanta, String talla, String urlFichaTecnica) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.whsCode = whsCode;
        this.pictureUrl = pictureUrl;
        this.presentation = presentation;
        this.iva = iva;
        this.discount = discount;
        this.price = price;
        this.marca = marca;
        this.grupo = grupo;
        this.subgrupo = subgrupo;
        this.subLinea = subLinea;
        this.modeloMoto = modeloMoto;
        this.tipoLlanta = tipoLlanta;
        this.anchoLlanta = anchoLlanta;
        this.perfilLlanta = perfilLlanta;
        this.rinLlanta = rinLlanta;
        this.talla = talla;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public Integer getPresentation() {
        return presentation;
    }

    public void setPresentation(Integer presentation) {
        this.presentation = presentation;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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

    public String getSubLinea() {
        return subLinea;
    }

    public void setSubLinea(String subLinea) {
        this.subLinea = subLinea;
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

    @Override
    public String toString() {
        return "ItemExtranetDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unit='" + unit + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", presentation=" + presentation +
                ", iva=" + iva +
                ", discount=" + discount +
                ", price=" + price +
                ", marca='" + marca + '\'' +
                ", grupo='" + grupo + '\'' +
                ", subgrupo='" + subgrupo + '\'' +
                ", subLinea='" + subLinea + '\'' +
                ", modeloMoto='" + modeloMoto + '\'' +
                ", tipoLlanta='" + tipoLlanta + '\'' +
                ", anchoLlanta='" + anchoLlanta + '\'' +
                ", perfilLlanta='" + perfilLlanta + '\'' +
                ", rinLlanta='" + rinLlanta + '\'' +
                ", talla='" + talla + '\'' +
                ", urlFichaTecnica='" + urlFichaTecnica + '\'' +
                '}';
    }
}
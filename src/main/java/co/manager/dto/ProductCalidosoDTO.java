package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class ProductCalidosoDTO {
    private String itemCode;
    private String itemName;
    private String description;
    private String condiction;
    private String urlPhoto;
    private String aliado;
    private BigDecimal price;

    public ProductCalidosoDTO() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondiction() {
        return condiction;
    }

    public void setCondiction(String condiction) {
        this.condiction = condiction;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAliado() {
        return aliado;
    }

    public void setAliado(String aliado) {
        this.aliado = aliado;
    }

    @Override
    public String toString() {
        return "ProductCalidosoDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", condiction='" + condiction + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", aliado='" + aliado + '\'' +
                ", price=" + price +
                '}';
    }
}
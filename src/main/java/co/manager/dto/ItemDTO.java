package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class ItemDTO {
    private String itemCode;
    private String itemName;
    private String unit;
    private String whsCode;
    private String pictureUrl;
    private Integer presentation;
    private Integer iva;
    private Integer discount;
    private BigDecimal price;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String itemName, String unit, Integer presentation, BigDecimal price, Integer iva, Integer discount, String whsCode, String pictureUrl) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.presentation = presentation;
        this.price = price;
        this.iva = iva;
        this.discount = discount;
        this.whsCode = whsCode;
        this.pictureUrl = pictureUrl;
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

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unit='" + unit + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", presentation=" + presentation +
                ", iva=" + iva +
                ", discount=" + discount +
                ", price=" + price +
                '}';
    }
}
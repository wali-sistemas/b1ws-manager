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
    private String presentation;
    private Integer iva;
    private Integer discount;
    private Integer quantity;
    private BigDecimal price;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String itemName, String unit, String presentation, BigDecimal price, Integer iva, Integer discount, String whsCode, Integer quantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unit = unit;
        this.presentation = presentation;
        this.price = price;
        this.iva = iva;
        this.discount = discount;
        this.whsCode = whsCode;
        this.quantity = quantity;
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

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", unit='" + unit + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", presentation='" + presentation + '\'' +
                ", iva=" + iva +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailSalesOrderSaveDTO implements Serializable {
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("itemCode")
    private String itemCode;
    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("group")
    private String group;
    @JsonProperty("presentation")
    private String presentation;
    @JsonProperty("whsCode")
    private String whsCode;
    @JsonProperty("price")
    private BigDecimal price;
    @JsonProperty("discountItem")
    private BigDecimal discountItem;
    @JsonProperty("discountPorc")
    private BigDecimal discountPorc;
    @JsonProperty("iva")
    private BigDecimal iva;

    public DetailSalesOrderSaveDTO() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountItem() {
        return discountItem;
    }

    public void setDiscountItem(BigDecimal discountItem) {
        this.discountItem = discountItem;
    }

    public BigDecimal getDiscountPorc() {
        return discountPorc;
    }

    public void setDiscountPorc(BigDecimal discountPorc) {
        this.discountPorc = discountPorc;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "DetailSalesOrderSaveDTO{" +
                "quantity=" + quantity +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", group='" + group + '\'' +
                ", presentation='" + presentation + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", price=" + price +
                ", discountItem=" + discountItem +
                ", discountPorc=" + discountPorc +
                ", iva=" + iva +
                '}';
    }
}
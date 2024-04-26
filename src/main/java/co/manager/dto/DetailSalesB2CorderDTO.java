package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailSalesB2CorderDTO implements Serializable {
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("itemCode")
    private String itemCode;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("itemName")
    private String itemName;
    @JsonProperty("whsCode")
    private String whsCode;
    @JsonProperty("baseType")
    private Long baseType = -1l;
    @JsonProperty("baseEntry")
    private Long baseEntry;
    @JsonProperty("baseLine")
    private Long baseLine;

    public DetailSalesB2CorderDTO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public Long getBaseType() {
        return baseType;
    }

    public void setBaseType(Long baseType) {
        this.baseType = baseType;
    }

    public Long getBaseEntry() {
        return baseEntry;
    }

    public void setBaseEntry(Long baseEntry) {
        this.baseEntry = baseEntry;
    }

    public Long getBaseLine() {
        return baseLine;
    }

    public void setBaseLine(Long baseLine) {
        this.baseLine = baseLine;
    }

    @Override
    public String toString() {
        return "DetailSalesB2CorderDTO{" +
                "quantity=" + quantity +
                ", itemCode='" + itemCode + '\'' +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", baseType=" + baseType +
                ", baseEntry=" + baseEntry +
                ", baseLine=" + baseLine +
                '}';
    }
}
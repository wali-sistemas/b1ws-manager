package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailSalesOrderDTO implements Serializable {
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("itemCode")
    private String itemCode;
    @JsonProperty("whsCode")
    private String whsCode;
    @JsonProperty("ocrCode")
    private String ocrCode;
    @JsonProperty("baseType")
    private Long baseType = -1l;
    @JsonProperty("baseEntry")
    private Long baseEntry;
    @JsonProperty("baseLine")
    private Long baseLine;

    public DetailSalesOrderDTO() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getOcrCode() {
        return ocrCode;
    }

    public void setOcrCode(String ocrCode) {
        this.ocrCode = ocrCode;
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
        return "DetailSalesOrderDTO{" +
                "quantity=" + quantity +
                ", itemCode='" + itemCode + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", ocrCode='" + ocrCode + '\'' +
                ", baseType=" + baseType +
                ", baseEntry=" + baseEntry +
                ", baseLine=" + baseLine +
                '}';
    }
}
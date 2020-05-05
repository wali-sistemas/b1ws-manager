package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailSalesOrderDTO {

    private Integer quantity;
    private String itemCode;
    private String whsCode;
    private String ocrCode;

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

    @Override
    public String toString() {
        return "DetailSalesOrderDTO{" +
                "quantity=" + quantity +
                ", itemCode='" + itemCode + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", ocrCode='" + ocrCode + '\'' +
                '}';
    }
}
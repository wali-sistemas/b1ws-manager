package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailQuotationDTO {
    private Integer quantity;
    private String itemCode;
    private String whsCode;

    public DetailQuotationDTO() {
    }

    public DetailQuotationDTO(Integer quantity, String itemCode, String whsCode) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.whsCode = whsCode;
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

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    @Override
    public String toString() {
        return "DetailQuotationDTO{" +
                "quantity=" + quantity +
                ", itemCode='" + itemCode + '\'' +
                ", whsCode='" + whsCode + '\'' +
                '}';
    }
}
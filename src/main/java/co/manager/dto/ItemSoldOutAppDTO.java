package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemSoldOutAppDTO {
    private String itemCode;
    private String itemName;
    private Integer quantity;
    private String slpCode;
    private String companyName;
    private String origen;
    private String whsName;

    public ItemSoldOutAppDTO() {
    }

    public ItemSoldOutAppDTO(String itemCode, String itemName, Integer quantity, String slpCode, String companyName, String origen, String whsName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.slpCode = slpCode;
        this.companyName = companyName;
        this.origen = origen;
        this.whsName = whsName;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getWhsName() {
        return whsName;
    }

    public void setWhsName(String whsName) {
        this.whsName = whsName;
    }

    @Override
    public String toString() {
        return "ItemSoldOutAppDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", slpCode='" + slpCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", origen='" + origen + '\'' +
                ", whsName='" + whsName + '\'' +
                '}';
    }
}
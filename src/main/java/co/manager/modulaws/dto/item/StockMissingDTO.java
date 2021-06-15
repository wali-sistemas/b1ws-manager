package co.manager.modulaws.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockMissingDTO {
    private String itemCode;
    private String itemName;
    private String whsCode;
    private String binCode;
    private String whsName;
    private Integer qtySAP;
    private Integer qtyMDL;

    public StockMissingDTO() {
    }

    public StockMissingDTO(String itemCode, String itemName, String whsCode, String binCode, String whsName, Integer qtySAP, Integer qtyMDL) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.whsCode = whsCode;
        this.binCode = binCode;
        this.whsName = whsName;
        this.qtySAP = qtySAP;
        this.qtyMDL = qtyMDL;
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

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getBinCode() {
        return binCode;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    public String getWhsName() {
        return whsName;
    }

    public void setWhsName(String whsName) {
        this.whsName = whsName;
    }

    public Integer getQtySAP() {
        return qtySAP;
    }

    public void setQtySAP(Integer qtySAP) {
        this.qtySAP = qtySAP;
    }

    public Integer getQtyMDL() {
        return qtyMDL;
    }

    public void setQtyMDL(Integer qtyMDL) {
        this.qtyMDL = qtyMDL;
    }

    @Override
    public String toString() {
        return "StockMissingDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", binCode='" + binCode + '\'' +
                ", whsName='" + whsName + '\'' +
                ", qtySAP=" + qtySAP +
                ", qtyMDL=" + qtyMDL +
                '}';
    }
}
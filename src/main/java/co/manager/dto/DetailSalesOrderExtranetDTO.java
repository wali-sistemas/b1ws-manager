package co.manager.dto;


import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class DetailSalesOrderExtranetDTO {
    private Integer lineNum;
    private String itemCode;
    private String itemName;
    private Integer qty;
    private Integer qtyPack;
    private BigDecimal priceUnit;
    private Integer iva;
    private BigDecimal discPrcnt;

    public DetailSalesOrderExtranetDTO() {
    }

    public DetailSalesOrderExtranetDTO(Integer lineNum, String itemCode, String itemName, Integer qty, Integer qtyPack, BigDecimal priceUnit, Integer iva, BigDecimal discPrcnt) {
        this.lineNum = lineNum;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qty = qty;
        this.qtyPack = qtyPack;
        this.priceUnit = priceUnit;
        this.iva = iva;
        this.discPrcnt = discPrcnt;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
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

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getQtyPack() {
        return qtyPack;
    }

    public void setQtyPack(Integer qtyPack) {
        this.qtyPack = qtyPack;
    }

    public BigDecimal getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(BigDecimal priceUnit) {
        this.priceUnit = priceUnit;
    }

    public Integer getIva() {
        return iva;
    }

    public void setIva(Integer iva) {
        this.iva = iva;
    }

    public BigDecimal getDiscPrcnt() {
        return discPrcnt;
    }

    public void setDiscPrcnt(BigDecimal discPrcnt) {
        this.discPrcnt = discPrcnt;
    }

    @Override
    public String toString() {
        return "DetailSalesOrderExtranetDTO{" +
                "lineNum=" + lineNum +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qty=" + qty +
                ", qtyPack=" + qtyPack +
                ", priceUnit=" + priceUnit +
                ", iva=" + iva +
                ", discPrcnt=" + discPrcnt +
                '}';
    }
}
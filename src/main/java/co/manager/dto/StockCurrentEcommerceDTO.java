package co.manager.dto;

/**
 * @author jguisao
 */
public class StockCurrentEcommerceDTO {
    private String itemCode;
    private Integer stock;
    private String whsCode;

    public StockCurrentEcommerceDTO() {
    }

    public StockCurrentEcommerceDTO(String itemCode, Integer stock, String whsCode) {
        this.itemCode = itemCode;
        this.stock = stock;
        this.whsCode = whsCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    @Override
    public String toString() {
        return "StockCurrentEcommerceDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", stock=" + stock +
                ", whsCode='" + whsCode + '\'' +
                '}';
    }
}
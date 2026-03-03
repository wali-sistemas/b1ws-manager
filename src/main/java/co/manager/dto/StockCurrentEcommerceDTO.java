package co.manager.dto;

/**
 * @author jguisao
 */
public class StockCurrentEcommerceDTO {
    private String itemCode;
    private Integer stock;

    public StockCurrentEcommerceDTO() {
    }

    public StockCurrentEcommerceDTO(String itemCode, Integer stock) {
        this.itemCode = itemCode;
        this.stock = stock;
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

    @Override
    public String toString() {
        return "StockCurrentEcommerceDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", stock=" + stock +
                '}';
    }
}
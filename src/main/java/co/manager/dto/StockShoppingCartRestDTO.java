package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class StockShoppingCartRestDTO {
    private String itemCode;
    private BigDecimal price;
    private Integer stock;

    public StockShoppingCartRestDTO() {
    }

    public StockShoppingCartRestDTO(String itemCode, BigDecimal price, Integer stock) {
        this.itemCode = itemCode;
        this.price = price;
        this.stock = stock;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "StockShoppingCartRestDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
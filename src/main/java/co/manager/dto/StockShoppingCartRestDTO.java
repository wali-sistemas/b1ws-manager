package co.manager.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
public class StockShoppingCartRestDTO {
    private String itemCode;
    private BigDecimal price;
    private Integer stock;
    private List<StockCurrentWarehouseDTO> stockWarehouses;

    public StockShoppingCartRestDTO() {
    }

    public StockShoppingCartRestDTO(String itemCode, BigDecimal price, Integer stock, List<StockCurrentWarehouseDTO> stockWarehouses) {
        this.itemCode = itemCode;
        this.price = price;
        this.stock = stock;
        this.stockWarehouses = stockWarehouses;
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

    public List<StockCurrentWarehouseDTO> getStockWarehouses() {
        return stockWarehouses;
    }

    public void setStockWarehouses(List<StockCurrentWarehouseDTO> stockWarehouses) {
        this.stockWarehouses = stockWarehouses;
    }

    @Override
    public String toString() {
        return "StockShoppingCartRestDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", stockWarehouses=" + stockWarehouses +
                '}';
    }

    public static class StockCurrentWarehouseDTO {
        private String whsCode;
        private Integer quantity;

        public StockCurrentWarehouseDTO() {
        }

        public StockCurrentWarehouseDTO(String whsCode, Integer quantity) {
            this.whsCode = whsCode;
            this.quantity = quantity;
        }

        public String getWhsCode() {
            return whsCode;
        }

        public void setWhsCode(String whsCode) {
            this.whsCode = whsCode;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "StockWarehouse{" +
                    "whsCode='" + whsCode + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
    }
}
package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class StockCurrentDTO {
    private String itemCode;
    private List<StockCurrentWarehouseDTO> stockWarehouses;

    public StockCurrentDTO() {
    }

    public StockCurrentDTO(String itemCode, List<StockCurrentWarehouseDTO> stockWarehouses) {
        this.itemCode = itemCode;
        this.stockWarehouses = stockWarehouses;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public List<StockCurrentWarehouseDTO> getStockWarehouses() {
        return stockWarehouses;
    }

    public void setStockWarehouses(List<StockCurrentWarehouseDTO> stockWarehouses) {
        this.stockWarehouses = stockWarehouses;
    }

    @Override
    public String toString() {
        return "StockCurrentDTO{" +
                "itemCode='" + itemCode + '\'' +
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
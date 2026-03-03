package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class PriceEcommerceDTO {
    private String itemCode;
    private BigDecimal priceVenta;

    public PriceEcommerceDTO() {
    }

    public PriceEcommerceDTO(String itemCode, BigDecimal priceVenta) {
        this.itemCode = itemCode;
        this.priceVenta = priceVenta;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public BigDecimal getPriceVenta() {
        return priceVenta;
    }

    public void setPriceVenta(BigDecimal priceVenta) {
        this.priceVenta = priceVenta;
    }

    @Override
    public String toString() {
        return "PriceEcommerceDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", priceVenta=" + priceVenta +
                '}';
    }
}
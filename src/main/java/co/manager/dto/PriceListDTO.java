package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class PriceListDTO {
    private String itemCode;
    private Integer codPriceList;
    private BigDecimal price;

    public PriceListDTO() {
    }

    public PriceListDTO(String itemCode, Integer codPriceList, BigDecimal price) {
        this.itemCode = itemCode;
        this.codPriceList = codPriceList;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getCodPriceList() {
        return codPriceList;
    }

    public void setCodPriceList(Integer codPriceList) {
        this.codPriceList = codPriceList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceListDTO{" +
                "itemCode='" + itemCode + '\'' +
                ", codPriceList='" + codPriceList + '\'' +
                ", price=" + price +
                '}';
    }
}
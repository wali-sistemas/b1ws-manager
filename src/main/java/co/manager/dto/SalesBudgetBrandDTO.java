package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesBudgetBrandDTO {
    private String brand;
    private BigDecimal budget;
    private BigDecimal sale;
    private Integer percent;

    public SalesBudgetBrandDTO() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "SalesBudgetBrandDTO{" +
                "brand='" + brand + '\'' +
                ", budget=" + budget +
                ", sale=" + sale +
                ", percent=" + percent +
                '}';
    }
}
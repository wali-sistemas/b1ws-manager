package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesEffectivenessDTO {
    private String slpCode;
    private String slpName;
    private Integer year;
    private Integer month;
    private Integer base;
    private Integer impact;
    private BigDecimal effectiveness;

    public SalesEffectivenessDTO() {
    }

    public SalesEffectivenessDTO(String slpCode, String slpName, Integer year, Integer month, Integer base, Integer impact, BigDecimal effectiveness) {
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.year = year;
        this.month = month;
        this.base = base;
        this.impact = impact;
        this.effectiveness = effectiveness;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Integer getImpact() {
        return impact;
    }

    public void setImpact(Integer impact) {
        this.impact = impact;
    }

    public BigDecimal getEffectiveness() {
        return effectiveness;
    }

    public void setEffectiveness(BigDecimal effectiveness) {
        this.effectiveness = effectiveness;
    }

    @Override
    public String toString() {
        return "SalesEffectivenessDTO{" +
                "slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", base=" + base +
                ", impact=" + impact +
                ", effectiveness=" + effectiveness +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesBudgetDTO {
    private Integer year;
    private String slpCode;
    private String companyName;
    private String month;
    private BigDecimal ventas;
    private BigDecimal presupuesto;
    private BigDecimal pendiente;

    public SalesBudgetDTO() {
    }

    public SalesBudgetDTO(String slpCode, String companyName, Integer year, String month, BigDecimal ventas, BigDecimal presupuesto) {
        this.slpCode = slpCode;
        this.companyName = companyName;
        this.year = year;
        this.month = month;
        this.ventas = ventas;
        this.presupuesto = presupuesto;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public BigDecimal getVentas() {
        return ventas;
    }

    public void setVentas(BigDecimal ventas) {
        this.ventas = ventas;
    }

    public BigDecimal getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(BigDecimal presupuesto) {
        this.presupuesto = presupuesto;
    }

    public BigDecimal getPendiente() {
        return pendiente;
    }

    public void setPendiente(BigDecimal pendiente) {
        this.pendiente = pendiente;
    }

    @Override
    public String toString() {
        return "SalesBudgetDTO{" +
                "year=" + year +
                ", slpCode='" + slpCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", month='" + month + '\'' +
                ", ventas=" + ventas +
                ", presupuesto=" + presupuesto +
                ", pendiente=" + pendiente +
                '}';
    }
}
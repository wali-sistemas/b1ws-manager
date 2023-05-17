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
    private String slpName;
    private String mail;
    private String urlSlpPicture;

    public SalesBudgetDTO() {
    }

    public SalesBudgetDTO(Integer year, String slpCode, String companyName, String month, BigDecimal ventas, BigDecimal presupuesto, BigDecimal pendiente, String slpName, String mail, String urlSlpPicture) {
        this.year = year;
        this.slpCode = slpCode;
        this.companyName = companyName;
        this.month = month;
        this.ventas = ventas;
        this.presupuesto = presupuesto;
        this.pendiente = pendiente;
        this.slpName = slpName;
        this.mail = mail;
        this.urlSlpPicture = urlSlpPicture;
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

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUrlSlpPicture() {
        return urlSlpPicture;
    }

    public void setUrlSlpPicture(String urlSlpPicture) {
        this.urlSlpPicture = urlSlpPicture;
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
                ", slpName='" + slpName + '\'' +
                ", mail='" + mail + '\'' +
                ", urlSlpPicture='" + urlSlpPicture + '\'' +
                '}';
    }
}
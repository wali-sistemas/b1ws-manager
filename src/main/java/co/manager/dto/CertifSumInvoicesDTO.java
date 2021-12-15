package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CertifSumInvoicesDTO {
    private String year;
    private String nit;
    private String cardName;
    private BigDecimal sumComp;
    private BigDecimal sumIvaComp;
    private BigDecimal sumDiscount;
    private BigDecimal sumDev;
    private BigDecimal sumIvaDev;
    private BigDecimal sumTransp;

    public CertifSumInvoicesDTO() {
    }

    public CertifSumInvoicesDTO(String year, String nit, String cardName, BigDecimal sumComp, BigDecimal sumIvaComp, BigDecimal sumDiscount, BigDecimal sumDev, BigDecimal sumIvaDev, BigDecimal sumTransp) {
        this.year = year;
        this.nit = nit;
        this.cardName = cardName;
        this.sumComp = sumComp;
        this.sumIvaComp = sumIvaComp;
        this.sumDiscount = sumDiscount;
        this.sumDev = sumDev;
        this.sumIvaDev = sumIvaDev;
        this.sumTransp = sumTransp;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public BigDecimal getSumComp() {
        return sumComp;
    }

    public void setSumComp(BigDecimal sumComp) {
        this.sumComp = sumComp;
    }

    public BigDecimal getSumIvaComp() {
        return sumIvaComp;
    }

    public void setSumIvaComp(BigDecimal sumIvaComp) {
        this.sumIvaComp = sumIvaComp;
    }

    public BigDecimal getSumDiscount() {
        return sumDiscount;
    }

    public void setSumDiscount(BigDecimal sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

    public BigDecimal getSumDev() {
        return sumDev;
    }

    public void setSumDev(BigDecimal sumDev) {
        this.sumDev = sumDev;
    }

    public BigDecimal getSumIvaDev() {
        return sumIvaDev;
    }

    public void setSumIvaDev(BigDecimal sumIvaDev) {
        this.sumIvaDev = sumIvaDev;
    }

    public BigDecimal getSumTransp() {
        return sumTransp;
    }

    public void setSumTransp(BigDecimal sumTransp) {
        this.sumTransp = sumTransp;
    }

    @Override
    public String toString() {
        return "CertifSumInvoicesDTO{" +
                "year='" + year + '\'' +
                ", nit='" + nit + '\'' +
                ", cardName='" + cardName + '\'' +
                ", sumComp=" + sumComp +
                ", sumIvaComp=" + sumIvaComp +
                ", sumDiscount=" + sumDiscount +
                ", sumDev=" + sumDev +
                ", sumIvaDev=" + sumIvaDev +
                ", sumTransp=" + sumTransp +
                '}';
    }
}
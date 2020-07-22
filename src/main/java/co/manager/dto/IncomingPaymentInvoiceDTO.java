package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingPaymentInvoiceDTO {
    private Long docEntry;
    private Integer lineNum;
    private BigDecimal sumApplied;
    private BigDecimal appliedSys;
    private String invoiceType;

    public IncomingPaymentInvoiceDTO() {
    }

    public IncomingPaymentInvoiceDTO(Long docEntry, Integer lineNum, BigDecimal sumApplied, BigDecimal appliedSys, String invoiceType) {
        this.docEntry = docEntry;
        this.lineNum = lineNum;
        this.sumApplied = sumApplied;
        this.appliedSys = appliedSys;
        this.invoiceType = invoiceType;
    }

    public Long getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Long docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public BigDecimal getSumApplied() {
        return sumApplied;
    }

    public void setSumApplied(BigDecimal sumApplied) {
        this.sumApplied = sumApplied;
    }

    public BigDecimal getAppliedSys() {
        return appliedSys;
    }

    public void setAppliedSys(BigDecimal appliedSys) {
        this.appliedSys = appliedSys;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Override
    public String toString() {
        return "IncomingPaymentInvoiceDTO{" +
                "docEntry=" + docEntry +
                ", lineNum=" + lineNum +
                ", sumApplied=" + sumApplied +
                ", appliedSys=" + appliedSys +
                ", invoiceType='" + invoiceType + '\'' +
                '}';
    }
}
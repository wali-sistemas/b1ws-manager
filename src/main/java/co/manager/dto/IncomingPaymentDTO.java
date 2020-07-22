package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingPaymentDTO {
    private Integer idPayment;
    private Long docEntry;
    private Long docNum;
    private Long series;
    private Date docDate;
    private Date transferDate;
    private Date taxDate;
    private String docType;
    private String cardCode;
    private String docCurrency;
    private String transferAccount;
    private String transferReference;
    private String journalRemarks;
    private String companyName;
    private BigDecimal cashSum;
    private BigDecimal transferSum;
    private String status;
    private List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices;

    public IncomingPaymentDTO() {
    }

    public IncomingPaymentDTO(Integer idPayment, Long docEntry, Long docNum, Long series, Date docDate, Date transferDate, Date taxDate, String docType, String cardCode, String docCurrency, String transferAccount, String transferReference, String journalRemarks, String companyName, BigDecimal cashSum, BigDecimal transferSum, String status, List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices) {
        this.idPayment = idPayment;
        this.docEntry = docEntry;
        this.docNum = docNum;
        this.series = series;
        this.docDate = docDate;
        this.transferDate = transferDate;
        this.taxDate = taxDate;
        this.docType = docType;
        this.cardCode = cardCode;
        this.docCurrency = docCurrency;
        this.transferAccount = transferAccount;
        this.transferReference = transferReference;
        this.journalRemarks = journalRemarks;
        this.companyName = companyName;
        this.cashSum = cashSum;
        this.transferSum = transferSum;
        this.status = status;
        this.incomingPaymentInvoices = incomingPaymentInvoices;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Long getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Long docEntry) {
        this.docEntry = docEntry;
    }

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(Date taxDate) {
        this.taxDate = taxDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getDocCurrency() {
        return docCurrency;
    }

    public void setDocCurrency(String docCurrency) {
        this.docCurrency = docCurrency;
    }

    public String getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public String getJournalRemarks() {
        return journalRemarks;
    }

    public void setJournalRemarks(String journalRemarks) {
        this.journalRemarks = journalRemarks;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BigDecimal getCashSum() {
        return cashSum;
    }

    public void setCashSum(BigDecimal cashSum) {
        this.cashSum = cashSum;
    }

    public BigDecimal getTransferSum() {
        return transferSum;
    }

    public void setTransferSum(BigDecimal transferSum) {
        this.transferSum = transferSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<IncomingPaymentInvoiceDTO> getIncomingPaymentInvoices() {
        return incomingPaymentInvoices;
    }

    public void setIncomingPaymentInvoices(List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices) {
        this.incomingPaymentInvoices = incomingPaymentInvoices;
    }

    @Override
    public String toString() {
        return "IncomingPaymentDTO{" +
                "idPayment=" + idPayment +
                ", docEntry=" + docEntry +
                ", docNum=" + docNum +
                ", series=" + series +
                ", docDate=" + docDate +
                ", transferDate=" + transferDate +
                ", taxDate=" + taxDate +
                ", docType='" + docType + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", docCurrency='" + docCurrency + '\'' +
                ", transferAccount='" + transferAccount + '\'' +
                ", transferReference='" + transferReference + '\'' +
                ", journalRemarks='" + journalRemarks + '\'' +
                ", companyName='" + companyName + '\'' +
                ", cashSum=" + cashSum +
                ", transferSum=" + transferSum +
                ", status='" + status + '\'' +
                ", incomingPaymentInvoices=" + incomingPaymentInvoices +
                '}';
    }
}
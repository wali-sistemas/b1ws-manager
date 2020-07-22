package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingPaymentDTO {
    private Integer idPayment;
    private String cardCode;
    private String transferReference;
    private String companyName;
    private BigDecimal cashSum;
    private String status;
    private List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices;

    public IncomingPaymentDTO() {
    }

    public IncomingPaymentDTO(Integer idPayment, String cardCode, String transferReference, String companyName, BigDecimal cashSum, String status, List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices) {
        this.idPayment = idPayment;
        this.cardCode = cardCode;
        this.transferReference = transferReference;
        this.companyName = companyName;
        this.cashSum = cashSum;
        this.status = status;
        this.incomingPaymentInvoices = incomingPaymentInvoices;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
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
                ", cardCode='" + cardCode + '\'' +
                ", transferReference='" + transferReference + '\'' +
                ", companyName='" + companyName + '\'' +
                ", cashSum=" + cashSum +
                ", status='" + status + '\'' +
                ", incomingPaymentInvoices=" + incomingPaymentInvoices +
                '}';
    }
}
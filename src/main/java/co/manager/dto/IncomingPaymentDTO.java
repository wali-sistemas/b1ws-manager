package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class IncomingPaymentDTO {
    private long docNum;
    private String companyName;
    private List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices;

    public long getDocNum() {
        return docNum;
    }

    public void setDocNum(long docNum) {
        this.docNum = docNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<IncomingPaymentInvoiceDTO> getIncomingPaymentInvoices() {
        return incomingPaymentInvoices;
    }

    public void setIncomingPaymentInvoices(List<IncomingPaymentInvoiceDTO> incomingPaymentInvoices) {
        this.incomingPaymentInvoices = incomingPaymentInvoices;
    }
}

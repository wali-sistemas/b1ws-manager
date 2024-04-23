package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailTrackingInvoiceDTO {
    private String order;
    private String docDateOrder;
    private String statusOrder;
    private String docDueDateOrder;
    private String invoice;
    private String docDateInvoice;
    private String transport;
    private String guia;
    private String statusInvoice;
    private String urlTracking;

    public DetailTrackingInvoiceDTO() {
    }

    public DetailTrackingInvoiceDTO(String order, String docDateOrder, String statusOrder, String docDueDateOrder, String invoice, String docDateInvoice, String transport, String guia, String statusInvoice, String urlTracking) {
        this.order = order;
        this.docDateOrder = docDateOrder;
        this.statusOrder = statusOrder;
        this.docDueDateOrder = docDueDateOrder;
        this.invoice = invoice;
        this.docDateInvoice = docDateInvoice;
        this.transport = transport;
        this.guia = guia;
        this.statusInvoice = statusInvoice;
        this.urlTracking = urlTracking;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDocDateOrder() {
        return docDateOrder;
    }

    public void setDocDateOrder(String docDateOrder) {
        this.docDateOrder = docDateOrder;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getDocDueDateOrder() {
        return docDueDateOrder;
    }

    public void setDocDueDateOrder(String docDueDateOrder) {
        this.docDueDateOrder = docDueDateOrder;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public String getDocDateInvoice() {
        return docDateInvoice;
    }

    public void setDocDateInvoice(String docDateInvoice) {
        this.docDateInvoice = docDateInvoice;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getStatusInvoice() {
        return statusInvoice;
    }

    public void setStatusInvoice(String statusInvoice) {
        this.statusInvoice = statusInvoice;
    }

    public String getUrlTracking() {
        return urlTracking;
    }

    public void setUrlTracking(String urlTracking) {
        this.urlTracking = urlTracking;
    }

    @Override
    public String toString() {
        return "DetailTrackingInvoiceDTO{" +
                "order='" + order + '\'' +
                ", docDateOrder='" + docDateOrder + '\'' +
                ", statusOrder='" + statusOrder + '\'' +
                ", docDueDateOrder='" + docDueDateOrder + '\'' +
                ", invoice='" + invoice + '\'' +
                ", docDateInvoice='" + docDateInvoice + '\'' +
                ", transport='" + transport + '\'' +
                ", guia='" + guia + '\'' +
                ", statusInvoice='" + statusInvoice + '\'' +
                ", urlTracking='" + urlTracking + '\'' +
                '}';
    }
}
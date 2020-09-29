package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrderDTO {
    private String cardCode;
    private String comments;
    private String companyName;
    private String numAtCard;
    private String idTransport;
    private String status;
    private String confirmed;
    private String startDatePack;
    private String shipToCode;
    private String payToCode;
    private Long slpCode;
    private Double discountPercent;
    private List<DetailSalesOrderDTO> detailSalesOrder;

    public SalesOrderDTO() {
        setDetailSalesOrder(new ArrayList<>());
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<DetailSalesOrderDTO> getDetailSalesOrder() {
        return detailSalesOrder;
    }

    public void setDetailSalesOrder(List<DetailSalesOrderDTO> detailSalesOrder) {
        this.detailSalesOrder = detailSalesOrder;
    }

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getIdTransport() {
        return idTransport;
    }

    public void setIdTransport(String idTransport) {
        this.idTransport = idTransport;
    }

    public Long getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(Long slpCode) {
        this.slpCode = slpCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getStartDatePack() {
        return startDatePack;
    }

    public void setStartDatePack(String startDatePack) {
        this.startDatePack = startDatePack;
    }

    public String getShipToCode() {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public String toString() {
        return "SalesOrderDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", idTransport='" + idTransport + '\'' +
                ", status='" + status + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", startDatePack='" + startDatePack + '\'' +
                ", shipToCode='" + shipToCode + '\'' +
                ", payToCode='" + payToCode + '\'' +
                ", slpCode=" + slpCode +
                ", discountPercent=" + discountPercent +
                ", detailSalesOrder=" + detailSalesOrder +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrderSaveDTO implements Serializable {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("cardCode")
    private String cardCode;
    @JsonProperty("cardName")
    private String cardName;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("companyName")
    private String companyName;
    @JsonProperty("numAtCard")
    private String numAtCard;
    @JsonProperty("status")
    private String status;
    @JsonProperty("shipToCode")
    private String shipToCode;
    @JsonProperty("payToCode")
    private String payToCode;
    @JsonProperty("docDate")
    private Date docDate;
    @JsonProperty("slpCode")
    private String slpCode;
    @JsonProperty("discountPercent")
    private BigDecimal discountPercent;
    @JsonProperty("docTotal")
    private BigDecimal docTotal;
    @JsonProperty("assignedShipToCode")
    private String assignedShipToCode;
    @JsonProperty("detailSalesOrderSave")
    private List<DetailSalesOrderSaveDTO> detailSalesOrderSave;

    public SalesOrderSaveDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
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

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    public String getAssignedShipToCode() {
        return assignedShipToCode;
    }

    public void setAssignedShipToCode(String assignedShipToCode) {
        this.assignedShipToCode = assignedShipToCode;
    }

    public List<DetailSalesOrderSaveDTO> getDetailSalesOrderSave() {
        return detailSalesOrderSave;
    }

    public void setDetailSalesOrderSave(List<DetailSalesOrderSaveDTO> detailSalesOrderSave) {
        this.detailSalesOrderSave = detailSalesOrderSave;
    }

    @Override
    public String toString() {
        return "SalesOrderSaveDTO{" +
                "id=" + id +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", status='" + status + '\'' +
                ", shipToCode='" + shipToCode + '\'' +
                ", payToCode='" + payToCode + '\'' +
                ", docDate='" + docDate + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", discountPercent=" + discountPercent +
                ", docTotal=" + docTotal +
                ", assignedShipToCode='" + assignedShipToCode + '\'' +
                ", detailSalesOrderSave=" + detailSalesOrderSave +
                '}';
    }
}
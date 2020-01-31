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
    private Long slpCode;

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

    @Override
    public String toString() {
        return "SalesOrderDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", idTransport='" + idTransport + '\'' +
                ", slpCode=" + slpCode +
                ", detailSalesOrder=" + detailSalesOrder +
                '}';
    }
}
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

    @Override
    public String toString() {
        return "SalesOrderDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", detailSalesOrder=" + detailSalesOrder +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotationDTO {
    private String cardCode;
    private String comments;
    private String companyName;
    private String numAtCard;
    private Long slpCode;
    private List<DetailQuotationDTO> detailQuotation;

    public QuotationDTO() {
    }

    public QuotationDTO(String cardCode, String comments, String companyName, String numAtCard, Long slpCode, List<DetailQuotationDTO> detailQuotation) {
        this.cardCode = cardCode;
        this.comments = comments;
        this.companyName = companyName;
        this.numAtCard = numAtCard;
        this.slpCode = slpCode;
        this.detailQuotation = detailQuotation;
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

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public Long getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(Long slpCode) {
        this.slpCode = slpCode;
    }

    public List<DetailQuotationDTO> getDetailQuotation() {
        return detailQuotation;
    }

    public void setDetailQuotation(List<DetailQuotationDTO> detailQuotation) {
        this.detailQuotation = detailQuotation;
    }

    @Override
    public String toString() {
        return "QuotationDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", companyName='" + companyName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", slpCode=" + slpCode +
                ", detailQuotation=" + detailQuotation +
                '}';
    }
}
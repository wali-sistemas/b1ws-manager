package co.manager.dto;

/**
 * @author jguisao
 */
import java.math.BigDecimal;
import java.util.Date;

public class CreditNotesHistoryDTO {
    private String docType;
    private Integer docNum;
    private Date docDate;
    private BigDecimal docTotal;
    private String description;
    private String urlFacture;

    public CreditNotesHistoryDTO() {
    }

    public CreditNotesHistoryDTO(String docType, Integer docNum, Date docDate, BigDecimal docTotal, String description, String urlFacture) {
        this.docType = docType;
        this.docNum = docNum;
        this.docDate = docDate;
        this.docTotal = docTotal;
        this.description = description;
        this.urlFacture = urlFacture;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlFacture() {
        return urlFacture;
    }

    public void setUrlFacture(String urlFacture) {
        this.urlFacture = urlFacture;
    }

    @Override
    public String toString() {
        return "CreditNotesHistoryDTO{" +
                "docType='" + docType + '\'' +
                ", docNum=" + docNum +
                ", docDate=" + docDate +
                ", docTotal=" + docTotal +
                ", description='" + description + '\'' +
                ", urlFacture='" + urlFacture + '\'' +
                '}';
    }
}
package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class OrdersAppDTO {
    private Integer docEntry;
    private Integer docNum;
    private String docDate;
    private String cardCode;
    private String cardName;
    private String comments;
    private String status;
    private BigDecimal docTotal;

    public OrdersAppDTO() {
    }

    public OrdersAppDTO(Integer docEntry, Integer docNum, String docDate, String cardCode, String cardName, String comments, BigDecimal docTotal) {
        this.docEntry = docEntry;
        this.docNum = docNum;
        this.docDate = docDate;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.comments = comments;
        this.docTotal = docTotal;
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

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdersAppDTO{" +
                "docEntry=" + docEntry +
                ", docNum=" + docNum +
                ", docDate='" + docDate + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", comments='" + comments + '\'' +
                ", docTotal=" + docTotal +
                '}';
    }
}
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
    private String comments;
    private BigDecimal docTotal;

    public OrdersAppDTO() {
    }

    public OrdersAppDTO(String cardCode, String docDate, BigDecimal docTotal, String comments, Integer docEntry, Integer docNum) {
        this.cardCode = cardCode;
        this.docDate = docDate;
        this.docTotal = docTotal;
        this.comments = comments;
        this.docEntry = docEntry;
        this.docNum = docNum;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
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

    @Override
    public String toString() {
        return "OrdersAppDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", docDate=" + docDate +
                ", docTotal=" + docTotal +
                ", comments='" + comments + '\'' +
                ", docEntry=" + docEntry +
                ", docNum=" + docNum +
                '}';
    }
}
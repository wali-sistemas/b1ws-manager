package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class NotificationOrderExtranetDTO {
    private String docNum;
    private String docDate;
    private String cardCode;
    private String cardName;
    private BigDecimal docTotal;

    public NotificationOrderExtranetDTO() {
    }

    public NotificationOrderExtranetDTO(String docNum, String docDate, String cardCode, String cardName, BigDecimal docTotal) {
        this.docNum = docNum;
        this.docDate = docDate;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.docTotal = docTotal;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
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

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    @Override
    public String toString() {
        return "NotificationOrderExtranetDTO{" +
                "docNum='" + docNum + '\'' +
                ", docDate='" + docDate + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", docTotal=" + docTotal +
                '}';
    }
}
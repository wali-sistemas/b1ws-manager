package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SalesOrderStoppedDTO {
    private Integer docNum;
    private String cardCode;
    private String cardName;
    private String status;
    private char authorization;
    private Date docDate;
    private BigDecimal docTotal;
    private String whsCode;
    private String comments;

    public SalesOrderStoppedDTO() {
    }

    public SalesOrderStoppedDTO(Integer docNum, String cardCode, String cardName, String status, char authorization, Date docDate, BigDecimal docTotal, String whsCode, String comments) {
        this.docNum = docNum;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.status = status;
        this.authorization = authorization;
        this.docDate = docDate;
        this.docTotal = docTotal;
        this.whsCode = whsCode;
        this.comments = comments;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public char getAuthorization() {
        return authorization;
    }

    public void setAuthorization(char authorization) {
        this.authorization = authorization;
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

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "SalesOrderStoppedDTO{" +
                "docNum=" + docNum +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", status='" + status + '\'' +
                ", authorization=" + authorization +
                ", docDate=" + docDate +
                ", docTotal=" + docTotal +
                ", whsCode='" + whsCode + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
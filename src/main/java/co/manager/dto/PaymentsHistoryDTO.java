package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class PaymentsHistoryDTO {
    private String docType;
    private Integer docNum;
    private Date docDate;
    private BigDecimal docTotal;

    public PaymentsHistoryDTO() {
    }

    public PaymentsHistoryDTO(String docType, Integer docNum, Date docDate, BigDecimal docTotal) {
        this.docType = docType;
        this.docNum = docNum;
        this.docDate = docDate;
        this.docTotal = docTotal;
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

    @Override
    public String toString() {
        return "PaymentsHistoryDTO{" +
                "docType='" + docType + '\'' +
                ", docNum=" + docNum +
                ", docDate=" + docDate +
                ", docTotal=" + docTotal +
                '}';
    }
}
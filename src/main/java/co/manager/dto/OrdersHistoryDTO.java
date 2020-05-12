package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class OrdersHistoryDTO {
    private Integer docNum;
    private Date docDate;
    private BigDecimal docTotal;

    public OrdersHistoryDTO() {
    }

    public OrdersHistoryDTO(Integer docNum, Date docDate, BigDecimal docTotal) {
        this.docNum = docNum;
        this.docDate = docDate;
        this.docTotal = docTotal;
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
        return "OrdersHistoryDTO{" +
                "docNum=" + docNum +
                ", docDate=" + docDate +
                ", docTotal=" + docTotal +
                '}';
    }
}
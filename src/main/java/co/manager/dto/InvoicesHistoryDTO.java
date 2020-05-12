package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class InvoicesHistoryDTO {
    private Integer docNum;
    private Integer porcDesc;
    private String docType;
    private String urlFacture;
    private Date docDate;
    private BigDecimal subTotal;
    private BigDecimal discount;
    private BigDecimal iva;
    private BigDecimal docTotal;

    public InvoicesHistoryDTO() {
    }

    public InvoicesHistoryDTO(String docType, Integer docNum, Date docDate, BigDecimal subTotal, Integer porcDesc, BigDecimal discount, BigDecimal iva, BigDecimal docTotal, String urlFacture) {
        this.docType = docType;
        this.docNum = docNum;
        this.docDate = docDate;
        this.subTotal = subTotal;
        this.porcDesc = porcDesc;
        this.discount = discount;
        this.iva = iva;
        this.docTotal = docTotal;
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

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getPorcDesc() {
        return porcDesc;
    }

    public void setPorcDesc(Integer porcDesc) {
        this.porcDesc = porcDesc;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    public String getUrlFacture() {
        return urlFacture;
    }

    public void setUrlFacture(String urlFacture) {
        this.urlFacture = urlFacture;
    }

    @Override
    public String toString() {
        return "InvoicesHistoryDTO{" +
                "docType='" + docType + '\'' +
                ", docNum='" + docNum + '\'' +
                ", docDate=" + docDate +
                ", subTotal=" + subTotal +
                ", porcDesc=" + porcDesc +
                ", discount=" + discount +
                ", iva=" + iva +
                ", docTotal=" + docTotal +
                ", urlFacture='" + urlFacture + '\'' +
                '}';
    }
}
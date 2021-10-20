package co.manager.hanaws.dto.purchaseInvoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseInvoicesDTO implements Serializable {
    private String cardCode;
    private String comments;
    private Long series;
    private String docDate;
    private String docDueDate;
    private Long contactPersonCode;
    private Long salesPersonCode;
    private BigDecimal baseAmount;
    private BigDecimal vatSum;
    private String uWUID;
    private Double utotcaj;
    private String ununfac;
    private List<PurchaseInvoicesDTO.DocumentLines.DocumentLine> documentLines;

    public PurchaseInvoicesDTO() {
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

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocDueDate() {
        return docDueDate;
    }

    public void setDocDueDate(String docDueDate) {
        this.docDueDate = docDueDate;
    }

    public Long getContactPersonCode() {
        return contactPersonCode;
    }

    public void setContactPersonCode(Long contactPersonCode) {
        this.contactPersonCode = contactPersonCode;
    }

    public Long getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(Long salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getVatSum() {
        return vatSum;
    }

    public void setVatSum(BigDecimal vatSum) {
        this.vatSum = vatSum;
    }

    public String getuWUID() {
        return uWUID;
    }

    public void setuWUID(String uWUID) {
        this.uWUID = uWUID;
    }

    public Double getUtotcaj() {
        return utotcaj;
    }

    public void setUtotcaj(Double utotcaj) {
        this.utotcaj = utotcaj;
    }

    public String getUnunfac() {
        return ununfac;
    }

    public void setUnunfac(String ununfac) {
        this.ununfac = ununfac;
    }

    public List<DocumentLines.DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<DocumentLines.DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    public static class DocumentLines {
        public static class DocumentLine {
            private Long lineNum;
            private String itemCode;
            private Double quantity;
            private String warehouseCode;
            private Long baseType;
            private Long baseEntry;
            private Long baseLine;

            public DocumentLine() {
            }

            public Long getLineNum() {
                return lineNum;
            }

            public void setLineNum(Long lineNum) {
                this.lineNum = lineNum;
            }

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            public Double getQuantity() {
                return quantity;
            }

            public void setQuantity(Double quantity) {
                this.quantity = quantity;
            }

            public String getWarehouseCode() {
                return warehouseCode;
            }

            public void setWarehouseCode(String warehouseCode) {
                this.warehouseCode = warehouseCode;
            }

            public Long getBaseType() {
                return baseType;
            }

            public void setBaseType(Long baseType) {
                this.baseType = baseType;
            }

            public Long getBaseEntry() {
                return baseEntry;
            }

            public void setBaseEntry(Long baseEntry) {
                this.baseEntry = baseEntry;
            }

            public Long getBaseLine() {
                return baseLine;
            }

            public void setBaseLine(Long baseLine) {
                this.baseLine = baseLine;
            }

            @Override
            public String toString() {
                return "DocumentLine{" +
                        "lineNum=" + lineNum +
                        ", itemCode='" + itemCode + '\'' +
                        ", quantity=" + quantity +
                        ", warehouseCode='" + warehouseCode + '\'' +
                        ", baseType=" + baseType +
                        ", baseEntry=" + baseEntry +
                        ", baseLine=" + baseLine +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "PurchaseInvoicesDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", series=" + series +
                ", docDate='" + docDate + '\'' +
                ", docDueDate='" + docDueDate + '\'' +
                ", contactPersonCode=" + contactPersonCode +
                ", salesPersonCode=" + salesPersonCode +
                ", baseAmount=" + baseAmount +
                ", vatSum=" + vatSum +
                ", uWUID='" + uWUID + '\'' +
                ", utotcaj=" + utotcaj +
                ", ununfac='" + ununfac + '\'' +
                ", documentLines=" + documentLines +
                '}';
    }
}
package co.manager.hanaws.dto.purchaseInvoice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseInvoicesDTO implements Serializable {
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("Comments")
    protected String comments;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocDueDate")
    protected String docDueDate;
    @JsonProperty("ContactPersonCode")
    protected Long contactPersonCode;
    @JsonProperty("SalesPersonCode")
    protected Long salesPersonCode;
    @JsonProperty("BaseAmount")
    protected BigDecimal baseAmount;
    @JsonProperty("VatSum")
    protected BigDecimal vatSum;
    @JsonProperty("U_WUID")
    protected String uWUID;
    @JsonProperty("U_TOT_CAJ")
    protected Double utotcaj;
    @JsonProperty("U_NUNFAC")
    protected String ununfac;
    @JsonProperty("DocumentLines")
    protected List<PurchaseInvoicesDTO.DocumentLines.DocumentLine> documentLines;
    /*@JsonProperty("DocumentAdditionalExpenses")
    protected List<PurchaseInvoicesDTO.DocumentAdditionalExpenses.DocumentAdditionalExpense> documentAdditionalExpenses;
    @JsonProperty("WithholdingTaxDataCollection")
    protected List<PurchaseInvoicesDTO.WithholdingTaxDataCollection.WithholdingTaxData> withholdingTaxDataCollection;*/

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
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("ItemCode")
            protected String itemCode;
            @JsonProperty("Quantity")
            protected Double quantity;
            @JsonProperty("WarehouseCode")
            protected String warehouseCode;
            @JsonProperty("BaseType")
            protected Long baseType;
            @JsonProperty("BaseEntry")
            protected Long baseEntry;
            @JsonProperty("BaseLine")
            protected Long baseLine;

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
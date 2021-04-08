package co.manager.hanaws.dto.quotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotationsDTO implements Serializable {
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocDueDate")
    protected String docDueDate;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("Comments")
    protected String comments;
    @JsonProperty("NumAtCard")
    protected String numAtCard;
    @JsonProperty("SalesPersonCode")
    protected Long salesPersonCode;
    @JsonProperty("DocumentLines")
    protected List<QuotationsDTO.DocumentLines.DocumentLine> documentLines;

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

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
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

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public Long getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(Long salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public List<QuotationsDTO.DocumentLines.DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<QuotationsDTO.DocumentLines.DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    @Override
    public String toString() {
        return "QuotationsDTO{" +
                "docDate='" + docDate + '\'' +
                ", docDueDate='" + docDueDate + '\'' +
                ", series=" + series +
                ", cardCode='" + cardCode + '\'' +
                ", comments='" + comments + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", salesPersonCode=" + salesPersonCode +
                ", documentLines=" + documentLines +
                '}';
    }

    public static class DocumentLines {
        public static class DocumentLine {
            @JsonProperty("ItemCode")
            protected String itemCode;
            @JsonProperty("Quantity")
            protected Double quantity;
            @JsonProperty("WarehouseCode")
            protected String warehouseCode;

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

            @Override
            public String toString() {
                return "DocumentLine{" +
                        "itemCode='" + itemCode + '\'' +
                        ", quantity=" + quantity +
                        ", warehouseCode='" + warehouseCode + '\'' +
                        '}';
            }
        }
    }
}
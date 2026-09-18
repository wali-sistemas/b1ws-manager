package co.manager.hanaws.dto.InventoryGenExits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryGenExitsDTO implements Serializable {
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocDueDate")
    protected String docDueDate;
    @JsonProperty("Series")
    protected Integer series;
    @JsonProperty("Reference2")
    protected String reference2;
    @JsonProperty("Comments")
    protected String comments;
    @JsonProperty("DocumentLines")
    protected List<InventoryGenExitsDTO.DocumentLine> documentLines;

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

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public List<DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentLine implements Serializable {
        @JsonProperty("ItemCode")
        protected String itemCode;
        @JsonProperty("Quantity")
        protected Integer quantity;
        @JsonProperty("WarehouseCode")
        protected String warehouseCode;

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getWarehouseCode() {
            return warehouseCode;
        }

        public void setWarehouseCode(String warehouseCode) {
            this.warehouseCode = warehouseCode;
        }

    }
}

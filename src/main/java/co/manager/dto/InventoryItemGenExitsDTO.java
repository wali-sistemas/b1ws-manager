package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryItemGenExitsDTO {
    private String cardCode;
    private String comment;
    private String companyName;
    private List<DocumentLines> documentLines;

    public static class DocumentLines {
        private String itemCode;
        private Integer quantity;
        private String whsCode;

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

        public String getWhsCode() {
            return whsCode;
        }

        public void setWhsCode(String whsCode) {
            this.whsCode = whsCode;
        }

        @Override
        public String toString() {
            return "DocumentLines{" +
                    "itemCode='" + itemCode + '\'' +
                    ", quantity='" + quantity + '\'' +
                    ", whsCode='" + whsCode + '\'' +
                    '}';
        }
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<DocumentLines> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<DocumentLines> documentLines) {
        this.documentLines = documentLines;
    }

    @Override
    public String toString() {
        return "InventoryGenExitsDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", comment='" + comment + '\'' +
                ", companyName='" + companyName + '\'' +
                ", documentLines=" + documentLines +
                '}';
    }
}

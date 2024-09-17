package co.manager.hanaws.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO implements Serializable {
    @JsonProperty("DocEntry")
    protected Long docEntry;
    @JsonProperty("DocNum")
    protected Long docNum;
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocDueDate")
    protected String docDueDate;
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("NumAtCard")
    protected String numAtCard;
    @JsonProperty("Comments")
    protected String comments;
    @JsonProperty("JournalMemo")
    protected String journalMemo;
    @JsonProperty("SalesPersonCode")
    protected Long salesPersonCode;
    @JsonProperty("Confirmed")
    protected String confirmed;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("ShipToCode")
    protected String shipToCode;
    @JsonProperty("DiscountPercent")
    protected Double discountPercent;
    @JsonProperty("PayToCode")
    protected String payToCode;
    @JsonProperty("U_TRANSP")
    protected String utransp;
    @JsonProperty("U_SEPARADOR")
    protected String useparador;
    @JsonProperty("U_FEC_INI")
    protected String ufecini;
    @JsonProperty("U_SERIAL")
    protected String userialMDL;
    @JsonProperty("U_ESTADO_PED")
    protected String uestadoPed;
    @JsonProperty("DocumentLines")
    protected List<OrderDTO.DocumentLines.DocumentLine> documentLines;
    @JsonProperty("DocumentAdditionalExpenses")
    protected List<OrderDTO.DocumentAdditionalExpenses.DocumentAdditionalExpense> documentAdditionalExpenses;

    public Long getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Long docEntry) {
        this.docEntry = docEntry;
    }

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
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

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getJournalMemo() {
        return journalMemo;
    }

    public void setJournalMemo(String journalMemo) {
        this.journalMemo = journalMemo;
    }

    public Long getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(Long salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public String getShipToCode() {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
    }

    public String getUtransp() {
        return utransp;
    }

    public void setUtransp(String utransp) {
        this.utransp = utransp;
    }

    public String getUseparador() {
        return useparador;
    }

    public void setUseparador(String useparador) {
        this.useparador = useparador;
    }

    public String getUfecini() {
        return ufecini;
    }

    public void setUfecini(String ufecini) {
        this.ufecini = ufecini;
    }

    public String getUserialMDL() {
        return userialMDL;
    }

    public void setUserialMDL(String userialMDL) {
        this.userialMDL = userialMDL;
    }

    public String getUestadoPed() {
        return uestadoPed;
    }

    public void setUestadoPed(String uestadoPed) {
        this.uestadoPed = uestadoPed;
    }

    public List<OrderDTO.DocumentLines.DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<OrderDTO.DocumentLines.DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    public List<DocumentAdditionalExpenses.DocumentAdditionalExpense> getDocumentAdditionalExpenses() {
        return documentAdditionalExpenses;
    }

    public void setDocumentAdditionalExpenses(List<DocumentAdditionalExpenses.DocumentAdditionalExpense> documentAdditionalExpenses) {
        this.documentAdditionalExpenses = documentAdditionalExpenses;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentLines implements Serializable {
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DocumentLine implements Serializable {
            @JsonProperty("ItemCode")
            protected String itemCode;
            @JsonProperty("Quantity")
            protected Double quantity;
            @JsonProperty("Price")
            protected Double price;
            @JsonProperty("UnitPrice")
            protected Double unitPrice;
            @JsonProperty("WarehouseCode")
            protected String warehouseCode;
            @JsonProperty("CostingCode")
            protected String costingCode;
            @JsonProperty("BaseType")
            protected Long baseType;
            @JsonProperty("BaseEntry")
            protected Long baseEntry;
            @JsonProperty("BaseLine")
            protected Long baseLine;
            @JsonProperty("TaxCode")
            protected String taxCode;
            @JsonProperty("AccountCode")
            protected String accountCode;

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

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            public Double getUnitPrice() {
                return unitPrice;
            }

            public void setUnitPrice(Double unitPrice) {
                this.unitPrice = unitPrice;
            }

            public String getWarehouseCode() {
                return warehouseCode;
            }

            public void setWarehouseCode(String warehouseCode) {
                this.warehouseCode = warehouseCode;
            }

            public String getCostingCode() {
                return costingCode;
            }

            public void setCostingCode(String costingCode) {
                this.costingCode = costingCode;
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

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }

            public String getAccountCode() {
                return accountCode;
            }

            public void setAccountCode(String accountCode) {
                this.accountCode = accountCode;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentAdditionalExpenses implements Serializable {
        public static class DocumentAdditionalExpense implements Serializable {
            @JsonProperty("ExpenseCode")
            protected Long expenseCode;
            @JsonProperty("LineTotal")
            protected BigDecimal lineTotal;
            @JsonProperty("TaxCode")
            protected String taxCode;

            public Long getExpenseCode() {
                return expenseCode;
            }

            public void setExpenseCode(Long expenseCode) {
                this.expenseCode = expenseCode;
            }

            public BigDecimal getLineTotal() {
                return lineTotal;
            }

            public void setLineTotal(BigDecimal lineTotal) {
                this.lineTotal = lineTotal;
            }

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }
        }
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "docEntry=" + docEntry +
                ", docNum=" + docNum +
                ", docDate='" + docDate + '\'' +
                ", docDueDate='" + docDueDate + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", comments='" + comments + '\'' +
                ", journalMemo='" + journalMemo + '\'' +
                ", salesPersonCode=" + salesPersonCode +
                ", confirmed='" + confirmed + '\'' +
                ", series=" + series +
                ", shipToCode='" + shipToCode + '\'' +
                ", discountPercent=" + discountPercent +
                ", payToCode='" + payToCode + '\'' +
                ", utransp='" + utransp + '\'' +
                ", useparador='" + useparador + '\'' +
                ", ufecini='" + ufecini + '\'' +
                ", userialMDL='" + userialMDL + '\'' +
                ", uestadoPed='" + uestadoPed + '\'' +
                ", documentLines=" + documentLines +
                ", documentAdditionalExpenses=" + documentAdditionalExpenses +
                '}';
    }
}
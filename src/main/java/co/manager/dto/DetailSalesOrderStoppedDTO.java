package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailSalesOrderStoppedDTO {
    private Integer docNum;
    private String nit;
    private String cardCode;
    private String cardName;
    private String slpCode;
    private String slpName;
    private String status;
    private String month;
    private Date docDate;
    private Date docDueDate;
    private BigDecimal docTotal;
    private List<DetailItemDTO> detailItem;

    public DetailSalesOrderStoppedDTO() {
    }

    public DetailSalesOrderStoppedDTO(Integer docNum, String nit, String cardCode, String cardName, String slpCode, String slpName, String status, String month, Date docDate, Date docDueDate, BigDecimal docTotal, List<DetailItemDTO> detailItem) {
        this.docNum = docNum;
        this.nit = nit;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.status = status;
        this.month = month;
        this.docDate = docDate;
        this.docDueDate = docDueDate;
        this.docTotal = docTotal;
        this.detailItem = detailItem;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getDocDueDate() {
        return docDueDate;
    }

    public void setDocDueDate(Date docDueDate) {
        this.docDueDate = docDueDate;
    }

    public BigDecimal getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(BigDecimal docTotal) {
        this.docTotal = docTotal;
    }

    public List<DetailItemDTO> getDetailItem() {
        return detailItem;
    }

    public void setDetailItem(List<DetailItemDTO> detailItem) {
        this.detailItem = detailItem;
    }

    @Override
    public String toString() {
        return "DetailSalesOrderStoppedDTO{" +
                "docNum=" + docNum +
                ", nit='" + nit + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", status='" + status + '\'' +
                ", month='" + month + '\'' +
                ", docDate=" + docDate +
                ", docDueDate=" + docDueDate +
                ", docTotal=" + docTotal +
                ", detailItem=" + detailItem +
                '}';
    }

    public static class DetailItemDTO {
        private String itemCode;
        private String dscription;
        private Integer orderQty;
        private Integer delivrdQty;
        private BigDecimal price;

        public DetailItemDTO() {
        }

        public DetailItemDTO(String itemCode, String dscription, Integer orderQty, Integer delivrdQty, BigDecimal price) {
            this.itemCode = itemCode;
            this.dscription = dscription;
            this.orderQty = orderQty;
            this.delivrdQty = delivrdQty;
            this.price = price;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getDscription() {
            return dscription;
        }

        public void setDscription(String dscription) {
            this.dscription = dscription;
        }

        public Integer getOrderQty() {
            return orderQty;
        }

        public void setOrderQty(Integer orderQty) {
            this.orderQty = orderQty;
        }

        public Integer getDelivrdQty() {
            return delivrdQty;
        }

        public void setDelivrdQty(Integer delivrdQty) {
            this.delivrdQty = delivrdQty;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "DetailItemDTO{" +
                    "itemCode='" + itemCode + '\'' +
                    ", dscription='" + dscription + '\'' +
                    ", orderQty=" + orderQty +
                    ", delivrdQty=" + delivrdQty +
                    ", price=" + price +
                    '}';
        }
    }
}
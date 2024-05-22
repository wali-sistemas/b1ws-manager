package co.manager.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
public class OrdersPedboxHistoryDTO {
    private String docDate;
    private String docNum;
    private Integer desc1;
    private BigDecimal total;
    private List<OrdersDetailsPedboxHistoryDTO> detailHistory;

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Integer getDesc1() {
        return desc1;
    }

    public void setDesc1(Integer desc1) {
        this.desc1 = desc1;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<OrdersDetailsPedboxHistoryDTO> getDetailHistory() {
        return detailHistory;
    }

    public void setDetailHistory(List<OrdersDetailsPedboxHistoryDTO> detailHistory) {
        this.detailHistory = detailHistory;
    }

    public static class OrdersDetailsPedboxHistoryDTO {
        private Integer seq;
        private String itemCode;
        private String itemName;
        private Integer qty;
        private String whsCode;
        private Integer iva;
        private Integer desc2;
        private BigDecimal price;
        private BigDecimal subTotal;

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getQty() {
            return qty;
        }

        public void setQty(Integer qty) {
            this.qty = qty;
        }

        public String getWhsCode() {
            return whsCode;
        }

        public void setWhsCode(String whsCode) {
            this.whsCode = whsCode;
        }

        public Integer getIva() {
            return iva;
        }

        public void setIva(Integer iva) {
            this.iva = iva;
        }

        public Integer getDesc2() {
            return desc2;
        }

        public void setDesc2(Integer desc2) {
            this.desc2 = desc2;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getSubTotal() {
            return subTotal;
        }

        public void setSubTotal(BigDecimal subTotal) {
            this.subTotal = subTotal;
        }

        public Integer getSeq() {
            return seq;
        }

        public void setSeq(Integer seq) {
            this.seq = seq;
        }

        @Override
        public String toString() {
            return "OrdersDetailsPedboxHistoryDTO{" +
                    "seq=" + seq +
                    ", itemCode='" + itemCode + '\'' +
                    ", itemName='" + itemName + '\'' +
                    ", qty=" + qty +
                    ", whsCode='" + whsCode + '\'' +
                    ", iva=" + iva +
                    ", desc2=" + desc2 +
                    ", price=" + price +
                    ", subTotal=" + subTotal +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrdersPedboxHistoryDTO{" +
                "docDate='" + docDate + '\'' +
                ", docNum='" + docNum + '\'' +
                ", desc1=" + desc1 +
                ", total=" + total +
                ", detailHistory=" + detailHistory +
                '}';
    }
}
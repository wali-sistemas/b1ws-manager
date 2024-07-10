package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class ResponseExtranetDTO {
    private int code;
    private Object content;
    private String message;
    private List<OutStockItems> outStockItems;

    public ResponseExtranetDTO() {
    }

    public ResponseExtranetDTO(int code, Object content) {
        this.code = code;
        this.content = content;
    }

    public ResponseExtranetDTO(int code, Object content, String message, List<OutStockItems> outStockItems) {
        this.code = code;
        this.content = content;
        this.message = message;
        this.outStockItems = outStockItems;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OutStockItems> getOutStockItems() {
        return outStockItems;
    }

    public void setOutStockItems(List<OutStockItems> outStockItems) {
        this.outStockItems = outStockItems;
    }

    public static class OutStockItems {
        private String itemCode;
        private Integer qtyOrder;
        private Integer qtyCurrent;

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public Integer getQtyOrder() {
            return qtyOrder;
        }

        public void setQtyOrder(Integer qtyOrder) {
            this.qtyOrder = qtyOrder;
        }

        public Integer getQtyCurrent() {
            return qtyCurrent;
        }

        public void setQtyCurrent(Integer qtyCurrent) {
            this.qtyCurrent = qtyCurrent;
        }
    }
}
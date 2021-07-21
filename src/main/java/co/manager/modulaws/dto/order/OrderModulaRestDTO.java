package co.manager.modulaws.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderModulaRestDTO implements Serializable {
    public static class Header {
        @JsonProperty("IMP_ORDINI")
        public List<OrderModulaRestDTO.Header.Ordine> order;
        @JsonProperty("IMP_ORDINI_RIGHE")
        public List<OrderModulaRestDTO.Header.Detail> detail;

        public List<Ordine> getOrder() {
            return order;
        }

        public void setOrder(List<Ordine> order) {
            this.order = order;
        }

        public List<Detail> getDetail() {
            return detail;
        }

        public void setDetail(List<Detail> detail) {
            this.detail = detail;
        }

        public static class Ordine {
            @JsonProperty("ORD_ORDINE")
            private String docNum;
            @JsonProperty("ORD_DES")
            private String comment;
            @JsonProperty("ORD_TIPOOP")
            private String type;

            public String getDocNum() {
                return docNum;
            }

            public void setDocNum(String docNum) {
                this.docNum = docNum;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class Detail {
            @JsonProperty("RIG_ORDINE")
            private String docNum;
            @JsonProperty("RIG_ARTICOLO")
            private String itemCode;
            @JsonProperty("RIG_QTAR")
            private String quantity;

            public String getDocNum() {
                return docNum;
            }

            public void setDocNum(String docNum) {
                this.docNum = docNum;
            }

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }
        }
    }
}
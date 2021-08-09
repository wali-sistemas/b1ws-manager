package co.manager.modulaws.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderExpModulaRestDTO implements Serializable {
    @JsonProperty("GUID")
    private String id;
    @JsonProperty("DATA")
    private OrderExpModulaRestDTO.OrderExpRestDTO order;
    @JsonProperty("TransactionStatus")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderExpRestDTO getOrder() {
        return order;
    }

    public void setOrder(OrderExpRestDTO order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class OrderExpRestDTO {
        @JsonProperty("EXP_ORDINI")
        private List<HeaderDTO> header;
        @JsonProperty("EXP_ORDINI_RIGHE")
        private List<DetailDTO> details;
        @JsonProperty("EXP_ORDINI_RIGHE_STO")
        private List<String> expOrdiniRigheSTO;
        @JsonProperty("EXP_ORDINI_UDS")
        private List<String> expOrdiniUDS;
        @JsonProperty("EXP_ORDINI_UDS_SCOMPARTI")
        private List<String> expOrdiniUDSComparti;

        public List<HeaderDTO> getHeader() {
            return header;
        }

        public void setHeader(List<HeaderDTO> header) {
            this.header = header;
        }

        public List<DetailDTO> getDetails() {
            return details;
        }

        public void setDetails(List<DetailDTO> details) {
            this.details = details;
        }

        public List<String> getExpOrdiniRigheSTO() {
            return expOrdiniRigheSTO;
        }

        public void setExpOrdiniRigheSTO(List<String> expOrdiniRigheSTO) {
            this.expOrdiniRigheSTO = expOrdiniRigheSTO;
        }

        public List<String> getExpOrdiniUDS() {
            return expOrdiniUDS;
        }

        public void setExpOrdiniUDS(List<String> expOrdiniUDS) {
            this.expOrdiniUDS = expOrdiniUDS;
        }

        public List<String> getExpOrdiniUDSComparti() {
            return expOrdiniUDSComparti;
        }

        public void setExpOrdiniUDSComparti(List<String> expOrdiniUDSComparti) {
            this.expOrdiniUDSComparti = expOrdiniUDSComparti;
        }

        public static class HeaderDTO {
            @JsonProperty("ORD_ORDINE")
            private String docNum;
            @JsonProperty("ORD_DES")
            private String comment;
            @JsonProperty("ORD_TIPOOP")
            private String type;
            @JsonProperty("EXP_ORDINI_Id")
            private Integer docEntry;

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

            public Integer getDocEntry() {
                return docEntry;
            }

            public void setDocEntry(Integer docEntry) {
                this.docEntry = docEntry;
            }
        }

        public static class DetailDTO {
            @JsonProperty("RIG_ORDINE")
            private String docNum;
            @JsonProperty("RIG_ARTICOLO")
            private String itemCode;
            @JsonProperty("RIG_QTAR")
            private String qtyReq;
            @JsonProperty("RIG_QTAE")
            private String qtySol;
            @JsonProperty("EXP_ORDINI_Id")
            private Integer docEntry;

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

            public String getQtyReq() {
                return qtyReq;
            }

            public void setQtyReq(String qtyReq) {
                this.qtyReq = qtyReq;
            }

            public String getQtySol() {
                return qtySol;
            }

            public void setQtySol(String qtySol) {
                this.qtySol = qtySol;
            }

            public Integer getDocEntry() {
                return docEntry;
            }

            public void setDocEntry(Integer docEntry) {
                this.docEntry = docEntry;
            }
        }
    }
}
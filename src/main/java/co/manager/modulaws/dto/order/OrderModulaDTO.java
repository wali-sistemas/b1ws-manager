package co.manager.modulaws.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderModulaDTO {
    private String docEntry;
    private String type;
    private List<DetailModulaDTO> detail;

    public String getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(String docEntry) {
        this.docEntry = docEntry;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DetailModulaDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailModulaDTO> detail) {
        this.detail = detail;
    }

    public static class DetailModulaDTO {
        private String itemCode;
        private Integer quantity;
        private String toBin;
        private String fromBin;

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

        public String getToBin() {
            return toBin;
        }

        public void setToBin(String toBin) {
            this.toBin = toBin;
        }

        public String getFromBin() {
            return fromBin;
        }

        public void setFromBin(String fromBin) {
            this.fromBin = fromBin;
        }

        @Override
        public String toString() {
            return "DetailModulaDTO{" +
                    "itemCode='" + itemCode + '\'' +
                    ", quantity=" + quantity +
                    ", toBin='" + toBin + '\'' +
                    ", fromBin='" + fromBin + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "OrderModulaDTO{" +
                "docEntry='" + docEntry + '\'' +
                ", type='" + type + '\'' +
                ", detail=" + detail +
                '}';
    }
}
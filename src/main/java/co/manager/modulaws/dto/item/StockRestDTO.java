package co.manager.modulaws.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockRestDTO implements Serializable {
    @JsonProperty("GUID")
    private String id;
    @JsonProperty("DATA")
    private StockRestDTO.ItemDTO item;
    @JsonProperty("TransactionStatus")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ItemDTO {
        @JsonProperty("EXP_GIACENZE")
        private List<DetailDTO> details;

        public List<DetailDTO> getDetails() {
            return details;
        }

        public void setDetails(List<DetailDTO> details) {
            this.details = details;
        }

        public static class DetailDTO {
            @JsonProperty("GIA_ARTICOLO")
            private String itemCode;
            @JsonProperty("GIA_ARTICOLO_DES")
            private String itemName;
            @JsonProperty("GIA_GIAC")
            private String stock;

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

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }
        }
    }
}
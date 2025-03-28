package co.manager.hanaws.dto.businessPartner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessPartnersWithholdingTaxDTO implements Serializable {
    @JsonProperty("BPWithholdingTaxCollection")
    protected List<BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTaxCollection;

    public List<BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax> getBpWithholdingTaxCollection() {
        return bpWithholdingTaxCollection;
    }

    public void setBpWithholdingTaxCollection(List<BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTaxCollection) {
        this.bpWithholdingTaxCollection = bpWithholdingTaxCollection;
    }

    public static class BPWithholdingTaxCollection {
        public static class BPWithholdingTax {
            @JsonProperty("WTCode")
            protected String wtCode;
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getWtCode() {
                return wtCode;
            }

            public void setWtCode(String wtCode) {
                this.wtCode = wtCode;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }
}
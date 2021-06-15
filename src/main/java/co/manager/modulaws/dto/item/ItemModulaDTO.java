package co.manager.modulaws.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemModulaDTO implements Serializable {
    @JsonProperty("IMP_ARTICOLI")
    private List<ItemModulaDTO.item> impArticuli;

    public List<item> getImpArticuli() {
        return impArticuli;
    }

    public void setImpArticuli(List<item> impArticuli) {
        this.impArticuli = impArticuli;
    }

    public static class item {
        @JsonProperty("ART_OPERAZIONE")
        private String artOperacione;
        @JsonProperty("ART_ARTICOLO")
        private String artArticolo;
        @JsonProperty("ART_DES")
        private String artDes;
        @JsonProperty("ART_SOTTOSCO")
        private Integer artSottosco;
        @JsonProperty("ART_DISP")
        private Integer artDisp;

        public String getArtOperacione() {
            return artOperacione;
        }

        public void setArtOperacione(String artOperacione) {
            this.artOperacione = artOperacione;
        }

        public String getArtArticolo() {
            return artArticolo;
        }

        public void setArtArticolo(String artArticolo) {
            this.artArticolo = artArticolo;
        }

        public String getArtDes() {
            return artDes;
        }

        public void setArtDes(String artDes) {
            this.artDes = artDes;
        }

        public Integer getArtSottosco() {
            return artSottosco;
        }

        public void setArtSottosco(Integer artSottosco) {
            this.artSottosco = artSottosco;
        }

        public Integer getArtDisp() {
            return artDisp;
        }

        public void setArtDisp(Integer artDisp) {
            this.artDisp = artDisp;
        }
    }
}
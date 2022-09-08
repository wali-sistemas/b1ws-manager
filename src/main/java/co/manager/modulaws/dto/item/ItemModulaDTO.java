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
        private Integer artStockMin;
        @JsonProperty("ART_STOCKMAX")
        private Integer artStockMax;
        @JsonProperty("ART_NOTE")
        private String artActive;
        @JsonProperty("ART_CREASCO_DIMX")
        private Integer artDIMX;
        @JsonProperty("ART_CREASCO_DIMY")
        private Integer artDIMY;
        @JsonProperty("ART_CREASCO_DIMZ")
        private Integer artDIMZ;
        @JsonProperty("ART_PMU")
        private Integer artPMU;
        @JsonProperty("ART_AREEABI")
        private Integer artAREEABI;

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

        public Integer getArtStockMin() {
            return artStockMin;
        }

        public void setArtStockMin(Integer artStockMin) {
            this.artStockMin = artStockMin;
        }

        public Integer getArtStockMax() {
            return artStockMax;
        }

        public void setArtStockMax(Integer artStockMax) {
            this.artStockMax = artStockMax;
        }

        public String getArtActive() {
            return artActive;
        }

        public void setArtActive(String artActive) {
            this.artActive = artActive;
        }

        public Integer getArtDIMX() {
            return artDIMX;
        }

        public void setArtDIMX(Integer artDIMX) {
            this.artDIMX = artDIMX;
        }

        public Integer getArtDIMY() {
            return artDIMY;
        }

        public void setArtDIMY(Integer artDIMY) {
            this.artDIMY = artDIMY;
        }

        public Integer getArtDIMZ() {
            return artDIMZ;
        }

        public void setArtDIMZ(Integer artDIMZ) {
            this.artDIMZ = artDIMZ;
        }

        public Integer getArtPMU() {
            return artPMU;
        }

        public void setArtPMU(Integer artPMU) {
            this.artPMU = artPMU;
        }

        public Integer getArtAREEABI() {
            return artAREEABI;
        }

        public void setArtAREEABI(Integer artAREEABI) {
            this.artAREEABI = artAREEABI;
        }
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConceptCalidosoDTO {
    private String code;
    private String Concepto;

    public ConceptCalidosoDTO() {
    }

    public ConceptCalidosoDTO(String code, String concepto) {
        this.code = code;
        Concepto = concepto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConcepto() {
        return Concepto;
    }

    public void setConcepto(String concepto) {
        Concepto = concepto;
    }

    @Override
    public String toString() {
        return "RedencionConceptoDTO{" +
                "code='" + code + '\'' +
                ", Concepto='" + Concepto + '\'' +
                '}';
    }
}
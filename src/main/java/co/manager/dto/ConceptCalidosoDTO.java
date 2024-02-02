package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConceptCalidosoDTO {
    private String code;
    private String concepto;

    public ConceptCalidosoDTO() {
    }

    public ConceptCalidosoDTO(String code, String concepto) {
        this.code = code;
        this.concepto = concepto;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return "ConceptCalidosoDTO{" +
                "code='" + code + '\'' +
                ", concepto='" + concepto + '\'' +
                '}';
    }
}
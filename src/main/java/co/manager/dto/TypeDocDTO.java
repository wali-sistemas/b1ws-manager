package co.manager.dto;

/**
 * @author jguisao
 */
public class TypeDocDTO {
    private String code;
    private String document;
    private String type;

    public TypeDocDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeDocDTO{" +
                "code='" + code + '\'' +
                ", document='" + document + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
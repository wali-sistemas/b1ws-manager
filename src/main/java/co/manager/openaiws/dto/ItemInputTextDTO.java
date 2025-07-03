package co.manager.openaiws.dto;

/**
 * @author jguisao
 */
public class ItemInputTextDTO {
    private String message;
    private String rol;
    private String slpCode;
    private String slpName;
    private String companyName;

    public ItemInputTextDTO() {
    }

    public ItemInputTextDTO(String message, String rol, String slpCode, String slpName, String companyName) {
        this.message = message;
        this.rol = rol;
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.companyName = companyName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ItemInputTextDTO{" +
                "message='" + message + '\'' +
                ", rol='" + rol + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
package co.manager.dto;

/**
 * @author jguisao
 */
public class GeolocationDTO {
    private String cardCode;
    private String latitud;
    private String longitud;
    private String companyName;

    public GeolocationDTO() {
    }

    public GeolocationDTO(String cardCode, String latitud, String longitud, String companyName) {
        this.cardCode = cardCode;
        this.latitud = latitud;
        this.longitud = longitud;
        this.companyName = companyName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "GeolocationDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
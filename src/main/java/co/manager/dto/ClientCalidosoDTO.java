package co.manager.dto;

/**
 * @author jguisao
 */
public class ClientCalidosoDTO {
    private String CardCode;
    private String CardName;
    private String LicTradNum;

    public ClientCalidosoDTO() {
    }

    public String getCardCode() {
        return CardCode;
    }

    public void setCardCode(String cardCode) {
        CardCode = cardCode;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getLicTradNum() {
        return LicTradNum;
    }

    public void setLicTradNum(String licTradNum) {
        LicTradNum = licTradNum;
    }

    @Override
    public String toString() {
        return "ClientCalidosoDTO{" +
                "CardCode='" + CardCode + '\'' +
                ", CardName='" + CardName + '\'' +
                ", LicTradNum='" + LicTradNum + '\'' +
                '}';
    }
}
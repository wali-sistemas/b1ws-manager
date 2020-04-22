package co.manager.dto;

/**
 * @author jguisao
 */
public class BusinessPartnerDTO {
    private String cardCode;
    private String cardName;
    private Character cardType;
    private String licTradNum;
    private String uBPCORTC;
    private String companyName;
    private Integer uBPCOTDC;
    private Integer uBPCOCS;

    public BusinessPartnerDTO() {
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Character getCardType() {
        return cardType;
    }

    public void setCardType(Character cardType) {
        this.cardType = cardType;
    }

    public String getLicTradNum() {
        return licTradNum;
    }

    public void setLicTradNum(String licTradNum) {
        this.licTradNum = licTradNum;
    }

    public String getuBPCORTC() {
        return uBPCORTC;
    }

    public void setuBPCORTC(String uBPCORTC) {
        this.uBPCORTC = uBPCORTC;
    }

    public Integer getuBPCOTDC() {
        return uBPCOTDC;
    }

    public void setuBPCOTDC(Integer uBPCOTDC) {
        this.uBPCOTDC = uBPCOTDC;
    }

    public Integer getuBPCOCS() {
        return uBPCOCS;
    }

    public void setuBPCOCS(Integer uBPCOCS) {
        this.uBPCOCS = uBPCOCS;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "BusinessPartnerDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardType=" + cardType +
                ", licTradNum='" + licTradNum + '\'' +
                ", uBPCORTC='" + uBPCORTC + '\'' +
                ", companyName='" + companyName + '\'' +
                ", uBPCOTDC=" + uBPCOTDC +
                ", uBPCOCS=" + uBPCOCS +
                '}';
    }
}
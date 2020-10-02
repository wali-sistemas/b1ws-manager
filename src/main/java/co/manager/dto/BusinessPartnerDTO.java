package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessPartnerDTO {
    private String cardCode;
    private String cardName;
    private String typeDoc;
    private Character cardType;
    private String licTradNum;
    private String uBPCORTC;
    private String companyName;
    private Integer uBPCOTDC;
    private Integer uBPCOCS;
    private String acceptHabeasData;
    private String firstname;
    private String lastname1;
    private String lastname2;
    private String phone;
    private String cellular;
    private String mail;
    private String codDepartamento;
    private String codMunicipio;
    private String address;

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

    public String getAcceptHabeasData() {
        return acceptHabeasData;
    }

    public void setAcceptHabeasData(String acceptHabeasData) {
        this.acceptHabeasData = acceptHabeasData;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getLastname1() {
        return lastname1;
    }

    public void setLastname1(String lastname1) {
        this.lastname1 = lastname1;
    }

    public String getLastname2() {
        return lastname2;
    }

    public void setLastname2(String lastname2) {
        this.lastname2 = lastname2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public String getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(String codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BusinessPartnerDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", typeDoc='" + typeDoc + '\'' +
                ", cardType=" + cardType +
                ", licTradNum='" + licTradNum + '\'' +
                ", uBPCORTC='" + uBPCORTC + '\'' +
                ", companyName='" + companyName + '\'' +
                ", uBPCOTDC=" + uBPCOTDC +
                ", uBPCOCS=" + uBPCOCS +
                ", acceptHabeasData='" + acceptHabeasData + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname1='" + lastname1 + '\'' +
                ", lastname2='" + lastname2 + '\'' +
                ", phone='" + phone + '\'' +
                ", cellular='" + cellular + '\'' +
                ", mail='" + mail + '\'' +
                ", codDepartamento='" + codDepartamento + '\'' +
                ", codMunicipio='" + codMunicipio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
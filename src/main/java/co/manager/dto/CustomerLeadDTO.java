package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerLeadDTO {
    private static Date createDate;
    private static String documentRut = "Y";
    private static String fidelity = "Y";
    private static String aut3 = "Y";
    private static String aut4 = "Y";
    private static String subject = "Y";
    private static String distributo = "02";
    private static Character cardType = 'L';
    //private String typeTransaction;
    private String document;
    private String cardName;
    private String licTradNum;
    private String cellular;
    private String mail;
    private String slpCode;
    private String companyName;
    //Ubicación
    private String address;
    private String departament;
    private String municipio;
    private String city;

    public CustomerLeadDTO() {
    }

    public static Date getCreateDate() {
        return createDate;
    }

    public static void setCreateDate(Date createDate) {
        CustomerLeadDTO.createDate = createDate;
    }

    public static String getDocumentRut() {
        return documentRut;
    }

    public static void setDocumentRut(String documentRut) {
        CustomerLeadDTO.documentRut = documentRut;
    }

    public static String getFidelity() {
        return fidelity;
    }

    public static void setFidelity(String fidelity) {
        CustomerLeadDTO.fidelity = fidelity;
    }

    public static String getAut3() {
        return aut3;
    }

    public static void setAut3(String aut3) {
        CustomerLeadDTO.aut3 = aut3;
    }

    public static String getAut4() {
        return aut4;
    }

    public static void setAut4(String aut4) {
        CustomerLeadDTO.aut4 = aut4;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        CustomerLeadDTO.subject = subject;
    }

    public static String getDistributo() {
        return distributo;
    }

    public static void setDistributo(String distributo) {
        CustomerLeadDTO.distributo = distributo;
    }

    public static Character getCardType() {
        return cardType;
    }

    public static void setCardType(Character cardType) {
        CustomerLeadDTO.cardType = cardType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getLicTradNum() {
        return licTradNum;
    }

    public void setLicTradNum(String licTradNum) {
        this.licTradNum = licTradNum;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CustomerLeadDTO{" +
                "document='" + document + '\'' +
                ", cardName='" + cardName + '\'' +
                ", licTradNum='" + licTradNum + '\'' +
                ", cellular='" + cellular + '\'' +
                ", mail='" + mail + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", departament='" + departament + '\'' +
                ", municipio='" + municipio + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

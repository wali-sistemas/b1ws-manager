package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessPartnerDTO {
    private static Date createDate;
    private static String documentRut = "Y";
    private static String fidelity = "Y";
    private static String aut3 = "Y";
    private static String aut4 = "Y";
    private static String subject = "Y";
    private static String distributo = "02";
    private Character cardType;
    private String typeTransaction;
    private String document;
    private String cardCode;
    private String cardName;
    private String licTradNum;
    private String cellular;
    private String phone;
    private String mail;
    private String slpCode;
    private String zona;
    private String comment;
    private String grupo;
    private String acceptHabeasData;
    private String companyName;
    private String transp;
    private String priceList;
    //Contacto
    private String contactPerson;
    private String nameContactPerson;
    private String secondNamecontactPerson;
    private String lastNameContactPerson;
    private String occupationContactPerson;
    private String phoneContactPerson;
    private String dateContactPerson;
    //Ubicación
    private String idAddress;
    private String address;
    private String codDepartamento;
    private String codMunicipio;
    private String taxAddress;
    private String lengthMap;
    private String latitudeMap;
    //Medios Mag
    private String firstname;
    private String lastname1;
    private String lastname2;
    private String typeDoc;
    private String typePerson;
    private String taxRegimen;
    private String codeCity;
    private String addressMM;
    private String regional;
    private String mailFE;
    private String typeSell;
    //Impustos & finanzas
    private String paymentCondition;
    private Double discount;
    private String taxType;
    private Double creditLimit;
    private Double comiteLimit;
    private List<WithholdingTax> withholdingTax;
    //Responsabilidad fiscal
    private String codeResFis;
    private String descResFis;

    public BusinessPartnerDTO() {
    }

    public String getTransp() {
        return transp;
    }

    public void setTransp(String transp) {
        this.transp = transp;
    }

    public static Date getCreateDate() {
        return createDate;
    }

    public static void setCreateDate(Date createDate) {
        BusinessPartnerDTO.createDate = createDate;
    }

    public static String getDocumentRut() {
        return documentRut;
    }

    public static void setDocumentRut(String documentRut) {
        BusinessPartnerDTO.documentRut = documentRut;
    }

    public static String getFidelity() {
        return fidelity;
    }

    public static void setFidelity(String fidelity) {
        BusinessPartnerDTO.fidelity = fidelity;
    }

    public static String getAut3() {
        return aut3;
    }

    public static void setAut3(String aut3) {
        BusinessPartnerDTO.aut3 = aut3;
    }

    public static String getAut4() {
        return aut4;
    }

    public static void setAut4(String aut4) {
        BusinessPartnerDTO.aut4 = aut4;
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        BusinessPartnerDTO.subject = subject;
    }

    public static String getDistributo() {
        return distributo;
    }

    public static void setDistributo(String distributo) {
        BusinessPartnerDTO.distributo = distributo;
    }

    public String getPriceList() {
        return priceList;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public Character getCardType() {
        return cardType;
    }

    public void setCardType(Character cardType) {
        this.cardType = cardType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getAcceptHabeasData() {
        return acceptHabeasData;
    }

    public void setAcceptHabeasData(String acceptHabeasData) {
        this.acceptHabeasData = acceptHabeasData;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getNameContactPerson() {
        return nameContactPerson;
    }

    public void setNameContactPerson(String nameContactPerson) {
        this.nameContactPerson = nameContactPerson;
    }

    public String getSecondNamecontactPerson() {
        return secondNamecontactPerson;
    }

    public void setSecondNamecontactPerson(String secondNamecontactPerson) {
        this.secondNamecontactPerson = secondNamecontactPerson;
    }

    public String getLastNameContactPerson() {
        return lastNameContactPerson;
    }

    public void setLastNameContactPerson(String lastNameContactPerson) {
        this.lastNameContactPerson = lastNameContactPerson;
    }

    public String getOccupationContactPerson() {
        return occupationContactPerson;
    }

    public void setOccupationContactPerson(String occupationContactPerson) {
        this.occupationContactPerson = occupationContactPerson;
    }

    public String getPhoneContactPerson() {
        return phoneContactPerson;
    }

    public void setPhoneContactPerson(String phoneContactPerson) {
        this.phoneContactPerson = phoneContactPerson;
    }

    public String getDateContactPerson() {
        return dateContactPerson;
    }

    public void setDateContactPerson(String dateContactPerson) {
        this.dateContactPerson = dateContactPerson;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTaxAddress() {
        return taxAddress;
    }

    public void setTaxAddress(String taxAddress) {
        this.taxAddress = taxAddress;
    }

    public String getLengthMap() {
        return lengthMap;
    }

    public void setLengthMap(String lengthMap) {
        this.lengthMap = lengthMap;
    }

    public String getLatitudeMap() {
        return latitudeMap;
    }

    public void setLatitudeMap(String latitudeMap) {
        this.latitudeMap = latitudeMap;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public String getTaxRegimen() {
        return taxRegimen;
    }

    public void setTaxRegimen(String taxRegimen) {
        this.taxRegimen = taxRegimen;
    }

    public String getCodeCity() {
        return codeCity;
    }

    public void setCodeCity(String codeCity) {
        this.codeCity = codeCity;
    }

    public String getAddressMM() {
        return addressMM;
    }

    public void setAddressMM(String addressMM) {
        this.addressMM = addressMM;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getMailFE() {
        return mailFE;
    }

    public void setMailFE(String mailFE) {
        this.mailFE = mailFE;
    }

    public String getTypeSell() {
        return typeSell;
    }

    public void setTypeSell(String typeSell) {
        this.typeSell = typeSell;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getComiteLimit() {
        return comiteLimit;
    }

    public void setComiteLimit(Double comiteLimit) {
        this.comiteLimit = comiteLimit;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public String getCodeResFis() {
        return codeResFis;
    }

    public void setCodeResFis(String codeResFis) {
        this.codeResFis = codeResFis;
    }

    public String getDescResFis() {
        return descResFis;
    }

    public void setDescResFis(String descResFis) {
        this.descResFis = descResFis;
    }

    public List<WithholdingTax> getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(List<WithholdingTax> withholdingTax) {
        this.withholdingTax = withholdingTax;
    }

    public static class WithholdingTax {
        protected String wtCode;

        public String getWtCode() {
            return wtCode;
        }

        public void setWtCode(String wtCode) {
            this.wtCode = wtCode;
        }
    }

    @Override
    public String toString() {
        return "BusinessPartnerDTO{" +
                "cardType=" + cardType +
                ", typeTransaction='" + typeTransaction + '\'' +
                ", document='" + document + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", licTradNum='" + licTradNum + '\'' +
                ", cellular='" + cellular + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", zona='" + zona + '\'' +
                ", comment='" + comment + '\'' +
                ", grupo='" + grupo + '\'' +
                ", acceptHabeasData='" + acceptHabeasData + '\'' +
                ", companyName='" + companyName + '\'' +
                ", transp='" + transp + '\'' +
                ", priceList='" + priceList + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", nameContactPerson='" + nameContactPerson + '\'' +
                ", secondNamecontactPerson='" + secondNamecontactPerson + '\'' +
                ", lastNameContactPerson='" + lastNameContactPerson + '\'' +
                ", occupationContactPerson='" + occupationContactPerson + '\'' +
                ", phoneContactPerson='" + phoneContactPerson + '\'' +
                ", dateContactPerson='" + dateContactPerson + '\'' +
                ", idAddress='" + idAddress + '\'' +
                ", address='" + address + '\'' +
                ", codDepartamento='" + codDepartamento + '\'' +
                ", codMunicipio='" + codMunicipio + '\'' +
                ", taxAddress='" + taxAddress + '\'' +
                ", lengthMap='" + lengthMap + '\'' +
                ", latitudeMap='" + latitudeMap + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname1='" + lastname1 + '\'' +
                ", lastname2='" + lastname2 + '\'' +
                ", typeDoc='" + typeDoc + '\'' +
                ", typePerson='" + typePerson + '\'' +
                ", taxRegimen='" + taxRegimen + '\'' +
                ", codeCity='" + codeCity + '\'' +
                ", addressMM='" + addressMM + '\'' +
                ", regional='" + regional + '\'' +
                ", mailFE='" + mailFE + '\'' +
                ", typeSell='" + typeSell + '\'' +
                ", paymentCondition='" + paymentCondition + '\'' +
                ", discount=" + discount +
                ", taxType='" + taxType + '\'' +
                ", creditLimit=" + creditLimit +
                ", comiteLimit=" + comiteLimit +
                ", withholdingTax=" + withholdingTax +
                ", codeResFis='" + codeResFis + '\'' +
                ", descResFis='" + descResFis + '\'' +
                '}';
    }
}
package co.manager.hanaws.dto.businessPartner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessPartnersDTO implements Serializable {
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("CardName")
    protected String cardName;
    @JsonProperty("CardType")
    protected String cardType;
    @JsonProperty("FederalTaxID")
    protected String federalTaxID;
    @JsonProperty("Properties13")
    protected String properties13;
    @JsonProperty("GroupCode")
    protected Long groupCode;
    @JsonProperty("Phone1")
    protected String phone1;
    @JsonProperty("Cellular")
    protected String cellular;
    @JsonProperty("EmailAddress")
    protected String emailAddress;
    @JsonProperty("U_Manejo")
    protected String uManejo;
    @JsonProperty("U_FEC_CREA")
    protected String ufeccrea;
    @JsonProperty("U_DocFormEnt")
    protected Long uDocFormEntFE;
    @JsonProperty("U_addInFaElectronica_email_contacto_FE")
    protected String uAddInFaElectronicaEmailContactoFE;
    @JsonProperty("U_Celular")
    protected String uCelularFE;
    @JsonProperty("U_BPCO_RTC")
    protected String ubpcortc;
    @JsonProperty("U_BPCO_TDC")
    protected String ubpcotdc;
    @JsonProperty("U_BPCO_TP")
    protected String ubpcotp;
    @JsonProperty("U_BPCO_CS")
    protected String ubpcocs;
    @JsonProperty("U_BPCO_City")
    protected String ubpcoCity;
    @JsonProperty("U_BPCO_Nombre")
    protected String ubpcoNombre;
    @JsonProperty("U_BPCO_1Apellido")
    protected String ubpco1Apellido;
    @JsonProperty("U_BPCO_2Apellido")
    protected String ubpco2Apellido;
    @JsonProperty("U_BPCO_Address")
    protected String ubpcoAddress;
    @JsonProperty("U_BPV_TPER")
    protected String ubpvtper;
    @JsonProperty("U_TRASP")
    protected String uTrasp;
    @JsonProperty("DebitorAccount")
    protected String debitorAccount;
    @JsonProperty("BPAddresses")
    protected List<BusinessPartnersDTO.BPAddresses.BPAddress> bpAddresses;

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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getFederalTaxID() {
        return federalTaxID;
    }

    public void setFederalTaxID(String federalTaxID) {
        this.federalTaxID = federalTaxID;
    }

    public String getProperties13() {
        return properties13;
    }

    public void setProperties13(String properties13) {
        this.properties13 = properties13;
    }

    public Long getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(Long groupCode) {
        this.groupCode = groupCode;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getuManejo() {
        return uManejo;
    }

    public void setuManejo(String uManejo) {
        this.uManejo = uManejo;
    }

    public String getUfeccrea() {
        return ufeccrea;
    }

    public void setUfeccrea(String ufeccrea) {
        this.ufeccrea = ufeccrea;
    }

    public Long getuDocFormEntFE() {
        return uDocFormEntFE;
    }

    public void setuDocFormEntFE(Long uDocFormEntFE) {
        this.uDocFormEntFE = uDocFormEntFE;
    }

    public String getuAddInFaElectronicaEmailContactoFE() {
        return uAddInFaElectronicaEmailContactoFE;
    }

    public void setuAddInFaElectronicaEmailContactoFE(String uAddInFaElectronicaEmailContactoFE) {
        this.uAddInFaElectronicaEmailContactoFE = uAddInFaElectronicaEmailContactoFE;
    }

    public String getuCelularFE() {
        return uCelularFE;
    }

    public void setuCelularFE(String uCelularFE) {
        this.uCelularFE = uCelularFE;
    }

    public String getUbpcortc() {
        return ubpcortc;
    }

    public void setUbpcortc(String ubpcortc) {
        this.ubpcortc = ubpcortc;
    }

    public String getUbpcotdc() {
        return ubpcotdc;
    }

    public void setUbpcotdc(String ubpcotdc) {
        this.ubpcotdc = ubpcotdc;
    }

    public String getUbpcotp() {
        return ubpcotp;
    }

    public void setUbpcotp(String ubpcotp) {
        this.ubpcotp = ubpcotp;
    }

    public String getUbpcocs() {
        return ubpcocs;
    }

    public void setUbpcocs(String ubpcocs) {
        this.ubpcocs = ubpcocs;
    }

    public String getUbpcoCity() {
        return ubpcoCity;
    }

    public void setUbpcoCity(String ubpcoCity) {
        this.ubpcoCity = ubpcoCity;
    }

    public String getUbpcoNombre() {
        return ubpcoNombre;
    }

    public void setUbpcoNombre(String ubpcoNombre) {
        this.ubpcoNombre = ubpcoNombre;
    }

    public String getUbpco1Apellido() {
        return ubpco1Apellido;
    }

    public void setUbpco1Apellido(String ubpco1Apellido) {
        this.ubpco1Apellido = ubpco1Apellido;
    }

    public String getUbpco2Apellido() {
        return ubpco2Apellido;
    }

    public void setUbpco2Apellido(String ubpco2Apellido) {
        this.ubpco2Apellido = ubpco2Apellido;
    }

    public String getUbpcoAddress() {
        return ubpcoAddress;
    }

    public void setUbpcoAddress(String ubpcoAddress) {
        this.ubpcoAddress = ubpcoAddress;
    }

    public String getUbpvtper() {
        return ubpvtper;
    }

    public void setUbpvtper(String ubpvtper) {
        this.ubpvtper = ubpvtper;
    }

    public String getuTrasp() {
        return uTrasp;
    }

    public void setuTrasp(String uTrasp) {
        this.uTrasp = uTrasp;
    }

    public String getDebitorAccount() {
        return debitorAccount;
    }

    public void setDebitorAccount(String debitorAccount) {
        this.debitorAccount = debitorAccount;
    }

    public List<BusinessPartnersDTO.BPAddresses.BPAddress> getBpAddresses() {
        return bpAddresses;
    }

    public void setBpAddresses(List<BusinessPartnersDTO.BPAddresses.BPAddress> bpAddresses) {
        this.bpAddresses = bpAddresses;
    }

    public static class BPAddresses {
        public static class BPAddress {
            @JsonProperty("AddressName")
            protected String addressName;
            @JsonProperty("Street")
            protected String street;
            @JsonProperty("Block")
            protected String block;
            @JsonProperty("City")
            protected String city;
            @JsonProperty("State")
            protected String state;
            @JsonProperty("Country")
            protected String country;
            @JsonProperty("AddressType")
            protected String addressType;
            @JsonProperty("TaxCode")
            protected String taxCode;
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("RowNum")
            protected Long rowNum;
            @JsonProperty("U_Municipio")
            protected String uMunicipio;

            public String getAddressName() {
                return addressName;
            }

            public void setAddressName(String addressName) {
                this.addressName = addressName;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getBlock() {
                return block;
            }

            public void setBlock(String block) {
                this.block = block;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getAddressType() {
                return addressType;
            }

            public void setAddressType(String addressType) {
                this.addressType = addressType;
            }

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }

            public Long getRowNum() {
                return rowNum;
            }

            public void setRowNum(Long rowNum) {
                this.rowNum = rowNum;
            }

            public String getuMunicipio() {
                return uMunicipio;
            }

            public void setuMunicipio(String uMunicipio) {
                this.uMunicipio = uMunicipio;
            }

            @Override
            public String toString() {
                return "BPAddress{" +
                        "addressName='" + addressName + '\'' +
                        ", street='" + street + '\'' +
                        ", block='" + block + '\'' +
                        ", city='" + city + '\'' +
                        ", state='" + state + '\'' +
                        ", country='" + country + '\'' +
                        ", addressType='" + addressType + '\'' +
                        ", taxCode='" + taxCode + '\'' +
                        ", bpCode='" + bpCode + '\'' +
                        ", rowNum=" + rowNum +
                        ", uMunicipio='" + uMunicipio + '\'' +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "BusinessPartnersDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardType='" + cardType + '\'' +
                ", federalTaxID='" + federalTaxID + '\'' +
                ", properties13='" + properties13 + '\'' +
                ", groupCode=" + groupCode +
                ", phone1='" + phone1 + '\'' +
                ", cellular='" + cellular + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", uManejo='" + uManejo + '\'' +
                ", ufeccrea='" + ufeccrea + '\'' +
                ", uDocFormEntFE=" + uDocFormEntFE +
                ", uAddInFaElectronicaEmailContactoFE='" + uAddInFaElectronicaEmailContactoFE + '\'' +
                ", uCelularFE='" + uCelularFE + '\'' +
                ", ubpcortc='" + ubpcortc + '\'' +
                ", ubpcotdc='" + ubpcotdc + '\'' +
                ", ubpcotp='" + ubpcotp + '\'' +
                ", ubpcocs='" + ubpcocs + '\'' +
                ", ubpcoCity='" + ubpcoCity + '\'' +
                ", ubpcoNombre='" + ubpcoNombre + '\'' +
                ", ubpco1Apellido='" + ubpco1Apellido + '\'' +
                ", ubpco2Apellido='" + ubpco2Apellido + '\'' +
                ", ubpcoAddress='" + ubpcoAddress + '\'' +
                ", ubpvtper='" + ubpvtper + '\'' +
                ", uTrasp='" + uTrasp + '\'' +
                ", debitorAccount='" + debitorAccount + '\'' +
                ", bpAddresses=" + bpAddresses +
                '}';
    }
}
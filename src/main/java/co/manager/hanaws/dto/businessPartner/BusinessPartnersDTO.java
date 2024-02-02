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
    @JsonProperty("Properties4")
    protected String properties4;
    @JsonProperty("Properties13")
    protected String properties13;
    @JsonProperty("Properties15")
    protected String properties15;
    @JsonProperty("GroupCode")
    protected Long groupCode;
    @JsonProperty("Phone1")
    protected String phone1;
    @JsonProperty("Phone2")
    protected String phone2;
    @JsonProperty("Cellular")
    protected String cellular;
    @JsonProperty("EmailAddress")
    protected String emailAddress;
    @JsonProperty("U_Manejo")
    protected String umanejo;
    @JsonProperty("U_FEC_CREA")
    protected String ufeccrea;
    @JsonProperty("U_DocFormEnt")
    protected Long udocFormEntFE;
    @JsonProperty("U_addInFaElectronica_email_contacto_FE")
    protected String uaddInFaElectronicaEmailContactoFE;
    @JsonProperty("U_Celular")
    protected String ucelularFE;
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
    protected String utrasp;
    @JsonProperty("DebitorAccount")
    protected String debitorAccount;
    @JsonProperty("SalesPersonCode")
    protected String salesPersonCode;
    @JsonProperty("Block")
    protected String block;
    @JsonProperty("BilltoDefault")
    protected String billtoDefault;
    @JsonProperty("Territory")
    protected Long territory;
    @JsonProperty("ContactPerson")
    protected String contactPerson;
    @JsonProperty("U_REGIONAL")
    protected String uregional;
    @JsonProperty("PayTermsGrpCode")
    protected Long payTermsGrpCode;
    @JsonProperty("DiscountPercent")
    protected Double discountPercent;
    @JsonProperty("VatLiable")
    protected String vatLiable;
    @JsonProperty("CreditLimit")
    protected Double creditLimit;
    @JsonProperty("MaxCommitment")
    protected Double maxCommitment;
    @JsonProperty("SubjectToWithholdingTax")
    protected String subjectToWithholdingTax;
    @JsonProperty("U_PRO_FIDELIZACION")
    protected String uproFidelizacion;
    @JsonProperty("PriceListNum")
    protected Long priceListNum;
    @JsonProperty("FreeText")
    protected String freeText;
    @JsonProperty("BPAddresses")
    protected List<BusinessPartnersDTO.BPAddresses.BPAddress> bpAddresses;
    @JsonProperty("ContactEmployees")
    protected List<BusinessPartnersDTO.ContactEmployees.ContactEmployee> contactEmployees;

    public BusinessPartnersDTO() {
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

    public String getProperties4() {
        return properties4;
    }

    public void setProperties4(String properties4) {
        this.properties4 = properties4;
    }

    public String getProperties13() {
        return properties13;
    }

    public void setProperties13(String properties13) {
        this.properties13 = properties13;
    }

    public String getProperties15() {
        return properties15;
    }

    public void setProperties15(String properties15) {
        this.properties15 = properties15;
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

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
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

    public String getUmanejo() {
        return umanejo;
    }

    public void setUmanejo(String umanejo) {
        this.umanejo = umanejo;
    }

    public String getUfeccrea() {
        return ufeccrea;
    }

    public void setUfeccrea(String ufeccrea) {
        this.ufeccrea = ufeccrea;
    }

    public Long getUdocFormEntFE() {
        return udocFormEntFE;
    }

    public void setUdocFormEntFE(Long udocFormEntFE) {
        this.udocFormEntFE = udocFormEntFE;
    }

    public String getUaddInFaElectronicaEmailContactoFE() {
        return uaddInFaElectronicaEmailContactoFE;
    }

    public void setUaddInFaElectronicaEmailContactoFE(String uaddInFaElectronicaEmailContactoFE) {
        this.uaddInFaElectronicaEmailContactoFE = uaddInFaElectronicaEmailContactoFE;
    }

    public String getUcelularFE() {
        return ucelularFE;
    }

    public void setUcelularFE(String ucelularFE) {
        this.ucelularFE = ucelularFE;
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

    public String getUtrasp() {
        return utrasp;
    }

    public void setUtrasp(String utrasp) {
        this.utrasp = utrasp;
    }

    public String getDebitorAccount() {
        return debitorAccount;
    }

    public void setDebitorAccount(String debitorAccount) {
        this.debitorAccount = debitorAccount;
    }

    public String getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(String salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBilltoDefault() {
        return billtoDefault;
    }

    public void setBilltoDefault(String billtoDefault) {
        this.billtoDefault = billtoDefault;
    }

    public Long getTerritory() {
        return territory;
    }

    public void setTerritory(Long territory) {
        this.territory = territory;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getUregional() {
        return uregional;
    }

    public void setUregional(String uregional) {
        this.uregional = uregional;
    }

    public Long getPayTermsGrpCode() {
        return payTermsGrpCode;
    }

    public void setPayTermsGrpCode(Long payTermsGrpCode) {
        this.payTermsGrpCode = payTermsGrpCode;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getVatLiable() {
        return vatLiable;
    }

    public void setVatLiable(String vatLiable) {
        this.vatLiable = vatLiable;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getMaxCommitment() {
        return maxCommitment;
    }

    public void setMaxCommitment(Double maxCommitment) {
        this.maxCommitment = maxCommitment;
    }

    public String getSubjectToWithholdingTax() {
        return subjectToWithholdingTax;
    }

    public void setSubjectToWithholdingTax(String subjectToWithholdingTax) {
        this.subjectToWithholdingTax = subjectToWithholdingTax;
    }

    public String getUproFidelizacion() {
        return uproFidelizacion;
    }

    public void setUproFidelizacion(String uproFidelizacion) {
        this.uproFidelizacion = uproFidelizacion;
    }

    public Long getPriceListNum() {
        return priceListNum;
    }

    public void setPriceListNum(Long priceListNum) {
        this.priceListNum = priceListNum;
    }

    public List<BPAddresses.BPAddress> getBpAddresses() {
        return bpAddresses;
    }

    public void setBpAddresses(List<BPAddresses.BPAddress> bpAddresses) {
        this.bpAddresses = bpAddresses;
    }

    public List<ContactEmployees.ContactEmployee> getContactEmployees() {
        return contactEmployees;
    }

    public void setContactEmployees(List<ContactEmployees.ContactEmployee> contactEmployees) {
        this.contactEmployees = contactEmployees;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
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
            protected String umunicipio;
            @JsonProperty("U_LATITUD")
            protected String ulatitud;
            @JsonProperty("U_LONGITUD")
            protected String ulongitud;

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

            public String getUmunicipio() {
                return umunicipio;
            }

            public void setUmunicipio(String umunicipio) {
                this.umunicipio = umunicipio;
            }

            public String getUlatitud() {
                return ulatitud;
            }

            public void setUlatitud(String ulatitud) {
                this.ulatitud = ulatitud;
            }

            public String getUlongitud() {
                return ulongitud;
            }

            public void setUlongitud(String ulongitud) {
                this.ulongitud = ulongitud;
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
                        ", umunicipio='" + umunicipio + '\'' +
                        ", ulatitud='" + ulatitud + '\'' +
                        ", ulongitud='" + ulongitud + '\'' +
                        '}';
            }
        }
    }

    public static class ContactEmployees {
        public static class ContactEmployee {
            @JsonProperty("CardCode")
            protected String cardCode;
            @JsonProperty("Name")
            protected String name;
            @JsonProperty("Position")
            protected String position;
            @JsonProperty("Address")
            protected String address;
            @JsonProperty("Phone1")
            protected String phone1;
            @JsonProperty("Phone2")
            protected String phone2;
            @JsonProperty("MobilePhone")
            protected String mobilePhone;
            @JsonProperty("Fax")
            protected String fax;
            @JsonProperty("E_Mail")
            protected String email;
            @JsonProperty("Pager")
            protected String pager;
            @JsonProperty("Remarks1")
            protected String remarks1;
            @JsonProperty("Remarks2")
            protected String remarks2;
            @JsonProperty("Password")
            protected String password;
            @JsonProperty("InternalCode")
            protected Long internalCode;
            @JsonProperty("PlaceOfBirth")
            protected String placeOfBirth;
            @JsonProperty("DateOfBirth")
            protected String dateOfBirth;
            @JsonProperty("Gender")
            protected String gender;
            @JsonProperty("Profession")
            protected String profession;
            @JsonProperty("Title")
            protected String title;
            @JsonProperty("CityOfBirth")
            protected String cityOfBirth;
            @JsonProperty("Active")
            protected String active;
            @JsonProperty("FirstName")
            protected String firstName;
            @JsonProperty("MiddleName")
            protected String middleName;
            @JsonProperty("LastName")
            protected String lastName;
            @JsonProperty("EmailGroupCode")
            protected String emailGroupCode;

            public String getCardCode() {
                return cardCode;
            }

            public void setCardCode(String cardCode) {
                this.cardCode = cardCode;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getPhone1() {
                return phone1;
            }

            public void setPhone1(String phone1) {
                this.phone1 = phone1;
            }

            public String getPhone2() {
                return phone2;
            }

            public void setPhone2(String phone2) {
                this.phone2 = phone2;
            }

            public String getMobilePhone() {
                return mobilePhone;
            }

            public void setMobilePhone(String mobilePhone) {
                this.mobilePhone = mobilePhone;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getPager() {
                return pager;
            }

            public void setPager(String pager) {
                this.pager = pager;
            }

            public String getRemarks1() {
                return remarks1;
            }

            public void setRemarks1(String remarks1) {
                this.remarks1 = remarks1;
            }

            public String getRemarks2() {
                return remarks2;
            }

            public void setRemarks2(String remarks2) {
                this.remarks2 = remarks2;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Long getInternalCode() {
                return internalCode;
            }

            public void setInternalCode(Long internalCode) {
                this.internalCode = internalCode;
            }

            public String getPlaceOfBirth() {
                return placeOfBirth;
            }

            public void setPlaceOfBirth(String placeOfBirth) {
                this.placeOfBirth = placeOfBirth;
            }

            public String getDateOfBirth() {
                return dateOfBirth;
            }

            public void setDateOfBirth(String dateOfBirth) {
                this.dateOfBirth = dateOfBirth;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getProfession() {
                return profession;
            }

            public void setProfession(String profession) {
                this.profession = profession;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCityOfBirth() {
                return cityOfBirth;
            }

            public void setCityOfBirth(String cityOfBirth) {
                this.cityOfBirth = cityOfBirth;
            }

            public String getActive() {
                return active;
            }

            public void setActive(String active) {
                this.active = active;
            }

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getMiddleName() {
                return middleName;
            }

            public void setMiddleName(String middleName) {
                this.middleName = middleName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }

            public String getEmailGroupCode() {
                return emailGroupCode;
            }

            public void setEmailGroupCode(String emailGroupCode) {
                this.emailGroupCode = emailGroupCode;
            }
        }
    }
}
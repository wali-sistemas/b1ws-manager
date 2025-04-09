package co.manager.hanaws.dto.businessPartner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BusinessPartnersRestDTO implements Serializable {
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("CardName")
    protected String cardName;
    @JsonProperty("CardType")
    protected String cardType;
    @JsonProperty("GroupCode")
    protected Long groupCode;
    @JsonProperty("Address")
    protected String address;
    @JsonProperty("ZipCode")
    protected String zipCode;
    @JsonProperty("MailAddress")
    protected String mailAddress;
    @JsonProperty("MailZipCode")
    protected String mailZipCode;
    @JsonProperty("Phone1")
    protected String phone1;
    @JsonProperty("Phone2")
    protected String phone2;
    @JsonProperty("Fax")
    protected String fax;
    @JsonProperty("ContactPerson")
    protected String contactPerson;
    @JsonProperty("Notes")
    protected String notes;
    @JsonProperty("PayTermsGrpCode")
    protected Long payTermsGrpCode;
    @JsonProperty("CreditLimit")
    protected Double creditLimit;
    @JsonProperty("MaxCommitment")
    protected Double maxCommitment;
    @JsonProperty("DiscountPercent")
    protected Double discountPercent;
    @JsonProperty("VatLiable")
    protected String vatLiable;
    @JsonProperty("FederalTaxID")
    protected String federalTaxID;
    @JsonProperty("DeductibleAtSource")
    protected String deductibleAtSource;
    @JsonProperty("DeductionPercent")
    protected Double deductionPercent;
    @JsonProperty("DeductionValidUntil")
    protected String deductionValidUntil;
    @JsonProperty("PriceListNum")
    protected Long priceListNum;
    @JsonProperty("IntrestRatePercent")
    protected Double intrestRatePercent;
    @JsonProperty("CommissionPercent")
    protected Double commissionPercent;
    @JsonProperty("CommissionGroupCode")
    protected Long commissionGroupCode;
    @JsonProperty("FreeText")
    protected String freeText;
    @JsonProperty("SalesPersonCode")
    protected Long salesPersonCode;
    @JsonProperty("Currency")
    protected String currency;
    @JsonProperty("RateDiffAccount")
    protected String rateDiffAccount;
    @JsonProperty("Cellular")
    protected String cellular;
    @JsonProperty("AvarageLate")
    protected Long avarageLate;
    @JsonProperty("City")
    protected String city;
    @JsonProperty("County")
    protected String county;
    @JsonProperty("Country")
    protected String country;
    @JsonProperty("MailCity")
    protected String mailCity;
    @JsonProperty("MailCounty")
    protected String mailCounty;
    @JsonProperty("MailCountry")
    protected String mailCountry;
    @JsonProperty("EmailAddress")
    protected String emailAddress;
    @JsonProperty("Picture")
    protected String picture;
    @JsonProperty("DefaultAccount")
    protected String defaultAccount;
    @JsonProperty("DefaultBranch")
    protected String defaultBranch;
    @JsonProperty("DefaultBankCode")
    protected String defaultBankCode;
    @JsonProperty("AdditionalID")
    protected String additionalID;
    @JsonProperty("Pager")
    protected String pager;
    @JsonProperty("FatherCard")
    protected String fatherCard;
    @JsonProperty("CardForeignName")
    protected String cardForeignName;
    @JsonProperty("FatherType")
    protected String fatherType;
    @JsonProperty("DeductionOffice")
    protected String deductionOffice;
    @JsonProperty("ExportCode")
    protected String exportCode;
    @JsonProperty("MinIntrest")
    protected Double minIntrest;
    @JsonProperty("CurrentAccountBalance")
    protected Double currentAccountBalance;
    @JsonProperty("OpenDeliveryNotesBalance")
    protected Double openDeliveryNotesBalance;
    @JsonProperty("OpenOrdersBalance")
    protected Double openOrdersBalance;
    @JsonProperty("VatGroup")
    protected String vatGroup;
    @JsonProperty("ShippingType")
    protected Long shippingType;
    @JsonProperty("Password")
    protected String password;
    @JsonProperty("Indicator")
    protected String indicator;
    @JsonProperty("IBAN")
    protected String iban;
    @JsonProperty("CreditCardCode")
    protected Long creditCardCode;
    @JsonProperty("CreditCardNum")
    protected String creditCardNum;
    @JsonProperty("CreditCardExpiration")
    protected String creditCardExpiration;
    @JsonProperty("DebitorAccount")
    protected String debitorAccount;
    @JsonProperty("OpenOpportunities")
    protected Long openOpportunities;
    @JsonProperty("Valid")
    protected String valid;
    @JsonProperty("ValidFrom")
    protected String validFrom;
    @JsonProperty("ValidTo")
    protected String validTo;
    @JsonProperty("ValidRemarks")
    protected String validRemarks;
    @JsonProperty("Frozen")
    protected String frozen;
    @JsonProperty("FrozenFrom")
    protected String frozenFrom;
    @JsonProperty("FrozenTo")
    protected String frozenTo;
    @JsonProperty("FrozenRemarks")
    protected String frozenRemarks;
    @JsonProperty("Block")
    protected String block;
    @JsonProperty("BillToState")
    protected String billToState;
    @JsonProperty("ShipToState")
    protected String shipToState;
    @JsonProperty("ExemptNum")
    protected String exemptNum;
    @JsonProperty("Priority")
    protected Long priority;
    @JsonProperty("FormCode1099")
    protected Long formCode1099;
    @JsonProperty("Box1099")
    protected String box1099;
    @JsonProperty("PeymentMethodCode")
    protected String peymentMethodCode;
    @JsonProperty("BackOrder")
    protected String backOrder;
    @JsonProperty("PartialDelivery")
    protected String partialDelivery;
    @JsonProperty("BlockDunning")
    protected String blockDunning;
    @JsonProperty("BankCountry")
    protected String bankCountry;
    @JsonProperty("HouseBank")
    protected String houseBank;
    @JsonProperty("HouseBankCountry")
    protected String houseBankCountry;
    @JsonProperty("HouseBankAccount")
    protected String houseBankAccount;
    @JsonProperty("ShipToDefault")
    protected String shipToDefault;
    @JsonProperty("DunningLevel")
    protected Long dunningLevel;
    @JsonProperty("DunningDate")
    protected String dunningDate;
    @JsonProperty("CollectionAuthorization")
    protected String collectionAuthorization;
    @JsonProperty("DME")
    protected String dme;
    @JsonProperty("InstructionKey")
    protected String instructionKey;
    @JsonProperty("SinglePayment")
    protected String singlePayment;
    @JsonProperty("ISRBillerID")
    protected String isrBillerID;
    @JsonProperty("PaymentBlock")
    protected String paymentBlock;
    @JsonProperty("ReferenceDetails")
    protected String referenceDetails;
    @JsonProperty("HouseBankBranch")
    protected String houseBankBranch;
    @JsonProperty("OwnerIDNumber")
    protected String ownerIDNumber;
    @JsonProperty("PaymentBlockDescription")
    protected Long paymentBlockDescription;
    @JsonProperty("TaxExemptionLetterNum")
    protected String taxExemptionLetterNum;
    @JsonProperty("MaxAmountOfExemption")
    protected Double maxAmountOfExemption;
    @JsonProperty("ExemptionValidityDateFrom")
    protected String exemptionValidityDateFrom;
    @JsonProperty("ExemptionValidityDateTo")
    protected String exemptionValidityDateTo;
    @JsonProperty("LinkedBusinessPartner")
    protected String linkedBusinessPartner;
    @JsonProperty("LastMultiReconciliationNum")
    protected Long lastMultiReconciliationNum;
    @JsonProperty("DeferredTax")
    protected String deferredTax;
    @JsonProperty("Equalization")
    protected String equalization;
    @JsonProperty("SubjectToWithholdingTax")
    protected String subjectToWithholdingTax;
    @JsonProperty("CertificateNumber")
    protected String certificateNumber;
    @JsonProperty("ExpirationDate")
    protected String expirationDate;
    @JsonProperty("NationalInsuranceNum")
    protected String nationalInsuranceNum;
    @JsonProperty("AccrualCriteria")
    protected String accrualCriteria;
    @JsonProperty("WTCode")
    protected String wtCode;
    @JsonProperty("BillToBuildingFloorRoom")
    protected String billToBuildingFloorRoom;
    @JsonProperty("DownPaymentClearAct")
    protected String downPaymentClearAct;
    @JsonProperty("ChannelBP")
    protected String channelBP;
    @JsonProperty("DefaultTechnician")
    protected Long defaultTechnician;
    @JsonProperty("BilltoDefault")
    protected String billtoDefault;
    @JsonProperty("CustomerBillofExchangDisc")
    protected String customerBillofExchangDisc;
    @JsonProperty("Territory")
    protected Long territory;
    @JsonProperty("ShipToBuildingFloorRoom")
    protected String shipToBuildingFloorRoom;
    @JsonProperty("CustomerBillofExchangPres")
    protected String customerBillofExchangPres;
    @JsonProperty("ProjectCode")
    protected String projectCode;
    @JsonProperty("VatGroupLatinAmerica")
    protected String vatGroupLatinAmerica;
    @JsonProperty("DunningTerm")
    protected String dunningTerm;
    @JsonProperty("Website")
    protected String website;
    @JsonProperty("OtherReceivablePayable")
    protected String otherReceivablePayable;
    @JsonProperty("BillofExchangeonCollection")
    protected String billofExchangeonCollection;
    @JsonProperty("CompanyPrivate")
    protected String companyPrivate;
    @JsonProperty("LanguageCode")
    protected Long languageCode;
    @JsonProperty("UnpaidBillofExchange")
    protected String unpaidBillofExchange;
    @JsonProperty("WithholdingTaxDeductionGroup")
    protected Long withholdingTaxDeductionGroup;
    @JsonProperty("ClosingDateProcedureNumber")
    protected Long closingDateProcedureNumber;
    @JsonProperty("Profession")
    protected String profession;
    @JsonProperty("BankChargesAllocationCode")
    protected String bankChargesAllocationCode;
    @JsonProperty("TaxRoundingRule")
    protected String taxRoundingRule;
    @JsonProperty("Properties1")
    protected String properties1;
    @JsonProperty("Properties2")
    protected String properties2;
    @JsonProperty("Properties3")
    protected String properties3;
    @JsonProperty("Properties4")
    protected String properties4;
    @JsonProperty("Properties5")
    protected String properties5;
    @JsonProperty("Properties6")
    protected String properties6;
    @JsonProperty("Properties7")
    protected String properties7;
    @JsonProperty("Properties8")
    protected String properties8;
    @JsonProperty("Properties9")
    protected String properties9;
    @JsonProperty("Properties10")
    protected String properties10;
    @JsonProperty("Properties11")
    protected String properties11;
    @JsonProperty("Properties12")
    protected String properties12;
    @JsonProperty("Properties13")
    protected String properties13;
    @JsonProperty("Properties14")
    protected String properties14;
    @JsonProperty("Properties15")
    protected String properties15;
    @JsonProperty("Properties16")
    protected String properties16;
    @JsonProperty("Properties17")
    protected String properties17;
    @JsonProperty("Properties18")
    protected String properties18;
    @JsonProperty("Properties19")
    protected String properties19;
    @JsonProperty("Properties20")
    protected String properties20;
    @JsonProperty("Properties21")
    protected String properties21;
    @JsonProperty("Properties22")
    protected String properties22;
    @JsonProperty("Properties23")
    protected String properties23;
    @JsonProperty("Properties24")
    protected String properties24;
    @JsonProperty("Properties25")
    protected String properties25;
    @JsonProperty("Properties26")
    protected String properties26;
    @JsonProperty("Properties27")
    protected String properties27;
    @JsonProperty("Properties28")
    protected String properties28;
    @JsonProperty("Properties29")
    protected String properties29;
    @JsonProperty("Properties30")
    protected String properties30;
    @JsonProperty("Properties31")
    protected String properties31;
    @JsonProperty("Properties32")
    protected String properties32;
    @JsonProperty("Properties33")
    protected String properties33;
    @JsonProperty("Properties34")
    protected String properties34;
    @JsonProperty("Properties35")
    protected String properties35;
    @JsonProperty("Properties36")
    protected String properties36;
    @JsonProperty("Properties37")
    protected String properties37;
    @JsonProperty("Properties38")
    protected String properties38;
    @JsonProperty("Properties39")
    protected String properties39;
    @JsonProperty("Properties40")
    protected String properties40;
    @JsonProperty("Properties41")
    protected String properties41;
    @JsonProperty("Properties42")
    protected String properties42;
    @JsonProperty("Properties43")
    protected String properties43;
    @JsonProperty("Properties44")
    protected String properties44;
    @JsonProperty("Properties45")
    protected String properties45;
    @JsonProperty("Properties46")
    protected String properties46;
    @JsonProperty("Properties47")
    protected String properties47;
    @JsonProperty("Properties48")
    protected String properties48;
    @JsonProperty("Properties49")
    protected String properties49;
    @JsonProperty("Properties50")
    protected String properties50;
    @JsonProperty("Properties51")
    protected String properties51;
    @JsonProperty("Properties52")
    protected String properties52;
    @JsonProperty("Properties53")
    protected String properties53;
    @JsonProperty("Properties54")
    protected String properties54;
    @JsonProperty("Properties55")
    protected String properties55;
    @JsonProperty("Properties56")
    protected String properties56;
    @JsonProperty("Properties57")
    protected String properties57;
    @JsonProperty("Properties58")
    protected String properties58;
    @JsonProperty("Properties59")
    protected String properties59;
    @JsonProperty("Properties60")
    protected String properties60;
    @JsonProperty("Properties61")
    protected String properties61;
    @JsonProperty("Properties62")
    protected String properties62;
    @JsonProperty("Properties63")
    protected String properties63;
    @JsonProperty("Properties64")
    protected String properties64;
    @JsonProperty("CompanyRegistrationNumber")
    protected String companyRegistrationNumber;
    @JsonProperty("VerificationNumber")
    protected String verificationNumber;
    @JsonProperty("DiscountBaseObject")
    protected String discountBaseObject;
    @JsonProperty("DiscountRelations")
    protected String discountRelations;
    @JsonProperty("TypeReport")
    protected String typeReport;
    @JsonProperty("ThresholdOverlook")
    protected String thresholdOverlook;
    @JsonProperty("SurchargeOverlook")
    protected String surchargeOverlook;
    @JsonProperty("DownPaymentInterimAccount")
    protected String downPaymentInterimAccount;
    @JsonProperty("OperationCode347")
    protected String operationCode347;
    @JsonProperty("InsuranceOperation347")
    protected String insuranceOperation347;
    @JsonProperty("HierarchicalDeduction")
    protected String hierarchicalDeduction;
    @JsonProperty("ShaamGroup")
    protected String shaamGroup;
    @JsonProperty("WithholdingTaxCertified")
    protected String withholdingTaxCertified;
    @JsonProperty("BookkeepingCertified")
    protected String bookkeepingCertified;
    @JsonProperty("PlanningGroup")
    protected String planningGroup;
    @JsonProperty("Affiliate")
    protected String affiliate;
    @JsonProperty("Industry")
    protected Long industry;
    @JsonProperty("VatIDNum")
    protected String vatIDNum;
    @JsonProperty("DatevAccount")
    protected Long datevAccount;
    @JsonProperty("DatevFirstDataEntry")
    protected String datevFirstDataEntry;
    @JsonProperty("GTSRegNo")
    protected String gtsRegNo;
    @JsonProperty("GTSBankAccountNo")
    protected String gtsBankAccountNo;
    @JsonProperty("GTSBillingAddrTel")
    protected String gtsBillingAddrTel;
    @JsonProperty("ETaxWebSite")
    protected Long etaxWebSite;
    @JsonProperty("HouseBankIBAN")
    protected String houseBankIBAN;
    @JsonProperty("VATRegistrationNumber")
    protected String vatRegistrationNumber;
    @JsonProperty("RepresentativeName")
    protected String representativeName;
    @JsonProperty("IndustryType")
    protected String industryType;
    @JsonProperty("BusinessType")
    protected String businessType;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("AutomaticPosting")
    protected String automaticPosting;
    @JsonProperty("InterestAccount")
    protected String interestAccount;
    @JsonProperty("FeeAccount")
    protected String feeAccount;
    @JsonProperty("CampaignNumber")
    protected Long campaignNumber;
    @JsonProperty("AliasName")
    protected String aliasName;
    @JsonProperty("DefaultBlanketAgreementNumber")
    protected Long defaultBlanketAgreementNumber;
    @JsonProperty("EffectiveDiscount")
    protected String effectiveDiscount;
    @JsonProperty("NoDiscounts")
    protected String noDiscounts;
    @JsonProperty("GlobalLocationNumber")
    protected String globalLocationNumber;
    @JsonProperty("EDISenderID")
    protected String ediSenderID;
    @JsonProperty("EDIRecipientID")
    protected String ediRecipientID;
    @JsonProperty("ResidenNumber")
    protected String residenNumber;
    @JsonProperty("RelationshipCode")
    protected String relationshipCode;
    @JsonProperty("RelationshipDateFrom")
    protected String relationshipDateFrom;
    @JsonProperty("RelationshipDateTill")
    protected String relationshipDateTill;
    @JsonProperty("UnifiedFederalTaxID")
    protected String unifiedFederalTaxID;
    @JsonProperty("AttachmentEntry")
    protected Long attachmentEntry;
    @JsonProperty("TypeOfOperation")
    protected String typeOfOperation;
    @JsonProperty("U_BD_Erst")
    protected String ubdErst;
    @JsonProperty("U_BD_Datev")
    protected String ubdDatev;
    @JsonProperty("U_BPCO_RTC")
    protected String ubpcortc;
    @JsonProperty("U_BPCO_TDC")
    protected String ubpcotdc;
    @JsonProperty("U_BPCO_CS")
    protected String ubpcocs;
    @JsonProperty("U_BPCO_City")
    protected String ubpcoCity;
    @JsonProperty("U_BPCO_TP")
    protected String ubpcotp;
    @JsonProperty("U_BPCO_Nombre")
    protected String ubpcoNombre;
    @JsonProperty("U_BPCO_1Apellido")
    protected String ubpco1Apellido;
    @JsonProperty("U_BPCO_2Apellido")
    protected String ubpco2Apellido;
    @JsonProperty("U_BPCO_BPExt")
    protected String ubpcobpExt;
    @JsonProperty("U_BPCO_TBPE")
    protected String ubpcotbpe;
    @JsonProperty("U_BPCO_Address")
    protected String ubpcoAddress;
    @JsonProperty("U_Manejo")
    protected String umanejo;
    @JsonProperty("U_FEC_CREA")
    protected String ufeccrea;
    @JsonProperty("U_TRASP")
    protected String utrasp;
    @JsonProperty("U_Tipo_Negocio")
    protected String utipoNegocio;
    @JsonProperty("U_TIEMPO_TRA")
    protected Long utiempotra;
    @JsonProperty("U_PROM_DIAS_PAGO")
    protected Double upromdiaspago;
    @JsonProperty("U_VLGX_VIV")
    protected String uvlgxviv;
    @JsonProperty("U_VLGX_LT")
    protected Long uvlgxlt;
    @JsonProperty("U_VLGX_OF")
    protected Long uvlgxof;
    @JsonProperty("U_VLGX_PLC")
    protected String uvlgxplc;
    @JsonProperty("U_VLGX_VFQ")
    protected Long uvlgxvfq;
    @JsonProperty("U_VLGX_VFW")
    protected Long uvlgxvfw;
    @JsonProperty("U_VLGX_VFM")
    protected Long uvlgxvfm;
    @JsonProperty("U_VLGX_VFV")
    protected Long uvlgxvfv;
    @JsonProperty("U_EsAutorret")
    protected String uesAutorret;
    @JsonProperty("U_OK1_AC_ECO")
    protected String uok1ACECO;
    @JsonProperty("U_DocFormEnt")
    protected Long udocFormEntFE;
    @JsonProperty("U_addInFaElectronica_email_contacto_FE")
    protected String uaddInFaElectronicaEmailContactoFE;
    @JsonProperty("U_Celular")
    protected String ucelularFE;
    @JsonProperty("U_REGIONAL")
    protected String uregional;
    @JsonProperty("U_PRO_FIDELIZACION")
    protected String uproFidelizacion;
    @JsonProperty("BlockSendingMarketingContent")
    protected String blockSendingMarketingContent;
    @JsonProperty("BPAddresses")
    protected List<BusinessPartnersRestDTO.BPAddresses.BPAddress> bpAddresses;
    @JsonProperty("ContactEmployees")
    protected List<BusinessPartnersRestDTO.ContactEmployees.ContactEmployee> contactEmployees;
    @JsonProperty("BPAccountReceivablePaybleCollection")
    protected List<BusinessPartnersRestDTO.BPAccountReceivablePaybleCollection.BPAccountReceivablePayble> bpAccountReceivablePaybleCollection;
    @JsonProperty("BPPaymentMethods")
    protected List<BusinessPartnersRestDTO.BPPaymentMethods.BPPaymentMethod> bpPaymentMethods;
    @JsonProperty("BPWithholdingTaxCollection")
    protected List<BusinessPartnersRestDTO.BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTaxCollection;
    @JsonProperty("BPPaymentDates")
    protected List<BusinessPartnersRestDTO.BPPaymentDates.BPPaymentDate> bpPaymentDates;
    @JsonProperty("BPBranchAssignment")
    protected List<BusinessPartnersRestDTO.BPBranchAssignment.BPBranchAssignmentItem> bpBranchAssignment;
    @JsonProperty("BPBankAccounts")
    protected List<BusinessPartnersRestDTO.BPBankAccounts.BPBankAccount> bpBankAccounts;
    @JsonProperty("BPFiscalTaxIDCollection")
    protected List<BusinessPartnersRestDTO.BPFiscalTaxIDCollection.BPFiscalTaxID> bpFiscalTaxIDCollection;
    @JsonProperty("DiscountGroups")
    protected List<BusinessPartnersRestDTO.DiscountGroups.DiscountGroup> discountGroups;
    @JsonProperty("BPIntrastatExtension")
    protected BusinessPartnersRestDTO.BPIntrastatExtension bpIntrastatExtension;

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

    public Long getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(Long groupCode) {
        this.groupCode = groupCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getMailZipCode() {
        return mailZipCode;
    }

    public void setMailZipCode(String mailZipCode) {
        this.mailZipCode = mailZipCode;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPayTermsGrpCode() {
        return payTermsGrpCode;
    }

    public void setPayTermsGrpCode(Long payTermsGrpCode) {
        this.payTermsGrpCode = payTermsGrpCode;
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

    public String getFederalTaxID() {
        return federalTaxID;
    }

    public void setFederalTaxID(String federalTaxID) {
        this.federalTaxID = federalTaxID;
    }

    public String getDeductibleAtSource() {
        return deductibleAtSource;
    }

    public void setDeductibleAtSource(String deductibleAtSource) {
        this.deductibleAtSource = deductibleAtSource;
    }

    public Double getDeductionPercent() {
        return deductionPercent;
    }

    public void setDeductionPercent(Double deductionPercent) {
        this.deductionPercent = deductionPercent;
    }

    public String getDeductionValidUntil() {
        return deductionValidUntil;
    }

    public void setDeductionValidUntil(String deductionValidUntil) {
        this.deductionValidUntil = deductionValidUntil;
    }

    public Long getPriceListNum() {
        return priceListNum;
    }

    public void setPriceListNum(Long priceListNum) {
        this.priceListNum = priceListNum;
    }

    public Double getIntrestRatePercent() {
        return intrestRatePercent;
    }

    public void setIntrestRatePercent(Double intrestRatePercent) {
        this.intrestRatePercent = intrestRatePercent;
    }

    public Double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public Long getCommissionGroupCode() {
        return commissionGroupCode;
    }

    public void setCommissionGroupCode(Long commissionGroupCode) {
        this.commissionGroupCode = commissionGroupCode;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public Long getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(Long salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRateDiffAccount() {
        return rateDiffAccount;
    }

    public void setRateDiffAccount(String rateDiffAccount) {
        this.rateDiffAccount = rateDiffAccount;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public Long getAvarageLate() {
        return avarageLate;
    }

    public void setAvarageLate(Long avarageLate) {
        this.avarageLate = avarageLate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMailCity() {
        return mailCity;
    }

    public void setMailCity(String mailCity) {
        this.mailCity = mailCity;
    }

    public String getMailCounty() {
        return mailCounty;
    }

    public void setMailCounty(String mailCounty) {
        this.mailCounty = mailCounty;
    }

    public String getMailCountry() {
        return mailCountry;
    }

    public void setMailCountry(String mailCountry) {
        this.mailCountry = mailCountry;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(String defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public String getDefaultBankCode() {
        return defaultBankCode;
    }

    public void setDefaultBankCode(String defaultBankCode) {
        this.defaultBankCode = defaultBankCode;
    }

    public String getAdditionalID() {
        return additionalID;
    }

    public void setAdditionalID(String additionalID) {
        this.additionalID = additionalID;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getFatherCard() {
        return fatherCard;
    }

    public void setFatherCard(String fatherCard) {
        this.fatherCard = fatherCard;
    }

    public String getCardForeignName() {
        return cardForeignName;
    }

    public void setCardForeignName(String cardForeignName) {
        this.cardForeignName = cardForeignName;
    }

    public String getFatherType() {
        return fatherType;
    }

    public void setFatherType(String fatherType) {
        this.fatherType = fatherType;
    }

    public String getDeductionOffice() {
        return deductionOffice;
    }

    public void setDeductionOffice(String deductionOffice) {
        this.deductionOffice = deductionOffice;
    }

    public String getExportCode() {
        return exportCode;
    }

    public void setExportCode(String exportCode) {
        this.exportCode = exportCode;
    }

    public Double getMinIntrest() {
        return minIntrest;
    }

    public void setMinIntrest(Double minIntrest) {
        this.minIntrest = minIntrest;
    }

    public Double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(Double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    public Double getOpenDeliveryNotesBalance() {
        return openDeliveryNotesBalance;
    }

    public void setOpenDeliveryNotesBalance(Double openDeliveryNotesBalance) {
        this.openDeliveryNotesBalance = openDeliveryNotesBalance;
    }

    public Double getOpenOrdersBalance() {
        return openOrdersBalance;
    }

    public void setOpenOrdersBalance(Double openOrdersBalance) {
        this.openOrdersBalance = openOrdersBalance;
    }

    public String getVatGroup() {
        return vatGroup;
    }

    public void setVatGroup(String vatGroup) {
        this.vatGroup = vatGroup;
    }

    public Long getShippingType() {
        return shippingType;
    }

    public void setShippingType(Long shippingType) {
        this.shippingType = shippingType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Long getCreditCardCode() {
        return creditCardCode;
    }

    public void setCreditCardCode(Long creditCardCode) {
        this.creditCardCode = creditCardCode;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getCreditCardExpiration() {
        return creditCardExpiration;
    }

    public void setCreditCardExpiration(String creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
    }

    public String getDebitorAccount() {
        return debitorAccount;
    }

    public void setDebitorAccount(String debitorAccount) {
        this.debitorAccount = debitorAccount;
    }

    public Long getOpenOpportunities() {
        return openOpportunities;
    }

    public void setOpenOpportunities(Long openOpportunities) {
        this.openOpportunities = openOpportunities;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTo() {
        return validTo;
    }

    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }

    public String getValidRemarks() {
        return validRemarks;
    }

    public void setValidRemarks(String validRemarks) {
        this.validRemarks = validRemarks;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }

    public String getFrozenFrom() {
        return frozenFrom;
    }

    public void setFrozenFrom(String frozenFrom) {
        this.frozenFrom = frozenFrom;
    }

    public String getFrozenTo() {
        return frozenTo;
    }

    public void setFrozenTo(String frozenTo) {
        this.frozenTo = frozenTo;
    }

    public String getFrozenRemarks() {
        return frozenRemarks;
    }

    public void setFrozenRemarks(String frozenRemarks) {
        this.frozenRemarks = frozenRemarks;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getBillToState() {
        return billToState;
    }

    public void setBillToState(String billToState) {
        this.billToState = billToState;
    }

    public String getShipToState() {
        return shipToState;
    }

    public void setShipToState(String shipToState) {
        this.shipToState = shipToState;
    }

    public String getExemptNum() {
        return exemptNum;
    }

    public void setExemptNum(String exemptNum) {
        this.exemptNum = exemptNum;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Long getFormCode1099() {
        return formCode1099;
    }

    public void setFormCode1099(Long formCode1099) {
        this.formCode1099 = formCode1099;
    }

    public String getBox1099() {
        return box1099;
    }

    public void setBox1099(String box1099) {
        this.box1099 = box1099;
    }

    public String getPeymentMethodCode() {
        return peymentMethodCode;
    }

    public void setPeymentMethodCode(String peymentMethodCode) {
        this.peymentMethodCode = peymentMethodCode;
    }

    public String getBackOrder() {
        return backOrder;
    }

    public void setBackOrder(String backOrder) {
        this.backOrder = backOrder;
    }

    public String getPartialDelivery() {
        return partialDelivery;
    }

    public void setPartialDelivery(String partialDelivery) {
        this.partialDelivery = partialDelivery;
    }

    public String getBlockDunning() {
        return blockDunning;
    }

    public void setBlockDunning(String blockDunning) {
        this.blockDunning = blockDunning;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public void setBankCountry(String bankCountry) {
        this.bankCountry = bankCountry;
    }

    public String getHouseBank() {
        return houseBank;
    }

    public void setHouseBank(String houseBank) {
        this.houseBank = houseBank;
    }

    public String getHouseBankCountry() {
        return houseBankCountry;
    }

    public void setHouseBankCountry(String houseBankCountry) {
        this.houseBankCountry = houseBankCountry;
    }

    public String getHouseBankAccount() {
        return houseBankAccount;
    }

    public void setHouseBankAccount(String houseBankAccount) {
        this.houseBankAccount = houseBankAccount;
    }

    public String getShipToDefault() {
        return shipToDefault;
    }

    public void setShipToDefault(String shipToDefault) {
        this.shipToDefault = shipToDefault;
    }

    public Long getDunningLevel() {
        return dunningLevel;
    }

    public void setDunningLevel(Long dunningLevel) {
        this.dunningLevel = dunningLevel;
    }

    public String getDunningDate() {
        return dunningDate;
    }

    public void setDunningDate(String dunningDate) {
        this.dunningDate = dunningDate;
    }

    public String getCollectionAuthorization() {
        return collectionAuthorization;
    }

    public void setCollectionAuthorization(String collectionAuthorization) {
        this.collectionAuthorization = collectionAuthorization;
    }

    public String getDme() {
        return dme;
    }

    public void setDme(String dme) {
        this.dme = dme;
    }

    public String getInstructionKey() {
        return instructionKey;
    }

    public void setInstructionKey(String instructionKey) {
        this.instructionKey = instructionKey;
    }

    public String getSinglePayment() {
        return singlePayment;
    }

    public void setSinglePayment(String singlePayment) {
        this.singlePayment = singlePayment;
    }

    public String getIsrBillerID() {
        return isrBillerID;
    }

    public void setIsrBillerID(String isrBillerID) {
        this.isrBillerID = isrBillerID;
    }

    public String getPaymentBlock() {
        return paymentBlock;
    }

    public void setPaymentBlock(String paymentBlock) {
        this.paymentBlock = paymentBlock;
    }

    public String getReferenceDetails() {
        return referenceDetails;
    }

    public void setReferenceDetails(String referenceDetails) {
        this.referenceDetails = referenceDetails;
    }

    public String getHouseBankBranch() {
        return houseBankBranch;
    }

    public void setHouseBankBranch(String houseBankBranch) {
        this.houseBankBranch = houseBankBranch;
    }

    public String getOwnerIDNumber() {
        return ownerIDNumber;
    }

    public void setOwnerIDNumber(String ownerIDNumber) {
        this.ownerIDNumber = ownerIDNumber;
    }

    public Long getPaymentBlockDescription() {
        return paymentBlockDescription;
    }

    public void setPaymentBlockDescription(Long paymentBlockDescription) {
        this.paymentBlockDescription = paymentBlockDescription;
    }

    public String getTaxExemptionLetterNum() {
        return taxExemptionLetterNum;
    }

    public void setTaxExemptionLetterNum(String taxExemptionLetterNum) {
        this.taxExemptionLetterNum = taxExemptionLetterNum;
    }

    public Double getMaxAmountOfExemption() {
        return maxAmountOfExemption;
    }

    public void setMaxAmountOfExemption(Double maxAmountOfExemption) {
        this.maxAmountOfExemption = maxAmountOfExemption;
    }

    public String getExemptionValidityDateFrom() {
        return exemptionValidityDateFrom;
    }

    public void setExemptionValidityDateFrom(String exemptionValidityDateFrom) {
        this.exemptionValidityDateFrom = exemptionValidityDateFrom;
    }

    public String getExemptionValidityDateTo() {
        return exemptionValidityDateTo;
    }

    public void setExemptionValidityDateTo(String exemptionValidityDateTo) {
        this.exemptionValidityDateTo = exemptionValidityDateTo;
    }

    public String getLinkedBusinessPartner() {
        return linkedBusinessPartner;
    }

    public void setLinkedBusinessPartner(String linkedBusinessPartner) {
        this.linkedBusinessPartner = linkedBusinessPartner;
    }

    public Long getLastMultiReconciliationNum() {
        return lastMultiReconciliationNum;
    }

    public void setLastMultiReconciliationNum(Long lastMultiReconciliationNum) {
        this.lastMultiReconciliationNum = lastMultiReconciliationNum;
    }

    public String getDeferredTax() {
        return deferredTax;
    }

    public void setDeferredTax(String deferredTax) {
        this.deferredTax = deferredTax;
    }

    public String getEqualization() {
        return equalization;
    }

    public void setEqualization(String equalization) {
        this.equalization = equalization;
    }

    public String getSubjectToWithholdingTax() {
        return subjectToWithholdingTax;
    }

    public void setSubjectToWithholdingTax(String subjectToWithholdingTax) {
        this.subjectToWithholdingTax = subjectToWithholdingTax;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNationalInsuranceNum() {
        return nationalInsuranceNum;
    }

    public void setNationalInsuranceNum(String nationalInsuranceNum) {
        this.nationalInsuranceNum = nationalInsuranceNum;
    }

    public String getAccrualCriteria() {
        return accrualCriteria;
    }

    public void setAccrualCriteria(String accrualCriteria) {
        this.accrualCriteria = accrualCriteria;
    }

    public String getWtCode() {
        return wtCode;
    }

    public void setWtCode(String wtCode) {
        this.wtCode = wtCode;
    }

    public String getBillToBuildingFloorRoom() {
        return billToBuildingFloorRoom;
    }

    public void setBillToBuildingFloorRoom(String billToBuildingFloorRoom) {
        this.billToBuildingFloorRoom = billToBuildingFloorRoom;
    }

    public String getDownPaymentClearAct() {
        return downPaymentClearAct;
    }

    public void setDownPaymentClearAct(String downPaymentClearAct) {
        this.downPaymentClearAct = downPaymentClearAct;
    }

    public String getChannelBP() {
        return channelBP;
    }

    public void setChannelBP(String channelBP) {
        this.channelBP = channelBP;
    }

    public Long getDefaultTechnician() {
        return defaultTechnician;
    }

    public void setDefaultTechnician(Long defaultTechnician) {
        this.defaultTechnician = defaultTechnician;
    }

    public String getBilltoDefault() {
        return billtoDefault;
    }

    public void setBilltoDefault(String billtoDefault) {
        this.billtoDefault = billtoDefault;
    }

    public String getCustomerBillofExchangDisc() {
        return customerBillofExchangDisc;
    }

    public void setCustomerBillofExchangDisc(String customerBillofExchangDisc) {
        this.customerBillofExchangDisc = customerBillofExchangDisc;
    }

    public Long getTerritory() {
        return territory;
    }

    public void setTerritory(Long territory) {
        this.territory = territory;
    }

    public String getShipToBuildingFloorRoom() {
        return shipToBuildingFloorRoom;
    }

    public void setShipToBuildingFloorRoom(String shipToBuildingFloorRoom) {
        this.shipToBuildingFloorRoom = shipToBuildingFloorRoom;
    }

    public String getCustomerBillofExchangPres() {
        return customerBillofExchangPres;
    }

    public void setCustomerBillofExchangPres(String customerBillofExchangPres) {
        this.customerBillofExchangPres = customerBillofExchangPres;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getVatGroupLatinAmerica() {
        return vatGroupLatinAmerica;
    }

    public void setVatGroupLatinAmerica(String vatGroupLatinAmerica) {
        this.vatGroupLatinAmerica = vatGroupLatinAmerica;
    }

    public String getDunningTerm() {
        return dunningTerm;
    }

    public void setDunningTerm(String dunningTerm) {
        this.dunningTerm = dunningTerm;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOtherReceivablePayable() {
        return otherReceivablePayable;
    }

    public void setOtherReceivablePayable(String otherReceivablePayable) {
        this.otherReceivablePayable = otherReceivablePayable;
    }

    public String getBillofExchangeonCollection() {
        return billofExchangeonCollection;
    }

    public void setBillofExchangeonCollection(String billofExchangeonCollection) {
        this.billofExchangeonCollection = billofExchangeonCollection;
    }

    public String getCompanyPrivate() {
        return companyPrivate;
    }

    public void setCompanyPrivate(String companyPrivate) {
        this.companyPrivate = companyPrivate;
    }

    public Long getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(Long languageCode) {
        this.languageCode = languageCode;
    }

    public String getUnpaidBillofExchange() {
        return unpaidBillofExchange;
    }

    public void setUnpaidBillofExchange(String unpaidBillofExchange) {
        this.unpaidBillofExchange = unpaidBillofExchange;
    }

    public Long getWithholdingTaxDeductionGroup() {
        return withholdingTaxDeductionGroup;
    }

    public void setWithholdingTaxDeductionGroup(Long withholdingTaxDeductionGroup) {
        this.withholdingTaxDeductionGroup = withholdingTaxDeductionGroup;
    }

    public Long getClosingDateProcedureNumber() {
        return closingDateProcedureNumber;
    }

    public void setClosingDateProcedureNumber(Long closingDateProcedureNumber) {
        this.closingDateProcedureNumber = closingDateProcedureNumber;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getBankChargesAllocationCode() {
        return bankChargesAllocationCode;
    }

    public void setBankChargesAllocationCode(String bankChargesAllocationCode) {
        this.bankChargesAllocationCode = bankChargesAllocationCode;
    }

    public String getTaxRoundingRule() {
        return taxRoundingRule;
    }

    public void setTaxRoundingRule(String taxRoundingRule) {
        this.taxRoundingRule = taxRoundingRule;
    }

    public String getProperties1() {
        return properties1;
    }

    public void setProperties1(String properties1) {
        this.properties1 = properties1;
    }

    public String getProperties2() {
        return properties2;
    }

    public void setProperties2(String properties2) {
        this.properties2 = properties2;
    }

    public String getProperties3() {
        return properties3;
    }

    public void setProperties3(String properties3) {
        this.properties3 = properties3;
    }

    public String getProperties4() {
        return properties4;
    }

    public void setProperties4(String properties4) {
        this.properties4 = properties4;
    }

    public String getProperties5() {
        return properties5;
    }

    public void setProperties5(String properties5) {
        this.properties5 = properties5;
    }

    public String getProperties6() {
        return properties6;
    }

    public void setProperties6(String properties6) {
        this.properties6 = properties6;
    }

    public String getProperties7() {
        return properties7;
    }

    public void setProperties7(String properties7) {
        this.properties7 = properties7;
    }

    public String getProperties8() {
        return properties8;
    }

    public void setProperties8(String properties8) {
        this.properties8 = properties8;
    }

    public String getProperties9() {
        return properties9;
    }

    public void setProperties9(String properties9) {
        this.properties9 = properties9;
    }

    public String getProperties10() {
        return properties10;
    }

    public void setProperties10(String properties10) {
        this.properties10 = properties10;
    }

    public String getProperties11() {
        return properties11;
    }

    public void setProperties11(String properties11) {
        this.properties11 = properties11;
    }

    public String getProperties12() {
        return properties12;
    }

    public void setProperties12(String properties12) {
        this.properties12 = properties12;
    }

    public String getProperties13() {
        return properties13;
    }

    public void setProperties13(String properties13) {
        this.properties13 = properties13;
    }

    public String getProperties14() {
        return properties14;
    }

    public void setProperties14(String properties14) {
        this.properties14 = properties14;
    }

    public String getProperties15() {
        return properties15;
    }

    public void setProperties15(String properties15) {
        this.properties15 = properties15;
    }

    public String getProperties16() {
        return properties16;
    }

    public void setProperties16(String properties16) {
        this.properties16 = properties16;
    }

    public String getProperties17() {
        return properties17;
    }

    public void setProperties17(String properties17) {
        this.properties17 = properties17;
    }

    public String getProperties18() {
        return properties18;
    }

    public void setProperties18(String properties18) {
        this.properties18 = properties18;
    }

    public String getProperties19() {
        return properties19;
    }

    public void setProperties19(String properties19) {
        this.properties19 = properties19;
    }

    public String getProperties20() {
        return properties20;
    }

    public void setProperties20(String properties20) {
        this.properties20 = properties20;
    }

    public String getProperties21() {
        return properties21;
    }

    public void setProperties21(String properties21) {
        this.properties21 = properties21;
    }

    public String getProperties22() {
        return properties22;
    }

    public void setProperties22(String properties22) {
        this.properties22 = properties22;
    }

    public String getProperties23() {
        return properties23;
    }

    public void setProperties23(String properties23) {
        this.properties23 = properties23;
    }

    public String getProperties24() {
        return properties24;
    }

    public void setProperties24(String properties24) {
        this.properties24 = properties24;
    }

    public String getProperties25() {
        return properties25;
    }

    public void setProperties25(String properties25) {
        this.properties25 = properties25;
    }

    public String getProperties26() {
        return properties26;
    }

    public void setProperties26(String properties26) {
        this.properties26 = properties26;
    }

    public String getProperties27() {
        return properties27;
    }

    public void setProperties27(String properties27) {
        this.properties27 = properties27;
    }

    public String getProperties28() {
        return properties28;
    }

    public void setProperties28(String properties28) {
        this.properties28 = properties28;
    }

    public String getProperties29() {
        return properties29;
    }

    public void setProperties29(String properties29) {
        this.properties29 = properties29;
    }

    public String getProperties30() {
        return properties30;
    }

    public void setProperties30(String properties30) {
        this.properties30 = properties30;
    }

    public String getProperties31() {
        return properties31;
    }

    public void setProperties31(String properties31) {
        this.properties31 = properties31;
    }

    public String getProperties32() {
        return properties32;
    }

    public void setProperties32(String properties32) {
        this.properties32 = properties32;
    }

    public String getProperties33() {
        return properties33;
    }

    public void setProperties33(String properties33) {
        this.properties33 = properties33;
    }

    public String getProperties34() {
        return properties34;
    }

    public void setProperties34(String properties34) {
        this.properties34 = properties34;
    }

    public String getProperties35() {
        return properties35;
    }

    public void setProperties35(String properties35) {
        this.properties35 = properties35;
    }

    public String getProperties36() {
        return properties36;
    }

    public void setProperties36(String properties36) {
        this.properties36 = properties36;
    }

    public String getProperties37() {
        return properties37;
    }

    public void setProperties37(String properties37) {
        this.properties37 = properties37;
    }

    public String getProperties38() {
        return properties38;
    }

    public void setProperties38(String properties38) {
        this.properties38 = properties38;
    }

    public String getProperties39() {
        return properties39;
    }

    public void setProperties39(String properties39) {
        this.properties39 = properties39;
    }

    public String getProperties40() {
        return properties40;
    }

    public void setProperties40(String properties40) {
        this.properties40 = properties40;
    }

    public String getProperties41() {
        return properties41;
    }

    public void setProperties41(String properties41) {
        this.properties41 = properties41;
    }

    public String getProperties42() {
        return properties42;
    }

    public void setProperties42(String properties42) {
        this.properties42 = properties42;
    }

    public String getProperties43() {
        return properties43;
    }

    public void setProperties43(String properties43) {
        this.properties43 = properties43;
    }

    public String getProperties44() {
        return properties44;
    }

    public void setProperties44(String properties44) {
        this.properties44 = properties44;
    }

    public String getProperties45() {
        return properties45;
    }

    public void setProperties45(String properties45) {
        this.properties45 = properties45;
    }

    public String getProperties46() {
        return properties46;
    }

    public void setProperties46(String properties46) {
        this.properties46 = properties46;
    }

    public String getProperties47() {
        return properties47;
    }

    public void setProperties47(String properties47) {
        this.properties47 = properties47;
    }

    public String getProperties48() {
        return properties48;
    }

    public void setProperties48(String properties48) {
        this.properties48 = properties48;
    }

    public String getProperties49() {
        return properties49;
    }

    public void setProperties49(String properties49) {
        this.properties49 = properties49;
    }

    public String getProperties50() {
        return properties50;
    }

    public void setProperties50(String properties50) {
        this.properties50 = properties50;
    }

    public String getProperties51() {
        return properties51;
    }

    public void setProperties51(String properties51) {
        this.properties51 = properties51;
    }

    public String getProperties52() {
        return properties52;
    }

    public void setProperties52(String properties52) {
        this.properties52 = properties52;
    }

    public String getProperties53() {
        return properties53;
    }

    public void setProperties53(String properties53) {
        this.properties53 = properties53;
    }

    public String getProperties54() {
        return properties54;
    }

    public void setProperties54(String properties54) {
        this.properties54 = properties54;
    }

    public String getProperties55() {
        return properties55;
    }

    public void setProperties55(String properties55) {
        this.properties55 = properties55;
    }

    public String getProperties56() {
        return properties56;
    }

    public void setProperties56(String properties56) {
        this.properties56 = properties56;
    }

    public String getProperties57() {
        return properties57;
    }

    public void setProperties57(String properties57) {
        this.properties57 = properties57;
    }

    public String getProperties58() {
        return properties58;
    }

    public void setProperties58(String properties58) {
        this.properties58 = properties58;
    }

    public String getProperties59() {
        return properties59;
    }

    public void setProperties59(String properties59) {
        this.properties59 = properties59;
    }

    public String getProperties60() {
        return properties60;
    }

    public void setProperties60(String properties60) {
        this.properties60 = properties60;
    }

    public String getProperties61() {
        return properties61;
    }

    public void setProperties61(String properties61) {
        this.properties61 = properties61;
    }

    public String getProperties62() {
        return properties62;
    }

    public void setProperties62(String properties62) {
        this.properties62 = properties62;
    }

    public String getProperties63() {
        return properties63;
    }

    public void setProperties63(String properties63) {
        this.properties63 = properties63;
    }

    public String getProperties64() {
        return properties64;
    }

    public void setProperties64(String properties64) {
        this.properties64 = properties64;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public String getDiscountBaseObject() {
        return discountBaseObject;
    }

    public void setDiscountBaseObject(String discountBaseObject) {
        this.discountBaseObject = discountBaseObject;
    }

    public String getDiscountRelations() {
        return discountRelations;
    }

    public void setDiscountRelations(String discountRelations) {
        this.discountRelations = discountRelations;
    }

    public String getTypeReport() {
        return typeReport;
    }

    public void setTypeReport(String typeReport) {
        this.typeReport = typeReport;
    }

    public String getThresholdOverlook() {
        return thresholdOverlook;
    }

    public void setThresholdOverlook(String thresholdOverlook) {
        this.thresholdOverlook = thresholdOverlook;
    }

    public String getSurchargeOverlook() {
        return surchargeOverlook;
    }

    public void setSurchargeOverlook(String surchargeOverlook) {
        this.surchargeOverlook = surchargeOverlook;
    }

    public String getDownPaymentInterimAccount() {
        return downPaymentInterimAccount;
    }

    public void setDownPaymentInterimAccount(String downPaymentInterimAccount) {
        this.downPaymentInterimAccount = downPaymentInterimAccount;
    }

    public String getOperationCode347() {
        return operationCode347;
    }

    public void setOperationCode347(String operationCode347) {
        this.operationCode347 = operationCode347;
    }

    public String getInsuranceOperation347() {
        return insuranceOperation347;
    }

    public void setInsuranceOperation347(String insuranceOperation347) {
        this.insuranceOperation347 = insuranceOperation347;
    }

    public String getHierarchicalDeduction() {
        return hierarchicalDeduction;
    }

    public void setHierarchicalDeduction(String hierarchicalDeduction) {
        this.hierarchicalDeduction = hierarchicalDeduction;
    }

    public String getShaamGroup() {
        return shaamGroup;
    }

    public void setShaamGroup(String shaamGroup) {
        this.shaamGroup = shaamGroup;
    }

    public String getWithholdingTaxCertified() {
        return withholdingTaxCertified;
    }

    public void setWithholdingTaxCertified(String withholdingTaxCertified) {
        this.withholdingTaxCertified = withholdingTaxCertified;
    }

    public String getBookkeepingCertified() {
        return bookkeepingCertified;
    }

    public void setBookkeepingCertified(String bookkeepingCertified) {
        this.bookkeepingCertified = bookkeepingCertified;
    }

    public String getPlanningGroup() {
        return planningGroup;
    }

    public void setPlanningGroup(String planningGroup) {
        this.planningGroup = planningGroup;
    }

    public String getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(String affiliate) {
        this.affiliate = affiliate;
    }

    public Long getIndustry() {
        return industry;
    }

    public void setIndustry(Long industry) {
        this.industry = industry;
    }

    public String getVatIDNum() {
        return vatIDNum;
    }

    public void setVatIDNum(String vatIDNum) {
        this.vatIDNum = vatIDNum;
    }

    public Long getDatevAccount() {
        return datevAccount;
    }

    public void setDatevAccount(Long datevAccount) {
        this.datevAccount = datevAccount;
    }

    public String getDatevFirstDataEntry() {
        return datevFirstDataEntry;
    }

    public void setDatevFirstDataEntry(String datevFirstDataEntry) {
        this.datevFirstDataEntry = datevFirstDataEntry;
    }

    public String getGtsRegNo() {
        return gtsRegNo;
    }

    public void setGtsRegNo(String gtsRegNo) {
        this.gtsRegNo = gtsRegNo;
    }

    public String getGtsBankAccountNo() {
        return gtsBankAccountNo;
    }

    public void setGtsBankAccountNo(String gtsBankAccountNo) {
        this.gtsBankAccountNo = gtsBankAccountNo;
    }

    public String getGtsBillingAddrTel() {
        return gtsBillingAddrTel;
    }

    public void setGtsBillingAddrTel(String gtsBillingAddrTel) {
        this.gtsBillingAddrTel = gtsBillingAddrTel;
    }

    public Long getEtaxWebSite() {
        return etaxWebSite;
    }

    public void setEtaxWebSite(Long etaxWebSite) {
        this.etaxWebSite = etaxWebSite;
    }

    public String getHouseBankIBAN() {
        return houseBankIBAN;
    }

    public void setHouseBankIBAN(String houseBankIBAN) {
        this.houseBankIBAN = houseBankIBAN;
    }

    public String getVatRegistrationNumber() {
        return vatRegistrationNumber;
    }

    public void setVatRegistrationNumber(String vatRegistrationNumber) {
        this.vatRegistrationNumber = vatRegistrationNumber;
    }

    public String getRepresentativeName() {
        return representativeName;
    }

    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public String getAutomaticPosting() {
        return automaticPosting;
    }

    public void setAutomaticPosting(String automaticPosting) {
        this.automaticPosting = automaticPosting;
    }

    public String getInterestAccount() {
        return interestAccount;
    }

    public void setInterestAccount(String interestAccount) {
        this.interestAccount = interestAccount;
    }

    public String getFeeAccount() {
        return feeAccount;
    }

    public void setFeeAccount(String feeAccount) {
        this.feeAccount = feeAccount;
    }

    public Long getCampaignNumber() {
        return campaignNumber;
    }

    public void setCampaignNumber(Long campaignNumber) {
        this.campaignNumber = campaignNumber;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Long getDefaultBlanketAgreementNumber() {
        return defaultBlanketAgreementNumber;
    }

    public void setDefaultBlanketAgreementNumber(Long defaultBlanketAgreementNumber) {
        this.defaultBlanketAgreementNumber = defaultBlanketAgreementNumber;
    }

    public String getEffectiveDiscount() {
        return effectiveDiscount;
    }

    public void setEffectiveDiscount(String effectiveDiscount) {
        this.effectiveDiscount = effectiveDiscount;
    }

    public String getNoDiscounts() {
        return noDiscounts;
    }

    public void setNoDiscounts(String noDiscounts) {
        this.noDiscounts = noDiscounts;
    }

    public String getGlobalLocationNumber() {
        return globalLocationNumber;
    }

    public void setGlobalLocationNumber(String globalLocationNumber) {
        this.globalLocationNumber = globalLocationNumber;
    }

    public String getEdiSenderID() {
        return ediSenderID;
    }

    public void setEdiSenderID(String ediSenderID) {
        this.ediSenderID = ediSenderID;
    }

    public String getEdiRecipientID() {
        return ediRecipientID;
    }

    public void setEdiRecipientID(String ediRecipientID) {
        this.ediRecipientID = ediRecipientID;
    }

    public String getResidenNumber() {
        return residenNumber;
    }

    public void setResidenNumber(String residenNumber) {
        this.residenNumber = residenNumber;
    }

    public String getRelationshipCode() {
        return relationshipCode;
    }

    public void setRelationshipCode(String relationshipCode) {
        this.relationshipCode = relationshipCode;
    }

    public String getRelationshipDateFrom() {
        return relationshipDateFrom;
    }

    public void setRelationshipDateFrom(String relationshipDateFrom) {
        this.relationshipDateFrom = relationshipDateFrom;
    }

    public String getRelationshipDateTill() {
        return relationshipDateTill;
    }

    public void setRelationshipDateTill(String relationshipDateTill) {
        this.relationshipDateTill = relationshipDateTill;
    }

    public String getUnifiedFederalTaxID() {
        return unifiedFederalTaxID;
    }

    public void setUnifiedFederalTaxID(String unifiedFederalTaxID) {
        this.unifiedFederalTaxID = unifiedFederalTaxID;
    }

    public Long getAttachmentEntry() {
        return attachmentEntry;
    }

    public void setAttachmentEntry(Long attachmentEntry) {
        this.attachmentEntry = attachmentEntry;
    }

    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    public void setTypeOfOperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }

    public String getUbdErst() {
        return ubdErst;
    }

    public void setUbdErst(String ubdErst) {
        this.ubdErst = ubdErst;
    }

    public String getUbdDatev() {
        return ubdDatev;
    }

    public void setUbdDatev(String ubdDatev) {
        this.ubdDatev = ubdDatev;
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

    public String getUbpcotp() {
        return ubpcotp;
    }

    public void setUbpcotp(String ubpcotp) {
        this.ubpcotp = ubpcotp;
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

    public String getUbpcobpExt() {
        return ubpcobpExt;
    }

    public void setUbpcobpExt(String ubpcobpExt) {
        this.ubpcobpExt = ubpcobpExt;
    }

    public String getUbpcotbpe() {
        return ubpcotbpe;
    }

    public void setUbpcotbpe(String ubpcotbpe) {
        this.ubpcotbpe = ubpcotbpe;
    }

    public String getUbpcoAddress() {
        return ubpcoAddress;
    }

    public void setUbpcoAddress(String ubpcoAddress) {
        this.ubpcoAddress = ubpcoAddress;
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

    public String getUtrasp() {
        return utrasp;
    }

    public void setUtrasp(String utrasp) {
        this.utrasp = utrasp;
    }

    public String getUtipoNegocio() {
        return utipoNegocio;
    }

    public void setUtipoNegocio(String utipoNegocio) {
        this.utipoNegocio = utipoNegocio;
    }

    public Long getUtiempotra() {
        return utiempotra;
    }

    public void setUtiempotra(Long utiempotra) {
        this.utiempotra = utiempotra;
    }

    public Double getUpromdiaspago() {
        return upromdiaspago;
    }

    public void setUpromdiaspago(Double upromdiaspago) {
        this.upromdiaspago = upromdiaspago;
    }

    public String getUvlgxviv() {
        return uvlgxviv;
    }

    public void setUvlgxviv(String uvlgxviv) {
        this.uvlgxviv = uvlgxviv;
    }

    public Long getUvlgxlt() {
        return uvlgxlt;
    }

    public void setUvlgxlt(Long uvlgxlt) {
        this.uvlgxlt = uvlgxlt;
    }

    public Long getUvlgxof() {
        return uvlgxof;
    }

    public void setUvlgxof(Long uvlgxof) {
        this.uvlgxof = uvlgxof;
    }

    public String getUvlgxplc() {
        return uvlgxplc;
    }

    public void setUvlgxplc(String uvlgxplc) {
        this.uvlgxplc = uvlgxplc;
    }

    public Long getUvlgxvfq() {
        return uvlgxvfq;
    }

    public void setUvlgxvfq(Long uvlgxvfq) {
        this.uvlgxvfq = uvlgxvfq;
    }

    public Long getUvlgxvfw() {
        return uvlgxvfw;
    }

    public void setUvlgxvfw(Long uvlgxvfw) {
        this.uvlgxvfw = uvlgxvfw;
    }

    public Long getUvlgxvfm() {
        return uvlgxvfm;
    }

    public void setUvlgxvfm(Long uvlgxvfm) {
        this.uvlgxvfm = uvlgxvfm;
    }

    public Long getUvlgxvfv() {
        return uvlgxvfv;
    }

    public void setUvlgxvfv(Long uvlgxvfv) {
        this.uvlgxvfv = uvlgxvfv;
    }

    public String getUesAutorret() {
        return uesAutorret;
    }

    public void setUesAutorret(String uesAutorret) {
        this.uesAutorret = uesAutorret;
    }

    public String getUok1ACECO() {
        return uok1ACECO;
    }

    public void setUok1ACECO(String uok1ACECO) {
        this.uok1ACECO = uok1ACECO;
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

    public String getUregional() {
        return uregional;
    }

    public void setUregional(String uregional) {
        this.uregional = uregional;
    }

    public String getUproFidelizacion() {
        return uproFidelizacion;
    }

    public void setUproFidelizacion(String uproFidelizacion) {
        this.uproFidelizacion = uproFidelizacion;
    }

    public String getBlockSendingMarketingContent() {
        return blockSendingMarketingContent;
    }

    public void setBlockSendingMarketingContent(String blockSendingMarketingContent) {
        this.blockSendingMarketingContent = blockSendingMarketingContent;
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

    public List<BPAccountReceivablePaybleCollection.BPAccountReceivablePayble> getBpAccountReceivablePaybleCollection() {
        return bpAccountReceivablePaybleCollection;
    }

    public void setBpAccountReceivablePaybleCollection(List<BPAccountReceivablePaybleCollection.BPAccountReceivablePayble> bpAccountReceivablePaybleCollection) {
        this.bpAccountReceivablePaybleCollection = bpAccountReceivablePaybleCollection;
    }

    public List<BPPaymentMethods.BPPaymentMethod> getBpPaymentMethods() {
        return bpPaymentMethods;
    }

    public void setBpPaymentMethods(List<BPPaymentMethods.BPPaymentMethod> bpPaymentMethods) {
        this.bpPaymentMethods = bpPaymentMethods;
    }

    public List<BPWithholdingTaxCollection.BPWithholdingTax> getBpWithholdingTaxCollection() {
        return bpWithholdingTaxCollection;
    }

    public void setBpWithholdingTaxCollection(List<BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTaxCollection) {
        this.bpWithholdingTaxCollection = bpWithholdingTaxCollection;
    }

    public List<BPPaymentDates.BPPaymentDate> getBpPaymentDates() {
        return bpPaymentDates;
    }

    public void setBpPaymentDates(List<BPPaymentDates.BPPaymentDate> bpPaymentDates) {
        this.bpPaymentDates = bpPaymentDates;
    }

    public List<BPBranchAssignment.BPBranchAssignmentItem> getBpBranchAssignment() {
        return bpBranchAssignment;
    }

    public void setBpBranchAssignment(List<BPBranchAssignment.BPBranchAssignmentItem> bpBranchAssignment) {
        this.bpBranchAssignment = bpBranchAssignment;
    }

    public List<BPBankAccounts.BPBankAccount> getBpBankAccounts() {
        return bpBankAccounts;
    }

    public void setBpBankAccounts(List<BPBankAccounts.BPBankAccount> bpBankAccounts) {
        this.bpBankAccounts = bpBankAccounts;
    }

    public List<BPFiscalTaxIDCollection.BPFiscalTaxID> getBpFiscalTaxIDCollection() {
        return bpFiscalTaxIDCollection;
    }

    public void setBpFiscalTaxIDCollection(List<BPFiscalTaxIDCollection.BPFiscalTaxID> bpFiscalTaxIDCollection) {
        this.bpFiscalTaxIDCollection = bpFiscalTaxIDCollection;
    }

    public List<DiscountGroups.DiscountGroup> getDiscountGroups() {
        return discountGroups;
    }

    public void setDiscountGroups(List<DiscountGroups.DiscountGroup> discountGroups) {
        this.discountGroups = discountGroups;
    }

    public BPIntrastatExtension getBpIntrastatExtension() {
        return bpIntrastatExtension;
    }

    public void setBpIntrastatExtension(BPIntrastatExtension bpIntrastatExtension) {
        this.bpIntrastatExtension = bpIntrastatExtension;
    }

    public static class BPAddresses {
        public static class BPAddress {
            @JsonProperty("AddressName")
            protected String addressName;
            @JsonProperty("Street")
            protected String street;
            @JsonProperty("Block")
            protected String block;
            @JsonProperty("ZipCode")
            protected String zipCode;
            @JsonProperty("City")
            protected String city;
            @JsonProperty("County")
            protected String county;
            @JsonProperty("Country")
            protected String country;
            @JsonProperty("State")
            protected String state;
            @JsonProperty("FederalTaxID")
            protected String federalTaxID;
            @JsonProperty("TaxCode")
            protected String taxCode;
            @JsonProperty("BuildingFloorRoom")
            protected String buildingFloorRoom;
            @JsonProperty("AddressType")
            protected String addressType;
            @JsonProperty("AddressName2")
            protected String addressName2;
            @JsonProperty("AddressName3")
            protected String addressName3;
            @JsonProperty("TypeOfAddress")
            protected String typeOfAddress;
            @JsonProperty("StreetNo")
            protected String streetNo;
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("RowNum")
            protected Long rowNum;
            @JsonProperty("GlobalLocationNumber")
            protected String globalLocationNumber;
            @JsonProperty("Nationality")
            protected String nationality;
            @JsonProperty("TaxOffice")
            protected String taxOffice;
            @JsonProperty("GSTIN")
            protected String gstin;
            @JsonProperty("GstType")
            protected String gstType;
            @JsonProperty("CreateDate")
            protected String createDate;
            @JsonProperty("CreateTime")
            protected String createTime;
            @JsonProperty("MYFType")
            protected String myfType;
            @JsonProperty("TaasEnabled")
            protected String taasEnabled;
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

            public String getZipCode() {
                return zipCode;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getFederalTaxID() {
                return federalTaxID;
            }

            public void setFederalTaxID(String federalTaxID) {
                this.federalTaxID = federalTaxID;
            }

            public String getTaxCode() {
                return taxCode;
            }

            public void setTaxCode(String taxCode) {
                this.taxCode = taxCode;
            }

            public String getBuildingFloorRoom() {
                return buildingFloorRoom;
            }

            public void setBuildingFloorRoom(String buildingFloorRoom) {
                this.buildingFloorRoom = buildingFloorRoom;
            }

            public String getAddressType() {
                return addressType;
            }

            public void setAddressType(String addressType) {
                this.addressType = addressType;
            }

            public String getAddressName2() {
                return addressName2;
            }

            public void setAddressName2(String addressName2) {
                this.addressName2 = addressName2;
            }

            public String getAddressName3() {
                return addressName3;
            }

            public void setAddressName3(String addressName3) {
                this.addressName3 = addressName3;
            }

            public String getTypeOfAddress() {
                return typeOfAddress;
            }

            public void setTypeOfAddress(String typeOfAddress) {
                this.typeOfAddress = typeOfAddress;
            }

            public String getStreetNo() {
                return streetNo;
            }

            public void setStreetNo(String streetNo) {
                this.streetNo = streetNo;
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

            public String getGlobalLocationNumber() {
                return globalLocationNumber;
            }

            public void setGlobalLocationNumber(String globalLocationNumber) {
                this.globalLocationNumber = globalLocationNumber;
            }

            public String getNationality() {
                return nationality;
            }

            public void setNationality(String nationality) {
                this.nationality = nationality;
            }

            public String getTaxOffice() {
                return taxOffice;
            }

            public void setTaxOffice(String taxOffice) {
                this.taxOffice = taxOffice;
            }

            public String getGstin() {
                return gstin;
            }

            public void setGstin(String gstin) {
                this.gstin = gstin;
            }

            public String getGstType() {
                return gstType;
            }

            public void setGstType(String gstType) {
                this.gstType = gstType;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getMyfType() {
                return myfType;
            }

            public void setMyfType(String myfType) {
                this.myfType = myfType;
            }

            public String getTaasEnabled() {
                return taasEnabled;
            }

            public void setTaasEnabled(String taasEnabled) {
                this.taasEnabled = taasEnabled;
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
            @JsonProperty("BlockSendingMarketingContent")
            protected String blockSendingMarketingContent;
            @JsonProperty("CreateDate")
            protected String createDate;
            @JsonProperty("CreateTime")
            protected String createTime;
            @JsonProperty("UpdateDate")
            protected String updateDate;
            @JsonProperty("UpdateTime")
            protected String updateTime;
            @JsonProperty("ConnectedAddressName")
            protected String connectedAddressName;
            @JsonProperty("ConnectedAddressType")
            protected String connectedAddressType;
            @JsonProperty("ForeignCountry")
            protected String foreignCountry;
            @JsonProperty("ContactEmployeeBlockSendingMarketingContents")
            protected List<Object> contactEmployeeBlockSendingMarketingContents;

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

            public String getBlockSendingMarketingContent() {
                return blockSendingMarketingContent;
            }

            public void setBlockSendingMarketingContent(String blockSendingMarketingContent) {
                this.blockSendingMarketingContent = blockSendingMarketingContent;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getConnectedAddressName() {
                return connectedAddressName;
            }

            public void setConnectedAddressName(String connectedAddressName) {
                this.connectedAddressName = connectedAddressName;
            }

            public String getConnectedAddressType() {
                return connectedAddressType;
            }

            public void setConnectedAddressType(String connectedAddressType) {
                this.connectedAddressType = connectedAddressType;
            }

            public String getForeignCountry() {
                return foreignCountry;
            }

            public void setForeignCountry(String foreignCountry) {
                this.foreignCountry = foreignCountry;
            }

            public List<Object> getContactEmployeeBlockSendingMarketingContents() {
                return contactEmployeeBlockSendingMarketingContents;
            }

            public void setContactEmployeeBlockSendingMarketingContents(List<Object> contactEmployeeBlockSendingMarketingContents) {
                this.contactEmployeeBlockSendingMarketingContents = contactEmployeeBlockSendingMarketingContents;
            }
        }
    }

    public static class BPAccountReceivablePaybleCollection {
        public static class BPAccountReceivablePayble {
            @JsonProperty("AccountType")
            protected String accountType;
            @JsonProperty("AccountCode")
            protected String accountCode;
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getAccountType() {
                return accountType;
            }

            public void setAccountType(String accountType) {
                this.accountType = accountType;
            }

            public String getAccountCode() {
                return accountCode;
            }

            public void setAccountCode(String accountCode) {
                this.accountCode = accountCode;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }

    public static class BPPaymentMethods {
        public static class BPPaymentMethod {
            @JsonProperty("PaymentMethodCode")
            protected String paymentMethodCode;
            @JsonProperty("RowNumber")
            protected Long rowNumber;
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getPaymentMethodCode() {
                return paymentMethodCode;
            }

            public void setPaymentMethodCode(String paymentMethodCode) {
                this.paymentMethodCode = paymentMethodCode;
            }

            public Long getRowNumber() {
                return rowNumber;
            }

            public void setRowNumber(Long rowNumber) {
                this.rowNumber = rowNumber;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }

    public static class BPWithholdingTaxCollection {
        public static class BPWithholdingTax {
            @JsonProperty("WTCode")
            protected String wtCode;
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getWtCode() {
                return wtCode;
            }

            public void setWtCode(String wtCode) {
                this.wtCode = wtCode;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }

    public static class BPPaymentDates {
        public static class BPPaymentDate {
            @JsonProperty("PaymentDate")
            protected String paymentDate;
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getPaymentDate() {
                return paymentDate;
            }

            public void setPaymentDate(String paymentDate) {
                this.paymentDate = paymentDate;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }

    public static class BPBranchAssignment {
        public static class BPBranchAssignmentItem {
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("BPLID")
            protected Long bplid;

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }

            public Long getBplid() {
                return bplid;
            }

            public void setBplid(Long bplid) {
                this.bplid = bplid;
            }
        }
    }

    public static class BPBankAccounts {
        public static class BPBankAccount {
            @JsonProperty("LogInstance")
            protected Long logInstance;
            @JsonProperty("UserNo4")
            protected String userNo4;
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("County")
            protected String county;
            @JsonProperty("State")
            protected String state;
            @JsonProperty("UserNo2")
            protected String userNo2;
            @JsonProperty("IBAN")
            protected String iban;
            @JsonProperty("ZipCode")
            protected String zipCode;
            @JsonProperty("City")
            protected String city;
            @JsonProperty("Block")
            protected String block;
            @JsonProperty("Branch")
            protected String branch;
            @JsonProperty("Country")
            protected String country;
            @JsonProperty("Street")
            protected String street;
            @JsonProperty("ControlKey")
            protected String controlKey;
            @JsonProperty("UserNo3")
            protected String userNo3;
            @JsonProperty("BankCode")
            protected String bankCode;
            @JsonProperty("AccountNo")
            protected String accountNo;
            @JsonProperty("UserNo1")
            protected String userNo1;
            @JsonProperty("InternalKey")
            protected Long internalKey;
            @JsonProperty("BuildingFloorRoom")
            protected String buildingFloorRoom;
            @JsonProperty("BIK")
            protected String bik;
            @JsonProperty("AccountName")
            protected String accountName;
            @JsonProperty("CorrespondentAccount")
            protected String correspondentAccount;
            @JsonProperty("Phone")
            protected String phone;
            @JsonProperty("Fax")
            protected String fax;
            @JsonProperty("CustomerIdNumber")
            protected String customerIdNumber;
            @JsonProperty("ISRBillerID")
            protected String isrBillerID;
            @JsonProperty("ISRType")
            protected Long isrType;
            @JsonProperty("BICSwiftCode")
            protected String bicSwiftCode;
            @JsonProperty("ABARoutingNumber")
            protected String abaRoutingNumber;
            @JsonProperty("MandateID")
            protected String mandateID;
            @JsonProperty("SignatureDate")
            protected String signatureDate;
            @JsonProperty("MandateExpDate")
            protected String mandateExpDate;
            @JsonProperty("SEPASeqType")
            protected String sepaSeqType;

            public Long getLogInstance() {
                return logInstance;
            }

            public void setLogInstance(Long logInstance) {
                this.logInstance = logInstance;
            }

            public String getUserNo4() {
                return userNo4;
            }

            public void setUserNo4(String userNo4) {
                this.userNo4 = userNo4;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }

            public String getCounty() {
                return county;
            }

            public void setCounty(String county) {
                this.county = county;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getUserNo2() {
                return userNo2;
            }

            public void setUserNo2(String userNo2) {
                this.userNo2 = userNo2;
            }

            public String getIban() {
                return iban;
            }

            public void setIban(String iban) {
                this.iban = iban;
            }

            public String getZipCode() {
                return zipCode;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getBlock() {
                return block;
            }

            public void setBlock(String block) {
                this.block = block;
            }

            public String getBranch() {
                return branch;
            }

            public void setBranch(String branch) {
                this.branch = branch;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getControlKey() {
                return controlKey;
            }

            public void setControlKey(String controlKey) {
                this.controlKey = controlKey;
            }

            public String getUserNo3() {
                return userNo3;
            }

            public void setUserNo3(String userNo3) {
                this.userNo3 = userNo3;
            }

            public String getBankCode() {
                return bankCode;
            }

            public void setBankCode(String bankCode) {
                this.bankCode = bankCode;
            }

            public String getAccountNo() {
                return accountNo;
            }

            public void setAccountNo(String accountNo) {
                this.accountNo = accountNo;
            }

            public String getUserNo1() {
                return userNo1;
            }

            public void setUserNo1(String userNo1) {
                this.userNo1 = userNo1;
            }

            public Long getInternalKey() {
                return internalKey;
            }

            public void setInternalKey(Long internalKey) {
                this.internalKey = internalKey;
            }

            public String getBuildingFloorRoom() {
                return buildingFloorRoom;
            }

            public void setBuildingFloorRoom(String buildingFloorRoom) {
                this.buildingFloorRoom = buildingFloorRoom;
            }

            public String getBik() {
                return bik;
            }

            public void setBik(String bik) {
                this.bik = bik;
            }

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getCorrespondentAccount() {
                return correspondentAccount;
            }

            public void setCorrespondentAccount(String correspondentAccount) {
                this.correspondentAccount = correspondentAccount;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getFax() {
                return fax;
            }

            public void setFax(String fax) {
                this.fax = fax;
            }

            public String getCustomerIdNumber() {
                return customerIdNumber;
            }

            public void setCustomerIdNumber(String customerIdNumber) {
                this.customerIdNumber = customerIdNumber;
            }

            public String getIsrBillerID() {
                return isrBillerID;
            }

            public void setIsrBillerID(String isrBillerID) {
                this.isrBillerID = isrBillerID;
            }

            public Long getIsrType() {
                return isrType;
            }

            public void setIsrType(Long isrType) {
                this.isrType = isrType;
            }

            public String getBicSwiftCode() {
                return bicSwiftCode;
            }

            public void setBicSwiftCode(String bicSwiftCode) {
                this.bicSwiftCode = bicSwiftCode;
            }

            public String getAbaRoutingNumber() {
                return abaRoutingNumber;
            }

            public void setAbaRoutingNumber(String abaRoutingNumber) {
                this.abaRoutingNumber = abaRoutingNumber;
            }

            public String getMandateID() {
                return mandateID;
            }

            public void setMandateID(String mandateID) {
                this.mandateID = mandateID;
            }

            public String getSignatureDate() {
                return signatureDate;
            }

            public void setSignatureDate(String signatureDate) {
                this.signatureDate = signatureDate;
            }

            public String getMandateExpDate() {
                return mandateExpDate;
            }

            public void setMandateExpDate(String mandateExpDate) {
                this.mandateExpDate = mandateExpDate;
            }

            public String getSepaSeqType() {
                return sepaSeqType;
            }

            public void setSepaSeqType(String sepaSeqType) {
                this.sepaSeqType = sepaSeqType;
            }
        }
    }

    public static class BPFiscalTaxIDCollection {
        public static class BPFiscalTaxID {
            @JsonProperty("Address")
            protected String address;
            @JsonProperty("CNAECode")
            protected Long cnaeCode;
            @JsonProperty("TaxId0")
            protected String taxId0;
            @JsonProperty("TaxId1")
            protected String taxId1;
            @JsonProperty("TaxId2")
            protected String taxId2;
            @JsonProperty("TaxId3")
            protected String taxId3;
            @JsonProperty("TaxId4")
            protected String taxId4;
            @JsonProperty("TaxId5")
            protected String taxId5;
            @JsonProperty("TaxId6")
            protected String taxId6;
            @JsonProperty("TaxId7")
            protected String taxId7;
            @JsonProperty("TaxId8")
            protected String taxId8;
            @JsonProperty("TaxId9")
            protected String taxId9;
            @JsonProperty("TaxId10")
            protected String taxId10;
            @JsonProperty("TaxId11")
            protected String taxId11;
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("AddrType")
            protected String addrType;
            @JsonProperty("TaxId12")
            protected String taxId12;
            @JsonProperty("TaxId13")
            protected String taxId13;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Long getCnaeCode() {
                return cnaeCode;
            }

            public void setCnaeCode(Long cnaeCode) {
                this.cnaeCode = cnaeCode;
            }

            public String getTaxId0() {
                return taxId0;
            }

            public void setTaxId0(String taxId0) {
                this.taxId0 = taxId0;
            }

            public String getTaxId1() {
                return taxId1;
            }

            public void setTaxId1(String taxId1) {
                this.taxId1 = taxId1;
            }

            public String getTaxId2() {
                return taxId2;
            }

            public void setTaxId2(String taxId2) {
                this.taxId2 = taxId2;
            }

            public String getTaxId3() {
                return taxId3;
            }

            public void setTaxId3(String taxId3) {
                this.taxId3 = taxId3;
            }

            public String getTaxId4() {
                return taxId4;
            }

            public void setTaxId4(String taxId4) {
                this.taxId4 = taxId4;
            }

            public String getTaxId5() {
                return taxId5;
            }

            public void setTaxId5(String taxId5) {
                this.taxId5 = taxId5;
            }

            public String getTaxId6() {
                return taxId6;
            }

            public void setTaxId6(String taxId6) {
                this.taxId6 = taxId6;
            }

            public String getTaxId7() {
                return taxId7;
            }

            public void setTaxId7(String taxId7) {
                this.taxId7 = taxId7;
            }

            public String getTaxId8() {
                return taxId8;
            }

            public void setTaxId8(String taxId8) {
                this.taxId8 = taxId8;
            }

            public String getTaxId9() {
                return taxId9;
            }

            public void setTaxId9(String taxId9) {
                this.taxId9 = taxId9;
            }

            public String getTaxId10() {
                return taxId10;
            }

            public void setTaxId10(String taxId10) {
                this.taxId10 = taxId10;
            }

            public String getTaxId11() {
                return taxId11;
            }

            public void setTaxId11(String taxId11) {
                this.taxId11 = taxId11;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }

            public String getAddrType() {
                return addrType;
            }

            public void setAddrType(String addrType) {
                this.addrType = addrType;
            }

            public String getTaxId12() {
                return taxId12;
            }

            public void setTaxId12(String taxId12) {
                this.taxId12 = taxId12;
            }

            public String getTaxId13() {
                return taxId13;
            }

            public void setTaxId13(String taxId13) {
                this.taxId13 = taxId13;
            }
        }
    }

    public static class DiscountGroups {
        public static class DiscountGroup {
            @JsonProperty("ObjectEntry")
            protected String objectEntry;
            @JsonProperty("DiscountPercentage")
            protected Double discountPercentage;
            @JsonProperty("BPCode")
            protected String bpCode;
            @JsonProperty("BaseObjectType")
            protected String baseObjectType;

            public String getObjectEntry() {
                return objectEntry;
            }

            public void setObjectEntry(String objectEntry) {
                this.objectEntry = objectEntry;
            }

            public Double getDiscountPercentage() {
                return discountPercentage;
            }

            public void setDiscountPercentage(Double discountPercentage) {
                this.discountPercentage = discountPercentage;
            }

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }

            public String getBaseObjectType() {
                return baseObjectType;
            }

            public void setBaseObjectType(String baseObjectType) {
                this.baseObjectType = baseObjectType;
            }
        }
    }

    public static class BPIntrastatExtension {
        @JsonProperty("CardCode")
        protected String cardCode;
        @JsonProperty("TransportMode")
        protected Long transportMode;
        @JsonProperty("Incoterms")
        protected Long incoterms;
        @JsonProperty("NatureOfTransactions")
        protected Long natureOfTransactions;
        @JsonProperty("StatisticalProcedure")
        protected Long statisticalProcedure;
        @JsonProperty("CustomsProcedure")
        protected Long customsProcedure;
        @JsonProperty("PortOfEntryOrExit")
        protected Long portOfEntryOrExit;
        @JsonProperty("DomesticOrForeignID")
        protected String domesticOrForeignID;
        @JsonProperty("IntrastatRelevant")
        protected String intrastatRelevant;

        public String getCardCode() {
            return cardCode;
        }

        public void setCardCode(String cardCode) {
            this.cardCode = cardCode;
        }

        public Long getTransportMode() {
            return transportMode;
        }

        public void setTransportMode(Long transportMode) {
            this.transportMode = transportMode;
        }

        public Long getIncoterms() {
            return incoterms;
        }

        public void setIncoterms(Long incoterms) {
            this.incoterms = incoterms;
        }

        public Long getNatureOfTransactions() {
            return natureOfTransactions;
        }

        public void setNatureOfTransactions(Long natureOfTransactions) {
            this.natureOfTransactions = natureOfTransactions;
        }

        public Long getStatisticalProcedure() {
            return statisticalProcedure;
        }

        public void setStatisticalProcedure(Long statisticalProcedure) {
            this.statisticalProcedure = statisticalProcedure;
        }

        public Long getCustomsProcedure() {
            return customsProcedure;
        }

        public void setCustomsProcedure(Long customsProcedure) {
            this.customsProcedure = customsProcedure;
        }

        public Long getPortOfEntryOrExit() {
            return portOfEntryOrExit;
        }

        public void setPortOfEntryOrExit(Long portOfEntryOrExit) {
            this.portOfEntryOrExit = portOfEntryOrExit;
        }

        public String getDomesticOrForeignID() {
            return domesticOrForeignID;
        }

        public void setDomesticOrForeignID(String domesticOrForeignID) {
            this.domesticOrForeignID = domesticOrForeignID;
        }

        public String getIntrastatRelevant() {
            return intrastatRelevant;
        }

        public void setIntrastatRelevant(String intrastatRelevant) {
            this.intrastatRelevant = intrastatRelevant;
        }
    }
}
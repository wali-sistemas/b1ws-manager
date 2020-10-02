
package co.manager.b1ws.businessPartners;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="cCustomer"/>
 *               &lt;enumeration value="cSupplier"/>
 *               &lt;enumeration value="cLid"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GroupCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ContactPerson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayTermsGrpCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CreditLimit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="MaxCommitment" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VatLiable" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="vExempted"/>
 *               &lt;enumeration value="vLiable"/>
 *               &lt;enumeration value="vEC"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FederalTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DeductibleAtSource" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeductionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DeductionValidUntil" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="PriceListNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="IntrestRatePercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CommissionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CommissionGroupCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FreeText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SalesPersonCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RateDiffAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cellular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AvarageLate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailCounty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MailCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EmailAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Picture" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AdditionalID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FatherCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardForeignName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FatherType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="cPayments_sum"/>
 *               &lt;enumeration value="cDelivery_sum"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeductionOffice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExportCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MinIntrest" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CurrentAccountBalance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="OpenDeliveryNotesBalance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="OpenOrdersBalance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VatGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Indicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCardCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="CreditCardNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CreditCardExpiration" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="DebitorAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OpenOpportunities" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Valid" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ValidFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ValidTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ValidRemarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Frozen" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FrozenFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FrozenTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="FrozenRemarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExemptNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Priority" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="FormCode1099" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Box1099" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PeymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BackOrder" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PartialDelivery" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BlockDunning" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseBank" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseBankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseBankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShipToDefault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DunningLevel" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DunningDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CollectionAuthorization" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DME" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InstructionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SinglePayment" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ISRBillerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentBlock" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReferenceDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="HouseBankBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OwnerIDNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentBlockDescription" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TaxExemptionLetterNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MaxAmountOfExemption" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ExemptionValidityDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="ExemptionValidityDateTo" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LinkedBusinessPartner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LastMultiReconciliationNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DeferredTax" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Equalization" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SubjectToWithholdingTax" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CertificateNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpirationDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="NationalInsuranceNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccrualCriteria" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillToBuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DownPaymentClearAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ChannelBP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultTechnician" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BilltoDefault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerBillofExchangDisc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Territory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ShipToBuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomerBillofExchangPres" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VatGroupLatinAmerica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DunningTerm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Website" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OtherReceivablePayable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillofExchangeonCollection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CompanyPrivate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="cCompany"/>
 *               &lt;enumeration value="cPrivate"/>
 *               &lt;enumeration value="cGovernment"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LanguageCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="UnpaidBillofExchange" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WithholdingTaxDeductionGroup" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ClosingDateProcedureNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Profession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankChargesAllocationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TaxRoundingRule" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="trr_RoundDown"/>
 *               &lt;enumeration value="trr_RoundUp"/>
 *               &lt;enumeration value="trr_RoundOff"/>
 *               &lt;enumeration value="trr_CompanyDefault"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties1" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties2" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties3" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties4" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties5" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties6" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties7" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties8" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties9" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties10" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties11" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties12" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties13" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties14" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties15" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties16" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties17" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties18" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties19" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties20" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties21" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties22" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties23" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties24" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties25" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties26" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties27" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties28" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties29" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties30" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties31" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties32" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties33" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties34" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties35" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties36" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties37" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties38" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties39" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties40" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties41" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties42" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties43" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties44" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties45" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties46" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties47" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties48" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties49" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties50" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties51" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties52" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties53" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties54" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties55" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties56" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties57" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties58" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties59" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties60" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties61" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties62" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties63" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Properties64" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CompanyRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VerificationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscountBaseObject" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="dgboNone"/>
 *               &lt;enumeration value="dgboItemGroups"/>
 *               &lt;enumeration value="dgboItemProperties"/>
 *               &lt;enumeration value="dgboManufacturer"/>
 *               &lt;enumeration value="dgboItems"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DiscountRelations" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="dgrLowestDiscount"/>
 *               &lt;enumeration value="dgrHighestDiscount"/>
 *               &lt;enumeration value="dgrAverageDiscount"/>
 *               &lt;enumeration value="dgrDiscountTotals"/>
 *               &lt;enumeration value="dgrMultipliedDiscount"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TypeReport" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="atCompany"/>
 *               &lt;enumeration value="atOthers"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ThresholdOverlook" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SurchargeOverlook" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DownPaymentInterimAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OperationCode347" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ocGoodsOrServiciesAcquisitions"/>
 *               &lt;enumeration value="ocPublicEntitiesAcquisitions"/>
 *               &lt;enumeration value="ocTravelAgenciesPurchases"/>
 *               &lt;enumeration value="ocSalesOrServicesRevenues"/>
 *               &lt;enumeration value="ocPublicSubsidies"/>
 *               &lt;enumeration value="ocTravelAgenciesSales"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InsuranceOperation347" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HierarchicalDeduction" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ShaamGroup" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="sgServicesAndAsset"/>
 *               &lt;enumeration value="sgAgriculturalProducts"/>
 *               &lt;enumeration value="sgInsuranceCommissions"/>
 *               &lt;enumeration value="sgWHTaxInstructions"/>
 *               &lt;enumeration value="sgInterestExchangeRateDiffs"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="WithholdingTaxCertified" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BookkeepingCertified" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PlanningGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Affiliate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Industry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="VatIDNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DatevAccount" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DatevFirstDataEntry" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GTSRegNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GTSBankAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="GTSBillingAddrTel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ETaxWebSite" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="HouseBankIBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VATRegistrationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RepresentativeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IndustryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BusinessType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Series" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AutomaticPosting" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="apNo"/>
 *               &lt;enumeration value="apInterestAndFee"/>
 *               &lt;enumeration value="apInterestOnly"/>
 *               &lt;enumeration value="apFeeOnly"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="InterestAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FeeAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CampaignNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="AliasName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DefaultBlanketAgreementNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="EffectiveDiscount" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="dgrLowestDiscount"/>
 *               &lt;enumeration value="dgrHighestDiscount"/>
 *               &lt;enumeration value="dgrAverageDiscount"/>
 *               &lt;enumeration value="dgrDiscountTotals"/>
 *               &lt;enumeration value="dgrMultipliedDiscount"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NoDiscounts" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="GlobalLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDISenderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EDIRecipientID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ResidenNumber" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="rntSpanishFiscalID"/>
 *               &lt;enumeration value="rntVATRegistrationNumber"/>
 *               &lt;enumeration value="rntPassport"/>
 *               &lt;enumeration value="rntFiscalIDIssuedbytheResidenceCountry"/>
 *               &lt;enumeration value="rntCertificateofFiscalResidence"/>
 *               &lt;enumeration value="rntOtherDocument"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="RelationshipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="RelationshipDateFrom" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="RelationshipDateTill" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="UnifiedFederalTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AttachmentEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="TypeOfOperation" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tooProfessionalServices"/>
 *               &lt;enumeration value="tooRentingAssets"/>
 *               &lt;enumeration value="tooOthers"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="U_BD_Erst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BD_Datev" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_RTC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_TDC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_CS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_TP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_Nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_1Apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_2Apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_BPExt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_TBPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_BPCO_Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_Manejo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_FEC_CREA" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="U_TRASP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_TIEMPO_TRA" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_PROM_DIAS_PAGO" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="U_VLGX_VIV" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_VLGX_LT" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_VLGX_OF" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_VLGX_PLC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_VLGX_VFQ" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_VLGX_VFW" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_VLGX_VFM" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_VLGX_VFV" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="U_EsAutorret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="U_OK1_AC_ECO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BPAddresses" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPAddress" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="AddressName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="FederalTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AddressType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="bo_ShipTo"/>
 *                                   &lt;enumeration value="bo_BillTo"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="AddressName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AddressName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TypeOfAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="StreetNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RowNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="GlobalLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="U_Municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ContactEmployees" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ContactEmployee" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="E_Mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Pager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Remarks1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Remarks2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="InternalCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="PlaceOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="Gender" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="gt_Female"/>
 *                                   &lt;enumeration value="gt_Male"/>
 *                                   &lt;enumeration value="gt_Undefined"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Profession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CityOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Active" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="tNO"/>
 *                                   &lt;enumeration value="tYES"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="EmailGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPAccountReceivablePaybleCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPAccountReceivablePayble" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="AccountType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="bpat_General"/>
 *                                   &lt;enumeration value="bpat_DownPayment"/>
 *                                   &lt;enumeration value="bpat_AssetsAccount"/>
 *                                   &lt;enumeration value="bpat_Receivable"/>
 *                                   &lt;enumeration value="bpat_Payable"/>
 *                                   &lt;enumeration value="bpat_OnCollection"/>
 *                                   &lt;enumeration value="bpat_Presentation"/>
 *                                   &lt;enumeration value="bpat_AssetsPayable"/>
 *                                   &lt;enumeration value="bpat_Discounted"/>
 *                                   &lt;enumeration value="bpat_Unpaid"/>
 *                                   &lt;enumeration value="bpat_OpenDebts"/>
 *                                   &lt;enumeration value="bpat_Domestic"/>
 *                                   &lt;enumeration value="bpat_Foreign"/>
 *                                   &lt;enumeration value="bpat_CashDiscountInterim"/>
 *                                   &lt;enumeration value="bpat_ExchangeRateInterim"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPPaymentMethods" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPPaymentMethod" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="RowNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPWithholdingTaxCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPWithholdingTax" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="WTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPPaymentDates" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPPaymentDate" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPBranchAssignment" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPBranchAssignmentItem" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPLID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPBankAccounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPBankAccount" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="LogInstance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="UserNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="UserNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ControlKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="UserNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="UserNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="InternalKey" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BIK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CorrespondentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CustomerIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ISRBillerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ISRType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="BICSwiftCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ABARoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="MandateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SignatureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="MandateExpDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="SEPASeqType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="sstOOFF"/>
 *                                   &lt;enumeration value="sstFRST"/>
 *                                   &lt;enumeration value="sstRCUR"/>
 *                                   &lt;enumeration value="sstFNAL"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPFiscalTaxIDCollection" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="BPFiscalTaxID" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CNAECode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="TaxId0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AddrType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="bo_ShipTo"/>
 *                                   &lt;enumeration value="bo_BillTo"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="TaxId12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TaxId13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="DiscountGroups" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DiscountGroup" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="ObjectEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="BaseObjectType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="dgboNone"/>
 *                                   &lt;enumeration value="dgboItemGroups"/>
 *                                   &lt;enumeration value="dgboItemProperties"/>
 *                                   &lt;enumeration value="dgboManufacturer"/>
 *                                   &lt;enumeration value="dgboItems"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/all>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BPIntrastatExtension" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="TransportMode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="Incoterms" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="NatureOfTransactions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="StatisticalProcedure" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="CustomsProcedure" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="PortOfEntryOrExit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="DomesticOrForeignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="IntrastatRelevant" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="tNO"/>
 *                         &lt;enumeration value="tYES"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "BusinessPartner")
public class BusinessPartner {

    @XmlElement(name = "CardCode")
    protected String cardCode;
    @XmlElement(name = "CardName")
    protected String cardName;
    @XmlElement(name = "CardType")
    protected String cardType;
    @XmlElement(name = "GroupCode")
    protected Long groupCode;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "ZipCode")
    protected String zipCode;
    @XmlElement(name = "MailAddress")
    protected String mailAddress;
    @XmlElement(name = "MailZipCode")
    protected String mailZipCode;
    @XmlElement(name = "Phone1")
    protected String phone1;
    @XmlElement(name = "Phone2")
    protected String phone2;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "ContactPerson")
    protected String contactPerson;
    @XmlElement(name = "Notes")
    protected String notes;
    @XmlElement(name = "PayTermsGrpCode")
    protected Long payTermsGrpCode;
    @XmlElement(name = "CreditLimit")
    protected Double creditLimit;
    @XmlElement(name = "MaxCommitment")
    protected Double maxCommitment;
    @XmlElement(name = "DiscountPercent")
    protected Double discountPercent;
    @XmlElement(name = "VatLiable")
    protected String vatLiable;
    @XmlElement(name = "FederalTaxID")
    protected String federalTaxID;
    @XmlElement(name = "DeductibleAtSource")
    protected String deductibleAtSource;
    @XmlElement(name = "DeductionPercent")
    protected Double deductionPercent;
    @XmlElement(name = "DeductionValidUntil")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar deductionValidUntil;
    @XmlElement(name = "PriceListNum")
    protected Long priceListNum;
    @XmlElement(name = "IntrestRatePercent")
    protected Double intrestRatePercent;
    @XmlElement(name = "CommissionPercent")
    protected Double commissionPercent;
    @XmlElement(name = "CommissionGroupCode")
    protected Long commissionGroupCode;
    @XmlElement(name = "FreeText")
    protected String freeText;
    @XmlElement(name = "SalesPersonCode")
    protected Long salesPersonCode;
    @XmlElement(name = "Currency")
    protected String currency;
    @XmlElement(name = "RateDiffAccount")
    protected String rateDiffAccount;
    @XmlElement(name = "Cellular")
    protected String cellular;
    @XmlElement(name = "AvarageLate")
    protected Long avarageLate;
    @XmlElement(name = "City")
    protected String city;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "MailCity")
    protected String mailCity;
    @XmlElement(name = "MailCounty")
    protected String mailCounty;
    @XmlElement(name = "MailCountry")
    protected String mailCountry;
    @XmlElement(name = "EmailAddress")
    protected String emailAddress;
    @XmlElement(name = "Picture")
    protected String picture;
    @XmlElement(name = "DefaultAccount")
    protected String defaultAccount;
    @XmlElement(name = "DefaultBranch")
    protected String defaultBranch;
    @XmlElement(name = "DefaultBankCode")
    protected String defaultBankCode;
    @XmlElement(name = "AdditionalID")
    protected String additionalID;
    @XmlElement(name = "Pager")
    protected String pager;
    @XmlElement(name = "FatherCard")
    protected String fatherCard;
    @XmlElement(name = "CardForeignName")
    protected String cardForeignName;
    @XmlElement(name = "FatherType")
    protected String fatherType;
    @XmlElement(name = "DeductionOffice")
    protected String deductionOffice;
    @XmlElement(name = "ExportCode")
    protected String exportCode;
    @XmlElement(name = "MinIntrest")
    protected Double minIntrest;
    @XmlElement(name = "CurrentAccountBalance")
    protected Double currentAccountBalance;
    @XmlElement(name = "OpenDeliveryNotesBalance")
    protected Double openDeliveryNotesBalance;
    @XmlElement(name = "OpenOrdersBalance")
    protected Double openOrdersBalance;
    @XmlElement(name = "VatGroup")
    protected String vatGroup;
    @XmlElement(name = "ShippingType")
    protected Long shippingType;
    @XmlElement(name = "Password")
    protected String password;
    @XmlElement(name = "Indicator")
    protected String indicator;
    @XmlElement(name = "IBAN")
    protected String iban;
    @XmlElement(name = "CreditCardCode")
    protected Long creditCardCode;
    @XmlElement(name = "CreditCardNum")
    protected String creditCardNum;
    @XmlElement(name = "CreditCardExpiration")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar creditCardExpiration;
    @XmlElement(name = "DebitorAccount")
    protected String debitorAccount;
    @XmlElement(name = "OpenOpportunities")
    protected Long openOpportunities;
    @XmlElement(name = "Valid")
    protected String valid;
    @XmlElement(name = "ValidFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validFrom;
    @XmlElement(name = "ValidTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar validTo;
    @XmlElement(name = "ValidRemarks")
    protected String validRemarks;
    @XmlElement(name = "Frozen")
    protected String frozen;
    @XmlElement(name = "FrozenFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frozenFrom;
    @XmlElement(name = "FrozenTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar frozenTo;
    @XmlElement(name = "FrozenRemarks")
    protected String frozenRemarks;
    @XmlElement(name = "Block")
    protected String block;
    @XmlElement(name = "BillToState")
    protected String billToState;
    @XmlElement(name = "ExemptNum")
    protected String exemptNum;
    @XmlElement(name = "Priority")
    protected Long priority;
    @XmlElement(name = "FormCode1099")
    protected Long formCode1099;
    @XmlElement(name = "Box1099")
    protected String box1099;
    @XmlElement(name = "PeymentMethodCode")
    protected String peymentMethodCode;
    @XmlElement(name = "BackOrder")
    protected String backOrder;
    @XmlElement(name = "PartialDelivery")
    protected String partialDelivery;
    @XmlElement(name = "BlockDunning")
    protected String blockDunning;
    @XmlElement(name = "BankCountry")
    protected String bankCountry;
    @XmlElement(name = "HouseBank")
    protected String houseBank;
    @XmlElement(name = "HouseBankCountry")
    protected String houseBankCountry;
    @XmlElement(name = "HouseBankAccount")
    protected String houseBankAccount;
    @XmlElement(name = "ShipToDefault")
    protected String shipToDefault;
    @XmlElement(name = "DunningLevel")
    protected Long dunningLevel;
    @XmlElement(name = "DunningDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dunningDate;
    @XmlElement(name = "CollectionAuthorization")
    protected String collectionAuthorization;
    @XmlElement(name = "DME")
    protected String dme;
    @XmlElement(name = "InstructionKey")
    protected String instructionKey;
    @XmlElement(name = "SinglePayment")
    protected String singlePayment;
    @XmlElement(name = "ISRBillerID")
    protected String isrBillerID;
    @XmlElement(name = "PaymentBlock")
    protected String paymentBlock;
    @XmlElement(name = "ReferenceDetails")
    protected String referenceDetails;
    @XmlElement(name = "HouseBankBranch")
    protected String houseBankBranch;
    @XmlElement(name = "OwnerIDNumber")
    protected String ownerIDNumber;
    @XmlElement(name = "PaymentBlockDescription")
    protected Long paymentBlockDescription;
    @XmlElement(name = "TaxExemptionLetterNum")
    protected String taxExemptionLetterNum;
    @XmlElement(name = "MaxAmountOfExemption")
    protected Double maxAmountOfExemption;
    @XmlElement(name = "ExemptionValidityDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar exemptionValidityDateFrom;
    @XmlElement(name = "ExemptionValidityDateTo")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar exemptionValidityDateTo;
    @XmlElement(name = "LinkedBusinessPartner")
    protected String linkedBusinessPartner;
    @XmlElement(name = "LastMultiReconciliationNum")
    protected Long lastMultiReconciliationNum;
    @XmlElement(name = "DeferredTax")
    protected String deferredTax;
    @XmlElement(name = "Equalization")
    protected String equalization;
    @XmlElement(name = "SubjectToWithholdingTax")
    protected String subjectToWithholdingTax;
    @XmlElement(name = "CertificateNumber")
    protected String certificateNumber;
    @XmlElement(name = "ExpirationDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expirationDate;
    @XmlElement(name = "NationalInsuranceNum")
    protected String nationalInsuranceNum;
    @XmlElement(name = "AccrualCriteria")
    protected String accrualCriteria;
    @XmlElement(name = "WTCode")
    protected String wtCode;
    @XmlElement(name = "BillToBuildingFloorRoom")
    protected String billToBuildingFloorRoom;
    @XmlElement(name = "DownPaymentClearAct")
    protected String downPaymentClearAct;
    @XmlElement(name = "ChannelBP")
    protected String channelBP;
    @XmlElement(name = "DefaultTechnician")
    protected Long defaultTechnician;
    @XmlElement(name = "BilltoDefault")
    protected String billtoDefault;
    @XmlElement(name = "CustomerBillofExchangDisc")
    protected String customerBillofExchangDisc;
    @XmlElement(name = "Territory")
    protected Long territory;
    @XmlElement(name = "ShipToBuildingFloorRoom")
    protected String shipToBuildingFloorRoom;
    @XmlElement(name = "CustomerBillofExchangPres")
    protected String customerBillofExchangPres;
    @XmlElement(name = "ProjectCode")
    protected String projectCode;
    @XmlElement(name = "VatGroupLatinAmerica")
    protected String vatGroupLatinAmerica;
    @XmlElement(name = "DunningTerm")
    protected String dunningTerm;
    @XmlElement(name = "Website")
    protected String website;
    @XmlElement(name = "OtherReceivablePayable")
    protected String otherReceivablePayable;
    @XmlElement(name = "BillofExchangeonCollection")
    protected String billofExchangeonCollection;
    @XmlElement(name = "CompanyPrivate")
    protected String companyPrivate;
    @XmlElement(name = "LanguageCode")
    protected Long languageCode;
    @XmlElement(name = "UnpaidBillofExchange")
    protected String unpaidBillofExchange;
    @XmlElement(name = "WithholdingTaxDeductionGroup")
    protected Long withholdingTaxDeductionGroup;
    @XmlElement(name = "ClosingDateProcedureNumber")
    protected Long closingDateProcedureNumber;
    @XmlElement(name = "Profession")
    protected String profession;
    @XmlElement(name = "BankChargesAllocationCode")
    protected String bankChargesAllocationCode;
    @XmlElement(name = "TaxRoundingRule")
    protected String taxRoundingRule;
    @XmlElement(name = "Properties1")
    protected String properties1;
    @XmlElement(name = "Properties2")
    protected String properties2;
    @XmlElement(name = "Properties3")
    protected String properties3;
    @XmlElement(name = "Properties4")
    protected String properties4;
    @XmlElement(name = "Properties5")
    protected String properties5;
    @XmlElement(name = "Properties6")
    protected String properties6;
    @XmlElement(name = "Properties7")
    protected String properties7;
    @XmlElement(name = "Properties8")
    protected String properties8;
    @XmlElement(name = "Properties9")
    protected String properties9;
    @XmlElement(name = "Properties10")
    protected String properties10;
    @XmlElement(name = "Properties11")
    protected String properties11;
    @XmlElement(name = "Properties12")
    protected String properties12;
    @XmlElement(name = "Properties13")
    protected String properties13;
    @XmlElement(name = "Properties14")
    protected String properties14;
    @XmlElement(name = "Properties15")
    protected String properties15;
    @XmlElement(name = "Properties16")
    protected String properties16;
    @XmlElement(name = "Properties17")
    protected String properties17;
    @XmlElement(name = "Properties18")
    protected String properties18;
    @XmlElement(name = "Properties19")
    protected String properties19;
    @XmlElement(name = "Properties20")
    protected String properties20;
    @XmlElement(name = "Properties21")
    protected String properties21;
    @XmlElement(name = "Properties22")
    protected String properties22;
    @XmlElement(name = "Properties23")
    protected String properties23;
    @XmlElement(name = "Properties24")
    protected String properties24;
    @XmlElement(name = "Properties25")
    protected String properties25;
    @XmlElement(name = "Properties26")
    protected String properties26;
    @XmlElement(name = "Properties27")
    protected String properties27;
    @XmlElement(name = "Properties28")
    protected String properties28;
    @XmlElement(name = "Properties29")
    protected String properties29;
    @XmlElement(name = "Properties30")
    protected String properties30;
    @XmlElement(name = "Properties31")
    protected String properties31;
    @XmlElement(name = "Properties32")
    protected String properties32;
    @XmlElement(name = "Properties33")
    protected String properties33;
    @XmlElement(name = "Properties34")
    protected String properties34;
    @XmlElement(name = "Properties35")
    protected String properties35;
    @XmlElement(name = "Properties36")
    protected String properties36;
    @XmlElement(name = "Properties37")
    protected String properties37;
    @XmlElement(name = "Properties38")
    protected String properties38;
    @XmlElement(name = "Properties39")
    protected String properties39;
    @XmlElement(name = "Properties40")
    protected String properties40;
    @XmlElement(name = "Properties41")
    protected String properties41;
    @XmlElement(name = "Properties42")
    protected String properties42;
    @XmlElement(name = "Properties43")
    protected String properties43;
    @XmlElement(name = "Properties44")
    protected String properties44;
    @XmlElement(name = "Properties45")
    protected String properties45;
    @XmlElement(name = "Properties46")
    protected String properties46;
    @XmlElement(name = "Properties47")
    protected String properties47;
    @XmlElement(name = "Properties48")
    protected String properties48;
    @XmlElement(name = "Properties49")
    protected String properties49;
    @XmlElement(name = "Properties50")
    protected String properties50;
    @XmlElement(name = "Properties51")
    protected String properties51;
    @XmlElement(name = "Properties52")
    protected String properties52;
    @XmlElement(name = "Properties53")
    protected String properties53;
    @XmlElement(name = "Properties54")
    protected String properties54;
    @XmlElement(name = "Properties55")
    protected String properties55;
    @XmlElement(name = "Properties56")
    protected String properties56;
    @XmlElement(name = "Properties57")
    protected String properties57;
    @XmlElement(name = "Properties58")
    protected String properties58;
    @XmlElement(name = "Properties59")
    protected String properties59;
    @XmlElement(name = "Properties60")
    protected String properties60;
    @XmlElement(name = "Properties61")
    protected String properties61;
    @XmlElement(name = "Properties62")
    protected String properties62;
    @XmlElement(name = "Properties63")
    protected String properties63;
    @XmlElement(name = "Properties64")
    protected String properties64;
    @XmlElement(name = "CompanyRegistrationNumber")
    protected String companyRegistrationNumber;
    @XmlElement(name = "VerificationNumber")
    protected String verificationNumber;
    @XmlElement(name = "DiscountBaseObject")
    protected String discountBaseObject;
    @XmlElement(name = "DiscountRelations")
    protected String discountRelations;
    @XmlElement(name = "TypeReport")
    protected String typeReport;
    @XmlElement(name = "ThresholdOverlook")
    protected String thresholdOverlook;
    @XmlElement(name = "SurchargeOverlook")
    protected String surchargeOverlook;
    @XmlElement(name = "DownPaymentInterimAccount")
    protected String downPaymentInterimAccount;
    @XmlElement(name = "OperationCode347")
    protected String operationCode347;
    @XmlElement(name = "InsuranceOperation347")
    protected String insuranceOperation347;
    @XmlElement(name = "HierarchicalDeduction")
    protected String hierarchicalDeduction;
    @XmlElement(name = "ShaamGroup")
    protected String shaamGroup;
    @XmlElement(name = "WithholdingTaxCertified")
    protected String withholdingTaxCertified;
    @XmlElement(name = "BookkeepingCertified")
    protected String bookkeepingCertified;
    @XmlElement(name = "PlanningGroup")
    protected String planningGroup;
    @XmlElement(name = "Affiliate")
    protected String affiliate;
    @XmlElement(name = "Industry")
    protected Long industry;
    @XmlElement(name = "VatIDNum")
    protected String vatIDNum;
    @XmlElement(name = "DatevAccount")
    protected Long datevAccount;
    @XmlElement(name = "DatevFirstDataEntry")
    protected String datevFirstDataEntry;
    @XmlElement(name = "GTSRegNo")
    protected String gtsRegNo;
    @XmlElement(name = "GTSBankAccountNo")
    protected String gtsBankAccountNo;
    @XmlElement(name = "GTSBillingAddrTel")
    protected String gtsBillingAddrTel;
    @XmlElement(name = "ETaxWebSite")
    protected Long eTaxWebSite;
    @XmlElement(name = "HouseBankIBAN")
    protected String houseBankIBAN;
    @XmlElement(name = "VATRegistrationNumber")
    protected String vatRegistrationNumber;
    @XmlElement(name = "RepresentativeName")
    protected String representativeName;
    @XmlElement(name = "IndustryType")
    protected String industryType;
    @XmlElement(name = "BusinessType")
    protected String businessType;
    @XmlElement(name = "Series")
    protected Long series;
    @XmlElement(name = "AutomaticPosting")
    protected String automaticPosting;
    @XmlElement(name = "InterestAccount")
    protected String interestAccount;
    @XmlElement(name = "FeeAccount")
    protected String feeAccount;
    @XmlElement(name = "CampaignNumber")
    protected Long campaignNumber;
    @XmlElement(name = "AliasName")
    protected String aliasName;
    @XmlElement(name = "DefaultBlanketAgreementNumber")
    protected Long defaultBlanketAgreementNumber;
    @XmlElement(name = "EffectiveDiscount")
    protected String effectiveDiscount;
    @XmlElement(name = "NoDiscounts")
    protected String noDiscounts;
    @XmlElement(name = "GlobalLocationNumber")
    protected String globalLocationNumber;
    @XmlElement(name = "EDISenderID")
    protected String ediSenderID;
    @XmlElement(name = "EDIRecipientID")
    protected String ediRecipientID;
    @XmlElement(name = "ResidenNumber")
    protected String residenNumber;
    @XmlElement(name = "RelationshipCode")
    protected String relationshipCode;
    @XmlElement(name = "RelationshipDateFrom")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar relationshipDateFrom;
    @XmlElement(name = "RelationshipDateTill")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar relationshipDateTill;
    @XmlElement(name = "UnifiedFederalTaxID")
    protected String unifiedFederalTaxID;
    @XmlElement(name = "AttachmentEntry")
    protected Long attachmentEntry;
    @XmlElement(name = "TypeOfOperation")
    protected String typeOfOperation;
    @XmlElement(name = "U_BD_Erst")
    protected String ubdErst;
    @XmlElement(name = "U_BD_Datev")
    protected String ubdDatev;
    @XmlElement(name = "U_BPCO_RTC")
    protected String ubpcortc;
    @XmlElement(name = "U_BPCO_TDC")
    protected String ubpcotdc;
    @XmlElement(name = "U_BPCO_CS")
    protected String ubpcocs;
    @XmlElement(name = "U_BPCO_City")
    protected String ubpcoCity;
    @XmlElement(name = "U_BPCO_TP")
    protected String ubpcotp;
    @XmlElement(name = "U_BPCO_Nombre")
    protected String ubpcoNombre;
    @XmlElement(name = "U_BPCO_1Apellido")
    protected String ubpco1Apellido;
    @XmlElement(name = "U_BPCO_2Apellido")
    protected String ubpco2Apellido;
    @XmlElement(name = "U_BPCO_BPExt")
    protected String ubpcobpExt;
    @XmlElement(name = "U_BPCO_TBPE")
    protected String ubpcotbpe;
    @XmlElement(name = "U_BPCO_Address")
    protected String ubpcoAddress;
    @XmlElement(name = "U_Manejo")
    protected String uManejo;
    @XmlElement(name = "U_FEC_CREA")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar ufeccrea;
    @XmlElement(name = "U_TRASP")
    protected String utrasp;
    @XmlElement(name = "U_TIEMPO_TRA")
    protected Long utiempotra;
    @XmlElement(name = "U_PROM_DIAS_PAGO")
    protected Double upromdiaspago;
    @XmlElement(name = "U_VLGX_VIV")
    protected String uvlgxviv;
    @XmlElement(name = "U_VLGX_LT")
    protected Long uvlgxlt;
    @XmlElement(name = "U_VLGX_OF")
    protected Long uvlgxof;
    @XmlElement(name = "U_VLGX_PLC")
    protected String uvlgxplc;
    @XmlElement(name = "U_VLGX_VFQ")
    protected Long uvlgxvfq;
    @XmlElement(name = "U_VLGX_VFW")
    protected Long uvlgxvfw;
    @XmlElement(name = "U_VLGX_VFM")
    protected Long uvlgxvfm;
    @XmlElement(name = "U_VLGX_VFV")
    protected Long uvlgxvfv;
    @XmlElement(name = "U_EsAutorret")
    protected String uEsAutorret;
    @XmlElement(name = "U_OK1_AC_ECO")
    protected String uok1ACECO;
    @XmlElement(name = "U_DocFormEnt")
    protected Long uDocFormEntFE;
    @XmlElement(name = "U_addInFaElectronica_email_contacto_FE")
    protected String uAddInFaElectronicaEmailContactoFE;
    @XmlElement(name = "U_Celular")
    protected String uCelularFE;
    @XmlElement(name = "BPAddresses")
    protected BusinessPartner.BPAddresses bpAddresses;
    @XmlElement(name = "ContactEmployees")
    protected BusinessPartner.ContactEmployees contactEmployees;
    @XmlElement(name = "BPAccountReceivablePaybleCollection")
    protected BusinessPartner.BPAccountReceivablePaybleCollection bpAccountReceivablePaybleCollection;
    @XmlElement(name = "BPPaymentMethods")
    protected BusinessPartner.BPPaymentMethods bpPaymentMethods;
    @XmlElement(name = "BPWithholdingTaxCollection")
    protected BusinessPartner.BPWithholdingTaxCollection bpWithholdingTaxCollection;
    @XmlElement(name = "BPPaymentDates")
    protected BusinessPartner.BPPaymentDates bpPaymentDates;
    @XmlElement(name = "BPBranchAssignment")
    protected BusinessPartner.BPBranchAssignment bpBranchAssignment;
    @XmlElement(name = "BPBankAccounts")
    protected BusinessPartner.BPBankAccounts bpBankAccounts;
    @XmlElement(name = "BPFiscalTaxIDCollection")
    protected BusinessPartner.BPFiscalTaxIDCollection bpFiscalTaxIDCollection;
    @XmlElement(name = "DiscountGroups")
    protected BusinessPartner.DiscountGroups discountGroups;
    @XmlElement(name = "BPIntrastatExtension")
    protected BusinessPartner.BPIntrastatExtension bpIntrastatExtension;

    /**
     * Obtiene el valor de la propiedad cardCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * Define el valor de la propiedad cardCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardCode(String value) {
        this.cardCode = value;
    }

    /**
     * Obtiene el valor de la propiedad cardName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * Define el valor de la propiedad cardName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardName(String value) {
        this.cardName = value;
    }

    /**
     * Obtiene el valor de la propiedad cardType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Define el valor de la propiedad cardType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Obtiene el valor de la propiedad groupCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGroupCode() {
        return groupCode;
    }

    /**
     * Define el valor de la propiedad groupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGroupCode(Long value) {
        this.groupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define el valor de la propiedad address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Obtiene el valor de la propiedad zipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Define el valor de la propiedad zipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Obtiene el valor de la propiedad mailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * Define el valor de la propiedad mailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailAddress(String value) {
        this.mailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad mailZipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailZipCode() {
        return mailZipCode;
    }

    /**
     * Define el valor de la propiedad mailZipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailZipCode(String value) {
        this.mailZipCode = value;
    }

    /**
     * Obtiene el valor de la propiedad phone1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone1() {
        return phone1;
    }

    /**
     * Define el valor de la propiedad phone1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone1(String value) {
        this.phone1 = value;
    }

    /**
     * Obtiene el valor de la propiedad phone2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone2() {
        return phone2;
    }

    /**
     * Define el valor de la propiedad phone2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone2(String value) {
        this.phone2 = value;
    }

    /**
     * Obtiene el valor de la propiedad fax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Define el valor de la propiedad fax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Obtiene el valor de la propiedad contactPerson.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * Define el valor de la propiedad contactPerson.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactPerson(String value) {
        this.contactPerson = value;
    }

    /**
     * Obtiene el valor de la propiedad notes.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Define el valor de la propiedad notes.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

    /**
     * Obtiene el valor de la propiedad payTermsGrpCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPayTermsGrpCode() {
        return payTermsGrpCode;
    }

    /**
     * Define el valor de la propiedad payTermsGrpCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPayTermsGrpCode(Long value) {
        this.payTermsGrpCode = value;
    }

    /**
     * Obtiene el valor de la propiedad creditLimit.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCreditLimit() {
        return creditLimit;
    }

    /**
     * Define el valor de la propiedad creditLimit.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCreditLimit(Double value) {
        this.creditLimit = value;
    }

    /**
     * Obtiene el valor de la propiedad maxCommitment.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxCommitment() {
        return maxCommitment;
    }

    /**
     * Define el valor de la propiedad maxCommitment.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxCommitment(Double value) {
        this.maxCommitment = value;
    }

    /**
     * Obtiene el valor de la propiedad discountPercent.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDiscountPercent() {
        return discountPercent;
    }

    /**
     * Define el valor de la propiedad discountPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDiscountPercent(Double value) {
        this.discountPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad vatLiable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatLiable() {
        return vatLiable;
    }

    /**
     * Define el valor de la propiedad vatLiable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatLiable(String value) {
        this.vatLiable = value;
    }

    /**
     * Obtiene el valor de la propiedad federalTaxID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFederalTaxID() {
        return federalTaxID;
    }

    /**
     * Define el valor de la propiedad federalTaxID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFederalTaxID(String value) {
        this.federalTaxID = value;
    }

    /**
     * Obtiene el valor de la propiedad deductibleAtSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeductibleAtSource() {
        return deductibleAtSource;
    }

    /**
     * Define el valor de la propiedad deductibleAtSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeductibleAtSource(String value) {
        this.deductibleAtSource = value;
    }

    /**
     * Obtiene el valor de la propiedad deductionPercent.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeductionPercent() {
        return deductionPercent;
    }

    /**
     * Define el valor de la propiedad deductionPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeductionPercent(Double value) {
        this.deductionPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad deductionValidUntil.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDeductionValidUntil() {
        return deductionValidUntil;
    }

    /**
     * Define el valor de la propiedad deductionValidUntil.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDeductionValidUntil(XMLGregorianCalendar value) {
        this.deductionValidUntil = value;
    }

    /**
     * Obtiene el valor de la propiedad priceListNum.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriceListNum() {
        return priceListNum;
    }

    /**
     * Define el valor de la propiedad priceListNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriceListNum(Long value) {
        this.priceListNum = value;
    }

    /**
     * Obtiene el valor de la propiedad intrestRatePercent.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getIntrestRatePercent() {
        return intrestRatePercent;
    }

    /**
     * Define el valor de la propiedad intrestRatePercent.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setIntrestRatePercent(Double value) {
        this.intrestRatePercent = value;
    }

    /**
     * Obtiene el valor de la propiedad commissionPercent.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCommissionPercent() {
        return commissionPercent;
    }

    /**
     * Define el valor de la propiedad commissionPercent.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCommissionPercent(Double value) {
        this.commissionPercent = value;
    }

    /**
     * Obtiene el valor de la propiedad commissionGroupCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCommissionGroupCode() {
        return commissionGroupCode;
    }

    /**
     * Define el valor de la propiedad commissionGroupCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCommissionGroupCode(Long value) {
        this.commissionGroupCode = value;
    }

    /**
     * Obtiene el valor de la propiedad freeText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFreeText() {
        return freeText;
    }

    /**
     * Define el valor de la propiedad freeText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFreeText(String value) {
        this.freeText = value;
    }

    /**
     * Obtiene el valor de la propiedad salesPersonCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSalesPersonCode() {
        return salesPersonCode;
    }

    /**
     * Define el valor de la propiedad salesPersonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSalesPersonCode(Long value) {
        this.salesPersonCode = value;
    }

    /**
     * Obtiene el valor de la propiedad currency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Define el valor de la propiedad currency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Obtiene el valor de la propiedad rateDiffAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRateDiffAccount() {
        return rateDiffAccount;
    }

    /**
     * Define el valor de la propiedad rateDiffAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRateDiffAccount(String value) {
        this.rateDiffAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad cellular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCellular() {
        return cellular;
    }

    /**
     * Define el valor de la propiedad cellular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCellular(String value) {
        this.cellular = value;
    }

    /**
     * Obtiene el valor de la propiedad avarageLate.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAvarageLate() {
        return avarageLate;
    }

    /**
     * Define el valor de la propiedad avarageLate.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAvarageLate(Long value) {
        this.avarageLate = value;
    }

    /**
     * Obtiene el valor de la propiedad city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Define el valor de la propiedad city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Obtiene el valor de la propiedad county.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Define el valor de la propiedad county.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad mailCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCity() {
        return mailCity;
    }

    /**
     * Define el valor de la propiedad mailCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCity(String value) {
        this.mailCity = value;
    }

    /**
     * Obtiene el valor de la propiedad mailCounty.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCounty() {
        return mailCounty;
    }

    /**
     * Define el valor de la propiedad mailCounty.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCounty(String value) {
        this.mailCounty = value;
    }

    /**
     * Obtiene el valor de la propiedad mailCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailCountry() {
        return mailCountry;
    }

    /**
     * Define el valor de la propiedad mailCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailCountry(String value) {
        this.mailCountry = value;
    }

    /**
     * Obtiene el valor de la propiedad emailAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Define el valor de la propiedad emailAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAddress(String value) {
        this.emailAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad picture.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Define el valor de la propiedad picture.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicture(String value) {
        this.picture = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultAccount() {
        return defaultAccount;
    }

    /**
     * Define el valor de la propiedad defaultAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultAccount(String value) {
        this.defaultAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultBranch.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultBranch() {
        return defaultBranch;
    }

    /**
     * Define el valor de la propiedad defaultBranch.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultBranch(String value) {
        this.defaultBranch = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultBankCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultBankCode() {
        return defaultBankCode;
    }

    /**
     * Define el valor de la propiedad defaultBankCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultBankCode(String value) {
        this.defaultBankCode = value;
    }

    /**
     * Obtiene el valor de la propiedad additionalID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalID() {
        return additionalID;
    }

    /**
     * Define el valor de la propiedad additionalID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalID(String value) {
        this.additionalID = value;
    }

    /**
     * Obtiene el valor de la propiedad pager.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPager() {
        return pager;
    }

    /**
     * Define el valor de la propiedad pager.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPager(String value) {
        this.pager = value;
    }

    /**
     * Obtiene el valor de la propiedad fatherCard.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherCard() {
        return fatherCard;
    }

    /**
     * Define el valor de la propiedad fatherCard.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherCard(String value) {
        this.fatherCard = value;
    }

    /**
     * Obtiene el valor de la propiedad cardForeignName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardForeignName() {
        return cardForeignName;
    }

    /**
     * Define el valor de la propiedad cardForeignName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardForeignName(String value) {
        this.cardForeignName = value;
    }

    /**
     * Obtiene el valor de la propiedad fatherType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFatherType() {
        return fatherType;
    }

    /**
     * Define el valor de la propiedad fatherType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFatherType(String value) {
        this.fatherType = value;
    }

    /**
     * Obtiene el valor de la propiedad deductionOffice.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeductionOffice() {
        return deductionOffice;
    }

    /**
     * Define el valor de la propiedad deductionOffice.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeductionOffice(String value) {
        this.deductionOffice = value;
    }

    /**
     * Obtiene el valor de la propiedad exportCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportCode() {
        return exportCode;
    }

    /**
     * Define el valor de la propiedad exportCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportCode(String value) {
        this.exportCode = value;
    }

    /**
     * Obtiene el valor de la propiedad minIntrest.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMinIntrest() {
        return minIntrest;
    }

    /**
     * Define el valor de la propiedad minIntrest.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMinIntrest(Double value) {
        this.minIntrest = value;
    }

    /**
     * Obtiene el valor de la propiedad currentAccountBalance.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    /**
     * Define el valor de la propiedad currentAccountBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCurrentAccountBalance(Double value) {
        this.currentAccountBalance = value;
    }

    /**
     * Obtiene el valor de la propiedad openDeliveryNotesBalance.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOpenDeliveryNotesBalance() {
        return openDeliveryNotesBalance;
    }

    /**
     * Define el valor de la propiedad openDeliveryNotesBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOpenDeliveryNotesBalance(Double value) {
        this.openDeliveryNotesBalance = value;
    }

    /**
     * Obtiene el valor de la propiedad openOrdersBalance.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getOpenOrdersBalance() {
        return openOrdersBalance;
    }

    /**
     * Define el valor de la propiedad openOrdersBalance.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setOpenOrdersBalance(Double value) {
        this.openOrdersBalance = value;
    }

    /**
     * Obtiene el valor de la propiedad vatGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatGroup() {
        return vatGroup;
    }

    /**
     * Define el valor de la propiedad vatGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatGroup(String value) {
        this.vatGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad shippingType.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getShippingType() {
        return shippingType;
    }

    /**
     * Define el valor de la propiedad shippingType.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setShippingType(Long value) {
        this.shippingType = value;
    }

    /**
     * Obtiene el valor de la propiedad password.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define el valor de la propiedad password.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Obtiene el valor de la propiedad indicator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * Define el valor de la propiedad indicator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicator(String value) {
        this.indicator = value;
    }

    /**
     * Obtiene el valor de la propiedad iban.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBAN() {
        return iban;
    }

    /**
     * Define el valor de la propiedad iban.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBAN(String value) {
        this.iban = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCardCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditCardCode() {
        return creditCardCode;
    }

    /**
     * Define el valor de la propiedad creditCardCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditCardCode(Long value) {
        this.creditCardCode = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCardNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditCardNum() {
        return creditCardNum;
    }

    /**
     * Define el valor de la propiedad creditCardNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditCardNum(String value) {
        this.creditCardNum = value;
    }

    /**
     * Obtiene el valor de la propiedad creditCardExpiration.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreditCardExpiration() {
        return creditCardExpiration;
    }

    /**
     * Define el valor de la propiedad creditCardExpiration.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreditCardExpiration(XMLGregorianCalendar value) {
        this.creditCardExpiration = value;
    }

    /**
     * Obtiene el valor de la propiedad debitorAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitorAccount() {
        return debitorAccount;
    }

    /**
     * Define el valor de la propiedad debitorAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitorAccount(String value) {
        this.debitorAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad openOpportunities.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOpenOpportunities() {
        return openOpportunities;
    }

    /**
     * Define el valor de la propiedad openOpportunities.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOpenOpportunities(Long value) {
        this.openOpportunities = value;
    }

    /**
     * Obtiene el valor de la propiedad valid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValid() {
        return valid;
    }

    /**
     * Define el valor de la propiedad valid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValid(String value) {
        this.valid = value;
    }

    /**
     * Obtiene el valor de la propiedad validFrom.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidFrom() {
        return validFrom;
    }

    /**
     * Define el valor de la propiedad validFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidFrom(XMLGregorianCalendar value) {
        this.validFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad validTo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValidTo() {
        return validTo;
    }

    /**
     * Define el valor de la propiedad validTo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValidTo(XMLGregorianCalendar value) {
        this.validTo = value;
    }

    /**
     * Obtiene el valor de la propiedad validRemarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidRemarks() {
        return validRemarks;
    }

    /**
     * Define el valor de la propiedad validRemarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidRemarks(String value) {
        this.validRemarks = value;
    }

    /**
     * Obtiene el valor de la propiedad frozen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrozen() {
        return frozen;
    }

    /**
     * Define el valor de la propiedad frozen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrozen(String value) {
        this.frozen = value;
    }

    /**
     * Obtiene el valor de la propiedad frozenFrom.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrozenFrom() {
        return frozenFrom;
    }

    /**
     * Define el valor de la propiedad frozenFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrozenFrom(XMLGregorianCalendar value) {
        this.frozenFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad frozenTo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrozenTo() {
        return frozenTo;
    }

    /**
     * Define el valor de la propiedad frozenTo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrozenTo(XMLGregorianCalendar value) {
        this.frozenTo = value;
    }

    /**
     * Obtiene el valor de la propiedad frozenRemarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrozenRemarks() {
        return frozenRemarks;
    }

    /**
     * Define el valor de la propiedad frozenRemarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrozenRemarks(String value) {
        this.frozenRemarks = value;
    }

    /**
     * Obtiene el valor de la propiedad block.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlock() {
        return block;
    }

    /**
     * Define el valor de la propiedad block.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlock(String value) {
        this.block = value;
    }

    /**
     * Obtiene el valor de la propiedad billToState.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillToState() {
        return billToState;
    }

    /**
     * Define el valor de la propiedad billToState.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillToState(String value) {
        this.billToState = value;
    }

    /**
     * Obtiene el valor de la propiedad exemptNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExemptNum() {
        return exemptNum;
    }

    /**
     * Define el valor de la propiedad exemptNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExemptNum(String value) {
        this.exemptNum = value;
    }

    /**
     * Obtiene el valor de la propiedad priority.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPriority() {
        return priority;
    }

    /**
     * Define el valor de la propiedad priority.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPriority(Long value) {
        this.priority = value;
    }

    /**
     * Obtiene el valor de la propiedad formCode1099.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFormCode1099() {
        return formCode1099;
    }

    /**
     * Define el valor de la propiedad formCode1099.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFormCode1099(Long value) {
        this.formCode1099 = value;
    }

    /**
     * Obtiene el valor de la propiedad box1099.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBox1099() {
        return box1099;
    }

    /**
     * Define el valor de la propiedad box1099.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBox1099(String value) {
        this.box1099 = value;
    }

    /**
     * Obtiene el valor de la propiedad peymentMethodCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeymentMethodCode() {
        return peymentMethodCode;
    }

    /**
     * Define el valor de la propiedad peymentMethodCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeymentMethodCode(String value) {
        this.peymentMethodCode = value;
    }

    /**
     * Obtiene el valor de la propiedad backOrder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBackOrder() {
        return backOrder;
    }

    /**
     * Define el valor de la propiedad backOrder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBackOrder(String value) {
        this.backOrder = value;
    }

    /**
     * Obtiene el valor de la propiedad partialDelivery.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartialDelivery() {
        return partialDelivery;
    }

    /**
     * Define el valor de la propiedad partialDelivery.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartialDelivery(String value) {
        this.partialDelivery = value;
    }

    /**
     * Obtiene el valor de la propiedad blockDunning.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBlockDunning() {
        return blockDunning;
    }

    /**
     * Define el valor de la propiedad blockDunning.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBlockDunning(String value) {
        this.blockDunning = value;
    }

    /**
     * Obtiene el valor de la propiedad bankCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCountry() {
        return bankCountry;
    }

    /**
     * Define el valor de la propiedad bankCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCountry(String value) {
        this.bankCountry = value;
    }

    /**
     * Obtiene el valor de la propiedad houseBank.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseBank() {
        return houseBank;
    }

    /**
     * Define el valor de la propiedad houseBank.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseBank(String value) {
        this.houseBank = value;
    }

    /**
     * Obtiene el valor de la propiedad houseBankCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseBankCountry() {
        return houseBankCountry;
    }

    /**
     * Define el valor de la propiedad houseBankCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseBankCountry(String value) {
        this.houseBankCountry = value;
    }

    /**
     * Obtiene el valor de la propiedad houseBankAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseBankAccount() {
        return houseBankAccount;
    }

    /**
     * Define el valor de la propiedad houseBankAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseBankAccount(String value) {
        this.houseBankAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad shipToDefault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipToDefault() {
        return shipToDefault;
    }

    /**
     * Define el valor de la propiedad shipToDefault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipToDefault(String value) {
        this.shipToDefault = value;
    }

    /**
     * Obtiene el valor de la propiedad dunningLevel.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDunningLevel() {
        return dunningLevel;
    }

    /**
     * Define el valor de la propiedad dunningLevel.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDunningLevel(Long value) {
        this.dunningLevel = value;
    }

    /**
     * Obtiene el valor de la propiedad dunningDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDunningDate() {
        return dunningDate;
    }

    /**
     * Define el valor de la propiedad dunningDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDunningDate(XMLGregorianCalendar value) {
        this.dunningDate = value;
    }

    /**
     * Obtiene el valor de la propiedad collectionAuthorization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollectionAuthorization() {
        return collectionAuthorization;
    }

    /**
     * Define el valor de la propiedad collectionAuthorization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollectionAuthorization(String value) {
        this.collectionAuthorization = value;
    }

    /**
     * Obtiene el valor de la propiedad dme.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDME() {
        return dme;
    }

    /**
     * Define el valor de la propiedad dme.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDME(String value) {
        this.dme = value;
    }

    /**
     * Obtiene el valor de la propiedad instructionKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstructionKey() {
        return instructionKey;
    }

    /**
     * Define el valor de la propiedad instructionKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstructionKey(String value) {
        this.instructionKey = value;
    }

    /**
     * Obtiene el valor de la propiedad singlePayment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSinglePayment() {
        return singlePayment;
    }

    /**
     * Define el valor de la propiedad singlePayment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSinglePayment(String value) {
        this.singlePayment = value;
    }

    /**
     * Obtiene el valor de la propiedad isrBillerID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISRBillerID() {
        return isrBillerID;
    }

    /**
     * Define el valor de la propiedad isrBillerID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISRBillerID(String value) {
        this.isrBillerID = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentBlock.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentBlock() {
        return paymentBlock;
    }

    /**
     * Define el valor de la propiedad paymentBlock.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentBlock(String value) {
        this.paymentBlock = value;
    }

    /**
     * Obtiene el valor de la propiedad referenceDetails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceDetails() {
        return referenceDetails;
    }

    /**
     * Define el valor de la propiedad referenceDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceDetails(String value) {
        this.referenceDetails = value;
    }

    /**
     * Obtiene el valor de la propiedad houseBankBranch.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseBankBranch() {
        return houseBankBranch;
    }

    /**
     * Define el valor de la propiedad houseBankBranch.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseBankBranch(String value) {
        this.houseBankBranch = value;
    }

    /**
     * Obtiene el valor de la propiedad ownerIDNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerIDNumber() {
        return ownerIDNumber;
    }

    /**
     * Define el valor de la propiedad ownerIDNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerIDNumber(String value) {
        this.ownerIDNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentBlockDescription.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPaymentBlockDescription() {
        return paymentBlockDescription;
    }

    /**
     * Define el valor de la propiedad paymentBlockDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPaymentBlockDescription(Long value) {
        this.paymentBlockDescription = value;
    }

    /**
     * Obtiene el valor de la propiedad taxExemptionLetterNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxExemptionLetterNum() {
        return taxExemptionLetterNum;
    }

    /**
     * Define el valor de la propiedad taxExemptionLetterNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxExemptionLetterNum(String value) {
        this.taxExemptionLetterNum = value;
    }

    /**
     * Obtiene el valor de la propiedad maxAmountOfExemption.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getMaxAmountOfExemption() {
        return maxAmountOfExemption;
    }

    /**
     * Define el valor de la propiedad maxAmountOfExemption.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setMaxAmountOfExemption(Double value) {
        this.maxAmountOfExemption = value;
    }

    /**
     * Obtiene el valor de la propiedad exemptionValidityDateFrom.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExemptionValidityDateFrom() {
        return exemptionValidityDateFrom;
    }

    /**
     * Define el valor de la propiedad exemptionValidityDateFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExemptionValidityDateFrom(XMLGregorianCalendar value) {
        this.exemptionValidityDateFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad exemptionValidityDateTo.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExemptionValidityDateTo() {
        return exemptionValidityDateTo;
    }

    /**
     * Define el valor de la propiedad exemptionValidityDateTo.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExemptionValidityDateTo(XMLGregorianCalendar value) {
        this.exemptionValidityDateTo = value;
    }

    /**
     * Obtiene el valor de la propiedad linkedBusinessPartner.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkedBusinessPartner() {
        return linkedBusinessPartner;
    }

    /**
     * Define el valor de la propiedad linkedBusinessPartner.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkedBusinessPartner(String value) {
        this.linkedBusinessPartner = value;
    }

    /**
     * Obtiene el valor de la propiedad lastMultiReconciliationNum.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastMultiReconciliationNum() {
        return lastMultiReconciliationNum;
    }

    /**
     * Define el valor de la propiedad lastMultiReconciliationNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastMultiReconciliationNum(Long value) {
        this.lastMultiReconciliationNum = value;
    }

    /**
     * Obtiene el valor de la propiedad deferredTax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeferredTax() {
        return deferredTax;
    }

    /**
     * Define el valor de la propiedad deferredTax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeferredTax(String value) {
        this.deferredTax = value;
    }

    /**
     * Obtiene el valor de la propiedad equalization.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEqualization() {
        return equalization;
    }

    /**
     * Define el valor de la propiedad equalization.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEqualization(String value) {
        this.equalization = value;
    }

    /**
     * Obtiene el valor de la propiedad subjectToWithholdingTax.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubjectToWithholdingTax() {
        return subjectToWithholdingTax;
    }

    /**
     * Define el valor de la propiedad subjectToWithholdingTax.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubjectToWithholdingTax(String value) {
        this.subjectToWithholdingTax = value;
    }

    /**
     * Obtiene el valor de la propiedad certificateNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * Define el valor de la propiedad certificateNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCertificateNumber(String value) {
        this.certificateNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad expirationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    /**
     * Define el valor de la propiedad expirationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpirationDate(XMLGregorianCalendar value) {
        this.expirationDate = value;
    }

    /**
     * Obtiene el valor de la propiedad nationalInsuranceNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationalInsuranceNum() {
        return nationalInsuranceNum;
    }

    /**
     * Define el valor de la propiedad nationalInsuranceNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationalInsuranceNum(String value) {
        this.nationalInsuranceNum = value;
    }

    /**
     * Obtiene el valor de la propiedad accrualCriteria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccrualCriteria() {
        return accrualCriteria;
    }

    /**
     * Define el valor de la propiedad accrualCriteria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccrualCriteria(String value) {
        this.accrualCriteria = value;
    }

    /**
     * Obtiene el valor de la propiedad wtCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWTCode() {
        return wtCode;
    }

    /**
     * Define el valor de la propiedad wtCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWTCode(String value) {
        this.wtCode = value;
    }

    /**
     * Obtiene el valor de la propiedad billToBuildingFloorRoom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillToBuildingFloorRoom() {
        return billToBuildingFloorRoom;
    }

    /**
     * Define el valor de la propiedad billToBuildingFloorRoom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillToBuildingFloorRoom(String value) {
        this.billToBuildingFloorRoom = value;
    }

    /**
     * Obtiene el valor de la propiedad downPaymentClearAct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownPaymentClearAct() {
        return downPaymentClearAct;
    }

    /**
     * Define el valor de la propiedad downPaymentClearAct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownPaymentClearAct(String value) {
        this.downPaymentClearAct = value;
    }

    /**
     * Obtiene el valor de la propiedad channelBP.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelBP() {
        return channelBP;
    }

    /**
     * Define el valor de la propiedad channelBP.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelBP(String value) {
        this.channelBP = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultTechnician.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDefaultTechnician() {
        return defaultTechnician;
    }

    /**
     * Define el valor de la propiedad defaultTechnician.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDefaultTechnician(Long value) {
        this.defaultTechnician = value;
    }

    /**
     * Obtiene el valor de la propiedad billtoDefault.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBilltoDefault() {
        return billtoDefault;
    }

    /**
     * Define el valor de la propiedad billtoDefault.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBilltoDefault(String value) {
        this.billtoDefault = value;
    }

    /**
     * Obtiene el valor de la propiedad customerBillofExchangDisc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerBillofExchangDisc() {
        return customerBillofExchangDisc;
    }

    /**
     * Define el valor de la propiedad customerBillofExchangDisc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerBillofExchangDisc(String value) {
        this.customerBillofExchangDisc = value;
    }

    /**
     * Obtiene el valor de la propiedad territory.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTerritory() {
        return territory;
    }

    /**
     * Define el valor de la propiedad territory.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTerritory(Long value) {
        this.territory = value;
    }

    /**
     * Obtiene el valor de la propiedad shipToBuildingFloorRoom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShipToBuildingFloorRoom() {
        return shipToBuildingFloorRoom;
    }

    /**
     * Define el valor de la propiedad shipToBuildingFloorRoom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShipToBuildingFloorRoom(String value) {
        this.shipToBuildingFloorRoom = value;
    }

    /**
     * Obtiene el valor de la propiedad customerBillofExchangPres.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerBillofExchangPres() {
        return customerBillofExchangPres;
    }

    /**
     * Define el valor de la propiedad customerBillofExchangPres.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerBillofExchangPres(String value) {
        this.customerBillofExchangPres = value;
    }

    /**
     * Obtiene el valor de la propiedad projectCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * Define el valor de la propiedad projectCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectCode(String value) {
        this.projectCode = value;
    }

    /**
     * Obtiene el valor de la propiedad vatGroupLatinAmerica.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatGroupLatinAmerica() {
        return vatGroupLatinAmerica;
    }

    /**
     * Define el valor de la propiedad vatGroupLatinAmerica.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatGroupLatinAmerica(String value) {
        this.vatGroupLatinAmerica = value;
    }

    /**
     * Obtiene el valor de la propiedad dunningTerm.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDunningTerm() {
        return dunningTerm;
    }

    /**
     * Define el valor de la propiedad dunningTerm.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDunningTerm(String value) {
        this.dunningTerm = value;
    }

    /**
     * Obtiene el valor de la propiedad website.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Define el valor de la propiedad website.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebsite(String value) {
        this.website = value;
    }

    /**
     * Obtiene el valor de la propiedad otherReceivablePayable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherReceivablePayable() {
        return otherReceivablePayable;
    }

    /**
     * Define el valor de la propiedad otherReceivablePayable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherReceivablePayable(String value) {
        this.otherReceivablePayable = value;
    }

    /**
     * Obtiene el valor de la propiedad billofExchangeonCollection.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillofExchangeonCollection() {
        return billofExchangeonCollection;
    }

    /**
     * Define el valor de la propiedad billofExchangeonCollection.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillofExchangeonCollection(String value) {
        this.billofExchangeonCollection = value;
    }

    /**
     * Obtiene el valor de la propiedad companyPrivate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyPrivate() {
        return companyPrivate;
    }

    /**
     * Define el valor de la propiedad companyPrivate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyPrivate(String value) {
        this.companyPrivate = value;
    }

    /**
     * Obtiene el valor de la propiedad languageCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLanguageCode() {
        return languageCode;
    }

    /**
     * Define el valor de la propiedad languageCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLanguageCode(Long value) {
        this.languageCode = value;
    }

    /**
     * Obtiene el valor de la propiedad unpaidBillofExchange.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnpaidBillofExchange() {
        return unpaidBillofExchange;
    }

    /**
     * Define el valor de la propiedad unpaidBillofExchange.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnpaidBillofExchange(String value) {
        this.unpaidBillofExchange = value;
    }

    /**
     * Obtiene el valor de la propiedad withholdingTaxDeductionGroup.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWithholdingTaxDeductionGroup() {
        return withholdingTaxDeductionGroup;
    }

    /**
     * Define el valor de la propiedad withholdingTaxDeductionGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWithholdingTaxDeductionGroup(Long value) {
        this.withholdingTaxDeductionGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad closingDateProcedureNumber.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getClosingDateProcedureNumber() {
        return closingDateProcedureNumber;
    }

    /**
     * Define el valor de la propiedad closingDateProcedureNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setClosingDateProcedureNumber(Long value) {
        this.closingDateProcedureNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad profession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfession() {
        return profession;
    }

    /**
     * Define el valor de la propiedad profession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfession(String value) {
        this.profession = value;
    }

    /**
     * Obtiene el valor de la propiedad bankChargesAllocationCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankChargesAllocationCode() {
        return bankChargesAllocationCode;
    }

    /**
     * Define el valor de la propiedad bankChargesAllocationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankChargesAllocationCode(String value) {
        this.bankChargesAllocationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad taxRoundingRule.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxRoundingRule() {
        return taxRoundingRule;
    }

    /**
     * Define el valor de la propiedad taxRoundingRule.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxRoundingRule(String value) {
        this.taxRoundingRule = value;
    }

    /**
     * Obtiene el valor de la propiedad properties1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties1() {
        return properties1;
    }

    /**
     * Define el valor de la propiedad properties1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties1(String value) {
        this.properties1 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties2() {
        return properties2;
    }

    /**
     * Define el valor de la propiedad properties2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties2(String value) {
        this.properties2 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties3.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties3() {
        return properties3;
    }

    /**
     * Define el valor de la propiedad properties3.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties3(String value) {
        this.properties3 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties4.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties4() {
        return properties4;
    }

    /**
     * Define el valor de la propiedad properties4.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties4(String value) {
        this.properties4 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties5.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties5() {
        return properties5;
    }

    /**
     * Define el valor de la propiedad properties5.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties5(String value) {
        this.properties5 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties6.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties6() {
        return properties6;
    }

    /**
     * Define el valor de la propiedad properties6.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties6(String value) {
        this.properties6 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties7.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties7() {
        return properties7;
    }

    /**
     * Define el valor de la propiedad properties7.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties7(String value) {
        this.properties7 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties8.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties8() {
        return properties8;
    }

    /**
     * Define el valor de la propiedad properties8.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties8(String value) {
        this.properties8 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties9.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties9() {
        return properties9;
    }

    /**
     * Define el valor de la propiedad properties9.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties9(String value) {
        this.properties9 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties10.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties10() {
        return properties10;
    }

    /**
     * Define el valor de la propiedad properties10.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties10(String value) {
        this.properties10 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties11.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties11() {
        return properties11;
    }

    /**
     * Define el valor de la propiedad properties11.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties11(String value) {
        this.properties11 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties12.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties12() {
        return properties12;
    }

    /**
     * Define el valor de la propiedad properties12.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties12(String value) {
        this.properties12 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties13.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties13() {
        return properties13;
    }

    /**
     * Define el valor de la propiedad properties13.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties13(String value) {
        this.properties13 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties14.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties14() {
        return properties14;
    }

    /**
     * Define el valor de la propiedad properties14.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties14(String value) {
        this.properties14 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties15.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties15() {
        return properties15;
    }

    /**
     * Define el valor de la propiedad properties15.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties15(String value) {
        this.properties15 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties16.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties16() {
        return properties16;
    }

    /**
     * Define el valor de la propiedad properties16.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties16(String value) {
        this.properties16 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties17.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties17() {
        return properties17;
    }

    /**
     * Define el valor de la propiedad properties17.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties17(String value) {
        this.properties17 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties18.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties18() {
        return properties18;
    }

    /**
     * Define el valor de la propiedad properties18.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties18(String value) {
        this.properties18 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties19.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties19() {
        return properties19;
    }

    /**
     * Define el valor de la propiedad properties19.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties19(String value) {
        this.properties19 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties20.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties20() {
        return properties20;
    }

    /**
     * Define el valor de la propiedad properties20.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties20(String value) {
        this.properties20 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties21.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties21() {
        return properties21;
    }

    /**
     * Define el valor de la propiedad properties21.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties21(String value) {
        this.properties21 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties22.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties22() {
        return properties22;
    }

    /**
     * Define el valor de la propiedad properties22.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties22(String value) {
        this.properties22 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties23.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties23() {
        return properties23;
    }

    /**
     * Define el valor de la propiedad properties23.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties23(String value) {
        this.properties23 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties24.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties24() {
        return properties24;
    }

    /**
     * Define el valor de la propiedad properties24.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties24(String value) {
        this.properties24 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties25.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties25() {
        return properties25;
    }

    /**
     * Define el valor de la propiedad properties25.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties25(String value) {
        this.properties25 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties26.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties26() {
        return properties26;
    }

    /**
     * Define el valor de la propiedad properties26.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties26(String value) {
        this.properties26 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties27.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties27() {
        return properties27;
    }

    /**
     * Define el valor de la propiedad properties27.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties27(String value) {
        this.properties27 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties28.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties28() {
        return properties28;
    }

    /**
     * Define el valor de la propiedad properties28.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties28(String value) {
        this.properties28 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties29.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties29() {
        return properties29;
    }

    /**
     * Define el valor de la propiedad properties29.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties29(String value) {
        this.properties29 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties30.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties30() {
        return properties30;
    }

    /**
     * Define el valor de la propiedad properties30.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties30(String value) {
        this.properties30 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties31.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties31() {
        return properties31;
    }

    /**
     * Define el valor de la propiedad properties31.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties31(String value) {
        this.properties31 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties32.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties32() {
        return properties32;
    }

    /**
     * Define el valor de la propiedad properties32.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties32(String value) {
        this.properties32 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties33.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties33() {
        return properties33;
    }

    /**
     * Define el valor de la propiedad properties33.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties33(String value) {
        this.properties33 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties34.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties34() {
        return properties34;
    }

    /**
     * Define el valor de la propiedad properties34.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties34(String value) {
        this.properties34 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties35.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties35() {
        return properties35;
    }

    /**
     * Define el valor de la propiedad properties35.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties35(String value) {
        this.properties35 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties36.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties36() {
        return properties36;
    }

    /**
     * Define el valor de la propiedad properties36.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties36(String value) {
        this.properties36 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties37.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties37() {
        return properties37;
    }

    /**
     * Define el valor de la propiedad properties37.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties37(String value) {
        this.properties37 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties38.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties38() {
        return properties38;
    }

    /**
     * Define el valor de la propiedad properties38.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties38(String value) {
        this.properties38 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties39.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties39() {
        return properties39;
    }

    /**
     * Define el valor de la propiedad properties39.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties39(String value) {
        this.properties39 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties40.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties40() {
        return properties40;
    }

    /**
     * Define el valor de la propiedad properties40.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties40(String value) {
        this.properties40 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties41.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties41() {
        return properties41;
    }

    /**
     * Define el valor de la propiedad properties41.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties41(String value) {
        this.properties41 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties42.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties42() {
        return properties42;
    }

    /**
     * Define el valor de la propiedad properties42.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties42(String value) {
        this.properties42 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties43.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties43() {
        return properties43;
    }

    /**
     * Define el valor de la propiedad properties43.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties43(String value) {
        this.properties43 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties44.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties44() {
        return properties44;
    }

    /**
     * Define el valor de la propiedad properties44.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties44(String value) {
        this.properties44 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties45.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties45() {
        return properties45;
    }

    /**
     * Define el valor de la propiedad properties45.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties45(String value) {
        this.properties45 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties46.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties46() {
        return properties46;
    }

    /**
     * Define el valor de la propiedad properties46.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties46(String value) {
        this.properties46 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties47.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties47() {
        return properties47;
    }

    /**
     * Define el valor de la propiedad properties47.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties47(String value) {
        this.properties47 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties48.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties48() {
        return properties48;
    }

    /**
     * Define el valor de la propiedad properties48.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties48(String value) {
        this.properties48 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties49.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties49() {
        return properties49;
    }

    /**
     * Define el valor de la propiedad properties49.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties49(String value) {
        this.properties49 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties50.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties50() {
        return properties50;
    }

    /**
     * Define el valor de la propiedad properties50.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties50(String value) {
        this.properties50 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties51.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties51() {
        return properties51;
    }

    /**
     * Define el valor de la propiedad properties51.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties51(String value) {
        this.properties51 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties52.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties52() {
        return properties52;
    }

    /**
     * Define el valor de la propiedad properties52.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties52(String value) {
        this.properties52 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties53.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties53() {
        return properties53;
    }

    /**
     * Define el valor de la propiedad properties53.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties53(String value) {
        this.properties53 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties54.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties54() {
        return properties54;
    }

    /**
     * Define el valor de la propiedad properties54.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties54(String value) {
        this.properties54 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties55.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties55() {
        return properties55;
    }

    /**
     * Define el valor de la propiedad properties55.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties55(String value) {
        this.properties55 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties56.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties56() {
        return properties56;
    }

    /**
     * Define el valor de la propiedad properties56.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties56(String value) {
        this.properties56 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties57.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties57() {
        return properties57;
    }

    /**
     * Define el valor de la propiedad properties57.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties57(String value) {
        this.properties57 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties58.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties58() {
        return properties58;
    }

    /**
     * Define el valor de la propiedad properties58.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties58(String value) {
        this.properties58 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties59.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties59() {
        return properties59;
    }

    /**
     * Define el valor de la propiedad properties59.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties59(String value) {
        this.properties59 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties60.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties60() {
        return properties60;
    }

    /**
     * Define el valor de la propiedad properties60.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties60(String value) {
        this.properties60 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties61.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties61() {
        return properties61;
    }

    /**
     * Define el valor de la propiedad properties61.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties61(String value) {
        this.properties61 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties62.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties62() {
        return properties62;
    }

    /**
     * Define el valor de la propiedad properties62.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties62(String value) {
        this.properties62 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties63.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties63() {
        return properties63;
    }

    /**
     * Define el valor de la propiedad properties63.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties63(String value) {
        this.properties63 = value;
    }

    /**
     * Obtiene el valor de la propiedad properties64.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProperties64() {
        return properties64;
    }

    /**
     * Define el valor de la propiedad properties64.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProperties64(String value) {
        this.properties64 = value;
    }

    /**
     * Obtiene el valor de la propiedad companyRegistrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    /**
     * Define el valor de la propiedad companyRegistrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyRegistrationNumber(String value) {
        this.companyRegistrationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad verificationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVerificationNumber() {
        return verificationNumber;
    }

    /**
     * Define el valor de la propiedad verificationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVerificationNumber(String value) {
        this.verificationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad discountBaseObject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountBaseObject() {
        return discountBaseObject;
    }

    /**
     * Define el valor de la propiedad discountBaseObject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountBaseObject(String value) {
        this.discountBaseObject = value;
    }

    /**
     * Obtiene el valor de la propiedad discountRelations.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDiscountRelations() {
        return discountRelations;
    }

    /**
     * Define el valor de la propiedad discountRelations.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDiscountRelations(String value) {
        this.discountRelations = value;
    }

    /**
     * Obtiene el valor de la propiedad typeReport.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeReport() {
        return typeReport;
    }

    /**
     * Define el valor de la propiedad typeReport.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeReport(String value) {
        this.typeReport = value;
    }

    /**
     * Obtiene el valor de la propiedad thresholdOverlook.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThresholdOverlook() {
        return thresholdOverlook;
    }

    /**
     * Define el valor de la propiedad thresholdOverlook.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThresholdOverlook(String value) {
        this.thresholdOverlook = value;
    }

    /**
     * Obtiene el valor de la propiedad surchargeOverlook.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSurchargeOverlook() {
        return surchargeOverlook;
    }

    /**
     * Define el valor de la propiedad surchargeOverlook.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSurchargeOverlook(String value) {
        this.surchargeOverlook = value;
    }

    /**
     * Obtiene el valor de la propiedad downPaymentInterimAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownPaymentInterimAccount() {
        return downPaymentInterimAccount;
    }

    /**
     * Define el valor de la propiedad downPaymentInterimAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownPaymentInterimAccount(String value) {
        this.downPaymentInterimAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad operationCode347.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationCode347() {
        return operationCode347;
    }

    /**
     * Define el valor de la propiedad operationCode347.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationCode347(String value) {
        this.operationCode347 = value;
    }

    /**
     * Obtiene el valor de la propiedad insuranceOperation347.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceOperation347() {
        return insuranceOperation347;
    }

    /**
     * Define el valor de la propiedad insuranceOperation347.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceOperation347(String value) {
        this.insuranceOperation347 = value;
    }

    /**
     * Obtiene el valor de la propiedad hierarchicalDeduction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchicalDeduction() {
        return hierarchicalDeduction;
    }

    /**
     * Define el valor de la propiedad hierarchicalDeduction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchicalDeduction(String value) {
        this.hierarchicalDeduction = value;
    }

    /**
     * Obtiene el valor de la propiedad shaamGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShaamGroup() {
        return shaamGroup;
    }

    /**
     * Define el valor de la propiedad shaamGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShaamGroup(String value) {
        this.shaamGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad withholdingTaxCertified.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWithholdingTaxCertified() {
        return withholdingTaxCertified;
    }

    /**
     * Define el valor de la propiedad withholdingTaxCertified.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWithholdingTaxCertified(String value) {
        this.withholdingTaxCertified = value;
    }

    /**
     * Obtiene el valor de la propiedad bookkeepingCertified.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookkeepingCertified() {
        return bookkeepingCertified;
    }

    /**
     * Define el valor de la propiedad bookkeepingCertified.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookkeepingCertified(String value) {
        this.bookkeepingCertified = value;
    }

    /**
     * Obtiene el valor de la propiedad planningGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanningGroup() {
        return planningGroup;
    }

    /**
     * Define el valor de la propiedad planningGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanningGroup(String value) {
        this.planningGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad affiliate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAffiliate() {
        return affiliate;
    }

    /**
     * Define el valor de la propiedad affiliate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAffiliate(String value) {
        this.affiliate = value;
    }

    /**
     * Obtiene el valor de la propiedad industry.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIndustry() {
        return industry;
    }

    /**
     * Define el valor de la propiedad industry.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIndustry(Long value) {
        this.industry = value;
    }

    /**
     * Obtiene el valor de la propiedad vatIDNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVatIDNum() {
        return vatIDNum;
    }

    /**
     * Define el valor de la propiedad vatIDNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVatIDNum(String value) {
        this.vatIDNum = value;
    }

    /**
     * Obtiene el valor de la propiedad datevAccount.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDatevAccount() {
        return datevAccount;
    }

    /**
     * Define el valor de la propiedad datevAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDatevAccount(Long value) {
        this.datevAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad datevFirstDataEntry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatevFirstDataEntry() {
        return datevFirstDataEntry;
    }

    /**
     * Define el valor de la propiedad datevFirstDataEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatevFirstDataEntry(String value) {
        this.datevFirstDataEntry = value;
    }

    /**
     * Obtiene el valor de la propiedad gtsRegNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTSRegNo() {
        return gtsRegNo;
    }

    /**
     * Define el valor de la propiedad gtsRegNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTSRegNo(String value) {
        this.gtsRegNo = value;
    }

    /**
     * Obtiene el valor de la propiedad gtsBankAccountNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTSBankAccountNo() {
        return gtsBankAccountNo;
    }

    /**
     * Define el valor de la propiedad gtsBankAccountNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTSBankAccountNo(String value) {
        this.gtsBankAccountNo = value;
    }

    /**
     * Obtiene el valor de la propiedad gtsBillingAddrTel.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGTSBillingAddrTel() {
        return gtsBillingAddrTel;
    }

    /**
     * Define el valor de la propiedad gtsBillingAddrTel.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGTSBillingAddrTel(String value) {
        this.gtsBillingAddrTel = value;
    }

    /**
     * Obtiene el valor de la propiedad eTaxWebSite.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getETaxWebSite() {
        return eTaxWebSite;
    }

    /**
     * Define el valor de la propiedad eTaxWebSite.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setETaxWebSite(Long value) {
        this.eTaxWebSite = value;
    }

    /**
     * Obtiene el valor de la propiedad houseBankIBAN.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHouseBankIBAN() {
        return houseBankIBAN;
    }

    /**
     * Define el valor de la propiedad houseBankIBAN.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHouseBankIBAN(String value) {
        this.houseBankIBAN = value;
    }

    /**
     * Obtiene el valor de la propiedad vatRegistrationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATRegistrationNumber() {
        return vatRegistrationNumber;
    }

    /**
     * Define el valor de la propiedad vatRegistrationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATRegistrationNumber(String value) {
        this.vatRegistrationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad representativeName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepresentativeName() {
        return representativeName;
    }

    /**
     * Define el valor de la propiedad representativeName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepresentativeName(String value) {
        this.representativeName = value;
    }

    /**
     * Obtiene el valor de la propiedad industryType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndustryType() {
        return industryType;
    }

    /**
     * Define el valor de la propiedad industryType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndustryType(String value) {
        this.industryType = value;
    }

    /**
     * Obtiene el valor de la propiedad businessType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * Define el valor de la propiedad businessType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBusinessType(String value) {
        this.businessType = value;
    }

    /**
     * Obtiene el valor de la propiedad series.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSeries() {
        return series;
    }

    /**
     * Define el valor de la propiedad series.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSeries(Long value) {
        this.series = value;
    }

    /**
     * Obtiene el valor de la propiedad automaticPosting.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutomaticPosting() {
        return automaticPosting;
    }

    /**
     * Define el valor de la propiedad automaticPosting.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutomaticPosting(String value) {
        this.automaticPosting = value;
    }

    /**
     * Obtiene el valor de la propiedad interestAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestAccount() {
        return interestAccount;
    }

    /**
     * Define el valor de la propiedad interestAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestAccount(String value) {
        this.interestAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad feeAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAccount() {
        return feeAccount;
    }

    /**
     * Define el valor de la propiedad feeAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAccount(String value) {
        this.feeAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad campaignNumber.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignNumber() {
        return campaignNumber;
    }

    /**
     * Define el valor de la propiedad campaignNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignNumber(Long value) {
        this.campaignNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad aliasName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliasName() {
        return aliasName;
    }

    /**
     * Define el valor de la propiedad aliasName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliasName(String value) {
        this.aliasName = value;
    }

    /**
     * Obtiene el valor de la propiedad defaultBlanketAgreementNumber.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDefaultBlanketAgreementNumber() {
        return defaultBlanketAgreementNumber;
    }

    /**
     * Define el valor de la propiedad defaultBlanketAgreementNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDefaultBlanketAgreementNumber(Long value) {
        this.defaultBlanketAgreementNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad effectiveDiscount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDiscount() {
        return effectiveDiscount;
    }

    /**
     * Define el valor de la propiedad effectiveDiscount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDiscount(String value) {
        this.effectiveDiscount = value;
    }

    /**
     * Obtiene el valor de la propiedad noDiscounts.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoDiscounts() {
        return noDiscounts;
    }

    /**
     * Define el valor de la propiedad noDiscounts.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoDiscounts(String value) {
        this.noDiscounts = value;
    }

    /**
     * Obtiene el valor de la propiedad globalLocationNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlobalLocationNumber() {
        return globalLocationNumber;
    }

    /**
     * Define el valor de la propiedad globalLocationNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlobalLocationNumber(String value) {
        this.globalLocationNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad ediSenderID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDISenderID() {
        return ediSenderID;
    }

    /**
     * Define el valor de la propiedad ediSenderID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDISenderID(String value) {
        this.ediSenderID = value;
    }

    /**
     * Obtiene el valor de la propiedad ediRecipientID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEDIRecipientID() {
        return ediRecipientID;
    }

    /**
     * Define el valor de la propiedad ediRecipientID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEDIRecipientID(String value) {
        this.ediRecipientID = value;
    }

    /**
     * Obtiene el valor de la propiedad residenNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResidenNumber() {
        return residenNumber;
    }

    /**
     * Define el valor de la propiedad residenNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResidenNumber(String value) {
        this.residenNumber = value;
    }

    /**
     * Obtiene el valor de la propiedad relationshipCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipCode() {
        return relationshipCode;
    }

    /**
     * Define el valor de la propiedad relationshipCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipCode(String value) {
        this.relationshipCode = value;
    }

    /**
     * Obtiene el valor de la propiedad relationshipDateFrom.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRelationshipDateFrom() {
        return relationshipDateFrom;
    }

    /**
     * Define el valor de la propiedad relationshipDateFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRelationshipDateFrom(XMLGregorianCalendar value) {
        this.relationshipDateFrom = value;
    }

    /**
     * Obtiene el valor de la propiedad relationshipDateTill.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRelationshipDateTill() {
        return relationshipDateTill;
    }

    /**
     * Define el valor de la propiedad relationshipDateTill.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRelationshipDateTill(XMLGregorianCalendar value) {
        this.relationshipDateTill = value;
    }

    /**
     * Obtiene el valor de la propiedad unifiedFederalTaxID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnifiedFederalTaxID() {
        return unifiedFederalTaxID;
    }

    /**
     * Define el valor de la propiedad unifiedFederalTaxID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnifiedFederalTaxID(String value) {
        this.unifiedFederalTaxID = value;
    }

    /**
     * Obtiene el valor de la propiedad attachmentEntry.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAttachmentEntry() {
        return attachmentEntry;
    }

    /**
     * Define el valor de la propiedad attachmentEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAttachmentEntry(Long value) {
        this.attachmentEntry = value;
    }

    /**
     * Obtiene el valor de la propiedad typeOfOperation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfOperation() {
        return typeOfOperation;
    }

    /**
     * Define el valor de la propiedad typeOfOperation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfOperation(String value) {
        this.typeOfOperation = value;
    }

    /**
     * Obtiene el valor de la propiedad ubdErst.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBDErst() {
        return ubdErst;
    }

    /**
     * Define el valor de la propiedad ubdErst.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBDErst(String value) {
        this.ubdErst = value;
    }

    /**
     * Obtiene el valor de la propiedad ubdDatev.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBDDatev() {
        return ubdDatev;
    }

    /**
     * Define el valor de la propiedad ubdDatev.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBDDatev(String value) {
        this.ubdDatev = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcortc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCORTC() {
        return ubpcortc;
    }

    /**
     * Define el valor de la propiedad ubpcortc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCORTC(String value) {
        this.ubpcortc = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcotdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOTDC() {
        return ubpcotdc;
    }

    /**
     * Define el valor de la propiedad ubpcotdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOTDC(String value) {
        this.ubpcotdc = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcocs.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOCS() {
        return ubpcocs;
    }

    /**
     * Define el valor de la propiedad ubpcocs.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOCS(String value) {
        this.ubpcocs = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcoCity.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOCity() {
        return ubpcoCity;
    }

    /**
     * Define el valor de la propiedad ubpcoCity.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOCity(String value) {
        this.ubpcoCity = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcotp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOTP() {
        return ubpcotp;
    }

    /**
     * Define el valor de la propiedad ubpcotp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOTP(String value) {
        this.ubpcotp = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcoNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCONombre() {
        return ubpcoNombre;
    }

    /**
     * Define el valor de la propiedad ubpcoNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCONombre(String value) {
        this.ubpcoNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpco1Apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCO1Apellido() {
        return ubpco1Apellido;
    }

    /**
     * Define el valor de la propiedad ubpco1Apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCO1Apellido(String value) {
        this.ubpco1Apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpco2Apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCO2Apellido() {
        return ubpco2Apellido;
    }

    /**
     * Define el valor de la propiedad ubpco2Apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCO2Apellido(String value) {
        this.ubpco2Apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcobpExt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOBPExt() {
        return ubpcobpExt;
    }

    /**
     * Define el valor de la propiedad ubpcobpExt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOBPExt(String value) {
        this.ubpcobpExt = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcotbpe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOTBPE() {
        return ubpcotbpe;
    }

    /**
     * Define el valor de la propiedad ubpcotbpe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOTBPE(String value) {
        this.ubpcotbpe = value;
    }

    /**
     * Obtiene el valor de la propiedad ubpcoAddress.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUBPCOAddress() {
        return ubpcoAddress;
    }

    /**
     * Define el valor de la propiedad ubpcoAddress.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUBPCOAddress(String value) {
        this.ubpcoAddress = value;
    }

    /**
     * Obtiene el valor de la propiedad uManejo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUManejo() {
        return uManejo;
    }

    /**
     * Define el valor de la propiedad uManejo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUManejo(String value) {
        this.uManejo = value;
    }

    /**
     * Obtiene el valor de la propiedad ufeccrea.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUFECCREA() {
        return ufeccrea;
    }

    /**
     * Define el valor de la propiedad ufeccrea.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUFECCREA(XMLGregorianCalendar value) {
        this.ufeccrea = value;
    }

    /**
     * Obtiene el valor de la propiedad utrasp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUTRASP() {
        return utrasp;
    }

    /**
     * Define el valor de la propiedad utrasp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUTRASP(String value) {
        this.utrasp = value;
    }

    /**
     * Obtiene el valor de la propiedad utiempotra.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUTIEMPOTRA() {
        return utiempotra;
    }

    /**
     * Define el valor de la propiedad utiempotra.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUTIEMPOTRA(Long value) {
        this.utiempotra = value;
    }

    /**
     * Obtiene el valor de la propiedad upromdiaspago.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUPROMDIASPAGO() {
        return upromdiaspago;
    }

    /**
     * Define el valor de la propiedad upromdiaspago.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUPROMDIASPAGO(Double value) {
        this.upromdiaspago = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxviv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUVLGXVIV() {
        return uvlgxviv;
    }

    /**
     * Define el valor de la propiedad uvlgxviv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUVLGXVIV(String value) {
        this.uvlgxviv = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxlt.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXLT() {
        return uvlgxlt;
    }

    /**
     * Define el valor de la propiedad uvlgxlt.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXLT(Long value) {
        this.uvlgxlt = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxof.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXOF() {
        return uvlgxof;
    }

    /**
     * Define el valor de la propiedad uvlgxof.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXOF(Long value) {
        this.uvlgxof = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxplc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUVLGXPLC() {
        return uvlgxplc;
    }

    /**
     * Define el valor de la propiedad uvlgxplc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUVLGXPLC(String value) {
        this.uvlgxplc = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxvfq.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXVFQ() {
        return uvlgxvfq;
    }

    /**
     * Define el valor de la propiedad uvlgxvfq.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXVFQ(Long value) {
        this.uvlgxvfq = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxvfw.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXVFW() {
        return uvlgxvfw;
    }

    /**
     * Define el valor de la propiedad uvlgxvfw.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXVFW(Long value) {
        this.uvlgxvfw = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxvfm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXVFM() {
        return uvlgxvfm;
    }

    /**
     * Define el valor de la propiedad uvlgxvfm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXVFM(Long value) {
        this.uvlgxvfm = value;
    }

    /**
     * Obtiene el valor de la propiedad uvlgxvfv.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUVLGXVFV() {
        return uvlgxvfv;
    }

    /**
     * Define el valor de la propiedad uvlgxvfv.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUVLGXVFV(Long value) {
        this.uvlgxvfv = value;
    }

    /**
     * Obtiene el valor de la propiedad uEsAutorret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUEsAutorret() {
        return uEsAutorret;
    }

    /**
     * Define el valor de la propiedad uEsAutorret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUEsAutorret(String value) {
        this.uEsAutorret = value;
    }

    /**
     * Obtiene el valor de la propiedad uok1ACECO.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUOK1ACECO() {
        return uok1ACECO;
    }

    /**
     * Define el valor de la propiedad uok1ACECO.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUOK1ACECO(String value) {
        this.uok1ACECO = value;
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
    /**
     * Obtiene el valor de la propiedad bpAddresses.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPAddresses }
     *     
     */
    public BusinessPartner.BPAddresses getBPAddresses() {
        return bpAddresses;
    }

    /**
     * Define el valor de la propiedad bpAddresses.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPAddresses }
     *     
     */
    public void setBPAddresses(BusinessPartner.BPAddresses value) {
        this.bpAddresses = value;
    }

    /**
     * Obtiene el valor de la propiedad contactEmployees.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.ContactEmployees }
     *     
     */
    public BusinessPartner.ContactEmployees getContactEmployees() {
        return contactEmployees;
    }

    /**
     * Define el valor de la propiedad contactEmployees.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.ContactEmployees }
     *     
     */
    public void setContactEmployees(BusinessPartner.ContactEmployees value) {
        this.contactEmployees = value;
    }

    /**
     * Obtiene el valor de la propiedad bpAccountReceivablePaybleCollection.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPAccountReceivablePaybleCollection }
     *     
     */
    public BusinessPartner.BPAccountReceivablePaybleCollection getBPAccountReceivablePaybleCollection() {
        return bpAccountReceivablePaybleCollection;
    }

    /**
     * Define el valor de la propiedad bpAccountReceivablePaybleCollection.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPAccountReceivablePaybleCollection }
     *     
     */
    public void setBPAccountReceivablePaybleCollection(BusinessPartner.BPAccountReceivablePaybleCollection value) {
        this.bpAccountReceivablePaybleCollection = value;
    }

    /**
     * Obtiene el valor de la propiedad bpPaymentMethods.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPPaymentMethods }
     *     
     */
    public BusinessPartner.BPPaymentMethods getBPPaymentMethods() {
        return bpPaymentMethods;
    }

    /**
     * Define el valor de la propiedad bpPaymentMethods.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPPaymentMethods }
     *     
     */
    public void setBPPaymentMethods(BusinessPartner.BPPaymentMethods value) {
        this.bpPaymentMethods = value;
    }

    /**
     * Obtiene el valor de la propiedad bpWithholdingTaxCollection.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPWithholdingTaxCollection }
     *     
     */
    public BusinessPartner.BPWithholdingTaxCollection getBPWithholdingTaxCollection() {
        return bpWithholdingTaxCollection;
    }

    /**
     * Define el valor de la propiedad bpWithholdingTaxCollection.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPWithholdingTaxCollection }
     *     
     */
    public void setBPWithholdingTaxCollection(BusinessPartner.BPWithholdingTaxCollection value) {
        this.bpWithholdingTaxCollection = value;
    }

    /**
     * Obtiene el valor de la propiedad bpPaymentDates.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPPaymentDates }
     *     
     */
    public BusinessPartner.BPPaymentDates getBPPaymentDates() {
        return bpPaymentDates;
    }

    /**
     * Define el valor de la propiedad bpPaymentDates.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPPaymentDates }
     *     
     */
    public void setBPPaymentDates(BusinessPartner.BPPaymentDates value) {
        this.bpPaymentDates = value;
    }

    /**
     * Obtiene el valor de la propiedad bpBranchAssignment.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPBranchAssignment }
     *     
     */
    public BusinessPartner.BPBranchAssignment getBPBranchAssignment() {
        return bpBranchAssignment;
    }

    /**
     * Define el valor de la propiedad bpBranchAssignment.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPBranchAssignment }
     *     
     */
    public void setBPBranchAssignment(BusinessPartner.BPBranchAssignment value) {
        this.bpBranchAssignment = value;
    }

    /**
     * Obtiene el valor de la propiedad bpBankAccounts.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPBankAccounts }
     *     
     */
    public BusinessPartner.BPBankAccounts getBPBankAccounts() {
        return bpBankAccounts;
    }

    /**
     * Define el valor de la propiedad bpBankAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPBankAccounts }
     *     
     */
    public void setBPBankAccounts(BusinessPartner.BPBankAccounts value) {
        this.bpBankAccounts = value;
    }

    /**
     * Obtiene el valor de la propiedad bpFiscalTaxIDCollection.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPFiscalTaxIDCollection }
     *     
     */
    public BusinessPartner.BPFiscalTaxIDCollection getBPFiscalTaxIDCollection() {
        return bpFiscalTaxIDCollection;
    }

    /**
     * Define el valor de la propiedad bpFiscalTaxIDCollection.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPFiscalTaxIDCollection }
     *     
     */
    public void setBPFiscalTaxIDCollection(BusinessPartner.BPFiscalTaxIDCollection value) {
        this.bpFiscalTaxIDCollection = value;
    }

    /**
     * Obtiene el valor de la propiedad discountGroups.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.DiscountGroups }
     *     
     */
    public BusinessPartner.DiscountGroups getDiscountGroups() {
        return discountGroups;
    }

    /**
     * Define el valor de la propiedad discountGroups.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.DiscountGroups }
     *     
     */
    public void setDiscountGroups(BusinessPartner.DiscountGroups value) {
        this.discountGroups = value;
    }

    /**
     * Obtiene el valor de la propiedad bpIntrastatExtension.
     * 
     * @return
     *     possible object is
     *     {@link BusinessPartner.BPIntrastatExtension }
     *     
     */
    public BusinessPartner.BPIntrastatExtension getBPIntrastatExtension() {
        return bpIntrastatExtension;
    }

    /**
     * Define el valor de la propiedad bpIntrastatExtension.
     * 
     * @param value
     *     allowed object is
     *     {@link BusinessPartner.BPIntrastatExtension }
     *     
     */
    public void setBPIntrastatExtension(BusinessPartner.BPIntrastatExtension value) {
        this.bpIntrastatExtension = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPAccountReceivablePayble" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="AccountType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="bpat_General"/>
     *                         &lt;enumeration value="bpat_DownPayment"/>
     *                         &lt;enumeration value="bpat_AssetsAccount"/>
     *                         &lt;enumeration value="bpat_Receivable"/>
     *                         &lt;enumeration value="bpat_Payable"/>
     *                         &lt;enumeration value="bpat_OnCollection"/>
     *                         &lt;enumeration value="bpat_Presentation"/>
     *                         &lt;enumeration value="bpat_AssetsPayable"/>
     *                         &lt;enumeration value="bpat_Discounted"/>
     *                         &lt;enumeration value="bpat_Unpaid"/>
     *                         &lt;enumeration value="bpat_OpenDebts"/>
     *                         &lt;enumeration value="bpat_Domestic"/>
     *                         &lt;enumeration value="bpat_Foreign"/>
     *                         &lt;enumeration value="bpat_CashDiscountInterim"/>
     *                         &lt;enumeration value="bpat_ExchangeRateInterim"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpAccountReceivablePayble"
    })
    public static class BPAccountReceivablePaybleCollection {

        @XmlElement(name = "BPAccountReceivablePayble")
        protected List<BusinessPartner.BPAccountReceivablePaybleCollection.BPAccountReceivablePayble> bpAccountReceivablePayble;

        /**
         * Gets the value of the bpAccountReceivablePayble property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpAccountReceivablePayble property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPAccountReceivablePayble().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPAccountReceivablePaybleCollection.BPAccountReceivablePayble }
         * 
         * 
         */
        public List<BusinessPartner.BPAccountReceivablePaybleCollection.BPAccountReceivablePayble> getBPAccountReceivablePayble() {
            if (bpAccountReceivablePayble == null) {
                bpAccountReceivablePayble = new ArrayList<BusinessPartner.BPAccountReceivablePaybleCollection.BPAccountReceivablePayble>();
            }
            return this.bpAccountReceivablePayble;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="AccountType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="bpat_General"/>
         *               &lt;enumeration value="bpat_DownPayment"/>
         *               &lt;enumeration value="bpat_AssetsAccount"/>
         *               &lt;enumeration value="bpat_Receivable"/>
         *               &lt;enumeration value="bpat_Payable"/>
         *               &lt;enumeration value="bpat_OnCollection"/>
         *               &lt;enumeration value="bpat_Presentation"/>
         *               &lt;enumeration value="bpat_AssetsPayable"/>
         *               &lt;enumeration value="bpat_Discounted"/>
         *               &lt;enumeration value="bpat_Unpaid"/>
         *               &lt;enumeration value="bpat_OpenDebts"/>
         *               &lt;enumeration value="bpat_Domestic"/>
         *               &lt;enumeration value="bpat_Foreign"/>
         *               &lt;enumeration value="bpat_CashDiscountInterim"/>
         *               &lt;enumeration value="bpat_ExchangeRateInterim"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPAccountReceivablePayble {

            @XmlElement(name = "AccountType")
            protected String accountType;
            @XmlElement(name = "AccountCode")
            protected String accountCode;
            @XmlElement(name = "BPCode")
            protected String bpCode;

            /**
             * Obtiene el valor de la propiedad accountType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountType() {
                return accountType;
            }

            /**
             * Define el valor de la propiedad accountType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountType(String value) {
                this.accountType = value;
            }

            /**
             * Obtiene el valor de la propiedad accountCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountCode() {
                return accountCode;
            }

            /**
             * Define el valor de la propiedad accountCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountCode(String value) {
                this.accountCode = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPAddress" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="AddressName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="FederalTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AddressType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="bo_ShipTo"/>
     *                         &lt;enumeration value="bo_BillTo"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="AddressName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AddressName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TypeOfAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="StreetNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RowNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="GlobalLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="U_Municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpAddress"
    })
    public static class BPAddresses {

        @XmlElement(name = "BPAddress")
        protected List<BusinessPartner.BPAddresses.BPAddress> bpAddress;

        /**
         * Gets the value of the bpAddress property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpAddress property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPAddress().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPAddresses.BPAddress }
         * 
         * 
         */
        public List<BusinessPartner.BPAddresses.BPAddress> getBPAddress() {
            if (bpAddress == null) {
                bpAddress = new ArrayList<BusinessPartner.BPAddresses.BPAddress>();
            }
            return this.bpAddress;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="AddressName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="FederalTaxID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AddressType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="bo_ShipTo"/>
         *               &lt;enumeration value="bo_BillTo"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="AddressName2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AddressName3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TypeOfAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="StreetNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RowNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="GlobalLocationNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Nationality" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="U_Municipio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPAddress {

            @XmlElement(name = "AddressName")
            protected String addressName;
            @XmlElement(name = "Street")
            protected String street;
            @XmlElement(name = "Block")
            protected String block;
            @XmlElement(name = "ZipCode")
            protected String zipCode;
            @XmlElement(name = "City")
            protected String city;
            @XmlElement(name = "County")
            protected String county;
            @XmlElement(name = "Country")
            protected String country;
            @XmlElement(name = "State")
            protected String state;
            @XmlElement(name = "FederalTaxID")
            protected String federalTaxID;
            @XmlElement(name = "TaxCode")
            protected String taxCode;
            @XmlElement(name = "BuildingFloorRoom")
            protected String buildingFloorRoom;
            @XmlElement(name = "AddressType")
            protected String addressType;
            @XmlElement(name = "AddressName2")
            protected String addressName2;
            @XmlElement(name = "AddressName3")
            protected String addressName3;
            @XmlElement(name = "TypeOfAddress")
            protected String typeOfAddress;
            @XmlElement(name = "StreetNo")
            protected String streetNo;
            @XmlElement(name = "BPCode")
            protected String bpCode;
            @XmlElement(name = "RowNum")
            protected Long rowNum;
            @XmlElement(name = "GlobalLocationNumber")
            protected String globalLocationNumber;
            @XmlElement(name = "Nationality")
            protected String nationality;
            @XmlElement(name = "U_Municipio")
            protected String uMunicipio;

            /**
             * Obtiene el valor de la propiedad addressName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressName() {
                return addressName;
            }

            /**
             * Define el valor de la propiedad addressName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressName(String value) {
                this.addressName = value;
            }

            /**
             * Obtiene el valor de la propiedad street.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStreet() {
                return street;
            }

            /**
             * Define el valor de la propiedad street.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStreet(String value) {
                this.street = value;
            }

            /**
             * Obtiene el valor de la propiedad block.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBlock() {
                return block;
            }

            /**
             * Define el valor de la propiedad block.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBlock(String value) {
                this.block = value;
            }

            /**
             * Obtiene el valor de la propiedad zipCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZipCode() {
                return zipCode;
            }

            /**
             * Define el valor de la propiedad zipCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZipCode(String value) {
                this.zipCode = value;
            }

            /**
             * Obtiene el valor de la propiedad city.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCity() {
                return city;
            }

            /**
             * Define el valor de la propiedad city.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Obtiene el valor de la propiedad county.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCounty() {
                return county;
            }

            /**
             * Define el valor de la propiedad county.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCounty(String value) {
                this.county = value;
            }

            /**
             * Obtiene el valor de la propiedad country.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Define el valor de la propiedad country.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Obtiene el valor de la propiedad state.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Define el valor de la propiedad state.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Obtiene el valor de la propiedad federalTaxID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFederalTaxID() {
                return federalTaxID;
            }

            /**
             * Define el valor de la propiedad federalTaxID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFederalTaxID(String value) {
                this.federalTaxID = value;
            }

            /**
             * Obtiene el valor de la propiedad taxCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxCode() {
                return taxCode;
            }

            /**
             * Define el valor de la propiedad taxCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxCode(String value) {
                this.taxCode = value;
            }

            /**
             * Obtiene el valor de la propiedad buildingFloorRoom.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuildingFloorRoom() {
                return buildingFloorRoom;
            }

            /**
             * Define el valor de la propiedad buildingFloorRoom.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuildingFloorRoom(String value) {
                this.buildingFloorRoom = value;
            }

            /**
             * Obtiene el valor de la propiedad addressType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressType() {
                return addressType;
            }

            /**
             * Define el valor de la propiedad addressType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressType(String value) {
                this.addressType = value;
            }

            /**
             * Obtiene el valor de la propiedad addressName2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressName2() {
                return addressName2;
            }

            /**
             * Define el valor de la propiedad addressName2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressName2(String value) {
                this.addressName2 = value;
            }

            /**
             * Obtiene el valor de la propiedad addressName3.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddressName3() {
                return addressName3;
            }

            /**
             * Define el valor de la propiedad addressName3.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddressName3(String value) {
                this.addressName3 = value;
            }

            /**
             * Obtiene el valor de la propiedad typeOfAddress.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTypeOfAddress() {
                return typeOfAddress;
            }

            /**
             * Define el valor de la propiedad typeOfAddress.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTypeOfAddress(String value) {
                this.typeOfAddress = value;
            }

            /**
             * Obtiene el valor de la propiedad streetNo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStreetNo() {
                return streetNo;
            }

            /**
             * Define el valor de la propiedad streetNo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStreetNo(String value) {
                this.streetNo = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

            /**
             * Obtiene el valor de la propiedad rowNum.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getRowNum() {
                return rowNum;
            }

            /**
             * Define el valor de la propiedad rowNum.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setRowNum(Long value) {
                this.rowNum = value;
            }

            /**
             * Obtiene el valor de la propiedad globalLocationNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGlobalLocationNumber() {
                return globalLocationNumber;
            }

            /**
             * Define el valor de la propiedad globalLocationNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGlobalLocationNumber(String value) {
                this.globalLocationNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad nationality.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNationality() {
                return nationality;
            }

            /**
             * Define el valor de la propiedad nationality.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNationality(String value) {
                this.nationality = value;
            }

            /**
             * Obtiene el valor de la propiedad uMunicipio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUMunicipio() {
                return uMunicipio;
            }

            /**
             * Define el valor de la propiedad uMunicipio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUMunicipio(String value) {
                this.uMunicipio = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPBankAccount" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="LogInstance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="UserNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="UserNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ControlKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="UserNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="UserNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="InternalKey" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BIK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CorrespondentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CustomerIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ISRBillerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ISRType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="BICSwiftCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ABARoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MandateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SignatureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="MandateExpDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="SEPASeqType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="sstOOFF"/>
     *                         &lt;enumeration value="sstFRST"/>
     *                         &lt;enumeration value="sstRCUR"/>
     *                         &lt;enumeration value="sstFNAL"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpBankAccount"
    })
    public static class BPBankAccounts {

        @XmlElement(name = "BPBankAccount")
        protected List<BusinessPartner.BPBankAccounts.BPBankAccount> bpBankAccount;

        /**
         * Gets the value of the bpBankAccount property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpBankAccount property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPBankAccount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPBankAccounts.BPBankAccount }
         * 
         * 
         */
        public List<BusinessPartner.BPBankAccounts.BPBankAccount> getBPBankAccount() {
            if (bpBankAccount == null) {
                bpBankAccount = new ArrayList<BusinessPartner.BPBankAccounts.BPBankAccount>();
            }
            return this.bpBankAccount;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="LogInstance" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="UserNo4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="State" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="UserNo2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="IBAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ZipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ControlKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="UserNo3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="UserNo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="InternalKey" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="BuildingFloorRoom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BIK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CorrespondentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Phone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CustomerIdNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ISRBillerID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ISRType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="BICSwiftCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ABARoutingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MandateID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SignatureDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="MandateExpDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="SEPASeqType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="sstOOFF"/>
         *               &lt;enumeration value="sstFRST"/>
         *               &lt;enumeration value="sstRCUR"/>
         *               &lt;enumeration value="sstFNAL"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPBankAccount {

            @XmlElement(name = "LogInstance")
            protected Long logInstance;
            @XmlElement(name = "UserNo4")
            protected String userNo4;
            @XmlElement(name = "BPCode")
            protected String bpCode;
            @XmlElement(name = "County")
            protected String county;
            @XmlElement(name = "State")
            protected String state;
            @XmlElement(name = "UserNo2")
            protected String userNo2;
            @XmlElement(name = "IBAN")
            protected String iban;
            @XmlElement(name = "ZipCode")
            protected String zipCode;
            @XmlElement(name = "City")
            protected String city;
            @XmlElement(name = "Block")
            protected String block;
            @XmlElement(name = "Branch")
            protected String branch;
            @XmlElement(name = "Country")
            protected String country;
            @XmlElement(name = "Street")
            protected String street;
            @XmlElement(name = "ControlKey")
            protected String controlKey;
            @XmlElement(name = "UserNo3")
            protected String userNo3;
            @XmlElement(name = "BankCode")
            protected String bankCode;
            @XmlElement(name = "AccountNo")
            protected String accountNo;
            @XmlElement(name = "UserNo1")
            protected String userNo1;
            @XmlElement(name = "InternalKey")
            protected Long internalKey;
            @XmlElement(name = "BuildingFloorRoom")
            protected String buildingFloorRoom;
            @XmlElement(name = "BIK")
            protected String bik;
            @XmlElement(name = "AccountName")
            protected String accountName;
            @XmlElement(name = "CorrespondentAccount")
            protected String correspondentAccount;
            @XmlElement(name = "Phone")
            protected String phone;
            @XmlElement(name = "Fax")
            protected String fax;
            @XmlElement(name = "CustomerIdNumber")
            protected String customerIdNumber;
            @XmlElement(name = "ISRBillerID")
            protected String isrBillerID;
            @XmlElement(name = "ISRType")
            protected Long isrType;
            @XmlElement(name = "BICSwiftCode")
            protected String bicSwiftCode;
            @XmlElement(name = "ABARoutingNumber")
            protected String abaRoutingNumber;
            @XmlElement(name = "MandateID")
            protected String mandateID;
            @XmlElement(name = "SignatureDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar signatureDate;
            @XmlElement(name = "MandateExpDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar mandateExpDate;
            @XmlElement(name = "SEPASeqType")
            protected String sepaSeqType;

            /**
             * Obtiene el valor de la propiedad logInstance.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLogInstance() {
                return logInstance;
            }

            /**
             * Define el valor de la propiedad logInstance.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLogInstance(Long value) {
                this.logInstance = value;
            }

            /**
             * Obtiene el valor de la propiedad userNo4.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserNo4() {
                return userNo4;
            }

            /**
             * Define el valor de la propiedad userNo4.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserNo4(String value) {
                this.userNo4 = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

            /**
             * Obtiene el valor de la propiedad county.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCounty() {
                return county;
            }

            /**
             * Define el valor de la propiedad county.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCounty(String value) {
                this.county = value;
            }

            /**
             * Obtiene el valor de la propiedad state.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getState() {
                return state;
            }

            /**
             * Define el valor de la propiedad state.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setState(String value) {
                this.state = value;
            }

            /**
             * Obtiene el valor de la propiedad userNo2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserNo2() {
                return userNo2;
            }

            /**
             * Define el valor de la propiedad userNo2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserNo2(String value) {
                this.userNo2 = value;
            }

            /**
             * Obtiene el valor de la propiedad iban.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getIBAN() {
                return iban;
            }

            /**
             * Define el valor de la propiedad iban.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setIBAN(String value) {
                this.iban = value;
            }

            /**
             * Obtiene el valor de la propiedad zipCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getZipCode() {
                return zipCode;
            }

            /**
             * Define el valor de la propiedad zipCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setZipCode(String value) {
                this.zipCode = value;
            }

            /**
             * Obtiene el valor de la propiedad city.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCity() {
                return city;
            }

            /**
             * Define el valor de la propiedad city.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCity(String value) {
                this.city = value;
            }

            /**
             * Obtiene el valor de la propiedad block.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBlock() {
                return block;
            }

            /**
             * Define el valor de la propiedad block.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBlock(String value) {
                this.block = value;
            }

            /**
             * Obtiene el valor de la propiedad branch.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBranch() {
                return branch;
            }

            /**
             * Define el valor de la propiedad branch.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBranch(String value) {
                this.branch = value;
            }

            /**
             * Obtiene el valor de la propiedad country.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Define el valor de la propiedad country.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Obtiene el valor de la propiedad street.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getStreet() {
                return street;
            }

            /**
             * Define el valor de la propiedad street.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setStreet(String value) {
                this.street = value;
            }

            /**
             * Obtiene el valor de la propiedad controlKey.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getControlKey() {
                return controlKey;
            }

            /**
             * Define el valor de la propiedad controlKey.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setControlKey(String value) {
                this.controlKey = value;
            }

            /**
             * Obtiene el valor de la propiedad userNo3.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserNo3() {
                return userNo3;
            }

            /**
             * Define el valor de la propiedad userNo3.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserNo3(String value) {
                this.userNo3 = value;
            }

            /**
             * Obtiene el valor de la propiedad bankCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBankCode() {
                return bankCode;
            }

            /**
             * Define el valor de la propiedad bankCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBankCode(String value) {
                this.bankCode = value;
            }

            /**
             * Obtiene el valor de la propiedad accountNo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountNo() {
                return accountNo;
            }

            /**
             * Define el valor de la propiedad accountNo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountNo(String value) {
                this.accountNo = value;
            }

            /**
             * Obtiene el valor de la propiedad userNo1.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUserNo1() {
                return userNo1;
            }

            /**
             * Define el valor de la propiedad userNo1.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUserNo1(String value) {
                this.userNo1 = value;
            }

            /**
             * Obtiene el valor de la propiedad internalKey.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getInternalKey() {
                return internalKey;
            }

            /**
             * Define el valor de la propiedad internalKey.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setInternalKey(Long value) {
                this.internalKey = value;
            }

            /**
             * Obtiene el valor de la propiedad buildingFloorRoom.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBuildingFloorRoom() {
                return buildingFloorRoom;
            }

            /**
             * Define el valor de la propiedad buildingFloorRoom.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBuildingFloorRoom(String value) {
                this.buildingFloorRoom = value;
            }

            /**
             * Obtiene el valor de la propiedad bik.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBIK() {
                return bik;
            }

            /**
             * Define el valor de la propiedad bik.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBIK(String value) {
                this.bik = value;
            }

            /**
             * Obtiene el valor de la propiedad accountName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccountName() {
                return accountName;
            }

            /**
             * Define el valor de la propiedad accountName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccountName(String value) {
                this.accountName = value;
            }

            /**
             * Obtiene el valor de la propiedad correspondentAccount.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCorrespondentAccount() {
                return correspondentAccount;
            }

            /**
             * Define el valor de la propiedad correspondentAccount.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCorrespondentAccount(String value) {
                this.correspondentAccount = value;
            }

            /**
             * Obtiene el valor de la propiedad phone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone() {
                return phone;
            }

            /**
             * Define el valor de la propiedad phone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone(String value) {
                this.phone = value;
            }

            /**
             * Obtiene el valor de la propiedad fax.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFax() {
                return fax;
            }

            /**
             * Define el valor de la propiedad fax.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFax(String value) {
                this.fax = value;
            }

            /**
             * Obtiene el valor de la propiedad customerIdNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCustomerIdNumber() {
                return customerIdNumber;
            }

            /**
             * Define el valor de la propiedad customerIdNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCustomerIdNumber(String value) {
                this.customerIdNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad isrBillerID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getISRBillerID() {
                return isrBillerID;
            }

            /**
             * Define el valor de la propiedad isrBillerID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setISRBillerID(String value) {
                this.isrBillerID = value;
            }

            /**
             * Obtiene el valor de la propiedad isrType.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getISRType() {
                return isrType;
            }

            /**
             * Define el valor de la propiedad isrType.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setISRType(Long value) {
                this.isrType = value;
            }

            /**
             * Obtiene el valor de la propiedad bicSwiftCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBICSwiftCode() {
                return bicSwiftCode;
            }

            /**
             * Define el valor de la propiedad bicSwiftCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBICSwiftCode(String value) {
                this.bicSwiftCode = value;
            }

            /**
             * Obtiene el valor de la propiedad abaRoutingNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getABARoutingNumber() {
                return abaRoutingNumber;
            }

            /**
             * Define el valor de la propiedad abaRoutingNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setABARoutingNumber(String value) {
                this.abaRoutingNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad mandateID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMandateID() {
                return mandateID;
            }

            /**
             * Define el valor de la propiedad mandateID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMandateID(String value) {
                this.mandateID = value;
            }

            /**
             * Obtiene el valor de la propiedad signatureDate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getSignatureDate() {
                return signatureDate;
            }

            /**
             * Define el valor de la propiedad signatureDate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setSignatureDate(XMLGregorianCalendar value) {
                this.signatureDate = value;
            }

            /**
             * Obtiene el valor de la propiedad mandateExpDate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getMandateExpDate() {
                return mandateExpDate;
            }

            /**
             * Define el valor de la propiedad mandateExpDate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setMandateExpDate(XMLGregorianCalendar value) {
                this.mandateExpDate = value;
            }

            /**
             * Obtiene el valor de la propiedad sepaSeqType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSEPASeqType() {
                return sepaSeqType;
            }

            /**
             * Define el valor de la propiedad sepaSeqType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSEPASeqType(String value) {
                this.sepaSeqType = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPBranchAssignmentItem" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPLID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpBranchAssignmentItem"
    })
    public static class BPBranchAssignment {

        @XmlElement(name = "BPBranchAssignmentItem")
        protected List<BusinessPartner.BPBranchAssignment.BPBranchAssignmentItem> bpBranchAssignmentItem;

        /**
         * Gets the value of the bpBranchAssignmentItem property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpBranchAssignmentItem property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPBranchAssignmentItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPBranchAssignment.BPBranchAssignmentItem }
         * 
         * 
         */
        public List<BusinessPartner.BPBranchAssignment.BPBranchAssignmentItem> getBPBranchAssignmentItem() {
            if (bpBranchAssignmentItem == null) {
                bpBranchAssignmentItem = new ArrayList<BusinessPartner.BPBranchAssignment.BPBranchAssignmentItem>();
            }
            return this.bpBranchAssignmentItem;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPLID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPBranchAssignmentItem {

            @XmlElement(name = "BPCode")
            protected String bpCode;
            @XmlElement(name = "BPLID")
            protected Long bplid;

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

            /**
             * Obtiene el valor de la propiedad bplid.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getBPLID() {
                return bplid;
            }

            /**
             * Define el valor de la propiedad bplid.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setBPLID(Long value) {
                this.bplid = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPFiscalTaxID" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CNAECode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="TaxId0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AddrType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="bo_ShipTo"/>
     *                         &lt;enumeration value="bo_BillTo"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="TaxId12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TaxId13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpFiscalTaxID"
    })
    public static class BPFiscalTaxIDCollection {

        @XmlElement(name = "BPFiscalTaxID")
        protected List<BusinessPartner.BPFiscalTaxIDCollection.BPFiscalTaxID> bpFiscalTaxID;

        /**
         * Gets the value of the bpFiscalTaxID property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpFiscalTaxID property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPFiscalTaxID().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPFiscalTaxIDCollection.BPFiscalTaxID }
         * 
         * 
         */
        public List<BusinessPartner.BPFiscalTaxIDCollection.BPFiscalTaxID> getBPFiscalTaxID() {
            if (bpFiscalTaxID == null) {
                bpFiscalTaxID = new ArrayList<BusinessPartner.BPFiscalTaxIDCollection.BPFiscalTaxID>();
            }
            return this.bpFiscalTaxID;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CNAECode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="TaxId0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId6" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId7" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId8" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId9" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId10" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId11" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AddrType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="bo_ShipTo"/>
         *               &lt;enumeration value="bo_BillTo"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="TaxId12" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TaxId13" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPFiscalTaxID {

            @XmlElement(name = "Address")
            protected String address;
            @XmlElement(name = "CNAECode")
            protected Long cnaeCode;
            @XmlElement(name = "TaxId0")
            protected String taxId0;
            @XmlElement(name = "TaxId1")
            protected String taxId1;
            @XmlElement(name = "TaxId2")
            protected String taxId2;
            @XmlElement(name = "TaxId3")
            protected String taxId3;
            @XmlElement(name = "TaxId4")
            protected String taxId4;
            @XmlElement(name = "TaxId5")
            protected String taxId5;
            @XmlElement(name = "TaxId6")
            protected String taxId6;
            @XmlElement(name = "TaxId7")
            protected String taxId7;
            @XmlElement(name = "TaxId8")
            protected String taxId8;
            @XmlElement(name = "TaxId9")
            protected String taxId9;
            @XmlElement(name = "TaxId10")
            protected String taxId10;
            @XmlElement(name = "TaxId11")
            protected String taxId11;
            @XmlElement(name = "BPCode")
            protected String bpCode;
            @XmlElement(name = "AddrType")
            protected String addrType;
            @XmlElement(name = "TaxId12")
            protected String taxId12;
            @XmlElement(name = "TaxId13")
            protected String taxId13;

            /**
             * Obtiene el valor de la propiedad address.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Define el valor de la propiedad address.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

            /**
             * Obtiene el valor de la propiedad cnaeCode.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCNAECode() {
                return cnaeCode;
            }

            /**
             * Define el valor de la propiedad cnaeCode.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCNAECode(Long value) {
                this.cnaeCode = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId0.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId0() {
                return taxId0;
            }

            /**
             * Define el valor de la propiedad taxId0.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId0(String value) {
                this.taxId0 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId1.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId1() {
                return taxId1;
            }

            /**
             * Define el valor de la propiedad taxId1.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId1(String value) {
                this.taxId1 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId2() {
                return taxId2;
            }

            /**
             * Define el valor de la propiedad taxId2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId2(String value) {
                this.taxId2 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId3.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId3() {
                return taxId3;
            }

            /**
             * Define el valor de la propiedad taxId3.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId3(String value) {
                this.taxId3 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId4.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId4() {
                return taxId4;
            }

            /**
             * Define el valor de la propiedad taxId4.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId4(String value) {
                this.taxId4 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId5.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId5() {
                return taxId5;
            }

            /**
             * Define el valor de la propiedad taxId5.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId5(String value) {
                this.taxId5 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId6.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId6() {
                return taxId6;
            }

            /**
             * Define el valor de la propiedad taxId6.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId6(String value) {
                this.taxId6 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId7.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId7() {
                return taxId7;
            }

            /**
             * Define el valor de la propiedad taxId7.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId7(String value) {
                this.taxId7 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId8.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId8() {
                return taxId8;
            }

            /**
             * Define el valor de la propiedad taxId8.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId8(String value) {
                this.taxId8 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId9.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId9() {
                return taxId9;
            }

            /**
             * Define el valor de la propiedad taxId9.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId9(String value) {
                this.taxId9 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId10.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId10() {
                return taxId10;
            }

            /**
             * Define el valor de la propiedad taxId10.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId10(String value) {
                this.taxId10 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId11.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId11() {
                return taxId11;
            }

            /**
             * Define el valor de la propiedad taxId11.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId11(String value) {
                this.taxId11 = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

            /**
             * Obtiene el valor de la propiedad addrType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddrType() {
                return addrType;
            }

            /**
             * Define el valor de la propiedad addrType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddrType(String value) {
                this.addrType = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId12.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId12() {
                return taxId12;
            }

            /**
             * Define el valor de la propiedad taxId12.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId12(String value) {
                this.taxId12 = value;
            }

            /**
             * Obtiene el valor de la propiedad taxId13.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTaxId13() {
                return taxId13;
            }

            /**
             * Define el valor de la propiedad taxId13.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTaxId13(String value) {
                this.taxId13 = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="TransportMode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="Incoterms" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="NatureOfTransactions" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="StatisticalProcedure" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="CustomsProcedure" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="PortOfEntryOrExit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="DomesticOrForeignID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="IntrastatRelevant" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="tNO"/>
     *               &lt;enumeration value="tYES"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class BPIntrastatExtension {

        @XmlElement(name = "CardCode")
        protected String cardCode;
        @XmlElement(name = "TransportMode")
        protected Long transportMode;
        @XmlElement(name = "Incoterms")
        protected Long incoterms;
        @XmlElement(name = "NatureOfTransactions")
        protected Long natureOfTransactions;
        @XmlElement(name = "StatisticalProcedure")
        protected Long statisticalProcedure;
        @XmlElement(name = "CustomsProcedure")
        protected Long customsProcedure;
        @XmlElement(name = "PortOfEntryOrExit")
        protected Long portOfEntryOrExit;
        @XmlElement(name = "DomesticOrForeignID")
        protected String domesticOrForeignID;
        @XmlElement(name = "IntrastatRelevant")
        protected String intrastatRelevant;

        /**
         * Obtiene el valor de la propiedad cardCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCardCode() {
            return cardCode;
        }

        /**
         * Define el valor de la propiedad cardCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCardCode(String value) {
            this.cardCode = value;
        }

        /**
         * Obtiene el valor de la propiedad transportMode.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getTransportMode() {
            return transportMode;
        }

        /**
         * Define el valor de la propiedad transportMode.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setTransportMode(Long value) {
            this.transportMode = value;
        }

        /**
         * Obtiene el valor de la propiedad incoterms.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getIncoterms() {
            return incoterms;
        }

        /**
         * Define el valor de la propiedad incoterms.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setIncoterms(Long value) {
            this.incoterms = value;
        }

        /**
         * Obtiene el valor de la propiedad natureOfTransactions.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getNatureOfTransactions() {
            return natureOfTransactions;
        }

        /**
         * Define el valor de la propiedad natureOfTransactions.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setNatureOfTransactions(Long value) {
            this.natureOfTransactions = value;
        }

        /**
         * Obtiene el valor de la propiedad statisticalProcedure.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getStatisticalProcedure() {
            return statisticalProcedure;
        }

        /**
         * Define el valor de la propiedad statisticalProcedure.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setStatisticalProcedure(Long value) {
            this.statisticalProcedure = value;
        }

        /**
         * Obtiene el valor de la propiedad customsProcedure.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getCustomsProcedure() {
            return customsProcedure;
        }

        /**
         * Define el valor de la propiedad customsProcedure.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setCustomsProcedure(Long value) {
            this.customsProcedure = value;
        }

        /**
         * Obtiene el valor de la propiedad portOfEntryOrExit.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getPortOfEntryOrExit() {
            return portOfEntryOrExit;
        }

        /**
         * Define el valor de la propiedad portOfEntryOrExit.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setPortOfEntryOrExit(Long value) {
            this.portOfEntryOrExit = value;
        }

        /**
         * Obtiene el valor de la propiedad domesticOrForeignID.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDomesticOrForeignID() {
            return domesticOrForeignID;
        }

        /**
         * Define el valor de la propiedad domesticOrForeignID.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDomesticOrForeignID(String value) {
            this.domesticOrForeignID = value;
        }

        /**
         * Obtiene el valor de la propiedad intrastatRelevant.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIntrastatRelevant() {
            return intrastatRelevant;
        }

        /**
         * Define el valor de la propiedad intrastatRelevant.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIntrastatRelevant(String value) {
            this.intrastatRelevant = value;
        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPPaymentDate" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpPaymentDate"
    })
    public static class BPPaymentDates {

        @XmlElement(name = "BPPaymentDate")
        protected List<BusinessPartner.BPPaymentDates.BPPaymentDate> bpPaymentDate;

        /**
         * Gets the value of the bpPaymentDate property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpPaymentDate property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPPaymentDate().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPPaymentDates.BPPaymentDate }
         * 
         * 
         */
        public List<BusinessPartner.BPPaymentDates.BPPaymentDate> getBPPaymentDate() {
            if (bpPaymentDate == null) {
                bpPaymentDate = new ArrayList<BusinessPartner.BPPaymentDates.BPPaymentDate>();
            }
            return this.bpPaymentDate;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="PaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPPaymentDate {

            @XmlElement(name = "PaymentDate")
            protected String paymentDate;
            @XmlElement(name = "BPCode")
            protected String bpCode;

            /**
             * Obtiene el valor de la propiedad paymentDate.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentDate() {
                return paymentDate;
            }

            /**
             * Define el valor de la propiedad paymentDate.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentDate(String value) {
                this.paymentDate = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPPaymentMethod" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="RowNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpPaymentMethod"
    })
    public static class BPPaymentMethods {

        @XmlElement(name = "BPPaymentMethod")
        protected List<BusinessPartner.BPPaymentMethods.BPPaymentMethod> bpPaymentMethod;

        /**
         * Gets the value of the bpPaymentMethod property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpPaymentMethod property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPPaymentMethod().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPPaymentMethods.BPPaymentMethod }
         * 
         * 
         */
        public List<BusinessPartner.BPPaymentMethods.BPPaymentMethod> getBPPaymentMethod() {
            if (bpPaymentMethod == null) {
                bpPaymentMethod = new ArrayList<BusinessPartner.BPPaymentMethods.BPPaymentMethod>();
            }
            return this.bpPaymentMethod;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="RowNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPPaymentMethod {

            @XmlElement(name = "PaymentMethodCode")
            protected String paymentMethodCode;
            @XmlElement(name = "RowNumber")
            protected Long rowNumber;
            @XmlElement(name = "BPCode")
            protected String bpCode;

            /**
             * Obtiene el valor de la propiedad paymentMethodCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentMethodCode() {
                return paymentMethodCode;
            }

            /**
             * Define el valor de la propiedad paymentMethodCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentMethodCode(String value) {
                this.paymentMethodCode = value;
            }

            /**
             * Obtiene el valor de la propiedad rowNumber.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getRowNumber() {
                return rowNumber;
            }

            /**
             * Define el valor de la propiedad rowNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setRowNumber(Long value) {
                this.rowNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="BPWithholdingTax" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="WTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "bpWithholdingTax"
    })
    public static class BPWithholdingTaxCollection {

        @XmlElement(name = "BPWithholdingTax")
        protected List<BusinessPartner.BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTax;

        /**
         * Gets the value of the bpWithholdingTax property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the bpWithholdingTax property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBPWithholdingTax().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.BPWithholdingTaxCollection.BPWithholdingTax }
         * 
         * 
         */
        public List<BusinessPartner.BPWithholdingTaxCollection.BPWithholdingTax> getBPWithholdingTax() {
            if (bpWithholdingTax == null) {
                bpWithholdingTax = new ArrayList<BusinessPartner.BPWithholdingTaxCollection.BPWithholdingTax>();
            }
            return this.bpWithholdingTax;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="WTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class BPWithholdingTax {

            @XmlElement(name = "WTCode")
            protected String wtCode;
            @XmlElement(name = "BPCode")
            protected String bpCode;

            /**
             * Obtiene el valor de la propiedad wtCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getWTCode() {
                return wtCode;
            }

            /**
             * Define el valor de la propiedad wtCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setWTCode(String value) {
                this.wtCode = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="ContactEmployee" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="E_Mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Pager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Remarks1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Remarks2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="InternalCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="PlaceOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="Gender" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="gt_Female"/>
     *                         &lt;enumeration value="gt_Male"/>
     *                         &lt;enumeration value="gt_Undefined"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Profession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CityOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Active" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="tNO"/>
     *                         &lt;enumeration value="tYES"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="EmailGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "contactEmployee"
    })
    public static class ContactEmployees {

        @XmlElement(name = "ContactEmployee")
        protected List<BusinessPartner.ContactEmployees.ContactEmployee> contactEmployee;

        /**
         * Gets the value of the contactEmployee property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contactEmployee property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContactEmployee().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.ContactEmployees.ContactEmployee }
         * 
         * 
         */
        public List<BusinessPartner.ContactEmployees.ContactEmployee> getContactEmployee() {
            if (contactEmployee == null) {
                contactEmployee = new ArrayList<BusinessPartner.ContactEmployees.ContactEmployee>();
            }
            return this.contactEmployee;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Position" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Phone1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Phone2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MobilePhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Fax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="E_Mail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Pager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Remarks1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Remarks2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="InternalCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="PlaceOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DateOfBirth" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="Gender" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="gt_Female"/>
         *               &lt;enumeration value="gt_Male"/>
         *               &lt;enumeration value="gt_Undefined"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Profession" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CityOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Active" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="tNO"/>
         *               &lt;enumeration value="tYES"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="FirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="EmailGroupCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class ContactEmployee {

            @XmlElement(name = "CardCode")
            protected String cardCode;
            @XmlElement(name = "Name")
            protected String name;
            @XmlElement(name = "Position")
            protected String position;
            @XmlElement(name = "Address")
            protected String address;
            @XmlElement(name = "Phone1")
            protected String phone1;
            @XmlElement(name = "Phone2")
            protected String phone2;
            @XmlElement(name = "MobilePhone")
            protected String mobilePhone;
            @XmlElement(name = "Fax")
            protected String fax;
            @XmlElement(name = "E_Mail")
            protected String eMail;
            @XmlElement(name = "Pager")
            protected String pager;
            @XmlElement(name = "Remarks1")
            protected String remarks1;
            @XmlElement(name = "Remarks2")
            protected String remarks2;
            @XmlElement(name = "Password")
            protected String password;
            @XmlElement(name = "InternalCode")
            protected Long internalCode;
            @XmlElement(name = "PlaceOfBirth")
            protected String placeOfBirth;
            @XmlElement(name = "DateOfBirth")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dateOfBirth;
            @XmlElement(name = "Gender")
            protected String gender;
            @XmlElement(name = "Profession")
            protected String profession;
            @XmlElement(name = "Title")
            protected String title;
            @XmlElement(name = "CityOfBirth")
            protected String cityOfBirth;
            @XmlElement(name = "Active")
            protected String active;
            @XmlElement(name = "FirstName")
            protected String firstName;
            @XmlElement(name = "MiddleName")
            protected String middleName;
            @XmlElement(name = "LastName")
            protected String lastName;
            @XmlElement(name = "EmailGroupCode")
            protected String emailGroupCode;

            /**
             * Obtiene el valor de la propiedad cardCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCardCode() {
                return cardCode;
            }

            /**
             * Define el valor de la propiedad cardCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCardCode(String value) {
                this.cardCode = value;
            }

            /**
             * Obtiene el valor de la propiedad name.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Define el valor de la propiedad name.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Obtiene el valor de la propiedad position.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPosition() {
                return position;
            }

            /**
             * Define el valor de la propiedad position.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPosition(String value) {
                this.position = value;
            }

            /**
             * Obtiene el valor de la propiedad address.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAddress() {
                return address;
            }

            /**
             * Define el valor de la propiedad address.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAddress(String value) {
                this.address = value;
            }

            /**
             * Obtiene el valor de la propiedad phone1.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone1() {
                return phone1;
            }

            /**
             * Define el valor de la propiedad phone1.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone1(String value) {
                this.phone1 = value;
            }

            /**
             * Obtiene el valor de la propiedad phone2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPhone2() {
                return phone2;
            }

            /**
             * Define el valor de la propiedad phone2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPhone2(String value) {
                this.phone2 = value;
            }

            /**
             * Obtiene el valor de la propiedad mobilePhone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMobilePhone() {
                return mobilePhone;
            }

            /**
             * Define el valor de la propiedad mobilePhone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMobilePhone(String value) {
                this.mobilePhone = value;
            }

            /**
             * Obtiene el valor de la propiedad fax.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFax() {
                return fax;
            }

            /**
             * Define el valor de la propiedad fax.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFax(String value) {
                this.fax = value;
            }

            /**
             * Obtiene el valor de la propiedad eMail.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEMail() {
                return eMail;
            }

            /**
             * Define el valor de la propiedad eMail.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEMail(String value) {
                this.eMail = value;
            }

            /**
             * Obtiene el valor de la propiedad pager.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPager() {
                return pager;
            }

            /**
             * Define el valor de la propiedad pager.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPager(String value) {
                this.pager = value;
            }

            /**
             * Obtiene el valor de la propiedad remarks1.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRemarks1() {
                return remarks1;
            }

            /**
             * Define el valor de la propiedad remarks1.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRemarks1(String value) {
                this.remarks1 = value;
            }

            /**
             * Obtiene el valor de la propiedad remarks2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRemarks2() {
                return remarks2;
            }

            /**
             * Define el valor de la propiedad remarks2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRemarks2(String value) {
                this.remarks2 = value;
            }

            /**
             * Obtiene el valor de la propiedad password.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPassword() {
                return password;
            }

            /**
             * Define el valor de la propiedad password.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPassword(String value) {
                this.password = value;
            }

            /**
             * Obtiene el valor de la propiedad internalCode.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getInternalCode() {
                return internalCode;
            }

            /**
             * Define el valor de la propiedad internalCode.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setInternalCode(Long value) {
                this.internalCode = value;
            }

            /**
             * Obtiene el valor de la propiedad placeOfBirth.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPlaceOfBirth() {
                return placeOfBirth;
            }

            /**
             * Define el valor de la propiedad placeOfBirth.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPlaceOfBirth(String value) {
                this.placeOfBirth = value;
            }

            /**
             * Obtiene el valor de la propiedad dateOfBirth.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDateOfBirth() {
                return dateOfBirth;
            }

            /**
             * Define el valor de la propiedad dateOfBirth.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDateOfBirth(XMLGregorianCalendar value) {
                this.dateOfBirth = value;
            }

            /**
             * Obtiene el valor de la propiedad gender.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getGender() {
                return gender;
            }

            /**
             * Define el valor de la propiedad gender.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setGender(String value) {
                this.gender = value;
            }

            /**
             * Obtiene el valor de la propiedad profession.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfession() {
                return profession;
            }

            /**
             * Define el valor de la propiedad profession.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfession(String value) {
                this.profession = value;
            }

            /**
             * Obtiene el valor de la propiedad title.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Define el valor de la propiedad title.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Obtiene el valor de la propiedad cityOfBirth.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCityOfBirth() {
                return cityOfBirth;
            }

            /**
             * Define el valor de la propiedad cityOfBirth.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCityOfBirth(String value) {
                this.cityOfBirth = value;
            }

            /**
             * Obtiene el valor de la propiedad active.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getActive() {
                return active;
            }

            /**
             * Define el valor de la propiedad active.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setActive(String value) {
                this.active = value;
            }

            /**
             * Obtiene el valor de la propiedad firstName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFirstName() {
                return firstName;
            }

            /**
             * Define el valor de la propiedad firstName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFirstName(String value) {
                this.firstName = value;
            }

            /**
             * Obtiene el valor de la propiedad middleName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMiddleName() {
                return middleName;
            }

            /**
             * Define el valor de la propiedad middleName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMiddleName(String value) {
                this.middleName = value;
            }

            /**
             * Obtiene el valor de la propiedad lastName.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLastName() {
                return lastName;
            }

            /**
             * Define el valor de la propiedad lastName.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLastName(String value) {
                this.lastName = value;
            }

            /**
             * Obtiene el valor de la propiedad emailGroupCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmailGroupCode() {
                return emailGroupCode;
            }

            /**
             * Define el valor de la propiedad emailGroupCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmailGroupCode(String value) {
                this.emailGroupCode = value;
            }

        }

    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DiscountGroup" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="ObjectEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="BaseObjectType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="dgboNone"/>
     *                         &lt;enumeration value="dgboItemGroups"/>
     *                         &lt;enumeration value="dgboItemProperties"/>
     *                         &lt;enumeration value="dgboManufacturer"/>
     *                         &lt;enumeration value="dgboItems"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/all>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "discountGroup"
    })
    public static class DiscountGroups {

        @XmlElement(name = "DiscountGroup")
        protected List<BusinessPartner.DiscountGroups.DiscountGroup> discountGroup;

        /**
         * Gets the value of the discountGroup property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the discountGroup property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDiscountGroup().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BusinessPartner.DiscountGroups.DiscountGroup }
         * 
         * 
         */
        public List<BusinessPartner.DiscountGroups.DiscountGroup> getDiscountGroup() {
            if (discountGroup == null) {
                discountGroup = new ArrayList<BusinessPartner.DiscountGroups.DiscountGroup>();
            }
            return this.discountGroup;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;all>
         *         &lt;element name="ObjectEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DiscountPercentage" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="BPCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="BaseObjectType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="dgboNone"/>
         *               &lt;enumeration value="dgboItemGroups"/>
         *               &lt;enumeration value="dgboItemProperties"/>
         *               &lt;enumeration value="dgboManufacturer"/>
         *               &lt;enumeration value="dgboItems"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/all>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {

        })
        public static class DiscountGroup {

            @XmlElement(name = "ObjectEntry")
            protected String objectEntry;
            @XmlElement(name = "DiscountPercentage")
            protected Double discountPercentage;
            @XmlElement(name = "BPCode")
            protected String bpCode;
            @XmlElement(name = "BaseObjectType")
            protected String baseObjectType;

            /**
             * Obtiene el valor de la propiedad objectEntry.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getObjectEntry() {
                return objectEntry;
            }

            /**
             * Define el valor de la propiedad objectEntry.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setObjectEntry(String value) {
                this.objectEntry = value;
            }

            /**
             * Obtiene el valor de la propiedad discountPercentage.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getDiscountPercentage() {
                return discountPercentage;
            }

            /**
             * Define el valor de la propiedad discountPercentage.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setDiscountPercentage(Double value) {
                this.discountPercentage = value;
            }

            /**
             * Obtiene el valor de la propiedad bpCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBPCode() {
                return bpCode;
            }

            /**
             * Define el valor de la propiedad bpCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBPCode(String value) {
                this.bpCode = value;
            }

            /**
             * Obtiene el valor de la propiedad baseObjectType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBaseObjectType() {
                return baseObjectType;
            }

            /**
             * Define el valor de la propiedad baseObjectType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBaseObjectType(String value) {
                this.baseObjectType = value;
            }

        }

    }

}

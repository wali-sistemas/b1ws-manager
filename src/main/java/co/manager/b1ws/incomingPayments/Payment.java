
package co.manager.b1ws.incomingPayments;

import java.math.BigDecimal;
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
 *         &lt;element name="DocNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="DocType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="rCustomer"/>
 *               &lt;enumeration value="rAccount"/>
 *               &lt;enumeration value="rSupplier"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="HandWritten" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Printed" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="CardCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CardName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CashAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DocCurrency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CashSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CheckAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransferAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TransferSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="TransferDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TransferReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocalCurrency" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DocRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Reference1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reference2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CounterReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="JournalRemarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SplitTransaction" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ContactPersonCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="ApplyVAT" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="Series" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CurrencyIsLocal" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DeductionPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DeductionSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CashSumFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="CashSumSys" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BoeAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BillOfExchangeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BillofExchangeStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="boes_Created"/>
 *               &lt;enumeration value="boes_Sent"/>
 *               &lt;enumeration value="boes_Deposited"/>
 *               &lt;enumeration value="boes_Paid"/>
 *               &lt;enumeration value="boes_Cancelled"/>
 *               &lt;enumeration value="boes_Closed"/>
 *               &lt;enumeration value="boes_Failed"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BillOfExchangeAmountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BillOfExchangeAmountSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BillOfExchangeAgent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WTCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WTAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WTAmountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WTAmountSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WTAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="WTTaxableAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="Proforma" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="PayToBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayToBankBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayToBankAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayToCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PayToBankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IsPayToBank" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DocEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="PaymentPriority" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="bopp_Priority_1"/>
 *               &lt;enumeration value="bopp_Priority_2"/>
 *               &lt;enumeration value="bopp_Priority_3"/>
 *               &lt;enumeration value="bopp_Priority_4"/>
 *               &lt;enumeration value="bopp_Priority_5"/>
 *               &lt;enumeration value="bopp_Priority_6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TaxGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="BankChargeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BankChargeAmountInFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="BankChargeAmountInSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UnderOverpaymentdifference" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="UnderOverpaymentdiffSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WtBaseSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WtBaseSumFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="WtBaseSumSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="VatDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="TransactionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="bopt_None"/>
 *               &lt;enumeration value="bopt_Electronic"/>
 *               &lt;enumeration value="bopt_Post"/>
 *               &lt;enumeration value="bopt_Telegraph"/>
 *               &lt;enumeration value="bopt_Express"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="TransferRealAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="DocObjectCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="bopot_IncomingPayments"/>
 *               &lt;enumeration value="bopot_OutgoingPayments"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DocTypte" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="rCustomer"/>
 *               &lt;enumeration value="rAccount"/>
 *               &lt;enumeration value="rSupplier"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LocationCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="Cancelled" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="tNO"/>
 *               &lt;enumeration value="tYES"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ControlAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnderOverpaymentdiffFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="AuthorizationStatus" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="pasWithout"/>
 *               &lt;enumeration value="pasPending"/>
 *               &lt;enumeration value="pasApproved"/>
 *               &lt;enumeration value="pasRejected"/>
 *               &lt;enumeration value="pasGenerated"/>
 *               &lt;enumeration value="pasGeneratedbyAuthorizer"/>
 *               &lt;enumeration value="pasCancelled"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BPLID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="BPLName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VATRegNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PaymentChecks" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PaymentCheck" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AccounttNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="Trnsfrable" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="tNO"/>
 *                                   &lt;enumeration value="tYES"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CheckAbsEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="CheckAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ManualCheck" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="tNO"/>
 *                                   &lt;enumeration value="tYES"/>
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
 *         &lt;element name="PaymentInvoices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PaymentInvoice" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="DocEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="SumApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="AppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="AppliedSys" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="DocRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="DocLine" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="InvoiceType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="it_AllTransactions"/>
 *                                   &lt;enumeration value="it_OpeningBalance"/>
 *                                   &lt;enumeration value="it_ClosingBalance"/>
 *                                   &lt;enumeration value="it_Invoice"/>
 *                                   &lt;enumeration value="it_CredItnote"/>
 *                                   &lt;enumeration value="it_TaxInvoice"/>
 *                                   &lt;enumeration value="it_Return"/>
 *                                   &lt;enumeration value="it_PurchaseInvoice"/>
 *                                   &lt;enumeration value="it_PurchaseCreditNote"/>
 *                                   &lt;enumeration value="it_PurchaseDeliveryNote"/>
 *                                   &lt;enumeration value="it_PurchaseReturn"/>
 *                                   &lt;enumeration value="it_Receipt"/>
 *                                   &lt;enumeration value="it_Deposit"/>
 *                                   &lt;enumeration value="it_JournalEntry"/>
 *                                   &lt;enumeration value="it_PaymentAdvice"/>
 *                                   &lt;enumeration value="it_ChequesForPayment"/>
 *                                   &lt;enumeration value="it_StockReconciliations"/>
 *                                   &lt;enumeration value="it_GeneralReceiptToStock"/>
 *                                   &lt;enumeration value="it_GeneralReleaseFromStock"/>
 *                                   &lt;enumeration value="it_TransferBetweenWarehouses"/>
 *                                   &lt;enumeration value="it_WorkInstructions"/>
 *                                   &lt;enumeration value="it_DeferredDeposit"/>
 *                                   &lt;enumeration value="it_CorrectionInvoice"/>
 *                                   &lt;enumeration value="it_APCorrectionInvoice"/>
 *                                   &lt;enumeration value="it_ARCorrectionInvoice"/>
 *                                   &lt;enumeration value="it_DownPayment"/>
 *                                   &lt;enumeration value="it_PurchaseDownPayment"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="PaidSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="InstallmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="WitholdingTaxApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="WitholdingTaxAppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="WitholdingTaxAppliedSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="LinkDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="DistributionRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DistributionRule2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DistributionRule3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DistributionRule4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="DistributionRule5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="TotalDiscount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="TotalDiscountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="TotalDiscountSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
 *         &lt;element name="PaymentCreditCards" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PaymentCreditCard" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="CreditCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="CreditAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CreditCardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CardValidUntil" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="VoucherNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OwnerIdNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="OwnerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="NumOfPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="FirstPaymentDue" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="FirstPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="AdditionalPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="CreditSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="CreditCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="CreditRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="ConfirmationNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="NumOfCreditPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="CreditType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="cr_Regular"/>
 *                                   &lt;enumeration value="cr_Telephone"/>
 *                                   &lt;enumeration value="cr_InternetTransaction"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="SplitPayments" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="tNO"/>
 *                                   &lt;enumeration value="tYES"/>
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
 *         &lt;element name="PaymentAccounts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PaymentAccount" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="SumPaid" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="SumPaidFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="Decription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VatGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="GrossAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="ProfitCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="VatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="ProfitCenter2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProfitCenter3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProfitCenter4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="ProfitCenter5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="LocationCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="EqualizationVatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
 *         &lt;element name="BillOfExchange" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="BillOfExchangeNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="BillOfExchangeDueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BPBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BPBankAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="BPBankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="ControlKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PaymentEngineStatus1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PaymentEngineStatus2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="PaymentEngineStatus3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="StampTaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="StampTaxAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="FolioNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="FolioPrefixString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="InterestAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="DiscountAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="FineAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="InterestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="DiscountDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="FineDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                   &lt;element name="IOFAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="ServiceFeeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="OtherExpensesAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                   &lt;element name="OtherIncomesAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CashFlowAssignments" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CashFlowAssignment" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="CashFlowAssignmentsID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="CashFlowLineItemID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="PaymentMeans" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="pmtNotAssigned"/>
 *                                   &lt;enumeration value="pmtChecks"/>
 *                                   &lt;enumeration value="pmtBankTransfer"/>
 *                                   &lt;enumeration value="pmtCash"/>
 *                                   &lt;enumeration value="pmtCreditCard"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="AmountLC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *                             &lt;element name="AmountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
 *         &lt;element name="Payments_ApprovalRequests" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Payments_ApprovalRequest" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;all>
 *                             &lt;element name="ApprovalTemplatesID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlRootElement(name = "Payment")
public class Payment {

    @XmlElement(name = "DocNum")
    protected Long docNum;
    @XmlElement(name = "DocType")
    protected String docType;
    @XmlElement(name = "HandWritten")
    protected String handWritten;
    @XmlElement(name = "Printed")
    protected String printed;
    @XmlElement(name = "DocDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar docDate;
    @XmlElement(name = "CardCode")
    protected String cardCode;
    @XmlElement(name = "CardName")
    protected String cardName;
    @XmlElement(name = "Address")
    protected String address;
    @XmlElement(name = "CashAccount")
    protected String cashAccount;
    @XmlElement(name = "DocCurrency")
    protected String docCurrency;
    @XmlElement(name = "CashSum")
    protected BigDecimal cashSum;
    @XmlElement(name = "CheckAccount")
    protected String checkAccount;
    @XmlElement(name = "TransferAccount")
    protected String transferAccount;
    @XmlElement(name = "TransferSum")
    protected BigDecimal transferSum;
    @XmlElement(name = "TransferDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar transferDate;
    @XmlElement(name = "TransferReference")
    protected String transferReference;
    @XmlElement(name = "LocalCurrency")
    protected String localCurrency;
    @XmlElement(name = "DocRate")
    protected Double docRate;
    @XmlElement(name = "Reference1")
    protected String reference1;
    @XmlElement(name = "Reference2")
    protected String reference2;
    @XmlElement(name = "CounterReference")
    protected String counterReference;
    @XmlElement(name = "Remarks")
    protected String remarks;
    @XmlElement(name = "JournalRemarks")
    protected String journalRemarks;
    @XmlElement(name = "SplitTransaction")
    protected String splitTransaction;
    @XmlElement(name = "ContactPersonCode")
    protected Long contactPersonCode;
    @XmlElement(name = "ApplyVAT")
    protected String applyVAT;
    @XmlElement(name = "TaxDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar taxDate;
    @XmlElement(name = "Series")
    protected Long series;
    @XmlElement(name = "BankCode")
    protected String bankCode;
    @XmlElement(name = "BankAccount")
    protected String bankAccount;
    @XmlElement(name = "DiscountPercent")
    protected Double discountPercent;
    @XmlElement(name = "ProjectCode")
    protected String projectCode;
    @XmlElement(name = "CurrencyIsLocal")
    protected String currencyIsLocal;
    @XmlElement(name = "DeductionPercent")
    protected Double deductionPercent;
    @XmlElement(name = "DeductionSum")
    protected Double deductionSum;
    @XmlElement(name = "CashSumFC")
    protected Double cashSumFC;
    @XmlElement(name = "CashSumSys")
    protected Double cashSumSys;
    @XmlElement(name = "BoeAccount")
    protected String boeAccount;
    @XmlElement(name = "BillOfExchangeAmount")
    protected Double billOfExchangeAmount;
    @XmlElement(name = "BillofExchangeStatus")
    protected String billofExchangeStatus;
    @XmlElement(name = "BillOfExchangeAmountFC")
    protected Double billOfExchangeAmountFC;
    @XmlElement(name = "BillOfExchangeAmountSC")
    protected Double billOfExchangeAmountSC;
    @XmlElement(name = "BillOfExchangeAgent")
    protected String billOfExchangeAgent;
    @XmlElement(name = "WTCode")
    protected String wtCode;
    @XmlElement(name = "WTAmount")
    protected Double wtAmount;
    @XmlElement(name = "WTAmountFC")
    protected Double wtAmountFC;
    @XmlElement(name = "WTAmountSC")
    protected Double wtAmountSC;
    @XmlElement(name = "WTAccount")
    protected String wtAccount;
    @XmlElement(name = "WTTaxableAmount")
    protected Double wtTaxableAmount;
    @XmlElement(name = "Proforma")
    protected String proforma;
    @XmlElement(name = "PayToBankCode")
    protected String payToBankCode;
    @XmlElement(name = "PayToBankBranch")
    protected String payToBankBranch;
    @XmlElement(name = "PayToBankAccountNo")
    protected String payToBankAccountNo;
    @XmlElement(name = "PayToCode")
    protected String payToCode;
    @XmlElement(name = "PayToBankCountry")
    protected String payToBankCountry;
    @XmlElement(name = "IsPayToBank")
    protected String isPayToBank;
    @XmlElement(name = "DocEntry")
    protected Long docEntry;
    @XmlElement(name = "PaymentPriority")
    protected String paymentPriority;
    @XmlElement(name = "TaxGroup")
    protected String taxGroup;
    @XmlElement(name = "BankChargeAmount")
    protected Double bankChargeAmount;
    @XmlElement(name = "BankChargeAmountInFC")
    protected Double bankChargeAmountInFC;
    @XmlElement(name = "BankChargeAmountInSC")
    protected Double bankChargeAmountInSC;
    @XmlElement(name = "UnderOverpaymentdifference")
    protected Double underOverpaymentdifference;
    @XmlElement(name = "UnderOverpaymentdiffSC")
    protected Double underOverpaymentdiffSC;
    @XmlElement(name = "WtBaseSum")
    protected Double wtBaseSum;
    @XmlElement(name = "WtBaseSumFC")
    protected Double wtBaseSumFC;
    @XmlElement(name = "WtBaseSumSC")
    protected Double wtBaseSumSC;
    @XmlElement(name = "VatDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vatDate;
    @XmlElement(name = "TransactionCode")
    protected String transactionCode;
    @XmlElement(name = "PaymentType")
    protected String paymentType;
    @XmlElement(name = "TransferRealAmount")
    protected Double transferRealAmount;
    @XmlElement(name = "DocObjectCode")
    protected String docObjectCode;
    @XmlElement(name = "DocTypte")
    protected String docTypte;
    @XmlElement(name = "DueDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dueDate;
    @XmlElement(name = "LocationCode")
    protected Long locationCode;
    @XmlElement(name = "Cancelled")
    protected String cancelled;
    @XmlElement(name = "ControlAccount")
    protected String controlAccount;
    @XmlElement(name = "UnderOverpaymentdiffFC")
    protected Double underOverpaymentdiffFC;
    @XmlElement(name = "AuthorizationStatus")
    protected String authorizationStatus;
    @XmlElement(name = "BPLID")
    protected Long bplid;
    @XmlElement(name = "BPLName")
    protected String bplName;
    @XmlElement(name = "VATRegNum")
    protected String vatRegNum;
    @XmlElement(name = "PaymentChecks")
    protected Payment.PaymentChecks paymentChecks;
    @XmlElement(name = "PaymentInvoices")
    protected Payment.PaymentInvoices paymentInvoices;
    @XmlElement(name = "PaymentCreditCards")
    protected Payment.PaymentCreditCards paymentCreditCards;
    @XmlElement(name = "PaymentAccounts")
    protected Payment.PaymentAccounts paymentAccounts;
    @XmlElement(name = "BillOfExchange")
    protected Payment.BillOfExchange billOfExchange;
    @XmlElement(name = "CashFlowAssignments")
    protected Payment.CashFlowAssignments cashFlowAssignments;
    @XmlElement(name = "Payments_ApprovalRequests")
    protected Payment.PaymentsApprovalRequests paymentsApprovalRequests;

    /**
     * Obtiene el valor de la propiedad docNum.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocNum() {
        return docNum;
    }

    /**
     * Define el valor de la propiedad docNum.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocNum(Long value) {
        this.docNum = value;
    }

    /**
     * Obtiene el valor de la propiedad docType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Define el valor de la propiedad docType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * Obtiene el valor de la propiedad handWritten.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHandWritten() {
        return handWritten;
    }

    /**
     * Define el valor de la propiedad handWritten.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHandWritten(String value) {
        this.handWritten = value;
    }

    /**
     * Obtiene el valor de la propiedad printed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinted() {
        return printed;
    }

    /**
     * Define el valor de la propiedad printed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinted(String value) {
        this.printed = value;
    }

    /**
     * Obtiene el valor de la propiedad docDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocDate() {
        return docDate;
    }

    /**
     * Define el valor de la propiedad docDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocDate(XMLGregorianCalendar value) {
        this.docDate = value;
    }

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
     * Obtiene el valor de la propiedad cashAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCashAccount() {
        return cashAccount;
    }

    /**
     * Define el valor de la propiedad cashAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCashAccount(String value) {
        this.cashAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad docCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocCurrency() {
        return docCurrency;
    }

    /**
     * Define el valor de la propiedad docCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocCurrency(String value) {
        this.docCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad cashSum.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public BigDecimal getCashSum() {
        return cashSum;
    }

    /**
     * Define el valor de la propiedad cashSum.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCashSum(BigDecimal value) {
        this.cashSum = value;
    }

    /**
     * Obtiene el valor de la propiedad checkAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckAccount() {
        return checkAccount;
    }

    /**
     * Define el valor de la propiedad checkAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckAccount(String value) {
        this.checkAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad transferAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferAccount() {
        return transferAccount;
    }

    /**
     * Define el valor de la propiedad transferAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferAccount(String value) {
        this.transferAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad transferSum.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public BigDecimal getTransferSum() {
        return transferSum;
    }

    /**
     * Define el valor de la propiedad transferSum.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransferSum(BigDecimal value) {
        this.transferSum = value;
    }

    /**
     * Obtiene el valor de la propiedad transferDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTransferDate() {
        return transferDate;
    }

    /**
     * Define el valor de la propiedad transferDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTransferDate(XMLGregorianCalendar value) {
        this.transferDate = value;
    }

    /**
     * Obtiene el valor de la propiedad transferReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferReference() {
        return transferReference;
    }

    /**
     * Define el valor de la propiedad transferReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferReference(String value) {
        this.transferReference = value;
    }

    /**
     * Obtiene el valor de la propiedad localCurrency.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalCurrency() {
        return localCurrency;
    }

    /**
     * Define el valor de la propiedad localCurrency.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalCurrency(String value) {
        this.localCurrency = value;
    }

    /**
     * Obtiene el valor de la propiedad docRate.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDocRate() {
        return docRate;
    }

    /**
     * Define el valor de la propiedad docRate.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDocRate(Double value) {
        this.docRate = value;
    }

    /**
     * Obtiene el valor de la propiedad reference1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference1() {
        return reference1;
    }

    /**
     * Define el valor de la propiedad reference1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference1(String value) {
        this.reference1 = value;
    }

    /**
     * Obtiene el valor de la propiedad reference2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference2() {
        return reference2;
    }

    /**
     * Define el valor de la propiedad reference2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference2(String value) {
        this.reference2 = value;
    }

    /**
     * Obtiene el valor de la propiedad counterReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounterReference() {
        return counterReference;
    }

    /**
     * Define el valor de la propiedad counterReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounterReference(String value) {
        this.counterReference = value;
    }

    /**
     * Obtiene el valor de la propiedad remarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * Define el valor de la propiedad remarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemarks(String value) {
        this.remarks = value;
    }

    /**
     * Obtiene el valor de la propiedad journalRemarks.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalRemarks() {
        return journalRemarks;
    }

    /**
     * Define el valor de la propiedad journalRemarks.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalRemarks(String value) {
        this.journalRemarks = value;
    }

    /**
     * Obtiene el valor de la propiedad splitTransaction.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSplitTransaction() {
        return splitTransaction;
    }

    /**
     * Define el valor de la propiedad splitTransaction.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSplitTransaction(String value) {
        this.splitTransaction = value;
    }

    /**
     * Obtiene el valor de la propiedad contactPersonCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContactPersonCode() {
        return contactPersonCode;
    }

    /**
     * Define el valor de la propiedad contactPersonCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContactPersonCode(Long value) {
        this.contactPersonCode = value;
    }

    /**
     * Obtiene el valor de la propiedad applyVAT.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplyVAT() {
        return applyVAT;
    }

    /**
     * Define el valor de la propiedad applyVAT.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplyVAT(String value) {
        this.applyVAT = value;
    }

    /**
     * Obtiene el valor de la propiedad taxDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTaxDate() {
        return taxDate;
    }

    /**
     * Define el valor de la propiedad taxDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTaxDate(XMLGregorianCalendar value) {
        this.taxDate = value;
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
     * Obtiene el valor de la propiedad bankAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * Define el valor de la propiedad bankAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankAccount(String value) {
        this.bankAccount = value;
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
     * Obtiene el valor de la propiedad currencyIsLocal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyIsLocal() {
        return currencyIsLocal;
    }

    /**
     * Define el valor de la propiedad currencyIsLocal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyIsLocal(String value) {
        this.currencyIsLocal = value;
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
     * Obtiene el valor de la propiedad deductionSum.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDeductionSum() {
        return deductionSum;
    }

    /**
     * Define el valor de la propiedad deductionSum.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDeductionSum(Double value) {
        this.deductionSum = value;
    }

    /**
     * Obtiene el valor de la propiedad cashSumFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCashSumFC() {
        return cashSumFC;
    }

    /**
     * Define el valor de la propiedad cashSumFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCashSumFC(Double value) {
        this.cashSumFC = value;
    }

    /**
     * Obtiene el valor de la propiedad cashSumSys.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getCashSumSys() {
        return cashSumSys;
    }

    /**
     * Define el valor de la propiedad cashSumSys.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setCashSumSys(Double value) {
        this.cashSumSys = value;
    }

    /**
     * Obtiene el valor de la propiedad boeAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBoeAccount() {
        return boeAccount;
    }

    /**
     * Define el valor de la propiedad boeAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBoeAccount(String value) {
        this.boeAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad billOfExchangeAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBillOfExchangeAmount() {
        return billOfExchangeAmount;
    }

    /**
     * Define el valor de la propiedad billOfExchangeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBillOfExchangeAmount(Double value) {
        this.billOfExchangeAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad billofExchangeStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillofExchangeStatus() {
        return billofExchangeStatus;
    }

    /**
     * Define el valor de la propiedad billofExchangeStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillofExchangeStatus(String value) {
        this.billofExchangeStatus = value;
    }

    /**
     * Obtiene el valor de la propiedad billOfExchangeAmountFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBillOfExchangeAmountFC() {
        return billOfExchangeAmountFC;
    }

    /**
     * Define el valor de la propiedad billOfExchangeAmountFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBillOfExchangeAmountFC(Double value) {
        this.billOfExchangeAmountFC = value;
    }

    /**
     * Obtiene el valor de la propiedad billOfExchangeAmountSC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBillOfExchangeAmountSC() {
        return billOfExchangeAmountSC;
    }

    /**
     * Define el valor de la propiedad billOfExchangeAmountSC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBillOfExchangeAmountSC(Double value) {
        this.billOfExchangeAmountSC = value;
    }

    /**
     * Obtiene el valor de la propiedad billOfExchangeAgent.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBillOfExchangeAgent() {
        return billOfExchangeAgent;
    }

    /**
     * Define el valor de la propiedad billOfExchangeAgent.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBillOfExchangeAgent(String value) {
        this.billOfExchangeAgent = value;
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
     * Obtiene el valor de la propiedad wtAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWTAmount() {
        return wtAmount;
    }

    /**
     * Define el valor de la propiedad wtAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWTAmount(Double value) {
        this.wtAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad wtAmountFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWTAmountFC() {
        return wtAmountFC;
    }

    /**
     * Define el valor de la propiedad wtAmountFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWTAmountFC(Double value) {
        this.wtAmountFC = value;
    }

    /**
     * Obtiene el valor de la propiedad wtAmountSC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWTAmountSC() {
        return wtAmountSC;
    }

    /**
     * Define el valor de la propiedad wtAmountSC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWTAmountSC(Double value) {
        this.wtAmountSC = value;
    }

    /**
     * Obtiene el valor de la propiedad wtAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWTAccount() {
        return wtAccount;
    }

    /**
     * Define el valor de la propiedad wtAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWTAccount(String value) {
        this.wtAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad wtTaxableAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWTTaxableAmount() {
        return wtTaxableAmount;
    }

    /**
     * Define el valor de la propiedad wtTaxableAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWTTaxableAmount(Double value) {
        this.wtTaxableAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad proforma.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProforma() {
        return proforma;
    }

    /**
     * Define el valor de la propiedad proforma.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProforma(String value) {
        this.proforma = value;
    }

    /**
     * Obtiene el valor de la propiedad payToBankCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToBankCode() {
        return payToBankCode;
    }

    /**
     * Define el valor de la propiedad payToBankCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToBankCode(String value) {
        this.payToBankCode = value;
    }

    /**
     * Obtiene el valor de la propiedad payToBankBranch.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToBankBranch() {
        return payToBankBranch;
    }

    /**
     * Define el valor de la propiedad payToBankBranch.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToBankBranch(String value) {
        this.payToBankBranch = value;
    }

    /**
     * Obtiene el valor de la propiedad payToBankAccountNo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToBankAccountNo() {
        return payToBankAccountNo;
    }

    /**
     * Define el valor de la propiedad payToBankAccountNo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToBankAccountNo(String value) {
        this.payToBankAccountNo = value;
    }

    /**
     * Obtiene el valor de la propiedad payToCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToCode() {
        return payToCode;
    }

    /**
     * Define el valor de la propiedad payToCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToCode(String value) {
        this.payToCode = value;
    }

    /**
     * Obtiene el valor de la propiedad payToBankCountry.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayToBankCountry() {
        return payToBankCountry;
    }

    /**
     * Define el valor de la propiedad payToBankCountry.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayToBankCountry(String value) {
        this.payToBankCountry = value;
    }

    /**
     * Obtiene el valor de la propiedad isPayToBank.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsPayToBank() {
        return isPayToBank;
    }

    /**
     * Define el valor de la propiedad isPayToBank.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsPayToBank(String value) {
        this.isPayToBank = value;
    }

    /**
     * Obtiene el valor de la propiedad docEntry.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDocEntry() {
        return docEntry;
    }

    /**
     * Define el valor de la propiedad docEntry.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDocEntry(Long value) {
        this.docEntry = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentPriority.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentPriority() {
        return paymentPriority;
    }

    /**
     * Define el valor de la propiedad paymentPriority.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentPriority(String value) {
        this.paymentPriority = value;
    }

    /**
     * Obtiene el valor de la propiedad taxGroup.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxGroup() {
        return taxGroup;
    }

    /**
     * Define el valor de la propiedad taxGroup.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxGroup(String value) {
        this.taxGroup = value;
    }

    /**
     * Obtiene el valor de la propiedad bankChargeAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBankChargeAmount() {
        return bankChargeAmount;
    }

    /**
     * Define el valor de la propiedad bankChargeAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBankChargeAmount(Double value) {
        this.bankChargeAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad bankChargeAmountInFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBankChargeAmountInFC() {
        return bankChargeAmountInFC;
    }

    /**
     * Define el valor de la propiedad bankChargeAmountInFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBankChargeAmountInFC(Double value) {
        this.bankChargeAmountInFC = value;
    }

    /**
     * Obtiene el valor de la propiedad bankChargeAmountInSC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBankChargeAmountInSC() {
        return bankChargeAmountInSC;
    }

    /**
     * Define el valor de la propiedad bankChargeAmountInSC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBankChargeAmountInSC(Double value) {
        this.bankChargeAmountInSC = value;
    }

    /**
     * Obtiene el valor de la propiedad underOverpaymentdifference.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUnderOverpaymentdifference() {
        return underOverpaymentdifference;
    }

    /**
     * Define el valor de la propiedad underOverpaymentdifference.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUnderOverpaymentdifference(Double value) {
        this.underOverpaymentdifference = value;
    }

    /**
     * Obtiene el valor de la propiedad underOverpaymentdiffSC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUnderOverpaymentdiffSC() {
        return underOverpaymentdiffSC;
    }

    /**
     * Define el valor de la propiedad underOverpaymentdiffSC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUnderOverpaymentdiffSC(Double value) {
        this.underOverpaymentdiffSC = value;
    }

    /**
     * Obtiene el valor de la propiedad wtBaseSum.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWtBaseSum() {
        return wtBaseSum;
    }

    /**
     * Define el valor de la propiedad wtBaseSum.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWtBaseSum(Double value) {
        this.wtBaseSum = value;
    }

    /**
     * Obtiene el valor de la propiedad wtBaseSumFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWtBaseSumFC() {
        return wtBaseSumFC;
    }

    /**
     * Define el valor de la propiedad wtBaseSumFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWtBaseSumFC(Double value) {
        this.wtBaseSumFC = value;
    }

    /**
     * Obtiene el valor de la propiedad wtBaseSumSC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getWtBaseSumSC() {
        return wtBaseSumSC;
    }

    /**
     * Define el valor de la propiedad wtBaseSumSC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setWtBaseSumSC(Double value) {
        this.wtBaseSumSC = value;
    }

    /**
     * Obtiene el valor de la propiedad vatDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVatDate() {
        return vatDate;
    }

    /**
     * Define el valor de la propiedad vatDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVatDate(XMLGregorianCalendar value) {
        this.vatDate = value;
    }

    /**
     * Obtiene el valor de la propiedad transactionCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionCode() {
        return transactionCode;
    }

    /**
     * Define el valor de la propiedad transactionCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionCode(String value) {
        this.transactionCode = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Define el valor de la propiedad paymentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Obtiene el valor de la propiedad transferRealAmount.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTransferRealAmount() {
        return transferRealAmount;
    }

    /**
     * Define el valor de la propiedad transferRealAmount.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTransferRealAmount(Double value) {
        this.transferRealAmount = value;
    }

    /**
     * Obtiene el valor de la propiedad docObjectCode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocObjectCode() {
        return docObjectCode;
    }

    /**
     * Define el valor de la propiedad docObjectCode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocObjectCode(String value) {
        this.docObjectCode = value;
    }

    /**
     * Obtiene el valor de la propiedad docTypte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocTypte() {
        return docTypte;
    }

    /**
     * Define el valor de la propiedad docTypte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocTypte(String value) {
        this.docTypte = value;
    }

    /**
     * Obtiene el valor de la propiedad dueDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDueDate() {
        return dueDate;
    }

    /**
     * Define el valor de la propiedad dueDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDueDate(XMLGregorianCalendar value) {
        this.dueDate = value;
    }

    /**
     * Obtiene el valor de la propiedad locationCode.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocationCode() {
        return locationCode;
    }

    /**
     * Define el valor de la propiedad locationCode.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocationCode(Long value) {
        this.locationCode = value;
    }

    /**
     * Obtiene el valor de la propiedad cancelled.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCancelled() {
        return cancelled;
    }

    /**
     * Define el valor de la propiedad cancelled.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCancelled(String value) {
        this.cancelled = value;
    }

    /**
     * Obtiene el valor de la propiedad controlAccount.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getControlAccount() {
        return controlAccount;
    }

    /**
     * Define el valor de la propiedad controlAccount.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setControlAccount(String value) {
        this.controlAccount = value;
    }

    /**
     * Obtiene el valor de la propiedad underOverpaymentdiffFC.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getUnderOverpaymentdiffFC() {
        return underOverpaymentdiffFC;
    }

    /**
     * Define el valor de la propiedad underOverpaymentdiffFC.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setUnderOverpaymentdiffFC(Double value) {
        this.underOverpaymentdiffFC = value;
    }

    /**
     * Obtiene el valor de la propiedad authorizationStatus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    /**
     * Define el valor de la propiedad authorizationStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationStatus(String value) {
        this.authorizationStatus = value;
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

    /**
     * Obtiene el valor de la propiedad bplName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBPLName() {
        return bplName;
    }

    /**
     * Define el valor de la propiedad bplName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBPLName(String value) {
        this.bplName = value;
    }

    /**
     * Obtiene el valor de la propiedad vatRegNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVATRegNum() {
        return vatRegNum;
    }

    /**
     * Define el valor de la propiedad vatRegNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVATRegNum(String value) {
        this.vatRegNum = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentChecks.
     * 
     * @return
     *     possible object is
     *     {@link Payment.PaymentChecks }
     *     
     */
    public Payment.PaymentChecks getPaymentChecks() {
        return paymentChecks;
    }

    /**
     * Define el valor de la propiedad paymentChecks.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.PaymentChecks }
     *     
     */
    public void setPaymentChecks(Payment.PaymentChecks value) {
        this.paymentChecks = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentInvoices.
     * 
     * @return
     *     possible object is
     *     {@link Payment.PaymentInvoices }
     *     
     */
    public Payment.PaymentInvoices getPaymentInvoices() {
        return paymentInvoices;
    }

    /**
     * Define el valor de la propiedad paymentInvoices.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.PaymentInvoices }
     *     
     */
    public void setPaymentInvoices(Payment.PaymentInvoices value) {
        this.paymentInvoices = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentCreditCards.
     * 
     * @return
     *     possible object is
     *     {@link Payment.PaymentCreditCards }
     *     
     */
    public Payment.PaymentCreditCards getPaymentCreditCards() {
        return paymentCreditCards;
    }

    /**
     * Define el valor de la propiedad paymentCreditCards.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.PaymentCreditCards }
     *     
     */
    public void setPaymentCreditCards(Payment.PaymentCreditCards value) {
        this.paymentCreditCards = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentAccounts.
     * 
     * @return
     *     possible object is
     *     {@link Payment.PaymentAccounts }
     *     
     */
    public Payment.PaymentAccounts getPaymentAccounts() {
        return paymentAccounts;
    }

    /**
     * Define el valor de la propiedad paymentAccounts.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.PaymentAccounts }
     *     
     */
    public void setPaymentAccounts(Payment.PaymentAccounts value) {
        this.paymentAccounts = value;
    }

    /**
     * Obtiene el valor de la propiedad billOfExchange.
     * 
     * @return
     *     possible object is
     *     {@link Payment.BillOfExchange }
     *     
     */
    public Payment.BillOfExchange getBillOfExchange() {
        return billOfExchange;
    }

    /**
     * Define el valor de la propiedad billOfExchange.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.BillOfExchange }
     *     
     */
    public void setBillOfExchange(Payment.BillOfExchange value) {
        this.billOfExchange = value;
    }

    /**
     * Obtiene el valor de la propiedad cashFlowAssignments.
     * 
     * @return
     *     possible object is
     *     {@link Payment.CashFlowAssignments }
     *     
     */
    public Payment.CashFlowAssignments getCashFlowAssignments() {
        return cashFlowAssignments;
    }

    /**
     * Define el valor de la propiedad cashFlowAssignments.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.CashFlowAssignments }
     *     
     */
    public void setCashFlowAssignments(Payment.CashFlowAssignments value) {
        this.cashFlowAssignments = value;
    }

    /**
     * Obtiene el valor de la propiedad paymentsApprovalRequests.
     * 
     * @return
     *     possible object is
     *     {@link Payment.PaymentsApprovalRequests }
     *     
     */
    public Payment.PaymentsApprovalRequests getPaymentsApprovalRequests() {
        return paymentsApprovalRequests;
    }

    /**
     * Define el valor de la propiedad paymentsApprovalRequests.
     * 
     * @param value
     *     allowed object is
     *     {@link Payment.PaymentsApprovalRequests }
     *     
     */
    public void setPaymentsApprovalRequests(Payment.PaymentsApprovalRequests value) {
        this.paymentsApprovalRequests = value;
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
     *         &lt;element name="BillOfExchangeNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="BillOfExchangeDueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ReferenceNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BPBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BPBankAct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="BPBankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="ControlKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PaymentEngineStatus1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PaymentEngineStatus2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="PaymentEngineStatus3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="StampTaxCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="StampTaxAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="FolioNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="FolioPrefixString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="InterestAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="DiscountAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="FineAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="InterestDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="DiscountDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="FineDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *         &lt;element name="IOFAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="ServiceFeeAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="OtherExpensesAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *         &lt;element name="OtherIncomesAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
    public static class BillOfExchange {

        @XmlElement(name = "BillOfExchangeNo")
        protected Long billOfExchangeNo;
        @XmlElement(name = "BillOfExchangeDueDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar billOfExchangeDueDate;
        @XmlElement(name = "Details")
        protected String details;
        @XmlElement(name = "ReferenceNo")
        protected String referenceNo;
        @XmlElement(name = "Remarks")
        protected String remarks;
        @XmlElement(name = "PaymentMethodCode")
        protected String paymentMethodCode;
        @XmlElement(name = "BPBankCode")
        protected String bpBankCode;
        @XmlElement(name = "BPBankAct")
        protected String bpBankAct;
        @XmlElement(name = "BPBankCountry")
        protected String bpBankCountry;
        @XmlElement(name = "ControlKey")
        protected String controlKey;
        @XmlElement(name = "PaymentEngineStatus1")
        protected String paymentEngineStatus1;
        @XmlElement(name = "PaymentEngineStatus2")
        protected String paymentEngineStatus2;
        @XmlElement(name = "PaymentEngineStatus3")
        protected String paymentEngineStatus3;
        @XmlElement(name = "StampTaxCode")
        protected String stampTaxCode;
        @XmlElement(name = "StampTaxAmount")
        protected Double stampTaxAmount;
        @XmlElement(name = "FolioNumber")
        protected Long folioNumber;
        @XmlElement(name = "FolioPrefixString")
        protected String folioPrefixString;
        @XmlElement(name = "InterestAmount")
        protected Double interestAmount;
        @XmlElement(name = "DiscountAmount")
        protected Double discountAmount;
        @XmlElement(name = "FineAmount")
        protected Double fineAmount;
        @XmlElement(name = "InterestDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar interestDate;
        @XmlElement(name = "DiscountDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar discountDate;
        @XmlElement(name = "FineDate")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar fineDate;
        @XmlElement(name = "IOFAmount")
        protected Double iofAmount;
        @XmlElement(name = "ServiceFeeAmount")
        protected Double serviceFeeAmount;
        @XmlElement(name = "OtherExpensesAmount")
        protected Double otherExpensesAmount;
        @XmlElement(name = "OtherIncomesAmount")
        protected Double otherIncomesAmount;

        /**
         * Obtiene el valor de la propiedad billOfExchangeNo.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getBillOfExchangeNo() {
            return billOfExchangeNo;
        }

        /**
         * Define el valor de la propiedad billOfExchangeNo.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setBillOfExchangeNo(Long value) {
            this.billOfExchangeNo = value;
        }

        /**
         * Obtiene el valor de la propiedad billOfExchangeDueDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBillOfExchangeDueDate() {
            return billOfExchangeDueDate;
        }

        /**
         * Define el valor de la propiedad billOfExchangeDueDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBillOfExchangeDueDate(XMLGregorianCalendar value) {
            this.billOfExchangeDueDate = value;
        }

        /**
         * Obtiene el valor de la propiedad details.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDetails() {
            return details;
        }

        /**
         * Define el valor de la propiedad details.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDetails(String value) {
            this.details = value;
        }

        /**
         * Obtiene el valor de la propiedad referenceNo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getReferenceNo() {
            return referenceNo;
        }

        /**
         * Define el valor de la propiedad referenceNo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setReferenceNo(String value) {
            this.referenceNo = value;
        }

        /**
         * Obtiene el valor de la propiedad remarks.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRemarks() {
            return remarks;
        }

        /**
         * Define el valor de la propiedad remarks.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRemarks(String value) {
            this.remarks = value;
        }

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
         * Obtiene el valor de la propiedad bpBankCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBPBankCode() {
            return bpBankCode;
        }

        /**
         * Define el valor de la propiedad bpBankCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBPBankCode(String value) {
            this.bpBankCode = value;
        }

        /**
         * Obtiene el valor de la propiedad bpBankAct.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBPBankAct() {
            return bpBankAct;
        }

        /**
         * Define el valor de la propiedad bpBankAct.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBPBankAct(String value) {
            this.bpBankAct = value;
        }

        /**
         * Obtiene el valor de la propiedad bpBankCountry.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBPBankCountry() {
            return bpBankCountry;
        }

        /**
         * Define el valor de la propiedad bpBankCountry.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBPBankCountry(String value) {
            this.bpBankCountry = value;
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
         * Obtiene el valor de la propiedad paymentEngineStatus1.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentEngineStatus1() {
            return paymentEngineStatus1;
        }

        /**
         * Define el valor de la propiedad paymentEngineStatus1.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentEngineStatus1(String value) {
            this.paymentEngineStatus1 = value;
        }

        /**
         * Obtiene el valor de la propiedad paymentEngineStatus2.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentEngineStatus2() {
            return paymentEngineStatus2;
        }

        /**
         * Define el valor de la propiedad paymentEngineStatus2.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentEngineStatus2(String value) {
            this.paymentEngineStatus2 = value;
        }

        /**
         * Obtiene el valor de la propiedad paymentEngineStatus3.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPaymentEngineStatus3() {
            return paymentEngineStatus3;
        }

        /**
         * Define el valor de la propiedad paymentEngineStatus3.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPaymentEngineStatus3(String value) {
            this.paymentEngineStatus3 = value;
        }

        /**
         * Obtiene el valor de la propiedad stampTaxCode.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStampTaxCode() {
            return stampTaxCode;
        }

        /**
         * Define el valor de la propiedad stampTaxCode.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStampTaxCode(String value) {
            this.stampTaxCode = value;
        }

        /**
         * Obtiene el valor de la propiedad stampTaxAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getStampTaxAmount() {
            return stampTaxAmount;
        }

        /**
         * Define el valor de la propiedad stampTaxAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setStampTaxAmount(Double value) {
            this.stampTaxAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad folioNumber.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getFolioNumber() {
            return folioNumber;
        }

        /**
         * Define el valor de la propiedad folioNumber.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setFolioNumber(Long value) {
            this.folioNumber = value;
        }

        /**
         * Obtiene el valor de la propiedad folioPrefixString.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFolioPrefixString() {
            return folioPrefixString;
        }

        /**
         * Define el valor de la propiedad folioPrefixString.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFolioPrefixString(String value) {
            this.folioPrefixString = value;
        }

        /**
         * Obtiene el valor de la propiedad interestAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getInterestAmount() {
            return interestAmount;
        }

        /**
         * Define el valor de la propiedad interestAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setInterestAmount(Double value) {
            this.interestAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad discountAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getDiscountAmount() {
            return discountAmount;
        }

        /**
         * Define el valor de la propiedad discountAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setDiscountAmount(Double value) {
            this.discountAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad fineAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getFineAmount() {
            return fineAmount;
        }

        /**
         * Define el valor de la propiedad fineAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setFineAmount(Double value) {
            this.fineAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad interestDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getInterestDate() {
            return interestDate;
        }

        /**
         * Define el valor de la propiedad interestDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setInterestDate(XMLGregorianCalendar value) {
            this.interestDate = value;
        }

        /**
         * Obtiene el valor de la propiedad discountDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDiscountDate() {
            return discountDate;
        }

        /**
         * Define el valor de la propiedad discountDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDiscountDate(XMLGregorianCalendar value) {
            this.discountDate = value;
        }

        /**
         * Obtiene el valor de la propiedad fineDate.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getFineDate() {
            return fineDate;
        }

        /**
         * Define el valor de la propiedad fineDate.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setFineDate(XMLGregorianCalendar value) {
            this.fineDate = value;
        }

        /**
         * Obtiene el valor de la propiedad iofAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getIOFAmount() {
            return iofAmount;
        }

        /**
         * Define el valor de la propiedad iofAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setIOFAmount(Double value) {
            this.iofAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad serviceFeeAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getServiceFeeAmount() {
            return serviceFeeAmount;
        }

        /**
         * Define el valor de la propiedad serviceFeeAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setServiceFeeAmount(Double value) {
            this.serviceFeeAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad otherExpensesAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getOtherExpensesAmount() {
            return otherExpensesAmount;
        }

        /**
         * Define el valor de la propiedad otherExpensesAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setOtherExpensesAmount(Double value) {
            this.otherExpensesAmount = value;
        }

        /**
         * Obtiene el valor de la propiedad otherIncomesAmount.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public Double getOtherIncomesAmount() {
            return otherIncomesAmount;
        }

        /**
         * Define el valor de la propiedad otherIncomesAmount.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setOtherIncomesAmount(Double value) {
            this.otherIncomesAmount = value;
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
     *         &lt;element name="CashFlowAssignment" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="CashFlowAssignmentsID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="CashFlowLineItemID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="PaymentMeans" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="pmtNotAssigned"/>
     *                         &lt;enumeration value="pmtChecks"/>
     *                         &lt;enumeration value="pmtBankTransfer"/>
     *                         &lt;enumeration value="pmtCash"/>
     *                         &lt;enumeration value="pmtCreditCard"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AmountLC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="AmountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "cashFlowAssignment"
    })
    public static class CashFlowAssignments {

        @XmlElement(name = "CashFlowAssignment")
        protected List<Payment.CashFlowAssignments.CashFlowAssignment> cashFlowAssignment;

        /**
         * Gets the value of the cashFlowAssignment property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cashFlowAssignment property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCashFlowAssignment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.CashFlowAssignments.CashFlowAssignment }
         * 
         * 
         */
        public List<Payment.CashFlowAssignments.CashFlowAssignment> getCashFlowAssignment() {
            if (cashFlowAssignment == null) {
                cashFlowAssignment = new ArrayList<Payment.CashFlowAssignments.CashFlowAssignment>();
            }
            return this.cashFlowAssignment;
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
         *         &lt;element name="CashFlowAssignmentsID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="CashFlowLineItemID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="Credit" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="PaymentMeans" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="pmtNotAssigned"/>
         *               &lt;enumeration value="pmtChecks"/>
         *               &lt;enumeration value="pmtBankTransfer"/>
         *               &lt;enumeration value="pmtCash"/>
         *               &lt;enumeration value="pmtCreditCard"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AmountLC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="AmountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        public static class CashFlowAssignment {

            @XmlElement(name = "CashFlowAssignmentsID")
            protected Long cashFlowAssignmentsID;
            @XmlElement(name = "CashFlowLineItemID")
            protected Long cashFlowLineItemID;
            @XmlElement(name = "Credit")
            protected Double credit;
            @XmlElement(name = "PaymentMeans")
            protected String paymentMeans;
            @XmlElement(name = "CheckNumber")
            protected String checkNumber;
            @XmlElement(name = "AmountLC")
            protected Double amountLC;
            @XmlElement(name = "AmountFC")
            protected Double amountFC;

            /**
             * Obtiene el valor de la propiedad cashFlowAssignmentsID.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCashFlowAssignmentsID() {
                return cashFlowAssignmentsID;
            }

            /**
             * Define el valor de la propiedad cashFlowAssignmentsID.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCashFlowAssignmentsID(Long value) {
                this.cashFlowAssignmentsID = value;
            }

            /**
             * Obtiene el valor de la propiedad cashFlowLineItemID.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCashFlowLineItemID() {
                return cashFlowLineItemID;
            }

            /**
             * Define el valor de la propiedad cashFlowLineItemID.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCashFlowLineItemID(Long value) {
                this.cashFlowLineItemID = value;
            }

            /**
             * Obtiene el valor de la propiedad credit.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getCredit() {
                return credit;
            }

            /**
             * Define el valor de la propiedad credit.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setCredit(Double value) {
                this.credit = value;
            }

            /**
             * Obtiene el valor de la propiedad paymentMeans.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPaymentMeans() {
                return paymentMeans;
            }

            /**
             * Define el valor de la propiedad paymentMeans.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPaymentMeans(String value) {
                this.paymentMeans = value;
            }

            /**
             * Obtiene el valor de la propiedad checkNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCheckNumber() {
                return checkNumber;
            }

            /**
             * Define el valor de la propiedad checkNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCheckNumber(String value) {
                this.checkNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad amountLC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getAmountLC() {
                return amountLC;
            }

            /**
             * Define el valor de la propiedad amountLC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setAmountLC(Double value) {
                this.amountLC = value;
            }

            /**
             * Obtiene el valor de la propiedad amountFC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getAmountFC() {
                return amountFC;
            }

            /**
             * Define el valor de la propiedad amountFC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setAmountFC(Double value) {
                this.amountFC = value;
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
     *         &lt;element name="PaymentAccount" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="SumPaid" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="SumPaidFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="Decription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VatGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="GrossAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="ProfitCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="VatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="ProfitCenter2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProfitCenter3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProfitCenter4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ProfitCenter5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="LocationCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="EqualizationVatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "paymentAccount"
    })
    public static class PaymentAccounts {

        @XmlElement(name = "PaymentAccount")
        protected List<Payment.PaymentAccounts.PaymentAccount> paymentAccount;

        /**
         * Gets the value of the paymentAccount property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentAccount property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentAccount().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.PaymentAccounts.PaymentAccount }
         * 
         * 
         */
        public List<Payment.PaymentAccounts.PaymentAccount> getPaymentAccount() {
            if (paymentAccount == null) {
                paymentAccount = new ArrayList<Payment.PaymentAccounts.PaymentAccount>();
            }
            return this.paymentAccount;
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
         *         &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="AccountCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="SumPaid" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="SumPaidFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="Decription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VatGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="GrossAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="ProfitCenter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="VatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="ProfitCenter2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProfitCenter3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProfitCenter4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ProfitCenter5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="LocationCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="EqualizationVatAmount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        public static class PaymentAccount {

            @XmlElement(name = "LineNum")
            protected Long lineNum;
            @XmlElement(name = "AccountCode")
            protected String accountCode;
            @XmlElement(name = "SumPaid")
            protected Double sumPaid;
            @XmlElement(name = "SumPaidFC")
            protected Double sumPaidFC;
            @XmlElement(name = "Decription")
            protected String decription;
            @XmlElement(name = "VatGroup")
            protected String vatGroup;
            @XmlElement(name = "AccountName")
            protected String accountName;
            @XmlElement(name = "GrossAmount")
            protected Double grossAmount;
            @XmlElement(name = "ProfitCenter")
            protected String profitCenter;
            @XmlElement(name = "ProjectCode")
            protected String projectCode;
            @XmlElement(name = "VatAmount")
            protected Double vatAmount;
            @XmlElement(name = "ProfitCenter2")
            protected String profitCenter2;
            @XmlElement(name = "ProfitCenter3")
            protected String profitCenter3;
            @XmlElement(name = "ProfitCenter4")
            protected String profitCenter4;
            @XmlElement(name = "ProfitCenter5")
            protected String profitCenter5;
            @XmlElement(name = "LocationCode")
            protected Long locationCode;
            @XmlElement(name = "EqualizationVatAmount")
            protected Double equalizationVatAmount;

            /**
             * Obtiene el valor de la propiedad lineNum.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLineNum() {
                return lineNum;
            }

            /**
             * Define el valor de la propiedad lineNum.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLineNum(Long value) {
                this.lineNum = value;
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
             * Obtiene el valor de la propiedad sumPaid.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getSumPaid() {
                return sumPaid;
            }

            /**
             * Define el valor de la propiedad sumPaid.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setSumPaid(Double value) {
                this.sumPaid = value;
            }

            /**
             * Obtiene el valor de la propiedad sumPaidFC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getSumPaidFC() {
                return sumPaidFC;
            }

            /**
             * Define el valor de la propiedad sumPaidFC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setSumPaidFC(Double value) {
                this.sumPaidFC = value;
            }

            /**
             * Obtiene el valor de la propiedad decription.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDecription() {
                return decription;
            }

            /**
             * Define el valor de la propiedad decription.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDecription(String value) {
                this.decription = value;
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
             * Obtiene el valor de la propiedad grossAmount.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getGrossAmount() {
                return grossAmount;
            }

            /**
             * Define el valor de la propiedad grossAmount.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setGrossAmount(Double value) {
                this.grossAmount = value;
            }

            /**
             * Obtiene el valor de la propiedad profitCenter.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfitCenter() {
                return profitCenter;
            }

            /**
             * Define el valor de la propiedad profitCenter.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfitCenter(String value) {
                this.profitCenter = value;
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
             * Obtiene el valor de la propiedad vatAmount.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getVatAmount() {
                return vatAmount;
            }

            /**
             * Define el valor de la propiedad vatAmount.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setVatAmount(Double value) {
                this.vatAmount = value;
            }

            /**
             * Obtiene el valor de la propiedad profitCenter2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfitCenter2() {
                return profitCenter2;
            }

            /**
             * Define el valor de la propiedad profitCenter2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfitCenter2(String value) {
                this.profitCenter2 = value;
            }

            /**
             * Obtiene el valor de la propiedad profitCenter3.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfitCenter3() {
                return profitCenter3;
            }

            /**
             * Define el valor de la propiedad profitCenter3.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfitCenter3(String value) {
                this.profitCenter3 = value;
            }

            /**
             * Obtiene el valor de la propiedad profitCenter4.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfitCenter4() {
                return profitCenter4;
            }

            /**
             * Define el valor de la propiedad profitCenter4.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfitCenter4(String value) {
                this.profitCenter4 = value;
            }

            /**
             * Obtiene el valor de la propiedad profitCenter5.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getProfitCenter5() {
                return profitCenter5;
            }

            /**
             * Define el valor de la propiedad profitCenter5.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setProfitCenter5(String value) {
                this.profitCenter5 = value;
            }

            /**
             * Obtiene el valor de la propiedad locationCode.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLocationCode() {
                return locationCode;
            }

            /**
             * Define el valor de la propiedad locationCode.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLocationCode(Long value) {
                this.locationCode = value;
            }

            /**
             * Obtiene el valor de la propiedad equalizationVatAmount.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getEqualizationVatAmount() {
                return equalizationVatAmount;
            }

            /**
             * Define el valor de la propiedad equalizationVatAmount.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setEqualizationVatAmount(Double value) {
                this.equalizationVatAmount = value;
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
     *         &lt;element name="PaymentCheck" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="AccounttNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="Trnsfrable" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="tNO"/>
     *                         &lt;enumeration value="tYES"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CheckAbsEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="CheckAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="ManualCheck" minOccurs="0">
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
        "paymentCheck"
    })
    public static class PaymentChecks {

        @XmlElement(name = "PaymentCheck")
        protected List<Payment.PaymentChecks.PaymentCheck> paymentCheck;

        /**
         * Gets the value of the paymentCheck property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentCheck property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentCheck().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.PaymentChecks.PaymentCheck }
         * 
         * 
         */
        public List<Payment.PaymentChecks.PaymentCheck> getPaymentCheck() {
            if (paymentCheck == null) {
                paymentCheck = new ArrayList<Payment.PaymentChecks.PaymentCheck>();
            }
            return this.paymentCheck;
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
         *         &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="DueDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="CheckNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="BankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Branch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="AccounttNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="Trnsfrable" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="tNO"/>
         *               &lt;enumeration value="tYES"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CheckAbsEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="CheckAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="ManualCheck" minOccurs="0">
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
        public static class PaymentCheck {

            @XmlElement(name = "LineNum")
            protected Long lineNum;
            @XmlElement(name = "DueDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar dueDate;
            @XmlElement(name = "CheckNumber")
            protected Long checkNumber;
            @XmlElement(name = "BankCode")
            protected String bankCode;
            @XmlElement(name = "Branch")
            protected String branch;
            @XmlElement(name = "AccounttNum")
            protected String accounttNum;
            @XmlElement(name = "Details")
            protected String details;
            @XmlElement(name = "Trnsfrable")
            protected String trnsfrable;
            @XmlElement(name = "CheckSum")
            protected Double checkSum;
            @XmlElement(name = "Currency")
            protected String currency;
            @XmlElement(name = "CountryCode")
            protected String countryCode;
            @XmlElement(name = "CheckAbsEntry")
            protected Long checkAbsEntry;
            @XmlElement(name = "CheckAccount")
            protected String checkAccount;
            @XmlElement(name = "ManualCheck")
            protected String manualCheck;

            /**
             * Obtiene el valor de la propiedad lineNum.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLineNum() {
                return lineNum;
            }

            /**
             * Define el valor de la propiedad lineNum.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLineNum(Long value) {
                this.lineNum = value;
            }

            /**
             * Obtiene el valor de la propiedad dueDate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDueDate() {
                return dueDate;
            }

            /**
             * Define el valor de la propiedad dueDate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDueDate(XMLGregorianCalendar value) {
                this.dueDate = value;
            }

            /**
             * Obtiene el valor de la propiedad checkNumber.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCheckNumber() {
                return checkNumber;
            }

            /**
             * Define el valor de la propiedad checkNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCheckNumber(Long value) {
                this.checkNumber = value;
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
             * Obtiene el valor de la propiedad accounttNum.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAccounttNum() {
                return accounttNum;
            }

            /**
             * Define el valor de la propiedad accounttNum.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAccounttNum(String value) {
                this.accounttNum = value;
            }

            /**
             * Obtiene el valor de la propiedad details.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDetails() {
                return details;
            }

            /**
             * Define el valor de la propiedad details.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDetails(String value) {
                this.details = value;
            }

            /**
             * Obtiene el valor de la propiedad trnsfrable.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTrnsfrable() {
                return trnsfrable;
            }

            /**
             * Define el valor de la propiedad trnsfrable.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTrnsfrable(String value) {
                this.trnsfrable = value;
            }

            /**
             * Obtiene el valor de la propiedad checkSum.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getCheckSum() {
                return checkSum;
            }

            /**
             * Define el valor de la propiedad checkSum.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setCheckSum(Double value) {
                this.checkSum = value;
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
             * Obtiene el valor de la propiedad countryCode.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountryCode() {
                return countryCode;
            }

            /**
             * Define el valor de la propiedad countryCode.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountryCode(String value) {
                this.countryCode = value;
            }

            /**
             * Obtiene el valor de la propiedad checkAbsEntry.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCheckAbsEntry() {
                return checkAbsEntry;
            }

            /**
             * Define el valor de la propiedad checkAbsEntry.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCheckAbsEntry(Long value) {
                this.checkAbsEntry = value;
            }

            /**
             * Obtiene el valor de la propiedad checkAccount.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCheckAccount() {
                return checkAccount;
            }

            /**
             * Define el valor de la propiedad checkAccount.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCheckAccount(String value) {
                this.checkAccount = value;
            }

            /**
             * Obtiene el valor de la propiedad manualCheck.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getManualCheck() {
                return manualCheck;
            }

            /**
             * Define el valor de la propiedad manualCheck.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setManualCheck(String value) {
                this.manualCheck = value;
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
     *         &lt;element name="PaymentCreditCard" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="CreditCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="CreditAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CreditCardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CardValidUntil" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="VoucherNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OwnerIdNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="OwnerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="NumOfPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="FirstPaymentDue" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="FirstPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="AdditionalPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="CreditSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="CreditCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="CreditRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="ConfirmationNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="NumOfCreditPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="CreditType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="cr_Regular"/>
     *                         &lt;enumeration value="cr_Telephone"/>
     *                         &lt;enumeration value="cr_InternetTransaction"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="SplitPayments" minOccurs="0">
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
        "paymentCreditCard"
    })
    public static class PaymentCreditCards {

        @XmlElement(name = "PaymentCreditCard")
        protected List<Payment.PaymentCreditCards.PaymentCreditCard> paymentCreditCard;

        /**
         * Gets the value of the paymentCreditCard property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentCreditCard property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentCreditCard().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.PaymentCreditCards.PaymentCreditCard }
         * 
         * 
         */
        public List<Payment.PaymentCreditCards.PaymentCreditCard> getPaymentCreditCard() {
            if (paymentCreditCard == null) {
                paymentCreditCard = new ArrayList<Payment.PaymentCreditCards.PaymentCreditCard>();
            }
            return this.paymentCreditCard;
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
         *         &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="CreditCard" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="CreditAcct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CreditCardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CardValidUntil" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="VoucherNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OwnerIdNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="OwnerPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="PaymentMethodCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="NumOfPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="FirstPaymentDue" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="FirstPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="AdditionalPaymentSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="CreditSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="CreditCur" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="CreditRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="ConfirmationNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="NumOfCreditPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="CreditType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="cr_Regular"/>
         *               &lt;enumeration value="cr_Telephone"/>
         *               &lt;enumeration value="cr_InternetTransaction"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="SplitPayments" minOccurs="0">
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
        public static class PaymentCreditCard {

            @XmlElement(name = "LineNum")
            protected Long lineNum;
            @XmlElement(name = "CreditCard")
            protected Long creditCard;
            @XmlElement(name = "CreditAcct")
            protected String creditAcct;
            @XmlElement(name = "CreditCardNumber")
            protected String creditCardNumber;
            @XmlElement(name = "CardValidUntil")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar cardValidUntil;
            @XmlElement(name = "VoucherNum")
            protected String voucherNum;
            @XmlElement(name = "OwnerIdNum")
            protected String ownerIdNum;
            @XmlElement(name = "OwnerPhone")
            protected String ownerPhone;
            @XmlElement(name = "PaymentMethodCode")
            protected Long paymentMethodCode;
            @XmlElement(name = "NumOfPayments")
            protected Long numOfPayments;
            @XmlElement(name = "FirstPaymentDue")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar firstPaymentDue;
            @XmlElement(name = "FirstPaymentSum")
            protected Double firstPaymentSum;
            @XmlElement(name = "AdditionalPaymentSum")
            protected Double additionalPaymentSum;
            @XmlElement(name = "CreditSum")
            protected Double creditSum;
            @XmlElement(name = "CreditCur")
            protected String creditCur;
            @XmlElement(name = "CreditRate")
            protected Double creditRate;
            @XmlElement(name = "ConfirmationNum")
            protected String confirmationNum;
            @XmlElement(name = "NumOfCreditPayments")
            protected Long numOfCreditPayments;
            @XmlElement(name = "CreditType")
            protected String creditType;
            @XmlElement(name = "SplitPayments")
            protected String splitPayments;

            /**
             * Obtiene el valor de la propiedad lineNum.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLineNum() {
                return lineNum;
            }

            /**
             * Define el valor de la propiedad lineNum.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLineNum(Long value) {
                this.lineNum = value;
            }

            /**
             * Obtiene el valor de la propiedad creditCard.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCreditCard() {
                return creditCard;
            }

            /**
             * Define el valor de la propiedad creditCard.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCreditCard(Long value) {
                this.creditCard = value;
            }

            /**
             * Obtiene el valor de la propiedad creditAcct.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreditAcct() {
                return creditAcct;
            }

            /**
             * Define el valor de la propiedad creditAcct.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreditAcct(String value) {
                this.creditAcct = value;
            }

            /**
             * Obtiene el valor de la propiedad creditCardNumber.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreditCardNumber() {
                return creditCardNumber;
            }

            /**
             * Define el valor de la propiedad creditCardNumber.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreditCardNumber(String value) {
                this.creditCardNumber = value;
            }

            /**
             * Obtiene el valor de la propiedad cardValidUntil.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getCardValidUntil() {
                return cardValidUntil;
            }

            /**
             * Define el valor de la propiedad cardValidUntil.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setCardValidUntil(XMLGregorianCalendar value) {
                this.cardValidUntil = value;
            }

            /**
             * Obtiene el valor de la propiedad voucherNum.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getVoucherNum() {
                return voucherNum;
            }

            /**
             * Define el valor de la propiedad voucherNum.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setVoucherNum(String value) {
                this.voucherNum = value;
            }

            /**
             * Obtiene el valor de la propiedad ownerIdNum.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOwnerIdNum() {
                return ownerIdNum;
            }

            /**
             * Define el valor de la propiedad ownerIdNum.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOwnerIdNum(String value) {
                this.ownerIdNum = value;
            }

            /**
             * Obtiene el valor de la propiedad ownerPhone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOwnerPhone() {
                return ownerPhone;
            }

            /**
             * Define el valor de la propiedad ownerPhone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOwnerPhone(String value) {
                this.ownerPhone = value;
            }

            /**
             * Obtiene el valor de la propiedad paymentMethodCode.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getPaymentMethodCode() {
                return paymentMethodCode;
            }

            /**
             * Define el valor de la propiedad paymentMethodCode.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setPaymentMethodCode(Long value) {
                this.paymentMethodCode = value;
            }

            /**
             * Obtiene el valor de la propiedad numOfPayments.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumOfPayments() {
                return numOfPayments;
            }

            /**
             * Define el valor de la propiedad numOfPayments.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumOfPayments(Long value) {
                this.numOfPayments = value;
            }

            /**
             * Obtiene el valor de la propiedad firstPaymentDue.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getFirstPaymentDue() {
                return firstPaymentDue;
            }

            /**
             * Define el valor de la propiedad firstPaymentDue.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setFirstPaymentDue(XMLGregorianCalendar value) {
                this.firstPaymentDue = value;
            }

            /**
             * Obtiene el valor de la propiedad firstPaymentSum.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getFirstPaymentSum() {
                return firstPaymentSum;
            }

            /**
             * Define el valor de la propiedad firstPaymentSum.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setFirstPaymentSum(Double value) {
                this.firstPaymentSum = value;
            }

            /**
             * Obtiene el valor de la propiedad additionalPaymentSum.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getAdditionalPaymentSum() {
                return additionalPaymentSum;
            }

            /**
             * Define el valor de la propiedad additionalPaymentSum.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setAdditionalPaymentSum(Double value) {
                this.additionalPaymentSum = value;
            }

            /**
             * Obtiene el valor de la propiedad creditSum.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getCreditSum() {
                return creditSum;
            }

            /**
             * Define el valor de la propiedad creditSum.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setCreditSum(Double value) {
                this.creditSum = value;
            }

            /**
             * Obtiene el valor de la propiedad creditCur.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreditCur() {
                return creditCur;
            }

            /**
             * Define el valor de la propiedad creditCur.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreditCur(String value) {
                this.creditCur = value;
            }

            /**
             * Obtiene el valor de la propiedad creditRate.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getCreditRate() {
                return creditRate;
            }

            /**
             * Define el valor de la propiedad creditRate.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setCreditRate(Double value) {
                this.creditRate = value;
            }

            /**
             * Obtiene el valor de la propiedad confirmationNum.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getConfirmationNum() {
                return confirmationNum;
            }

            /**
             * Define el valor de la propiedad confirmationNum.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setConfirmationNum(String value) {
                this.confirmationNum = value;
            }

            /**
             * Obtiene el valor de la propiedad numOfCreditPayments.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumOfCreditPayments() {
                return numOfCreditPayments;
            }

            /**
             * Define el valor de la propiedad numOfCreditPayments.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumOfCreditPayments(Long value) {
                this.numOfCreditPayments = value;
            }

            /**
             * Obtiene el valor de la propiedad creditType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCreditType() {
                return creditType;
            }

            /**
             * Define el valor de la propiedad creditType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCreditType(String value) {
                this.creditType = value;
            }

            /**
             * Obtiene el valor de la propiedad splitPayments.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSplitPayments() {
                return splitPayments;
            }

            /**
             * Define el valor de la propiedad splitPayments.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSplitPayments(String value) {
                this.splitPayments = value;
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
     *         &lt;element name="PaymentInvoice" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="DocEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="SumApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="AppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="AppliedSys" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="DocRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="DocLine" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="InvoiceType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="it_AllTransactions"/>
     *                         &lt;enumeration value="it_OpeningBalance"/>
     *                         &lt;enumeration value="it_ClosingBalance"/>
     *                         &lt;enumeration value="it_Invoice"/>
     *                         &lt;enumeration value="it_CredItnote"/>
     *                         &lt;enumeration value="it_TaxInvoice"/>
     *                         &lt;enumeration value="it_Return"/>
     *                         &lt;enumeration value="it_PurchaseInvoice"/>
     *                         &lt;enumeration value="it_PurchaseCreditNote"/>
     *                         &lt;enumeration value="it_PurchaseDeliveryNote"/>
     *                         &lt;enumeration value="it_PurchaseReturn"/>
     *                         &lt;enumeration value="it_Receipt"/>
     *                         &lt;enumeration value="it_Deposit"/>
     *                         &lt;enumeration value="it_JournalEntry"/>
     *                         &lt;enumeration value="it_PaymentAdvice"/>
     *                         &lt;enumeration value="it_ChequesForPayment"/>
     *                         &lt;enumeration value="it_StockReconciliations"/>
     *                         &lt;enumeration value="it_GeneralReceiptToStock"/>
     *                         &lt;enumeration value="it_GeneralReleaseFromStock"/>
     *                         &lt;enumeration value="it_TransferBetweenWarehouses"/>
     *                         &lt;enumeration value="it_WorkInstructions"/>
     *                         &lt;enumeration value="it_DeferredDeposit"/>
     *                         &lt;enumeration value="it_CorrectionInvoice"/>
     *                         &lt;enumeration value="it_APCorrectionInvoice"/>
     *                         &lt;enumeration value="it_ARCorrectionInvoice"/>
     *                         &lt;enumeration value="it_DownPayment"/>
     *                         &lt;enumeration value="it_PurchaseDownPayment"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="PaidSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="InstallmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="WitholdingTaxApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="WitholdingTaxAppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="WitholdingTaxAppliedSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="LinkDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="DistributionRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DistributionRule2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DistributionRule3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DistributionRule4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="DistributionRule5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="TotalDiscount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="TotalDiscountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
     *                   &lt;element name="TotalDiscountSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        "paymentInvoice"
    })
    public static class PaymentInvoices {

        @XmlElement(name = "PaymentInvoice")
        protected List<Payment.PaymentInvoices.PaymentInvoice> paymentInvoice;

        /**
         * Gets the value of the paymentInvoice property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentInvoice property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentInvoice().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.PaymentInvoices.PaymentInvoice }
         * 
         * 
         */
        public List<Payment.PaymentInvoices.PaymentInvoice> getPaymentInvoice() {
            if (paymentInvoice == null) {
                paymentInvoice = new ArrayList<Payment.PaymentInvoices.PaymentInvoice>();
            }
            return this.paymentInvoice;
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
         *         &lt;element name="LineNum" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="DocEntry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="SumApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="AppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="AppliedSys" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="DocRate" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="DocLine" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="InvoiceType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="it_AllTransactions"/>
         *               &lt;enumeration value="it_OpeningBalance"/>
         *               &lt;enumeration value="it_ClosingBalance"/>
         *               &lt;enumeration value="it_Invoice"/>
         *               &lt;enumeration value="it_CredItnote"/>
         *               &lt;enumeration value="it_TaxInvoice"/>
         *               &lt;enumeration value="it_Return"/>
         *               &lt;enumeration value="it_PurchaseInvoice"/>
         *               &lt;enumeration value="it_PurchaseCreditNote"/>
         *               &lt;enumeration value="it_PurchaseDeliveryNote"/>
         *               &lt;enumeration value="it_PurchaseReturn"/>
         *               &lt;enumeration value="it_Receipt"/>
         *               &lt;enumeration value="it_Deposit"/>
         *               &lt;enumeration value="it_JournalEntry"/>
         *               &lt;enumeration value="it_PaymentAdvice"/>
         *               &lt;enumeration value="it_ChequesForPayment"/>
         *               &lt;enumeration value="it_StockReconciliations"/>
         *               &lt;enumeration value="it_GeneralReceiptToStock"/>
         *               &lt;enumeration value="it_GeneralReleaseFromStock"/>
         *               &lt;enumeration value="it_TransferBetweenWarehouses"/>
         *               &lt;enumeration value="it_WorkInstructions"/>
         *               &lt;enumeration value="it_DeferredDeposit"/>
         *               &lt;enumeration value="it_CorrectionInvoice"/>
         *               &lt;enumeration value="it_APCorrectionInvoice"/>
         *               &lt;enumeration value="it_ARCorrectionInvoice"/>
         *               &lt;enumeration value="it_DownPayment"/>
         *               &lt;enumeration value="it_PurchaseDownPayment"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DiscountPercent" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="PaidSum" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="InstallmentId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="WitholdingTaxApplied" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="WitholdingTaxAppliedFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="WitholdingTaxAppliedSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="LinkDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="DistributionRule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DistributionRule2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DistributionRule3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DistributionRule4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="DistributionRule5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="TotalDiscount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="TotalDiscountFC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
         *         &lt;element name="TotalDiscountSC" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
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
        public static class PaymentInvoice {

            @XmlElement(name = "LineNum")
            protected Long lineNum;
            @XmlElement(name = "DocEntry")
            protected Long docEntry;
            @XmlElement(name = "SumApplied")
            protected BigDecimal sumApplied;
            @XmlElement(name = "AppliedFC")
            protected Double appliedFC;
            @XmlElement(name = "AppliedSys")
            protected Double appliedSys;
            @XmlElement(name = "DocRate")
            protected Double docRate;
            @XmlElement(name = "DocLine")
            protected Long docLine;
            @XmlElement(name = "InvoiceType")
            protected String invoiceType;
            @XmlElement(name = "DiscountPercent")
            protected Double discountPercent;
            @XmlElement(name = "PaidSum")
            protected Double paidSum;
            @XmlElement(name = "InstallmentId")
            protected Long installmentId;
            @XmlElement(name = "WitholdingTaxApplied")
            protected Double witholdingTaxApplied;
            @XmlElement(name = "WitholdingTaxAppliedFC")
            protected Double witholdingTaxAppliedFC;
            @XmlElement(name = "WitholdingTaxAppliedSC")
            protected Double witholdingTaxAppliedSC;
            @XmlElement(name = "LinkDate")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar linkDate;
            @XmlElement(name = "DistributionRule")
            protected String distributionRule;
            @XmlElement(name = "DistributionRule2")
            protected String distributionRule2;
            @XmlElement(name = "DistributionRule3")
            protected String distributionRule3;
            @XmlElement(name = "DistributionRule4")
            protected String distributionRule4;
            @XmlElement(name = "DistributionRule5")
            protected String distributionRule5;
            @XmlElement(name = "TotalDiscount")
            protected Double totalDiscount;
            @XmlElement(name = "TotalDiscountFC")
            protected Double totalDiscountFC;
            @XmlElement(name = "TotalDiscountSC")
            protected Double totalDiscountSC;

            /**
             * Obtiene el valor de la propiedad lineNum.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getLineNum() {
                return lineNum;
            }

            /**
             * Define el valor de la propiedad lineNum.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setLineNum(Long value) {
                this.lineNum = value;
            }

            /**
             * Obtiene el valor de la propiedad docEntry.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getDocEntry() {
                return docEntry;
            }

            /**
             * Define el valor de la propiedad docEntry.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setDocEntry(Long value) {
                this.docEntry = value;
            }

            /**
             * Obtiene el valor de la propiedad sumApplied.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public BigDecimal getSumApplied() {
                return sumApplied;
            }

            /**
             * Define el valor de la propiedad sumApplied.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setSumApplied(BigDecimal value) {
                this.sumApplied = value;
            }

            /**
             * Obtiene el valor de la propiedad appliedFC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getAppliedFC() {
                return appliedFC;
            }

            /**
             * Define el valor de la propiedad appliedFC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setAppliedFC(Double value) {
                this.appliedFC = value;
            }

            /**
             * Obtiene el valor de la propiedad appliedSys.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getAppliedSys() {
                return appliedSys;
            }

            /**
             * Define el valor de la propiedad appliedSys.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setAppliedSys(Double value) {
                this.appliedSys = value;
            }

            /**
             * Obtiene el valor de la propiedad docRate.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getDocRate() {
                return docRate;
            }

            /**
             * Define el valor de la propiedad docRate.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setDocRate(Double value) {
                this.docRate = value;
            }

            /**
             * Obtiene el valor de la propiedad docLine.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getDocLine() {
                return docLine;
            }

            /**
             * Define el valor de la propiedad docLine.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setDocLine(Long value) {
                this.docLine = value;
            }

            /**
             * Obtiene el valor de la propiedad invoiceType.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInvoiceType() {
                return invoiceType;
            }

            /**
             * Define el valor de la propiedad invoiceType.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInvoiceType(String value) {
                this.invoiceType = value;
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
             * Obtiene el valor de la propiedad paidSum.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getPaidSum() {
                return paidSum;
            }

            /**
             * Define el valor de la propiedad paidSum.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setPaidSum(Double value) {
                this.paidSum = value;
            }

            /**
             * Obtiene el valor de la propiedad installmentId.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getInstallmentId() {
                return installmentId;
            }

            /**
             * Define el valor de la propiedad installmentId.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setInstallmentId(Long value) {
                this.installmentId = value;
            }

            /**
             * Obtiene el valor de la propiedad witholdingTaxApplied.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWitholdingTaxApplied() {
                return witholdingTaxApplied;
            }

            /**
             * Define el valor de la propiedad witholdingTaxApplied.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWitholdingTaxApplied(Double value) {
                this.witholdingTaxApplied = value;
            }

            /**
             * Obtiene el valor de la propiedad witholdingTaxAppliedFC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWitholdingTaxAppliedFC() {
                return witholdingTaxAppliedFC;
            }

            /**
             * Define el valor de la propiedad witholdingTaxAppliedFC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWitholdingTaxAppliedFC(Double value) {
                this.witholdingTaxAppliedFC = value;
            }

            /**
             * Obtiene el valor de la propiedad witholdingTaxAppliedSC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getWitholdingTaxAppliedSC() {
                return witholdingTaxAppliedSC;
            }

            /**
             * Define el valor de la propiedad witholdingTaxAppliedSC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setWitholdingTaxAppliedSC(Double value) {
                this.witholdingTaxAppliedSC = value;
            }

            /**
             * Obtiene el valor de la propiedad linkDate.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getLinkDate() {
                return linkDate;
            }

            /**
             * Define el valor de la propiedad linkDate.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setLinkDate(XMLGregorianCalendar value) {
                this.linkDate = value;
            }

            /**
             * Obtiene el valor de la propiedad distributionRule.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistributionRule() {
                return distributionRule;
            }

            /**
             * Define el valor de la propiedad distributionRule.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistributionRule(String value) {
                this.distributionRule = value;
            }

            /**
             * Obtiene el valor de la propiedad distributionRule2.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistributionRule2() {
                return distributionRule2;
            }

            /**
             * Define el valor de la propiedad distributionRule2.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistributionRule2(String value) {
                this.distributionRule2 = value;
            }

            /**
             * Obtiene el valor de la propiedad distributionRule3.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistributionRule3() {
                return distributionRule3;
            }

            /**
             * Define el valor de la propiedad distributionRule3.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistributionRule3(String value) {
                this.distributionRule3 = value;
            }

            /**
             * Obtiene el valor de la propiedad distributionRule4.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistributionRule4() {
                return distributionRule4;
            }

            /**
             * Define el valor de la propiedad distributionRule4.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistributionRule4(String value) {
                this.distributionRule4 = value;
            }

            /**
             * Obtiene el valor de la propiedad distributionRule5.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDistributionRule5() {
                return distributionRule5;
            }

            /**
             * Define el valor de la propiedad distributionRule5.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDistributionRule5(String value) {
                this.distributionRule5 = value;
            }

            /**
             * Obtiene el valor de la propiedad totalDiscount.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getTotalDiscount() {
                return totalDiscount;
            }

            /**
             * Define el valor de la propiedad totalDiscount.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setTotalDiscount(Double value) {
                this.totalDiscount = value;
            }

            /**
             * Obtiene el valor de la propiedad totalDiscountFC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getTotalDiscountFC() {
                return totalDiscountFC;
            }

            /**
             * Define el valor de la propiedad totalDiscountFC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setTotalDiscountFC(Double value) {
                this.totalDiscountFC = value;
            }

            /**
             * Obtiene el valor de la propiedad totalDiscountSC.
             * 
             * @return
             *     possible object is
             *     {@link Double }
             *     
             */
            public Double getTotalDiscountSC() {
                return totalDiscountSC;
            }

            /**
             * Define el valor de la propiedad totalDiscountSC.
             * 
             * @param value
             *     allowed object is
             *     {@link Double }
             *     
             */
            public void setTotalDiscountSC(Double value) {
                this.totalDiscountSC = value;
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
     *         &lt;element name="Payments_ApprovalRequest" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;all>
     *                   &lt;element name="ApprovalTemplatesID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "paymentsApprovalRequest"
    })
    public static class PaymentsApprovalRequests {

        @XmlElement(name = "Payments_ApprovalRequest")
        protected List<Payment.PaymentsApprovalRequests.PaymentsApprovalRequest> paymentsApprovalRequest;

        /**
         * Gets the value of the paymentsApprovalRequest property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the paymentsApprovalRequest property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPaymentsApprovalRequest().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Payment.PaymentsApprovalRequests.PaymentsApprovalRequest }
         * 
         * 
         */
        public List<Payment.PaymentsApprovalRequests.PaymentsApprovalRequest> getPaymentsApprovalRequest() {
            if (paymentsApprovalRequest == null) {
                paymentsApprovalRequest = new ArrayList<Payment.PaymentsApprovalRequests.PaymentsApprovalRequest>();
            }
            return this.paymentsApprovalRequest;
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
         *         &lt;element name="ApprovalTemplatesID" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="Remarks" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        public static class PaymentsApprovalRequest {

            @XmlElement(name = "ApprovalTemplatesID")
            protected Long approvalTemplatesID;
            @XmlElement(name = "Remarks")
            protected String remarks;

            /**
             * Obtiene el valor de la propiedad approvalTemplatesID.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getApprovalTemplatesID() {
                return approvalTemplatesID;
            }

            /**
             * Define el valor de la propiedad approvalTemplatesID.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setApprovalTemplatesID(Long value) {
                this.approvalTemplatesID = value;
            }

            /**
             * Obtiene el valor de la propiedad remarks.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRemarks() {
                return remarks;
            }

            /**
             * Define el valor de la propiedad remarks.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRemarks(String value) {
                this.remarks = value;
            }

        }

    }

}

package co.manager.hanaws.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentRestDTO implements Serializable {
    @JsonProperty("DocNum")
    protected Long docNum;
    @JsonProperty("DocType")
    protected String docType;
    @JsonProperty("HandWritten")
    protected String handWritten;
    @JsonProperty("Printed")
    protected String printed;
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("CardName")
    protected String cardName;
    @JsonProperty("Address")
    protected String address;
    @JsonProperty("CashAccount")
    protected String cashAccount;
    @JsonProperty("DocCurrency")
    protected String docCurrency;
    @JsonProperty("CashSum")
    protected BigDecimal cashSum;
    @JsonProperty("CheckAccount")
    protected String checkAccount;
    @JsonProperty("TransferAccount")
    protected String transferAccount;
    @JsonProperty("TransferSum")
    protected BigDecimal transferSum;
    @JsonProperty("TransferDate")
    protected String transferDate;
    @JsonProperty("TransferReference")
    protected String transferReference;
    @JsonProperty("LocalCurrency")
    protected String localCurrency;
    @JsonProperty("DocRate")
    protected Double docRate;
    @JsonProperty("Reference1")
    protected String reference1;
    @JsonProperty("Reference2")
    protected String reference2;
    @JsonProperty("CounterReference")
    protected String counterReference;
    @JsonProperty("Remarks")
    protected String remarks;
    @JsonProperty("JournalRemarks")
    protected String journalRemarks;
    @JsonProperty("SplitTransaction")
    protected String splitTransaction;
    @JsonProperty("ContactPersonCode")
    protected Long contactPersonCode;
    @JsonProperty("ApplyVAT")
    protected String applyVAT;
    @JsonProperty("TaxDate")
    protected String taxDate;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("BankCode")
    protected String bankCode;
    @JsonProperty("BankAccount")
    protected String bankAccount;
    @JsonProperty("DiscountPercent")
    protected Double discountPercent;
    @JsonProperty("ProjectCode")
    protected String projectCode;
    @JsonProperty("CurrencyIsLocal")
    protected String currencyIsLocal;
    @JsonProperty("DeductionPercent")
    protected Double deductionPercent;
    @JsonProperty("DeductionSum")
    protected Double deductionSum;
    @JsonProperty("CashSumFC")
    protected Double cashSumFC;
    @JsonProperty("CashSumSys")
    protected Double cashSumSys;
    @JsonProperty("BoeAccount")
    protected String boeAccount;
    @JsonProperty("BillOfExchangeAmount")
    protected Double billOfExchangeAmount;
    @JsonProperty("BillofExchangeStatus")
    protected String billofExchangeStatus;
    @JsonProperty("BillOfExchangeAmountFC")
    protected Double billOfExchangeAmountFC;
    @JsonProperty("BillOfExchangeAmountSC")
    protected Double billOfExchangeAmountSC;
    @JsonProperty("BillOfExchangeAgent")
    protected String billOfExchangeAgent;
    @JsonProperty("WTCode")
    protected String wtCode;
    @JsonProperty("WTAmount")
    protected Double wtAmount;
    @JsonProperty("WTAmountFC")
    protected Double wtAmountFC;
    @JsonProperty("WTAmountSC")
    protected Double wtAmountSC;
    @JsonProperty("WTAccount")
    protected String wtAccount;
    @JsonProperty("WTTaxableAmount")
    protected Double wtTaxableAmount;
    @JsonProperty("Proforma")
    protected String proforma;
    @JsonProperty("PayToBankCode")
    protected String payToBankCode;
    @JsonProperty("PayToBankBranch")
    protected String payToBankBranch;
    @JsonProperty("PayToBankAccountNo")
    protected String payToBankAccountNo;
    @JsonProperty("PayToCode")
    protected String payToCode;
    @JsonProperty("PayToBankCountry")
    protected String payToBankCountry;
    @JsonProperty("IsPayToBank")
    protected String isPayToBank;
    @JsonProperty("DocEntry")
    protected Long docEntry;
    @JsonProperty("PaymentPriority")
    protected String paymentPriority;
    @JsonProperty("TaxGroup")
    protected String taxGroup;
    @JsonProperty("BankChargeAmount")
    protected Double bankChargeAmount;
    @JsonProperty("BankChargeAmountInFC")
    protected Double bankChargeAmountInFC;
    @JsonProperty("BankChargeAmountInSC")
    protected Double bankChargeAmountInSC;
    @JsonProperty("UnderOverpaymentdifference")
    protected Double underOverpaymentdifference;
    @JsonProperty("UnderOverpaymentdiffSC")
    protected Double underOverpaymentdiffSC;
    @JsonProperty("WtBaseSum")
    protected Double wtBaseSum;
    @JsonProperty("WtBaseSumFC")
    protected Double wtBaseSumFC;
    @JsonProperty("WtBaseSumSC")
    protected Double wtBaseSumSC;
    @JsonProperty("VatDate")
    protected String vatDate;
    @JsonProperty("TransactionCode")
    protected String transactionCode;
    @JsonProperty("PaymentType")
    protected String paymentType;
    @JsonProperty("TransferRealAmount")
    protected Double transferRealAmount;
    @JsonProperty("DocObjectCode")
    protected String docObjectCode;
    @JsonProperty("DocTypte")
    protected String docTypte;
    @JsonProperty("DueDate")
    protected String dueDate;
    @JsonProperty("LocationCode")
    protected Long locationCode;
    @JsonProperty("Cancelled")
    protected String cancelled;
    @JsonProperty("ControlAccount")
    protected String controlAccount;
    @JsonProperty("UnderOverpaymentdiffFC")
    protected Double underOverpaymentdiffFC;
    @JsonProperty("AuthorizationStatus")
    protected String authorizationStatus;
    @JsonProperty("BPLID")
    protected Long bplid;
    @JsonProperty("BPLName")
    protected String bplName;
    @JsonProperty("VATRegNum")
    protected String vatRegNum;
    @JsonProperty("U_asesor")
    protected String uAsesor;
    @JsonProperty("U_OK1_IFRS")
    protected String uOK1IFRS;
    @JsonProperty("PaymentChecks")
    protected List<PaymentRestDTO.PaymentChecks.PaymentCheck> paymentChecks;
    protected List<PaymentRestDTO.PaymentInvoices.PaymentInvoice> paymentInvoices;
    protected List<PaymentRestDTO.PaymentCreditCards.PaymentCreditCard> paymentCreditCards;
    protected List<PaymentRestDTO.PaymentAccounts.PaymentAccount> paymentAccounts;
    protected PaymentRestDTO.BillOfExchange billOfExchange;
    protected PaymentRestDTO.CashFlowAssignments cashFlowAssignments;
    protected PaymentRestDTO.PaymentsApprovalRequests paymentsApprovalRequests;

    public Long getDocNum() {
        return docNum;
    }

    public void setDocNum(Long docNum) {
        this.docNum = docNum;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getHandWritten() {
        return handWritten;
    }

    public void setHandWritten(String handWritten) {
        this.handWritten = handWritten;
    }

    public String getPrinted() {
        return printed;
    }

    public void setPrinted(String printed) {
        this.printed = printed;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount;
    }

    public String getDocCurrency() {
        return docCurrency;
    }

    public void setDocCurrency(String docCurrency) {
        this.docCurrency = docCurrency;
    }

    public BigDecimal getCashSum() {
        return cashSum;
    }

    public void setCashSum(BigDecimal cashSum) {
        this.cashSum = cashSum;
    }

    public String getCheckAccount() {
        return checkAccount;
    }

    public void setCheckAccount(String checkAccount) {
        this.checkAccount = checkAccount;
    }

    public String getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public BigDecimal getTransferSum() {
        return transferSum;
    }

    public void setTransferSum(BigDecimal transferSum) {
        this.transferSum = transferSum;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public String getLocalCurrency() {
        return localCurrency;
    }

    public void setLocalCurrency(String localCurrency) {
        this.localCurrency = localCurrency;
    }

    public Double getDocRate() {
        return docRate;
    }

    public void setDocRate(Double docRate) {
        this.docRate = docRate;
    }

    public String getReference1() {
        return reference1;
    }

    public void setReference1(String reference1) {
        this.reference1 = reference1;
    }

    public String getReference2() {
        return reference2;
    }

    public void setReference2(String reference2) {
        this.reference2 = reference2;
    }

    public String getCounterReference() {
        return counterReference;
    }

    public void setCounterReference(String counterReference) {
        this.counterReference = counterReference;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getJournalRemarks() {
        return journalRemarks;
    }

    public void setJournalRemarks(String journalRemarks) {
        this.journalRemarks = journalRemarks;
    }

    public String getSplitTransaction() {
        return splitTransaction;
    }

    public void setSplitTransaction(String splitTransaction) {
        this.splitTransaction = splitTransaction;
    }

    public Long getContactPersonCode() {
        return contactPersonCode;
    }

    public void setContactPersonCode(Long contactPersonCode) {
        this.contactPersonCode = contactPersonCode;
    }

    public String getApplyVAT() {
        return applyVAT;
    }

    public void setApplyVAT(String applyVAT) {
        this.applyVAT = applyVAT;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getCurrencyIsLocal() {
        return currencyIsLocal;
    }

    public void setCurrencyIsLocal(String currencyIsLocal) {
        this.currencyIsLocal = currencyIsLocal;
    }

    public Double getDeductionPercent() {
        return deductionPercent;
    }

    public void setDeductionPercent(Double deductionPercent) {
        this.deductionPercent = deductionPercent;
    }

    public Double getDeductionSum() {
        return deductionSum;
    }

    public void setDeductionSum(Double deductionSum) {
        this.deductionSum = deductionSum;
    }

    public Double getCashSumFC() {
        return cashSumFC;
    }

    public void setCashSumFC(Double cashSumFC) {
        this.cashSumFC = cashSumFC;
    }

    public Double getCashSumSys() {
        return cashSumSys;
    }

    public void setCashSumSys(Double cashSumSys) {
        this.cashSumSys = cashSumSys;
    }

    public String getBoeAccount() {
        return boeAccount;
    }

    public void setBoeAccount(String boeAccount) {
        this.boeAccount = boeAccount;
    }

    public Double getBillOfExchangeAmount() {
        return billOfExchangeAmount;
    }

    public void setBillOfExchangeAmount(Double billOfExchangeAmount) {
        this.billOfExchangeAmount = billOfExchangeAmount;
    }

    public String getBillofExchangeStatus() {
        return billofExchangeStatus;
    }

    public void setBillofExchangeStatus(String billofExchangeStatus) {
        this.billofExchangeStatus = billofExchangeStatus;
    }

    public Double getBillOfExchangeAmountFC() {
        return billOfExchangeAmountFC;
    }

    public void setBillOfExchangeAmountFC(Double billOfExchangeAmountFC) {
        this.billOfExchangeAmountFC = billOfExchangeAmountFC;
    }

    public Double getBillOfExchangeAmountSC() {
        return billOfExchangeAmountSC;
    }

    public void setBillOfExchangeAmountSC(Double billOfExchangeAmountSC) {
        this.billOfExchangeAmountSC = billOfExchangeAmountSC;
    }

    public String getBillOfExchangeAgent() {
        return billOfExchangeAgent;
    }

    public void setBillOfExchangeAgent(String billOfExchangeAgent) {
        this.billOfExchangeAgent = billOfExchangeAgent;
    }

    public String getWtCode() {
        return wtCode;
    }

    public void setWtCode(String wtCode) {
        this.wtCode = wtCode;
    }

    public Double getWtAmount() {
        return wtAmount;
    }

    public void setWtAmount(Double wtAmount) {
        this.wtAmount = wtAmount;
    }

    public Double getWtAmountFC() {
        return wtAmountFC;
    }

    public void setWtAmountFC(Double wtAmountFC) {
        this.wtAmountFC = wtAmountFC;
    }

    public Double getWtAmountSC() {
        return wtAmountSC;
    }

    public void setWtAmountSC(Double wtAmountSC) {
        this.wtAmountSC = wtAmountSC;
    }

    public String getWtAccount() {
        return wtAccount;
    }

    public void setWtAccount(String wtAccount) {
        this.wtAccount = wtAccount;
    }

    public Double getWtTaxableAmount() {
        return wtTaxableAmount;
    }

    public void setWtTaxableAmount(Double wtTaxableAmount) {
        this.wtTaxableAmount = wtTaxableAmount;
    }

    public String getProforma() {
        return proforma;
    }

    public void setProforma(String proforma) {
        this.proforma = proforma;
    }

    public String getPayToBankCode() {
        return payToBankCode;
    }

    public void setPayToBankCode(String payToBankCode) {
        this.payToBankCode = payToBankCode;
    }

    public String getPayToBankBranch() {
        return payToBankBranch;
    }

    public void setPayToBankBranch(String payToBankBranch) {
        this.payToBankBranch = payToBankBranch;
    }

    public String getPayToBankAccountNo() {
        return payToBankAccountNo;
    }

    public void setPayToBankAccountNo(String payToBankAccountNo) {
        this.payToBankAccountNo = payToBankAccountNo;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
    }

    public String getPayToBankCountry() {
        return payToBankCountry;
    }

    public void setPayToBankCountry(String payToBankCountry) {
        this.payToBankCountry = payToBankCountry;
    }

    public String getIsPayToBank() {
        return isPayToBank;
    }

    public void setIsPayToBank(String isPayToBank) {
        this.isPayToBank = isPayToBank;
    }

    public Long getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Long docEntry) {
        this.docEntry = docEntry;
    }

    public String getPaymentPriority() {
        return paymentPriority;
    }

    public void setPaymentPriority(String paymentPriority) {
        this.paymentPriority = paymentPriority;
    }

    public String getTaxGroup() {
        return taxGroup;
    }

    public void setTaxGroup(String taxGroup) {
        this.taxGroup = taxGroup;
    }

    public Double getBankChargeAmount() {
        return bankChargeAmount;
    }

    public void setBankChargeAmount(Double bankChargeAmount) {
        this.bankChargeAmount = bankChargeAmount;
    }

    public Double getBankChargeAmountInFC() {
        return bankChargeAmountInFC;
    }

    public void setBankChargeAmountInFC(Double bankChargeAmountInFC) {
        this.bankChargeAmountInFC = bankChargeAmountInFC;
    }

    public Double getBankChargeAmountInSC() {
        return bankChargeAmountInSC;
    }

    public void setBankChargeAmountInSC(Double bankChargeAmountInSC) {
        this.bankChargeAmountInSC = bankChargeAmountInSC;
    }

    public Double getUnderOverpaymentdifference() {
        return underOverpaymentdifference;
    }

    public void setUnderOverpaymentdifference(Double underOverpaymentdifference) {
        this.underOverpaymentdifference = underOverpaymentdifference;
    }

    public Double getUnderOverpaymentdiffSC() {
        return underOverpaymentdiffSC;
    }

    public void setUnderOverpaymentdiffSC(Double underOverpaymentdiffSC) {
        this.underOverpaymentdiffSC = underOverpaymentdiffSC;
    }

    public Double getWtBaseSum() {
        return wtBaseSum;
    }

    public void setWtBaseSum(Double wtBaseSum) {
        this.wtBaseSum = wtBaseSum;
    }

    public Double getWtBaseSumFC() {
        return wtBaseSumFC;
    }

    public void setWtBaseSumFC(Double wtBaseSumFC) {
        this.wtBaseSumFC = wtBaseSumFC;
    }

    public Double getWtBaseSumSC() {
        return wtBaseSumSC;
    }

    public void setWtBaseSumSC(Double wtBaseSumSC) {
        this.wtBaseSumSC = wtBaseSumSC;
    }

    public String getVatDate() {
        return vatDate;
    }

    public void setVatDate(String vatDate) {
        this.vatDate = vatDate;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Double getTransferRealAmount() {
        return transferRealAmount;
    }

    public void setTransferRealAmount(Double transferRealAmount) {
        this.transferRealAmount = transferRealAmount;
    }

    public String getDocObjectCode() {
        return docObjectCode;
    }

    public void setDocObjectCode(String docObjectCode) {
        this.docObjectCode = docObjectCode;
    }

    public String getDocTypte() {
        return docTypte;
    }

    public void setDocTypte(String docTypte) {
        this.docTypte = docTypte;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Long getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(Long locationCode) {
        this.locationCode = locationCode;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getControlAccount() {
        return controlAccount;
    }

    public void setControlAccount(String controlAccount) {
        this.controlAccount = controlAccount;
    }

    public Double getUnderOverpaymentdiffFC() {
        return underOverpaymentdiffFC;
    }

    public void setUnderOverpaymentdiffFC(Double underOverpaymentdiffFC) {
        this.underOverpaymentdiffFC = underOverpaymentdiffFC;
    }

    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }

    public Long getBplid() {
        return bplid;
    }

    public void setBplid(Long bplid) {
        this.bplid = bplid;
    }

    public String getBplName() {
        return bplName;
    }

    public void setBplName(String bplName) {
        this.bplName = bplName;
    }

    public String getVatRegNum() {
        return vatRegNum;
    }

    public void setVatRegNum(String vatRegNum) {
        this.vatRegNum = vatRegNum;
    }

    public String getuAsesor() {
        return uAsesor;
    }

    public void setuAsesor(String uAsesor) {
        this.uAsesor = uAsesor;
    }

    public String getuOK1IFRS() {
        return uOK1IFRS;
    }

    public void setuOK1IFRS(String uOK1IFRS) {
        this.uOK1IFRS = uOK1IFRS;
    }

    public List<PaymentChecks.PaymentCheck> getPaymentChecks() {
        return paymentChecks;
    }

    public void setPaymentChecks(List<PaymentChecks.PaymentCheck> paymentChecks) {
        this.paymentChecks = paymentChecks;
    }

    public List<PaymentInvoices.PaymentInvoice> getPaymentInvoices() {
        return paymentInvoices;
    }

    public void setPaymentInvoices(List<PaymentInvoices.PaymentInvoice> paymentInvoices) {
        this.paymentInvoices = paymentInvoices;
    }

    public List<PaymentCreditCards.PaymentCreditCard> getPaymentCreditCards() {
        return paymentCreditCards;
    }

    public void setPaymentCreditCards(List<PaymentCreditCards.PaymentCreditCard> paymentCreditCards) {
        this.paymentCreditCards = paymentCreditCards;
    }

    public List<PaymentAccounts.PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(List<PaymentAccounts.PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public BillOfExchange getBillOfExchange() {
        return billOfExchange;
    }

    public void setBillOfExchange(BillOfExchange billOfExchange) {
        this.billOfExchange = billOfExchange;
    }

    public CashFlowAssignments getCashFlowAssignments() {
        return cashFlowAssignments;
    }

    public void setCashFlowAssignments(CashFlowAssignments cashFlowAssignments) {
        this.cashFlowAssignments = cashFlowAssignments;
    }

    public PaymentsApprovalRequests getPaymentsApprovalRequests() {
        return paymentsApprovalRequests;
    }

    public void setPaymentsApprovalRequests(PaymentsApprovalRequests paymentsApprovalRequests) {
        this.paymentsApprovalRequests = paymentsApprovalRequests;
    }

    @Override
    public String toString() {
        return "PaymentRestDTO{" +
                "docNum=" + docNum +
                ", docType='" + docType + '\'' +
                ", handWritten='" + handWritten + '\'' +
                ", printed='" + printed + '\'' +
                ", docDate='" + docDate + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", address='" + address + '\'' +
                ", cashAccount='" + cashAccount + '\'' +
                ", docCurrency='" + docCurrency + '\'' +
                ", cashSum=" + cashSum +
                ", checkAccount='" + checkAccount + '\'' +
                ", transferAccount='" + transferAccount + '\'' +
                ", transferSum=" + transferSum +
                ", transferDate='" + transferDate + '\'' +
                ", transferReference='" + transferReference + '\'' +
                ", localCurrency='" + localCurrency + '\'' +
                ", docRate=" + docRate +
                ", reference1='" + reference1 + '\'' +
                ", reference2='" + reference2 + '\'' +
                ", counterReference='" + counterReference + '\'' +
                ", remarks='" + remarks + '\'' +
                ", journalRemarks='" + journalRemarks + '\'' +
                ", splitTransaction='" + splitTransaction + '\'' +
                ", contactPersonCode=" + contactPersonCode +
                ", applyVAT='" + applyVAT + '\'' +
                ", taxDate='" + taxDate + '\'' +
                ", series=" + series +
                ", bankCode='" + bankCode + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", discountPercent=" + discountPercent +
                ", projectCode='" + projectCode + '\'' +
                ", currencyIsLocal='" + currencyIsLocal + '\'' +
                ", deductionPercent=" + deductionPercent +
                ", deductionSum=" + deductionSum +
                ", cashSumFC=" + cashSumFC +
                ", cashSumSys=" + cashSumSys +
                ", boeAccount='" + boeAccount + '\'' +
                ", billOfExchangeAmount=" + billOfExchangeAmount +
                ", billofExchangeStatus='" + billofExchangeStatus + '\'' +
                ", billOfExchangeAmountFC=" + billOfExchangeAmountFC +
                ", billOfExchangeAmountSC=" + billOfExchangeAmountSC +
                ", billOfExchangeAgent='" + billOfExchangeAgent + '\'' +
                ", wtCode='" + wtCode + '\'' +
                ", wtAmount=" + wtAmount +
                ", wtAmountFC=" + wtAmountFC +
                ", wtAmountSC=" + wtAmountSC +
                ", wtAccount='" + wtAccount + '\'' +
                ", wtTaxableAmount=" + wtTaxableAmount +
                ", proforma='" + proforma + '\'' +
                ", payToBankCode='" + payToBankCode + '\'' +
                ", payToBankBranch='" + payToBankBranch + '\'' +
                ", payToBankAccountNo='" + payToBankAccountNo + '\'' +
                ", payToCode='" + payToCode + '\'' +
                ", payToBankCountry='" + payToBankCountry + '\'' +
                ", isPayToBank='" + isPayToBank + '\'' +
                ", docEntry=" + docEntry +
                ", paymentPriority='" + paymentPriority + '\'' +
                ", taxGroup='" + taxGroup + '\'' +
                ", bankChargeAmount=" + bankChargeAmount +
                ", bankChargeAmountInFC=" + bankChargeAmountInFC +
                ", bankChargeAmountInSC=" + bankChargeAmountInSC +
                ", underOverpaymentdifference=" + underOverpaymentdifference +
                ", underOverpaymentdiffSC=" + underOverpaymentdiffSC +
                ", wtBaseSum=" + wtBaseSum +
                ", wtBaseSumFC=" + wtBaseSumFC +
                ", wtBaseSumSC=" + wtBaseSumSC +
                ", vatDate='" + vatDate + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", transferRealAmount=" + transferRealAmount +
                ", docObjectCode='" + docObjectCode + '\'' +
                ", docTypte='" + docTypte + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", locationCode=" + locationCode +
                ", cancelled='" + cancelled + '\'' +
                ", controlAccount='" + controlAccount + '\'' +
                ", underOverpaymentdiffFC=" + underOverpaymentdiffFC +
                ", authorizationStatus='" + authorizationStatus + '\'' +
                ", bplid=" + bplid +
                ", bplName='" + bplName + '\'' +
                ", vatRegNum='" + vatRegNum + '\'' +
                ", uAsesor='" + uAsesor + '\'' +
                ", uOK1IFRS='" + uOK1IFRS + '\'' +
                ", paymentChecks=" + paymentChecks +
                ", paymentInvoices=" + paymentInvoices +
                ", paymentCreditCards=" + paymentCreditCards +
                ", paymentAccounts=" + paymentAccounts +
                ", billOfExchange=" + billOfExchange +
                ", cashFlowAssignments=" + cashFlowAssignments +
                ", paymentsApprovalRequests=" + paymentsApprovalRequests +
                '}';
    }

    public static class PaymentChecks {
        public static class PaymentCheck {
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("DueDate")
            protected String dueDate;
            @JsonProperty("CheckNumber")
            protected Long checkNumber;
            @JsonProperty("BankCode")
            protected String bankCode;
            @JsonProperty("Branch")
            protected String branch;
            @JsonProperty("AccounttNum")
            protected String accounttNum;
            @JsonProperty("Details")
            protected String details;
            @JsonProperty("Trnsfrable")
            protected String trnsfrable;
            @JsonProperty("CheckSum")
            protected Double checkSum;
            @JsonProperty("Currency")
            protected String currency;
            @JsonProperty("CountryCode")
            protected String countryCode;
            @JsonProperty("CheckAbsEntry")
            protected Long checkAbsEntry;
            @JsonProperty("CheckAccount")
            protected String checkAccount;
            @JsonProperty("ManualCheck")
            protected String manualCheck;

            public Long getLineNum() {
                return lineNum;
            }

            public void setLineNum(Long lineNum) {
                this.lineNum = lineNum;
            }

            public String getDueDate() {
                return dueDate;
            }

            public void setDueDate(String dueDate) {
                this.dueDate = dueDate;
            }

            public Long getCheckNumber() {
                return checkNumber;
            }

            public void setCheckNumber(Long checkNumber) {
                this.checkNumber = checkNumber;
            }

            public String getBankCode() {
                return bankCode;
            }

            public void setBankCode(String bankCode) {
                this.bankCode = bankCode;
            }

            public String getBranch() {
                return branch;
            }

            public void setBranch(String branch) {
                this.branch = branch;
            }

            public String getAccounttNum() {
                return accounttNum;
            }

            public void setAccounttNum(String accounttNum) {
                this.accounttNum = accounttNum;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public String getTrnsfrable() {
                return trnsfrable;
            }

            public void setTrnsfrable(String trnsfrable) {
                this.trnsfrable = trnsfrable;
            }

            public Double getCheckSum() {
                return checkSum;
            }

            public void setCheckSum(Double checkSum) {
                this.checkSum = checkSum;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public String getCountryCode() {
                return countryCode;
            }

            public void setCountryCode(String countryCode) {
                this.countryCode = countryCode;
            }

            public Long getCheckAbsEntry() {
                return checkAbsEntry;
            }

            public void setCheckAbsEntry(Long checkAbsEntry) {
                this.checkAbsEntry = checkAbsEntry;
            }

            public String getCheckAccount() {
                return checkAccount;
            }

            public void setCheckAccount(String checkAccount) {
                this.checkAccount = checkAccount;
            }

            public String getManualCheck() {
                return manualCheck;
            }

            public void setManualCheck(String manualCheck) {
                this.manualCheck = manualCheck;
            }
        }

    }

    public static class PaymentInvoices {
        public static class PaymentInvoice {
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("DocEntry")
            protected Long docEntry;
            @JsonProperty("SumApplied")
            protected BigDecimal sumApplied;
            @JsonProperty("AppliedFC")
            protected Double appliedFC;
            @JsonProperty("AppliedSys")
            protected Double appliedSys;
            @JsonProperty("DocRate")
            protected Double docRate;
            @JsonProperty("DocLine")
            protected Long docLine;
            @JsonProperty("InvoiceType")
            protected String invoiceType;
            @JsonProperty("DiscountPercent")
            protected Double discountPercent;
            @JsonProperty("PaidSum")
            protected Double paidSum;
            @JsonProperty("InstallmentId")
            protected Long installmentId;
            @JsonProperty("WitholdingTaxApplied")
            protected Double witholdingTaxApplied;
            @JsonProperty("WitholdingTaxAppliedFC")
            protected Double witholdingTaxAppliedFC;
            @JsonProperty("WitholdingTaxAppliedSC")
            protected Double witholdingTaxAppliedSC;
            @JsonProperty("LinkDate")
            protected String linkDate;
            @JsonProperty("DistributionRule")
            protected String distributionRule;
            @JsonProperty("DistributionRule2")
            protected String distributionRule2;
            @JsonProperty("DistributionRule3")
            protected String distributionRule3;
            @JsonProperty("DistributionRule4")
            protected String distributionRule4;
            @JsonProperty("DistributionRule5")
            protected String distributionRule5;
            @JsonProperty("TotalDiscount")
            protected Double totalDiscount;
            @JsonProperty("TotalDiscountFC")
            protected Double totalDiscountFC;
            @JsonProperty("TotalDiscountSC")
            protected Double totalDiscountSC;

            public Long getLineNum() {
                return lineNum;
            }

            public void setLineNum(Long lineNum) {
                this.lineNum = lineNum;
            }

            public Long getDocEntry() {
                return docEntry;
            }

            public void setDocEntry(Long docEntry) {
                this.docEntry = docEntry;
            }

            public BigDecimal getSumApplied() {
                return sumApplied;
            }

            public void setSumApplied(BigDecimal sumApplied) {
                this.sumApplied = sumApplied;
            }

            public Double getAppliedFC() {
                return appliedFC;
            }

            public void setAppliedFC(Double appliedFC) {
                this.appliedFC = appliedFC;
            }

            public Double getAppliedSys() {
                return appliedSys;
            }

            public void setAppliedSys(Double appliedSys) {
                this.appliedSys = appliedSys;
            }

            public Double getDocRate() {
                return docRate;
            }

            public void setDocRate(Double docRate) {
                this.docRate = docRate;
            }

            public Long getDocLine() {
                return docLine;
            }

            public void setDocLine(Long docLine) {
                this.docLine = docLine;
            }

            public String getInvoiceType() {
                return invoiceType;
            }

            public void setInvoiceType(String invoiceType) {
                this.invoiceType = invoiceType;
            }

            public Double getDiscountPercent() {
                return discountPercent;
            }

            public void setDiscountPercent(Double discountPercent) {
                this.discountPercent = discountPercent;
            }

            public Double getPaidSum() {
                return paidSum;
            }

            public void setPaidSum(Double paidSum) {
                this.paidSum = paidSum;
            }

            public Long getInstallmentId() {
                return installmentId;
            }

            public void setInstallmentId(Long installmentId) {
                this.installmentId = installmentId;
            }

            public Double getWitholdingTaxApplied() {
                return witholdingTaxApplied;
            }

            public void setWitholdingTaxApplied(Double witholdingTaxApplied) {
                this.witholdingTaxApplied = witholdingTaxApplied;
            }

            public Double getWitholdingTaxAppliedFC() {
                return witholdingTaxAppliedFC;
            }

            public void setWitholdingTaxAppliedFC(Double witholdingTaxAppliedFC) {
                this.witholdingTaxAppliedFC = witholdingTaxAppliedFC;
            }

            public Double getWitholdingTaxAppliedSC() {
                return witholdingTaxAppliedSC;
            }

            public void setWitholdingTaxAppliedSC(Double witholdingTaxAppliedSC) {
                this.witholdingTaxAppliedSC = witholdingTaxAppliedSC;
            }

            public String getLinkDate() {
                return linkDate;
            }

            public void setLinkDate(String linkDate) {
                this.linkDate = linkDate;
            }

            public String getDistributionRule() {
                return distributionRule;
            }

            public void setDistributionRule(String distributionRule) {
                this.distributionRule = distributionRule;
            }

            public String getDistributionRule2() {
                return distributionRule2;
            }

            public void setDistributionRule2(String distributionRule2) {
                this.distributionRule2 = distributionRule2;
            }

            public String getDistributionRule3() {
                return distributionRule3;
            }

            public void setDistributionRule3(String distributionRule3) {
                this.distributionRule3 = distributionRule3;
            }

            public String getDistributionRule4() {
                return distributionRule4;
            }

            public void setDistributionRule4(String distributionRule4) {
                this.distributionRule4 = distributionRule4;
            }

            public String getDistributionRule5() {
                return distributionRule5;
            }

            public void setDistributionRule5(String distributionRule5) {
                this.distributionRule5 = distributionRule5;
            }

            public Double getTotalDiscount() {
                return totalDiscount;
            }

            public void setTotalDiscount(Double totalDiscount) {
                this.totalDiscount = totalDiscount;
            }

            public Double getTotalDiscountFC() {
                return totalDiscountFC;
            }

            public void setTotalDiscountFC(Double totalDiscountFC) {
                this.totalDiscountFC = totalDiscountFC;
            }

            public Double getTotalDiscountSC() {
                return totalDiscountSC;
            }

            public void setTotalDiscountSC(Double totalDiscountSC) {
                this.totalDiscountSC = totalDiscountSC;
            }
        }
    }

    public static class PaymentCreditCards {
        public static class PaymentCreditCard {
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("CreditCard")
            protected Long creditCard;
            @JsonProperty("CreditAcct")
            protected String creditAcct;
            @JsonProperty("CreditCardNumber")
            protected String creditCardNumber;
            @JsonProperty("CardValidUntil")
            protected String cardValidUntil;
            @JsonProperty("VoucherNum")
            protected String voucherNum;
            @JsonProperty("OwnerIdNum")
            protected String ownerIdNum;
            @JsonProperty("OwnerPhone")
            protected String ownerPhone;
            @JsonProperty("PaymentMethodCode")
            protected Long paymentMethodCode;
            @JsonProperty("NumOfPayments")
            protected Long numOfPayments;
            @JsonProperty("FirstPaymentDue")
            protected String firstPaymentDue;
            @JsonProperty("FirstPaymentSum")
            protected Double firstPaymentSum;
            @JsonProperty("AdditionalPaymentSum")
            protected Double additionalPaymentSum;
            @JsonProperty("CreditSum")
            protected Double creditSum;
            @JsonProperty("CreditCur")
            protected String creditCur;
            @JsonProperty("CreditRate")
            protected Double creditRate;
            @JsonProperty("ConfirmationNum")
            protected String confirmationNum;
            @JsonProperty("NumOfCreditPayments")
            protected Long numOfCreditPayments;
            @JsonProperty("CreditType")
            protected String creditType;
            @JsonProperty("SplitPayments")
            protected String splitPayments;

            public Long getLineNum() {
                return lineNum;
            }

            public void setLineNum(Long lineNum) {
                this.lineNum = lineNum;
            }

            public Long getCreditCard() {
                return creditCard;
            }

            public void setCreditCard(Long creditCard) {
                this.creditCard = creditCard;
            }

            public String getCreditAcct() {
                return creditAcct;
            }

            public void setCreditAcct(String creditAcct) {
                this.creditAcct = creditAcct;
            }

            public String getCreditCardNumber() {
                return creditCardNumber;
            }

            public void setCreditCardNumber(String creditCardNumber) {
                this.creditCardNumber = creditCardNumber;
            }

            public String getCardValidUntil() {
                return cardValidUntil;
            }

            public void setCardValidUntil(String cardValidUntil) {
                this.cardValidUntil = cardValidUntil;
            }

            public String getVoucherNum() {
                return voucherNum;
            }

            public void setVoucherNum(String voucherNum) {
                this.voucherNum = voucherNum;
            }

            public String getOwnerIdNum() {
                return ownerIdNum;
            }

            public void setOwnerIdNum(String ownerIdNum) {
                this.ownerIdNum = ownerIdNum;
            }

            public String getOwnerPhone() {
                return ownerPhone;
            }

            public void setOwnerPhone(String ownerPhone) {
                this.ownerPhone = ownerPhone;
            }

            public Long getPaymentMethodCode() {
                return paymentMethodCode;
            }

            public void setPaymentMethodCode(Long paymentMethodCode) {
                this.paymentMethodCode = paymentMethodCode;
            }

            public Long getNumOfPayments() {
                return numOfPayments;
            }

            public void setNumOfPayments(Long numOfPayments) {
                this.numOfPayments = numOfPayments;
            }

            public String getFirstPaymentDue() {
                return firstPaymentDue;
            }

            public void setFirstPaymentDue(String firstPaymentDue) {
                this.firstPaymentDue = firstPaymentDue;
            }

            public Double getFirstPaymentSum() {
                return firstPaymentSum;
            }

            public void setFirstPaymentSum(Double firstPaymentSum) {
                this.firstPaymentSum = firstPaymentSum;
            }

            public Double getAdditionalPaymentSum() {
                return additionalPaymentSum;
            }

            public void setAdditionalPaymentSum(Double additionalPaymentSum) {
                this.additionalPaymentSum = additionalPaymentSum;
            }

            public Double getCreditSum() {
                return creditSum;
            }

            public void setCreditSum(Double creditSum) {
                this.creditSum = creditSum;
            }

            public String getCreditCur() {
                return creditCur;
            }

            public void setCreditCur(String creditCur) {
                this.creditCur = creditCur;
            }

            public Double getCreditRate() {
                return creditRate;
            }

            public void setCreditRate(Double creditRate) {
                this.creditRate = creditRate;
            }

            public String getConfirmationNum() {
                return confirmationNum;
            }

            public void setConfirmationNum(String confirmationNum) {
                this.confirmationNum = confirmationNum;
            }

            public Long getNumOfCreditPayments() {
                return numOfCreditPayments;
            }

            public void setNumOfCreditPayments(Long numOfCreditPayments) {
                this.numOfCreditPayments = numOfCreditPayments;
            }

            public String getCreditType() {
                return creditType;
            }

            public void setCreditType(String creditType) {
                this.creditType = creditType;
            }

            public String getSplitPayments() {
                return splitPayments;
            }

            public void setSplitPayments(String splitPayments) {
                this.splitPayments = splitPayments;
            }
        }
    }

    public static class PaymentAccounts {
        public static class PaymentAccount {
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("AccountCode")
            protected String accountCode;
            @JsonProperty("SumPaid")
            protected Double sumPaid;
            @JsonProperty("SumPaidFC")
            protected Double sumPaidFC;
            @JsonProperty("Decription")
            protected String decription;
            @JsonProperty("VatGroup")
            protected String vatGroup;
            @JsonProperty("AccountName")
            protected String accountName;
            @JsonProperty("GrossAmount")
            protected Double grossAmount;
            @JsonProperty("ProfitCenter")
            protected String profitCenter;
            @JsonProperty("ProjectCode")
            protected String projectCode;
            @JsonProperty("VatAmount")
            protected Double vatAmount;
            @JsonProperty("ProfitCenter2")
            protected String profitCenter2;
            @JsonProperty("ProfitCenter3")
            protected String profitCenter3;
            @JsonProperty("ProfitCenter4")
            protected String profitCenter4;
            @JsonProperty("ProfitCenter5")
            protected String profitCenter5;
            @JsonProperty("LocationCode")
            protected Long locationCode;
            @JsonProperty("EqualizationVatAmount")
            protected Double equalizationVatAmount;

            public Long getLineNum() {
                return lineNum;
            }

            public void setLineNum(Long lineNum) {
                this.lineNum = lineNum;
            }

            public String getAccountCode() {
                return accountCode;
            }

            public void setAccountCode(String accountCode) {
                this.accountCode = accountCode;
            }

            public Double getSumPaid() {
                return sumPaid;
            }

            public void setSumPaid(Double sumPaid) {
                this.sumPaid = sumPaid;
            }

            public Double getSumPaidFC() {
                return sumPaidFC;
            }

            public void setSumPaidFC(Double sumPaidFC) {
                this.sumPaidFC = sumPaidFC;
            }

            public String getDecription() {
                return decription;
            }

            public void setDecription(String decription) {
                this.decription = decription;
            }

            public String getVatGroup() {
                return vatGroup;
            }

            public void setVatGroup(String vatGroup) {
                this.vatGroup = vatGroup;
            }

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public Double getGrossAmount() {
                return grossAmount;
            }

            public void setGrossAmount(Double grossAmount) {
                this.grossAmount = grossAmount;
            }

            public String getProfitCenter() {
                return profitCenter;
            }

            public void setProfitCenter(String profitCenter) {
                this.profitCenter = profitCenter;
            }

            public String getProjectCode() {
                return projectCode;
            }

            public void setProjectCode(String projectCode) {
                this.projectCode = projectCode;
            }

            public Double getVatAmount() {
                return vatAmount;
            }

            public void setVatAmount(Double vatAmount) {
                this.vatAmount = vatAmount;
            }

            public String getProfitCenter2() {
                return profitCenter2;
            }

            public void setProfitCenter2(String profitCenter2) {
                this.profitCenter2 = profitCenter2;
            }

            public String getProfitCenter3() {
                return profitCenter3;
            }

            public void setProfitCenter3(String profitCenter3) {
                this.profitCenter3 = profitCenter3;
            }

            public String getProfitCenter4() {
                return profitCenter4;
            }

            public void setProfitCenter4(String profitCenter4) {
                this.profitCenter4 = profitCenter4;
            }

            public String getProfitCenter5() {
                return profitCenter5;
            }

            public void setProfitCenter5(String profitCenter5) {
                this.profitCenter5 = profitCenter5;
            }

            public Long getLocationCode() {
                return locationCode;
            }

            public void setLocationCode(Long locationCode) {
                this.locationCode = locationCode;
            }

            public Double getEqualizationVatAmount() {
                return equalizationVatAmount;
            }

            public void setEqualizationVatAmount(Double equalizationVatAmount) {
                this.equalizationVatAmount = equalizationVatAmount;
            }
        }
    }

    public static class BillOfExchange {
        @JsonProperty("BillOfExchangeNo")
        protected Long billOfExchangeNo;
        @JsonProperty("BillOfExchangeDueDate")
        protected String billOfExchangeDueDate;
        @JsonProperty("Details")
        protected String details;
        @JsonProperty("ReferenceNo")
        protected String referenceNo;
        @JsonProperty("Remarks")
        protected String remarks;
        @JsonProperty("PaymentMethodCode")
        protected String paymentMethodCode;
        @JsonProperty("BPBankCode")
        protected String bpBankCode;
        @JsonProperty("BPBankAct")
        protected String bpBankAct;
        @JsonProperty("BPBankCountry")
        protected String bpBankCountry;
        @JsonProperty("ControlKey")
        protected String controlKey;
        @JsonProperty("PaymentEngineStatus1")
        protected String paymentEngineStatus1;
        @JsonProperty("PaymentEngineStatus2")
        protected String paymentEngineStatus2;
        @JsonProperty("PaymentEngineStatus3")
        protected String paymentEngineStatus3;
        @JsonProperty("StampTaxCode")
        protected String stampTaxCode;
        @JsonProperty("StampTaxAmount")
        protected Double stampTaxAmount;
        @JsonProperty("FolioNumber")
        protected Long folioNumber;
        @JsonProperty("FolioPrefixString")
        protected String folioPrefixString;
        @JsonProperty("InterestAmount")
        protected Double interestAmount;
        @JsonProperty("DiscountAmount")
        protected Double discountAmount;
        @JsonProperty("FineAmount")
        protected Double fineAmount;
        @JsonProperty("InterestDate")
        protected String interestDate;
        @JsonProperty("DiscountDate")
        protected String discountDate;
        @JsonProperty("FineDate")
        protected String fineDate;
        @JsonProperty("IOFAmount")
        protected Double iofAmount;
        @JsonProperty("ServiceFeeAmount")
        protected Double serviceFeeAmount;
        @JsonProperty("OtherExpensesAmount")
        protected Double otherExpensesAmount;
        @JsonProperty("OtherIncomesAmount")
        protected Double otherIncomesAmount;

        public Long getBillOfExchangeNo() {
            return billOfExchangeNo;
        }

        public void setBillOfExchangeNo(Long billOfExchangeNo) {
            this.billOfExchangeNo = billOfExchangeNo;
        }

        public String getBillOfExchangeDueDate() {
            return billOfExchangeDueDate;
        }

        public void setBillOfExchangeDueDate(String billOfExchangeDueDate) {
            this.billOfExchangeDueDate = billOfExchangeDueDate;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getReferenceNo() {
            return referenceNo;
        }

        public void setReferenceNo(String referenceNo) {
            this.referenceNo = referenceNo;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getPaymentMethodCode() {
            return paymentMethodCode;
        }

        public void setPaymentMethodCode(String paymentMethodCode) {
            this.paymentMethodCode = paymentMethodCode;
        }

        public String getBpBankCode() {
            return bpBankCode;
        }

        public void setBpBankCode(String bpBankCode) {
            this.bpBankCode = bpBankCode;
        }

        public String getBpBankAct() {
            return bpBankAct;
        }

        public void setBpBankAct(String bpBankAct) {
            this.bpBankAct = bpBankAct;
        }

        public String getBpBankCountry() {
            return bpBankCountry;
        }

        public void setBpBankCountry(String bpBankCountry) {
            this.bpBankCountry = bpBankCountry;
        }

        public String getControlKey() {
            return controlKey;
        }

        public void setControlKey(String controlKey) {
            this.controlKey = controlKey;
        }

        public String getPaymentEngineStatus1() {
            return paymentEngineStatus1;
        }

        public void setPaymentEngineStatus1(String paymentEngineStatus1) {
            this.paymentEngineStatus1 = paymentEngineStatus1;
        }

        public String getPaymentEngineStatus2() {
            return paymentEngineStatus2;
        }

        public void setPaymentEngineStatus2(String paymentEngineStatus2) {
            this.paymentEngineStatus2 = paymentEngineStatus2;
        }

        public String getPaymentEngineStatus3() {
            return paymentEngineStatus3;
        }

        public void setPaymentEngineStatus3(String paymentEngineStatus3) {
            this.paymentEngineStatus3 = paymentEngineStatus3;
        }

        public String getStampTaxCode() {
            return stampTaxCode;
        }

        public void setStampTaxCode(String stampTaxCode) {
            this.stampTaxCode = stampTaxCode;
        }

        public Double getStampTaxAmount() {
            return stampTaxAmount;
        }

        public void setStampTaxAmount(Double stampTaxAmount) {
            this.stampTaxAmount = stampTaxAmount;
        }

        public Long getFolioNumber() {
            return folioNumber;
        }

        public void setFolioNumber(Long folioNumber) {
            this.folioNumber = folioNumber;
        }

        public String getFolioPrefixString() {
            return folioPrefixString;
        }

        public void setFolioPrefixString(String folioPrefixString) {
            this.folioPrefixString = folioPrefixString;
        }

        public Double getInterestAmount() {
            return interestAmount;
        }

        public void setInterestAmount(Double interestAmount) {
            this.interestAmount = interestAmount;
        }

        public Double getDiscountAmount() {
            return discountAmount;
        }

        public void setDiscountAmount(Double discountAmount) {
            this.discountAmount = discountAmount;
        }

        public Double getFineAmount() {
            return fineAmount;
        }

        public void setFineAmount(Double fineAmount) {
            this.fineAmount = fineAmount;
        }

        public String getInterestDate() {
            return interestDate;
        }

        public void setInterestDate(String interestDate) {
            this.interestDate = interestDate;
        }

        public String getDiscountDate() {
            return discountDate;
        }

        public void setDiscountDate(String discountDate) {
            this.discountDate = discountDate;
        }

        public String getFineDate() {
            return fineDate;
        }

        public void setFineDate(String fineDate) {
            this.fineDate = fineDate;
        }

        public Double getIofAmount() {
            return iofAmount;
        }

        public void setIofAmount(Double iofAmount) {
            this.iofAmount = iofAmount;
        }

        public Double getServiceFeeAmount() {
            return serviceFeeAmount;
        }

        public void setServiceFeeAmount(Double serviceFeeAmount) {
            this.serviceFeeAmount = serviceFeeAmount;
        }

        public Double getOtherExpensesAmount() {
            return otherExpensesAmount;
        }

        public void setOtherExpensesAmount(Double otherExpensesAmount) {
            this.otherExpensesAmount = otherExpensesAmount;
        }

        public Double getOtherIncomesAmount() {
            return otherIncomesAmount;
        }

        public void setOtherIncomesAmount(Double otherIncomesAmount) {
            this.otherIncomesAmount = otherIncomesAmount;
        }
    }

    public static class CashFlowAssignments {
        public static class CashFlowAssignment {
            @JsonProperty("CashFlowAssignmentsID")
            protected Long cashFlowAssignmentsID;
            @JsonProperty("CashFlowLineItemID")
            protected Long cashFlowLineItemID;
            @JsonProperty("Credit")
            protected Double credit;
            @JsonProperty("PaymentMeans")
            protected String paymentMeans;
            @JsonProperty("CheckNumber")
            protected String checkNumber;
            @JsonProperty("AmountLC")
            protected Double amountLC;
            @JsonProperty("AmountFC")
            protected Double amountFC;

            public Long getCashFlowAssignmentsID() {
                return cashFlowAssignmentsID;
            }

            public void setCashFlowAssignmentsID(Long cashFlowAssignmentsID) {
                this.cashFlowAssignmentsID = cashFlowAssignmentsID;
            }

            public Long getCashFlowLineItemID() {
                return cashFlowLineItemID;
            }

            public void setCashFlowLineItemID(Long cashFlowLineItemID) {
                this.cashFlowLineItemID = cashFlowLineItemID;
            }

            public Double getCredit() {
                return credit;
            }

            public void setCredit(Double credit) {
                this.credit = credit;
            }

            public String getPaymentMeans() {
                return paymentMeans;
            }

            public void setPaymentMeans(String paymentMeans) {
                this.paymentMeans = paymentMeans;
            }

            public String getCheckNumber() {
                return checkNumber;
            }

            public void setCheckNumber(String checkNumber) {
                this.checkNumber = checkNumber;
            }

            public Double getAmountLC() {
                return amountLC;
            }

            public void setAmountLC(Double amountLC) {
                this.amountLC = amountLC;
            }

            public Double getAmountFC() {
                return amountFC;
            }

            public void setAmountFC(Double amountFC) {
                this.amountFC = amountFC;
            }
        }
    }

    public static class PaymentsApprovalRequests {
        public static class PaymentsApprovalRequest {
            @JsonProperty("ApprovalTemplatesID")
            protected Long approvalTemplatesID;
            @JsonProperty("Remarks")
            protected String remarks;

            public Long getApprovalTemplatesID() {
                return approvalTemplatesID;
            }

            public void setApprovalTemplatesID(Long approvalTemplatesID) {
                this.approvalTemplatesID = approvalTemplatesID;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }
        }
    }
}
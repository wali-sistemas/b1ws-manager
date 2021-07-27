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
public class PaymentDTO implements Serializable {
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocType")
    protected String docType;
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("DocCurrency")
    protected String docCurrency;
    @JsonProperty("TransferAccount")
    protected String transferAccount;
    @JsonProperty("TransferReference")
    protected String transferReference;
    @JsonProperty("JournalRemarks")
    protected String journalRemarks;
    @JsonProperty("TransferSum")
    protected BigDecimal transferSum;
    @JsonProperty("TransferDate")
    protected String transferDate;
    @JsonProperty("TaxDate")
    protected String taxDate;
    @JsonProperty("PaymentInvoices")
    protected List<PaymentDTO.PaymentInvoices.PaymentInvoice> paymentInvoices;
    @JsonProperty("PaymentAccounts")
    protected List<PaymentDTO.PaymentAccounts.PaymentAccount> paymentAccounts;
    @JsonProperty("CashFlowAssignments")
    protected PaymentDTO.CashFlowAssignments cashFlowAssignments;

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getDocCurrency() {
        return docCurrency;
    }

    public void setDocCurrency(String docCurrency) {
        this.docCurrency = docCurrency;
    }

    public String getTransferAccount() {
        return transferAccount;
    }

    public void setTransferAccount(String transferAccount) {
        this.transferAccount = transferAccount;
    }

    public String getTransferReference() {
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public String getJournalRemarks() {
        return journalRemarks;
    }

    public void setJournalRemarks(String journalRemarks) {
        this.journalRemarks = journalRemarks;
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

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public List<PaymentInvoices.PaymentInvoice> getPaymentInvoices() {
        return paymentInvoices;
    }

    public void setPaymentInvoices(List<PaymentInvoices.PaymentInvoice> paymentInvoices) {
        this.paymentInvoices = paymentInvoices;
    }

    public List<PaymentAccounts.PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(List<PaymentAccounts.PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }

    public CashFlowAssignments getCashFlowAssignments() {
        return cashFlowAssignments;
    }

    public void setCashFlowAssignments(CashFlowAssignments cashFlowAssignments) {
        this.cashFlowAssignments = cashFlowAssignments;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "series=" + series +
                ", docDate='" + docDate + '\'' +
                ", docType='" + docType + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", docCurrency='" + docCurrency + '\'' +
                ", transferAccount='" + transferAccount + '\'' +
                ", transferReference='" + transferReference + '\'' +
                ", journalRemarks='" + journalRemarks + '\'' +
                ", transferSum=" + transferSum +
                ", transferDate='" + transferDate + '\'' +
                ", taxDate='" + taxDate + '\'' +
                ", paymentInvoices=" + paymentInvoices +
                ", cashFlowAssignments=" + cashFlowAssignments +
                '}';
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

    public static class PaymentAccounts {
        public static class PaymentAccount {
            @JsonProperty("LineNum")
            protected Long lineNum;
            @JsonProperty("AccountCode")
            protected String accountCode;
            @JsonProperty("SumPaid")
            protected BigDecimal sumPaid;
            @JsonProperty("SumPaidFC")
            protected BigDecimal sumPaidFC;
            @JsonProperty("Decription")
            protected String decription;
            @JsonProperty("VatGroup")
            protected String vatGroup;
            @JsonProperty("AccountName")
            protected String accountName;
            @JsonProperty("GrossAmount")
            protected BigDecimal grossAmount;
            @JsonProperty("ProfitCenter")
            protected String profitCenter;
            @JsonProperty("ProjectCode")
            protected String projectCode;
            @JsonProperty("VatAmount")
            protected BigDecimal vatAmount;
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
            protected BigDecimal equalizationVatAmount;

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

            public BigDecimal getSumPaid() {
                return sumPaid;
            }

            public void setSumPaid(BigDecimal sumPaid) {
                this.sumPaid = sumPaid;
            }

            public BigDecimal getSumPaidFC() {
                return sumPaidFC;
            }

            public void setSumPaidFC(BigDecimal sumPaidFC) {
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

            public BigDecimal getGrossAmount() {
                return grossAmount;
            }

            public void setGrossAmount(BigDecimal grossAmount) {
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

            public BigDecimal getVatAmount() {
                return vatAmount;
            }

            public void setVatAmount(BigDecimal vatAmount) {
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

            public BigDecimal getEqualizationVatAmount() {
                return equalizationVatAmount;
            }

            public void setEqualizationVatAmount(BigDecimal equalizationVatAmount) {
                this.equalizationVatAmount = equalizationVatAmount;
            }
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
}
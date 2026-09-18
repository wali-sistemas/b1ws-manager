package co.manager.hanaws.dto.InventoryGenExits;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryGenExitsRestDTO implements Serializable {
    @JsonProperty("DocEntry")
    protected Integer docEntry;
    @JsonProperty("DocNum")
    protected Integer docNum;
    @JsonProperty("DocType")
    protected String docType;
    @JsonProperty("HandWritten")
    protected String handWritten;
    @JsonProperty("Printed")
    protected String printed;
    @JsonProperty("DocDate")
    protected String docDate;
    @JsonProperty("DocDueDate")
    protected String docDueDate;
    @JsonProperty("CardCode")
    protected String cardCode;
    @JsonProperty("CardName")
    protected String cardName;
    @JsonProperty("Address")
    protected String address;
    @JsonProperty("NumAtCard")
    protected String numAtCard;
    @JsonProperty("DocTotal")
    protected Double docTotal;
    @JsonProperty("AttachmentEntry")
    protected String attachmentEntry;
    @JsonProperty("DocCurrency")
    protected String docCurrency;
    @JsonProperty("DocRate")
    protected Double docRate;
    @JsonProperty("Reference1")
    protected String reference1;
    @JsonProperty("Reference2")
    protected String reference2;
    @JsonProperty("Comments")
    protected String comments;
    @JsonProperty("JournalMemo")
    protected String journalMemo;
    @JsonProperty("PaymentGroupCode")
    protected Integer paymentGroupCode;
    @JsonProperty("DocTime")
    protected String docTime;
    @JsonProperty("SalesPersonCode")
    protected Integer salesPersonCode;
    @JsonProperty("TransportationCode")
    protected Integer transportationCode;
    @JsonProperty("Confirmed")
    protected String confirmed;
    @JsonProperty("ImportFileNum")
    protected String importFileNum;
    @JsonProperty("SummeryType")
    protected String summeryType;
    @JsonProperty("ContactPersonCode")
    protected Integer contactPersonCode;
    @JsonProperty("ShowSCN")
    protected String showSCN;
    @JsonProperty("Series")
    protected Integer series;
    @JsonProperty("TaxDate")
    protected String taxDate;
    @JsonProperty("PartialSupply")
    protected String partialSupply;
    @JsonProperty("DocObjectCode")
    protected String docObjectCode;
    @JsonProperty("ShipToCode")
    protected String shipToCode;
    @JsonProperty("Indicator")
    protected String indicator;
    @JsonProperty("FederalTaxID")
    protected String federalTaxID;
    @JsonProperty("DiscountPercent")
    protected Double discountPercent;
    @JsonProperty("PaymentReference")
    protected String paymentReference;
    @JsonProperty("CreationDate")
    protected String creationDate;
    @JsonProperty("UpdateDate")
    protected String updateDate;
    @JsonProperty("FinancialPeriod")
    protected Integer financialPeriod;
    @JsonProperty("UserSign")
    protected Integer userSign;
    @JsonProperty("TransNum")
    protected Integer transNum;
    @JsonProperty("VatSum")
    protected Double vatSum;
    @JsonProperty("VatSumSys")
    protected Double vatSumSys;
    @JsonProperty("VatSumFc")
    protected Double vatSumFc;
    @JsonProperty("NetProcedure")
    protected String netProcedure;
    @JsonProperty("DocTotalFc")
    protected Double docTotalFc;
    @JsonProperty("DocTotalSys")
    protected Double docTotalSys;
    @JsonProperty("Form1099")
    protected String form1099;
    @JsonProperty("Box1099")
    protected String box1099;
    @JsonProperty("RevisionPo")
    protected String revisionPo;
    @JsonProperty("RequriedDate")
    protected String requriedDate;
    @JsonProperty("CancelDate")
    protected String cancelDate;
    @JsonProperty("BlockDunning")
    protected String blockDunning;
    @JsonProperty("Submitted")
    protected String submitted;
    @JsonProperty("Segment")
    protected Integer segment;
    @JsonProperty("PickStatus")
    protected String pickStatus;
    @JsonProperty("Pick")
    protected String pick;
    @JsonProperty("PaymentMethod")
    protected String paymentMethod;
    @JsonProperty("PaymentBlock")
    protected String paymentBlock;
    @JsonProperty("PaymentBlockEntry")
    protected String paymentBlockEntry;
    @JsonProperty("CentralBankIndicator")
    protected String centralBankIndicator;
    @JsonProperty("MaximumCashDiscount")
    protected String maximumCashDiscount;
    @JsonProperty("Reserve")
    protected String reserve;
    @JsonProperty("Project")
    protected String project;
    @JsonProperty("ExemptionValidityDateFrom")
    protected String exemptionValidityDateFrom;
    @JsonProperty("ExemptionValidityDateTo")
    protected String exemptionValidityDateTo;
    @JsonProperty("WareHouseUpdateType")
    protected String wareHouseUpdateType;
    @JsonProperty("Rounding")
    protected String rounding;
    @JsonProperty("ExternalCorrectedDocNum")
    protected String externalCorrectedDocNum;
    @JsonProperty("InternalCorrectedDocNum")
    protected String internalCorrectedDocNum;
    @JsonProperty("NextCorrectingDocument")
    protected String nextCorrectingDocument;
    @JsonProperty("DeferredTax")
    protected String deferredTax;
    @JsonProperty("TaxExemptionLetterNum")
    protected String taxExemptionLetterNum;
    @JsonProperty("WTApplied")
    protected Double wTApplied;
    @JsonProperty("WTAppliedFC")
    protected Double wTAppliedFC;
    @JsonProperty("BillOfExchangeReserved")
    protected String billOfExchangeReserved;
    @JsonProperty("AgentCode")
    protected String agentCode;
    @JsonProperty("WTAppliedSC")
    protected Double wTAppliedSC;
    @JsonProperty("TotalEqualizationTax")
    protected Double totalEqualizationTax;
    @JsonProperty("TotalEqualizationTaxFC")
    protected Double totalEqualizationTaxFC;
    @JsonProperty("TotalEqualizationTaxSC")
    protected Double totalEqualizationTaxSC;
    @JsonProperty("NumberOfInstallments")
    protected Integer numberOfInstallments;
    @JsonProperty("ApplyTaxOnFirstInstallment")
    protected String applyTaxOnFirstInstallment;
    @JsonProperty("TaxOnInstallments")
    protected String taxOnInstallments;
    @JsonProperty("WTNonSubjectAmount")
    protected Double wTNonSubjectAmount;
    @JsonProperty("WTNonSubjectAmountSC")
    protected Double wTNonSubjectAmountSC;
    @JsonProperty("WTNonSubjectAmountFC")
    protected Double wTNonSubjectAmountFC;
    @JsonProperty("WTExemptedAmount")
    protected Double wTExemptedAmount;
    @JsonProperty("WTExemptedAmountSC")
    protected Double wTExemptedAmountSC;
    @JsonProperty("WTExemptedAmountFC")
    protected Double wTExemptedAmountFC;
    @JsonProperty("BaseAmount")
    protected Double baseAmount;
    @JsonProperty("BaseAmountSC")
    protected Double baseAmountSC;
    @JsonProperty("BaseAmountFC")
    protected Double baseAmountFC;
    @JsonProperty("WTAmount")
    protected Double wTAmount;
    @JsonProperty("WTAmountSC")
    protected Double wTAmountSC;
    @JsonProperty("WTAmountFC")
    protected Double wTAmountFC;
    @JsonProperty("VatDate")
    protected String vatDate;
    @JsonProperty("DocumentsOwner")
    protected String documentsOwner;
    @JsonProperty("FolioPrefixString")
    protected String folioPrefixString;
    @JsonProperty("FolioNumber")
    protected String folioNumber;
    @JsonProperty("DocumentSubType")
    protected String documentSubType;
    @JsonProperty("BPChannelCode")
    protected String bPChannelCode;
    @JsonProperty("BPChannelContact")
    protected String bPChannelContact;
    @JsonProperty("Address2")
    protected String address2;
    @JsonProperty("DocumentStatus")
    protected String documentStatus;
    @JsonProperty("PeriodIndicator")
    protected String periodIndicator;
    @JsonProperty("PayToCode")
    protected String payToCode;
    @JsonProperty("ManualNumber")
    protected String manualNumber;
    @JsonProperty("UseShpdGoodsAct")
    protected String useShpdGoodsAct;
    @JsonProperty("IsPayToBank")
    protected String isPayToBank;
    @JsonProperty("PayToBankCountry")
    protected String payToBankCountry;
    @JsonProperty("PayToBankCode")
    protected String payToBankCode;
    @JsonProperty("PayToBankAccountNo")
    protected String payToBankAccountNo;
    @JsonProperty("PayToBankBranch")
    protected String payToBankBranch;
    @JsonProperty("BPL_IDAssignedToInvoice")
    protected String bplIdassignedtoinvoice;
    @JsonProperty("DownPayment")
    protected Double downPayment;
    @JsonProperty("ReserveInvoice")
    protected String reserveInvoice;
    @JsonProperty("LanguageCode")
    protected String languageCode;
    @JsonProperty("TrackingNumber")
    protected String trackingNumber;
    @JsonProperty("PickRemark")
    protected String pickRemark;
    @JsonProperty("ClosingDate")
    protected String closingDate;
    @JsonProperty("SequenceCode")
    protected String sequenceCode;
    @JsonProperty("SequenceSerial")
    protected String sequenceSerial;
    @JsonProperty("SeriesString")
    protected String seriesString;
    @JsonProperty("SubSeriesString")
    protected String subSeriesString;
    @JsonProperty("SequenceModel")
    protected String sequenceModel;
    @JsonProperty("UseCorrectionVATGroup")
    protected String useCorrectionVATGroup;
    @JsonProperty("TotalDiscount")
    protected Double totalDiscount;
    @JsonProperty("DownPaymentAmount")
    protected Double downPaymentAmount;
    @JsonProperty("DownPaymentPercentage")
    protected Double downPaymentPercentage;
    @JsonProperty("DownPaymentType")
    protected String downPaymentType;
    @JsonProperty("DownPaymentAmountSC")
    protected Double downPaymentAmountSC;
    @JsonProperty("DownPaymentAmountFC")
    protected Double downPaymentAmountFC;
    @JsonProperty("VatPercent")
    protected Double vatPercent;
    @JsonProperty("ServiceGrossProfitPercent")
    protected Double serviceGrossProfitPercent;
    @JsonProperty("OpeningRemarks")
    protected String openingRemarks;
    @JsonProperty("ClosingRemarks")
    protected String closingRemarks;
    @JsonProperty("RoundingDiffAmount")
    protected Double roundingDiffAmount;
    @JsonProperty("RoundingDiffAmountFC")
    protected Double roundingDiffAmountFC;
    @JsonProperty("RoundingDiffAmountSC")
    protected Double roundingDiffAmountSC;
    @JsonProperty("Cancelled")
    protected String cancelled;
    @JsonProperty("SignatureInputMessage")
    protected String signatureInputMessage;
    @JsonProperty("SignatureDigest")
    protected String signatureDigest;
    @JsonProperty("CertificationNumber")
    protected String certificationNumber;
    @JsonProperty("PrivateKeyVersion")
    protected String privateKeyVersion;
    @JsonProperty("ControlAccount")
    protected String controlAccount;
    @JsonProperty("InsuranceOperation347")
    protected String insuranceOperation347;
    @JsonProperty("ArchiveNonremovableSalesQuotation")
    protected String archiveNonremovableSalesQuotation;
    @JsonProperty("GTSChecker")
    protected String gTSChecker;
    @JsonProperty("GTSPayee")
    protected String gTSPayee;
    @JsonProperty("ExtraMonth")
    protected String extraMonth;
    @JsonProperty("ExtraDays")
    protected String extraDays;
    @JsonProperty("CashDiscountDateOffset")
    protected Integer cashDiscountDateOffset;
    @JsonProperty("StartFrom")
    protected String startFrom;
    @JsonProperty("NTSApproved")
    protected String nTSApproved;
    @JsonProperty("ETaxWebSite")
    protected String eTaxWebSite;
    @JsonProperty("ETaxNumber")
    protected String eTaxNumber;
    @JsonProperty("NTSApprovedNumber")
    protected String nTSApprovedNumber;
    @JsonProperty("EDocGenerationType")
    protected String eDocGenerationType;
    @JsonProperty("EDocSeries")
    protected String eDocSeries;
    @JsonProperty("EDocNum")
    protected String eDocNum;
    @JsonProperty("EDocExportFormat")
    protected String eDocExportFormat;
    @JsonProperty("EDocStatus")
    protected String eDocStatus;
    @JsonProperty("EDocErrorCode")
    protected String eDocErrorCode;
    @JsonProperty("EDocErrorMessage")
    protected String eDocErrorMessage;
    @JsonProperty("DownPaymentStatus")
    protected String downPaymentStatus;
    @JsonProperty("GroupSeries")
    protected String groupSeries;
    @JsonProperty("GroupNumber")
    protected String groupNumber;
    @JsonProperty("GroupHandWritten")
    protected String groupHandWritten;
    @JsonProperty("ReopenOriginalDocument")
    protected String reopenOriginalDocument;
    @JsonProperty("ReopenManuallyClosedOrCanceledDocument")
    protected String reopenManuallyClosedOrCanceledDocument;
    @JsonProperty("CreateOnlineQuotation")
    protected String createOnlineQuotation;
    @JsonProperty("POSEquipmentNumber")
    protected String pOSEquipmentNumber;
    @JsonProperty("POSManufacturerSerialNumber")
    protected String pOSManufacturerSerialNumber;
    @JsonProperty("POSCashierNumber")
    protected String pOSCashierNumber;
    @JsonProperty("ApplyCurrentVATRatesForDownPaymentsToDraw")
    protected String applyCurrentVATRatesForDownPaymentsToDraw;
    @JsonProperty("ClosingOption")
    protected String closingOption;
    @JsonProperty("SpecifiedClosingDate")
    protected String specifiedClosingDate;
    @JsonProperty("OpenForLandedCosts")
    protected String openForLandedCosts;
    @JsonProperty("AuthorizationStatus")
    protected String authorizationStatus;
    @JsonProperty("TotalDiscountFC")
    protected Double totalDiscountFC;
    @JsonProperty("TotalDiscountSC")
    protected Double totalDiscountSC;
    @JsonProperty("RelevantToGTS")
    protected String relevantToGTS;
    @JsonProperty("BPLName")
    protected String bPLName;
    @JsonProperty("VATRegNum")
    protected String vATRegNum;
    @JsonProperty("AnnualInvoiceDeclarationReference")
    protected String annualInvoiceDeclarationReference;
    @JsonProperty("Supplier")
    protected String supplier;
    @JsonProperty("Releaser")
    protected String releaser;
    @JsonProperty("Receiver")
    protected String receiver;
    @JsonProperty("BlanketAgreementNumber")
    protected String blanketAgreementNumber;
    @JsonProperty("IsAlteration")
    protected String isAlteration;
    @JsonProperty("CancelStatus")
    protected String cancelStatus;
    @JsonProperty("AssetValueDate")
    protected String assetValueDate;
    @JsonProperty("DocumentDelivery")
    protected String documentDelivery;
    @JsonProperty("AuthorizationCode")
    protected String authorizationCode;
    @JsonProperty("StartDeliveryDate")
    protected String startDeliveryDate;
    @JsonProperty("StartDeliveryTime")
    protected String startDeliveryTime;
    @JsonProperty("EndDeliveryDate")
    protected String endDeliveryDate;
    @JsonProperty("EndDeliveryTime")
    protected String endDeliveryTime;
    @JsonProperty("VehiclePlate")
    protected String vehiclePlate;
    @JsonProperty("ATDocumentType")
    protected String aTDocumentType;
    @JsonProperty("ElecCommStatus")
    protected String elecCommStatus;
    @JsonProperty("ElecCommMessage")
    protected String elecCommMessage;
    @JsonProperty("ReuseDocumentNum")
    protected String reuseDocumentNum;
    @JsonProperty("ReuseNotaFiscalNum")
    protected String reuseNotaFiscalNum;
    @JsonProperty("PrintSEPADirect")
    protected String printSEPADirect;
    @JsonProperty("FiscalDocNum")
    protected String fiscalDocNum;
    @JsonProperty("POSDailySummaryNo")
    protected String pOSDailySummaryNo;
    @JsonProperty("POSReceiptNo")
    protected String pOSReceiptNo;
    @JsonProperty("PointOfIssueCode")
    protected String pointOfIssueCode;
    @JsonProperty("Letter")
    protected String letter;
    @JsonProperty("FolioNumberFrom")
    protected String folioNumberFrom;
    @JsonProperty("FolioNumberTo")
    protected String folioNumberTo;
    @JsonProperty("InterimType")
    protected String interimType;
    @JsonProperty("RelatedType")
    protected Integer relatedType;
    @JsonProperty("RelatedEntry")
    protected String relatedEntry;
    @JsonProperty("SAPPassport")
    protected String sAPPassport;
    @JsonProperty("DocumentTaxID")
    protected String documentTaxID;
    @JsonProperty("DateOfReportingControlStatementVAT")
    protected String dateOfReportingControlStatementVAT;
    @JsonProperty("ReportingSectionControlStatementVAT")
    protected String reportingSectionControlStatementVAT;
    @JsonProperty("ExcludeFromTaxReportControlStatementVAT")
    protected String excludeFromTaxReportControlStatementVAT;
    @JsonProperty("POS_CashRegister")
    protected String posCashregister;
    @JsonProperty("UpdateTime")
    protected String updateTime;
    @JsonProperty("CreateQRCodeFrom")
    protected String createQRCodeFrom;
    @JsonProperty("ShipFrom")
    protected String shipFrom;
    @JsonProperty("CommissionTrade")
    protected String commissionTrade;
    @JsonProperty("CommissionTradeReturn")
    protected String commissionTradeReturn;
    @JsonProperty("UseBillToAddrToDetermineTax")
    protected String useBillToAddrToDetermineTax;
    @JsonProperty("Cig")
    protected String cig;
    @JsonProperty("Cup")
    protected String cup;
    @JsonProperty("FatherCard")
    protected String fatherCard;
    @JsonProperty("FatherType")
    protected String fatherType;
    @JsonProperty("ShipState")
    protected String shipState;
    @JsonProperty("ShipPlace")
    protected String shipPlace;
    @JsonProperty("CustOffice")
    protected String custOffice;
    @JsonProperty("FCI")
    protected String fCI;
    @JsonProperty("AddLegIn")
    protected String addLegIn;
    @JsonProperty("LegTextF")
    protected String legTextF;
    @JsonProperty("DANFELgTxt")
    protected String dANFELgTxt;
    @JsonProperty("DataVersion")
    protected Integer dataVersion;
    @JsonProperty("LastPageFolioNumber")
    protected Integer lastPageFolioNumber;
    @JsonProperty("InventoryStatus")
    protected String inventoryStatus;
    @JsonProperty("PlasticPackagingTaxRelevant")
    protected String plasticPackagingTaxRelevant;
    @JsonProperty("NotRelevantForMonthlyInvoice")
    protected String notRelevantForMonthlyInvoice;
    @JsonProperty("U_BPCOST")
    protected String uBpcost;
    @JsonProperty("U_WUID")
    protected String uWuid;
    @JsonProperty("U_F_TOMA_PED")
    protected String uFTomaPed;
    @JsonProperty("U_CAMPANA")
    protected String uCampana;
    @JsonProperty("U_TRANSP")
    protected String uTransp;
    @JsonProperty("U_SEPARADOR")
    protected String uSeparador;
    @JsonProperty("U_DESP")
    protected String uDesp;
    @JsonProperty("U_UBIC1")
    protected String uUbic1;
    @JsonProperty("U_CONC_NC")
    protected String uConcNc;
    @JsonProperty("U_CONC_ND")
    protected String uConcNd;
    @JsonProperty("U_CONC_INV")
    protected String uConcInv;
    @JsonProperty("U_F_EMBARQUE")
    protected String uFEmbarque;
    @JsonProperty("U_TERM_NEG")
    protected String uTermNeg;
    @JsonProperty("U_MOD_TRANSP")
    protected String uModTransp;
    @JsonProperty("U_PUERTO_DES")
    protected String uPuertoDes;
    @JsonProperty("U_MOD_IMP")
    protected String uModImp;
    @JsonProperty("U_ESTADO_OC")
    protected String uEstadoOc;
    @JsonProperty("U_F_PROFORMA")
    protected String uFProforma;
    @JsonProperty("U_EMBARCADO")
    protected String uEmbarcado;
    @JsonProperty("U_DOC_TRANSP")
    protected String uDocTransp;
    @JsonProperty("U_F_DOC_TRANSP")
    protected String uFDocTransp;
    @JsonProperty("U_F_ARRIB_PUERTO")
    protected String uFArribPuerto;
    @JsonProperty("U_F_ARRIB_ALMA")
    protected String uFArribAlma;
    @JsonProperty("U_REQ_ANT")
    protected String uReqAnt;
    @JsonProperty("U_ANT_REALIZ")
    protected String uAntRealiz;
    @JsonProperty("U_TOT_CAJ")
    protected Double uTotCaj;
    @JsonProperty("U_TOT_BUL")
    protected Double uTotBul;
    @JsonProperty("U_TOT_LIOS")
    protected Double uTotLios;
    @JsonProperty("U_VLR_FLE")
    protected Double uVlrFle;
    @JsonProperty("U_VLR_SEG")
    protected Double uVlrSeg;
    @JsonProperty("U_TOT_FLE")
    protected Double uTotFle;
    @JsonProperty("U_HORA_INI")
    protected String uHoraIni;
    @JsonProperty("U_HORA_FIN")
    protected String uHoraFin;
    @JsonProperty("U_PESO_BRUTO")
    protected Double uPesoBruto;
    @JsonProperty("U_AUT_PRECIO")
    protected String uAutPrecio;
    @JsonProperty("U_TipoNota")
    protected String uTiponota;
    @JsonProperty("U_NUNFAC")
    protected String uNunfac;
    @JsonProperty("U_FECHA_ENTREGA_PRO")
    protected String uFechaEntregaPro;
    @JsonProperty("U_NUM_FAC_IMP")
    protected String uNumFacImp;
    @JsonProperty("U_TRANSP_IMP")
    protected String uTranspImp;
    @JsonProperty("U_TIEMPO_ESTIMADO")
    protected Double uTiempoEstimado;
    @JsonProperty("U_FEC_INI")
    protected String uFecIni;
    @JsonProperty("U_FEC_FIN")
    protected String uFecFin;
    @JsonProperty("U_IVCDone")
    protected String uIvcdone;
    @JsonProperty("U_Vendedor_2")
    protected String uVendedor2;
    @JsonProperty("U_DifCode")
    protected String uDifcode;
    @JsonProperty("U_OK1_IVAPA")
    protected String uOk1Ivapa;
    @JsonProperty("U_MOT_DEVOL")
    protected String uMotDevol;
    @JsonProperty("U_FECHA_PAGO")
    protected String uFechaPago;
    @JsonProperty("U_ANT_CANCELADO")
    protected String uAntCancelado;
    @JsonProperty("U_IMP_CANCELADO")
    protected String uImpCancelado;
    @JsonProperty("U_TIPO_EMPAQUE")
    protected String uTipoEmpaque;
    @JsonProperty("U_VR_ANTICIPO")
    protected Double uVrAnticipo;
    @JsonProperty("U_VR_TOTAL")
    protected Double uVrTotal;
    @JsonProperty("U_VR_IMPUESTO")
    protected Double uVrImpuesto;
    @JsonProperty("U_OBSERVACION")
    protected String uObservacion;
    @JsonProperty("U_VR_DECLARADO")
    protected Double uVrDeclarado;
    @JsonProperty("U_PUERTO_EMB")
    protected String uPuertoEmb;
    @JsonProperty("U_NAVIERA")
    protected String uNaviera;
    @JsonProperty("U_TRANSP_TERR")
    protected String uTranspTerr;
    @JsonProperty("U_AGENTE_ADU")
    protected String uAgenteAdu;
    @JsonProperty("U_ALMAC_DES")
    protected String uAlmacDes;
    @JsonProperty("U_GUID")
    protected String uGuid;
    @JsonProperty("U_BPV_NCON2")
    protected String uBpvNcon2;
    @JsonProperty("U_BPV_SERI")
    protected String uBpvSeri;
    @JsonProperty("U_BPV_TRAN")
    protected String uBpvTran;
    @JsonProperty("U_BPV_FAFE")
    protected String uBpvFafe;
    @JsonProperty("U_BPV_COMP")
    protected String uBpvComp;
    @JsonProperty("U_BPV_TDOC")
    protected String uBpvTdoc;
    @JsonProperty("U_BPV_NIMP")
    protected String uBpvNimp;
    @JsonProperty("U_BPV_NumExp")
    protected String uBpvNumexp;
    @JsonProperty("U_BPV_NCON")
    protected String uBpvNcon;
    @JsonProperty("U_MOTIVO")
    protected String uMotivo;
    @JsonProperty("U_ESTADO_PED")
    protected String uEstadoPed;
    @JsonProperty("U_Autorret")
    protected String uAutorret;
    @JsonProperty("U_Retefue")
    protected String uRetefue;
    @JsonProperty("U_ReteIca")
    protected String uReteica;
    @JsonProperty("U_NWR_PicS")
    protected String uNwrPics;
    @JsonProperty("U_NWR_BRet")
    protected String uNwrBret;
    @JsonProperty("U_nwr_PAut")
    protected Integer uNwrPaut;
    @JsonProperty("U_nwr_Note")
    protected String uNwrNote;
    @JsonProperty("U_nwr_Tag")
    protected String uNwrTag;
    @JsonProperty("U_nwr_Frgt")
    protected Double uNwrFrgt;
    @JsonProperty("U_NWR_NORM")
    protected String uNwrNorm;
    @JsonProperty("U_TypeExped")
    protected String uTypeexped;
    @JsonProperty("U_NWR_Manifest")
    protected String uNwrManifest;
    @JsonProperty("U_EMPACADOR")
    protected String uEmpacador;
    @JsonProperty("U_HORA_INI_EMP")
    protected String uHoraIniEmp;
    @JsonProperty("U_HORA_FIN_EMP")
    protected String uHoraFinEmp;
    @JsonProperty("U_ALIST")
    protected String uAlist;
    @JsonProperty("U_FEC_INI_EMP")
    protected String uFecIniEmp;
    @JsonProperty("U_FEC_FIN_EMP")
    protected String uFecFinEmp;
    @JsonProperty("U_OK1_IFRS")
    protected String uOk1Ifrs;
    @JsonProperty("U_TOT_FLE_CLIE")
    protected Double uTotFleClie;
    @JsonProperty("U_SHIPPING")
    protected String uShipping;
    @JsonProperty("U_EsIndep")
    protected String uEsindep;
    @JsonProperty("U_DocEntryLeg")
    protected String uDocentryleg;
    @JsonProperty("U_idLineLeg")
    protected String uIdlineleg;
    @JsonProperty("U_serieLeg")
    protected String uSerieleg;
    @JsonProperty("U_Fecha_Arribo_CEDI")
    protected String uFechaArriboCedi;
    @JsonProperty("U_CatRet")
    protected String uCatret;
    @JsonProperty("U_Bodega")
    protected String uBodega;
    @JsonProperty("U_AIU_ADMIN")
    protected Double uAiuAdmin;
    @JsonProperty("U_AIU_IMPRE")
    protected Double uAiuImpre;
    @JsonProperty("U_AIU_UTIL")
    protected Double uAiuUtil;
    @JsonProperty("U_F_EN_DOC_FIN")
    protected String uFEnDocFin;
    @JsonProperty("U_F_PAGO_FINAL")
    protected String uFPagoFinal;
    @JsonProperty("U_VLR_PAGO_FINAL")
    protected Double uVlrPagoFinal;
    @JsonProperty("U_CANT_CONTE")
    protected String uCantConte;
    @JsonProperty("U_addInFaElectronica_tipoND_FE")
    protected String uAddinfaelectronicaTipondFe;
    @JsonProperty("U_tipoNCC_FE")
    protected String uTiponccFe;
    @JsonProperty("U_fechaDocCont")
    protected String uFechadoccont;
    @JsonProperty("U_FE_FechaTC")
    protected String uFeFechatc;
    @JsonProperty("U_Doc_CR_FE")
    protected String uDocCrFe;
    @JsonProperty("U_CUFE")
    protected String uCufe;
    @JsonProperty("U_DocAdicionales")
    protected String uDocadicionales;
    @JsonProperty("U_addInFE_LinkFE")
    protected String uAddinfeLinkfe;
    @JsonProperty("U_addInFa_FVSerie")
    protected String uAddinfaFvserie;
    @JsonProperty("U_addInFa_FVNum")
    protected String uAddinfaFvnum;
    @JsonProperty("U_NroFacContinFE")
    protected String uNrofaccontinfe;
    @JsonProperty("U_tipoEmisionFE")
    protected String uTipoemisionfe;
    @JsonProperty("U_CodigoQR")
    protected String uCodigoqr;
    @JsonProperty("U_SelloDigital")
    protected String uSellodigital;
    @JsonProperty("U_tipo_NCV_FE")
    protected String uTipoNcvFe;
    @JsonProperty("U_tipo_NDV_FE")
    protected String uTipoNdvFe;
    @JsonProperty("U_CBM")
    protected String uCbm;
    @JsonProperty("U_condEntrega_FE")
    protected String uCondentregaFe;
    @JsonProperty("U_MedioPg")
    protected String uMediopg;
    @JsonProperty("U_Plantilla")
    protected Integer uPlantilla;
    @JsonProperty("U_DESPACHO_CONTADO")
    protected String uDespachoContado;
    @JsonProperty("U_totalImpoCo")
    protected Double uTotalimpoco;
    @JsonProperty("U_SERIAL")
    protected String uSerial;
    @JsonProperty("U_ESTADO_WMS")
    protected String uEstadoWms;
    @JsonProperty("U_INCOTERMS")
    protected String uIncoterms;
    @JsonProperty("U_OK1_Fa_Export")
    protected String uOk1FaExport;
    @JsonProperty("U_TipoFacturacion")
    protected String uTipofacturacion;
    @JsonProperty("U_tipoMandato")
    protected String uTipomandato;
    @JsonProperty("U_tipoTransporte")
    protected String uTipotransporte;
    @JsonProperty("U_F_CARGA_LISTA")
    protected String uFCargaLista;
    @JsonProperty("U_TIEMPO_TRANSITO")
    protected String uTiempoTransito;
    @JsonProperty("U_F_SALIDA_PUERTO")
    protected String uFSalidaPuerto;
    @JsonProperty("U_TIEMPO_PUERTO")
    protected String uTiempoPuerto;
    @JsonProperty("U_TIPO_CARGA")
    protected String uTipoCarga;
    @JsonProperty("U_TIEMPO_ENT_COMEX")
    protected String uTiempoEntComex;
    @JsonProperty("U_F_BOOKING")
    protected String uFBooking;
    @JsonProperty("U_TIEMPO_ESP_BOOKING")
    protected String uTiempoEspBooking;
    @JsonProperty("U_F_ESTIM_EMBARQUE")
    protected String uFEstimEmbarque;
    @JsonProperty("U_F_CUTT_OFF")
    protected String uFCuttOff;
    @JsonProperty("U_F_REC_DOC_FINAL")
    protected String uFRecDocFinal;
    @JsonProperty("U_EMISION_BL")
    protected String uEmisionBl;
    @JsonProperty("U_INSPECCION")
    protected String uInspeccion;
    @JsonProperty("U_F_ARRIBO_CEDI_EST")
    protected String uFArriboCediEst;
    @JsonProperty("U_NotificationBL")
    protected String uNotificationbl;
    @JsonProperty("U_F_ESTIM_PAGO")
    protected String uFEstimPago;
    @JsonProperty("U_LIQUID_COMEX")
    protected String uLiquidComex;
    @JsonProperty("U_TIPO_CARGA_PRO")
    protected String uTipoCargaPro;
    @JsonProperty("U_CANT_CARGA")
    protected Double uCantCarga;
    @JsonProperty("U_BodegaDestino")
    protected String uBodegadestino;
    @JsonProperty("U_Traslado")
    protected String uTraslado;
    @JsonProperty("U_PrjctT")
    protected String uPrjctt;
    @JsonProperty("U_Dim1T")
    protected String uDim1t;
    @JsonProperty("U_Dim2T")
    protected String uDim2t;
    @JsonProperty("U_Dim3T")
    protected String uDim3t;
    @JsonProperty("U_Dim4T")
    protected String uDim4t;
    @JsonProperty("U_Dim5T")
    protected String uDim5t;
    @JsonProperty("U_SEMANA_CARGA")
    protected String uSemanaCarga;
    @JsonProperty("U_MES_CARGA")
    protected String uMesCarga;
    @JsonProperty("U_F_ENT_CARGA")
    protected String uFEntCarga;
    @JsonProperty("U_F_LIQUIDACION")
    protected String uFLiquidacion;
    @JsonProperty("U_F_LIB_BL")
    protected String uFLibBl;
    @JsonProperty("U_F_ENTREGA_PROV")
    protected String uFEntregaProv;
    @JsonProperty("U_CONDUCTOR")
    protected String uConductor;
    @JsonProperty("U_CEDULA_CON")
    protected String uCedulaCon;
    @JsonProperty("U_PLACA")
    protected String uPlaca;
    @JsonProperty("U_CONTENEDOR")
    protected String uContenedor;
    @JsonProperty("U_PRECINTO")
    protected String uPrecinto;
    @JsonProperty("U_ENVIAR_DATOS_CON")
    protected String uEnviarDatosCon;
    @JsonProperty("U_formaGeneracion")
    protected String uFormageneracion;
    @JsonProperty("U_conceptoCorreccionNC")
    protected String uConceptocorreccionnc;
    @JsonProperty("U_Saneamiento")
    protected String uSaneamiento;
    @JsonProperty("U_mesesDiferido")
    protected String uMesesdiferido;
    @JsonProperty("U_VR_ANTICIPO_2")
    protected Double uVrAnticipo2;
    @JsonProperty("U_periodoAsociado_FE")
    protected String uPeriodoasociadoFe;
    @JsonProperty("U_MetodoPWeb")
    protected String uMetodopweb;
    @JsonProperty("U_noConReq")
    protected String uNoconreq;
    @JsonProperty("U_numReqWeb")
    protected String uNumreqweb;
    @JsonProperty("U_SplCode")
    protected String uSplcode;
    @JsonProperty("U_OK1_DescReq")
    protected String uOk1Descreq;
    @JsonProperty("U_ElectronicReception")
    protected String uElectronicreception;
    @JsonProperty("U_RutaPDF")
    protected String uRutapdf;
    @JsonProperty("U_Url_Viewer")
    protected String uUrlViewer;
    @JsonProperty("Document_ApprovalRequests")
    protected List<String> documentApprovalrequests;
    @JsonProperty("DocumentLines")
    protected List<InventoryGenExitsRestDTO.DocumentLine> documentLines;
    @JsonProperty("ElectronicProtocols")
    protected List<String> electronicProtocols;
    @JsonProperty("TaxExtension")
    protected Object taxExtension;
    @JsonProperty("AddressExtension")
    protected Object addressExtension;
    @JsonProperty("DocumentReferences")
    protected List<String> documentReferences;

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
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

    public String getDocDueDate() {
        return docDueDate;
    }

    public void setDocDueDate(String docDueDate) {
        this.docDueDate = docDueDate;
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

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public Double getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(Double docTotal) {
        this.docTotal = docTotal;
    }

    public String getAttachmentEntry() {
        return attachmentEntry;
    }

    public void setAttachmentEntry(String attachmentEntry) {
        this.attachmentEntry = attachmentEntry;
    }

    public String getDocCurrency() {
        return docCurrency;
    }

    public void setDocCurrency(String docCurrency) {
        this.docCurrency = docCurrency;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getJournalMemo() {
        return journalMemo;
    }

    public void setJournalMemo(String journalMemo) {
        this.journalMemo = journalMemo;
    }

    public Integer getPaymentGroupCode() {
        return paymentGroupCode;
    }

    public void setPaymentGroupCode(Integer paymentGroupCode) {
        this.paymentGroupCode = paymentGroupCode;
    }

    public String getDocTime() {
        return docTime;
    }

    public void setDocTime(String docTime) {
        this.docTime = docTime;
    }

    public Integer getSalesPersonCode() {
        return salesPersonCode;
    }

    public void setSalesPersonCode(Integer salesPersonCode) {
        this.salesPersonCode = salesPersonCode;
    }

    public Integer getTransportationCode() {
        return transportationCode;
    }

    public void setTransportationCode(Integer transportationCode) {
        this.transportationCode = transportationCode;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getImportFileNum() {
        return importFileNum;
    }

    public void setImportFileNum(String importFileNum) {
        this.importFileNum = importFileNum;
    }

    public String getSummeryType() {
        return summeryType;
    }

    public void setSummeryType(String summeryType) {
        this.summeryType = summeryType;
    }

    public Integer getContactPersonCode() {
        return contactPersonCode;
    }

    public void setContactPersonCode(Integer contactPersonCode) {
        this.contactPersonCode = contactPersonCode;
    }

    public String getShowSCN() {
        return showSCN;
    }

    public void setShowSCN(String showSCN) {
        this.showSCN = showSCN;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public String getPartialSupply() {
        return partialSupply;
    }

    public void setPartialSupply(String partialSupply) {
        this.partialSupply = partialSupply;
    }

    public String getDocObjectCode() {
        return docObjectCode;
    }

    public void setDocObjectCode(String docObjectCode) {
        this.docObjectCode = docObjectCode;
    }

    public String getShipToCode() {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getFederalTaxID() {
        return federalTaxID;
    }

    public void setFederalTaxID(String federalTaxID) {
        this.federalTaxID = federalTaxID;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getFinancialPeriod() {
        return financialPeriod;
    }

    public void setFinancialPeriod(Integer financialPeriod) {
        this.financialPeriod = financialPeriod;
    }

    public Integer getUserSign() {
        return userSign;
    }

    public void setUserSign(Integer userSign) {
        this.userSign = userSign;
    }

    public Integer getTransNum() {
        return transNum;
    }

    public void setTransNum(Integer transNum) {
        this.transNum = transNum;
    }

    public Double getVatSum() {
        return vatSum;
    }

    public void setVatSum(Double vatSum) {
        this.vatSum = vatSum;
    }

    public Double getVatSumSys() {
        return vatSumSys;
    }

    public void setVatSumSys(Double vatSumSys) {
        this.vatSumSys = vatSumSys;
    }

    public Double getVatSumFc() {
        return vatSumFc;
    }

    public void setVatSumFc(Double vatSumFc) {
        this.vatSumFc = vatSumFc;
    }

    public String getNetProcedure() {
        return netProcedure;
    }

    public void setNetProcedure(String netProcedure) {
        this.netProcedure = netProcedure;
    }

    public Double getDocTotalFc() {
        return docTotalFc;
    }

    public void setDocTotalFc(Double docTotalFc) {
        this.docTotalFc = docTotalFc;
    }

    public Double getDocTotalSys() {
        return docTotalSys;
    }

    public void setDocTotalSys(Double docTotalSys) {
        this.docTotalSys = docTotalSys;
    }

    public String getForm1099() {
        return form1099;
    }

    public void setForm1099(String form1099) {
        this.form1099 = form1099;
    }

    public String getBox1099() {
        return box1099;
    }

    public void setBox1099(String box1099) {
        this.box1099 = box1099;
    }

    public String getRevisionPo() {
        return revisionPo;
    }

    public void setRevisionPo(String revisionPo) {
        this.revisionPo = revisionPo;
    }

    public String getRequriedDate() {
        return requriedDate;
    }

    public void setRequriedDate(String requriedDate) {
        this.requriedDate = requriedDate;
    }

    public String getCancelDate() {
        return cancelDate;
    }

    public void setCancelDate(String cancelDate) {
        this.cancelDate = cancelDate;
    }

    public String getBlockDunning() {
        return blockDunning;
    }

    public void setBlockDunning(String blockDunning) {
        this.blockDunning = blockDunning;
    }

    public String getSubmitted() {
        return submitted;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public Integer getSegment() {
        return segment;
    }

    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    public String getPickStatus() {
        return pickStatus;
    }

    public void setPickStatus(String pickStatus) {
        this.pickStatus = pickStatus;
    }

    public String getPick() {
        return pick;
    }

    public void setPick(String pick) {
        this.pick = pick;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentBlock() {
        return paymentBlock;
    }

    public void setPaymentBlock(String paymentBlock) {
        this.paymentBlock = paymentBlock;
    }

    public String getPaymentBlockEntry() {
        return paymentBlockEntry;
    }

    public void setPaymentBlockEntry(String paymentBlockEntry) {
        this.paymentBlockEntry = paymentBlockEntry;
    }

    public String getCentralBankIndicator() {
        return centralBankIndicator;
    }

    public void setCentralBankIndicator(String centralBankIndicator) {
        this.centralBankIndicator = centralBankIndicator;
    }

    public String getMaximumCashDiscount() {
        return maximumCashDiscount;
    }

    public void setMaximumCashDiscount(String maximumCashDiscount) {
        this.maximumCashDiscount = maximumCashDiscount;
    }

    public String getReserve() {
        return reserve;
    }

    public void setReserve(String reserve) {
        this.reserve = reserve;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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

    public String getWareHouseUpdateType() {
        return wareHouseUpdateType;
    }

    public void setWareHouseUpdateType(String wareHouseUpdateType) {
        this.wareHouseUpdateType = wareHouseUpdateType;
    }

    public String getRounding() {
        return rounding;
    }

    public void setRounding(String rounding) {
        this.rounding = rounding;
    }

    public String getExternalCorrectedDocNum() {
        return externalCorrectedDocNum;
    }

    public void setExternalCorrectedDocNum(String externalCorrectedDocNum) {
        this.externalCorrectedDocNum = externalCorrectedDocNum;
    }

    public String getInternalCorrectedDocNum() {
        return internalCorrectedDocNum;
    }

    public void setInternalCorrectedDocNum(String internalCorrectedDocNum) {
        this.internalCorrectedDocNum = internalCorrectedDocNum;
    }

    public String getNextCorrectingDocument() {
        return nextCorrectingDocument;
    }

    public void setNextCorrectingDocument(String nextCorrectingDocument) {
        this.nextCorrectingDocument = nextCorrectingDocument;
    }

    public String getDeferredTax() {
        return deferredTax;
    }

    public void setDeferredTax(String deferredTax) {
        this.deferredTax = deferredTax;
    }

    public String getTaxExemptionLetterNum() {
        return taxExemptionLetterNum;
    }

    public void setTaxExemptionLetterNum(String taxExemptionLetterNum) {
        this.taxExemptionLetterNum = taxExemptionLetterNum;
    }

    public Double getwTApplied() {
        return wTApplied;
    }

    public void setwTApplied(Double wTApplied) {
        this.wTApplied = wTApplied;
    }

    public Double getwTAppliedFC() {
        return wTAppliedFC;
    }

    public void setwTAppliedFC(Double wTAppliedFC) {
        this.wTAppliedFC = wTAppliedFC;
    }

    public String getBillOfExchangeReserved() {
        return billOfExchangeReserved;
    }

    public void setBillOfExchangeReserved(String billOfExchangeReserved) {
        this.billOfExchangeReserved = billOfExchangeReserved;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public Double getwTAppliedSC() {
        return wTAppliedSC;
    }

    public void setwTAppliedSC(Double wTAppliedSC) {
        this.wTAppliedSC = wTAppliedSC;
    }

    public Double getTotalEqualizationTax() {
        return totalEqualizationTax;
    }

    public void setTotalEqualizationTax(Double totalEqualizationTax) {
        this.totalEqualizationTax = totalEqualizationTax;
    }

    public Double getTotalEqualizationTaxFC() {
        return totalEqualizationTaxFC;
    }

    public void setTotalEqualizationTaxFC(Double totalEqualizationTaxFC) {
        this.totalEqualizationTaxFC = totalEqualizationTaxFC;
    }

    public Double getTotalEqualizationTaxSC() {
        return totalEqualizationTaxSC;
    }

    public void setTotalEqualizationTaxSC(Double totalEqualizationTaxSC) {
        this.totalEqualizationTaxSC = totalEqualizationTaxSC;
    }

    public Integer getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public void setNumberOfInstallments(Integer numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public String getApplyTaxOnFirstInstallment() {
        return applyTaxOnFirstInstallment;
    }

    public void setApplyTaxOnFirstInstallment(String applyTaxOnFirstInstallment) {
        this.applyTaxOnFirstInstallment = applyTaxOnFirstInstallment;
    }

    public String getTaxOnInstallments() {
        return taxOnInstallments;
    }

    public void setTaxOnInstallments(String taxOnInstallments) {
        this.taxOnInstallments = taxOnInstallments;
    }

    public Double getwTNonSubjectAmount() {
        return wTNonSubjectAmount;
    }

    public void setwTNonSubjectAmount(Double wTNonSubjectAmount) {
        this.wTNonSubjectAmount = wTNonSubjectAmount;
    }

    public Double getwTNonSubjectAmountSC() {
        return wTNonSubjectAmountSC;
    }

    public void setwTNonSubjectAmountSC(Double wTNonSubjectAmountSC) {
        this.wTNonSubjectAmountSC = wTNonSubjectAmountSC;
    }

    public Double getwTNonSubjectAmountFC() {
        return wTNonSubjectAmountFC;
    }

    public void setwTNonSubjectAmountFC(Double wTNonSubjectAmountFC) {
        this.wTNonSubjectAmountFC = wTNonSubjectAmountFC;
    }

    public Double getwTExemptedAmount() {
        return wTExemptedAmount;
    }

    public void setwTExemptedAmount(Double wTExemptedAmount) {
        this.wTExemptedAmount = wTExemptedAmount;
    }

    public Double getwTExemptedAmountSC() {
        return wTExemptedAmountSC;
    }

    public void setwTExemptedAmountSC(Double wTExemptedAmountSC) {
        this.wTExemptedAmountSC = wTExemptedAmountSC;
    }

    public Double getwTExemptedAmountFC() {
        return wTExemptedAmountFC;
    }

    public void setwTExemptedAmountFC(Double wTExemptedAmountFC) {
        this.wTExemptedAmountFC = wTExemptedAmountFC;
    }

    public Double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Double getBaseAmountSC() {
        return baseAmountSC;
    }

    public void setBaseAmountSC(Double baseAmountSC) {
        this.baseAmountSC = baseAmountSC;
    }

    public Double getBaseAmountFC() {
        return baseAmountFC;
    }

    public void setBaseAmountFC(Double baseAmountFC) {
        this.baseAmountFC = baseAmountFC;
    }

    public Double getwTAmount() {
        return wTAmount;
    }

    public void setwTAmount(Double wTAmount) {
        this.wTAmount = wTAmount;
    }

    public Double getwTAmountSC() {
        return wTAmountSC;
    }

    public void setwTAmountSC(Double wTAmountSC) {
        this.wTAmountSC = wTAmountSC;
    }

    public Double getwTAmountFC() {
        return wTAmountFC;
    }

    public void setwTAmountFC(Double wTAmountFC) {
        this.wTAmountFC = wTAmountFC;
    }

    public String getVatDate() {
        return vatDate;
    }

    public void setVatDate(String vatDate) {
        this.vatDate = vatDate;
    }

    public String getDocumentsOwner() {
        return documentsOwner;
    }

    public void setDocumentsOwner(String documentsOwner) {
        this.documentsOwner = documentsOwner;
    }

    public String getFolioPrefixString() {
        return folioPrefixString;
    }

    public void setFolioPrefixString(String folioPrefixString) {
        this.folioPrefixString = folioPrefixString;
    }

    public String getFolioNumber() {
        return folioNumber;
    }

    public void setFolioNumber(String folioNumber) {
        this.folioNumber = folioNumber;
    }

    public String getDocumentSubType() {
        return documentSubType;
    }

    public void setDocumentSubType(String documentSubType) {
        this.documentSubType = documentSubType;
    }

    public String getbPChannelCode() {
        return bPChannelCode;
    }

    public void setbPChannelCode(String bPChannelCode) {
        this.bPChannelCode = bPChannelCode;
    }

    public String getbPChannelContact() {
        return bPChannelContact;
    }

    public void setbPChannelContact(String bPChannelContact) {
        this.bPChannelContact = bPChannelContact;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDocumentStatus() {
        return documentStatus;
    }

    public void setDocumentStatus(String documentStatus) {
        this.documentStatus = documentStatus;
    }

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setPeriodIndicator(String periodIndicator) {
        this.periodIndicator = periodIndicator;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
    }

    public String getManualNumber() {
        return manualNumber;
    }

    public void setManualNumber(String manualNumber) {
        this.manualNumber = manualNumber;
    }

    public String getUseShpdGoodsAct() {
        return useShpdGoodsAct;
    }

    public void setUseShpdGoodsAct(String useShpdGoodsAct) {
        this.useShpdGoodsAct = useShpdGoodsAct;
    }

    public String getIsPayToBank() {
        return isPayToBank;
    }

    public void setIsPayToBank(String isPayToBank) {
        this.isPayToBank = isPayToBank;
    }

    public String getPayToBankCountry() {
        return payToBankCountry;
    }

    public void setPayToBankCountry(String payToBankCountry) {
        this.payToBankCountry = payToBankCountry;
    }

    public String getPayToBankCode() {
        return payToBankCode;
    }

    public void setPayToBankCode(String payToBankCode) {
        this.payToBankCode = payToBankCode;
    }

    public String getPayToBankAccountNo() {
        return payToBankAccountNo;
    }

    public void setPayToBankAccountNo(String payToBankAccountNo) {
        this.payToBankAccountNo = payToBankAccountNo;
    }

    public String getPayToBankBranch() {
        return payToBankBranch;
    }

    public void setPayToBankBranch(String payToBankBranch) {
        this.payToBankBranch = payToBankBranch;
    }

    public String getBplIdassignedtoinvoice() {
        return bplIdassignedtoinvoice;
    }

    public void setBplIdassignedtoinvoice(String bplIdassignedtoinvoice) {
        this.bplIdassignedtoinvoice = bplIdassignedtoinvoice;
    }

    public Double getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(Double downPayment) {
        this.downPayment = downPayment;
    }

    public String getReserveInvoice() {
        return reserveInvoice;
    }

    public void setReserveInvoice(String reserveInvoice) {
        this.reserveInvoice = reserveInvoice;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getPickRemark() {
        return pickRemark;
    }

    public void setPickRemark(String pickRemark) {
        this.pickRemark = pickRemark;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getSequenceCode() {
        return sequenceCode;
    }

    public void setSequenceCode(String sequenceCode) {
        this.sequenceCode = sequenceCode;
    }

    public String getSequenceSerial() {
        return sequenceSerial;
    }

    public void setSequenceSerial(String sequenceSerial) {
        this.sequenceSerial = sequenceSerial;
    }

    public String getSeriesString() {
        return seriesString;
    }

    public void setSeriesString(String seriesString) {
        this.seriesString = seriesString;
    }

    public String getSubSeriesString() {
        return subSeriesString;
    }

    public void setSubSeriesString(String subSeriesString) {
        this.subSeriesString = subSeriesString;
    }

    public String getSequenceModel() {
        return sequenceModel;
    }

    public void setSequenceModel(String sequenceModel) {
        this.sequenceModel = sequenceModel;
    }

    public String getUseCorrectionVATGroup() {
        return useCorrectionVATGroup;
    }

    public void setUseCorrectionVATGroup(String useCorrectionVATGroup) {
        this.useCorrectionVATGroup = useCorrectionVATGroup;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getDownPaymentAmount() {
        return downPaymentAmount;
    }

    public void setDownPaymentAmount(Double downPaymentAmount) {
        this.downPaymentAmount = downPaymentAmount;
    }

    public Double getDownPaymentPercentage() {
        return downPaymentPercentage;
    }

    public void setDownPaymentPercentage(Double downPaymentPercentage) {
        this.downPaymentPercentage = downPaymentPercentage;
    }

    public String getDownPaymentType() {
        return downPaymentType;
    }

    public void setDownPaymentType(String downPaymentType) {
        this.downPaymentType = downPaymentType;
    }

    public Double getDownPaymentAmountSC() {
        return downPaymentAmountSC;
    }

    public void setDownPaymentAmountSC(Double downPaymentAmountSC) {
        this.downPaymentAmountSC = downPaymentAmountSC;
    }

    public Double getDownPaymentAmountFC() {
        return downPaymentAmountFC;
    }

    public void setDownPaymentAmountFC(Double downPaymentAmountFC) {
        this.downPaymentAmountFC = downPaymentAmountFC;
    }

    public Double getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Double vatPercent) {
        this.vatPercent = vatPercent;
    }

    public Double getServiceGrossProfitPercent() {
        return serviceGrossProfitPercent;
    }

    public void setServiceGrossProfitPercent(Double serviceGrossProfitPercent) {
        this.serviceGrossProfitPercent = serviceGrossProfitPercent;
    }

    public String getOpeningRemarks() {
        return openingRemarks;
    }

    public void setOpeningRemarks(String openingRemarks) {
        this.openingRemarks = openingRemarks;
    }

    public String getClosingRemarks() {
        return closingRemarks;
    }

    public void setClosingRemarks(String closingRemarks) {
        this.closingRemarks = closingRemarks;
    }

    public Double getRoundingDiffAmount() {
        return roundingDiffAmount;
    }

    public void setRoundingDiffAmount(Double roundingDiffAmount) {
        this.roundingDiffAmount = roundingDiffAmount;
    }

    public Double getRoundingDiffAmountFC() {
        return roundingDiffAmountFC;
    }

    public void setRoundingDiffAmountFC(Double roundingDiffAmountFC) {
        this.roundingDiffAmountFC = roundingDiffAmountFC;
    }

    public Double getRoundingDiffAmountSC() {
        return roundingDiffAmountSC;
    }

    public void setRoundingDiffAmountSC(Double roundingDiffAmountSC) {
        this.roundingDiffAmountSC = roundingDiffAmountSC;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getSignatureInputMessage() {
        return signatureInputMessage;
    }

    public void setSignatureInputMessage(String signatureInputMessage) {
        this.signatureInputMessage = signatureInputMessage;
    }

    public String getSignatureDigest() {
        return signatureDigest;
    }

    public void setSignatureDigest(String signatureDigest) {
        this.signatureDigest = signatureDigest;
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    public String getPrivateKeyVersion() {
        return privateKeyVersion;
    }

    public void setPrivateKeyVersion(String privateKeyVersion) {
        this.privateKeyVersion = privateKeyVersion;
    }

    public String getControlAccount() {
        return controlAccount;
    }

    public void setControlAccount(String controlAccount) {
        this.controlAccount = controlAccount;
    }

    public String getInsuranceOperation347() {
        return insuranceOperation347;
    }

    public void setInsuranceOperation347(String insuranceOperation347) {
        this.insuranceOperation347 = insuranceOperation347;
    }

    public String getArchiveNonremovableSalesQuotation() {
        return archiveNonremovableSalesQuotation;
    }

    public void setArchiveNonremovableSalesQuotation(String archiveNonremovableSalesQuotation) {
        this.archiveNonremovableSalesQuotation = archiveNonremovableSalesQuotation;
    }

    public String getgTSChecker() {
        return gTSChecker;
    }

    public void setgTSChecker(String gTSChecker) {
        this.gTSChecker = gTSChecker;
    }

    public String getgTSPayee() {
        return gTSPayee;
    }

    public void setgTSPayee(String gTSPayee) {
        this.gTSPayee = gTSPayee;
    }

    public String getExtraMonth() {
        return extraMonth;
    }

    public void setExtraMonth(String extraMonth) {
        this.extraMonth = extraMonth;
    }

    public String getExtraDays() {
        return extraDays;
    }

    public void setExtraDays(String extraDays) {
        this.extraDays = extraDays;
    }

    public Integer getCashDiscountDateOffset() {
        return cashDiscountDateOffset;
    }

    public void setCashDiscountDateOffset(Integer cashDiscountDateOffset) {
        this.cashDiscountDateOffset = cashDiscountDateOffset;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(String startFrom) {
        this.startFrom = startFrom;
    }

    public String getnTSApproved() {
        return nTSApproved;
    }

    public void setnTSApproved(String nTSApproved) {
        this.nTSApproved = nTSApproved;
    }

    public String geteTaxWebSite() {
        return eTaxWebSite;
    }

    public void seteTaxWebSite(String eTaxWebSite) {
        this.eTaxWebSite = eTaxWebSite;
    }

    public String geteTaxNumber() {
        return eTaxNumber;
    }

    public void seteTaxNumber(String eTaxNumber) {
        this.eTaxNumber = eTaxNumber;
    }

    public String getnTSApprovedNumber() {
        return nTSApprovedNumber;
    }

    public void setnTSApprovedNumber(String nTSApprovedNumber) {
        this.nTSApprovedNumber = nTSApprovedNumber;
    }

    public String geteDocGenerationType() {
        return eDocGenerationType;
    }

    public void seteDocGenerationType(String eDocGenerationType) {
        this.eDocGenerationType = eDocGenerationType;
    }

    public String geteDocSeries() {
        return eDocSeries;
    }

    public void seteDocSeries(String eDocSeries) {
        this.eDocSeries = eDocSeries;
    }

    public String geteDocNum() {
        return eDocNum;
    }

    public void seteDocNum(String eDocNum) {
        this.eDocNum = eDocNum;
    }

    public String geteDocExportFormat() {
        return eDocExportFormat;
    }

    public void seteDocExportFormat(String eDocExportFormat) {
        this.eDocExportFormat = eDocExportFormat;
    }

    public String geteDocStatus() {
        return eDocStatus;
    }

    public void seteDocStatus(String eDocStatus) {
        this.eDocStatus = eDocStatus;
    }

    public String geteDocErrorCode() {
        return eDocErrorCode;
    }

    public void seteDocErrorCode(String eDocErrorCode) {
        this.eDocErrorCode = eDocErrorCode;
    }

    public String geteDocErrorMessage() {
        return eDocErrorMessage;
    }

    public void seteDocErrorMessage(String eDocErrorMessage) {
        this.eDocErrorMessage = eDocErrorMessage;
    }

    public String getDownPaymentStatus() {
        return downPaymentStatus;
    }

    public void setDownPaymentStatus(String downPaymentStatus) {
        this.downPaymentStatus = downPaymentStatus;
    }

    public String getGroupSeries() {
        return groupSeries;
    }

    public void setGroupSeries(String groupSeries) {
        this.groupSeries = groupSeries;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupHandWritten() {
        return groupHandWritten;
    }

    public void setGroupHandWritten(String groupHandWritten) {
        this.groupHandWritten = groupHandWritten;
    }

    public String getReopenOriginalDocument() {
        return reopenOriginalDocument;
    }

    public void setReopenOriginalDocument(String reopenOriginalDocument) {
        this.reopenOriginalDocument = reopenOriginalDocument;
    }

    public String getReopenManuallyClosedOrCanceledDocument() {
        return reopenManuallyClosedOrCanceledDocument;
    }

    public void setReopenManuallyClosedOrCanceledDocument(String reopenManuallyClosedOrCanceledDocument) {
        this.reopenManuallyClosedOrCanceledDocument = reopenManuallyClosedOrCanceledDocument;
    }

    public String getCreateOnlineQuotation() {
        return createOnlineQuotation;
    }

    public void setCreateOnlineQuotation(String createOnlineQuotation) {
        this.createOnlineQuotation = createOnlineQuotation;
    }

    public String getpOSEquipmentNumber() {
        return pOSEquipmentNumber;
    }

    public void setpOSEquipmentNumber(String pOSEquipmentNumber) {
        this.pOSEquipmentNumber = pOSEquipmentNumber;
    }

    public String getpOSManufacturerSerialNumber() {
        return pOSManufacturerSerialNumber;
    }

    public void setpOSManufacturerSerialNumber(String pOSManufacturerSerialNumber) {
        this.pOSManufacturerSerialNumber = pOSManufacturerSerialNumber;
    }

    public String getpOSCashierNumber() {
        return pOSCashierNumber;
    }

    public void setpOSCashierNumber(String pOSCashierNumber) {
        this.pOSCashierNumber = pOSCashierNumber;
    }

    public String getApplyCurrentVATRatesForDownPaymentsToDraw() {
        return applyCurrentVATRatesForDownPaymentsToDraw;
    }

    public void setApplyCurrentVATRatesForDownPaymentsToDraw(String applyCurrentVATRatesForDownPaymentsToDraw) {
        this.applyCurrentVATRatesForDownPaymentsToDraw = applyCurrentVATRatesForDownPaymentsToDraw;
    }

    public String getClosingOption() {
        return closingOption;
    }

    public void setClosingOption(String closingOption) {
        this.closingOption = closingOption;
    }

    public String getSpecifiedClosingDate() {
        return specifiedClosingDate;
    }

    public void setSpecifiedClosingDate(String specifiedClosingDate) {
        this.specifiedClosingDate = specifiedClosingDate;
    }

    public String getOpenForLandedCosts() {
        return openForLandedCosts;
    }

    public void setOpenForLandedCosts(String openForLandedCosts) {
        this.openForLandedCosts = openForLandedCosts;
    }

    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
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

    public String getRelevantToGTS() {
        return relevantToGTS;
    }

    public void setRelevantToGTS(String relevantToGTS) {
        this.relevantToGTS = relevantToGTS;
    }

    public String getbPLName() {
        return bPLName;
    }

    public void setbPLName(String bPLName) {
        this.bPLName = bPLName;
    }

    public String getvATRegNum() {
        return vATRegNum;
    }

    public void setvATRegNum(String vATRegNum) {
        this.vATRegNum = vATRegNum;
    }

    public String getAnnualInvoiceDeclarationReference() {
        return annualInvoiceDeclarationReference;
    }

    public void setAnnualInvoiceDeclarationReference(String annualInvoiceDeclarationReference) {
        this.annualInvoiceDeclarationReference = annualInvoiceDeclarationReference;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getReleaser() {
        return releaser;
    }

    public void setReleaser(String releaser) {
        this.releaser = releaser;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getBlanketAgreementNumber() {
        return blanketAgreementNumber;
    }

    public void setBlanketAgreementNumber(String blanketAgreementNumber) {
        this.blanketAgreementNumber = blanketAgreementNumber;
    }

    public String getIsAlteration() {
        return isAlteration;
    }

    public void setIsAlteration(String isAlteration) {
        this.isAlteration = isAlteration;
    }

    public String getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(String cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getAssetValueDate() {
        return assetValueDate;
    }

    public void setAssetValueDate(String assetValueDate) {
        this.assetValueDate = assetValueDate;
    }

    public String getDocumentDelivery() {
        return documentDelivery;
    }

    public void setDocumentDelivery(String documentDelivery) {
        this.documentDelivery = documentDelivery;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getStartDeliveryDate() {
        return startDeliveryDate;
    }

    public void setStartDeliveryDate(String startDeliveryDate) {
        this.startDeliveryDate = startDeliveryDate;
    }

    public String getStartDeliveryTime() {
        return startDeliveryTime;
    }

    public void setStartDeliveryTime(String startDeliveryTime) {
        this.startDeliveryTime = startDeliveryTime;
    }

    public String getEndDeliveryDate() {
        return endDeliveryDate;
    }

    public void setEndDeliveryDate(String endDeliveryDate) {
        this.endDeliveryDate = endDeliveryDate;
    }

    public String getEndDeliveryTime() {
        return endDeliveryTime;
    }

    public void setEndDeliveryTime(String endDeliveryTime) {
        this.endDeliveryTime = endDeliveryTime;
    }

    public String getVehiclePlate() {
        return vehiclePlate;
    }

    public void setVehiclePlate(String vehiclePlate) {
        this.vehiclePlate = vehiclePlate;
    }

    public String getaTDocumentType() {
        return aTDocumentType;
    }

    public void setaTDocumentType(String aTDocumentType) {
        this.aTDocumentType = aTDocumentType;
    }

    public String getElecCommStatus() {
        return elecCommStatus;
    }

    public void setElecCommStatus(String elecCommStatus) {
        this.elecCommStatus = elecCommStatus;
    }

    public String getElecCommMessage() {
        return elecCommMessage;
    }

    public void setElecCommMessage(String elecCommMessage) {
        this.elecCommMessage = elecCommMessage;
    }

    public String getReuseDocumentNum() {
        return reuseDocumentNum;
    }

    public void setReuseDocumentNum(String reuseDocumentNum) {
        this.reuseDocumentNum = reuseDocumentNum;
    }

    public String getReuseNotaFiscalNum() {
        return reuseNotaFiscalNum;
    }

    public void setReuseNotaFiscalNum(String reuseNotaFiscalNum) {
        this.reuseNotaFiscalNum = reuseNotaFiscalNum;
    }

    public String getPrintSEPADirect() {
        return printSEPADirect;
    }

    public void setPrintSEPADirect(String printSEPADirect) {
        this.printSEPADirect = printSEPADirect;
    }

    public String getFiscalDocNum() {
        return fiscalDocNum;
    }

    public void setFiscalDocNum(String fiscalDocNum) {
        this.fiscalDocNum = fiscalDocNum;
    }

    public String getpOSDailySummaryNo() {
        return pOSDailySummaryNo;
    }

    public void setpOSDailySummaryNo(String pOSDailySummaryNo) {
        this.pOSDailySummaryNo = pOSDailySummaryNo;
    }

    public String getpOSReceiptNo() {
        return pOSReceiptNo;
    }

    public void setpOSReceiptNo(String pOSReceiptNo) {
        this.pOSReceiptNo = pOSReceiptNo;
    }

    public String getPointOfIssueCode() {
        return pointOfIssueCode;
    }

    public void setPointOfIssueCode(String pointOfIssueCode) {
        this.pointOfIssueCode = pointOfIssueCode;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getFolioNumberFrom() {
        return folioNumberFrom;
    }

    public void setFolioNumberFrom(String folioNumberFrom) {
        this.folioNumberFrom = folioNumberFrom;
    }

    public String getFolioNumberTo() {
        return folioNumberTo;
    }

    public void setFolioNumberTo(String folioNumberTo) {
        this.folioNumberTo = folioNumberTo;
    }

    public String getInterimType() {
        return interimType;
    }

    public void setInterimType(String interimType) {
        this.interimType = interimType;
    }

    public Integer getRelatedType() {
        return relatedType;
    }

    public void setRelatedType(Integer relatedType) {
        this.relatedType = relatedType;
    }

    public String getRelatedEntry() {
        return relatedEntry;
    }

    public void setRelatedEntry(String relatedEntry) {
        this.relatedEntry = relatedEntry;
    }

    public String getsAPPassport() {
        return sAPPassport;
    }

    public void setsAPPassport(String sAPPassport) {
        this.sAPPassport = sAPPassport;
    }

    public String getDocumentTaxID() {
        return documentTaxID;
    }

    public void setDocumentTaxID(String documentTaxID) {
        this.documentTaxID = documentTaxID;
    }

    public String getDateOfReportingControlStatementVAT() {
        return dateOfReportingControlStatementVAT;
    }

    public void setDateOfReportingControlStatementVAT(String dateOfReportingControlStatementVAT) {
        this.dateOfReportingControlStatementVAT = dateOfReportingControlStatementVAT;
    }

    public String getReportingSectionControlStatementVAT() {
        return reportingSectionControlStatementVAT;
    }

    public void setReportingSectionControlStatementVAT(String reportingSectionControlStatementVAT) {
        this.reportingSectionControlStatementVAT = reportingSectionControlStatementVAT;
    }

    public String getExcludeFromTaxReportControlStatementVAT() {
        return excludeFromTaxReportControlStatementVAT;
    }

    public void setExcludeFromTaxReportControlStatementVAT(String excludeFromTaxReportControlStatementVAT) {
        this.excludeFromTaxReportControlStatementVAT = excludeFromTaxReportControlStatementVAT;
    }

    public String getPosCashregister() {
        return posCashregister;
    }

    public void setPosCashregister(String posCashregister) {
        this.posCashregister = posCashregister;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateQRCodeFrom() {
        return createQRCodeFrom;
    }

    public void setCreateQRCodeFrom(String createQRCodeFrom) {
        this.createQRCodeFrom = createQRCodeFrom;
    }

    public String getShipFrom() {
        return shipFrom;
    }

    public void setShipFrom(String shipFrom) {
        this.shipFrom = shipFrom;
    }

    public String getCommissionTrade() {
        return commissionTrade;
    }

    public void setCommissionTrade(String commissionTrade) {
        this.commissionTrade = commissionTrade;
    }

    public String getCommissionTradeReturn() {
        return commissionTradeReturn;
    }

    public void setCommissionTradeReturn(String commissionTradeReturn) {
        this.commissionTradeReturn = commissionTradeReturn;
    }

    public String getUseBillToAddrToDetermineTax() {
        return useBillToAddrToDetermineTax;
    }

    public void setUseBillToAddrToDetermineTax(String useBillToAddrToDetermineTax) {
        this.useBillToAddrToDetermineTax = useBillToAddrToDetermineTax;
    }

    public String getCig() {
        return cig;
    }

    public void setCig(String cig) {
        this.cig = cig;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public String getFatherCard() {
        return fatherCard;
    }

    public void setFatherCard(String fatherCard) {
        this.fatherCard = fatherCard;
    }

    public String getFatherType() {
        return fatherType;
    }

    public void setFatherType(String fatherType) {
        this.fatherType = fatherType;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipPlace() {
        return shipPlace;
    }

    public void setShipPlace(String shipPlace) {
        this.shipPlace = shipPlace;
    }

    public String getCustOffice() {
        return custOffice;
    }

    public void setCustOffice(String custOffice) {
        this.custOffice = custOffice;
    }

    public String getfCI() {
        return fCI;
    }

    public void setfCI(String fCI) {
        this.fCI = fCI;
    }

    public String getAddLegIn() {
        return addLegIn;
    }

    public void setAddLegIn(String addLegIn) {
        this.addLegIn = addLegIn;
    }

    public String getLegTextF() {
        return legTextF;
    }

    public void setLegTextF(String legTextF) {
        this.legTextF = legTextF;
    }

    public String getdANFELgTxt() {
        return dANFELgTxt;
    }

    public void setdANFELgTxt(String dANFELgTxt) {
        this.dANFELgTxt = dANFELgTxt;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Integer getLastPageFolioNumber() {
        return lastPageFolioNumber;
    }

    public void setLastPageFolioNumber(Integer lastPageFolioNumber) {
        this.lastPageFolioNumber = lastPageFolioNumber;
    }

    public String getInventoryStatus() {
        return inventoryStatus;
    }

    public void setInventoryStatus(String inventoryStatus) {
        this.inventoryStatus = inventoryStatus;
    }

    public String getPlasticPackagingTaxRelevant() {
        return plasticPackagingTaxRelevant;
    }

    public void setPlasticPackagingTaxRelevant(String plasticPackagingTaxRelevant) {
        this.plasticPackagingTaxRelevant = plasticPackagingTaxRelevant;
    }

    public String getNotRelevantForMonthlyInvoice() {
        return notRelevantForMonthlyInvoice;
    }

    public void setNotRelevantForMonthlyInvoice(String notRelevantForMonthlyInvoice) {
        this.notRelevantForMonthlyInvoice = notRelevantForMonthlyInvoice;
    }

    public String getuBpcost() {
        return uBpcost;
    }

    public void setuBpcost(String uBpcost) {
        this.uBpcost = uBpcost;
    }

    public String getuWuid() {
        return uWuid;
    }

    public void setuWuid(String uWuid) {
        this.uWuid = uWuid;
    }

    public String getuFTomaPed() {
        return uFTomaPed;
    }

    public void setuFTomaPed(String uFTomaPed) {
        this.uFTomaPed = uFTomaPed;
    }

    public String getuCampana() {
        return uCampana;
    }

    public void setuCampana(String uCampana) {
        this.uCampana = uCampana;
    }

    public String getuTransp() {
        return uTransp;
    }

    public void setuTransp(String uTransp) {
        this.uTransp = uTransp;
    }

    public String getuSeparador() {
        return uSeparador;
    }

    public void setuSeparador(String uSeparador) {
        this.uSeparador = uSeparador;
    }

    public String getuDesp() {
        return uDesp;
    }

    public void setuDesp(String uDesp) {
        this.uDesp = uDesp;
    }

    public String getuUbic1() {
        return uUbic1;
    }

    public void setuUbic1(String uUbic1) {
        this.uUbic1 = uUbic1;
    }

    public String getuConcNc() {
        return uConcNc;
    }

    public void setuConcNc(String uConcNc) {
        this.uConcNc = uConcNc;
    }

    public String getuConcNd() {
        return uConcNd;
    }

    public void setuConcNd(String uConcNd) {
        this.uConcNd = uConcNd;
    }

    public String getuConcInv() {
        return uConcInv;
    }

    public void setuConcInv(String uConcInv) {
        this.uConcInv = uConcInv;
    }

    public String getuFEmbarque() {
        return uFEmbarque;
    }

    public void setuFEmbarque(String uFEmbarque) {
        this.uFEmbarque = uFEmbarque;
    }

    public String getuTermNeg() {
        return uTermNeg;
    }

    public void setuTermNeg(String uTermNeg) {
        this.uTermNeg = uTermNeg;
    }

    public String getuModTransp() {
        return uModTransp;
    }

    public void setuModTransp(String uModTransp) {
        this.uModTransp = uModTransp;
    }

    public String getuPuertoDes() {
        return uPuertoDes;
    }

    public void setuPuertoDes(String uPuertoDes) {
        this.uPuertoDes = uPuertoDes;
    }

    public String getuModImp() {
        return uModImp;
    }

    public void setuModImp(String uModImp) {
        this.uModImp = uModImp;
    }

    public String getuEstadoOc() {
        return uEstadoOc;
    }

    public void setuEstadoOc(String uEstadoOc) {
        this.uEstadoOc = uEstadoOc;
    }

    public String getuFProforma() {
        return uFProforma;
    }

    public void setuFProforma(String uFProforma) {
        this.uFProforma = uFProforma;
    }

    public String getuEmbarcado() {
        return uEmbarcado;
    }

    public void setuEmbarcado(String uEmbarcado) {
        this.uEmbarcado = uEmbarcado;
    }

    public String getuDocTransp() {
        return uDocTransp;
    }

    public void setuDocTransp(String uDocTransp) {
        this.uDocTransp = uDocTransp;
    }

    public String getuFDocTransp() {
        return uFDocTransp;
    }

    public void setuFDocTransp(String uFDocTransp) {
        this.uFDocTransp = uFDocTransp;
    }

    public String getuFArribPuerto() {
        return uFArribPuerto;
    }

    public void setuFArribPuerto(String uFArribPuerto) {
        this.uFArribPuerto = uFArribPuerto;
    }

    public String getuFArribAlma() {
        return uFArribAlma;
    }

    public void setuFArribAlma(String uFArribAlma) {
        this.uFArribAlma = uFArribAlma;
    }

    public String getuReqAnt() {
        return uReqAnt;
    }

    public void setuReqAnt(String uReqAnt) {
        this.uReqAnt = uReqAnt;
    }

    public String getuAntRealiz() {
        return uAntRealiz;
    }

    public void setuAntRealiz(String uAntRealiz) {
        this.uAntRealiz = uAntRealiz;
    }

    public Double getuTotCaj() {
        return uTotCaj;
    }

    public void setuTotCaj(Double uTotCaj) {
        this.uTotCaj = uTotCaj;
    }

    public Double getuTotBul() {
        return uTotBul;
    }

    public void setuTotBul(Double uTotBul) {
        this.uTotBul = uTotBul;
    }

    public Double getuTotLios() {
        return uTotLios;
    }

    public void setuTotLios(Double uTotLios) {
        this.uTotLios = uTotLios;
    }

    public Double getuVlrFle() {
        return uVlrFle;
    }

    public void setuVlrFle(Double uVlrFle) {
        this.uVlrFle = uVlrFle;
    }

    public Double getuVlrSeg() {
        return uVlrSeg;
    }

    public void setuVlrSeg(Double uVlrSeg) {
        this.uVlrSeg = uVlrSeg;
    }

    public Double getuTotFle() {
        return uTotFle;
    }

    public void setuTotFle(Double uTotFle) {
        this.uTotFle = uTotFle;
    }

    public String getuHoraIni() {
        return uHoraIni;
    }

    public void setuHoraIni(String uHoraIni) {
        this.uHoraIni = uHoraIni;
    }

    public String getuHoraFin() {
        return uHoraFin;
    }

    public void setuHoraFin(String uHoraFin) {
        this.uHoraFin = uHoraFin;
    }

    public Double getuPesoBruto() {
        return uPesoBruto;
    }

    public void setuPesoBruto(Double uPesoBruto) {
        this.uPesoBruto = uPesoBruto;
    }

    public String getuAutPrecio() {
        return uAutPrecio;
    }

    public void setuAutPrecio(String uAutPrecio) {
        this.uAutPrecio = uAutPrecio;
    }

    public String getuTiponota() {
        return uTiponota;
    }

    public void setuTiponota(String uTiponota) {
        this.uTiponota = uTiponota;
    }

    public String getuNunfac() {
        return uNunfac;
    }

    public void setuNunfac(String uNunfac) {
        this.uNunfac = uNunfac;
    }

    public String getuFechaEntregaPro() {
        return uFechaEntregaPro;
    }

    public void setuFechaEntregaPro(String uFechaEntregaPro) {
        this.uFechaEntregaPro = uFechaEntregaPro;
    }

    public String getuNumFacImp() {
        return uNumFacImp;
    }

    public void setuNumFacImp(String uNumFacImp) {
        this.uNumFacImp = uNumFacImp;
    }

    public String getuTranspImp() {
        return uTranspImp;
    }

    public void setuTranspImp(String uTranspImp) {
        this.uTranspImp = uTranspImp;
    }

    public Double getuTiempoEstimado() {
        return uTiempoEstimado;
    }

    public void setuTiempoEstimado(Double uTiempoEstimado) {
        this.uTiempoEstimado = uTiempoEstimado;
    }

    public String getuFecIni() {
        return uFecIni;
    }

    public void setuFecIni(String uFecIni) {
        this.uFecIni = uFecIni;
    }

    public String getuFecFin() {
        return uFecFin;
    }

    public void setuFecFin(String uFecFin) {
        this.uFecFin = uFecFin;
    }

    public String getuIvcdone() {
        return uIvcdone;
    }

    public void setuIvcdone(String uIvcdone) {
        this.uIvcdone = uIvcdone;
    }

    public String getuVendedor2() {
        return uVendedor2;
    }

    public void setuVendedor2(String uVendedor2) {
        this.uVendedor2 = uVendedor2;
    }

    public String getuDifcode() {
        return uDifcode;
    }

    public void setuDifcode(String uDifcode) {
        this.uDifcode = uDifcode;
    }

    public String getuOk1Ivapa() {
        return uOk1Ivapa;
    }

    public void setuOk1Ivapa(String uOk1Ivapa) {
        this.uOk1Ivapa = uOk1Ivapa;
    }

    public String getuMotDevol() {
        return uMotDevol;
    }

    public void setuMotDevol(String uMotDevol) {
        this.uMotDevol = uMotDevol;
    }

    public String getuFechaPago() {
        return uFechaPago;
    }

    public void setuFechaPago(String uFechaPago) {
        this.uFechaPago = uFechaPago;
    }

    public String getuAntCancelado() {
        return uAntCancelado;
    }

    public void setuAntCancelado(String uAntCancelado) {
        this.uAntCancelado = uAntCancelado;
    }

    public String getuImpCancelado() {
        return uImpCancelado;
    }

    public void setuImpCancelado(String uImpCancelado) {
        this.uImpCancelado = uImpCancelado;
    }

    public String getuTipoEmpaque() {
        return uTipoEmpaque;
    }

    public void setuTipoEmpaque(String uTipoEmpaque) {
        this.uTipoEmpaque = uTipoEmpaque;
    }

    public Double getuVrAnticipo() {
        return uVrAnticipo;
    }

    public void setuVrAnticipo(Double uVrAnticipo) {
        this.uVrAnticipo = uVrAnticipo;
    }

    public Double getuVrTotal() {
        return uVrTotal;
    }

    public void setuVrTotal(Double uVrTotal) {
        this.uVrTotal = uVrTotal;
    }

    public Double getuVrImpuesto() {
        return uVrImpuesto;
    }

    public void setuVrImpuesto(Double uVrImpuesto) {
        this.uVrImpuesto = uVrImpuesto;
    }

    public String getuObservacion() {
        return uObservacion;
    }

    public void setuObservacion(String uObservacion) {
        this.uObservacion = uObservacion;
    }

    public Double getuVrDeclarado() {
        return uVrDeclarado;
    }

    public void setuVrDeclarado(Double uVrDeclarado) {
        this.uVrDeclarado = uVrDeclarado;
    }

    public String getuPuertoEmb() {
        return uPuertoEmb;
    }

    public void setuPuertoEmb(String uPuertoEmb) {
        this.uPuertoEmb = uPuertoEmb;
    }

    public String getuNaviera() {
        return uNaviera;
    }

    public void setuNaviera(String uNaviera) {
        this.uNaviera = uNaviera;
    }

    public String getuTranspTerr() {
        return uTranspTerr;
    }

    public void setuTranspTerr(String uTranspTerr) {
        this.uTranspTerr = uTranspTerr;
    }

    public String getuAgenteAdu() {
        return uAgenteAdu;
    }

    public void setuAgenteAdu(String uAgenteAdu) {
        this.uAgenteAdu = uAgenteAdu;
    }

    public String getuAlmacDes() {
        return uAlmacDes;
    }

    public void setuAlmacDes(String uAlmacDes) {
        this.uAlmacDes = uAlmacDes;
    }

    public String getuGuid() {
        return uGuid;
    }

    public void setuGuid(String uGuid) {
        this.uGuid = uGuid;
    }

    public String getuBpvNcon2() {
        return uBpvNcon2;
    }

    public void setuBpvNcon2(String uBpvNcon2) {
        this.uBpvNcon2 = uBpvNcon2;
    }

    public String getuBpvSeri() {
        return uBpvSeri;
    }

    public void setuBpvSeri(String uBpvSeri) {
        this.uBpvSeri = uBpvSeri;
    }

    public String getuBpvTran() {
        return uBpvTran;
    }

    public void setuBpvTran(String uBpvTran) {
        this.uBpvTran = uBpvTran;
    }

    public String getuBpvFafe() {
        return uBpvFafe;
    }

    public void setuBpvFafe(String uBpvFafe) {
        this.uBpvFafe = uBpvFafe;
    }

    public String getuBpvComp() {
        return uBpvComp;
    }

    public void setuBpvComp(String uBpvComp) {
        this.uBpvComp = uBpvComp;
    }

    public String getuBpvTdoc() {
        return uBpvTdoc;
    }

    public void setuBpvTdoc(String uBpvTdoc) {
        this.uBpvTdoc = uBpvTdoc;
    }

    public String getuBpvNimp() {
        return uBpvNimp;
    }

    public void setuBpvNimp(String uBpvNimp) {
        this.uBpvNimp = uBpvNimp;
    }

    public String getuBpvNumexp() {
        return uBpvNumexp;
    }

    public void setuBpvNumexp(String uBpvNumexp) {
        this.uBpvNumexp = uBpvNumexp;
    }

    public String getuBpvNcon() {
        return uBpvNcon;
    }

    public void setuBpvNcon(String uBpvNcon) {
        this.uBpvNcon = uBpvNcon;
    }

    public String getuMotivo() {
        return uMotivo;
    }

    public void setuMotivo(String uMotivo) {
        this.uMotivo = uMotivo;
    }

    public String getuEstadoPed() {
        return uEstadoPed;
    }

    public void setuEstadoPed(String uEstadoPed) {
        this.uEstadoPed = uEstadoPed;
    }

    public String getuAutorret() {
        return uAutorret;
    }

    public void setuAutorret(String uAutorret) {
        this.uAutorret = uAutorret;
    }

    public String getuRetefue() {
        return uRetefue;
    }

    public void setuRetefue(String uRetefue) {
        this.uRetefue = uRetefue;
    }

    public String getuReteica() {
        return uReteica;
    }

    public void setuReteica(String uReteica) {
        this.uReteica = uReteica;
    }

    public String getuNwrPics() {
        return uNwrPics;
    }

    public void setuNwrPics(String uNwrPics) {
        this.uNwrPics = uNwrPics;
    }

    public String getuNwrBret() {
        return uNwrBret;
    }

    public void setuNwrBret(String uNwrBret) {
        this.uNwrBret = uNwrBret;
    }

    public Integer getuNwrPaut() {
        return uNwrPaut;
    }

    public void setuNwrPaut(Integer uNwrPaut) {
        this.uNwrPaut = uNwrPaut;
    }

    public String getuNwrNote() {
        return uNwrNote;
    }

    public void setuNwrNote(String uNwrNote) {
        this.uNwrNote = uNwrNote;
    }

    public String getuNwrTag() {
        return uNwrTag;
    }

    public void setuNwrTag(String uNwrTag) {
        this.uNwrTag = uNwrTag;
    }

    public Double getuNwrFrgt() {
        return uNwrFrgt;
    }

    public void setuNwrFrgt(Double uNwrFrgt) {
        this.uNwrFrgt = uNwrFrgt;
    }

    public String getuNwrNorm() {
        return uNwrNorm;
    }

    public void setuNwrNorm(String uNwrNorm) {
        this.uNwrNorm = uNwrNorm;
    }

    public String getuTypeexped() {
        return uTypeexped;
    }

    public void setuTypeexped(String uTypeexped) {
        this.uTypeexped = uTypeexped;
    }

    public String getuNwrManifest() {
        return uNwrManifest;
    }

    public void setuNwrManifest(String uNwrManifest) {
        this.uNwrManifest = uNwrManifest;
    }

    public String getuEmpacador() {
        return uEmpacador;
    }

    public void setuEmpacador(String uEmpacador) {
        this.uEmpacador = uEmpacador;
    }

    public String getuHoraIniEmp() {
        return uHoraIniEmp;
    }

    public void setuHoraIniEmp(String uHoraIniEmp) {
        this.uHoraIniEmp = uHoraIniEmp;
    }

    public String getuHoraFinEmp() {
        return uHoraFinEmp;
    }

    public void setuHoraFinEmp(String uHoraFinEmp) {
        this.uHoraFinEmp = uHoraFinEmp;
    }

    public String getuAlist() {
        return uAlist;
    }

    public void setuAlist(String uAlist) {
        this.uAlist = uAlist;
    }

    public String getuFecIniEmp() {
        return uFecIniEmp;
    }

    public void setuFecIniEmp(String uFecIniEmp) {
        this.uFecIniEmp = uFecIniEmp;
    }

    public String getuFecFinEmp() {
        return uFecFinEmp;
    }

    public void setuFecFinEmp(String uFecFinEmp) {
        this.uFecFinEmp = uFecFinEmp;
    }

    public String getuOk1Ifrs() {
        return uOk1Ifrs;
    }

    public void setuOk1Ifrs(String uOk1Ifrs) {
        this.uOk1Ifrs = uOk1Ifrs;
    }

    public Double getuTotFleClie() {
        return uTotFleClie;
    }

    public void setuTotFleClie(Double uTotFleClie) {
        this.uTotFleClie = uTotFleClie;
    }

    public String getuShipping() {
        return uShipping;
    }

    public void setuShipping(String uShipping) {
        this.uShipping = uShipping;
    }

    public String getuEsindep() {
        return uEsindep;
    }

    public void setuEsindep(String uEsindep) {
        this.uEsindep = uEsindep;
    }

    public String getuDocentryleg() {
        return uDocentryleg;
    }

    public void setuDocentryleg(String uDocentryleg) {
        this.uDocentryleg = uDocentryleg;
    }

    public String getuIdlineleg() {
        return uIdlineleg;
    }

    public void setuIdlineleg(String uIdlineleg) {
        this.uIdlineleg = uIdlineleg;
    }

    public String getuSerieleg() {
        return uSerieleg;
    }

    public void setuSerieleg(String uSerieleg) {
        this.uSerieleg = uSerieleg;
    }

    public String getuFechaArriboCedi() {
        return uFechaArriboCedi;
    }

    public void setuFechaArriboCedi(String uFechaArriboCedi) {
        this.uFechaArriboCedi = uFechaArriboCedi;
    }

    public String getuCatret() {
        return uCatret;
    }

    public void setuCatret(String uCatret) {
        this.uCatret = uCatret;
    }

    public String getuBodega() {
        return uBodega;
    }

    public void setuBodega(String uBodega) {
        this.uBodega = uBodega;
    }

    public Double getuAiuAdmin() {
        return uAiuAdmin;
    }

    public void setuAiuAdmin(Double uAiuAdmin) {
        this.uAiuAdmin = uAiuAdmin;
    }

    public Double getuAiuImpre() {
        return uAiuImpre;
    }

    public void setuAiuImpre(Double uAiuImpre) {
        this.uAiuImpre = uAiuImpre;
    }

    public Double getuAiuUtil() {
        return uAiuUtil;
    }

    public void setuAiuUtil(Double uAiuUtil) {
        this.uAiuUtil = uAiuUtil;
    }

    public String getuFEnDocFin() {
        return uFEnDocFin;
    }

    public void setuFEnDocFin(String uFEnDocFin) {
        this.uFEnDocFin = uFEnDocFin;
    }

    public String getuFPagoFinal() {
        return uFPagoFinal;
    }

    public void setuFPagoFinal(String uFPagoFinal) {
        this.uFPagoFinal = uFPagoFinal;
    }

    public Double getuVlrPagoFinal() {
        return uVlrPagoFinal;
    }

    public void setuVlrPagoFinal(Double uVlrPagoFinal) {
        this.uVlrPagoFinal = uVlrPagoFinal;
    }

    public String getuCantConte() {
        return uCantConte;
    }

    public void setuCantConte(String uCantConte) {
        this.uCantConte = uCantConte;
    }

    public String getuAddinfaelectronicaTipondFe() {
        return uAddinfaelectronicaTipondFe;
    }

    public void setuAddinfaelectronicaTipondFe(String uAddinfaelectronicaTipondFe) {
        this.uAddinfaelectronicaTipondFe = uAddinfaelectronicaTipondFe;
    }

    public String getuTiponccFe() {
        return uTiponccFe;
    }

    public void setuTiponccFe(String uTiponccFe) {
        this.uTiponccFe = uTiponccFe;
    }

    public String getuFechadoccont() {
        return uFechadoccont;
    }

    public void setuFechadoccont(String uFechadoccont) {
        this.uFechadoccont = uFechadoccont;
    }

    public String getuFeFechatc() {
        return uFeFechatc;
    }

    public void setuFeFechatc(String uFeFechatc) {
        this.uFeFechatc = uFeFechatc;
    }

    public String getuDocCrFe() {
        return uDocCrFe;
    }

    public void setuDocCrFe(String uDocCrFe) {
        this.uDocCrFe = uDocCrFe;
    }

    public String getuCufe() {
        return uCufe;
    }

    public void setuCufe(String uCufe) {
        this.uCufe = uCufe;
    }

    public String getuDocadicionales() {
        return uDocadicionales;
    }

    public void setuDocadicionales(String uDocadicionales) {
        this.uDocadicionales = uDocadicionales;
    }

    public String getuAddinfeLinkfe() {
        return uAddinfeLinkfe;
    }

    public void setuAddinfeLinkfe(String uAddinfeLinkfe) {
        this.uAddinfeLinkfe = uAddinfeLinkfe;
    }

    public String getuAddinfaFvserie() {
        return uAddinfaFvserie;
    }

    public void setuAddinfaFvserie(String uAddinfaFvserie) {
        this.uAddinfaFvserie = uAddinfaFvserie;
    }

    public String getuAddinfaFvnum() {
        return uAddinfaFvnum;
    }

    public void setuAddinfaFvnum(String uAddinfaFvnum) {
        this.uAddinfaFvnum = uAddinfaFvnum;
    }

    public String getuNrofaccontinfe() {
        return uNrofaccontinfe;
    }

    public void setuNrofaccontinfe(String uNrofaccontinfe) {
        this.uNrofaccontinfe = uNrofaccontinfe;
    }

    public String getuTipoemisionfe() {
        return uTipoemisionfe;
    }

    public void setuTipoemisionfe(String uTipoemisionfe) {
        this.uTipoemisionfe = uTipoemisionfe;
    }

    public String getuCodigoqr() {
        return uCodigoqr;
    }

    public void setuCodigoqr(String uCodigoqr) {
        this.uCodigoqr = uCodigoqr;
    }

    public String getuSellodigital() {
        return uSellodigital;
    }

    public void setuSellodigital(String uSellodigital) {
        this.uSellodigital = uSellodigital;
    }

    public String getuTipoNcvFe() {
        return uTipoNcvFe;
    }

    public void setuTipoNcvFe(String uTipoNcvFe) {
        this.uTipoNcvFe = uTipoNcvFe;
    }

    public String getuTipoNdvFe() {
        return uTipoNdvFe;
    }

    public void setuTipoNdvFe(String uTipoNdvFe) {
        this.uTipoNdvFe = uTipoNdvFe;
    }

    public String getuCbm() {
        return uCbm;
    }

    public void setuCbm(String uCbm) {
        this.uCbm = uCbm;
    }

    public String getuCondentregaFe() {
        return uCondentregaFe;
    }

    public void setuCondentregaFe(String uCondentregaFe) {
        this.uCondentregaFe = uCondentregaFe;
    }

    public String getuMediopg() {
        return uMediopg;
    }

    public void setuMediopg(String uMediopg) {
        this.uMediopg = uMediopg;
    }

    public Integer getuPlantilla() {
        return uPlantilla;
    }

    public void setuPlantilla(Integer uPlantilla) {
        this.uPlantilla = uPlantilla;
    }

    public String getuDespachoContado() {
        return uDespachoContado;
    }

    public void setuDespachoContado(String uDespachoContado) {
        this.uDespachoContado = uDespachoContado;
    }

    public Double getuTotalimpoco() {
        return uTotalimpoco;
    }

    public void setuTotalimpoco(Double uTotalimpoco) {
        this.uTotalimpoco = uTotalimpoco;
    }

    public String getuSerial() {
        return uSerial;
    }

    public void setuSerial(String uSerial) {
        this.uSerial = uSerial;
    }

    public String getuEstadoWms() {
        return uEstadoWms;
    }

    public void setuEstadoWms(String uEstadoWms) {
        this.uEstadoWms = uEstadoWms;
    }

    public String getuIncoterms() {
        return uIncoterms;
    }

    public void setuIncoterms(String uIncoterms) {
        this.uIncoterms = uIncoterms;
    }

    public String getuOk1FaExport() {
        return uOk1FaExport;
    }

    public void setuOk1FaExport(String uOk1FaExport) {
        this.uOk1FaExport = uOk1FaExport;
    }

    public String getuTipofacturacion() {
        return uTipofacturacion;
    }

    public void setuTipofacturacion(String uTipofacturacion) {
        this.uTipofacturacion = uTipofacturacion;
    }

    public String getuTipomandato() {
        return uTipomandato;
    }

    public void setuTipomandato(String uTipomandato) {
        this.uTipomandato = uTipomandato;
    }

    public String getuTipotransporte() {
        return uTipotransporte;
    }

    public void setuTipotransporte(String uTipotransporte) {
        this.uTipotransporte = uTipotransporte;
    }

    public String getuFCargaLista() {
        return uFCargaLista;
    }

    public void setuFCargaLista(String uFCargaLista) {
        this.uFCargaLista = uFCargaLista;
    }

    public String getuTiempoTransito() {
        return uTiempoTransito;
    }

    public void setuTiempoTransito(String uTiempoTransito) {
        this.uTiempoTransito = uTiempoTransito;
    }

    public String getuFSalidaPuerto() {
        return uFSalidaPuerto;
    }

    public void setuFSalidaPuerto(String uFSalidaPuerto) {
        this.uFSalidaPuerto = uFSalidaPuerto;
    }

    public String getuTiempoPuerto() {
        return uTiempoPuerto;
    }

    public void setuTiempoPuerto(String uTiempoPuerto) {
        this.uTiempoPuerto = uTiempoPuerto;
    }

    public String getuTipoCarga() {
        return uTipoCarga;
    }

    public void setuTipoCarga(String uTipoCarga) {
        this.uTipoCarga = uTipoCarga;
    }

    public String getuTiempoEntComex() {
        return uTiempoEntComex;
    }

    public void setuTiempoEntComex(String uTiempoEntComex) {
        this.uTiempoEntComex = uTiempoEntComex;
    }

    public String getuFBooking() {
        return uFBooking;
    }

    public void setuFBooking(String uFBooking) {
        this.uFBooking = uFBooking;
    }

    public String getuTiempoEspBooking() {
        return uTiempoEspBooking;
    }

    public void setuTiempoEspBooking(String uTiempoEspBooking) {
        this.uTiempoEspBooking = uTiempoEspBooking;
    }

    public String getuFEstimEmbarque() {
        return uFEstimEmbarque;
    }

    public void setuFEstimEmbarque(String uFEstimEmbarque) {
        this.uFEstimEmbarque = uFEstimEmbarque;
    }

    public String getuFCuttOff() {
        return uFCuttOff;
    }

    public void setuFCuttOff(String uFCuttOff) {
        this.uFCuttOff = uFCuttOff;
    }

    public String getuFRecDocFinal() {
        return uFRecDocFinal;
    }

    public void setuFRecDocFinal(String uFRecDocFinal) {
        this.uFRecDocFinal = uFRecDocFinal;
    }

    public String getuEmisionBl() {
        return uEmisionBl;
    }

    public void setuEmisionBl(String uEmisionBl) {
        this.uEmisionBl = uEmisionBl;
    }

    public String getuInspeccion() {
        return uInspeccion;
    }

    public void setuInspeccion(String uInspeccion) {
        this.uInspeccion = uInspeccion;
    }

    public String getuFArriboCediEst() {
        return uFArriboCediEst;
    }

    public void setuFArriboCediEst(String uFArriboCediEst) {
        this.uFArriboCediEst = uFArriboCediEst;
    }

    public String getuNotificationbl() {
        return uNotificationbl;
    }

    public void setuNotificationbl(String uNotificationbl) {
        this.uNotificationbl = uNotificationbl;
    }

    public String getuFEstimPago() {
        return uFEstimPago;
    }

    public void setuFEstimPago(String uFEstimPago) {
        this.uFEstimPago = uFEstimPago;
    }

    public String getuLiquidComex() {
        return uLiquidComex;
    }

    public void setuLiquidComex(String uLiquidComex) {
        this.uLiquidComex = uLiquidComex;
    }

    public String getuTipoCargaPro() {
        return uTipoCargaPro;
    }

    public void setuTipoCargaPro(String uTipoCargaPro) {
        this.uTipoCargaPro = uTipoCargaPro;
    }

    public Double getuCantCarga() {
        return uCantCarga;
    }

    public void setuCantCarga(Double uCantCarga) {
        this.uCantCarga = uCantCarga;
    }

    public String getuBodegadestino() {
        return uBodegadestino;
    }

    public void setuBodegadestino(String uBodegadestino) {
        this.uBodegadestino = uBodegadestino;
    }

    public String getuTraslado() {
        return uTraslado;
    }

    public void setuTraslado(String uTraslado) {
        this.uTraslado = uTraslado;
    }

    public String getuPrjctt() {
        return uPrjctt;
    }

    public void setuPrjctt(String uPrjctt) {
        this.uPrjctt = uPrjctt;
    }

    public String getuDim1t() {
        return uDim1t;
    }

    public void setuDim1t(String uDim1t) {
        this.uDim1t = uDim1t;
    }

    public String getuDim2t() {
        return uDim2t;
    }

    public void setuDim2t(String uDim2t) {
        this.uDim2t = uDim2t;
    }

    public String getuDim3t() {
        return uDim3t;
    }

    public void setuDim3t(String uDim3t) {
        this.uDim3t = uDim3t;
    }

    public String getuDim4t() {
        return uDim4t;
    }

    public void setuDim4t(String uDim4t) {
        this.uDim4t = uDim4t;
    }

    public String getuDim5t() {
        return uDim5t;
    }

    public void setuDim5t(String uDim5t) {
        this.uDim5t = uDim5t;
    }

    public String getuSemanaCarga() {
        return uSemanaCarga;
    }

    public void setuSemanaCarga(String uSemanaCarga) {
        this.uSemanaCarga = uSemanaCarga;
    }

    public String getuMesCarga() {
        return uMesCarga;
    }

    public void setuMesCarga(String uMesCarga) {
        this.uMesCarga = uMesCarga;
    }

    public String getuFEntCarga() {
        return uFEntCarga;
    }

    public void setuFEntCarga(String uFEntCarga) {
        this.uFEntCarga = uFEntCarga;
    }

    public String getuFLiquidacion() {
        return uFLiquidacion;
    }

    public void setuFLiquidacion(String uFLiquidacion) {
        this.uFLiquidacion = uFLiquidacion;
    }

    public String getuFLibBl() {
        return uFLibBl;
    }

    public void setuFLibBl(String uFLibBl) {
        this.uFLibBl = uFLibBl;
    }

    public String getuFEntregaProv() {
        return uFEntregaProv;
    }

    public void setuFEntregaProv(String uFEntregaProv) {
        this.uFEntregaProv = uFEntregaProv;
    }

    public String getuConductor() {
        return uConductor;
    }

    public void setuConductor(String uConductor) {
        this.uConductor = uConductor;
    }

    public String getuCedulaCon() {
        return uCedulaCon;
    }

    public void setuCedulaCon(String uCedulaCon) {
        this.uCedulaCon = uCedulaCon;
    }

    public String getuPlaca() {
        return uPlaca;
    }

    public void setuPlaca(String uPlaca) {
        this.uPlaca = uPlaca;
    }

    public String getuContenedor() {
        return uContenedor;
    }

    public void setuContenedor(String uContenedor) {
        this.uContenedor = uContenedor;
    }

    public String getuPrecinto() {
        return uPrecinto;
    }

    public void setuPrecinto(String uPrecinto) {
        this.uPrecinto = uPrecinto;
    }

    public String getuEnviarDatosCon() {
        return uEnviarDatosCon;
    }

    public void setuEnviarDatosCon(String uEnviarDatosCon) {
        this.uEnviarDatosCon = uEnviarDatosCon;
    }

    public String getuFormageneracion() {
        return uFormageneracion;
    }

    public void setuFormageneracion(String uFormageneracion) {
        this.uFormageneracion = uFormageneracion;
    }

    public String getuConceptocorreccionnc() {
        return uConceptocorreccionnc;
    }

    public void setuConceptocorreccionnc(String uConceptocorreccionnc) {
        this.uConceptocorreccionnc = uConceptocorreccionnc;
    }

    public String getuSaneamiento() {
        return uSaneamiento;
    }

    public void setuSaneamiento(String uSaneamiento) {
        this.uSaneamiento = uSaneamiento;
    }

    public String getuMesesdiferido() {
        return uMesesdiferido;
    }

    public void setuMesesdiferido(String uMesesdiferido) {
        this.uMesesdiferido = uMesesdiferido;
    }

    public Double getuVrAnticipo2() {
        return uVrAnticipo2;
    }

    public void setuVrAnticipo2(Double uVrAnticipo2) {
        this.uVrAnticipo2 = uVrAnticipo2;
    }

    public String getuPeriodoasociadoFe() {
        return uPeriodoasociadoFe;
    }

    public void setuPeriodoasociadoFe(String uPeriodoasociadoFe) {
        this.uPeriodoasociadoFe = uPeriodoasociadoFe;
    }

    public String getuMetodopweb() {
        return uMetodopweb;
    }

    public void setuMetodopweb(String uMetodopweb) {
        this.uMetodopweb = uMetodopweb;
    }

    public String getuNoconreq() {
        return uNoconreq;
    }

    public void setuNoconreq(String uNoconreq) {
        this.uNoconreq = uNoconreq;
    }

    public String getuNumreqweb() {
        return uNumreqweb;
    }

    public void setuNumreqweb(String uNumreqweb) {
        this.uNumreqweb = uNumreqweb;
    }

    public String getuSplcode() {
        return uSplcode;
    }

    public void setuSplcode(String uSplcode) {
        this.uSplcode = uSplcode;
    }

    public String getuOk1Descreq() {
        return uOk1Descreq;
    }

    public void setuOk1Descreq(String uOk1Descreq) {
        this.uOk1Descreq = uOk1Descreq;
    }

    public String getuElectronicreception() {
        return uElectronicreception;
    }

    public void setuElectronicreception(String uElectronicreception) {
        this.uElectronicreception = uElectronicreception;
    }

    public String getuRutapdf() {
        return uRutapdf;
    }

    public void setuRutapdf(String uRutapdf) {
        this.uRutapdf = uRutapdf;
    }

    public String getuUrlViewer() {
        return uUrlViewer;
    }

    public void setuUrlViewer(String uUrlViewer) {
        this.uUrlViewer = uUrlViewer;
    }

    public List<String> getDocumentApprovalrequests() {
        return documentApprovalrequests;
    }

    public void setDocumentApprovalrequests(List<String> documentApprovalrequests) {
        this.documentApprovalrequests = documentApprovalrequests;
    }

    public List<DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    public List<String> getElectronicProtocols() {
        return electronicProtocols;
    }

    public void setElectronicProtocols(List<String> electronicProtocols) {
        this.electronicProtocols = electronicProtocols;
    }

    public Object getTaxExtension() {
        return taxExtension;
    }

    public void setTaxExtension(Object taxExtension) {
        this.taxExtension = taxExtension;
    }

    public Object getAddressExtension() {
        return addressExtension;
    }

    public void setAddressExtension(Object addressExtension) {
        this.addressExtension = addressExtension;
    }

    public List<String> getDocumentReferences() {
        return documentReferences;
    }

    public void setDocumentReferences(List<String> documentReferences) {
        this.documentReferences = documentReferences;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentLine implements Serializable {
        @JsonProperty("LineNum")
        protected Integer lineNum;
        @JsonProperty("ItemCode")
        protected String itemCode;
        @JsonProperty("ItemDescription")
        protected String itemDescription;
        @JsonProperty("Quantity")
        protected Double quantity;
        @JsonProperty("ShipDate")
        protected String shipDate;
        @JsonProperty("Price")
        protected Double price;
        @JsonProperty("PriceAfterVAT")
        protected Double priceAfterVAT;
        @JsonProperty("Currency")
        protected String currency;
        @JsonProperty("Rate")
        protected Double rate;
        @JsonProperty("DiscountPercent")
        protected Double discountPercent;
        @JsonProperty("VendorNum")
        protected String vendorNum;
        @JsonProperty("SerialNum")
        protected String serialNum;
        @JsonProperty("WarehouseCode")
        protected String warehouseCode;
        @JsonProperty("SalesPersonCode")
        protected Integer salesPersonCode;
        @JsonProperty("CommisionPercent")
        protected Double commisionPercent;
        @JsonProperty("TreeType")
        protected String treeType;
        @JsonProperty("AccountCode")
        protected String accountCode;
        @JsonProperty("UseBaseUnits")
        protected String useBaseUnits;
        @JsonProperty("SupplierCatNum")
        protected String supplierCatNum;
        @JsonProperty("CostingCode")
        protected String costingCode;
        @JsonProperty("ProjectCode")
        protected String projectCode;
        @JsonProperty("BarCode")
        protected String barCode;
        @JsonProperty("VatGroup")
        protected String vatGroup;
        @JsonProperty("Height1")
        protected Double height1;
        @JsonProperty("Hight1Unit")
        protected String hight1Unit;
        @JsonProperty("Height2")
        protected Double height2;
        @JsonProperty("Height2Unit")
        protected String height2Unit;
        @JsonProperty("Lengh1")
        protected Double lengh1;
        @JsonProperty("Lengh1Unit")
        protected String lengh1Unit;
        @JsonProperty("Lengh2")
        protected Double lengh2;
        @JsonProperty("Lengh2Unit")
        protected String lengh2Unit;
        @JsonProperty("Weight1")
        protected Double weight1;
        @JsonProperty("Weight1Unit")
        protected String weight1Unit;
        @JsonProperty("Weight2")
        protected Double weight2;
        @JsonProperty("Weight2Unit")
        protected String weight2Unit;
        @JsonProperty("Factor1")
        protected Double factor1;
        @JsonProperty("Factor2")
        protected Double factor2;
        @JsonProperty("Factor3")
        protected Double factor3;
        @JsonProperty("Factor4")
        protected Double factor4;
        @JsonProperty("BaseType")
        protected Integer baseType;
        @JsonProperty("BaseEntry")
        protected String baseEntry;
        @JsonProperty("BaseLine")
        protected String baseLine;
        @JsonProperty("Volume")
        protected Double volume;
        @JsonProperty("VolumeUnit")
        protected String volumeUnit;
        @JsonProperty("Width1")
        protected Double width1;
        @JsonProperty("Width1Unit")
        protected String width1Unit;
        @JsonProperty("Width2")
        protected Double width2;
        @JsonProperty("Width2Unit")
        protected String width2Unit;
        @JsonProperty("Address")
        protected String address;
        @JsonProperty("TaxCode")
        protected String taxCode;
        @JsonProperty("TaxType")
        protected String taxType;
        @JsonProperty("TaxLiable")
        protected String taxLiable;
        @JsonProperty("PickStatus")
        protected String pickStatus;
        @JsonProperty("PickQuantity")
        protected Double pickQuantity;
        @JsonProperty("PickListIdNumber")
        protected String pickListIdNumber;
        @JsonProperty("OriginalItem")
        protected String originalItem;
        @JsonProperty("BackOrder")
        protected String backOrder;
        @JsonProperty("FreeText")
        protected String freeText;
        @JsonProperty("ShippingMethod")
        protected Integer shippingMethod;
        @JsonProperty("POTargetNum")
        protected String pOTargetNum;
        @JsonProperty("POTargetEntry")
        protected String pOTargetEntry;
        @JsonProperty("POTargetRowNum")
        protected String pOTargetRowNum;
        @JsonProperty("CorrectionInvoiceItem")
        protected String correctionInvoiceItem;
        @JsonProperty("CorrInvAmountToStock")
        protected Double corrInvAmountToStock;
        @JsonProperty("CorrInvAmountToDiffAcct")
        protected Double corrInvAmountToDiffAcct;
        @JsonProperty("AppliedTax")
        protected Double appliedTax;
        @JsonProperty("AppliedTaxFC")
        protected Double appliedTaxFC;
        @JsonProperty("AppliedTaxSC")
        protected Double appliedTaxSC;
        @JsonProperty("WTLiable")
        protected String wTLiable;
        @JsonProperty("DeferredTax")
        protected String deferredTax;
        @JsonProperty("EqualizationTaxPercent")
        protected Double equalizationTaxPercent;
        @JsonProperty("TotalEqualizationTax")
        protected Double totalEqualizationTax;
        @JsonProperty("TotalEqualizationTaxFC")
        protected Double totalEqualizationTaxFC;
        @JsonProperty("TotalEqualizationTaxSC")
        protected Double totalEqualizationTaxSC;
        @JsonProperty("NetTaxAmount")
        protected Double netTaxAmount;
        @JsonProperty("NetTaxAmountFC")
        protected Double netTaxAmountFC;
        @JsonProperty("NetTaxAmountSC")
        protected Double netTaxAmountSC;
        @JsonProperty("MeasureUnit")
        protected String measureUnit;
        @JsonProperty("UnitsOfMeasurment")
        protected Double unitsOfMeasurment;
        @JsonProperty("LineTotal")
        protected Double lineTotal;
        @JsonProperty("TaxPercentagePerRow")
        protected Double taxPercentagePerRow;
        @JsonProperty("TaxTotal")
        protected Double taxTotal;
        @JsonProperty("ConsumerSalesForecast")
        protected String consumerSalesForecast;
        @JsonProperty("ExciseAmount")
        protected Double exciseAmount;
        @JsonProperty("TaxPerUnit")
        protected Double taxPerUnit;
        @JsonProperty("TotalInclTax")
        protected Double totalInclTax;
        @JsonProperty("CountryOrg")
        protected String countryOrg;
        @JsonProperty("SWW")
        protected String sWW;
        @JsonProperty("TransactionType")
        protected String transactionType;
        @JsonProperty("DistributeExpense")
        protected String distributeExpense;
        @JsonProperty("RowTotalFC")
        protected Double rowTotalFC;
        @JsonProperty("RowTotalSC")
        protected Double rowTotalSC;
        @JsonProperty("LastBuyInmPrice")
        protected Double lastBuyInmPrice;
        @JsonProperty("LastBuyDistributeSumFc")
        protected Double lastBuyDistributeSumFc;
        @JsonProperty("LastBuyDistributeSumSc")
        protected Double lastBuyDistributeSumSc;
        @JsonProperty("LastBuyDistributeSum")
        protected Double lastBuyDistributeSum;
        @JsonProperty("StockDistributesumForeign")
        protected Double stockDistributesumForeign;
        @JsonProperty("StockDistributesumSystem")
        protected Double stockDistributesumSystem;
        @JsonProperty("StockDistributesum")
        protected Double stockDistributesum;
        @JsonProperty("StockInmPrice")
        protected Double stockInmPrice;
        @JsonProperty("PickStatusEx")
        protected String pickStatusEx;
        @JsonProperty("TaxBeforeDPM")
        protected Double taxBeforeDPM;
        @JsonProperty("TaxBeforeDPMFC")
        protected Double taxBeforeDPMFC;
        @JsonProperty("TaxBeforeDPMSC")
        protected Double taxBeforeDPMSC;
        @JsonProperty("CFOPCode")
        protected String cFOPCode;
        @JsonProperty("CSTCode")
        protected String cSTCode;
        @JsonProperty("Usage")
        protected String usage;
        @JsonProperty("TaxOnly")
        protected String taxOnly;
        @JsonProperty("VisualOrder")
        protected Integer visualOrder;
        @JsonProperty("BaseOpenQuantity")
        protected Double baseOpenQuantity;
        @JsonProperty("UnitPrice")
        protected Double unitPrice;
        @JsonProperty("LineStatus")
        protected String lineStatus;
        @JsonProperty("PackageQuantity")
        protected Double packageQuantity;
        @JsonProperty("Text")
        protected String text;
        @JsonProperty("LineType")
        protected String lineType;
        @JsonProperty("COGSCostingCode")
        protected String cOGSCostingCode;
        @JsonProperty("COGSAccountCode")
        protected String cOGSAccountCode;
        @JsonProperty("ChangeAssemlyBoMWarehouse")
        protected String changeAssemlyBoMWarehouse;
        @JsonProperty("GrossBuyPrice")
        protected Double grossBuyPrice;
        @JsonProperty("GrossBase")
        protected String grossBase;
        @JsonProperty("GrossProfitTotalBasePrice")
        protected Double grossProfitTotalBasePrice;
        @JsonProperty("CostingCode2")
        protected String costingCode2;
        @JsonProperty("CostingCode3")
        protected String costingCode3;
        @JsonProperty("CostingCode4")
        protected String costingCode4;
        @JsonProperty("CostingCode5")
        protected String costingCode5;
        @JsonProperty("ItemDetails")
        protected String itemDetails;
        @JsonProperty("LocationCode")
        protected String locationCode;
        @JsonProperty("ActualDeliveryDate")
        protected String actualDeliveryDate;
        @JsonProperty("RemainingOpenQuantity")
        protected Double remainingOpenQuantity;
        @JsonProperty("OpenAmount")
        protected Double openAmount;
        @JsonProperty("OpenAmountFC")
        protected Double openAmountFC;
        @JsonProperty("OpenAmountSC")
        protected Double openAmountSC;
        @JsonProperty("ExLineNo")
        protected String exLineNo;
        @JsonProperty("RequiredDate")
        protected String requiredDate;
        @JsonProperty("RequiredQuantity")
        protected Double requiredQuantity;
        @JsonProperty("COGSCostingCode2")
        protected String cOGSCostingCode2;
        @JsonProperty("COGSCostingCode3")
        protected String cOGSCostingCode3;
        @JsonProperty("COGSCostingCode4")
        protected String cOGSCostingCode4;
        @JsonProperty("COGSCostingCode5")
        protected String cOGSCostingCode5;
        @JsonProperty("CSTforIPI")
        protected String cSTforIPI;
        @JsonProperty("CSTforPIS")
        protected String cSTforPIS;
        @JsonProperty("CSTforCOFINS")
        protected String cSTforCOFINS;
        @JsonProperty("CreditOriginCode")
        protected String creditOriginCode;
        @JsonProperty("WithoutInventoryMovement")
        protected String withoutInventoryMovement;
        @JsonProperty("AgreementNo")
        protected String agreementNo;
        @JsonProperty("AgreementRowNumber")
        protected String agreementRowNumber;
        @JsonProperty("ActualBaseEntry")
        protected String actualBaseEntry;
        @JsonProperty("ActualBaseLine")
        protected String actualBaseLine;
        @JsonProperty("DocEntry")
        protected Integer docEntry;
        @JsonProperty("Surpluses")
        protected Double surpluses;
        @JsonProperty("DefectAndBreakup")
        protected Double defectAndBreakup;
        @JsonProperty("Shortages")
        protected Double shortages;
        @JsonProperty("ConsiderQuantity")
        protected String considerQuantity;
        @JsonProperty("PartialRetirement")
        protected String partialRetirement;
        @JsonProperty("RetirementQuantity")
        protected Double retirementQuantity;
        @JsonProperty("RetirementAPC")
        protected Double retirementAPC;
        @JsonProperty("ThirdParty")
        protected String thirdParty;
        @JsonProperty("PoNum")
        protected String poNum;
        @JsonProperty("PoItmNum")
        protected String poItmNum;
        @JsonProperty("ExpenseType")
        protected String expenseType;
        @JsonProperty("ReceiptNumber")
        protected String receiptNumber;
        @JsonProperty("ExpenseOperationType")
        protected String expenseOperationType;
        @JsonProperty("FederalTaxID")
        protected String federalTaxID;
        @JsonProperty("GrossProfit")
        protected Double grossProfit;
        @JsonProperty("GrossProfitFC")
        protected Double grossProfitFC;
        @JsonProperty("GrossProfitSC")
        protected Double grossProfitSC;
        @JsonProperty("PriceSource")
        protected String priceSource;
        @JsonProperty("StgSeqNum")
        protected String stgSeqNum;
        @JsonProperty("StgEntry")
        protected String stgEntry;
        @JsonProperty("StgDesc")
        protected String stgDesc;
        @JsonProperty("UoMEntry")
        protected Integer uoMEntry;
        @JsonProperty("UoMCode")
        protected String uoMCode;
        @JsonProperty("InventoryQuantity")
        protected Double inventoryQuantity;
        @JsonProperty("RemainingOpenInventoryQuantity")
        protected Double remainingOpenInventoryQuantity;
        @JsonProperty("ParentLineNum")
        protected String parentLineNum;
        @JsonProperty("Incoterms")
        protected Integer incoterms;
        @JsonProperty("TransportMode")
        protected Integer transportMode;
        @JsonProperty("NatureOfTransaction")
        protected String natureOfTransaction;
        @JsonProperty("DestinationCountryForImport")
        protected String destinationCountryForImport;
        @JsonProperty("DestinationRegionForImport")
        protected String destinationRegionForImport;
        @JsonProperty("OriginCountryForExport")
        protected String originCountryForExport;
        @JsonProperty("OriginRegionForExport")
        protected String originRegionForExport;
        @JsonProperty("ItemType")
        protected String itemType;
        @JsonProperty("ChangeInventoryQuantityIndependently")
        protected String changeInventoryQuantityIndependently;
        @JsonProperty("FreeOfChargeBP")
        protected String freeOfChargeBP;
        @JsonProperty("SACEntry")
        protected String sACEntry;
        @JsonProperty("HSNEntry")
        protected String hSNEntry;
        @JsonProperty("GrossPrice")
        protected Double grossPrice;
        @JsonProperty("GrossTotal")
        protected Double grossTotal;
        @JsonProperty("GrossTotalFC")
        protected Double grossTotalFC;
        @JsonProperty("GrossTotalSC")
        protected Double grossTotalSC;
        @JsonProperty("NCMCode")
        protected Integer nCMCode;
        @JsonProperty("NVECode")
        protected String nVECode;
        @JsonProperty("IndEscala")
        protected String indEscala;
        @JsonProperty("CtrSealQty")
        protected Double ctrSealQty;
        @JsonProperty("CNJPMan")
        protected String cNJPMan;
        @JsonProperty("CESTCode")
        protected String cESTCode;
        @JsonProperty("UFFiscalBenefitCode")
        protected String uFFiscalBenefitCode;
        @JsonProperty("ReverseCharge")
        protected String reverseCharge;
        @JsonProperty("OwnerCode")
        protected String ownerCode;
        @JsonProperty("StandardItemIdentification")
        protected Integer standardItemIdentification;
        @JsonProperty("CommodityClassification")
        protected Integer commodityClassification;
        @JsonProperty("WeightOfRecycledPlastic")
        protected Double weightOfRecycledPlastic;
        @JsonProperty("PlasticPackageExemptionReason")
        protected String plasticPackageExemptionReason;
        @JsonProperty("LegalText")
        protected String legalText;
        @JsonProperty("Cig")
        protected String cig;
        @JsonProperty("Cup")
        protected String cup;
        @JsonProperty("UnencumberedReason")
        protected String unencumberedReason;
        @JsonProperty("CUSplit")
        protected String cUSplit;
        @JsonProperty("ListNum")
        protected Integer listNum;
        @JsonProperty("RecognizedTaxCode")
        protected String recognizedTaxCode;
        @JsonProperty("U_PREC_LIS")
        protected Double uPrecLis;
        @JsonProperty("U_DIF_PREC")
        protected Double uDifPrec;
        @JsonProperty("U_COSTOIMP")
        protected String uCostoimp;
        @JsonProperty("U_BANCO")
        protected String uBanco;
        @JsonProperty("U_UBICACION")
        protected String uUbicacion;
        @JsonProperty("U_CHEQUE")
        protected String uCheque;
        @JsonProperty("U_VAL_PRECIO")
        protected String uValPrecio;
        @JsonProperty("U_CAUSAL_DEV")
        protected String uCausalDev;
        @JsonProperty("U_STOCK_ALM")
        protected Double uStockAlm;
        @JsonProperty("U_DISPONIBLE_ALM")
        protected Double uDisponibleAlm;
        @JsonProperty("U_BLD_LyID")
        protected Integer uBldLyid;
        @JsonProperty("U_BLD_NCps")
        protected String uBldNcps;
        @JsonProperty("U_Referencia")
        protected String uReferencia;
        @JsonProperty("U_Diferencia")
        protected String uDiferencia;
        @JsonProperty("U_Precio_Cotizacion")
        protected Double uPrecioCotizacion;
        @JsonProperty("U_IVCDone")
        protected String uIvcdone;
        @JsonProperty("U_NWR_Base")
        protected String uNwrBase;
        @JsonProperty("U_CustDate")
        protected String uCustdate;
        @JsonProperty("U_DocNumBase")
        protected String uDocnumbase;
        @JsonProperty("U_ObjType")
        protected String uObjtype;
        @JsonProperty("U_NWR_QtyAllocated")
        protected Double uNwrQtyallocated;
        @JsonProperty("U_ReclamQty")
        protected Double uReclamqty;
        @JsonProperty("U_QAMark")
        protected String uQamark;
        @JsonProperty("U_IncomingQty")
        protected Double uIncomingqty;
        @JsonProperty("U_NWR_Bin")
        protected String uNwrBin;
        @JsonProperty("U_TransitWHSCode")
        protected String uTransitwhscode;
        @JsonProperty("U_CalcAIU")
        protected String uCalcaiu;
        @JsonProperty("U_RILDone")
        protected String uRildone;
        @JsonProperty("U_valor_ImpoCon")
        protected Double uValorImpocon;
        @JsonProperty("U_Marca")
        protected String uMarca;
        @JsonProperty("U_Modelo")
        protected String uModelo;
        @JsonProperty("U_Location")
        protected String uLocation;
        @JsonProperty("U_mesesDiferidoL")
        protected String uMesesdiferidol;
        @JsonProperty("U_DocumentoEvaluado")
        protected String uDocumentoevaluado;
        @JsonProperty("U_CreateDate")
        protected String uCreatedate;
        @JsonProperty("U_DeliveryDate")
        protected String uDeliverydate;
        @JsonProperty("U_OK1_DescReqL")
        protected String uOk1Descreql;
        @JsonProperty("U_InvoiceNumber")
        protected String uInvoicenumber;
        @JsonProperty("U_AnexoSol")
        protected String uAnexosol;
        @JsonProperty("LineTaxJurisdictions")
        protected List<String> lineTaxJurisdictions;
        @JsonProperty("SerialNumbers")
        protected List<String> serialNumbers;
        @JsonProperty("BatchNumbers")
        protected List<String> batchNumbers;
        @JsonProperty("CCDNumbers")
        protected List<String> cCDNumbers;
        @JsonProperty("DocumentLinesBinAllocations")
        protected List<InventoryGenExitsRestDTO.DocumentLine.DocumentLinesBinAllocation> documentLinesBinAllocations;

        public Integer getLineNum() {
            return lineNum;
        }

        public void setLineNum(Integer lineNum) {
            this.lineNum = lineNum;
        }

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public Double getQuantity() {
            return quantity;
        }

        public void setQuantity(Double quantity) {
            this.quantity = quantity;
        }

        public String getShipDate() {
            return shipDate;
        }

        public void setShipDate(String shipDate) {
            this.shipDate = shipDate;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public Double getPriceAfterVAT() {
            return priceAfterVAT;
        }

        public void setPriceAfterVAT(Double priceAfterVAT) {
            this.priceAfterVAT = priceAfterVAT;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }

        public Double getDiscountPercent() {
            return discountPercent;
        }

        public void setDiscountPercent(Double discountPercent) {
            this.discountPercent = discountPercent;
        }

        public String getVendorNum() {
            return vendorNum;
        }

        public void setVendorNum(String vendorNum) {
            this.vendorNum = vendorNum;
        }

        public String getSerialNum() {
            return serialNum;
        }

        public void setSerialNum(String serialNum) {
            this.serialNum = serialNum;
        }

        public String getWarehouseCode() {
            return warehouseCode;
        }

        public void setWarehouseCode(String warehouseCode) {
            this.warehouseCode = warehouseCode;
        }

        public Integer getSalesPersonCode() {
            return salesPersonCode;
        }

        public void setSalesPersonCode(Integer salesPersonCode) {
            this.salesPersonCode = salesPersonCode;
        }

        public Double getCommisionPercent() {
            return commisionPercent;
        }

        public void setCommisionPercent(Double commisionPercent) {
            this.commisionPercent = commisionPercent;
        }

        public String getTreeType() {
            return treeType;
        }

        public void setTreeType(String treeType) {
            this.treeType = treeType;
        }

        public String getAccountCode() {
            return accountCode;
        }

        public void setAccountCode(String accountCode) {
            this.accountCode = accountCode;
        }

        public String getUseBaseUnits() {
            return useBaseUnits;
        }

        public void setUseBaseUnits(String useBaseUnits) {
            this.useBaseUnits = useBaseUnits;
        }

        public String getSupplierCatNum() {
            return supplierCatNum;
        }

        public void setSupplierCatNum(String supplierCatNum) {
            this.supplierCatNum = supplierCatNum;
        }

        public String getCostingCode() {
            return costingCode;
        }

        public void setCostingCode(String costingCode) {
            this.costingCode = costingCode;
        }

        public String getProjectCode() {
            return projectCode;
        }

        public void setProjectCode(String projectCode) {
            this.projectCode = projectCode;
        }

        public String getBarCode() {
            return barCode;
        }

        public void setBarCode(String barCode) {
            this.barCode = barCode;
        }

        public String getVatGroup() {
            return vatGroup;
        }

        public void setVatGroup(String vatGroup) {
            this.vatGroup = vatGroup;
        }

        public Double getHeight1() {
            return height1;
        }

        public void setHeight1(Double height1) {
            this.height1 = height1;
        }

        public String getHight1Unit() {
            return hight1Unit;
        }

        public void setHight1Unit(String hight1Unit) {
            this.hight1Unit = hight1Unit;
        }

        public Double getHeight2() {
            return height2;
        }

        public void setHeight2(Double height2) {
            this.height2 = height2;
        }

        public String getHeight2Unit() {
            return height2Unit;
        }

        public void setHeight2Unit(String height2Unit) {
            this.height2Unit = height2Unit;
        }

        public Double getLengh1() {
            return lengh1;
        }

        public void setLengh1(Double lengh1) {
            this.lengh1 = lengh1;
        }

        public String getLengh1Unit() {
            return lengh1Unit;
        }

        public void setLengh1Unit(String lengh1Unit) {
            this.lengh1Unit = lengh1Unit;
        }

        public Double getLengh2() {
            return lengh2;
        }

        public void setLengh2(Double lengh2) {
            this.lengh2 = lengh2;
        }

        public String getLengh2Unit() {
            return lengh2Unit;
        }

        public void setLengh2Unit(String lengh2Unit) {
            this.lengh2Unit = lengh2Unit;
        }

        public Double getWeight1() {
            return weight1;
        }

        public void setWeight1(Double weight1) {
            this.weight1 = weight1;
        }

        public String getWeight1Unit() {
            return weight1Unit;
        }

        public void setWeight1Unit(String weight1Unit) {
            this.weight1Unit = weight1Unit;
        }

        public Double getWeight2() {
            return weight2;
        }

        public void setWeight2(Double weight2) {
            this.weight2 = weight2;
        }

        public String getWeight2Unit() {
            return weight2Unit;
        }

        public void setWeight2Unit(String weight2Unit) {
            this.weight2Unit = weight2Unit;
        }

        public Double getFactor1() {
            return factor1;
        }

        public void setFactor1(Double factor1) {
            this.factor1 = factor1;
        }

        public Double getFactor2() {
            return factor2;
        }

        public void setFactor2(Double factor2) {
            this.factor2 = factor2;
        }

        public Double getFactor3() {
            return factor3;
        }

        public void setFactor3(Double factor3) {
            this.factor3 = factor3;
        }

        public Double getFactor4() {
            return factor4;
        }

        public void setFactor4(Double factor4) {
            this.factor4 = factor4;
        }

        public Integer getBaseType() {
            return baseType;
        }

        public void setBaseType(Integer baseType) {
            this.baseType = baseType;
        }

        public String getBaseEntry() {
            return baseEntry;
        }

        public void setBaseEntry(String baseEntry) {
            this.baseEntry = baseEntry;
        }

        public String getBaseLine() {
            return baseLine;
        }

        public void setBaseLine(String baseLine) {
            this.baseLine = baseLine;
        }

        public Double getVolume() {
            return volume;
        }

        public void setVolume(Double volume) {
            this.volume = volume;
        }

        public String getVolumeUnit() {
            return volumeUnit;
        }

        public void setVolumeUnit(String volumeUnit) {
            this.volumeUnit = volumeUnit;
        }

        public Double getWidth1() {
            return width1;
        }

        public void setWidth1(Double width1) {
            this.width1 = width1;
        }

        public String getWidth1Unit() {
            return width1Unit;
        }

        public void setWidth1Unit(String width1Unit) {
            this.width1Unit = width1Unit;
        }

        public Double getWidth2() {
            return width2;
        }

        public void setWidth2(Double width2) {
            this.width2 = width2;
        }

        public String getWidth2Unit() {
            return width2Unit;
        }

        public void setWidth2Unit(String width2Unit) {
            this.width2Unit = width2Unit;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTaxCode() {
            return taxCode;
        }

        public void setTaxCode(String taxCode) {
            this.taxCode = taxCode;
        }

        public String getTaxType() {
            return taxType;
        }

        public void setTaxType(String taxType) {
            this.taxType = taxType;
        }

        public String getTaxLiable() {
            return taxLiable;
        }

        public void setTaxLiable(String taxLiable) {
            this.taxLiable = taxLiable;
        }

        public String getPickStatus() {
            return pickStatus;
        }

        public void setPickStatus(String pickStatus) {
            this.pickStatus = pickStatus;
        }

        public Double getPickQuantity() {
            return pickQuantity;
        }

        public void setPickQuantity(Double pickQuantity) {
            this.pickQuantity = pickQuantity;
        }

        public String getPickListIdNumber() {
            return pickListIdNumber;
        }

        public void setPickListIdNumber(String pickListIdNumber) {
            this.pickListIdNumber = pickListIdNumber;
        }

        public String getOriginalItem() {
            return originalItem;
        }

        public void setOriginalItem(String originalItem) {
            this.originalItem = originalItem;
        }

        public String getBackOrder() {
            return backOrder;
        }

        public void setBackOrder(String backOrder) {
            this.backOrder = backOrder;
        }

        public String getFreeText() {
            return freeText;
        }

        public void setFreeText(String freeText) {
            this.freeText = freeText;
        }

        public Integer getShippingMethod() {
            return shippingMethod;
        }

        public void setShippingMethod(Integer shippingMethod) {
            this.shippingMethod = shippingMethod;
        }

        public String getpOTargetNum() {
            return pOTargetNum;
        }

        public void setpOTargetNum(String pOTargetNum) {
            this.pOTargetNum = pOTargetNum;
        }

        public String getpOTargetEntry() {
            return pOTargetEntry;
        }

        public void setpOTargetEntry(String pOTargetEntry) {
            this.pOTargetEntry = pOTargetEntry;
        }

        public String getpOTargetRowNum() {
            return pOTargetRowNum;
        }

        public void setpOTargetRowNum(String pOTargetRowNum) {
            this.pOTargetRowNum = pOTargetRowNum;
        }

        public String getCorrectionInvoiceItem() {
            return correctionInvoiceItem;
        }

        public void setCorrectionInvoiceItem(String correctionInvoiceItem) {
            this.correctionInvoiceItem = correctionInvoiceItem;
        }

        public Double getCorrInvAmountToStock() {
            return corrInvAmountToStock;
        }

        public void setCorrInvAmountToStock(Double corrInvAmountToStock) {
            this.corrInvAmountToStock = corrInvAmountToStock;
        }

        public Double getCorrInvAmountToDiffAcct() {
            return corrInvAmountToDiffAcct;
        }

        public void setCorrInvAmountToDiffAcct(Double corrInvAmountToDiffAcct) {
            this.corrInvAmountToDiffAcct = corrInvAmountToDiffAcct;
        }

        public Double getAppliedTax() {
            return appliedTax;
        }

        public void setAppliedTax(Double appliedTax) {
            this.appliedTax = appliedTax;
        }

        public Double getAppliedTaxFC() {
            return appliedTaxFC;
        }

        public void setAppliedTaxFC(Double appliedTaxFC) {
            this.appliedTaxFC = appliedTaxFC;
        }

        public Double getAppliedTaxSC() {
            return appliedTaxSC;
        }

        public void setAppliedTaxSC(Double appliedTaxSC) {
            this.appliedTaxSC = appliedTaxSC;
        }

        public String getwTLiable() {
            return wTLiable;
        }

        public void setwTLiable(String wTLiable) {
            this.wTLiable = wTLiable;
        }

        public String getDeferredTax() {
            return deferredTax;
        }

        public void setDeferredTax(String deferredTax) {
            this.deferredTax = deferredTax;
        }

        public Double getEqualizationTaxPercent() {
            return equalizationTaxPercent;
        }

        public void setEqualizationTaxPercent(Double equalizationTaxPercent) {
            this.equalizationTaxPercent = equalizationTaxPercent;
        }

        public Double getTotalEqualizationTax() {
            return totalEqualizationTax;
        }

        public void setTotalEqualizationTax(Double totalEqualizationTax) {
            this.totalEqualizationTax = totalEqualizationTax;
        }

        public Double getTotalEqualizationTaxFC() {
            return totalEqualizationTaxFC;
        }

        public void setTotalEqualizationTaxFC(Double totalEqualizationTaxFC) {
            this.totalEqualizationTaxFC = totalEqualizationTaxFC;
        }

        public Double getTotalEqualizationTaxSC() {
            return totalEqualizationTaxSC;
        }

        public void setTotalEqualizationTaxSC(Double totalEqualizationTaxSC) {
            this.totalEqualizationTaxSC = totalEqualizationTaxSC;
        }

        public Double getNetTaxAmount() {
            return netTaxAmount;
        }

        public void setNetTaxAmount(Double netTaxAmount) {
            this.netTaxAmount = netTaxAmount;
        }

        public Double getNetTaxAmountFC() {
            return netTaxAmountFC;
        }

        public void setNetTaxAmountFC(Double netTaxAmountFC) {
            this.netTaxAmountFC = netTaxAmountFC;
        }

        public Double getNetTaxAmountSC() {
            return netTaxAmountSC;
        }

        public void setNetTaxAmountSC(Double netTaxAmountSC) {
            this.netTaxAmountSC = netTaxAmountSC;
        }

        public String getMeasureUnit() {
            return measureUnit;
        }

        public void setMeasureUnit(String measureUnit) {
            this.measureUnit = measureUnit;
        }

        public Double getUnitsOfMeasurment() {
            return unitsOfMeasurment;
        }

        public void setUnitsOfMeasurment(Double unitsOfMeasurment) {
            this.unitsOfMeasurment = unitsOfMeasurment;
        }

        public Double getLineTotal() {
            return lineTotal;
        }

        public void setLineTotal(Double lineTotal) {
            this.lineTotal = lineTotal;
        }

        public Double getTaxPercentagePerRow() {
            return taxPercentagePerRow;
        }

        public void setTaxPercentagePerRow(Double taxPercentagePerRow) {
            this.taxPercentagePerRow = taxPercentagePerRow;
        }

        public Double getTaxTotal() {
            return taxTotal;
        }

        public void setTaxTotal(Double taxTotal) {
            this.taxTotal = taxTotal;
        }

        public String getConsumerSalesForecast() {
            return consumerSalesForecast;
        }

        public void setConsumerSalesForecast(String consumerSalesForecast) {
            this.consumerSalesForecast = consumerSalesForecast;
        }

        public Double getExciseAmount() {
            return exciseAmount;
        }

        public void setExciseAmount(Double exciseAmount) {
            this.exciseAmount = exciseAmount;
        }

        public Double getTaxPerUnit() {
            return taxPerUnit;
        }

        public void setTaxPerUnit(Double taxPerUnit) {
            this.taxPerUnit = taxPerUnit;
        }

        public Double getTotalInclTax() {
            return totalInclTax;
        }

        public void setTotalInclTax(Double totalInclTax) {
            this.totalInclTax = totalInclTax;
        }

        public String getCountryOrg() {
            return countryOrg;
        }

        public void setCountryOrg(String countryOrg) {
            this.countryOrg = countryOrg;
        }

        public String getsWW() {
            return sWW;
        }

        public void setsWW(String sWW) {
            this.sWW = sWW;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getDistributeExpense() {
            return distributeExpense;
        }

        public void setDistributeExpense(String distributeExpense) {
            this.distributeExpense = distributeExpense;
        }

        public Double getRowTotalFC() {
            return rowTotalFC;
        }

        public void setRowTotalFC(Double rowTotalFC) {
            this.rowTotalFC = rowTotalFC;
        }

        public Double getRowTotalSC() {
            return rowTotalSC;
        }

        public void setRowTotalSC(Double rowTotalSC) {
            this.rowTotalSC = rowTotalSC;
        }

        public Double getLastBuyInmPrice() {
            return lastBuyInmPrice;
        }

        public void setLastBuyInmPrice(Double lastBuyInmPrice) {
            this.lastBuyInmPrice = lastBuyInmPrice;
        }

        public Double getLastBuyDistributeSumFc() {
            return lastBuyDistributeSumFc;
        }

        public void setLastBuyDistributeSumFc(Double lastBuyDistributeSumFc) {
            this.lastBuyDistributeSumFc = lastBuyDistributeSumFc;
        }

        public Double getLastBuyDistributeSumSc() {
            return lastBuyDistributeSumSc;
        }

        public void setLastBuyDistributeSumSc(Double lastBuyDistributeSumSc) {
            this.lastBuyDistributeSumSc = lastBuyDistributeSumSc;
        }

        public Double getLastBuyDistributeSum() {
            return lastBuyDistributeSum;
        }

        public void setLastBuyDistributeSum(Double lastBuyDistributeSum) {
            this.lastBuyDistributeSum = lastBuyDistributeSum;
        }

        public Double getStockDistributesumForeign() {
            return stockDistributesumForeign;
        }

        public void setStockDistributesumForeign(Double stockDistributesumForeign) {
            this.stockDistributesumForeign = stockDistributesumForeign;
        }

        public Double getStockDistributesumSystem() {
            return stockDistributesumSystem;
        }

        public void setStockDistributesumSystem(Double stockDistributesumSystem) {
            this.stockDistributesumSystem = stockDistributesumSystem;
        }

        public Double getStockDistributesum() {
            return stockDistributesum;
        }

        public void setStockDistributesum(Double stockDistributesum) {
            this.stockDistributesum = stockDistributesum;
        }

        public Double getStockInmPrice() {
            return stockInmPrice;
        }

        public void setStockInmPrice(Double stockInmPrice) {
            this.stockInmPrice = stockInmPrice;
        }

        public String getPickStatusEx() {
            return pickStatusEx;
        }

        public void setPickStatusEx(String pickStatusEx) {
            this.pickStatusEx = pickStatusEx;
        }

        public Double getTaxBeforeDPM() {
            return taxBeforeDPM;
        }

        public void setTaxBeforeDPM(Double taxBeforeDPM) {
            this.taxBeforeDPM = taxBeforeDPM;
        }

        public Double getTaxBeforeDPMFC() {
            return taxBeforeDPMFC;
        }

        public void setTaxBeforeDPMFC(Double taxBeforeDPMFC) {
            this.taxBeforeDPMFC = taxBeforeDPMFC;
        }

        public Double getTaxBeforeDPMSC() {
            return taxBeforeDPMSC;
        }

        public void setTaxBeforeDPMSC(Double taxBeforeDPMSC) {
            this.taxBeforeDPMSC = taxBeforeDPMSC;
        }

        public String getcFOPCode() {
            return cFOPCode;
        }

        public void setcFOPCode(String cFOPCode) {
            this.cFOPCode = cFOPCode;
        }

        public String getcSTCode() {
            return cSTCode;
        }

        public void setcSTCode(String cSTCode) {
            this.cSTCode = cSTCode;
        }

        public String getUsage() {
            return usage;
        }

        public void setUsage(String usage) {
            this.usage = usage;
        }

        public String getTaxOnly() {
            return taxOnly;
        }

        public void setTaxOnly(String taxOnly) {
            this.taxOnly = taxOnly;
        }

        public Integer getVisualOrder() {
            return visualOrder;
        }

        public void setVisualOrder(Integer visualOrder) {
            this.visualOrder = visualOrder;
        }

        public Double getBaseOpenQuantity() {
            return baseOpenQuantity;
        }

        public void setBaseOpenQuantity(Double baseOpenQuantity) {
            this.baseOpenQuantity = baseOpenQuantity;
        }

        public Double getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
        }

        public String getLineStatus() {
            return lineStatus;
        }

        public void setLineStatus(String lineStatus) {
            this.lineStatus = lineStatus;
        }

        public Double getPackageQuantity() {
            return packageQuantity;
        }

        public void setPackageQuantity(Double packageQuantity) {
            this.packageQuantity = packageQuantity;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getLineType() {
            return lineType;
        }

        public void setLineType(String lineType) {
            this.lineType = lineType;
        }

        public String getcOGSCostingCode() {
            return cOGSCostingCode;
        }

        public void setcOGSCostingCode(String cOGSCostingCode) {
            this.cOGSCostingCode = cOGSCostingCode;
        }

        public String getcOGSAccountCode() {
            return cOGSAccountCode;
        }

        public void setcOGSAccountCode(String cOGSAccountCode) {
            this.cOGSAccountCode = cOGSAccountCode;
        }

        public String getChangeAssemlyBoMWarehouse() {
            return changeAssemlyBoMWarehouse;
        }

        public void setChangeAssemlyBoMWarehouse(String changeAssemlyBoMWarehouse) {
            this.changeAssemlyBoMWarehouse = changeAssemlyBoMWarehouse;
        }

        public Double getGrossBuyPrice() {
            return grossBuyPrice;
        }

        public void setGrossBuyPrice(Double grossBuyPrice) {
            this.grossBuyPrice = grossBuyPrice;
        }

        public String getGrossBase() {
            return grossBase;
        }

        public void setGrossBase(String grossBase) {
            this.grossBase = grossBase;
        }

        public Double getGrossProfitTotalBasePrice() {
            return grossProfitTotalBasePrice;
        }

        public void setGrossProfitTotalBasePrice(Double grossProfitTotalBasePrice) {
            this.grossProfitTotalBasePrice = grossProfitTotalBasePrice;
        }

        public String getCostingCode2() {
            return costingCode2;
        }

        public void setCostingCode2(String costingCode2) {
            this.costingCode2 = costingCode2;
        }

        public String getCostingCode3() {
            return costingCode3;
        }

        public void setCostingCode3(String costingCode3) {
            this.costingCode3 = costingCode3;
        }

        public String getCostingCode4() {
            return costingCode4;
        }

        public void setCostingCode4(String costingCode4) {
            this.costingCode4 = costingCode4;
        }

        public String getCostingCode5() {
            return costingCode5;
        }

        public void setCostingCode5(String costingCode5) {
            this.costingCode5 = costingCode5;
        }

        public String getItemDetails() {
            return itemDetails;
        }

        public void setItemDetails(String itemDetails) {
            this.itemDetails = itemDetails;
        }

        public String getLocationCode() {
            return locationCode;
        }

        public void setLocationCode(String locationCode) {
            this.locationCode = locationCode;
        }

        public String getActualDeliveryDate() {
            return actualDeliveryDate;
        }

        public void setActualDeliveryDate(String actualDeliveryDate) {
            this.actualDeliveryDate = actualDeliveryDate;
        }

        public Double getRemainingOpenQuantity() {
            return remainingOpenQuantity;
        }

        public void setRemainingOpenQuantity(Double remainingOpenQuantity) {
            this.remainingOpenQuantity = remainingOpenQuantity;
        }

        public Double getOpenAmount() {
            return openAmount;
        }

        public void setOpenAmount(Double openAmount) {
            this.openAmount = openAmount;
        }

        public Double getOpenAmountFC() {
            return openAmountFC;
        }

        public void setOpenAmountFC(Double openAmountFC) {
            this.openAmountFC = openAmountFC;
        }

        public Double getOpenAmountSC() {
            return openAmountSC;
        }

        public void setOpenAmountSC(Double openAmountSC) {
            this.openAmountSC = openAmountSC;
        }

        public String getExLineNo() {
            return exLineNo;
        }

        public void setExLineNo(String exLineNo) {
            this.exLineNo = exLineNo;
        }

        public String getRequiredDate() {
            return requiredDate;
        }

        public void setRequiredDate(String requiredDate) {
            this.requiredDate = requiredDate;
        }

        public Double getRequiredQuantity() {
            return requiredQuantity;
        }

        public void setRequiredQuantity(Double requiredQuantity) {
            this.requiredQuantity = requiredQuantity;
        }

        public String getcOGSCostingCode2() {
            return cOGSCostingCode2;
        }

        public void setcOGSCostingCode2(String cOGSCostingCode2) {
            this.cOGSCostingCode2 = cOGSCostingCode2;
        }

        public String getcOGSCostingCode3() {
            return cOGSCostingCode3;
        }

        public void setcOGSCostingCode3(String cOGSCostingCode3) {
            this.cOGSCostingCode3 = cOGSCostingCode3;
        }

        public String getcOGSCostingCode4() {
            return cOGSCostingCode4;
        }

        public void setcOGSCostingCode4(String cOGSCostingCode4) {
            this.cOGSCostingCode4 = cOGSCostingCode4;
        }

        public String getcOGSCostingCode5() {
            return cOGSCostingCode5;
        }

        public void setcOGSCostingCode5(String cOGSCostingCode5) {
            this.cOGSCostingCode5 = cOGSCostingCode5;
        }

        public String getcSTforIPI() {
            return cSTforIPI;
        }

        public void setcSTforIPI(String cSTforIPI) {
            this.cSTforIPI = cSTforIPI;
        }

        public String getcSTforPIS() {
            return cSTforPIS;
        }

        public void setcSTforPIS(String cSTforPIS) {
            this.cSTforPIS = cSTforPIS;
        }

        public String getcSTforCOFINS() {
            return cSTforCOFINS;
        }

        public void setcSTforCOFINS(String cSTforCOFINS) {
            this.cSTforCOFINS = cSTforCOFINS;
        }

        public String getCreditOriginCode() {
            return creditOriginCode;
        }

        public void setCreditOriginCode(String creditOriginCode) {
            this.creditOriginCode = creditOriginCode;
        }

        public String getWithoutInventoryMovement() {
            return withoutInventoryMovement;
        }

        public void setWithoutInventoryMovement(String withoutInventoryMovement) {
            this.withoutInventoryMovement = withoutInventoryMovement;
        }

        public String getAgreementNo() {
            return agreementNo;
        }

        public void setAgreementNo(String agreementNo) {
            this.agreementNo = agreementNo;
        }

        public String getAgreementRowNumber() {
            return agreementRowNumber;
        }

        public void setAgreementRowNumber(String agreementRowNumber) {
            this.agreementRowNumber = agreementRowNumber;
        }

        public String getActualBaseEntry() {
            return actualBaseEntry;
        }

        public void setActualBaseEntry(String actualBaseEntry) {
            this.actualBaseEntry = actualBaseEntry;
        }

        public String getActualBaseLine() {
            return actualBaseLine;
        }

        public void setActualBaseLine(String actualBaseLine) {
            this.actualBaseLine = actualBaseLine;
        }

        public Integer getDocEntry() {
            return docEntry;
        }

        public void setDocEntry(Integer docEntry) {
            this.docEntry = docEntry;
        }

        public Double getSurpluses() {
            return surpluses;
        }

        public void setSurpluses(Double surpluses) {
            this.surpluses = surpluses;
        }

        public Double getDefectAndBreakup() {
            return defectAndBreakup;
        }

        public void setDefectAndBreakup(Double defectAndBreakup) {
            this.defectAndBreakup = defectAndBreakup;
        }

        public Double getShortages() {
            return shortages;
        }

        public void setShortages(Double shortages) {
            this.shortages = shortages;
        }

        public String getConsiderQuantity() {
            return considerQuantity;
        }

        public void setConsiderQuantity(String considerQuantity) {
            this.considerQuantity = considerQuantity;
        }

        public String getPartialRetirement() {
            return partialRetirement;
        }

        public void setPartialRetirement(String partialRetirement) {
            this.partialRetirement = partialRetirement;
        }

        public Double getRetirementQuantity() {
            return retirementQuantity;
        }

        public void setRetirementQuantity(Double retirementQuantity) {
            this.retirementQuantity = retirementQuantity;
        }

        public Double getRetirementAPC() {
            return retirementAPC;
        }

        public void setRetirementAPC(Double retirementAPC) {
            this.retirementAPC = retirementAPC;
        }

        public String getThirdParty() {
            return thirdParty;
        }

        public void setThirdParty(String thirdParty) {
            this.thirdParty = thirdParty;
        }

        public String getPoNum() {
            return poNum;
        }

        public void setPoNum(String poNum) {
            this.poNum = poNum;
        }

        public String getPoItmNum() {
            return poItmNum;
        }

        public void setPoItmNum(String poItmNum) {
            this.poItmNum = poItmNum;
        }

        public String getExpenseType() {
            return expenseType;
        }

        public void setExpenseType(String expenseType) {
            this.expenseType = expenseType;
        }

        public String getReceiptNumber() {
            return receiptNumber;
        }

        public void setReceiptNumber(String receiptNumber) {
            this.receiptNumber = receiptNumber;
        }

        public String getExpenseOperationType() {
            return expenseOperationType;
        }

        public void setExpenseOperationType(String expenseOperationType) {
            this.expenseOperationType = expenseOperationType;
        }

        public String getFederalTaxID() {
            return federalTaxID;
        }

        public void setFederalTaxID(String federalTaxID) {
            this.federalTaxID = federalTaxID;
        }

        public Double getGrossProfit() {
            return grossProfit;
        }

        public void setGrossProfit(Double grossProfit) {
            this.grossProfit = grossProfit;
        }

        public Double getGrossProfitFC() {
            return grossProfitFC;
        }

        public void setGrossProfitFC(Double grossProfitFC) {
            this.grossProfitFC = grossProfitFC;
        }

        public Double getGrossProfitSC() {
            return grossProfitSC;
        }

        public void setGrossProfitSC(Double grossProfitSC) {
            this.grossProfitSC = grossProfitSC;
        }

        public String getPriceSource() {
            return priceSource;
        }

        public void setPriceSource(String priceSource) {
            this.priceSource = priceSource;
        }

        public String getStgSeqNum() {
            return stgSeqNum;
        }

        public void setStgSeqNum(String stgSeqNum) {
            this.stgSeqNum = stgSeqNum;
        }

        public String getStgEntry() {
            return stgEntry;
        }

        public void setStgEntry(String stgEntry) {
            this.stgEntry = stgEntry;
        }

        public String getStgDesc() {
            return stgDesc;
        }

        public void setStgDesc(String stgDesc) {
            this.stgDesc = stgDesc;
        }

        public Integer getUoMEntry() {
            return uoMEntry;
        }

        public void setUoMEntry(Integer uoMEntry) {
            this.uoMEntry = uoMEntry;
        }

        public String getUoMCode() {
            return uoMCode;
        }

        public void setUoMCode(String uoMCode) {
            this.uoMCode = uoMCode;
        }

        public Double getInventoryQuantity() {
            return inventoryQuantity;
        }

        public void setInventoryQuantity(Double inventoryQuantity) {
            this.inventoryQuantity = inventoryQuantity;
        }

        public Double getRemainingOpenInventoryQuantity() {
            return remainingOpenInventoryQuantity;
        }

        public void setRemainingOpenInventoryQuantity(Double remainingOpenInventoryQuantity) {
            this.remainingOpenInventoryQuantity = remainingOpenInventoryQuantity;
        }

        public String getParentLineNum() {
            return parentLineNum;
        }

        public void setParentLineNum(String parentLineNum) {
            this.parentLineNum = parentLineNum;
        }

        public Integer getIncoterms() {
            return incoterms;
        }

        public void setIncoterms(Integer incoterms) {
            this.incoterms = incoterms;
        }

        public Integer getTransportMode() {
            return transportMode;
        }

        public void setTransportMode(Integer transportMode) {
            this.transportMode = transportMode;
        }

        public String getNatureOfTransaction() {
            return natureOfTransaction;
        }

        public void setNatureOfTransaction(String natureOfTransaction) {
            this.natureOfTransaction = natureOfTransaction;
        }

        public String getDestinationCountryForImport() {
            return destinationCountryForImport;
        }

        public void setDestinationCountryForImport(String destinationCountryForImport) {
            this.destinationCountryForImport = destinationCountryForImport;
        }

        public String getDestinationRegionForImport() {
            return destinationRegionForImport;
        }

        public void setDestinationRegionForImport(String destinationRegionForImport) {
            this.destinationRegionForImport = destinationRegionForImport;
        }

        public String getOriginCountryForExport() {
            return originCountryForExport;
        }

        public void setOriginCountryForExport(String originCountryForExport) {
            this.originCountryForExport = originCountryForExport;
        }

        public String getOriginRegionForExport() {
            return originRegionForExport;
        }

        public void setOriginRegionForExport(String originRegionForExport) {
            this.originRegionForExport = originRegionForExport;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getChangeInventoryQuantityIndependently() {
            return changeInventoryQuantityIndependently;
        }

        public void setChangeInventoryQuantityIndependently(String changeInventoryQuantityIndependently) {
            this.changeInventoryQuantityIndependently = changeInventoryQuantityIndependently;
        }

        public String getFreeOfChargeBP() {
            return freeOfChargeBP;
        }

        public void setFreeOfChargeBP(String freeOfChargeBP) {
            this.freeOfChargeBP = freeOfChargeBP;
        }

        public String getsACEntry() {
            return sACEntry;
        }

        public void setsACEntry(String sACEntry) {
            this.sACEntry = sACEntry;
        }

        public String gethSNEntry() {
            return hSNEntry;
        }

        public void sethSNEntry(String hSNEntry) {
            this.hSNEntry = hSNEntry;
        }

        public Double getGrossPrice() {
            return grossPrice;
        }

        public void setGrossPrice(Double grossPrice) {
            this.grossPrice = grossPrice;
        }

        public Double getGrossTotal() {
            return grossTotal;
        }

        public void setGrossTotal(Double grossTotal) {
            this.grossTotal = grossTotal;
        }

        public Double getGrossTotalFC() {
            return grossTotalFC;
        }

        public void setGrossTotalFC(Double grossTotalFC) {
            this.grossTotalFC = grossTotalFC;
        }

        public Double getGrossTotalSC() {
            return grossTotalSC;
        }

        public void setGrossTotalSC(Double grossTotalSC) {
            this.grossTotalSC = grossTotalSC;
        }

        public Integer getnCMCode() {
            return nCMCode;
        }

        public void setnCMCode(Integer nCMCode) {
            this.nCMCode = nCMCode;
        }

        public String getnVECode() {
            return nVECode;
        }

        public void setnVECode(String nVECode) {
            this.nVECode = nVECode;
        }

        public String getIndEscala() {
            return indEscala;
        }

        public void setIndEscala(String indEscala) {
            this.indEscala = indEscala;
        }

        public Double getCtrSealQty() {
            return ctrSealQty;
        }

        public void setCtrSealQty(Double ctrSealQty) {
            this.ctrSealQty = ctrSealQty;
        }

        public String getcNJPMan() {
            return cNJPMan;
        }

        public void setcNJPMan(String cNJPMan) {
            this.cNJPMan = cNJPMan;
        }

        public String getcESTCode() {
            return cESTCode;
        }

        public void setcESTCode(String cESTCode) {
            this.cESTCode = cESTCode;
        }

        public String getuFFiscalBenefitCode() {
            return uFFiscalBenefitCode;
        }

        public void setuFFiscalBenefitCode(String uFFiscalBenefitCode) {
            this.uFFiscalBenefitCode = uFFiscalBenefitCode;
        }

        public String getReverseCharge() {
            return reverseCharge;
        }

        public void setReverseCharge(String reverseCharge) {
            this.reverseCharge = reverseCharge;
        }

        public String getOwnerCode() {
            return ownerCode;
        }

        public void setOwnerCode(String ownerCode) {
            this.ownerCode = ownerCode;
        }

        public Integer getStandardItemIdentification() {
            return standardItemIdentification;
        }

        public void setStandardItemIdentification(Integer standardItemIdentification) {
            this.standardItemIdentification = standardItemIdentification;
        }

        public Integer getCommodityClassification() {
            return commodityClassification;
        }

        public void setCommodityClassification(Integer commodityClassification) {
            this.commodityClassification = commodityClassification;
        }

        public Double getWeightOfRecycledPlastic() {
            return weightOfRecycledPlastic;
        }

        public void setWeightOfRecycledPlastic(Double weightOfRecycledPlastic) {
            this.weightOfRecycledPlastic = weightOfRecycledPlastic;
        }

        public String getPlasticPackageExemptionReason() {
            return plasticPackageExemptionReason;
        }

        public void setPlasticPackageExemptionReason(String plasticPackageExemptionReason) {
            this.plasticPackageExemptionReason = plasticPackageExemptionReason;
        }

        public String getLegalText() {
            return legalText;
        }

        public void setLegalText(String legalText) {
            this.legalText = legalText;
        }

        public String getCig() {
            return cig;
        }

        public void setCig(String cig) {
            this.cig = cig;
        }

        public String getCup() {
            return cup;
        }

        public void setCup(String cup) {
            this.cup = cup;
        }

        public String getUnencumberedReason() {
            return unencumberedReason;
        }

        public void setUnencumberedReason(String unencumberedReason) {
            this.unencumberedReason = unencumberedReason;
        }

        public String getcUSplit() {
            return cUSplit;
        }

        public void setcUSplit(String cUSplit) {
            this.cUSplit = cUSplit;
        }

        public Integer getListNum() {
            return listNum;
        }

        public void setListNum(Integer listNum) {
            this.listNum = listNum;
        }

        public String getRecognizedTaxCode() {
            return recognizedTaxCode;
        }

        public void setRecognizedTaxCode(String recognizedTaxCode) {
            this.recognizedTaxCode = recognizedTaxCode;
        }

        public Double getuPrecLis() {
            return uPrecLis;
        }

        public void setuPrecLis(Double uPrecLis) {
            this.uPrecLis = uPrecLis;
        }

        public Double getuDifPrec() {
            return uDifPrec;
        }

        public void setuDifPrec(Double uDifPrec) {
            this.uDifPrec = uDifPrec;
        }

        public String getuCostoimp() {
            return uCostoimp;
        }

        public void setuCostoimp(String uCostoimp) {
            this.uCostoimp = uCostoimp;
        }

        public String getuBanco() {
            return uBanco;
        }

        public void setuBanco(String uBanco) {
            this.uBanco = uBanco;
        }

        public String getuUbicacion() {
            return uUbicacion;
        }

        public void setuUbicacion(String uUbicacion) {
            this.uUbicacion = uUbicacion;
        }

        public String getuCheque() {
            return uCheque;
        }

        public void setuCheque(String uCheque) {
            this.uCheque = uCheque;
        }

        public String getuValPrecio() {
            return uValPrecio;
        }

        public void setuValPrecio(String uValPrecio) {
            this.uValPrecio = uValPrecio;
        }

        public String getuCausalDev() {
            return uCausalDev;
        }

        public void setuCausalDev(String uCausalDev) {
            this.uCausalDev = uCausalDev;
        }

        public Double getuStockAlm() {
            return uStockAlm;
        }

        public void setuStockAlm(Double uStockAlm) {
            this.uStockAlm = uStockAlm;
        }

        public Double getuDisponibleAlm() {
            return uDisponibleAlm;
        }

        public void setuDisponibleAlm(Double uDisponibleAlm) {
            this.uDisponibleAlm = uDisponibleAlm;
        }

        public Integer getuBldLyid() {
            return uBldLyid;
        }

        public void setuBldLyid(Integer uBldLyid) {
            this.uBldLyid = uBldLyid;
        }

        public String getuBldNcps() {
            return uBldNcps;
        }

        public void setuBldNcps(String uBldNcps) {
            this.uBldNcps = uBldNcps;
        }

        public String getuReferencia() {
            return uReferencia;
        }

        public void setuReferencia(String uReferencia) {
            this.uReferencia = uReferencia;
        }

        public String getuDiferencia() {
            return uDiferencia;
        }

        public void setuDiferencia(String uDiferencia) {
            this.uDiferencia = uDiferencia;
        }

        public Double getuPrecioCotizacion() {
            return uPrecioCotizacion;
        }

        public void setuPrecioCotizacion(Double uPrecioCotizacion) {
            this.uPrecioCotizacion = uPrecioCotizacion;
        }

        public String getuIvcdone() {
            return uIvcdone;
        }

        public void setuIvcdone(String uIvcdone) {
            this.uIvcdone = uIvcdone;
        }

        public String getuNwrBase() {
            return uNwrBase;
        }

        public void setuNwrBase(String uNwrBase) {
            this.uNwrBase = uNwrBase;
        }

        public String getuCustdate() {
            return uCustdate;
        }

        public void setuCustdate(String uCustdate) {
            this.uCustdate = uCustdate;
        }

        public String getuDocnumbase() {
            return uDocnumbase;
        }

        public void setuDocnumbase(String uDocnumbase) {
            this.uDocnumbase = uDocnumbase;
        }

        public String getuObjtype() {
            return uObjtype;
        }

        public void setuObjtype(String uObjtype) {
            this.uObjtype = uObjtype;
        }

        public Double getuNwrQtyallocated() {
            return uNwrQtyallocated;
        }

        public void setuNwrQtyallocated(Double uNwrQtyallocated) {
            this.uNwrQtyallocated = uNwrQtyallocated;
        }

        public Double getuReclamqty() {
            return uReclamqty;
        }

        public void setuReclamqty(Double uReclamqty) {
            this.uReclamqty = uReclamqty;
        }

        public String getuQamark() {
            return uQamark;
        }

        public void setuQamark(String uQamark) {
            this.uQamark = uQamark;
        }

        public Double getuIncomingqty() {
            return uIncomingqty;
        }

        public void setuIncomingqty(Double uIncomingqty) {
            this.uIncomingqty = uIncomingqty;
        }

        public String getuNwrBin() {
            return uNwrBin;
        }

        public void setuNwrBin(String uNwrBin) {
            this.uNwrBin = uNwrBin;
        }

        public String getuTransitwhscode() {
            return uTransitwhscode;
        }

        public void setuTransitwhscode(String uTransitwhscode) {
            this.uTransitwhscode = uTransitwhscode;
        }

        public String getuCalcaiu() {
            return uCalcaiu;
        }

        public void setuCalcaiu(String uCalcaiu) {
            this.uCalcaiu = uCalcaiu;
        }

        public String getuRildone() {
            return uRildone;
        }

        public void setuRildone(String uRildone) {
            this.uRildone = uRildone;
        }

        public Double getuValorImpocon() {
            return uValorImpocon;
        }

        public void setuValorImpocon(Double uValorImpocon) {
            this.uValorImpocon = uValorImpocon;
        }

        public String getuMarca() {
            return uMarca;
        }

        public void setuMarca(String uMarca) {
            this.uMarca = uMarca;
        }

        public String getuModelo() {
            return uModelo;
        }

        public void setuModelo(String uModelo) {
            this.uModelo = uModelo;
        }

        public String getuLocation() {
            return uLocation;
        }

        public void setuLocation(String uLocation) {
            this.uLocation = uLocation;
        }

        public String getuMesesdiferidol() {
            return uMesesdiferidol;
        }

        public void setuMesesdiferidol(String uMesesdiferidol) {
            this.uMesesdiferidol = uMesesdiferidol;
        }

        public String getuDocumentoevaluado() {
            return uDocumentoevaluado;
        }

        public void setuDocumentoevaluado(String uDocumentoevaluado) {
            this.uDocumentoevaluado = uDocumentoevaluado;
        }

        public String getuCreatedate() {
            return uCreatedate;
        }

        public void setuCreatedate(String uCreatedate) {
            this.uCreatedate = uCreatedate;
        }

        public String getuDeliverydate() {
            return uDeliverydate;
        }

        public void setuDeliverydate(String uDeliverydate) {
            this.uDeliverydate = uDeliverydate;
        }

        public String getuOk1Descreql() {
            return uOk1Descreql;
        }

        public void setuOk1Descreql(String uOk1Descreql) {
            this.uOk1Descreql = uOk1Descreql;
        }

        public String getuInvoicenumber() {
            return uInvoicenumber;
        }

        public void setuInvoicenumber(String uInvoicenumber) {
            this.uInvoicenumber = uInvoicenumber;
        }

        public String getuAnexosol() {
            return uAnexosol;
        }

        public void setuAnexosol(String uAnexosol) {
            this.uAnexosol = uAnexosol;
        }

        public List<String> getLineTaxJurisdictions() {
            return lineTaxJurisdictions;
        }

        public void setLineTaxJurisdictions(List<String> lineTaxJurisdictions) {
            this.lineTaxJurisdictions = lineTaxJurisdictions;
        }

        public List<String> getSerialNumbers() {
            return serialNumbers;
        }

        public void setSerialNumbers(List<String> serialNumbers) {
            this.serialNumbers = serialNumbers;
        }

        public List<String> getBatchNumbers() {
            return batchNumbers;
        }

        public void setBatchNumbers(List<String> batchNumbers) {
            this.batchNumbers = batchNumbers;
        }

        public List<String> getcCDNumbers() {
            return cCDNumbers;
        }

        public void setcCDNumbers(List<String> cCDNumbers) {
            this.cCDNumbers = cCDNumbers;
        }

        public List<DocumentLinesBinAllocation> getDocumentLinesBinAllocations() {
            return documentLinesBinAllocations;
        }

        public void setDocumentLinesBinAllocations(List<DocumentLinesBinAllocation> documentLinesBinAllocations) {
            this.documentLinesBinAllocations = documentLinesBinAllocations;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class DocumentLinesBinAllocation implements Serializable {
            @JsonProperty("BinAbsEntry")
            protected Integer binAbsEntry;
            @JsonProperty("Quantity")
            protected Double quantity;
            @JsonProperty("AllowNegativeQuantity")
            protected String allowNegativeQuantity;
            @JsonProperty("SerialAndBatchNumbersBaseLine")
            protected Integer serialAndBatchNumbersBaseLine;
            @JsonProperty("BaseLineNumber")
            protected Integer baseLineNumber;

            public Integer getBinAbsEntry() {
                return binAbsEntry;
            }

            public void setBinAbsEntry(Integer binAbsEntry) {
                this.binAbsEntry = binAbsEntry;
            }

            public Double getQuantity() {
                return quantity;
            }

            public void setQuantity(Double quantity) {
                this.quantity = quantity;
            }

            public String getAllowNegativeQuantity() {
                return allowNegativeQuantity;
            }

            public void setAllowNegativeQuantity(String allowNegativeQuantity) {
                this.allowNegativeQuantity = allowNegativeQuantity;
            }

            public Integer getSerialAndBatchNumbersBaseLine() {
                return serialAndBatchNumbersBaseLine;
            }

            public void setSerialAndBatchNumbersBaseLine(Integer serialAndBatchNumbersBaseLine) {
                this.serialAndBatchNumbersBaseLine = serialAndBatchNumbersBaseLine;
            }

            public Integer getBaseLineNumber() {
                return baseLineNumber;
            }

            public void setBaseLineNumber(Integer baseLineNumber) {
                this.baseLineNumber = baseLineNumber;
            }
        }
    }
}

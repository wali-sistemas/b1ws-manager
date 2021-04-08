package co.manager.hanaws.dto.item;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemsRestDTO implements Serializable {
    @JsonProperty("ItemCode")
    protected String itemCode;
    @JsonProperty("ItemName")
    protected String itemName;
    @JsonProperty("ForeignName")
    protected String foreignName;
    @JsonProperty("ItemsGroupCode")
    protected Long itemsGroupCode;
    @JsonProperty("CustomsGroupCode")
    protected Long customsGroupCode;
    @JsonProperty("SalesVATGroup")
    protected String salesVATGroup;
    @JsonProperty("BarCode")
    protected String barCode;
    @JsonProperty("VatLiable")
    protected String vatLiable;
    @JsonProperty("PurchaseItem")
    protected String purchaseItem;
    @JsonProperty("SalesItem")
    protected String salesItem;
    @JsonProperty("InventoryItem")
    protected String inventoryItem;
    @JsonProperty("IncomeAccount")
    protected String incomeAccount;
    @JsonProperty("ExemptIncomeAccount")
    protected String exemptIncomeAccount;
    @JsonProperty("ExpanseAccount")
    protected String expanseAccount;
    @JsonProperty("Mainsupplier")
    protected String mainsupplier;
    @JsonProperty("SupplierCatalogNo")
    protected String supplierCatalogNo;
    @JsonProperty("DesiredInventory")
    protected Double desiredInventory;
    @JsonProperty("MinInventory")
    protected Double minInventory;
    @JsonProperty("Picture")
    protected String picture;
    @JsonProperty("User_Text")
    protected String userText;
    @JsonProperty("SerialNum")
    protected String serialNum;
    @JsonProperty("CommissionPercent")
    protected Double commissionPercent;
    @JsonProperty("CommissionSum")
    protected Double commissionSum;
    @JsonProperty("CommissionGroup")
    protected Long commissionGroup;
    @JsonProperty("TreeType")
    protected String treeType;
    @JsonProperty("AssetItem")
    protected String assetItem;
    @JsonProperty("DataExportCode")
    protected String dataExportCode;
    @JsonProperty("Manufacturer")
    protected Long manufacturer;
    @JsonProperty("QuantityOnStock")
    protected Double quantityOnStock;
    @JsonProperty("QuantityOrderedFromVendors")
    protected Double quantityOrderedFromVendors;
    @JsonProperty("QuantityOrderedByCustomers")
    protected Double quantityOrderedByCustomers;
    @JsonProperty("ManageSerialNumbers")
    protected String manageSerialNumbers;
    @JsonProperty("ManageBatchNumbers")
    protected String manageBatchNumbers;
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
    @JsonProperty("SalesUnit")
    protected String salesUnit;
    @JsonProperty("SalesItemsPerUnit")
    protected Double salesItemsPerUnit;
    @JsonProperty("SalesPackagingUnit")
    protected String salesPackagingUnit;
    @JsonProperty("SalesQtyPerPackUnit")
    protected Double salesQtyPerPackUnit;
    @JsonProperty("SalesUnitLength")
    protected Double salesUnitLength;
    @JsonProperty("SalesLengthUnit")
    protected Long salesLengthUnit;
    @JsonProperty("SalesUnitWidth")
    protected Double salesUnitWidth;
    @JsonProperty("SalesWidthUnit")
    protected Long salesWidthUnit;
    @JsonProperty("SalesUnitHeight")
    protected Double salesUnitHeight;
    @JsonProperty("SalesHeightUnit")
    protected Long salesHeightUnit;
    @JsonProperty("SalesUnitVolume")
    protected Double salesUnitVolume;
    @JsonProperty("SalesVolumeUnit")
    protected Long salesVolumeUnit;
    @JsonProperty("SalesUnitWeight")
    protected Double salesUnitWeight;
    @JsonProperty("SalesWeightUnit")
    protected Long salesWeightUnit;
    @JsonProperty("PurchaseUnit")
    protected String purchaseUnit;
    @JsonProperty("PurchaseItemsPerUnit")
    protected Double purchaseItemsPerUnit;
    @JsonProperty("PurchasePackagingUnit")
    protected String purchasePackagingUnit;
    @JsonProperty("PurchaseQtyPerPackUnit")
    protected Double purchaseQtyPerPackUnit;
    @JsonProperty("PurchaseUnitLength")
    protected Double purchaseUnitLength;
    @JsonProperty("PurchaseLengthUnit")
    protected Long purchaseLengthUnit;
    @JsonProperty("PurchaseUnitWidth")
    protected Double purchaseUnitWidth;
    @JsonProperty("PurchaseWidthUnit")
    protected Long purchaseWidthUnit;
    @JsonProperty("PurchaseUnitHeight")
    protected Double purchaseUnitHeight;
    @JsonProperty("PurchaseHeightUnit")
    protected Long purchaseHeightUnit;
    @JsonProperty("PurchaseUnitVolume")
    protected Double purchaseUnitVolume;
    @JsonProperty("PurchaseVolumeUnit")
    protected Long purchaseVolumeUnit;
    @JsonProperty("PurchaseUnitWeight")
    protected Double purchaseUnitWeight;
    @JsonProperty("PurchaseWeightUnit")
    protected Long purchaseWeightUnit;
    @JsonProperty("PurchaseVATGroup")
    protected String purchaseVATGroup;
    @JsonProperty("SalesFactor1")
    protected Double salesFactor1;
    @JsonProperty("SalesFactor2")
    protected Double salesFactor2;
    @JsonProperty("SalesFactor3")
    protected Double salesFactor3;
    @JsonProperty("SalesFactor4")
    protected Double salesFactor4;
    @JsonProperty("PurchaseFactor1")
    protected Double purchaseFactor1;
    @JsonProperty("PurchaseFactor2")
    protected Double purchaseFactor2;
    @JsonProperty("PurchaseFactor3")
    protected Double purchaseFactor3;
    @JsonProperty("PurchaseFactor4")
    protected Double purchaseFactor4;
    @JsonProperty("MovingAveragePrice")
    protected Double movingAveragePrice;
    @JsonProperty("ForeignRevenuesAccount")
    protected String foreignRevenuesAccount;
    @JsonProperty("ECRevenuesAccount")
    protected String ecRevenuesAccount;
    @JsonProperty("ForeignExpensesAccount")
    protected String foreignExpensesAccount;
    @JsonProperty("ECExpensesAccount")
    protected String ecExpensesAccount;
    @JsonProperty("AvgStdPrice")
    protected Double avgStdPrice;
    @JsonProperty("DefaultWarehouse")
    protected String defaultWarehouse;
    @JsonProperty("ShipType")
    protected Long shipType;
    @JsonProperty("GLMethod")
    protected String glMethod;
    @JsonProperty("TaxType")
    protected String taxType;
    @JsonProperty("MaxInventory")
    protected Double maxInventory;
    @JsonProperty("ManageStockByWarehouse")
    protected String manageStockByWarehouse;
    @JsonProperty("PurchaseHeightUnit1")
    protected Long purchaseHeightUnit1;
    @JsonProperty("PurchaseUnitHeight1")
    protected Double purchaseUnitHeight1;
    @JsonProperty("PurchaseLengthUnit1")
    protected Long purchaseLengthUnit1;
    @JsonProperty("PurchaseUnitLength1")
    protected Double purchaseUnitLength1;
    @JsonProperty("PurchaseWeightUnit1")
    protected Long purchaseWeightUnit1;
    @JsonProperty("PurchaseUnitWeight1")
    protected Double purchaseUnitWeight1;
    @JsonProperty("PurchaseWidthUnit1")
    protected Long purchaseWidthUnit1;
    @JsonProperty("PurchaseUnitWidth1")
    protected Double purchaseUnitWidth1;
    @JsonProperty("SalesHeightUnit1")
    protected Long salesHeightUnit1;
    @JsonProperty("SalesUnitHeight1")
    protected Double salesUnitHeight1;
    @JsonProperty("SalesLengthUnit1")
    protected Long salesLengthUnit1;
    @JsonProperty("SalesUnitLength1")
    protected Double salesUnitLength1;
    @JsonProperty("SalesWeightUnit1")
    protected Long salesWeightUnit1;
    @JsonProperty("SalesUnitWeight1")
    protected Double salesUnitWeight1;
    @JsonProperty("SalesWidthUnit1")
    protected Long salesWidthUnit1;
    @JsonProperty("SalesUnitWidth1")
    protected Double salesUnitWidth1;
    @JsonProperty("ForceSelectionOfSerialNumber")
    protected String forceSelectionOfSerialNumber;
    @JsonProperty("ManageSerialNumbersOnReleaseOnly")
    protected String manageSerialNumbersOnReleaseOnly;
    @JsonProperty("WTLiable")
    protected String wtLiable;
    @JsonProperty("CostAccountingMethod")
    protected String costAccountingMethod;
    @JsonProperty("SWW")
    protected String sww;
    @JsonProperty("WarrantyTemplate")
    protected String warrantyTemplate;
    @JsonProperty("IndirectTax")
    protected String indirectTax;
    @JsonProperty("ArTaxCode")
    protected String arTaxCode;
    @JsonProperty("ApTaxCode")
    protected String apTaxCode;
    @JsonProperty("BaseUnitName")
    protected String baseUnitName;
    @JsonProperty("ItemCountryOrg")
    protected String itemCountryOrg;
    @JsonProperty("IssueMethod")
    protected String issueMethod;
    @JsonProperty("SRIAndBatchManageMethod")
    protected String sriAndBatchManageMethod;
    @JsonProperty("IsPhantom")
    protected String isPhantom;
    @JsonProperty("InventoryUOM")
    protected String inventoryUOM;
    @JsonProperty("PlanningSystem")
    protected String planningSystem;
    @JsonProperty("ProcurementMethod")
    protected String procurementMethod;
    @JsonProperty("ComponentWarehouse")
    protected String componentWarehouse;
    @JsonProperty("OrderIntervals")
    protected Long orderIntervals;
    @JsonProperty("OrderMultiple")
    protected Double orderMultiple;
    @JsonProperty("LeadTime")
    protected Long leadTime;
    @JsonProperty("MinOrderQuantity")
    protected Double minOrderQuantity;
    @JsonProperty("ItemType")
    protected String itemType;
    @JsonProperty("ItemClass")
    protected String itemClass;
    @JsonProperty("OutgoingServiceCode")
    protected Long outgoingServiceCode;
    @JsonProperty("IncomingServiceCode")
    protected Long incomingServiceCode;
    @JsonProperty("ServiceGroup")
    protected Long serviceGroup;
    @JsonProperty("NCMCode")
    protected Long ncmCode;
    @JsonProperty("MaterialType")
    protected String materialType;
    @JsonProperty("MaterialGroup")
    protected Long materialGroup;
    @JsonProperty("ProductSource")
    protected String productSource;
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
    @JsonProperty("AutoCreateSerialNumbersOnRelease")
    protected String autoCreateSerialNumbersOnRelease;
    @JsonProperty("DNFEntry")
    protected Long dnfEntry;
    @JsonProperty("GTSItemSpec")
    protected String gtsItemSpec;
    @JsonProperty("GTSItemTaxCategory")
    protected String gtsItemTaxCategory;
    @JsonProperty("FuelID")
    protected Long fuelID;
    @JsonProperty("BeverageTableCode")
    protected String beverageTableCode;
    @JsonProperty("BeverageGroupCode")
    protected String beverageGroupCode;
    @JsonProperty("BeverageCommercialBrandCode")
    protected Long beverageCommercialBrandCode;
    @JsonProperty("Series")
    protected Long series;
    @JsonProperty("ToleranceDays")
    protected Long toleranceDays;
    @JsonProperty("TypeOfAdvancedRules")
    protected String typeOfAdvancedRules;
    @JsonProperty("IssuePrimarilyBy")
    protected String issuePrimarilyBy;
    @JsonProperty("NoDiscounts")
    protected String noDiscounts;
    @JsonProperty("AssetClass")
    protected String assetClass;
    @JsonProperty("AssetGroup")
    protected String assetGroup;
    @JsonProperty("InventoryNumber")
    protected String inventoryNumber;
    @JsonProperty("Technician")
    protected Long technician;
    @JsonProperty("Employee")
    protected Long employee;
    @JsonProperty("Location")
    protected Long location;
    @JsonProperty("AssetStatus")
    protected String assetStatus;
    @JsonProperty("CapitalizationDate")
    protected String capitalizationDate;
    @JsonProperty("StatisticalAsset")
    protected String statisticalAsset;
    @JsonProperty("Cession")
    protected String cession;
    @JsonProperty("DeactivateAfterUsefulLife")
    protected String deactivateAfterUsefulLife;
    @JsonProperty("ManageByQuantity")
    protected String manageByQuantity;
    @JsonProperty("UoMGroupEntry")
    protected Long uoMGroupEntry;
    @JsonProperty("InventoryUoMEntry")
    protected Long inventoryUoMEntry;
    @JsonProperty("DefaultSalesUoMEntry")
    protected Long defaultSalesUoMEntry;
    @JsonProperty("DefaultPurchasingUoMEntry")
    protected Long defaultPurchasingUoMEntry;
    @JsonProperty("DepreciationGroup")
    protected String depreciationGroup;
    @JsonProperty("AssetSerialNumber")
    protected String assetSerialNumber;
    @JsonProperty("InventoryWeight")
    protected Double inventoryWeight;
    @JsonProperty("InventoryWeightUnit")
    protected Long inventoryWeightUnit;
    @JsonProperty("InventoryWeight1")
    protected Double inventoryWeight1;
    @JsonProperty("InventoryWeightUnit1")
    protected Long inventoryWeightUnit1;
    @JsonProperty("DefaultCountingUnit")
    protected String defaultCountingUnit;
    @JsonProperty("CountingItemsPerUnit")
    protected Double countingItemsPerUnit;
    @JsonProperty("DefaultCountingUoMEntry")
    protected Long defaultCountingUoMEntry;
    @JsonProperty("Excisable")
    protected String excisable;
    @JsonProperty("ChapterID")
    protected Long chapterID;
    @JsonProperty("ScsCode")
    protected String scsCode;
    @JsonProperty("SpProdType")
    protected String spProdType;
    @JsonProperty("InCostRollup")
    protected String inCostRoll;
    @JsonProperty("VirtualAssetItem")
    protected String virtAstItm;
    @JsonProperty("EnforceAssetSerialNumbers")
    protected String enAstSeri;
    @JsonProperty("UpdateDate")
    protected String updateDate;
    @JsonProperty("UpdateTime")
    protected String updateTime;
    @JsonProperty("GSTRelevnt")
    protected String gstRelevnt;
    @JsonProperty("SACEntry")
    protected Long sacEntry;
    @JsonProperty("GSTTaxCategory")
    protected String gstTaxCtg;
    @JsonProperty("ServiceCategoryEntry")
    protected Long serviceCtg;
    @JsonProperty("AssessableValue")
    protected Double assblValue;
    @JsonProperty("AssVal4WTR")
    protected Double assVal4WTR;
    @JsonProperty("SOIExcisable")
    protected String soiExc;
    @JsonProperty("ImportedItem")
    protected String imported;
    @JsonProperty("PricingPrc")
    protected Double pricingPrc;
    @JsonProperty("PricingUnit")
    protected Long priceUnit;
    @JsonProperty("CreateDate")
    protected String createDate;
    @JsonProperty("CreateTime")
    protected String createTime;
    @JsonProperty("ProdStdCost")
    protected Double prdStdCst;
    @JsonProperty("AttachmentEntry")
    protected Integer AtcEntry;
    @JsonProperty("U_Equiv_Box")
    protected Integer uEquivBox;
    @JsonProperty("U_Marcas_info")
    protected String uMarcasInfo;
    @JsonProperty("U_Grupo")
    protected String uGrupo;
    @JsonProperty("U_Subgrupo")
    protected String uSubgrupo;
    @JsonProperty("U_Marca")
    protected String uMarca;
    @JsonProperty("U_SUBMARCA")
    protected String uSubMarca;
    @JsonProperty("U_Procedencia")
    protected String uProcedencia;
    @JsonProperty("U_Modelo")
    protected String uModelo;
    @JsonProperty("U_Cod_Anterior")
    protected String uCodAnterior;
    @JsonProperty("U_COSTOIMP")
    protected String ucostoimp;
    @JsonProperty("U_FEC_CREA")
    protected String ufeccrea;
    @JsonProperty("U_UNI_PRO_VTAS")
    protected Double uuniprovtas;
    @JsonProperty("U_VLGX_VIV")
    protected String uvlgxviv;
    @JsonProperty("U_VLGX_ORD")
    protected String uvlgxord;
    @JsonProperty("U_VLGX_BOM")
    protected String uvlgxbom;
    @JsonProperty("U_VLGX_PLN")
    protected String uvlgxpln;
    @JsonProperty("U_VLGX_SUP")
    protected String uvlgxsup;
    @JsonProperty("U_Varroc_Item_Code")
    protected String uVarrocItemCode;
    @JsonProperty("U_WMS_Velocity")
    protected String uwmsVelocity;
    @JsonProperty("U_Aplicacion")
    protected String uAplicacion;
    @JsonProperty("U_Type")
    protected String uType;
    @JsonProperty("U_NWR_SCRP")
    protected Double unwrscrp;
    @JsonProperty("U_NWRWOPO")
    protected Long unwrwopo;
    @JsonProperty("U_NWR_MATRIX")
    protected Long unwrmatrix;
    @JsonProperty("U_NWR_AutoShipment")
    protected String unwrAutoShipment;
    @JsonProperty("U_Tipo_Inventario")
    protected String uTipoInventario;
    @JsonProperty("U_Responsable")
    protected String uResponsable;
    @JsonProperty("U_VLGX_CA")
    protected String uvlgxca;
    @JsonProperty("U_CATEGORIA")
    protected String uCategoria;
    @JsonProperty("U_CATALOGO")
    protected String uCatalogo;
    @JsonProperty("U_TIPO_LLANTA")
    protected String uTipoLlanta;
    @JsonProperty("U_ANCHO_LLANTA")
    protected String uAnchoLlanta;
    @JsonProperty("U_RIN_LLANTA")
    protected String uRinLlanta;
    @JsonProperty("U_PERFIL_LLANTA")
    protected String uPerfilLlanta;
    @JsonProperty("U_TALLA")
    protected String uTalla;
    @JsonProperty("U_COLOR_CADENA")
    protected String uColorCadena;
    @JsonProperty("U_VISCOSIDAD")
    protected String uViscosidad;
    @JsonProperty("U_BASE")
    protected String uBase;
    @JsonProperty("U_ARTICULO")
    protected String uArticulo;
    @JsonProperty("U_KEYWORDS")
    protected String uKeywords;
    @JsonProperty("U_PASO_CADENA")
    protected String uPasoCadena;
    @JsonProperty("U_TIPO")
    protected String uTipo;
    @JsonProperty("U_EsAIU")
    protected String uEsAIU;
    @JsonProperty("U_PorcAIU")
    protected String uPorcAIU;
    @JsonProperty("U_CalcAIU")
    protected String uCalcAIU;
    @JsonProperty("U_LARGO_CADENA")
    protected String uLargoCadena;
    protected List<ItemsRestDTO.ItemPrices.ItemPrice> itemPrices;
    protected List<ItemsRestDTO.ItemWarehouseInfoCollection.ItemWarehouseInfo> itemWarehouseInfoCollection;
    protected List<ItemsRestDTO.ItemPreferredVendors.ItemPreferredVendor> itemPreferredVendors;
    protected List<ItemsRestDTO.ItemLocalizationInfos.ItemLocalizationInfo> itemLocalizationInfos;
    protected List<ItemsRestDTO.ItemProjects.ItemProject> itemProjects;
    protected List<ItemsRestDTO.ItemDistributionRules.ItemDistributionRule> itemDistributionRules;
    protected List<ItemsRestDTO.ItemAttributeGroups> itemAttributeGroups;
    protected List<ItemsRestDTO.ItemBarCodeCollection.ItemBarCode> itemBarCodeCollection;
    protected List<ItemsRestDTO.ItemDepreciationParameters.ItemDepreciationParameter> itemDepreciationParameters;
    protected List<ItemsRestDTO.ItemIntrastatExtension> itemIntrastatExtension;
    protected List<ItemsRestDTO.ItemPeriodControls.ItemPeriodControl> itemPeriodControls;
    protected List<ItemsRestDTO.ItemUnitOfMeasurementCollection.ItemUnitOfMeasurement> itemUnitOfMeasurementCollection;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getForeignName() {
        return foreignName;
    }

    public void setForeignName(String foreignName) {
        this.foreignName = foreignName;
    }

    public Long getItemsGroupCode() {
        return itemsGroupCode;
    }

    public void setItemsGroupCode(Long itemsGroupCode) {
        this.itemsGroupCode = itemsGroupCode;
    }

    public Long getCustomsGroupCode() {
        return customsGroupCode;
    }

    public void setCustomsGroupCode(Long customsGroupCode) {
        this.customsGroupCode = customsGroupCode;
    }

    public String getSalesVATGroup() {
        return salesVATGroup;
    }

    public void setSalesVATGroup(String salesVATGroup) {
        this.salesVATGroup = salesVATGroup;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getVatLiable() {
        return vatLiable;
    }

    public void setVatLiable(String vatLiable) {
        this.vatLiable = vatLiable;
    }

    public String getPurchaseItem() {
        return purchaseItem;
    }

    public void setPurchaseItem(String purchaseItem) {
        this.purchaseItem = purchaseItem;
    }

    public String getSalesItem() {
        return salesItem;
    }

    public void setSalesItem(String salesItem) {
        this.salesItem = salesItem;
    }

    public String getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(String inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    public String getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(String incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public String getExemptIncomeAccount() {
        return exemptIncomeAccount;
    }

    public void setExemptIncomeAccount(String exemptIncomeAccount) {
        this.exemptIncomeAccount = exemptIncomeAccount;
    }

    public String getExpanseAccount() {
        return expanseAccount;
    }

    public void setExpanseAccount(String expanseAccount) {
        this.expanseAccount = expanseAccount;
    }

    public String getMainsupplier() {
        return mainsupplier;
    }

    public void setMainsupplier(String mainsupplier) {
        this.mainsupplier = mainsupplier;
    }

    public String getSupplierCatalogNo() {
        return supplierCatalogNo;
    }

    public void setSupplierCatalogNo(String supplierCatalogNo) {
        this.supplierCatalogNo = supplierCatalogNo;
    }

    public Double getDesiredInventory() {
        return desiredInventory;
    }

    public void setDesiredInventory(Double desiredInventory) {
        this.desiredInventory = desiredInventory;
    }

    public Double getMinInventory() {
        return minInventory;
    }

    public void setMinInventory(Double minInventory) {
        this.minInventory = minInventory;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUserText() {
        return userText;
    }

    public void setUserText(String userText) {
        this.userText = userText;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public Double getCommissionPercent() {
        return commissionPercent;
    }

    public void setCommissionPercent(Double commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public Double getCommissionSum() {
        return commissionSum;
    }

    public void setCommissionSum(Double commissionSum) {
        this.commissionSum = commissionSum;
    }

    public Long getCommissionGroup() {
        return commissionGroup;
    }

    public void setCommissionGroup(Long commissionGroup) {
        this.commissionGroup = commissionGroup;
    }

    public String getTreeType() {
        return treeType;
    }

    public void setTreeType(String treeType) {
        this.treeType = treeType;
    }

    public String getAssetItem() {
        return assetItem;
    }

    public void setAssetItem(String assetItem) {
        this.assetItem = assetItem;
    }

    public String getDataExportCode() {
        return dataExportCode;
    }

    public void setDataExportCode(String dataExportCode) {
        this.dataExportCode = dataExportCode;
    }

    public Long getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Long manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getQuantityOnStock() {
        return quantityOnStock;
    }

    public void setQuantityOnStock(Double quantityOnStock) {
        this.quantityOnStock = quantityOnStock;
    }

    public Double getQuantityOrderedFromVendors() {
        return quantityOrderedFromVendors;
    }

    public void setQuantityOrderedFromVendors(Double quantityOrderedFromVendors) {
        this.quantityOrderedFromVendors = quantityOrderedFromVendors;
    }

    public Double getQuantityOrderedByCustomers() {
        return quantityOrderedByCustomers;
    }

    public void setQuantityOrderedByCustomers(Double quantityOrderedByCustomers) {
        this.quantityOrderedByCustomers = quantityOrderedByCustomers;
    }

    public String getManageSerialNumbers() {
        return manageSerialNumbers;
    }

    public void setManageSerialNumbers(String manageSerialNumbers) {
        this.manageSerialNumbers = manageSerialNumbers;
    }

    public String getManageBatchNumbers() {
        return manageBatchNumbers;
    }

    public void setManageBatchNumbers(String manageBatchNumbers) {
        this.manageBatchNumbers = manageBatchNumbers;
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

    public String getSalesUnit() {
        return salesUnit;
    }

    public void setSalesUnit(String salesUnit) {
        this.salesUnit = salesUnit;
    }

    public Double getSalesItemsPerUnit() {
        return salesItemsPerUnit;
    }

    public void setSalesItemsPerUnit(Double salesItemsPerUnit) {
        this.salesItemsPerUnit = salesItemsPerUnit;
    }

    public String getSalesPackagingUnit() {
        return salesPackagingUnit;
    }

    public void setSalesPackagingUnit(String salesPackagingUnit) {
        this.salesPackagingUnit = salesPackagingUnit;
    }

    public Double getSalesQtyPerPackUnit() {
        return salesQtyPerPackUnit;
    }

    public void setSalesQtyPerPackUnit(Double salesQtyPerPackUnit) {
        this.salesQtyPerPackUnit = salesQtyPerPackUnit;
    }

    public Double getSalesUnitLength() {
        return salesUnitLength;
    }

    public void setSalesUnitLength(Double salesUnitLength) {
        this.salesUnitLength = salesUnitLength;
    }

    public Long getSalesLengthUnit() {
        return salesLengthUnit;
    }

    public void setSalesLengthUnit(Long salesLengthUnit) {
        this.salesLengthUnit = salesLengthUnit;
    }

    public Double getSalesUnitWidth() {
        return salesUnitWidth;
    }

    public void setSalesUnitWidth(Double salesUnitWidth) {
        this.salesUnitWidth = salesUnitWidth;
    }

    public Long getSalesWidthUnit() {
        return salesWidthUnit;
    }

    public void setSalesWidthUnit(Long salesWidthUnit) {
        this.salesWidthUnit = salesWidthUnit;
    }

    public Double getSalesUnitHeight() {
        return salesUnitHeight;
    }

    public void setSalesUnitHeight(Double salesUnitHeight) {
        this.salesUnitHeight = salesUnitHeight;
    }

    public Long getSalesHeightUnit() {
        return salesHeightUnit;
    }

    public void setSalesHeightUnit(Long salesHeightUnit) {
        this.salesHeightUnit = salesHeightUnit;
    }

    public Double getSalesUnitVolume() {
        return salesUnitVolume;
    }

    public void setSalesUnitVolume(Double salesUnitVolume) {
        this.salesUnitVolume = salesUnitVolume;
    }

    public Long getSalesVolumeUnit() {
        return salesVolumeUnit;
    }

    public void setSalesVolumeUnit(Long salesVolumeUnit) {
        this.salesVolumeUnit = salesVolumeUnit;
    }

    public Double getSalesUnitWeight() {
        return salesUnitWeight;
    }

    public void setSalesUnitWeight(Double salesUnitWeight) {
        this.salesUnitWeight = salesUnitWeight;
    }

    public Long getSalesWeightUnit() {
        return salesWeightUnit;
    }

    public void setSalesWeightUnit(Long salesWeightUnit) {
        this.salesWeightUnit = salesWeightUnit;
    }

    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }

    public Double getPurchaseItemsPerUnit() {
        return purchaseItemsPerUnit;
    }

    public void setPurchaseItemsPerUnit(Double purchaseItemsPerUnit) {
        this.purchaseItemsPerUnit = purchaseItemsPerUnit;
    }

    public String getPurchasePackagingUnit() {
        return purchasePackagingUnit;
    }

    public void setPurchasePackagingUnit(String purchasePackagingUnit) {
        this.purchasePackagingUnit = purchasePackagingUnit;
    }

    public Double getPurchaseQtyPerPackUnit() {
        return purchaseQtyPerPackUnit;
    }

    public void setPurchaseQtyPerPackUnit(Double purchaseQtyPerPackUnit) {
        this.purchaseQtyPerPackUnit = purchaseQtyPerPackUnit;
    }

    public Double getPurchaseUnitLength() {
        return purchaseUnitLength;
    }

    public void setPurchaseUnitLength(Double purchaseUnitLength) {
        this.purchaseUnitLength = purchaseUnitLength;
    }

    public Long getPurchaseLengthUnit() {
        return purchaseLengthUnit;
    }

    public void setPurchaseLengthUnit(Long purchaseLengthUnit) {
        this.purchaseLengthUnit = purchaseLengthUnit;
    }

    public Double getPurchaseUnitWidth() {
        return purchaseUnitWidth;
    }

    public void setPurchaseUnitWidth(Double purchaseUnitWidth) {
        this.purchaseUnitWidth = purchaseUnitWidth;
    }

    public Long getPurchaseWidthUnit() {
        return purchaseWidthUnit;
    }

    public void setPurchaseWidthUnit(Long purchaseWidthUnit) {
        this.purchaseWidthUnit = purchaseWidthUnit;
    }

    public Double getPurchaseUnitHeight() {
        return purchaseUnitHeight;
    }

    public void setPurchaseUnitHeight(Double purchaseUnitHeight) {
        this.purchaseUnitHeight = purchaseUnitHeight;
    }

    public Long getPurchaseHeightUnit() {
        return purchaseHeightUnit;
    }

    public void setPurchaseHeightUnit(Long purchaseHeightUnit) {
        this.purchaseHeightUnit = purchaseHeightUnit;
    }

    public Double getPurchaseUnitVolume() {
        return purchaseUnitVolume;
    }

    public void setPurchaseUnitVolume(Double purchaseUnitVolume) {
        this.purchaseUnitVolume = purchaseUnitVolume;
    }

    public Long getPurchaseVolumeUnit() {
        return purchaseVolumeUnit;
    }

    public void setPurchaseVolumeUnit(Long purchaseVolumeUnit) {
        this.purchaseVolumeUnit = purchaseVolumeUnit;
    }

    public Double getPurchaseUnitWeight() {
        return purchaseUnitWeight;
    }

    public void setPurchaseUnitWeight(Double purchaseUnitWeight) {
        this.purchaseUnitWeight = purchaseUnitWeight;
    }

    public Long getPurchaseWeightUnit() {
        return purchaseWeightUnit;
    }

    public void setPurchaseWeightUnit(Long purchaseWeightUnit) {
        this.purchaseWeightUnit = purchaseWeightUnit;
    }

    public String getPurchaseVATGroup() {
        return purchaseVATGroup;
    }

    public void setPurchaseVATGroup(String purchaseVATGroup) {
        this.purchaseVATGroup = purchaseVATGroup;
    }

    public Double getSalesFactor1() {
        return salesFactor1;
    }

    public void setSalesFactor1(Double salesFactor1) {
        this.salesFactor1 = salesFactor1;
    }

    public Double getSalesFactor2() {
        return salesFactor2;
    }

    public void setSalesFactor2(Double salesFactor2) {
        this.salesFactor2 = salesFactor2;
    }

    public Double getSalesFactor3() {
        return salesFactor3;
    }

    public void setSalesFactor3(Double salesFactor3) {
        this.salesFactor3 = salesFactor3;
    }

    public Double getSalesFactor4() {
        return salesFactor4;
    }

    public void setSalesFactor4(Double salesFactor4) {
        this.salesFactor4 = salesFactor4;
    }

    public Double getPurchaseFactor1() {
        return purchaseFactor1;
    }

    public void setPurchaseFactor1(Double purchaseFactor1) {
        this.purchaseFactor1 = purchaseFactor1;
    }

    public Double getPurchaseFactor2() {
        return purchaseFactor2;
    }

    public void setPurchaseFactor2(Double purchaseFactor2) {
        this.purchaseFactor2 = purchaseFactor2;
    }

    public Double getPurchaseFactor3() {
        return purchaseFactor3;
    }

    public void setPurchaseFactor3(Double purchaseFactor3) {
        this.purchaseFactor3 = purchaseFactor3;
    }

    public Double getPurchaseFactor4() {
        return purchaseFactor4;
    }

    public void setPurchaseFactor4(Double purchaseFactor4) {
        this.purchaseFactor4 = purchaseFactor4;
    }

    public Double getMovingAveragePrice() {
        return movingAveragePrice;
    }

    public void setMovingAveragePrice(Double movingAveragePrice) {
        this.movingAveragePrice = movingAveragePrice;
    }

    public String getForeignRevenuesAccount() {
        return foreignRevenuesAccount;
    }

    public void setForeignRevenuesAccount(String foreignRevenuesAccount) {
        this.foreignRevenuesAccount = foreignRevenuesAccount;
    }

    public String getEcRevenuesAccount() {
        return ecRevenuesAccount;
    }

    public void setEcRevenuesAccount(String ecRevenuesAccount) {
        this.ecRevenuesAccount = ecRevenuesAccount;
    }

    public String getForeignExpensesAccount() {
        return foreignExpensesAccount;
    }

    public void setForeignExpensesAccount(String foreignExpensesAccount) {
        this.foreignExpensesAccount = foreignExpensesAccount;
    }

    public String getEcExpensesAccount() {
        return ecExpensesAccount;
    }

    public void setEcExpensesAccount(String ecExpensesAccount) {
        this.ecExpensesAccount = ecExpensesAccount;
    }

    public Double getAvgStdPrice() {
        return avgStdPrice;
    }

    public void setAvgStdPrice(Double avgStdPrice) {
        this.avgStdPrice = avgStdPrice;
    }

    public String getDefaultWarehouse() {
        return defaultWarehouse;
    }

    public void setDefaultWarehouse(String defaultWarehouse) {
        this.defaultWarehouse = defaultWarehouse;
    }

    public Long getShipType() {
        return shipType;
    }

    public void setShipType(Long shipType) {
        this.shipType = shipType;
    }

    public String getGlMethod() {
        return glMethod;
    }

    public void setGlMethod(String glMethod) {
        this.glMethod = glMethod;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public Double getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(Double maxInventory) {
        this.maxInventory = maxInventory;
    }

    public String getManageStockByWarehouse() {
        return manageStockByWarehouse;
    }

    public void setManageStockByWarehouse(String manageStockByWarehouse) {
        this.manageStockByWarehouse = manageStockByWarehouse;
    }

    public Long getPurchaseHeightUnit1() {
        return purchaseHeightUnit1;
    }

    public void setPurchaseHeightUnit1(Long purchaseHeightUnit1) {
        this.purchaseHeightUnit1 = purchaseHeightUnit1;
    }

    public Double getPurchaseUnitHeight1() {
        return purchaseUnitHeight1;
    }

    public void setPurchaseUnitHeight1(Double purchaseUnitHeight1) {
        this.purchaseUnitHeight1 = purchaseUnitHeight1;
    }

    public Long getPurchaseLengthUnit1() {
        return purchaseLengthUnit1;
    }

    public void setPurchaseLengthUnit1(Long purchaseLengthUnit1) {
        this.purchaseLengthUnit1 = purchaseLengthUnit1;
    }

    public Double getPurchaseUnitLength1() {
        return purchaseUnitLength1;
    }

    public void setPurchaseUnitLength1(Double purchaseUnitLength1) {
        this.purchaseUnitLength1 = purchaseUnitLength1;
    }

    public Long getPurchaseWeightUnit1() {
        return purchaseWeightUnit1;
    }

    public void setPurchaseWeightUnit1(Long purchaseWeightUnit1) {
        this.purchaseWeightUnit1 = purchaseWeightUnit1;
    }

    public Double getPurchaseUnitWeight1() {
        return purchaseUnitWeight1;
    }

    public void setPurchaseUnitWeight1(Double purchaseUnitWeight1) {
        this.purchaseUnitWeight1 = purchaseUnitWeight1;
    }

    public Long getPurchaseWidthUnit1() {
        return purchaseWidthUnit1;
    }

    public void setPurchaseWidthUnit1(Long purchaseWidthUnit1) {
        this.purchaseWidthUnit1 = purchaseWidthUnit1;
    }

    public Double getPurchaseUnitWidth1() {
        return purchaseUnitWidth1;
    }

    public void setPurchaseUnitWidth1(Double purchaseUnitWidth1) {
        this.purchaseUnitWidth1 = purchaseUnitWidth1;
    }

    public Long getSalesHeightUnit1() {
        return salesHeightUnit1;
    }

    public void setSalesHeightUnit1(Long salesHeightUnit1) {
        this.salesHeightUnit1 = salesHeightUnit1;
    }

    public Double getSalesUnitHeight1() {
        return salesUnitHeight1;
    }

    public void setSalesUnitHeight1(Double salesUnitHeight1) {
        this.salesUnitHeight1 = salesUnitHeight1;
    }

    public Long getSalesLengthUnit1() {
        return salesLengthUnit1;
    }

    public void setSalesLengthUnit1(Long salesLengthUnit1) {
        this.salesLengthUnit1 = salesLengthUnit1;
    }

    public Double getSalesUnitLength1() {
        return salesUnitLength1;
    }

    public void setSalesUnitLength1(Double salesUnitLength1) {
        this.salesUnitLength1 = salesUnitLength1;
    }

    public Long getSalesWeightUnit1() {
        return salesWeightUnit1;
    }

    public void setSalesWeightUnit1(Long salesWeightUnit1) {
        this.salesWeightUnit1 = salesWeightUnit1;
    }

    public Double getSalesUnitWeight1() {
        return salesUnitWeight1;
    }

    public void setSalesUnitWeight1(Double salesUnitWeight1) {
        this.salesUnitWeight1 = salesUnitWeight1;
    }

    public Long getSalesWidthUnit1() {
        return salesWidthUnit1;
    }

    public void setSalesWidthUnit1(Long salesWidthUnit1) {
        this.salesWidthUnit1 = salesWidthUnit1;
    }

    public Double getSalesUnitWidth1() {
        return salesUnitWidth1;
    }

    public void setSalesUnitWidth1(Double salesUnitWidth1) {
        this.salesUnitWidth1 = salesUnitWidth1;
    }

    public String getForceSelectionOfSerialNumber() {
        return forceSelectionOfSerialNumber;
    }

    public void setForceSelectionOfSerialNumber(String forceSelectionOfSerialNumber) {
        this.forceSelectionOfSerialNumber = forceSelectionOfSerialNumber;
    }

    public String getManageSerialNumbersOnReleaseOnly() {
        return manageSerialNumbersOnReleaseOnly;
    }

    public void setManageSerialNumbersOnReleaseOnly(String manageSerialNumbersOnReleaseOnly) {
        this.manageSerialNumbersOnReleaseOnly = manageSerialNumbersOnReleaseOnly;
    }

    public String getWtLiable() {
        return wtLiable;
    }

    public void setWtLiable(String wtLiable) {
        this.wtLiable = wtLiable;
    }

    public String getCostAccountingMethod() {
        return costAccountingMethod;
    }

    public void setCostAccountingMethod(String costAccountingMethod) {
        this.costAccountingMethod = costAccountingMethod;
    }

    public String getSww() {
        return sww;
    }

    public void setSww(String sww) {
        this.sww = sww;
    }

    public String getWarrantyTemplate() {
        return warrantyTemplate;
    }

    public void setWarrantyTemplate(String warrantyTemplate) {
        this.warrantyTemplate = warrantyTemplate;
    }

    public String getIndirectTax() {
        return indirectTax;
    }

    public void setIndirectTax(String indirectTax) {
        this.indirectTax = indirectTax;
    }

    public String getArTaxCode() {
        return arTaxCode;
    }

    public void setArTaxCode(String arTaxCode) {
        this.arTaxCode = arTaxCode;
    }

    public String getApTaxCode() {
        return apTaxCode;
    }

    public void setApTaxCode(String apTaxCode) {
        this.apTaxCode = apTaxCode;
    }

    public String getBaseUnitName() {
        return baseUnitName;
    }

    public void setBaseUnitName(String baseUnitName) {
        this.baseUnitName = baseUnitName;
    }

    public String getItemCountryOrg() {
        return itemCountryOrg;
    }

    public void setItemCountryOrg(String itemCountryOrg) {
        this.itemCountryOrg = itemCountryOrg;
    }

    public String getIssueMethod() {
        return issueMethod;
    }

    public void setIssueMethod(String issueMethod) {
        this.issueMethod = issueMethod;
    }

    public String getSriAndBatchManageMethod() {
        return sriAndBatchManageMethod;
    }

    public void setSriAndBatchManageMethod(String sriAndBatchManageMethod) {
        this.sriAndBatchManageMethod = sriAndBatchManageMethod;
    }

    public String getIsPhantom() {
        return isPhantom;
    }

    public void setIsPhantom(String isPhantom) {
        this.isPhantom = isPhantom;
    }

    public String getInventoryUOM() {
        return inventoryUOM;
    }

    public void setInventoryUOM(String inventoryUOM) {
        this.inventoryUOM = inventoryUOM;
    }

    public String getPlanningSystem() {
        return planningSystem;
    }

    public void setPlanningSystem(String planningSystem) {
        this.planningSystem = planningSystem;
    }

    public String getProcurementMethod() {
        return procurementMethod;
    }

    public void setProcurementMethod(String procurementMethod) {
        this.procurementMethod = procurementMethod;
    }

    public String getComponentWarehouse() {
        return componentWarehouse;
    }

    public void setComponentWarehouse(String componentWarehouse) {
        this.componentWarehouse = componentWarehouse;
    }

    public Long getOrderIntervals() {
        return orderIntervals;
    }

    public void setOrderIntervals(Long orderIntervals) {
        this.orderIntervals = orderIntervals;
    }

    public Double getOrderMultiple() {
        return orderMultiple;
    }

    public void setOrderMultiple(Double orderMultiple) {
        this.orderMultiple = orderMultiple;
    }

    public Long getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(Long leadTime) {
        this.leadTime = leadTime;
    }

    public Double getMinOrderQuantity() {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Double minOrderQuantity) {
        this.minOrderQuantity = minOrderQuantity;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemClass() {
        return itemClass;
    }

    public void setItemClass(String itemClass) {
        this.itemClass = itemClass;
    }

    public Long getOutgoingServiceCode() {
        return outgoingServiceCode;
    }

    public void setOutgoingServiceCode(Long outgoingServiceCode) {
        this.outgoingServiceCode = outgoingServiceCode;
    }

    public Long getIncomingServiceCode() {
        return incomingServiceCode;
    }

    public void setIncomingServiceCode(Long incomingServiceCode) {
        this.incomingServiceCode = incomingServiceCode;
    }

    public Long getServiceGroup() {
        return serviceGroup;
    }

    public void setServiceGroup(Long serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    public Long getNcmCode() {
        return ncmCode;
    }

    public void setNcmCode(Long ncmCode) {
        this.ncmCode = ncmCode;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Long getMaterialGroup() {
        return materialGroup;
    }

    public void setMaterialGroup(Long materialGroup) {
        this.materialGroup = materialGroup;
    }

    public String getProductSource() {
        return productSource;
    }

    public void setProductSource(String productSource) {
        this.productSource = productSource;
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

    public String getAutoCreateSerialNumbersOnRelease() {
        return autoCreateSerialNumbersOnRelease;
    }

    public void setAutoCreateSerialNumbersOnRelease(String autoCreateSerialNumbersOnRelease) {
        this.autoCreateSerialNumbersOnRelease = autoCreateSerialNumbersOnRelease;
    }

    public Long getDnfEntry() {
        return dnfEntry;
    }

    public void setDnfEntry(Long dnfEntry) {
        this.dnfEntry = dnfEntry;
    }

    public String getGtsItemSpec() {
        return gtsItemSpec;
    }

    public void setGtsItemSpec(String gtsItemSpec) {
        this.gtsItemSpec = gtsItemSpec;
    }

    public String getGtsItemTaxCategory() {
        return gtsItemTaxCategory;
    }

    public void setGtsItemTaxCategory(String gtsItemTaxCategory) {
        this.gtsItemTaxCategory = gtsItemTaxCategory;
    }

    public Long getFuelID() {
        return fuelID;
    }

    public void setFuelID(Long fuelID) {
        this.fuelID = fuelID;
    }

    public String getBeverageTableCode() {
        return beverageTableCode;
    }

    public void setBeverageTableCode(String beverageTableCode) {
        this.beverageTableCode = beverageTableCode;
    }

    public String getBeverageGroupCode() {
        return beverageGroupCode;
    }

    public void setBeverageGroupCode(String beverageGroupCode) {
        this.beverageGroupCode = beverageGroupCode;
    }

    public Long getBeverageCommercialBrandCode() {
        return beverageCommercialBrandCode;
    }

    public void setBeverageCommercialBrandCode(Long beverageCommercialBrandCode) {
        this.beverageCommercialBrandCode = beverageCommercialBrandCode;
    }

    public Long getSeries() {
        return series;
    }

    public void setSeries(Long series) {
        this.series = series;
    }

    public Long getToleranceDays() {
        return toleranceDays;
    }

    public void setToleranceDays(Long toleranceDays) {
        this.toleranceDays = toleranceDays;
    }

    public String getTypeOfAdvancedRules() {
        return typeOfAdvancedRules;
    }

    public void setTypeOfAdvancedRules(String typeOfAdvancedRules) {
        this.typeOfAdvancedRules = typeOfAdvancedRules;
    }

    public String getIssuePrimarilyBy() {
        return issuePrimarilyBy;
    }

    public void setIssuePrimarilyBy(String issuePrimarilyBy) {
        this.issuePrimarilyBy = issuePrimarilyBy;
    }

    public String getNoDiscounts() {
        return noDiscounts;
    }

    public void setNoDiscounts(String noDiscounts) {
        this.noDiscounts = noDiscounts;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getAssetGroup() {
        return assetGroup;
    }

    public void setAssetGroup(String assetGroup) {
        this.assetGroup = assetGroup;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    public Long getTechnician() {
        return technician;
    }

    public void setTechnician(Long technician) {
        this.technician = technician;
    }

    public Long getEmployee() {
        return employee;
    }

    public void setEmployee(Long employee) {
        this.employee = employee;
    }

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }

    public String getCapitalizationDate() {
        return capitalizationDate;
    }

    public void setCapitalizationDate(String capitalizationDate) {
        this.capitalizationDate = capitalizationDate;
    }

    public String getStatisticalAsset() {
        return statisticalAsset;
    }

    public void setStatisticalAsset(String statisticalAsset) {
        this.statisticalAsset = statisticalAsset;
    }

    public String getCession() {
        return cession;
    }

    public void setCession(String cession) {
        this.cession = cession;
    }

    public String getDeactivateAfterUsefulLife() {
        return deactivateAfterUsefulLife;
    }

    public void setDeactivateAfterUsefulLife(String deactivateAfterUsefulLife) {
        this.deactivateAfterUsefulLife = deactivateAfterUsefulLife;
    }

    public String getManageByQuantity() {
        return manageByQuantity;
    }

    public void setManageByQuantity(String manageByQuantity) {
        this.manageByQuantity = manageByQuantity;
    }

    public Long getUoMGroupEntry() {
        return uoMGroupEntry;
    }

    public void setUoMGroupEntry(Long uoMGroupEntry) {
        this.uoMGroupEntry = uoMGroupEntry;
    }

    public Long getInventoryUoMEntry() {
        return inventoryUoMEntry;
    }

    public void setInventoryUoMEntry(Long inventoryUoMEntry) {
        this.inventoryUoMEntry = inventoryUoMEntry;
    }

    public Long getDefaultSalesUoMEntry() {
        return defaultSalesUoMEntry;
    }

    public void setDefaultSalesUoMEntry(Long defaultSalesUoMEntry) {
        this.defaultSalesUoMEntry = defaultSalesUoMEntry;
    }

    public Long getDefaultPurchasingUoMEntry() {
        return defaultPurchasingUoMEntry;
    }

    public void setDefaultPurchasingUoMEntry(Long defaultPurchasingUoMEntry) {
        this.defaultPurchasingUoMEntry = defaultPurchasingUoMEntry;
    }

    public String getDepreciationGroup() {
        return depreciationGroup;
    }

    public void setDepreciationGroup(String depreciationGroup) {
        this.depreciationGroup = depreciationGroup;
    }

    public String getAssetSerialNumber() {
        return assetSerialNumber;
    }

    public void setAssetSerialNumber(String assetSerialNumber) {
        this.assetSerialNumber = assetSerialNumber;
    }

    public Double getInventoryWeight() {
        return inventoryWeight;
    }

    public void setInventoryWeight(Double inventoryWeight) {
        this.inventoryWeight = inventoryWeight;
    }

    public Long getInventoryWeightUnit() {
        return inventoryWeightUnit;
    }

    public void setInventoryWeightUnit(Long inventoryWeightUnit) {
        this.inventoryWeightUnit = inventoryWeightUnit;
    }

    public Double getInventoryWeight1() {
        return inventoryWeight1;
    }

    public void setInventoryWeight1(Double inventoryWeight1) {
        this.inventoryWeight1 = inventoryWeight1;
    }

    public Long getInventoryWeightUnit1() {
        return inventoryWeightUnit1;
    }

    public void setInventoryWeightUnit1(Long inventoryWeightUnit1) {
        this.inventoryWeightUnit1 = inventoryWeightUnit1;
    }

    public String getDefaultCountingUnit() {
        return defaultCountingUnit;
    }

    public void setDefaultCountingUnit(String defaultCountingUnit) {
        this.defaultCountingUnit = defaultCountingUnit;
    }

    public Double getCountingItemsPerUnit() {
        return countingItemsPerUnit;
    }

    public void setCountingItemsPerUnit(Double countingItemsPerUnit) {
        this.countingItemsPerUnit = countingItemsPerUnit;
    }

    public Long getDefaultCountingUoMEntry() {
        return defaultCountingUoMEntry;
    }

    public void setDefaultCountingUoMEntry(Long defaultCountingUoMEntry) {
        this.defaultCountingUoMEntry = defaultCountingUoMEntry;
    }

    public String getExcisable() {
        return excisable;
    }

    public void setExcisable(String excisable) {
        this.excisable = excisable;
    }

    public Long getChapterID() {
        return chapterID;
    }

    public void setChapterID(Long chapterID) {
        this.chapterID = chapterID;
    }

    public String getScsCode() {
        return scsCode;
    }

    public void setScsCode(String scsCode) {
        this.scsCode = scsCode;
    }

    public String getSpProdType() {
        return spProdType;
    }

    public void setSpProdType(String spProdType) {
        this.spProdType = spProdType;
    }

    public String getInCostRoll() {
        return inCostRoll;
    }

    public void setInCostRoll(String inCostRoll) {
        this.inCostRoll = inCostRoll;
    }

    public String getVirtAstItm() {
        return virtAstItm;
    }

    public void setVirtAstItm(String virtAstItm) {
        this.virtAstItm = virtAstItm;
    }

    public String getEnAstSeri() {
        return enAstSeri;
    }

    public void setEnAstSeri(String enAstSeri) {
        this.enAstSeri = enAstSeri;
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

    public String getGstRelevnt() {
        return gstRelevnt;
    }

    public void setGstRelevnt(String gstRelevnt) {
        this.gstRelevnt = gstRelevnt;
    }

    public Long getSacEntry() {
        return sacEntry;
    }

    public void setSacEntry(Long sacEntry) {
        this.sacEntry = sacEntry;
    }

    public String getGstTaxCtg() {
        return gstTaxCtg;
    }

    public void setGstTaxCtg(String gstTaxCtg) {
        this.gstTaxCtg = gstTaxCtg;
    }

    public Long getServiceCtg() {
        return serviceCtg;
    }

    public void setServiceCtg(Long serviceCtg) {
        this.serviceCtg = serviceCtg;
    }

    public Double getAssblValue() {
        return assblValue;
    }

    public void setAssblValue(Double assblValue) {
        this.assblValue = assblValue;
    }

    public Double getAssVal4WTR() {
        return assVal4WTR;
    }

    public void setAssVal4WTR(Double assVal4WTR) {
        this.assVal4WTR = assVal4WTR;
    }

    public String getSoiExc() {
        return soiExc;
    }

    public void setSoiExc(String soiExc) {
        this.soiExc = soiExc;
    }

    public String getImported() {
        return imported;
    }

    public void setImported(String imported) {
        this.imported = imported;
    }

    public Double getPricingPrc() {
        return pricingPrc;
    }

    public void setPricingPrc(Double pricingPrc) {
        this.pricingPrc = pricingPrc;
    }

    public Long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(Long priceUnit) {
        this.priceUnit = priceUnit;
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

    public Double getPrdStdCst() {
        return prdStdCst;
    }

    public void setPrdStdCst(Double prdStdCst) {
        this.prdStdCst = prdStdCst;
    }

    public Integer getAtcEntry() {
        return AtcEntry;
    }

    public void setAtcEntry(Integer atcEntry) {
        AtcEntry = atcEntry;
    }

    public Integer getuEquivBox() {
        return uEquivBox;
    }

    public void setuEquivBox(Integer uEquivBox) {
        this.uEquivBox = uEquivBox;
    }

    public String getuMarcasInfo() {
        return uMarcasInfo;
    }

    public void setuMarcasInfo(String uMarcasInfo) {
        this.uMarcasInfo = uMarcasInfo;
    }

    public String getuGrupo() {
        return uGrupo;
    }

    public void setuGrupo(String uGrupo) {
        this.uGrupo = uGrupo;
    }

    public String getuSubgrupo() {
        return uSubgrupo;
    }

    public void setuSubgrupo(String uSubgrupo) {
        this.uSubgrupo = uSubgrupo;
    }

    public String getuMarca() {
        return uMarca;
    }

    public void setuMarca(String uMarca) {
        this.uMarca = uMarca;
    }

    public String getuSubMarca() {
        return uSubMarca;
    }

    public void setuSubMarca(String uSubMarca) {
        this.uSubMarca = uSubMarca;
    }

    public String getuProcedencia() {
        return uProcedencia;
    }

    public void setuProcedencia(String uProcedencia) {
        this.uProcedencia = uProcedencia;
    }

    public String getuModelo() {
        return uModelo;
    }

    public void setuModelo(String uModelo) {
        this.uModelo = uModelo;
    }

    public String getuCodAnterior() {
        return uCodAnterior;
    }

    public void setuCodAnterior(String uCodAnterior) {
        this.uCodAnterior = uCodAnterior;
    }

    public String getUcostoimp() {
        return ucostoimp;
    }

    public void setUcostoimp(String ucostoimp) {
        this.ucostoimp = ucostoimp;
    }

    public String getUfeccrea() {
        return ufeccrea;
    }

    public void setUfeccrea(String ufeccrea) {
        this.ufeccrea = ufeccrea;
    }

    public Double getUuniprovtas() {
        return uuniprovtas;
    }

    public void setUuniprovtas(Double uuniprovtas) {
        this.uuniprovtas = uuniprovtas;
    }

    public String getUvlgxviv() {
        return uvlgxviv;
    }

    public void setUvlgxviv(String uvlgxviv) {
        this.uvlgxviv = uvlgxviv;
    }

    public String getUvlgxord() {
        return uvlgxord;
    }

    public void setUvlgxord(String uvlgxord) {
        this.uvlgxord = uvlgxord;
    }

    public String getUvlgxbom() {
        return uvlgxbom;
    }

    public void setUvlgxbom(String uvlgxbom) {
        this.uvlgxbom = uvlgxbom;
    }

    public String getUvlgxpln() {
        return uvlgxpln;
    }

    public void setUvlgxpln(String uvlgxpln) {
        this.uvlgxpln = uvlgxpln;
    }

    public String getUvlgxsup() {
        return uvlgxsup;
    }

    public void setUvlgxsup(String uvlgxsup) {
        this.uvlgxsup = uvlgxsup;
    }

    public String getuVarrocItemCode() {
        return uVarrocItemCode;
    }

    public void setuVarrocItemCode(String uVarrocItemCode) {
        this.uVarrocItemCode = uVarrocItemCode;
    }

    public String getUwmsVelocity() {
        return uwmsVelocity;
    }

    public void setUwmsVelocity(String uwmsVelocity) {
        this.uwmsVelocity = uwmsVelocity;
    }

    public String getuAplicacion() {
        return uAplicacion;
    }

    public void setuAplicacion(String uAplicacion) {
        this.uAplicacion = uAplicacion;
    }

    public String getuType() {
        return uType;
    }

    public void setuType(String uType) {
        this.uType = uType;
    }

    public Double getUnwrscrp() {
        return unwrscrp;
    }

    public void setUnwrscrp(Double unwrscrp) {
        this.unwrscrp = unwrscrp;
    }

    public Long getUnwrwopo() {
        return unwrwopo;
    }

    public void setUnwrwopo(Long unwrwopo) {
        this.unwrwopo = unwrwopo;
    }

    public Long getUnwrmatrix() {
        return unwrmatrix;
    }

    public void setUnwrmatrix(Long unwrmatrix) {
        this.unwrmatrix = unwrmatrix;
    }

    public String getUnwrAutoShipment() {
        return unwrAutoShipment;
    }

    public void setUnwrAutoShipment(String unwrAutoShipment) {
        this.unwrAutoShipment = unwrAutoShipment;
    }

    public String getuTipoInventario() {
        return uTipoInventario;
    }

    public void setuTipoInventario(String uTipoInventario) {
        this.uTipoInventario = uTipoInventario;
    }

    public String getuResponsable() {
        return uResponsable;
    }

    public void setuResponsable(String uResponsable) {
        this.uResponsable = uResponsable;
    }

    public String getUvlgxca() {
        return uvlgxca;
    }

    public void setUvlgxca(String uvlgxca) {
        this.uvlgxca = uvlgxca;
    }

    public String getuCategoria() {
        return uCategoria;
    }

    public void setuCategoria(String uCategoria) {
        this.uCategoria = uCategoria;
    }

    public String getuCatalogo() {
        return uCatalogo;
    }

    public void setuCatalogo(String uCatalogo) {
        this.uCatalogo = uCatalogo;
    }

    public String getuTipoLlanta() {
        return uTipoLlanta;
    }

    public void setuTipoLlanta(String uTipoLlanta) {
        this.uTipoLlanta = uTipoLlanta;
    }

    public String getuAnchoLlanta() {
        return uAnchoLlanta;
    }

    public void setuAnchoLlanta(String uAnchoLlanta) {
        this.uAnchoLlanta = uAnchoLlanta;
    }

    public String getuRinLlanta() {
        return uRinLlanta;
    }

    public void setuRinLlanta(String uRinLlanta) {
        this.uRinLlanta = uRinLlanta;
    }

    public String getuPerfilLlanta() {
        return uPerfilLlanta;
    }

    public void setuPerfilLlanta(String uPerfilLlanta) {
        this.uPerfilLlanta = uPerfilLlanta;
    }

    public String getuTalla() {
        return uTalla;
    }

    public void setuTalla(String uTalla) {
        this.uTalla = uTalla;
    }

    public String getuColorCadena() {
        return uColorCadena;
    }

    public void setuColorCadena(String uColorCadena) {
        this.uColorCadena = uColorCadena;
    }

    public String getuViscosidad() {
        return uViscosidad;
    }

    public void setuViscosidad(String uViscosidad) {
        this.uViscosidad = uViscosidad;
    }

    public String getuBase() {
        return uBase;
    }

    public void setuBase(String uBase) {
        this.uBase = uBase;
    }

    public String getuArticulo() {
        return uArticulo;
    }

    public void setuArticulo(String uArticulo) {
        this.uArticulo = uArticulo;
    }

    public String getuKeywords() {
        return uKeywords;
    }

    public void setuKeywords(String uKeywords) {
        this.uKeywords = uKeywords;
    }

    public String getuPasoCadena() {
        return uPasoCadena;
    }

    public void setuPasoCadena(String uPasoCadena) {
        this.uPasoCadena = uPasoCadena;
    }

    public String getuTipo() {
        return uTipo;
    }

    public void setuTipo(String uTipo) {
        this.uTipo = uTipo;
    }

    public String getuEsAIU() {
        return uEsAIU;
    }

    public void setuEsAIU(String uEsAIU) {
        this.uEsAIU = uEsAIU;
    }

    public String getuPorcAIU() {
        return uPorcAIU;
    }

    public void setuPorcAIU(String uPorcAIU) {
        this.uPorcAIU = uPorcAIU;
    }

    public String getuCalcAIU() {
        return uCalcAIU;
    }

    public void setuCalcAIU(String uCalcAIU) {
        this.uCalcAIU = uCalcAIU;
    }

    public String getuLargoCadena() {
        return uLargoCadena;
    }

    public void setuLargoCadena(String uLargoCadena) {
        this.uLargoCadena = uLargoCadena;
    }

    public List<ItemPrices.ItemPrice> getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(List<ItemPrices.ItemPrice> itemPrices) {
        this.itemPrices = itemPrices;
    }

    public List<ItemWarehouseInfoCollection.ItemWarehouseInfo> getItemWarehouseInfoCollection() {
        return itemWarehouseInfoCollection;
    }

    public void setItemWarehouseInfoCollection(List<ItemWarehouseInfoCollection.ItemWarehouseInfo> itemWarehouseInfoCollection) {
        this.itemWarehouseInfoCollection = itemWarehouseInfoCollection;
    }

    public List<ItemPreferredVendors.ItemPreferredVendor> getItemPreferredVendors() {
        return itemPreferredVendors;
    }

    public void setItemPreferredVendors(List<ItemPreferredVendors.ItemPreferredVendor> itemPreferredVendors) {
        this.itemPreferredVendors = itemPreferredVendors;
    }

    public List<ItemLocalizationInfos.ItemLocalizationInfo> getItemLocalizationInfos() {
        return itemLocalizationInfos;
    }

    public void setItemLocalizationInfos(List<ItemLocalizationInfos.ItemLocalizationInfo> itemLocalizationInfos) {
        this.itemLocalizationInfos = itemLocalizationInfos;
    }

    public List<ItemProjects.ItemProject> getItemProjects() {
        return itemProjects;
    }

    public void setItemProjects(List<ItemProjects.ItemProject> itemProjects) {
        this.itemProjects = itemProjects;
    }

    public List<ItemDistributionRules.ItemDistributionRule> getItemDistributionRules() {
        return itemDistributionRules;
    }

    public void setItemDistributionRules(List<ItemDistributionRules.ItemDistributionRule> itemDistributionRules) {
        this.itemDistributionRules = itemDistributionRules;
    }

    public List<ItemAttributeGroups> getItemAttributeGroups() {
        return itemAttributeGroups;
    }

    public void setItemAttributeGroups(List<ItemAttributeGroups> itemAttributeGroups) {
        this.itemAttributeGroups = itemAttributeGroups;
    }

    public List<ItemBarCodeCollection.ItemBarCode> getItemBarCodeCollection() {
        return itemBarCodeCollection;
    }

    public void setItemBarCodeCollection(List<ItemBarCodeCollection.ItemBarCode> itemBarCodeCollection) {
        this.itemBarCodeCollection = itemBarCodeCollection;
    }

    public List<ItemDepreciationParameters.ItemDepreciationParameter> getItemDepreciationParameters() {
        return itemDepreciationParameters;
    }

    public void setItemDepreciationParameters(List<ItemDepreciationParameters.ItemDepreciationParameter> itemDepreciationParameters) {
        this.itemDepreciationParameters = itemDepreciationParameters;
    }

    public List<ItemIntrastatExtension> getItemIntrastatExtension() {
        return itemIntrastatExtension;
    }

    public void setItemIntrastatExtension(List<ItemIntrastatExtension> itemIntrastatExtension) {
        this.itemIntrastatExtension = itemIntrastatExtension;
    }

    public List<ItemPeriodControls.ItemPeriodControl> getItemPeriodControls() {
        return itemPeriodControls;
    }

    public void setItemPeriodControls(List<ItemPeriodControls.ItemPeriodControl> itemPeriodControls) {
        this.itemPeriodControls = itemPeriodControls;
    }

    public List<ItemUnitOfMeasurementCollection.ItemUnitOfMeasurement> getItemUnitOfMeasurementCollection() {
        return itemUnitOfMeasurementCollection;
    }

    public void setItemUnitOfMeasurementCollection(List<ItemUnitOfMeasurementCollection.ItemUnitOfMeasurement> itemUnitOfMeasurementCollection) {
        this.itemUnitOfMeasurementCollection = itemUnitOfMeasurementCollection;
    }

    public static class ItemPrices {
        public static class ItemPrice {
            @JsonProperty("PriceList")
            protected Long priceList;
            @JsonProperty("Price")
            protected Double price;
            @JsonProperty("Currency")
            protected String currency;
            @JsonProperty("AdditionalPrice1")
            protected Double additionalPrice1;
            @JsonProperty("AdditionalCurrency1")
            protected String additionalCurrency1;
            @JsonProperty("AdditionalPrice2")
            protected Double additionalPrice2;
            @JsonProperty("AdditionalCurrency2")
            protected String additionalCurrency2;
            @JsonProperty("BasePriceList")
            protected Long basePriceList;
            @JsonProperty("Factor")
            protected Double factor;
            @JsonProperty("UoMPrices")
            protected ItemsRestDTO.ItemPrices.ItemPrice.UoMPrices uoMPrices;

            public Long getPriceList() {
                return priceList;
            }

            public void setPriceList(Long priceList) {
                this.priceList = priceList;
            }

            public Double getPrice() {
                return price;
            }

            public void setPrice(Double price) {
                this.price = price;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }

            public Double getAdditionalPrice1() {
                return additionalPrice1;
            }

            public void setAdditionalPrice1(Double additionalPrice1) {
                this.additionalPrice1 = additionalPrice1;
            }

            public String getAdditionalCurrency1() {
                return additionalCurrency1;
            }

            public void setAdditionalCurrency1(String additionalCurrency1) {
                this.additionalCurrency1 = additionalCurrency1;
            }

            public Double getAdditionalPrice2() {
                return additionalPrice2;
            }

            public void setAdditionalPrice2(Double additionalPrice2) {
                this.additionalPrice2 = additionalPrice2;
            }

            public String getAdditionalCurrency2() {
                return additionalCurrency2;
            }

            public void setAdditionalCurrency2(String additionalCurrency2) {
                this.additionalCurrency2 = additionalCurrency2;
            }

            public Long getBasePriceList() {
                return basePriceList;
            }

            public void setBasePriceList(Long basePriceList) {
                this.basePriceList = basePriceList;
            }

            public Double getFactor() {
                return factor;
            }

            public void setFactor(Double factor) {
                this.factor = factor;
            }

            public UoMPrices getUoMPrices() {
                return uoMPrices;
            }

            public void setUoMPrices(UoMPrices uoMPrices) {
                this.uoMPrices = uoMPrices;
            }

            public static class UoMPrices {
                public static class UoMPrice {
                    @JsonProperty("PriceList")
                    protected Long priceList;
                    @JsonProperty("UoMEntry")
                    protected Long uoMEntry;
                    @JsonProperty("ReduceBy")
                    protected Double reduceBy;
                    @JsonProperty("Price")
                    protected Double price;
                    @JsonProperty("Currency")
                    protected String currency;
                    @JsonProperty("AdditionalReduceBy1")
                    protected Double additionalReduceBy1;
                    @JsonProperty("AdditionalPrice1")
                    protected Double additionalPrice1;
                    @JsonProperty("AdditionalCurrency1")
                    protected String additionalCurrency1;
                    @JsonProperty("AdditionalReduceBy2")
                    protected Double additionalReduceBy2;
                    @JsonProperty("AdditionalPrice2")
                    protected Double additionalPrice2;
                    @JsonProperty("AdditionalCurrency2")
                    protected String additionalCurrency2;
                    @JsonProperty("Auto")
                    protected String auto;

                    public Long getPriceList() {
                        return priceList;
                    }

                    public void setPriceList(Long priceList) {
                        this.priceList = priceList;
                    }

                    public Long getUoMEntry() {
                        return uoMEntry;
                    }

                    public void setUoMEntry(Long uoMEntry) {
                        this.uoMEntry = uoMEntry;
                    }

                    public Double getReduceBy() {
                        return reduceBy;
                    }

                    public void setReduceBy(Double reduceBy) {
                        this.reduceBy = reduceBy;
                    }

                    public Double getPrice() {
                        return price;
                    }

                    public void setPrice(Double price) {
                        this.price = price;
                    }

                    public String getCurrency() {
                        return currency;
                    }

                    public void setCurrency(String currency) {
                        this.currency = currency;
                    }

                    public Double getAdditionalReduceBy1() {
                        return additionalReduceBy1;
                    }

                    public void setAdditionalReduceBy1(Double additionalReduceBy1) {
                        this.additionalReduceBy1 = additionalReduceBy1;
                    }

                    public Double getAdditionalPrice1() {
                        return additionalPrice1;
                    }

                    public void setAdditionalPrice1(Double additionalPrice1) {
                        this.additionalPrice1 = additionalPrice1;
                    }

                    public String getAdditionalCurrency1() {
                        return additionalCurrency1;
                    }

                    public void setAdditionalCurrency1(String additionalCurrency1) {
                        this.additionalCurrency1 = additionalCurrency1;
                    }

                    public Double getAdditionalReduceBy2() {
                        return additionalReduceBy2;
                    }

                    public void setAdditionalReduceBy2(Double additionalReduceBy2) {
                        this.additionalReduceBy2 = additionalReduceBy2;
                    }

                    public Double getAdditionalPrice2() {
                        return additionalPrice2;
                    }

                    public void setAdditionalPrice2(Double additionalPrice2) {
                        this.additionalPrice2 = additionalPrice2;
                    }

                    public String getAdditionalCurrency2() {
                        return additionalCurrency2;
                    }

                    public void setAdditionalCurrency2(String additionalCurrency2) {
                        this.additionalCurrency2 = additionalCurrency2;
                    }

                    public String getAuto() {
                        return auto;
                    }

                    public void setAuto(String auto) {
                        this.auto = auto;
                    }
                }
            }
        }
    }

    public static class ItemWarehouseInfoCollection {
        public static class ItemWarehouseInfo {
            @JsonProperty("MinimalStock")
            protected Double minimalStock;
            @JsonProperty("MaximalStock")
            protected Double maximalStock;
            @JsonProperty("MinimalOrder")
            protected Double minimalOrder;
            @JsonProperty("StandardAveragePrice")
            protected Double standardAveragePrice;
            @JsonProperty("Locked")
            protected String locked;
            @JsonProperty("InventoryAccount")
            protected String inventoryAccount;
            @JsonProperty("CostAccount")
            protected String costAccount;
            @JsonProperty("TransferAccount")
            protected String transferAccount;
            @JsonProperty("RevenuesAccount")
            protected String revenuesAccount;
            @JsonProperty("VarienceAccount")
            protected String varienceAccount;
            @JsonProperty("DecreasingAccount")
            protected String decreasingAccount;
            @JsonProperty("IncreasingAccount")
            protected String increasingAccount;
            @JsonProperty("ReturningAccount")
            protected String returningAccount;
            @JsonProperty("ExpensesAccount")
            protected String expensesAccount;
            @JsonProperty("EURevenuesAccount")
            protected String euRevenuesAccount;
            @JsonProperty("EUExpensesAccount")
            protected String euExpensesAccount;
            @JsonProperty("ForeignRevenueAcc")
            protected String foreignRevenueAcc;
            @JsonProperty("ForeignExpensAcc")
            protected String foreignExpensAcc;
            @JsonProperty("ExemptIncomeAcc")
            protected String exemptIncomeAcc;
            @JsonProperty("PriceDifferenceAcc")
            protected String priceDifferenceAcc;
            @JsonProperty("WarehouseCode")
            protected String warehouseCode;
            @JsonProperty("InStock")
            protected Double inStock;
            @JsonProperty("Committed")
            protected Double committed;
            @JsonProperty("Ordered")
            protected Double ordered;
            @JsonProperty("CountedQuantity")
            protected Double countedQuantity;
            @JsonProperty("WasCounted")
            protected String wasCounted;
            @JsonProperty("UserSignature")
            protected Long userSignature;
            @JsonProperty("Counted")
            protected Double counted;
            @JsonProperty("ExpenseClearingAct")
            protected String expenseClearingAct;
            @JsonProperty("PurchaseCreditAcc")
            protected String purchaseCreditAcc;
            @JsonProperty("EUPurchaseCreditAcc")
            protected String euPurchaseCreditAcc;
            @JsonProperty("ForeignPurchaseCreditAcc")
            protected String foreignPurchaseCreditAcc;
            @JsonProperty("SalesCreditAcc")
            protected String salesCreditAcc;
            @JsonProperty("SalesCreditEUAcc")
            protected String salesCreditEUAcc;
            @JsonProperty("ExemptedCredits")
            protected String exemptedCredits;
            @JsonProperty("SalesCreditForeignAcc")
            protected String salesCreditForeignAcc;
            @JsonProperty("ExpenseOffsettingAccount")
            protected String expenseOffsettingAccount;
            @JsonProperty("WipAccount")
            protected String wipAccount;
            @JsonProperty("ExchangeRateDifferencesAcct")
            protected String exchangeRateDifferencesAcct;
            @JsonProperty("GoodsClearingAcct")
            protected String goodsClearingAcct;
            @JsonProperty("NegativeInventoryAdjustmentAccount")
            protected String negativeInventoryAdjustmentAccount;
            @JsonProperty("CostInflationOffsetAccount")
            protected String costInflationOffsetAccount;
            @JsonProperty("GLDecreaseAcct")
            protected String glDecreaseAcct;
            @JsonProperty("GLIncreaseAcct")
            protected String glIncreaseAcct;
            @JsonProperty("PAReturnAcct")
            protected String paReturnAcct;
            @JsonProperty("PurchaseAcct")
            protected String purchaseAcct;
            @JsonProperty("PurchaseOffsetAcct")
            protected String purchaseOffsetAcct;
            @JsonProperty("ShippedGoodsAccount")
            protected String shippedGoodsAccount;
            @JsonProperty("StockInflationOffsetAccount")
            protected String stockInflationOffsetAccount;
            @JsonProperty("StockInflationAdjustAccount")
            protected String stockInflationAdjustAccount;
            @JsonProperty("VATInRevenueAccount")
            protected String vatInRevenueAccount;
            @JsonProperty("WipVarianceAccount")
            protected String wipVarianceAccount;
            @JsonProperty("CostInflationAccount")
            protected String costInflationAccount;
            @JsonProperty("WHIncomingCenvatAccount")
            protected String whIncomingCenvatAccount;
            @JsonProperty("WHOutgoingCenvatAccount")
            protected String whOutgoingCenvatAccount;
            @JsonProperty("StockInTransitAccount")
            protected String stockInTransitAccount;
            @JsonProperty("WipOffsetProfitAndLossAccount")
            protected String wipOffsetProfitAndLossAccount;
            @JsonProperty("InventoryOffsetProfitAndLossAccount")
            protected String inventoryOffsetProfitAndLossAccount;
            @JsonProperty("DefaultBin")
            protected Long defaultBin;
            @JsonProperty("DefaultBinEnforced")
            protected String defaultBinEnforced;
            @JsonProperty("PurchaseBalanceAccount")
            protected String purchaseBalanceAccount;
            @JsonProperty("U_UBIC1")
            protected String uubic1;
            @JsonProperty("U_UBIC2")
            protected String uubic2;
            @JsonProperty("U_UBIC3")
            protected String uubic3;
            @JsonProperty("U_UBIC4")
            protected String uubic4;
            @JsonProperty("U_UBIC5")
            protected String uubic5;
            @JsonProperty("U_VLGX_RHT")
            protected String uvlgxrht;
            @JsonProperty("U_VLGX_NSP")
            protected String uvlgxnsp;
            @JsonProperty("U_VLGX_POL")
            protected String uvlgxpol;
            @JsonProperty("ItemCycleCounts")
            protected ItemsRestDTO.ItemWarehouseInfoCollection.ItemWarehouseInfo.ItemCycleCounts itemCycleCounts;

            public Double getMinimalStock() {
                return minimalStock;
            }

            public void setMinimalStock(Double minimalStock) {
                this.minimalStock = minimalStock;
            }

            public Double getMaximalStock() {
                return maximalStock;
            }

            public void setMaximalStock(Double maximalStock) {
                this.maximalStock = maximalStock;
            }

            public Double getMinimalOrder() {
                return minimalOrder;
            }

            public void setMinimalOrder(Double minimalOrder) {
                this.minimalOrder = minimalOrder;
            }

            public Double getStandardAveragePrice() {
                return standardAveragePrice;
            }

            public void setStandardAveragePrice(Double standardAveragePrice) {
                this.standardAveragePrice = standardAveragePrice;
            }

            public String getLocked() {
                return locked;
            }

            public void setLocked(String locked) {
                this.locked = locked;
            }

            public String getInventoryAccount() {
                return inventoryAccount;
            }

            public void setInventoryAccount(String inventoryAccount) {
                this.inventoryAccount = inventoryAccount;
            }

            public String getCostAccount() {
                return costAccount;
            }

            public void setCostAccount(String costAccount) {
                this.costAccount = costAccount;
            }

            public String getTransferAccount() {
                return transferAccount;
            }

            public void setTransferAccount(String transferAccount) {
                this.transferAccount = transferAccount;
            }

            public String getRevenuesAccount() {
                return revenuesAccount;
            }

            public void setRevenuesAccount(String revenuesAccount) {
                this.revenuesAccount = revenuesAccount;
            }

            public String getVarienceAccount() {
                return varienceAccount;
            }

            public void setVarienceAccount(String varienceAccount) {
                this.varienceAccount = varienceAccount;
            }

            public String getDecreasingAccount() {
                return decreasingAccount;
            }

            public void setDecreasingAccount(String decreasingAccount) {
                this.decreasingAccount = decreasingAccount;
            }

            public String getIncreasingAccount() {
                return increasingAccount;
            }

            public void setIncreasingAccount(String increasingAccount) {
                this.increasingAccount = increasingAccount;
            }

            public String getReturningAccount() {
                return returningAccount;
            }

            public void setReturningAccount(String returningAccount) {
                this.returningAccount = returningAccount;
            }

            public String getExpensesAccount() {
                return expensesAccount;
            }

            public void setExpensesAccount(String expensesAccount) {
                this.expensesAccount = expensesAccount;
            }

            public String getEuRevenuesAccount() {
                return euRevenuesAccount;
            }

            public void setEuRevenuesAccount(String euRevenuesAccount) {
                this.euRevenuesAccount = euRevenuesAccount;
            }

            public String getEuExpensesAccount() {
                return euExpensesAccount;
            }

            public void setEuExpensesAccount(String euExpensesAccount) {
                this.euExpensesAccount = euExpensesAccount;
            }

            public String getForeignRevenueAcc() {
                return foreignRevenueAcc;
            }

            public void setForeignRevenueAcc(String foreignRevenueAcc) {
                this.foreignRevenueAcc = foreignRevenueAcc;
            }

            public String getForeignExpensAcc() {
                return foreignExpensAcc;
            }

            public void setForeignExpensAcc(String foreignExpensAcc) {
                this.foreignExpensAcc = foreignExpensAcc;
            }

            public String getExemptIncomeAcc() {
                return exemptIncomeAcc;
            }

            public void setExemptIncomeAcc(String exemptIncomeAcc) {
                this.exemptIncomeAcc = exemptIncomeAcc;
            }

            public String getPriceDifferenceAcc() {
                return priceDifferenceAcc;
            }

            public void setPriceDifferenceAcc(String priceDifferenceAcc) {
                this.priceDifferenceAcc = priceDifferenceAcc;
            }

            public String getWarehouseCode() {
                return warehouseCode;
            }

            public void setWarehouseCode(String warehouseCode) {
                this.warehouseCode = warehouseCode;
            }

            public Double getInStock() {
                return inStock;
            }

            public void setInStock(Double inStock) {
                this.inStock = inStock;
            }

            public Double getCommitted() {
                return committed;
            }

            public void setCommitted(Double committed) {
                this.committed = committed;
            }

            public Double getOrdered() {
                return ordered;
            }

            public void setOrdered(Double ordered) {
                this.ordered = ordered;
            }

            public Double getCountedQuantity() {
                return countedQuantity;
            }

            public void setCountedQuantity(Double countedQuantity) {
                this.countedQuantity = countedQuantity;
            }

            public String getWasCounted() {
                return wasCounted;
            }

            public void setWasCounted(String wasCounted) {
                this.wasCounted = wasCounted;
            }

            public Long getUserSignature() {
                return userSignature;
            }

            public void setUserSignature(Long userSignature) {
                this.userSignature = userSignature;
            }

            public Double getCounted() {
                return counted;
            }

            public void setCounted(Double counted) {
                this.counted = counted;
            }

            public String getExpenseClearingAct() {
                return expenseClearingAct;
            }

            public void setExpenseClearingAct(String expenseClearingAct) {
                this.expenseClearingAct = expenseClearingAct;
            }

            public String getPurchaseCreditAcc() {
                return purchaseCreditAcc;
            }

            public void setPurchaseCreditAcc(String purchaseCreditAcc) {
                this.purchaseCreditAcc = purchaseCreditAcc;
            }

            public String getEuPurchaseCreditAcc() {
                return euPurchaseCreditAcc;
            }

            public void setEuPurchaseCreditAcc(String euPurchaseCreditAcc) {
                this.euPurchaseCreditAcc = euPurchaseCreditAcc;
            }

            public String getForeignPurchaseCreditAcc() {
                return foreignPurchaseCreditAcc;
            }

            public void setForeignPurchaseCreditAcc(String foreignPurchaseCreditAcc) {
                this.foreignPurchaseCreditAcc = foreignPurchaseCreditAcc;
            }

            public String getSalesCreditAcc() {
                return salesCreditAcc;
            }

            public void setSalesCreditAcc(String salesCreditAcc) {
                this.salesCreditAcc = salesCreditAcc;
            }

            public String getSalesCreditEUAcc() {
                return salesCreditEUAcc;
            }

            public void setSalesCreditEUAcc(String salesCreditEUAcc) {
                this.salesCreditEUAcc = salesCreditEUAcc;
            }

            public String getExemptedCredits() {
                return exemptedCredits;
            }

            public void setExemptedCredits(String exemptedCredits) {
                this.exemptedCredits = exemptedCredits;
            }

            public String getSalesCreditForeignAcc() {
                return salesCreditForeignAcc;
            }

            public void setSalesCreditForeignAcc(String salesCreditForeignAcc) {
                this.salesCreditForeignAcc = salesCreditForeignAcc;
            }

            public String getExpenseOffsettingAccount() {
                return expenseOffsettingAccount;
            }

            public void setExpenseOffsettingAccount(String expenseOffsettingAccount) {
                this.expenseOffsettingAccount = expenseOffsettingAccount;
            }

            public String getWipAccount() {
                return wipAccount;
            }

            public void setWipAccount(String wipAccount) {
                this.wipAccount = wipAccount;
            }

            public String getExchangeRateDifferencesAcct() {
                return exchangeRateDifferencesAcct;
            }

            public void setExchangeRateDifferencesAcct(String exchangeRateDifferencesAcct) {
                this.exchangeRateDifferencesAcct = exchangeRateDifferencesAcct;
            }

            public String getGoodsClearingAcct() {
                return goodsClearingAcct;
            }

            public void setGoodsClearingAcct(String goodsClearingAcct) {
                this.goodsClearingAcct = goodsClearingAcct;
            }

            public String getNegativeInventoryAdjustmentAccount() {
                return negativeInventoryAdjustmentAccount;
            }

            public void setNegativeInventoryAdjustmentAccount(String negativeInventoryAdjustmentAccount) {
                this.negativeInventoryAdjustmentAccount = negativeInventoryAdjustmentAccount;
            }

            public String getCostInflationOffsetAccount() {
                return costInflationOffsetAccount;
            }

            public void setCostInflationOffsetAccount(String costInflationOffsetAccount) {
                this.costInflationOffsetAccount = costInflationOffsetAccount;
            }

            public String getGlDecreaseAcct() {
                return glDecreaseAcct;
            }

            public void setGlDecreaseAcct(String glDecreaseAcct) {
                this.glDecreaseAcct = glDecreaseAcct;
            }

            public String getGlIncreaseAcct() {
                return glIncreaseAcct;
            }

            public void setGlIncreaseAcct(String glIncreaseAcct) {
                this.glIncreaseAcct = glIncreaseAcct;
            }

            public String getPaReturnAcct() {
                return paReturnAcct;
            }

            public void setPaReturnAcct(String paReturnAcct) {
                this.paReturnAcct = paReturnAcct;
            }

            public String getPurchaseAcct() {
                return purchaseAcct;
            }

            public void setPurchaseAcct(String purchaseAcct) {
                this.purchaseAcct = purchaseAcct;
            }

            public String getPurchaseOffsetAcct() {
                return purchaseOffsetAcct;
            }

            public void setPurchaseOffsetAcct(String purchaseOffsetAcct) {
                this.purchaseOffsetAcct = purchaseOffsetAcct;
            }

            public String getShippedGoodsAccount() {
                return shippedGoodsAccount;
            }

            public void setShippedGoodsAccount(String shippedGoodsAccount) {
                this.shippedGoodsAccount = shippedGoodsAccount;
            }

            public String getStockInflationOffsetAccount() {
                return stockInflationOffsetAccount;
            }

            public void setStockInflationOffsetAccount(String stockInflationOffsetAccount) {
                this.stockInflationOffsetAccount = stockInflationOffsetAccount;
            }

            public String getStockInflationAdjustAccount() {
                return stockInflationAdjustAccount;
            }

            public void setStockInflationAdjustAccount(String stockInflationAdjustAccount) {
                this.stockInflationAdjustAccount = stockInflationAdjustAccount;
            }

            public String getVatInRevenueAccount() {
                return vatInRevenueAccount;
            }

            public void setVatInRevenueAccount(String vatInRevenueAccount) {
                this.vatInRevenueAccount = vatInRevenueAccount;
            }

            public String getWipVarianceAccount() {
                return wipVarianceAccount;
            }

            public void setWipVarianceAccount(String wipVarianceAccount) {
                this.wipVarianceAccount = wipVarianceAccount;
            }

            public String getCostInflationAccount() {
                return costInflationAccount;
            }

            public void setCostInflationAccount(String costInflationAccount) {
                this.costInflationAccount = costInflationAccount;
            }

            public String getWhIncomingCenvatAccount() {
                return whIncomingCenvatAccount;
            }

            public void setWhIncomingCenvatAccount(String whIncomingCenvatAccount) {
                this.whIncomingCenvatAccount = whIncomingCenvatAccount;
            }

            public String getWhOutgoingCenvatAccount() {
                return whOutgoingCenvatAccount;
            }

            public void setWhOutgoingCenvatAccount(String whOutgoingCenvatAccount) {
                this.whOutgoingCenvatAccount = whOutgoingCenvatAccount;
            }

            public String getStockInTransitAccount() {
                return stockInTransitAccount;
            }

            public void setStockInTransitAccount(String stockInTransitAccount) {
                this.stockInTransitAccount = stockInTransitAccount;
            }

            public String getWipOffsetProfitAndLossAccount() {
                return wipOffsetProfitAndLossAccount;
            }

            public void setWipOffsetProfitAndLossAccount(String wipOffsetProfitAndLossAccount) {
                this.wipOffsetProfitAndLossAccount = wipOffsetProfitAndLossAccount;
            }

            public String getInventoryOffsetProfitAndLossAccount() {
                return inventoryOffsetProfitAndLossAccount;
            }

            public void setInventoryOffsetProfitAndLossAccount(String inventoryOffsetProfitAndLossAccount) {
                this.inventoryOffsetProfitAndLossAccount = inventoryOffsetProfitAndLossAccount;
            }

            public Long getDefaultBin() {
                return defaultBin;
            }

            public void setDefaultBin(Long defaultBin) {
                this.defaultBin = defaultBin;
            }

            public String getDefaultBinEnforced() {
                return defaultBinEnforced;
            }

            public void setDefaultBinEnforced(String defaultBinEnforced) {
                this.defaultBinEnforced = defaultBinEnforced;
            }

            public String getPurchaseBalanceAccount() {
                return purchaseBalanceAccount;
            }

            public void setPurchaseBalanceAccount(String purchaseBalanceAccount) {
                this.purchaseBalanceAccount = purchaseBalanceAccount;
            }

            public String getUubic1() {
                return uubic1;
            }

            public void setUubic1(String uubic1) {
                this.uubic1 = uubic1;
            }

            public String getUubic2() {
                return uubic2;
            }

            public void setUubic2(String uubic2) {
                this.uubic2 = uubic2;
            }

            public String getUubic3() {
                return uubic3;
            }

            public void setUubic3(String uubic3) {
                this.uubic3 = uubic3;
            }

            public String getUubic4() {
                return uubic4;
            }

            public void setUubic4(String uubic4) {
                this.uubic4 = uubic4;
            }

            public String getUubic5() {
                return uubic5;
            }

            public void setUubic5(String uubic5) {
                this.uubic5 = uubic5;
            }

            public String getUvlgxrht() {
                return uvlgxrht;
            }

            public void setUvlgxrht(String uvlgxrht) {
                this.uvlgxrht = uvlgxrht;
            }

            public String getUvlgxnsp() {
                return uvlgxnsp;
            }

            public void setUvlgxnsp(String uvlgxnsp) {
                this.uvlgxnsp = uvlgxnsp;
            }

            public String getUvlgxpol() {
                return uvlgxpol;
            }

            public void setUvlgxpol(String uvlgxpol) {
                this.uvlgxpol = uvlgxpol;
            }

            public ItemCycleCounts getItemCycleCounts() {
                return itemCycleCounts;
            }

            public void setItemCycleCounts(ItemCycleCounts itemCycleCounts) {
                this.itemCycleCounts = itemCycleCounts;
            }

            public static class ItemCycleCounts {
                public static class ItemCycleCount {
                    @JsonProperty("CycleCode")
                    protected Long cycleCode;
                    @JsonProperty("Alert")
                    protected String alert;
                    @JsonProperty("NextCountingDate")
                    protected String nextCountingDate;
                    @JsonProperty("AlertTime")
                    protected String alertTime;
                    @JsonProperty("DestinationUser")
                    protected Long destinationUser;
                    @JsonProperty("WarehouseCode")
                    protected String warehouseCode;

                    public Long getCycleCode() {
                        return cycleCode;
                    }

                    public void setCycleCode(Long cycleCode) {
                        this.cycleCode = cycleCode;
                    }

                    public String getAlert() {
                        return alert;
                    }

                    public void setAlert(String alert) {
                        this.alert = alert;
                    }

                    public String getNextCountingDate() {
                        return nextCountingDate;
                    }

                    public void setNextCountingDate(String nextCountingDate) {
                        this.nextCountingDate = nextCountingDate;
                    }

                    public String getAlertTime() {
                        return alertTime;
                    }

                    public void setAlertTime(String alertTime) {
                        this.alertTime = alertTime;
                    }

                    public Long getDestinationUser() {
                        return destinationUser;
                    }

                    public void setDestinationUser(Long destinationUser) {
                        this.destinationUser = destinationUser;
                    }

                    public String getWarehouseCode() {
                        return warehouseCode;
                    }

                    public void setWarehouseCode(String warehouseCode) {
                        this.warehouseCode = warehouseCode;
                    }
                }
            }
        }
    }

    public static class ItemPreferredVendors {
        public static class ItemPreferredVendor {
            @JsonProperty("BPCode")
            protected String bpCode;

            public String getBpCode() {
                return bpCode;
            }

            public void setBpCode(String bpCode) {
                this.bpCode = bpCode;
            }
        }
    }

    public static class ItemLocalizationInfos {
        public static class ItemLocalizationInfo {
            @JsonProperty("ItemCode")
            protected String itemCode;
            @JsonProperty("IncomeNature")
            protected String incomeNature;

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            public String getIncomeNature() {
                return incomeNature;
            }

            public void setIncomeNature(String incomeNature) {
                this.incomeNature = incomeNature;
            }
        }
    }

    public static class ItemProjects {
        public static class ItemProject {
            @JsonProperty("LineNumber")
            protected Long lineNumber;
            @JsonProperty("ValidFrom")
            protected String validFrom;
            @JsonProperty("ValidTo")
            protected String validTo;
            @JsonProperty("Project")
            protected String project;

            public Long getLineNumber() {
                return lineNumber;
            }

            public void setLineNumber(Long lineNumber) {
                this.lineNumber = lineNumber;
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

            public String getProject() {
                return project;
            }

            public void setProject(String project) {
                this.project = project;
            }
        }
    }

    public static class ItemDistributionRules {
        public static class ItemDistributionRule {
            @JsonProperty("LineNumber")
            protected String lineNumber;
            @JsonProperty("ValidFrom")
            protected String validFrom;
            @JsonProperty("ValidTo")
            protected String validTo;
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

            public String getLineNumber() {
                return lineNumber;
            }

            public void setLineNumber(String lineNumber) {
                this.lineNumber = lineNumber;
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
        }
    }

    public static class ItemAttributeGroups {
    }

    public static class ItemBarCodeCollection {
        public static class ItemBarCode {
            @JsonProperty("AbsEntry")
            protected Long absEntry;
            @JsonProperty("UoMEntry")
            protected Long uoMEntry;
            @JsonProperty("Barcode")
            protected String barcode;
            @JsonProperty("FreeText")
            protected String freeText;

            public Long getAbsEntry() {
                return absEntry;
            }

            public void setAbsEntry(Long absEntry) {
                this.absEntry = absEntry;
            }

            public Long getUoMEntry() {
                return uoMEntry;
            }

            public void setUoMEntry(Long uoMEntry) {
                this.uoMEntry = uoMEntry;
            }

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getFreeText() {
                return freeText;
            }

            public void setFreeText(String freeText) {
                this.freeText = freeText;
            }
        }
    }

    public static class ItemDepreciationParameters {
        public static class ItemDepreciationParameter {
            @JsonProperty("FiscalYear")
            protected String fiscalYear;
            @JsonProperty("DepreciationArea")
            protected String depreciationArea;
            @JsonProperty("DepreciationStartDate")
            protected String depreciationStartDate;
            @JsonProperty("DepreciationEndDate")
            protected String depreciationEndDate;
            @JsonProperty("UsefulLife")
            protected Long usefulLife;
            @JsonProperty("RemainingLife")
            protected Double remainingLife;
            @JsonProperty("DepreciationType")
            protected String depreciationType;

            public String getFiscalYear() {
                return fiscalYear;
            }

            public void setFiscalYear(String fiscalYear) {
                this.fiscalYear = fiscalYear;
            }

            public String getDepreciationArea() {
                return depreciationArea;
            }

            public void setDepreciationArea(String depreciationArea) {
                this.depreciationArea = depreciationArea;
            }

            public String getDepreciationStartDate() {
                return depreciationStartDate;
            }

            public void setDepreciationStartDate(String depreciationStartDate) {
                this.depreciationStartDate = depreciationStartDate;
            }

            public String getDepreciationEndDate() {
                return depreciationEndDate;
            }

            public void setDepreciationEndDate(String depreciationEndDate) {
                this.depreciationEndDate = depreciationEndDate;
            }

            public Long getUsefulLife() {
                return usefulLife;
            }

            public void setUsefulLife(Long usefulLife) {
                this.usefulLife = usefulLife;
            }

            public Double getRemainingLife() {
                return remainingLife;
            }

            public void setRemainingLife(Double remainingLife) {
                this.remainingLife = remainingLife;
            }

            public String getDepreciationType() {
                return depreciationType;
            }

            public void setDepreciationType(String depreciationType) {
                this.depreciationType = depreciationType;
            }
        }
    }

    public static class ItemIntrastatExtension {
        @JsonProperty("ItemCode")
        protected String itemCode;
        @JsonProperty("CommodityCode")
        protected Long commodityCode;
        @JsonProperty("SupplementaryUnit")
        protected Long supplementaryUnit;
        @JsonProperty("FactorOfSupplementaryUnit")
        protected Double factorOfSupplementaryUnit;
        @JsonProperty("ImportRegionState")
        protected Long importRegionState;
        @JsonProperty("ExportRegionState")
        protected Long exportRegionState;
        @JsonProperty("ImportNatureOfTransaction")
        protected Long importNatureOfTransaction;
        @JsonProperty("ExportNatureOfTransaction")
        protected Long exportNatureOfTransaction;
        @JsonProperty("ImportStatisticalProcedure")
        protected Long importStatisticalProcedure;
        @JsonProperty("ExportStatisticalProcedure")
        protected Long exportStatisticalProcedure;
        @JsonProperty("CountryOfOrigin")
        protected String countryOfOrigin;
        @JsonProperty("ServiceCode")
        protected Long serviceCode;
        @JsonProperty("Type")
        protected String type;
        @JsonProperty("ServiceSupplyMethod")
        protected String serviceSupplyMethod;
        @JsonProperty("ServicePaymentMethod")
        protected String servicePaymentMethod;
        @JsonProperty("ImportRegionCountry")
        protected String importRegionCountry;
        @JsonProperty("ExportRegionCountry")
        protected String exportRegionCountry;
        @JsonProperty("UseWeightInCalculation")
        protected String useWeightInCalculation;
        @JsonProperty("IntrastatRelevant")
        protected String intrastatRelevant;
        @JsonProperty("StatisticalCode")
        protected String statisticalCode;

        public String getItemCode() {
            return itemCode;
        }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
        }

        public Long getCommodityCode() {
            return commodityCode;
        }

        public void setCommodityCode(Long commodityCode) {
            this.commodityCode = commodityCode;
        }

        public Long getSupplementaryUnit() {
            return supplementaryUnit;
        }

        public void setSupplementaryUnit(Long supplementaryUnit) {
            this.supplementaryUnit = supplementaryUnit;
        }

        public Double getFactorOfSupplementaryUnit() {
            return factorOfSupplementaryUnit;
        }

        public void setFactorOfSupplementaryUnit(Double factorOfSupplementaryUnit) {
            this.factorOfSupplementaryUnit = factorOfSupplementaryUnit;
        }

        public Long getImportRegionState() {
            return importRegionState;
        }

        public void setImportRegionState(Long importRegionState) {
            this.importRegionState = importRegionState;
        }

        public Long getExportRegionState() {
            return exportRegionState;
        }

        public void setExportRegionState(Long exportRegionState) {
            this.exportRegionState = exportRegionState;
        }

        public Long getImportNatureOfTransaction() {
            return importNatureOfTransaction;
        }

        public void setImportNatureOfTransaction(Long importNatureOfTransaction) {
            this.importNatureOfTransaction = importNatureOfTransaction;
        }

        public Long getExportNatureOfTransaction() {
            return exportNatureOfTransaction;
        }

        public void setExportNatureOfTransaction(Long exportNatureOfTransaction) {
            this.exportNatureOfTransaction = exportNatureOfTransaction;
        }

        public Long getImportStatisticalProcedure() {
            return importStatisticalProcedure;
        }

        public void setImportStatisticalProcedure(Long importStatisticalProcedure) {
            this.importStatisticalProcedure = importStatisticalProcedure;
        }

        public Long getExportStatisticalProcedure() {
            return exportStatisticalProcedure;
        }

        public void setExportStatisticalProcedure(Long exportStatisticalProcedure) {
            this.exportStatisticalProcedure = exportStatisticalProcedure;
        }

        public String getCountryOfOrigin() {
            return countryOfOrigin;
        }

        public void setCountryOfOrigin(String countryOfOrigin) {
            this.countryOfOrigin = countryOfOrigin;
        }

        public Long getServiceCode() {
            return serviceCode;
        }

        public void setServiceCode(Long serviceCode) {
            this.serviceCode = serviceCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getServiceSupplyMethod() {
            return serviceSupplyMethod;
        }

        public void setServiceSupplyMethod(String serviceSupplyMethod) {
            this.serviceSupplyMethod = serviceSupplyMethod;
        }

        public String getServicePaymentMethod() {
            return servicePaymentMethod;
        }

        public void setServicePaymentMethod(String servicePaymentMethod) {
            this.servicePaymentMethod = servicePaymentMethod;
        }

        public String getImportRegionCountry() {
            return importRegionCountry;
        }

        public void setImportRegionCountry(String importRegionCountry) {
            this.importRegionCountry = importRegionCountry;
        }

        public String getExportRegionCountry() {
            return exportRegionCountry;
        }

        public void setExportRegionCountry(String exportRegionCountry) {
            this.exportRegionCountry = exportRegionCountry;
        }

        public String getUseWeightInCalculation() {
            return useWeightInCalculation;
        }

        public void setUseWeightInCalculation(String useWeightInCalculation) {
            this.useWeightInCalculation = useWeightInCalculation;
        }

        public String getIntrastatRelevant() {
            return intrastatRelevant;
        }

        public void setIntrastatRelevant(String intrastatRelevant) {
            this.intrastatRelevant = intrastatRelevant;
        }

        public String getStatisticalCode() {
            return statisticalCode;
        }

        public void setStatisticalCode(String statisticalCode) {
            this.statisticalCode = statisticalCode;
        }
    }

    public static class ItemPeriodControls {
        public static class ItemPeriodControl {
            @JsonProperty("FiscalYear")
            protected String fiscalYear;
            @JsonProperty("DepreciationArea")
            protected String depreciationArea;
            @JsonProperty("SubPeriod")
            protected Long subPeriod;
            @JsonProperty("DepreciationStatus")
            protected String depreciationStatus;
            @JsonProperty("Factor")
            protected Double factor;

            public String getFiscalYear() {
                return fiscalYear;
            }

            public void setFiscalYear(String fiscalYear) {
                this.fiscalYear = fiscalYear;
            }

            public String getDepreciationArea() {
                return depreciationArea;
            }

            public void setDepreciationArea(String depreciationArea) {
                this.depreciationArea = depreciationArea;
            }

            public Long getSubPeriod() {
                return subPeriod;
            }

            public void setSubPeriod(Long subPeriod) {
                this.subPeriod = subPeriod;
            }

            public String getDepreciationStatus() {
                return depreciationStatus;
            }

            public void setDepreciationStatus(String depreciationStatus) {
                this.depreciationStatus = depreciationStatus;
            }

            public Double getFactor() {
                return factor;
            }

            public void setFactor(Double factor) {
                this.factor = factor;
            }
        }
    }

    public static class ItemUnitOfMeasurementCollection {
        public static class ItemUnitOfMeasurement {
            @JsonProperty("UoMType")
            protected String uoMType;
            @JsonProperty("UoMEntry")
            protected Long uoMEntry;
            @JsonProperty("DefaultBarcode")
            protected Long defaultBarcode;
            @JsonProperty("DefaultPackage")
            protected Long defaultPackage;
            @JsonProperty("Length1")
            protected Double length1;
            @JsonProperty("Length1Unit")
            protected Long length1Unit;
            @JsonProperty("Length2")
            protected Double length2;
            @JsonProperty("Length2Unit")
            protected Long length2Unit;
            @JsonProperty("Width1")
            protected Double width1;
            @JsonProperty("Width1Unit")
            protected Long width1Unit;
            @JsonProperty("Width2")
            protected Double width2;
            @JsonProperty("Width2Unit")
            protected Long width2Unit;
            @JsonProperty("Height1")
            protected Double height1;
            @JsonProperty("Height1Unit")
            protected Long height1Unit;
            @JsonProperty("Height2")
            protected Double height2;
            @JsonProperty("Height2Unit")
            protected Long height2Unit;
            @JsonProperty("Volume")
            protected Double volume;
            @JsonProperty("VolumeUnit")
            protected Long volumeUnit;
            @JsonProperty("Weight1")
            protected Double weight1;
            @JsonProperty("Weight1Unit")
            protected Long weight1Unit;
            @JsonProperty("Weight2")
            protected Double weight2;
            @JsonProperty("Weight2Unit")
            protected Long weight2Unit;
            @JsonProperty("ItemUoMPackageCollection")
            protected ItemsRestDTO.ItemUnitOfMeasurementCollection.ItemUnitOfMeasurement.ItemUoMPackageCollection itemUoMPackageCollection;

            public String getUoMType() {
                return uoMType;
            }

            public void setUoMType(String uoMType) {
                this.uoMType = uoMType;
            }

            public Long getUoMEntry() {
                return uoMEntry;
            }

            public void setUoMEntry(Long uoMEntry) {
                this.uoMEntry = uoMEntry;
            }

            public Long getDefaultBarcode() {
                return defaultBarcode;
            }

            public void setDefaultBarcode(Long defaultBarcode) {
                this.defaultBarcode = defaultBarcode;
            }

            public Long getDefaultPackage() {
                return defaultPackage;
            }

            public void setDefaultPackage(Long defaultPackage) {
                this.defaultPackage = defaultPackage;
            }

            public Double getLength1() {
                return length1;
            }

            public void setLength1(Double length1) {
                this.length1 = length1;
            }

            public Long getLength1Unit() {
                return length1Unit;
            }

            public void setLength1Unit(Long length1Unit) {
                this.length1Unit = length1Unit;
            }

            public Double getLength2() {
                return length2;
            }

            public void setLength2(Double length2) {
                this.length2 = length2;
            }

            public Long getLength2Unit() {
                return length2Unit;
            }

            public void setLength2Unit(Long length2Unit) {
                this.length2Unit = length2Unit;
            }

            public Double getWidth1() {
                return width1;
            }

            public void setWidth1(Double width1) {
                this.width1 = width1;
            }

            public Long getWidth1Unit() {
                return width1Unit;
            }

            public void setWidth1Unit(Long width1Unit) {
                this.width1Unit = width1Unit;
            }

            public Double getWidth2() {
                return width2;
            }

            public void setWidth2(Double width2) {
                this.width2 = width2;
            }

            public Long getWidth2Unit() {
                return width2Unit;
            }

            public void setWidth2Unit(Long width2Unit) {
                this.width2Unit = width2Unit;
            }

            public Double getHeight1() {
                return height1;
            }

            public void setHeight1(Double height1) {
                this.height1 = height1;
            }

            public Long getHeight1Unit() {
                return height1Unit;
            }

            public void setHeight1Unit(Long height1Unit) {
                this.height1Unit = height1Unit;
            }

            public Double getHeight2() {
                return height2;
            }

            public void setHeight2(Double height2) {
                this.height2 = height2;
            }

            public Long getHeight2Unit() {
                return height2Unit;
            }

            public void setHeight2Unit(Long height2Unit) {
                this.height2Unit = height2Unit;
            }

            public Double getVolume() {
                return volume;
            }

            public void setVolume(Double volume) {
                this.volume = volume;
            }

            public Long getVolumeUnit() {
                return volumeUnit;
            }

            public void setVolumeUnit(Long volumeUnit) {
                this.volumeUnit = volumeUnit;
            }

            public Double getWeight1() {
                return weight1;
            }

            public void setWeight1(Double weight1) {
                this.weight1 = weight1;
            }

            public Long getWeight1Unit() {
                return weight1Unit;
            }

            public void setWeight1Unit(Long weight1Unit) {
                this.weight1Unit = weight1Unit;
            }

            public Double getWeight2() {
                return weight2;
            }

            public void setWeight2(Double weight2) {
                this.weight2 = weight2;
            }

            public Long getWeight2Unit() {
                return weight2Unit;
            }

            public void setWeight2Unit(Long weight2Unit) {
                this.weight2Unit = weight2Unit;
            }

            public ItemUoMPackageCollection getItemUoMPackageCollection() {
                return itemUoMPackageCollection;
            }

            public void setItemUoMPackageCollection(ItemUoMPackageCollection itemUoMPackageCollection) {
                this.itemUoMPackageCollection = itemUoMPackageCollection;
            }

            public static class ItemUoMPackageCollection {
                public static class ItemUoMPackage {
                    @JsonProperty("UoMType")
                    protected String uoMType;
                    @JsonProperty("UoMEntry")
                    protected Long uoMEntry;
                    @JsonProperty("PackageTypeEntry")
                    protected Long packageTypeEntry;
                    @JsonProperty("Length1")
                    protected Double length1;
                    @JsonProperty("Length1Unit")
                    protected Long length1Unit;
                    @JsonProperty("Length2")
                    protected Double length2;
                    @JsonProperty("Length2Unit")
                    protected Long length2Unit;
                    @JsonProperty("Width1")
                    protected Double width1;
                    @JsonProperty("Width1Unit")
                    protected Long width1Unit;
                    @JsonProperty("Width2")
                    protected Double width2;
                    @JsonProperty("Width2Unit")
                    protected Long width2Unit;
                    @JsonProperty("Height1")
                    protected Double height1;
                    @JsonProperty("Height1Unit")
                    protected Long height1Unit;
                    @JsonProperty("Height2")
                    protected Double height2;
                    @JsonProperty("Height2Unit")
                    protected Long height2Unit;
                    @JsonProperty("Volume")
                    protected Double volume;
                    @JsonProperty("VolumeUnit")
                    protected Long volumeUnit;
                    @JsonProperty("Weight1")
                    protected Double weight1;
                    @JsonProperty("Weight1Unit")
                    protected Long weight1Unit;
                    @JsonProperty("Weight2")
                    protected Double weight2;
                    @JsonProperty("Weight2Unit")
                    protected Long weight2Unit;
                    @JsonProperty("QuantityPerPackage")
                    protected Double quantityPerPackage;

                    public String getUoMType() {
                        return uoMType;
                    }

                    public void setUoMType(String uoMType) {
                        this.uoMType = uoMType;
                    }

                    public Long getUoMEntry() {
                        return uoMEntry;
                    }

                    public void setUoMEntry(Long uoMEntry) {
                        this.uoMEntry = uoMEntry;
                    }

                    public Long getPackageTypeEntry() {
                        return packageTypeEntry;
                    }

                    public void setPackageTypeEntry(Long packageTypeEntry) {
                        this.packageTypeEntry = packageTypeEntry;
                    }

                    public Double getLength1() {
                        return length1;
                    }

                    public void setLength1(Double length1) {
                        this.length1 = length1;
                    }

                    public Long getLength1Unit() {
                        return length1Unit;
                    }

                    public void setLength1Unit(Long length1Unit) {
                        this.length1Unit = length1Unit;
                    }

                    public Double getLength2() {
                        return length2;
                    }

                    public void setLength2(Double length2) {
                        this.length2 = length2;
                    }

                    public Long getLength2Unit() {
                        return length2Unit;
                    }

                    public void setLength2Unit(Long length2Unit) {
                        this.length2Unit = length2Unit;
                    }

                    public Double getWidth1() {
                        return width1;
                    }

                    public void setWidth1(Double width1) {
                        this.width1 = width1;
                    }

                    public Long getWidth1Unit() {
                        return width1Unit;
                    }

                    public void setWidth1Unit(Long width1Unit) {
                        this.width1Unit = width1Unit;
                    }

                    public Double getWidth2() {
                        return width2;
                    }

                    public void setWidth2(Double width2) {
                        this.width2 = width2;
                    }

                    public Long getWidth2Unit() {
                        return width2Unit;
                    }

                    public void setWidth2Unit(Long width2Unit) {
                        this.width2Unit = width2Unit;
                    }

                    public Double getHeight1() {
                        return height1;
                    }

                    public void setHeight1(Double height1) {
                        this.height1 = height1;
                    }

                    public Long getHeight1Unit() {
                        return height1Unit;
                    }

                    public void setHeight1Unit(Long height1Unit) {
                        this.height1Unit = height1Unit;
                    }

                    public Double getHeight2() {
                        return height2;
                    }

                    public void setHeight2(Double height2) {
                        this.height2 = height2;
                    }

                    public Long getHeight2Unit() {
                        return height2Unit;
                    }

                    public void setHeight2Unit(Long height2Unit) {
                        this.height2Unit = height2Unit;
                    }

                    public Double getVolume() {
                        return volume;
                    }

                    public void setVolume(Double volume) {
                        this.volume = volume;
                    }

                    public Long getVolumeUnit() {
                        return volumeUnit;
                    }

                    public void setVolumeUnit(Long volumeUnit) {
                        this.volumeUnit = volumeUnit;
                    }

                    public Double getWeight1() {
                        return weight1;
                    }

                    public void setWeight1(Double weight1) {
                        this.weight1 = weight1;
                    }

                    public Long getWeight1Unit() {
                        return weight1Unit;
                    }

                    public void setWeight1Unit(Long weight1Unit) {
                        this.weight1Unit = weight1Unit;
                    }

                    public Double getWeight2() {
                        return weight2;
                    }

                    public void setWeight2(Double weight2) {
                        this.weight2 = weight2;
                    }

                    public Long getWeight2Unit() {
                        return weight2Unit;
                    }

                    public void setWeight2Unit(Long weight2Unit) {
                        this.weight2Unit = weight2Unit;
                    }

                    public Double getQuantityPerPackage() {
                        return quantityPerPackage;
                    }

                    public void setQuantityPerPackage(Double quantityPerPackage) {
                        this.quantityPerPackage = quantityPerPackage;
                    }
                }
            }
        }
    }
}
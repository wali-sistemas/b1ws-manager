package co.manager.novaws.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemRestDTO implements Serializable {
    private Pagination pagination;
    private List<Result> results;
    @JsonProperty("_links")
    private Links Links;

    public ItemRestDTO() {
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Links getLinks() {
        return Links;
    }

    public void setLinks(Links links) {
        Links = links;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pagination implements Serializable {
        private Integer page;
        @JsonProperty("page_size")
        private Integer pageSize;
        @JsonProperty("total_results")
        private Integer totalResults;

        public Integer getPage() {
            return page;
        }

        public void setPage(Integer page) {
            this.page = page;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public Integer getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(Integer totalResults) {
            this.totalResults = totalResults;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable {
        private String id;
        private String code;
        private String name;
        @JsonProperty("account_group")
        private AccountGroup accountGroup;
        private String type;
        @JsonProperty("stock_control")
        private Boolean stockControl;
        private Boolean active;
        @JsonProperty("tax_classification")
        private String taxClassification;
        @JsonProperty("tax_included")
        private Boolean taxIncluded;
        private List<Tax> taxes;
        private List<Object> variants;
        private List<Price> prices;
        private Unit unit;
        @JsonProperty("unit_label")
        private String unitLabel;
        @JsonProperty("additional_fields")
        private AdditionalFields additionalFields;
        @JsonProperty("available_quantity")
        private BigDecimal availableQuantity;
        private List<Warehouse> warehouses;
        private List<Object> batches;
        private Metadata metadata;
        @JsonProperty("tax_consumption_value")
        private Integer taxConsumptionValue;
        private String reference;
        private String description;
        private List<Component> components;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public AccountGroup getAccountGroup() {
            return accountGroup;
        }

        public void setAccountGroup(AccountGroup accountGroup) {
            this.accountGroup = accountGroup;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Boolean getStockControl() {
            return stockControl;
        }

        public void setStockControl(Boolean stockControl) {
            this.stockControl = stockControl;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
        }

        public String getTaxClassification() {
            return taxClassification;
        }

        public void setTaxClassification(String taxClassification) {
            this.taxClassification = taxClassification;
        }

        public Boolean getTaxIncluded() {
            return taxIncluded;
        }

        public void setTaxIncluded(Boolean taxIncluded) {
            this.taxIncluded = taxIncluded;
        }

        public List<Tax> getTaxes() {
            return taxes;
        }

        public void setTaxes(List<Tax> taxes) {
            this.taxes = taxes;
        }

        public List<Object> getVariants() {
            return variants;
        }

        public void setVariants(List<Object> variants) {
            this.variants = variants;
        }

        public List<Price> getPrices() {
            return prices;
        }

        public void setPrices(List<Price> prices) {
            this.prices = prices;
        }

        public Unit getUnit() {
            return unit;
        }

        public void setUnit(Unit unit) {
            this.unit = unit;
        }

        public String getUnitLabel() {
            return unitLabel;
        }

        public void setUnitLabel(String unitLabel) {
            this.unitLabel = unitLabel;
        }

        public AdditionalFields getAdditionalFields() {
            return additionalFields;
        }

        public void setAdditionalFields(AdditionalFields additionalFields) {
            this.additionalFields = additionalFields;
        }

        public BigDecimal getAvailableQuantity() {
            return availableQuantity;
        }

        public void setAvailableQuantity(BigDecimal availableQuantity) {
            this.availableQuantity = availableQuantity;
        }

        public List<Warehouse> getWarehouses() {
            return warehouses;
        }

        public void setWarehouses(List<Warehouse> warehouses) {
            this.warehouses = warehouses;
        }

        public List<Object> getBatches() {
            return batches;
        }

        public void setBatches(List<Object> batches) {
            this.batches = batches;
        }

        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

        public Integer getTaxConsumptionValue() {
            return taxConsumptionValue;
        }

        public void setTaxConsumptionValue(Integer taxConsumptionValue) {
            this.taxConsumptionValue = taxConsumptionValue;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Component> getComponents() {
            return components;
        }

        public void setComponents(List<Component> components) {
            this.components = components;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AccountGroup implements Serializable {
            private Integer id;
            private String name;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Tax implements Serializable {
            private Integer id;
            private String name;
            private String type;
            private BigDecimal percentage;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public BigDecimal getPercentage() {
                return percentage;
            }

            public void setPercentage(BigDecimal percentage) {
                this.percentage = percentage;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Price implements Serializable {
            @JsonProperty("currency_code")
            private String currencyCode;
            @JsonProperty("price_list")
            private List<PriceList> priceList;

            public String getCurrencyCode() {
                return currencyCode;
            }

            public void setCurrencyCode(String currencyCode) {
                this.currencyCode = currencyCode;
            }

            public List<PriceList> getPriceList() {
                return priceList;
            }

            public void setPriceList(List<PriceList> priceList) {
                this.priceList = priceList;
            }

            @JsonIgnoreProperties(ignoreUnknown = true)
            public static class PriceList implements Serializable {
                private Integer position;
                private String name;
                private BigDecimal value;

                public Integer getPosition() {
                    return position;
                }

                public void setPosition(Integer position) {
                    this.position = position;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public BigDecimal getValue() {
                    return value;
                }

                public void setValue(BigDecimal value) {
                    this.value = value;
                }
            }

        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Unit implements Serializable {
            private String code;
            private String name;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class AdditionalFields implements Serializable {
            private String barcode;
            private String brand;
            private String tariff;
            private String model;

            public String getBarcode() {
                return barcode;
            }

            public void setBarcode(String barcode) {
                this.barcode = barcode;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getTariff() {
                return tariff;
            }

            public void setTariff(String tariff) {
                this.tariff = tariff;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Warehouse implements Serializable {
            private Integer id;
            private String name;
            private BigDecimal quantity;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public BigDecimal getQuantity() {
                return quantity;
            }

            public void setQuantity(BigDecimal quantity) {
                this.quantity = quantity;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Metadata implements Serializable {
            private String created;
            @JsonProperty("last_updated")
            private String lastUpdated;

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getLastUpdated() {
                return lastUpdated;
            }

            public void setLastUpdated(String lastUpdated) {
                this.lastUpdated = lastUpdated;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Component implements Serializable {
            private Integer id;
            private String name;
            private BigDecimal quantity;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public BigDecimal getQuantity() {
                return quantity;
            }

            public void setQuantity(BigDecimal quantity) {
                this.quantity = quantity;
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Links implements Serializable {
        private Self self;
        private Next next;

        public Self getSelf() {
            return self;
        }

        public void setSelf(Self self) {
            this.self = self;
        }

        public Next getNext() {
            return next;
        }

        public void setNext(Next next) {
            this.next = next;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Next implements Serializable {
            private String href;

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Self implements Serializable {
            private String href;

            public String getHref() {
                return href;
            }
        }
    }
}
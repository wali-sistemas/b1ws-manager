package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class ItemChatBotIADTO {
    public String itemCode;
    public String itemName;
    public Integer stockWhMed;
    public Integer stockWhCart;
    public Integer stockWhCal;
    public Integer stockWhBog;
    public BigDecimal price;
    public String category;
    public String group;
    public String subGroup;
    public String brand;
    public String subBrand;
    public String application;
    public String oring;
    public String typeInv;
    public String urlPicture;
    public String typeTire;
    public String widthTire;
    public String highTire;
    public String profileTire;
    public String rinTire;
    public String colorChain;
    public String pasoChain;
    public String longChain;
    public String unitPack;

    public ItemChatBotIADTO() {
    }

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

    public Integer getStockWhMed() {
        return stockWhMed;
    }

    public void setStockWhMed(Integer stockWhMed) {
        this.stockWhMed = stockWhMed;
    }

    public Integer getStockWhCart() {
        return stockWhCart;
    }

    public void setStockWhCart(Integer stockWhCart) {
        this.stockWhCart = stockWhCart;
    }

    public Integer getStockWhCal() {
        return stockWhCal;
    }

    public void setStockWhCal(Integer stockWhCal) {
        this.stockWhCal = stockWhCal;
    }

    public Integer getStockWhBog() {
        return stockWhBog;
    }

    public void setStockWhBog(Integer stockWhBog) {
        this.stockWhBog = stockWhBog;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSubBrand() {
        return subBrand;
    }

    public void setSubBrand(String subBrand) {
        this.subBrand = subBrand;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getOring() {
        return oring;
    }

    public void setOring(String oring) {
        this.oring = oring;
    }

    public String getTypeInv() {
        return typeInv;
    }

    public void setTypeInv(String typeInv) {
        this.typeInv = typeInv;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public String getTypeTire() {
        return typeTire;
    }

    public void setTypeTire(String typeTire) {
        this.typeTire = typeTire;
    }

    public String getWidthTire() {
        return widthTire;
    }

    public void setWidthTire(String widthTire) {
        this.widthTire = widthTire;
    }

    public String getHighTire() {
        return highTire;
    }

    public void setHighTire(String highTire) {
        this.highTire = highTire;
    }

    public String getProfileTire() {
        return profileTire;
    }

    public void setProfileTire(String profileTire) {
        this.profileTire = profileTire;
    }

    public String getRinTire() {
        return rinTire;
    }

    public void setRinTire(String rinTire) {
        this.rinTire = rinTire;
    }

    public String getColorChain() {
        return colorChain;
    }

    public void setColorChain(String colorChain) {
        this.colorChain = colorChain;
    }

    public String getPasoChain() {
        return pasoChain;
    }

    public void setPasoChain(String pasoChain) {
        this.pasoChain = pasoChain;
    }

    public String getLongChain() {
        return longChain;
    }

    public void setLongChain(String longChain) {
        this.longChain = longChain;
    }

    public String getUnitPack() {
        return unitPack;
    }

    public void setUnitPack(String unitPack) {
        this.unitPack = unitPack;
    }

    @Override
    public String toString() {
        return "ItemChatBotIADTO{" +
                "itemCode='" + itemCode + '\'' +
                ", stockWhMed=" + stockWhMed +
                ", stockWhCart=" + stockWhCart +
                ", stockWhCal=" + stockWhCal +
                ", stockWhBog=" + stockWhBog +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", group='" + group + '\'' +
                ", subGroup='" + subGroup + '\'' +
                ", brand='" + brand + '\'' +
                ", subBrand='" + subBrand + '\'' +
                ", application='" + application + '\'' +
                ", oring='" + oring + '\'' +
                ", typeInv='" + typeInv + '\'' +
                ", urlPicture='" + urlPicture + '\'' +
                ", typeTire='" + typeTire + '\'' +
                ", widthTire='" + widthTire + '\'' +
                ", highTire='" + highTire + '\'' +
                ", profileTire='" + profileTire + '\'' +
                ", rinTire='" + rinTire + '\'' +
                ", colorChain='" + colorChain + '\'' +
                ", pasoChain='" + pasoChain + '\'' +
                ", longChain='" + longChain + '\'' +
                ", unitPack='" + unitPack + '\'' +
                '}';
    }
}

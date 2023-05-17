package co.manager.dto;

import java.util.Date;

/**
 * @author jguisao
 */
public class EmployeeCustodyDTO {
    private String cardCode;
    private String cardName;
    private String depart;
    private String company;
    private Integer ccEmpl;
    private String statusEmp;
    private String idAsset;
    private Date dateAssign;
    private Date dateFinish;
    private String statusDet;
    private String userAssign;
    private String userFinish;
    private String type;
    private String brand;
    private String referencia;
    private String serial;
    private String companyPurchase;
    private Date datePurchase;
    private Integer ccAsset;
    private String statusAsset;
    private String comment;
    private String pictAsset;
    private String icon;

    public EmployeeCustodyDTO() {
    }

    public EmployeeCustodyDTO(String cardCode, String cardName, String depart, String company, Integer ccEmpl, String statusEmp, String idAsset, Date dateAssign, Date dateFinish, String statusDet, String userAssign, String userFinish, String type, String brand, String referencia, String serial, String companyPurchase, Date datePurchase, Integer ccAsset, String statusAsset, String comment, String pictAsset, String icon) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.depart = depart;
        this.company = company;
        this.ccEmpl = ccEmpl;
        this.statusEmp = statusEmp;
        this.idAsset = idAsset;
        this.dateAssign = dateAssign;
        this.dateFinish = dateFinish;
        this.statusDet = statusDet;
        this.userAssign = userAssign;
        this.userFinish = userFinish;
        this.type = type;
        this.brand = brand;
        this.referencia = referencia;
        this.serial = serial;
        this.companyPurchase = companyPurchase;
        this.datePurchase = datePurchase;
        this.ccAsset = ccAsset;
        this.statusAsset = statusAsset;
        this.comment = comment;
        this.pictAsset = pictAsset;
        this.icon = icon;
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

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCcEmpl() {
        return ccEmpl;
    }

    public void setCcEmpl(Integer ccEmpl) {
        this.ccEmpl = ccEmpl;
    }

    public String getStatusEmp() {
        return statusEmp;
    }

    public void setStatusEmp(String statusEmp) {
        this.statusEmp = statusEmp;
    }

    public String getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(String idAsset) {
        this.idAsset = idAsset;
    }

    public Date getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(Date dateAssign) {
        this.dateAssign = dateAssign;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(Date dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String getStatusDet() {
        return statusDet;
    }

    public void setStatusDet(String statusDet) {
        this.statusDet = statusDet;
    }

    public String getUserAssign() {
        return userAssign;
    }

    public void setUserAssign(String userAssign) {
        this.userAssign = userAssign;
    }

    public String getUserFinish() {
        return userFinish;
    }

    public void setUserFinish(String userFinish) {
        this.userFinish = userFinish;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCompanyPurchase() {
        return companyPurchase;
    }

    public void setCompanyPurchase(String companyPurchase) {
        this.companyPurchase = companyPurchase;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getCcAsset() {
        return ccAsset;
    }

    public void setCcAsset(Integer ccAsset) {
        this.ccAsset = ccAsset;
    }

    public String getStatusAsset() {
        return statusAsset;
    }

    public void setStatusAsset(String statusAsset) {
        this.statusAsset = statusAsset;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPictAsset() {
        return pictAsset;
    }

    public void setPictAsset(String pictAsset) {
        this.pictAsset = pictAsset;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "EmployeeCustodyDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", depart='" + depart + '\'' +
                ", company='" + company + '\'' +
                ", ccEmpl=" + ccEmpl +
                ", statusEmp='" + statusEmp + '\'' +
                ", idAsset='" + idAsset + '\'' +
                ", dateAssign=" + dateAssign +
                ", dateFinish=" + dateFinish +
                ", statusDet='" + statusDet + '\'' +
                ", userAssign='" + userAssign + '\'' +
                ", userFinish='" + userFinish + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", referencia='" + referencia + '\'' +
                ", serial='" + serial + '\'' +
                ", companyPurchase='" + companyPurchase + '\'' +
                ", datePurchase=" + datePurchase +
                ", ccAsset=" + ccAsset +
                ", statusAsset='" + statusAsset + '\'' +
                ", comment='" + comment + '\'' +
                ", pictAsset='" + pictAsset + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
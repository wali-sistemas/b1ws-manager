package co.manager.dto;

import java.util.Date;

public class AssetDTO {
    private String idAsset;
    private String type;
    private String brand;
    private String reference;
    private String serial;
    private String company;
    private Date datePurchase;
    private Integer ccosto;
    private String status;
    private String comment;
    private String pictureAssetUrl;
    private EmployeeDTO employeeDTO;

    public AssetDTO() {
    }

    public AssetDTO(String idAsset, String type, String brand, String reference, String serial, String company, Date datePurchase, Integer ccosto, String status, String comment, String pictureAssetUrl, EmployeeDTO employeeDTO) {
        this.idAsset = idAsset;
        this.type = type;
        this.brand = brand;
        this.reference = reference;
        this.serial = serial;
        this.company = company;
        this.datePurchase = datePurchase;
        this.ccosto = ccosto;
        this.status = status;
        this.comment = comment;
        this.pictureAssetUrl = pictureAssetUrl;
        this.employeeDTO = employeeDTO;
    }

    public String getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(String idAsset) {
        this.idAsset = idAsset;
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

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getCcosto() {
        return ccosto;
    }

    public void setCcosto(Integer ccosto) {
        this.ccosto = ccosto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPictureAssetUrl() {
        return pictureAssetUrl;
    }

    public void setPictureAssetUrl(String pictureAssetUrl) {
        this.pictureAssetUrl = pictureAssetUrl;
    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    @Override
    public String toString() {
        return "AssetDTO{" +
                "idAsset='" + idAsset + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", reference='" + reference + '\'' +
                ", serial='" + serial + '\'' +
                ", company='" + company + '\'' +
                ", datePurchase=" + datePurchase +
                ", ccosto=" + ccosto +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", pictureAssetUrl='" + pictureAssetUrl + '\'' +
                ", employeeDTO=" + employeeDTO +
                '}';
    }
}
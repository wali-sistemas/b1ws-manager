package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "asset_master_data")
public class AssetMasterData implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "idAsset", nullable = false)
    private String idAsset;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
    @Column(name = "datePurchase")
    private String datePurchase;
    @Column(name = "ccosto")
    private Integer ccosto;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "pictureAssetUrl")
    private String pictureAssetUrl;

    public AssetMasterData() {
    }

    public AssetMasterData(String idAsset) {
        this.idAsset = idAsset;
    }

    public AssetMasterData(String idAsset, String type, String brand, String reference, String serial, String company, String datePurchase, Integer ccosto, String status, String comment, String pictureAssetUrl) {
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

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idAsset);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AssetMasterData other = (AssetMasterData) obj;
        if (!Objects.equals(this.idAsset, other.idAsset)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssetMasterData{" +
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
                '}';
    }
}

package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "OITM")
public class ItemSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ItemCode")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "PicturName")
    private String picturName;

    public ItemSAP() {
    }

    public ItemSAP(String itemCode, String picture) {
        this.itemCode = itemCode;
        this.picturName = picture;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getPicture() {
        return picturName;
    }

    public void setPicture(String picture) {
        this.picturName = picture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemCode != null ? itemCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSAP)) {
            return false;
        }
        ItemSAP other = (ItemSAP) object;
        return !((this.itemCode == null && other.itemCode != null) || (this.itemCode != null && !this.itemCode.equals(other.itemCode)));
    }

    @Override
    public String toString() {
        return "ItemSAP{" +
                "itemCode=" + itemCode +
                ", picturName='" + picturName + '\'' +
                '}';
    }
}
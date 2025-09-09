package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "item_sold_out_app")
public class ItemSoldOutAPP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItemSoldOut")
    private Integer idItemSoldOut;
    @Basic(optional = false)
    @Column(name = "itemCode")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "qtySoldOut")
    private int qtySoldOut;
    @Column(name = "docDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDate;
    @Basic(optional = false)
    @Column(name = "slpCode")
    private String slpCode;
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "origen")
    private String origen;
    @Basic(optional = false)
    @Column(name = "whsName")
    private String whsName;

    public ItemSoldOutAPP() {
    }

    public ItemSoldOutAPP(Integer idItemSoldOut, String itemCode, String itemName, int qtySoldOut, Date docDate, String slpCode, String companyName, String origen, String whsName) {
        this.idItemSoldOut = idItemSoldOut;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.qtySoldOut = qtySoldOut;
        this.docDate = docDate;
        this.slpCode = slpCode;
        this.companyName = companyName;
        this.origen = origen;
        this.whsName = whsName;
    }

    public Integer getIdItemSoldOut() {
        return idItemSoldOut;
    }

    public void setIdItemSoldOut(Integer idItemSoldOut) {
        this.idItemSoldOut = idItemSoldOut;
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

    public int getQtySoldOut() {
        return qtySoldOut;
    }

    public void setQtySoldOut(int qtySoldOut) {
        this.qtySoldOut = qtySoldOut;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getWhsName() {
        return whsName;
    }

    public void setWhsName(String whsName) {
        this.whsName = whsName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idItemSoldOut);
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
        final ItemSoldOutAPP other = (ItemSoldOutAPP) obj;
        if (!Objects.equals(this.idItemSoldOut, other.idItemSoldOut)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemSoldOutAPP{" +
                "idItemSoldOut=" + idItemSoldOut +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", qtySoldOut=" + qtySoldOut +
                ", docDate=" + docDate +
                ", slpCode='" + slpCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", origen='" + origen + '\'' +
                ", whsName='" + whsName + '\'' +
                '}';
    }
}
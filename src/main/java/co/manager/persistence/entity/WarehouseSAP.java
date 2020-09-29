package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "OWHS")
public class WarehouseSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WhsCode")
    private String whsCode;
    @Basic(optional = false)
    @Column(name = "WhsName")
    private String whsName;
    @Basic(optional = false)
    @Column(name = "Inactive")
    private Character inactive;
    @Basic(optional = false)
    @Column(name = "DftBinAbs")
    private Integer dftBinAbs;

    public WarehouseSAP() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getWhsName() {
        return whsName;
    }

    public void setWhsName(String whsName) {
        this.whsName = whsName;
    }

    public Character getInactive() {
        return inactive;
    }

    public void setInactive(Character inactive) {
        this.inactive = inactive;
    }

    public Integer getDftBinAbs() {
        return dftBinAbs;
    }

    public void setDftBinAbs(Integer dftBinAbs) {
        this.dftBinAbs = dftBinAbs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (whsCode != null ? whsCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarehouseSAP)) {
            return false;
        }
        WarehouseSAP other = (WarehouseSAP) object;
        return !((this.whsCode == null && other.whsCode != null) || (this.whsCode != null && !this.whsCode.equals(other.whsCode)));
    }

    @Override
    public String toString() {
        return "WarehouseSAP{" +
                "whsCode='" + whsCode + '\'' +
                ", whsName='" + whsName + '\'' +
                ", inactive=" + inactive +
                ", dftBinAbs=" + dftBinAbs +
                '}';
    }
}
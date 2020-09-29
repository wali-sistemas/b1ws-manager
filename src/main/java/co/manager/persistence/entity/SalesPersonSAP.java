package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "OSLP")
public class SalesPersonSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SlpCode")
    private Short slpCode;
    @Basic(optional = false)
    @Column(name = "SlpName")
    private String slpName;
    @Column(name = "Active")
    private Character active;
    @Basic(optional = false)
    @Column(name = "U_CentroCosto")
    private String uCentroCosto;

    public SalesPersonSAP() {
    }

    public SalesPersonSAP(Short slpCode, String slpName, Character active, String uCentroCosto) {
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.active = active;
        this.uCentroCosto = uCentroCosto;
    }

    public Short getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(Short slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getuCentroCosto() {
        return uCentroCosto;
    }

    public void setuCentroCosto(String uCentroCosto) {
        this.uCentroCosto = uCentroCosto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slpCode != null ? slpCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesPersonSAP)) {
            return false;
        }
        SalesPersonSAP other = (SalesPersonSAP) object;
        if ((this.slpCode == null && other.slpCode != null) || (this.slpCode != null && !this.slpCode.equals(other.slpCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SalesPersonSAP{" +
                "slpCode=" + slpCode +
                ", slpName='" + slpName + '\'' +
                ", active=" + active +
                ", uCentroCosto='" + uCentroCosto + '\'' +
                '}';
    }
}
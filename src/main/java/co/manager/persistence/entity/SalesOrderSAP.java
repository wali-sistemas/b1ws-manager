package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "ORDR")
public class SalesOrderSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DocEntry")
    private Integer docEntry;
    @Basic(optional = false)
    @Column(name = "DocNum")
    private Integer docNum;
    @Basic(optional = false)
    @Column(name = "U_TRANSP")
    private String uTransp;

    public SalesOrderSAP() {
    }

    public SalesOrderSAP(Integer docEntry, Integer docNum, String uTransp) {
        this.docEntry = docEntry;
        this.docNum = docNum;
        this.uTransp = uTransp;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getDocEntry() {
        return docEntry;
    }

    public void setDocEntry(Integer docEntry) {
        this.docEntry = docEntry;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public String getuTransp() {
        return uTransp;
    }

    public void setuTransp(String uTransp) {
        this.uTransp = uTransp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docEntry != null ? docEntry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesOrderSAP)) {
            return false;
        }
        SalesOrderSAP other = (SalesOrderSAP) object;
        return !((this.docEntry == null && other.docEntry != null) || (this.docEntry != null && !this.docEntry.equals(other.docEntry)));
    }

    @Override
    public String toString() {
        return "SalesOrderSAP{" +
                "docEntry=" + docEntry +
                ", docNum=" + docNum +
                ", uTransp='" + uTransp + '\'' +
                '}';
    }
}
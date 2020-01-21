package co.manager.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "OCRD")
public class BusinessPartnerSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cardCode")
    private String cardCode;
    @Basic(optional = false)
    @Column(name = "cardName")
    private String cardName;
    @Basic(optional = false)
    @Column(name = "cardType")
    private String cardType;

    public BusinessPartnerSAP() {
    }

    public BusinessPartnerSAP(String cardCode, String cardName, String cardType) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.cardType = cardType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardCode != null ? cardCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemSAP)) {
            return false;
        }
        BusinessPartnerSAP other = (BusinessPartnerSAP) object;
        return !((this.cardCode == null && other.cardCode != null) || (this.cardCode != null && !this.cardCode.equals(other.cardCode)));
    }

    @Override
    public String toString() {
        return "BusinessPartnerSAP{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
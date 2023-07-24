package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "custody_detail")
public class CustodyDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCustody", nullable = false)
    private long idCustody;
    @JoinColumn(name = "idAsset", referencedColumnName = "idAsset")
    @ManyToOne(optional = false)
    private AssetMasterData idAsset;
    @JoinColumn(name = "cardCode", referencedColumnName = "cardCode")
    @ManyToOne(optional = false)
    private Employee cardCode;
    @Column(name = "dateAssign")
    private Date dateAssign;
    @Column(name = "dateFinish")
    private Date dateFinish;
    @Column(name = "status")
    private String status;
    @Column(name = "userAssign")
    private String userAssign;
    @Column(name = "userFinish")
    private String userFinish;

    public CustodyDetail() {
    }

    public CustodyDetail(long idCustody, AssetMasterData idAsset, Employee cardCode, Date dateAssign, Date dateFinish, String status, String userAssign, String userFinish) {
        this.idCustody = idCustody;
        this.idAsset = idAsset;
        this.cardCode = cardCode;
        this.dateAssign = dateAssign;
        this.dateFinish = dateFinish;
        this.status = status;
        this.userAssign = userAssign;
        this.userFinish = userFinish;
    }

    public long getIdCustody() {
        return idCustody;
    }

    public void setIdCustody(long idCustodia) {
        this.idCustody = idCustody;
    }

    public AssetMasterData getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(AssetMasterData idAsset) {
        this.idAsset = idAsset;
    }

    public Employee getCardCode() {
        return cardCode;
    }

    public void setCardCode(Employee cardCode) {
        this.cardCode = cardCode;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idCustody);
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
        final CustodyDetail other = (CustodyDetail) obj;
        if (!Objects.equals(this.idCustody, other.idCustody)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustodyDetail{" +
                "idCustody=" + idCustody +
                ", idAsset=" + idAsset +
                ", cardCode=" + cardCode +
                ", dateAssign=" + dateAssign +
                ", dateFinish=" + dateFinish +
                ", status='" + status + '\'' +
                ", userAssign='" + userAssign + '\'' +
                ", userFinish='" + userFinish + '\'' +
                '}';
    }
}
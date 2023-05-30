package co.manager.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "order_pedbox")
public class OrderPedbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrder")
    private long idOrder;
    @Basic(optional = true)
    @Column(name = "docNum")
    private long docNum;
    @Basic(optional = false)
    @Column(name = "docDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDate;
    @Basic(optional = false)
    @Column(name = "cardCode")
    private String cardCode;
    @Basic(optional = false)
    @Column(name = "numAtCard")
    private String numAtCard;
    @Basic(optional = false)
    @Column(name = "comments")
    private String comments;
    @Basic(optional = false)
    @Column(name = "slpCode")
    private String slpCode;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "companyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "docTotal")
    private Double docTotal;

    public OrderPedbox() {
    }

    public OrderPedbox(long idOrder, long docNum, Date docDate, String cardCode, String numAtCard, String comments, String slpCode, String status, String companyName, Double docTotal) {
        this.idOrder = idOrder;
        this.docNum = docNum;
        this.docDate = docDate;
        this.cardCode = cardCode;
        this.numAtCard = numAtCard;
        this.comments = comments;
        this.slpCode = slpCode;
        this.status = status;
        this.companyName = companyName;
        this.docTotal = docTotal;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getDocNum() {
        return docNum;
    }

    public void setDocNum(long docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(Double docTotal) {
        this.docTotal = docTotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.idOrder);
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
        final OrderPedbox other = (OrderPedbox) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderPedbox{" +
                "idOrder=" + idOrder +
                ", docNum=" + docNum +
                ", docDate=" + docDate +
                ", cardCode='" + cardCode + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", comments='" + comments + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", status='" + status + '\'' +
                ", companyName='" + companyName + '\'' +
                ", docTotal=" + docTotal +
                '}';
    }
}
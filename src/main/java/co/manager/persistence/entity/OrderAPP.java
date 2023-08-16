package co.manager.persistence.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "order_app")
public class OrderAPP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrder")
    private Integer idOrder;
    @Basic(optional = true)
    @Column(name = "docNum")
    private Integer docNum;
    @Column(name = "docDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDate;
    @Basic(optional = false)
    @Column(name = "cardCode")
    private String cardCode;
    @Basic(optional = false)
    @Column(name = "cardName")
    private String cardName;
    @Basic(optional = false)
    @Column(name = "numAtCard")
    private String numAtCard;
    @Basic(optional = false)
    @Column(name = "shipToCode")
    private String shipToCode;
    @Basic(optional = false)
    @Column(name = "payToCode")
    private String payToCode;
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
    @Column(name = "discountPercent")
    private Double discountPercent;
    @Basic(optional = false)
    @Column(name = "docTotal")
    private Double docTotal;
    @Basic(optional = false)
    @Column(name = "lineNum")
    private String lineNum;

    public OrderAPP() {
    }

    public OrderAPP(Integer idOrder, Integer docNum, Date docDate, String cardCode, String cardName, String numAtCard, String shipToCode, String payToCode, String comments, String slpCode, String status, String companyName, Double discountPercent, Double docTotal, String lineNum) {
        this.idOrder = idOrder;
        this.docNum = docNum;
        this.docDate = docDate;
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.numAtCard = numAtCard;
        this.shipToCode = shipToCode;
        this.payToCode = payToCode;
        this.comments = comments;
        this.slpCode = slpCode;
        this.status = status;
        this.companyName = companyName;
        this.discountPercent = discountPercent;
        this.docTotal = docTotal;
        this.lineNum = lineNum;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
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

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getNumAtCard() {
        return numAtCard;
    }

    public void setNumAtCard(String numAtCard) {
        this.numAtCard = numAtCard;
    }

    public String getShipToCode() {
        return shipToCode;
    }

    public void setShipToCode(String shipToCode) {
        this.shipToCode = shipToCode;
    }

    public String getPayToCode() {
        return payToCode;
    }

    public void setPayToCode(String payToCode) {
        this.payToCode = payToCode;
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

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Double getDocTotal() {
        return docTotal;
    }

    public void setDocTotal(Double docTotal) {
        this.docTotal = docTotal;
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum;
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
        final OrderAPP other = (OrderAPP) obj;
        if (!Objects.equals(this.idOrder, other.idOrder)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderAPP{" +
                "idOrder=" + idOrder +
                ", docNum=" + docNum +
                ", docDate=" + docDate +
                ", cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", numAtCard='" + numAtCard + '\'' +
                ", shipToCode='" + shipToCode + '\'' +
                ", payToCode='" + payToCode + '\'' +
                ", comments='" + comments + '\'' +
                ", slpCode='" + slpCode + '\'' +
                ", status='" + status + '\'' +
                ", companyName='" + companyName + '\'' +
                ", discountPercent=" + discountPercent +
                ", docTotal=" + docTotal +
                ", lineNum='" + lineNum + '\'' +
                '}';
    }
}
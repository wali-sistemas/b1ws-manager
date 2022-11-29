package co.manager.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "order_detail_pedbox")
public class OrderDetailPedbox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrderDetail")
    private long idOrderDetail;
    @JoinColumn(name = "idOrder", referencedColumnName = "idOrder")
    @ManyToOne(optional = false)
    private OrderPedbox idOrder;
    @Basic(optional = false)
    @Column(name = "itemCode")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "whsCode")
    private String whsCode;
    @Basic(optional = false)
    @Column(name = "qtyAPP")
    private Integer qtyAPP;
    @Basic(optional = false)
    @Column(name = "qtySAP")
    private Integer qtySAP;
    @Basic(optional = false)
    @Column(name = "qtyMDL")
    private Integer qtyMDL;
    @Basic(optional = false)
    @Column(name = "qtySBT")
    private Integer qtySBT;

    public OrderDetailPedbox() {
    }

    public OrderDetailPedbox(long idOrderDetail, OrderPedbox idOrder, String itemCode, String whsCode, Integer qtyAPP, Integer qtySAP, Integer qtyMDL, Integer qtySBT) {
        this.idOrderDetail = idOrderDetail;
        this.idOrder = idOrder;
        this.itemCode = itemCode;
        this.whsCode = whsCode;
        this.qtyAPP = qtyAPP;
        this.qtySAP = qtySAP;
        this.qtyMDL = qtyMDL;
        this.qtySBT = qtySBT;
    }

    public long getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(long idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public OrderPedbox getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderPedbox idOrder) {
        this.idOrder = idOrder;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public long getQtyAPP() {
        return qtyAPP;
    }

    public void setQtyAPP(Integer qtyAPP) {
        this.qtyAPP = qtyAPP;
    }

    public Integer getQtySAP() {
        return qtySAP;
    }

    public void setQtySAP(Integer qtySAP) {
        this.qtySAP = qtySAP;
    }

    public Integer getQtyMDL() {
        return qtyMDL;
    }

    public void setQtyMDL(Integer qtyMDL) {
        this.qtyMDL = qtyMDL;
    }

    public Integer getQtySBT() {
        return qtySBT;
    }

    public void setQtySBT(Integer qtySBT) {
        this.qtySBT = qtySBT;
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
        final OrderDetailPedbox other = (OrderDetailPedbox) obj;
        if (!Objects.equals(this.idOrderDetail, other.idOrderDetail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetailPedbox{" +
                "idOrderDetail=" + idOrderDetail +
                ", idOrder=" + idOrder +
                ", itemCode='" + itemCode + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", qtyAPP=" + qtyAPP +
                ", qtySAP=" + qtySAP +
                ", qtyMDL=" + qtyMDL +
                ", qtySBT=" + qtySBT +
                '}';
    }
}
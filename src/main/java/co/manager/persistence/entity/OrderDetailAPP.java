package co.manager.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "order_detail_app")
public class OrderDetailAPP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrderDetail")
    private long idOrderDetail;
    @JoinColumn(name = "idOrder", referencedColumnName = "idOrder")
    @ManyToOne(optional = false)
    private OrderAPP idOrder;
    @Basic(optional = false)
    @Column(name = "itemCode")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "group")
    private String group;
    @Basic(optional = false)
    @Column(name = "presentation")
    private String presentation;
    @Basic(optional = false)
    @Column(name = "whsCode")
    private String whsCode;
    @Basic(optional = false)
    @Column(name = "price")
    private Double price;
    @Basic(optional = false)
    @Column(name = "discountItem")
    private Double discountItem;
    @Basic(optional = false)
    @Column(name = "discountPorc")
    private Double discountPorc;
    @Basic(optional = false)
    @Column(name = "iva")
    private Double iva;
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

    public OrderDetailAPP() {
    }

    public OrderDetailAPP(long idOrderDetail, OrderAPP idOrder, String itemCode, String itemName, String group, String presentation, String whsCode, Double price, Double discountItem, Double discountPorc, Double iva, Integer qtyAPP, Integer qtySAP, Integer qtyMDL, Integer qtySBT) {
        this.idOrderDetail = idOrderDetail;
        this.idOrder = idOrder;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.group = group;
        this.presentation = presentation;
        this.whsCode = whsCode;
        this.price = price;
        this.discountItem = discountItem;
        this.discountPorc = discountPorc;
        this.iva = iva;
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

    public OrderAPP getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(OrderAPP idOrder) {
        this.idOrder = idOrder;
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

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountItem() {
        return discountItem;
    }

    public void setDiscountItem(Double discountItem) {
        this.discountItem = discountItem;
    }

    public Double getDiscountPorc() {
        return discountPorc;
    }

    public void setDiscountPorc(Double discountPorc) {
        this.discountPorc = discountPorc;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Integer getQtyAPP() {
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
        final OrderDetailAPP other = (OrderDetailAPP) obj;
        if (!Objects.equals(this.idOrderDetail, other.idOrderDetail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OrderDetailAPP{" +
                "idOrderDetail=" + idOrderDetail +
                ", idOrder=" + idOrder +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", group='" + group + '\'' +
                ", presentation='" + presentation + '\'' +
                ", whsCode='" + whsCode + '\'' +
                ", price=" + price +
                ", discountItem=" + discountItem +
                ", discountPorc=" + discountPorc +
                ", iva=" + iva +
                ", qtyAPP=" + qtyAPP +
                ", qtySAP=" + qtySAP +
                ", qtyMDL=" + qtyMDL +
                ", qtySBT=" + qtySBT +
                '}';
    }
}
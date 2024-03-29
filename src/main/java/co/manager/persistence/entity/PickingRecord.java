package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "picking_record")
public class PickingRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpicking_record")
    private Long id;
    @Basic(optional = false)
    @Column(name = "order_number")
    private Long orderNumber;
    @Basic(optional = false)
    @Column(name = "item_code")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "quantity")
    private Long quantity;
    @Basic(optional = false)
    @Column(name = "bin_from")
    private Long binFrom;
    @Basic(optional = false)
    @Column(name = "bin_to")
    private Long binTo;
    @Basic(optional = false)
    @Column(name = "stock_transfer_doc_entry")
    private Long stockTransferDocEntry;
    @Basic(optional = false)
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "transaction_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @Column(name = "company_name")
    private String companyName;

    public PickingRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getBinFrom() {
        return binFrom;
    }

    public void setBinFrom(Long binFrom) {
        this.binFrom = binFrom;
    }

    public Long getBinTo() {
        return binTo;
    }

    public void setBinTo(Long binTo) {
        this.binTo = binTo;
    }

    public Long getStockTransferDocEntry() {
        return stockTransferDocEntry;
    }

    public void setStockTransferDocEntry(Long stockTransferDocEntry) {
        this.stockTransferDocEntry = stockTransferDocEntry;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final PickingRecord other = (PickingRecord) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PickingRecord{" +
                "id=" + id +
                ", orderNumber=" + orderNumber +
                ", itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                ", binFrom=" + binFrom +
                ", binTo=" + binTo +
                ", stockTransferDocEntry=" + stockTransferDocEntry +
                ", empId='" + empId + '\'' +
                ", transactionDate=" + transactionDate +
                ", status='" + status + '\'' +
                ", expires=" + expires +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
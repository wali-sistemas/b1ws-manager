package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "ticket_ti")
public class TicketTI implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idticket")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idticket_ti_type")
    private Integer idTicketType;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "emp_id_add")
    private String empIdAdd;
    @Basic(optional = false)
    @Column(name = "emp_id_set")
    private String empIdSet;
    @Basic(optional = false)
    @Column(name = "url_attached")
    private String urlAttached;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "asunt")
    private String asunt;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "modify_date")
    private Date modifyDate;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "date_end")
    private Date dateEnd;

    public TicketTI() {
    }

    public TicketTI(Integer id, Integer idTicketType, Date date, String departmentName, String empIdAdd, String empIdSet, String urlAttached, String priority, String companyName, String asunt, String status, Date modifyDate) {
        this.id = id;
        this.idTicketType = idTicketType;
        this.date = date;
        this.departmentName = departmentName;
        this.empIdAdd = empIdAdd;
        this.empIdSet = empIdSet;
        this.urlAttached = urlAttached;
        this.priority = priority;
        this.companyName = companyName;
        this.asunt = asunt;
        this.status = status;
        this.modifyDate = modifyDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Integer idTicketType) {
        this.idTicketType = idTicketType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmpIdAdd() {
        return empIdAdd;
    }

    public void setEmpIdAdd(String empIdAdd) {
        this.empIdAdd = empIdAdd;
    }

    public String getEmpIdSet() {
        return empIdSet;
    }

    public void setEmpIdSet(String empIdSet) {
        this.empIdSet = empIdSet;
    }

    public String getUrlAttached() {
        return urlAttached;
    }

    public void setUrlAttached(String urlAttached) {
        this.urlAttached = urlAttached;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAsunt() {
        return asunt;
    }

    public void setAsunt(String asunt) {
        this.asunt = asunt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
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
        final TicketTI other = (TicketTI) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TicketTI{" +
                "id=" + id +
                ", idTicketType=" + idTicketType +
                ", date=" + date +
                ", departmentName='" + departmentName + '\'' +
                ", empIdAdd='" + empIdAdd + '\'' +
                ", empIdSet='" + empIdSet + '\'' +
                ", urlAttached='" + urlAttached + '\'' +
                ", priority='" + priority + '\'' +
                ", companyName='" + companyName + '\'' +
                ", asunt='" + asunt + '\'' +
                ", status='" + status + '\'' +
                ", modifyDate=" + modifyDate +
                ", type='" + type + '\'' +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
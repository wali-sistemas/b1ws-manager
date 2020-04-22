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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "idticket")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idticket_ti_type")
    private Long idTicketType;
    @Basic(optional = false)
    @Column(name = "date")
    private Date date;
    @Basic(optional = false)
    @Column(name = "department_name")
    private String departmentName;
    @Basic(optional = false)
    @Column(name = "emp_id_add")
    private String empIidAdd;
    @Basic(optional = false)
    @Column(name = "emp_id_set")
    private String empIidSet;
    @Basic(optional = false)
    @Column(name = "url_attached")
    private String urlAttached;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "company_name")
    private String companyName;

    public TicketTI() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTicketType() {
        return idTicketType;
    }

    public void setIdTicketType(Long idTicketType) {
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

    public String getEmpIidAdd() {
        return empIidAdd;
    }

    public void setEmpIidAdd(String empIidAdd) {
        this.empIidAdd = empIidAdd;
    }

    public String getEmpIidSet() {
        return empIidSet;
    }

    public void setEmpIidSet(String empIidSet) {
        this.empIidSet = empIidSet;
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
                ", empIidAdd='" + empIidAdd + '\'' +
                ", empIidSet='" + empIidSet + '\'' +
                ", urlAttached='" + urlAttached + '\'' +
                ", priority='" + priority + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
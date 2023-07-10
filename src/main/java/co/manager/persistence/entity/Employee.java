package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "cardCode", nullable = false)
    private String cardCode;
    @Basic(optional = false)
    @Column(name = "cardName", nullable = false)
    private String cardName;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @Column(name = "ccosto")
    private Integer ccosto;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Employee() {
    }

    public Employee(String cardCode) {
        this.cardCode = cardCode;
    }

    public Employee(String cardCode, String cardName, String department, String company, Integer ccosto, String status) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.department = department;
        this.company = company;
        this.ccosto = ccosto;
        this.status = status;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCcosto() {
        return ccosto;
    }

    public void setCcosto(Integer ccosto) {
        this.ccosto = ccosto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cardCode);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.cardCode, other.cardCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", department='" + department + '\'' +
                ", company='" + company + '\'' +
                ", ccosto=" + ccosto +
                ", status='" + status + '\'' +
                '}';
    }
}
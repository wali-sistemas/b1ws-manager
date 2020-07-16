package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDTO {
    public Integer idTicket;
    public String typeTicket;
    public Date dateTicket;
    public String department;
    public String empAdd;
    public String empSet;
    public String urlAttached;
    public String priority;
    public String company;
    public String asunt;

    public TicketDTO() {
    }

    public TicketDTO(Integer idTicket, String typeTicket, Date dateTicket, String department, String empAdd, String empSet, String urlAttached, String priority, String company) {
        this.idTicket = idTicket;
        this.typeTicket = typeTicket;
        this.dateTicket = dateTicket;
        this.department = department;
        this.empAdd = empAdd;
        this.empSet = empSet;
        this.urlAttached = urlAttached;
        this.priority = priority;
        this.company = company;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    public Date getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(Date dateTicket) {
        this.dateTicket = dateTicket;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmpAdd() {
        return empAdd;
    }

    public void setEmpAdd(String empAdd) {
        this.empAdd = empAdd;
    }

    public String getEmpSet() {
        return empSet;
    }

    public void setEmpSet(String empSet) {
        this.empSet = empSet;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAsunt() {
        return asunt;
    }

    public void setAsunt(String asunt) {
        this.asunt = asunt;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "idTicket=" + idTicket +
                ", typeTicket='" + typeTicket + '\'' +
                ", dateTicket=" + dateTicket +
                ", department='" + department + '\'' +
                ", empAdd='" + empAdd + '\'' +
                ", empSet='" + empSet + '\'' +
                ", urlAttached='" + urlAttached + '\'' +
                ", priority='" + priority + '\'' +
                ", company='" + company + '\'' +
                ", asunt='" + asunt + '\'' +
                '}';
    }
}
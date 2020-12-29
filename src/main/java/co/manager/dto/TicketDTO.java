package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketDTO {
    public Integer idTicket;
    public Integer idTypeTicket;
    public String typeTicket;
    public String dateTicket;
    public String department;
    public String empAdd;
    public String empSet;
    public String urlAttached;
    public String priority;
    public String company;
    public String asunt;
    public String status;
    public String type;
    public String dateEnd;

    public TicketDTO() {
    }

    public TicketDTO(String department, String empAdd, String empSet, String priority, String company, String asunt, String status) {
        this.department = department;
        this.empAdd = empAdd;
        this.empSet = empSet;
        this.priority = priority;
        this.company = company;
        this.asunt = asunt;
        this.status = status;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Integer getIdTypeTicket() {
        return idTypeTicket;
    }

    public void setIdTypeTicket(Integer idTypeTicket) {
        this.idTypeTicket = idTypeTicket;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    public String getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(String dateTicket) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "idTicket=" + idTicket +
                ", idTypeTicket=" + idTypeTicket +
                ", typeTicket='" + typeTicket + '\'' +
                ", dateTicket='" + dateTicket + '\'' +
                ", department='" + department + '\'' +
                ", empAdd='" + empAdd + '\'' +
                ", empSet='" + empSet + '\'' +
                ", urlAttached='" + urlAttached + '\'' +
                ", priority='" + priority + '\'' +
                ", company='" + company + '\'' +
                ", asunt='" + asunt + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", dateEnd=" + dateEnd +
                '}';
    }
}
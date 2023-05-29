package co.manager.dto;

/**
 * @author jguisao
 */
public class EmployeeDTO {
    private String cardCode;
    private String cardName;
    private String department;
    private String companyName;
    private String status;
    private Integer ccosto;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String cardCode, String cardName, String department, String companyName, Integer ccosto, String status) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.department = department;
        this.companyName = companyName;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCcosto() {
        return ccosto;
    }

    public void setCcosto(Integer ccosto) {
        this.ccosto = ccosto;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", department='" + department + '\'' +
                ", companyName='" + companyName + '\'' +
                ", status='" + status + '\'' +
                ", ccosto=" + ccosto +
                '}';
    }
}
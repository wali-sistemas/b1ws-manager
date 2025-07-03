package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class AssociatedFemproDTO {
    private String code;
    private String name;
    private String apell1;
    private String apell2;
    private Date birthdate;
    private Date dateIngr;
    private String companyName;
    private String jobTitle;
    private BigDecimal salary;
    private BigDecimal ingresPrest;
    private BigDecimal ingresNoPrest;
    private Date dateAfil;
    private Date dateRet;
    private String status;
    private String address;
    private String locality;
    private String phone;
    private String email;
    private String statusCivil;
    private String typeAccount;
    private String accountBanc;
    private String fdoBanc;
    private BigDecimal apMonth;
    private boolean apPeriod1;
    private boolean apPeriod2;
    private String codeBenef1;
    private String nameBenef1;
    private String parentBenef1;
    private String codeBenef2;
    private String nameBenef2;
    private String parentBenef2;

    public AssociatedFemproDTO() {
    }

    public AssociatedFemproDTO(String code, String name, String apell1, String apell2, Date birthdate, Date dateIngr, String companyName, String jobTitle, BigDecimal salary, BigDecimal ingresPrest, BigDecimal ingresNoPrest, Date dateAfil, Date dateRet, String status, String address, String locality, String phone, String email, String statusCivil, String typeAccount, String accountBanc, String fdoBanc, BigDecimal apMonth, boolean apPeriod1, boolean apPeriod2, String codeBenef1, String nameBenef1, String parentBenef1, String codeBenef2, String nameBenef2, String parentBenef2) {
        this.code = code;
        this.name = name;
        this.apell1 = apell1;
        this.apell2 = apell2;
        this.birthdate = birthdate;
        this.dateIngr = dateIngr;
        this.companyName = companyName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.ingresPrest = ingresPrest;
        this.ingresNoPrest = ingresNoPrest;
        this.dateAfil = dateAfil;
        this.dateRet = dateRet;
        this.status = status;
        this.address = address;
        this.locality = locality;
        this.phone = phone;
        this.email = email;
        this.statusCivil = statusCivil;
        this.typeAccount = typeAccount;
        this.accountBanc = accountBanc;
        this.fdoBanc = fdoBanc;
        this.apMonth = apMonth;
        this.apPeriod1 = apPeriod1;
        this.apPeriod2 = apPeriod2;
        this.codeBenef1 = codeBenef1;
        this.nameBenef1 = nameBenef1;
        this.parentBenef1 = parentBenef1;
        this.codeBenef2 = codeBenef2;
        this.nameBenef2 = nameBenef2;
        this.parentBenef2 = parentBenef2;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApell1() {
        return apell1;
    }

    public void setApell1(String apell1) {
        this.apell1 = apell1;
    }

    public String getApell2() {
        return apell2;
    }

    public void setApell2(String apell2) {
        this.apell2 = apell2;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getDateIngr() {
        return dateIngr;
    }

    public void setDateIngr(Date dateIngr) {
        this.dateIngr = dateIngr;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getIngresPrest() {
        return ingresPrest;
    }

    public void setIngresPrest(BigDecimal ingresPrest) {
        this.ingresPrest = ingresPrest;
    }

    public BigDecimal getIngresNoPrest() {
        return ingresNoPrest;
    }

    public void setIngresNoPrest(BigDecimal ingresNoPrest) {
        this.ingresNoPrest = ingresNoPrest;
    }

    public Date getDateAfil() {
        return dateAfil;
    }

    public void setDateAfil(Date dateAfil) {
        this.dateAfil = dateAfil;
    }

    public Date getDateRet() {
        return dateRet;
    }

    public void setDateRet(Date dateRet) {
        this.dateRet = dateRet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatusCivil() {
        return statusCivil;
    }

    public void setStatusCivil(String statusCivil) {
        this.statusCivil = statusCivil;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public String getAccountBanc() {
        return accountBanc;
    }

    public void setAccountBanc(String accountBanc) {
        this.accountBanc = accountBanc;
    }

    public String getFdoBanc() {
        return fdoBanc;
    }

    public void setFdoBanc(String fdoBanc) {
        this.fdoBanc = fdoBanc;
    }

    public BigDecimal getApMonth() {
        return apMonth;
    }

    public void setApMonth(BigDecimal apMonth) {
        this.apMonth = apMonth;
    }

    public boolean isApPeriod1() {
        return apPeriod1;
    }

    public void setApPeriod1(boolean apPeriod1) {
        this.apPeriod1 = apPeriod1;
    }

    public boolean isApPeriod2() {
        return apPeriod2;
    }

    public void setApPeriod2(boolean apPeriod2) {
        this.apPeriod2 = apPeriod2;
    }

    public String getCodeBenef1() {
        return codeBenef1;
    }

    public void setCodeBenef1(String codeBenef1) {
        this.codeBenef1 = codeBenef1;
    }

    public String getNameBenef1() {
        return nameBenef1;
    }

    public void setNameBenef1(String nameBenef1) {
        this.nameBenef1 = nameBenef1;
    }

    public String getParentBenef1() {
        return parentBenef1;
    }

    public void setParentBenef1(String parentBenef1) {
        this.parentBenef1 = parentBenef1;
    }

    public String getCodeBenef2() {
        return codeBenef2;
    }

    public void setCodeBenef2(String codeBenef2) {
        this.codeBenef2 = codeBenef2;
    }

    public String getNameBenef2() {
        return nameBenef2;
    }

    public void setNameBenef2(String nameBenef2) {
        this.nameBenef2 = nameBenef2;
    }

    public String getParentBenef2() {
        return parentBenef2;
    }

    public void setParentBenef2(String parentBenef2) {
        this.parentBenef2 = parentBenef2;
    }

    @Override
    public String toString() {
        return "AssociatedFemproDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", apell1='" + apell1 + '\'' +
                ", apell2='" + apell2 + '\'' +
                ", birthdate=" + birthdate +
                ", dateIngr=" + dateIngr +
                ", companyName='" + companyName + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", ingresPrest=" + ingresPrest +
                ", ingresNoPrest=" + ingresNoPrest +
                ", dateAfil=" + dateAfil +
                ", dateRet=" + dateRet +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", locality='" + locality + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", statusCivil='" + statusCivil + '\'' +
                ", typeAccount='" + typeAccount + '\'' +
                ", accountBanc='" + accountBanc + '\'' +
                ", fdoBanc='" + fdoBanc + '\'' +
                ", apMonth=" + apMonth +
                ", apPeriod1=" + apPeriod1 +
                ", apPeriod2=" + apPeriod2 +
                ", codeBenef1='" + codeBenef1 + '\'' +
                ", nameBenef1='" + nameBenef1 + '\'' +
                ", parentBenef1='" + parentBenef1 + '\'' +
                ", codeBenef2='" + codeBenef2 + '\'' +
                ", nameBenef2='" + nameBenef2 + '\'' +
                ", parentBenef2='" + parentBenef2 + '\'' +
                '}';
    }
}
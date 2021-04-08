package co.manager.hanaws.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class LoginDTO implements Serializable {
    @JsonProperty("CompanyDB")
    private String companyDB;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("UserName")
    private String userName;

    public LoginDTO() {
    }

    public LoginDTO(String companyDB, String password, String userName) {
        this.companyDB = companyDB;
        this.password = password;
        this.userName = userName;
    }

    public String getCompanyDB() {
        return companyDB;
    }

    public void setCompanyDB(String companyDB) {
        this.companyDB = companyDB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "CompanyDB='" + companyDB + '\'' +
                ", Password='" + password + '\'' +
                ", UserName='" + userName + '\'' +
                '}';
    }
}
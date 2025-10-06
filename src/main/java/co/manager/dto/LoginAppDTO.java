package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginAppDTO {
    private String slpCode;
    private String slpName;
    private String passWord;
    private String companyName;
    private String appVersion;

    public LoginAppDTO() {
    }

    public LoginAppDTO(String slpCode, String slpName, String passWord, String companyName, String appVersion) {
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.passWord = passWord;
        this.companyName = companyName;
        this.appVersion = appVersion;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "LoginAppDTO{" +
                "slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", companyName='" + companyName + '\'' +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }
}
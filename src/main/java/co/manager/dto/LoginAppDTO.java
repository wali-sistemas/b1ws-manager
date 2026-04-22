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
    private String whsTire1;
    private String whsTire2;
    private String whsTire3;
    private String whsTire4;

    public LoginAppDTO() {
    }

    public LoginAppDTO(String slpCode, String slpName, String passWord, String companyName, String appVersion, String whsTire1, String whsTire2, String whsTire3, String whsTire4) {
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.passWord = passWord;
        this.companyName = companyName;
        this.appVersion = appVersion;
        this.whsTire1 = whsTire1;
        this.whsTire2 = whsTire2;
        this.whsTire3 = whsTire3;
        this.whsTire4 = whsTire4;
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

    public String getWhsTire1() {
        return whsTire1;
    }

    public void setWhsTire1(String whsTire1) {
        this.whsTire1 = whsTire1;
    }

    public String getWhsTire2() {
        return whsTire2;
    }

    public void setWhsTire2(String whsTire2) {
        this.whsTire2 = whsTire2;
    }

    public String getWhsTire3() {
        return whsTire3;
    }

    public void setWhsTire3(String whsTire3) {
        this.whsTire3 = whsTire3;
    }

    public String getWhsTire4() {
        return whsTire4;
    }

    public void setWhsTire4(String whsTire4) {
        this.whsTire4 = whsTire4;
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
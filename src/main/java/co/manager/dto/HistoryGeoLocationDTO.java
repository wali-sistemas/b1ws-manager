package co.manager.dto;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class HistoryGeoLocationDTO implements Serializable {
    private String slpCode;
    private String slpName;
    private String docDate;
    private String docTime;
    private String latitude;
    private String longitude;
    private String docType;
    private String companyName;
    private String regional;

    public HistoryGeoLocationDTO() {
    }

    public HistoryGeoLocationDTO(String slpCode, String slpName, String docDate, String docTime, String latitude, String longitude, String docType, String companyName, String regional) {
        this.slpCode = slpCode;
        this.slpName = slpName;
        this.docDate = docDate;
        this.docTime = docTime;
        this.latitude = latitude;
        this.longitude = longitude;
        this.docType = docType;
        this.companyName = companyName;
        this.regional = regional;
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

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getDocTime() {
        return docTime;
    }

    public void setDocTime(String docTime) {
        this.docTime = docTime;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    @Override
    public String toString() {
        return "HistoryGeoLocationDTO{" +
                "slpCode='" + slpCode + '\'' +
                ", slpName='" + slpName + '\'' +
                ", docDate='" + docDate + '\'' +
                ", docTime='" + docTime + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", docType='" + docType + '\'' +
                ", companyName='" + companyName + '\'' +
                ", regional='" + regional + '\'' +
                '}';
    }
}
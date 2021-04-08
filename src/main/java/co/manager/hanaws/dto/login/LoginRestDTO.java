package co.manager.hanaws.dto.login;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class LoginRestDTO implements Serializable {
    @JsonProperty("odata.metadata")
    private String metaData;
    @JsonProperty("SessionId")
    private String sessionId;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("SessionTimeout")
    private Integer sessionTimeout;

    public LoginRestDTO() {
    }

    public LoginRestDTO(String metaData, String sessionId, String version, Integer sessionTimeout) {
        this.metaData = metaData;
        this.sessionId = sessionId;
        this.version = version;
        this.sessionTimeout = sessionTimeout;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    @Override
    public String toString() {
        return "LoginRESTResponseDTO{" +
                "odata.metadata='" + metaData + '\'' +
                ", SessionId='" + sessionId + '\'' +
                ", Version='" + version + '\'' +
                ", SessionTimeout=" + sessionTimeout +
                '}';
    }
}
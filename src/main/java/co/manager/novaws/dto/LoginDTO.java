package co.manager.novaws.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class LoginDTO implements Serializable {
    private String username;
    @JsonProperty("access_key")
    private String accessKey;

    public LoginDTO() {
    }

    public LoginDTO(String username, String accessKey) {
        this.username = username;
        this.accessKey = accessKey;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "username='" + username + '\'' +
                ", accessKey='" + accessKey + '\'' +
                '}';
    }
}
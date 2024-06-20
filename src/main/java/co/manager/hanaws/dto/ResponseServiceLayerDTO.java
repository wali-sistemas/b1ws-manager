package co.manager.hanaws.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseServiceLayerDTO implements Serializable {
    @JsonProperty("error")
    protected Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Error implements Serializable {
        @JsonProperty("code")
        protected Integer code;
        @JsonProperty("message")
        protected Message message;

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Message implements Serializable {
            @JsonProperty("lang")
            protected String lang;
            @JsonProperty("value")
            protected String value;

            public String getLang() {
                return lang;
            }

            public void setLang(String lang) {
                this.lang = lang;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "Message{" +
                        "lang='" + lang + '\'' +
                        ", value='" + value + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Error{" +
                    "code=" + code +
                    ", message=" + message +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseServiceLayerDTO{" +
                "error=" + error +
                '}';
    }
}
package co.manager.hanaws.dto.udo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeResFisSnDTO implements Serializable {
    @JsonProperty("Period")
    protected Long period;
    @JsonProperty("Instance")
    protected Long instance;
    @JsonProperty("Handwrtten")
    protected String handwrtten;
    @JsonProperty("Status")
    protected String status;
    @JsonProperty("RequestStatus")
    protected String requestStatus;
    @JsonProperty("Canceled")
    protected String canceled;
    @JsonProperty("Object")
    protected String object;
    @JsonProperty("Transfered")
    protected String transfered;
    @JsonProperty("CreateDate")
    protected String createDate;
    @JsonProperty("UpdateDate")
    protected String updateDate;
    @JsonProperty("DataSource")
    protected String dataSource;
    @JsonProperty("U_CardCode")
    protected String uCardCode;
    @JsonProperty("U_CardName")
    protected String uCardName;
    @JsonProperty("OK1_FE_RES_FIS_SN_LCollection")
    protected List<FeResFisSnDTO.FeResFisSnLDTO> feResFisSnLDTO;

    public static class FeResFisSnLDTO {
        @JsonProperty("LineId")
        protected Long lineId;
        @JsonProperty("VisOrder")
        protected Long visOrder;
        @JsonProperty("Object")
        protected String object;
        @JsonProperty("LogInst")
        protected String logInst;
        @JsonProperty("U_codeResFis")
        protected String uCodeResFis;
        @JsonProperty("U_descResFis")
        protected String uDescResFis;
        @JsonProperty("U_lineNum")
        protected Long uLineNum;

        public Long getLineId() {
            return lineId;
        }

        public void setLineId(Long lineId) {
            this.lineId = lineId;
        }

        public Long getVisOrder() {
            return visOrder;
        }

        public void setVisOrder(Long visOrder) {
            this.visOrder = visOrder;
        }

        public String getObject() {
            return object;
        }

        public void setObject(String object) {
            this.object = object;
        }

        public String getLogInst() {
            return logInst;
        }

        public void setLogInst(String logInst) {
            this.logInst = logInst;
        }

        public String getuCodeResFis() {
            return uCodeResFis;
        }

        public void setuCodeResFis(String uCodeResFis) {
            this.uCodeResFis = uCodeResFis;
        }

        public String getuDescResFis() {
            return uDescResFis;
        }

        public void setuDescResFis(String uDescResFis) {
            this.uDescResFis = uDescResFis;
        }

        public Long getuLineNum() {
            return uLineNum;
        }

        public void setuLineNum(Long uLineNum) {
            this.uLineNum = uLineNum;
        }

        @Override
        public String toString() {
            return "FeResFisSnLDTO{" +
                    "lineId=" + lineId +
                    ", visOrder=" + visOrder +
                    ", object='" + object + '\'' +
                    ", logInst='" + logInst + '\'' +
                    ", uCodeResFis='" + uCodeResFis + '\'' +
                    ", uDescResFis='" + uDescResFis + '\'' +
                    ", uLineNum=" + uLineNum +
                    '}';
        }
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Long getInstance() {
        return instance;
    }

    public void setInstance(Long instance) {
        this.instance = instance;
    }

    public String getHandwrtten() {
        return handwrtten;
    }

    public void setHandwrtten(String handwrtten) {
        this.handwrtten = handwrtten;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getCanceled() {
        return canceled;
    }

    public void setCanceled(String canceled) {
        this.canceled = canceled;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getTransfered() {
        return transfered;
    }

    public void setTransfered(String transfered) {
        this.transfered = transfered;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getuCardCode() {
        return uCardCode;
    }

    public void setuCardCode(String uCardCode) {
        this.uCardCode = uCardCode;
    }

    public String getuCardName() {
        return uCardName;
    }

    public void setuCardName(String uCardName) {
        this.uCardName = uCardName;
    }

    public List<FeResFisSnLDTO> getFeResFisSnLDTO() {
        return feResFisSnLDTO;
    }

    public void setFeResFisSnLDTO(List<FeResFisSnLDTO> feResFisSnLDTO) {
        this.feResFisSnLDTO = feResFisSnLDTO;
    }

    @Override
    public String toString() {
        return "FeResFisSnDTO{" +
                "period=" + period +
                ", instance=" + instance +
                ", handwrtten='" + handwrtten + '\'' +
                ", status='" + status + '\'' +
                ", requestStatus='" + requestStatus + '\'' +
                ", canceled='" + canceled + '\'' +
                ", object='" + object + '\'' +
                ", transfered='" + transfered + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", dataSource='" + dataSource + '\'' +
                ", uCardCode='" + uCardCode + '\'' +
                ", uCardName='" + uCardName + '\'' +
                ", feResFisSnLDTO=" + feResFisSnLDTO +
                '}';
    }
}
package co.manager.dto;

/**
 * @author jguisao
 */
public class WarehouseDTO {
    private String whsCode;
    private String whsName;
    private Integer type;

    public WarehouseDTO() {
    }

    public WarehouseDTO(String whsCode, String whsName, Integer type) {
        this.whsCode = whsCode;
        this.whsName = whsName;
        this.type = type;
    }

    public String getWhsCode() {
        return whsCode;
    }

    public void setWhsCode(String whsCode) {
        this.whsCode = whsCode;
    }

    public String getWhsName() {
        return whsName;
    }

    public void setWhsName(String whsName) {
        this.whsName = whsName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "whsCode='" + whsCode + '\'' +
                ", whsName='" + whsName + '\'' +
                ", type=" + type +
                '}';
    }
}
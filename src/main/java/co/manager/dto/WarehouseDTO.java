package co.manager.dto;

/**
 * @author jguisao
 */
public class WarehouseDTO {
    private String whsCode;
    private String whsName;

    public WarehouseDTO() {
    }

    public WarehouseDTO(String whsCode, String whsName) {
        this.whsCode = whsCode;
        this.whsName = whsName;
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

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "bodega='" + whsCode + '\'' +
                ", descripción='" + whsName + '\'' +
                '}';
    }
}
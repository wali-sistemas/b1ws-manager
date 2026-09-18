package co.manager.dto;

/**
 * @author jguisao
 */
public class DespachoExhibidoreDTO {
    private String code;
    private String name;
    private String cardCode;
    private String itemCode;
    private Integer qty;
    private String marca;
    private String baseRef;

    public DespachoExhibidoreDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getBaseRef() {
        return baseRef;
    }

    public void setBaseRef(String baseRef) {
        this.baseRef = baseRef;
    }

    @Override
    public String toString() {
        return "DespachoExhibidoreDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", qty=" + qty +
                ", marca='" + marca + '\'' +
                ", baseRef='" + baseRef + '\'' +
                '}';
    }
}

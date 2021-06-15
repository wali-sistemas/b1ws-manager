package co.manager.dto;

import java.io.Serializable;

/**
 * @author jguisao
 */
public class PointAvailableCalidosoDTO implements Serializable {
    private String cardCode;
    private String concept;
    private Integer point;

    public PointAvailableCalidosoDTO() {
    }

    public PointAvailableCalidosoDTO(String cardCode, String concept, Integer point) {
        this.cardCode = cardCode;
        this.concept = concept;
        this.point = point;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "PointAvailableCalidosoDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", concept='" + concept + '\'' +
                ", point=" + point +
                '}';
    }
}
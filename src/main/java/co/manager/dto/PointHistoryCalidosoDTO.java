package co.manager.dto;

/**
 * @author jguisao
 */
public class PointHistoryCalidosoDTO {
    private String cardCode;
    private String concept;
    private Integer docNum;
    private String docType;
    private String docDate;
    private Integer point;

    public PointHistoryCalidosoDTO() {
    }

    public PointHistoryCalidosoDTO(String cardCode, String concept, Integer docNum, String docType, String docDate, Integer point) {
        this.cardCode = cardCode;
        this.concept = concept;
        this.docNum = docNum;
        this.docType = docType;
        this.docDate = docDate;
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

    public Integer getDocNum() {
        return docNum;
    }

    public void setDocNum(Integer docNum) {
        this.docNum = docNum;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "PointCalidosoDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", concept='" + concept + '\'' +
                ", docNum=" + docNum +
                ", docType='" + docType + '\'' +
                ", docDate='" + docDate + '\'' +
                ", point=" + point +
                '}';
    }
}
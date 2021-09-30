package co.manager.dto;

import java.util.List;

/**
 * @author jguisao
 */
public class StockShoppingCartDTO {
    private String cardCode;
    private String companyName;
    private List<String> items;

    public StockShoppingCartDTO() {
    }

    public String getCardCode() {
        return cardCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "StockShoppingCartDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", companyName='" + companyName + '\'' +
                ", items=" + items +
                '}';
    }
}
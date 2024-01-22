package co.manager.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class DetailAgeCustomerPortfolioDTO {
    private String slpCode;
    private String cardCode;
    private BigDecimal ageSinVencer;
    private BigDecimal age0a30;
    private BigDecimal age30a60;
    private BigDecimal age61a90;
    private BigDecimal age91a120;
    private BigDecimal ageMas120;
    private BigDecimal subTotal;
    private BigDecimal total;
    private String email;
    private String phone;

    public DetailAgeCustomerPortfolioDTO() {
    }

    public DetailAgeCustomerPortfolioDTO(String slpCode, String cardCode, BigDecimal ageSinVencer, BigDecimal age0a30, BigDecimal age30a60, BigDecimal age61a90, BigDecimal age91a120, BigDecimal ageMas120, BigDecimal subTotal, BigDecimal total, String email, String phone) {
        this.slpCode = slpCode;
        this.cardCode = cardCode;
        this.ageSinVencer = ageSinVencer;
        this.age0a30 = age0a30;
        this.age30a60 = age30a60;
        this.age61a90 = age61a90;
        this.age91a120 = age91a120;
        this.ageMas120 = ageMas120;
        this.subTotal = subTotal;
        this.total = total;
        this.email = email;
        this.phone = phone;
    }

    public String getSlpCode() {
        return slpCode;
    }

    public void setSlpCode(String slpCode) {
        this.slpCode = slpCode;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public BigDecimal getAgeSinVencer() {
        return ageSinVencer;
    }

    public void setAgeSinVencer(BigDecimal ageSinVencer) {
        this.ageSinVencer = ageSinVencer;
    }

    public BigDecimal getAge0a30() {
        return age0a30;
    }

    public void setAge0a30(BigDecimal age0a30) {
        this.age0a30 = age0a30;
    }

    public BigDecimal getAge30a60() {
        return age30a60;
    }

    public void setAge30a60(BigDecimal age30a60) {
        this.age30a60 = age30a60;
    }

    public BigDecimal getAge61a90() {
        return age61a90;
    }

    public void setAge61a90(BigDecimal age61a90) {
        this.age61a90 = age61a90;
    }

    public BigDecimal getAge91a120() {
        return age91a120;
    }

    public void setAge91a120(BigDecimal age91a120) {
        this.age91a120 = age91a120;
    }

    public BigDecimal getAgeMas120() {
        return ageMas120;
    }

    public void setAgeMas120(BigDecimal ageMas120) {
        this.ageMas120 = ageMas120;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "DetailAgeCustomerPortfolioDTO{" +
                "slpCode='" + slpCode + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", ageSinVencer=" + ageSinVencer +
                ", age0a30=" + age0a30 +
                ", age30a60=" + age30a60 +
                ", age61a90=" + age61a90 +
                ", age91a120=" + age91a120 +
                ", ageMas120=" + ageMas120 +
                ", subTotal=" + subTotal +
                ", total=" + total +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioCustomerDTO {
    private String cardCode;
    private String cardName;
    private String licTradNum;
    private String slpName;
    private String payCondition;
    private BigDecimal cupo;
    private Integer payDayAvg;
    private Date lastSaleDay;
    private Integer totalDoc;
    private String emailFE;
    private List<DetailPortfolioCustomerDTO> detailPortfolio;

    public PortfolioCustomerDTO() {
    }

    public PortfolioCustomerDTO(String cardCode, String cardName, String licTradNum, String slpName, String payCondition, BigDecimal cupo, Integer payDayAvg, Date lastSaleDay, Integer totalDoc, String emailFE, List<DetailPortfolioCustomerDTO> detailPortfolio) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.licTradNum = licTradNum;
        this.slpName = slpName;
        this.payCondition = payCondition;
        this.cupo = cupo;
        this.payDayAvg = payDayAvg;
        this.lastSaleDay = lastSaleDay;
        this.totalDoc = totalDoc;
        this.emailFE = emailFE;
        this.detailPortfolio = detailPortfolio;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getLicTradNum() {
        return licTradNum;
    }

    public void setLicTradNum(String licTradNum) {
        this.licTradNum = licTradNum;
    }

    public String getSlpName() {
        return slpName;
    }

    public void setSlpName(String slpName) {
        this.slpName = slpName;
    }

    public String getPayCondition() {
        return payCondition;
    }

    public void setPayCondition(String payCondition) {
        this.payCondition = payCondition;
    }

    public BigDecimal getCupo() {
        return cupo;
    }

    public void setCupo(BigDecimal cupo) {
        this.cupo = cupo;
    }

    public Integer getPayDayAvg() {
        return payDayAvg;
    }

    public void setPayDayAvg(Integer payDayAvg) {
        this.payDayAvg = payDayAvg;
    }

    public Date getLastSaleDay() {
        return lastSaleDay;
    }

    public void setLastSaleDay(Date lastSaleDay) {
        this.lastSaleDay = lastSaleDay;
    }

    public List<DetailPortfolioCustomerDTO> getDetailPortfolio() {
        return detailPortfolio;
    }

    public void setDetailPortfolio(List<DetailPortfolioCustomerDTO> detailPortfolio) {
        this.detailPortfolio = detailPortfolio;
    }

    public Integer getTotalDoc() {
        return totalDoc;
    }

    public void setTotalDoc(Integer totalDoc) {
        this.totalDoc = totalDoc;
    }

    public String getEmailFE() {
        return emailFE;
    }

    public void setEmailFE(String emailFE) {
        this.emailFE = emailFE;
    }

    @Override
    public String toString() {
        return "PortfolioCustomerDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", licTradNum='" + licTradNum + '\'' +
                ", slpName='" + slpName + '\'' +
                ", payCondition='" + payCondition + '\'' +
                ", cupo=" + cupo +
                ", payDayAvg=" + payDayAvg +
                ", lastSaleDay=" + lastSaleDay +
                ", totalDoc=" + totalDoc +
                ", emailFE='" + emailFE + '\'' +
                ", detailPortfolio=" + detailPortfolio +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DetailPortfolioCustomerDTO {
        private String docType;
        private Date docDate;
        private Date docDueDate;
        private String docDateCutoff;
        private BigDecimal balance;
        private BigDecimal docTotal;
        private Integer docNum;
        private Integer expiredDays;
        private String urlFE;
        private BigDecimal iva;
        private BigDecimal subtotal;
        private BigDecimal discount;
        private BigDecimal totalBruto;
        private String activeCalc;
        private String comment;
        private Integer discApplied;

        public DetailPortfolioCustomerDTO() {
        }

        public String getDocType() {
            return docType;
        }

        public void setDocType(String docType) {
            this.docType = docType;
        }

        public Date getDocDate() {
            return docDate;
        }

        public void setDocDate(Date docDate) {
            this.docDate = docDate;
        }

        public Date getDocDueDate() {
            return docDueDate;
        }

        public void setDocDueDate(Date docDueDate) {
            this.docDueDate = docDueDate;
        }

        public String getDocDateCutoff() {
            return docDateCutoff;
        }

        public void setDocDateCutoff(String docDateCutoff) {
            this.docDateCutoff = docDateCutoff;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public BigDecimal getDocTotal() {
            return docTotal;
        }

        public void setDocTotal(BigDecimal docTotal) {
            this.docTotal = docTotal;
        }

        public Integer getDocNum() {
            return docNum;
        }

        public void setDocNum(Integer docNum) {
            this.docNum = docNum;
        }

        public Integer getExpiredDays() {
            return expiredDays;
        }

        public void setExpiredDays(Integer expiredDays) {
            this.expiredDays = expiredDays;
        }

        public String getUrlFE() {
            return urlFE;
        }

        public void setUrlFE(String urlFE) {
            this.urlFE = urlFE;
        }

        public BigDecimal getIva() {
            return iva;
        }

        public void setIva(BigDecimal iva) {
            this.iva = iva;
        }

        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }

        public BigDecimal getDiscount() {
            return discount;
        }

        public void setDiscount(BigDecimal discount) {
            this.discount = discount;
        }

        public BigDecimal getTotalBruto() {
            return totalBruto;
        }

        public void setTotalBruto(BigDecimal totalBruto) {
            this.totalBruto = totalBruto;
        }

        public String getActiveCalc() {
            return activeCalc;
        }

        public void setActiveCalc(String activeCalc) {
            this.activeCalc = activeCalc;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public Integer getDiscApplied() {
            return discApplied;
        }

        public void setDiscApplied(Integer discApplied) {
            this.discApplied = discApplied;
        }

        @Override
        public String toString() {
            return "DetailPortfolioCustomerDTO{" +
                    "docType='" + docType + '\'' +
                    ", docDate=" + docDate +
                    ", docDueDate=" + docDueDate +
                    ", docDateCutoff='" + docDateCutoff + '\'' +
                    ", balance=" + balance +
                    ", docTotal=" + docTotal +
                    ", docNum=" + docNum +
                    ", expiredDays=" + expiredDays +
                    ", urlFE='" + urlFE + '\'' +
                    ", iva=" + iva +
                    ", subtotal=" + subtotal +
                    ", discount=" + discount +
                    ", totalBruto=" + totalBruto +
                    ", activeCalc='" + activeCalc + '\'' +
                    ", comment='" + comment + '\'' +
                    ", discApplied=" + discApplied +
                    '}';
        }
    }
}
package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author jguisao
 */
public class CustomerPortfolioDTO {
    private String cardCode;
    private String cardName;
    private String licTradNum;
    private String slpName;
    private String payCondition;
    private BigDecimal cupo;
    private Integer payDayAvg;
    private Date lastSaleDay;
    private List<detailPortfolioDTO> detailPortfolio;

    public CustomerPortfolioDTO() {
    }

    public CustomerPortfolioDTO(String cardCode, String cardName, String licTradNum, String slpName, String payCondition, BigDecimal cupo, Integer payDayAvg, Date lastSaleDay, List<detailPortfolioDTO> detailPortfolio) {
        this.cardCode = cardCode;
        this.cardName = cardName;
        this.licTradNum = licTradNum;
        this.slpName = slpName;
        this.payCondition = payCondition;
        this.cupo = cupo;
        this.payDayAvg = payDayAvg;
        this.lastSaleDay = lastSaleDay;
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

    public List<detailPortfolioDTO> getDetailPortfolio() {
        return detailPortfolio;
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

    public void setDetailPortfolio(List<detailPortfolioDTO> detailPortfolio) {
        this.detailPortfolio = detailPortfolio;
    }

    @Override
    public String toString() {
        return "CustomerPortfolioDTO{" +
                "cardCode='" + cardCode + '\'' +
                ", cardName='" + cardName + '\'' +
                ", licTradNum='" + licTradNum + '\'' +
                ", slpName='" + slpName + '\'' +
                ", payCondition='" + payCondition + '\'' +
                ", cupo=" + cupo +
                ", payDayAvg=" + payDayAvg +
                ", lastSaleDay=" + lastSaleDay +
                ", detailPortfolio=" + detailPortfolio +
                '}';
    }

    public static class detailPortfolioDTO {
        private String docType;
        private Date docDate;
        private Date docDueDate;
        private String docDateCutoff;
        private BigDecimal balance;
        private BigDecimal docTotal;
        private Integer docNum;
        private Integer expiredDays;

        public detailPortfolioDTO() {
        }

        public detailPortfolioDTO(String docType, Date docDate, Date docDueDate, String docDateCutoff, BigDecimal balance, BigDecimal docTotal, Integer docNum, Integer expiredDays) {
            this.docType = docType;
            this.docDate = docDate;
            this.docDueDate = docDueDate;
            this.docDateCutoff = docDateCutoff;
            this.balance = balance;
            this.docTotal = docTotal;
            this.docNum = docNum;
            this.expiredDays = expiredDays;
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

        @Override
        public String toString() {
            return "detailPortfolioDTO{" +
                    "docType='" + docType + '\'' +
                    ", docDate=" + docDate +
                    ", docDueDate=" + docDueDate +
                    ", docDateCutoff=" + docDateCutoff +
                    ", balance=" + balance +
                    ", docTotal=" + docTotal +
                    ", docNum=" + docNum +
                    ", expiredDays=" + expiredDays +
                    '}';
        }
    }
}
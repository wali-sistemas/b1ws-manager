package co.manager.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
public class CupoDTO {
    private BigDecimal cupo;
    private Integer payDayAvg;
    private Date lastSaleDay;

    public CupoDTO() {
    }

    public CupoDTO(BigDecimal cupo, Integer payDayAvg, Date lastSaleDay) {
        this.cupo = cupo;
        this.payDayAvg = payDayAvg;
        this.lastSaleDay = lastSaleDay;
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

    @Override
    public String toString() {
        return "CupoDTO{" +
                "cupo=" + cupo +
                ", payDayAvg=" + payDayAvg +
                ", lastSaleDay=" + lastSaleDay +
                '}';
    }
}
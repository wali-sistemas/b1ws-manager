package co.manager.persistence.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jguisao
 */
@Entity
@Table(name = "[@PAGO_PASARELA_ENC]")
public class PagoPasarelaSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code")
    private String code;
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_idPago")
    private Integer uIdPago;
    @Basic(optional = false)
    @Column(name = "U_cardCode")
    private String uCardCode;
    @Basic(optional = false)
    @Column(name = "U_transferReference")
    private String uTransferReference;
    @Basic(optional = false)
    @Column(name = "U_cashSum")
    private BigDecimal uCashSum;
    @Basic(optional = false)
    @Column(name = "U_status")
    private String uStatus;
    @Basic(optional = false)
    @Column(name = "U_pasarela")
    private String uPasarela;
    @Basic(optional = false)
    @Column(name = "U_createDate")
    private Date uCreateDate;

    public PagoPasarelaSAP() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Integer getuIdPago() {
        return uIdPago;
    }

    public void setuIdPago(Integer uIdPago) {
        this.uIdPago = uIdPago;
    }

    public String getuCardCode() {
        return uCardCode;
    }

    public void setuCardCode(String uCardCode) {
        this.uCardCode = uCardCode;
    }

    public String getuTransferReference() {
        return uTransferReference;
    }

    public void setuTransferReference(String uTransferReference) {
        this.uTransferReference = uTransferReference;
    }

    public BigDecimal getuCashSum() {
        return uCashSum;
    }

    public void setuCashSum(BigDecimal uCashSum) {
        this.uCashSum = uCashSum;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }

    public String getuPasarela() {
        return uPasarela;
    }

    public void setuPasarela(String uPasarela) {
        this.uPasarela = uPasarela;
    }

    public Date getuCreateDate() {
        return uCreateDate;
    }

    public void setuCreateDate(Date uCreateDate) {
        this.uCreateDate = uCreateDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoPasarelaSAP)) {
            return false;
        }
        PagoPasarelaSAP other = (PagoPasarelaSAP) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return "PagoPasarelaSAP{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", uIdPago='" + uIdPago + '\'' +
                ", uCardCode='" + uCardCode + '\'' +
                ", uTransferReference='" + uTransferReference + '\'' +
                ", uCashSum=" + uCashSum +
                ", uStatus='" + uStatus + '\'' +
                ", uPasarela='" + uPasarela + '\'' +
                ", uCreateDate=" + uCreateDate +
                '}';
    }
}
package co.manager.persistence.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jguisao
 */
@Entity
@Table(name = "[@PAGO_PASARELA_DET]")
public class DetallePagoPasarelaSAP implements Serializable {
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
    @Column(name = "U_docEntryFv")
    private String uDocEntryFv;
    @Basic(optional = false)
    @Column(name = "U_lineNumFv")
    private Integer uLineNumFv;
    @Basic(optional = false)
    @Column(name = "U_sumAppliedFv")
    private BigDecimal uSumAppliedFv;

    public DetallePagoPasarelaSAP() {
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

    public String getuDocEntryFv() {
        return uDocEntryFv;
    }

    public void setuDocEntryFv(String uDocEntryFv) {
        this.uDocEntryFv = uDocEntryFv;
    }

    public Integer getuLineNumFv() {
        return uLineNumFv;
    }

    public void setuLineNumFv(Integer uLineNumFv) {
        this.uLineNumFv = uLineNumFv;
    }

    public BigDecimal getuSumAppliedFv() {
        return uSumAppliedFv;
    }

    public void setuSumAppliedFv(BigDecimal uSumAppliedFv) {
        this.uSumAppliedFv = uSumAppliedFv;
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
        if (!(object instanceof DetallePagoPasarelaSAP)) {
            return false;
        }
        DetallePagoPasarelaSAP other = (DetallePagoPasarelaSAP) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return "DetallePagoPasarelaSAP{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", uIdPago=" + uIdPago +
                ", uDocEntryFv='" + uDocEntryFv + '\'' +
                ", uLineNumFv=" + uLineNumFv +
                ", uSumAppliedFv=" + uSumAppliedFv +
                '}';
    }
}
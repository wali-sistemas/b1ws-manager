package co.manager.persistence.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jguisao
 */
@Entity
@Table(name = "@HIST_COORDENADAS")
public class HistoryGeoLocationSAP implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Code")
    private String code;
    @NotNull
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_SlpCode")
    private String uslpCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_Fecha")
    private String udocDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_Hora")
    private String udocTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_Longitud")
    private String ulongitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_Latitud")
    private String ulatitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "U_Tipo")
    private String udocType;

    public HistoryGeoLocationSAP() {
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

    public String getUslpCode() {
        return uslpCode;
    }

    public void setUslpCode(String uslpCode) {
        this.uslpCode = uslpCode;
    }

    public String getUdocDate() {
        return udocDate;
    }

    public void setUdocDate(String udocDate) {
        this.udocDate = udocDate;
    }

    public String getUdocTime() {
        return udocTime;
    }

    public void setUdocTime(String udocTime) {
        this.udocTime = udocTime;
    }

    public String getUlongitud() {
        return ulongitud;
    }

    public void setUlongitud(String ulongitud) {
        this.ulongitud = ulongitud;
    }

    public String getUlatitud() {
        return ulatitud;
    }

    public void setUlatitud(String ulatitud) {
        this.ulatitud = ulatitud;
    }

    public String getUdocType() {
        return udocType;
    }

    public void setUdocType(String udocType) {
        this.udocType = udocType;
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
        if (!(object instanceof HistoryGeoLocationSAP)) {
            return false;
        }
        HistoryGeoLocationSAP other = (HistoryGeoLocationSAP) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return "HistoryGeoLocationSAP{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", uslpCode='" + uslpCode + '\'' +
                ", udocDate='" + udocDate + '\'' +
                ", udocTime='" + udocTime + '\'' +
                ", ulongitud='" + ulongitud + '\'' +
                ", ulatitud='" + ulatitud + '\'' +
                ", udocType='" + udocType + '\'' +
                '}';
    }
}
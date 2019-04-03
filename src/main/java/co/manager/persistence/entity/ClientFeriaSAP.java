package co.manager.persistence.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jguisao
 */
@Entity
@Table(name = "[@CLIENTES_FERIA]")
public class ClientFeriaSAP implements Serializable {
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
    @Column(name = "U_documento")
    private String uDocumento;
    @Basic(optional = false)
    @Column(name = "U_nombreCompleto")
    private String uNombreCompleto;
    @Basic(optional = false)
    @Column(name = "U_telefono")
    private String uTelefono;
    @Column(name = "U_correo")
    private String uCorreo;
    @Column(name = "U_almacen")
    private String uAlmacen;
    @Column(name = "U_interes")
    private String uInteres;
    @Column(name = "U_regional")
    private String uRegional;
    @Column(name = "U_fecha")
    private Date uFecha;

    public ClientFeriaSAP() {
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

    public String getuDocumento() {
        return uDocumento;
    }

    public void setuDocumento(String uDocumento) {
        this.uDocumento = uDocumento;
    }

    public String getuNombreCompleto() {
        return uNombreCompleto;
    }

    public void setuNombreCompleto(String uNombreCompleto) {
        this.uNombreCompleto = uNombreCompleto;
    }

    public String getuTelefono() {
        return uTelefono;
    }

    public void setuTelefono(String uTelefono) {
        this.uTelefono = uTelefono;
    }

    public String getuCorreo() {
        return uCorreo;
    }

    public void setuCorreo(String uCorreo) {
        this.uCorreo = uCorreo;
    }

    public String getuAlmacen() {
        return uAlmacen;
    }

    public void setuAlmacen(String uAlmacen) {
        this.uAlmacen = uAlmacen;
    }

    public String getuInteres() {
        return uInteres;
    }

    public void setuInteres(String uInteres) {
        this.uInteres = uInteres;
    }

    public String getuRegional() {
        return uRegional;
    }

    public void setuRegional(String uRegional) {
        this.uRegional = uRegional;
    }

    public Date getuFecha() {
        return uFecha;
    }

    public void setuFecha(Date uFecha) {
        this.uFecha = uFecha;
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
        if (!(object instanceof ClientFeriaSAP)) {
            return false;
        }
        ClientFeriaSAP other = (ClientFeriaSAP) object;
        return !((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code)));
    }

    @Override
    public String toString() {
        return "ClientFeriaSAP{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", uDocumento='" + uDocumento + '\'' +
                ", uNombreCompleto='" + uNombreCompleto + '\'' +
                ", uTelefono='" + uTelefono + '\'' +
                ", uCorreo='" + uCorreo + '\'' +
                ", uAlmacen='" + uAlmacen + '\'' +
                ", uInteres='" + uInteres + '\'' +
                ", uRegional='" + uRegional + '\'' +
                ", uFecha=" + uFecha +
                '}';
    }
}
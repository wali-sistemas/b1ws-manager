package co.manager.dto;

/**
 * @author jguisao
 */
public class ClientFeriaDTO {
    private String documento;
    private String nombreCompleto;
    private String telefono;
    private String correo;
    private String almacen;
    private String interes;
    private String regional;
    private String ciudad;
    private String companyName;

    public ClientFeriaDTO() {
    }

    public ClientFeriaDTO(String documento, String nombreCompleto, String telefono, String correo, String almacen, String interes, String regional, String ciudad, String companyName) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correo = correo;
        this.almacen = almacen;
        this.interes = interes;
        this.regional = regional;
        this.ciudad = ciudad;
        this.companyName = companyName;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "ClientFeriaDTO{" +
                "documento='" + documento + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", almacen='" + almacen + '\'' +
                ", interes='" + interes + '\'' +
                ", regional='" + regional + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
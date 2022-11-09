package co.manager.dto;

import java.util.Date;

/**
 * @author jguisao
 */
public class VendedorMostradorDTO {
    private String documento;
    private String nombres;
    private String apellidos;
    private String correo;
    private String celular;
    private String cardCode;
    private String departamento;
    private String ciudad;
    private String direccion;
    private String codConcepto;
    private Date fechaNacimiento;
    private char aceptoTermino;
    private char aceptoTratamientoDatos;

    public VendedorMostradorDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getAceptoTermino() {
        return aceptoTermino;
    }

    public void setAceptoTermino(char aceptoTermino) {
        this.aceptoTermino = aceptoTermino;
    }

    public char getAceptoTratamientoDatos() {
        return aceptoTratamientoDatos;
    }

    public void setAceptoTratamientoDatos(char aceptoTratamientoDatos) {
        this.aceptoTratamientoDatos = aceptoTratamientoDatos;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(String codConcepto) {
        this.codConcepto = codConcepto;
    }

    @Override
    public String toString() {
        return "VendedorMostradorDTO{" +
                "documento='" + documento + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", celular='" + celular + '\'' +
                ", cardCode='" + cardCode + '\'' +
                ", departamento='" + departamento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", codConcepto='" + codConcepto + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", aceptoTermino=" + aceptoTermino +
                ", aceptoTratamientoDatos=" + aceptoTratamientoDatos +
                '}';
    }
}
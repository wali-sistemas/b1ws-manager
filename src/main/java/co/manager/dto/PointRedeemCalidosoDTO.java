package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointRedeemCalidosoDTO {
    private String documento;
    private String fecha;
    private Integer puntos;
    private String concepto;
    private String comprobante;
    private String descripcion;
    private String empresa;

    public PointRedeemCalidosoDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "PointRedeemCalidosoDTO{" +
                "documento='" + documento + '\'' +
                ", fecha='" + fecha + '\'' +
                ", puntos=" + puntos +
                ", concepto='" + concepto + '\'' +
                ", comprobante='" + comprobante + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
package co.manager.dto;

import java.util.Date;

/**
 * @author jguisao
 */
public class PointRedeemCalidosoDTO {
    private String documento;
    private Date fecha;
    private Integer puntos;
    private String concepto;
    private String comprobante;

    public PointRedeemCalidosoDTO() {
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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

    @Override
    public String toString() {
        return "PointRedeemCalidosoDTO{" +
                "documento='" + documento + '\'' +
                ", fecha=" + fecha +
                ", puntos=" + puntos +
                ", concepto='" + concepto + '\'' +
                ", comprobante='" + comprobante + '\'' +
                '}';
    }
}
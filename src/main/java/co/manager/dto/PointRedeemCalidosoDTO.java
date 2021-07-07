package co.manager.dto;

/**
 * @author jguisao
 */
public class PointRedeemCalidosoDTO {
    private String documento;
    private String fecha;
    private Integer puntos;
    private String concepto;
    private String comprobante;
    private String descripcion;

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

    @Override
    public String toString() {
        return "PointRedeemCalidosoDTO{" +
                "documento='" + documento + '\'' +
                ", fecha=" + fecha +
                ", puntos=" + puntos +
                ", concepto='" + concepto + '\'' +
                ", comprobante='" + comprobante + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
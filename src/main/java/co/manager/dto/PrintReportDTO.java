package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PrintReportDTO {
    private String id;
    private int copias;
    private String documento;
    private String companyName;
    private String origen;
    private String filtro;
    private String filtroSec;
    private boolean imprimir;

    public PrintReportDTO() {
    }

    public PrintReportDTO(String id, int copias, String documento, String companyName, String origen, String filtro, String filtroSec, boolean imprimir) {
        this.id = id;
        this.copias = copias;
        this.documento = documento;
        this.companyName = companyName;
        this.origen = origen;
        this.filtro = filtro;
        this.filtroSec = filtroSec;
        this.imprimir = imprimir;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public boolean isImprimir() {
        return imprimir;
    }

    public void setImprimir(boolean imprimir) {
        this.imprimir = imprimir;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public String getFiltroSec() {
        return filtroSec;
    }

    public void setFiltroSec(String filtroSec) {
        this.filtroSec = filtroSec;
    }

    @Override
    public String toString() {
        return "PrintReportDTO{" +
                "id=" + id +
                ", copias=" + copias +
                ", documento='" + documento + '\'' +
                ", companyName='" + companyName + '\'' +
                ", origen='" + origen + '\'' +
                ", filtro='" + filtro + '\'' +
                ", filtroSec='" + filtroSec + '\'' +
                ", imprimir=" + imprimir +
                '}';
    }
}
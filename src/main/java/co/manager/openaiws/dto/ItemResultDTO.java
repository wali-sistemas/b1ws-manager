package co.manager.openaiws.dto;

import java.math.BigDecimal;

/**
 * @author jguisao
 */
public class ItemResultDTO {
    private String articulo;
    private String description;
    private Integer stockMedellin;
    private Integer stockCartagena;
    private Integer stockCali;
    private Integer stockBogota;
    private BigDecimal precio;
    private String foto;

    public ItemResultDTO() {
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStockMedellin() {
        return stockMedellin;
    }

    public void setStockMedellin(Integer stockMedellin) {
        this.stockMedellin = stockMedellin;
    }

    public Integer getStockCartagena() {
        return stockCartagena;
    }

    public void setStockCartagena(Integer stockCartagena) {
        this.stockCartagena = stockCartagena;
    }

    public Integer getStockCali() {
        return stockCali;
    }

    public void setStockCali(Integer stockCali) {
        this.stockCali = stockCali;
    }

    public Integer getStockBogota() {
        return stockBogota;
    }

    public void setStockBogota(Integer stockBogota) {
        this.stockBogota = stockBogota;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "ItemResultDTO{" +
                "articulo='" + articulo + '\'' +
                ", description='" + description + '\'' +
                ", stockMedellin=" + stockMedellin +
                ", stockCartagena=" + stockCartagena +
                ", stockCali=" + stockCali +
                ", stockBogota=" + stockBogota +
                ", precio=" + precio +
                ", foto='" + foto + '\'' +
                '}';
    }
}

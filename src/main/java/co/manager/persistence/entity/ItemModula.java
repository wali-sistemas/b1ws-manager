package co.manager.persistence.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "itemModula")
public class ItemModula {
    @Id
    @Basic(optional = false)
    @Column(name = "itemCode")
    private String itemCode;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;
    @Basic(optional = false)
    @Column(name = "stockMin")
    private Integer stockMin;
    @Basic(optional = false)
    @Column(name = "stockMax")
    private Integer stockMax;
    @Basic(optional = false)
    @Column(name = "active")
    private String active;
    @Basic(optional = false)
    @Column(name = "ancho")
    private Integer ancho;
    @Basic(optional = false)
    @Column(name = "alto")
    private Integer alto;
    @Basic(optional = false)
    @Column(name = "largo")
    private Integer largo;
    @Basic(optional = false)
    @Column(name = "peso")
    private Integer peso;

    public ItemModula() {
    }

    public ItemModula(String itemCode, String itemName, Integer stockMin, Integer stockMax, String active, Integer ancho, Integer alto, Integer largo, Integer peso) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.stockMin = stockMin;
        this.stockMax = stockMax;
        this.active = active;
        this.ancho = ancho;
        this.alto = alto;
        this.largo = largo;
        this.peso = peso;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Integer getAncho() {
        return ancho;
    }

    public void setAncho(Integer ancho) {
        this.ancho = ancho;
    }

    public Integer getAlto() {
        return alto;
    }

    public void setAlto(Integer alto) {
        this.alto = alto;
    }

    public Integer getLargo() {
        return largo;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.itemCode);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemModula other = (ItemModula) obj;
        if (!Objects.equals(this.itemCode, other.itemCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemModula{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", stockMin=" + stockMin +
                ", stockMax=" + stockMax +
                ", active='" + active + '\'' +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", largo=" + largo +
                ", peso=" + peso +
                '}';
    }
}
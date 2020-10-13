package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "ticket_ti_notes")
public class TicketTIType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idticket_ti_type")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type_ticket")
    private String typeTicket;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public TicketTIType() {
    }

    public TicketTIType(Integer id, String typeTicket, String status) {
        this.id = id;
        this.typeTicket = typeTicket;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final TicketTIType other = (TicketTIType) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TicketTIType{" +
                "id=" + id +
                ", typeTicket='" + typeTicket + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
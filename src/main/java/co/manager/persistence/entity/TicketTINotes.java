package co.manager.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author jguisao
 */
@Entity
@Table(name = "ticket_ti_notes")
public class TicketTINotes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idticket_ti_notes")
    private Long id;
    @Basic(optional = false)
    @Column(name = "idticket")
    private Long idTicket;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "emp_id")
    private String empId;
    @Basic(optional = false)
    @Column(name = "note")
    private String note;

    public TicketTINotes() {
    }

    public TicketTINotes(Long id, Long idTicket, Date date, String empId, String note) {
        this.id = id;
        this.idTicket = idTicket;
        this.date = date;
        this.empId = empId;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
        final TicketTINotes other = (TicketTINotes) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TicketTINotes{" +
                "id=" + id +
                ", idTicket=" + idTicket +
                ", date=" + date +
                ", empId='" + empId + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
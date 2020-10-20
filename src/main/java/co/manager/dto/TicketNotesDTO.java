package co.manager.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author jguisao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TicketNotesDTO {
    public Integer idTicket;
    public String dateNote;
    public String empNote;
    public String note;

    public TicketNotesDTO() {
    }

    public TicketNotesDTO(Integer idTicket, String dateNote, String empNote, String note) {
        this.idTicket = idTicket;
        this.dateNote = dateNote;
        this.empNote = empNote;
        this.note = note;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getDateNote() {
        return dateNote;
    }

    public void setDateNote(String dateNote) {
        this.dateNote = dateNote;
    }

    public String getEmpNote() {
        return empNote;
    }

    public void setEmpNote(String empNote) {
        this.empNote = empNote;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "TicketNotesDTO{" +
                "idTicket=" + idTicket +
                ", dateNote=" + dateNote +
                ", empNote='" + empNote + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
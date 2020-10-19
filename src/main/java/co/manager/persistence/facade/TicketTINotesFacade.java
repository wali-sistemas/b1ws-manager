package co.manager.persistence.facade;

import co.manager.persistence.entity.TicketTINotes;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class TicketTINotesFacade {

    private static final Logger CONSOLE = Logger.getLogger(TicketTINotes.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(TicketTINotes ticketTiNotes, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(ticketTiNotes);
    }

    public List<Object[]> listNotesTicket(Integer idTicket) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("select n.idticket_ti_notes,n.idticket,cast(n.date as varchar(10))as createDate,n.emp_id,note ");
        sb.append("from ticket_ti_notes n where n.idTicket = ");
        sb.append(idTicket);
        sb.append(" order by n.idticket_ti_notes DESC, n.date ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando las notas para el ticket #" + idTicket.toString(), e);
        }
        return new ArrayList<>();
    }
}
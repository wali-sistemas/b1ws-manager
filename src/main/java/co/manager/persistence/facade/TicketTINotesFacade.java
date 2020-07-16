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
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MYSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(TicketTINotes ticketTiNotes, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE).persist(ticketTiNotes);
    }

    public List<Object[]> listNotesTicket(Integer idTicket) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select n.* from ticket_ti_notes n where n.idTicket = ");
        sb.append(idTicket);
        sb.append(" order by n.date DESC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando las notas para el ticket #", idTicket.toString());
        }
        return new ArrayList<>();
    }
}

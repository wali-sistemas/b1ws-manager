package co.manager.persistence.facade;

import co.manager.persistence.entity.TicketTI;
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
public class TicketTIFacade {

    private static final Logger CONSOLE = Logger.getLogger(TicketTI.class.getSimpleName());
    private static final String DB_TYPE = Constants.DATABASE_TYPE_MYSQL;

    @EJB
    private PersistenceConf persistenceConf;

    public TicketTIFacade() {
    }

    public void create(TicketTI ticketTi, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE).persist(ticketTi);
    }

    public Long getIdTicket() {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("selet max(idticket) from ticket_ti");
        try {
            return (Long) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el último ticket creado.", e);
        }
        return 0l;
    }

    public List<Object[]> listTickets(String empId, boolean admUser) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select t.idticket, p.type_ticket, t.date, t.department_name, t.emp_id_add, t.emp_id_set, ");
        sb.append("      t.url_attached, t.priority, t.company_name, t.asunt ");
        sb.append("from  ticket_ti t ");
        sb.append("inner join ticket_ti_type p ON p.idticket_ti_type = t.idticket_ti_type ");

        if (!admUser) {
            sb.append("where t.emp_id_add = '");
            sb.append(empId);
            sb.append("'");
        }

        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los ticket.");
        }
        return new ArrayList<>();
    }
}
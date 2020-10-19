package co.manager.persistence.facade;

import co.manager.persistence.entity.TicketTIType;
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
public class TicketTITypeFacade {
    private static final Logger CONSOLE = Logger.getLogger(TicketTIType.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(TicketTIType ticketTiType, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(ticketTiType);
    }

    public List<Object[]> listTypeTickets() {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("select idticket_ti_type, type_ticket from ticket_ti_type where status = 'open' order by idticket_ti_type ASC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar los tipos de tickets.", e);
        }
        return new ArrayList<>();
    }
}
package co.manager.persistence.facade;

import co.manager.dto.TicketDTO;
import co.manager.persistence.entity.TicketTI;
import co.manager.persistence.entity.TicketTI_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class TicketTIFacade {

    private static final Logger CONSOLE = Logger.getLogger(TicketTI.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public TicketTIFacade() {
    }

    public void create(TicketTI ticketTi, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(ticketTi);
    }

    public TicketTI find(Integer idTicket, String companyName, boolean testing) {
        return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).find(TicketTI.class, idTicket);
    }

    public Long getIdTicket() {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("selet max(idticket) from ticket_ti");
        try {
            return (Long) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el ultimo ticket creado. ", e);
        }
        return 0l;
    }

    public TicketDTO getTicket(Integer idTicket, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("select department_name,emp_id_add,emp_id_set,priority,company_name,asunt,status ");
        sb.append("from ticket_ti where idticket=");
        sb.append(idTicket);
        try {
            Object[] obj = (Object[]) em.createNativeQuery(sb.toString()).getSingleResult();
            TicketDTO dto = new TicketDTO((String) obj[0], (String) obj[1], (String) obj[2], (String) obj[3], (String) obj[4], (String) obj[5], (String) obj[6]);
            return dto;
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando datos del ticker " + idTicket.toString(), e);
        }
        return null;
    }

    public List<Object[]> listTickets(String empId, boolean admUser) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(t.idticket as int)as idticket,cast(p.type_ticket as varchar(45))as type_ticket,cast(t.date as varchar(10))as createDate, ");
        sb.append(" cast(t.department_name as varchar(45))as department_name,cast(t.emp_id_add as varchar(45))as emp_id_add, cast(t.emp_id_set as varchar(45))as emp_id_set, ");
        sb.append(" cast(t.url_attached as varchar(100))as url_attached,cast(t.priority as varchar(10))as priority,cast(t.company_name as varchar(20))as company_name, ");
        sb.append(" cast(t.asunt as varchar(100))as asunt,cast(t.status as varchar(15))as status,cast(t.type as varchar(20))as type,cast(t.date_end as varchar(10))as dateEnd ");
        sb.append("from  ticket_ti t ");
        sb.append("inner join ticket_ti_type p ON p.idticket_ti_type = t.idticket_ti_type ");

        if (!admUser) {
            sb.append("where t.emp_id_add = '");
            sb.append(empId);
            sb.append("'");
        }
        sb.append(" order by t.idticket DESC;");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los ticket. ", e);
            return null;
        }
        return new ArrayList<>();
    }

    public boolean assignTicket(Integer idTicket, String idEmp, String priority, String status) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<TicketTI> cu = cb.createCriteriaUpdate(TicketTI.class);
        Root<TicketTI> root = cu.from(TicketTI.class);
        cu.set(root.get(TicketTI_.empIdSet), idEmp);
        cu.set(root.get(TicketTI_.priority), priority);
        cu.set(root.get(TicketTI_.status), status);
        cu.set(root.get(TicketTI_.modifyDate), new Date());
        cu.where(cb.equal(root.get(TicketTI_.id), idTicket));
        try {
            int rows = em.createQuery(cu).executeUpdate();
            if (rows == 1) {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error asignando el tickit TI #" + idTicket.toString(), e);
        }
        return false;
    }

    public boolean changeStatusTicket(Integer idTicket, String status) {
        EntityManager em = persistenceConf.chooseSchema("", false, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<TicketTI> cu = cb.createCriteriaUpdate(TicketTI.class);
        Root<TicketTI> root = cu.from(TicketTI.class);
        cu.set(root.get(TicketTI_.status), status);
        cu.set(root.get(TicketTI_.modifyDate), new Date());

        if (status.equals("CERRADO")) {
            cu.set(root.get(TicketTI_.dateEnd), new Date());
        }

        cu.where(cb.equal(root.get(TicketTI_.id), idTicket));
        try {
            int rows = em.createQuery(cu).executeUpdate();
            if (rows == 1) {
                return true;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error modificando estado al tickit TI #" + idTicket.toString(), e);
        }
        return false;
    }
}
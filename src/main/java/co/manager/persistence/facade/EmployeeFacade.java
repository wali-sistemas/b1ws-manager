package co.manager.persistence.facade;

import co.manager.persistence.entity.Employee;
import co.manager.persistence.entity.Employee_;
import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class EmployeeFacade {
    private static final Logger CONSOLE = Logger.getLogger(EmployeeFacade.class.getSimpleName());
    private static final String DB_TYPE_WALI = Constants.DATABASE_TYPE_WALI;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(Employee employee, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(employee);
    }

    public void remove(Employee employee, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).remove(employee);
    }

    public List<Object[]> listCustodyByEmplee(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.cardCode as varchar)as cardCode,cast(e.cardName as varchar)as cardName,cast(e.department as varchar)as depart, ");
        sb.append(" cast(e.company as varchar)as company,cast(e.ccosto as int)as ccEmpl, cast(e.status as varchar)as statusEmp,cast(c.idAsset as varchar)as id, ");
        sb.append(" cast(c.dateAssign as date)as dateAssign,cast(c.dateFinish as date)as dateFinish,cast(c.status as varchar)as statusDet, ");
        sb.append(" cast(c.userAssign as varchar)as userAssign,cast(c.userFinish as varchar)as userFinish,cast(a.type as varchar)as type, ");
        sb.append(" cast(a.brand as varchar)as brand,cast(a.reference as varchar)as referencia,cast(a.serial as varchar)as serial, ");
        sb.append(" cast(a.company as varchar)as companyPurchase,cast(a.datePurchase as date)as datePurchase,cast(a.ccosto as int)as ccAsset, ");
        sb.append(" cast(a.status as varchar)as statusAsset,cast(a.comment as varchar)as comment,cast(a.pictureAssetUrl as varchar(max))as pictAsset ");
        sb.append("from employee e ");
        sb.append("inner join custody_detail c on c.cardCode=e.cardCode ");
        sb.append("inner join asset_master_data a on a.idAsset=c.idAsset ");
        sb.append("where e.cardCode='");
        sb.append(cardCode);
        sb.append("' and e.status='Y'");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las custodias asignadas el empleado " + cardCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public Object[] findEmployee(String cardCode, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(cardCode as varchar(20))as cardCode,cast(cardName as varchar(100))as cardName,cast(department as varchar(100))as deparment, ");
        sb.append(" cast(company as varchar(20))as company,cast(ccosto as int)as ccentro,cast(status as varchar(1))as status ");
        sb.append("from employee ");
        sb.append("where cardCode='");
        sb.append(cardCode);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando los datos del empleado en " + companyName, e);
        }
        return null;
    }

    public List<Employee> listEmployeeActives(String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.where(cb.equal(root.get(Employee_.status), "Y"));
        try {
            return em.createQuery(cq).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los empleados activos en " + companyName);
        }
        return new ArrayList<>();
    }

    public boolean updateEmployee(Employee entity, String companyName, boolean testing) {
        EntityManager em = persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Employee> cu = cb.createCriteriaUpdate(Employee.class);
        Root<Employee> root = cu.from(Employee.class);
        cu.set(root.get(Employee_.cardName), entity.getCardName());
        cu.set(root.get(Employee_.department), entity.getDepartment());
        cu.set(root.get(Employee_.company), entity.getCompany());
        cu.set(root.get(Employee_.ccosto), entity.getCcosto());
        cu.set(root.get(Employee_.status), entity.getStatus());
        cu.where(cb.equal(root.get(Employee_.cardCode), entity.getCardCode()));
        try {
            int rows = em.createQuery(cu).executeUpdate();
            if (rows == 1) {
                return true;
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al actualizar los datos del empleado " + entity.getCardCode(), e);
        }
        return false;
    }
}
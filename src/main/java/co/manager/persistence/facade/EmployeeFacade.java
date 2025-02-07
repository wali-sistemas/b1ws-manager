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
    private static final String DB_TYPE_NOVAWEB = Constants.DATABASE_TYPE_NOVAWEB;

    @EJB
    private PersistenceConf persistenceConf;

    public void create(Employee employee, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).persist(employee);
    }

    public void remove(Employee employee, String companyName, boolean testing) {
        persistenceConf.chooseSchema(companyName, testing, DB_TYPE_WALI).remove(employee);
    }

    public List<Object[]> listCustodyByEmpleeOrAsset(String cardCode, String idAsset, String cardName, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from (");
        sb.append("select cast(isnull(e.cardCode,'811011909') as varchar)as cardCode,cast(isnull(e.cardName, 'Sin Asignar') as varchar)as cardName,cast(isnull(e.department,'SISTEMAS') as varchar)as depart, ");
        sb.append(" cast(isnull(e.company,'IGB') as varchar)as company,cast(e.ccosto as int)as ccEmpl, cast(e.status as varchar)as statusEmp,cast(a.idAsset as varchar)as id, ");
        sb.append(" cast(c.dateAssign as varchar)as dateAssign,cast(c.dateFinish as varchar)as dateFinish,cast(c.status as varchar)as statusDet, ");
        sb.append(" cast(c.userAssign as varchar)as userAssign,cast(c.userFinish as varchar)as userFinish,cast(a.type as varchar)as type, ");
        sb.append(" cast(a.brand as varchar)as brand,cast(a.reference as varchar)as referencia,cast(a.serial as varchar)as serial, ");
        sb.append(" cast(a.company as varchar)as companyPurchase,cast(a.datePurchase as varchar)as datePurchase,cast(a.ccosto as int)as ccAsset, ");
        sb.append(" cast(a.status as varchar)as statusAsset,cast(a.comment as varchar(max))as comment,cast(a.pictureAssetUrl as varchar(max))as pictAsset ");
        sb.append("from asset_master_data a ");
        sb.append("left join custody_detail c on c.idAsset=a.idAsset ");
        sb.append("left join employee e on e.cardCode=c.cardCode ");
        if (cardCode != null || idAsset != null) {
            sb.append("where (c.status='Y' or c.status is null) and (c.cardCode='");
            sb.append(cardCode);
            sb.append("' or a.idAsset='");
            sb.append(idAsset);
            sb.append("'))as t");
        } else {
            sb.append(")as t where t.statusDet is null and t.cardName='");
            sb.append(cardName);
            sb.append("'");
        }
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
        cq.where(cb.and(cb.equal(root.get(Employee_.status), "Y")), cb.notEqual(root.get(Employee_.cardCode), "811011909"));
        cq.orderBy(cb.asc(root.get(Employee_.cardName)));
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

    public boolean validateEmployeeExistenceNovaWeb(String empId, String birthdate, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(cast(cod_emp as varchar(12)))as nro ");
        sb.append("from rhh_emplea ");
        sb.append("where cod_emp='");
        sb.append(empId);
        if (!birthdate.equals("null")) {
            sb.append("' and cast(fec_nac as date)='");
            sb.append(birthdate);
        }
        sb.append("'");
        try {
            int result = (Integer) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).createNativeQuery(sb.toString()).getSingleResult();
            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error validando la existencia del empleado [" + empId + "]", e);
        }
        return false;
    }

    /*public Object[] findEmployeeNovaWeb(String empId, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select top 1 cast(rtrim(ltrim(e.cod_emp)) as varchar)as cedula,cast(e.nom_emp as varchar)as nombre,cast(e.ap1_emp as varchar)as apell1, ");
        sb.append(" cast(e.ap2_emp as varchar)as apell2,cast(e.fec_ing as date)as ingreso,cast(c.nom_car as varchar)as nomCar,cast(e_mail_alt as varchar)as jefe ");
        sb.append("from rhh_emplea e ");
        sb.append("inner join rhh_cargos c ON e.cod_car=c.cod_car ");
        sb.append("where cod_emp='");
        sb.append(empId);
        sb.append("'");
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_NOVAWEB).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al encontrar el empleado " + empId + " en novaweb de la empresa " + companyName, e);
        }
        return null;
    }*/
}
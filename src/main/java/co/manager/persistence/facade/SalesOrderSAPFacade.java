package co.manager.persistence.facade;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class SalesOrderSAPFacade {

    private static final Logger CONSOLE = Logger.getLogger(SalesOrderSAPFacade.class.getSimpleName());
    private static final String DB_TYPE = "mssql";

    @EJB
    private PersistenceConf persistenceConf;

    public SalesOrderSAPFacade() {
    }

    public List<String> getStatusOrder(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.Name as varchar(50)) as Estados ");
        sb.append("from   [@DESPACHADORES] e ");
        sb.append("where  RTRIM(LTRIM(e.Name)) NOT IN ('.',',') and RTRIM(LTRIM(e.Code)) like '%[a-zA-Z]%' ");
        sb.append("order  by Estados asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar los estado disponibles para " + companyName, e);
        }
        return null;
    }

    public List<Object[]> findOrdersStopped(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.DocNum as int)as docNum, cast(o.DocDate as date)as docDate, cast(o.cardCode as varchar(20))as cardCode, ");
        sb.append("       cast(o.CardName as varchar(50))as cardName, cast(o.U_SEPARADOR as varchar (50))as status, cast(o.DocTotal as numeric(18,0))as docTotal, ");
        sb.append("       cast((select top 1 whsCode from RDR1 d where d.DocEntry = o.DocEntry)as varchar(10))as whsCode, cast(o.Comments as varchar(100))as comments ");
        sb.append("from   ORDR o ");
        sb.append("where  YEAR(o.DocDate) > YEAR(GETDATE())-1 and MONTH(o.DocDate) > MONTH(GETDATE())-1 and o.DocStatus = 'O' and ");
        sb.append("       o.U_SEPARADOR NOT IN ('APROBADO','PREPAGO','') and o.SlpCode =");
        sb.append(slpCode);
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes detenidas al vendedor [" + slpCode + "] de " + companyName, e);
        }
        return null;
    }

    public Integer getDocNumOrder(Long docEntry, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(DocNum as int)as DocNum from ORDR where DocEntry = ");
        sb.append(docEntry);
        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el nro de documento de la orden [" + docEntry + "] en [" + companyName + ']', e);
        }
        return null;
    }
}
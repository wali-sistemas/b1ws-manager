package co.manager.persistence.facade;

import co.manager.persistence.entity.SalesOrderSAP;
import co.manager.persistence.entity.SalesOrderSAP_;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    public List<Object[]> findDetailOrdersStopped(String slpCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.DocNum as int)as docNum, cast(o.cardCode as varchar(20))as cardCode, cast(s.LicTradNum as varchar(20))as nit, ");
        sb.append("       cast(o.CardName as varchar(50))as cardName, cast(o.DocDueDate as date)as docDueDate, cast(o.DocDate as date)as docDate, ");
        sb.append("       cast(o.DocTotal as numeric(18,0))as docTotal, cast(o.SlpCode as varchar(50))as slpCode, cast(a.SlpName as varchar(50))as slpName, ");
        sb.append("       cast(o.U_SEPARADOR as varchar(20))as status, cast(DATENAME(MM, o.DocDate)as varchar(20))as mes, ");
        sb.append("       cast(d.itemCode as varchar(20))as itemCode, cast(d.Dscription as varchar(50))as dscription, cast(d.Quantity as int)as quantity, ");
        sb.append("       cast(d.DelivrdQty as int)as delivrdQty, cast(d.Price as numeric(18,0))as priceUnit ");
        sb.append("from   ORDR o ");
        sb.append("inner  join RDR1 d ON d.DocEntry = o.DocEntry ");
        sb.append("inner  join OSLP a ON a.SlpCode = o.SlpCode ");
        sb.append("inner  join OCRD s ON s.CardCode = o.CardCode ");
        sb.append("where  YEAR(o.DocDate) > YEAR(GETDATE())-1 and MONTH(o.DocDate) > MONTH(GETDATE())-1 and o.DocStatus = 'O' and ");
        sb.append("       o.U_SEPARADOR NOT IN ('APROBADO','PREPAGO','') and o.SlpCode =");
        sb.append(slpCode);
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el detalle de las ordenes detenidas para " + companyName, e);
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

    public Integer getDocNumOrderByNumAtCard(String numAtCard, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(DocNum as int)as DocNum from ORDR where numAtCard = '");
        sb.append(numAtCard);
        sb.append("'");
        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el nro de documento de la orden por el idPedBox [" + numAtCard + "] en [" + companyName + ']', e);
        }
        return 0;
    }

    public List<Object[]> listOrdersHistoryByCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.DocNum as int)as DocNum, cast(o.DocDate as date)as DocDate, cast(o.DocTotal as numeric(18,2))as DocTotal ");
        sb.append("from  ORDR o ");
        sb.append("where cast(o.DocDate as date) between cast(DATEADD(MM,-3,GETDATE())as date) and cast(GETDATE() as date) and o.CardCode = '");
        sb.append(cardCode);
        sb.append("' order by o.DocDate DESC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historico de ordenes del cliente " + cardCode, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listDetailOrder(Integer docNum, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(d.LineNum as int)as LineNum, cast(d.ItemCode as varchar(20))as ItemCode, cast(d.Dscription as varchar(100))as ItemName, ");
        sb.append("      cast(d.Quantity as int)as Qty, cast(d.PackQty as int)as QtyPack, cast(d.Price as numeric(18,2))as PriceUnit, ");
        sb.append("      cast(i.Rate as int)as Iva, cast(d.DiscPrcnt as numeric(18,2))as DiscPrcnt ");
        sb.append("from  RDR1 d ");
        sb.append("inner join OSTC i on i.Code = d.TaxCode ");
        sb.append("where d.DocEntry = (select o.DocEntry from ORDR o where o.DocNum =");
        sb.append(docNum);
        sb.append(") order by d.LineNum asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle de la orden " + docNum.toString() + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listOrdersForValidateTransport(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.DocNum as int)as DocNum, cast(m.U_COD_TRA as varchar(2))as U_COD_TRA ");
        sb.append("from  ORDR o ");
        sb.append("inner join RDR12 d on o.DocEntry=d.DocEntry ");
        sb.append("inner join [@TRANSP] t on o.U_TRANSP=t.Code ");
        sb.append("inner join [@TRANSP_TAR] m on m.code=d.BlockS ");
        sb.append("where o.DocStatus='O' and t.code<>m.U_COD_TRA and o.Pick='N'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la validacion de la transportadora. ", e);
        }
        return new ArrayList<>();
    }

    public void updateTransport(Integer docNum, String trasnport, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE);
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<SalesOrderSAP> cu = cb.createCriteriaUpdate(SalesOrderSAP.class);
        Root<SalesOrderSAP> root = cu.from(SalesOrderSAP.class);

        cu.set(root.get(SalesOrderSAP_.uTransp), trasnport);
        cu.where(cb.equal(root.get(SalesOrderSAP_.docNum), docNum));
        try {
            em.createQuery(cu).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando la transportadora en la orden " + docNum.toString(), e);
        }
    }
}
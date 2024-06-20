package co.manager.persistence.facade;

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
public class SalesOrderSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(SalesOrderSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public SalesOrderSAPFacade() {
    }

    public List<String> getStatusOrder(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(e.\"Name\" as varchar(50)) as Estados ");
        sb.append("from   \"@DESPACHADORES\" e ");
        sb.append("where  RTRIM(LTRIM(e.\"Name\")) NOT IN ('.',',') and RTRIM(LTRIM(e.\"Code\")) LIKE_REGEXPR '[a-z]|[A-Z]' ");
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
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as int)as docNum, cast(o.\"DocDate\" as date)as docDate, cast(o.\"CardCode\" as varchar(20))as cardCode, ");
        sb.append("       cast(o.\"CardName\" as varchar(50))as cardName, cast(o.\"U_SEPARADOR\" as varchar (50))as status, cast(o.\"DocTotal\" as numeric(18,0))as docTotal, ");
        sb.append("       cast((select max(\"WhsCode\") from RDR1 d where d.\"DocEntry\" = o.\"DocEntry\")as varchar(10))as whsCode, cast(o.\"Comments\" as varchar(100))as comments ");
        sb.append("from   ORDR o ");
        sb.append("where  YEAR(o.\"DocDate\") > YEAR(current_date)-1 and MONTH(o.\"DocDate\") > MONTH(current_date)-1 and o.\"DocStatus\" = 'O' and ");
        sb.append("       o.\"U_SEPARADOR\" NOT IN ('APROBADO','PREPAGO','') and o.\"SlpCode\" =");
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
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as int)as docNum, cast(o.\"CardCode\" as varchar(20))as cardCode, cast(s.\"LicTradNum\" as varchar(20))as nit, ");
        sb.append("       cast(o.\"CardName\" as varchar(50))as cardName, cast(o.\"DocDueDate\" as date)as docDueDate, cast(o.\"DocDate\" as date)as docDate, ");
        sb.append("       cast(o.\"DocTotal\" as numeric(18,0))as docTotal, cast(o.\"SlpCode\" as varchar(50))as slpCode, cast(a.\"SlpName\" as varchar(50))as slpName, ");
        sb.append("       cast(o.\"U_SEPARADOR\" as varchar(20))as status, cast(MONTHNAME(o.\"DocDate\")as varchar(20))as mes, ");
        sb.append("       cast(d.\"ItemCode\" as varchar(20))as itemCode, cast(d.\"Dscription\" as varchar(50))as dscription, cast(d.\"Quantity\" as int)as quantity, ");
        sb.append("       cast(d.\"DelivrdQty\" as int)as delivrdQty, cast(d.\"Price\" as numeric(18,0))as priceUnit ");
        sb.append("from   ORDR o ");
        sb.append("inner  join RDR1 d ON d.\"DocEntry\" = o.\"DocEntry\" ");
        sb.append("inner  join OSLP a ON a.\"SlpCode\" = o.\"SlpCode\" ");
        sb.append("inner  join OCRD s ON s.\"CardCode\" = o.\"CardCode\" ");
        sb.append("where  YEAR(o.\"DocDate\") > YEAR(current_date)-1 and MONTH(o.\"DocDate\") > MONTH(current_date)-1 and o.\"DocStatus\" = 'O' and ");
        sb.append("       o.\"U_SEPARADOR\" NOT IN ('APROBADO','PREPAGO','') and o.\"SlpCode\" =");
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
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"DocNum\"as int)as DocNum from ORDR where \"DocEntry\" = ");
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
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"DocNum\" as int)as DocNum from ORDR where \"NumAtCard\" like '");
        sb.append(numAtCard);
        sb.append("%' limit 1");
        try {
            return (Integer) em.createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando el nro de documento de la orden por el idPedBox [" + numAtCard + "] en [" + companyName + ']', e);
        }
        return 0;
    }

    public List<Object[]> listOrdersHistoryByCustomer(String cardCode, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as int)as DocNum, cast(o.\"DocDate\" as date)as DocDate, cast(o.\"DocTotal\" as numeric(18,2))as DocTotal ");
        sb.append("from ORDR o ");
        sb.append("where o.\"DocDate\" between ADD_MONTHS(TO_DATE(current_date,'YYYY-MM-DD'),-3) and current_date and o.\"CardCode\" = '");
        sb.append(cardCode);
        sb.append("' order by o.\"DocDate\" DESC");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el historico de ordenes del cliente " + cardCode, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listOrdersHistoryWithDetailByCustomer(String cardCode, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocDate\" as date)as DocDate,cast(o.\"DocNum\" as varchar)as DocNum,cast(d.\"WhsCode\" as varchar)as WhsCode, ");
        sb.append(" cast(d.\"Quantity\" as int)as Qty,cast(o.\"DiscPrcnt\" as int)as desc1,cast(d.\"DiscPrcnt\" as int)as desc2,cast(d.\"Dscription\" as varchar)as itemName, ");
        sb.append(" cast(i.\"Rate\" as int)as iva,cast(d.\"Price\" as numeric(18,2))as Price,cast(d.\"ItemCode\" as varchar)as ItemCode,cast(d.\"LineNum\" as int)as seq, ");
        sb.append(" cast((d.\"Quantity\"*d.\"Price\")as numeric(18,2))as SubTotal,cast((select sum(d.\"LineTotal\"-(d.\"LineTotal\"*(e.\"DiscPrcnt\")/100))+e.\"VatSum\" from ORDR e ");
        sb.append(" inner join RDR1 d on d.\"DocEntry\"=e.\"DocEntry\" where e.\"DocNum\"=o.\"DocNum\" group by e.\"VatSum\")as numeric(18,2))as Total ");
        sb.append("from ORDR o ");
        sb.append("inner join RDR1 d on d.\"DocEntry\"=o.\"DocEntry\" ");
        sb.append("inner join OSTC i on i.\"Code\"=d.\"TaxCode\" ");
        sb.append("where o.\"DocDate\" between ADD_MONTHS(TO_DATE(current_date,'YYYY-MM-DD'),-3) and current_date and o.\"CardCode\"='");
        sb.append(cardCode);
        sb.append("' order by cast(o.\"DocDate\" as date) desc ");
        try {
            return persistenceConf.chooseSchema(companyName,pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al listar el historico de ordenes con detalle para el cliente " + cardCode + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listDetailOrder(Integer docNum, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(d.\"LineNum\" as int)as LineNum, cast(d.\"ItemCode\" as varchar(20))as ItemCode, cast(d.\"Dscription\" as varchar(100))as ItemName, ");
        sb.append("      cast(d.\"Quantity\" as int)as Qty, cast(d.\"PackQty\" as int)as QtyPack, cast(d.\"Price\" as numeric(18,2))as PriceUnit, ");
        sb.append("      cast(i.\"Rate\" as int)as Iva, cast(d.\"DiscPrcnt\" as numeric(18,2))as DiscPrcnt ");
        sb.append("from  RDR1 d ");
        sb.append("inner join OSTC i on i.\"Code\" = d.\"TaxCode\" ");
        sb.append("where d.\"DocEntry\" = (select o.\"DocEntry\" from ORDR o where o.\"DocNum\" =");
        sb.append(docNum);
        sb.append(") order by d.\"LineNum\" asc");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el detalle de la orden " + docNum.toString() + " en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listOrdersForValidateTransport(String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as int)as DocNum, cast(m.\"U_COD_TRA\" as varchar(2))as U_COD_TRA ");
        sb.append("from  ORDR o ");
        sb.append("inner join RDR12 d on o.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("inner join \"@TRANSP\" t on o.\"U_TRANSP\"=t.\"Code\" ");
        sb.append("inner join \"@TRANSP_TAR\" m on m.\"Code\"=d.\"BlockS\" ");
        sb.append("where o.\"DocStatus\"='O' and t.\"Code\"<>m.\"U_COD_TRA\" and o.\"Pick\"='N'");
        try {
            return em.createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error consultando la validacion de la transportadora. ", e);
        }
        return new ArrayList<>();
    }

    public void updateTransport(Integer docNum, String trasnport, String companyName, boolean pruebas) {
        EntityManager em = persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA);
        StringBuilder sb = new StringBuilder();
        sb.append("update ORDR set \"U_TRANSP\"=");
        sb.append(trasnport);
        sb.append(" where \"DocNum\"=");
        sb.append(docNum);
        try {
            em.createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando la transportadora en la orden " + docNum.toString(), e);
        }
    }

    public List<Object[]> listOrdersApprovedForModula(String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"DocNum\" as varchar(20))as DocNun, cast(d.\"ItemCode\" as varchar(20))as ItemCode,cast(d.\"Quantity\" as int)as Qty ");
        sb.append("from ORDR p ");
        sb.append("inner join RDR1 d on p.\"DocEntry\"=d.\"DocEntry\" ");
        sb.append("where p.\"DocStatus\"='O' and d.\"WhsCode\"='30' and days_between(p.\"DocDate\",current_date)<45");
        sb.append(" and p.\"Confirmed\"='Y' and p.\"U_SEPARADOR\" in ('APROBADO','PREPAGO') and p.\"U_ESTADO_WMS\" in ('P','C') ");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listado las ordenes aprobadas para enviar a wms-modula.", e);
        }
        return new ArrayList<>();
    }

    public void updateStatus(String docNum, Character status, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("update ORDR set \"U_ESTADO_WMS\"='");
        sb.append(status);
        sb.append("' where \"DocNum\"=");
        sb.append(docNum);
        try {
            persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualiando el estado de la orden de venta docEntry=[" + docNum + "]", e);
        }
    }

    public List<Object[]> listOrdersByDateAndSale(long slpCode, long year, long month, long day, String companyName, boolean pruebas) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(\"CardCode\" as varchar(20))as cardCode,cast(\"DocDate\" as date)as docDate,cast(\"DocTotal\" as numeric(18,2))as docTotal, ");
        sb.append(" cast(\"Comments\" as varchar(500))as comments,cast(\"DocEntry\" as int)as docEntry,cast(\"DocNum\" as int)as docNum,cast(\"CardName\" as varchar(100))as cardName, ");
        sb.append(" cast(ifnull(\"U_SEPARADOR\", 'REVISAR')as varchar(100))as status ");
        sb.append("from ORDR ");
        sb.append("where \"CANCELED\"='N' and \"SlpCode\"=");
        sb.append(slpCode);
        sb.append(" and year(\"DocDate\")=");
        sb.append(year);
        sb.append(" and month(\"DocDate\")=");
        sb.append(month);
        sb.append(" and DAYOFMONTH(\"DocDate\")=");
        sb.append(day);
        sb.append(" order by \"DocDate\" asc,\"DocNum\" desc");
        try {
            return persistenceConf.chooseSchema(companyName, pruebas, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes de venta para el asesor [" + slpCode + "] en " + companyName, e);
        }
        return new ArrayList<>();
    }

    public Object[] getDetailTrackingByOrder(String docNum, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as varchar)as orders,cast(o.\"DocDate\" as date)as docDateOrder,cast(o.\"U_SEPARADOR\" as varchar)as statusOrder, ");
        sb.append(" cast(o.\"DocDueDate\" as date)as docDueDateOrder,cast(f.\"DocNum\" as varchar)as invoice,cast(f.\"DocDate\" as date)as docDateInvoice, ");
        sb.append(" cast(t.\"Name\" as varchar)as transpInvoice,cast(f.\"U_UBIC1\" as varchar)as guiaInvoice,cast(f.\"U_SEPARADOR\" as varchar)as statusInvoice, ");
        sb.append(" cast(t.\"U_URL\" as varchar)as urlTracking ");
        sb.append("from ORDR o ");
        sb.append("left join ODLN e on o.\"DocNum\"=e.\"U_NUNFAC\" ");
        sb.append("left join OINV f on f.\"U_NUNFAC\"=cast(e.\"DocNum\" as varchar) ");
        sb.append("left join \"@TRANSP\" t on t.\"Code\"=f.\"U_TRANSP\" ");
        sb.append("where o.\"DocNum\"=");
        sb.append(docNum);
        try {
            return (Object[]) persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getSingleResult();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo el detalle de seguimineto de la factura " + docNum + " en " + companyName, e);
        }
        return null;
    }
}
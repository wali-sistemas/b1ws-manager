package co.manager.persistence.facade;

import co.manager.util.Constants;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class PurchaseOrderFacade {
    private static final Logger CONSOLE = Logger.getLogger(PurchaseOrderFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public PurchaseOrderFacade() {
    }

    public List<Object[]> listOrdersWithDocumentBL(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(o.\"DocNum\" as varchar(20))as DocNum,cast(o.\"DocDate\" as date)as DocDate, ");
        sb.append(" cast(o.\"U_DOC_TRANSP\" as varchar(50))as BL,cast(s.\"SlpName\" as varchar(100))as SlpName, ");
        sb.append(" cast(o.\"Comments\" as varchar(100))as Coment,'REPUESTOS' as Linea, ");
        sb.append(" cast(s.\"Email\" as varchar(100))as mail ");
        sb.append("from OPOR o ");
        sb.append("inner join OSLP s ON s.\"SlpCode\" = o.\"SlpCode\" ");
        sb.append("where o.\"Series\"='48' and o.\"DocStatus\"='O' and o.\"U_DOC_TRANSP\" is not null and o.\"U_NotificationBL\"='Y' ");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando las ordenes de compra con documento BL. ", e);
        }
        return new ArrayList<>();
    }

    public void updateFieldDocumentBL(String docNum, char status, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OPOR set \"U_NotificationBL\"='");
        sb.append(status);
        sb.append("' where \"DocNum\"=");
        sb.append(docNum);
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el campo de usuario [NotificationBL] en la factura de compra. Estado=[" + status + "]");
        }
    }

    public List<Object[]> listOrderWithDataDriver(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(p.\"DocNum\" as varchar(20))as docNum,cast(p.\"DocDate\" as date)as docDate, ");
        sb.append(" ifnull(cast(p.\"U_CONDUCTOR\" as varchar(100)),'')as driver,ifnull(cast(p.\"U_CEDULA_CON\" as varchar(20)),'')as idDriver, ");
        sb.append(" ifnull(cast(p.\"U_PLACA\" as varchar(15)),'')as placa,ifnull(cast(p.\"U_CONTENEDOR\" as varchar(254)),'')as container,ifnull(cast(p.\"U_PRECINTO\" as varchar(50)),'')as precinto, ");
        sb.append(" ifnull(cast(p.\"U_Fecha_Arribo_CEDI\" as date),current_date)as fecArribo,cast(v.\"SlpName\" as varchar(50))as encargado, ");
        sb.append(" cast(case when p.\"U_TIPO_EMPAQUE\"=01 then 'NO APLICA' when p.\"U_TIPO_EMPAQUE\"=04 then 'CONTENEDOR 40' when p.\"U_TIPO_EMPAQUE\"=05 then 'CONTENEDOR 40 HC' ");
        sb.append("  when p.\"U_TIPO_EMPAQUE\"=02 then 'CARGA SUELTA' when p.\"U_TIPO_EMPAQUE\"=03 then 'CONTENEDOR 20' else '' end as varchar)as tipoEmpaque,cast(v.\"Email\" as varchar(100))as mail ");
        sb.append("from OPOR p ");
        sb.append("inner join OSLP v on p.\"SlpCode\"=v.\"SlpCode\" ");
        sb.append("where p.\"U_ENVIAR_DATOS_CON\"='Y' ");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los datos del conductor de la factura de compra");
        }
        return new ArrayList<>();
    }

    public void updateFieldDataDriver(String docNum, char status, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("update OPOR set \"U_ENVIAR_DATOS_CON\"='");
        sb.append(status);
        sb.append("' where \"DocNum\"=");
        sb.append(docNum);
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el campo de usuario [ENVIAR_DATOS_CON] en la factura de compra. Estado=[" + status + "]");
        }
    }
}
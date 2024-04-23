package co.manager.persistence.facade;

import co.manager.persistence.entity.HistoryGeoLocationSAP;
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
public class HistoryGeoLocationSAPFacade {
    private static final Logger CONSOLE = Logger.getLogger(HistoryGeoLocationSAPFacade.class.getSimpleName());
    private static final String DB_TYPE_HANA = Constants.DATABASE_TYPE_HANA;

    @EJB
    private PersistenceConf persistenceConf;

    public void addHistoryGeoLocation(HistoryGeoLocationSAP historyGeoLocationSAP, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into \"@HIST_COORDENADAS\" values ('");
        sb.append(historyGeoLocationSAP.getCode());
        sb.append("','");
        sb.append(historyGeoLocationSAP.getName());
        sb.append("',");
        sb.append(historyGeoLocationSAP.getUslpCode());
        sb.append(",'");
        sb.append(historyGeoLocationSAP.getUdocDate());
        sb.append("',");
        sb.append(historyGeoLocationSAP.getUdocTime());
        sb.append(",'");
        sb.append(historyGeoLocationSAP.getUlatitud());
        sb.append("','");
        sb.append(historyGeoLocationSAP.getUlongitud());
        sb.append("','");
        sb.append(historyGeoLocationSAP.getUdocType());
        sb.append("');");
        try {
            persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).executeUpdate();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el registro de geo-localizador en " + companyName, e);
        }
    }

    public List<Object[]> listGeoLocationBySeller(String slpCode, String year, String month, String day, String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select distinct cast(h.\"U_SlpCode\" as varchar)as slpcode,cast(a.\"SlpName\" as varchar)as slpName, ");
        sb.append(" cast(h.\"U_Fecha\" as date)as fecha,cast(h.\"U_Hora\" as varchar)as hora,cast(h.\"U_Latitud\" as varchar)as lat, ");
        sb.append(" cast(h.\"U_Longitud\" as varchar)as lon,cast(h.\"U_Tipo\" as varchar)as tipo,cast(a.\"Memo\" as varchar)as regional, ");
        sb.append(" cast(a.\"U_CEDULA\" as varchar)as cedula ");
        sb.append("from \"@HIST_COORDENADAS\" h ");
        sb.append("inner join \"OSLP\" a on a.\"SlpCode\"=h.\"U_SlpCode\" ");
        sb.append("where h.\"U_SlpCode\"=");
        sb.append(slpCode);
        sb.append(" and year(h.\"U_Fecha\")=");
        sb.append(year);
        sb.append(" and month(h.\"U_Fecha\")=");
        sb.append(month);
        sb.append(" and EXTRACT_DAY(h.\"U_Fecha\")=");
        sb.append(day);
        sb.append(" order by fecha asc,cast(hora as int) desc");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (NoResultException ex) {
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando los registros de geo-lacalizacion para el asesor " + slpCode, e);
        }
        return new ArrayList<>();
    }

    public List<Object[]> listActivityReportBySeller(String companyName, boolean testing) {
        StringBuilder sb = new StringBuilder();
        sb.append("select cast(a.\"SlpCode\" as varchar)as slpCode,cast(a.\"SlpName\" as varchar)as slpName,cast(a.\"U_CEDULA\" as varchar)as cedula, ");
        sb.append(" cast((select count(*) from \"@HIST_COORDENADAS\" h where a.\"SlpCode\"=h.\"U_SlpCode\" and h.\"U_Fecha\"=current_date)as int)as countHistC ");
        sb.append("from OSLP a ");
        sb.append("where a.\"Fax\"='Y' ");
        sb.append("order by a.\"SlpCode\" asc");
        try {
            return persistenceConf.chooseSchema(companyName, testing, DB_TYPE_HANA).createNativeQuery(sb.toString()).getResultList();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el reporte de actividad de los asesores", e);
        }
        return new ArrayList<>();
    }
}
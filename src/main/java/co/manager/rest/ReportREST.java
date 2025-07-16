package co.manager.rest;

import co.manager.dto.PrintReportDTO;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.ManagerApplicationBean;
import net.sf.jasperreports.engine.*;
import org.apache.pdfbox.pdmodel.PDDocument;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("report")
public class ReportREST implements Serializable {
    private static final Logger CONSOLE = Logger.getLogger(ReportREST.class.getSimpleName());

    @Inject
    private ManagerApplicationBean appBean;

    @POST
    @Path("generate-report")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ResponseDTO generateReport(PrintReportDTO dto) throws Exception {
        String reportName = null;
        String report = null;
        String rutaArchivo = "";

        switch (dto.getDocumento()) {
            case "withholding":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        dto.getDocumento() + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + dto.getFiltro() + File.separator + reportName;
                break;
            case "shopping":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "customer" + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            case "collection":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "customer" + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            case "orderDetail":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "sales" + File.separator + dto.getDocumento() + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + "sales" + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            case "accountSetting":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "customer" + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            case "associatedForm":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "employee" + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            case "accountStatement":
                rutaArchivo = appBean.obtenerValorPropiedad("url.archivo");
                reportName = dto.getId() + ".pdf";
                report = JasperCompileManager.compileReportToFile(appBean.obtenerValorPropiedad("url.jasper") + dto.getCompanyName() + File.separator +
                        "employee" + File.separator + dto.getDocumento() + ".jrxml");
                rutaArchivo = rutaArchivo + dto.getCompanyName() + File.separator + dto.getDocumento() + File.separator + reportName;
                break;
            default:
                reportName = "";
                break;
        }

        //Se crea la coneccion con la base de datos
        String cn = null;
        InitialContext initialContext = new InitialContext();
        //Origen: S=SAP W=WALI N=NOMINA
        if (dto.getOrigen().equals("S")) {
            switch (dto.getCompanyName()) {
                case "IGB":
                    cn = "java:/HANAIGBDS";
                    break;
                case "VARROC":
                    cn = "java:/HANAVARROCDS";
                    break;
                case "REDPLAS":
                    cn = "java:/HANAREDPLASDS";
                    break;
                case "IGBPruebas":
                    cn = "java:/HANAIGBTESTDS";
                    break;
                case "VARROCPruebas":
                    cn = "java:/HANAVARROCTESTDS";
                    break;
                case "REDPLASPruebas":
                    cn = "java:/HANAREDPLASTESTDS";
                    break;
                default:
                    cn = "";
                    break;
            }
        } else if (dto.getOrigen().equals("N")) {
            switch (dto.getCompanyName()) {
                case "IGB_NOVAWEB":
                    cn = "java:/IGBNOVAWEBNUBEDS";
                    break;
                case "MTZ_NOVAWEB":
                    cn = "java:/MTZNOVAWEBNUBEDS";
                    break;
                case "VILNA_NOVAWEB":
                    cn = "java:/VILNOVAWEBNUBEDS";
                    break;
                case "WALI_NOVAWEB":
                    cn = "java:/WALNOVAWEBNUBEDS";
                    break;
                case "DSM_NOVAWEB":
                    cn = "java:/DIGNOVAWEBNUBEDS";
                    break;
                case "INVERSUR_NOVAWEB":
                    cn = "java:/INVNOVAWEBNUBEDS";
                    break;
                case "MOTOREPUESTOS_NOVAWEB":
                    cn = "java:/MOTNOVAWEBNUBEDS";
                    break;
                case "FEMPROBN_NOVAWEB":
                    cn = "java:/FPBNOVAWEBNUBEDS";
                    break;
                default:
                    cn = "";
                    break;
            }
        } else if (dto.getOrigen().equals("W")) {
            cn = "java:/WMSDS";
        } else {
            cn = "java:/MySQLDS";
        }
        DataSource dataSource = (DataSource) initialContext.lookup(cn);
        Connection connection = dataSource.getConnection();

        //Se mandan los parametros al Jasper
        Map<String, Object> mapa = new HashMap<>();
        mapa.put("id", dto.getId());
        mapa.put("filtro", dto.getFiltro());
        mapa.put("filtroSec", dto.getFiltroSec());

        generarInforme(report, rutaArchivo, dto, mapa, connection);
        connection.close();
        return new ResponseDTO(0, rutaArchivo);
    }

    private void generarInforme(String report, String rutaArchivo, PrintReportDTO dto, Map<String, Object> mapa, Connection connection) throws JRException, IOException {
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, mapa, connection);
        JasperExportManager.exportReportToPdfFile(jasperPrint, rutaArchivo);
        PDDocument document = PDDocument.load(new File(rutaArchivo));
        CONSOLE.log(Level.INFO, "Se guardo el documento {0} numero {1}", new Object[]{dto.getDocumento(), dto.getId()});
        document.close();
    }
}
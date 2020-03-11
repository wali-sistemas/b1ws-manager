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

    @Inject
    private ManagerApplicationBean appBean;
    private static final Logger CONSOLE = Logger.getLogger(ReportREST.class.getSimpleName());

    @POST
    @Path("generate-report/")
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
            default:
                reportName = "";
                break;
        }

        //TODO: Se crea la coneccion con la base de datos
        String cn = null;
        InitialContext initialContext = new InitialContext();
        if (dto.getOrigen().equals("S")) {
            if (dto.getCompanyName().equals("IGB")) {
                cn = "java:/IGBDS";
            } else {
                cn = "java:/VARROCDS";
            }
        } else {
            cn = "java:/MySQLDS";
        }
        DataSource dataSource = (DataSource) initialContext.lookup(cn);
        Connection connection = dataSource.getConnection();

        //TODO: Se mandan los parametros al Jasper
        Map<String, Object> mapa = new HashMap<>();
        if (dto.getId() != 0) {
            mapa.put("id", dto.getId());
        }
        if (dto.getDocumento().equals("withholding")) {
            if (dto.getFiltro() != null) {
                mapa.put("filtro", dto.getFiltro());
            }
        }
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
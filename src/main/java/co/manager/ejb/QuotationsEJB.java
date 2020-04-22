package co.manager.ejb;

import co.manager.b1ws.quotations.*;
import co.manager.dto.DetailQuotationDTO;
import co.manager.dto.QuotationDTO;
import co.manager.dto.ResponseDTO;
import co.manager.util.Constants;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class QuotationsEJB {
    private static final Logger CONSOLE = Logger.getLogger(QuotationsEJB.class.getSimpleName());
    private QuotationsService service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new QuotationsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_QUOTATIONS_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de QuotationsService. ", e);
        }
    }

    private Long createQuotationsDocument(Document document, String sessionId) throws MalformedURLException {
        QuotationsService service = new QuotationsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_QUOTATIONS_SERVICE)));
        Add add = new Add();
        add.setDocument(document);

        MsgHeader header = new MsgHeader();
        header.setServiceName("QuotationsService");
        header.setSessionID(sessionId);

        CONSOLE.log(Level.INFO, "Creando cotizacion en SAP con sessionId [{0}]", sessionId);

        AddResponse response = service.getQuotationsServiceSoap12().add(add, header);
        Long docEntry = response.getDocumentParams().getDocEntry();
        CONSOLE.log(Level.INFO, "Cotizacion creado con docEntry {0}", docEntry);
        return docEntry;
    }

    public ResponseDTO createSalesOrder(QuotationDTO dto) {
        Long docEntry = 0l;
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                Document quotation = new Document();
                Document.DocumentLines detailQuotation = new Document.DocumentLines();
                quotation.setSeries(17l);
                quotation.setCardCode(dto.getCardCode());
                quotation.setComments(dto.getComments());
                quotation.setNumAtCard(dto.getNumAtCard());
                quotation.setSalesPersonCode(dto.getSlpCode());

                try {
                    GregorianCalendar date = new GregorianCalendar();
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
                    quotation.setDocDate(date2);
                    quotation.setDocDueDate(date2);
                } catch (Exception e) {
                }

                List<DetailQuotationDTO> lines = dto.getDetailQuotation();
                for (DetailQuotationDTO line : lines) {
                    Document.DocumentLines.DocumentLine quotationLine = new Document.DocumentLines.DocumentLine();
                    quotationLine.setItemCode(line.getItemCode());
                    quotationLine.setQuantity(line.getQuantity().doubleValue());
                    quotationLine.setWarehouseCode(line.getWhsCode());

                    detailQuotation.getDocumentLine().add(quotationLine);
                }
                quotation.setDocumentLines(detailQuotation);

                CONSOLE.log(Level.INFO, "Iniciando creacion de cotizacion para {0}", dto.getCompanyName());
                docEntry = createQuotationsDocument(quotation, sessionId);
                if (docEntry == 0) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear la cotizacion. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear la cotizacion. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo la cotizacion satisfactoriamente");
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la cotizacion ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }

        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, docEntry);
    }
}
package co.manager.ejb;

import co.manager.dto.DetailQuotationDTO;
import co.manager.dto.QuotationDTO;
import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.quotation.QuotationsClient;
import co.manager.hanaws.dto.quotation.QuotationsDTO;
import co.manager.hanaws.dto.quotation.QuotationsRestDTO;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class QuotationsEJB {
    private static final Logger CONSOLE = Logger.getLogger(QuotationsEJB.class.getSimpleName());
    private QuotationsClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new QuotationsClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de QuotationsServiceLayer. ", e);
        }
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
                QuotationsDTO quotation = new QuotationsDTO();
                List<QuotationsDTO.DocumentLines.DocumentLine> detailQuotation = new ArrayList<>();
                quotation.setSeries(17l);
                quotation.setCardCode(dto.getCardCode());
                quotation.setComments(dto.getComments());
                quotation.setNumAtCard(dto.getNumAtCard());
                quotation.setSalesPersonCode(dto.getSlpCode());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    quotation.setDocDate(date2);
                    quotation.setDocDueDate(date2);
                } catch (Exception e) {
                }

                List<DetailQuotationDTO> lines = dto.getDetailQuotation();
                for (DetailQuotationDTO line : lines) {
                    QuotationsDTO.DocumentLines.DocumentLine quotationLine = new QuotationsDTO.DocumentLines.DocumentLine();
                    quotationLine.setItemCode(line.getItemCode());
                    quotationLine.setQuantity(line.getQuantity().doubleValue());
                    quotationLine.setWarehouseCode(line.getWhsCode());

                    detailQuotation.add(quotationLine);
                }
                quotation.setDocumentLines(detailQuotation);

                CONSOLE.log(Level.INFO, "Iniciando creacion de cotizacion para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(quotation);
                CONSOLE.log(Level.INFO, json);
                QuotationsRestDTO res = service.addQuotation(quotation, sessionId);
                docEntry = res.getDocEntry();

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
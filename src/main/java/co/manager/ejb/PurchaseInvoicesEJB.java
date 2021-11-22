package co.manager.ejb;

import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.purchaseInvoices.PurchaseInvoicesClient;
import co.manager.hanaws.dto.purchaseInvoice.PurchaseInvoicesDTO;
import co.manager.hanaws.dto.purchaseInvoice.PurchaseInvoicesRestDTO;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.math.BigDecimal;
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
public class PurchaseInvoicesEJB {
    private static final Logger CONSOLE = Logger.getLogger(PurchaseInvoicesEJB.class.getSimpleName());
    private PurchaseInvoicesClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new PurchaseInvoicesClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de PurchaseInvoicesServiceLayer. ", e);
        }
    }

    public ResponseDTO createPurchaseInvoice(List<Object[]> details, String invoice, String companyName) {
        Long docNum = 0l;
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(companyName);
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
                PurchaseInvoicesDTO purchaseInvoice = new PurchaseInvoicesDTO();
                List<PurchaseInvoicesDTO.DocumentLines.DocumentLine> documentLines = new ArrayList<>();

                purchaseInvoice.setCardCode("P811011909");
                purchaseInvoice.setComments((String) details.get(0)[0]);
                purchaseInvoice.setSeries(11l);
                purchaseInvoice.setSalesPersonCode(5l);
                purchaseInvoice.setNumAtCard(invoice);
                purchaseInvoice.setDiscountPercent((BigDecimal) details.get(0)[5]);

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    purchaseInvoice.setDocDate(date2);
                    purchaseInvoice.setDocDueDate(date2);
                } catch (Exception e) {
                }

                for (Object[] obj : details) {
                    long lineNum = (Integer) obj[4];
                    PurchaseInvoicesDTO.DocumentLines.DocumentLine documentLine = new PurchaseInvoicesDTO.DocumentLines.DocumentLine();
                    documentLine.setLineNum(lineNum);
                    documentLine.setItemCode((String) obj[1]);
                    documentLine.setQuantity(Double.valueOf((Integer) obj[2]));
                    documentLine.setWarehouseCode("01");
                    documentLine.setPrice((BigDecimal) obj[3]);
                    documentLine.setTaxCode("IVAD01");

                    documentLines.add(documentLine);
                }
                purchaseInvoice.setDocumentLines(documentLines);

                CONSOLE.log(Level.INFO, "Iniciando creacion de factura de compra para {0}", companyName);
                Gson gson = new Gson();
                String json = gson.toJson(purchaseInvoice);
                CONSOLE.log(Level.INFO, json);
                PurchaseInvoicesRestDTO res = service.addInvoice(purchaseInvoice, sessionId);
                docNum = res.getDocNum();

                if (docNum == 0) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear la factura de compra. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear la factura de compra. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo la factura de compra [{0}] satisfactoriamente", docNum);
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la factura de compra ", e);
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
        return new ResponseDTO(0, docNum);
    }
}
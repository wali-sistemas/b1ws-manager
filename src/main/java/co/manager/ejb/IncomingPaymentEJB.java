package co.manager.ejb;

import co.manager.dto.IncomingPaymentDTO;
import co.manager.dto.IncomingPaymentInvoiceDTO;
import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.incomingPayments.PaymentsClient;
import co.manager.hanaws.dto.payment.PaymentDTO;
import co.manager.hanaws.dto.payment.PaymentRestDTO;
import co.manager.persistence.facade.PagoPasarelaSAPFacade;
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
public class IncomingPaymentEJB {
    private static final Logger CONSOLE = Logger.getLogger(IncomingPaymentEJB.class.getSimpleName());
    private PaymentsClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;
    @EJB
    private PagoPasarelaSAPFacade pagoPasarelaSAPFacade;

    @PostConstruct
    private void initialize() {
        try {
            service = new PaymentsClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de IncomingPaymentsServiceLayer. ", e);
        }
    }

    public ResponseDTO createIncomingPaymentsService(IncomingPaymentDTO dto) {
        long docEntry = 0l;
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
                List<PaymentDTO.PaymentInvoices.PaymentInvoice> paymentInvoice = new ArrayList<>();
                PaymentDTO payment = new PaymentDTO();
                payment.setSeries(Long.valueOf(18L));
                payment.setDocType("C");
                payment.setCardCode(dto.getCardCode());
                payment.setDocCurrency("$");
                payment.setTransferAccount("752038166");//Banco de Bogota fiducia solo motozone
                payment.setTransferReference(dto.getTransferReference());
                payment.setJournalRemarks("Pagos recibidos Extranet - " + dto.getCardCode());
                payment.setTransferSum(dto.getCashSum());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    payment.setDocDate(date2);
                    payment.setTaxDate(date2);
                    payment.setTransferDate(date2);
                } catch (Exception exception) {
                }

                List<IncomingPaymentInvoiceDTO> lines = dto.getIncomingPaymentInvoices();
                for (IncomingPaymentInvoiceDTO line : lines) {
                    PaymentDTO.PaymentInvoices.PaymentInvoice paymentInvoiceLine = new PaymentDTO.PaymentInvoices.PaymentInvoice();
                    paymentInvoiceLine.setLineNum(line.getLineNum().longValue());
                    paymentInvoiceLine.setDocEntry(line.getDocEntry());
                    paymentInvoiceLine.setSumApplied(line.getSumApplied());
                    paymentInvoiceLine.setInvoiceType("it_Invoice");
                    paymentInvoice.add(paymentInvoiceLine);
                }
                payment.setPaymentInvoices(paymentInvoice);

                CONSOLE.log(Level.INFO, "Iniciando creacion de pago recibido para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(payment);
                CONSOLE.log(Level.INFO, json);
                PaymentRestDTO res = service.addPayment(payment, sessionId);
                docEntry = res.getDocEntry();

                if (docEntry <= 0L) {
                    CONSOLE.log(Level.WARNING, "Ocurrio un problema al crear el pago recibido");
                    return new ResponseDTO(-1, "Ocurrio un problema al crear el pago recibido.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el pago recibido #{0} satisfactoriamente", res.getDocNum());
                    //actualizar el nro de documento en el encabezado de pago pasarela
                    pagoPasarelaSAPFacade.updateNroPago(dto.getIdPayment(), res.getDocNum(), dto.getCompanyName(), false);
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago recibido. ", e);
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

    public ResponseDTO createIncomingPaymentAccountCalidosoService(IncomingPaymentDTO dto) {
        long docEntry = 0l;
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
                List<PaymentDTO.PaymentAccounts.PaymentAccount> paymentInvoice = new ArrayList<>();
                PaymentDTO payment = new PaymentDTO();
                payment.setSeries(Long.valueOf(18L));
                payment.setDocType("C");
                payment.setCardCode(dto.getCardCode());
                payment.setDocCurrency("$");
                payment.setTransferAccount("52356085");//Cuenta de fidelización
                payment.setTransferSum(dto.getTransferSum());
                payment.setTransferReference(dto.getTransferReference());
                payment.setJournalRemarks("Redención de puntos Los Calidosos - " + dto.getCardCode());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    payment.setDocDate(date2);
                    payment.setTransferDate(date2);
                    payment.setTaxDate(date2);
                } catch (Exception exception) {
                }

                payment.setPaymentAccounts(paymentInvoice);

                CONSOLE.log(Level.INFO, "Iniciando creacion de pago a cuenta para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(payment);
                CONSOLE.log(Level.INFO, json);
                PaymentRestDTO res = service.addPayment(payment, sessionId);
                docEntry = res.getDocEntry();

                if (docEntry <= 0L) {
                    CONSOLE.log(Level.WARNING, "Ocurrio un problema al crear el pago a cuenta");
                    return new ResponseDTO(-1, "Ocurrio un problema al crear el pago a cuenta.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el pago a cuenta #{0} satisfactoriamente", res.getDocNum());
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el pago a cuenta. ", e);
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
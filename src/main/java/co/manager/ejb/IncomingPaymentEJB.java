package co.manager.ejb;

import co.manager.b1ws.incomingPayments.*;
import co.manager.b1ws.incomingPayments.IncomingPaymentsService;
import co.manager.dto.IncomingPaymentDTO;
import co.manager.dto.IncomingPaymentInvoiceDTO;
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
public class IncomingPaymentEJB {
    private static final Logger CONSOLE = Logger.getLogger(IncomingPaymentEJB.class.getSimpleName());
    private IncomingPaymentsService service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;

    @PostConstruct
    private void initialize() {
        try {
            service = new IncomingPaymentsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_INCOMING_PAYMENTS_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de IncomingPaymentsService. ", e);
        }
    }

    private Long createIncomingPaymentsServiceDocument(Payment document, String sessionId) throws MalformedURLException {
        IncomingPaymentsService service = new IncomingPaymentsService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_INCOMING_PAYMENTS_SERVICE)));
        Add add = new Add();
        add.setPayment(document);

        MsgHeader header = new MsgHeader();
        header.setServiceName("IncomingPaymentsService");
        header.setSessionID(sessionId);

        CONSOLE.log(Level.INFO, "Creando pago recibido en SAP con sessionId [{0}]", sessionId);

        AddResponse response = service.getIncomingPaymentsServiceSoap12().add(add, header);
        Long docEntry = response.getPaymentParams().getDocEntry();
        CONSOLE.log(Level.INFO, "Pago recibido creado con docEntry {0}", docEntry);
        return docEntry;
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
                Payment.PaymentInvoices paymentInvoice = new Payment.PaymentInvoices();
                Payment payment = new Payment();
                payment.setSeries(Long.valueOf(18L));
                payment.setDocType("C");
                payment.setCardCode(dto.getCardCode());
                payment.setDocCurrency("$");
                payment.setTransferAccount("11250525");//itau fiducia solo motozone
                payment.setTransferReference(dto.getTransferReference());
                payment.setJournalRemarks("Pagos recibidos Extranet - " + dto.getCardCode());
                payment.setTransferSum(dto.getCashSum());
                try {
                    GregorianCalendar date = new GregorianCalendar();
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
                    payment.setDocDate(date2);
                    payment.setTransferDate(date2);
                    payment.setTaxDate(date2);
                } catch (Exception exception) {
                }

                List<IncomingPaymentInvoiceDTO> lines = dto.getIncomingPaymentInvoices();
                for (IncomingPaymentInvoiceDTO line : lines) {
                    Payment.PaymentInvoices.PaymentInvoice paymentInvoiceLine = new Payment.PaymentInvoices.PaymentInvoice();
                    paymentInvoiceLine.setLineNum(line.getLineNum().longValue());
                    paymentInvoiceLine.setDocEntry(line.getDocEntry());
                    paymentInvoiceLine.setSumApplied(line.getSumApplied());
                    paymentInvoiceLine.setInvoiceType("it_Invoice");
                    paymentInvoice.getPaymentInvoice().add(paymentInvoiceLine);
                }
                payment.setPaymentInvoices(paymentInvoice);
                CONSOLE.log(Level.INFO, "Iniciando creacion de pago recido para {0}", dto.getCompanyName());
                docEntry = createIncomingPaymentsServiceDocument(payment, sessionId).longValue();
                if (docEntry <= 0L) {
                    CONSOLE.log(Level.WARNING, "Ocurriun problema al crear el pago recibido. Resetear el sesiID.");
                    return new ResponseDTO(-1, "Ocurriun problema al crear el pago recibido. Resetear el sesiID.");
                }
                CONSOLE.log(Level.INFO, "Se creo el pago recibido satisfactoriamente");
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
}
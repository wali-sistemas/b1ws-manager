package co.manager.ejb;

import co.manager.b1ws.orderSale.*;
import co.manager.dto.DetailSalesOrderDTO;
import co.manager.dto.ResponseDTO;
import co.manager.dto.SalesOrderDTO;
import co.manager.persistence.facade.SalesOrderSAPFacade;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;

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
public class SalesOrderEJB {
    private static final Logger CONSOLE = Logger.getLogger(SalesOrderEJB.class.getSimpleName());
    private OrdersService service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;

    @PostConstruct
    private void initialize() {
        try {
            service = new OrdersService(
                    new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ORDER_SERVICE)));
        } catch (MalformedURLException e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de OrdersService. ", e);
        }
    }

    private Document retrieveOrderDocument(Long docEntry, String sessionId) throws MalformedURLException {
        OrdersService service = new OrdersService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ORDER_SERVICE)));

        MsgHeader header = new MsgHeader();
        header.setServiceName(Constants.B1WS_ORDER_SERVICE);
        header.setSessionID(sessionId);

        DocumentParams docParams = new DocumentParams();
        docParams.setDocEntry(docEntry);

        GetByParams params = new GetByParams();
        params.setDocumentParams(docParams);

        GetByParamsResponse response = service.getOrdersServiceSoap12().getByParams(params, header);
        return response.getDocument();
    }

    public ResponseDTO createSalesOrder(SalesOrderDTO dto) {
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
                Document.DocumentLines detail = new Document.DocumentLines();
                Document order = new Document();
                order.setSeries(Long.parseLong(getPropertyValue("manager.order.series", dto.getCompanyName())));
                order.setCardCode(dto.getCardCode());
                order.setComments(dto.getComments());
                order.setSalesPersonCode(dto.getSlpCode());
                order.setNumAtCard(dto.getNumAtCard());
                order.setJournalMemo("Pedidos de cliente - " + dto.getCardCode());
                order.setUTRANSP(dto.getIdTransport());
                order.setConfirmed(dto.getConfirmed());
                order.setUSEPARADOR(dto.getStatus());
                order.setShipToCode(dto.getShipToCode());
                order.setPayToCode(dto.getPayToCode());
                order.setDiscountPercent(dto.getDiscountPercent());

                try {
                    GregorianCalendar date = new GregorianCalendar();
                    XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
                    order.setDocDate(date2);
                    order.setDocDueDate(date2);
                    order.setUFECINI(date2);
                } catch (Exception e) {
                }

                List<DetailSalesOrderDTO> lines = dto.getDetailSalesOrder();
                for (DetailSalesOrderDTO line : lines) {
                    Document.DocumentLines.DocumentLine orderLine = new Document.DocumentLines.DocumentLine();
                    orderLine.setItemCode(line.getItemCode());
                    orderLine.setQuantity(line.getQuantity().doubleValue());
                    orderLine.setWarehouseCode(line.getWhsCode());
                    orderLine.setCostingCode(lines.get(0).getOcrCode());

                    detail.getDocumentLine().add(orderLine);
                }
                order.setDocumentLines(detail);

                CONSOLE.log(Level.INFO, "Iniciando creacion de orden de la venta para {0}", dto.getCompanyName());
                docEntry = createOrderDocument(order, sessionId);
                if (docEntry == 0) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear la orden. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear la orden. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo la orden satisfactoriamente");
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden ", e);
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
        return new ResponseDTO(0, salesOrderSAPFacade.getDocNumOrder(docEntry, dto.getCompanyName(), false));
    }

    private Long createOrderDocument(Document document, String sessionId) throws MalformedURLException {
        OrdersService service = new OrdersService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ORDER_SERVICE)));
        Add add = new Add();
        add.setDocument(document);

        MsgHeader header = new MsgHeader();
        header.setServiceName("OrdersService");
        header.setSessionID(sessionId);

        CONSOLE.log(Level.INFO, "Creando orden de venta en SAP con sessionId [{0}]", sessionId);

        AddResponse response = service.getOrdersServiceSoap12().add(add, header);
        Long docEntry = response.getDocumentParams().getDocEntry();
        CONSOLE.log(Level.INFO, "Orden de venta creada con docEntry {0}", docEntry);
        return docEntry;
    }

    public ResponseDTO modifySalesOrderQuantity(String companyName, Integer orderEntry, String itemCode, Integer newQuantity) {
        ResponseDTO res = null;
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
                Document doc = retrieveOrderDocument(orderEntry.longValue(), sessionId);
                List<Document.DocumentLines.DocumentLine> lines = doc.getDocumentLines().getDocumentLine();
                for (Document.DocumentLines.DocumentLine line : lines) {
                    if (line.getItemCode().equals(itemCode)) {
                        line.setQuantity(newQuantity.doubleValue());
                        //line.setuPicking("Y");
                        break;
                    }
                }
                res = modifyOrderDocument(doc, sessionId);
                if (res.getCode() == 0) {
                    CONSOLE.log(Level.INFO, "Se modifico la orden satisfactoriamente");
                } else {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al modificar la orden " + res.getContent() + ". Resetear el sesión ID.");
                    return new ResponseDTO(-1, res.getContent());
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al modificar la cantidad de la orden ", e);
                return new ResponseDTO(-1, e);
            }
        }

        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            }
        }
        return new ResponseDTO(0, res.getContent());
    }

    private String getSessionId(String companyName) {
        String sessionId = null;
        try {
            sessionId = sessionManager.login(companyName);
            CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
        } catch (Exception ignored) {
        }
        return sessionId;
    }

    private ResponseDTO modifyOrderDocument(Document document, String sessionId) throws MalformedURLException {
        String errorMessage = null;
        OrdersService service = new OrdersService(new URL(String.format(appBean.obtenerValorPropiedad(Constants.B1WS_WSDL_URL), Constants.B1WS_ORDER_SERVICE)));

        MsgHeader header = new MsgHeader();
        header.setServiceName(Constants.B1WS_ORDER_SERVICE);
        header.setSessionID(sessionId);

        Update params = new Update();
        params.setDocument(document);

        CONSOLE.log(Level.INFO, "Modificando orden de venta en SAP con sessionId [{0}]", sessionId);

        try {
            UpdateResponse resp = service.getOrdersServiceSoap12().update(params, header);
            if (resp != null) {
                return new ResponseDTO(0, resp);
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al modificar la cantidad de la orden. ", e);
            errorMessage = e.getMessage();
        }
        return new ResponseDTO(-1, errorMessage);
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(propertyName), companyName);
    }
}
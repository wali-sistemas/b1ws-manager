package co.manager.ejb;

import co.manager.dto.DetailSalesOrderDTO;
import co.manager.dto.ResponseDTO;
import co.manager.dto.SalesOrderDTO;
import co.manager.hanaws.client.order.OrderClient;
import co.manager.hanaws.dto.order.OrderDTO;
import co.manager.hanaws.dto.order.OrderRestDTO;
import co.manager.persistence.facade.SalesOrderSAPFacade;
import co.manager.util.Constants;
import co.manager.util.IGBUtils;
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
public class SalesOrderEJB {
    private static final Logger CONSOLE = Logger.getLogger(SalesOrderEJB.class.getSimpleName());
    private OrderClient service;
    @Inject
    private ManagerApplicationBean appBean;
    @Inject
    private SessionPoolManager sessionPoolManager;
    @EJB
    private SessionManager sessionManager;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;

    @PostConstruct
    private void initialize() {
        try {
            service = new OrderClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de OrderServiceLayer. ", e);
        }
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
                OrderDTO order = new OrderDTO();
                order.setSeries(Long.parseLong(getPropertyValue("manager.order.series", dto.getCompanyName())));
                order.setCardCode(dto.getCardCode());
                order.setComments(dto.getComments());
                order.setSalesPersonCode(dto.getSlpCode());
                order.setNumAtCard(dto.getNumAtCard());
                order.setJournalMemo("Pedidos de cliente - " + dto.getCardCode());
                order.setUtransp(dto.getIdTransport());
                order.setConfirmed(dto.getConfirmed());
                order.setUseparador(dto.getStatus());
                order.setShipToCode(dto.getShipToCode());
                order.setPayToCode(dto.getPayToCode());
                order.setDiscountPercent(dto.getDiscountPercent());
                order.setUserialMDL(dto.getSerialMDL());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    order.setDocDate(date2);
                    order.setDocDueDate(date2);
                    order.setUfecini(date2);
                } catch (Exception e) {
                }

                List<DetailSalesOrderDTO> lines = dto.getDetailSalesOrder();
                List<OrderDTO.DocumentLines.DocumentLine> listDet = new ArrayList<>();
                for (DetailSalesOrderDTO line : lines) {
                    OrderDTO.DocumentLines.DocumentLine orderLine = new OrderDTO.DocumentLines.DocumentLine();
                    orderLine.setItemCode(line.getItemCode());
                    orderLine.setQuantity(line.getQuantity().doubleValue());
                    orderLine.setWarehouseCode(line.getWhsCode());
                    orderLine.setCostingCode(lines.get(0).getOcrCode());
                    orderLine.setBaseLine(line.getBaseLine());
                    orderLine.setBaseType(line.getBaseType());
                    orderLine.setBaseEntry(line.getBaseEntry());

                    listDet.add(orderLine);
                }
                order.setDocumentLines(listDet);

                CONSOLE.log(Level.INFO, "Iniciando creacion de orden de la venta para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(order);
                CONSOLE.log(Level.INFO, json);
                OrderRestDTO res = service.addOrder(order, sessionId);
                docEntry = res.getDocEntry();
                if (docEntry == 0) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear la orden. Resetear el sesión ID.");
                    return new ResponseDTO(-1, order);
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
            String resp = sessionPoolManager.returnSession(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, salesOrderSAPFacade.getDocNumOrder(docEntry, dto.getCompanyName(), false));
    }

    private String getPropertyValue(String propertyName, String companyName) {
        return IGBUtils.getProperParameter(appBean.obtenerValorPropiedad(propertyName), companyName);
    }
}
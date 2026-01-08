package co.manager.modulaws.ejb;

import co.manager.modulaws.client.OrderClient;
import co.manager.modulaws.dto.order.OrderExpModulaRestDTO;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.dto.order.OrderImpModulaRestDTO;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OrderModulaEJB {
    private static final Logger CONSOLE = Logger.getLogger(OrderModulaEJB.class.getSimpleName());
    private OrderClient service;

    @PostConstruct
    private void initialize() {
        try {
            service = new OrderClient(Constants.MODULAWS_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de modula [CFG-IMP-ORDINI]. ", e);
        }
    }

    public String addOrdine(OrderModulaDTO dto, String comment) {
        OrderImpModulaRestDTO.Header ordine = new OrderImpModulaRestDTO.Header();
        List<OrderImpModulaRestDTO.Header.Ordine> header = new ArrayList<>();
        OrderImpModulaRestDTO.Header.Ordine headerDto = new OrderImpModulaRestDTO.Header.Ordine();
        headerDto.setDocNum(dto.getDocNum());
        headerDto.setComment(comment);
        headerDto.setType(dto.getType());//Inventario=I Reabastecer=V Picking=P

        if (dto.getType().equals("V") || dto.getType().equals("I")) {
            headerDto.setOrdSospesa(1);
            headerDto.setOrdEseguiSys("E");
            headerDto.setOrdGestBan(0);
        } else if (dto.getType().equals("P")) {
            headerDto.setOrdSospesa(0);
            headerDto.setOrdEseguiSys("");
            headerDto.setOrdGestBan(1);
        }

        header.add(headerDto);
        ordine.setOrder(header);

        List<OrderImpModulaRestDTO.Header.Detail> detail = new ArrayList<>();
        for (OrderModulaDTO.DetailModulaDTO d : dto.getDetail()) {
            OrderImpModulaRestDTO.Header.Detail detailDto = new OrderImpModulaRestDTO.Header.Detail();
            detailDto.setDocNum(dto.getDocNum());
            detailDto.setItemCode(d.getItemCode());
            detailDto.setQuantity(d.getQuantity().toString());
            detail.add(detailDto);
        }
        ordine.setDetail(detail);

        Gson gson = new Gson();
        String json = gson.toJson(ordine);
        CONSOLE.log(Level.INFO, json);

        try {
            return service.addOrdine(ordine);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando la orden usando la instancia [CFG-IMP-ORDINI]", e);
            return null;
        }
    }

    public OrderExpModulaRestDTO listOrdineProcessed() {
        OrderExpModulaRestDTO documento = new OrderExpModulaRestDTO();
        try {
            documento = service.listOrdineProcessed();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error retornando el listando de ordenes procesadas usando la instancia [CFG-EXP-ORDINI]", e);
            return null;
        }
        return documento;
    }
}
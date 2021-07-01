package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.modulaws.dto.item.StockMissingDTO;
import co.manager.modulaws.dto.item.StockRestDTO;
import co.manager.modulaws.ejb.StockModulaEJB;
import co.manager.persistence.facade.ItemSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("modula")
public class ModulaREST {
    private static final Logger CONSOLE = Logger.getLogger(ModulaREST.class.getSimpleName());

    @EJB
    private StockModulaEJB stockModulaEJB;
    @EJB
    private ItemSAPFacade itemSAPFacade;

    @GET
    @Path("stock-compare")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockModula() {
        CONSOLE.log(Level.INFO, "Iniciando comparacion de stock entre modula vs SAP");
        List<StockRestDTO.ItemDTO.DetailDTO> stockModula = new ArrayList<>();
        List<StockMissingDTO> stockMissingDTO = new ArrayList<>();

        //obtener stock del api
        StockRestDTO res = stockModulaEJB.getStock();
        if (res == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo datos del api modula");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error obteniendo datos del api modula.")).build();
        }
        //mapear datos obtenidos del api
        for (StockRestDTO.ItemDTO.DetailDTO obj : res.getItem().getDetails()) {
            StockRestDTO.ItemDTO.DetailDTO dto = new StockRestDTO.ItemDTO.DetailDTO();
            dto.setItemCode(obj.getItemCode());
            dto.setItemName(obj.getItemName());
            dto.setStock(obj.getStock());
            stockModula.add(dto);
        }

        if (stockModula.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "En modula no se encontraron datos para comparar");
            return Response.ok(new ResponseDTO(-1, "En modula no se encontraron datos para comparar.")).build();
        }
        //obtener stock de SAP almacen 30-modula
        List<Object[]> stockModulaSAP = itemSAPFacade.listStockSAPModula("IGB", false);
        if (stockModulaSAP == null) {
            CONSOLE.log(Level.SEVERE, "En sap no se encontraron datos para comparar");
            return Response.ok(new ResponseDTO(-1, "En sap no se encontraron datos para comparar.")).build();
        }

        for (StockRestDTO.ItemDTO.DetailDTO dto1 : stockModula) {
            StockMissingDTO dto2 = new StockMissingDTO();
            for (Object[] obj : stockModulaSAP) {
                if (obj[0].equals(dto1.getItemCode()) && !obj[2].equals(dto1.getStock())) {
                    dto2.setItemCode((String) obj[0]);
                    dto2.setItemName((String) obj[1]);
                    dto2.setQtySAP((Integer) obj[2]);
                    dto2.setQtyMDL(Integer.parseInt(dto1.getStock().replace(",000", "")));
                    dto2.setWhsCode((String) obj[3]);
                    dto2.setBinCode((String) obj[4]);
                    dto2.setWhsName((String) obj[5]);
                    stockMissingDTO.add(dto2);
                } else {
                    dto2.setItemCode(dto1.getItemCode());
                    dto2.setItemName(dto1.getItemName());
                    dto2.setQtySAP(0);
                    dto2.setQtyMDL(Integer.parseInt(dto1.getStock().replace(",000", "")));
                    dto2.setBinCode("MODULA");
                    dto2.setWhsCode("30");
                    dto2.setWhsName("MODULA");
                    stockMissingDTO.add(dto2);
                }
            }
        }
        return Response.ok(stockMissingDTO).build();
    }
}
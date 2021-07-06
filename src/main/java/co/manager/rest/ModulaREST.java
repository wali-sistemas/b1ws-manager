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
import java.util.TreeSet;
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
        TreeSet<StockMissingDTO> stockMissingDTO = new TreeSet<>();

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

        for (Object[] sap : stockModulaSAP) {
            StockMissingDTO dto = new StockMissingDTO();
            dto.setItemCode((String) sap[0]);
            dto.setItemName((String) sap[1]);
            dto.setQtySAP(0);
            dto.setQtyMDL(0);
            dto.setWhsCode((String) sap[3]);
            dto.setBinCode((String) sap[4]);
            dto.setWhsName((String) sap[5]);
            stockMissingDTO.add(dto);
        }

        for (StockRestDTO.ItemDTO.DetailDTO modula : stockModula) {
            StockMissingDTO dto = new StockMissingDTO();
            dto.setItemCode(modula.getItemCode());
            dto.setItemName(modula.getItemName());
            dto.setQtySAP(0);
            dto.setQtyMDL(0);
            dto.setBinCode("MODULA");
            dto.setWhsCode("30");
            dto.setWhsName("MODULA");
            stockMissingDTO.add(dto);
        }

        for (StockMissingDTO stock : stockMissingDTO) {
            for (StockRestDTO.ItemDTO.DetailDTO modula : stockModula) {
                if (stock.getItemCode().equals(modula.getItemCode())) {
                    stock.setQtyMDL(Integer.parseInt(modula.getStock().replace(",000", "")));
                    break;
                }
            }
            stock.setQtySAP(itemSAPFacade.listStockSAPModulaByItem(stock.getItemCode(), "IGB", false));
        }
        return Response.ok(stockMissingDTO).build();
    }
}
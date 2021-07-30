package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.modulaws.dto.item.StockMissingDTO;
import co.manager.modulaws.dto.item.StockRestDTO;
import co.manager.modulaws.dto.order.OrderExpModulaRestDTO;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.modulaws.ejb.StockModulaEJB;
import co.manager.persistence.facade.ItemSAPFacade;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.*;
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
    private OrderModulaEJB orderModulaEJB;
    @EJB
    private ItemSAPFacade itemSAPFacade;

    @GET
    @Path("stock-compare")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockModula() {
        CONSOLE.log(Level.INFO, "Iniciando comparacion de stock entre modula vs SAP");
        TreeSet<StockMissingDTO> stockMissingDTO = new TreeSet<>();

        //obtener stock del api
        List<StockRestDTO.ItemDTO.DetailDTO> stockModula = listStockModula();

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

    @GET
    @Path("validate-item/{itemcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response validateItem(@PathParam("itemcode") String itemCode) {
        CONSOLE.log(Level.INFO, "Iniciando servicio de validacion del item {0} en modula", itemCode);
        List<StockRestDTO.ItemDTO.DetailDTO> stockModula = listStockModula();

        if (stockModula.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "En modula no se encontraron datos para mostrar");
            return Response.ok(new ResponseDTO(-1, "En modula no se encontraron datos para mostrar.")).build();
        }

        for (StockRestDTO.ItemDTO.DetailDTO modula : stockModula) {
            if (itemCode.equals(modula.getItemCode())) {
                CONSOLE.log(Level.INFO, "El item {0} esta creado en modula", itemCode);
                return Response.ok(new ResponseDTO(0, "El item " + itemCode + " esta creado en modula.")).build();
            }
        }
        CONSOLE.log(Level.WARNING, "El item {0} no esta creado en modula", itemCode);
        return Response.ok(new ResponseDTO(-1, "El item no esta creado en modula.")).build();
    }

    @GET
    @Path("orders-completed")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrderCompleted() {
        CONSOLE.log(Level.INFO, "Listando ordenes procesadas en modula");


        OrderExpModulaRestDTO res = orderModulaEJB.listOrdineProcessed();


        return Response.ok(res).build();
    }

    @POST
    @Path("stock-deposit")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response depositStockToModula(OrderModulaDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando deposito de stock en modula");
        if (dto.getDocEntry() == null || dto.getDocEntry().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [DocNum] es obligatorio para lanzar peticion en modula");
            return Response.ok(new ResponseDTO(-2, "Campo [DocNum] es obligatorio para lanzar peticion en modula.")).build();
        } else if (dto.getDetail().size() <= 0) {
            CONSOLE.log(Level.WARNING, "Campo [detail] es obligatorio para lanzar peticion en modula");
            return Response.ok(new ResponseDTO(-2, "Campo [detail] es obligatorio para lanzar peticion en modula.")).build();
        } else if (dto.getType() == null || dto.getType().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Type] es obligatorio para lanzar peticion a modula");
            return Response.ok(new ResponseDTO(-2, "Campo [Type] es obligatorio para lanzar peticion a modula")).build();
        }

        String comment = dto.getType().equals("V") ? "Reabastecer articulo" : "";

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        String res = orderModulaEJB.addOrdine(dto, comment);
        if (res == null || res.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error depositando stock en modula");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error depositando stock en modula.")).build();
        }
        CONSOLE.log(Level.INFO, "Deposito de stock en modula exitoso");
        return Response.ok(new ResponseDTO(0, "Deposito de stock en modula exitoso.")).build();
    }

    @POST
    @Path("stock-inventory")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response inventoryStockModula(OrderModulaDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando inventario de stock en modula");
        if (dto.getDocEntry() == null || dto.getDocEntry().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [DocNum] es obligatorio para lanzar peticion en modula");
            return Response.ok(new ResponseDTO(-2, "Campo [DocNum] es obligatorio para lanzar peticion en modula.")).build();
        } else if (dto.getDetail().size() <= 0) {
            CONSOLE.log(Level.WARNING, "Campo [detail] es obligatorio para lanzar peticion en modula");
            return Response.ok(new ResponseDTO(-2, "Campo [detail] es obligatorio para lanzar peticion en modula.")).build();
        } else if (dto.getType() == null || dto.getType().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Type] es obligatorio para lanzar peticion a modula");
            return Response.ok(new ResponseDTO(-2, "Campo [Type] es obligatorio para lanzar peticion a modula")).build();
        }

        String comment = dto.getType().equals("I") ? "Inventariar articulo" : "";

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        String res = orderModulaEJB.addOrdine(dto, comment);
        if (res == null || res.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error inventariando articulo en modula");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error inventariando articulo en modula.")).build();
        }
        CONSOLE.log(Level.INFO, "Inventariando articulo en modula exitoso");
        return Response.ok(new ResponseDTO(0, "Inventariando articulo en modula exitoso.")).build();
    }

    private List<StockRestDTO.ItemDTO.DetailDTO> listStockModula() {
        List<StockRestDTO.ItemDTO.DetailDTO> stockModula = new ArrayList<>();

        //obtener stock del api
        StockRestDTO res = stockModulaEJB.getStock();
        if (res == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo datos del api modula");
            return new ArrayList<>();
        }
        //mapear datos obtenidos del api
        for (StockRestDTO.ItemDTO.DetailDTO obj : res.getItem().getDetails()) {
            StockRestDTO.ItemDTO.DetailDTO dto = new StockRestDTO.ItemDTO.DetailDTO();
            dto.setItemCode(obj.getItemCode());
            dto.setItemName(obj.getItemName());
            dto.setStock(obj.getStock());
            stockModula.add(dto);
        }
        return stockModula;
    }
}
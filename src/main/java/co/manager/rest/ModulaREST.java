package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.modulaws.dto.item.StockMissingDTO;
import co.manager.modulaws.dto.item.StockRestDTO;
import co.manager.modulaws.dto.order.OrderExpModulaRestDTO;
import co.manager.modulaws.dto.order.OrderModulaDTO;
import co.manager.modulaws.ejb.OrderModulaEJB;
import co.manager.modulaws.ejb.StockModulaEJB;
import co.manager.persistence.entity.ItemModula;
import co.manager.persistence.facade.ItemModulaFacade;
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
    @EJB
    private ItemModulaFacade itemModulaFacade;
    @EJB
    private SondaREST sondaREST;

    @GET
    @Path("stock-compare")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getStockModula(@HeaderParam("X-Company-Name") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando comparacion de stock entre modula vs SAP");
        TreeSet<StockMissingDTO> stockMissingDTO = new TreeSet<>();

        //obtener stock del api
        List<StockRestDTO.ItemDTO.DetailDTO> stockModula = listStockModula();
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
        //obtener stock de SAP almacen 30-modula
        List<Object[]> stockModulaSAP = itemSAPFacade.listStockSAPModula(companyName, false);
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

        for (StockMissingDTO stock : stockMissingDTO) {
            for (StockRestDTO.ItemDTO.DetailDTO modula : stockModula) {
                if (stock.getItemCode().equals(modula.getItemCode())) {
                    try {
                        stock.setQtyMDL(Integer.parseInt(modula.getStock().replace(".000", "")));
                    } catch (Exception e) {
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error convirtiendo el stock [" + modula.getStock() + "] del item " + modula.getItemCode(), e);
                    }
                    break;
                }
            }
            stock.setQtySAP(itemSAPFacade.listStockSAPModulaByItem(stock.getItemCode(), companyName, false));
        }

        List<StockMissingDTO> removeItem = new ArrayList<>();
        for (StockMissingDTO dto : stockMissingDTO) {
            if (dto.getQtySAP().equals(dto.getQtyMDL())) {
                removeItem.add(dto);
            }
        }

        for (StockMissingDTO dto : removeItem) {
            stockMissingDTO.remove(dto);
        }

        return Response.ok(stockMissingDTO).build();
    }

    @GET
    @Path("validate-item/{itemcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response validateItem(@PathParam("itemcode") String itemCode,
                                 @HeaderParam("X-Company-Name") String companyName,
                                 @HeaderParam("X-Pruebas") boolean testing) {
        CONSOLE.log(Level.INFO, "Iniciando servicio de validacion del item {0} en modula", itemCode);
        ItemModula entity = itemModulaFacade.find(itemCode, companyName, testing);

        if (entity != null) {
            CONSOLE.log(Level.INFO, "El item {0} esta creado en modula", itemCode);
            return Response.ok(new ResponseDTO(0, "El item " + itemCode + " esta creado en modula.")).build();
        } else {
            CONSOLE.log(Level.WARNING, "El item {0} no esta creado en modula", itemCode);
            return Response.ok(new ResponseDTO(-1, "El item no esta creado en modula.")).build();
        }
    }

    @GET
    @Path("orders-completed/{order}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listOrderCompleted(@PathParam("order") String docNum) {
        CONSOLE.log(Level.INFO, "Listando ordenes procesadas en el wms de modula");
        List<OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO> ordersCompleted = listOrdersModula();

        if (ordersCompleted.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "En modula no se encontraron ordenes completadas.");
            return Response.ok(new ResponseDTO(-1, "En modula no se encontraron ordenes completadas.")).build();
        }

        for (OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO dto : ordersCompleted) {
            if (dto.getDocNum().equals(docNum)) {
                return Response.ok(true).build();
            }
        }
        return Response.ok(false).build();
    }

    @POST
    @Path("stock-deposit")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response depositStockToModula(OrderModulaDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando deposito de stock en modula");
        if (dto.getDocNum() == null || dto.getDocNum().isEmpty()) {
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
        if (dto.getDocNum() == null || dto.getDocNum().isEmpty()) {
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

    @GET
    @Path("replicate-item/{itemCode}/{minStock}/{maxStock}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response replicateItemModula(@PathParam("itemCode") String itemCode,
                                        @PathParam("minStock") Integer minStock,
                                        @PathParam("maxStock") Integer maxStock) {
        CONSOLE.log(Level.INFO, "Iniciando sincronizacion de item en modula con actualizacion de stocks");
        /***1. Actualizar stock mínimo y stock máximo para la bodega 30 en IGB***/
        try {
            itemSAPFacade.updateStocksItemByWarehouse(itemCode, minStock, maxStock, "30", "IGB", false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando los stocks para el item {0}", itemCode);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error actualizando los stocks.")).build();
        }
        /***2. Actualizar estado Y en la propiedad Replicar a Modula en el maestro de items***/
        try {
            itemSAPFacade.updateFieldSyncModula(itemCode, "Y", "IGB", false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el check [replicar a modula] para el item {0}", itemCode);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error actualizando el check para replicar a modula.")).build();
        }
        /***3. Eliminar registro existente en la tabla temporal [itemModula] en WMS***/
        try {
            itemModulaFacade.remove(itemCode, "IGB", false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error eliminando el registro temporal para el item {0}", itemCode);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error eliminando el registro temporal.")).build();
        }
        /***4. Lanzar servicio de sincronización automatica***/
        sondaREST.syncItemsModula("IGB", false);

        CONSOLE.log(Level.INFO, "Finalizando sincronizacion de item en modula.");
        return Response.ok(new ResponseDTO(0, "Sincronización exitosa.")).build();
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

    private List<OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO> listOrdersModula() {
        List<OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO> orderModula = new ArrayList<>();

        //obtener stock del api
        OrderExpModulaRestDTO res = orderModulaEJB.listOrdineProcessed();
        if (res == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error obteniendo datos del api modula");
            return new ArrayList<>();
        }

        //mapear datos obtenidos del api
        for (OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO obj : res.getOrder().getHeader()) {
            OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO dto = new OrderExpModulaRestDTO.OrderExpRestDTO.HeaderDTO();
            dto.setDocNum(obj.getDocNum());
            dto.setType(obj.getType());
            orderModula.add(dto);
        }

        return orderModula;
    }
}
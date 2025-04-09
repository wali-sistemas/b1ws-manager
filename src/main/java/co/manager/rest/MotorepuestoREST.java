package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.*;
import co.manager.persistence.entity.OrderDetailPedbox;
import co.manager.persistence.entity.OrderPedbox;
import co.manager.persistence.facade.*;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("motorepuesto")
public class MotorepuestoREST {
    private static final Logger CONSOLE = Logger.getLogger(MotorepuestoREST.class.getSimpleName());

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;
    @EJB
    private BasicFunctions basicFunctions;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private PurchaseInvoicesEJB purchaseInvoicesEJB;
    @EJB
    private InvoiceSAPFacade invoiceSAPFacade;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;
    @EJB
    private SalesPersonSAPFacade salesPersonSAPFacade;
    @EJB
    private SalesOrderEJB salesOrderEJB;
    @EJB
    private OrderPedboxFacade orderPedboxFacade;
    @EJB
    private OrderDetailPedboxFacade orderDetailPedboxFacade;

    @GET
    @Path("items")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listItemMaster() {
        CONSOLE.log(Level.INFO, "Iniciando servicio item master de motorepuesto.");
        List<Object[]> objects = itemSAPFacade.listItemMasterMotorepuesto();

        if (objects == null || objects.size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error listando el item master de motorepuesto.");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error listando el items master de motorepuesto.")).build();
        }

        List<ItemMotorepuestoDTO> items = new ArrayList<>();
        for (Object[] obj : objects) {
            ItemMotorepuestoDTO dto = new ItemMotorepuestoDTO();
            dto.setItemCode((String) obj[0]);
            dto.setPresentation((String) obj[1]);
            dto.setIva((Integer) obj[2]);
            dto.setWhsCode((String) obj[3]);
            dto.setStock((Integer) obj[4] < 0 ? 0 : (Integer) obj[4]);
            dto.setPictureUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/motorepuesto/" + obj[5]);
            dto.setPictureMarcaUrl(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/motorepuesto/" + obj[7] + ".jpg");
            dto.setCategory((String) obj[6]);
            dto.setMarca((String) obj[7]);
            dto.setSubMarca((String) obj[8]);
            dto.setGrupo((String) obj[9]);
            dto.setSubgrupo((String) obj[10]);
            dto.setModeloMoto((String) obj[11]);
            dto.setTipoLlanta((String) obj[12]);
            dto.setAnchoLlanta((String) obj[13]);
            dto.setPerfilLlanta((String) obj[14]);
            dto.setRinLlanta((String) obj[15]);
            dto.setTalla((String) obj[16]);
            dto.setColorCadena((String) obj[17]);
            dto.setPasoCadena((String) obj[18]);
            dto.setViscosidad((String) obj[19]);
            dto.setBase((String) obj[20]);
            dto.setItemType((String) obj[21]);
            dto.setKeyword((String) obj[22]);
            dto.setParent(obj[23] != null ? true : false);
            dto.setItemParent((String) obj[23]);
            dto.setItemNameParent((String) obj[24]);
            dto.setNomWeb((String) obj[25]);
            dto.setPriceVenta((BigDecimal) obj[26]);
            dto.setPricePromo((BigDecimal) obj[27]);
            dto.setDescripcionLarga((String) obj[28]);
            dto.setUltimasOfertas((String) obj[29]);
            items.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando el item master de motorepuesto.");
        return Response.ok(new ResponseDTO(0, items)).build();
    }

    @GET
    @Path("purchase/create-invoice")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createPurchaseInvoice(@QueryParam("docnum") String docNum,
                                          @HeaderParam("X-Company-Name") String companyName,
                                          @HeaderParam("X-Employee") String userName,
                                          @HeaderParam("X-Pruebas") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Iniciando creacion de factura de compra para la venta # {0} realizada en [{1}]", new Object[]{docNum, companyName});

        List<Object[]> details = invoiceSAPFacade.listDetailInvoice(docNum, companyName, pruebas);
        if (details.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos de la FV# {0} para crear la factura de compra", docNum);
            return Response.ok(new ResponseDTO(-2, "No se encontraron datos de la FV [" + docNum + "] para crear la factura de compra.")).build();
        }
        return Response.ok(purchaseInvoicesEJB.createPurchaseInvoice(details, docNum, companyName)).build();
    }

    @POST
    @Path("create-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(BusinessPartnerDTO dto) {
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente. Campo companyName es obligatorio.")).build();
        } else if (dto.getDocument() == null || dto.getDocument().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo document es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo document es obligatorio.")).build();
        } else if (dto.getTypeDoc() == null || dto.getTypeDoc().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo typeDoc es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo typeDoc es obligatorio.")).build();
        } else if (dto.getFirstname() == null || dto.getFirstname().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo firstname es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo firstname es obligatorio.")).build();
        } else if (dto.getLastname1() == null || dto.getLastname1().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo lastname1 es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo lastname1 es obligatorio.")).build();
        } else if (dto.getPhone() == null || dto.getPhone().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo phone es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo phone es obligatorio.")).build();
        } else if (dto.getCellular() == null || dto.getCellular().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cellular es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo cellular es obligatorio.")).build();
        } else if (dto.getMail() == null || dto.getMail().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo mail es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo mail es obligatorio.")).build();
        } else if (dto.getCodDepartamento() == null || dto.getCodDepartamento().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo codDepartamento es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo codDepartamento es obligatorio.")).build();
        } else if (dto.getCodMunicipio() == null || dto.getCodMunicipio().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo codMunicipio es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo codMunicipio es obligatorio.")).build();
        } else if (dto.getAddress() == null || dto.getAddress().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo address es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo address es obligatorio.")).build();
        } else if (dto.getAcceptHabeasData() == null || dto.getAcceptHabeasData().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo acceptHabeasData es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo acceptHabeasData es obligatorio.")).build();
        } else if (dto.getPhone().length() > 10) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo phone excede el tamaño permitido", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo phone es obligatorio.")).build();
        } else if (dto.getCellular().length() > 10) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el cliente para {0}. Campo cellular excede el tamaño permitido", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear el cliente para " + dto.getCompanyName() + " .Campo cellular es obligatorio.")).build();
        }

        //Validar si ya existe el cliente en SAP.
        Object[] res = businessPartnerSAPFacade.findCustomer("C" + dto.getDocument(), dto.getCompanyName(), false);
        if ((Boolean) res[0]) {
            CONSOLE.log(Level.INFO, "El cliente ya existe en SAP con el id {0}", "C" + dto.getDocument());
            return Response.ok(new ResponseDTO(1, "C" + dto.getDocument())).build();
        }

        CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en " + dto.getCompanyName(), dto.toString());

        int digito = basicFunctions.getDigitoDian(dto.getDocument());

        dto.setLicTradNum(dto.getDocument() + "-" + digito);
        dto.setCardCode("C" + dto.getDocument());
        dto.setCardName(dto.getLastname1().toUpperCase() + " " + dto.getLastname2().toUpperCase() + " " + dto.getFirstname().toUpperCase());
        //dto.setLicTradNum(dto.getCardCode().replace("C", ""));

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        return Response.ok(businessPartnerEJB.createBusinessPartnerFromEcommerce(dto)).build();
    }

    @POST
    @Path("create-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesB2CorderDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando creacion de orden de venta para " + dto.getCompanyName());
        /**** 1.Validar si ya existe la orden en SAP por idPedBox campo NumAtCard****/
        if (dto.getNumAtCard() == null || dto.getNumAtCard().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo numAtCard es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo numAtCard es obligatorio.")).build();
        } else {
            Integer docNum = salesOrderSAPFacade.getDocNumOrderByNumAtCard(dto.getNumAtCard(), dto.getCompanyName(), false);
            if (docNum != 0) {
                CONSOLE.log(Level.INFO, "La orden ya existe en SAP con el id {0}", docNum);
                return Response.ok(new ResponseDTO(0, docNum)).build();
            }
        }
        /**** 2.Validar campos obligatorios para creación de orden de venta****/
        if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo cardCode es obligatorio.")).build();
        } else if (dto.getDetailSalesOrder().size() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo detailSalesOrder es obligatorio.")).build();
        } else if (dto.getSlpCode() == null || dto.getSlpCode() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo slpCode es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo slpCode es obligatorio.")).build();
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo status es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo status es obligatorio.")).build();
        } else if (dto.getConfirmed() == null || dto.getConfirmed().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo confirmed es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo confirmed es obligatorio.")).build();
        } else if (dto.getDocTotal() == null || dto.getDocTotal() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo docTotal es obligatorio", dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo docTotal es obligatorio.")).build();
        }
        /**** 3.Asignar valores predeterminados a la orden****/
        dto.setStatus("APROBADO");
        dto.setConfirmed("Y");
        dto.setDocTotal(dto.getDocTotal());
        /**** 4.Consultando código de transportadora asignada al cliente****/
        dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
        /**** 5.Consultando por cliente el id de la dirección de factura****/
        String shipToCodeDefault = null;
        List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
        if (idAddress.size() > 0) {
            for (Object[] obj : idAddress) {
                shipToCodeDefault = (String) obj[0];
                dto.setPayToCode((String) obj[1]);
            }
        }
        if (dto.getShipToCode().equals("0")) {
            dto.setShipToCode(shipToCodeDefault);
        }

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        CONSOLE.log(Level.INFO, json);

        /**** 6.Crear orden directamente en cedi solo para MTZ, MOTOREPUESTOS, IGB(solo llantas y cliente C900998242), wms-Modula(apagada)****/
        ResponseDTO res = salesOrderEJB.createSalesOrderB2C(dto);
        if (res.getCode() == 0) {
            return Response.ok(res).build();
        } else {
            /**** 6.1.Creando registro en tabla temporal solo para ordenes con estado error para retornar de nuevo a PEDBOX****/
            return Response.ok(createOrderTemporary(dto, 0)).build();
        }
    }

    @POST
    @Path("create-payments")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createIncomingPayments(BusinessPartnerDTO dto) {
        dto.setLicTradNum(dto.getCardCode().replace("C", ""));
        return Response.ok(businessPartnerEJB.createBusinessPartnerFromEcommerce(dto)).build();
    }

    private ResponseDTO createOrderTemporary(SalesB2CorderDTO dto, Integer docNum) {
        OrderPedbox order = new OrderPedbox();
        OrderDetailPedbox detail = new OrderDetailPedbox();

        order.setDocNum(docNum);
        order.setDocDate(new Date());
        order.setCardCode(dto.getCardCode());
        order.setNumAtCard(dto.getNumAtCard());
        order.setComments(dto.getComments());
        order.setSlpCode(dto.getSlpCode().toString());
        order.setStatus("F");
        order.setCompanyName(dto.getCompanyName());
        order.setDocTotal(dto.getDocTotal());
        try {
            orderPedboxFacade.create(order, dto.getCompanyName(), false);
        } catch (Exception ex) {
        }

        for (DetailSalesB2CorderDTO dt : dto.getDetailSalesOrder()) {
            Object[] stockCurrent = itemSAPFacade.getStockItemMDLvsSAPvsSBT(dt.getItemCode(), dt.getWhsCode(), dto.getCompanyName(), false);

            detail.setIdOrder(order);
            detail.setIdOrderDetail(0);
            detail.setItemCode(dt.getItemCode());
            detail.setWhsCode(dt.getWhsCode());
            detail.setQtyAPP(dt.getQuantity());
            detail.setQtyMDL((Integer) stockCurrent[0]);
            detail.setQtySAP((Integer) stockCurrent[1]);
            detail.setQtySBT((Integer) stockCurrent[2]);
            try {
                orderDetailPedboxFacade.create(detail, dto.getCompanyName(), false);
            } catch (Exception ex) {
            }
        }

        return new ResponseDTO(0, order.getIdOrder());
    }
}
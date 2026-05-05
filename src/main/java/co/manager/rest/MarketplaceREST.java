package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.BasicFunctions;
import co.manager.ejb.BusinessPartnerEJB;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.ejb.SalesOrderEJB;
import co.manager.persistence.entity.OrderDetailPedbox;
import co.manager.persistence.entity.OrderPedbox;
import co.manager.persistence.facade.*;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.ejb.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
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
@Path("marketplace")
public class MarketplaceREST {
    private static final Logger CONSOLE = Logger.getLogger(MarketplaceREST.class.getSimpleName());
    private boolean orderCompleted = true;

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private BasicFunctions basicFunctions;
    @EJB
    private BusinessPartnerEJB businessPartnerEJB;
    @EJB
    private SalesOrderEJB salesOrderEJB;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private SalesOrderSAPFacade salesOrderSAPFacade;
    @EJB
    private SalesPersonSAPFacade salesPersonSAPFacade;
    @EJB
    private OrderPedboxFacade orderPedboxFacade;
    @EJB
    private OrderDetailPedboxFacade orderDetailPedboxFacade;

    @GET
    @Path("virtual-llantas/items/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listMechanicsByClient(@PathParam("companyname") String companyName,
                                          @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_VIRTUAL_LLANTAS)) || token.isEmpty()) {
            List<Object[]> objects = itemSAPFacade.getListItemsExtranet("0", companyName, "false", "virtual-llantas", false);

            List<ItemExtranetDTO> items = new ArrayList<>();
            for (Object[] obj : objects) {
                ItemExtranetDTO dto = new ItemExtranetDTO();
                dto.setItemCode((String) obj[0]);
                dto.setItemName((String) obj[1]);
                //TODO: Modificar hasta que compras termine el proyecto de unidad de empaque.
                dto.setPresentation((String) obj[2]);
                dto.setPrice((BigDecimal) obj[3]);
                dto.setIva((Integer) obj[4]);
                dto.setWhsCode((String) obj[5]);
                dto.setStock((Integer) obj[6] < 0 ? 0 : (Integer) obj[6]);
                dto.setDiscountItem(0);
                dto.setDiscountPorc(0);
                dto.setPictureUrl("http://wali.igbcolombia.com:8080/shared/images/mtz/" + obj[7]);
                //filtros para extranet
                dto.setModeloMoto((String) obj[8]);
                dto.setTipoLlanta((String) obj[9]);
                dto.setAnchoLlanta((String) obj[10]);
                dto.setPerfilLlanta((String) obj[11]);
                dto.setRinLlanta((String) obj[12]);
                dto.setTalla((String) obj[13]);
                dto.setCategoria((String) obj[14]);
                dto.setGrupo((String) obj[15]);
                dto.setSubgrupo((String) obj[16]);
                dto.setMarca((String) obj[17]);
                dto.setViscosidad((String) obj[18]);
                dto.setBase((String) obj[19]);

                items.add(dto);
            }

            return Response.ok(new ResponseDTO(0, items)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @POST
    @Path("virtual-llantas/create-customer")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createCustomer(BusinessPartnerDTO dto,
                                   @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_VIRTUAL_LLANTAS)) || token.isEmpty()) {
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
                return Response.ok(new ResponseDTO(0, "C" + dto.getDocument())).build();
            }

            CONSOLE.log(Level.INFO, "Iniciando creacion de cliente en " + dto.getCompanyName(), dto.toString());

            int digito = basicFunctions.getDigitoDian(dto.getDocument());

            dto.setLicTradNum(dto.getDocument() + "-" + digito);
            dto.setCardCode("C" + dto.getDocument());
            dto.setCardName(dto.getLastname1().toUpperCase() + " " + dto.getLastname2().toUpperCase() + " " + dto.getFirstname().toUpperCase());

            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);

            return Response.ok(businessPartnerEJB.createBusinessPartnerFromEcommerce(dto)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @POST
    @Path("virtual-llantas/create-order")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createOrderSale(SalesOrderDTO dto,
                                    @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_VIRTUAL_LLANTAS)) || token.isEmpty()) {
            ResponseDTO res = new ResponseDTO();
            /**** 1. Validar si ya existe la orden en SAP por idPedBox campo NumAtCard****/
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
            /**** 2. Validar campos obligatorios para creación de orden de venta****/
            if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio");
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta. Campo companyName es obligatorio.")).build();
            } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo cardCode es obligatorio", dto.getCompanyName());
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo cardCode es obligatorio.")).build();
            } else if (dto.getDetailSalesOrder().size() <= 0) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo detailSalesOrder es obligatorio", dto.getCompanyName());
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo detailSalesOrder es obligatorio.")).build();
            } else if (dto.getDocTotal() == null || dto.getDocTotal() <= 0) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden de venta para {0}. Campo docTotal es obligatorio", dto.getCompanyName());
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al crear la orden de venta para " + dto.getCompanyName() + ". Campo docTotal es obligatorio.")).build();
            }

            dto.setStatus("REVISAR");
            dto.setConfirmed("N");
            dto.setDiscountPercent(10.0);
            dto.setSlpCode(159L);
            /**** 3. Consultando el centro de costo por asesor de venta****/
            String ocrCode = "590";
            dto.getDetailSalesOrder().get(0).setOcrCode(ocrCode);
            /**** 4. Consultando código de transportadora asignada al cliente****/
            dto.setIdTransport(businessPartnerSAPFacade.getTransportCustomer(dto.getCardCode(), dto.getCompanyName(), false));
            /**** 5. Consultando por cliente el id de la dirección de factura****/
            String shipToCodeDefault = null;
            List<Object[]> idAddress = businessPartnerSAPFacade.findIdAddress(dto.getCardCode(), dto.getCompanyName(), false);
            if (idAddress.size() > 0) {
                for (Object[] obj : idAddress) {
                    shipToCodeDefault = (String) obj[0];
                    dto.setPayToCode((String) obj[1]);
                }
            }
            dto.setShipToCode(shipToCodeDefault);

            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);

            /**** 6. Separación de items para crear ordenes independientes - Llantas - (*) - (**) ****/
            List<DetailSalesOrderDTO> detailSalesOrderWS = dto.getDetailSalesOrder();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cali = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_one_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_two_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cali_combo = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cart = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_one_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_two_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_cart_combo = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_link = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_link_one_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_link_two_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_link_combo = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_bog = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_one_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_two_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_bog_combo = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_med = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_med_one_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_med_two_asterisk = new ArrayList<>();
            List<DetailSalesOrderDTO> detailSalesOrder_LL_med_combo = new ArrayList<>();

            String numAtCard = dto.getNumAtCard();
            res = new ResponseDTO();

            orderCompleted = true;

            /**** 7. Crear orden directamente en cedi solo para: motorepuestos.co - REDPLAS ****/
            for (DetailSalesOrderDTO detail : detailSalesOrderWS) {
                if (dto.getCompanyName().contains("IGB")) {
                    if (detail.getGroup().equals("LLANTAS")) {
                        if (detail.getWhsCode().equals("05")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cart_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_cart_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_cart_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cart.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("26")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_cali_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_cali_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_cali_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_cali.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("35")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_bog_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_bog_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_bog_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_bog.add(setDetailOrder(detail, ocrCode));
                            }
                        } else if (detail.getWhsCode().equals("60")) {
                            if (detail.getItemName().substring(0, 3).equals("(*)")) {
                                detailSalesOrder_LL_med_one_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 4).equals("(**)")) {
                                detailSalesOrder_LL_med_two_asterisk.add(setDetailOrder(detail, ocrCode));
                            } else if (detail.getItemName().substring(0, 5).equals("COMBO")) {
                                detailSalesOrder_LL_med_combo.add(setDetailOrder(detail, ocrCode));
                            } else {
                                detailSalesOrder_LL_med.add(setDetailOrder(detail, ocrCode));
                            }
                        }
                    }
                }
            }
            /**** 8.Crear ordenes separadas por regla de negocio ****/
            /**** 8.1. Solo llantas link con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_link_one_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_link_one_asterisk);
                    dto.setNumAtCard(numAtCard + "LL13D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (*). Orden Temp={0}", response.getContent());
                        res = response;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.2. Solo llantas link con (**) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_link_two_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_link_two_asterisk);
                    dto.setNumAtCard(numAtCard + "LL13D2");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (**). Orden Temp={0}", response.getContent());
                        res = response;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.3. Solo llantas link con (combo) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_link_combo.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_link_combo);
                    dto.setNumAtCard(numAtCard + "LL13DC");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.4. Solo llantas link ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_link.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_link);
                    dto.setNumAtCard(numAtCard + "LL13");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de link. Orden Temp={0}", response.getContent());
                        res = response;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.5. Solo llantas de cali con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cali_one_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cali_one_asterisk);
                    dto.setNumAtCard(numAtCard + "LL26D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.6. Solo llantas de cali con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cali_two_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cali_two_asterisk);
                    dto.setNumAtCard(numAtCard + "LL26D2");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.7. Solo llantas de cali con (combo) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cali_combo.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cali_combo);
                    dto.setNumAtCard(numAtCard + "LL26DC");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.8. Solo llantas de cartagena con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cart_one_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cart_one_asterisk);
                    dto.setNumAtCard(numAtCard + "LL05D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.9. Solo llantas de cartagena con (**) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cart_two_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cart_two_asterisk);
                    dto.setNumAtCard(numAtCard + "LL05D2");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.10. Solo llantas de cartagena con (combo) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cart_combo.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cart_combo);
                    dto.setNumAtCard(numAtCard + "LL05DC");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.11. Solo llantas de bogotá con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_bog_one_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_bog_one_asterisk);
                    dto.setNumAtCard(numAtCard + "LL35D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.12. Solo llantas de bogotá con (**) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_bog_two_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_bog_two_asterisk);
                    dto.setNumAtCard(numAtCard + "LL35D2");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (**). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.13. Solo llantas de bogotá con (combo) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_bog_combo.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_bog_combo);
                    dto.setNumAtCard(numAtCard + "LL35DC");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.14. Solo llantas de medellín con (*) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_med_one_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_med_one_asterisk);
                    dto.setNumAtCard(numAtCard + "LL60D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.15. Solo llantas de medellín con (**) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_med_two_asterisk.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_med_two_asterisk);
                    dto.setNumAtCard(numAtCard + "LL60D1");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (*). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.16. Solo llantas de medellín con (combo) ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_med_combo.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_med_combo);
                    dto.setNumAtCard(numAtCard + "LL60DC");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín con (combo). Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.17. Solo llantas de cali ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cali.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cali);
                    dto.setNumAtCard(numAtCard + "LL26");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cali. Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.18. Solo llantas de cartagena ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_cart.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_cart);
                    dto.setNumAtCard(numAtCard + "LL05");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Cartagena. Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.19. Solo llantas de bogotá ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_bog.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_bog);
                    dto.setNumAtCard(numAtCard + "LL35");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Bogotá. Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            /**** 8.20. Solo llantas de medellín ****/
            if (orderCompleted) {
                if (detailSalesOrder_LL_med.size() > 0) {
                    dto.setDetailSalesOrder(new ArrayList<>());
                    dto.setDetailSalesOrder(detailSalesOrder_LL_med);
                    dto.setNumAtCard(numAtCard + "LL60");
                    dto.setSerialMDL("");

                    res = salesOrderEJB.createSalesOrderByApp(dto);
                    if (res.getCode() < 0) {
                        ResponseDTO response = createOrderTemporary(dto, 0);

                        gson = new Gson();
                        json = gson.toJson(dto);
                        CONSOLE.log(Level.INFO, json);
                        CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items solo LLantas de Medellín. Orden Temp={0}", response.getContent());
                        res = response;
                        orderCompleted = false;
                    } else {
                        orderCompleted = true;
                    }
                }
            } else {
                return Response.ok(res).build();
            }
            //TODO: crear orden temporal, si no clasifico bien los articulos
            if (res.getContent() == null) {
                ResponseDTO response = createOrderTemporary(dto, 0);
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear la orden para items. Orden Temp={0}", response.getContent());
                res = response;
                orderCompleted = false;
            }
            CONSOLE.log(Level.INFO, "Retornando ordenes creadas para la empresa [{0}]", dto.getCompanyName());
            return Response.ok(res).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("virtual-llantas/tracking-order/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getTrackingOrder(@PathParam("companyname") String companyName,
                                     @QueryParam("docnum") String docNum,
                                     @HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_VIRTUAL_LLANTAS)) || token.isEmpty()) {
            if (docNum == null || docNum.isEmpty() || docNum.equals("0")) {
                CONSOLE.log(Level.WARNING, "Debe ingresar un numero de orden para continuar con la consulta.");
                return Response.ok(new ResponseDTO(-1, "Debe ingresar un número de orden para continuar con la consulta.")).build();
            }

            Object[] obj = salesOrderSAPFacade.getDetailTrackingByOrder(docNum, companyName, false);
            if (obj == null) {
                CONSOLE.log(Level.WARNING, "No se encontraron datos para mostrar.");
                return Response.ok(new ResponseDTO(-1, "No se encontraron datos para mostrar.")).build();
            }

            DetailTrackingInvoiceDTO dto = new DetailTrackingInvoiceDTO();
            dto.setOrder((String) obj[0]);
            dto.setDocDateOrder(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[1]));
            dto.setStatusOrder((String) obj[2]);
            dto.setDocDueDateOrder(new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[3]));
            dto.setInvoice((String) obj[4]);
            dto.setDocDateInvoice(obj[5] != null ? new SimpleDateFormat("yyyy-MM-dd").format((Date) obj[5]) : null);
            dto.setTransport((String) obj[6]);
            dto.setGuia((String) obj[7]);
            dto.setStatusInvoice((String) obj[8]);
            dto.setUrlTracking((String) obj[9]);

            return Response.ok(dto).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    private DetailSalesOrderDTO setDetailOrder(DetailSalesOrderDTO detail, String ocrCode) {
        DetailSalesOrderDTO detailDTO = new DetailSalesOrderDTO();
        detailDTO.setItemCode(detail.getItemCode());
        detailDTO.setQuantity(detail.getQuantity());
        detailDTO.setWhsCode(detail.getWhsCode());
        detailDTO.setOcrCode(ocrCode);
        detailDTO.setBaseLine(detail.getBaseLine());
        detailDTO.setBaseEntry(detail.getBaseEntry());
        detailDTO.setBaseType(detail.getBaseType());
        return detail;
    }

    private ResponseDTO createOrderTemporary(SalesOrderDTO dto, Integer docNum) {
        /****Registrar pedido en tablas temporales****/
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

        for (DetailSalesOrderDTO dt : dto.getDetailSalesOrder()) {
            /****Consultado stock actual en SAP - MODULA - SBT y CEDI****/
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
        CONSOLE.log(Level.INFO, "Se creo la orden temporal satisfactoriamente. idOrden={0} en la empresa {1}", new Object[]{order.getIdOrder(), dto.getCompanyName()});
        return new ResponseDTO(0, order.getIdOrder());
    }
}
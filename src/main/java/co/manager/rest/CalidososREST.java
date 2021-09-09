package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.IncomingPaymentEJB;
import co.manager.ejb.ManagerApplicationBean;
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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("calidosos")
public class CalidososREST {
    private static final Logger CONSOLE = Logger.getLogger(CalidososREST.class.getSimpleName());

    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private ConceptoSAPFacade conceptoSAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;
    @EJB
    private VendedorMostradorSAPFacade vendedorMostradorSAPFacade;
    @EJB
    private RedimeProductoSAPFacade redimeProductoSAPFacade;
    @EJB
    private RedimePuntosSAPFacade redimePuntosSAPFacade;
    @EJB
    private IncomingPaymentEJB incomingPaymentEJB;

    @GET
    @Path("programas")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listActivePrograms(@HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            return Response.ok(conceptoSAPFacade.listActivePrograms("IGB", false)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("sucursales")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listActiveClients(@HeaderParam("X-TOKEN") String token) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            return Response.ok(businessPartnerSAPFacade.listClientCalidosos("IGB", false)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("productos")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response ListProducts(@HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Iniciando servicio de listar productos a redimir en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            List<Object[]> objects = redimeProductoSAPFacade.listActiveProducts("IGB", false);

            List<ProductCalidosoDTO> products = new ArrayList<>();
            for (Object[] obj : objects) {
                ProductCalidosoDTO dto = new ProductCalidosoDTO();
                dto.setItemCode((String) obj[0]);
                dto.setItemName((String) obj[1]);
                dto.setDescription((String) obj[2]);
                dto.setPrice((BigDecimal) obj[3]);
                dto.setUrlPhoto(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED_HTTPS) + "images/calidosos/" + obj[4]);
                dto.setCondiction((String) obj[5]);
                dto.setAliado((String) obj[6]);
                products.add(dto);
            }
            CONSOLE.log(Level.INFO, "Retornando lista de productos activos a redimir en los calidosos");
            return Response.ok(products).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("historial-puntos")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getHistoryPointsOfCustomer(@QueryParam("cardCode") String cardCode,
                                               @HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Listando historial de puntos por clientes en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            List<Object[]> objects = businessPartnerSAPFacade.listHistoryPointsCalidosos(cardCode, "IGB", false);

            if (objects.size() <= 0) {
                CONSOLE.log(Level.WARNING, "No se encontro historico de puntos en los calidosos para {0}", cardCode);
                return Response.ok(new ResponseDTO(-1, "No se encontro historico de puntos en los calidosos para " + cardCode)).build();
            }
            if (objects == null) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el historico de puntos en los calidosos para {0}", cardCode);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el historico de puntos en los calidosos para " + cardCode)).build();
            }

            List<PointHistoryCalidosoDTO> pointHistoryCalidosoDTO = new ArrayList<>();
            for (Object[] obj : objects) {
                PointHistoryCalidosoDTO dto = new PointHistoryCalidosoDTO();
                dto.setCardCode((String) obj[0]);
                dto.setConcept((String) obj[1]);
                dto.setDocNum((Integer) obj[2]);
                dto.setDocType((String) obj[3]);
                dto.setDocDate((String) obj[4]);
                dto.setPoint((Integer) obj[5]);

                pointHistoryCalidosoDTO.add(dto);
            }

            CONSOLE.log(Level.INFO, "Retornando historico de puntos en los calidosos.");
            return Response.ok(new ResponseDTO(0, pointHistoryCalidosoDTO)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("total-registros")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getProgramsCount(@HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Listando total de registros en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            return Response.ok(conceptoSAPFacade.countNumberRegister("IGB", false)).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("data-login")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getDataLogin(@HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Iniciando servicio de listando datos para login en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            List<Object[]> objs = vendedorMostradorSAPFacade.listDataLoginCalidoso("IGB", false);
            List<LoginCalidosoDTO> data = new ArrayList<>();

            for (Object[] obj : objs) {
                LoginCalidosoDTO dto = new LoginCalidosoDTO();
                dto.setDocumento((String) obj[0]);
                dto.setPrograma((String) obj[1]);
                dto.setMail((String) obj[2]);
                dto.setCelular((String) obj[3]);
                dto.setNombre((String) obj[4]);

                data.add(dto);
            }
            CONSOLE.log(Level.INFO, "Retornando listando datos para login en los calidosos");
            return Response.ok(data).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("disponible-puntos")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getAvailablePoints(@QueryParam("cardCode") String cardCode,
                                       @HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Iniciando listando puntos disponibles en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            List<PointAvailableCalidosoDTO> availablePoints = new ArrayList<>();
            List<Object[]> objs = redimePuntosSAPFacade.listAvailablePoints(cardCode, "IGB", false);
            for (Object[] obj : objs) {
                PointAvailableCalidosoDTO dto = new PointAvailableCalidosoDTO();
                dto.setCardCode((String) obj[0]);
                dto.setConcept((String) obj[1]);
                dto.setPoint((Integer) obj[2]);

                availablePoints.add(dto);
            }
            CONSOLE.log(Level.INFO, "Retornando listando puntos disponibles en los calidosos");
            return Response.ok(availablePoints).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @GET
    @Path("cliente/vendedores-mostrador")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listVendedorMostradorByClient(@QueryParam("cardCode") String cardCode,
                                                  @HeaderParam("X-TOKEN") String token) {
        CONSOLE.log(Level.INFO, "Iniciando listando de vendedores mostrador por cliente en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            List<Object[]> objects = vendedorMostradorSAPFacade.listVendMostradorByClient(cardCode, "IGB", false);
            List<ClientVendMortradorDTO> clientVendMortradorDTO = new ArrayList<>();

            HashMap<String, String> client = new HashMap<>();
            for (Object[] obj : objects) {
                client.put((String) obj[0], "id");
            }

            for (String sn : client.keySet()) {
                List<ClientVendMortradorDTO.VendMostradorDTO> vendedoresMostrador = new ArrayList<>();
                ClientVendMortradorDTO dto = new ClientVendMortradorDTO();
                dto.setClient(sn);

                for (Object[] obj : objects) {
                    if (dto.getClient().equals(obj[0])) {
                        //Clientes
                        dto.setClient((String) obj[0]);
                        //Vendedores Mostrador
                        ClientVendMortradorDTO.VendMostradorDTO dto2 = new ClientVendMortradorDTO.VendMostradorDTO();
                        dto2.setNro((Integer) obj[1]);
                        dto2.setVendMostrador((String) obj[2]);
                        dto2.setNombre(obj[3] + " " + obj[4]);
                        dto2.setCorreo((String) obj[5]);
                        dto2.setCelular((String) obj[6]);
                        dto2.setCiudad((String) obj[7]);
                        dto2.setDepartamento((String) obj[8]);
                        vendedoresMostrador.add(dto2);
                    }
                }
                dto.setVendedoresMostrador(vendedoresMostrador);
                clientVendMortradorDTO.add(dto);
            }
            CONSOLE.log(Level.INFO, "Retornando el listado de vendedores mostrador para el cliente {0}", cardCode);
            return Response.ok(clientVendMortradorDTO).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @POST
    @Path("add-vendedor-mostrador")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addVendedorMostrador(@HeaderParam("X-TOKEN") String token,
                                         VendedorMostradorDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando un nuevo registro de vendedor mostrador en los calidosos");
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            if (dto.getDocumento() == null || dto.getDocumento().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Documento] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo Documento es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getNombres() == null || dto.getNombres().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Nombres] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo Nombres es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getApellidos() == null || dto.getApellidos().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Apellidos] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo Apellidos es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getCorreo() == null || dto.getCorreo().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Correo] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo Correo es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getCelular() == null || dto.getCelular().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Celular] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo Celular es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getAceptoTermino() <= 0 || dto.getAceptoTratamientoDatos() <= 0) {
                CONSOLE.log(Level.WARNING, "Debe aceptar terminos de condiciones para participar en los calidoso");
                return Response.ok(new ResponseDTO(-2, "Debe aceptar terminos de condiciones para participar en los calidoso.")).build();
            } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Sucursal] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo [Sucursal] es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getCiudad() == null || dto.getCiudad().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Ciudad] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo [Ciudad] es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getDepartamento() == null || dto.getDepartamento().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Departamento] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo [Departamento] es obligatorio para participar en los calidosos.")).build();
            } else if (dto.getDireccion() == null || dto.getDireccion().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Direccion] es obligatorio para participar en los calidosos");
                return Response.ok(new ResponseDTO(-2, "Campo [Direccion] es obligatorio para participar en los calidosos.")).build();
            }

            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);

            //Validar que no se duplique un vendedor mostrador
            if (!vendedorMostradorSAPFacade.validateVendMostrador("C" + dto.getDocumento(), "IGB", false)) {
                CONSOLE.log(Level.WARNING, "El vendedor mostrador [{0}] ya exite en los calidosos", dto.getDocumento());
                return Response.ok(new ResponseDTO(-1, "El vendedor mostrador [" + dto.getDocumento() + "] ya exite en los calidosos.")).build();
            }
            //TODO: Valida si el vendedor mostrador esta activo para una sucursal

            try {
                vendedorMostradorSAPFacade.addVendedorMostrador(dto, "IGB", false);
                CONSOLE.log(Level.INFO, "Creación vendedor mostrador exitosa.");
                return Response.ok(new ResponseDTO(0, "Creación vendedor mostrador exitosa.")).build();
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error creando vendedor mostrador en los calidosos ", e);
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando vendedor mostrador en los calidosos.")).build();
            }
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @POST
    @Path("add-puntos-redimidos")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response redeemPoints(@HeaderParam("X-TOKEN") String token,
                                 PointRedeemCalidosoDTO dto) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            CONSOLE.log(Level.INFO, "Iniciando servicio para redimir puntos");
            if (dto.getDocumento() == null || dto.getDocumento().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Documento] es obligatorio para redimir puntos");
                return Response.ok(new ResponseDTO(-2, "Campo [Documento] es obligatorio para redimir puntos.")).build();
            } else if (dto.getPuntos() <= 0) {
                CONSOLE.log(Level.WARNING, "Campo [Puntos] es obligatorio para redimir puntos");
                return Response.ok(new ResponseDTO(-2, "campo [Puntos] es obligatorio para redimir puntos.")).build();
            } else if (dto.getConcepto() == null || dto.getConcepto().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Concepto] es obligatorio para redimir puntos");
                return Response.ok().build();
            } else if (dto.getComprobante() == null || dto.getComprobante().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Campo [Comprobante] es obligatorio para redimir puntos");
                return Response.ok(new ResponseDTO(-2, "Campo [Comprobante] es obligatorio para redimir puntos")).build();
            }

            //Validar que el comprobante de redención no exista
            String idRedeem = redimePuntosSAPFacade.getIdRedeemPoint(dto.getComprobante(), "IGB", false);
            if (idRedeem != null) {
                CONSOLE.log(Level.WARNING, "Ya existe un comprobante de redencion");
                return Response.ok(new ResponseDTO(0, "Ya existe un comprobante de redencion.")).build();
            }

            Gson gson = new Gson();
            String json = gson.toJson(dto);
            CONSOLE.log(Level.INFO, json);
            try {
                //TODO: Validar si es un abono a redimir, se crea en SAP un pago a cuenta
                if (dto.getConcepto().equals("ABONO")) {
                    IncomingPaymentDTO incomingPaymentDTO = new IncomingPaymentDTO();
                    incomingPaymentDTO.setCardCode(dto.getDocumento());
                    incomingPaymentDTO.setTransferSum(new BigDecimal(dto.getPuntos()));
                    incomingPaymentDTO.setTransferReference("ABONO CALIDOSOS");
                    incomingPaymentDTO.setCompanyName("IGB");

                    ResponseDTO res = incomingPaymentEJB.createIncomingPaymentAccountCalidosoService(incomingPaymentDTO);
                    if (res.getCode() < 0) {
                        return Response.ok(res).build();
                    } else {
                        redimePuntosSAPFacade.addRedeemPoints(dto, (long) res.getContent(), "IGB", false);
                    }
                } else {
                    redimePuntosSAPFacade.addRedeemPoints(dto, 0, "IGB", false);
                }
            } catch (Exception e) {
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error redimiento los puntos para el participante" + dto.getDocumento())).build();
            }
            CONSOLE.log(Level.INFO, "Redención de puntos exitoso");
            return Response.ok(new ResponseDTO(0, "Redención de puntos exitoso.")).build();
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }

    @DELETE
    @Path("delete-punto-redimido/{cardcode}/{code}")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response deleteRedeemPoint(@HeaderParam("X-TOKEN") String token,
                                      @PathParam("cardcode") String cardCode,
                                      @PathParam("code") String code) {
        if (token.equals(managerApplicationBean.obtenerValorPropiedad(Constants.TOKEN_CALIDOSOS)) || token.isEmpty() || token == null) {
            CONSOLE.log(Level.INFO, "Eliminado redencion de id [{0}] no aprobada para el participante {1}", new Object[]{code, cardCode});
            try {
                redimePuntosSAPFacade.deleteRedeemPointWithoutApproved(code, cardCode, "IGB", false);
                CONSOLE.log(Level.INFO, "Redencion eliminada con exito");
                return Response.ok(new ResponseDTO(0, "Redención eliminada con exito.")).build();
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error elminando la redencion de id [{0}] para participante {1}", new Object[]{code, cardCode});
                return Response.ok(new ResponseDTO(-1, "Ocurrio un error elminando la redencion de id " + code)).build();
            }
        } else {
            CONSOLE.log(Level.WARNING, "Token invalido para consumir servicio");
            return Response.ok(new ResponseDTO(-3, "Token invalido para consumir servicio.")).build();
        }
    }
}
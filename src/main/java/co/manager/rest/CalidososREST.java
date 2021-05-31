package co.manager.rest;

import co.manager.dto.PointCalidosoDTO;
import co.manager.dto.ProductCalidosoDTO;
import co.manager.dto.ResponseDTO;
import co.manager.dto.VendedorMostradorDTO;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.ConceptoSAPFacade;
import co.manager.persistence.facade.RedimeProductoSAPFacade;
import co.manager.persistence.facade.VendedorMostradorSAPFacade;
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

    @GET
    @Path("programas")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listActivePrograms() {
        return Response.ok(conceptoSAPFacade.listActivePrograms("IGB", false)).build();
    }

    @GET
    @Path("sucursales")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listActiveClients() {
        return Response.ok(businessPartnerSAPFacade.listClientCalidosos("IGB", false)).build();
    }

    @GET
    @Path("productos")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response ListProducts() {
        CONSOLE.log(Level.INFO, "Iniciando servicio de listar productos a redimir en los calidosos");
        List<Object[]> objects = redimeProductoSAPFacade.listActiveProducts("IGB", false);

        List<ProductCalidosoDTO> products = new ArrayList<>();
        for (Object[] obj: objects) {
            ProductCalidosoDTO dto = new ProductCalidosoDTO();
            dto.setItemCode((String) obj[0]);
            dto.setItemName((String) obj[1]);
            dto.setDescription((String) obj[2]);
            dto.setPrice((BigDecimal) obj[3]);
            dto.setUrlPhoto(managerApplicationBean.obtenerValorPropiedad(Constants.URL_SHARED) + "images/calidosos/" + obj[4]);
            dto.setCondiction((String) obj[5]);
            products.add(dto);
        }
        CONSOLE.log(Level.INFO, "Retornando lista de productos activos a redimir en los calidosos.");
        return Response.ok(products).build();
    }

    @GET
    @Path("historial-puntos")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getHistoryPointsOfCustomer(@QueryParam("cardCode") String cardCode) {
        CONSOLE.log(Level.INFO, "Listando historial de puntos por clientes en los calidosos.");
        List<Object[]> objects = businessPartnerSAPFacade.listHistoryPointsCalidosos(cardCode, "IGB", false);

        if (objects.size() <= 0) {
            CONSOLE.log(Level.WARNING, "No se encontro historico de puntos en los calidosos para {0}", cardCode);
            return Response.ok(new ResponseDTO(-1, "No se encontro historico de puntos en los calidosos para " + cardCode)).build();
        }
        if (objects == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al consultar el historico de puntos en los calidosos para {0}", cardCode);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al consultar el historico de puntos en los calidosos para " + cardCode)).build();
        }

        List<PointCalidosoDTO> pointCalidosoDTO = new ArrayList<>();
        for (Object[] obj : objects) {
            PointCalidosoDTO dto = new PointCalidosoDTO();
            dto.setCardCode((String) obj[0]);
            dto.setConcept((String) obj[1]);
            dto.setDocNum((Integer) obj[2]);
            dto.setDocType((String) obj[3]);
            dto.setDocDate((String) obj[4]);
            dto.setPoint((Integer) obj[5]);

            pointCalidosoDTO.add(dto);
        }

        CONSOLE.log(Level.INFO, "Retornando historico de puntos en los calidosos.");
        return Response.ok(new ResponseDTO(0, pointCalidosoDTO)).build();
    }

    @POST
    @Path("add-vendedor-mostrador")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addVendedorMostrador(VendedorMostradorDTO dto) {
        CONSOLE.log(Level.INFO, "Iniciando un nuevo registro de vendedor mostrador en los calidosos.");
        if (dto.getDocumento() == null || dto.getDocumento().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Documento] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo Documento es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getNombres() == null || dto.getNombres().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Nombres] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo Nombres es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getApellidos() == null || dto.getApellidos().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Apellidos] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo Apellidos es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getCorreo() == null || dto.getCorreo().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Correo] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo Correo es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getCelular() == null || dto.getCelular().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Celular] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo Celular es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getAceptoTermino() <= 0 || dto.getAceptoTratamientoDatos() <= 0) {
            CONSOLE.log(Level.WARNING, "Debe aceptar terminos de condiciones para participar en los calidoso.");
            return Response.ok(new ResponseDTO(-2, "Debe aceptar terminos de condiciones para participar en los calidoso.")).build();
        } else if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [Sucursal] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo [Sucursal] es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getCiudad() == null || dto.getCiudad().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [ciudad] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo [Ciudad] es obligatorio para participar en los calidosos.")).build();
        } else if (dto.getDepartamento() == null || dto.getDepartamento().isEmpty()) {
            CONSOLE.log(Level.WARNING, "Campo [departamento] es obligatorio para participar en los calidosos.");
            return Response.ok(new ResponseDTO(-2, "Campo [departamento] es obligatorio para participar en los calidosos.")).build();
        }

        Gson gson = new Gson();
        String JSON = gson.toJson(dto);
        CONSOLE.log(Level.INFO, JSON);

        try {
            vendedorMostradorSAPFacade.addVendedorMostrador(dto, "IGB", false);
            CONSOLE.log(Level.INFO, "Creación vendedor mostrador exitosa.");
            return Response.ok(new ResponseDTO(0, "Creación vendedor mostrador exitosa.")).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando vendedor mostrador en los calidosos. ", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando vendedor mostrador en los calidosos.")).build();
        }
    }
}
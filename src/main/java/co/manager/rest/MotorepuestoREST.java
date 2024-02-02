package co.manager.rest;

import co.manager.dto.BusinessPartnerDTO;
import co.manager.dto.ItemMotorepuestoDTO;
import co.manager.dto.ResponseDTO;
import co.manager.ejb.BasicFunctions;
import co.manager.ejb.BusinessPartnerEJB;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.ejb.PurchaseInvoicesEJB;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.InvoiceSAPFacade;
import co.manager.persistence.facade.ItemSAPFacade;
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
        }

        //Validar si ya existe el cliente en SAP.
        if (businessPartnerSAPFacade.findCustomer("C" + dto.getDocument(), dto.getCompanyName(), false)) {
            CONSOLE.log(Level.INFO, "El cliente ya existe en SAP con el id {0}", "C" + dto.getDocument());
            return Response.ok(new ResponseDTO(0, "C" + dto.getDocument())).build();
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
    @Path("create-payments")
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response createIncomingPayments(BusinessPartnerDTO dto) {
        dto.setLicTradNum(dto.getCardCode().replace("C", ""));
        return Response.ok(businessPartnerEJB.createBusinessPartnerFromEcommerce(dto)).build();
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
}
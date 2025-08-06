package co.manager.rest;

import co.manager.dto.ResponseDTO;
import co.manager.ejb.ManagerApplicationBean;
import co.manager.openaiws.dto.ItemInputTextDTO;
import co.manager.openaiws.dto.ItemResultDTO;
import co.manager.openaiws.ejb.OpenaiEJB;
import co.manager.persistence.entity.ChatbotAPP;
import co.manager.persistence.facade.ChatbotAPPFacade;
import co.manager.persistence.facade.ItemSAPFacade;
import co.manager.util.Constants;

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
@Path("chatbot")
public class ChatBotIAREST {
    private static final Logger CONSOLE = Logger.getLogger(ChatBotIAREST.class.getSimpleName());
    @Inject
    private ManagerApplicationBean managerApplicationBean;
    @EJB
    private ItemSAPFacade itemSAPFacade;
    @EJB
    private OpenaiEJB openaiEJB;
    @EJB
    private ChatbotAPPFacade chatbotAPPFacade;

    @POST
    @Path("interpret-input-text")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response interpretInputText(ItemInputTextDTO dto) {
        String res = openaiEJB.interpretTextInput(dto);
        if (res == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error interpretando la solicitud del asesor " + dto.getSlpCode() + " en " + dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1, dto.getSlpName() + ", parece que hubo una situación interpretando tu solicitud. Mmm... creo que no entendí bien lo que necesitas. ¿Podrías explicármelo con un poquito más de detalle? Estoy aquí para ayudarte.")).build();
        }
        CONSOLE.log(Level.INFO, "Query=" + res);

        //TODO: crear registro de solicitud a chatbot
        ChatbotAPP entity = new ChatbotAPP();
        entity.setSlpCode(dto.getSlpCode());
        entity.setSlpName(dto.getSlpName());
        entity.setCreateDate(new Date());
        entity.setCompanyName(dto.getCompanyName());
        entity.setPrompt(dto.getMessage());
        entity.setResponse(res);
        try {
            chatbotAPPFacade.create(entity, dto.getCompanyName(), false);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE,"Ocurrio un error creando el registro de la solicitud al chatbot");
        }

        List<Object[]> objs = itemSAPFacade.getResultOfItemChatBotIA(new StringBuilder(res), dto.getSlpCode(), dto.getCompanyName(), false);
        if (objs.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron datos para mostrar a la solicitud del asesor " + dto.getSlpCode() + " en " + dto.getCompanyName());
            return Response.ok(new ResponseDTO(-1,  "Ups! No encontré resultados con lo que me dijiste " + dto.getSlpName() + ". Puede que esté mal escrito, o no se hayan encontrado datos por temas de stock o porque el producto está inactivo. Intenta de nuevo preguntarme, que con gusto te ayudo.")).build();
        }

        List<ItemResultDTO> results = new ArrayList<>();
        for (Object[] obj : objs) {
            ItemResultDTO itemResultDTO = new ItemResultDTO();
            itemResultDTO.setArticulo((String) obj[0]);
            itemResultDTO.setDescription((String) obj[1]);
            itemResultDTO.setStockMedellin((Integer) obj[2]);
            itemResultDTO.setStockCartagena((Integer) obj[3]);
            itemResultDTO.setStockCali((Integer) obj[4]);
            itemResultDTO.setStockBogota((Integer) obj[5]);
            itemResultDTO.setPrecio((BigDecimal) obj[6]);
            itemResultDTO.setFoto(obj[0] + ".jpg");

            results.add(itemResultDTO);
        }
        return Response.ok(new ResponseDTO(0, results)).build();
    }

    @GET
    @Path("open-ai/apikey")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getApikeyOpenAI() {
        CONSOLE.log(Level.INFO, "Consultando la apikey activa para utilizar OpenAI.");
        return Response.ok(new ResponseDTO(0, managerApplicationBean.obtenerValorPropiedad(Constants.OPEN_AI_APIKEY))).build();
    }
}
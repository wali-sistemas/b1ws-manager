package co.manager.rest;

import co.manager.dto.ItemChatBotIADTO;
import co.manager.dto.ResponseDTO;
import co.manager.persistence.facade.ItemSAPFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
@Path("chatbot")
public class ChatBotIAREST {
    private static final Logger CONSOLE = Logger.getLogger(ChatBotIAREST.class.getSimpleName());
    @EJB
    private ItemSAPFacade itemSAPFacade;

    @GET
    @Path("fetch-items")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response fetchItemCatalog(@QueryParam("companyname") String companyName) {
        CONSOLE.log(Level.INFO, "Iniciando busquedad del catalogo de items para la empresa {0}", companyName);

        List<Object[]> objs = itemSAPFacade.getListItemsChatBotIABySeller("", companyName, false);

        List<ItemChatBotIADTO> listItems = new ArrayList<>();
        for (Object[] obj : objs) {
            ItemChatBotIADTO dto = new ItemChatBotIADTO();
            dto.setItemCode((String) obj[0]);
            dto.setItemName((String) obj[1]);
            dto.setStockFull((Integer) obj[2]);
            dto.setStockWhMed((Integer) obj[3]);
            dto.setStockWhCart((Integer) obj[4]);
            dto.setStockWhCal((Integer) obj[5]);
            dto.setStockWhBog((Integer) obj[6]);
            dto.setPrice((BigDecimal) obj[7]);
            dto.setCategory((String) obj[8]);
            dto.setGroup((String) obj[9]);
            dto.setSubGroup((String) obj[10]);
            dto.setBrand((String) obj[11]);
            dto.setSubBrand((String) obj[12]);
            dto.setApplication((String) obj[13]);
            dto.setOring((String) obj[14]);
            dto.setTypeInv((String) obj[15]);
            dto.setTypeTire((String) obj[16]);
            dto.setWidthTire((String) obj[17]);
            dto.setProfileTire((String) obj[18]);
            dto.setRinTire((String) obj[19]);
            dto.setColorChain((String) obj[20]);
            dto.setPasoChain((String) obj[21]);
            dto.setLongChain((String) obj[22]);
            dto.setUnitPack("1");
            dto.setUrlPicture("http://wali.igbcolombia.com:8080/shared/images/mtz/" + obj[0] + ".jpg");

            listItems.add(dto);
        }
        return Response.ok(new ResponseDTO(0, listItems)).build();
    }
}
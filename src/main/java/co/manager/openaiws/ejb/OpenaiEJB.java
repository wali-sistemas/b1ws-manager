package co.manager.openaiws.ejb;

import co.manager.ejb.ManagerApplicationBean;
import co.manager.openaiws.client.OpenaiClient;
import co.manager.openaiws.dto.FormDataDTO;
import co.manager.openaiws.dto.FormDataResponseDTO;
import co.manager.openaiws.dto.ItemInputTextDTO;
import co.manager.openaiws.prompt.ItemPrompt;
import co.manager.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class OpenaiEJB {
    private static final Logger CONSOLE = Logger.getLogger(OpenaiEJB.class.getSimpleName());
    private OpenaiClient service;
    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private ItemPrompt itemPrompt;

    @PostConstruct
    private void initialize() {
        try {
            service = new OpenaiClient(Constants.OPEN_AI_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la interface de OpenAI. ", e);
        }
    }

    public String interpretTextInput(ItemInputTextDTO dto) {
        List<FormDataDTO.Message> messages = new ArrayList<>();
        FormDataDTO.Message messageDTO = new FormDataDTO.Message();
        messageDTO.setRole(dto.getRol());
        messageDTO.setContent(dto.getCompanyName().contains("IGB") ? itemPrompt.createItemQueryIGB(dto.getMessage()) : itemPrompt.createItemQueryMTZ(dto.getMessage()));
        messages.add(messageDTO);

        FormDataDTO formDataDTO = new FormDataDTO();
        formDataDTO.setModel("gpt-4o");
        formDataDTO.setMessages(messages);
        formDataDTO.setTemperature(0.2);

        try {
            String response = service.interpretTextInput(formDataDTO, appBean.obtenerValorPropiedad(Constants.OPEN_AI_APIKEY));
            FormDataResponseDTO formDataResponseDTO = new ObjectMapper().readValue(response, FormDataResponseDTO.class);
            return formDataResponseDTO.getChoices().get(0).getMessage().getContent();
        } catch (javax.ws.rs.WebApplicationException e) {
            if (e.getResponse().getStatus() == 429) {
                CONSOLE.log(Level.WARNING, "Límite alcanzado o sin saldo para OpenAI");
                return "Lo sentimos, no hay saldo disponible para procesar la solicitud.";
            } else {
                CONSOLE.log(Level.SEVERE, "Error HTTP " + e.getResponse().getStatus() + " al interpretar mensaje para el asesor " + dto.getSlpCode(), e);
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error interpretando con OpenAI el mensaje enviado por el asesor " + dto.getSlpCode() + " en " + dto.getCompanyName(), e);
        }
        return null;
    }
}

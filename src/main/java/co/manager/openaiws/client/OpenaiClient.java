package co.manager.openaiws.client;

import co.manager.openaiws.dto.FormDataDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class OpenaiClient {
    private WebTarget webTarget;
    private Client client;

    public OpenaiClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public OpenaiClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public String interpretTextInput(FormDataDTO dto, String apikey) {
        return webTarget.path("chat/completions").request(MediaType.APPLICATION_JSON).header("Authorization", "Bearer " + apikey)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), String.class);
    }
}
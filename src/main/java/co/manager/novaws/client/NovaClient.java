package co.manager.novaws.client;

import co.manager.novaws.dto.ItemRestDTO;
import co.manager.novaws.dto.LoginDTO;
import co.manager.novaws.dto.LoginRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * @author jguisao
 */
public class NovaClient {
    private WebTarget webTarget;
    private Client client;

    public NovaClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("");
    }

    public NovaClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public LoginRestDTO getSessionId(LoginDTO dto) {
        return webTarget.path("auth").request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), LoginRestDTO.class);
    }

    public ItemRestDTO getItems(String token, String partnerId) {
        MultivaluedMap<String, Object> headers = new MultivaluedHashMap<>();
        headers.add("Authorization", token);
        headers.add("Partner-Id", partnerId);

        return webTarget.path("v1/products").request(MediaType.APPLICATION_JSON).headers(headers)
                .get(ItemRestDTO.class);
    }
}

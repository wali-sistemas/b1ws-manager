package co.manager.hanaws.client.item;

import co.manager.hanaws.dto.item.ItemsDTO;
import co.manager.hanaws.dto.item.ItemsRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class ItemsClient {
    private WebTarget webTarget;
    private Client client;

    public ItemsClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public ItemsClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public ItemsRestDTO getItem(String itemCode, String sessionId) {
        return webTarget.path("Items('" + itemCode + "')").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .get(ItemsRestDTO.class);
    }

    public ItemsRestDTO addItem(ItemsDTO dto, String sessionId) {
        return webTarget.path("Items").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), ItemsRestDTO.class);
    }
}
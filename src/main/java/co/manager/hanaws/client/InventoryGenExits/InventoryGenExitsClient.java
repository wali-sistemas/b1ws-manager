package co.manager.hanaws.client.InventoryGenExits;

import co.manager.hanaws.dto.InventoryGenExits.InventoryGenExitsDTO;
import co.manager.hanaws.dto.InventoryGenExits.InventoryGenExitsRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class InventoryGenExitsClient {
    private WebTarget webTarget;
    private Client client;

    public InventoryGenExitsClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public InventoryGenExitsClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public InventoryGenExitsRestDTO addInventoryGenExits(InventoryGenExitsDTO dto, String sessionId) {
        return webTarget.path("InventoryGenExits").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), InventoryGenExitsRestDTO.class);
    }
}

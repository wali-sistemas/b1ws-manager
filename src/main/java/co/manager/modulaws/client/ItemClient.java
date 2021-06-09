package co.manager.modulaws.client;

import co.manager.modulaws.dto.item.ItemModulaDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class ItemClient {
    private WebTarget webTarget;
    private Client client;

    public ItemClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("jobs");
    }

    public ItemClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public String addItem(ItemModulaDTO dto) {
        return webTarget.path("CFG-IMP-ARTICOLI").request(MediaType.APPLICATION_JSON).header("Authorization", "BASIC UkVTVFVTRVI6V01TUmVzdFVzZXIh")
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), String.class);
    }
}
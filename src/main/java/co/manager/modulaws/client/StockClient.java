package co.manager.modulaws.client;

import co.manager.modulaws.dto.item.StockRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class StockClient {
    private WebTarget webTarget;
    private Client client;

    public StockClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("jobs");
    }

    public StockClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public StockRestDTO getStock() {
        return webTarget.path("CFG-EXP-GIACENZE").request(MediaType.APPLICATION_JSON).header("Authorization", "BASIC UkVTVFVTRVI6V01TUmVzdFVzZXIh")
                .get(StockRestDTO.class);
    }
}
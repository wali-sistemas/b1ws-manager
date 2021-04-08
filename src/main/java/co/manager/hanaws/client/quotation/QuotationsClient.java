package co.manager.hanaws.client.quotation;

import co.manager.hanaws.dto.quotation.QuotationsDTO;
import co.manager.hanaws.dto.quotation.QuotationsRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class QuotationsClient {
    private WebTarget webTarget;
    private Client client;

    public QuotationsClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public QuotationsClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public QuotationsRestDTO addQuotation(QuotationsDTO dto, String sessionId) {
        return webTarget.path("Orders").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), QuotationsRestDTO.class);
    }
}
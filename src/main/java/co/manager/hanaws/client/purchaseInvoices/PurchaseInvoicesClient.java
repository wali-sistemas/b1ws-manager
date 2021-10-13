package co.manager.hanaws.client.purchaseInvoices;

import co.manager.hanaws.dto.purchaseInvoice.PurchaseInvoicesDTO;
import co.manager.hanaws.dto.purchaseInvoice.PurchaseInvoicesRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class PurchaseInvoicesClient {
    private WebTarget webTarget;
    private Client client;

    public PurchaseInvoicesClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public PurchaseInvoicesClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public PurchaseInvoicesRestDTO addInvoice(PurchaseInvoicesDTO dto, String sessionId) {
        return webTarget.path("PurchaseInvoices").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), PurchaseInvoicesRestDTO.class);
    }
}
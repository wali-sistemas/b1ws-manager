package co.manager.hanaws.client.incomingPayments;

import co.manager.hanaws.dto.payment.PaymentDTO;
import co.manager.hanaws.dto.payment.PaymentRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class PaymentsClient {
    private WebTarget webTarget;
    private Client client;

    public PaymentsClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public PaymentsClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public PaymentRestDTO addPayment(PaymentDTO dto, String sessionId) {
        return webTarget.path("IncomingPayments").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), PaymentRestDTO.class);
    }
}
package co.manager.hanaws.client.order;

import co.manager.hanaws.dto.ResponseServiceLayerDTO;
import co.manager.hanaws.dto.order.OrderDTO;
import co.manager.hanaws.dto.order.OrderRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author jguisao
 */
public class OrderClient {
    private WebTarget webTarget;
    private Client client;

    public OrderClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public OrderClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public OrderRestDTO addOrder(OrderDTO dto, String sessionId) {
        return webTarget.path("Orders").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), OrderRestDTO.class);
    }

    public Object addOrderByExtranet(OrderDTO dto, String sessionId) {
        Response response = webTarget.path("Orders")
                .request(MediaType.APPLICATION_JSON)
                .cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON));

        if (response.getStatus() == 200 || response.getStatus() == 201) {
            return response.readEntity(OrderRestDTO.class);
        } else {
            return response.readEntity(ResponseServiceLayerDTO.class);
        }
    }
}
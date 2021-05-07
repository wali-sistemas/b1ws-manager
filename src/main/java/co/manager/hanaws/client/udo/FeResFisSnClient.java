package co.manager.hanaws.client.udo;

import co.manager.hanaws.dto.udo.FeResFisSnDTO;
import co.manager.hanaws.dto.udo.FeResFisSnRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class FeResFisSnClient {
    private WebTarget webTarget;
    private Client client;

    public FeResFisSnClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public FeResFisSnClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public FeResFisSnRestDTO addResFisSN(FeResFisSnDTO dto, String sessionId) {
        return webTarget.path("FE_RES_FIS_SN").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), FeResFisSnRestDTO.class);
    }
}
package co.manager.hanaws.client.login;

import co.manager.hanaws.dto.login.LoginDTO;
import co.manager.hanaws.dto.login.LoginRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author jguisao
 */
public class LoginClient {
    private WebTarget webTarget;
    private Client client;

    public LoginClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public LoginClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public LoginRestDTO getSessionId(LoginDTO dto) {
        return webTarget.path("Login").request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), LoginRestDTO.class);
    }

    public Response closeSessionId(String sessionId) {
        return webTarget.path("Logout").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(null, MediaType.APPLICATION_JSON), Response.class);
    }
}
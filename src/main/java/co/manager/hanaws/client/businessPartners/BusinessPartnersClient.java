package co.manager.hanaws.client.businessPartners;

import co.manager.hanaws.dto.businessPartner.BusinessPartnersDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersRestDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * @author jguisao
 */
public class BusinessPartnersClient {
    private WebTarget webTarget;
    private Client client;

    public BusinessPartnersClient(String BASE_URI) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("v1");
    }

    public BusinessPartnersClient(String BASE_URI, String path) {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path(path);
    }

    public BusinessPartnersRestDTO addBusinessPartner(BusinessPartnersDTO dto, String sessionId) {
        return webTarget.path("BusinessPartners").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), BusinessPartnersRestDTO.class);
    }
}
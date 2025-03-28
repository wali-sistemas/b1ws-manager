package co.manager.hanaws.client.businessPartners;

import co.manager.hanaws.dto.businessPartner.BusinessPartnersDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersEcommerceDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersRestDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersWithholdingTaxDTO;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    public BusinessPartnersRestDTO getBusinessPartner(String cardCode, String sessionId) {
        WebTarget url = webTarget.path("BusinessPartners('" + cardCode + "')");
        return url.request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .get(BusinessPartnersRestDTO.class);
    }

    public BusinessPartnersRestDTO addBusinessPartnerFromWali(BusinessPartnersDTO dto, String sessionId) {
        return webTarget.path("BusinessPartners").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), BusinessPartnersRestDTO.class);
    }

    public BusinessPartnersRestDTO addBusinessPartnerFromEcommerce(BusinessPartnersEcommerceDTO dto, String sessionId) {
        return webTarget.path("BusinessPartners").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .post(Entity.entity(dto, MediaType.APPLICATION_JSON), BusinessPartnersRestDTO.class);
    }

    public Response updateBusinessPartner(BusinessPartnersRestDTO dto, String cardCode, String sessionId) {
        return webTarget.path("BusinessPartners('" + cardCode + "')").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .method("PATCH", Entity.entity(dto, MediaType.APPLICATION_JSON));
    }

    public Response updateBPWithholdingTaxCollection(BusinessPartnersWithholdingTaxDTO dto, String cardCode, String sessionId) {
        return webTarget.path("BusinessPartners('" + cardCode + "')").request(MediaType.APPLICATION_JSON).cookie("B1SESSION", sessionId)
                .method("PATCH", Entity.entity(dto, MediaType.APPLICATION_JSON));
    }
}
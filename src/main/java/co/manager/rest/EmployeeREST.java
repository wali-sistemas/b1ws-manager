package co.manager.rest;

import co.manager.dto.EmployeeCustodyDTO;
import co.manager.dto.ResponseDTO;
import co.manager.persistence.facade.EmployeeFacade;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
@Path("employee")
public class EmployeeREST {
    private static final Logger CONSOLE = Logger.getLogger(EmployeeREST.class.getSimpleName());

    @EJB
    private EmployeeFacade employeeFacade;

    @GET
    @Path("list-custody/{cardcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustodyByEmployee(@PathParam("cardcode") String cardCode,
                                         @HeaderParam("X-Company-Name") String companyName,
                                         @HeaderParam("X-Pruebas") boolean pruebas) {
        List<Object[]> objs = employeeFacade.listCustodyByEmplee(cardCode, companyName, pruebas);
        if (objs.isEmpty()) {
            CONSOLE.log(Level.WARNING, "No se encontraron custodias para mostrar");
            return Response.ok(new ResponseDTO(-1, "No se encontraron custodias para mostrar")).build();
        }

        List<EmployeeCustodyDTO> employeeCustodyDTO = new ArrayList<>();
        for (Object[] obj : objs) {
            EmployeeCustodyDTO dto = new EmployeeCustodyDTO();
            dto.setCardCode((String) obj[0]);
            dto.setCardName((String) obj[1]);
            dto.setDepart((String) obj[2]);
            dto.setCompany((String) obj[3]);
            dto.setCcEmpl((Integer) obj[4]);
            dto.setStatusEmp((String) obj[5]);
            dto.setIdAsset((String) obj[6]);
            dto.setDateAssign((Date) obj[7]);
            dto.setDateFinish((Date) obj[8]);
            dto.setStatusDet((String) obj[9]);
            dto.setUserAssign((String) obj[10]);
            dto.setUserFinish((String) obj[11]);
            dto.setType((String) obj[12]);
            dto.setBrand((String) obj[13]);
            dto.setReferencia((String) obj[14]);
            dto.setSerial((String) obj[15]);
            dto.setCompanyPurchase((String) obj[16]);
            dto.setDatePurchase((Date) obj[17]);
            dto.setCcAsset((Integer) obj[18]);
            dto.setStatusAsset((String) obj[19]);
            dto.setComment((String) obj[20]);
            dto.setPictAsset((String) obj[21]);
            dto.setIcon("icon-" + dto.getType());

            employeeCustodyDTO.add(dto);
        }
        return Response.ok(employeeCustodyDTO).build();
    }
}
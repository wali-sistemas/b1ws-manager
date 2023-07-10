package co.manager.rest;

import co.manager.dto.AssetDTO;
import co.manager.dto.EmployeeCustodyDTO;
import co.manager.dto.EmployeeDTO;
import co.manager.dto.ResponseDTO;
import co.manager.persistence.entity.AssetMasterData;
import co.manager.persistence.entity.CustodyDetail;
import co.manager.persistence.entity.Employee;
import co.manager.persistence.facade.AssetMasterDataFacade;
import co.manager.persistence.facade.CustodyDetailFacade;
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
    @EJB
    private AssetMasterDataFacade assetMasterDataFacade;
    @EJB
    private CustodyDetailFacade custodyDetailFacade;

    @GET
    @Path("list-custody")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustodyByEmployeeOrAsset(@QueryParam("filtre") String filtre,
                                                @HeaderParam("X-Company-Name") String companyName,
                                                @HeaderParam("X-Pruebas") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Listando custodias por empleado o por activo en {0}", new Object[]{companyName});

        String cardCode = "";
        String idAsset = "";
        if (Character.isDigit(filtre.charAt(0))) {
            cardCode = filtre;
        } else {
            idAsset = filtre;
        }

        List<Object[]> objs = employeeFacade.listCustodyByEmpleeOrAsset(cardCode, idAsset, companyName, pruebas);
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

    @GET
    @Path("find-employee/{cardcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response findEmployee(@PathParam("cardcode") String cardCode,
                                 @HeaderParam("X-Company-Name") String companyName,
                                 @HeaderParam("X-Pruebas") boolean pruebas) {
        Object[] obj = employeeFacade.findEmployee(cardCode, companyName, pruebas);

        if (obj != null) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setCardCode((String) obj[0]);
            dto.setCardName((String) obj[1]);
            dto.setDepartment((String) obj[2]);
            dto.setCompanyName((String) obj[3]);
            dto.setCcosto((Integer) obj[4]);
            dto.setStatus((String) obj[5]);

            return Response.ok(new ResponseDTO(0, dto)).build();
        }
        return Response.ok(new ResponseDTO(-1, "No se encontraron datos para mostrar.")).build();
    }

    @GET
    @Path("list-actives-employee")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response listEmployeeActive(@HeaderParam("X-Company-Name") String companyName,
                                       @HeaderParam("X-Pruebas") boolean pruebas) {
        return Response.ok(employeeFacade.listEmployeeActives(companyName, pruebas)).build();
    }

    @POST
    @Path("add-refresh-employee")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addOrRefreshEmployee(EmployeeDTO dto,
                                         @QueryParam("bottonAction") String bottonAction,
                                         @HeaderParam("X-Company-Name") String companyName,
                                         @HeaderParam("X-Pruebas") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Inciando creacion o actualizacion de empleado para el modulo de custodia");

        if (dto.getCardCode() == null || dto.getCardCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Cedula es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Cédula es obligatorio")).build();
        } else if (dto.getCardName() == null || dto.getCardName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Nombre es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Nombre es obligatorio")).build();
        } else if (dto.getDepartment() == null || dto.getDepartment().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Departamento es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Departamento es obligatorio")).build();
        } else if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Empresa es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Empresa es obligatorio")).build();
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Estado es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Estado es obligatorio")).build();
        } else if (dto.getCcosto() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el empleado. Campo Centro de costo es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el empleado. Campo Centro de costo es obligatorio")).build();
        }

        Employee entity = new Employee();
        entity.setCardCode(dto.getCardCode());
        entity.setCardName(dto.getCardName());
        entity.setDepartment(dto.getDepartment());
        entity.setCompany(dto.getCompanyName());
        entity.setCcosto(dto.getCcosto());
        entity.setStatus(dto.getStatus());

        try {
            if (bottonAction.equals("Crear")) {
                employeeFacade.create(entity, companyName, pruebas);
            } else {
                employeeFacade.updateEmployee(entity, companyName, pruebas);
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando o actulizando el empleado ", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando o actulizando el empleado.")).build();
        }
        return Response.ok(new ResponseDTO(0, "Empleado creado o modificado con éxito.")).build();
    }

    @GET
    @Path("find-asset/{id}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response findAsset(@PathParam("id") String idAsset,
                              @HeaderParam("X-Company-Name") String companyName,
                              @HeaderParam("X-Pruebas") boolean pruebas) {
        Object[] obj = assetMasterDataFacade.findAsset(idAsset, companyName, pruebas);
        if (obj != null) {
            AssetDTO assetDTO = new AssetDTO();
            assetDTO.setIdAsset((String) obj[0]);
            assetDTO.setType((String) obj[1]);
            assetDTO.setBrand((String) obj[2]);
            assetDTO.setReference((String) obj[3]);
            assetDTO.setSerial((String) obj[4]);
            assetDTO.setCompany((String) obj[5]);
            assetDTO.setDatePurchase((Date) obj[6]);
            assetDTO.setCcosto((Integer) obj[7]);
            assetDTO.setStatus((String) obj[8]);
            assetDTO.setComment((String) obj[9]);
            assetDTO.setPictureAssetUrl((String) obj[10]);

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setCardCode((String) obj[11]);
            employeeDTO.setCardName((String) obj[12]);

            assetDTO.setEmployeeDTO(employeeDTO);

            return Response.ok(new ResponseDTO(0, assetDTO)).build();
        }
        return Response.ok(new ResponseDTO(-1, "No se encontraron datos para mostrar.")).build();
    }

    @POST
    @Path("add-refresh-asset")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addOrRefreshAsset(AssetDTO dto,
                                      @QueryParam("bottonAction") String bottonAction,
                                      @HeaderParam("X-Company-Name") String companyName,
                                      @HeaderParam("X-Employee") String employee,
                                      @HeaderParam("X-Pruebas") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Inciando creacion o actualizacion del activo fijo para el modulo de custodia");

        if (dto.getIdAsset() == null || dto.getIdAsset().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo id es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo id es obligatorio")).build();
        } else if (dto.getType() == null || dto.getType().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo tipo es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo tipo es obligatorio")).build();
        } else if (dto.getBrand() == null || dto.getBrand().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo marca es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo marca es obligatorio")).build();
        } else if (dto.getReference() == null || dto.getReference().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo referencia es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo referencia es obligatorio")).build();
        } else if (dto.getSerial() == null || dto.getSerial().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo serial es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo serial es obligatorio")).build();
        } else if (dto.getCompany() == null || dto.getCompany().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo empresa es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo empresa es obligatorio")).build();
        } else if (dto.getDatePurchase() == null) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo fecha de compra es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo fecha de compra es obligatorio")).build();
        } else if (dto.getCcosto() == null || dto.getCcosto() <= 0) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo centro de costo es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo centro de costo es obligatorio")).build();
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo estado es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo estado es obligatorio")).build();
        } else if (dto.getComment() == null || dto.getComment().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo comentario es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo comentario es obligatorio")).build();
        } else if (dto.getPictureAssetUrl() == null || dto.getPictureAssetUrl().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo evidencia es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo evidencia es obligatorio")).build();
        }

        AssetMasterData entity = new AssetMasterData();
        entity.setIdAsset(dto.getIdAsset());
        entity.setType(dto.getType());
        entity.setBrand(dto.getBrand());
        entity.setReference(dto.getReference());
        entity.setSerial(dto.getSerial());
        entity.setCompany(dto.getCompany());
        entity.setDatePurchase(dto.getDatePurchase());
        entity.setCcosto(dto.getCcosto());
        entity.setStatus(dto.getStatus());
        entity.setComment(dto.getComment());
        entity.setPictureAssetUrl(dto.getPictureAssetUrl());

        try {
            if (bottonAction.equals("Crear")) {
                assetMasterDataFacade.create(entity, companyName, pruebas);
                if (dto.getEmployeeDTO().getCardCode() != null || !dto.getEmployeeDTO().getCardCode().isEmpty()) {
                    CustodyDetail entityCustody = new CustodyDetail();
                    entityCustody.setIdAsset(new AssetMasterData(dto.getIdAsset()));
                    entityCustody.setCardCode(new Employee(dto.getEmployeeDTO().getCardCode()));
                    entityCustody.setDateAssign(new Date());
                    entityCustody.setStatus("Y");
                    entityCustody.setUserAssign(employee);
                    custodyDetailFacade.create(entityCustody, companyName, pruebas);
                }
            } else {
                assetMasterDataFacade.updateAsset(entity, companyName, pruebas);
                if (dto.getEmployeeDTO().getCardCode() != null || !dto.getEmployeeDTO().getCardCode().isEmpty()) {
                    CustodyDetail entityCustody = new CustodyDetail();
                    entityCustody.setIdAsset(new AssetMasterData(dto.getIdAsset()));
                    entityCustody.setCardCode(new Employee(dto.getEmployeeDTO().getCardCode()));
                    entityCustody.setDateAssign(new Date());
                    entityCustody.setStatus("Y");
                    entityCustody.setUserAssign(employee);
                    custodyDetailFacade.create(entityCustody, companyName, pruebas);
                }
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando o actulizando el activo fijo ", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando o actulizando el activo fijo.")).build();
        }
        return Response.ok(new ResponseDTO(0, "Activo fijo creado o modificado con éxito.")).build();
    }
}
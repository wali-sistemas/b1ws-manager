package co.manager.rest;

import co.manager.dto.*;
import co.manager.ejb.EmailManager;
import co.manager.persistence.entity.AssetMasterData;
import co.manager.persistence.entity.AssociatedFEMPRO;
import co.manager.persistence.entity.CustodyDetail;
import co.manager.persistence.entity.Employee;
import co.manager.persistence.facade.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
    @EJB
    private StatementFEMPROFacade statementFEMPROFacade;
    @EJB
    private AssociatedFEMPROFacade associatedFEMPROFacade;
    @EJB
    private ReportREST reportREST;
    @Inject
    private EmailManager emailManager;

    @GET
    @Path("list-custody")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response getCustodyByEmployeeOrAsset(@QueryParam("filtre") String filtre,
                                                @HeaderParam("X-Company-Name") String companyName,
                                                @HeaderParam("X-Pruebas") boolean pruebas) {
        CONSOLE.log(Level.INFO, "Listando custodias por empleado o por activo en {0}", new Object[]{companyName});

        String cardCode = null;
        String idAsset = null;
        String cardName = null;
        if (Character.isDigit(filtre.charAt(0))) {
            cardCode = filtre;
        } else if (filtre.toUpperCase().contains("SIN ASIGNAR")) {
            cardName = filtre;
        } else {
            idAsset = filtre.toLowerCase();
        }

        List<Object[]> objs = employeeFacade.listCustodyByEmpleeOrAsset(cardCode, idAsset, cardName, companyName, pruebas);
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
            dto.setDateAssign((String) obj[7]);
            dto.setDateFinish((String) obj[8]);
            dto.setStatusDet((String) obj[9]);
            dto.setUserAssign((String) obj[10]);
            dto.setUserFinish((String) obj[11]);
            dto.setType((String) obj[12]);
            dto.setBrand((String) obj[13]);
            dto.setReferencia((String) obj[14]);
            dto.setSerial((String) obj[15]);
            dto.setCompanyPurchase((String) obj[16]);
            dto.setDatePurchase((String) obj[17]);
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
            assetDTO.setDatePurchase((String) obj[6]);
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
        } else if (dto.getStatus() == null || dto.getStatus().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al agregar el activo. Campo estado es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al agregar el activo. Campo estado es obligatorio")).build();
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

                    List<String> ids = custodyDetailFacade.listCustodyDetailByAsset(dto.getIdAsset(), companyName, pruebas);
                    if (!ids.isEmpty()) {
                        for (String id : ids) {
                            custodyDetailFacade.updateCustodyDetailByAsset(id, "N", employee, companyName, pruebas);
                        }
                    }

                    CustodyDetail entityCustody = new CustodyDetail();
                    entityCustody.setIdAsset(new AssetMasterData(dto.getIdAsset()));
                    entityCustody.setCardCode(new Employee(dto.getEmployeeDTO().getCardCode()));
                    entityCustody.setDateAssign(new Date());
                    entityCustody.setDateFinish(null);
                    entityCustody.setStatus("Y");
                    entityCustody.setUserAssign(employee);
                    entityCustody.setUserFinish(null);
                    custodyDetailFacade.create(entityCustody, companyName, pruebas);
                }
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando o actulizando el activo fijo ", e);
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error creando o actulizando el activo fijo.")).build();
        }
        return Response.ok(new ResponseDTO(0, "Activo fijo creado o modificado con éxito.")).build();
    }

    @GET
    @Path("validate-employee-existence/{companyname}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response validateEmployeeExistenceNovaWeb(@PathParam("companyname") String companyName,
                                                     @QueryParam("id") String emplId,
                                                     @QueryParam("birthdate") String birthdate,
                                                     @HeaderParam("X-Pruebas") boolean pruebas) {
        if (companyName == null || companyName.isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al validar el empleado. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al validar el empleado. Campo companyName es obligatorio.")).build();
        }
        return Response.ok(new ResponseDTO(0, employeeFacade.validateEmployeeExistenceNovaWeb(emplId, birthdate, companyName, pruebas))).build();
    }

    @GET
    @Path("femprobien/find-data-employee/{cardcode}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response findDataEmployeeFemprobienNovaWeb(@PathParam("cardcode") String cardCode,
                                                      @HeaderParam("X-Pruebas") boolean pruebas) {
        return Response.ok(new ResponseDTO(0, statementFEMPROFacade.findDataEmployee(cardCode, "FEMPROBN_NOVAWEB", pruebas))).build();
    }

    @GET
    @Path("femprobien/load-associated-requests")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response loadAssociatedRequests(@QueryParam("status") String status,
                                           @HeaderParam("X-Pruebas") boolean pruebas) {
        List<AssociatedFEMPRO> res = associatedFEMPROFacade.listAssociatedRequestsByStatus(status, "FEMPROBN_NOVAWEB", pruebas);
        return Response.ok(new ResponseDTO(0, res)).build();
    }

    @POST
    @Path("femprobien/add-associated")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Response addAssociated(AssociatedFemproDTO dto) throws ParseException {
        CONSOLE.log(Level.INFO, "Iniciando creacion de afiliado al femprobien");

        if (dto.getCode() == null || dto.getCode().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al creando el asociado. Campo code es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al creando el asociado. Campo code es obligatorio")).build();
        } else if (dto.getName() == null || dto.getName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al creando el asociado. Campo name es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al creando el asociado. Campo name es obligatorio")).build();
        } else if (dto.getCompanyName() == null || dto.getCompanyName().isEmpty()) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al creando el asociado. Campo companyName es obligatorio");
            return Response.ok(new ResponseDTO(-1, "Ocurrio un error al creando el asociado. Campo companyName es obligatorio")).build();
        }

        AssociatedFEMPRO entity = new AssociatedFEMPRO();
        entity.setCodAso(dto.getCode());
        entity.setNomAso(dto.getName());
        entity.setAp1Aso(dto.getApell1());
        entity.setAp2Aso(dto.getApell2());
        entity.setFecNac(dto.getBirthdate());
        entity.setFecIng(dto.getDateIngr());
        entity.setNomEmp(dto.getCompanyName());
        entity.setNomCar(dto.getJobTitle());
        entity.setSalBas(dto.getSalary());
        entity.setIngPre(dto.getIngresPrest());
        entity.setIngNoPre(dto.getIngresNoPrest());
        entity.setFecAfi(dto.getDateAfil());
        entity.setFecRet(dto.getDateRet());
        entity.setEstAso(dto.getStatus());
        entity.setDirRes(dto.getAddress());
        entity.setNomBar(dto.getLocality());
        entity.setTelCel(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setEstCivil(dto.getStatusCivil());
        entity.setCtaBan(dto.getAccountBanc());
        entity.setCtaTipo(dto.getTypeAccount());
        entity.setFdoBan(dto.getFdoBanc());
        entity.setApMes(dto.getApMonth());
        entity.setApPer1(dto.isApPeriod1());
        entity.setApPer2(dto.isApPeriod2());
        entity.setCodBen1(dto.getCodeBenef1());
        entity.setNomBen1(dto.getNameBenef1());
        entity.setParBen1(dto.getParentBenef1());
        entity.setCodBen2(dto.getCodeBenef2());
        entity.setNomBen2(dto.getNameBenef2());
        entity.setParBen2(dto.getParentBenef2());

        try {
            associatedFEMPROFacade.create(entity, "FEMPROBN_NOVAWEB", false);
            CONSOLE.log(Level.INFO, "El asociado ha sido creado exitosamente. Generando formulario de afiliacion.");
            //Generar reporte de afiliación
            PrintReportDTO printReportDTO = new PrintReportDTO();
            printReportDTO.setId(entity.getCodAso());
            printReportDTO.setCopias(0);
            printReportDTO.setDocumento("associatedForm");
            printReportDTO.setCompanyName("FEMPROBN_NOVAWEB");
            printReportDTO.setOrigen("N");
            printReportDTO.setFiltro(null);
            printReportDTO.setFiltroSec(null);
            printReportDTO.setImprimir(false);

            ResponseDTO res = reportREST.generateReport(printReportDTO);
            String UrlAttachment = "https://wali.igbcolombia.com/api/shared/FEMPROBN_NOVAWEB/associatedForm/" + dto.getCode() + ".pdf";

            //Notificar por email la afiliacion
            Map<String, String> params = new HashMap<>();
            params.put("cardName", entity.getNomAso() + ' ' + entity.getAp1Aso());
            params.put("cardCode", entity.getCodAso());
            params.put("docDate", new SimpleDateFormat("yyyy-MM-dd").format(entity.getFecAfi()));
            params.put("comment", "Pendiente por revisar");
            params.put("status", "NUEVO");

            sendEmail("NotificationAssociatedFemprobien", "Femprobien <soporte@igbcolombia.com>", "Nuevo asociado - Femprobien", "sistemas5@igbcolombia.com",
                    "sistemas5@igbcolombia.com", "sistemas5@igbcolombia.com", UrlAttachment, params);

            return Response.ok(new ResponseDTO(Integer.parseInt(entity.getCodAso()), UrlAttachment)).build();
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error creando el asosciado al fondo de empleados ", e);
            return Response.ok(new ResponseDTO(-1, entity)).build();
        }
    }

    private void sendEmail(String template, String from, String subject, String toAddress, String ccAddress, String bccAddress, String urlAdjunto, Map<String, String> params) {
        MailMessageDTO dtoMail = new MailMessageDTO();
        dtoMail.setTemplateName(template);
        dtoMail.setParams(params);
        dtoMail.setUrlAttachment(urlAdjunto);
        dtoMail.setFrom(from);
        dtoMail.setSubject(subject);
        dtoMail.addToAddress(toAddress);
        dtoMail.addBccAddress(bccAddress);
        dtoMail.addBccAddress(ccAddress);
        try {
            emailManager.sendEmailwithAttachment(dtoMail);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error al enviar la notificacion", e);
        }
    }
}
package co.manager.ejb;

import co.manager.dto.BusinessPartnerDTO;
import co.manager.dto.CustomerOncreditDTO;
import co.manager.dto.ResponseDTO;
import co.manager.hanaws.client.businessPartners.BusinessPartnersClient;
import co.manager.hanaws.client.udo.FeResFisSnClient;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersEcommerceDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersRestDTO;
import co.manager.hanaws.dto.businessPartner.BusinessPartnersWithholdingTaxDTO;
import co.manager.hanaws.dto.udo.FeResFisSnDTO;
import co.manager.hanaws.dto.udo.FeResFisSnRestDTO;
import co.manager.persistence.facade.BusinessPartnerSAPFacade;
import co.manager.persistence.facade.CitySAPFacade;
import co.manager.util.Constants;
import com.google.gson.Gson;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@Stateless
public class BusinessPartnerEJB {
    private static final Logger CONSOLE = Logger.getLogger(BusinessPartnerEJB.class.getSimpleName());
    private BusinessPartnersClient service;

    @Inject
    private ManagerApplicationBean appBean;
    @EJB
    private SessionManager sessionManager;
    @EJB
    private CitySAPFacade citySAPFacade;
    @EJB
    private BusinessPartnerSAPFacade businessPartnerSAPFacade;

    @PostConstruct
    private void initialize() {
        try {
            service = new BusinessPartnersClient(Constants.HANAWS_SL_URL);
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "No fue posible iniciar la instancia de BusinessPartnersServiceLayer. ", e);
        }
    }

    public ResponseDTO createBusinessPartnerFromEcommerce(BusinessPartnerDTO dto) {
        String cardCode = "";
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                BusinessPartnersEcommerceDTO businessPartner = new BusinessPartnersEcommerceDTO();
                businessPartner.setCardCode(dto.getCardCode());
                businessPartner.setCardName(dto.getCardName().toUpperCase());
                businessPartner.setCardType("C");
                businessPartner.setFederalTaxID(dto.getLicTradNum());
                businessPartner.setProperties13(dto.getAcceptHabeasData());
                businessPartner.setGroupCode(100l);
                businessPartner.setPhone1(dto.getPhone());
                businessPartner.setPhone2(dto.getPhone());
                businessPartner.setCellular(dto.getCellular());
                businessPartner.setEmailAddress(dto.getMail().toUpperCase());
                businessPartner.setUmanejo("DIA");
                businessPartner.setUdocFormEntFE(1l);
                businessPartner.setUcelularFE(dto.getCellular());
                businessPartner.setUbpcortc("RS");
                businessPartner.setUbpcotdc("13");
                businessPartner.setUbpcotp("01");
                businessPartner.setUbpcocs(dto.getCodMunicipio());
                businessPartner.setUbpcoCity(dto.getCodMunicipio());
                businessPartner.setUbpcoNombre(dto.getFirstname().toUpperCase());
                businessPartner.setUbpco1Apellido(dto.getLastname1().toUpperCase());
                businessPartner.setUbpco2Apellido(dto.getLastname2().toUpperCase());
                businessPartner.setUbpcoAddress(dto.getAddress().toUpperCase());
                businessPartner.setUbpvtper("PNRE");
                businessPartner.setUtrasp("03");
                businessPartner.setPriceListNum(dto.getPriceList() == null ? 1 : Long.valueOf(dto.getPriceList()));
                if (dto.getCompanyName().contains("VELEZ")) {
                    businessPartner.setSalesPersonCode("05");
                    businessPartner.setUaddInFaElectronicaEmailContactoFE("facturas@motorepuestos.co;" + dto.getMail().toUpperCase());
                    businessPartner.setDebitorAccount("11100520");
                } else {
                    businessPartner.setSalesPersonCode("22");
                    businessPartner.setUaddInFaElectronicaEmailContactoFE(dto.getMail().toUpperCase());
                    businessPartner.setDebitorAccount("13050505");
                }
                businessPartner.setBilltoDefault("DIR WEB");
                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    businessPartner.setUfeccrea(date2);
                } catch (Exception e) {
                }

                List<BusinessPartnersEcommerceDTO.BPAddresses.BPAddress> addresses = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    BusinessPartnersEcommerceDTO.BPAddresses.BPAddress address = new BusinessPartnersEcommerceDTO.BPAddresses.BPAddress();
                    address.setAddressName("DIR WEB");
                    address.setStreet(dto.getAddress().toUpperCase());
                    address.setCity(citySAPFacade.getNameMunicipio(dto.getCodMunicipio(), dto.getCompanyName(), false));
                    address.setBlock(dto.getCodMunicipio());
                    address.setState(dto.getCodDepartamento());
                    address.setCountry("CO");

                    if (i == 0) {
                        address.setAddressType("bo_BillTo");
                    } else {
                        address.setAddressType("bo_ShipTo");
                        if (dto.getCompanyName().contains("VELEZ")) {
                            address.setTaxCode("IVAV01");
                        } else {
                            address.setTaxCode("IVAG19");
                        }
                    }

                    address.setBpCode(dto.getCardCode());
                    address.setRowNum(0l);
                    address.setUmunicipio(dto.getCodMunicipio());
                    addresses.add(address);
                }
                businessPartner.setBpAddresses(addresses);

                CONSOLE.log(Level.INFO, "Iniciando creacion de socio de negocio para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(businessPartner);
                CONSOLE.log(Level.INFO, json);

                BusinessPartnersRestDTO res = service.addBusinessPartnerFromEcommerce(businessPartner, sessionId);
                cardCode = res.getCardCode();

                if (cardCode.isEmpty()) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el socio de negocios satisfactoriamente");
                    //agregar las resposabilidades fiscales al socio de negocio
                    addRespFisSN(cardCode, res.getCardName(), "R-99-PN", "No aplica – Otros", sessionId, dto.getCompanyName());
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el socio de negocio ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, cardCode);
    }

    public ResponseDTO createBusinessPartnerFromOncredit(CustomerOncreditDTO dto, int digit) {
        String cardCode = "";
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                BusinessPartnersDTO businessPartner = new BusinessPartnersDTO();
                businessPartner.setCardCode("C" + dto.getCardCode());
                businessPartner.setCardName((dto.getLastName1() + " " + dto.getLastName2() + " " + dto.getFirstName()).toUpperCase());
                businessPartner.setCardType("C");
                businessPartner.setFederalTaxID(dto.getCardCode().replace("C", "") + "-" + digit);
                businessPartner.setGroupCode(100l);
                businessPartner.setPhone1(dto.getCellular());
                businessPartner.setPhone2(dto.getCellular());
                businessPartner.setCellular(dto.getCellular());
                businessPartner.setEmailAddress(dto.getEmail().toUpperCase());
                businessPartner.setUmanejo("DIA");
                businessPartner.setUdocFormEntFE(1l);
                businessPartner.setUcelularFE(dto.getCellular());
                businessPartner.setUbpcortc("RS");
                businessPartner.setUbpcotdc("13");
                businessPartner.setUbpcotp("01");
                businessPartner.setUbpcocs("05001");
                businessPartner.setUbpcoCity("05001");
                businessPartner.setUbpcoNombre(dto.getFirstName().toUpperCase());
                businessPartner.setUbpco1Apellido(dto.getLastName1().toUpperCase());
                businessPartner.setUbpco2Apellido(dto.getLastName2().toUpperCase());
                businessPartner.setUbpcoAddress("CALLE 98 SUR N 48 225");
                businessPartner.setUbpvtper("PNRE");
                businessPartner.setUtrasp("03");
                businessPartner.setPriceListNum(1l);
                businessPartner.setSalesPersonCode("22");
                businessPartner.setUaddInFaElectronicaEmailContactoFE(dto.getEmail().toUpperCase());
                businessPartner.setDebitorAccount("13050505");
                businessPartner.setBilltoDefault("DIR ONCREDIT");
                businessPartner.setUoncredit("Y");
                businessPartner.setUtipoNegocio("1");
                businessPartner.setCreditLimit(dto.getCupo() == null ? 0 : dto.getCupo());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    businessPartner.setUfeccrea(date2);
                } catch (Exception e) {
                }

                List<BusinessPartnersDTO.BPAddresses.BPAddress> addresses = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    BusinessPartnersDTO.BPAddresses.BPAddress address = new BusinessPartnersDTO.BPAddresses.BPAddress();
                    address.setAddressName("DIR ONCREDIT");
                    address.setStreet("CALLE 98 SUR N 48 225");
                    address.setCity("LA ESTRELLA");
                    address.setBlock("05380");
                    address.setState("05");
                    address.setCountry("CO");

                    if (i == 0) {
                        address.setAddressType("bo_BillTo");
                    } else {
                        address.setAddressType("bo_ShipTo");
                        address.setTaxCode("IVAG19");
                    }

                    address.setBpCode(businessPartner.getCardCode());
                    address.setRowNum(0l);
                    address.setUmunicipio("05380");
                    address.setUlatitud("0123456789");
                    address.setUlongitud("0123456789");
                    addresses.add(address);
                }
                businessPartner.setBpAddresses(addresses);

                if (dto.getCustomerContactPersons() != null) {
                    //Agregar co-deudor al cliente
                    List<BusinessPartnersDTO.ContactEmployees.ContactEmployee> contactEmployees = new ArrayList<>();
                    for (int i = 0; i < 1; i++) {
                        BusinessPartnersDTO.ContactEmployees.ContactEmployee contactEmployee = new BusinessPartnersDTO.ContactEmployees.ContactEmployee();
                        contactEmployee.setName(dto.getCustomerContactPersons().getDocIdent());
                        contactEmployee.setFirstName(dto.getCustomerContactPersons().getFirstName());
                        contactEmployee.setLastName(dto.getCustomerContactPersons().getLastName());
                        contactEmployee.setMobilePhone(dto.getCustomerContactPersons().getCellular());
                        contactEmployee.setEmail(dto.getCustomerContactPersons().getEmail());
                        contactEmployee.setTitle(dto.getCustomerContactPersons().getIdTypeDoc());

                        contactEmployees.add(contactEmployee);
                    }
                    businessPartner.setContactEmployees(contactEmployees);
                }

                CONSOLE.log(Level.INFO, "Iniciando creacion de socio de negocio para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(businessPartner);
                CONSOLE.log(Level.INFO, json);

                BusinessPartnersRestDTO res = service.addBusinessPartnerFromWali(businessPartner, sessionId);
                cardCode = res.getCardCode();

                if (cardCode.isEmpty()) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el socio de negocios satisfactoriamente.");
                    //agregar las resposabilidades fiscales al socio de negocio
                    addRespFisSN(cardCode, res.getCardName(), "R-99-PN", "No aplica – Otros", sessionId, dto.getCompanyName());
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el socio de negocio ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, "Cliente creado exitosamente. " + cardCode);
    }

    public ResponseDTO createBusinessPartnerFromWali(BusinessPartnerDTO dto) {
        String cardCode = "";
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                BusinessPartnersDTO businessPartner = new BusinessPartnersDTO();
                businessPartner.setCardCode(dto.getCardCode());
                businessPartner.setCardName(dto.getCardName());
                businessPartner.setCardType("cCustomer");
                businessPartner.setFederalTaxID(dto.getLicTradNum());
                businessPartner.setProperties4(dto.getDocumentRut());
                businessPartner.setProperties13(dto.getAcceptHabeasData());
                businessPartner.setProperties15(dto.getFidelity());
                businessPartner.setGroupCode(Long.valueOf(dto.getGrupo()));
                businessPartner.setPhone1(dto.getPhone());
                businessPartner.setPhone2(dto.getCellular());
                businessPartner.setCellular(dto.getCellular());
                businessPartner.setEmailAddress(dto.getMail());
                businessPartner.setUmanejo("DIA");
                businessPartner.setUdocFormEntFE(1l);
                businessPartner.setUcelularFE(dto.getCellular());
                businessPartner.setUbpcortc(dto.getTaxRegimen());
                businessPartner.setUbpcotdc(dto.getTypeDoc());
                businessPartner.setUbpcotp(dto.getTypePerson());
                businessPartner.setUbpcocs(dto.getCodeCity());
                businessPartner.setUbpcoCity(dto.getCodeCity());
                businessPartner.setUbpcoNombre(dto.getFirstname());
                businessPartner.setUbpco1Apellido(dto.getLastname1());
                businessPartner.setUbpco2Apellido(dto.getLastname2());
                businessPartner.setUbpcoAddress(dto.getAddressMM());
                businessPartner.setUtrasp(dto.getTransp());
                businessPartner.setTerritory(Long.valueOf(dto.getZona()));
                businessPartner.setContactPerson(dto.getContactPerson());
                businessPartner.setUregional(dto.getRegional());
                businessPartner.setPayTermsGrpCode(Long.valueOf(dto.getPaymentCondition()));
                businessPartner.setDiscountPercent(dto.getDiscount());
                businessPartner.setVatLiable(dto.getTaxType());
                businessPartner.setCreditLimit(dto.getCreditLimit());
                businessPartner.setMaxCommitment(dto.getComiteLimit());
                businessPartner.setSubjectToWithholdingTax(dto.getSubject());
                businessPartner.setUproFidelizacion(dto.getDistributo());
                businessPartner.setPriceListNum(Long.valueOf(dto.getPriceList()));
                businessPartner.setFreeText(dto.getComment());
                businessPartner.setUtipoNegocio(dto.getTypeSell());

                try {
                    String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    businessPartner.setUfeccrea(date2);
                } catch (Exception e) {
                }

                List<BusinessPartnersDTO.ContactEmployees.ContactEmployee> contactEmployees = new ArrayList<>();
                for (int i = 0; i < 1; i++) {
                    BusinessPartnersDTO.ContactEmployees.ContactEmployee contactEmployee = new BusinessPartnersDTO.ContactEmployees.ContactEmployee();
                    contactEmployee.setName(dto.getContactPerson());
                    contactEmployee.setFirstName(dto.getNameContactPerson());
                    contactEmployee.setMiddleName(dto.getSecondNamecontactPerson());
                    contactEmployee.setLastName(dto.getLastNameContactPerson());
                    contactEmployee.setPosition(dto.getOccupationContactPerson());
                    contactEmployee.setPhone1(dto.getPhoneContactPerson());
                    contactEmployee.setDateOfBirth(dto.getDateContactPerson());
                    contactEmployees.add(contactEmployee);
                }
                businessPartner.setContactEmployees(contactEmployees);

                if (dto.getCompanyName().contains("VELEZ")) {
                    businessPartner.setGroupCode(100l);
                    businessPartner.setBilltoDefault("DIR WEB");
                    businessPartner.setUbpcortc("RS");
                    businessPartner.setUbpcotdc("13");
                    businessPartner.setUbpcotp("01");
                    businessPartner.setSalesPersonCode("05");
                    businessPartner.setUaddInFaElectronicaEmailContactoFE("facturas@motorepuestos.co;" + dto.getMailFE());
                    businessPartner.setDebitorAccount("11100520");
                } else {
                    businessPartner.setBilltoDefault(dto.getIdAddress());
                    businessPartner.setSalesPersonCode(dto.getSlpCode());
                    businessPartner.setUaddInFaElectronicaEmailContactoFE(dto.getMailFE());
                    businessPartner.setDebitorAccount("13050505");
                }

                List<BusinessPartnersDTO.BPAddresses.BPAddress> addresses = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    BusinessPartnersDTO.BPAddresses.BPAddress address = new BusinessPartnersDTO.BPAddresses.BPAddress();
                    address.setStreet(dto.getAddress());
                    address.setCity(citySAPFacade.getNameMunicipio(dto.getCodMunicipio(), dto.getCompanyName(), false));
                    address.setBlock(dto.getCodMunicipio());
                    address.setState(dto.getCodDepartamento());
                    address.setCountry("CO");
                    address.setUlatitud(dto.getLatitudeMap());
                    address.setUlongitud(dto.getLengthMap());

                    if (i == 0) {
                        address.setAddressType("bo_BillTo");
                        if (dto.getCompanyName().contains("VELEZ")) {
                            address.setAddressName("DIR WEB");
                        } else {
                            address.setAddressName(dto.getIdAddress());
                        }
                    } else {
                        address.setAddressType("bo_ShipTo");
                        if (dto.getCompanyName().contains("VELEZ")) {
                            address.setAddressName("DIR WEB");
                            address.setTaxCode("IVAV01");
                        } else {
                            address.setAddressName(dto.getIdAddress());
                            address.setTaxCode(dto.getTaxAddress());
                        }
                    }

                    address.setBpCode(dto.getCardCode());
                    address.setRowNum(0l);
                    address.setUmunicipio(dto.getCodMunicipio());
                    addresses.add(address);
                }
                businessPartner.setBpAddresses(addresses);

                List<BusinessPartnersDTO.BPWithholdingTaxCollection.BPWithholdingTax> bpWithholdingTaxes = new ArrayList<>();
                for (BusinessPartnerDTO.WithholdingTax obj : dto.getWithholdingTax()) {
                    BusinessPartnersDTO.BPWithholdingTaxCollection.BPWithholdingTax bpWithholdingTax = new BusinessPartnersDTO.BPWithholdingTaxCollection.BPWithholdingTax();
                    bpWithholdingTax.setWtCode(obj.getWtCode());
                    bpWithholdingTax.setBpCode(dto.getCardCode());

                    bpWithholdingTaxes.add(bpWithholdingTax);
                }
                businessPartner.setBpWithholdingTaxCollection(bpWithholdingTaxes);

                CONSOLE.log(Level.INFO, "Iniciando creacion de socio de negocio para {0}", dto.getCompanyName());
                Gson gson = new Gson();
                String json = gson.toJson(businessPartner);
                CONSOLE.log(Level.INFO, json);
                BusinessPartnersRestDTO res = service.addBusinessPartnerFromWali(businessPartner, sessionId);
                cardCode = res.getCardCode();

                if (cardCode.isEmpty()) {
                    CONSOLE.log(Level.WARNING, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                    return new ResponseDTO(-1, "Ocurrió un problema al crear el socio de negocio. Resetear el sesión ID.");
                } else {
                    CONSOLE.log(Level.INFO, "Se creo el socio de negocios satisfactoriamente");
                    //agregar las resposabilidades fiscales al socio de negocio
                    if (dto.getCompanyName().contains("VELEZ")) {
                        addRespFisSN(cardCode, res.getCardName(), "R-99-PN", "No aplica – Otros", sessionId, dto.getCompanyName());
                    } else {
                        addRespFisSN(cardCode, res.getCardName(), dto.getCodeResFis(), dto.getDescResFis(), sessionId, dto.getCompanyName());
                    }
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el socio de negocio ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, cardCode);
    }

    public ResponseDTO updateBusinessPartnerFromWali(BusinessPartnerDTO dto) {
        //1. Login
        String sessionId = null;
        try {
            sessionId = sessionManager.login(dto.getCompanyName());
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                //Reiniciar los códigos de retenciones de impuestos para aplicar actualizaciones.
                BusinessPartnersWithholdingTaxDTO businessPartnersWithholdingTaxDTO = new BusinessPartnersWithholdingTaxDTO();
                List<BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax> businessPartnersWithholdingTaxes = new ArrayList<>();
                BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax businessPartnersWithholdingTax = new BusinessPartnersWithholdingTaxDTO.BPWithholdingTaxCollection.BPWithholdingTax();
                businessPartnersWithholdingTax.setWtCode("");
                businessPartnersWithholdingTax.setBpCode("");
                businessPartnersWithholdingTaxes.add(businessPartnersWithholdingTax);
                businessPartnersWithholdingTaxDTO.setBpWithholdingTaxCollection(businessPartnersWithholdingTaxes);

                try {
                    service.updateBPWithholdingTaxCollection(businessPartnersWithholdingTaxDTO, dto.getCardCode(), sessionId);
                } catch (Exception e) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error al vaciar los codigos de retencion del socio de negocio " + dto.getCardCode() + " en " + dto.getCompanyName(), e);
                }
                //Obtener el objeto completo para asignar los valores que se van a modificar
                BusinessPartnersRestDTO businessPartnersRestDTO = service.getBusinessPartner(dto.getCardCode(), sessionId);

                businessPartnersRestDTO.setCardCode(dto.getCardCode());
                businessPartnersRestDTO.setCardName(dto.getCardName());
                businessPartnersRestDTO.setCardType(businessPartnersRestDTO.getCardType());
                businessPartnersRestDTO.setGroupCode(Long.valueOf(dto.getGrupo()));
                businessPartnersRestDTO.setFederalTaxID(dto.getLicTradNum());
                businessPartnersRestDTO.setProperties4(dto.getDocumentRut());
                businessPartnersRestDTO.setProperties13(dto.getAcceptHabeasData());
                businessPartnersRestDTO.setProperties15(dto.getFidelity());
                businessPartnersRestDTO.setPhone1(dto.getPhone());
                businessPartnersRestDTO.setPhone2(dto.getCellular());
                businessPartnersRestDTO.setCellular(dto.getCellular());
                businessPartnersRestDTO.setEmailAddress(dto.getMail());
                businessPartnersRestDTO.setUcelularFE(dto.getCellular());
                businessPartnersRestDTO.setUbpcortc(dto.getTaxRegimen());
                businessPartnersRestDTO.setUbpcotdc(dto.getTypeDoc());
                businessPartnersRestDTO.setUbpcotp(dto.getTypePerson());
                businessPartnersRestDTO.setUbpcocs(dto.getCodeCity());
                businessPartnersRestDTO.setUbpcoCity(dto.getCodeCity());
                businessPartnersRestDTO.setUbpcoNombre(dto.getFirstname());
                businessPartnersRestDTO.setUbpco1Apellido(dto.getLastname1());
                businessPartnersRestDTO.setUbpco2Apellido(dto.getLastname2());
                businessPartnersRestDTO.setUbpcoAddress(dto.getAddress());
                businessPartnersRestDTO.setTerritory(Long.valueOf(dto.getZona()));
                businessPartnersRestDTO.setContactPerson(dto.getContactPerson());
                businessPartnersRestDTO.setUregional(dto.getRegional());
                businessPartnersRestDTO.setPayTermsGrpCode(Long.valueOf(dto.getPaymentCondition()));
                businessPartnersRestDTO.setDiscountPercent(dto.getDiscount());
                businessPartnersRestDTO.setVatLiable(dto.getTaxType());
                businessPartnersRestDTO.setCreditLimit(dto.getCreditLimit());
                businessPartnersRestDTO.setMaxCommitment(dto.getComiteLimit());
                businessPartnersRestDTO.setSubjectToWithholdingTax(dto.getSubject());
                businessPartnersRestDTO.setUproFidelizacion(dto.getDistributo());
                businessPartnersRestDTO.setPriceListNum(Long.valueOf(dto.getPriceList()));
                businessPartnersRestDTO.setUtrasp(dto.getTransp());
                businessPartnersRestDTO.setUtipoNegocio(dto.getTypeSell());

                if (dto.getCompanyName().contains("VELEZ")) {
                    businessPartnersRestDTO.setUaddInFaElectronicaEmailContactoFE("facturas@motorepuestos.co;" + dto.getMailFE());
                } else {
                    businessPartnersRestDTO.setSalesPersonCode(Long.valueOf(dto.getSlpCode()));
                    businessPartnersRestDTO.setUaddInFaElectronicaEmailContactoFE(dto.getMailFE());
                }
                //Asignación de códigos para impuestos de retención
                List<BusinessPartnersRestDTO.BPWithholdingTaxCollection.BPWithholdingTax>
                        bpWithholdingTaxes = new ArrayList<>();
                for (BusinessPartnerDTO.WithholdingTax obj : dto.getWithholdingTax()) {
                    BusinessPartnersRestDTO.BPWithholdingTaxCollection.BPWithholdingTax bpWithholdingTax = new BusinessPartnersRestDTO.BPWithholdingTaxCollection.BPWithholdingTax();
                    bpWithholdingTax.setWtCode(obj.getWtCode());
                    bpWithholdingTax.setBpCode(dto.getCardCode());

                    bpWithholdingTaxes.add(bpWithholdingTax);
                }
                businessPartnersRestDTO.setBpWithholdingTaxCollection(bpWithholdingTaxes);

                CONSOLE.log(Level.INFO, "Actualizando información del socio de negocio {0} para {1}", new Object[]{dto.getCardCode(), dto.getCompanyName()});
                Gson gson = new Gson();
                String json = gson.toJson(businessPartnersRestDTO);
                CONSOLE.log(Level.INFO, json);
                try {
                    service.updateBusinessPartner(businessPartnersRestDTO, dto.getCardCode(), sessionId);
                } catch (Exception e) {
                    CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el socio de negocio " + dto.getCardCode() + " en " + dto.getCompanyName(), e);
                    return new ResponseDTO(-1, "Ocurrio un error actualizando el socio de negocio " + dto.getCardCode());
                }
                //TODO: pendiente la modificación de responsabilidad fiscal, direcciones, persona de contacto
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error actualizando el socio de negocio " + dto.getCardCode() + " en " + dto.getCompanyName(), e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        CONSOLE.log(Level.INFO, "Socio de negocio [" + dto.getCardCode() + "] actualizado con exito en " + dto.getCompanyName());
        return new ResponseDTO(0, "Socio de negocio [" + dto.getCardCode() + "] actualizado con exito.");
    }

    private void addRespFisSN(String cardCode, String cardName, String codeResFis, String descResFis, String sessionId, String companyName) {
        FeResFisSnClient client = new FeResFisSnClient(Constants.HANAWS_SL_URL);
        FeResFisSnDTO header = new FeResFisSnDTO();
        List<FeResFisSnDTO.FeResFisSnLDTO> detail = new ArrayList<>();

        header.setPeriod(151l);
        header.setInstance(0l);
        header.setHandwrtten("N");
        header.setStatus("O");
        header.setRequestStatus("W");
        header.setCanceled("N");
        header.setObject("FE_RES_FIS_SN");
        header.setTransfered("N");
        header.setDataSource("O");
        header.setuCardCode(cardCode);
        header.setuCardName(cardName);

        try {
            String date2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            header.setCreateDate(date2);
            header.setUpdateDate(date2);
        } catch (Exception e) {
        }

        FeResFisSnDTO.FeResFisSnLDTO detailLine = new FeResFisSnDTO.FeResFisSnLDTO();
        detailLine.setLineId(1l);
        detailLine.setVisOrder(1l);
        detailLine.setObject("FE_RES_FIS_SN");
        detailLine.setLogInst(null);
        detailLine.setuCodeResFis(codeResFis);
        detailLine.setuDescResFis(descResFis);
        detailLine.setuLineNum(1l);

        detail.add(detailLine);
        header.setFeResFisSnLDTO(detail);

        CONSOLE.log(Level.INFO, "Iniciando creacion de responsabilidad fiscal para {0}", companyName);
        Gson gson = new Gson();
        String json = gson.toJson(header);
        CONSOLE.log(Level.INFO, json);

        try {
            FeResFisSnRestDTO res = client.addResFisSN(header, sessionId);
            if (res.getuCardCode().isEmpty()) {
                CONSOLE.log(Level.WARNING, "Ocurrio una novedad registrando las responsabilidades fiscales para el socio de negocio {0} en {1}", new Object[]{cardCode, companyName});
            } else {
                CONSOLE.log(Level.INFO, "Registro de responsabilidades fiscales exitoso.");
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error registrando las responsabilidades fiscales. ", e);
        }
    }

    public ResponseDTO addRespFisMassiveSN(String companyName, List<Object[]> customers) {
        //1. Login0
        String sessionId = null;
        try {
            sessionId = sessionManager.login(companyName);
            if (sessionId != null) {
                CONSOLE.log(Level.INFO, "Se inicio sesion en DI Server satisfactoriamente. SessionID={0}", sessionId);
            } else {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al iniciar sesion en el DI Server.");
                return new ResponseDTO(-1, "Ocurrio un error al iniciar sesion en el DI Server.");
            }
        } catch (Exception ignored) {
        }
        //2. Procesar documento
        if (sessionId != null) {
            try {
                for (Object[] obj : customers) {
                    //agregar las resposabilidades fiscales al socio de negocio
                    addRespFisSN((String) obj[0], (String) obj[1], "R-99-PN", "No aplica – Otros", sessionId, companyName);
                }
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al crear el socio de negocio ", e);
                return new ResponseDTO(-1, e.getMessage());
            }
        }
        //3. Logout
        if (sessionId != null) {
            String resp = sessionManager.logout(sessionId);
            if (resp.equals("error")) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error al cerrar la sesion [{0}] de DI Server", sessionId);
            } else {
                CONSOLE.log(Level.INFO, "Se cerro la sesion [{0}] de DI Server correctamente", sessionId);
            }
        }
        return new ResponseDTO(0, "Registro de responsabilidades fiscales exitoso.");
    }
}
package co.manager.ejb;

import co.manager.dto.ResponseDTO;
import co.manager.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * @author jguisao
 */
@ApplicationScoped
@Named("managerApplicationBean")
@Path("application")
public class ManagerApplicationBean implements Serializable {

    private static final Logger CONSOLE = Logger.getLogger(ManagerApplicationBean.class.getSimpleName());

    private Properties props = new Properties();
    private HashSet<String> excludedPaths;
    private List<Pattern> excludedPathTemplates;

    @PostConstruct
    private void initialize() {
        loadProperties();
    }

    @GET
    @Path("recargar/")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response reloadConfig(@QueryParam("showprops") String showProps, @QueryParam("pruebas") boolean pruebas) {
        initialize();
        if (StringUtils.isNotBlank(showProps) && showProps.equals("yes")) {
            return Response.ok(new ResponseDTO(0, props)).build();
        } else {
            return Response.ok(new ResponseDTO(0, null)).build();
        }
    }

    private void loadProperties() {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(System.getProperty("PROPERTIES_SECRET"));
        props = new EncryptableProperties(encryptor);

        String serverConfUrl = System.getProperty("jboss.server.config.dir");
        CONSOLE.log(Level.INFO, "Server config URL [{0}]", serverConfUrl);
        String propertiesFileName = "manager.properties";
        String path = serverConfUrl + File.separator + propertiesFileName;
        CONSOLE.log(Level.INFO, "Loading properties file: [{0}]", path);

        try {
            File propsFile = new File(path);
            if (propsFile.exists()) {
                props.load(new FileInputStream(propsFile));
            } else {
                props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/" + propertiesFileName));
            }

            String pathValues = props.getProperty(Constants.NO_FILTER_PATHS);
            excludedPaths = new HashSet<>(Arrays.asList(pathValues.split(",")));

            String templateValues = props.getProperty(Constants.NO_FILTER_TEMPLATES);
            excludedPathTemplates = new ArrayList<>();
            for (String regex : templateValues.split(",")) {
                excludedPathTemplates.add(Pattern.compile(regex));
            }
        } catch (Exception e) {
            CONSOLE.log(Level.SEVERE, "There was an error loading the file.", e);
        }
    }

    public String obtenerValorPropiedad(String prop) {
        String value = props.getProperty(prop);
        if (value.equals("IGB,Pa$$w0rd;VARROC,Pa$$w0rd;IGBPruebas,Pa$$w0rd;VARROCPruebas,Pa$$w0rd")) {
            value = value + ";VELEZ,Pa$$w0rd;VELEZPruebas,Pa$$w0rd";
        }
        return value;
    }
}
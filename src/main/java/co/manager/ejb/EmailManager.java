package co.manager.ejb;

import co.manager.dto.MailMessageDTO;
import co.manager.util.Constants;
import org.apache.commons.lang.text.StrSubstitutor;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jguisao
 */
@SessionScoped
@Named("emailManager")
public class EmailManager implements Serializable {

    private static final Logger CONSOLE = Logger.getLogger(EmailManager.class.getSimpleName());
    private String username;
    private String password;
    private String host;
    private String templatesFolder;
    private String port;
    private Properties propsConn;

    @Inject
    private ManagerApplicationBean appBean;


    @PostConstruct
    protected void initialize() {
        username = appBean.obtenerValorPropiedad(Constants.EMAIL_USERNAME);
        password = appBean.obtenerValorPropiedad(Constants.EMAIL_PASSWORD);
        host = appBean.obtenerValorPropiedad(Constants.EMAIL_HOST);
        templatesFolder = appBean.obtenerValorPropiedad("mail.templates");
        port = appBean.obtenerValorPropiedad(Constants.EMAIL_PORT);
        inicializarParametros();
    }

    private void inicializarParametros() {
        propsConn = new Properties();
        propsConn.put("mail.smtp.auth", "true");
        propsConn.put("mail.smtp.starttls.enable", "false");
        propsConn.put("mail.smtp.host", host);
        propsConn.put("mail.smtp.port", "25");
        propsConn.put("mail.smtp.port", port);
    }

    public void sendMailClientCapture(MailMessageDTO dto) throws Exception {
        Session session = Session.getInstance(propsConn, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(dto.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getToList()));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(dto.getCcList()));
            message.addRecipients(Message.RecipientType.BCC, InternetAddress.parse(dto.getBccList()));
            message.setSubject(dto.getSubject());
            try {
                String fullTemplateName = appBean.obtenerValorPropiedad(Constants.EMAIL_TEMPLATES) + dto.getTemplateName() + ".html";
                String templateContent = new String(Files.readAllBytes(Paths.get(fullTemplateName)), StandardCharsets.UTF_8);
                message.setContent(StrSubstitutor.replace(templateContent, dto.getParams()), "text/html");
            } catch (Exception e) {
                throw new Exception("No fue posible enviar ");
            }
            CONSOLE.log(Level.INFO, "Enviando datos al email {0}", dto.getTo());
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
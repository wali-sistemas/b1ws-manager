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
import java.util.Date;
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

    @Inject
    private ManagerApplicationBean appBean;

    @PostConstruct
    protected void initialize() {
        username = appBean.obtenerValorPropiedad(Constants.EMAIL_USERNAME);
        password = appBean.obtenerValorPropiedad(Constants.EMAIL_PASSWORD);
        host = appBean.obtenerValorPropiedad(Constants.EMAIL_HOST);
        templatesFolder = appBean.obtenerValorPropiedad("mail.templates");
        port = appBean.obtenerValorPropiedad(Constants.EMAIL_PORT);
    }

    public Properties getEmailProperties() {
        Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", host);
        config.put("mail.smtp.port", port);
        return config;
    }

    public void sendEmail(MailMessageDTO dto) throws Exception {
        Session session = Session.getInstance(getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(dto.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getToList()));
            //message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(dto.getCcList()));
            message.setSubject(dto.getSubject());
            message.setSentDate(new Date());
            try {
                String fullTemplateName = appBean.obtenerValorPropiedad(Constants.EMAIL_TEMPLATES) + dto.getTemplateName() + ".html";
                String templateContent = new String(Files.readAllBytes(Paths.get(fullTemplateName)), StandardCharsets.UTF_8);
                message.setContent(StrSubstitutor.replace(templateContent, dto.getParams()), "text/html");
            } catch (Exception e) {
                CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando el email", e);
                throw new Exception("Ocurrio un error enviando el email");
            }
            CONSOLE.log(Level.INFO, "Enviando datos al email {0}", dto.getTo());
            Transport.send(message);
        } catch (MessagingException e) {
            CONSOLE.log(Level.SEVERE, "Ocurrio un error enviando el email", e);
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
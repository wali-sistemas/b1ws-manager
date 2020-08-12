package co.manager.ejb;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Email {
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private static final String SERVIDOR_SMTP = "smtp.office365.com";
    private static final int PORTA_SERVIDOR_SMTP = 587;
    private static final String CONTA_PADRAO = "sistemas2@igbcolombia.com";
    private static final String SENHA_CONTA_PADRAO = "Mtz2020*";

    private final String from = "sistemas2@igbcolombia.com";
    private final String to = "soporte@igbcolombia.com";
    private final String cc = "soporte@igbcolombia.com";

    private final String subject = "Prueba";
    private final String messageContent = "Prueba 2 enviando mail desde Java usando office 365";

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.smtp.auth", "true");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SERVIDOR_SMTP);
        config.put("mail.smtp.port", PORTA_SERVIDOR_SMTP);
        return config;
    }

    public void sendEmail() {
        final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CONTA_PADRAO, SENHA_CONTA_PADRAO);
            }

        });

        try {
            final Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            message.setSubject(subject);
            message.setText(messageContent);
            message.setSentDate(new Date());
            Transport.send(message);
        } catch (final MessagingException ex) {
            LOGGER.log(Level.WARNING, "Error enviar mensage: " + ex.getMessage(), ex);
        }
    }

    public static void main(final String[] args) {
        new Email().sendEmail();
    }
}
package reporting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;

import static java.io.File.separator;
import static logging.CVLogging.getLogger;

public class MailableReport {
    private static Logger logger = getLogger();
    private static Session session;
    private static String username;
    private static String password;
    private static String host;
    private static String port;

    public MailableReport() {
        this.username = "apps@rupeek.com";
        this.password = "";
        this.host = "smtp.rupeek.com";
        this.port = "587";
        session = getSession();

    }

    private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        return session;
    }

    public MimeMessage sendMail(String recipientList) {
        try {
            if(recipientList == null){
                logger.severe("No mail recipient");
                return null;
            }
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientList));
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientList));
            message.setSubject("Mobile Automation Test Report");
            File file = new File("target" + separator + "summary.html");
            StringBuilder contentBuilder = new StringBuilder();
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader(file));
                String str;
                while ((str = in.readLine()) != null) {
                    contentBuilder.append(str);
                }
            } catch (IOException e) {
                logger.info("Exception: " + e);
            }
            finally {
                in.close();
            }
            String content = contentBuilder.toString().trim();
            message.setContent(content, "text/html");
            //send the message
            Transport.send(message);

            logger.info("Email sent successfully...");
            return message;

        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
package reporting;

import io.cucumber.java.eo.Se;
import utils.TestConfigurationReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import static java.io.File.separator;
import static logging.CVLogging.LOG_FILE;
import static logging.CVLogging.getLogger;

public class MailWithAttachmentService {

    private static Logger logger = getLogger();

    private String username;
    private String password;
    private String host;
    private String port;
    private Session session;


    public MailWithAttachmentService() {
        this.username = "rajat.gupta@rupeek.com";
        this.password = "";
        this.host = "smtp.rupeek.com";
        this.port = "587";
        session = getSession();

    }

    public MailWithAttachmentService(String username, String password, String host, String port) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.session = getSession();
    }

    private Session getSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", this.host);
        props.put("mail.smtp.port", this.port);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        return session;
    }

    public Message createMail(String recipientList) throws MessagingException, IOException{

        logger.info(String.format("Sending mail to %s", recipientList));

        if(recipientList == null){
            logger.severe("No mail recipient");
            return null;
        }

        Message message = new MimeMessage(this.session);
       message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientList));
        message.setSubject("Mobile Automation Test Report");
        logger.info("Mail Subject: " + message.getSubject());
          File file =   new File("target" + separator + "summary.html");
            StringBuilder contentBuilder = new StringBuilder();
            try {
                BufferedReader in = new BufferedReader(new FileReader(file));
                String str;
                while ((str = in.readLine()) != null) {
                    contentBuilder.append(str);
                }
                in.close();
            } catch (IOException e) {
            }
            String content = contentBuilder.toString().trim();
        message.setContent(content,"text/html");
        logger.info("Mail Content: " + message .getContent());
        return message;
    }

    private static void addAttachment(Multipart multipart, List<File> files) throws IOException,MessagingException{
        for(File file: files){
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(file);
            multipart.addBodyPart(mimeBodyPart);
        }
    }

    public void sendMail(String recipientList) throws AddressException, MessagingException, IOException {
        try{
        Thread.sleep(5 * 1000);
        }
        catch (InterruptedException e){

        }
        Message message = createMail(recipientList);
        logger.info("Message: " + message);
        Transport.send(message);
    }



    public static void main(String[] args) throws Exception{
//        Properties properties = TestConfigurationReader.getProperties();
//        String recipientList = properties.getProperty("report.recipient.list");
//        MailWithAttachmentService mailWithAttachmentService = new MailWithAttachmentService();
//        mailWithAttachmentService.sendMail(recipientList);
    }

}
package prodobro.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Date;
import java.util.Properties;
public class AttachmentWithText {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("xx@gmail.com", "xx"); //valid email and correspondent password
                    }
                });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("xxgmail.com")); //from email
            msg.setRecipients(Message.RecipientType.TO, "yy@zz.com"); //to email
            msg.setSubject("Text Mail with Attachment."); //message subject
            msg.setSentDate(new Date());

            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            String textContent = "Please find the Attachment."; //message body
            textPart.setText(textContent);
            multipart.addBodyPart(textPart);

            MimeBodyPart attachementPart = new MimeBodyPart();
            attachementPart.attachFile(new File("C:\\SavedImages\\1.jpg")); //choose an attachment
            multipart.addBodyPart(attachementPart);

            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("---Done---");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

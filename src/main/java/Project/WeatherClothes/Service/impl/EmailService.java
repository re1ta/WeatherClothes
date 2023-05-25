package Project.WeatherClothes.Service.impl;

import Project.WeatherClothes.Service.EmailAddition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService implements EmailAddition {

    @Value("${MAIL_TO}")
    private String mailTo;

    @Value("${MAIL_FROM}")
    private String mailFrom;

    @Value("${PASSWORD_MAIL}")
    private String password_mail;

    @Override
    public void sendEmailMessage(String text){
        Properties properties = new Properties();
        String from = mailTo;
        String to = mailFrom;
        properties.put("mail.smtp.host","smtp.mail.ru");
        properties.put("mail.smtp.post","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session = Session.getInstance(
                properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password_mail);
                    }
                }
        );
        session.setDebug(true);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, to);
            message.setSubject("Кол-во пользователей за день");
            message.setText(text);
            Transport.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
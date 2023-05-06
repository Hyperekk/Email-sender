package com.example.emailsender;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class KontrolerProgram {
    public Button btnSend;
    public TextField txtFrom;
    public TextField txtTo;
    public TextArea txtContent;
    public String password;

    public String from;

    public void initialize()
    {
        from = (DataExchange.odbiorca);
        password = (DataExchange.haslo);
        txtFrom.setDisable(true);
    }

    public void btnSendWyslij(ActionEvent actionEvent)
    {
        String to = txtTo.getText();
        String tresc = txtContent.getText();

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.poczta.onet.pl");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new MyAuthenticator(from, password));

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Email");
            message.setText(tresc);
            Transport.send(message);
            System.out.println("Wiadomość została wysłana!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}

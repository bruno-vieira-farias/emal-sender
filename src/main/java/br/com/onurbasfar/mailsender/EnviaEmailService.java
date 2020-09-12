package br.com.onurbasfar.mailsender;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EnviaEmailService {
    private Session session;
    private String from;

    public EnviaEmailService(String server, String port, String ssl, String from, String password) {
        this.from = from;
        setup(server, port, ssl, password);
    }

    public void enviaEmail( String destinatario,String assunto, String mensagem) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));

            Address[] toUser = InternetAddress.parse(destinatario);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
            message.setText(mensagem);

            Transport.send(message);
            System.out.println("Email enviado com sucesso!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void setup(String server, String port, String ssl, final String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", server);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", ssl);
        props.put("mail.smtp.port", port);

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        session.setDebug(true);
    }
}
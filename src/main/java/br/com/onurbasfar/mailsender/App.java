package br.com.onurbasfar.mailsender;

import br.com.onurbasfar.mailsender.config.GlobalConfig;
import br.com.onurbasfar.mailsender.config.GlobalConfigLoader;

public class App {

    public static void main(String[] args) {
        String destinatario = args[0];
        String assunto = args[1];
        String mensagem = args[2];

        GlobalConfig config = new GlobalConfigLoader("config.properties").load();

        EnviaEmailService emailService = new EnviaEmailService(
                config.getSmtpServer(),
                config.getSmtpPort(),
                config.getSmtpSsl(),
                config.getFrom(),
                config.getPassword()
        );

        emailService.enviaEmail(destinatario, assunto, mensagem);
    }
}
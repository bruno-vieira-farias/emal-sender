package br.com.onurbasfar.mailsender.config;

public class GlobalConfig {
    private String smtpServer;
    private String smtpPort;
    private String smtpSsl;
    private String from;
    private String password;

    public GlobalConfig(String smtpServer, String smtpPort, String smtpSsl, String from, String password) {
        this.smtpServer = smtpServer;
        this.smtpPort = smtpPort;
        this.smtpSsl = smtpSsl;
        this.from = from;
        this.password = password;
    }

    public String getSmtpServer() {
        return smtpServer;
    }

    public String getSmtpPort() {
        return smtpPort;
    }

    public String getSmtpSsl() {
        return smtpSsl;
    }

    public String getFrom() {
        return from;
    }

    public String getPassword() {
        return password;
    }
}

package br.com.onurbasfar.mailsender.config;

import java.util.*;

public class GlobalConfigLoader {
    private String configPropertyName;

    public GlobalConfigLoader(String configPropertyName) {
        this.configPropertyName = configPropertyName;
    }

    public GlobalConfig load(){
        try {
        Properties prop = new Properties();
            prop.load(ClassLoader.getSystemResourceAsStream(configPropertyName));
            return new GlobalConfig(
                    prop.getProperty("mailsender.smtp.server"),
                    prop.getProperty("mailsender.smtp.port"),
                    prop.getProperty("mailsender.smtp.ssl"),
                    prop.getProperty("mailsender.from"),
                    prop.getProperty("mailsender.password")
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}




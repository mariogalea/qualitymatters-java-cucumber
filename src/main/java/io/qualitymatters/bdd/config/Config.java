package io.qualitymatters.bdd.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties properties;

    public Config(String configFilePath) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBaseUrl() {

        return properties.getProperty("base.url");

    }

    public String getBasicAuthenticationUsername() {

        return properties.getProperty("ba.username");

    }

    public String getBasicAuthenticationPassword() {

        return properties.getProperty("ba.password");
        
    }
}
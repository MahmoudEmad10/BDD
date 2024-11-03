package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader {
    /*
    initialize the properties file
     */
    private final Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream input = Files.newInputStream(Paths.get("src/test/resources/config/testData.properties"))) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getBaseUrl() {
        String baseUrl = properties.getProperty("BASE_URL");
        if (baseUrl == null) {
            throw new IllegalStateException("BASE_URL property is not set in testData.properties");
        }
        return baseUrl;
    }

    public String getBrowserName() {
        String browser = properties.getProperty("browser");
        if (browser == null) {
            throw new IllegalStateException("browser property is not set in testData.properties");
        }
        return browser;
    }

    public String getUserName() {
        String username = properties.getProperty("username");
        if (username == null) {
            throw new IllegalStateException("username property is not set in testData.properties");
        }
        return username;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        if (password == null) {
            throw new IllegalStateException("password property is not set in testData.properties");
        }
        return password;
    }

}

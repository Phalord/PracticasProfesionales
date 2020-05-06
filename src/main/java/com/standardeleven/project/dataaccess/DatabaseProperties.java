package com.standardeleven.project.dataaccess;

import java.io.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProperties {
    private final Properties properties = new Properties();

    public DatabaseProperties() {
        setURL("url:port/database");
        setUsername("username");
        setPassword("password");
    }

    public void setURL(String url) {
        properties.setProperty("url", url);
    }

    public void setUsername(String username) {
        properties.setProperty("username", username);
    }

    public void setPassword(String password) {
        properties.setProperty("password", password);
    }

    public Properties getProperties() {
        return properties;
    }

    public void setDatabaseConfig(String url, String username, String password) {
        setURL(url);
        setUsername(username);
        setPassword(password);
    }

    public void saveProperties() throws FileNotFoundException {
        OutputStream propertiesFile = new FileOutputStream("dbConfig.properties");
        try {
            properties.store(propertiesFile, null);
        } catch (IOException exception) {
            Logger.getLogger(DatabaseProperties.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    public void loadProperties() throws FileNotFoundException{
        InputStream is = new FileInputStream("dbConfig.properties");
        try {
            properties.load(is);
            setDatabaseConfig(properties.getProperty("url"), properties
                    .getProperty("username"), properties.getProperty("password"));
        } catch (IOException exception) {
            saveProperties();
            Logger.getLogger(DatabaseProperties.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }
}

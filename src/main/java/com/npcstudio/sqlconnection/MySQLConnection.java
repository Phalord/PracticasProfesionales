package com.npcstudio.sqlconnection;


import com.standardeleven.project.dataaccess.DatabaseProperties;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
    private final DatabaseProperties databaseProperties = new DatabaseProperties();
    private Connection connection = null;
    private String database;
    private String username;
    private String password;

    public MySQLConnection() {
        try {
            readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        connect();
        return connection;
    }

    public void readProperties() throws FileNotFoundException {
        databaseProperties.loadProperties();
        Properties properties = databaseProperties.getProperties();
        setDatabase(properties.getProperty("url"));
        setUsername(properties.getProperty("username"));
        setPassword(properties.getProperty("password"));
    }

    public void saveProperties() throws FileNotFoundException{
        databaseProperties.saveProperties();
    }

    private void connect() throws SQLException {
        String driver = "jdbc:mysql://";
        connection = DriverManager.getConnection(String.format("%s%s", driver, database), username, password);
    }

    public void closeConnection() {
        if(connection != null) {
            try {
                if(!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException exception) {
                Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
}

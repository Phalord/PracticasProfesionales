package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IAccountDAO;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDAO implements IAccountDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public AccountDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public boolean logIn(String username, String password) {
        boolean result;
        String query = "Select * from usuario where usuario=? && contraseña=?";
        try{
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            result = resultSet.next();
        } catch (SQLException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            return false;
        }
        return result;
    }

    @Override
    public String getAccountType(String username) {
        String result = "";
        String query = "Select tipoCuenta from usuario where usuario=?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getString("tipoCuenta");
            }
        } catch (SQLException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            return null;
        }
        return result;
    }
}
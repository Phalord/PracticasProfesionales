package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements IUserDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public UserDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("usuario"));
                user.setUserPassword(resultSet.getString("contraseña"));
                user.setUserType(resultSet.getString("tipoCuenta"));
                users.add(user);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return users;
    }

    @Override
    public User getUserByEnrollment(String userName) {
        User user = null;
        String query = "SELECT * FROM usuario WHERE usuario = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString("usuario"));
                user.setUserPassword(resultSet.getString("contraseña"));
                user.setUserType(resultSet.getString("tipoCuenta"));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        result = false;
        String query = "INSERT INTO usuario(usuario,contraseña,tipoCuenta) VALUES(?,?,?)";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setString(3, user.getUserType());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return  result;
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Operation not yet supported");
    }

    @Override
    public boolean deleteUser(User user) {
        throw new UnsupportedOperationException("Operation not yet supported");
    }
}

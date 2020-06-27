package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;
import org.mindrot.jbcrypt.BCrypt;

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
    private boolean result;

    public UserDAO() {
        mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM usuario";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("usuario"));
                user.setUserPassword(resultSet.getString("contraseñaHash"));
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
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userName);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = new User();
                    user.setUserName(resultSet.getString("usuario"));
                    user.setUserPassword(resultSet.getString("contraseñaHash"));
                    user.setUserType(resultSet.getString("tipoCuenta"));
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        result = false;
        String query = "INSERT INTO usuario(usuario,contraseñaHash,tipoCuenta) VALUES(?,?,?)";
        String passwordAux = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt(10));
        try (Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, passwordAux);
            preparedStatement.setString(3, user.getUserType());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean updateUser(User user) {
        throw new UnsupportedOperationException("Operation not yet supported");
    }

    @Override
    public boolean deleteUser(User user) {
        result = false;
        String query = "DELETE FROM usuario WHERE usuario = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }
}

package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO implements IUserDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    UserDAO() {
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

        return null;
    }

    @Override
    public User getUserByEnrollment(String userName) {
        return null;
    }

    @Override
    public void addUser(String enrollment, String password) {

    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}

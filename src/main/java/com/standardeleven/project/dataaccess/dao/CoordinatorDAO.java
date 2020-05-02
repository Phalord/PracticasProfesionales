package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.standardeleven.project.logical.Coordinator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoordinatorDAO implements ICoordinatorDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public CoordinatorDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<Coordinator> getAllCoordinators(){
        List<Coordinator> coordinators = new ArrayList<>();
        String query = "SELECT * FROM coordinador";
        try {
            connection = mySQLConnection.getConnection();
            if (connection.isClosed()) {
                Exception exception = new Exception("Connection Lost with Server");
                Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            } else {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    Coordinator coordinator = new Coordinator();
                    fillCoordinator(coordinator);
                    coordinators.add(coordinator);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return coordinators;
    }

    @Override
    public Coordinator getCoordinator(String coordinatorPersonalNumber) {
        Coordinator coordinator = null;
        String query = "SELECT * FROM coordinador WHERE NumeroPersonalCoordinador = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, coordinatorPersonalNumber);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                coordinator = new Coordinator();
                fillCoordinator(coordinator);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return coordinator;
    }

    @Override
    public boolean addCoordinator(Coordinator coordinator) {
        result = false;
        String sql = String.format("INSERT INTO Coordinador(NumeroPersonalCoordinador,%s",
                "Nombre,ApellidoPaterno,ApellidoMaterno) VALUES(?,?,?,?)");
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, coordinator.getUserName());
            preparedStatement.setString(2, coordinator.getCoordinatorName());
            preparedStatement.setString(3, coordinator.getCoordinatorFatherSurname());
            preparedStatement.setString(4, coordinator.getCoordinatorMotherSurname());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean updateCoordinator(Coordinator coordinator) {
        result = false;
        String query = String.format("UPDATE coordinador SET Nombre=?,%s",
                " ApellidoPaterno=?, ApellidoMaterno=? WHERE NumeroPersonalCoordinador=?");
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, coordinator.getCoordinatorName());
            preparedStatement.setString(2, coordinator.getCoordinatorFatherSurname());
            preparedStatement.setString(3, coordinator.getCoordinatorMotherSurname());
            preparedStatement.setString(4, coordinator.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deleteCoordinator(Coordinator coordinator){
        result = false;
        String query = "DELETE FROM coordinador WHERE NumeroPersonalCoordinador = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,coordinator.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    private void fillCoordinator(Coordinator coordinator) throws SQLException{
        coordinator.setUserName(resultSet.getString("NumeroPersonalCoordinador"));
        coordinator.setCoordinatorName(resultSet.getString("Nombre"));
        coordinator.setCoordinatorFatherSurname(resultSet.getString("ApellidoPaterno"));
        coordinator.setCoordinatorMotherSurname(resultSet.getString("ApellidoMaterno"));
    }
}

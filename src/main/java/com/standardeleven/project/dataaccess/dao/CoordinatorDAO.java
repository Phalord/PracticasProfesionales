package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;
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
        this.mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<Coordinator> getAllCoordinators(){
        List<Coordinator> coordinators = new ArrayList<>();
        String query = "SELECT * FROM coordinador";
        try {
            connection = mySQLConnection.getConnection();
            if(connection.isClosed()) {
                Exception exception = new Exception("Connection Lost with Server");
                Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            } else {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    Coordinator coordinator = new Coordinator();
                    coordinator.setCoordinatorFullName(resultSet.getString("NombreCompletoCoordinador"));
                    coordinator.setCoordinatorNumberPersonal(resultSet.getString("NumeroPersonalCoordinador"));
                    coordinators.add(coordinator);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return coordinators;
    }
    
    @Override
    public boolean addCoordinator(Coordinator coordinator) {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "INSERT INTO Coordinador(NumeroPersonalCoordinador,NombreCompletoCoordinador,ContraseñaCoordinador) VALUES(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,coordinator.getCoordinatorNumberPersonal());
            preparedStatement.setString(2,coordinator.getCoordinatorFullName());
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
        try {
            connection = mySQLConnection.getConnection();
            String sql = "UPDATE coordinador SET NombreCompletoCoordinador=?, ContraseñaCoordinador=? WHERE NumeroPersonalCoordinador=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(3,coordinator.getCoordinatorNumberPersonal());
            preparedStatement.setString(1,coordinator.getCoordinatorFullName());
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
        try {
            connection = mySQLConnection.getConnection();
            String sql = "DELETE FROM coordinador WHERE NumeroPersonalCoordinador = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,coordinator.getCoordinatorNumberPersonal());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(CoordinatorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }
}

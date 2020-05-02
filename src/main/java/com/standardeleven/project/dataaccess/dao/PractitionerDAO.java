package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.logical.Practitioner;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PractitionerDAO implements IPractitionerDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public PractitionerDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<Practitioner> getAllPractitioners() {
        List<Practitioner> practitioners = new ArrayList<>();
        String query = "SELECT * FROM practicante";
        try {
            connection = mySQLConnection.getConnection();
            if(connection.isClosed()) {
                Exception exception = new Exception("Connection Lost with Server");
                Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            } else {
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    Practitioner practitioner = new Practitioner();
                    fillPractitioner(practitioner, resultSet);
                    practitioners.add(practitioner);
                }
            }
        } catch(SQLException sqlException) {
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return practitioners;
    }

    @Override
    public Practitioner getPractitioner(String studentEnrollment) {
        Practitioner practitioner = null;
        String query = "SELECT * FROM practicante WHERE Matricula = ?";
        try {
            connection = mySQLConnection.getConnection();
            if (!connection.isClosed()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, studentEnrollment);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()) {
                    practitioner = new Practitioner();
                    fillPractitioner(practitioner, resultSet);
                }
            } else {
                Exception exception = new Exception("Connection Lost with Server");
                Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return practitioner;
    }

    @Override
    public boolean addPractitioner(Practitioner practitioner) {
        result = false;
        String query = String.format("INSERT INTO practicante(Matricula,Nombre,ApellidoPaterno,%s",
                "ApellidoMaterno,Turno) VALUES(?,?,?,?,?)");
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, practitioner.getUserName());
            preparedStatement.setString(2, practitioner.getStudentName());
            preparedStatement.setString(3, practitioner.getStudentFatherSurname());
            preparedStatement.setString(4, practitioner.getStudentMotherSurname());
            preparedStatement.setString(5, practitioner.getStudentShift());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deletePractitioner(Practitioner practitioner) {
        result = false;
        String query = "DELETE FROM practicante WHERE matricula = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, practitioner.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    private static void fillPractitioner(Practitioner practitioner, ResultSet resultSet) throws SQLException{
        practitioner.setUserName(resultSet.getString("Matricula"));
        practitioner.setStudentName(resultSet.getString("Nombre"));
        practitioner.setStudentFatherSurname(resultSet.getString("ApellidoPaterno"));
        practitioner.setStudentMotherSurname(resultSet.getString("ApellidoMaterno"));
        practitioner.setStudentShift(resultSet.getString("Turno"));
        practitioner.setStudentGrade(resultSet.getInt("Calificacion"));
    }
}

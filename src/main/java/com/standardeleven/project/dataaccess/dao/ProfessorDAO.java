package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.logical.Professor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class ProfessorDAO implements IProfessorDAO {
    private final MySQLConnection mySQLConnection;
    private boolean result;

    public ProfessorDAO() {
        mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<Professor> getAllProfessors() {
        List <Professor> professors = new ArrayList<>();
        String query = "SELECT * FROM profesor";
        try (Connection connection = mySQLConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while(resultSet.next()) {
                Professor professor = new Professor();
                fillProfessor(resultSet, professor);
                professors.add(professor);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return professors;
    }

    @Override
    public Professor getProfessor(String personalNumber) {
        Professor professor = null;
        String query = "SELECT * FROM profesor WHERE NumeroPersonalProfesor = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, personalNumber);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    professor = new Professor();
                    fillProfessor(resultSet, professor);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return professor;
    }
    
    @Override
    public boolean addProfessor(Professor professor) {
        result = false;
        String query = String.format("INSERT INTO profesor(NumeroPersonalProfesor,Nombre,%s",
                "ApellidoPaterno,ApellidoMaterno,Turno) VALUES(?,?,?,?,?)");
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,professor.getUserName());
            preparedStatement.setString(2,professor.getProfessorNames());
            preparedStatement.setString(3,professor.getProfessorFatherSurname());
            preparedStatement.setString(4,professor.getProfessorMotherSurname());
            preparedStatement.setString(5,professor.getProfessorShift());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean updateProfessor(Professor professor) {
        result = false;
        String query = String.format("UPDATE profesor SET Nombre=?, ApellidoPaterno=?,%s",
                " ApellidoMaterno=?, Turno=? WHERE NumeroPersonalProfesor=?");
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,professor.getProfessorNames());
            preparedStatement.setString(2,professor.getProfessorFatherSurname());
            preparedStatement.setString(3,professor.getProfessorMotherSurname());
            preparedStatement.setString(4,professor.getProfessorShift());
            preparedStatement.setString(5,professor.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deleteProfessor(Professor professor) {
        result = false;
        String query = "DELETE FROM profesor WHERE NumeroPersonalProfesor = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,professor.getUserName());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }
    
    @Override
    public void fillProfessorInformation(Connection mySQLConnection, ObservableList<Professor> listProfessor) {
        String query = "SELECT * FROM profesor";
        try {
            Statement instruction = mySQLConnection.createStatement();
            ResultSet resultQuery = instruction.executeQuery(query);
            while(resultQuery.next()){
                Professor professor = new Professor();
                fillProfessor(resultQuery,professor);
                listProfessor.add(professor);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }  
    }
    
    private void fillProfessor(ResultSet resultSet, Professor professor) throws SQLException {
        professor.setUserName(resultSet.getString("NumeroPersonalProfesor"));
        professor.setProfessorNames(resultSet.getString("Nombre"));
        professor.setProfessorFatherSurname(resultSet.getString("ApellidoPaterno"));
        professor.setProfessorMotherSurname(resultSet.getString("ApellidoMaterno"));
        professor.setProfessorShift(resultSet.getString("Turno"));
    }
}

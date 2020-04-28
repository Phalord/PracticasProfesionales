package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Professor;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfessorDAO implements IProfessorDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public ProfessorDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<Professor> getAllProfessors() {
        List <Professor> professors = new ArrayList<>();
        String sql = "SELECT * FROM Profesor";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
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
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, personalNumber);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                professor = new Professor();
                fillProfessor(resultSet, professor);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return professor;
    }

    public void fillProfessor(ResultSet resultSet, Professor professor) throws SQLException{
        professor.setProfessorNumberPersonal(resultSet.getString("NumeroPersonalProfesor"));
        professor.setProfessorNames(resultSet.getString("Nombre"));
        professor.setProfessorFatherSurname(resultSet.getString("ApellidoPaterno"));
        professor.setProfessorMotherSurname(resultSet.getString("ApellidoMaterno"));
        professor.setProfessorShift(resultSet.getString("Turno"));
    }
    
    @Override
    public boolean addProfessor(Professor professor) {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "INSERT INTO Profesor(NumeroPersonalProfesor,Nombre,ApellidoPaterno,ApellidoMaterno,Turno) VALUES(?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,professor.getProfessorNumberPersonal());
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
        try {
            connection = mySQLConnection.getConnection();
            String sql = "UPDATE profesor SET Nombre=?, ApellidoPaterno=?, ApellidoMaterno=?, Turno=? WHERE NumeroPersonalProfesor=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,professor.getProfessorNames());
            preparedStatement.setString(2,professor.getProfessorFatherSurname());
            preparedStatement.setString(3,professor.getProfessorMotherSurname());
            preparedStatement.setString(4,professor.getProfessorShift());
            preparedStatement.setString(5,professor.getProfessorNumberPersonal());
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
        try {
            connection = mySQLConnection.getConnection();
            String sql = "DELETE FROM profesor WHERE NumeroPersonalProfesor = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,professor.getProfessorNumberPersonal());
            int numberRowsAffected = statement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }
}

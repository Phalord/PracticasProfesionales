package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.logical.Professor;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IProfessorDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public ProfessorDAO() {
        this.mySQLConnection = new MySQLConnection();
    }
    
    @Override
    public boolean addProfessor(Professor professor) throws SQLException {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "INSERT INTO Profesor(NumeroPersonalProfesor,Nombre,ApellidoPaterno,ApellidoMaterno,Turno,Contraseña) VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,professor.getProfessorNumberPersonal());
            statement.setString(2,professor.getProfessorNames());
            statement.setString(3,professor.getProfessorFatherSurname());
            statement.setString(4,professor.getProfessorMotherSurname());
            statement.setString(5,professor.getProfessorShift());
            statement.setString(6,professor.getProfessorPassword());
            int numberRowsAffected = statement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException e) {
            System.out.println("No se pudo registrar el Profesor, Intente de nuevo."+e.getMessage());
        }
        return result;
    }

    @Override
    public boolean updateProfessor(Professor professor) throws SQLException, ClassNotFoundException {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "UPDATE profesor SET Nombre=?, ApellidoPaterno=?, ApellidoMaterno=?, Turno=?, Contraseña=? WHERE NumeroPersonalProfesor=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(6,professor.getProfessorNumberPersonal());
            statement.setString(1,professor.getProfessorNames());
            statement.setString(2,professor.getProfessorFatherSurname());
            statement.setString(3,professor.getProfessorMotherSurname());
            statement.setString(4,professor.getProfessorShift());
            statement.setString(5,professor.getProfessorPassword());
            int numberRowsAffected = statement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException e) {
            System.out.println("No se pudo actualizar el Profesor, Intente de nuevo. " + e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteProfessor(Professor professor) throws SQLException, ClassNotFoundException {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "DELETE FROM profesor WHERE NumeroPersonalProfesor = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,professor.getProfessorNumberPersonal());
            int numberRowsAffected = statement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException e) {
            System.out.println("No se pudo eliminar el Profesor, Intente de nuevo." + e.getMessage());
        }
        return result;
    }
    

    @Override
    public List<Professor> getListProfessor() throws SQLException, ClassNotFoundException {
        List <Professor> professorList = null;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "select * from Profesor";
            PreparedStatement statement = connection.prepareStatement(sql);
            professorList = new ArrayList();
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                Professor professor = new Professor();
                professor.setProfessorNumberPersonal(resultset.getString("NumeroPersonalProfesor"));
                professor.setProfessorNames(resultset.getString("Nombre"));
                professor.setProfessorFatherSurname(resultset.getString("ApellidoPaterno"));
                professor.setProfessorMotherSurname(resultset.getString("ApellidoMaterno"));
                professor.setProfessorShift(resultset.getString("Turno"));
                professor.setProfessorPassword(resultset.getString("Contraseña"));                
                professorList.add(professor);
            }
            resultset.close();
            statement.close();
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No se pudieron mostrar los datos del Profesor, Intente de nuevo." + e.getMessage());
        }
        return professorList;
    }
}

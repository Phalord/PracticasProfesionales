package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Project;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectDAO implements IProjectDAO {
    private final MySQLConnection mySQLConnection;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public ProjectDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM proyecto";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Project project = new Project(resultSet.getString("NombreProyecto"),
                        resultSet.getString("Descripcion"), resultSet.getString("Recursos"),
                        resultSet.getString("Matricula"), resultSet.
                        getString("idResponsableProyecto"));
                projects.add(project);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return projects;
    }

    @Override
    public List<Project> getAllAvailableProjects() {
        List<Project> projects = new ArrayList<>();
        String query = "SELECT * FROM proyecto WHERE Matricula IS NULL";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Project project = new Project();
                fillProject(resultSet, project);
                projects.add(project);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return projects;
    }

    @Override
    public Project getProject(int idProject) {
        Project project = null;
        String query = "SELECT * FROM proyecto WHERE idProyecto = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idProject);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                project = new Project();
                fillProject(resultSet, project);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return project;
    }

    @Override
    public boolean assignPractitioner(Practitioner practitioner, int idProject) {
        result = false;
        String studentEnrollment = practitioner.getStudentEnrollment();
        String query = "UPDATE proyecto SET Matricula = ? WHERE proyecto.idProyecto = ?";
        try {
            connection = mySQLConnection.getConnection();
            if(!connection.isClosed()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, studentEnrollment);
                preparedStatement.setInt(2, idProject);
                int numberRowsAffected = preparedStatement.executeUpdate();
                result = (0 < numberRowsAffected);
            } else {
                Exception exception = new Exception("Connection Lost with Server");
                Logger.getLogger(PractitionerDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean addProject(Project project) {
        result = false;
        String sql = String
                .format("INSERT INTO proyecto(NombreProyecto,Descripcion,Recursos,%s",
                        "idResponsableProyecto) VALUES(?,?,?,?)");
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,project.getProjectName());
            preparedStatement.setString(2,project.getProjectDescription());
            preparedStatement.setString(3,project.getProjectResource());
            preparedStatement.setString(4,project.getIdProjectManager());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean updateProject(Project project) {
        result = false;
        String sql = String.format("UPDATE proyecto SET Descripcion=?, Recursos=?, Matricula=?,%s",
                " NumeroPersonalCoordinador=? WHERE NombreProyecto=?");
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(5,project.getProjectName());
            preparedStatement.setString(1,project.getProjectDescription());
            preparedStatement.setString(2,project.getProjectResource());
            preparedStatement.setString(3,project.getStudentEnrollment());
            preparedStatement.setString(4,project.getIdProjectManager());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;    }

    @Override
    public boolean deleteProject(Project project) {
        result = false;
        try {
            connection = mySQLConnection.getConnection();
            String sql = "DELETE FROM proyecto WHERE idProyecto = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,project.getProjectID());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    public void fillProject(ResultSet resultSet, Project project) throws SQLException {
        project.setProjectID(resultSet.getInt("idProyecto"));
        project.setProjectName(resultSet.getString("NombreProyecto"));
        project.setProjectDescription(resultSet.getString("Descripcion"));
        project.setProjectResource(resultSet.getString("Recursos"));
        project.setStudentEnrollment(resultSet.getString("Matricula"));
        project.setIdProjectManager(resultSet.getString("idResponsableProyecto"));
    }
}

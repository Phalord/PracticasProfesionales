package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IProjectApplicationDAO;
import com.standardeleven.project.logical.ProjectApplication;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectApplicationDAO implements IProjectApplicationDAO {
    private final MySQLConnection mySQLConnection;
    private boolean result;

    public ProjectApplicationDAO() {
        mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<ProjectApplication> getAllProjectApplications() {
        List<ProjectApplication> projectApplications = new ArrayList<>();
        String query = "SELECT * FROM solicitud";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                ProjectApplication projectApplication = new ProjectApplication();
                fillProjectApplications(projectApplication, resultSet);
                projectApplications.add(projectApplication);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectApplicationDAO.class.getName())
                    .log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return projectApplications;
    }

    @Override
    public ProjectApplication getProjectApplicationByID(int idProjectApplication) {
        ProjectApplication projectApplication = null;
        String query = "SELECT * FROM solicitud WHERE idSolicitud = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idProjectApplication);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    projectApplication = new ProjectApplication();
                    fillProjectApplications(projectApplication, resultSet);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectApplicationDAO.class.getName())
                    .log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return projectApplication;
    }

    @Override
    public ProjectApplication getProjectApplicationByStudentEnrollment(String studentEnrollment) {
        ProjectApplication projectApplication = null;
        String query = "SELECT * FROM solicitud WHERE practicante = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, studentEnrollment);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    projectApplication = new ProjectApplication();
                    fillProjectApplications(projectApplication, resultSet);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectApplicationDAO.class.getName())
                    .log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return projectApplication;
    }

    @Override
    public boolean addProjectApplication(ProjectApplication projectApplication) {
        result = false;
        String query = String.format("INSERT INTO solicitud(estadoSolicitud,practicante,proyectoOpcionUno,%s",
                "ProyectoOpcionDos,ProyectoOpcionTres) VALUES (?, ?, ?, ?, ?)");
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, projectApplication.isProjectStatus());
            preparedStatement.setString(2, projectApplication.getPractitionerEnrollment());
            preparedStatement.setInt(3, projectApplication.getProjectOption1());
            preparedStatement.setInt(4, projectApplication.getProjectOption2());
            preparedStatement.setInt(5, projectApplication.getProjectOption3());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0 );
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectApplicationDAO.class.getName())
                    .log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deleteProjectApplication(ProjectApplication projectApplication) {
        result = false;
        String query = "DELETE FROM solicitud WHERE idSolicitud = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, projectApplication.getIdProjectApplication());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ProjectApplicationDAO.class.getName())
                    .log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    private void fillProjectApplications(ProjectApplication projectApplication, ResultSet resultSet) throws SQLException {
        projectApplication.setIdProjectApplication(resultSet.getInt("idSolicitud"));
        projectApplication.setProjectStatus(resultSet.getBoolean("estadoSolicitud"));
        projectApplication.setPractitionerEnrollment(resultSet.getString("practicante"));
        projectApplication.setProjectOption1(resultSet.getInt("proyectoOpcionUno"));
        projectApplication.setProjectOption2(resultSet.getInt("proyectoOpcionDos"));
        projectApplication.setProjectOption3(resultSet.getInt("proyectoOpcionTres"));
    }
}

package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IActivityDAO;
import com.standardeleven.project.logical.Activity;
import com.standardeleven.project.logical.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActivityDAO implements IActivityDAO {
    private final MySQLConnection mySQLConnection;
    private boolean result;

    public ActivityDAO() {
        mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<Activity> getAllActivities() {
        List<Activity> activities = new ArrayList<>();
        String query = "SELECT * FROM actividad";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Activity activity = new Activity();
                fillActivity(activity, resultSet);
                activities.add(activity);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return activities;
    }

    public List<Activity> getAllActivitiesByReportID(int reportID) {
        List<Activity> activities = new ArrayList<>();
        String query = "SELECT * FROM actividad WHERE idReporte = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, reportID);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    Activity activity = new Activity();
                    fillActivity(activity, resultSet);
                    activities.add(activity);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return activities;
    }

    @Override
    public Activity getActivityByID(int activityID) {
        Activity activity = null;
        String query = "SELECT * FROM actividad WHERE idActividad = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, activityID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    activity = new Activity();
                    fillActivity(activity, resultSet);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return activity;
    }

    @Override
    public boolean addActivity(Activity activity) {
        result = false;
        String query = String.format("INSERT INTO actividad(tituloActividad,idProyecto,matriculaEstudiante,%s",
                "descripcionActividad,fechaEntregaActividad, estadoActividad) VALUES (?,?,?,?,?,?)");
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, activity.getActivityTitle());
            preparedStatement.setInt(2, activity.getProjectID());
            preparedStatement.setString(3, activity.getStudentEnrollment());
            preparedStatement.setString(4, activity.getActivityDescription());
            preparedStatement.setDate(5, null);
            preparedStatement.setBoolean(6, activity.getActivityStatus());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean assignReport(Activity activity, Report report) {
        result = false;
        String query = "UPDATE actividad SET idReporte = ? WHERE idActividad = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, report.getReportID());
            preparedStatement.setInt(2, activity.getActivityID());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deleteActivity(Activity activity) {
        result = false;
        String query = "DELETE FROM actividad WHERE idActividad = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, activity.getActivityID());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return  result;
    }

    private void fillActivity(Activity activity, ResultSet resultSet) throws SQLException {
        activity.setActivityID(resultSet.getInt("idActividad"));
        activity.setActivityTitle(resultSet.getString("tituloActividad"));
        activity.setProjectID(resultSet.getInt("idProyecto"));
        activity.setStudentEnrollment(resultSet.getString("matriculaEstudiante"));
        activity.setActivityDeliveryDate(resultSet.getDate("fechaEntregaActividad"));
        activity.setActivityStatus(resultSet.getBoolean("estadoActividad"));
    }
}

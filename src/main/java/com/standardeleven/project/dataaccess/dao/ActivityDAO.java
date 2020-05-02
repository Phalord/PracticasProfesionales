package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IActivityDAO;
import com.standardeleven.project.logical.Activity;

import java.io.FileNotFoundException;
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
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private boolean result;

    public ActivityDAO() {
        mySQLConnection = new MySQLConnection();
        try {
            mySQLConnection.readProperties();
        } catch (FileNotFoundException exception) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, exception.getMessage(), exception);
        }
    }

    @Override
    public List<Activity> getAllActivityDescription() {
        List<Activity> activities = new ArrayList<>();
        String query = "SELECT * FROM actividad";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Activity activity = new Activity();
                fillActivity(activity);
                activities.add(activity);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return activities;
    }

    @Override
    public Activity getActivityDescriptionByID(int idActivity) {
        Activity activity = null;
        String query = "SELECT * FROM actividad WHERE idActividad = ?";
        try {
            connection = mySQLConnection.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idActivity);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                activity = new Activity();
                fillActivity(activity);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ActivityDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return activity;
    }

    @Override
    public void addActivity(Activity activity) {

    }

    @Override
    public void deleteActivity0(Activity activity) {

    }

    private void fillActivity(Activity activity) throws SQLException {
        activity.setProjectID(resultSet.getInt("idActividad"));
    }
}

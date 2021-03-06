package com.standardeleven.project.dataaccess.dao;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.idao.IReportDAO;
import com.standardeleven.project.logical.Report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReportDAO implements IReportDAO {
    private final MySQLConnection mySQLConnection;
    private boolean result;

    public ReportDAO() {
        mySQLConnection = new MySQLConnection();
    }

    @Override
    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM reporte";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Report report = new Report();
                fillReport(report, resultSet);
                reports.add(report);
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return reports;
    }

    @Override
    public Report getReportByID(int reportID) {
        Report report = null;
        String query = "SELECT * FROM reporte WHERE idReporte = ?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, reportID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    report = new Report();
                    fillReport(report, resultSet);
                }
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return report;
    }

    @Override
    public boolean addReport(Report report) {
        result = false;
        String query = String.format("INSERT INTO reporte(numeroReporteProyecto,horasCubiertasProyecto,%s",
                "periodoEscolar,expEducativaNRC) VALUES(?,?,?,?)");
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, report.getProjectReportNumber());
            preparedStatement.setInt(2, report.getProjectHoursCovered());
            preparedStatement.setString(3, report.getEducationalExperiencePeriod());
            preparedStatement.setString(4, report.getEducationalExperienceNRC());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    @Override
    public boolean deleteReport(Report report) {
        result = false;
        String query = "DELETE FROM reporte WHERE idReporte =?";
        try (Connection connection = mySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, report.getReportID());
            int numberRowsAffected = preparedStatement.executeUpdate();
            result = (numberRowsAffected > 0);
        } catch (SQLException sqlException) {
            Logger.getLogger(ReportDAO.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        return result;
    }

    private void fillReport(Report report, ResultSet resultSet) throws SQLException{
        report.setReportID(resultSet.getInt("idReporte"));
        report.setActivitiesAccomplished(new ActivityDAO().getAllActivitiesByReportID(report.getReportID()));
        report.setProjectReportNumber(resultSet.getInt("numeroReporteProyecto"));
        report.setProjectHoursCovered(resultSet.getInt("horasCubiertasProyecto"));
        report.setEducationalExperiencePeriod(resultSet.getString("periodoEscolar"));
        report.setEducationalExperienceNRC(resultSet.getString("expEducativaNRC"));
    }
}

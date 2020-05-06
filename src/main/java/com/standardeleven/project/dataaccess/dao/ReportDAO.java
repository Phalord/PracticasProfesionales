package com.standardeleven.project.dataaccess.dao;

import com.standardeleven.project.dataaccess.idao.IReportDAO;
import com.standardeleven.project.logical.Report;
import java.sql.SQLException;
import java.util.List;

public class ReportDAO implements IReportDAO {

    @Override
    public List<Report> getAllReports() {
        return null;
    }

    @Override
    public Report getReportByID(int reportID) {
        return null;
    }

    @Override
    public boolean addReport(Report report) {
        return false;
    }

    @Override
    public boolean updateReport(Report report) {
        return false;
    }

    @Override
    public boolean deleteReport(Report report) {
        return false;
    }
}

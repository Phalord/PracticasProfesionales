package com.standardeleven.project.dataaccess.dao;

import com.standardeleven.project.dataaccess.idao.IReportDAO;
import com.standardeleven.project.logical.Report;
import java.sql.SQLException;
import java.util.List;

public class ReportDAO implements IReportDAO {

    @Override
    public boolean addReport(Report report) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateReport(Report report) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteReport(Report report) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Report> getListReport() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

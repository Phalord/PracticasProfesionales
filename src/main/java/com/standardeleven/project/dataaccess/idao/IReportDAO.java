package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Report;
import java.sql.SQLException;
import java.util.List;

public interface IReportDAO {
    public boolean addReport(Report report) throws SQLException, ClassNotFoundException;
    public boolean updateReport(Report report) throws SQLException, ClassNotFoundException;
    public boolean deleteReport(Report report) throws SQLException, ClassNotFoundException;
    public List<Report> getListReport() throws SQLException, ClassNotFoundException; 
}

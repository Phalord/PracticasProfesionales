package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Report;
import java.sql.SQLException;
import java.util.List;

public interface IReportDAO {
    List<Report> getAllReports();
    Report getReportByID(int reportID);
    boolean addReport(Report report);
    boolean deleteReport(Report report);
}

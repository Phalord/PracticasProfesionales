package testdao;

import com.standardeleven.project.dataaccess.dao.ReportDAO;
import com.standardeleven.project.dataaccess.idao.IReportDAO;
import com.standardeleven.project.logical.Activity;
import com.standardeleven.project.logical.Report;

import java.util.List;

public class TestReportDAO {
    private static final IReportDAO iReportDAO = new ReportDAO();

    public static void main(String[] args) {
        testGetAllReports();
        testGetReportByID(5);
        testGetReportByID(2);
        testDeleteReport(5);
        testDeleteReport(3);
    }
    private static void testGetAllReports() {
        printTestTitle("Get All Reports");
        List<Report> reports = iReportDAO.getAllReports();
        if (!reports.isEmpty()) {
            for (Report report: reports) {
                print(report.toString());
            }
        } else {
            print("There are no Reports");
        }
        print("");
    }

    private static void testGetReportByID(int reportID) {
        printTestTitle("Get Report By ID");
        Report report = iReportDAO.getReportByID(reportID);
        if (report != null) {
            print(String.format("Reporte: %s", report.toString()));
        } else {
            print("Such report doesn't exist");
        }
        print("");
    }

    private static void testAddReport(String educationalExperienceNRC,
                                      String educationalExperiencePeriod, int projectHoursCovered,
                                      int projectReportNumber, List<Activity> activitiesAccomplished) {
        printTestTitle("Add Report");
        Report report = new Report();
        report.setEducationalExperienceNRC(educationalExperienceNRC);
        report.setEducationalExperiencePeriod(educationalExperiencePeriod);
        report.setProjectHoursCovered(projectHoursCovered);
        report.setProjectReportNumber(projectReportNumber);
        report.setActivitiesAccomplished(activitiesAccomplished);
        if (iReportDAO.addReport(report)) {
            print(String.format("Report %s added successfully", report.toString()));
        } else {
            print(String.format("Unable to add Report %s",
                    report.toString()));
        }
        print("");
    }

    private static void testDeleteReport(int reportID) {
        printTestTitle("Delete Report");
        Report report = iReportDAO.getReportByID(reportID);
        if (report != null) {
            if (iReportDAO.deleteReport(report)) {
                print(String.format("Report %s deleted successfully", report.toString()));
            } else {
                print(String.format("Unable to delete Report %s", report.toString()));
            }
        } else {
            print("That Report doesn't exist");
        }
        print("");
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

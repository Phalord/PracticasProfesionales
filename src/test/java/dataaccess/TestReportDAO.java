package dataaccess;

import com.standardeleven.project.dataaccess.dao.ReportDAO;
import com.standardeleven.project.dataaccess.idao.IReportDAO;
import com.standardeleven.project.logical.Activity;
import com.standardeleven.project.logical.Report;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestReportDAO {
    private static final IReportDAO iReportDAO = new ReportDAO();

    public static void main(String[] args) {
    }

    @Test
    public void testGetAllReports() {
        printTestTitle("Get All Reports");
        List<Report> reports = iReportDAO.getAllReports();
        assertTrue(reports.isEmpty());
        print();
    }

    @Test
    public void testGetReportByID() {
        printTestTitle("Get Report By ID");
        Report report = iReportDAO.getReportByID(2);
        assertEquals(2, report.getReportID());
        print();
    }

    @Test
    public void testAddReport() {
        printTestTitle("Add Report");
        Report report = new Report();
        report.setEducationalExperienceNRC("87590");
        report.setEducationalExperiencePeriod("AGO 2020 - ENE 2021");
        report.setProjectHoursCovered(100);
        report.setProjectReportNumber(1);
        report.setActivitiesAccomplished(getActivitiesAccomplished());
        assertTrue(iReportDAO.addReport(report));
        print();
    }

    @Test
    public void testDeleteReport() {
        printTestTitle("Delete Report");
        Report report = iReportDAO.getReportByID(3);
        if (report != null) {
            assertTrue(iReportDAO.deleteReport(report));
        } else {
            fail();
        }
        print();
    }

    private static void print() {
        System.out.println();
    }

    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
    private List<Activity> getActivitiesAccomplished() {
        List<Activity> activities = new ArrayList<>();
        fillActivities(activities);
        return activities;
    }
    private void fillActivities(List<Activity> activities) {
        activities.add(newActivity(1, "Activity 1 Title", "Activity 1 Description", 8));
        activities.add(newActivity(2, "Activity 2 Title", "Activity 2 Description", 5));
        activities.add(newActivity(3, "Activity 3 Title", "Activity 3 Description", 8));
    }
    private Activity newActivity(int activityID, String activityTitle, String activityDescription, int projectID) {
        Activity activity = new Activity();
        activity.setActivityID(activityID);
        activity.setActivityTitle(activityTitle);
        activity.setActivityDescription(activityDescription);
        activity.setProjectID(projectID);
        activity.setActivityDeliveryDate(new Date());
        activity.setActivityStatus(true);
        return activity;
    }
}

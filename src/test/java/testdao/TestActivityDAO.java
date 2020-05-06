package testdao;

import com.standardeleven.project.dataaccess.dao.ActivityDAO;
import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.dataaccess.idao.IActivityDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Activity;

import java.util.List;

public class TestActivityDAO {
    private final static IActivityDAO iActivityDAO = new ActivityDAO();

    public static void main(String[] args) {
        testGetAllActivities();
        testGetActivityByID();
        testAddActivity();
        testDeleteActivity();
    }

    private static void testGetAllActivities() {
        printTestTitle("Get All Activities");
        List<Activity> activities = iActivityDAO.getAllActivities();
        if (activities != null) {
            for (Activity activity: activities) {
                print(activity.toString());
            }
        } else {
            print("There are no activities");
        }
        print("");
    }

    private static void testGetActivityByID() {
        printTestTitle("Get Activity By ID");
        Activity activity = iActivityDAO.getActivityByID(8);
        if (activity != null) {
            print(activity.toString());
        } else {
            print("Activity not found");
        }
        print("");
    }

    private static void testAddActivity() {
        printTestTitle("Add Activity");
        Activity activity = new Activity();
        activity.setActivityTitle("Test Activity Three");
        activity.setStudentEnrollment("s19012132");
        activity.setProjectID(15);
        activity.setActivityDescription("This is supposed to be a medium/long Activity description");
        activity.setActivityStatus(false);
        if (verifyProjectAndPractitioner(activity.getProjectID(), activity.getStudentEnrollment())) {
            if(iActivityDAO.addActivity(activity)) {
                print(String.format("Activity %s added successfully", activity.getActivityTitle()));
            } else {
                print(String.format("Unable to add Activity %s", activity.getActivityTitle()));
            }
        } else {
            print("Please use a valid Project or Practitioner");
        }
        print("");
    }

    private static void testDeleteActivity() {
        printTestTitle("Delete Activity");
        Activity activity = iActivityDAO.getActivityByID(5);
        if (activity != null) {
            if (iActivityDAO.deleteActivity(activity)) {
                print(String.format("Activity %s deleted successfully", activity.getActivityTitle()));
            } else {
                print(String.format("Unable to delete Activity %s", activity.getActivityTitle()));
            }
        } else {
            print("The activity doesn't exist");
        }
        print("");
    }

    private static void print(String string) {
        System.out.println(string);
    }
    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
    private static boolean verifyProjectAndPractitioner(int projectID, String studentEnrollment) {
        boolean result = false;
        IProjectDAO iProjectDAO = new ProjectDAO();
        IPractitionerDAO iPractitionerDAO = new PractitionerDAO();
        if ((iProjectDAO.getProject(projectID) != null)
                && (iPractitionerDAO.getPractitioner(studentEnrollment) != null)) {
            result = true;
        }
        return result;
    }
}

package dataaccess;

import com.standardeleven.project.dataaccess.dao.ActivityDAO;
import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.dataaccess.idao.IActivityDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Activity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestActivityDAO {
    private final static IActivityDAO iActivityDAO = new ActivityDAO();

    @Test
    public void testGetAllActivities() {
        printTestTitle("Get All Activities");
        List<Activity> activities = iActivityDAO.getAllActivities();
        assertFalse(activities.isEmpty());
        print("");
    }

    @Test
    public void testGetActivityByID() {
        printTestTitle("Get Activity By ID");
        Activity activity = iActivityDAO.getActivityByID(8);
        assertNotNull(activity);
        print("");
    }

    @Test
    public void testAddActivity() {
        printTestTitle("Add Activity");
        Activity activity = new Activity();
        activity.setActivityTitle("Test Activity Three");
        activity.setStudentEnrollment("s19012132");
        activity.setProjectID(15);
        activity.setActivityDescription("This is supposed to be a medium/long Activity description");
        activity.setActivityStatus(false);
        if (verifyProjectAndPractitioner(activity.getProjectID(), activity.getStudentEnrollment())) {
            assertTrue(iActivityDAO.addActivity(activity));
        } else {
            print("Please use a valid Project or Practitioner");
        }
        print("");
    }

    @Test
    public void testDeleteExistingActivity() {
        printTestTitle("Delete Activity");
        Activity activity = iActivityDAO.getActivityByID(5);
        assertTrue(iActivityDAO.deleteActivity(activity));
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

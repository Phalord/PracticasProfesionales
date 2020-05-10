package dataaccess;

import com.standardeleven.project.dataaccess.dao.ProjectApplicationDAO;
import com.standardeleven.project.dataaccess.idao.IProjectApplicationDAO;
import com.standardeleven.project.logical.ProjectApplication;

import java.util.List;

public class TestProjectApplicationDAO {
    private final static IProjectApplicationDAO iProjectApplicationDAO = new ProjectApplicationDAO();

    public static void main(String[] args) {
        testGetAllProjectApplications();
        testGetProjectApplicationByID();
        testAddProjectApplication();
        testDeleteProjectApplication();
    }

    private static void testGetAllProjectApplications() {
        printTestTitle("Get All Project Applications");
        List<ProjectApplication> projectApplications = iProjectApplicationDAO.getAllProjectApplications();
        if (!projectApplications.isEmpty()) {
            for (ProjectApplication projectApplication: projectApplications) {
                print(projectApplication.toString());
            }
        } else {
            print("Project List is Empty");
        }
        print("");
    }

    private static void testGetProjectApplicationByID() {
        printTestTitle("Get Project Application by ID");
        ProjectApplication projectApplication = iProjectApplicationDAO.getProjectApplicationByID(4);
        if (projectApplication != null) {
            print(String.format("Project Application %s found succesfully", projectApplication.toString()));
        } else {
            print("Project Application not found");
        }
        print("");
    }

    private static void testAddProjectApplication() {
        printTestTitle("Add Project Application");
        ProjectApplication projectApplication = new ProjectApplication();
        projectApplication.setProjectStatus(false);
        projectApplication.setPractitionerEnrollment("s19012132");
        projectApplication.setProjectOption1(15);
        projectApplication.setProjectOption2(17);
        projectApplication.setProjectOption3(20);
        if(iProjectApplicationDAO.getProjectApplicationByStudentEnrollment("s19012132") == null) {
            if(iProjectApplicationDAO.addProjectApplication(projectApplication)) {
                print("Project Application sent successfully");
            } else {
                print("Unable to add Project Application");
            }
        } else {
            print("Project Application for student s19012132 already sent");
        }
        print("");
    }

    private static void testDeleteProjectApplication() {
        printTestTitle("Delete Project Application");
        ProjectApplication projectApplication = iProjectApplicationDAO.getProjectApplicationByID(3);
        if(projectApplication != null) {
            if(iProjectApplicationDAO.deleteProjectApplication(projectApplication)) {
                print("Project Application deleted successfully");
            } else {
                print("Unable to delete Project Application");            }
        } else {
            print("Project Application doesn't exists");
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

package testdao;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Project;

import java.sql.SQLException;
import java.util.List;

public class TestProjectDao {
    private final static IProjectDAO iProjectDAO = new ProjectDAO();

    public static void main(String[] args) {
        testGetAllProjects();
        testGetProject();
        testAssignPractitioner();
        addProject();
        deleteProject();
    }

    public static void testGetAllProjects() {
        printTestTitle("Get All Projects");
        List<Project> projects = iProjectDAO.getAllProjects();
        for(Project project: projects) {
            print(String.format("Project's name: %s", project.getProjectName()));
        }
        print("");
    }

    public static void testGetProject() {
        printTestTitle("Get Project");
        Project project = iProjectDAO.getProject(1);
        print(String.format("Project's name: %s", project.getProjectName()));
        print("");
    }

    public static void testAssignPractitioner() {
        printTestTitle("Assign Practitioner");
        Practitioner practitioner;
        IPractitionerDAO iPractitionerDAO = new PractitionerDAO();
        practitioner = iPractitionerDAO.getPractitioner("s18012132");
        if(isAvailable()) {
            if (iProjectDAO.assignPractitioner(practitioner, 1)) {
                print("Project assigned successfully");
            } else {
                print("Project assignation aborted");
            }
        } else {
            print("There are no available projects to assign");
        }
        print("");
    }

    public static void addProject() {
        Project project = new Project();
        printTestTitle("Add Project");
        try {
            if (iProjectDAO.addProject(project)) {
                print("Project added successfully");
            } else {
                print("Something has occur");
            }
        } catch (SQLException sqlException) {
            print(sqlException.getMessage());
        }
        print("");
    }

    public static void deleteProject() {
        Project project = iProjectDAO.getProject(1);
        try {
            if(iProjectDAO.deleteProject(project)) {
                print("Project Deleted Successfully");
            } else {
                print("Something has occur");
            }
        } catch (SQLException sqlException) {
            print(sqlException.getMessage());
        }
        print("");
    }

    public static boolean isAvailable() {
        List<Project> projects = iProjectDAO.getAllAvailableProjects();
        boolean result = false;
        if(!projects.isEmpty()) {
            result = true;
        }
        return result;
    }

    public static void print(String string) {
        System.out.println(string);
    }
    public static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

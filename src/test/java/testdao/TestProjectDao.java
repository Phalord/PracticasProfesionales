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

    private static void testGetAllProjects() {
        printTestTitle("Get All Projects");
        List<Project> projects = iProjectDAO.getAllProjects();
        for(Project project: projects) {
            print(String.format("Project's name: %s", project.getProjectName()));
        }
        print("");
    }

    private static void testGetProject() {
        printTestTitle("Get Project");
        Project project = iProjectDAO.getProject(1);
        if (project != null) {
            print(String.format("Project's name: %s", project.getProjectName()));
            print("");
        } else {
            print("The project specified doesn't exists");
        }
        print("");
    }

    private static void testAssignPractitioner() {
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

    private static void addProject() {
        printTestTitle("Add Project");
        Project project = new Project("Proyecto de Prueba", "Descripción de prueba",
                "Recursos de prueba", "", "1");
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

    private static void deleteProject() {
        printTestTitle("Delete Project");
        Project project = iProjectDAO.getProject(18);
        try {
            if(project != null) {
                iProjectDAO.deleteProject(project);
                print("Project deleted successfully");
            } else {
                print("Project wasn't found");
            }
        } catch (SQLException sqlException) {
            print(sqlException.getMessage());
        }
        print("");
    }

    private static boolean isAvailable() {
        List<Project> projects = iProjectDAO.getAllAvailableProjects();
        boolean result = false;
        if(!projects.isEmpty()) {
            result = true;
        }
        return result;
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

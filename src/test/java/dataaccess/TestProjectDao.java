package dataaccess;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Project;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestProjectDao {
    private final static IProjectDAO iProjectDAO = new ProjectDAO();

    @Test
    public void testGetAllProjects() {
        printTestTitle("Get All Projects");
        List<Project> projects = iProjectDAO.getAllProjects();
        assertFalse(projects.isEmpty());
        print("");
    }

    @Test
    public void testGetProjectByID() {
        printTestTitle("Get Project");
        Project project = iProjectDAO.getProject(1);
        assertNotNull(project);
        print("");
    }

    @Test
    public void testAssignPractitioner() {
        printTestTitle("Assign Practitioner");
        Practitioner practitioner;
        IPractitionerDAO iPractitionerDAO = new PractitionerDAO();
        practitioner = iPractitionerDAO.getPractitioner("s18012132");
        if(isAvailable()) {
            assertTrue(iProjectDAO.assignPractitioner(practitioner, 1));
        } else {
            print("There are no available projects to assign");
            fail();
        }
        print("");
    }

    @Test
    public void addProject() {
        printTestTitle("Add Project");
        Project project = new Project("Proyecto de Prueba", "Descripción de prueba",
                "Recursos de prueba", "", "1");
        assertTrue(iProjectDAO.addProject(project));
        print("");
    }

    @Test
    public void deleteProject() {
        printTestTitle("Delete Project");
        Project project = iProjectDAO.getProject(18);
        if(project != null) {
            assertNotNull(project);
        } else {
            print("Project wasn't found");
            fail();
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

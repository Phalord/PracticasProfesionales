package dataaccess;

import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.dataaccess.idao.IProjectDAO;
import com.standardeleven.project.logical.Project;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoordinatorUseCases {

    @Test
    public void testAssignAvailableProject() {
        IProjectDAO iProjectDAO = new ProjectDAO();
        Project project = iProjectDAO.getProject(2);
        project.setStudentEnrollment("s18012132");
        iProjectDAO.updateProject(project);
        assertEquals("s18012132", iProjectDAO.getProject(2).getStudentEnrollment());
    }

}

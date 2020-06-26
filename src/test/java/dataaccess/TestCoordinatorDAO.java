package dataaccess;

import com.standardeleven.project.dataaccess.dao.CoordinatorDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Coordinator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestCoordinatorDAO {
    private final ICoordinatorDAO iCoordinatorDAO = new CoordinatorDAO();

    @Test
    public void testGetAllCoordinators() {
        printTestTitle("Get All Coordinators");
        List<Coordinator> coordinators = iCoordinatorDAO.getAllCoordinators();
        assertFalse(coordinators.isEmpty());
        print("");
    }

    @Test
    public void testGetCoordinator() {
        printTestTitle("Get Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator("c11002684");
        assertEquals("c11002684", coordinator.getUserName());
        print("");
    }

    @Test
    public void testAddCoordinator() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Coordinator");
        Coordinator coordinator = new Coordinator();
        coordinator.setUserName("c11223344");
        coordinator.setCoordinatorName("Coordinator");
        coordinator.setCoordinatorFatherSurname("Coordinador");
        coordinator.setCoordinatorMotherSurname("Coordinante");
        if (iUserDAO.getUserByUserName(coordinator.getUserName()) != null) {
            assertTrue(iCoordinatorDAO.addCoordinator(coordinator));
        } else {
            coordinator.setUserPassword("coordinador");
            coordinator.setUserType("coordinador");
            if(iUserDAO.addUser(coordinator)) {
                assertTrue(iCoordinatorDAO.addCoordinator(coordinator));
            } else {
                print("Unable to add User to database");
                fail();
            }
        }
        print("");
    }

    @Test
    public void testDeleteCoordinator() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator("c11002684");
        if (coordinator != null) {
            if (iCoordinatorDAO.deleteCoordinator(coordinator)) {
                assertTrue(iUserDAO.deleteUser(coordinator));
            } else {
                print("Unable to delete Coordinator");
                fail();
            }
        } else {
            print("Coordinator doesn't exists");
            fail();
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

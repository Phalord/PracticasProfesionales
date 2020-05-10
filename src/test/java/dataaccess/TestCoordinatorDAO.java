package dataaccess;

import com.standardeleven.project.dataaccess.dao.CoordinatorDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Coordinator;
import com.standardeleven.project.logical.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCoordinatorDAO {
    private final static ICoordinatorDAO iCoordinatorDAO = new CoordinatorDAO();

    public static void main(String[] args) {
    }

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
        coordinator.setUserName("c11002684");
        coordinator.setCoordinatorName("Francisco");
        coordinator.setCoordinatorFatherSurname("Molina");
        coordinator.setCoordinatorMotherSurname("Rojas");
        if (iUserDAO.getUserByEnrollment(coordinator.getUserName()) != null) {
            assertTrue(iCoordinatorDAO.addCoordinator(coordinator));
        } else {
            if(iUserDAO.addUser(new User(coordinator.getUserName(), "Nc)Se2oe¡p14rat2r'a2iT1(ÑA", "coordinador"))) {
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

package testdao;

import com.standardeleven.project.dataaccess.dao.CoordinatorDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.ICoordinatorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Coordinator;
import com.standardeleven.project.logical.User;

import java.util.List;

public class TestCoordinatorDAO {
    private final static ICoordinatorDAO iCoordinatorDAO = new CoordinatorDAO();

    public static void main(String[] args) {
        testGetAllCoordinators();
        testGetCoordinator();
        testAddCoordinator();
        testDeleteCoordinator();
    }

    private static void testGetAllCoordinators() {
        printTestTitle("Get All Coordinators");
        List<Coordinator> coordinators = iCoordinatorDAO.getAllCoordinators();
        if (!coordinators.isEmpty()) {
            for (Coordinator coordinator: coordinators) {
                print(coordinator.toString());
            }
        } else {
            print("There are no Coordinators");
        }
        print("");
    }

    private static void testGetCoordinator() {
        printTestTitle("Get Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator("c11554433");
        if (coordinator != null) {
            print(String.format("Coordinator %s found", coordinator.toString()));
        } else {
            print("The Coordinator wasn't found");
        }
        print("");
    }

    private static void testAddCoordinator() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Coordinator");
        Coordinator coordinator = new Coordinator();
        coordinator.setUserName("c11502033");
        coordinator.setCoordinatorName("Abel");
        coordinator.setCoordinatorFatherSurname("Makkonen");
        coordinator.setCoordinatorMotherSurname("Tesfaye");
        if (iCoordinatorDAO.getCoordinator(coordinator.getUserName()) == null) {
            if (iUserDAO.getUserByEnrollment(coordinator.getUserName()) != null) {
                if(iCoordinatorDAO.addCoordinator(coordinator)) {
                    print(String.format("Coordinator %s added successfully", coordinator.toString()));
                } else {
                    print("Unable to add Coordinator");
                }
            } else {
                if(iUserDAO.addUser(new User(coordinator.getUserName(), "password", "coordinador"))) {
                    testAddCoordinator();
                } else {
                    print("Unable to add User to database");
                }
            }
        } else {
            print("Coordinator Already Exists");
        }
        print("");
    }

    private static void testDeleteCoordinator() {
        printTestTitle("Delete Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator("c11502033");
        if (coordinator != null) {
            if (iCoordinatorDAO.deleteCoordinator(coordinator)) {
                print(String.format("Coordinator %s deleted successfully", coordinator.toString()));
            } else {
                print("Unable to delete Coordinator");
            }
        } else {
            print("Coordinator doesn't exists");
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

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
        testGetCoordinator("c11006521");
        testAddCoordinator("c11002684","Francisco","Molina","Rojas","Nc)Se2oe¡p14rat2r'a2iT1(ÑA");
        testAddCoordinator("c11006521","Minerva","Sanchez","del Campo","coe2Nt2r)SeÑAp'a2iT1(¡4ra1");
        testDeleteCoordinator("c11005236");
        testDeleteCoordinator("c11502033");
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

    private static void testGetCoordinator(String coordinatorPersonalNumber) {
        printTestTitle("Get Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator(coordinatorPersonalNumber);
        if (coordinator != null) {
            print(String.format("Coordinator %s found", coordinator.toString()));
        } else {
            print("The Coordinator wasn't found");
        }
        print("");
    }

    private static void testAddCoordinator(String userName, String coordinatorName, String coordinatorFatherSurname, String coordinatorMotherSurname, String password) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Coordinator");
        Coordinator coordinator = new Coordinator();
        coordinator.setUserName(userName);
        coordinator.setCoordinatorName(coordinatorName);
        coordinator.setCoordinatorFatherSurname(coordinatorFatherSurname);
        coordinator.setCoordinatorMotherSurname(coordinatorMotherSurname);
        if (iCoordinatorDAO.getCoordinator(coordinator.getUserName()) == null) {
            if (iUserDAO.getUserByEnrollment(coordinator.getUserName()) != null) {
                if(iCoordinatorDAO.addCoordinator(coordinator)) {
                    print(String.format("Coordinator %s added successfully", coordinator.toString()));
                } else {
                    print("Unable to add Coordinator");
                }
            } else {
                if(iUserDAO.addUser(new User(coordinator.getUserName(), password, "coordinador"))) {
                    testAddCoordinator(userName, coordinatorName, coordinatorFatherSurname, coordinatorMotherSurname, password);
                } else {
                    print("Unable to add User to database");
                }
            }
        } else {
            print("Coordinator Already Exists");
        }
        print("");
    }

    private static void testDeleteCoordinator(String coordinatorPersonalNumber) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Coordinator");
        Coordinator coordinator = iCoordinatorDAO.getCoordinator(coordinatorPersonalNumber);
        if (coordinator != null) {
            if (iCoordinatorDAO.deleteCoordinator(coordinator)) {
                if (iUserDAO.deleteUser(coordinator)) {
                    print(String.format("Coordinator %s deleted successfully", coordinator.toString()));
                } else {
                    print("Unable to delete User");
                }
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

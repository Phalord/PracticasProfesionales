package testdao;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;

public class TestUserDAO {
    private final static IUserDAO iUserDAO = new UserDAO();

    public static void main(String[] args) {
        testAddUser("s17015232", "ConT123RaSeñ123a!", "practicante");
        testGetUser("c15086425");
        testDeleteUser("s17015232");
        testAddUser("c15086425", "Co23eñ12n!RaT13aS", "coordinador");
        testGetUser("s17015232");
        testDeleteUser("s18012132");
    }

    private static void testGetUser(String enrollment) {
        printTestTitle("Get User");
        User user = iUserDAO.getUserByEnrollment(enrollment);
        if(user != null) {
            print(String.format(" %s | %s", user.getUserName(), user.getUserType()));
        } else {
            print("Unable to retrieve User");
        }
        print("");
    }

    private static void testAddUser(String userName, String password, String userType) {
        printTestTitle("Add User");
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);
        user.setUserType(userType);
        if(iUserDAO.addUser(user)) {
            print("User added successfully");
        } else {
            print("Unable to add User");
        }
        print("");
    }

    private static void testDeleteUser(String enrollment) {
        printTestTitle("Delete User");
        User user = iUserDAO.getUserByEnrollment(enrollment);
        if(user != null) {
            if(iUserDAO.deleteUser(user)) {
                print("User deleted successfully");
            } else {
                print("Unable to delete user");
            }
        } else {
            print("User not found");
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

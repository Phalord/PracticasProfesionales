package testdao;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;

public class TestUserDAO {
    private final static IUserDAO iUserDAO = new UserDAO();

    public static void main(String[] args) {
        testAddUser();
        testGetUser();
        testDeleteUser();
    }

    private static void testGetUser() {
        printTestTitle("Get User");
        User user = iUserDAO.getUserByEnrollment("c11556677");
        if(user != null) {
            print(String.format(" %s | %s", user.getUserName(), user.getUserType()));
        } else {
            print("Unable to retrieve User");
        }
        print("");
    }

    private static void testAddUser() {
        printTestTitle("Add User");
        User user = new User();
        user.setUserName("p11556677");
        user.setUserPassword("password");
        user.setUserType("profesor");
        if(iUserDAO.addUser(user)) {
            print("User added successfully");
        } else {
            print("Unable to add User");
        }
        print("");
    }

    private static void testDeleteUser() {
        printTestTitle("Delete User");
        User user = iUserDAO.getUserByEnrollment("c11556677");
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

package testdao;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;

import java.util.List;

public class TestUserDAO {
    private final static IUserDAO iUserDAO = new UserDAO();

    public static void main(String[] args) {
        testAddUser();
        testGetUser();
    }

    public static void testGetUser() {
        printTestTitle("Get User");
        User user = iUserDAO.getUserByEnrollment("c11556677");
        if(user != null) {
            print(String.format(" %s | %s", user.getUserName(), user.getUserType()));
        } else {
            print("Unable to retrieve User");
        }
        print("");
    }

    public static void testAddUser() {
        printTestTitle("Add User");
        User user = new User();
        user.setUserName("c11556677");
        user.setUserPassword("password");
        user.setUserType("profesor");
        if(iUserDAO.addUser(user)) {
            print("User added successfully");
        } else {
            print("Unable to add User");
        }
        print("");
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

package dataaccess;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestUserDAO {
    private final static IUserDAO iUserDAO = new UserDAO();

    public static void main(String[] args) {
    }

    @Test
    public void testGetUser() {
        printTestTitle("Get User");
        User user = iUserDAO.getUserByEnrollment("s18012132");
        assertEquals("s18012132", user.getUserName());
        print();
    }

    @Test
    public void testAddUser() {
        printTestTitle("Add User");
        User user = new User();
        user.setUserName("s17015232");
        user.setUserPassword("ConT123RaSeñ123a!");
        user.setUserType("practicante");
        assertTrue(iUserDAO.addUser(user));
        print();
    }

    @Test
    public void testDeleteUser() {
        printTestTitle("Delete User");
        User user = iUserDAO.getUserByEnrollment("s17015232");
        if(user != null) {
            assertTrue(iUserDAO.deleteUser(user));
        } else {
            fail();
        }
        print();
    }

    private static void print() {
        System.out.println();
    }

    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

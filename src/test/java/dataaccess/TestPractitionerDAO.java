package dataaccess;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestPractitionerDAO {
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();

    public static void main(String[] args) {
    }

    @Test
    public void testGetAllPractitioners() {
        printTestTitle("Get All Practitioners");
        List<Practitioner> practitioners = iPractitionerDAO.getAllPractitioners();
        assertFalse(practitioners.isEmpty());
        print();
    }

    @Test
    public void testGetPractitioner() {
        printTestTitle("Get Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner("s18012132");
        assertEquals("s18012132", practitioner.getUserName());
        print();
    }

    @Test
    public void testAddPractitioner() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Practitioner");
        Practitioner practitioner = new Practitioner();
        practitioner.setUserName("s18012132");
        practitioner.setStudentName("Alejandro");
        practitioner.setStudentFatherSurname("Sandoval");
        practitioner.setStudentMotherSurname("Bravo");
        practitioner.setStudentShift("Vespertino");
        User user = iUserDAO.getUserByEnrollment("s18012132");
        if(iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
            if (user != null) {
                assertTrue(iPractitionerDAO.addPractitioner(practitioner));
            } else {
                if (iUserDAO.addUser(new User(practitioner.getUserName(),
                        "min51!uEñar3Sco?'at63Pe¿S5r", "practicante"))) {
                    assertTrue(iPractitionerDAO.addPractitioner(practitioner));
                } else {
                    fail("Unable to add user to database");
                }
            }
        } else {
            fail(String.format("Practitioner %s already exists", practitioner.getUserName()));
        }
        print();
    }

    @Test
    public void testDeletePractitioner() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner("s18012132");
        if (practitioner != null) {
            if (iPractitionerDAO.deletePractitioner(practitioner)) {
                assertTrue(iUserDAO.deleteUser(practitioner));
            } else {
                fail("Unable to delete Practitioner");
            }
        } else {
            fail("Practitioner doesn't exists");
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

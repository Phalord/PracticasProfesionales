package dataaccess;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Practitioner;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class TestPractitionerDAO {
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();

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
        practitioner.setUserName("s11223344");
        practitioner.setStudentName("Practitioner");
        practitioner.setStudentFatherSurname("Practicante");
        practitioner.setStudentMotherSurname("Practicoso");
        practitioner.setStudentShift("Matutino");
        if(iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
            practitioner.setUserPassword("practitioner");
            practitioner.setUserType("practicante");
            if (iUserDAO.addUser(practitioner)) {
                assertTrue(iPractitionerDAO.addPractitioner(practitioner));
            } else {
                fail("Unable to add user to database");
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

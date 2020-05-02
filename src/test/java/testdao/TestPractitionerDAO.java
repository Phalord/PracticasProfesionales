package testdao;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.User;

import java.util.List;

public class TestPractitionerDAO {
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();

    public static void main(String[] args) {
        testGetAllPractitioners();
        testGetPractitioner();
        testAddPractitioner();
        testDeletePractitioner();
    }

    private static void testGetAllPractitioners() {
        printTestTitle("Get All Practitioners");
        List<Practitioner> practitioners = iPractitionerDAO.getAllPractitioners();
        for(Practitioner practitioner: practitioners) {
            print(practitioner.getStudentName());
        }
        print("");
    }

    private static void testGetPractitioner() {
        printTestTitle("Get Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner("s18012132");
        if(practitioner != null) {
            print(practitioner.getStudentName());
        } else {
            print("The practitioner wasn't found");
        }
        print("");
    }

    private static void testAddPractitioner() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Practitioner");
        Practitioner practitioner = new Practitioner();
        practitioner.setUserName("s20012131");
        practitioner.setStudentName("Pepe");
        practitioner.setStudentFatherSurname("Pecas");
        practitioner.setStudentMotherSurname("Picas");
        practitioner.setStudentShift("Matutino");
        User user = iUserDAO.getUserByEnrollment("s20012131");
        if(iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
            if (user != null) {
                if (iPractitionerDAO.addPractitioner(practitioner)) {
                    print(String.format("Practitioner %s added successfully", practitioner.getUserName()));
                } else {
                    print("Unable to add Practitioner");
                }
            } else {
                if (iUserDAO.addUser(new User(practitioner.getUserName(), "password", "practicante"))) {
                    testAddPractitioner();
                } else {
                    print("Unable to add user to database");
                }
            }
        } else {
            print(String.format("Practitioner %s already exists", practitioner.getUserName()));
        }
        print("");
    }

    private static void testDeletePractitioner() {
        printTestTitle("Delete Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner("s20012131");
        if (practitioner != null) {
            if (iPractitionerDAO.deletePractitioner(practitioner)) {
                print(String.format("Practitioner %s deleted successfully", practitioner.getUserName()));
            } else {
                print("Unable to delete Practitioner");
            }
        } else {
            print("Practitioner doesn't exists");
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

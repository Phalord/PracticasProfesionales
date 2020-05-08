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
        testAddPractitioner("s18012132", "Alejandro", "Sandoval" , "Bravo", "Vespertino", "min51!uEñar3Sco?'at63Pe¿S5r");
        testAddPractitioner("s18012133", "Victor Arturo", "Ruiz" , "Cuervo", "Vespertino", "r3e6n5o?'a1Sc3P!u¿SEñ5mitar");
        testAddPractitioner("s18012155", "Abner Jeffrey", "Tapia" , "Cruz", "Vespertino", "t63Pe¿SSco?'min515r!uEñar3a");
        testDeletePractitioner("s18012135");
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

    private static void testAddPractitioner(String userName, String studentName, String studentFatherSurname,
                                            String studentMotherSurname, String studentShift, String password) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Practitioner");
        Practitioner practitioner = new Practitioner();
        practitioner.setUserName(userName);
        practitioner.setStudentName(studentName);
        practitioner.setStudentFatherSurname(studentFatherSurname);
        practitioner.setStudentMotherSurname(studentMotherSurname);
        practitioner.setStudentShift(studentShift);
        User user = iUserDAO.getUserByEnrollment(userName);
        if(iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
            if (user != null) {
                if (iPractitionerDAO.addPractitioner(practitioner)) {
                    print(String.format("Practitioner %s added successfully", practitioner.getUserName()));
                } else {
                    print("Unable to add Practitioner");
                }
            } else {
                if (iUserDAO.addUser(new User(practitioner.getUserName(), password, "practicante"))) {
                    testAddPractitioner(userName, studentName, studentFatherSurname, studentMotherSurname, studentShift, password);
                } else {
                    print("Unable to add user to database");
                }
            }
        } else {
            print(String.format("Practitioner %s already exists", practitioner.getUserName()));
        }
        print("");
    }

    private static void testDeletePractitioner(String studentEnrollment) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner(studentEnrollment);
        if (practitioner != null) {
            if (iPractitionerDAO.deletePractitioner(practitioner)) {
                if (iUserDAO.deleteUser(practitioner)) {
                    print("Practitioner deleted successfully");
                } else {
                    print("Unable to delete User");
                }
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

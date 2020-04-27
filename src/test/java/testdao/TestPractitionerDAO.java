package testdao;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.logical.Practitioner;

import java.util.List;

public class TestPractitionerDAO {
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();

    public static void main(String[] args) {
        testGetAllPractitioners();
        testGetPractitioner();
    }

    public static void testGetAllPractitioners() {
        printTestTitle("Get All Practitioners");
        List<Practitioner> practitioners = iPractitionerDAO.getAllPractitioners();
        for(Practitioner practitioner: practitioners) {
            print(practitioner.getStudentName());
        }
        print("");
    }

    public static void testGetPractitioner() {
        printTestTitle("Get Practitioner");
        Practitioner practitioner = iPractitionerDAO.getPractitioner("s18012132");
        if(practitioner != null) {
            print(practitioner.getStudentName());
        } else {
            print("The practitioner wasn't found");
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

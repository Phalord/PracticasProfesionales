package dataaccess;

import com.standardeleven.project.dataaccess.dao.ProfessorDAO;
import java.util.List;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Professor;
import com.standardeleven.project.logical.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


public class TestProfessorDAO {
    private final static IProfessorDAO iProfessorDAO = new ProfessorDAO();

    public static void main(String[] args) {
    }

    @Test
    public void testGetAllProfessors() {
        printTestTitle("Get All Professors");
        List<Professor> professors = iProfessorDAO.getAllProfessors();
        assertFalse(professors.isEmpty());
        print("");
    }

    @Test
    public void testAddProfessor() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Professor");
        Professor professor = new Professor();
        professor.setProfessorNames("Jessica");
        professor.setProfessorFatherSurname("Elric");
        professor.setProfessorMotherSurname("Muñoz");
        professor.setProfessorShift("Vespertino");
        professor.setUserName("p20553366");
        User user = iUserDAO.getUserByEnrollment(professor.getUserName());
        if (user != null) {
            assertTrue(iProfessorDAO.addProfessor(professor));
        } else {
            if (iUserDAO.addUser(new User(professor.getUserName(), "56OirA?n¡t2tt4Re'¿raCAPo", "profesor"))) {
                assertTrue(iProfessorDAO.addProfessor(professor));
            } else {
                print("Unable to add User to database");
                fail();
            }
        }
        print("");
    }

    @Test
    public void testUpdateProfessor() {
        printTestTitle("Update Professor");
        Professor professor = iProfessorDAO.getProfessor("p20553366");
        if (professor != null) {
            professor.setProfessorNames("Antonieta");
            professor.setProfessorFatherSurname("Kamikaze");
            assertTrue(iProfessorDAO.updateProfessor(professor));
        } else {
            print("No Professor found");
            fail();
        }
        print("");
    }

    @Test
    public void testDeleteProfessor() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Professor");
        Professor professor = iProfessorDAO.getProfessor("p20553366");
        if (professor != null) {
            if (iProfessorDAO.deleteProfessor(professor)) {
                assertTrue(iUserDAO.deleteUser(professor));
            } else {
                print("Unable to delete Professor");
                fail();
            }
        } else{
            print("No Professor found");
            fail();
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

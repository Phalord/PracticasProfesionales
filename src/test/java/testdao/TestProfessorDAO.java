package testdao;

import com.standardeleven.project.dataaccess.dao.ProfessorDAO;
import java.util.List;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Professor;
import com.standardeleven.project.logical.User;

public class TestProfessorDAO {
    private final static IProfessorDAO iProfessorDAO = new ProfessorDAO();

    public static void main(String[] args) {
        testAddProfessor();
        testGetAllProfessors();
        testDeleteProfessor();
        testUpdateProfessor();
    }

    private static void testAddProfessor() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Professor");
        Professor professor = new Professor();
        professor.setProfessorNames("Roberto Carlos");
        professor.setProfessorFatherSurname("Valencia");
        professor.setProfessorMotherSurname("de la Villa");
        professor.setProfessorShift("Matutino");
        professor.setUserName("p11556677");
        User user = iUserDAO.getUserByEnrollment(professor.getUserName());
        if (iProfessorDAO.getProfessor(professor.getUserName()) == null) {
            if (user != null) {
                if (iProfessorDAO.addProfessor(professor)) {
                    print(String.format("Professor %s added successfully", professor.getProfessorNames()));
                } else {
                    print("Unable to add Professor");
                }
            } else {
                if (iUserDAO.addUser(new User(professor.getUserName(), "password", "profesor"))) {
                    testAddProfessor();
                } else {
                    print("Unable to add User to database");
                }
            }
        } else {
            print(String.format("Professor %s already exists", professor.getProfessorNames()));
        }
        print("");
    }

    private static void testUpdateProfessor() {
        printTestTitle("Update Professor");
        Professor professor = iProfessorDAO.getProfessor("p33557799");
        if (professor != null) {
            professor.setProfessorFatherSurname("Azcarraga");
            professor.setProfessorNames("Juan Gabriel");
            if (iProfessorDAO.updateProfessor(professor)) {
                print(String.format("Professor %s updated successfully", professor.getProfessorNames()));
            } else {
                print("Unable to update Professor");
            }
        } else {
            print("No Professor found");
        }
        print("");
    }

    private static void testDeleteProfessor() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Professor");
        Professor professor = iProfessorDAO.getProfessor("p11556677");
        if (professor != null) {
            if (iProfessorDAO.deleteProfessor(professor)) {
                if (iUserDAO.deleteUser(iUserDAO.getUserByEnrollment(professor.getUserName()))) {
                    print("Professor deleted successfully");
                } else {
                    print("Unable to delete User");
                }
            } else {
                print("Unable to delete Professor");
            }
        } else{
            print("No Professor found");
        }
        print("");
    }

    private static void testGetAllProfessors() {
        printTestTitle("Get All Professors");
        List<Professor> professors = iProfessorDAO.getAllProfessors();
        if (!professors.isEmpty()) {
            for (Professor professor: professors) {
                print(professor.toString());
            }
        } else {
            print("There are no professors!");
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

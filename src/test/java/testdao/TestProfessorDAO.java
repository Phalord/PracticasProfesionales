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
        testAddProfessor("p20553366","Jessica","Elric","Muñoz","Vespertino","56OirA?n¡t2tt4Re'¿raCAPo");
        testAddProfessor("p20513488","Freud","Smith"," Rodriguez","Matutino","'¿raCPttOA?ntA56o¡4R2ire");
        testAddProfessor("p20010145","Lois","Lane","Kent","Matutino","Ott564RAPirA?ne'¿raC2o¡t");
        testGetAllProfessors();
        testDeleteProfessor("p20204865");
        testDeleteProfessor("p20010145");
        testUpdateProfessor("p20553366", "Antonieta", "De las Aguas");
        testUpdateProfessor("p20553386", "Joshua", "Kamikaze");
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

    private static void testAddProfessor(String userName, String professorName, String professorFatherSurname,
                                         String professorMotherSurname, String professorShift, String password) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Add Professor");
        Professor professor = new Professor();
        professor.setProfessorNames(professorName);
        professor.setProfessorFatherSurname(professorFatherSurname);
        professor.setProfessorMotherSurname(professorMotherSurname);
        professor.setProfessorShift(professorShift);
        professor.setUserName(userName);
        User user = iUserDAO.getUserByEnrollment(professor.getUserName());
        if (iProfessorDAO.getProfessor(professor.getUserName()) == null) {
            if (user != null) {
                if (iProfessorDAO.addProfessor(professor)) {
                    print(String.format("Professor %s added successfully", professor.getProfessorNames()));
                } else {
                    print("Unable to add Professor");
                }
            } else {
                if (iUserDAO.addUser(new User(professor.getUserName(), password, "profesor"))) {
                    testAddProfessor(userName, professorName, professorFatherSurname, professorMotherSurname, professorShift, password);
                } else {
                    print("Unable to add User to database");
                }
            }
        } else {
            print(String.format("Professor %s already exists", professor.getProfessorNames()));
        }
        print("");
    }

    private static void testUpdateProfessor(String personalNumber, String professorName, String professorFatherSurname) {
        printTestTitle("Update Professor");
        Professor professor = iProfessorDAO.getProfessor(personalNumber);
        if (professor != null) {
            professor.setProfessorNames(professorName);
            professor.setProfessorFatherSurname(professorFatherSurname);
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

    private static void testDeleteProfessor(String personalNumber) {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("Delete Professor");
        Professor professor = iProfessorDAO.getProfessor(personalNumber);
        if (professor != null) {
            if (iProfessorDAO.deleteProfessor(professor)) {
                if (iUserDAO.deleteUser(professor)) {
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

    private static void print(String string) {
        System.out.println(string);
    }

    private static void printTestTitle(String testTitle) {
        System.out.println(String.format("----- %s -----", testTitle));
    }
}

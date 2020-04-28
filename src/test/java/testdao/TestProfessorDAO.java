package testdao;

import com.standardeleven.project.dataaccess.dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void testAddProfessor() {
        IUserDAO iUserDAO = new UserDAO();
        printTestTitle("AddProfessor");
        Professor professor = new Professor();
        professor.setProfessorNames("Roberto Carlos");
        professor.setProfessorFatherSurname("Valencia");
        professor.setProfessorMotherSurname("de la Villa");
        professor.setProfessorShift("Matutino");
        professor.setProfessorNumberPersonal("c11556677");
        User user = iUserDAO.getUserByEnrollment(professor.getProfessorNumberPersonal());
        if(user != null) {
            if(iProfessorDAO.addProfessor(professor)) {
                print("Professor added successfully");
            } else {
                print("Unable to add Professor");
            }
        } else {
            print("There is no username with that enrollment");
        }
        print("");
    }

    public static void testUpdateProfessor() {
        printTestTitle("Update Professor");
        Professor professor = iProfessorDAO.getProfessor("p33557799");
        if(professor != null) {
            professor.setProfessorFatherSurname("Azcarraga");
            professor.setProfessorNames("Juan Gabriel");
            if(iProfessorDAO.updateProfessor(professor)) {
                print("Professor updated successfully");
            } else {
                print("Unable to update Professor");
            }
        } else {
            print("No Professor found");
        }
        print("");
    }

    public static void testDeleteProfessor() {
        printTestTitle("Delete Professor");
        Professor professor = iProfessorDAO.getProfessor("p33557788");
        if(professor != null) {
            if(iProfessorDAO.deleteProfessor(professor)) {
                print("Professor deleted successfully");
            } else {
                print("Unable to delete Professor");
            }
        } else{
            print("No Professor found");
        }
        print("");
    }

    public static void testGetAllProfessors() {
        printTestTitle("Get All Professors");
        List<Professor> professors = iProfessorDAO.getAllProfessors();
        if(!professors.isEmpty()) {
            for(Professor professor: professors) {
                print(String.format("%s | %s", professor.getProfessorNumberPersonal(), professor.getProfessorNames()));
            }
        } else {
            print("There are no professors!");
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

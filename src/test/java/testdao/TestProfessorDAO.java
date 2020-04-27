package testdao;

import com.standardeleven.project.dataaccess.dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.standardeleven.project.dataaccess.idao.IProfessorDAO;
import com.standardeleven.project.logical.Professor;

public class TestProfessorDAO {
    
    public static void main(String[] args) {
        Professor professor1 = new Professor("P1","Juan Carlos", "Perez", "Arriaga", "Vespertino", "qwerty");
        IProfessorDAO professorDAO = new ProfessorDAO();
        
        try {
            if (professorDAO.addProfessor(professor1)) {
                System.out.println("Agregado");
            } else {
                System.out.println("Ha ocurrido un error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(TestProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }     
        
        try {
            professor1.setProfessorPassword("asd123");
            if (professorDAO.updateProfessor(professor1)) {
                System.out.println("Actualizado");
            } else {
                System.out.println("Ha ocurrido un error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(TestProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            professor1.setProfessorNumberPersonal("P2");
            if (professorDAO.deleteProfessor(professor1)) {
                System.out.println("Eliminado");
            } else {
                System.out.println("Ha ocurrido un error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(TestProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }        
        
        try {
            for (Professor professor : professorDAO.getListProfessor()) {
                System.out.println(professor.getProfessorNumberPersonal());
                System.out.println(professor.getProfessorNames());
                System.out.println(professor.getProfessorFatherSurname());
                System.out.println(professor.getProfessorMotherSurname());
                System.out.println(professor.getProfessorPassword());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            Logger.getLogger(TestProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}

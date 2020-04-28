package com.standardeleven.project.dataaccess.idao;

import java.sql.SQLException;
import java.util.List;
import com.standardeleven.project.logical.Professor;

public interface IProfessorDAO {
    List<Professor> getAllProfessors();
    Professor getProfessor(String personalNumber);
    boolean addProfessor(Professor professor);
    boolean updateProfessor(Professor professor);
    boolean deleteProfessor(Professor professor);
}

package com.standardeleven.project.dataaccess.idao;

import java.util.List;
import com.standardeleven.project.logical.Professor;
import java.sql.Connection;
import javafx.collections.ObservableList;

public interface IProfessorDAO {
    List<Professor> getAllProfessors();
    Professor getProfessor(String personalNumber);
    boolean addProfessor(Professor professor);
    boolean updateProfessor(Professor professor);
    boolean deleteProfessor(Professor professor);
    void fillProfessorInformation(Connection mySQLConnection, ObservableList<Professor> listProfessor);
}

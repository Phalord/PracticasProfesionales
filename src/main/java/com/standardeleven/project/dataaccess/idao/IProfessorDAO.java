package com.standardeleven.project.dataaccess.idao;

import java.sql.SQLException;
import java.util.List;
import com.standardeleven.project.logical.Professor;

public interface IProfessorDAO {
    public boolean addProfessor(Professor professor) throws SQLException, ClassNotFoundException;
    public boolean updateProfessor(Professor professor) throws SQLException, ClassNotFoundException;
    public boolean deleteProfessor(Professor professor) throws SQLException, ClassNotFoundException;
    public List<Professor> getListProfessor() throws SQLException, ClassNotFoundException; 
}

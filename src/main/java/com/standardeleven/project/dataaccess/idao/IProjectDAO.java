package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Project;

import java.sql.SQLException;
import java.util.List;

public interface IProjectDAO {

    List<Project> getAllProjects();
    List<Project> getAllAvailableProjects();
    Project getProject(int idProject);
    boolean assignPractitioner(Practitioner practitioner, int idProject);
    boolean addProject(Project project) throws SQLException;
    boolean updateProject(Project project) throws SQLException;
    boolean deleteProject(Project project) throws SQLException;

}

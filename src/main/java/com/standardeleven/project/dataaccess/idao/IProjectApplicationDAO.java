package com.standardeleven.project.dataaccess.idao;

import com.standardeleven.project.logical.ProjectApplication;

import java.util.List;

public interface IProjectApplicationDAO {

    List<ProjectApplication> getAllProjectApplications();
    ProjectApplication getProjectApplicationByID(int idProjectApplication);
    ProjectApplication getProjectApplicationByStudentEnrollment(String studentEnrollment);
    boolean addProjectApplication(ProjectApplication projectApplication);
    boolean deleteProjectApplication(ProjectApplication projectApplication);

}

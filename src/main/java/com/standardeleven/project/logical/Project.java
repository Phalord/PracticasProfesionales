package com.standardeleven.project.logical;

public class  Project {
    private int projectID;
    private String projectName;
    private String projectDescription;
    private String projectResource;
    private String studentEnrollment;
    private String idProjectManager;

    public Project() {
        setProjectName("Default");
        setProjectDescription("Description");
        setProjectResource("ProjectResource");
        setStudentEnrollment("Student Enrollment");
        setIdProjectManager("ID Encargado");
    }

    public Project(String projectName, String projectDescription, String projectResource, String studentEnrollment, String idProjectManager) {
        setProjectName(projectName);
        setProjectDescription(projectDescription);
        setProjectResource(projectResource);
        setStudentEnrollment(studentEnrollment);
        setIdProjectManager(idProjectManager);
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectResource(String projectResource) {
        this.projectResource = projectResource;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setIdProjectManager(String idProjectManager) {
        this.idProjectManager = idProjectManager;
    }

    public int getProjectID() {
        return projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectResource() {
        return projectResource;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public String getIdProjectManager() {
        return idProjectManager;
    }
}

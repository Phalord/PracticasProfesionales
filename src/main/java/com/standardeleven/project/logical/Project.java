package com.standardeleven.project.logical;

public class Project {
    private String projectName;
    private String projectDescription;
    private String projectResource;
    private String studentEnrollment;
    private String professorNumberPersonal;

    public Project() {
        setProjectName("Default");
        setProjectDescription("Description");
        setProjectResource("ProjectResource");
        setStudentEnrollment("Student Enrollment");
        setProfessorNumberPersonal("Professor NumberPersonal");
    }

    public Project(String projectName, String projectDescription, String projectResource, String studentEnrollment, String professorNumberPersonal) {
        setProjectName(projectName);
        setProjectDescription(projectDescription);
        setProjectResource(projectResource);
        setStudentEnrollment(studentEnrollment);
        setProfessorNumberPersonal(professorNumberPersonal);
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectResource() {
        return projectResource;
    }

    public void setProjectResource(String projectResource) {
        this.projectResource = projectResource;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public String getProfessorNumberPersonal() {
        return professorNumberPersonal;
    }

    public void setProfessorNumberPersonal(String professorNumberPersonal) {
        this.professorNumberPersonal = professorNumberPersonal;
    }
}

package com.standardeleven.project.logical;

public class ProjectResponsible {
    private String responsibleFullName;
    private String responsibleEmail;
    private String projectName;
    private String companyName; 
    private int responsiblePhone;
    private int responsibleID;

    public ProjectResponsible(){}

    public ProjectResponsible(String responsibleFullName, String responsibleEmail, int responsiblePhone, String projectName, String companyName, int responsibleID) {
        this.setResponsibleFullName(responsibleFullName);
        this.setResponsibleEmail(responsibleEmail);
        this.setResponsiblePhone(responsiblePhone);
        this.setProjectName(projectName);
        this.setCompanyName(companyName);
        this.setResponsibleID(responsibleID);
    }

    public String getResponsibleFullName() {
        return responsibleFullName;
    }

    public String getResponsibleEmail() {
        return responsibleEmail;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getResponsiblePhone() {
        return responsiblePhone;
    }

    public int getResponsibleID() {
        return responsibleID;
    }

    public void setResponsibleFullName(String responsibleFullName) {
        this.responsibleFullName = responsibleFullName;
    }

    public void setResponsibleEmail(String responsibleEmail) {
        this.responsibleEmail = responsibleEmail;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setResponsiblePhone(int responsiblePhone) {
        this.responsiblePhone = responsiblePhone;
    }

    public void setResponsibleID(int responsibleID) {
        this.responsibleID = responsibleID;
    }

    @Override
    public String toString() {
        return "ProjectResponsible{" + "responsibleFullName=" + responsibleFullName + ", responsibleEmail=" + responsibleEmail + ", projectName=" + projectName + ", companyName=" + companyName + ", responsiblePhone=" + responsiblePhone + ", responsibleID=" + responsibleID + '}';
    }   
}

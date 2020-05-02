package com.standardeleven.project.logical;

public class ProjectApplication {
    private int projectOption1;
    private int projectOption2;
    private int projectOption3;
    private int idProjectApplication;
    private boolean projectStatus;
    private String practitionerEnrollment;

    public ProjectApplication() {
        setIdProjectApplication(0);
        setProjectStatus(false);
        setPractitionerEnrollment("practitionerEnrollment");
        setProjectOption1(0);
        setProjectOption2(0);
        setProjectOption3(0);
    }

    public void setIdProjectApplication(int idProjectApplication) {
        this.idProjectApplication = idProjectApplication;
    }

    public void setProjectStatus(boolean projectStatus) {
        this.projectStatus = projectStatus;
    }

    public void setProjectOption1(int projectOption1) {
        this.projectOption1 = projectOption1;
    }

    public void setProjectOption2(int projectOption2) {
        this.projectOption2 = projectOption2;
    }

    public void setProjectOption3(int projectOption3) {
        this.projectOption3 = projectOption3;
    }

    public void setPractitionerEnrollment(String practitionerEnrollment) {
        this.practitionerEnrollment = practitionerEnrollment;
    }

    public int getIdProjectApplication() {
        return idProjectApplication;
    }

    public int getProjectOption1() {
        return projectOption1;
    }

    public int getProjectOption2() {
        return projectOption2;
    }

    public int getProjectOption3() {
        return projectOption3;
    }

    public String getPractitionerEnrollment() {
        return practitionerEnrollment;
    }

    public boolean isProjectStatus() {
        return projectStatus;
    }

    @Override
    public String toString() {
        return  String.format("| %d | %b | %s | %d | %d | %d", getIdProjectApplication(), isProjectStatus(),
                getPractitionerEnrollment(), getProjectOption1(), getProjectOption2(), getProjectOption3());
    }
}

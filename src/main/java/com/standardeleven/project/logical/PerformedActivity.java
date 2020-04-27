package com.standardeleven.project.logical;

import java.io.File;

public class PerformedActivity {
    private int activityPerformedID;
    private int activityID;
    private String professorNumberPersonal;
    private String studentEnrollment;
    private File activityFile;

    public PerformedActivity(){}

    public PerformedActivity(int activityPerformedID, int activityID, String professorNumberPersonal, String studentEnrollment, File activityFile) {
        this.setActivityPerformedID(activityPerformedID);
        this.setActivityID(activityID);
        this.setProfessorNumberPersonal(professorNumberPersonal);
        this.setStudentEnrollment(studentEnrollment);
        this.setActivityFile(activityFile);
    }

    public int getActivityPerformedID() {
        return activityPerformedID;
    }

    public int getActivityID() {
        return activityID;
    }

    public String getProfessorNumberPersonal() {
        return professorNumberPersonal;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public File getActivityFile() {
        return activityFile;
    }

    public void setActivityPerformedID(int activityPerformedID) {
        this.activityPerformedID = activityPerformedID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public void setProfessorNumberPersonal(String professorNumberPersonal) {
        this.professorNumberPersonal = professorNumberPersonal;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setActivityFile(File activityFile) {
        this.activityFile = activityFile;
    }

    @Override
    public String toString() {
        return "PerformedActivity{" + "activityPerformedID=" + activityPerformedID + ", activityID=" + activityID + ", professorNumberPersonal=" + professorNumberPersonal + ", studentEnrollment=" + studentEnrollment + ", activityFile=" + activityFile + '}';
    }
}

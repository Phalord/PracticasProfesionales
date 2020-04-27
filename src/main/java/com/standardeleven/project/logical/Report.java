package com.standardeleven.project.logical;

import java.io.File;
import java.util.Date;

public class Report {
    private String reportID;
    private String reportTipe;
    private String professorNumberPersonal;
    private Date reportDeliveryDate;
    private File reportFile;
    private int studentGrade;

    public Report(){}

    public Report(String reportID, String reportTipe, Date reportDeliveryDate, File reportFile, int studentGrade, String professorNumberPersonal) {
        this.setReportID(reportID);
        this.setReportTipe(reportTipe);
        this.setReportDeliveryDate(reportDeliveryDate);
        this.setReportFile(reportFile);
        this.setStudentGrade(studentGrade);
        this.setProfessorNumberPersonal(professorNumberPersonal);
    }

    public String getReportID() {
        return reportID;
    }

    public String getReportTipe() {
        return reportTipe;
    }

    public String getProfessorNumberPersonal() {
        return professorNumberPersonal;
    }

    public Date getReportDeliveryDate() {
        return reportDeliveryDate;
    }

    public File getReportFile() {
        return reportFile;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setReportID(String reportID) {
        this.reportID = reportID;
    }

    public void setReportTipe(String reportTipe) {
        this.reportTipe = reportTipe;
    }

    public void setProfessorNumberPersonal(String professorNumberPersonal) {
        this.professorNumberPersonal = professorNumberPersonal;
    }

    public void setReportDeliveryDate(Date reportDeliveryDate) {
        this.reportDeliveryDate = reportDeliveryDate;
    }

    public void setReportFile(File reportFile) {
        this.reportFile = reportFile;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    @Override
    public String toString() {
        return "Report{" + "reportID=" + reportID + ", reportTipe=" + reportTipe + ", professorNumberPersonal=" + professorNumberPersonal + ", reportDeliveryDate=" + reportDeliveryDate + ", reportFile=" + reportFile + ", studentGrade=" + studentGrade + '}';
    }
}

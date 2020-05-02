package com.standardeleven.project.logical;

import java.io.File;
import java.util.Date;

public class Report {
    private String reportID;
    private String reportType;
    private String professorNumberPersonal;
    private Date reportDeliveryDate;
    private File reportFile;
    private int studentGrade;

    public Report(){}

    public Report(String reportID, String reportType, Date reportDeliveryDate, File reportFile, int studentGrade, String professorNumberPersonal) {
        setReportID(reportID);
        setReportType(reportType);
        setReportDeliveryDate(reportDeliveryDate);
        setReportFile(reportFile);
        setStudentGrade(studentGrade);
        setProfessorNumberPersonal(professorNumberPersonal);
    }

    public String getReportID() {
        return reportID;
    }

    public String getReportType() {
        return reportType;
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

    public void setReportType(String reportType) {
        this.reportType = reportType;
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

}

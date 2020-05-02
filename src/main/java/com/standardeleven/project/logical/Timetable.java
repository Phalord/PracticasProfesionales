package com.standardeleven.project.logical;

import java.io.File;

public class Timetable {
    private String timetableID;
    private String studentEnrollment;
    private File timetableFile;

    public Timetable(){}

    public Timetable(String timetableID, File timetableFile, String studentEnrollment) {
        setTimetableID(timetableID);
        setTimetableFile(timetableFile);
        setStudentEnrollment(studentEnrollment);
    }

    public void setTimetableID(String timetableID) {
        this.timetableID = timetableID;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setTimetableFile(File timetableFile) {
        this.timetableFile = timetableFile;
    }

    public String getTimetableID() {
        return timetableID;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public File getTimetableFile() {
        return timetableFile;
    }

    @Override
    public String toString() {
        return "Timetable{" + "timetableID=" + timetableID + ", studentEnrollment=" + studentEnrollment + ", timetableFile=" + timetableFile + '}';
    }
}

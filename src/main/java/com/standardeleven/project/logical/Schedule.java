package com.standardeleven.project.logical;

import java.io.File;

public class Schedule {
    private String scheduleID;
    private String studentEnrollment;
    private File scheduleFile;

    public Schedule(){}

    public Schedule(String scheduleID, File scheduleFile, String studentEnrollment) {
        this.setScheduleID(scheduleID);
        this.setScheduleFile(scheduleFile);
        this.setStudentEnrollment(studentEnrollment);
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setScheduleFile(File scheduleFile) {
        this.scheduleFile = scheduleFile;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public File getScheduleFile() {
        return scheduleFile;
    }

    @Override
    public String toString() {
        return "Schedule{" + "scheduleID=" + scheduleID + ", studentEnrollment=" + studentEnrollment + ", scheduleFile=" + scheduleFile + '}';
    }
}

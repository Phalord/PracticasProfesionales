package com.standardeleven.project.logical;

import java.io.File;

public class SelfAppraisal {
    private int selfappraisalID;
    private String studentEnrollment;
    private File selfappraisalFile;

    public SelfAppraisal(){}

    public SelfAppraisal(int selfappraisalID, File selfappraisalFile, String studentEnrollment) {
        this.setSelfappraisalID(selfappraisalID);
        this.setSelfappraisalFile(selfappraisalFile);
        this.setStudentEnrollment(studentEnrollment);
    }

    public int getSelfappraisalID() {
        return selfappraisalID;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public File getSelfappraisalFile() {
        return selfappraisalFile;
    }

    public void setSelfappraisalID(int selfappraisalID) {
        this.selfappraisalID = selfappraisalID;
    }

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setSelfappraisalFile(File selfappraisalFile) {
        this.selfappraisalFile = selfappraisalFile;
    }

    @Override
    public String toString() {
        return "SelfAppraisal{" + "selfappraisalID=" + selfappraisalID + ", studentEnrollment=" + studentEnrollment + ", selfappraisalFile=" + selfappraisalFile + '}';
    }
}

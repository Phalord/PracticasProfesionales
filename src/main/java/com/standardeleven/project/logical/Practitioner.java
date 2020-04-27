package com.standardeleven.project.logical;

public class Practitioner {
    private String studentEnrollment;
    private String studentName;
    private String studentFatherSurname;
    private String studentMotherSurname;
    private String studentShift;
    private int studentGrade;
    private int personalProfessor;

    public void setStudentEnrollment(String studentEnrollment) {
        this.studentEnrollment = studentEnrollment;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentFatherSurname(String studentFatherSurname) {
        this.studentFatherSurname = studentFatherSurname;
    }

    public void setStudentMotherSurname(String studentMotherSurname) {
        this.studentMotherSurname = studentMotherSurname;
    }

    public void setStudentShift(String studentShift) {
        this.studentShift = studentShift;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public void setPersonalProfessor(int personalProfessor) {
        this.personalProfessor = personalProfessor;
    }

    public String getStudentEnrollment() {
        return studentEnrollment;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentFatherSurname() {
        return studentFatherSurname;
    }

    public String getStudentMotherSurname() {
        return studentMotherSurname;
    }

    public String getStudentShift() {
        return studentShift;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public int getPersonalProfessor() {
        return personalProfessor;
    }
}

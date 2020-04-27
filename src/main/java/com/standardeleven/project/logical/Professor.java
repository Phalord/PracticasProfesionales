package com.standardeleven.project.logical;

public class Professor {
    
    private String professorNames;
    private String professorFatherSurname;
    private String professorMotherSurname;
    private String professorShift;
    private String professorPassword;
    private String professorNumberPersonal;
    
    public Professor(){}

    public Professor(String professorNumberPersonal, String professorNames, String professorFatherSurname, String professorMotherSurname, String professorShift, String professorPassword) {
        this.setProfessorNames(professorNames);
        this.setProfessorFatherSurname(professorFatherSurname);
        this.setProfessorMotherSurname(professorMotherSurname);
        this.setProfessorShift(professorShift);
        this.setProfessorPassword(professorPassword);
        this.setProfessorNumberPersonal(professorNumberPersonal);
    }

    public String getProfessorNames() {
        return professorNames;
    }

    public String getProfessorFatherSurname() {
        return professorFatherSurname;
    }

    public String getProfessorMotherSurname() {
        return professorMotherSurname;
    }

    public String getProfessorShift() {
        return professorShift;
    }

    public String getProfessorPassword() {
        return professorPassword;
    }

    public String getProfessorNumberPersonal() {
        return professorNumberPersonal;
    }

    public void setProfessorNames(String professorNames) {
        this.professorNames = professorNames;
    }

    public void setProfessorFatherSurname(String professorFatherSurname) {
        this.professorFatherSurname = professorFatherSurname;
    }

    public void setProfessorMotherSurname(String professorMotherSurname) {
        this.professorMotherSurname = professorMotherSurname;
    }

    public void setProfessorShift(String professorShift) {
        this.professorShift = professorShift;
    }

    public void setProfessorPassword(String professorPassword) {
        this.professorPassword = professorPassword;
    }

    public void setProfessorNumberPersonal(String professorNumberPersonal) {
        this.professorNumberPersonal = professorNumberPersonal;
    }

    @Override
    public String toString() {
        return "Professor{" + "professorNames=" + professorNames + ", professorFatherSurname=" + professorFatherSurname + ", professorMotherSurname=" + professorMotherSurname + ", professorShift=" + professorShift + ", professorPassword=" + professorPassword + ", professorNumberPersonal=" + professorNumberPersonal + '}';
    }
}
    
 

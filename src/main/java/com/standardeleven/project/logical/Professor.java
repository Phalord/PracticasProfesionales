package com.standardeleven.project.logical;

public class Professor extends User {
    private String professorNames;
    private String professorFatherSurname;
    private String professorMotherSurname;
    private String professorShift;
    
    public Professor(){
        super();
        setProfessorNames("professorNames");
        setProfessorFatherSurname("professorFatherSurname");
        setProfessorMotherSurname("professorMotherSurname");
        setProfessorShift("professorShift");
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

    @Override
    public String toString() {
        return getProfessorNames() + "("+getUserName()+")";
    }
}
    
 

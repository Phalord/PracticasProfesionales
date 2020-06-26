package com.standardeleven.project.logical;

import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

public class Practitioner extends User{
    
    private String studentName;
    private String studentFatherSurname;
    private String studentMotherSurname;
    private String studentShift;
    private int studentGrade;
    private int personalProfessor;

    public Practitioner() {
        super();
        setStudentName("studentName");
        setStudentFatherSurname("studentFatherSurname");
        setStudentMotherSurname("studentMotherSurname");
        setStudentShift("studentShift");
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

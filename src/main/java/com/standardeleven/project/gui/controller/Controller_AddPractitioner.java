package com.standardeleven.project.gui.controller;

import com.standardeleven.project.logical.Practitioner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller_AddPractitioner implements Initializable {

    @FXML
    private Button registerButton;
    @FXML
    private TextField studentNameTextField;
    @FXML
    private TextField studentFatherSurnameTextField;
    @FXML
    private TextField studentMotherSurnameTextField;
    @FXML
    private TextField studentShiftTextField;
    @FXML
    
    private TextField personalProfessorTextField;
    private Practitioner practitioner;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    @FXML
    private void registerPractitioner(ActionEvent event) {
        String studentName = this.studentNameTextField.getText();
        String studentFatherSurname = this.studentFatherSurnameTextField.getText();
        String studentMotherSurname = this.studentMotherSurnameTextField.getText();
        String studentShift = this.studentShiftTextField.getText();
        int personalProfessor = Integer.parseInt(this.personalProfessorTextField.getText());
        this.practitioner = new Practitioner();
        practitioner.setStudentName(studentName);
        practitioner.setStudentFatherSurname(studentFatherSurname);
        practitioner.setStudentMotherSurname(studentMotherSurname);
        practitioner.setStudentShift(studentShift);
        practitioner.setPersonalProfessor(personalProfessor);
    }
    
    private Practitioner validateExists() {
        return null;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }
}

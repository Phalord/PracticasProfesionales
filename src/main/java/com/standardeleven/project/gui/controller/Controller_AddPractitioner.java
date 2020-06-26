package com.standardeleven.project.gui.controller;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller_AddPractitioner implements Initializable {
    @FXML
    private Button registerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button deleteButton;
    @FXML
    private RadioButton radioButtonEvening;
    @FXML
    private RadioButton radioButtonMorning;
    @FXML
    private TextField studentNameTextField;
    @FXML
    private TextField studentFatherSurnameTextField;
    @FXML
    private TextField studentMotherSurnameTextField;
    @FXML
    private TextField personalProfessorTextField;
    @FXML
    private TextField studentEnrollmentTextField;
    @FXML
    private TextField usernameTexField;
    @FXML
    private ToggleGroup shiftGroup;
    @FXML
    private TableView<Practitioner> tableViewPractitioner;
    @FXML
    private TableColumn<Practitioner, String> enrollmentColumn;
    @FXML
    private TableColumn<Practitioner, String> nameColumn;
    @FXML
    private TableColumn<Practitioner, String> fatherSurnameColumn;
    @FXML
    private TableColumn<Practitioner, String> motherSurnameColumn;
    @FXML
    private TableColumn<Practitioner, String> shiftColumn;
    @FXML
    private TableColumn<Practitioner, String> gradeColumn;
    
    private ObservableList<Practitioner> listPractitioner;
    private final PractitionerDAO practitionerDAO = new PractitionerDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MySQLConnection mySQLConnection = new MySQLConnection();
        listPractitioner = FXCollections.observableArrayList();
        try {
            practitionerDAO.fillPractitionerTable(mySQLConnection.getConnection(),listPractitioner);
        } catch (SQLException sqlException) {
            Logger.getLogger(Controller_AddPractitioner.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        tableViewPractitioner.setItems(listPractitioner);
        linkColumnsWithAttributes();
    }    
    
    @FXML
    private void registerPractitioner(ActionEvent event) {
        Practitioner practitioner = new Practitioner();
        User user = new User();
        String username = this.usernameTexField.getText();
        
        String studentName = this.studentNameTextField.getText();
        String studentFatherSurname = this.studentFatherSurnameTextField.getText();
        String studentMotherSurname = this.studentFatherSurnameTextField.getText();
        String radioButtonEvening = this.radioButtonEvening.isSelected()?"Vespertino":"Matutino";
        //int personalProfessor = Integer.parseInt(this.personalProfessorTextField.getText());
        practitioner.setUserName(username); //1
        practitioner.setStudentName(studentName); //2
        practitioner.setStudentFatherSurname(studentFatherSurname); //3
        practitioner.setStudentMotherSurname(studentMotherSurname); //4
        practitioner.setStudentShift(radioButtonEvening); //5
        
        /*
        // Calificacion // 7
        //practitioner.setPersonalProfessor(personalProfessor); //7?
        
        //Poner aquí lo del user, ya solo faltaría contraseña aleatoria y haseada, y tipo de usuario que seria "practicante" en este caso
        
        //User user = iUserDAO.getUserByEnrollment("s18012132");
        user.setUserName(username);
        user.setUserPassword("ConT123RaSeÃ±123a!1");
        user.setUserType("practicante");
        
        //Validar y llamar el DAO
        
 
        //Lamando el DAO
        if(practitionerDAO.addPractitioner(practitioner)){
            Alert dialog = new Alert(AlertType.INFORMATION);
            dialog.setTitle("Registro agregado");
            dialog.setContentText("¡Se ha registrado un practicante exitosamente!");
            dialog.setHeaderText("Éxito");
            dialog.show();
        } else {
            System.out.println("nel");
        }
        
        */
    }
    
    private boolean validateExistsPractitioner() {
        return true;
    }
    
    private void linkColumnsWithAttributes() {
        enrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        fatherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentFatherSurname"));
        motherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentMotherSurname"));
        shiftColumn.setCellValueFactory(new PropertyValueFactory<>("studentShift"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("studentGrade"));
    }
    
    private void cleanTextField() {
        usernameTexField.setText(null);
        studentNameTextField.setText(null);
        studentFatherSurnameTextField.setText(null);
        studentFatherSurnameTextField.setText(null);
        radioButtonEvening.setSelected(false);
        radioButtonMorning.setSelected(false);
        registerButton.setDisable(false);
        deleteButton.setDisable(false);
    }
}

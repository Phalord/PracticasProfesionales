package com.standardeleven.project.gui.controller;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.ProfessorDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Practitioner;
import com.standardeleven.project.logical.Professor;
import com.standardeleven.project.logical.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Controller_AddPractitioner implements Initializable {
    @FXML
    private AnchorPane anchorPaneAddPractitioner;
    @FXML
    private Button registerButton;
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
    private TextField studentEnrollmentTextField;
    @FXML
    private ComboBox professorComboBox;
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
    private TableColumn<Practitioner, String> personalProfessorNumberColumn;
    
    private ObservableList<Practitioner> listPractitioner;
    private ObservableList<Professor> listProfessor;
    private final PractitionerDAO practitionerDAO = new PractitionerDAO();
    private final ProfessorDAO professorDAO = new ProfessorDAO();
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();
    private ArrayList<String> fails;
    private boolean empty = false; //hacer constante


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fails = new ArrayList<>();
        listPractitioner = FXCollections.observableArrayList();
        listProfessor = FXCollections.observableArrayList();
        MySQLConnection mySQLConnection = new MySQLConnection();
        try {
            professorDAO.fillProfessorInformation(mySQLConnection.getConnection(), listProfessor);
            professorComboBox.setItems(listProfessor);
            practitionerDAO.fillPractitionerTable(mySQLConnection.getConnection(),listPractitioner);
        } catch (SQLException sqlException) {
            Logger.getLogger(Controller_AddPractitioner.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        tableViewPractitioner.setItems(listPractitioner);
        linkColumnsWithAttributes();
    }    
    @FXML
    private void registerPractitioner(ActionEvent event) { 
        validateEmpty();
        if (!empty) {
            String username = this.studentEnrollmentTextField.getText();
            String studentName = this.studentNameTextField.getText();
            String studentFatherSurname = this.studentFatherSurnameTextField.getText();
            String studentMotherSurname = this.studentMotherSurnameTextField.getText();
            String radioButtonEvening = this.radioButtonEvening.isSelected()?"Matutino":"Vespertino";
            if (validateStudentEnrollment()) {
                Alert studentEnrollmentErrorDialog = new Alert(AlertType.WARNING);
                studentEnrollmentErrorDialog.setTitle("Aviso");
                studentEnrollmentErrorDialog.setHeaderText(null);
                studentEnrollmentErrorDialog.setContentText("Matricula inválida. La primera letra debe ser una s minúcula seguida de 8 digitos numéricos");
                studentEnrollmentErrorDialog.show();
                return;
            }
            String personalProfessor = (String) professorComboBox.getSelectionModel().getSelectedItem().toString();
            Practitioner practitioner = new Practitioner();        
            practitioner.setUserName(username); //1
            practitioner.setStudentName(studentName); //2
            practitioner.setStudentFatherSurname(studentFatherSurname); //3
            practitioner.setStudentMotherSurname(studentMotherSurname); //4
            practitioner.setStudentShift(radioButtonEvening); //5
            practitioner.setPersonalProfessor(personalProfessor); //6        
            IUserDAO iUserDAO = new UserDAO(); 
            User user = iUserDAO.getUserByEnrollment(username);
            if (iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
                practitioner.setUserPassword("practitioner");
                practitioner.setUserType("practicante");
                if (iUserDAO.addUser(practitioner)) {
                    assertTrue(iPractitionerDAO.addPractitioner(practitioner));
                    listPractitioner.add(practitioner);                
                    Alert successDialog = new Alert(AlertType.INFORMATION);
                    successDialog.setTitle("Registro agregado");
                    successDialog.setContentText("¡Se ha registrado un practicante exitosamente!");
                    successDialog.setHeaderText(null);
                    successDialog.show();
                    cleanTextField();
                } else {
                    Alert alertDialog = new Alert(AlertType.WARNING);
                    alertDialog.setTitle("Aviso");
                    alertDialog.setHeaderText(null);
                    alertDialog.setContentText("No se pudo agregar el practicante. Intente de nuevo");
                }
            } else {
                Alert errorDialog = new Alert(AlertType.ERROR);
                errorDialog.setTitle("Error");
                errorDialog.setHeaderText(null);
                errorDialog.setContentText("El practicante ya existe");
                errorDialog.showAndWait();
            }               
        } else {
            Alert validateErrorDialog = new Alert(AlertType.WARNING);
            validateErrorDialog.setTitle("Aviso");
            validateErrorDialog.setHeaderText(null);
            validateErrorDialog.setContentText("Debe llenar todos los campos solicitados");
            validateErrorDialog.show();
            empty = false;
        } 
    }
    
    /*
    @FXML
    private void registerPractitioner(ActionEvent event) { 
        String username = this.studentEnrollmentTextField.getText();
        String studentName = this.studentNameTextField.getText();
        String studentFatherSurname = this.studentFatherSurnameTextField.getText();
        String studentMotherSurname = this.studentMotherSurnameTextField.getText();
        String radioButtonEvening = this.radioButtonEvening.isSelected()?"Matutino":"Vespertino";
        validateEmpty();
        if (fails.size()>0) {
            Alert validateErrorDialog = new Alert(AlertType.WARNING);
            validateErrorDialog.setTitle("Aviso");
            validateErrorDialog.setHeaderText(null);
            validateErrorDialog.setContentText("Debe llenar todos los campos solicitados");
            validateErrorDialog.show();
            fails.clear();
            return;
        } else if (validateStudentEnrollment()) {
            Alert studentEnrollmentErrorDialog = new Alert(AlertType.WARNING);
            studentEnrollmentErrorDialog.setTitle("Aviso");
            studentEnrollmentErrorDialog.setHeaderText(null);
            studentEnrollmentErrorDialog.setContentText("Matricula inválida. La primera letra debe ser una s minúcula seguida de 8 digitos numéricos");
            studentEnrollmentErrorDialog.show();
            return;
        }
        String personalProfessor = (String) professorComboBox.getSelectionModel().getSelectedItem().toString();
        Practitioner practitioner = new Practitioner();        
        practitioner.setUserName(username); //1
        practitioner.setStudentName(studentName); //2
        practitioner.setStudentFatherSurname(studentFatherSurname); //3
        practitioner.setStudentMotherSurname(studentMotherSurname); //4
        practitioner.setStudentShift(radioButtonEvening); //5
        practitioner.setPersonalProfessor(personalProfessor); //6        
        IUserDAO iUserDAO = new UserDAO(); 
        User user = iUserDAO.getUserByEnrollment(username);
        if (iPractitionerDAO.getPractitioner(practitioner.getUserName()) == null) {
            practitioner.setUserPassword("practitioner");
            practitioner.setUserType("practicante");
            if (iUserDAO.addUser(practitioner)) {
                assertTrue(iPractitionerDAO.addPractitioner(practitioner));
                listPractitioner.add(practitioner);                
                Alert successDialog = new Alert(AlertType.INFORMATION);
                successDialog.setTitle("Registro agregado");
                successDialog.setContentText("¡Se ha registrado un practicante exitosamente!");
                successDialog.setHeaderText(null);
                successDialog.show();
                cleanTextField();
            } else {
                Alert alertDialog = new Alert(AlertType.WARNING);
                alertDialog.setTitle("Aviso");
                alertDialog.setHeaderText(null);
                alertDialog.setContentText("No se pudo agregar el practicante. Intente de nuevo");
            }
        } else {
            Alert errorDialog = new Alert(AlertType.ERROR);
            errorDialog.setTitle("Error");
            errorDialog.setHeaderText(null);
            errorDialog.setContentText("El practicante ya existe");
            errorDialog.showAndWait();
        }
    }
    */
    
    private boolean validateEmpty() {
        if(shiftGroup.getSelectedToggle() == null 
                || studentEnrollmentTextField.getText().isEmpty() || studentNameTextField.getText().isEmpty() ||
                studentFatherSurnameTextField.getText().isEmpty() || studentMotherSurnameTextField.getText().isEmpty() || professorComboBox.getSelectionModel() == null) {
            empty = true;
        }
        return empty;
    }
    
    private boolean validateStudentEnrollment() {
        String regexStudentEnrollment = "(^[s]{1,3}([0-9]{8})){1}";
        return !Pattern.matches(regexStudentEnrollment, studentEnrollmentTextField.getText());
    }
    
    private void validateComboBox() {
        if (professorComboBox.getSelectionModel() == null) {
            fails.add("Debe selecciona id de profesor");
        }   
    }
    
    private void linkColumnsWithAttributes() {
        enrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        fatherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentFatherSurname"));
        motherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentMotherSurname"));
        shiftColumn.setCellValueFactory(new PropertyValueFactory<>("studentShift"));
        personalProfessorNumberColumn.setCellValueFactory(new PropertyValueFactory<>("personalProfessor"));
    }
    
    private void cleanTextField() {
        studentEnrollmentTextField.setText(null);
        studentNameTextField.setText(null);
        studentFatherSurnameTextField.setText(null);
        studentMotherSurnameTextField.setText(null);
        radioButtonEvening.setSelected(false);
        radioButtonMorning.setSelected(false);
        registerButton.setDisable(false);
        professorComboBox.setValue(null);
    }

    @FXML
    private void closeWindow (ActionEvent event) {
        Stage window = (Stage) anchorPaneAddPractitioner.getScene().getWindow();
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_CoordinatorHome.fxml"));
            viewFile = loader.load();
            Controller_CoordinatorHome coordinatorHomeController = loader.getController();
            coordinatorHomeController = loader.getController();
            window.setScene(new Scene(viewFile));
        } catch (IOException ioException) {
            Logger.getLogger(Controller_AddPractitioner.class.getName()).log(Level.SEVERE,
                    ioException.getMessage(), ioException);
        }
    }
}

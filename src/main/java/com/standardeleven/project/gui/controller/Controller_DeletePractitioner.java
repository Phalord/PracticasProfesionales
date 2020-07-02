package com.standardeleven.project.gui.controller;

import com.npcstudio.sqlconnection.MySQLConnection;
import com.standardeleven.project.dataaccess.dao.PractitionerDAO;
import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IPractitionerDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.logical.Practitioner;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Controller_DeletePractitioner implements Initializable {

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
    @FXML
    private TableView<Practitioner> tableViewPractitioner;
    @FXML
    private Button deletePractitionerButton;
    @FXML
    private Button cancelButton;
    @FXML
    private AnchorPane deletePractitionerAnchorPane;
    private ObservableList<Practitioner> listPractitioner;
    private final PractitionerDAO practitionerDAO = new PractitionerDAO();
    private final static IPractitionerDAO iPractitionerDAO = new PractitionerDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listPractitioner = FXCollections.observableArrayList();
        MySQLConnection mySQLConnection = new MySQLConnection();
        try {
            practitionerDAO.fillPractitionerTable(mySQLConnection.getConnection(),listPractitioner);
        } catch (SQLException sqlException) {
            Logger.getLogger(Controller_AddPractitioner.class.getName()).log(Level.SEVERE, sqlException.getMessage(), sqlException);
        }
        tableViewPractitioner.setItems(listPractitioner);
        linkColumnsWithAttributes();     
    }
    
    @FXML
    private void deletePractitioner(ActionEvent event) {
        if (getValueFromCell() != null) {
            String enrollment = getValueFromCell();
            Practitioner practitioner = iPractitionerDAO.getPractitioner(enrollment);
            IUserDAO iUserDAO = new UserDAO();
            if (practitioner != null) {
                if (iPractitionerDAO.deletePractitioner(practitioner)) {
                    assertTrue(iUserDAO.deleteUser(practitioner));
                    listPractitioner.remove(tableViewPractitioner.getSelectionModel().getSelectedIndex());                
                    Alert successDialog = new Alert(Alert.AlertType.INFORMATION);
                    successDialog.setTitle("Practicante eliminado");
                    successDialog.setContentText("¡Se ha eliminado el practicante exitosamente!");
                    successDialog.setHeaderText(null);
                    successDialog.show(); 
                } else {
                    Alert alertDialog = new Alert(Alert.AlertType.WARNING);
                    alertDialog.setTitle("Aviso");
                    alertDialog.setHeaderText(null);
                    alertDialog.setContentText("No se pudo eliminar el practicante. Intente de nuevo");
                }
            } else {
                Alert errorDialog = new Alert(Alert.AlertType.ERROR);
                errorDialog.setTitle("Error");
                errorDialog.setHeaderText(null);
                errorDialog.setContentText("El practicante no existe");
                errorDialog.showAndWait();
            }
        } else {
            Alert selectPractitionerAlertDialog = new Alert(Alert.AlertType.WARNING);
            selectPractitionerAlertDialog.setTitle("Aviso");
            selectPractitionerAlertDialog.setHeaderText(null);
            selectPractitionerAlertDialog.setContentText("Debe seleccionar una practicante para eliminar"); 
        }
    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage window = (Stage) deletePractitionerAnchorPane.getScene().getWindow();
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
    
    public String getValueFromCell() {
        String enrollment = null;
        if (tableViewPractitioner.getSelectionModel().getSelectedItem() != null) {
            TablePosition position = tableViewPractitioner.getSelectionModel().getSelectedCells().get(0);
            int row = position.getRow();
            Practitioner item = tableViewPractitioner.getItems().get(row);
            TableColumn column = enrollmentColumn;
            enrollment = (String) column.getCellObservableValue(item).getValue();
        }
        return enrollment;
    }
    
    private void linkColumnsWithAttributes() {
        enrollmentColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        fatherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentFatherSurname"));
        motherSurnameColumn.setCellValueFactory(new PropertyValueFactory<>("studentMotherSurname"));
        shiftColumn.setCellValueFactory(new PropertyValueFactory<>("studentShift"));
        personalProfessorNumberColumn.setCellValueFactory(new PropertyValueFactory<>("personalProfessor"));
    }
}

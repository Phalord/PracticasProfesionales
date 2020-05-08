package com.standardeleven.project.gui.controller;

import com.standardeleven.project.dataaccess.dao.ProjectDAO;
import com.standardeleven.project.logical.Project;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Controller_AddProject implements Initializable {

    @FXML
    private Label labelAddProjectTitle;
    @FXML
    private TextField txtCompanyName;
    @FXML
    private TextField txtCompanyAddress;
    @FXML
    private TextField txtCompanyCity;
    @FXML
    private TextField txtCompanyState;
    @FXML
    private TextField txtCompanySector;
    @FXML
    private TextField txtCompanyPhone;
    @FXML
    private TextField txtCompanyEmail;
    @FXML
    private TextField txtResponsibleName;
    @FXML
    private TextField txtResponsibleEmail;
    @FXML
    private TextField txtResponsiblePhone;
    @FXML
    private TextField txtProjectName;
    @FXML
    private TextArea txtProjectDescription;
    @FXML
    private TextArea txtProjectResources;
    @FXML
    private Button buttonRegister;
    @FXML
    private Button buttonCancel;
    @FXML
    private AnchorPane container;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegisterProject(ActionEvent event) { 
        if (txtProjectName.getText().isEmpty() || txtProjectDescription.getText().isEmpty() || txtProjectResources.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos");
        } else {
            Project project = new Project();
            ProjectDAO connectionProject = new ProjectDAO();
            project.setProjectName(txtProjectName.getText());
            project.setProjectDescription(txtProjectDescription.getText());
            project.setProjectResource(txtProjectResources.getText());
            connectionProject.addProject(project);
            
            
        }
    }

    @FXML
    private void returnHome(ActionEvent event) throws IOException {
        int selection = JOptionPane.showConfirmDialog(null, "¿Desea cancelar el registro del proyecto?", "Cancelar creación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(selection == JOptionPane.YES_OPTION){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("View_ProjectSection.fxml"));
            container.getChildren().setAll(pane);  
        }
    }
    
}

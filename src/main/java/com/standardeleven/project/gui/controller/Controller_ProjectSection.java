package com.standardeleven.project.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Controller_ProjectSection implements Initializable {
    @FXML
    private AnchorPane container;
    @FXML
    private Button buttonAddProject;
    @FXML
    private Button buttonUpdateProject;
    @FXML
    private Button buttonProjectList;
    @FXML
    private Button buttonDeleteProject;
    @FXML
    private ImageView imgAdd;
    @FXML
    private ImageView imgRemove;
    @FXML
    private ImageView imgUpload;
    @FXML
    private ImageView imgListCheck;
    @FXML
    private ImageView imgHome;
    @FXML
    private Label labelProjectSectionTitle;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registerProject(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("View_AddProject.fxml"));
        container.getChildren().setAll(pane);
    }

    @FXML
    private void updateProject(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void listRegisteredProjects(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void deleteProject(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void returnHome(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }
}

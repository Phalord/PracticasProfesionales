package com.standardeleven.project.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller_CoordinatorHome implements Initializable {
    @FXML private Button registerPractitionerButton;
    @FXML private AnchorPane anchorPaneCoordinatorHome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}     

    @FXML
    private void addPractitionerClick(ActionEvent event) throws IOException {
        Stage window = (Stage) anchorPaneCoordinatorHome.getScene().getWindow();
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_AddPractitioner.fxml"));
            viewFile = loader.load();
            Controller_AddPractitioner addPractitionerController = loader.getController();
            addPractitionerController = loader.getController();
            window.setScene(new Scene(viewFile));
        } catch (IOException ioException) {
            Logger.getLogger(Controller_CoordinatorHome.class.getName()).log(Level.SEVERE, 
                    ioException.getMessage(), ioException);
        }
    }

    @FXML
    private void deletePractitionerClick(ActionEvent event) {
        Stage window = (Stage) anchorPaneCoordinatorHome.getScene().getWindow();
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_DeletePractitioner.fxml"));
            viewFile = loader.load();
            Controller_DeletePractitioner deletePractitionerController = loader.getController();
            deletePractitionerController = loader.getController();
            window.setScene(new Scene(viewFile));
        } catch (IOException ioException) {
            Logger.getLogger(Controller_CoordinatorHome.class.getName()).log(Level.SEVERE, 
                    ioException.getMessage(), ioException);
        }        
    }
}
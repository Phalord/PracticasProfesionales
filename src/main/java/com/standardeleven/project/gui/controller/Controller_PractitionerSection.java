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
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Controller_PractitionerSection implements Initializable {
    @FXML private Button registerPractitionerButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}     

    @FXML
    private void addPractitionerClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_AddPractitioner.fxml"));
            Parent root = loader.load();
            Controller_AddPractitioner addPractitionerController;
            addPractitionerController = loader.getController();
            Scene addPractitionerScene = new Scene(root);
            Stage addPractitionerStage = new Stage();
            addPractitionerStage.setResizable(false);
            addPractitionerStage.initModality(Modality.APPLICATION_MODAL);
            addPractitionerStage.setScene(addPractitionerScene);
            addPractitionerStage.showAndWait();
        } catch (IOException ioException) {
            Logger.getLogger(Controller_PractitionerSection.class.getName()).log(Level.SEVERE, 
                    ioException.getMessage(), ioException);
        }  
    }
}
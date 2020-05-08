package com.standardeleven.project.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Controller_ActivitySection implements Initializable {

    @FXML
    private ImageView imgHome;
    @FXML
    private Button buttonGenerateActivity;
    @FXML
    private Button buttonDeliveredActivities;
    @FXML
    private Button buttonPresentationFormat;
    @FXML
    private AnchorPane container;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void generateActivity(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("View_CreateActivity.fxml"));
        container.getChildren().setAll(pane);
    }

    @FXML
    private void showDeliveryActivities(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void uploadPresentationFormat(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void returnHome(MouseEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }
    
}

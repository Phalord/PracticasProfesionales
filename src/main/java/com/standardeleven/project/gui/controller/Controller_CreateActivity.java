package com.standardeleven.project.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Controller_CreateActivity implements Initializable {

    @FXML
    private TextField txtTitle;
    @FXML
    private TextArea txtDescription;
    @FXML
    private DatePicker txtDeliveryDate;
    @FXML
    private Button buttonPublish;
    @FXML
    private Button buttonCancel;
    @FXML
    private AnchorPane container;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void getDeliveryDate(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void publishActivity(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void returnHome(ActionEvent event) throws IOException {
        int selection = JOptionPane.showConfirmDialog(null, "¿Desea cancelar la creación de la actividad?", "Cancelar creación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(selection == JOptionPane.YES_OPTION){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("View_ActivitySection.fxml"));
            container.getChildren().setAll(pane);  
        }
    }
}

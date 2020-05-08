package com.standardeleven.project.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

public class Controller_CreateSelfAppraisal implements Initializable {

    @FXML
    private TextField txtSentence1;
    @FXML
    private TextField txtSentence2;
    @FXML
    private TextField txtSentence3;
    @FXML
    private TextField txtSentence4;
    @FXML
    private TextField txtSentence5;
    @FXML
    private TextField txtSentence6;
    @FXML
    private TextField txtSentence7;
    @FXML
    private TextField txtSentence8;
    @FXML
    private TextField txtSentence9;
    @FXML
    private TextField txtSentence10;
    @FXML
    private Button buttonGenerateSelfApraissal;
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
    private void generateSelfApraissal(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }

    @FXML
    private void returnHome(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Función no implementada aún");
    }
    
}

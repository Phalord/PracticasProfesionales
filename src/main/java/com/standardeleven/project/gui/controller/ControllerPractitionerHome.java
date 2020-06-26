package com.standardeleven.project.gui.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;

public class ControllerPractitionerHome {
    private final Stage window = new Stage();
    @FXML private String userName;

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getUsername() {
        return userName;
    }

    @FXML
    public void goProjectSection() {

    }

    @FXML
    public void generateDocumentation() {

    }

    @FXML
    public void uploadDocumentation() {

    }

    public void back() {

    }
}
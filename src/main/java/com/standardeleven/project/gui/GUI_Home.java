package com.standardeleven.project.gui;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI_Home implements IWindowGUI {
    private Stage window;
    private BorderPane borderPane;

    public GUI_Home(String accountType) {
        switch (accountType) {
            case "practicante":
                buildPractitionerScene();
                break;
            case "coordinador":
                buildCoordinatorScene();
                break;
            case "profesor":
                buildProfessorScene();
                break;
            default:
                Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, "Account type out of boundaries");
        }
    }

    @Override
    public void display() {
        window.setScene(new Scene(borderPane, 720, 480));
        window.show();
    }

    @Override
    public void buildStage(Stage stage, String title) {
        window = stage;
        window.setTitle(title);
    }

    public void buildPractitionerScene() {
        buildStage(new Stage(), "Practicante");
        Label label = new Label("Bienvenido, Practicante!");
        borderPane = new BorderPane();
        borderPane.setCenter(label);
    }
    public void buildCoordinatorScene() {
        buildStage(new Stage(), "Coordinador");
        Label label = new Label("Bienvenido, Coordinador!");
        borderPane = new BorderPane();
        borderPane.setCenter(label);
    }
    public void buildProfessorScene() {
        buildStage(new Stage(), "Profesor");
        Label label = new Label("Bienvenido, Profesor!");
        borderPane = new BorderPane();
        borderPane.setCenter(label);
    }
}

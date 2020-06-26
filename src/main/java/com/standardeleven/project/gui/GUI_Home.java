package com.standardeleven.project.gui;

import com.standardeleven.project.gui.controller.ControllerPractitionerHome;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.standardeleven.project.main.Main.PRACTITIONER;
import static com.standardeleven.project.main.Main.COORDINATOR;
import static com.standardeleven.project.main.Main.PROFESSOR;

public class GUI_Home implements IWindowGUI {
    private Stage window;

    public GUI_Home(String accountType, String userName) {
        final String fxmlPractitionerHome = "/view/View_PractitionerHome.fxml";
        final String fxmlCoordinatorHome = "/view/View_CoordinatorHome.fxml";
        final String fxmlProfessorHome = "/view/View_ProfessorHome.fxml";
        switch (accountType) {
            case PRACTITIONER:
                buildStage(new Stage(), "Practicante");
                buildScene(fxmlPractitionerHome);
                break;
            case COORDINATOR:
                buildStage(new Stage(), "Coordinador");
                buildScene(fxmlCoordinatorHome);
                break;
            case PROFESSOR:
                buildStage(new Stage(), "Profesor");
                buildScene(fxmlProfessorHome);
                break;
            default:
                Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, "Account type out of boundaries");
                break;
        }
    }

    @Override
    public void display() {
        window.show();
    }

    @Override
    public void buildStage(Stage stage, String title) {
        window = stage;
        window.setTitle(title);
    }

    private void buildScene(String fxmlFile) {
        Parent viewFile;
        try {
            viewFile = FXMLLoader.load(getClass().getResource(fxmlFile));
            window.setScene(new Scene(viewFile, 600, 400));
            window.setResizable(false);
        } catch (IOException ioException) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, ioException.getMessage(), ioException);
        }
    }
}

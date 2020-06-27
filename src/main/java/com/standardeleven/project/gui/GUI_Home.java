package com.standardeleven.project.gui;

import com.standardeleven.project.gui.controller.ControllerLogIn;
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
        final String fxmlCoordinatorHome = "/view/View_CoordinatorHome.fxml";
        final String fxmlProfessorHome = "/view/View_ProfessorHome.fxml";
        switch (accountType) {
            case PRACTITIONER:
                buildStage(new Stage(), "Practicante");
                buildPractitionerHomeScene(userName);
                break;
            case COORDINATOR:
                buildStage(new Stage(), "Coordinador");
                //buildCoordinatorHomeScene(userName);
                break;
            case PROFESSOR:
                buildStage(new Stage(), "Profesor");
                //buildCoordinatorHomeScene(userName);
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

    private void buildPractitionerHomeScene(String userName) {
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_PractitionerHome.fxml"));
            viewFile = loader.load();
            ControllerPractitionerHome controllerPractitionerHome = loader.getController();
            controllerPractitionerHome.setTopMenuText(userName);
            window.setScene(new Scene(viewFile, 600, 400));
            window.setResizable(false);
        } catch (IOException ioException) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, ioException.getMessage(), ioException);
        }
    }
}

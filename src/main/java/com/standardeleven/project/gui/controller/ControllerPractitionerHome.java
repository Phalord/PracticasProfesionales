package com.standardeleven.project.gui.controller;

import com.standardeleven.project.gui.GUI_Home;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPractitionerHome {
    @FXML private Menu topMenu;
    @FXML private BorderPane borderPane;

    public final void setTopMenuText(String username) {
        topMenu.setText(username);
    }

    @FXML
    public final void goProjectSection() {
        notYetSupportedDialog();
    }

    @FXML
    public final void generateDocumentation() {
        setGenerateDocumentationScene();
    }

    @FXML
    public final void uploadDocumentation() {
        notYetSupportedDialog();
    }

    @FXML
    public final void logOut() {
        closeWindow();
        displayLogin();
    }

    private void setGenerateDocumentationScene() {
        Stage window = (Stage) borderPane.getScene().getWindow();
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/View_GenerateDocumentation.fxml"));
            viewFile = loader.load();
            ControllerGenerateDocumentation controllerGenerateDocumentation = loader.getController();
            controllerGenerateDocumentation.setTopMenuText(topMenu.getText());
            window.setScene(new Scene(viewFile, 600, 400));
        } catch (IOException ioException) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, ioException.getMessage(), ioException);
        }
    }

    private void notYetSupportedDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Funcionamiento sin implementar");
        alert.setContentText("Lamentamos las molestias que esto pueda ocasionarle. Seguimos en desarrollo.");

        alert.showAndWait();
    }

    private void somethingWentWrong() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Algo ha salido mal");
        alert.setContentText("Lamentamos las molestias que esto pueda ocasionarle. Seguimos en desarrollo.");

        alert.showAndWait();
    }

    private void closeWindow() {
        Stage stage1 = (Stage) borderPane.getScene().getWindow();
        stage1.close();
    }

    private void displayLogin() {
        try {
            new ControllerLogIn().display();
        } catch (IOException ioException) {
            somethingWentWrong();
        }
    }
}
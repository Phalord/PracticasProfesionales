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

public class ControllerGenerateDocumentation {
    @FXML private Menu topMenu;
    @FXML private BorderPane borderPane;

    public void setTopMenuText(String username) {
        topMenu.setText(username);
    }

    @FXML
    public void generatePartialReport() {
        notYetSupportedDialog();
    }

    @FXML
    public void generateMonthlyReport() {
        notYetSupportedDialog();
    }

    @FXML
    public void generateSelfAppraisal() {
        notYetSupportedDialog();
    }

    @FXML
    public void back() {
        backScene();
    }

    private void notYetSupportedDialog() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Funcionamiento sin implementar");
        alert.setContentText("Lamentamos las molestias que esto pueda ocasionarle. Seguimos en desarrollo.");

        alert.showAndWait();
    }

    private void backScene() {
        Stage window = (Stage) borderPane.getScene().getWindow();
        Parent viewFile;
        try {
            FXMLLoader loader = new FXMLLoader(getClass()
                    .getResource("/view/View_PractitionerHome.fxml"));
            viewFile = loader.load();
            ControllerPractitionerHome controllerPractitionerHome = loader.getController();
            controllerPractitionerHome.setTopMenuText(topMenu.getText());
            window.setScene(new Scene(viewFile, 600, 400));
        } catch (IOException ioException) {
            Logger.getLogger(GUI_Home.class.getName()).log(Level.SEVERE, ioException.getMessage(), ioException);
        }
    }
}

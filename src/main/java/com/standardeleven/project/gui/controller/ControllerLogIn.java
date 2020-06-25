package com.standardeleven.project.gui.controller;

import com.standardeleven.project.dataaccess.dao.UserDAO;
import com.standardeleven.project.dataaccess.idao.IUserDAO;
import com.standardeleven.project.gui.GUI_Home;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

public class ControllerLogIn {
    private final Stage window = new Stage();
    @FXML private TextField fieldUsername;
    @FXML private PasswordField fieldPassword;
    @FXML private Label logInMessage;

    public void display() throws IOException {
        Parent viewFile = FXMLLoader.load(getClass().getResource("/view/View_LogIn.fxml"));
        window.setScene(new Scene(viewFile, 300, 600));
        window.setResizable(false);
        window.show();
    }

    @FXML
    private void logIn() {
        IUserDAO iUserDAO = new UserDAO();
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        if (iUserDAO.getUserByEnrollment(username) != null) {
            if (BCrypt.checkpw(password, iUserDAO.getUserByEnrollment(username).getUserPassword())) {
                logInMessage.setTextFill(Color.rgb(39, 210, 30));
                GUI_Home gui_home = new GUI_Home(iUserDAO.getUserByEnrollment(username).getUserType());
                gui_home.display();
                closeWindow();
            } else {
                incorrectCredentials();
            }
        } else {
            incorrectCredentials();
        }
    }

    private void incorrectCredentials() {
        logInMessage.setTextFill(Color.rgb(210, 39, 30));
        logInMessage.setText("Usuario o contraseña incorrectas. Por favor intente nuevamente.");
    }

    private void closeWindow() {
        Stage stage1 = (Stage) fieldPassword.getScene().getWindow();
        stage1.close();
    }
}

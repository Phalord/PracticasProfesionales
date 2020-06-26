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

import static com.npcstudio.utils.TextValidator.*;

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
    public void logIn() {
        IUserDAO iUserDAO = new UserDAO();
        String userName = fieldUsername.getText();
        String password = fieldPassword.getText();
        if (validateUserName(userName)) {
            if (iUserDAO.getUserByUserName(userName) != null) {
                if (BCrypt.checkpw(password, iUserDAO.getUserByUserName(userName).getUserPassword())) {
                    logInMessage.setTextFill(Color.rgb(39, 210, 30));
                    GUI_Home gui_home = new GUI_Home(iUserDAO.getUserTypeByUserName(userName), userName);
                    gui_home.display();
                    closeWindow();
                } else {
                    incorrectCredentials();
                }
            } else {
                incorrectCredentials();
            }
        } else {
            incorrectUserName();
        }
    }

    private void incorrectCredentials() {
        logInMessage.setTextFill(Color.rgb(210, 39, 30));
        logInMessage.setText("Usuario o contraseña incorrectas. Por favor intente nuevamente.");
    }

    private void incorrectUserName() {
        logInMessage.setTextFill(Color.rgb(210, 39, 30));
        logInMessage.setText("Formato de nombre de usuario incorrecto. Intente nuevamente.");
    }

    private void closeWindow() {
        Stage stage1 = (Stage) fieldPassword.getScene().getWindow();
        stage1.close();
    }

    private boolean validateUserName(String userName) {
        return (validatePractitionerEnrollment(userName) ||
                validateCoordinatorEmployeeNumber(userName) ||
                validateProfessorEmployeeNumber(userName));
    }
}

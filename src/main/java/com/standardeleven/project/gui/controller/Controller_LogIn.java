package com.standardeleven.project.gui.controller;

import com.standardeleven.project.dataaccess.dao.AccountDAO;
import com.standardeleven.project.dataaccess.idao.IAccountDAO;
import com.standardeleven.project.gui.GUI_Home;
import com.standardeleven.project.gui.IWindowGUI;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_LogIn {
    private final Stage window = new Stage();
    @FXML private TextField fieldUsername;
    @FXML private PasswordField fieldPassword;
    @FXML private Label logInMessage;

    public void display() throws IOException {
        Parent viewFile = FXMLLoader.load(getClass().getResource("/view/View_LogIn.fxml"));
        window.setScene(new Scene(viewFile, 300, 600));
        window.show();
    }

    public void logIn() {
        String username = fieldUsername.getText();
        String password = fieldPassword.getText();
        IAccountDAO iAccountDAO = new AccountDAO();
        if (iAccountDAO.logIn(username, password)){
            GUI_Home gui_home = new GUI_Home(iAccountDAO.getAccountType(username));
            window.close();
            gui_home.display();
        } else {
            incorrectCredentials();
        }
    }

    public void incorrectCredentials() {
        logInMessage.setTextFill(Color.rgb(210, 39, 30));
        logInMessage.setText("Usuario o contraseña incorrectas. Por favor intente nuevamente.");
    }
}

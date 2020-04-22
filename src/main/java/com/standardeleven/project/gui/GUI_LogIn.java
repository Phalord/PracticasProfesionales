package com.standardeleven.project.gui;


import com.standardeleven.project.dataaccess.dao.AccountDAO;
import com.standardeleven.project.dataaccess.idao.IAccountDAO;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI_LogIn {
    Stage window = new Stage();
    private BorderPane sceneLayout;
    private Button buttonLogIn;
    private Text textLogIn;
    private TextField fieldUsername;
    private PasswordField fieldPassword;
    private Label logInMessage;

    public void display() {
        window.setTitle("Prácticas Profesionales");
        buildLogInScreen();
        Scene logInScene = new Scene(sceneLayout, 300, 600);
        window.setScene(logInScene);
        window.setResizable(false);
        window.show();
    }

    public void buildLogInScreen() {
        VBox centerLayout = new VBox();
        textLogIn = new Text("INICIA SESIÓN");
        textLogIn.setFont(Font.font("Product Sans", 20));
        fieldUsername = new TextField("Usuario");
        fieldPassword = new PasswordField();
        buttonLogIn = new Button("Iniciar Sesión");
        buttonLogIn.setFont(Font.font("Product Sans"));
        buttonLogIn.setOnAction(e -> {
            String username = fieldUsername.getText();
            String password = fieldPassword.getText();
            IAccountDAO iAccountDAO = new AccountDAO();
            if (iAccountDAO.logIn(username, password)){
                GUI_Home gui_home = new GUI_Home(iAccountDAO.getAccountType(username));
                window.close();
                gui_home.display();
                correctCredentials(iAccountDAO.getAccountType(username));
            } else {
                incorrectCredentials();
            }
        });
        logInMessage = new Label("");
        centerLayout.getChildren().addAll(textLogIn, fieldUsername, fieldPassword, logInMessage, buttonLogIn);
        centerLayout.setPadding(new Insets(30));
        centerLayout.setSpacing(15);
        centerLayout.setAlignment(Pos.CENTER);
        sceneLayout = new BorderPane();
        sceneLayout.setCenter(centerLayout);
    }

    public void incorrectCredentials() {
        logInMessage.setTextFill(Color.rgb(210, 39, 30));
        logInMessage.setText("Usuario o contraseña incorrectas. Por favor intente nuevamente.");
    }

    public void correctCredentials(String accountType) {
        logInMessage.setTextFill(Color.rgb(39, 210, 30));
        logInMessage.setText(String.format("Inició correctamente como: %s", accountType));
    }
}

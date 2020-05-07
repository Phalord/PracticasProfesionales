package com.standardeleven.project.main;

import com.standardeleven.project.gui.controller.Controller_LogIn;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new Controller_LogIn().display();
    }
}

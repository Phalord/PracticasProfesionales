package com.standardeleven.project.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUI_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new GUI_LogIn().display();

    }
}

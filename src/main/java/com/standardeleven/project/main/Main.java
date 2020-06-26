package com.standardeleven.project.main;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static final String PRACTITIONER = "practicante";
    public static final String PROFESSOR = "professor";
    public static final String COORDINATOR = "coordinator";
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/View_PractitionerSection.fxml"));
            Pane window = (Pane) loader.load();
            Scene scene = new Scene(window);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}


/*
package com.standardeleven.project.main;

import com.standardeleven.project.gui.controller.ControllerLogIn;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new ControllerLogIn().display();

    }
}
*/
package org.proyect.hibernatejavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(PrincipalApplication.class.getResource("videogames-view.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        var scene = new Scene(new Pane(), 1024, 900);
        ViewSwitcher.setScene(scene);
        ViewSwitcher.switchTo(View.MENU);


        stage.setTitle("Gamers Application");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        //HIBERNATE
        //1.LOAD VIDEOGAMES



        //JAVAFX
        launch();

    }
}

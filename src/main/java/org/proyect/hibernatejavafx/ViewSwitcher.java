package org.proyect.hibernatejavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitcher {
    //SCENE WE WANT TO SWITCH
    private static Scene scene;

    /**
     * This method set the Scene we want to switch.
     * @param scene Scene.
     */
    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view) {
        if(scene == null){
            System.out.println("No scene was set!");
            return;
        }

        try {
            Parent root = FXMLLoader.load(
                    ViewSwitcher.class.getResource(view.getFileName())
            );

            scene.setRoot(root);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}

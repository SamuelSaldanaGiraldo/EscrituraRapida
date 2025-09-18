package com.example.miniproyecto1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Main entry point of the Fast Writing game application.
 * <p>
 * This class initializes the JavaFX application, loads the initial FXML
 * (menu screen), and sets up the primary stage.
 */
public class Main extends Application {
    /**
     * Starts the JavaFX application by loading the menu screen.
     * @param stage the primary stage for this application.
     * @throws Exception if an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws Exception{
// Load the menu screen from its FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/menu.fxml"));
        Parent root = loader.load();

        // Create a new scene with the loaded FXML content.
        Scene scene = new Scene(root);

        // Set up the primary stage.
        stage.setScene(scene);
        stage.setTitle("Escritura Rapida");
        stage.show(); // Display the stage.
    }

    /**
     * Main method of the application.
     * <p>
     * This is the actual entry point of the program when running from the JVM.
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }


}

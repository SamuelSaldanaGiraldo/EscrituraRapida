package com.example.miniproyecto1.controller;


import com.example.miniproyecto1.model.juego.Game;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main game screen.
 * This class initializes and controls the game logic,
 * handles user interactions (typing words, pressing Enter),
 * updates UI components such as labels and progress bar,
 * and provides navigation back to the menu or to the final screen.
 */
public class GameController {
    @FXML
    private Button btnBack;
    @FXML
    private Label lbTimer;
    @FXML
    private Label lbWord;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField tfWord;
    @FXML
    private Label lbLevel;
    @FXML
    private Label lbMessage;

    private Game fastWriting;

    /**
     * Initializes the controller after the FXML file is loaded.
     * This method creates a new {@link Game} instance,
     * sets the controller reference inside the game,
     * starts the game logic,
     * and configures the Enter key to validate typed words.
     */
    @FXML
    public void initialize(){
        // Create and configure the Game instance with the UI components.
        fastWriting = new Game(lbTimer, lbWord, lbLevel, tfWord, progressBar, lbMessage);
        fastWriting.setController(this);
        fastWriting.start();
        // Add event handler: when Enter is pressed, validate the typed word.
        tfWord.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case ENTER:
                    fastWriting.getWord().validateWord(fastWriting);
                    break;
            }
        });
    }
    /**
     * Handles the event when the "Back" button is clicked.
     * This method stops the game timer (if active) and loads the menu scene.
     * @throws IOException if an error occurs while loading the menu FXML file.
     */

    @FXML
    private void onBackClicked() throws IOException {
        // Stop the timer to prevent it from running in the background.
        if (fastWriting != null && fastWriting.getTimer() != null) {
            fastWriting.getTimer().destroy();
        }
        // Load the menu scene.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/menu.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Displays the final screen when the game ends.
     * This method stops the timer, loads the final scene from FXML,
     * passes the game instance to the FinalController,
     * and updates the stage with the final scene.
     *
     * @param stage the current stage where the final scene will be shown.
     * @throws IOException if an error occurs while loading the final FXML file.
     */
    public void showFinal(Stage stage) throws IOException{
        // Stop the timer if it is running.
        if (fastWriting.getTimer() != null) {
            fastWriting.getTimer().destroy();
        }
        try {
            // Load the final screen from FXML.
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/final.fxml"));
            Parent root = loader.load();

            // Get the FinalController and pass the current game data.
            FinalController controller = loader.getController();
            controller.ShowFinalStage(fastWriting);

            // Update the stage with the final scene.
            Platform.runLater(() -> stage.show());
            stage.setScene(new Scene(root));
            System.out.println("Escena puesta");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

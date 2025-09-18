package com.example.miniproyecto1.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Controller for the rules screen.
 * This class manages the screen that displays the game rules.
 * When the player clicks the "Start" button, it loads the game screen.
 */
public class RulesController {
    @FXML
    private Button btnStart;
    /**
     * Handles the event when the "Start" button is clicked.
     * This method loads the "game.fxml" screen and displays it in the current stage.
     * @throws IOException if an error occurs while loading the game FXML file.
     */
    @FXML
    private void onStartClicked() throws IOException {
        // Load the game screen from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/game.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the game scene.
        Stage stage = (Stage) btnStart.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

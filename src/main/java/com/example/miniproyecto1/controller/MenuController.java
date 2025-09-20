package com.example.miniproyecto1.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main menu screen of the application.
 * <p>
 * This class manages the main menu view where the player can start the game,
 * view the help/rules, or exit the application.
 * It handles button events and loads the corresponding screens.
 */
public class MenuController {
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnEnd;
    @FXML
    private Button btnHelp;

    /**
     * Handles the "Play" button click event.
     * <p>
     * Loads the {@code game.fxml} layout and displays the game screen
     * in the current stage.
     * @throws IOException if the game FXML file cannot be loaded.
     */
    @FXML
    private void onPlayClicked() throws IOException{
        // Load the game screen from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/game.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the game scene.
        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Handles the "Exit" button click event.
     * <p>
     * Closes the current application window (stage).
     */
    @FXML
    private void onEndClicked(){
        Stage stage = (Stage) btnEnd.getScene().getWindow();
        stage.close();
    }
    /**
     * Handles the "Help" button click event.
     * <p>
     * Loads the {@code rules.fxml} layout and displays the rules/help screen
     * in the current stage.
     * @throws IOException if the rules FXML file cannot be loaded.
     */
    @FXML
    private void onHelpClicked() throws IOException{
        // Load the rules screen from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/rules.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the rules scene.
        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
}

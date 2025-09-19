package com.example.miniproyecto1.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the main menu screen.
 * This class handles the menu view where the player can start the game.
 * When the "Play" button is clicked, it loads the rules screen.
 */
public class MenuController {
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnEnd;

    /**
     * Handles the event when the "Play" button is clicked.
     * This method loads the "rules.fxml" screen and displays it in the current stage.
     * @throws IOException if an error occurs while loading the rules FXML file.
     */
    @FXML
    private void onPlayClicked() throws IOException{
        // Load the rules screen from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/rules.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the rules scene.
        Stage stage = (Stage) btnPlay.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    private void onEndClicked(){
        Stage stage = (Stage) btnEnd.getScene().getWindow();
        stage.close();
    }
}

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
 * When the player clicks the "Back" button, it loads the menu screen.
 */
public class RulesController {
    @FXML
    private Button btnBack;
    /**
     * Handles the event when the "Back" button is clicked.
     * This method loads the "menu.fxml" screen and displays it in the current stage.
     * @throws IOException if an error occurs while loading the menu FXML file.
     */
    @FXML
    private void onBackClicked() throws IOException {
        // Load the menu screen from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/menu.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the menu scene.
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

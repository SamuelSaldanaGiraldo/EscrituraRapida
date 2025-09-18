package com.example.miniproyecto1.controller;

import com.example.miniproyecto1.model.juego.Game;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller for the final game screen.
 * This class manages the final view where the game results are displayed
 * (levels completed, failures, victory or defeat messages)
 * and allows the player to restart the game by clicking a button.
 */
public class FinalController {
    @FXML
    private Button btnStartAgain;
    @FXML
    private Label lbWinOrLose;
    @FXML
    private Label lbLevelsCompleteNumber;
    @FXML
    private Label lbFailuresNumber;
    @FXML
    private Label lbTimeOver;
    @FXML
    private ImageView imgLoseRight;
    @FXML
    private ImageView imgLoseLeft;

    private Game game;
    /**
     * Sets the game data on the final screen.
     * This method updates the labels and images according to the game result.
     * @param game the Game object containing the current game information.
     */
    @FXML
    public void ShowFinalStage(Game game) {
        this.game = game;

        // Update labels with game data
        lbLevelsCompleteNumber.setText("Niveles completados: " + game.getLevel().getLevelValue());
        lbFailuresNumber.setText("Fallas: " + game.getLevel().getFailedLevels());

        // If the player completed all levels:
        if (game.getLevel().getLevelValue()>50){ //se muestra si el jugador completa todos los niveles
            lbWinOrLose.setText("GANASTE");
            imgLoseRight.setVisible(false);
            imgLoseLeft.setVisible(false);
        }
        // If the time ran out and the player didn't finish:
        else{
            lbTimeOver.setText("¡SE ACABÓ EL TIEMPO!");
            lbWinOrLose.setText("PERDISTE");
            imgLoseRight.setVisible(true);
            imgLoseLeft.setVisible(true);
        }

    }
    /**
     * Handles the event when the "Start Again" button is clicked.
     * Loads the main game scene (game.fxml) and restarts the game.
     * @throws IOException if an error occurs while loading the FXML file.
     */
    @FXML
    private void onStartAgainClicked() throws IOException {
        // Load the game scene from the FXML file.
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/miniproyecto1/fxml/game.fxml"));
        Parent root = loader.load();

        // Get the current stage and set the new game scene.
        Stage stage = (Stage) btnStartAgain.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}

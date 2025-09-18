package com.example.miniproyecto1.model.juego;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * Represents a countdown timer used during the game.
 * This class controls the time limit for each round of the game.
 * It updates the UI labels and progress bar as time decreases.
 */
public class Timer {
    private int seconds = 20;
    private int InitialTime;
    private Timeline timeline;

    /**
     * Starts the countdown timer for the given game.
     * @param game the current {@link Game} instance whose UI components are updated.
     */
    public void start(Game game) {
        this.InitialTime = seconds;

        // Creates a timeline that executes every second.
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    seconds--;

                    // Update timer label.
                    game.getLbTimer().setText(seconds + " s");

                    // Update progress bar (from 0 to 1).
                    double progress = 1 - (double) seconds / InitialTime;
                    game.getProgressBar().setProgress(progress);

                    // When time runs out:
                    if (seconds <= 0) {
                        timeline.stop();
                        game.getProgressBar().setProgress(1);

                        // Forces validation of the current word when time ends.
                        game.getWord().validateWord(game);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Restarts the timer with a new time based on the current game level.
     * @param baseTime the base time to start from.
     * @param game the current {@link Game} instance.
     */
    public void restart(int baseTime, Game game) {
        // Stop the current timeline if running.
        if (timeline != null) {
            timeline.stop();
        }

        // Decrease time based on the current level (harder levels = less time).
        int actualLevel = game.getLevel().getLevelValue();
        int reduction = ((actualLevel) / 5) * 2;
        int newTime = baseTime - reduction;

        // Minimum time allowed is 2 seconds.
        if (newTime < 2) {
            newTime = 2;
        }

        this.seconds = newTime;
        this.InitialTime = newTime;

        // Reset UI.
        game.getLbTimer().setText(seconds + " s");
        game.getProgressBar().setProgress(0);

        // Start again with updated time.
        start(game);
    }

    /**
     * @return the remaining seconds of the timer.
     */
    public int getSeconds() {
        return seconds;
    }
    /**
     * Stops and destroys the timer, releasing resources.
     */
    public void destroy() {
        if (timeline != null) {
            timeline.stop();
            timeline = null;
        }
    }
}

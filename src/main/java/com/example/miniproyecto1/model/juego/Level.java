package com.example.miniproyecto1.model.juego;

import javafx.scene.control.Label;

/**
 * Represents the level system of the game.
 * This class tracks the current level and the number of failed levels.
 * It also updates the UI label whenever the level changes.
 */
public class Level {
    private int level = 1;
    private int failedLevels = 0;

    /**
     * Sets the label to display the starting level.
     * @param levelLabel the label where the level will be displayed.
     */
    public void setFirstLevel(Label levelLabel) {
        levelLabel.setText("Level " + level);
    }

    /**
     * Advances to the next level and updates the label.
     * @param levelLabel the label where the updated level will be displayed.
     */
    public void advanceLevel(Label levelLabel) {
        level++;
        levelLabel.setText("Level " + level);
    }

    /**
     * Registers a failed level (increments the counter).
     */
    public void registerFailure() {
        failedLevels++;
    }

    /**
     * @return the current level value.
     */
    public int getLevelValue() {return level;}

    /**
     * @return the number of failed levels.
     */
    public int getFailedLevels() {return failedLevels;}
}

package com.example.miniproyecto1.model.juego;
/**
 * Represents the contract for a game.
 * <p>
 * Any class implementing this interface must define how a game
 * starts and how it ends. This allows different types of games
 * to share the same basic structure while implementing their own
 * specific behavior.
 */
public interface IGame {
    /**
     * Starts the game.
     * <p>
     * This method should initialize and prepare all the necessary
     * components for the game to run (e.g., timers, levels, UI updates).
     */
    void start();
    /**
     * Ends the game.
     * <p>
     * This method stops and cleans up the timer or any other running processes.
     */
    void end();
}

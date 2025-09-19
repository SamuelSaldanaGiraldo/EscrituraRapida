package com.example.miniproyecto1.model.juego;

import com.example.miniproyecto1.controller.GameController;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;


/**
 * Represents the core logic of the game.
 * <p>
 * This class manages the game's state and connects the user interface components
 * (labels, text field, and progress bar) with the underlying game logic
 * (timer, word, and level).
 * <p>
 * It serves as the "Model" in the MVC pattern, while {@link GameController}
 * acts as the Controller.
 */
public class Game implements IGame{
    private Label lbTimer;
    private Label lbWord;
    private Label lbLevel;
    private Label lbMessage;
    private TextField tfWord;
    private ProgressBar progressBar;
    private GameController controller;
    private Word word;
    private Timer timer;
    private Level level;
    /**
     * Creates a new {@code Game} instance and initializes the UI components.
     * @param lbTimer     Label used to display the timer.
     * @param lbWord      Label used to display the current word.
     * @param lbLevel     Label used to display the current level.
     * @param tfWord      Text field where the user inputs words.
     * @param progressBar Progress bar used to visualize time or progress.
     * @param lbMessage   Label used to display messages or feedback to the player.
     */
    public Game(Label lbTimer, Label lbWord, Label lbLevel, TextField tfWord, ProgressBar progressBar, Label lbMessage) {
        this.lbTimer = lbTimer;
        this.lbWord = lbWord;
        this.lbLevel = lbLevel;
        this.lbMessage = lbMessage;
        this.tfWord = tfWord;
        this.progressBar = progressBar;

    }

    /**
     * Starts the game by initializing the timer, level, and word components.
     * <p>
     * This method also assigns the first word and level to the corresponding UI elements.
     */
    @Override
    public void start() {
        timer = new Timer();
        level = new Level();
        word = new Word();

        timer.start(this);
        word.assignWord(lbWord);
        level.setFirstLevel(lbLevel);
    }
    /**
     * Ends the game.
     * <p>
     * This method stops and cleans up the timer or any other running processes.
     */
    @Override
    public void end() {
        timer.destroy();
    }

    /**
     * Sets the controller that manages the UI and user interactions.
     * @param controller the {@link GameController} instance controlling this game.
     */
    public void setController(GameController controller) {
        this.controller = controller;
    }

    /** @return the timer label. */
    public Label getLbTimer() { return lbTimer; }

    /** @return the word label. */
    public Label getLbWord() { return lbWord; }

    /** @return the level label. */
    public Label getLbLevel() { return lbLevel; }

    /** @return the message label. */
    public Label getLbMessage() { return lbMessage; }

    /** @return the text field for user input. */
    public TextField getTfWord() { return tfWord; }

    /** @return the progress bar. */
    public ProgressBar getProgressBar() { return progressBar; }

    /** @return the Word instance. */
    public Word getWord() { return word; }

    /** @return the Timer instance. */
    public Timer getTimer() { return timer; }

    /** @return the Level instance. */
    public Level getLevel() { return level; }

    /** @return the controller of this game. */
    public GameController getController() { return controller; }
}

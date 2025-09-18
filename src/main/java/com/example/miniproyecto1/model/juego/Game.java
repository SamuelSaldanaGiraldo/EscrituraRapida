package com.example.miniproyecto1.model.juego;

import com.example.miniproyecto1.controller.GameController;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

/**
 * Represents the core logic of the game.
 * This class manages the game’s state and ties together the user interface (labels, text field, progress bar)
 * with the game logic (Timer, Word, Level).
 * It acts as the "model" in an MVC pattern, while {@link GameController} acts as the controller.
 */
public class Game {
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
     * Creates a new Game instance and initializes the UI components.
     * @param lbTimer Label for displaying the timer.
     * @param lbWord Label for displaying the current word.
     * @param lbLevel Label for displaying the current level.
     * @param tfWord Text field for user input.
     * @param progressBar Progress bar for displaying progress/time.
     * @param lbMessage Label for displaying messages.
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
     * Starts the game.
     * Initializes the timer, level, and word objects,
     * then assigns the first word and level to the UI.
     */
    public void Start() {
        timer = new Timer();
        level = new Level();
        word = new Word();

        timer.start(this);
        word.assignWord(lbWord);
        level.setFirstLevel(lbLevel);
    }

    /**
     * Sets the game controller that manages the UI.
     * @param controller the {@link GameController} instance.
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

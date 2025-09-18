package com.example.miniproyecto1.model.juego;

import javafx.animation.PauseTransition;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

/**
 * Handles random word generation and validation in the game.
 * <p>
 * This class contains a set of word categories and provides functionality to:
 * <ul>
 *     <li>Generate a random word from any category.</li>
 *     <li>Assign the generated word to a label in the UI.</li>
 *     <li>Validate if the word entered by the player is correct or incorrect.</li>
 * </ul>
 */
public class Word {
    /**
     * Map containing word categories and their associated lists.
     * The key is the category name, and the value is an array of words.
     */
    private static final Map<String, String[]> CATEGORY = new HashMap<>();
    /** Random number generator to select category and word. */
    private static final Random random = new Random();

    // Static block to initialize all word categories
    static {
        CATEGORY.put("DEPORTE", new String[]{
                "futbol", "baloncesto", "tenis", "natacion", "ciclismo",
                "voleibol", "rugby", "boxeo", "golf", "surf",
                "patinaje", "hockey", "béisbol", "esgrima", "atletismo"
        });

        CATEGORY.put("ANIMAL", new String[]{
                "gato", "perro", "elefante", "tigre", "leon",
                "jirafa", "oso", "lobo", "zorro", "pingüino",
                "cocodrilo", "delfin", "caballo", "aguila", "rana"
        });

        CATEGORY.put("OBJETO", new String[]{
                "mesa", "silla", "telefono", "reloj", "computador",
                "lámpara", "cuchara", "libro", "bolígrafo", "ventilador",
                "caja", "puerta", "mochila", "espejo", "botella"
        });

        CATEGORY.put("COMIDA", new String[]{
                "pizza", "hamburguesa", "pasta", "ensalada", "sopa",
                "taco", "sushi", "helado", "arroz", "empanada",
                "arepa", "pollo", "pan", "queso", "galleta"
        });

        CATEGORY.put("ACCION", new String[]{
                "correr", "saltar", "leer", "escribir", "jugar",
                "cantar", "bailar", "dibujar", "viajar", "estudiar",
                "cocinar", "nadar", "caminar", "pintar", "trabajar"
        });

        CATEGORY.put("TRANSPORTE", new String[]{
                "carro", "avion", "bicicleta", "tren", "barco",
                "moto", "camión", "submarino", "helicóptero", "patinete",
                "globo", "teleférico", "ferry", "cohete", "triciclo"
        });

        CATEGORY.put("COLOR", new String[]{
                "rojo", "azul", "verde", "amarillo", "morado",
                "naranja", "rosado", "gris", "blanco", "negro",
                "cian", "marrón", "violeta", "turquesa", "dorado"
        });

        CATEGORY.put("INSTRUMENTO", new String[]{
                "guitarra", "piano", "violin", "bateria", "flauta",
                "trompeta", "saxofon", "clarinete", "arpa", "tambor",
                "bajo", "ukelele", "harmonica", "xilofono", "trombón"
        });

        CATEGORY.put("PROFESION", new String[]{
                "doctor", "ingeniero", "profesor", "bombero", "policía",
                "arquitecto", "abogado", "enfermero", "piloto", "chef",
                "diseñador", "científico", "carpintero", "electricista", "veterinario"
        });
    }

    /**
     * Generates a random word by first picking a random category
     * and then a random word from that category.
     *
     * @return A random word from any category.
     */
    public static String generateAleatoryWord() {

        List<String> category = new ArrayList<>(CATEGORY.keySet());
        String categoryString = category.get(random.nextInt(category.size()));


        String[] words = CATEGORY.get(categoryString);
        return words[random.nextInt(words.length)];
    }

    /**
     * Assigns a random word to the given label in the UI.
     * @param label Label where the word will be displayed.
     */
    public void assignWord(Label label){
        String words = generateAleatoryWord();
        label.setText(words);
    }

    /**
     * Validates the word entered by the player:
     * <ul>
     *     <li>If correct: shows "CORRECT", restarts the timer,
     *     generates a new word, clears the text field, and increases the level.</li>
     *     <li>If incorrect:
     *         <ul>
     *             <li>If time is up: registers failure and shows the final screen.</li>
     *             <li>If time remains: shows "INCORRECT", restarts timer,
     *             generates a new word, and registers failure.</li>
     *         </ul>
     *     </li>
     * </ul>
     *
     * @param game The game object that holds the current state (level, timer, UI components).
     */
    public void validateWord(Game game) {
        if (game.getLbWord().getText().equals(game.getTfWord().getText())) {
            // CORRECT case
            game.getLbMessage().setText("CORRECTO");
            PauseTransition pause = new PauseTransition(Duration.seconds(0.5));
            pause.setOnFinished(event -> {
                game.getTimer().restart(20, game);
                game.getLbMessage().setText("ESPERANDO AL JUGADOR...");
                assignWord(game.getLbWord());
                game.getTfWord().clear();
                game.getLevel().advanceLevel(game.getLbLevel());
                // If the player exceeds level 50, show the final screen
                if (game.getLevel().getLevelValue() > 50) {
                    try {
                        Stage stage = (Stage) game.getLbWord().getScene().getWindow();
                        game.getController().showFinal(stage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            pause.play();
        } else {
            // INCORRECT case
            if (game.getTimer().getSeconds() == 0) {
                // Time is up: register failure and show final screen
                game.getLevel().registerFailure();
                try {
                    Stage stage = (Stage) game.getLbWord().getScene().getWindow();
                    game.getController().showFinal(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Time still active: show "INCORRECT", restart and register failure
                game.getLbMessage().setText("INCORRECTO");
                PauseTransition pause2 = new PauseTransition(Duration.seconds(0.5));
                pause2.setOnFinished(event -> {
                    game.getTimer().restart(20, game);
                    game.getLbMessage().setText("ESPERANDO AL JUGADOR...");
                    assignWord(game.getLbWord());
                    game.getTfWord().clear();
                    game.getLevel().registerFailure();
                });
                pause2.play();
            }
        }
    }
}


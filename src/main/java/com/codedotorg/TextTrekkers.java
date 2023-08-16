package com.codedotorg;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextTrekkers {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The text box that displays the results */
    private TextArea gameplay;

    /** Whether or not the player has the key */
    private boolean hasKey;

    /** Whether or not the door is locked */
    private boolean doorLocked;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructor for the TextTrekkers class.
     * 
     * @param window the Stage object representing the game window
     * @param width the width of the game window
     * @param height the height of the game window
     */
    public TextTrekkers(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        gameplay = new TextArea();
        gameplay.setWrapText(true);

        hasKey = false;
        doorLocked = false;

        inputField = createInputField();
    }
    
    /**
     * This method sets the title of the window to "TextTrekkers", creates the main scene, adds
     * the stylesheet to the main scene, sets the main scene to the window, and shows the window.
     */
    public void startApp() {
        window.setTitle("TextTrekkers");
        
        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the TextTrekkers game.
     * 
     * @return the main scene for the game
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("TextTrekkers");
        titleLabel.setId("titleLabel");

        HBox inputLayout = createInputLayout();

        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(titleLabel, gameplay, inputLayout);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Creates an HBox layout that contains a Label and an input field for the user to enter a command.
     * 
     * @return the HBox layout containing the Label and input field
     */
    public HBox createInputLayout() {
        Label inputLabel = new Label("Enter your command:");
        inputLabel.setPadding(new Insets(0, 5, 0, 0));

        HBox tempLayout = new HBox();
        tempLayout.getChildren().addAll(inputLabel, inputField);
        tempLayout.setAlignment(Pos.CENTER);
        
        return tempLayout;
    }

    /**
     * Processes the user's command in a text-based adventure game.
     * The command is converted to lowercase to ensure case-insensitive comparison.
     * 
     * The following commands are supported:
     * - "go north": The user attempts to go north, and the method returns a
     *               description of what they see.
     * - "pick up key": The user attempts to pick up a key. If successful, the method
     *                  updates the hasKey variable and returns a success message.
     * - "use key": The user attempts to use a key they have picked up. If the user has
     *              a key, the method unlocks the door and returns a success message. If
     *              the user doesn't have a key, the method returns a failure message.
     * - "open door": The user attempts to open a door. If the door is unlocked, the method
     *                returns a success message indicating the user has won. If the door is
     *                locked, the method returns a failure message.
     * 
     * If the command is not recognized, the method returns a message indicating the command
     * was not understood.
     * 
     * @param input The user's command.
     * @return A string describing the result of the user's command.
     */
    public String processCommand(String input) {
        
        return "";
    }

    /**
     * Creates a new TextField for user input and sets an action event to handle the input.
     * The action event updates the user response and game response, and clears the TextField.
     * 
     * @return the created TextField
     */
    public TextField createInputField() {
        TextField tempField = new TextField();

        tempField.setOnAction(event -> {
            String userInput = tempField.getText();
            
            updateUserResponse(userInput);
            updateGameResponse(userInput);
            
            tempField.clear();
        });

        return tempField;
    }

    /**
     * Updates the user response in the gameplay text area.
     * 
     * @param userInput the user's input to be displayed in the gameplay text area
     */
    public void updateUserResponse(String userInput) {
        gameplay.appendText("You: " + userInput + "\n");
    }

    /**
     * Updates the game response based on the user input.
     * Calls the processCommand method to process the user input and generate a response.
     * Appends the response to the gameplay text area.
     *
     * @param userInput the user input to be processed
     */
    public void updateGameResponse(String userInput) {
        String response = processCommand(userInput);
        gameplay.appendText("Game: " + response + "\n");
    }

}

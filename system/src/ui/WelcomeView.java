package ui;

import Game.Game;
import Problems.ProblemManager;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utilisateur.User;
import utilisateur.UserManager;

import java.util.List;

public class WelcomeView {


    public Scene createWelcomeScene(Stage primaryStage) {
        // Create the dropdown (ComboBox) for selecting a user
        ComboBox<String> userSelect = new ComboBox<>();
        //User[] users = UserManager.getusersList() ;
        userSelect.getItems().addAll("User 1", "User 2", "User 3");  // Add user options
        userSelect.setPromptText("Select User");

        ComboBox<String> gameModeSelect = new ComboBox<>();
        gameModeSelect.getItems().addAll("Mode Input Output", "Mode Include");  // Add user options
        gameModeSelect.setPromptText("select Mode");

        // Create the Play button
        Button playButton = new Button("Play");

        playButton.setOnAction(event -> {
            if (userSelect.getValue() != null && gameModeSelect.getValue() != null) {
                Game currentGame = new Game(null , null , gameModeSelect.getValue() , new User(userSelect.getValue())) ;

                List<String> allTitles = ProblemManager.retrieveTitlesWithDifficulty();
                PremiereScene premierScene = new PremiereScene() ;
                Scene selectionScene = premierScene.createSelectionScene(primaryStage, allTitles , currentGame);
                primaryStage.setScene(selectionScene);
            } else {
                PremiereScene.showPopup("veiller choisir un utilisateur et le mode de jeux");
            }
        });

        // Create the GridPane
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10)); // Padding around the grid
        gridPane.setVgap(10); // Vertical spacing between components
        gridPane.setHgap(10); // Horizontal spacing between components

        Button newUser = new Button("Créer nouveau utilisateur") ;

        newUser.setOnAction(event -> {
            TextField textField = new TextField();

            // Set a prompt text
            textField.setPromptText("Renseigner Un nom d'utilisateur");
            gridPane.add(textField, 0 , 1);
            UserManager.fromUsernameCreateUser(new User(textField.getText()));

        } );



        // Adding the ComboBox to the grid
        gridPane.add(userSelect, 0, 0); // Column 0, Row 0

        // Adding the Play button to the grid
        gridPane.add(playButton, 1, 0); // Column 1, Row 0
        GridPane.setHalignment(playButton, HPos.CENTER);

        gridPane.add(gameModeSelect ,0,1);

        // Setting up the scene and the stage
        Scene scene = new Scene(gridPane, 300, 150); // width and height of the window
        return scene;
    }

}
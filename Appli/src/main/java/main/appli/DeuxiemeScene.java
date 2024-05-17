package main.appli;

import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


public class DeuxiemeScene {
    private ComboBox<String> languageComboBox;

    public Scene createDetailsScene(Stage primaryStage, String selectedExercise, String selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise + "\nLangage: " + selectedLanguage);

        // Initialisation de la liste déroulante avec les langages disponibles
        ObservableList<String> languages = FXCollections.observableArrayList("Python", "C", "Java", "PHP", "JavaScript");
        languageComboBox = new ComboBox<>(languages);

        // Sélectionner le langage par défaut
        languageComboBox.setValue(selectedLanguage);

        TextArea codeTextArea = new TextArea();
        // Écouteur pour détecter les changements de sélection de langue
        languageComboBox.setOnAction(event -> {
            // Initialiser la page avec le nouveau langage sélectionné
            initializePage(primaryStage, selectedExercise, languageComboBox.getValue(),codeTextArea);
        });



        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String output = codeInterpreter.executeCode(selectedLanguage, code);
            outputTextArea.setText(output);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, DatabaseManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        VBox root = new VBox(
                // Mettre la liste déroulante en haut

                new Label("Exercice: " + selectedExercise + "\nLangage: " + selectedLanguage),
                codeTextArea,
                executeButton,
                languageComboBox,
                new Label("Output:"),
                outputTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene scene = new Scene(root, 600, 700);
        return scene;
        }

        private void initializePage(Stage primaryStage, String selectedExercise, String selectedLanguage,TextArea codeTextArea) {
            // Réinitialiser la zone de texte du code
            codeTextArea.setText("");

            // Mettre à jour la scène avec le nouveau langage sélectionné
            Scene scene = createDetailsScene(primaryStage, selectedExercise, selectedLanguage);
            primaryStage.setScene(scene);
        }


    }


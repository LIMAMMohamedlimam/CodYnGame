package ui;

import Problems.ProblemManager;
import fonctionnalities.codeInterpreter;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeuxiemeScene {

    public Scene createDetailsScene(Stage primaryStage, String selectedTitle, String selectedLanguage, String description, String generatorOutput) {
        Label detailsLabel = new Label("Exercice: " + selectedTitle + "\nLangage: " + selectedLanguage + "\nDescription: " + description);

        // Initialisation de la liste déroulante avec les langages disponibles
        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("Python", "C", "Java", "PHP", "JavaScript");
        languageComboBox.setValue(selectedLanguage);

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        TextArea generatorOutputTextArea = new TextArea();
        generatorOutputTextArea.setEditable(false);
        generatorOutputTextArea.setText(generatorOutput); // Affichage des données générées

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String output = codeInterpreter.executeCode(selectedLanguage, code);
            outputTextArea.setText(output);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        // Ajouter un gestionnaire d'événements à la liste déroulante des langages pour réinitialiser la scène avec le nouveau langage
        languageComboBox.setOnAction(event -> {
            String newLanguage = languageComboBox.getValue();
            DeuxiemeScene newScene = new DeuxiemeScene();
            Scene updatedScene = newScene.createDetailsScene(primaryStage, selectedTitle, newLanguage, description, generatorOutput);
            primaryStage.setScene(updatedScene);
        });

        VBox root = new VBox(
                detailsLabel,
                languageComboBox,
                new Label("Données générées:"),
                generatorOutputTextArea,
                codeTextArea,
                executeButton,
                new Label("Output:"),
                outputTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }
}

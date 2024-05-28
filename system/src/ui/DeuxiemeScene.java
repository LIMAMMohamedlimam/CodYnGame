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

    public Scene createDetailsScene(Stage primaryStage, String selectedTitle, String selectedLanguage, String description, String generatorOutput, String solutionOutput) {
        Label detailsLabel = new Label("Exercise: " + selectedTitle + "\nLanguage: " + selectedLanguage + "\nDescription: " + description);

        // Initialize the dropdown list with available languages
        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("Python", "C", "Java", "PHP", "JavaScript");
        languageComboBox.setValue(selectedLanguage);

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Enter your code here");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Validate");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String output = codeInterpreter.executeCode(selectedLanguage, code).trim();

            // Compare the solution output with the expected result
            String comparisonResult;
            if (output.equals(solutionOutput.trim())) {
                comparisonResult = "True";
            } else {
                comparisonResult = "False";
            }

            // Display the result in the text area
            outputTextArea.setText("Expected result: " + solutionOutput.trim() + "\nObtained result: " + output + "\nComparison: " + comparisonResult);
        });

        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitlesWithDifficulty());
            primaryStage.setScene(scene);
        });

        // Add an event handler to the language dropdown to reset the scene with the new language
        languageComboBox.setOnAction(event -> {
            String newLanguage = languageComboBox.getValue();
            DeuxiemeScene newScene = new DeuxiemeScene();
            Scene updatedScene = newScene.createDetailsScene(primaryStage, selectedTitle, newLanguage, description, generatorOutput, solutionOutput);
            primaryStage.setScene(updatedScene);
        });

        VBox root = new VBox(
                detailsLabel,
                languageComboBox,
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

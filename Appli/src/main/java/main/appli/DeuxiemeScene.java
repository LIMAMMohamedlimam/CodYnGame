package main.appli;

import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeuxiemeScene {

    public Scene createDetailsScene(Stage primaryStage, String selectedExercise, String selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise + "\nLangage: " + selectedLanguage);

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String output = executeCode(selectedLanguage, code);
            outputTextArea.setText(output);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, DatabaseManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        VBox root = new VBox(
                detailsLabel,
                codeTextArea,
                executeButton,
                outputTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }

    private String executeCode(String language, String code) {
        try {
            ProcessBuilder processBuilder;
            switch (language) {
                case "Python":
                    processBuilder = new ProcessBuilder("python", "-c", code);
                    break;
                case "C":
                    // Compilation and execution of C code would require writing the code to a file,
                    // compiling it with a compiler like gcc, and then executing the binary.
                    // This is a simplified example and not complete.
                    return "Execution for C not implemented.";
                case "Java":
                    // Similar to C, Java code execution would require writing to a file, compiling, and then executing.
                    return "Execution for Java not implemented.";
                case "PHP":
                    processBuilder = new ProcessBuilder("php", "-r", code);
                    break;
                default:
                    return "Unsupported language: " + language;
            }

            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
            return output.toString();
        } catch (Exception e) {
            return "Error executing code: " + e.getMessage();
        }
    }
}

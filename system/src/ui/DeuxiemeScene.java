package ui;

import Problems.ProblemManager;
import GetSolution.SolutionExecutor;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class DeuxiemeScene {

    public Scene createDetailsScene(Stage primaryStage, String selectedTitle, String selectedLanguage, String description, String generatorOutput, String output) {
        Label detailsLabel = new Label("Exercice: " + selectedTitle + "\nLangage: " + selectedLanguage + "\nDescription: " + description);

        // Initialisation des composants de la scène
        ComboBox<String> languageComboBox = new ComboBox<>();
        languageComboBox.getItems().addAll("Python", "C", "Java", "PHP", "JavaScript");
        languageComboBox.setValue(selectedLanguage);

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        TextArea generatorOutputTextArea = new TextArea();
        generatorOutputTextArea.setEditable(false);
        generatorOutputTextArea.setText(generatorOutput);

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String solutionOutput = executeSolution(selectedLanguage, code, selectedTitle, generatorOutput);
            outputTextArea.setText(solutionOutput);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        // Gestionnaire d'événements pour la modification du langage sélectionné
        languageComboBox.setOnAction(event -> {
            String newLanguage = languageComboBox.getValue();
            Scene updatedScene = createDetailsScene(primaryStage, selectedTitle, newLanguage, description, generatorOutput, output);
            primaryStage.setScene(updatedScene);
        });

        // Assemblage de la scène
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

    private String executeSolution(String selectedLanguage, String code, String selectedTitle, String generatorOutput) {
        if (selectedLanguage.equals("Python")) {
            // Exécuter la solution Python avec les arguments générés
            Map<String, String> arguments = convertGeneratorOutput(generatorOutput);
            SolutionExecutor solutionExecutor = new SolutionExecutor();
            return solutionExecutor.executeSolution(selectedTitle, arguments);
        } else {
            return "Langage non pris en charge : " + selectedLanguage;
        }
    }

    private Map<String, String> convertGeneratorOutput(String generatorOutput) {
        // Vous devrez adapter cette méthode pour traiter correctement la sortie du générateur
        // Pour le moment, nous supposons que la sortie est une chaîne de clés et de valeurs séparées par des sauts de ligne
        Map<String, String> arguments = new HashMap<>();
        String[] lines = generatorOutput.split("\n");
        for (int i = 0; i < lines.length; i++) {
            arguments.put("arg" + i, lines[i]);
        }
        return arguments;
    }
}

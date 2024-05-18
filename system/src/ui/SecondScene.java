package ui;

import Other.Language;
import Problems.Problem;
import Problems.ProblemManager;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static fonctionnalities.Compiler.Run;

public class SecondScene {
    public Scene createDetailsScene(Stage primaryStage, Problem selectedExercise, Language selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise.getTitle() + "\nLangage: " + selectedLanguage.getName());

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText();
            String output = Run(selectedLanguage, code);
            outputTextArea.setText(output);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            FirstScene premiereScene = new FirstScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles());
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
}

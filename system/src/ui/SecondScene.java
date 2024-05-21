package ui;

import Other.Language;
import Problems.Problem;
import Problems.ProblemManager;
import database.DatabaseManager;
import fonctionnalities.Submission;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.io.File;
import java.lang.reflect.Field;

import static fonctionnalities.Compiler.Run;
import static javafx.application.Application.launch;

public class SecondScene {
    public Scene createDetailsScene(Stage primaryStage, Problem selectedExercise, Language selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise.getTitle() + "\nLangage: " + selectedLanguage.getName());


        TextArea infoTextArea = new TextArea();
        infoTextArea.setPrefHeight(450);
        infoTextArea.setEditable(false);
        infoTextArea.setText(selectedExercise.getDescription());


        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");



        executeButton.setOnAction(event -> {
            if (codeTextArea.getText().length() == 0) {
            }else{
                String code = codeTextArea.getText();
                Submission submission = new Submission(selectedLanguage , code) ;
                String output = Run(submission.getLanguage(), submission.getFile().getPath());
                outputTextArea.setText(output);
            }
        });


        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            FirstScene premiereScene = new FirstScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        VBox root = new VBox(
                detailsLabel,
                infoTextArea,
                codeTextArea,
                executeButton,
                outputTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);



    }

    public void main(String[] args){
        launch(args) ;
    }
}

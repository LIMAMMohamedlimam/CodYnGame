package ui;

import Other.Language;
import Problems.Problem;
import Problems.ProblemManager;
import database.DatabaseManager;
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

import static fonctionnalities.Compiler.Run;
import static javafx.application.Application.launch;

public class SecondScene {
    public Scene createDetailsScene(Stage primaryStage, Problem selectedExercise, Language selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise.getTitle() + "\nLangage: " + selectedLanguage.getName());

        TextArea infoTextArea = new TextArea();
        infoTextArea.setEditable(false);
        infoTextArea.setText("Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                "\n" +
                "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                "\n" +
                "You can return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,7,11,15], target = 9\n" +
                "Output: [0,1]\n" +
                "Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,2,4], target = 6\n" +
                "Output: [1,2]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [3,3], target = 6\n" +
                "Output: [0,1]\n");


        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");


        executeButton.setOnAction(event -> {
            if (codeTextArea.getText().length() != 0) {
                String code = codeTextArea.getText();
                String output = Run(selectedLanguage, code);
                outputTextArea.setText(output);
            }
        });


        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            FirstScene premiereScene = new FirstScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles());
            primaryStage.setScene(scene);
        });

        //VBox root = new VBox(
        //        detailsLabel,
        //        infoTextArea,
        //        codeTextArea,
        //        executeButton,
        //        outputTextArea,
        //        backButton
        //);
        //root.setSpacing(10);
        //root.setPadding(new Insets(10));
//
        //return new Scene(root, 600, 700);


        SplitPane splitPane = new SplitPane();
        splitPane.setPrefSize(1200, 900);
        splitPane.setDividerPositions(0.5);

        AnchorPane leftPane = new AnchorPane();
        TextArea problemDescriptionField = new TextArea("Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n" +
                "\n" +
                "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n" +
                "\n" +
                "You can return the answer in any order.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: nums = [2,7,11,15], target = 9\n" +
                "Output: [0,1]\n" +
                "Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].\n" +
                "Example 2:\n" +
                "\n" +
                "Input: nums = [3,2,4], target = 6\n" +
                "Output: [1,2]\n" +
                "Example 3:\n" +
                "\n" +
                "Input: nums = [3,3], target = 6\n" +
                "Output: [0,1]\n");
        problemDescriptionField.setLayoutY(22);
        problemDescriptionField.setPrefSize(596, 509);
        problemDescriptionField.setEditable(false);
        problemDescriptionField.setWrapText(true);

        Label problemDescriptionLabel = new Label("ProblemDescriptionField");
        problemDescriptionLabel.setLayoutX(23);
        problemDescriptionLabel.setLayoutY(6);

        TextArea dataField = new TextArea();
        dataField.setLayoutY(547);
        dataField.setPrefSize(596, 352);
        dataField.setEditable(false);


        Label dataFieldLabel = new Label("DataField");
        dataFieldLabel.setLayoutX(25);
        dataFieldLabel.setLayoutY(531);

        leftPane.getChildren().addAll(problemDescriptionField, problemDescriptionLabel, dataField, dataFieldLabel);

        AnchorPane rightPane = new AnchorPane();
        TextArea codeEditor = new TextArea();
        codeEditor.setLayoutY(27);
        codeEditor.setPrefSize(596, 422);


        TextField result = new TextField();
        result.setLayoutY(523);
        result.setPrefSize(596, 295);
        result.setEditable(false);

        Label resultLabel = new Label("Result");
        resultLabel.setLayoutX(14);
        resultLabel.setLayoutY(499);

        Label codeEditorLabel = new Label("CodeEditor");
        codeEditorLabel.setLayoutX(14);
        codeEditorLabel.setLayoutY(6);

        Button runButton = new Button("run");
        runButton.setLayoutY(850);
        runButton.setLayoutX(450);
        runButton.setPrefSize(125, 40);

        rightPane.getChildren().addAll(codeEditor, result, resultLabel, codeEditorLabel, runButton);

        splitPane.getItems().addAll(leftPane, rightPane);
        Scene scene = new Scene(splitPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CodYnGame");
        return scene ;
    }

    public void main(String[] args){
        launch(args) ;
    }
}

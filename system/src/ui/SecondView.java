package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SecondView extends Application {



        @Override
        public void start(Stage primaryStage) {
            Scene secondview = createSecondView(primaryStage);
            primaryStage.setScene(secondview);
            primaryStage.setScene(secondview);
            primaryStage.setTitle("CodYnGame");
            primaryStage.show();

        }

        public Scene createSecondView(Stage primaryStage) {
            SplitPane splitPane = new SplitPane();
            splitPane.setPrefSize(1000, 700);
            splitPane.setMaxSize(1000,700);
            splitPane.setDividerPositions(0.5);

            AnchorPane leftPane = new AnchorPane();
            TextArea problemDescriptionField = new TextArea();
            problemDescriptionField.setLayoutY(22);
            problemDescriptionField.setPrefSize(596, 509) ;
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

            Button runButton = new Button("run") ;
            runButton.setLayoutY(850);
            runButton.setLayoutX(450);
            runButton.setPrefSize(125 , 40 ) ;

            rightPane.getChildren().addAll(codeEditor, result, resultLabel, codeEditorLabel , runButton);

            splitPane.getItems().addAll(leftPane, rightPane);

            Scene scene = new Scene(splitPane);
            return scene ;
        }

        public static void main(String[] args) {
            launch(args);
        }
    }



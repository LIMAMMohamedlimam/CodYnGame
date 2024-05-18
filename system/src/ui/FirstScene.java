package ui;

import Other.Language;
import Problems.Problem;
import Problems.ProblemManager;
import database.DatabaseManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import static javafx.application.Application.launch;

public class FirstScene {
    public void start(Stage primaryStage) {
        List<String> titles = ProblemManager.retrieveTitles();
        Scene selectionScene = createSelectionScene(primaryStage, titles);
        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Exercise and Language Selector");
        primaryStage.show();
    }

    public Scene createSelectionScene(Stage primaryStage, List<String> titles) {
        ListView<String> enonceListView = new ListView<>();
        enonceListView.getItems().addAll(titles);

        String[] languages = {"Python", "C", "Java", "PHP"};
        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll(languages);



        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            Problem selectedEnonce = ProblemManager.getProblem(enonceListView.getSelectionModel().getSelectedItem()) ;
            Language selectedLanguage = new Language(languageListView.getSelectionModel().getSelectedItem());

            if (selectedEnonce != null && selectedLanguage != null ) {
                SecondScene secondScene = new SecondScene();
                Scene scene = secondScene.createDetailsScene(primaryStage, selectedEnonce, selectedLanguage);
                primaryStage.setScene(scene);
            } else {
                System.out.println("Veuillez sélectionner un enonce, un langage et confirmer votre choix.");
            }
        });

        VBox root = new VBox(
                new Label("Titles"),
                enonceListView,
                new Label("Langages de programmation"),
                languageListView,
                confirmButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }

    public static void main(String[] args) {
        launch(args);
    }

}

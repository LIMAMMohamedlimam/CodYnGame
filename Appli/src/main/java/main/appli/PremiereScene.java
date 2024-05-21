package main.appli;

import Problems.ExerciseRetriever;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class PremiereScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<String> titles = ExerciseRetriever.retrieveTitles();
        Scene selectionScene = createSelectionScene(primaryStage, titles);
        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Exercise and Language Selector");
        primaryStage.show();
    }

    public Scene createSelectionScene(Stage primaryStage, List<String> titles) {
        ListView<String> titleListView = new ListView<>();
        titleListView.getItems().addAll(titles);

        String[] languages = {"Python", "C", "Java", "PHP", "JavaScript"};
        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll(languages);

        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            String selectedTitle = titleListView.getSelectionModel().getSelectedItem();
            String selectedLanguage = languageListView.getSelectionModel().getSelectedItem();

            if (selectedTitle != null && selectedLanguage != null ) {
                String description = ExerciseRetriever.retrieveDescription(selectedTitle); // Correction ici
                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedTitle, selectedLanguage, description); // Passer la description
                primaryStage.setScene(scene);
            } else {
                System.out.println("Veuillez sélectionner un énoncé et un langage, puis confirmer votre choix.");
            }
        });

        VBox root = new VBox(
                new Label("Énoncés"),
                titleListView,
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

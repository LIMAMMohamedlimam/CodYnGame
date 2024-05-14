package main.appli;



import database.DatabaseManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;


public class PremiereScene extends Application {

    @Override
    public void start(Stage primaryStage) {
        List<String> titles = DatabaseManager.retrieveTitles();


        Scene selectionScene = createSelectionScene(primaryStage, titles);

        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    public Scene createSelectionScene(Stage primaryStage,List<String> titles) {

        ListView<String> exerciseListView = new ListView<>();
        exerciseListView.getItems().addAll(titles);


        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll("Python", "C", "Java", "PHP");



        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            String selectedExercise = exerciseListView.getSelectionModel().getSelectedItem();
            String selectedLanguage = languageListView.getSelectionModel().getSelectedItem();

            if (selectedExercise != null && selectedLanguage != null ) {
                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedExercise, selectedLanguage);
                primaryStage.setScene(scene);
            } else {
                System.out.println("Veuillez sélectionner un exercice, un langage et confirmer votre choix.");
            }
        });

        VBox root = new VBox(
                new Label("Exercices"),
                exerciseListView,
                new Label("Langages de programmation"),
                languageListView,
                confirmButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }
}

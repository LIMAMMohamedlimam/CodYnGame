package main.appli;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PremiereScene extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene selectionScene = createSelectionScene(primaryStage);

        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Application");
        primaryStage.show();
    }

    public Scene createSelectionScene(Stage primaryStage) {
        String[] exercises = {
                "Exercise 1",
                "Exercise 2",
                "Exercise 3"
        };

        String[] languages = {
                "Python",
                "C",
                "Java",
                "PHP"
        };

        ListView<String> exerciseListView = new ListView<>();
        exerciseListView.getItems().addAll(exercises);

        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll(languages);



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

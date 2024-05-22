package main.appli;



import Problems.ExerciseRetriever;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PremiereScene extends Application {

    private ListView<String> titleListView;
    private ComboBox<String> difficultyComboBox;
    private List<String> allTitles;

    @Override
    public void start(Stage primaryStage) {
        allTitles = retrieveTitlesWithDifficulty();
        Scene selectionScene = createSelectionScene(primaryStage, allTitles);
        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Exercise and Language Selector");
        primaryStage.show();
    }

    private List<String> retrieveTitlesWithDifficulty() {
        List<String> titles = ExerciseRetriever.retrieveTitles();
        List<String> titlesWithDifficulty = new ArrayList<>();

        for (String title : titles) {
            try {
                String difficulty = ExerciseRetriever.retrieveDifficultyLevel(title);
                titlesWithDifficulty.add(title + " (" + difficulty + ")");
            } catch (SQLException e) {
                e.printStackTrace();
                titlesWithDifficulty.add(title + " (UNKNOWN)");
            }
        }

        return titlesWithDifficulty;
    }

    public Scene createSelectionScene(Stage primaryStage, List<String> titles) {
        titleListView = new ListView<>();
        titleListView.getItems().addAll(titles);

        String[] languages = {"Python", "C", "Java", "PHP", "JavaScript"};
        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll(languages);

        String[] difficulties = {"ALL", "EASY", "MEDIUM", "HARD"};
        difficultyComboBox = new ComboBox<>();
        difficultyComboBox.getItems().addAll(difficulties);
        difficultyComboBox.setValue("ALL");

        difficultyComboBox.setOnAction(event -> filterTitles());

        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            String selectedTitleWithDifficulty = titleListView.getSelectionModel().getSelectedItem();
            String selectedLanguage = languageListView.getSelectionModel().getSelectedItem();

            if (selectedTitleWithDifficulty != null && selectedLanguage != null) {
                String selectedTitle = selectedTitleWithDifficulty.split(" \\(")[0];
                String description = ExerciseRetriever.retrieveDescription(selectedTitle);

                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedTitle, selectedLanguage, description);
                primaryStage.setScene(scene);
            } else {
                System.out.println("Veuillez sélectionner un énoncé et un langage, puis confirmer votre choix.");
            }
        });

        VBox root = new VBox(
                new Label("Énoncés"),
                difficultyComboBox,
                titleListView,
                new Label("Langages de programmation"),
                languageListView,
                confirmButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }

    private void filterTitles() {
        String selectedDifficulty = difficultyComboBox.getValue();
        List<String> filteredTitles;

        if (selectedDifficulty.equals("ALL")) {
            filteredTitles = new ArrayList<>(allTitles);
        } else {
            filteredTitles = allTitles.stream()
                    .filter(title -> title.contains("(" + selectedDifficulty + ")"))
                    .collect(Collectors.toList());
        }

        titleListView.getItems().setAll(filteredTitles);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

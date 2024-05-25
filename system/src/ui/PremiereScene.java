package ui;


import GetSolution.PythonSolutionExecutor;
import Problems.ProblemManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import GetGeneration.PythonGenerator;
import javafx.scene.control.TextArea;

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
        WelcomeView welcomeView = new WelcomeView();
        Scene welcomeScene = welcomeView.createWelcomeScene(primaryStage);
        primaryStage.setScene(welcomeScene);
        primaryStage.setTitle("CodYngame");
        primaryStage.show();
    }

    private List<String> retrieveTitlesWithDifficulty() {
        List<String> titles = ProblemManager.retrieveTitles();
        List<String> titlesWithDifficulty = new ArrayList<>();

        for (String title : titles) {
            try {
                String difficulty = ProblemManager.retrieveDifficultyLevel(title);
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

        allTitles = new ArrayList<>(titles);

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
                String description = ProblemManager.retrieveDescription(selectedTitle);

                // Générer et capturer la sortie du fichier Python
                String generatorFilePath = PythonGenerator.getGeneratorFilePath(selectedTitle);
                String generatorOutput = PythonGenerator.runPythonGenerator(generatorFilePath);

                // Exécuter la solution Python avec les données générées
                String solutionFilePath = PythonSolutionExecutor.getSolutionFilePath(selectedTitle);
                String solutionOutput = PythonSolutionExecutor.executePythonSolution(solutionFilePath, generatorOutput);

                // Afficher la fenêtre JSON avec la solution
                showJsonWindow(generatorOutput);
                showJsonWindow(solutionOutput);




                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedTitle, selectedLanguage, description, generatorOutput,solutionOutput);
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

    public static void showPopup(String arg) {
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Error");

        Label messageLabel = new Label(arg);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> popupStage.close());

        VBox popupLayout = new VBox(10);
        popupLayout.getChildren().addAll(messageLabel, closeButton);
        Scene popupScene = new Scene(popupLayout, 300, 100);
        popupStage.setScene(popupScene);
        popupStage.showAndWait();
    }
    private void showJsonWindow(String jsonContent) {
        Stage jsonStage = new Stage();
        jsonStage.setTitle("Solution JSON");

        TextArea textArea = new TextArea(jsonContent);
        textArea.setEditable(false);

        jsonStage.setScene(new Scene(textArea, 400, 300));
        jsonStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

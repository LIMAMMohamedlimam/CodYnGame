package ui ;


import Other.Language;
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
import utilisateur.User;

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



    public Scene createSelectionScene(Stage primaryStage, List<String> titles) {
        titleListView = new ListView<>();
        titleListView.getItems().addAll(titles);

        String[] languages = {"Python", "C", "Java", "PHP", "JavaScript"};
        ListView<String> languageListViytétgew = new ListView<>();
        languageListView.getItems().addAll(languages);
        // hello
        String[] difficulties = {"ALL", "EASY", "MEDIUM", "HARD"};
        difficultyComboBox = new ComboBox<>();
        difficultyComboBox.getItems().addAll(difficulties);
        difficultyComboBox.setValue("ALL");

        difficultyComboBox.setOnAction(event -> filterTitles());

        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            String selectedTitleWithDifficulty = titleListView.getSelectionModel().getSelectedItem();
            Language selectedLanguage = new Language(languageListView.getSelectionModel().getSelectedItem() );

            if (selectedTitleWithDifficulty != null && selectedLanguage.getName() != null) {
                String selectedTitle = selectedTitleWithDifficulty.split(" \\(")[0];
                String description = ProblemManager.retrieveDescription(selectedTitle);

                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedTitle, selectedLanguage, description);
                primaryStage.setScene(scene);
            } else if (selectedLanguage.getName() == null){
                showPopup("Veuillez sélectionner un énoncé\net un langage, puis confirmer votre choix.");

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
                    .filter(title -> title.toLowerCase().contains( selectedDifficulty.toLowerCase() ))
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

    public static void main(String[] args) {
        launch(args);
    }
}

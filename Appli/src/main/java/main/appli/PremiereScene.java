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
        List<String> enonces = DatabaseManager.retrieveTitles();
        Scene selectionScene = createSelectionScene(primaryStage, enonces);
        primaryStage.setScene(selectionScene);
        primaryStage.setTitle("Exercise and Language Selector");
        primaryStage.show();
    }

    public Scene createSelectionScene(Stage primaryStage, List<String> enonces) {
        ListView<String> enonceListView = new ListView<>();
        enonceListView.getItems().addAll(enonces);

        String[] languages = {"Python", "C", "Java", "PHP"};
        ListView<String> languageListView = new ListView<>();
        languageListView.getItems().addAll(languages);

        CheckBox confirmCheckBox = new CheckBox("Confirmer");

        Button confirmButton = new Button("Valider");
        confirmButton.setOnAction(event -> {
            String selectedEnonce = enonceListView.getSelectionModel().getSelectedItem();
            String selectedLanguage = languageListView.getSelectionModel().getSelectedItem();
            boolean confirmed = confirmCheckBox.isSelected();
            if (selectedEnonce != null && selectedLanguage != null && confirmed) {
                DeuxiemeScene deuxiemeScene = new DeuxiemeScene();
                Scene scene = deuxiemeScene.createDetailsScene(primaryStage, selectedEnonce, selectedLanguage);
                primaryStage.setScene(scene);
            } else {
                System.out.println("Veuillez sélectionner un enonce, un langage et confirmer votre choix.");
            }
        });

        VBox root = new VBox(
                new Label("Enonces"),
                enonceListView,
                new Label("Langages de programmation"),
                languageListView,
                confirmCheckBox,
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

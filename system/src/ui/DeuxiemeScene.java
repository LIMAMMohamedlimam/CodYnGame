package ui ;
import Other.Language;
import Problems.Problem;
import Problems.ProblemManager;
import fonctionnalities.Submission;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Game.Game ;

import static fonctionnalities.Compiler.Run;

public class DeuxiemeScene {

    public Scene createDetailsScene(Stage primaryStage,Game currentGame) {
        //Label detailsLabel = new Label("Exercice: " + selectedTitle + "\nLangage: " + selectedLanguage.getName() + "\nDescription: " + selectedProb.getDescription());
        TextArea probDescription = new TextArea("Exercice: " + currentGame.getSelectedProblem().getTitle() +
                "\nLangage: " + currentGame.getSelectedLanguage().getName() + "\nDescription: " + currentGame.getSelectedProblem().getDescription()) ;
        probDescription.setEditable(false);
        // Initialisation de la liste déroulante avec les langages disponibles
        ObservableList<String> languages = FXCollections.observableArrayList("Python", "C", "Java", "PHP", "JavaScript");
        ComboBox<String> languageComboBox = new ComboBox<>(languages);

        // Sélectionner le langage par défaut
        languageComboBox.setValue(currentGame.getSelectedLanguage().getName());


        TextArea codeTextArea = new TextArea(currentGame.getDefaultCode());
        codeTextArea.setPromptText("Saisissez votre code ici");

        TextArea outputTextArea = new TextArea();
        outputTextArea.setEditable(false);

        Button executeButton = new Button("Valider");
        executeButton.setOnAction(event -> {
            String code = codeTextArea.getText() ;
            Submission submission = new Submission(currentGame.getSelectedLanguage() , code) ;
            String output = Run(submission.getLanguage(), submission.getFile().getPath());
            ProblemManager.verifyCode(currentGame.getSelectedProblem(), output);
            outputTextArea.setText(output);
        });

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage, ProblemManager.retrieveTitles(), currentGame);
            primaryStage.setScene(scene);
        });

        // Ajouter un gestionnaire d'événements à la liste déroulante des langages pour réinitialiser la scène avec le nouveau langage
        languageComboBox.setOnAction(event -> {
            //Language newLanguage = new Language(languageComboBox.getValue());
            DeuxiemeScene newScene = new DeuxiemeScene();
            Scene updatedScene = newScene.createDetailsScene(primaryStage,currentGame);
            primaryStage.setScene(updatedScene);
        });

        VBox root = new VBox(
                probDescription,
                languageComboBox,
                codeTextArea,
                executeButton,
                new Label("Output:"),
                outputTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }
}


package main.appli;




import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeuxiemeScene {

    public Scene createDetailsScene(Stage primaryStage, String selectedExercise, String selectedLanguage) {
        Label detailsLabel = new Label("Exercice: " + selectedExercise + "\n"+"\nLangage: " + selectedLanguage);

        TextArea codeTextArea = new TextArea();
        codeTextArea.setPromptText("Saisissez votre code ici");

        Button backButton = new Button("Retour");
        backButton.setOnAction(event -> {
            PremiereScene premiereScene = new PremiereScene();
            Scene scene = premiereScene.createSelectionScene(primaryStage,null);
            primaryStage.setScene(scene);
        });

        VBox root = new VBox(
                detailsLabel,
                codeTextArea,
                backButton
        );
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        return new Scene(root, 600, 700);
    }
}

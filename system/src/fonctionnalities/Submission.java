package fonctionnalities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Game.Game;
import Other.Language;
import constants.Commandes;

/**
 * Représente une soumission dans un système de gestion de soumissions.
 */
public class Submission {
    private Game currentGame;
    private File file;

    /**
     * Constructeur pour créer une soumission avec la langue et le fichier spécifiés.
     *
     * @param currentGame La langue de programmation de la soumission.
     * @param code Le code source de la soumission.
     */
    public Submission(Game currentGame, String code) {
        this.currentGame = currentGame;
        this.file = fromCodeFile(code);

    }

    /**
     * Constructeur pour créer une soumission avec un identifiant de soumission,
     * un identifiant d'utilisateur, la langue de programmation et le fichier.
     *
     * @param submissionId L'identifiant unique de la soumission.
     * @param userId L'identifiant de l'utilisateur qui soumet.
     * @param language La langue de programmation de la soumission.
     * @param code Le code source de la soumission.
     */


    /**
     * Définit le fichier de cette soumission.
     *
     * @param file Le nouveau fichier source de la soumission.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Soumet le fichier au système.
     */
    public void submit() {
        // Logique de soumission
    }

    /**
     * Récupère les détails de la soumission.
     */
    public void fetchSubmissionDetails() {
        // Logique pour récupérer les détails de la soumission
    }

    public File getFile() {
        return file;
    }


    /**
     * Exécute le fichier de la soumission selon la langue spécifiée.
     */
    public void runFile() {
        String languageName = this.currentGame.getSelectedLanguage().getName().toLowerCase();
        if (languageName.equals("python")) {
            Compiler.Run(this.currentGame.getSelectedLanguage(), this.file.getPath());
        } else if (languageName.equals("c")) {
            Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "output.out");
        } else if (languageName.equals("java")) {
            String classpath = this.file.getPath().replace(this.file.getName(), "");
            String program = this.file.getName().replace(".java", " ");
            Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "-classpath" + " " + classpath + " " + program);
        }
    }


    public File fromCodeFile(String code){

        String directoryPath = "CodYngame_exec";
        String fileName = "" + this.currentGame.getSelectedLanguage().getName() + Commandes.getFiletag(this.currentGame.getSelectedLanguage());

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.out.println("Failed to create directory.");
            }
        }

        // Create a new file object
        File file = new File(directoryPath + File.separator + fileName);

        // Create the file and write to it
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(code);
            System.out.println("File created and text written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating/writing to the file.");
            e.printStackTrace();
        }
        return file;
    }

    public String run(){
        if(currentGame.getSelectedLanguage().getName().equalsIgnoreCase("c") ||
                currentGame.getSelectedLanguage().getName().equalsIgnoreCase("java")){
            Compiler.compile(currentGame.getSelectedLanguage(), this.file.getPath(),  "userOutputFile");
            return Compiler.Run(currentGame.getSelectedLanguage() , "userOutputFile") ;
        }else{
            return Compiler.Run(currentGame.getSelectedLanguage() , this.file.getPath() ) ;
        }
    }
}

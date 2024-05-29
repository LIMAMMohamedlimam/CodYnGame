package fonctionnalities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

import Game.Game;
import Other.Language;
import constants.Commandes;

/**
 * Représente une soumission dans un système de gestion de soumissions.
 */
public class Submission {
    private Game currentGame;
    private String userResult ;
    private File file;

    /**
     * Constructeur pour créer une soumission avec la langue et le fichier spécifiés.
     *
     * @param currentGame La langue de programmation de la soumission.
     * @param code        Le code source de la soumission.
     */
    public Submission(Game currentGame, String code) {
        this.currentGame = currentGame;
        this.file = fromCodeFile(code);

    }

    public void setUserResult() throws SQLException {
        this.userResult =  this.run().trim() ;//Compiler.transformStringToJson(this.run().trim()) ;
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
            Compiler.Run(this.currentGame.getSelectedLanguage(), this.file.getPath() ,"");
        } else if (languageName.equals("c")) {
            Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "output.out" , "");
        } else if (languageName.equals("java")) {
            String classpath = this.file.getPath().replace(this.file.getName(), "");
            String program = this.file.getName().replace(".java", " ");
            Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "-classpath" + " " + classpath + " " + program , "");
        }
    }


    public File fromCodeFile(String code) {

        String directoryPath = "modeInclude";
        String fileName = this.currentGame.getSelectedUser().getUsername().replaceAll(" ", "") + Commandes.getFiletag(this.currentGame.getSelectedLanguage());

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

    public String run() throws SQLException {
        //if (currentGame.getSelectedMode().equals("Mode Include")) {
        //    IncludeUserFunction(currentGame.getSelectedProblem().getModeIncludeFile(currentGame), this.file.getPath(), currentGame.getSelectedUser().getUsername());
        //}
        if (currentGame.getSelectedMode().equalsIgnoreCase("Mode Include")) {
            if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("c")) {
                return Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "output.out" , "") ;
            } else if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("java")) {
                String classpath = this.file.getPath().replace(this.file.getName(), "");
                String program = this.file.getName().replace(".java", " ");
                return Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "-classpath" + " " + classpath + " " + program ,"");
            } else {

                return Compiler.Run(this.currentGame.getSelectedLanguage(), this.file.getPath() , "");
            }
        }else if(currentGame.getSelectedMode().equalsIgnoreCase("Mode Input Output")){
            if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("c")) {
                return Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "output.out" , currentGame.getSelectedProblem().getData().replaceAll(" ",""));
            } else if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("java")) {
                String classpath = this.file.getPath().replace(this.file.getName(), "");
                String program = this.file.getName().replace(".java", " ");
                return Compiler.compile(this.currentGame.getSelectedLanguage(), this.file.getPath(), "-classpath" + " " + classpath + " " + program , currentGame.getSelectedProblem().getData().replaceAll(" " ,""));
            } else {

                return Compiler.Run(this.currentGame.getSelectedLanguage(), this.file.getPath() + " "+
                         currentGame.getSelectedProblem().getData().replaceAll(" ", "") , "");
            }
        }
        return null ;
    }


    public String run(String filePath) {

        if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("c")) {
            return Compiler.compile(this.currentGame.getSelectedLanguage(), filePath, "output.out" , "");
        } else if (currentGame.getSelectedLanguage().getName().equalsIgnoreCase("java")) {
            String classpath = filePath.replace(this.file.getName(), "");
            String program = this.file.getName().replace(".java", " ");
            return Compiler.compile(this.currentGame.getSelectedLanguage(), filePath, "-classpath" + " " + classpath + " " + program , "");
        } else {

            return Compiler.Run(this.currentGame.getSelectedLanguage(), filePath ,"");
        }
    }





    public String verifySolution() throws SQLException {
        System.out.println(currentGame.getSelectedProblem().getData());
        this.setUserResult();

        System.out.println("this is the usroutput" + userResult);
        String output = Compiler.Run(new Language("python"), currentGame.getSelectedProblem().getSolutionFile()
                + " verify " +  currentGame.getSelectedProblem().getData().replaceAll(" " , "") + " "  + userResult.replaceAll(" " , "") , "");
        return output;

    }
}


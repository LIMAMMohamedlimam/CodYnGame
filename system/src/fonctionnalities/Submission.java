package fonctionnalities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Other.Language;
import constants.Commandes;

/**
 * Représente une soumission dans un système de gestion de soumissions.
 */
public class Submission {
    private int subId ;
    private int userId;
    private Language language;
    private File file;

    /**
     * Constructeur pour créer une soumission avec la langue et le fichier spécifiés.
     *
     * @param language La langue de programmation de la soumission.
     * @param code Le code source de la soumission.
     */
    public Submission(Language language, String code) {
        this.language = language;
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
    public Submission(int submissionId, int userId, Language language, String code) {
        this.userId = userId;
        this.language = language;
        this.file = fromCodeFile(code);
    }

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

    public Language getLanguage(){
        return this.language ;
    }

    /**
     * Exécute le fichier de la soumission selon la langue spécifiée.
     */
    public void runFile() {
        String languageName = this.language.getName().toLowerCase();
        if (languageName.equals("python")) {
            Compiler.Run(this.language, this.file.getPath());
        } else if (languageName.equals("c")) {
            Compiler.compile(this.language, this.file.getPath(), "output.out");
        } else if (languageName.equals("java")) {
            String classpath = this.file.getPath().replace(this.file.getName(), "");
            String program = this.file.getName().replace(".java", " ");
            Compiler.compile(this.language, this.file.getPath(), "-classpath" + " " + classpath + " " + program);
        }
    }


    public File fromCodeFile(String code){

        String directoryPath = "CodYngame_exec";
        String fileName = "" + this.language.getName() + Commandes.getFiletag(this.language);

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
}

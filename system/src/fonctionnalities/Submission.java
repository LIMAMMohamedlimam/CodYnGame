package fonctionnalities;

import java.io.File;
import Other.Language;

/**
 * Représente une soumission dans un système de gestion de soumissions.
 */
public class Submission {
    private int submissionId;
    private int userId;
    private Language language;
    private File file;

    /**
     * Constructeur pour créer une soumission avec la langue et le fichier spécifiés.
     *
     * @param language La langue de programmation de la soumission.
     * @param file Le fichier source de la soumission.
     */
    public Submission(Language language, File file) {
        this.file = file;
        this.language = language;
    }

    /**
     * Constructeur pour créer une soumission avec un identifiant de soumission,
     * un identifiant d'utilisateur, la langue de programmation et le fichier.
     *
     * @param submissionId L'identifiant unique de la soumission.
     * @param userId L'identifiant de l'utilisateur qui soumet.
     * @param language La langue de programmation de la soumission.
     * @param file Le fichier source de la soumission.
     */
    public Submission(int submissionId, int userId, Language language, File file) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.language = language;
        this.file = file;
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

    /**
     * Exécute le fichier de la soumission selon la langue spécifiée.
     */
    public void runFile() {
        String languageName = this.language.getName().toLowerCase();
        if (languageName.equals("python")) {
            Compiler.compile(this.language, this.file.getPath());
        } else if (languageName.equals("c")) {
            Compiler.compile(this.language, this.file.getPath(), "output.out");
        } else if (languageName.equals("java")) {
            String classpath = this.file.getPath().replace(this.file.getName(), "");
            String program = this.file.getName().replace(".java", " ");
            Compiler.compile(this.language, this.file.getPath(), "-classpath" + " " + classpath + " " + program);
        }
    }
}

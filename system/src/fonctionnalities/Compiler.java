package fonctionnalities;
import java.lang.Runtime ;
import static constants.Commandes.getCompileCommand;
import static constants.Commandes.getRunCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import Other.Language;
import constants.Commandes;


/**
 * Classe abstraite définissant les fonctionnalités de compilation pour différents langages de programmation.
 */
public abstract class Compiler {

    /**
     * Compile et exécute un programme à partir d'un chemin de fichier source spécifié.
     *
     * @param language Le langage de programmation utilisé.
     * @param srcFilePath Le chemin vers le fichier source à compiler.
     * @param outFilename Le nom du fichier de sortie après la compilation.
     */
    public static void compile(Language language, String srcFilePath, String outFilename){
        String compileCmd = getCompileCommand(language, srcFilePath, outFilename);
        String runCmd = getRunCommand(language, outFilename);

        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd);
            String compileError = readProcessOutput(compileProcess.getErrorStream());
            int compileStatus = compileProcess.waitFor();
            if (compileStatus != 0){
                System.out.println("Erreur de compilation: " + compileError);
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream());
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
                System.out.println("Sortie: " + runOutput);
            } else {
                System.out.println("Erreur d'exécution: " + runError);
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * execute un fichier source spécifié utilisant le compilateur par défaut du langage.
     *
     * @param language Le langage de programmation du fichier.
     * @param filePath Le chemin du fichier source à compiler.
     */
    public static String Run(Language language, String filePath) {
        String runCmd = Commandes.getCompileCommandtag(language) + " " + filePath;
        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream());
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
//                System.out.println("Sortie: " + runOutput);
                return  runOutput ;
            } else {
//                System.out.println("Erreur de compilation: " + runError);
                return  runError ;

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage() ;
        }
    }



    /**
     * Lit et retourne la sortie d'un processus.
     *
     * @param inputStream Le flux d'entrée du processus à lire.
     * @return La sortie du processus sous forme de chaîne de caractères.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de la lecture du flux.
     */
    private static String readProcessOutput(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }


    /**
     * Exécute une liste de commandes shell de manière enchaînée en fonction du système d'exploitation.
     * Sous Windows, les commandes sont exécutées séquentiellement en utilisant '&&'.
     * Sous les systèmes Unix (Linux, macOS), les commandes sont chaînées par '|'.
     *
     * @param commands Une liste de commandes shell à exécuter. Cette liste ne doit ni être null ni vide.
     *                 Chaque chaîne dans la liste devrait être une commande valide de ligne de commande.
     * @return Void Cette méthode ne retourne aucune valeur. Les sorties sont directement imprimées sur la sortie standard.
     */
    public static void executeCommands(List<String> commands) {
        if (commands == null || commands.isEmpty()) {
            System.out.println("Aucune commande fournie.");
            return;
        }

        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder builder;

        if (os.contains("win")) {
            builder = new ProcessBuilder("cmd.exe", "/c", String.join(" && ", commands));
        } else {
            builder = new ProcessBuilder("/bin/sh", "-c", String.join(" | ", commands));
        }

        try {
            Process process = builder.start();

            // Lecture de la sortie et des erreurs du processus
            String output = readProcessOutput(process.getInputStream());
            String errors = readProcessOutput(process.getErrorStream());
            int status = process.waitFor();

            // Affichage de la sortie ou des erreurs en fonction du statut d'exécution
            if (status == 0) {
                System.out.println("Sortie : " + output);
            } else {
                System.out.println("Erreur : " + errors);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}



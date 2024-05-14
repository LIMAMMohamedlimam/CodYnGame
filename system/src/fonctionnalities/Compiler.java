package fonctionnalities;
import java.lang.Runtime ;
import static constants.Commandes.getCompileCommand;
import static constants.Commandes.getRunCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
     * Compile un fichier source spécifié utilisant le compilateur par défaut du langage.
     *
     * @param language Le langage de programmation du fichier.
     * @param filePath Le chemin du fichier source à compiler.
     */
    public static void compile(Language language, String filePath) {
        String runCmd = Commandes.getCompileCommandtag(language) + " " + filePath;
        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream());
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
                System.out.println("Sortie: " + runOutput);
            } else {
                System.out.println("Erreur de compilation: " + runError);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
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

}

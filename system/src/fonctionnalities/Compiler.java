package fonctionnalities;
import java.io.*;
import java.lang.Runtime ;
import static constants.Commandes.getCompileCommand;
import static constants.Commandes.getRunCommand;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import java.nio.file.Files ;
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
    public static String compile(Language language, String srcFilePath, String outFilename , String argv){
        System.out.println("compiling ....");
        String compileCmd = getCompileCommand(language, srcFilePath, outFilename);
        String runCmd = getRunCommand(language, outFilename , argv);

        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd);
            String compileError = readProcessOutput(compileProcess.getErrorStream());
            int compileStatus = compileProcess.waitFor();
            if (compileStatus != 0){
                System.out.println("compiling error");
                System.out.println(compileError);
                return compileError ;
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
                return runOutput ;
            } else {
                return runError ;
            }

        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return null ;
    }

    /**
     * execute un fichier source spécifié utilisant le compilateur par défaut du langage.
     *
     * @param language Le langage de programmation du fichier.
     * @param filePath Le chemin du fichier source à compiler.
     */
    public static String Run(Language language, String filePath) {
        String runCmd = language.getRunTag()  + filePath;
        System.out.println(runCmd);

        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream());
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            //deleteFile(filePath) ;
            if (runStatus == 0){
                return  runOutput ;
            } else {
                return  runError ;

            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return e.getMessage() ;
        }


    }


    private static void deleteFile(String filePath) {
            executeCommand("rm "+filePath);
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
            if(!line.contains("{"))
                output.append(line).append("\n");
            else{
                output.append(line);
            }

        }
        return output.toString();

    }


    /**
     * Exécute une liste de commandes shell de manière enchaînée en fonction du système d'exploitation.
     * Sous Windows, les commandes sont exécutées séquentiellement en utilisant '&&'.
     * Sous les systèmes Unix (Linux, macOS), les commandes sont chaînées par '|'.
     *
     * @param command Une liste de commandes shell à exécuter. Cette liste ne doit ni être null ni vide.
     *                 Chaque chaîne dans la liste devrait être une commande valide de ligne de commande.
     * @return Void Cette méthode ne retourne aucune valeur. Les sorties sont directement imprimées sur la sortie standard.
     */
    public static void executeCommand(String command) {
        try {
            Process runProcess = Runtime.getRuntime().exec(command);
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
                System.out.println(" success") ;
            } else {
                System.out.println("Error ");
            }
        }

         catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}



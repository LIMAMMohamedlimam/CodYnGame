package GetSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonSolutionExecutor {

    /**
     * Génère le chemin du fichier Python de solution basé sur le titre de l'exercice.
     *
     * @param title Le titre de l'exercice.
     * @return Le chemin du fichier Python de solution.
     */
    public static String getSolutionFilePath(String title) {
        // Convertir le titre en nom de fichier
        String fileName = title.replace(" ", "") + ".py";
        // Chemin complet du fichier de solution
        return "solutionFiles/" + fileName;
    }

    /**
     * Exécute le script Python de solution avec les données générées.
     *
     * @param solutionFilePath Le chemin du fichier Python de solution.
     * @param generatedData    Les données générées à passer au script Python.
     * @return La sortie du script Python.
     */
    public static String executePythonSolution(String solutionFilePath, String generatedData) {
        try {
            // Construction de la commande pour exécuter le script Python avec les données générées
            String command = "python " + solutionFilePath + " " + generatedData;

            // Exécution de la commande
            Process process = Runtime.getRuntime().exec(command);

            // Récupération de la sortie du script Python
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Attente de la fin de l'exécution du processus Python
            process.waitFor();

            return output.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

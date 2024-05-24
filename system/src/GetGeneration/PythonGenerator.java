
package GetGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonGenerator {

    /**
     * Génère le chemin du fichier Python générateur basé sur le titre de l'exercice.
     *
     * @param title Le titre de l'exercice.
     * @return Le chemin du fichier Python générateur.
     */
    public static String getGeneratorFilePath(String title) {
        // Convertir le titre en nom de fichier
        String fileName = title.replace(" ", "") + "Gen.py";
        // Chemin complet du fichier générateur
        return "DataGenFiles/" + fileName;
    }

    /**
     * Exécute le fichier Python générateur et capture sa sortie.
     *
     * @param filePath Le chemin du fichier Python à exécuter.
     * @return La sortie du script Python.
     */
    public static String runPythonGenerator(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec("python " + filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}

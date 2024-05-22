
package main.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataGenerator {
    private String pythonScriptPath;

    public DataGenerator(String pythonScriptPath) {
        this.pythonScriptPath = pythonScriptPath;
    }

    public String generateData() {
        StringBuilder output = new StringBuilder();
        try {
            // Exécuter le script Python et capturer la sortie
            Process process = Runtime.getRuntime().exec("python " + pythonScriptPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Erreur lors de la génération des données : " + e.getMessage();
        }
        return output.toString();
    }
}

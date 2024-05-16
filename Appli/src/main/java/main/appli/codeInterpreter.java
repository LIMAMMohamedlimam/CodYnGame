package main.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class codeInterpreter {
    public static String executeCode(String language, String code) {
        try {
            ProcessBuilder processBuilder;
            switch (language) {
                case "Python":
                    processBuilder = new ProcessBuilder("C:\\Users\\axelm\\OneDrive\\Documents\\GitHub\\CodYnGame\\venv\\Scripts\\python.exe", "-c", code);
                    break;
                case "C":
                    // Ajoutez ici la logique de compilation et d'exécution pour le langage C
                    return "Exécution pour C non implémentée.";
                case "Java":
                    // Ajoutez ici la logique de compilation et d'exécution pour le langage Java
                    return "Exécution pour Java non implémentée.";
                case "PHP":
                    processBuilder = new ProcessBuilder("php", "-r", code);
                    break;
                default:
                    return "Langage non pris en charge : " + language;
            }

            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
            return output.toString();
        } catch (IOException | InterruptedException e) {
            return "Erreur lors de l'exécution du code : " + e.getMessage();
        }
    }
}



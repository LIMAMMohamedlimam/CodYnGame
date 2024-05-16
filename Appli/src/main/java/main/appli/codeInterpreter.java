package main.appli;

import java.io.*;

public class codeInterpreter {
    public static String executeCode(String language, String code) {
        try {
            switch (language) {
                case "Python":
                    // Logique d'exécution pour Python
                    break;
                case "C":
                    // Écriture du code C dans un fichier temporaire
                    File tempFile = File.createTempFile("code", ".c");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                        writer.write(code);
                    }

                    // Compilation du fichier source C avec GCC
                    ProcessBuilder processBuilder = new ProcessBuilder("gcc", "-o", "output", tempFile.getAbsolutePath());
                    processBuilder.directory(tempFile.getParentFile());
                    Process compileProcess = processBuilder.start();
                    int exitCode = compileProcess.waitFor();

                    if (exitCode == 0) {
                        return "Compilation réussie";
                        // Si la compilation réussit, vous pouvez exécuter le programme généré, le cas échéant
                    } else {
                        return "Échec de la compilation";
                        // Gestion des erreurs de compilation, affichage de messages à l'utilisateur, etc.
                    }
                case "Java":
                    // Logique d'exécution pour Java
                    break;
                case "PHP":
                    // Logique d'exécution pour PHP
                    break;
                default:
                    return "Langage non pris en charge : " + language;
            }
        } catch (IOException | InterruptedException e) {
            return "Erreur lors de l'exécution du code : " + e.getMessage();
        }
        return "Code exécuté avec succès";
    }
}

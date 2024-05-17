package main.appli;



import java.io.*;

public class codeInterpreter {
    public static String executeCode(String language, String code) {
        ProcessBuilder processBuilder = null; // Déclarez processBuilder ici pour l'utiliser dans tout le bloc try

        try {
            switch (language) {
                case "Python":
                    // Écriture du code Python dans un fichier temporaire
                    File tempPythonFile = File.createTempFile("code", ".py");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempPythonFile))) {
                        writer.write(code);
                    }
                    processBuilder = new ProcessBuilder("python", tempPythonFile.getAbsolutePath());
                    break;
                case "C":
                    // Écriture du code C dans un fichier temporaire
                    File tempFile = File.createTempFile("code", ".c");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                        writer.write(code);
                    }

                    // Compilation du fichier source C avec GCC
                    processBuilder = new ProcessBuilder("gcc", "-o", "output", tempFile.getAbsolutePath());
                    processBuilder.directory(tempFile.getParentFile());
                    Process compileProcess = processBuilder.start();
                    int exitCode = compileProcess.waitFor();

                    if (exitCode == 0) {
                        // Exécution du programme compilé
                        ProcessBuilder runProcessBuilder = new ProcessBuilder(tempFile.getParentFile().getAbsolutePath() + "\\output");
                        runProcessBuilder.directory(tempFile.getParentFile());
                        runProcessBuilder.redirectErrorStream(true);
                        Process runProcess = runProcessBuilder.start();
                        BufferedReader runReader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
                        StringBuilder runOutput = new StringBuilder();
                        String line;
                        while ((line = runReader.readLine()) != null) {
                            runOutput.append(line).append("\n");
                        }
                        runProcess.waitFor();
                        return runOutput.toString();
                    } else {
                        // Lire la sortie de la compilation (erreurs éventuelles)
                        BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
                        StringBuilder errorOutput = new StringBuilder();
                        String line;
                        while ((line = errorReader.readLine()) != null) {
                            errorOutput.append(line).append("\n");
                        }
                        return "Échec de la compilation:\n" + errorOutput.toString();
                    }
                case "Java":
                    // Logique d'exécution pour Java
                    break;
                case "PHP":
                    processBuilder = new ProcessBuilder("php", "-r", code);
                    break;
                default:
                    return "Langage non pris en charge : " + language;
            }

            if (processBuilder != null) {
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
            } else {
                return "Aucune commande à exécuter.";
            }

        } catch (IOException | InterruptedException e) {
            return "Erreur lors de l'exécution du code : " + e.getMessage();
        }
    }
}

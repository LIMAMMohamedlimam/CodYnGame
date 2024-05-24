package fonctionnalities;

import java.io.*;

class codeInterpreter {
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

                    // Exécution du fichier Python
                    processBuilder = new ProcessBuilder("python", tempPythonFile.getAbsolutePath());
                    break;
                case "C":
                    // Écriture du code C dans un fichier temporaire
                    File tempCFile = File.createTempFile("code", ".c");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempCFile))) {
                        writer.write(code);
                    }

                    // Compilation du fichier source C avec GCC
                    processBuilder = new ProcessBuilder("gcc", "-o", "output", tempCFile.getAbsolutePath());
                    processBuilder.directory(tempCFile.getParentFile());
                    Process compileProcess = processBuilder.start();
                    int exitCode = compileProcess.waitFor();

                    if (exitCode == 0) {
                        // Exécution du programme compilé
                        ProcessBuilder runProcessBuilder = new ProcessBuilder(tempCFile.getParentFile().getAbsolutePath() + "\\output");
                        runProcessBuilder.directory(tempCFile.getParentFile());
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
                    // Écriture du code Java dans un fichier temporaire
                    File tempJavaFile = new File(System.getProperty("java.io.tmpdir"), "Main.java");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempJavaFile))) {
                        writer.write(code);
                    }

                    // Compilation du fichier source Java avec javac
                    processBuilder = new ProcessBuilder("javac", tempJavaFile.getAbsolutePath());
                    processBuilder.directory(tempJavaFile.getParentFile());
                    Process compileJavaProcess = processBuilder.start();
                    int javaExitCode = compileJavaProcess.waitFor();

                    if (javaExitCode == 0) {
                        // Exécution du programme compilé
                        processBuilder = new ProcessBuilder("java", "-cp", tempJavaFile.getParentFile().getAbsolutePath(), "Main");
                        processBuilder.directory(tempJavaFile.getParentFile());
                    } else {
                        // Lire la sortie de la compilation (erreurs éventuelles)
                        BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileJavaProcess.getErrorStream()));
                        StringBuilder errorOutput = new StringBuilder();
                        String line;
                        while ((line = errorReader.readLine()) != null) {
                            errorOutput.append(line).append("\n");
                        }
                        return "Échec de la compilation:\n" + errorOutput.toString();
                    }
                    break;
                case "PHP":
                    // Écriture du code PHP dans un fichier temporaire
                    File tempPHPFile = File.createTempFile("code", ".php");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempPHPFile))) {
                        writer.write(code);
                    }

                    // Exécution du fichier PHP
                    processBuilder = new ProcessBuilder("php", tempPHPFile.getAbsolutePath());
                    break;
                case "JavaScript":
                    File tempJavaScriptFile = File.createTempFile("code",".js");
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(tempJavaScriptFile))){
                        writer.write(code);

                    }

                    processBuilder = new ProcessBuilder("node",tempJavaScriptFile.getAbsolutePath());
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

                BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                StringBuilder errorOutput = new StringBuilder();
                while ((line = errorReader.readLine()) != null) {
                    errorOutput.append(line).append("\n");
                }

                process.waitFor();
                if (errorOutput.length() > 0) {
                    return "Erreur:\n" + errorOutput.toString();
                }
                return output.toString();
            } else {
                return "Aucune commande à exécuter.";
            }

        } catch (IOException | InterruptedException e) {
            return "Erreur lors de l'exécution du code : " + e.getMessage();
        }
    }
}

package fonctionnalities;

import java.io.*;

public class codeInterpreter {
    public static String executeCode(String language, String code) {
        ProcessBuilder processBuilder = null; // Declare processBuilder here to use it throughout the try block

        try {
            switch (language) {
                case "Python":
                    // Write the Python code to a temporary file
                    File tempPythonFile = File.createTempFile("code", ".py");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempPythonFile))) {
                        writer.write(code);
                    }

                    // Execute the Python file
                    processBuilder = new ProcessBuilder("python", tempPythonFile.getAbsolutePath());
                    break;
                case "C":
                    // Write the C code to a temporary file
                    File tempCFile = File.createTempFile("code", ".c");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempCFile))) {
                        writer.write(code);
                    }

                    // Compile the C source file with GCC
                    processBuilder = new ProcessBuilder("gcc", "-o", "output", tempCFile.getAbsolutePath());
                    processBuilder.directory(tempCFile.getParentFile());
                    Process compileProcess = processBuilder.start();
                    int exitCode = compileProcess.waitFor();

                    if (exitCode == 0) {
                        // Execute the compiled program
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
                        // Read the compilation output (possible errors)
                        BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
                        StringBuilder errorOutput = new StringBuilder();
                        String line;
                        while ((line = errorReader.readLine()) != null) {
                            errorOutput.append(line).append("\n");
                        }
                        return "Compilation failed:\n" + errorOutput.toString();
                    }
                case "Java":
                    // Write the Java code to a temporary file
                    File tempJavaFile = new File(System.getProperty("java.io.tmpdir"), "Main.java");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempJavaFile))) {
                        writer.write(code);
                    }

                    // Compile the Java source file with javac
                    processBuilder = new ProcessBuilder("javac", tempJavaFile.getAbsolutePath());
                    processBuilder.directory(tempJavaFile.getParentFile());
                    Process compileJavaProcess = processBuilder.start();
                    int javaExitCode = compileJavaProcess.waitFor();

                    if (javaExitCode == 0) {
                        // Execute the compiled program
                        processBuilder = new ProcessBuilder("java", "-cp", tempJavaFile.getParentFile().getAbsolutePath(), "Main");
                        processBuilder.directory(tempJavaFile.getParentFile());
                    } else {
                        // Read the compilation output (possible errors)
                        BufferedReader errorReader = new BufferedReader(new InputStreamReader(compileJavaProcess.getErrorStream()));
                        StringBuilder errorOutput = new StringBuilder();
                        String line;
                        while ((line = errorReader.readLine()) != null) {
                            errorOutput.append(line).append("\n");
                        }
                        return "Compilation failed:\n" + errorOutput.toString();
                    }
                    break;
                case "PHP":
                    // Write the PHP code to a temporary file
                    File tempPHPFile = File.createTempFile("code", ".php");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempPHPFile))) {
                        writer.write(code);
                    }

                    // Execute the PHP file
                    processBuilder = new ProcessBuilder("php", tempPHPFile.getAbsolutePath());
                    break;
                case "JavaScript":
                    // Write the JavaScript code to a temporary file
                    File tempJavaScriptFile = File.createTempFile("code", ".js");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempJavaScriptFile))) {
                        writer.write(code);
                    }

                    // Execute the JavaScript file
                    processBuilder = new ProcessBuilder("node", tempJavaScriptFile.getAbsolutePath());
                    break;
                default:
                    return "Unsupported language: " + language;
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
                    return "Error:\n" + errorOutput.toString();
                }
                return output.toString();
            } else {
                return "No command to execute.";
            }

        } catch (IOException | InterruptedException e) {
            return "Error executing code: " + e.getMessage();
        }
    }
}

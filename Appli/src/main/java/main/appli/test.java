package main.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


 class test {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("gcc", "--version");
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            process.waitFor();
            System.out.println("GCC Test Output:\n" + output.toString());
        } catch (IOException | InterruptedException e) {
            System.err.println("Erreur lors du test de GCC : " + e.getMessage());
        }
    }
}


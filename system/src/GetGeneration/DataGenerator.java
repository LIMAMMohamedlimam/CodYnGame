package GetGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class DataGenerator {

    public Map<String, String> generateData(String title) {
        String generatorFilePath = getGeneratorFilePath(title);
        String generatorOutput = runPythonGenerator(generatorFilePath);
        return parseGeneratorOutput(generatorOutput);
    }

    private String getGeneratorFilePath(String title) {
        String fileName = title.replaceAll("\\s+", "") + "Gen.py";
        return "DataGenFiles/" + fileName;
    }

    private String runPythonGenerator(String filePath) {
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

    private Map<String, String> parseGeneratorOutput(String generatorOutput) {
        Map<String, String> data = new HashMap<>();
        // Votre logique d'analyse pour extraire les données du générateur de sortie
        return data;
    }
}

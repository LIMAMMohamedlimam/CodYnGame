package GetGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DataGenerator {

    public String generateData(String title) {
        String generatorFilePath = getGeneratorFilePath(title);
        return runPythonGenerator(generatorFilePath);
    }

    public static String getGeneratorFilePath(String title) {
        String fileName = title.replaceAll("\\s+", "") + "Gen.py";
        return "DataGenFiles/" + fileName;
    }

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

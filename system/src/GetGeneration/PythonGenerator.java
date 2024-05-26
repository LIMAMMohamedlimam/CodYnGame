package GetGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonGenerator {

    /**
     * Generates the path to the Python generator file based on the exercise title.
     *
     * @param title The title of the exercise.
     * @return The path to the Python generator file.
     */
    public static String getGeneratorFilePath(String title) {
        // Convert the title to a filename
        String fileName = title.replace(" ", "") + "Gen.py";
        // Full path to the generator file
        return "DataGenFiles/" + fileName;
    }

    /**
     * Executes the Python generator file and captures its output.
     *
     * @param filePath The path to the Python file to execute.
     * @return The output of the Python script.
     */
    public static String runPythonGenerator(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            // Execute the Python script
            Process process = Runtime.getRuntime().exec("python " + filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            // Read the output of the script line by line
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

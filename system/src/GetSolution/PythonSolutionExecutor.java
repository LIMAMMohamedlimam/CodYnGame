package GetSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonSolutionExecutor {

    /**
     * Generates the path to the Python solution file based on the exercise title.
     *
     * @param title The title of the exercise.
     * @return The path to the Python solution file.
     */
    public static String getSolutionFilePath(String title) {
        // Convert the title to a filename
        String fileName = title.replace(" ", "") + ".py";
        // Full path to the solution file
        return "solutionFiles/" + fileName;
    }

    /**
     * Executes the Python solution script with the generated data.
     *
     * @param solutionFilePath The path to the Python solution file.
     * @param generatedData    The generated data to pass to the Python script.
     * @return The output of the Python script.
     */
    public static String executePythonSolution(String solutionFilePath, String generatedData) {
        try {
            // Build the command to execute the Python script with the generated data
            String command = "python " + solutionFilePath + " " + generatedData;

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Capture the output of the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the Python process to complete
            process.waitFor();

            return output.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

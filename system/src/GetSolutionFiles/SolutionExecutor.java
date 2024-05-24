package GetSolutionFiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class SolutionExecutor {

    public String executeSolution(String title, Map<String, String> generatorOutput) {
        String solutionFilePath = "SolutionFiles/" + title.replace(" ", "") + ".py";
        String arguments = buildArguments(generatorOutput);

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python", solutionFilePath, arguments);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            process.waitFor();
            return output.toString().trim();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String buildArguments(Map<String, String> generatorOutput) {
        StringBuilder argsBuilder = new StringBuilder();

        for (String key : generatorOutput.keySet()) {
            String value = generatorOutput.get(key);
            argsBuilder.append(key).append("=").append(value).append(" ");
        }

        return argsBuilder.toString().trim();
    }
}

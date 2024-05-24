package GetGeneration;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PythonGenerator {

    public static String getGeneratorFilePath(String title) {
        return "DataGenFiles/" + title.replaceAll(" ", "") + "Gen.py";
    }

    public static String runPythonGenerator(String filePath) {
        StringBuilder output = new StringBuilder();
        try {
            Process process = Runtime.getRuntime().exec("python SolutionFiles/" + filePath);
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

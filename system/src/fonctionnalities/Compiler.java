package fonctionnalities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Other.Language;
import constants.Commandes;

public abstract class Compiler {

    public static void compile(Language language, String filePath, String outputFilePath) {
        String cmd = Commandes.getCommand(language);
        ProcessBuilder compileBuilder = new ProcessBuilder(cmd, filePath, "-o", outputFilePath);
        try {
            Process compileProcess = compileBuilder.start();
            String compileErrors = readProcessOutput(compileProcess.getErrorStream());
            int compileStatus = compileProcess.waitFor();
            if (compileStatus == 0) {
                // Execute the compiled C code
                ProcessBuilder runBuilder = new ProcessBuilder("./" + outputFilePath);
                Process runProcess = runBuilder.start();
                String output = readProcessOutput(runProcess.getInputStream());
                String errors = readProcessOutput(runProcess.getErrorStream());

                int runStatus = runProcess.waitFor();
                if (runStatus == 0) {
                    System.out.println("Output:\n" + output);
                } else {
                    System.out.println("Error running the program:\n" + errors);
                }
            } else {
                System.out.println("Compilation failed:\n" + compileErrors);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Helper method to read process output
    private static String readProcessOutput(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }
      }



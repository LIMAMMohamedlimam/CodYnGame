package fonctionnalities;
import java.lang.Runtime ;
import static constants.Commandes.getCompileCommand;
import static constants.Commandes.getRunCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import Other.Language;
import constants.Commandes;


public abstract class Compiler {

    public static void compile (Language language , String srcFilePath , String outFilename){
        String compileCmd = getCompileCommand(language, srcFilePath , outFilename);
        String runCmd = getRunCommand(language, outFilename) ;
        

        try {
            Process compileProcess = Runtime.getRuntime().exec(compileCmd) ;
            String compileError = readProcessOutput(compileProcess.getErrorStream()) ;
            int compileStatus = compileProcess.waitFor();
            if (compileStatus != 0){
                System.out.println("CompilationError: " + compileError) ;
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream()) ;
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
                System.out.println("Output: "+ runOutput) ;
            }else{
                System.out.println("runingError: " + runError) ;
            }
        
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void compile(Language language , String filePath) {
        String runCmd = Commandes.getCompileCommandtag(language) + " " + filePath;
        try {
            Process runProcess = Runtime.getRuntime().exec(runCmd);
            String runError = readProcessOutput(runProcess.getErrorStream()) ;
            String runOutput = readProcessOutput(runProcess.getInputStream());
            int runStatus = runProcess.waitFor();
            if (runStatus == 0){
                System.out.println("Output: "+ runOutput) ;
            }else{
                System.out.println("Compilation Error :" + runError) ;
            }
        
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

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



package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {

    public static String readFileContent(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public static void main(String[] args) {

        String filePath = "/home/mohamed/Java_IHM/CodYnGame/solutionFiles/MergedTwoList.py" ;
        try {
            String content = readFileContent(filePath);
            System.out.println("File Content:");
            System.out.println(content);
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}

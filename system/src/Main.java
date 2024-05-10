import java.io.File;

import Other.Language;
import fonctionnalities.Submission;

public class Main {
    public static void main(String[] args) {
        Language c = new Language("c", null);
        Submission sub1 = new Submission(0, 0, c, new File("/home/mohamed/Desktop/test/helloworld.c"));
        sub1.runFile();
    }
}
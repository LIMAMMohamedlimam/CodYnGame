import java.io.File;

import Other.Language;
import fonctionnalities.Submission;

public class Main {
    public static void main(String[] args) {

        // test for compiling and running for c java and python

        System.out.println("c\n");

        Language c = new Language("c", null);
        Submission sub1 = new Submission( c, new File("/home/mohamed/Desktop/test/helloworld.c"));
        sub1.runFile();

        System.out.println("java\n");
        
        Language java = new Language("java", null);
        Submission sub2 = new Submission( java, new File("/home/mohamed/Desktop/test/H.java"));
        sub2.runFile();


        System.out.println("python\n");

        Language python = new Language("python", null);
        Submission sub3 = new Submission( python, new File("/home/mohamed/Desktop/test/helloworld.py"));
        sub3.runFile();
    }
}
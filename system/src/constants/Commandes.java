package constants;

import Other.Language;

public abstract class Commandes {
    public static final String compileC = "gcc";
    public static final String compileJAVA = "javac";
    public static final String compilePYTHON = "python3";

    public static String getCompileCommandtag(Language language) {
        switch (language.getName().toLowerCase()) {
            case "c":
                return compileC ;
            case "java":
                return compileJAVA;
            case "python":
                return compilePYTHON;
            default:
                return null;
        }
    }

    public static String getFiletag(Language language) {
        switch (language.getName().toLowerCase()) {
            case "c":
                return ".c" ;
            case "java":
                return ".java";
            case "python":
                return ".py";
            default:
                return null;
        }
    }


    public static String getCompileCommand(Language language , String filePath ,String outputFilePath) {
        if (language.getName().toLowerCase().equals("c"))
            return compileC + " " + filePath + " -o " + outputFilePath;
        else if (language.getName().toLowerCase().equals("java"))
            return compileJAVA + " " + filePath ;
        return null;
    }


    public static String getCompileCommand (Language language , String filePath) {
        if (language.getName().toLowerCase().equals("java"))
            return compileJAVA + " " + filePath;
        if (language.getName().toLowerCase().equals("python"))
            return compilePYTHON + " " + filePath;
        return null;
    }



    public static String getRunCommand(Language language , String FilePath) {
        if (language.getName().toLowerCase().equals("c"))
            return "./" + FilePath;
        if (language.getName().toLowerCase().equals("java"))
            return "java" + " " + FilePath;
        if (language.getName().toLowerCase().equals("python"))
            return "python3" + " " + FilePath;
        return null;
    }



}

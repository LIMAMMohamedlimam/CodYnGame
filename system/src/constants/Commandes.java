package constants;

import Other.Language;

public abstract class Commandes {
    public static final String compileC = "gcc";
    public static final String compileJAVA = "javac";
    public static final String compilePYTHON = "python3";
    public static final String compileJAVASCRIPT = "node";
    public static final String compilePHP = "php" ;
    public static final String commentTagC = "//";
    public static final String commentTagJAVA = "//";
    public static final String commentTagPYTHON = "#";

    public static String getCompileCommandtag(Language language) {
        switch (language.getName().toLowerCase()) {
            case "c":
                return compileC ;
            case "java":
                return compileJAVA;
            case "python":
                return compilePYTHON;
            case "javascript" :
                return compileJAVASCRIPT ;
            case "php" :
                return compilePHP ;
            default:
                return null;
        }
    }

    public static String getCommentTag(Language language) {
        switch (language.getName().toLowerCase()) {
            case "c":
                return commentTagC ;
            case "java":
                return commentTagJAVA;
            case "python":
                return commentTagPYTHON;
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
            case "php" :
                return ".php" ;
            case "javascript" :
                return ".js" ;
            default:
                return null;
        }
    }


    public static String getCompileCommand(Language language , String filePath ,String outputFilePath) {
        if (language.getName().equalsIgnoreCase("c")) {
            System.out.println(compileC + " " + filePath + " -o " + outputFilePath + " -ljson-c");
            return compileC + " " + filePath + " -o " + outputFilePath+ " -ljson-c";
        }
        else if (language.getName().equalsIgnoreCase("java"))
            return compileJAVA + " " + filePath ;
        return null;
    }


    public static String getCompileCommand (Language language , String filePath) {
        if (language.getName().equalsIgnoreCase("java"))
            return compileJAVA + " " + filePath;
        if (language.getName().equalsIgnoreCase("python"))
            return compilePYTHON + " " + filePath;
        return null;
    }



    public static String getRunCommand(Language language , String FilePath , String argv) {
        if (language.getName().equalsIgnoreCase("c"))
            return "./" + FilePath + " "+argv;
        if (language.getName().equalsIgnoreCase("java"))
            return "java" + " " + FilePath + argv;
        return null;
    }


    public static String getIncludeTag(Language selectedLanguage, String modeIncludeFileName) {
        switch (selectedLanguage.getName().toLowerCase()) {
            case "c":
                return "#include \"" + modeIncludeFileName + "\"";
            case "java":
                return "import com.modeInclude." + modeIncludeFileName.replaceAll(".java", "") + ";";
            case "javascript":
                return "const " + modeIncludeFileName.replaceAll(".js" ,"") + " = require('./" +
                        modeIncludeFileName.replaceAll(".js" ,"") + "');";
            case "python":
                return "import " + modeIncludeFileName.replaceAll(".py" , "");
            case "php":
                return "include '" + modeIncludeFileName + ";";
            default:
                throw new IllegalArgumentException("Unsupported language: " + selectedLanguage.getName());
        }
    }

    public static String getverifFunc(Language lang) {
        switch (lang.getName().toLowerCase()) {
            case "python":
                return "verifysolution(data, solution)";

            case "c":
                return "verifysolution(data, solution);"; // Using snake_case typically used in C

            case "javascript":
                return "verifysolution(data, solution);"; // Using camelCase typically used in JavaScript

            case "php":
                return "verifysolution($data, $solution);"; // Using camelCase typically used in PHP, with $ for variables

            case "java":
                return "verifysolution(data, solution);"; // Using camelCase typically used in Java

            default:
                return null;
        }
    }

}

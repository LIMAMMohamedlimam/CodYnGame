package constants;

import Other.Language;

public abstract class Commandes {
    public static final String C = "gcc";
    public static final String JAVA = "java";
    public static final String PYTHON = "python";

    public static String getCommand(Language language) {
        switch (language.getName().toLowerCase()) {
            case "c":
                return C;
            case "java":
                return JAVA;
            case "python":
                return PYTHON;
            default:
                return null;
        }
    }
    
}

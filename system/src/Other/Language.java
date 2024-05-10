package Other;

public class Language {
    private String name;
    private String defaultCode;

    public Language(String name, String defaultCode) {
        this.name = name;
        this.defaultCode = defaultCode;
    }

    public String getName() {
        return name;
    }

    public String getDefaultCode() {
        return defaultCode;
    }
}

package IDE;

import Other.Language;

public class IDE {
    private String currentCode;
    private Language selectedLanguage;

    public IDE(String currentCode, Language selectedLanguage) {
        this.currentCode = currentCode;
        this.selectedLanguage = selectedLanguage;
    }

    public void editCode() {
        // Edit code logic
    }

    public void compileCode() {
        // Compile code logic
    }
}

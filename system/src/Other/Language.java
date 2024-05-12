package Other;

import constants.Commandes;


public class Language {
    private String name;
    private String defaultCode;
    public Language(String name , Commandes cmd) {
        this.name = name;
        this.defaultCode = "";
    }

    public String getName() {
        return name;
    }






    public String getDefaultCode() {
        return defaultCode;
    }
}

package Other;

import constants.Commandes;


public class Language {
    private String name;
    private String defaultCode;
    public Language(String name) {
        this.name = name;
        this.defaultCode = "";
    }

    public String getName() {
        return name;
    }

    public String getCommentTag(){
        if(this.getName().toLowerCase() == "python"){
            return "#" ;
        }
        return "//" ;
    }



    public String getDefaultCode() {
        return defaultCode;
    }


}



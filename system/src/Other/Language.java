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
        if(this.getName().equalsIgnoreCase("python")){
            return "#" ;
        }
        return "//" ;
    }

    public String getRunTag(){
        if(this.getName().equalsIgnoreCase("c"))
            return "./ ";
        else if (this.getName().equalsIgnoreCase("java")) {
            return "java " ;
        }
        return Commandes.getCompileCommandtag(this)+" " ;
    }



    public String getDefaultCode() {
        return defaultCode;
    }


}



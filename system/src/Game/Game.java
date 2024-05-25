package Game;

import Other.Language;
import Problems.Problem;
import utilisateur.User;

public class Game {

    private Problem selectedProblem;
    private Language selectedLanguage;
    private String selectedMode;
    private User selectedUser;
    private String defaultCode;

    public Game(Problem selectedProblem, Language selectedLanguage, String selectedMode, User selectedUser) {
        this.selectedProblem = selectedProblem;
        this.selectedLanguage = selectedLanguage;
        this.selectedMode = selectedMode;
        this.selectedUser = selectedUser;
    }

    public Problem getSelectedProblem() {
        return selectedProblem;
    }

    public Language getSelectedLanguage() {
        return selectedLanguage;
    }

    public String getSelectedMode() {
        return selectedMode;
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedProblem(Problem selectedProblem) {
        this.selectedProblem = selectedProblem;
    }

    public void setSelectedLanguage(Language selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }

    public String setDefaultCode() {
        if (this.selectedMode.equals("Mode Include")) {
            this.defaultCode = this.selectedLanguage.getCommentTag() + " Create a function named '"
                    + this.selectedProblem.getTitle().replaceAll(" ", "").replaceAll("\n" , "")
                    + "(args)' with arguments 'args'\n";
        } else if (this.selectedMode.equals("Mode Input Output")) {
            // add logic later boyyy!!!
        }
        return null ;
    }

    public String getDefaultCode() {
        return defaultCode;
    }

}


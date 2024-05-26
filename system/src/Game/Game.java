package Game;

import Other.Language;
import Problems.Problem;
import constants.Commandes;
import database.DatabaseManager;
import utilisateur.User;

import java.sql.SQLException;
import java.util.List;

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

    public String setDefaultCode()  {
        if (this.selectedMode.equals("Mode Include")) {
            this.defaultCode = this.selectedLanguage.getCommentTag() + " Create a function named '"
                    + this.selectedProblem.getTitle().replaceAll(" ", "").replaceAll("\n" , "")
                    + "(args)' with arguments 'args'\n" + Commandes.getIncludeTag(selectedLanguage ,
                    getModeIncludeFileName()) + "\n"+this.selectedLanguage.getCommentTag()+"write your code here" +
                    "\n\n\n"+"\n"+ Commandes.getverifFunc(selectedLanguage)  ;
        } else if (this.selectedMode.equals("Mode Input Output")) {
            this.defaultCode = setDefaultCodeInputOutput(); ;
        }
        return null ;
    }



    public String getDefaultCode() {
        return defaultCode;
    }

    public String setDefaultCodeInputOutput(){
        String query = "select code from default_code where problem_id="+"'"+selectedProblem.getId() +
                "'" +" and language = '"+ selectedLanguage.getName().toLowerCase() +"' ;" ;

        DatabaseManager dbManager = new DatabaseManager();

        System.out.println(query);
        List<String> defaultCodes = dbManager.executeQuery(query, resultSet -> {
            try {
                return resultSet.getString("code");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
        if (defaultCodes != null && !defaultCodes.isEmpty()) {
            return defaultCodes.get(0); // Assuming titles are unique, return the first match.
        } else {
            System.out.println("no default code for : " + this.getSelectedProblem().getTitle());
        }
        return null ;
    }

    public String getModeIncludeFileName()  {
        String query = "select filepath from modeInclude where probId=" + this.getSelectedProblem().getId() +
                " and language = " + "'"+selectedLanguage.getName().toLowerCase() + "'";
        DatabaseManager dbManager = new DatabaseManager();

        System.out.println(query);
        List<String> filepaths = dbManager.executeQuery(query, resultSet -> {
            try {
                return resultSet.getString("filepath");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });

        if (filepaths != null && !filepaths.isEmpty()) {
            return filepaths.get(0); // Assuming titles are unique, return the first match.
        } else {
            System.out.println("mode include file non trouver : " + this.getSelectedProblem().getTitle());
        }
        return null ;
    }





}


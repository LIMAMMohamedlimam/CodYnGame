package Game;

import Other.Language;
import Problems.Problem;
import constants.Commandes;
import database.DatabaseManager;
import test.FileReaderUtil;
import utilisateur.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static fonctionnalities.Compiler.readFileContent;

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
            //this.defaultCode = this.selectedLanguage.getCommentTag() + " Create a function named '"
            //        + this.selectedProblem.getTitle().replaceAll(" ", "").replaceAll("\n" , "")
            //        + "(args)' with arguments 'args'\n" + Commandes.getIncludeTag(selectedLanguage ,
            //        getModeIncludeFileName()) + "\n"+this.selectedLanguage.getCommentTag()+"write your code here" +
            //        "\n\n\n"+"\n"+ Commandes.getverifFunc(selectedLanguage)  ;
            this.defaultCode = setDefaultCodeModeInclude() ;
        } else if (this.selectedMode.equals("Mode Input Output")) {
            try{
                this.defaultCode = setDefaultCodeInputOutput();
                ;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return null ;
    }



    public String getDefaultCode() {
        return defaultCode;
    }

    public String setDefaultCodeInputOutput() throws IOException {
        String filePath = System.getProperty("user.dir") + "/DefaultCodeInputOutput/" +
                this.getSelectedProblem().getId() +Commandes.getFiletag(this.getSelectedLanguage()) ;
        return readFileContent(filePath) ;
    }
    public String setDefaultCodeModeInclude(){
        String filePath = System.getProperty("user.dir") + "/DefaultCodeInputOutput/" +
                this.getSelectedProblem().getId() +Commandes.getFiletag(this.getSelectedLanguage()) ;
        return extractFunctionName(filePath , Commandes.getFunctionIdentifier(this.getSelectedLanguage())) ;
    }

    public String getSolution() throws IOException{
        String filePath = System.getProperty("user.dir") + "/solutionFiles/"+
                selectedProblem.getTitle().trim().replaceAll(" ","") + Commandes.getFiletag(selectedLanguage) ;
        return readFileContent(filePath) ;
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


    public static String extractFunctionName(String filePath, String searchString) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(searchString)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}


package Problems;

import Game.Game;
import Other.Language;
import database.DatabaseManager;
import fonctionnalities.Compiler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe représentant un problème avec ses détails.
 */
public class Problem {
    private  int id;
    private  String title;
    private  String description;
    private  ProblemDifficulty difficultyLevel;
    private  String solutionFile;

    private String data ;
    private String modeIncludeFile;


    public Problem(String title){
        this.title = title ;
    }

    public String getData() {
        return data;
    }

    public void setData() {
        this.data = Compiler.Run(new Language("python") , this.solutionFile + " gen") ;
    }

    /**
     * Constructeur de la classe Problem.
     *
     * @param id L'identifiant unique du problème.
     * @param title Le titre du problème.
     * @param description La description du problème.
     * @param solutionFile Le chemin du fichier de la solution.
     * @param difficultyLevel Le niveau de difficulté du problème.
     */
    public Problem(int id, String title, String description, String solutionFile, ProblemDifficulty difficultyLevel , String defaultCode) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.solutionFile = solutionFile;
        this.difficultyLevel = difficultyLevel;
        setData() ;
    }


    /**
     * Obtient l'identifiant du problème.
     *
     * @return L'identifiant du problème.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtient le titre du problème.
     *
     * @return Le titre du problème.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Obtient la description du problème.
     *
     * @return La description du problème.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Obtient le niveau de difficulté du problème.
     *
     * @return Le niveau de difficulté du problème.
     */
    public ProblemDifficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    /**
     * Obtient le chemin du fichier de solution.
     *
     * @return  Le chemin du fichier de solution.
     */
    public String getSolutionFile() {
        return solutionFile;
    }

    /**
     * Crée une instance de Problem à partir d'un ResultSet.
     *
     * @param resultSet Le ResultSet à partir duquel extraire les données.
     * @return Une nouvelle instance de Problem ou null en cas d'erreur.
     */
    public static Problem fromResultSet(ResultSet resultSet) {
        try {
            int id = resultSet.getInt("ID");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String solutionFile = resultSet.getString("solutionFile");
            ProblemDifficulty difficultyLevel = ProblemDifficulty.fromString(resultSet.getString("difficulty"));
            String defaultCode = resultSet.getString("defaultCode") ;
            return new Problem(id, title, description, solutionFile, difficultyLevel , defaultCode);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}

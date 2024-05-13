package Problems;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe représentant un problème avec ses détails.
 */
public class Problem {
    private final int id;
    private final String title;
    private final String description;
    private final ProblemDifficulty difficultyLevel;
    private final String solutionFile;

    /**
     * Constructeur de la classe Problem.
     *
     * @param id L'identifiant unique du problème.
     * @param title Le titre du problème.
     * @param description La description du problème.
     * @param solutionFile Le chemin du fichier de la solution.
     * @param difficultyLevel Le niveau de difficulté du problème.
     */
    public Problem(int id, String title, String description, String solutionFile, ProblemDifficulty difficultyLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.solutionFile = solutionFile;
        this.difficultyLevel = difficultyLevel;
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
            return new Problem(id, title, description, solutionFile, difficultyLevel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

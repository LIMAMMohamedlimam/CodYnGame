package Problems;
import database.DatabaseManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Classe abstraite représentant le gestionnaire de problèmes.
 */
public abstract class ProblemManager {

    /**
     * Récupère la liste des problèmes depuis la base de données.
     *
     * @param db_manager Le gestionnaire de la base de données utilisé pour exécuter les requêtes.
     * @return Une liste des problèmes disponibles dans la base de données.
     * @throws NullPointerException Si db_manager est null.
     */
    public static List<Problem> getProblemList(@NotNull DatabaseManager db_manager) {
        // Définit la requête SQL pour sélectionner les problèmes.
        String query = "select id, title, description, solutionFile, difficulty from Problem";

        // Exécute la requête et transforme le ResultSet en objets Problem.

        // Retourne la liste des problèmes obtenus.
        return db_manager.executeQuery(query, Problem::fromResultSet);
    }

    /**
     * méthode pour récuperer les titres de la base de données et utilisé dans PremiereScene.java
     *
     * @return les titres des different problem dans la base de données
     */

    public static List<String> retrieveTitles() {
        String query = "SELECT title FROM Problem";
        DatabaseManager dbManager = new DatabaseManager();
        return dbManager.executeQuery(query, resultSet -> {
            try {
                return resultSet.getString("title");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });

    }

    public static List<String> retrieveTitlesWithDifficulty() {
        List<String> titles = ProblemManager.retrieveTitles();
        List<String> titlesWithDifficulty = new ArrayList<>();

        for (String title : titles) {
            try {
                String difficulty = ProblemManager.retrieveDifficultyLevel(title);
                titlesWithDifficulty.add(title + " (" + difficulty + ")");
            } catch (SQLException e) {
                e.printStackTrace();
                titlesWithDifficulty.add(title + " (UNKNOWN)");
            }
        }

        return titlesWithDifficulty;
    }

    public static @Nullable Problem getProblem(String title){
        DatabaseManager dbManager = new DatabaseManager();
        String query = "select id, title, description, solutionFile, difficulty " +
                "from Problem " +
                "WHERE title = '" + title + "';" ;
        try {
            List<Problem> results = dbManager.executeQuery(query, Problem::fromResultSet);
            if (results.isEmpty()) {
                return null;
            }
            return results.get(0); // Get the first element from the list
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String retrieveDifficultyLevel(String title) throws SQLException {
        String query = "SELECT difficulty FROM Problem WHERE title = ?";
        DatabaseManager dbManager = new DatabaseManager();

        List<String> difficultyLevels = dbManager.executeQuery(query, stmt -> {
            try {
                stmt.setString(1, title);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, resultSet -> {
            try {
                return resultSet.getString("difficulty");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });

        if (difficultyLevels != null && !difficultyLevels.isEmpty()) {
            return difficultyLevels.get(0); // Assuming titles are unique, return the first match.
        } else {
            throw new SQLException("Exercice non trouvé pour le titre donné : " + title);
        }
    }

    public static String retrieveDescription(String title) {
        String query = "SELECT description FROM Problem WHERE title = ?";
        DatabaseManager dbManager = new DatabaseManager();
        List<String> descriptions = dbManager.executeQuery(query, stmt -> {
            try {
                stmt.setString(1, title);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, resultSet -> {
            try {
                return resultSet.getString("description");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });

        if (descriptions != null && !descriptions.isEmpty()) {
            return descriptions.get(0); // Assuming titles are unique, return the first match.
        } else {
            return null;
        }
    }
}

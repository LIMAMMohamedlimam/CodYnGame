package Problems;
import database.DatabaseManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import static Problems.Problem.fromResultSet;

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
     * @return
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
}

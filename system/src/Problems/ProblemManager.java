

package Problems;


import database.DatabaseManager;
import org.jetbrains.annotations.NotNull;
import java.util.List;

/**
 * Classe abstraite représentant le gestionnaire de problèmes.
 */
public abstract class ProblemManager {

    /**
     * Récupère la liste des problèmes depuis la base de données.
     * @param db_manager Le gestionnaire de la base de données utilisé pour exécuter les requêtes.
     * @return Une liste des problèmes disponibles dans la base de données.
     * @throws NullPointerException Si db_manager est null.
     */
    public static  List<Problem> getProblemList(@NotNull DatabaseManager db_manager) {
        // Définit la requête SQL pour sélectionner les problèmes.
        String query = "select id, title, description, solutionFile, difficulty from Problem";

        // Exécute la requête et transforme le ResultSet en objets Problem.

        // Retourne la liste des problèmes obtenus.
        return db_manager.executeQuery(query , Problem::fromResultSet);
    }
}

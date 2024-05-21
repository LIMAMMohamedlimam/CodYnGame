package Problems;

import database.DatabaseManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Classe abstraite représentant le gestionnaire de problèmes.
 */
//public abstract class ProblemManager {

    /**
     * Récupère la liste des problèmes depuis la base de données.
     *
     * @param dbManager Le gestionnaire de la base de données utilisé pour exécuter les requêtes.
     * @return Une liste des problèmes disponibles dans la base de données.
     * @throws NullPointerException Si dbManager est null.
     */
    //public static List<Problem> getProblemList(@NotNull DatabaseManager dbManager) {
        // Définit la requête SQL pour sélectionner les problèmes.
        //String query = "SELECT id, title, description, difficultyLevel,solutionFile,  FROM exercises";

        // Exécute la requête et transforme le ResultSet en objets Problem.




        //return dbManager.executeQuery1(query, resultSet -> {
          //  try {
            //    return new Problem(
              //          resultSet.getInt("id"),
                //        resultSet.getString("title"),
                  //      resultSet.getString("description"),
                    //    resultSet.getString("difficultyLevel"),
                      //  resultSet.getString("solutionFile")

              //  );
          //  } catch (Exception e) {
            //    e.printStackTrace();
              //  return null;
   //         }
     //   });
   // }
//}
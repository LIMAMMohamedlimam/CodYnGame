package Problems;
import database.DatabaseManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Abstract class representing the problem manager.
 */
public abstract class ProblemManager {

    /**
     * Retrieves the list of problems from the database.
     *
     * @param db_manager The database manager used to execute queries.
     * @return A list of problems available in the database.
     * @throws NullPointerException If db_manager is null.
     */
    public static List<Problem> getProblemList(@NotNull DatabaseManager db_manager) {
        // Define the SQL query to select problems.
        String query = "select id, title, description, solutionFile, difficulty from Problem";

        // Execute the query and transform the ResultSet into Problem objects.

        // Return the obtained list of problems.
        return db_manager.executeQuery(query, Problem::fromResultSet);
    }

    /**
     * Method to retrieve titles from the database and used in PremiereScene.java
     *
     * @return The titles of different problems in the database.
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

    public static @Nullable Problem getProblem(String title) {
        DatabaseManager dbManager = new DatabaseManager();
        String query = "select id, title, description, solutionFile, difficulty " +
                "from Problem " +
                "WHERE title = '" + title + "';";
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
            throw new SQLException("Exercise not found for the given title: " + title);
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

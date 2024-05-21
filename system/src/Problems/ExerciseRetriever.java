package Problems;

import database.DatabaseManager;
import java.sql.SQLException;
import java.util.List;

public class ExerciseRetriever {

    public static List<String> retrieveTitles() {
        String query = "SELECT title FROM exercises";
        DatabaseManager dbManager = new DatabaseManager();
        return dbManager.executeQuery(query, stmt -> {}, resultSet -> {
            try {
                return resultSet.getString("title");
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    public static String retrieveDescription(String title) {
        String query = "SELECT description FROM exercises WHERE title = ?";
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

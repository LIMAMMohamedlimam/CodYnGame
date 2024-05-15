package utilisateur;

import database.DatabaseManager;
import java.sql.*;
import java.util.UUID;



public class UserManager {

    DatabaseManager db = new DatabaseManager();


    public void createUser(User user) {
        String query = "INSERT INTO Utilisateur (id,username,password,email) VALUES (?, ?, ?, ?);";
        try (Connection conn = db.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(user.getUserId()));
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Utilisateur crée avec succès.");
            } else {
                System.out.println("La création de l'utilisateur a échoué.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticateUser(String username, String password) {
        String sql = "SELECT password FROM Utilisateur WHERE username = ?;";
        try (Connection conn = db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String Password = rs.getString("password");
                return Password.equals(password);
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void getUserDetails(String username) {
        String sql = "SELECT * FROM Utilisateur WHERE username = ?;";
        try (Connection conn = db.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Informations Utilisateur:");
                System.out.println("Id: " + rs.getString("id"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("Aucun utilisateur trouvé avec : " + username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}







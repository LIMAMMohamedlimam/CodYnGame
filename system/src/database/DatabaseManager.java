package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Gère la connexion et les interactions avec la base de données.
 */
public class DatabaseManager {

    // URL de la base de données
    private static String url = "jdbc:mysql://localhost:3306/codyngame";
    // Nom d'utilisateur pour se connecter à la base de données
    private static String username = "java";
    // Mot de passe pour se connecter à la base de données
    private static String password = "12345678";

    /**
     * Constructeur par défaut de DatabaseManager.
     */
    public DatabaseManager() {
    }

    /**
     * Constructeur de DatabaseManager avec configuration de la connexion.
     *
     * @param url       L'URL de la base de données
     * @param username  Le nom d'utilisateur de la base de données
     * @param password  Le mot de passe de la base de données
     */
    public DatabaseManager(String url, String username, String password) {
        this.url = url;
        this.password = password;
        this.username = username;
    }

    /**
     * Établit une connexion avec la base de données.
     *
     * @return L'objet Connection pour interagir avec la base de données.
     */
    public Connection connect() {
        System.out.println("connecting to database ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Ferme la connexion à la base de données.
     *
     * @param db_connection L'objet Connection à fermer.
     */
    public void disconnect(Connection db_connection) {
        System.out.println("disconnecting from the database ...");
        try {
            db_connection.close();
            System.out.println("disconnected from the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Exécute une requête SQL et retourne un ResultSet.
     *
     * @param query La requête SQL à exécuter.
     * @return Le ResultSet obtenu après l'exécution de la requête.
     */
    public ResultSet executeQuery(String query) {
        Connection con = this.connect();
        if (con == null || query == null)
            throw new NullPointerException();
        try (Statement stmt = con.createStatement()) {
            ResultSet Res = stmt.executeQuery(query);
            return Res;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Exécute une requête SQL et transforme chaque entrée du ResultSet en utilisant une fonction mapper.
     *
     * @param query La requête SQL à exécuter.
     * @param mapper Une fonction qui prend un ResultSet et retourne un objet de type T.
     * @return Une liste d'objets de type T, chaque objet correspondant à une entrée du ResultSet.
     */
    public <T> List<T> executeQuery(String query, Function<ResultSet, T> mapper) {
        if (query == null)
            throw new NullPointerException();
        List<T> res = new ArrayList<>();
        try (Statement stmt = this.connect().createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                res.add(mapper.apply(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}

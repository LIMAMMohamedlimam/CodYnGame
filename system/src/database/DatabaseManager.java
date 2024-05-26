package database;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
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
     * should be used to set up the database from the codyngame.sql file
     */
    public static boolean setDataBase(String CodYngamedatabasefile){
        return false ;
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

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            return  DriverManager.getConnection(url, username, password);
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
//        System.out.println("disconnecting from the database ...");
        try {
            db_connection.close();
//            System.out.println("disconnected from the database.");
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
    public  ResultSet executeQuery(String query) {
        Connection con = this.connect();
        if(con == null){
            if(startMySQLServer()){
                con = this.connect() ;
            }
        }
        if (query == null)
            throw new NullPointerException();
        try (Statement stmt = con.createStatement()) {
            return stmt.executeQuery(query);

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


    public  <T> List<T> executeQuery(String query, Consumer<PreparedStatement> parameterSetter, Function<ResultSet, T> mapper) {
        if (query == null)
            throw new NullPointerException();
        List<T> res = new ArrayList<>();
        try (Connection conn = this.connect();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            parameterSetter.accept(stmt);
            try (ResultSet resultSet = stmt.executeQuery()) {
                while (resultSet.next()) {
                    res.add(mapper.apply(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static boolean startMySQLServer() {
        String command;

        // Adjust the command according to your OS
        if (System.getProperty("os.name").startsWith("Windows")) {
            command = "net start MySQL";
        } else {
            command = "sudo service mysql start";
        }

        try {
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            return process.exitValue() == 0;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

}

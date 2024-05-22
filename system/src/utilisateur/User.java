package utilisateur;

import database.DatabaseManager;

import java.sql.*;

public class User {
    private int userId ;
    private String username;
    private String password;
    private String email;
    private DatabaseManager db = new DatabaseManager();


    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
    public String getUsername(){
        return username;
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    }

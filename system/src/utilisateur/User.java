package utilisateur;

public class User {
    private int userId;
    private String username;
    private String password;
    private String email;

    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void login() {
        // Login logic
    }

    public void logout() {
        // Logout logic
    }
}

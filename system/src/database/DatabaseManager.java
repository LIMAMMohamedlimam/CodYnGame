package database;

import java.sql.*;

public class DatabaseManager  {

    private static String url = "jdbc:mysql://localhost:3306/codyngame" ;
    private  static String username = "java" ;
    private static  String password = "12345678" ;


    public DatabaseManager (){
    }
    public DatabaseManager(String url , String username , String password){
        this.url = url ;
        this.password = password ;
        this.username = username ;
    }

    public Connection connect() {
        System.out.println("connecting to database ...");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("connected");
            return connection ;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null ;
    }

    public void disconnect(Connection db_connection) {
        // Disconnect from the database
        System.out.println("disconnecting from the database ...");
        try{
            db_connection.close();
            System.out.println("disconnected from the database.") ;
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Connection con = this.connect() ;
        if (con == null || query == null)
            throw new NullPointerException();
        // Execute a database query
        try(Statement stmt = con.createStatement()){
            ResultSet Res = stmt.executeQuery(query);
            return Res ;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null ;
    }
}

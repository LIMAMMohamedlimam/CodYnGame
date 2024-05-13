import Problems.Problem;
import Problems.ProblemManager;
import database.DatabaseManager;

import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // test for compiling and running for c java and python

    //    System.out.println("c\n");
//
    //    Language c = new Language("c", null);
    //    Submission sub1 = new Submission( c, new File("/home/mohamed/Desktop/test/helloworld.c"));
    //    sub1.runFile();
//
    //    System.out.println("java\n");
    //
    //    Language java = new Language("java", null);
    //    Submission sub2 = new Submission( java, new File("/home/mohamed/Desktop/test/H.java"));
    //    sub2.runFile();
//
//
    //    System.out.println("python\n");
//
    //    Language python = new Language("python", null);
    //    Submission sub3 = new Submission( python, new File("/home/mohamed/Desktop/test/helloworld.py"));
    //    sub3.runFile();



    //    String query = "select ID, TITLE, DESCRIPTION, solutionFile from Problem ";
    //    DatabaseManager codyngamedb_manager = new DatabaseManager();
    //    Connection connection = codyngamedb_manager.connect();
    //    ResultSet Res = codyngamedb_manager.executeQuery(query);
    //    try{
    //        System.out.println(Res.next());
    //    }catch (Exception e){
    //        e.printStackTrace();
    //    }

        //try{
        //    ResultSet Res = codyngamedb_manager.executeQuery(connection,query);
        //        while(Res.next()){
        //            int id = Res.getInt("ID");
        //            String title = Res.getString("TITLE");
        //            String description = Res.getString("DESCRIPTION");
        //            String SOLPath = Res.getString("solutionFile");
        //            System.out.println(id);
        //            System.out.println(title);
        //            System.out.println(description);
        //            System.out.println(SOLPath);
        //    }
        //}catch(SQLException e){
        //    e.printStackTrace();
        //}

        //codyngamedb_manager.disconnect(connection);



        DatabaseManager codyngame_manager = new DatabaseManager();
        List<Problem> problemList = ProblemManager.getProblemList(codyngame_manager);
        for (Problem prob : problemList){
            System.out.println(prob.getId());
            System.out.println(prob.getTitle());
            System.out.println(prob.getDescription());
            System.out.println(prob.getDifficultyLevel());
        }




    }
}
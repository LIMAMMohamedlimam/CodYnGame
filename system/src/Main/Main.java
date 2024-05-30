package Main;

import Game.Game;
import Other.Language;
import Problems.Problem;
import fonctionnalities.Compiler;
import fonctionnalities.Submission;
import javafx.application.Application;
import ui.PremiereScene;
import utilisateur.User;

import static Problems.ProblemManager.getProblem;


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








        //List<String> commands = List.of("gcc -o /home/mohamed/Desktop/test/output /home/mohamed/Desktop/test/helloworld.c",
        //        "cd /home/mohamed/Desktop/test",
        //        "./output");
        //Compiler.executeCommands(commands);

        //System.out.println("test getProblem");
        //Problem prob = ProblemManager.getProblem("Two Sum") ;
        //if (prob != null){
        //    System.out.println(prob.getId());
        //    System.out.println(prob.getTitle());
        //    System.out.println(prob.getDescription());
        //    System.out.println(prob.getDifficultyLevel());
        //}else
        //    System.out.println("non result");

             // Paramètres de connexion
              //  Random random = new Random();
               // int id = random.nextInt(1000000);
               // UserManager um = new UserManager();
               // User user = new User(id,"rayane","saighi","rayane.saighi123@gmail.com");
               // um.getUserDetails("rayane");
        //Application.launch(PremiereScene.class, args);
        String projectPath = System.getProperty("user.dir");

        // Print the project root path
        System.out.println("Project Path: " + projectPath);


        // testing the datageneration
        //Problem p = getProblem("Calculate the multiplication and sum of two numbers") ;
        //String data = p.getData() ;
        //System.out.println(data);
        //System.out.println(p.getDefaultCode());


        Game test=  new Game(getProblem(9) , new Language("php"),
                "Mode Input Output" ,new User("User1")) ;
        System.out.println(test.getSelectedProblem().getTitle());
        test.setDefaultCode() ;
        //System.out.println(test.getDefaultCode());
        //System.out.println(test.getDefaultCode() );
        String code =  "<?php\n" +
                "\n" +
                "function merge_two_sorted_lists($l1, $l2) {\n" +
                "    $merged_list = [];\n" +
                "    $i = $j = 0;\n" +
                "\n" +
                "    // Traverse both lists and append the smaller element to the merged list\n" +
                "    while ($i < count($l1) && $j < count($l2)) {\n" +
                "        if ($l1[$i] <= $l2[$j]) {\n" +
                "            $merged_list[] = $l1[$i];\n" +
                "            $i++;\n" +
                "        } else {\n" +
                "            $merged_list[] = $l2[$j];\n" +
                "            $j++;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    // Append remaining elements, if any\n" +
                "    while ($i < count($l1)) {\n" +
                "        $merged_list[] = $l1[$i];\n" +
                "        $i++;\n" +
                "    }\n" +
                "\n" +
                "    while ($j < count($l2)) {\n" +
                "        $merged_list[] = $l2[$j];\n" +
                "        $j++;\n" +
                "    }\n" +
                "\n" +
                "    return $merged_list;\n" +
                "}\n" +
                "\n" +
                "function main() {\n" +
                "    // Assuming the input is passed as the first command line argument\n" +
                "    global $argv;\n" +
                "    $input_json = $argv[1];\n" +
                "\n" +
                "    // Parse the JSON input\n" +
                "    $data = json_decode($input_json, true);\n" +
                "    $l1 = isset($data['list1']) ? $data['list1'] : [];\n" +
                "    $l2 = isset($data['list2']) ? $data['list2'] : [];\n" +
                "\n" +
                "    // Merge the two sorted lists\n" +
                "    $merged_list = merge_two_sorted_lists($l1, $l2);\n" +
                "\n" +
                "    // Prepare the result in the desired format\n" +
                "    $result = [\"result\" => $merged_list];\n" +
                "\n" +
                "    // Print the result as a JSON string\n" +
                "    $output_json = json_encode($result);\n" +
                "    echo $output_json;\n" +
                "}\n" +
                "\n" +
                "main();\n" +
                "\n" +
                "?>\n" ;
        String output = null ;
        try{
             output = (new Submission(test, code)).verifySolution() ;
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(output);




    }
}

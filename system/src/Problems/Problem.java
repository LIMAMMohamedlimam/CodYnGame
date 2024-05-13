package Problems;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Problem {
    private int id;
    private String title;
    private String description;
    private ProblemDifficulty difficultyLevel;
    private String solutionFile;

    public Problem(int id, String title, String description, String solutionFile, ProblemDifficulty difficultyLevel) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.solutionFile = solutionFile;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ProblemDifficulty getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getSolutionFile() {
        return solutionFile;
    }

    public void displayProblem() {
        // Display problem logic
    }



    public void fetchProblem() {
        // Fetch problem logic
    }

    public static Problem fromResultSet(ResultSet resultSet)  {
        try{
            int id = resultSet.getInt("ID");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String solutionFile = resultSet.getString("solutionFile");
            ProblemDifficulty difficultyLevel = ProblemDifficulty.fromString(resultSet.getString("difficulty"));
            return new Problem(id,title,description,solutionFile,difficultyLevel);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}

package Problems;

public class Problem {
    private int id;
    private String title;
    private String description;
    private ProblemDifficulty difficultyLevel;
    private String solutionFile;

    public Problem(int id, String title, String description, ProblemDifficulty difficultyLevel, String solutionFile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.solutionFile = solutionFile;
    }

    public void displayProblem() {
        // Display problem logic
    }



    public void fetchProblem() {
        // Fetch problem logic
    }
}

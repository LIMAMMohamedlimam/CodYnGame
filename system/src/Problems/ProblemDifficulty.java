package Problems;

public enum ProblemDifficulty {
    EASY,
    MEDIUM,
    HARD ;

    public static ProblemDifficulty fromString(String difstr) {
        return ProblemDifficulty.valueOf(difstr.toUpperCase());
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}

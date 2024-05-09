package fonctionnalities;

import Other.Language;

public class Submission {
    private int submissionId;
    private int userId;
    private Language language;

    public Submission(int submissionId, int userId, Language language) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.language = language;
    }

    public void submit() {
        // Submit logic
    }

    public void fetchSubmissionDetails() {
        // Fetch submission details logic
    }
}

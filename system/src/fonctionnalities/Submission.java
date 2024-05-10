package fonctionnalities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import Other.Language;

public class Submission {
    private int submissionId;
    private int userId;
    private Language language;
    private File file;



    public Submission(int submissionId, int userId, Language language , File file) {
        this.submissionId = submissionId;
        this.userId = userId;
        this.language = language;  
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void submit() {
        // Submit logic
    }

    public void fetchSubmissionDetails() {
        // Fetch submission details logic
    }

    public void runFile() {
        Compiler.compile(this.language, this.file.getPath(), "submission"+this.submissionId+".out");
    }

}

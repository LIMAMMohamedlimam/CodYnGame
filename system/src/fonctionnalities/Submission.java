package fonctionnalities;

import java.io.File;
import Other.Language;

public class Submission {
    private int submissionId;
    private int userId;
    private Language language;
    private File file;


    public Submission(Language language ,File file){
        this.file = file ;
        this.language =  language ;
    }

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
        if(this.language.getName().toLowerCase() == "python")
            Compiler.compile(this.language, this.file.getPath());
        else if (this.language.getName().toLowerCase() == "c"){
            Compiler.compile(this.language, this.file.getPath(),  "output.out");
        }
        else if(this.language.getName().toLowerCase() == "java"){
            String classpath = this.file.getPath().replace( this.file.getName() , "") ;
            String program = this.file.getName().replace(".java" , " ") ;

            Compiler.compile(language, this.file.getPath(), "-classpath" + " " + classpath + " " + program );
        }
    }

}

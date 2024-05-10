package constants;

public class Files {
  private String name;
  private String absolutePath;



  public Files(String name, String absolutePath) {
    this.name = name;
    this.absolutePath = absolutePath;
    
  }
  public String getName() {
    return name;
  }
  public String getAbsolutePath() {
    return absolutePath;
  }


}

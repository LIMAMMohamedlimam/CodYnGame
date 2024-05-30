public class 3 {

  public static String calculateResult(String jsonInput) {
      // Simple parsing of the input JSON string
      int number1 = Integer.parseInt(jsonInput.split("\"number1\":")[1].split(",")[0].trim());
      int number2 = Integer.parseInt(jsonInput.split("\"number2\":")[1].split("}")[0].trim());

      int product = number1 * number2;
      int result;

      //write your code here 

      // Creating the output JSON string
      String output = "{\"result\": " + result + "}";

      return output;
  }

  public static void main(String[] args) {
      // Assuming the JSON string is passed as the first argument
      String jsonInput = args[0];
      String output = calculateResult(jsonInput);
      System.out.println(output);
  }
}

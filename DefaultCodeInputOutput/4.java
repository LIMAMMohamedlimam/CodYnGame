public class 4 {

  public static int reverseInteger(int x) {
    //Write your code here
  }

  public static void main(String[] args) {
      if (args.length != 1) {
          System.out.println("Usage: java ReverseInteger '{\"x\": 123}'");
          return;
      }

      // Read the input JSON string from the program arguments
      String inputJson = args[0];

      // Parse the JSON string to get the integer
      int x = parseJson(inputJson);

      // Get the reversed integer
      int result = reverseInteger(x);

      // Prepare the output as a JSON string
      String outputJson = "{\"result\": " + result + "}";

      // Print the output JSON string
      System.out.println(outputJson);
  }

  private static int parseJson(String json) {
      // Find the index of the colon to locate the start of the number
      int colonIndex = json.indexOf(':');
      // Find the index of the closing curly brace
      int endIndex = json.indexOf('}', colonIndex);

      // Extract the substring representing the number and trim any whitespace
      String numberStr = json.substring(colonIndex + 1, endIndex).trim();

      // Convert the substring to an integer
      return Integer.parseInt(numberStr);
  }

  
}

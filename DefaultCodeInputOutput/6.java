public class 6 {

  public static int romanToInt(String s) {
      //Write your code here
  }

  public static void main(String[] args) {
      if (args.length != 1) {
          System.out.println("Usage: java RomanToIntConverter '<json_string>'");
          return;
      }

      String inputJson = args[0];
      try {
          String romanNumeral = parseJsonString(inputJson, "roman");
          if (romanNumeral == null || romanNumeral.isEmpty()) {
              System.out.println("{\"error\": \"No roman numeral found\"}");
              return;
          }

          int integerValue = romanToInt(romanNumeral);
          String result = "{\"result\": " + integerValue + "}";
          System.out.println(result);
      } catch (Exception e) {
          System.out.println("{\"error\": \"Invalid JSON input\"}");
      }
  }

  private static String parseJsonString(String json, String key) {
      String keyPattern = "\"" + key + "\":";
      int keyIndex = json.indexOf(keyPattern);
      if (keyIndex == -1) {
          return null;
      }

      int startIndex = json.indexOf("\"", keyIndex + keyPattern.length()) + 1;
      int endIndex = json.indexOf("\"", startIndex);
      if (startIndex == -1 || endIndex == -1) {
          return null;
      }

      return json.substring(startIndex, endIndex);
  }
}

public class 10 {

  public static String longestCommonPrefix(String[] strs) {
    //Write your code here
  }

  public static void main(String[] args) {
      if (args.length < 1) {
          System.out.println("{\"error\": \"No input provided\"}");
          return;
      }

      String input = args[0];
      if (!input.startsWith("{\"strs\":[") || !input.endsWith("]}")) {
          System.out.println("{\"error\": \"Invalid input format\"}");
          return;
      }

      input = input.substring(9, input.length() - 2);  // Remove {"strs":[ and ]}
      String[] strs = input.split("\",\"");

      if (strs.length > 0) {
          strs[0] = strs[0].substring(1);  // Remove the starting quote from the first string
          strs[strs.length - 1] = strs[strs.length - 1].substring(0, strs[strs.length - 1].length() - 1);  // Remove the ending quote from the last string
      }

      for (String str : strs) {
          if (str.isEmpty()) {
              System.out.println("{\"error\": \"Invalid input\"}");
              return;
          }
      }

      String result = longestCommonPrefix(strs);
      System.out.println("{\"longest_common_prefix\": \"" + result + "\"}");
  }
}

import java.util.HashSet;
import java.util.Scanner;

public class User1 {

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide a single JSON string argument.");
            return;
        }

        String input = args[0];
        String s = extractValue(input, "s");

        if (s == null) {
            System.out.println("Invalid JSON input.");
            return;
        }

        int result = lengthOfLongestSubstring(s);
        System.out.println("{\"result\": " + result + "}");
    }

    private static String extractValue(String jsonString, String key) {
        String pattern = "\"" + key + "\":\"";
        int start = jsonString.indexOf(pattern);
        if (start == -1) return null;

        start += pattern.length();
        int end = jsonString.indexOf("\"", start);
        if (end == -1) return null;

        return jsonString.substring(start, end);
    }
}

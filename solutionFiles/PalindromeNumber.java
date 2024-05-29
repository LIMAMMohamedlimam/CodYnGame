import java.io.*;
import java.util.*;

public class PalindromeChecker {

    public static boolean isPalindrome(int x) {
        String strX = Integer.toString(x);
        int len = strX.length();
        for (int i = 0; i < len / 2; i++) {
            if (strX.charAt(i) != strX.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("{\"error\": \"Invalid input\"}");
            return;
        }

        try {
            String input = args[0];
            if (!input.startsWith("{\"x\":") || !input.endsWith("}")) {
                System.out.println("{\"error\": \"Invalid JSON format\"}");
                return;
            }

            String[] parts = input.substring(1, input.length() - 1).split(":");
            if (parts.length != 2 || !parts[0].trim().equals("\"x\"")) {
                System.out.println("{\"error\": \"Invalid JSON format\"}");
                return;
            }

            int x = Integer.parseInt(parts[1].trim());

            boolean result = isPalindrome(x);
            System.out.println("{\"result\": " + result + "}");

        } catch (NumberFormatException e) {
            System.out.println("{\"error\": \"Value is not an integer\"}");
        }
    }
}

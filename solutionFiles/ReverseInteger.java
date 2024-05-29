public class ReverseInteger {
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

    public static int reverseInteger(int x) {
        // Check for the sign of the number
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        // Reverse the digits of the number
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // Check for overflow
            if (reversed > (Integer.MAX_VALUE - pop) / 10) {
                return 0;
            }
            reversed = reversed * 10 + pop;
        }

        // Restore the sign
        reversed *= sign;

        return reversed;
    }
}

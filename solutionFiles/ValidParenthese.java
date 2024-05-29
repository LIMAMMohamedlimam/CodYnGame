import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            String inputJson = args[0];
            String s = parseInputJson(inputJson);

            boolean result = isValidParentheses(s);

            String outputJson = createOutputJson(result);
            System.out.println(outputJson);
        }
    }

    public static String parseInputJson(String inputJson) {
        // Simple parsing assuming the input is in the format {"s": "value"}
        int start = inputJson.indexOf(":") + 2;
        int end = inputJson.lastIndexOf("\"");
        return inputJson.substring(start, end);
    }

    public static String createOutputJson(boolean result) {
        return "{\"result\":" + result + "}";
    }

    public static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == mapping.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}

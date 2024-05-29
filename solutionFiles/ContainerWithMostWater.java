import java.util.*;
import java.util.regex.*;

public class User1 {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int currentArea = width * h;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java User1 '<json_string>'");
            System.exit(1);
        }

        String inputJson = args[0];
        try {
            // Extract the heights array from the JSON string
            Pattern pattern = Pattern.compile("\"height\":\\[(.*?)\\]");
            Matcher matcher = pattern.matcher(inputJson);
            if (!matcher.find()) {
                System.out.println("Invalid JSON input");
                System.exit(1);
            }

            String heightStr = matcher.group(1);
            String[] heightStrArray = heightStr.split(",");
            int[] height = new int[heightStrArray.length];
            for (int i = 0; i < heightStrArray.length; i++) {
                height[i] = Integer.parseInt(heightStrArray[i].trim());
            }

            // Compute the maximum area
            int result = maxArea(height);

            // Create the result JSON string
            String outputJson = String.format("{\"result\": %d}", result);
            System.out.println(outputJson);

        } catch (Exception e) {
            System.out.println("Invalid JSON input");
            System.exit(1);
        }
    }
}

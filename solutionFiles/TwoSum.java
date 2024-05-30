import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static String twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                int[] result = { numMap.get(complement), i };
                return "[" + result[0] + ", " + result[1] + "]";
            }
            numMap.put(nums[i], i);
        }

        return "[]"; // In case no solution is found (though the problem guarantees a solution)
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TwoSum '{\"nums\":[...], \"target\":...}'");
            System.exit(1);
        }

        try {
            String inputJson = args[0];
            inputJson = inputJson.replaceAll("[\\[\\]{}\"]", "");  // Remove brackets, braces, and quotes
            String[] parts = inputJson.split(",");  // Split by commas

            int target = 0;
            int[] nums = new int[parts.length - 1];
            int numsIndex = 0;

            for (String part : parts) {
                if (part.contains("target:")) {
                    target = Integer.parseInt(part.split(":")[1].trim());
                } else if (part.contains("nums:")) {
                    nums[numsIndex++] = Integer.parseInt(part.split(":")[1].trim());
                } else {
                    nums[numsIndex++] = Integer.parseInt(part.trim());
                }
            }

            System.out.println(twoSum(nums, target));
        } catch (Exception e) {
            System.out.println("Invalid input format. Please provide a JSON string with 'nums' and 'target'.");
        }
    }
}

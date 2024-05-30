import java.util.*;

public class MergeSortedLists {

    public static List<Integer> mergeTwoSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        // Traverse both lists and append the smaller element to the merged list
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Append remaining elements, if any
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Error: Incorrect arguments or number of arguments.");
            return;
        }

        // Assuming the input is passed as the first command line argument
        String inputJson = args[0];

        // Parse the JSON input
        Map<String, List<Integer>> data = parseJson(inputJson);
        List<Integer> list1 = data.get("list1");
        List<Integer> list2 = data.get("list2");

        // Merge the two sorted lists
        List<Integer> mergedList = mergeTwoSortedLists(list1, list2);

        // Prepare the result in the desired format
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("result", mergedList);

        // Print the result as a JSON string
        String outputJson = toJson(result);
        System.out.println(outputJson);
    }

    // Simple JSON parser
    public static Map<String, List<Integer>> parseJson(String json) {
        Map<String, List<Integer>> data = new HashMap<>();
        json = json.trim().substring(1, json.length() - 1); // Remove the surrounding braces
        json = json.replaceAll("\\[", "").replaceAll("]", ""); // Remove square brackets
        String[] pairs = json.split(",");

        String currentKey = null;
        List<Integer> currentList = new ArrayList<>();

        for (String pair : pairs) {
            String[] keyValue = pair.split(":");

            if (keyValue.length == 2) {
                if (currentKey != null) {
                    data.put(currentKey, currentList);
                }
                currentKey = keyValue[0].trim().replaceAll("\"", "");
                currentList = new ArrayList<>();
                currentList.add(Integer.parseInt(keyValue[1].trim()));
            } else {
                currentList.add(Integer.parseInt(keyValue[0].trim()));
            }
        }

        if (currentKey != null) {
            data.put(currentKey, currentList);
        }

        return data;
    }

    // Simple JSON serializer
    public static String toJson(Map<String, List<Integer>> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            json.append("\"").append(entry.getKey()).append("\":");
            json.append(entry.getValue().toString());
            json.append(",");
        }
        json.deleteCharAt(json.length() - 1); // Remove the trailing comma
        json.append("}");
        return json.toString();
    }
}

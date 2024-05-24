
package GetSolutionFiles;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final Map<String, String> generatedData = new HashMap<>();

    public static void saveGeneratedData(String exerciseTitle, String generatedValue) {
        generatedData.put(exerciseTitle, generatedValue);
    }

    public static String getGeneratedData(String exerciseTitle) {
        return generatedData.get(exerciseTitle);
    }
}

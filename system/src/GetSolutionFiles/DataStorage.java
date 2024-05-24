
package GetSolutionFiles;

import java.util.HashMap;
import java.util.Map;

public class DataStorage {
    private static final Map<String, String> solutionMap = new HashMap<>();

    public static void saveGeneratedData(String exerciseTitle, String generatedData) {
        solutionMap.put(exerciseTitle, generatedData);
    }

    public static String getGeneratedData(String exerciseTitle) {
        return solutionMap.get(exerciseTitle);
    }
}

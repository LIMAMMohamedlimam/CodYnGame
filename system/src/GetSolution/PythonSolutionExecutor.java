package GetSolution;




import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PythonSolutionExecutor {

    /**
     * Génère un fichier Python pour exécuter la solution avec les données générées.
     *
     * @param title        Le titre de l'exercice.
     * @param generatedData Les données générées sous forme de chaîne JSON.
     */
    public static void createPythonSolutionExecutionFile(String title, String generatedData) {
        try {
            // Convertir les données JSON en Map
            Map<String, Object> dataMap = parseJSON(generatedData);
            String nums = stringifyArray((int[]) dataMap.get("nums"));
            String target = dataMap.get("target").toString();

            // Créer le contenu du fichier Python
            String solutionCode = """
                    from solutionFiles.{} import {}
                    
                    # Données générées
                    nums = {}
                    target = {}
                    
                    # Exécution de la solution
                    result = {}(nums, target)
                    print(result)  # Affichage du résultat
                    """.formatted(title.replace(" ", ""), title.replace(" ", ""), nums, target, title.replace(" ", ""));

            // Chemin du fichier généré
            String solutionFilePath = "GeneratedSolutions/Execute" + title.replace(" ", "") + "Solution.py";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(solutionFilePath))) {
                writer.write(solutionCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Object> parseJSON(String json) throws IOException {
        // Implémentez ici votre propre analyseur JSON ou utilisez une bibliothèque externe si nécessaire
        // Pour cet exemple, nous supposons que vos données générées sont déjà dans un format de carte clé-valeur
        throw new UnsupportedOperationException("Méthode non implémentée");
    }

    private static String stringifyArray(int[] array) {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < array.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        String title = "Two Sum";
        String generatedData = "{\"nums\": [846, -266, -602, -338, 320], \"target\": 1114}";  // Exemple de données générées
        createPythonSolutionExecutionFile(title, generatedData);
    }
}



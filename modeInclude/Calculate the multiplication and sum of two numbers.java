import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Calculatethemultiplicationandsumoftwonumbers {

    public static Map<String, Integer> generateNumbers() {
        Random rand = new Random();
        int number1 = rand.nextInt(100) + 1;
        int number2 = rand.nextInt(100) + 1;
        Map<String, Integer> numbers = new HashMap<>();
        numbers.put("number1", number1);
        numbers.put("number2", number2);
        return numbers;
    }

    public static boolean verifySolution(Map<String, Integer> data) {
        try {
            int number1 = data.get("number1");
            int number2 = data.get("number2");
            int correctProduct = number1 * number2;
            int correctSum = number1 + number2;
            return data.get("product") == correctProduct && data.get("sum") == correctSum;
        } catch (Exception e) {
            return false;
        }
    }

    public static void result(String[] args) {
        Map<String, Integer> numbers = generateNumbers();
        System.out.println("Number1: " + numbers.get("number1") + ", Number2: " + numbers.get("number2"));

        Map<String, Integer> data = new HashMap<>();
        data.put("number1", numbers.get("number1"));
        data.put("number2", numbers.get("number2"));
        data.put("product", numbers.get("number1") * numbers.get("number2"));
        data.put("sum", numbers.get("number1") + numbers.get("number2"));

        if (verifySolution(data)) {
            System.out.println("The solution is correct.");
        } else {
            System.out.println("The solution is incorrect.");
        }
    }
}

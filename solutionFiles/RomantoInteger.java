public class RomanToIntConverter {

    public static int romanToInt(String s) {
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = values[s.charAt(i) - 'A'];
            if (value < prevValue) {
                total -= value;
            } else {
                total += value;
            }
            prevValue = value;
        }

        return total;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RomanToIntConverter '<json_string>'");
            return;
        }

        String inputJson = args[0];
        try {
            String romanNumeral = parseJsonString(inputJson, "roman");
            if (romanNumeral == null || romanNumeral.isEmpty()) {
                System.out.println("{\"error\": \"No roman numeral found\"}");
                return;
            }

            int integerValue = romanToInt(romanNumeral);
            String result = "{\"result\": " + integerValue + "}";
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("{\"error\": \"Invalid JSON input\"}");
        }
    }

    private static String parseJsonString(String json, String key) {
        String keyPattern = "\"" + key + "\":";
        int keyIndex = json.indexOf(keyPattern);
        if (keyIndex == -1) {
            return null;
        }

        int startIndex = json.indexOf("\"", keyIndex + keyPattern.length()) + 1;
        int endIndex = json.indexOf("\"", startIndex);
        if (startIndex == -1 || endIndex == -1) {
            return null;
        }

        return json.substring(startIndex, endIndex);
    }
}

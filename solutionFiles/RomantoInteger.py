import json
import sys

def roman_to_int(s: str) -> int:
    roman_to_value = {
        'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000
    }
    total = 0
    prev_value = 0

    for char in reversed(s):
        value = roman_to_value[char]
        if value < prev_value:
            total -= value
        else:
            total += value
        prev_value = value

    return total

def main():
    if len(sys.argv) != 2:
        print("Usage: python script.py '<json_string>'")
        return

    input_json = sys.argv[1]
    try:
        data = json.loads(input_json)
        roman_numeral = data.get("roman")
        if not roman_numeral:
            print(json.dumps({"error": "No roman numeral found"}))
            return

        integer_value = roman_to_int(roman_numeral)
        result = json.dumps({"result": integer_value})
        print(result)
    except json.JSONDecodeError:
        print(json.dumps({"error": "Invalid JSON input"}))

if __name__ == "__main__":
    main()

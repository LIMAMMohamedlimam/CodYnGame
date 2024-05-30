import json
import sys

def roman_to_int(s: str) -> int:
    #Write your code here

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

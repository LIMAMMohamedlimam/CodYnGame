import json
import sys

def is_palindrome(x):
    #write your code here

def main():
    # Read input from program argument
    if len(sys.argv) != 2:
        print(json.dumps({"error": "Invalid input"}))
        return

    try:
        input_json = sys.argv[1]
        data = json.loads(input_json)
        x = data["x"]

        if not isinstance(x, int):
            print(json.dumps({"error": "Value is not an integer"}))
            return

        result = is_palindrome(x)
        print(json.dumps({"result": result}))
    except (json.JSONDecodeError, KeyError):
        print(json.dumps({"error": "Invalid JSON or missing key 'x'"}))

if __name__ == "__main__":
    main()

import sys
import json

def length_of_longest_substring(s: str) -> int:
   #write your code here

    return max_length

def main():
    if len(sys.argv) != 2:
        print("Please provide a single JSON string argument.")
        return

    input_json = sys.argv[1]
    try:
        input_data = json.loads(input_json)
        s = input_data.get("s", "")
    except json.JSONDecodeError:
        print("Invalid JSON input.")
        return

    result = length_of_longest_substring(s)
    output = {"result": result}
    print(json.dumps(output))

if __name__ == "__main__":
    main()

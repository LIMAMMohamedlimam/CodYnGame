import json
import sys

def longest_common_prefix(strs):
    #Write your code here

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print(json.dumps({"error": "No input provided"}))
        sys.exit(1)

    input_str = sys.argv[1]
    try:
        strs = json.loads(input_str)
        if not isinstance(strs, list) or not all(isinstance(s, str) for s in strs):
            raise ValueError
    except ValueError:
        print(json.dumps({"error": "Invalid input"}))
        sys.exit(1)

    result = longest_common_prefix(strs)
    print(json.dumps({"result": result}))

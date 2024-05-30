import json
import sys

def max_area(height):
   #write your code here

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: python script.py '<json_string>'")
        sys.exit(1)

    # Parse the JSON input
    input_json = sys.argv[1]
    try:
        data = json.loads(input_json)
        height = data["height"]
    except (json.JSONDecodeError, KeyError):
        print("Invalid JSON input")
        sys.exit(1)

    # Compute the maximum area
    result = max_area(height)

    # Convert result to JSON string with the specified format
    output_json = json.dumps({"result": result})

    # Print the JSON string
    print(output_json)

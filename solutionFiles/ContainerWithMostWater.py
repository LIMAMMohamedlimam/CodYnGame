import json
import sys

def max_area(height):
    left, right = 0, len(height) - 1
    max_area = 0

    while left < right:
        width = right - left
        h = min(height[left], height[right])
        current_area = width * h
        max_area = max(max_area, current_area)

        if height[left] < height[right]:
            left += 1
        else:
            right -= 1

    return max_area

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

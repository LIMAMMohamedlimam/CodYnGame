import sys
import json

def length_of_longest_substring(s: str) -> int:
    char_set = set()
    left = 0
    max_length = 0

    for right in range(len(s)):
        while s[right] in char_set:
            char_set.remove(s[left])
            left += 1
        char_set.add(s[right])
        max_length = max(max_length, right - left + 1)

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

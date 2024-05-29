import json
import sys

def is_valid_parentheses(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in mapping.values():
            stack.append(char)
        elif char in mapping:
            if stack and stack[-1] == mapping[char]:
                stack.pop()
            else:
                return False
        else:
            return False

    return not stack

def main():
    # Read the JSON string from program argument
    input_json = sys.argv[1]
    input_data = json.loads(input_json)

    s = input_data['s']
    result = is_valid_parentheses(s)

    # Output the result as JSON string
    output_json = json.dumps({"result": result})
    print(output_json)

if __name__ == "__main__":
    main()





